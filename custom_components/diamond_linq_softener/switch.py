"""Switch platform for Diamond Linq Water Softener."""
from __future__ import annotations

import logging
from typing import TYPE_CHECKING, Any

from homeassistant.components.switch import SwitchEntity
from homeassistant.config_entries import ConfigEntry
from homeassistant.core import HomeAssistant
from homeassistant.helpers.entity_platform import AddEntitiesCallback
from homeassistant.helpers.update_coordinator import (
    CoordinatorEntity,
    DataUpdateCoordinator,
)

from .const import DOMAIN, NAME, MANUFACTURER
from .ble_client import SoftenerBleClient
from .parser import DiamondLinqData

if TYPE_CHECKING:
    from . import SoftenerDataUpdateCoordinator

_LOGGER = logging.getLogger(__name__)


async def async_setup_entry(
    hass: HomeAssistant,
    entry: ConfigEntry,
    async_add_entities: AddEntitiesCallback,
) -> None:
    """Set up Diamond Linq switch entities."""
    data = hass.data[DOMAIN][entry.entry_id]
    coordinator: DataUpdateCoordinator[DiamondLinqData] = data["coordinator"]
    client: SoftenerBleClient = data["client"]

    async_add_entities([DisplaySwitch(coordinator, client, entry)])


class DisplaySwitch(CoordinatorEntity[DataUpdateCoordinator[DiamondLinqData]], SwitchEntity):
    """Switch to control the front-panel display on the softener."""

    _attr_has_entity_name = True
    _attr_name = "Display"
    _attr_icon = "mdi:monitor"

    def __init__(
        self,
        coordinator: DataUpdateCoordinator[DiamondLinqData],
        client: SoftenerBleClient,
        entry: ConfigEntry,
    ) -> None:
        """Initialize the display switch.
        
        Args:
            coordinator: The data update coordinator
            client: The BLE client for sending commands
            entry: The config entry
        """
        super().__init__(coordinator)
        self._client = client
        self._attr_unique_id = f"{entry.entry_id}_display"
        self._is_on: bool | None = None  # Unknown until we get state from device
        
        # Device info for grouping entities
        self._attr_device_info = {
            "identifiers": {(DOMAIN, entry.entry_id)},
            "name": NAME,
            "manufacturer": MANUFACTURER,
            "model": "Water Softener",
        }

    @property
    def is_on(self) -> bool | None:
        """Return True if the display is on.
        
        Note: The display state is not currently read back from the device,
        so this returns the last commanded state.
        """
        return self._is_on

    async def async_turn_on(self, **kwargs: Any) -> None:
        """Turn the display on."""
        _LOGGER.info("Turning display ON")
        success = await self._client.async_set_display(on=True)
        if success:
            self._is_on = True
            self.async_write_ha_state()
        else:
            _LOGGER.error("Failed to turn display on")

    async def async_turn_off(self, **kwargs: Any) -> None:
        """Turn the display off."""
        _LOGGER.info("Turning display OFF")
        success = await self._client.async_set_display(on=False)
        if success:
            self._is_on = False
            self.async_write_ha_state()
        else:
            _LOGGER.error("Failed to turn display off")

    @property
    def available(self) -> bool:
        """Return True if entity is available.
        
        The switch is available if we have connectivity to the device.
        """
        return super().available
