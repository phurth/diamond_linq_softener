from __future__ import annotations

from dataclasses import dataclass, field
from typing import Any, Callable, Dict, Optional

from bleak.backends.device import BLEDevice
from bleak.backends.scanner import AdvertisementData

from homeassistant.components.bluetooth import (
    BluetoothServiceInfoBleak,
    async_ble_device_from_address,
)
from homeassistant.core import HomeAssistant

from .const import NUS_RX_UUID, NUS_TX_UUID


@dataclass
class SoftenerState:
    """Decoded state from tt/uu/vv frames."""

    flow_gpm: Optional[float] = None
    soft_remaining_gal: Optional[int] = None
    avg_daily_use_gal: Optional[float] = None
    treated_today_gal: Optional[float] = None
    regen_hour: Optional[int] = None
    # Raw salt / geometry fields from uu subtype-1
    salt_config_f7: Optional[int] = None
    salt_config_f8: Optional[int] = None


class SoftenerBleClient:
    """Thin wrapper around HA Bluetooth/Bleak client for the softener."""

    def __init__(
        self,
        hass: HomeAssistant,
        address: str,
    ) -> None:
        self._hass = hass
        self._address = address
        self._device: Optional[BLEDevice] = None
        self._client: Optional[Any] = None  # BleakClient-like
        self.state = SoftenerState()

    async def async_connect(self) -> None:
        """Ensure we have a connected BLE client.

        This uses HA's bluetooth integration to find the BLEDevice
        and then obtains a connected client object from the service info.
        """

        if self._client is not None:
            return

        ble_device = await async_ble_device_from_address(self._hass, self._address, connectable=True)
        if ble_device is None:
            raise RuntimeError(f"Softener BLE device {self._address} not found")

        # In a full implementation we would obtain a BleakClient from
        # the Bluetooth integration. For initial scaffolding we leave
        # this as a TODO to be wired up to HA's bluetooth APIs.
        self._device = ble_device
        # self._client = ...

    async def async_disconnect(self) -> None:
        """Disconnect the BLE client if connected."""

        if self._client is None:
            return
        try:
            await self._client.disconnect()
        finally:
            self._client = None

    async def async_poll_once(self) -> SoftenerState:
        """Placeholder for a single poll/refresh cycle.

        In a full implementation this would:
        - connect if needed
        - subscribe to NUS_TX_UUID notifications
        - send tt/uu/vv keepalives on NUS_RX_UUID
        - wait briefly for frames
        - decode latest tt/uu frames into self.state
        """

        # TODO: implement BLE interaction using HA bluetooth helpers.
        return self.state

    async def async_set_display(self, on: bool) -> None:
        """Toggle the softener front-panel display.

        Uses the vv-style write frame with 0x47 00/01 in the middle.
        This is a placeholder until the client wiring is finished.
        """

        # TODO: construct and send vv-style 20-byte payload over NUS_RX_UUID.
        _ = on

    async def async_set_salt_geometry_raw(self, block: bytes) -> None:
        """Send a raw 5-byte salt/geometry block (53 xx yy zz ww).

        The caller is responsible for choosing appropriate bytes
        based on the mapping derived from traces.
        """

        # TODO: construct uu-style padded 20-byte payload and write it.
        _ = block
