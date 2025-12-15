from __future__ import annotations

import asyncio
import binascii
import logging
import struct
from dataclasses import dataclass
from typing import Any, Optional

from bleak import BleakClient
from bleak.backends.device import BLEDevice

from .const import NUS_RX_UUID, NUS_TX_UUID

_LOGGER = logging.getLogger(__name__)


@dataclass
class DiamondLinqData:
    """Decoded data from tt/uu/vv frames."""
    flow_gpm: Optional[float] = None
    soft_remaining_gal: Optional[int] = None
    avg_daily_use_gal: Optional[float] = None
    treated_today_gal: Optional[float] = None
    regen_hour: Optional[int] = None
    salt_config_f7: Optional[int] = None
    salt_config_f8: Optional[int] = None

    # Internal state for polling
    _last_tt: Optional[list[int]] = None
    _last_uu_usage: Optional[list[int]] = None
    _last_uu_cfg: Optional[list[int]] = None
    _lock: Optional[asyncio.Lock] = None

    def __post_init__(self):
        self._lock = asyncio.Lock()

    def update(self, service_info):
        """Update from BLE advertisement data (if any)."""
        # For now, we don't parse advertisements - all data comes from polling
        return self

    async def async_poll(self, device: BLEDevice) -> DiamondLinqData:
        """Poll the device by connecting and subscribing to NUS TX."""

        client = BleakClient(device)
        try:
            await client.connect()

            # Reset last-seen frames for this poll
            async with self._lock:
                self._last_tt = None
                self._last_uu_usage = None
                self._last_uu_cfg = None

            # Subscribe to NUS TX notifications
            await client.start_notify(NUS_TX_UUID, self._notification_callback)

            # Send handshake frames on RX to start streams
            for payload in [b"t" * 20, b"u" * 20, b"v" * 20]:
                await client.write_gatt_char(NUS_RX_UUID, payload, response=False)

            # Wait for notifications
            await asyncio.sleep(5)  # Adjust based on device response time

            # Snapshot the decoded data
            async with self._lock:
                # Apply any pending tt/uu frames to our data
                if self._last_tt:
                    _, _, _, _, _, f6, _, _ = self._last_tt
                    self.flow_gpm = f6 / 100.0

                if self._last_uu_usage:
                    _, _, _, _, f5, f6, f7, f8, _, _ = self._last_uu_usage
                    self.soft_remaining_gal = f5
                    self.avg_daily_use_gal = f6 / 256.0
                    self.treated_today_gal = f7 / 256.0
                    self.regen_hour = f8

                if self._last_uu_cfg:
                    *_, cfg_f7, cfg_f8 = self._last_uu_cfg
                    self.salt_config_f7 = cfg_f7
                    self.salt_config_f8 = cfg_f8

        finally:
            try:
                await client.stop_notify(NUS_TX_UUID)
                await client.disconnect()
            except Exception:
                pass

        return self

    def _notification_callback(self, handle: int, data: bytes) -> None:
        """Handle incoming NUS TX notifications."""
        if not data:
            return

        try:
            if data.startswith(b"tt"):
                vals = self._decode_tt(data)
                if vals is not None:
                    asyncio.create_task(self._apply_tt(vals))
            elif data.startswith(b"uu"):
                fields = self._decode_uu(data)
                if fields is not None:
                    subtype = fields[0]
                    asyncio.create_task(self._apply_uu(subtype, fields))
        except Exception as exc:
            _LOGGER.warning("Error decoding notification: %s", exc)

    @staticmethod
    def _decode_tt(payload: bytes) -> Optional[list[int]]:
        if len(payload) < 2 + 16 or payload[0:2] != b"tt":
            return None
        return [struct.unpack("<H", payload[2 + 2 * i:4 + 2 * i])[0] for i in range(8)]

    @staticmethod
    def _decode_uu(payload: bytes) -> Optional[list[int]]:
        if len(payload) < 20 or payload[0:2] != b"uu":
            return None
        fields = []
        for i in range(10):
            off = 2 + 2 * i
            fields.append(struct.unpack("<H", payload[off:off + 2])[0])
        return fields

    async def _apply_tt(self, vals: list[int]) -> None:
        async with self._lock:
            self._last_tt = vals

    async def _apply_uu(self, subtype: int, fields: list[int]) -> None:
        async with self._lock:
            if subtype == 0x0003:
                self._last_uu_usage = fields
            elif subtype == 0x0001:
                self._last_uu_cfg = fields