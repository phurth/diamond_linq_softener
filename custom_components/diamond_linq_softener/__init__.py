from __future__ import annotations

import logging

from homeassistant.config_entries import ConfigEntry
from homeassistant.const import Platform
from homeassistant.core import HomeAssistant
from homeassistant.components.bluetooth import BluetoothScanningMode
from homeassistant.components.bluetooth.active_update_processor import (
    ActiveBluetoothProcessorCoordinator,
)

from .const import DOMAIN
from .parser import DiamondLinqData

PLATFORMS: list[Platform] = [Platform.SENSOR, Platform.SWITCH]

_LOGGER = logging.getLogger(__name__)


async def async_setup_entry(hass: HomeAssistant, entry: ConfigEntry) -> bool:
    """Set up Diamond Linq softener from a config entry."""
    address = entry.unique_id
    data = DiamondLinqData()

    def _needs_poll(service_info, last_poll):
        # For your softener, we need to poll to get the tt/uu frames
        # You could optimize this based on advertisement data if the softener broadcasts anything
        return True  # Always poll for now

    async def _async_poll(service_info):
        # This is where we do the active BLE connection and get tt/uu data
        # service_info.device is the BLE device from HA's bluetooth layer
        return await data.async_poll(service_info.device)

    coordinator = ActiveBluetoothProcessorCoordinator(
        hass,
        _LOGGER,
        address=address,
        mode=BluetoothScanningMode.ACTIVE,  # We need active mode for connections
        update_method=data.update,
        needs_poll_method=_needs_poll,
        poll_method=_async_poll,
        connectable=True,  # We need to connect to subscribe to NUS TX
    )

    hass.data.setdefault(DOMAIN, {})[entry.entry_id] = coordinator
    await hass.config_entries.async_forward_entry_setups(entry, PLATFORMS)
    entry.async_on_unload(coordinator.async_start())

    return True


async def async_unload_entry(hass: HomeAssistant, entry: ConfigEntry) -> bool:
    """Unload a config entry."""
    unload_ok = await hass.config_entries.async_unload_platforms(entry, PLATFORMS)
    coordinator = hass.data[DOMAIN][entry.entry_id]
    if unload_ok:
        await coordinator.async_shutdown()
    return unload_ok