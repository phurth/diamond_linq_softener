"""Diamond Linq Water Softener integration for Home Assistant."""
from __future__ import annotations

import logging
from datetime import timedelta

from homeassistant.config_entries import ConfigEntry
from homeassistant.const import Platform
from homeassistant.core import HomeAssistant
from homeassistant.helpers.update_coordinator import DataUpdateCoordinator, UpdateFailed

from .const import (
    DOMAIN, 
    DEFAULT_SCAN_INTERVAL, 
    CONF_AUTH_TOKEN, 
    DEFAULT_AUTH_TOKEN,
    CONF_PASSWORD,
    DEFAULT_PASSWORD,
)
from .ble_client import SoftenerBleClient
from .parser import DiamondLinqData

PLATFORMS: list[Platform] = [Platform.SENSOR, Platform.SWITCH]

_LOGGER = logging.getLogger(__name__)


class SoftenerDataUpdateCoordinator(DataUpdateCoordinator[DiamondLinqData]):
    """Coordinator that manages polling the softener via BLE."""

    def __init__(
        self,
        hass: HomeAssistant,
        client: SoftenerBleClient,
        address: str,
    ) -> None:
        """Initialize the coordinator.
        
        Args:
            hass: Home Assistant instance
            client: The BLE client for the softener
            address: BLE address for logging
        """
        super().__init__(
            hass,
            _LOGGER,
            name=f"{DOMAIN}_{address}",
            update_interval=timedelta(seconds=DEFAULT_SCAN_INTERVAL),
        )
        self.client = client
        self.address = address

    async def _async_update_data(self) -> DiamondLinqData:
        """Fetch data from the softener.
        
        This is called periodically by the coordinator.
        """
        _LOGGER.debug("Coordinator updating data for %s", self.address)
        
        try:
            data = await self.client.async_poll_once()
            
            if data.soft_remaining_gal is None and data.flow_gpm is None:
                _LOGGER.warning(
                    "No data received from softener %s - device may be out of range",
                    self.address
                )
            
            return data
            
        except Exception as err:
            _LOGGER.error("Error polling softener %s: %s", self.address, err)
            # Try to disconnect and reconnect on next poll
            await self.client.async_disconnect()
            raise UpdateFailed(f"Error communicating with softener: {err}") from err

    async def async_shutdown(self) -> None:
        """Shut down the coordinator and disconnect."""
        _LOGGER.info("Shutting down coordinator for %s", self.address)
        await self.client.async_disconnect()


async def async_setup_entry(hass: HomeAssistant, entry: ConfigEntry) -> bool:
    """Set up Diamond Linq softener from a config entry."""
    # Get the device address from config entry
    address = entry.data.get("address") or entry.unique_id
    
    if not address:
        _LOGGER.error("No address configured for Diamond Linq softener")
        return False

    _LOGGER.info("Setting up Diamond Linq softener at %s", address)

    # Get the auth token and password if configured
    auth_token = entry.data.get(CONF_AUTH_TOKEN, DEFAULT_AUTH_TOKEN)
    password = entry.data.get(CONF_PASSWORD, DEFAULT_PASSWORD)
    
    if auth_token:
        _LOGGER.info("Auth token configured (length=%d)", len(auth_token))
    else:
        _LOGGER.info("No auth token configured - will use password '%s' for PA auth", password)

    # Create the BLE client with auth configuration
    client = SoftenerBleClient(hass, address, auth_token=auth_token, password=password)
    
    # Create the coordinator
    coordinator = SoftenerDataUpdateCoordinator(hass, client, address)

    # Do an initial data fetch
    await coordinator.async_config_entry_first_refresh()

    # Store the coordinator for access by platforms
    hass.data.setdefault(DOMAIN, {})[entry.entry_id] = {
        "coordinator": coordinator,
        "client": client,
    }

    # Set up platforms (sensor, switch)
    await hass.config_entries.async_forward_entry_setups(entry, PLATFORMS)

    # Register shutdown handler
    entry.async_on_unload(coordinator.async_shutdown)

    return True


async def async_unload_entry(hass: HomeAssistant, entry: ConfigEntry) -> bool:
    """Unload a config entry."""
    _LOGGER.info("Unloading Diamond Linq softener entry %s", entry.entry_id)
    
    unload_ok = await hass.config_entries.async_unload_platforms(entry, PLATFORMS)
    
    if unload_ok:
        data = hass.data[DOMAIN].pop(entry.entry_id, None)
        if data:
            coordinator = data.get("coordinator")
            if coordinator:
                await coordinator.async_shutdown()
    
    return unload_ok
