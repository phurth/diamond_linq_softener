"""BLE client for Diamond Linq Water Softener.

Handles BLE connection, notification subscription, and command sending
using Home Assistant's bluetooth integration and bleak-retry-connector.
"""
from __future__ import annotations

import asyncio
import hashlib
import logging
import time
from typing import Any, Callable, Optional

from bleak import BleakClient, BleakError
from bleak.backends.device import BLEDevice
from bleak.backends.characteristic import BleakGATTCharacteristic
from bleak_retry_connector import establish_connection, BleakNotFoundError

from homeassistant.components.bluetooth import (
    async_ble_device_from_address,
    async_scanner_count,
    async_discovered_service_info,
)
from homeassistant.core import HomeAssistant

from .const import NUS_SERVICE_UUID, NUS_RX_UUID, NUS_TX_UUID
from .parser import DiamondLinqData, FrameParser

_LOGGER = logging.getLogger(__name__)

# Connection timeouts
CONNECT_TIMEOUT = 30.0
DISCONNECT_TIMEOUT = 5.0
POLL_DURATION = 10.0  # How long to listen for notifications during a poll
REQUEST_INTERVAL = 2.0  # How often to send request frames during poll

# Command payloads
CMD_DISPLAY_ON = bytes([0x76] * 13 + [0x47, 0x00] + [0x76] * 5)
CMD_DISPLAY_OFF = bytes([0x76] * 13 + [0x47, 0x01] + [0x76] * 5)

# Keepalive / request frames - sent to trigger data from device
# These are the tt/uu/vv frame headers that the app sends periodically
CMD_REQUEST_TT = bytes([0x74] * 20)  # tt frame - request telemetry
CMD_REQUEST_UU = bytes([0x75] * 20)  # uu frame - request usage stats  
CMD_REQUEST_VV = bytes([0x76] * 20)  # vv frame - request config


def build_pa_frame() -> bytes:
    """Build the PA (authentication) frame.
    
    Format (based on BLE trace analysis):
    - Bytes 0-1: 0x74 0x74 ('tt' header)
    - Bytes 2-3: 0x50 0x41 ('PA' command)
    - Bytes 4-19: 16 random bytes (token)
    
    Example from trace:
    74 74 50 41 35 c4 35 6b bc f5 1a 4d e1 8f a5 eb a6 60 95 f7
    
    Returns:
        20-byte PA frame
    """
    import secrets
    
    # Start with tt header
    frame = bytearray([0x74, 0x74])
    
    # Add PA command
    frame.extend([0x50, 0x41])  # 'P' 'A'
    
    # Add 16 random bytes
    frame.extend(secrets.token_bytes(16))
    
    _LOGGER.debug("Built PA frame: %s", bytes(frame).hex())
    return bytes(frame)


