from __future__ import annotations

from typing import Any

from homeassistant.components.switch import SwitchEntity
from homeassistant.config_entries import ConfigEntry
from homeassistant.core import HomeAssistant
from homeassistant.helpers.entity_platform import AddEntitiesCallback

from .const import DOMAIN, NAME


async def async_setup_entry(
    hass: HomeAssistant,
    entry: ConfigEntry,
    async_add_entities: AddEntitiesCallback,
) -> None:
    # For now, create the switch entity without direct coordinator access
    # Command sending will need to be implemented separately
    async_add_entities([DisplaySwitch(entry.entry_id)])


class DisplaySwitch(SwitchEntity):
    """Switch to control the front-panel display on the softener."""

    def __init__(self, entry_id: str) -> None:
        self._entry_id = entry_id
        self._attr_name = f"{NAME} Display"
        self._attr_unique_id = f"{DOMAIN}_display_{entry_id}"
        self._is_on: bool | None = None

    @property
    def is_on(self) -> bool | None:
        return self._is_on

    async def async_turn_on(self, **kwargs: Any) -> None:  # type: ignore[override]
        # TODO: Implement display ON command
        # This will require extending the ActiveBluetoothProcessorCoordinator
        # to support command sending, or implementing a separate BLE connection
        # for commands while keeping polling for sensors
        self._is_on = True
        self.async_write_ha_state()

    async def async_turn_off(self, **kwargs: Any) -> None:  # type: ignore[override]
        # TODO: Implement display OFF command
        self._is_on = False
        self.async_write_ha_state()

    async def async_update(self) -> None:
        # Display state is not yet read back as a sensor
        return