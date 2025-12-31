"""Sensor platform for Diamond Linq Water Softener."""
from __future__ import annotations

from dataclasses import dataclass
from typing import TYPE_CHECKING, Any, Callable

from homeassistant.components.sensor import (
    SensorDeviceClass,
    SensorEntity,
    SensorEntityDescription,
    SensorStateClass,
)
from homeassistant.config_entries import ConfigEntry
from homeassistant.core import HomeAssistant
from homeassistant.helpers.entity_platform import AddEntitiesCallback
from homeassistant.helpers.update_coordinator import (
    CoordinatorEntity,
    DataUpdateCoordinator,
)

from .const import DOMAIN, NAME, MANUFACTURER
from .parser import DiamondLinqData

if TYPE_CHECKING:
    from . import SoftenerDataUpdateCoordinator


@dataclass(frozen=True, kw_only=True)
class SoftenerSensorEntityDescription(SensorEntityDescription):
    """Describes a Diamond Linq sensor entity."""
    
    value_fn: Callable[[DiamondLinqData], Any]


SENSORS: tuple[SoftenerSensorEntityDescription, ...] = (
    SoftenerSensorEntityDescription(
        key="flow_gpm",
        name="Current Flow",
        native_unit_of_measurement="gal/min",
        device_class=SensorDeviceClass.VOLUME_FLOW_RATE,
        state_class=SensorStateClass.MEASUREMENT,
        icon="mdi:water",
        value_fn=lambda d: d.flow_gpm,
    ),
    SoftenerSensorEntityDescription(
        key="soft_remaining_gal",
        name="Soft Water Remaining",
        native_unit_of_measurement="gal",
        device_class=SensorDeviceClass.WATER,
        state_class=SensorStateClass.MEASUREMENT,
        icon="mdi:water-check",
        value_fn=lambda d: d.soft_remaining_gal,
    ),
    SoftenerSensorEntityDescription(
        key="treated_today_gal",
        name="Treated Today",
        native_unit_of_measurement="gal",
        device_class=SensorDeviceClass.WATER,
        state_class=SensorStateClass.TOTAL_INCREASING,
        icon="mdi:water-plus",
        value_fn=lambda d: d.treated_today_gal,
    ),
    SoftenerSensorEntityDescription(
        key="avg_daily_use_gal",
        name="Average Daily Use",
        native_unit_of_measurement="gal",
        device_class=SensorDeviceClass.WATER,
        state_class=SensorStateClass.MEASUREMENT,
        icon="mdi:chart-line",
        value_fn=lambda d: d.avg_daily_use_gal,
    ),
    SoftenerSensorEntityDescription(
        key="days_until_regen",
        name="Days Until Regeneration",
        native_unit_of_measurement="d",
        state_class=SensorStateClass.MEASUREMENT,
        icon="mdi:calendar-clock",
        value_fn=lambda d: d.days_until_regen,
    ),
    SoftenerSensorEntityDescription(
        key="regen_hour",
        name="Regeneration Time",
        native_unit_of_measurement="h",
        icon="mdi:clock-outline",
        value_fn=lambda d: d.regen_hour,
    ),
    SoftenerSensorEntityDescription(
        key="water_hardness_gpg",
        name="Water Hardness",
        native_unit_of_measurement="gpg",
        state_class=SensorStateClass.MEASUREMENT,
        icon="mdi:water-opacity",
        value_fn=lambda d: d.water_hardness_gpg,
    ),
    SoftenerSensorEntityDescription(
        key="reserve_capacity_pct",
        name="Reserve Capacity",
        native_unit_of_measurement="%",
        state_class=SensorStateClass.MEASUREMENT,
        icon="mdi:gauge",
        value_fn=lambda d: d.reserve_capacity_pct,
    ),
    SoftenerSensorEntityDescription(
        key="salt_config_f7",
        name="Salt Config F7 (raw)",
        icon="mdi:shaker-outline",
        value_fn=lambda d: d.salt_config_f7,
        entity_registry_enabled_default=False,  # Hidden by default
    ),
    SoftenerSensorEntityDescription(
        key="salt_config_f8",
        name="Salt Config F8 (raw)",
        icon="mdi:shaker-outline",
        value_fn=lambda d: d.salt_config_f8,
        entity_registry_enabled_default=False,  # Hidden by default
    ),
)


async def async_setup_entry(
    hass: HomeAssistant,
    entry: ConfigEntry,
    async_add_entities: AddEntitiesCallback,
) -> None:
    """Set up Diamond Linq sensor entities."""
    data = hass.data[DOMAIN][entry.entry_id]
    coordinator: DataUpdateCoordinator[DiamondLinqData] = data["coordinator"]

    entities: list[SoftenerSensor] = [
        SoftenerSensor(coordinator, entry, description)
        for description in SENSORS
    ]

    async_add_entities(entities)


class SoftenerSensor(CoordinatorEntity[DataUpdateCoordinator[DiamondLinqData]], SensorEntity):
    """Sensor entity for Diamond Linq water softener."""

    entity_description: SoftenerSensorEntityDescription
    _attr_has_entity_name = True

    def __init__(
        self,
        coordinator: DataUpdateCoordinator[DiamondLinqData],
        entry: ConfigEntry,
        description: SoftenerSensorEntityDescription,
    ) -> None:
        """Initialize the sensor.
        
        Args:
            coordinator: The data update coordinator
            entry: The config entry
            description: The sensor entity description
        """
        super().__init__(coordinator)
        self.entity_description = description
        
        # Set unique ID using entry ID and sensor key
        self._attr_unique_id = f"{entry.entry_id}_{description.key}"
        
        # Device info for grouping entities
        self._attr_device_info = {
            "identifiers": {(DOMAIN, entry.entry_id)},
            "name": NAME,
            "manufacturer": MANUFACTURER,
            "model": "Water Softener",
            "sw_version": coordinator.data.firmware_version if coordinator.data else None,
        }

    @property
    def native_value(self) -> Any:
        """Return the sensor value."""
        if self.coordinator.data is None:
            return None
        return self.entity_description.value_fn(self.coordinator.data)

    @property
    def available(self) -> bool:
        """Return True if entity is available."""
        return (
            super().available
            and self.coordinator.data is not None
            and self.native_value is not None
        )
