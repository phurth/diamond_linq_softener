from __future__ import annotations

from datetime import timedelta
import logging

from homeassistant.core import HomeAssistant
from homeassistant.helpers.update_coordinator import DataUpdateCoordinator

from .ble_client import SoftenerBleClient, SoftenerState
from .const import DEFAULT_SCAN_INTERVAL, DOMAIN

_LOGGER = logging.getLogger(__name__)


class SoftenerCoordinator(DataUpdateCoordinator[SoftenerState]):
    """Coordinates BLE polling and exposes SoftenerState."""

    def __init__(self, hass: HomeAssistant, client: SoftenerBleClient) -> None:
        super().__init__(
            hass,
            _LOGGER,
            name=f"{DOMAIN}_coordinator",
            update_interval=timedelta(seconds=DEFAULT_SCAN_INTERVAL),
        )
        self._client = client

    async def _async_update_data(self) -> SoftenerState:
        """Fetch data from the device."""

        await self._client.async_connect()
        state = await self._client.async_poll_once()
        return state
