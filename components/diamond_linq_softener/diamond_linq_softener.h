#pragma once

#include "esphome/core/component.h"
#include "esphome/components/ble_client/ble_client.h"
#include "esphome/components/esp32_ble_tracker/esp32_ble_tracker.h"
#include "esphome/components/sensor/sensor.h"
#include "esphome/components/text_sensor/text_sensor.h"
#include <esp_random.h>

namespace espbt = esphome::esp32_ble_tracker;

namespace esphome {
namespace diamond_linq_softener {

// Nordic UART Service UUIDs (128-bit, little-endian)
static const uint8_t NUS_SERVICE_UUID[] = {
    0x9e, 0xca, 0xdc, 0x24, 0x0e, 0xe5, 0xa9, 0xe0,
    0x93, 0xf3, 0xa3, 0xb5, 0x01, 0x00, 0x40, 0x6e
};

static const uint8_t NUS_RX_UUID[] = {  // Write characteristic (to device)
    0x9e, 0xca, 0xdc, 0x24, 0x0e, 0xe5, 0xa9, 0xe0,
    0x93, 0xf3, 0xa3, 0xb5, 0x02, 0x00, 0x40, 0x6e
};

static const uint8_t NUS_TX_UUID[] = {  // Notify characteristic (from device)
    0x9e, 0xca, 0xdc, 0x24, 0x0e, 0xe5, 0xa9, 0xe0,
    0x93, 0xf3, 0xa3, 0xb5, 0x03, 0x00, 0x40, 0x6e
};

class DiamondLinqSoftener : public PollingComponent, public ble_client::BLEClientNode {
 public:
  DiamondLinqSoftener() : PollingComponent(60000) {}

  void setup() override;
  void update() override;
  void gattc_event_handler(esp_gattc_cb_event_t event, esp_gatt_if_t gattc_if,
                           esp_ble_gattc_cb_param_t *param) override;
  void dump_config() override;
  float get_setup_priority() const override { return setup_priority::DATA; }

  void set_flow_sensor(sensor::Sensor *sensor) { flow_sensor_ = sensor; }
  void set_soft_remaining_sensor(sensor::Sensor *sensor) { soft_remaining_sensor_ = sensor; }
  void set_hardness_sensor(sensor::Sensor *sensor) { hardness_sensor_ = sensor; }
  void set_salt_level_sensor(sensor::Sensor *sensor) { salt_level_sensor_ = sensor; }
  void set_days_to_empty_sensor(sensor::Sensor *sensor) { days_to_empty_sensor_ = sensor; }
  void set_serial_sensor(text_sensor::TextSensor *sensor) { serial_sensor_ = sensor; }
  void set_auth_status_sensor(text_sensor::TextSensor *sensor) { auth_status_sensor_ = sensor; }
  void set_password(const std::string &password) { password_ = password; }

 protected:
  void send_pa_frame_();
  void send_pw_frame_();
  void send_tt_request_();
  void send_uu_request_();
  void send_vv_request_();
  void parse_tt_frame_(const uint8_t *data, uint16_t length);
  void parse_uu_frame_(const uint8_t *data, uint16_t length);
  void parse_vv_frame_(const uint8_t *data, uint16_t length);
  void write_to_device_(const uint8_t *data, uint16_t length);
  bool is_authenticated_() const { return authenticated_; }
  void update_auth_status_();

  uint16_t rx_handle_{0};
  uint16_t tx_handle_{0};
  uint16_t cccd_handle_{0};
  bool authenticated_{false};
  bool auth_attempted_{false};
  bool notifications_enabled_{false};
  
  std::string password_{"1234"};
  std::string serial_number_;

  sensor::Sensor *flow_sensor_{nullptr};
  sensor::Sensor *soft_remaining_sensor_{nullptr};
  sensor::Sensor *hardness_sensor_{nullptr};
  sensor::Sensor *salt_level_sensor_{nullptr};
  sensor::Sensor *days_to_empty_sensor_{nullptr};
  text_sensor::TextSensor *serial_sensor_{nullptr};
  text_sensor::TextSensor *auth_status_sensor_{nullptr};

  enum class State {
    IDLE,
    WAITING_FOR_TT,
    AUTHENTICATING,
    AUTHENTICATING_PW,
    REQUESTING_UU,
    REQUESTING_VV,
    DATA_RECEIVED
  } state_{State::IDLE};
  
  uint32_t last_request_time_{0};
};

}  // namespace diamond_linq_softener
}  // namespace esphome
