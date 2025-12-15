from __future__ import annotations

from typing import Any

import voluptuous as vol

from homeassistant import config_entries
from homeassistant.core import callback

from .const import DOMAIN, NAME


class DiamondLinqConfigFlow(config_entries.ConfigFlow, domain=DOMAIN):
    """Handle a config flow for the Diamond Linq softener."""

    VERSION = 1

    async def async_step_user(self, user_input: dict[str, Any] | None = None):
        if user_input is not None:
            # Check if already configured
            await self.async_set_unique_id(user_input["address"])
            self._abort_if_unique_id_configured()

            return self.async_create_entry(
                title=NAME,
                data=user_input,
            )

        data_schema = vol.Schema(
            {
                vol.Required("address"): str,
            }
        )

        return self.async_show_form(step_id="user", data_schema=data_schema)

    @callback
    def async_get_options_flow(self, config_entry):  # type: ignore[override]
        return OptionsFlowHandler(config_entry)


class OptionsFlowHandler(config_entries.OptionsFlow):
    def __init__(self, config_entry: config_entries.ConfigEntry) -> None:
        self._config_entry = config_entry

    async def async_step_init(self, user_input: dict[str, Any] | None = None):  # type: ignore[override]
        if user_input is not None:
            return self.async_create_entry(title="Options", data=user_input)

        # For now, no editable options beyond the device address.
        return self.async_create_entry(title="Options", data={})