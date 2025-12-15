from __future__ import annotations

from typing import Any

from homeassistant.config_entries import ConfigEntry
from homeassistant.core import HomeAssistant
from homeassistant.helpers.typing import ConfigType

from .ble_client import SoftenerBleClient
from .coordinator import SoftenerCoordinator
from .const import DOMAIN

PLATFORMS = ["sensor", "switch"]


async def async_setup(hass: HomeAssistant, config: ConfigType) -> bool:
    """Set up from YAML (not used; config flow only)."""

    return True


async def async_setup_entry(hass: HomeAssistant, entry: ConfigEntry) -> bool:
    """Set up the integration from a config entry."""

    address = entry.data["address"]
    client = SoftenerBleClient(hass, address)
    coordinator = SoftenerCoordinator(hass, client)

    await coordinator.async_config_entry_first_refresh()

    hass.data.setdefault(DOMAIN, {})[entry.entry_id] = {
        "client": client,
        "coordinator": coordinator,
    }

    await hass.config_entries.async_forward_entry_setups(entry, PLATFORMS)
    return True


async def async_unload_entry(hass: HomeAssistant, entry: ConfigEntry) -> bool:
    """Unload a config entry."""

    unload_ok = await hass.config_entries.async_unload_platforms(entry, PLATFORMS)
    data = hass.data.get(DOMAIN, {}).pop(entry.entry_id, None)
    if data is not None:
        client: SoftenerBleClient = data["client"]
        await client.async_disconnect()
    return unload_ok
