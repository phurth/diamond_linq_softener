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
    address = entry.unique_id  # Use the unique_id set by config flow

    # Store the latest data here so sensors can access it
    latest_data = DiamondLinqData()

    def _needs_poll(service_info, last_poll):
        # For your softener, we need to poll to get the tt/uu frames
        # You could optimize this based on advertisement data if the softener broadcasts anything
        return True  # Always poll for now

    async def _async_poll(service_info):
        # This is where we do the active BLE connection and get tt/uu data
        # service_info.device is the BLE device from HA's bluetooth layer
        _LOGGER.debug("Polling device: %s", service_info.device.address)
        polled_data = await DiamondLinqData().async_poll(service_info.device)
        # Update our shared data
        nonlocal latest_data
        latest_data = polled_data
        return polled_data

    def update_method(service_info):
        # This is called with advertisement data, but we mainly use polling
        return latest_data

    coordinator = ActiveBluetoothProcessorCoordinator(
        hass,
        _LOGGER,
        address=address,
        mode=BluetoothScanningMode.ACTIVE,  # We need active mode for connections
        update_method=update_method,
        needs_poll_method=_needs_poll,
        poll_method=_async_poll,
        connectable=True,  # We need to connect to subscribe to NUS TX
    )

    # Store both coordinator and latest data for sensors to access
    hass.data.setdefault(DOMAIN, {})[entry.entry_id] = {
        "coordinator": coordinator,
        "latest_data": latest_data,
    }
    await hass.config_entries.async_forward_entry_setups(entry, PLATFORMS)
    entry.async_on_unload(coordinator.async_start())

    return True


async def async_unload_entry(hass: HomeAssistant, entry: ConfigEntry) -> bool:
    """Unload a config entry."""
    unload_ok = await hass.config_entries.async_unload_platforms(entry, PLATFORMS)
    # Note: ActiveBluetoothProcessorCoordinator doesn't have async_shutdown method
    # The coordinator will be automatically cleaned up by HA
    return unload_ok