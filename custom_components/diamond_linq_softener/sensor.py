from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Callable

from homeassistant.components.sensor import SensorEntity, SensorEntityDescription
from homeassistant.config_entries import ConfigEntry
from homeassistant.core import HomeAssistant
from homeassistant.helpers.entity_platform import AddEntitiesCallback
from homeassistant.helpers.update_coordinator import CoordinatorEntity

from .ble_client import SoftenerState
from .coordinator import SoftenerCoordinator
from .const import DOMAIN, NAME


@dataclass
class SoftenerSensorEntityDescription(SensorEntityDescription):
    value_fn: Callable[[SoftenerState], Any] | None = None


SENSORS: tuple[SoftenerSensorEntityDescription, ...] = (
    SoftenerSensorEntityDescription(
        key="flow_gpm",
        name=f"{NAME} Flow",
        native_unit_of_measurement="gal/min",
        value_fn=lambda s: s.flow_gpm,
    ),
    SoftenerSensorEntityDescription(
        key="soft_remaining_gal",
        name=f"{NAME} Soft Remaining",
        native_unit_of_measurement="gal",
        value_fn=lambda s: s.soft_remaining_gal,
    ),
    SoftenerSensorEntityDescription(
        key="treated_today_gal",
        name=f"{NAME} Treated Today",
        native_unit_of_measurement="gal",
        value_fn=lambda s: s.treated_today_gal,
    ),
    SoftenerSensorEntityDescription(
        key="avg_daily_use_gal",
        name=f"{NAME} Average Daily Use",
        native_unit_of_measurement="gal",
        value_fn=lambda s: s.avg_daily_use_gal,
    ),
    SoftenerSensorEntityDescription(
        key="regen_hour",
        name=f"{NAME} Regen Hour",
        native_unit_of_measurement="h",
        value_fn=lambda s: s.regen_hour,
    ),
    SoftenerSensorEntityDescription(
        key="salt_config_f7",
        name=f"{NAME} Salt Config F7 (raw)",
        value_fn=lambda s: s.salt_config_f7,
    ),
    SoftenerSensorEntityDescription(
        key="salt_config_f8",
        name=f"{NAME} Salt Config F8 (raw)",
        value_fn=lambda s: s.salt_config_f8,
    ),
)


async def async_setup_entry(
    hass: HomeAssistant,
    entry: ConfigEntry,
    async_add_entities: AddEntitiesCallback,
) -> None:
    data = hass.data[DOMAIN][entry.entry_id]
    coordinator: SoftenerCoordinator = data["coordinator"]

    entities: list[SoftenerSensor] = []
    for desc in SENSORS:
        entities.append(SoftenerSensor(coordinator, desc))

    async_add_entities(entities)


class SoftenerSensor(CoordinatorEntity[SoftenerCoordinator], SensorEntity):
    """Sensor backed by SoftenerCoordinator."""

    entity_description: SoftenerSensorEntityDescription

    def __init__(
        self,
        coordinator: SoftenerCoordinator,
        description: SoftenerSensorEntityDescription,
    ) -> None:
        super().__init__(coordinator)
        self.entity_description = description
        self._attr_unique_id = f"{DOMAIN}_{description.key}"

    @property
    def native_value(self) -> Any:
        state: SoftenerState = self.coordinator.data
        fn = self.entity_description.value_fn
        return fn(state) if fn is not None else None
