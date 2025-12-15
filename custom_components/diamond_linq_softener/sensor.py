from __future__ import annotations

from dataclasses import dataclass
from typing import Any, Callable

from homeassistant.components.bluetooth.active_update_processor import (
    ActiveBluetoothProcessorCoordinator,
)
from homeassistant.components.sensor import SensorEntity, SensorEntityDescription
from homeassistant.config_entries import ConfigEntry
from homeassistant.core import HomeAssistant
from homeassistant.helpers.entity_platform import AddEntitiesCallback
from homeassistant.helpers.update_coordinator import CoordinatorEntity

from .const import DOMAIN, NAME
from .parser import DiamondLinqData


@dataclass
class SoftenerSensorEntityDescription(SensorEntityDescription):
    value_fn: Callable[[DiamondLinqData], Any] | None = None


SENSORS: tuple[SoftenerSensorEntityDescription, ...] = (
    SoftenerSensorEntityDescription(
        key="flow_gpm",
        name=f"{NAME} Flow",
        native_unit_of_measurement="gal/min",
        value_fn=lambda d: d.flow_gpm,
    ),
    SoftenerSensorEntityDescription(
        key="soft_remaining_gal",
        name=f"{NAME} Soft Remaining",
        native_unit_of_measurement="gal",
        value_fn=lambda d: d.soft_remaining_gal,
    ),
    SoftenerSensorEntityDescription(
        key="treated_today_gal",
        name=f"{NAME} Treated Today",
        native_unit_of_measurement="gal",
        value_fn=lambda d: d.treated_today_gal,
    ),
    SoftenerSensorEntityDescription(
        key="avg_daily_use_gal",
        name=f"{NAME} Average Daily Use",
        native_unit_of_measurement="gal",
        value_fn=lambda d: d.avg_daily_use_gal,
    ),
    SoftenerSensorEntityDescription(
        key="regen_hour",
        name=f"{NAME} Regen Hour",
        native_unit_of_measurement="h",
        value_fn=lambda d: d.regen_hour,
    ),
    SoftenerSensorEntityDescription(
        key="salt_config_f7",
        name=f"{NAME} Salt Config F7 (raw)",
        value_fn=lambda d: d.salt_config_f7,
    ),
    SoftenerSensorEntityDescription(
        key="salt_config_f8",
        name=f"{NAME} Salt Config F8 (raw)",
        value_fn=lambda d: d.salt_config_f8,
    ),
)


async def async_setup_entry(
    hass: HomeAssistant,
    entry: ConfigEntry,
    async_add_entities: AddEntitiesCallback,
) -> None:
    coordinator: ActiveBluetoothProcessorCoordinator = hass.data[DOMAIN][entry.entry_id]

    entities: list[SoftenerSensor] = []
    for desc in SENSORS:
        entities.append(SoftenerSensor(coordinator, desc))

    async_add_entities(entities)


class SoftenerSensor(
    CoordinatorEntity[ActiveBluetoothProcessorCoordinator], SensorEntity
):
    """Sensor backed by the ActiveBluetoothProcessorCoordinator."""

    entity_description: SoftenerSensorEntityDescription

    def __init__(
        self,
        coordinator: ActiveBluetoothProcessorCoordinator,
        description: SoftenerSensorEntityDescription,
    ) -> None:
        super().__init__(coordinator)
        self.entity_description = description
        self._attr_unique_id = f"{DOMAIN}_{description.key}"

    @property
    def native_value(self) -> Any:
        data: DiamondLinqData = self.coordinator.data
        fn = self.entity_description.value_fn
        return fn(data) if fn is not None else None