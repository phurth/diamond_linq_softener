from __future__ import annotations

from typing import Any

from homeassistant.components.switch import SwitchEntity
from homeassistant.config_entries import ConfigEntry
from homeassistant.core import HomeAssistant
from homeassistant.helpers.entity_platform import AddEntitiesCallback

from .ble_client import SoftenerBleClient
from .coordinator import SoftenerCoordinator
from .const import DOMAIN, NAME


async def async_setup_entry(
    hass: HomeAssistant,
    entry: ConfigEntry,
    async_add_entities: AddEntitiesCallback,
) -> None:
    data = hass.data[DOMAIN][entry.entry_id]
    coordinator: SoftenerCoordinator = data["coordinator"]
    client: SoftenerBleClient = data["client"]

    async_add_entities([DisplaySwitch(coordinator, client)])


class DisplaySwitch(SwitchEntity):
    """Switch to control the front-panel display on the softener."""

    def __init__(self, coordinator: SoftenerCoordinator, client: SoftenerBleClient) -> None:
        self._coordinator = coordinator
        self._client = client
        self._attr_name = f"{NAME} Display"
        self._attr_unique_id = f"{DOMAIN}_display"
        self._is_on: bool | None = None

    @property
    def is_on(self) -> bool | None:
        return self._is_on

    async def async_turn_on(self, **kwargs: Any) -> None:  # type: ignore[override]
        await self._client.async_set_display(True)
        self._is_on = True
        self.async_write_ha_state()

    async def async_turn_off(self, **kwargs: Any) -> None:  # type: ignore[override]
        await self._client.async_set_display(False)
        self._is_on = False
        self.async_write_ha_state()

    async def async_update(self) -> None:
        # Display state is not yet read back as a sensor; assume last command.
        return
