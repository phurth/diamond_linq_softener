"""ESPHome component for Diamond Linq Water Softener."""
import esphome.codegen as cg
import esphome.config_validation as cv
from esphome.components import ble_client, sensor, text_sensor
from esphome.const import (
    CONF_ID,
    CONF_PASSWORD,
    DEVICE_CLASS_WATER,
    STATE_CLASS_MEASUREMENT,
    UNIT_GALLON,
    UNIT_PERCENT,
    ICON_WATER,
)

DEPENDENCIES = ["ble_client"]
AUTO_LOAD = ["sensor", "text_sensor"]

CONF_FLOW_RATE = "flow_rate"
CONF_SOFT_REMAINING = "soft_remaining"
CONF_HARDNESS = "hardness"
CONF_SALT_LEVEL = "salt_level"
CONF_DAYS_TO_EMPTY = "days_to_empty"
CONF_SERIAL_NUMBER = "serial_number"
CONF_AUTH_STATUS = "auth_status"

diamond_linq_ns = cg.esphome_ns.namespace("diamond_linq_softener")
DiamondLinqSoftener = diamond_linq_ns.class_(
    "DiamondLinqSoftener", cg.PollingComponent, ble_client.BLEClientNode
)

CONFIG_SCHEMA = (
    cv.Schema(
        {
            cv.GenerateID(): cv.declare_id(DiamondLinqSoftener),
            cv.Optional(CONF_PASSWORD, default="1234"): cv.string,
            cv.Optional(CONF_FLOW_RATE): sensor.sensor_schema(
                unit_of_measurement="GPM",
                accuracy_decimals=2,
                device_class=DEVICE_CLASS_WATER,
                state_class=STATE_CLASS_MEASUREMENT,
                icon="mdi:water-pump",
            ),
            cv.Optional(CONF_SOFT_REMAINING): sensor.sensor_schema(
                unit_of_measurement=UNIT_GALLON,
                accuracy_decimals=0,
                device_class=DEVICE_CLASS_WATER,
                state_class=STATE_CLASS_MEASUREMENT,
                icon=ICON_WATER,
            ),
            cv.Optional(CONF_HARDNESS): sensor.sensor_schema(
                unit_of_measurement="gpg",
                accuracy_decimals=0,
                state_class=STATE_CLASS_MEASUREMENT,
                icon="mdi:water-opacity",
            ),
            cv.Optional(CONF_SALT_LEVEL): sensor.sensor_schema(
                unit_of_measurement=UNIT_PERCENT,
                accuracy_decimals=0,
                state_class=STATE_CLASS_MEASUREMENT,
                icon="mdi:shaker-outline",
            ),
            cv.Optional(CONF_DAYS_TO_EMPTY): sensor.sensor_schema(
                unit_of_measurement="days",
                accuracy_decimals=0,
                state_class=STATE_CLASS_MEASUREMENT,
                icon="mdi:calendar-clock",
            ),
            cv.Optional(CONF_SERIAL_NUMBER): text_sensor.text_sensor_schema(
                icon="mdi:identifier",
            ),
            cv.Optional(CONF_AUTH_STATUS): text_sensor.text_sensor_schema(
                icon="mdi:shield-check",
            ),
        }
    )
    .extend(cv.polling_component_schema("60s"))
    .extend(ble_client.BLE_CLIENT_SCHEMA)
)


async def to_code(config):
    var = cg.new_Pvariable(config[CONF_ID])
    await cg.register_component(var, config)
    await ble_client.register_ble_node(var, config)

    cg.add(var.set_password(config[CONF_PASSWORD]))

    if CONF_FLOW_RATE in config:
        sens = await sensor.new_sensor(config[CONF_FLOW_RATE])
        cg.add(var.set_flow_sensor(sens))

    if CONF_SOFT_REMAINING in config:
        sens = await sensor.new_sensor(config[CONF_SOFT_REMAINING])
        cg.add(var.set_soft_remaining_sensor(sens))

    if CONF_HARDNESS in config:
        sens = await sensor.new_sensor(config[CONF_HARDNESS])
        cg.add(var.set_hardness_sensor(sens))

    if CONF_SALT_LEVEL in config:
        sens = await sensor.new_sensor(config[CONF_SALT_LEVEL])
        cg.add(var.set_salt_level_sensor(sens))

    if CONF_DAYS_TO_EMPTY in config:
        sens = await sensor.new_sensor(config[CONF_DAYS_TO_EMPTY])
        cg.add(var.set_days_to_empty_sensor(sens))

    if CONF_SERIAL_NUMBER in config:
        sens = await text_sensor.new_text_sensor(config[CONF_SERIAL_NUMBER])
        cg.add(var.set_serial_sensor(sens))

    if CONF_AUTH_STATUS in config:
        sens = await text_sensor.new_text_sensor(config[CONF_AUTH_STATUS])
        cg.add(var.set_auth_status_sensor(sens))