def build_pw_frame(password: str = "1234") -> bytes:
    """Build the PW (Password Write) frame from Android app G.java.
    
    Format (from G.java lines 200-213):
    - Bytes 0-11: Fill with frame type (0x74 for tt)
    - Bytes 12-13: 'PW' (0x50 0x57)
    - Bytes 14-17: Password digits as BCD (0-9 values, NOT ASCII)
    - Bytes 18-19: Fill with frame type (0x74)
    
    Example for password "1234":
    74 74 74 74 74 74 74 74 74 74 74 74 50 57 01 02 03 04 74 74
    
    Args:
        password: 4-digit numeric password string
        
    Returns:
        20-byte PW frame
    """
    frame = bytearray([0x74] * 20)  # Fill with 0x74
    
    # Set PW command at positions 12-13
    frame[12] = 0x50  # 'P'
    frame[13] = 0x57  # 'W'
    
    # Convert password to BCD digits at positions 14-17
    # Password "1234" becomes bytes [1, 2, 3, 4] (not ASCII!)
    pwd_int = int(password)
    frame[14] = (pwd_int // 1000) % 10      # Thousands digit
    frame[15] = (pwd_int // 100) % 10       # Hundreds digit  
    frame[16] = (pwd_int // 10) % 10        # Tens digit
    frame[17] = pwd_int % 10                # Units digit
    
    _LOGGER.debug("Built PW frame: %s", bytes(frame).hex())
    return bytes(frame)


class SoftenerBleClient:
    """BLE client for the Diamond Linq water softener."""

    def __init__(
        self,
        hass: HomeAssistant,
        address: str,
        auth_token: str = "",
        password: str = "1234",
    ) -> None:
        """Initialize the BLE client.
        
        Args:
            hass: Home Assistant instance
            address: BLE MAC address of the softener
            auth_token: 32-char hex string for PA authentication (optional)
            password: Device password for PA auth (default "1234")
        """
        self._hass = hass
        self._address = address
        self._auth_token = auth_token
        self._password = password
        self._client: Optional[BleakClient] = None
        self._parser = FrameParser()
        self._connected = False
        self._authenticated = False
        self._auth_confirmed = False  # True when device sets bit 15 in tt response
        self._lock = asyncio.Lock()
        self._notification_event = asyncio.Event()

    @property
    def address(self) -> str:
        """Return the device address."""
        return self._address

    @property
    def is_connected(self) -> bool:
        """Return True if connected to the device."""
        return self._connected and self._client is not None and self._client.is_connected

    def _notification_handler(
        self, characteristic: BleakGATTCharacteristic, data: bytearray
    ) -> None:
        """Handle incoming BLE notifications.
        
        This is called by Bleak when the device sends data on the TX characteristic.
        """
        # Identify frame type from first two bytes
        frame_type = "unknown"
        auth_flag = ""
        status_word = 0
        if len(data) >= 2:
            if data[0] == 0x74 and data[1] == 0x74:
                frame_type = "tt"
                # Check for auth flag in tt frames (bit 15 of bytes 6-7, F3 status field)
                if len(data) >= 8:
                    status_word = data[6] | (data[7] << 8)
                    _LOGGER.info(
                        "tt frame F3 status: 0x%04x (byte6=0x%02x, byte7=0x%02x, bit15=%s)",
                        status_word, data[6], data[7], bool(status_word & 0x8000)
                    )
                    if status_word & 0x8000:
                        auth_flag = " [AUTH_OK]"
                        if not self._auth_confirmed:
                            self._auth_confirmed = True
                            _LOGGER.info("Device confirmed authentication (bit 15 set in F3)")
                    else:
                        auth_flag = " [NO_AUTH]"
            elif data[0] == 0x75 and data[1] == 0x75:
                frame_type = "uu"
            elif data[0] == 0x76 and data[1] == 0x76:
                frame_type = "vv"
        
        _LOGGER.info(
            "BLE RX %s%s: %s (%d bytes)",
            frame_type,
            auth_flag,
            data.hex(),
            len(data)
        )
        
        # Parse the frame
        try:
            self._parser.parse_frame(bytes(data))
            self._notification_event.set()
        except Exception as e:
            _LOGGER.warning("Error parsing %s frame: %s", frame_type, e)

    def _find_device(self) -> tuple[Optional[BLEDevice], Optional[str]]:
        """Find the BLE device from HA's discovered devices.
        
        Searches across all bluetooth adapters/proxies.
        Returns (device, source) where source indicates where device was found.
        """
        # First try the simple lookup
        ble_device = async_ble_device_from_address(
            self._hass, self._address, connectable=True
        )
        if ble_device is not None:
            _LOGGER.debug("Found device via async_ble_device_from_address: %s", ble_device)
            return ble_device, "direct_lookup"
        
        # Search through all discovered service info (works with proxies)
        target_address = self._address.upper()
        for service_info in async_discovered_service_info(self._hass, connectable=True):
            if service_info.address.upper() == target_address:
                _LOGGER.debug(
                    "Found device via service_info scan: %s from %s",
                    service_info.device,
                    service_info.source
                )
                return service_info.device, service_info.source
        
        # Log diagnostic info
        scanner_count = async_scanner_count(self._hass, connectable=True)
        _LOGGER.warning(
            "Device %s not found. Active connectable scanners: %d",
            self._address,
            scanner_count
        )
        
        return None, None

    async def async_connect(self) -> bool:
        """Connect to the softener.
        
        Returns True if connection was successful.
        """
        async with self._lock:
            if self.is_connected:
                _LOGGER.debug("Already connected to %s", self._address)
                return True

            _LOGGER.info("Connecting to softener at %s", self._address)

            try:
                # Get the BLE device from Home Assistant's bluetooth integration
                ble_device, source = self._find_device()

                if ble_device is None:
                    _LOGGER.error(
                        "Could not find BLE device %s - ensure it is advertising and a "
                        "bluetooth adapter/proxy can reach it",
                        self._address
                    )
                    return False
                
                _LOGGER.info("Found BLE device: %s (source: %s)", ble_device, source)

                def _disconnected_callback(client: BleakClient) -> None:
                    """Handle disconnection."""
                    _LOGGER.info("Disconnected from %s", self._address)
                    self._connected = False
                    self._authenticated = False  # Reset auth state on disconnect
                    self._auth_confirmed = False  # Reset device auth confirmation

                # Use bleak-retry-connector for reliable connection with HA's multi-adapter support
                self._client = await establish_connection(
                    BleakClient,
                    ble_device,
                    self._address,
                    disconnected_callback=_disconnected_callback,
                    max_attempts=3,
                )
                self._connected = True

                _LOGGER.info("Connected to %s", self._address)

                # Log MTU size
                try:
                    mtu = self._client.mtu_size
                    _LOGGER.info("MTU size: %d bytes", mtu)
                except Exception as e:
                    _LOGGER.debug("Could not get MTU size: %s", e)

                # Subscribe to notifications on the TX characteristic
                await self._client.start_notify(
                    NUS_TX_UUID, self._notification_handler
                )
                _LOGGER.info("Subscribed to TX notifications")
                
                # Minimal delay - just enough for BLE stack to settle
                # Note: The trace shows auth happens very quickly after connect
                await asyncio.sleep(0.1)

                return True

            except BleakNotFoundError:
                _LOGGER.error("BLE device %s not found or not connectable", self._address)
                self._connected = False
                self._client = None
                return False
            except BleakError as e:
                _LOGGER.error("BLE connection error: %s", e)
                self._connected = False
                self._client = None
                return False
            except Exception as e:
                _LOGGER.error("Unexpected error connecting: %s", e)
                self._connected = False
                self._client = None
                return False

    async def async_disconnect(self) -> None:
        """Disconnect from the softener."""
        async with self._lock:
            if self._client is None:
                return

            try:
                if self._client.is_connected:
                    # Stop notifications first
                    try:
                        await self._client.stop_notify(NUS_TX_UUID)
                    except Exception:
                        pass

                    # Disconnect
                    await asyncio.wait_for(
                        self._client.disconnect(),
                        timeout=DISCONNECT_TIMEOUT
                    )
                    _LOGGER.info("Disconnected from %s", self._address)
            except asyncio.TimeoutError:
                _LOGGER.warning("Disconnect timeout for %s", self._address)
            except Exception as e:
                _LOGGER.warning("Error disconnecting: %s", e)
            finally:
                self._connected = False
                self._authenticated = False  # Reset auth state on disconnect
                self._auth_confirmed = False  # Reset device auth confirmation
                self._client = None

    async def _send_auth_frame(self) -> bool:
        """Send the PA (authentication) frame.
        
        Sends ttPA + random 16-byte token. Uses write without response.
        Returns True if auth was sent successfully, False on error.
        """
        pa_frame = build_pa_frame()
        
        try:
            _LOGGER.debug("Sending PA authentication frame: %s", pa_frame.hex())
            # Write without response, matching tt/uu/vv request behavior
            await self._client.write_gatt_char(NUS_RX_UUID, pa_frame, response=False)
            self._authenticated = True
            _LOGGER.info("PA authentication sent successfully")
            return True
        except Exception as e:
            _LOGGER.warning("Error sending PA authentication: %s", e)
            return False

    async def _wait_for_notification(self, timeout: float = 0.5) -> bool:
        """Wait for a notification from the device.
        
        Returns True if a notification was received, False on timeout.
        """
        try:
            await asyncio.wait_for(
                self._notification_event.wait(),
                timeout=timeout
            )
            self._notification_event.clear()
            return True
        except asyncio.TimeoutError:
            return False

    async def _send_initial_auth_sequence(self) -> bool:
        """Send the initial authentication sequence.
        
        Tries multiple approaches based on trace analysis:
        
        Approach 1 (trace sequence): tt → wait → PA
        Approach 2: PA immediately (no tt first)
        Approach 3: Known-good PA token from trace
        
        Returns True if sequence completed successfully.
        """
        try:
            _LOGGER.info("Starting initial auth sequence...")
            
            # Reset auth confirmed flag
            self._auth_confirmed = False
            
            # Get the RX characteristic directly for more control
            rx_char = None
            for service in self._client.services:
                for char in service.characteristics:
                    if char.uuid.lower() == NUS_RX_UUID.lower():
                        rx_char = char
                        _LOGGER.info("Found RX characteristic: handle=%s, props=%s", 
                                   char.handle, char.properties)
                        break
                if rx_char:
                    break
            
            if rx_char is None:
                _LOGGER.warning("RX characteristic not found! Using UUID string")
                write_target = NUS_RX_UUID
            else:
                write_target = rx_char
            
            # ============================================================
            # APPROACH 1: Send PA immediately after connection (no tt first)
            # Some devices expect auth before any data request
            # ============================================================
            _LOGGER.info("=== APPROACH 1: PA immediately (no tt first) ===")
            
            pa_frame = build_pa_frame()
            _LOGGER.info("Sending PA (immediate): %s", pa_frame.hex())
            await self._client.write_gatt_char(write_target, pa_frame, response=False)
            
            # Wait for response
            for _ in range(20):
                if await self._wait_for_notification(timeout=0.05):
                    if self._auth_confirmed:
                        _LOGGER.info("APPROACH 1 SUCCEEDED - PA immediately worked!")
                        return True
            
            # ============================================================
            # APPROACH 2: Standard trace sequence - tt → wait → PA
            # ============================================================
            _LOGGER.info("=== APPROACH 2: tt → wait → PA (trace sequence) ===")
            
            _LOGGER.info("Sending tt request")
            await self._client.write_gatt_char(write_target, CMD_REQUEST_TT, response=False)
            
            if not await self._wait_for_notification(timeout=2.0):
                _LOGGER.warning("No response to tt request")
            else:
                _LOGGER.info("Got tt response")
            
            # Small delay matching trace (~50ms)
            await asyncio.sleep(0.05)
            
            pa_frame = build_pa_frame()
            _LOGGER.info("Sending PA (post-tt): %s", pa_frame.hex())
            await self._client.write_gatt_char(write_target, pa_frame, response=False)
            
            for _ in range(20):
                if await self._wait_for_notification(timeout=0.05):
                    if self._auth_confirmed:
                        _LOGGER.info("APPROACH 2 SUCCEEDED - tt→PA sequence worked!")
                        return True
            
            # ============================================================
            # APPROACH 3: Use exact PA token from working trace
            # Token: 35 c4 35 6b bc f5 1a 4d e1 8f a5 eb a6 60 95 f7
            # ============================================================
            _LOGGER.info("=== APPROACH 3: Known-good PA token from trace ===")
            
            # Exact token from trace BT_HCI_2025_1231_104820
            known_token = bytes.fromhex("35c4356bbcf51a4de18fa5eba66095f7")
            pa_frame_known = bytes([0x74, 0x74, 0x50, 0x41]) + known_token
            
            _LOGGER.info("Sending PA (known token): %s", pa_frame_known.hex())
            await self._client.write_gatt_char(write_target, pa_frame_known, response=False)
            
            for _ in range(20):
                if await self._wait_for_notification(timeout=0.05):
                    if self._auth_confirmed:
                        _LOGGER.info("APPROACH 3 SUCCEEDED - known token worked!")
                        return True
            
            # ============================================================
            # APPROACH 4: Try PA with write-with-response
            # ============================================================
            _LOGGER.info("=== APPROACH 4: PA with write-with-response ===")
            
            pa_frame = build_pa_frame()
            _LOGGER.info("Sending PA (with-response): %s", pa_frame.hex())
            try:
                await self._client.write_gatt_char(write_target, pa_frame, response=True)
            except Exception as e:
                _LOGGER.warning("Write-with-response failed: %s", e)
            
            for _ in range(20):
                if await self._wait_for_notification(timeout=0.05):
                    if self._auth_confirmed:
                        _LOGGER.info("APPROACH 4 SUCCEEDED - write-with-response worked!")
                        return True
            
            # ============================================================
            # APPROACH 5: Zero-delay rapid PA after tt
            # ============================================================
            _LOGGER.info("=== APPROACH 5: Rapid PA (no delay after tt) ===")
            
            await self._client.write_gatt_char(write_target, CMD_REQUEST_TT, response=False)
            # No wait - send PA immediately
            pa_frame = build_pa_frame()
            _LOGGER.info("Sending PA (rapid): %s", pa_frame.hex())
            await self._client.write_gatt_char(write_target, pa_frame, response=False)
            
            for _ in range(20):
                if await self._wait_for_notification(timeout=0.05):
                    if self._auth_confirmed:
                        _LOGGER.info("APPROACH 5 SUCCEEDED - rapid PA worked!")
                        return True
            
            # ============================================================
            # APPROACH 6: PW (Password Write) format from G.java
            # This is the Android app's password command format
            # ============================================================
            _LOGGER.info("=== APPROACH 6: PW (Password Write) from G.java ===")
            
            pw_frame = build_pw_frame(self._password)
            _LOGGER.info("Sending PW (password=%s): %s", self._password, pw_frame.hex())
            await self._client.write_gatt_char(write_target, pw_frame, response=False)
            
            for _ in range(20):
                if await self._wait_for_notification(timeout=0.05):
                    if self._auth_confirmed:
                        _LOGGER.info("APPROACH 6 SUCCEEDED - PW command worked!")
                        return True
            
            # ============================================================
            # APPROACH 7: PW after tt request (in case it needs context)
            # ============================================================
            _LOGGER.info("=== APPROACH 7: tt → PW sequence ===")
            
            await self._client.write_gatt_char(write_target, CMD_REQUEST_TT, response=False)
            await self._wait_for_notification(timeout=1.0)
            await asyncio.sleep(0.05)
            
            pw_frame = build_pw_frame(self._password)
            _LOGGER.info("Sending PW (post-tt): %s", pw_frame.hex())
            await self._client.write_gatt_char(write_target, pw_frame, response=False)
            
            for _ in range(20):
                if await self._wait_for_notification(timeout=0.05):
                    if self._auth_confirmed:
                        _LOGGER.info("APPROACH 7 SUCCEEDED - tt→PW worked!")
                        return True
            
            _LOGGER.error("ALL APPROACHES FAILED - device did not set auth bit")
            _LOGGER.error("This may indicate BLE proxy incompatibility - try direct Bluetooth connection")
            return False
            
        except Exception as e:
            _LOGGER.error("Error in auth sequence: %s", e)
            import traceback
            _LOGGER.error("Traceback: %s", traceback.format_exc())
            return False

    async def _send_request_frames(self) -> None:
        """Send request frames to trigger data from device.
        
        After authentication, we send tt/uu/vv requests with delays between them.
        """
        try:
            # Send tt request first
            _LOGGER.debug("Sending tt request: %s", CMD_REQUEST_TT.hex())
            await self._client.write_gatt_char(NUS_RX_UUID, CMD_REQUEST_TT, response=False)
            await asyncio.sleep(0.15)
            
            # Log auth status for debugging
            auth_status = "[AUTH_OK]" if self._auth_confirmed else "[NO_AUTH]"
            
            # Send uu request
            _LOGGER.debug("Sending uu request %s: %s", auth_status, CMD_REQUEST_UU.hex())
            await self._client.write_gatt_char(NUS_RX_UUID, CMD_REQUEST_UU, response=False)
            await asyncio.sleep(0.15)
            
            # Send vv request
            _LOGGER.debug("Sending vv request %s: %s", auth_status, CMD_REQUEST_VV.hex())
            await self._client.write_gatt_char(NUS_RX_UUID, CMD_REQUEST_VV, response=False)
        except Exception as e:
            _LOGGER.warning("Error sending request frames: %s", e)

    async def async_poll_once(self) -> DiamondLinqData:
        """Connect, gather data, and return the parsed result.
        
        This method:
        1. Connects to the device (if not already connected)
        2. Runs the initial authentication sequence (if not already authenticated)
        3. Sends request frames repeatedly to trigger data transmission
        4. Waits for notification frames for POLL_DURATION seconds
        5. Returns the accumulated parsed data
        
        The connection is left open for future polls.
        """
        # Ensure we're connected
        if not await self.async_connect():
            _LOGGER.error("Failed to connect for polling")
            return self._parser.get_data()

        # Clear the notification event
        self._notification_event.clear()

        _LOGGER.debug("Starting poll for %.1f seconds...", POLL_DURATION)
        
        # If not authenticated, run the auth sequence first
        if not self._authenticated:
            await self._send_initial_auth_sequence()
        
        start_time = time.time()
        last_request_time = 0.0
        frames_received = 0
        tt_count = 0
        uu_count = 0
        vv_count = 0
        
        while (time.time() - start_time) < POLL_DURATION:
            # Send request frames periodically
            elapsed = time.time() - start_time
            if elapsed - last_request_time >= REQUEST_INTERVAL or last_request_time == 0:
                _LOGGER.debug("Sending request frames (%.1fs elapsed)...", elapsed)
                await self._send_request_frames()
                last_request_time = elapsed
            
            try:
                # Wait for a notification with a short timeout
                await asyncio.wait_for(
                    self._notification_event.wait(),
                    timeout=0.3
                )
                frames_received += 1
                self._notification_event.clear()
                
                # Count frame types based on parsed data
                data = self._parser.data
                if data.flow_gpm is not None:
                    tt_count += 1
                if data.soft_remaining_gal is not None:
                    uu_count += 1
                if data.water_hardness_gpg is not None:
                    vv_count += 1
                    
            except asyncio.TimeoutError:
                # No notification in this interval, continue waiting
                pass

        # Update timestamp
        self._parser.data.last_update = time.time()
        
        _LOGGER.info(
            "Poll complete: %d frames (tt:%d approx), flow=%.2f GPM, remaining=%s gal, hardness=%s gpg",
            frames_received,
            tt_count,
            self._parser.data.flow_gpm or 0,
            self._parser.data.soft_remaining_gal,
            self._parser.data.water_hardness_gpg
        )

        return self._parser.get_data()

    async def async_write_command(self, data: bytes) -> bool:
        """Write a command to the RX characteristic.
        
        Args:
            data: The command bytes to send (should be 20 bytes)
            
        Returns:
            True if the write was successful
        """
        if not self.is_connected:
            if not await self.async_connect():
                _LOGGER.error("Cannot send command: not connected")
                return False

        try:
            _LOGGER.debug("Writing command to RX: %s", data.hex())
            await self._client.write_gatt_char(
                NUS_RX_UUID,
                data,
                response=False  # Write without response for NUS
            )
            _LOGGER.info("Command sent successfully")
            return True
        except BleakError as e:
            _LOGGER.error("Failed to write command: %s", e)
            return False
        except Exception as e:
            _LOGGER.error("Unexpected error writing command: %s", e)
            return False

    async def async_set_display(self, on: bool) -> bool:
        """Turn the softener display on or off.
        
        Args:
            on: True to turn display on, False to turn off
            
        Returns:
            True if command was sent successfully
        """
        cmd = CMD_DISPLAY_ON if on else CMD_DISPLAY_OFF
        _LOGGER.info("Setting display to %s", "ON" if on else "OFF")
        return await self.async_write_command(cmd)

    async def async_set_salt_geometry_raw(self, config_bytes: bytes) -> bool:
        """Send a raw salt/geometry configuration update.
        
        The config_bytes should be the 5-byte encoded config (53 XX YY ZZ WW).
        This will be wrapped in the appropriate uu-style frame.
        
        Args:
            config_bytes: 5-byte configuration payload
            
        Returns:
            True if command was sent successfully
        """
        if len(config_bytes) != 5:
            _LOGGER.error("Salt config must be exactly 5 bytes")
            return False

        # Build the 20-byte command frame:
        # 75 75 75 75 75 75 75 75 75 75 75 75 75 [5 config bytes] 75 75
        cmd = bytes([0x75] * 13) + config_bytes + bytes([0x75, 0x75])
        
        _LOGGER.info("Sending salt/geometry config: %s", config_bytes.hex())
        return await self.async_write_command(cmd)

    def get_data(self) -> DiamondLinqData:
        """Get the current parsed data without polling."""
        return self._parser.get_data()

    def reset_data(self) -> None:
        """Reset all parsed data."""
        self._parser.reset()
