#include "diamond_linq_softener.h"
#include "esphome/core/log.h"
#include "esphome/core/helpers.h"

namespace esphome {
namespace diamond_linq_softener {

static const char *const TAG = "diamond_linq_softener";

// Frame type prefixes
static const uint8_t FRAME_TT = 0x74;  // 't'
static const uint8_t FRAME_UU = 0x75;  // 'u'
static const uint8_t FRAME_VV = 0x76;  // 'v'

void DiamondLinqSoftener::setup() {
  ESP_LOGI(TAG, "Setting up Diamond Linq Softener...");
}

void DiamondLinqSoftener::dump_config() {
  ESP_LOGCONFIG(TAG, "Diamond Linq Softener:");
  ESP_LOGCONFIG(TAG, "  MAC Address: %s", this->parent()->address_str());
  ESP_LOGCONFIG(TAG, "  Password: %s", this->password_.c_str());
  LOG_SENSOR("  ", "Flow Rate", this->flow_sensor_);
  LOG_SENSOR("  ", "Soft Remaining", this->soft_remaining_sensor_);
  LOG_SENSOR("  ", "Hardness", this->hardness_sensor_);
  LOG_SENSOR("  ", "Salt Level", this->salt_level_sensor_);
  LOG_SENSOR("  ", "Days to Empty", this->days_to_empty_sensor_);
  LOG_TEXT_SENSOR("  ", "Serial Number", this->serial_sensor_);
  LOG_TEXT_SENSOR("  ", "Auth Status", this->auth_status_sensor_);
}

void DiamondLinqSoftener::update() {
  ESP_LOGD(TAG, "update() called - node_state=%d, rx_handle=0x%04x, tx_handle=0x%04x, notifications=%s",
           static_cast<int>(this->node_state), this->rx_handle_, this->tx_handle_,
           this->notifications_enabled_ ? "YES" : "NO");
           
  if (this->node_state != esp32_ble_tracker::ClientState::ESTABLISHED) {
    ESP_LOGW(TAG, "Not connected to device (state=%d), skipping update", 
             static_cast<int>(this->node_state));
    return;
  }

  if (this->rx_handle_ == 0) {
    ESP_LOGW(TAG, "RX handle not found, skipping update");
    return;
  }

  if (!this->notifications_enabled_) {
    ESP_LOGW(TAG, "Notifications not enabled yet, skipping update");
    return;
  }

  // Skip authentication - just poll data directly!
  // Password is only required for WRITE operations (config changes)
  // Reading sensor data (tt/uu/vv) works without auth
  ESP_LOGI(TAG, "Polling device data (no auth needed for reads)");
  
  this->send_tt_request_();
  
  // Queue uu and vv requests with delays
  this->set_timeout("send_uu", 200, [this]() {
    this->send_uu_request_();
  });
  this->set_timeout("send_vv", 400, [this]() {
    this->send_vv_request_();
  });
  
  this->last_request_time_ = millis();
}

void DiamondLinqSoftener::gattc_event_handler(esp_gattc_cb_event_t event, 
                                               esp_gatt_if_t gattc_if,
                                               esp_ble_gattc_cb_param_t *param) {
  switch (event) {
    case ESP_GATTC_OPEN_EVT: {
      if (param->open.status == ESP_GATT_OK) {
        ESP_LOGI(TAG, "Connected to device - connection established");
        this->authenticated_ = false;
        this->auth_attempted_ = false;
        this->update_auth_status_();
      } else {
        ESP_LOGW(TAG, "Connection failed: status=%d", param->open.status);
      }
      break;
    }

    case ESP_GATTC_DISCONNECT_EVT: {
      ESP_LOGI(TAG, "Disconnected from device - reason=%d", param->disconnect.reason);
      this->rx_handle_ = 0;
      this->tx_handle_ = 0;
      this->cccd_handle_ = 0;
      this->authenticated_ = false;
      this->notifications_enabled_ = false;
      this->update_auth_status_();
      break;
    }

    case ESP_GATTC_SEARCH_CMPL_EVT: {
      // Service discovery complete - find our characteristics
      ESP_LOGI(TAG, "Service discovery complete - searching for NUS characteristics");
      
      // Look for NUS RX characteristic (write to device)
      auto *rx_char = this->parent()->get_characteristic(
          espbt::ESPBTUUID::from_raw(NUS_SERVICE_UUID),
          espbt::ESPBTUUID::from_raw(NUS_RX_UUID));
      if (rx_char != nullptr) {
        this->rx_handle_ = rx_char->handle;
        ESP_LOGI(TAG, "Found RX characteristic, handle=0x%04x", this->rx_handle_);
      } else {
        ESP_LOGW(TAG, "RX characteristic not found!");
      }

      // Look for NUS TX characteristic (notify from device)
      auto *tx_char = this->parent()->get_characteristic(
          espbt::ESPBTUUID::from_raw(NUS_SERVICE_UUID),
          espbt::ESPBTUUID::from_raw(NUS_TX_UUID));
      if (tx_char != nullptr) {
        this->tx_handle_ = tx_char->handle;
        ESP_LOGI(TAG, "Found TX characteristic, handle=0x%04x", this->tx_handle_);
        
        // Enable notifications on TX characteristic
        auto status = esp_ble_gattc_register_for_notify(
            this->parent()->get_gattc_if(),
            this->parent()->get_remote_bda(),
            this->tx_handle_);
        if (status != ESP_OK) {
          ESP_LOGW(TAG, "Failed to register for notifications: %d", status);
        } else {
          ESP_LOGI(TAG, "Registered for TX notifications");
        }
      } else {
        ESP_LOGW(TAG, "TX characteristic not found!");
      }
      break;
    }

    case ESP_GATTC_REG_FOR_NOTIFY_EVT: {
      if (param->reg_for_notify.status == ESP_GATT_OK) {
        ESP_LOGI(TAG, "Notifications registered successfully - scheduling initial poll");
        this->notifications_enabled_ = true;
        this->node_state = esp32_ble_tracker::ClientState::ESTABLISHED;
        
        // Now that notifications are enabled, do initial poll
        this->set_timeout("initial_poll", 500, [this]() {
          ESP_LOGI(TAG, "Initial poll timeout triggered");
          this->update();
        });
      } else {
        ESP_LOGW(TAG, "Notification registration failed: %d", param->reg_for_notify.status);
      }
      break;
    }

    case ESP_GATTC_NOTIFY_EVT: {
      // Received data from device
      if (param->notify.handle != this->tx_handle_) {
        break;
      }

      const uint8_t *data = param->notify.value;
      uint16_t length = param->notify.value_len;

      if (length < 2) {
        ESP_LOGW(TAG, "Received frame too short: %d bytes", length);
        break;
      }

      // Log raw frame
      ESP_LOGD(TAG, "RX [%d bytes]: %s", length, 
               format_hex_pretty(data, length).c_str());

      // Identify frame type
      if (data[0] == FRAME_TT && data[1] == FRAME_TT) {
        this->parse_tt_frame_(data, length);
      } else if (data[0] == FRAME_UU && data[1] == FRAME_UU) {
        this->parse_uu_frame_(data, length);
      } else if (data[0] == FRAME_VV && data[1] == FRAME_VV) {
        this->parse_vv_frame_(data, length);
      } else {
        ESP_LOGD(TAG, "Unknown frame type: 0x%02x 0x%02x", data[0], data[1]);
      }
      break;
    }

    default:
      break;
  }
}

void DiamondLinqSoftener::send_pa_frame_() {
  // PA frame format: tt (2 bytes) + PA (2 bytes) + random token (16 bytes)
  uint8_t pa_frame[20];
  pa_frame[0] = FRAME_TT;  // 0x74
  pa_frame[1] = FRAME_TT;  // 0x74
  pa_frame[2] = 0x50;      // 'P'
  pa_frame[3] = 0x41;      // 'A'
  
  // Generate 16 random bytes for token
  esp_fill_random(&pa_frame[4], 16);

  ESP_LOGI(TAG, "Sending PA frame: %s", format_hex_pretty(pa_frame, 20).c_str());
  this->write_to_device_(pa_frame, 20);
}

void DiamondLinqSoftener::send_pw_frame_() {
  // PW frame format from Android app (when password is set):
  // Bytes 0-11: 0x74 padding
  // Bytes 12-13: 0x50 0x57 ("PW")
  // Bytes 14-17: Password digits as BCD (NOT ASCII!)
  // Bytes 18-19: 0x74 padding
  uint8_t pw_frame[20];
  memset(pw_frame, FRAME_TT, 20);  // Fill with 0x74
  
  pw_frame[12] = 0x50;  // 'P'
  pw_frame[13] = 0x57;  // 'W'
  
  // Convert password string to BCD digits
  // "1234" becomes bytes [1, 2, 3, 4]
  int pwd = atoi(this->password_.c_str());
  pw_frame[14] = (pwd / 1000) % 10;  // Thousands
  pw_frame[15] = (pwd / 100) % 10;   // Hundreds
  pw_frame[16] = (pwd / 10) % 10;    // Tens
  pw_frame[17] = pwd % 10;           // Units

  ESP_LOGI(TAG, "Sending PW frame (password=%s): %s", 
           this->password_.c_str(), format_hex_pretty(pw_frame, 20).c_str());
  this->write_to_device_(pw_frame, 20);
}

void DiamondLinqSoftener::send_tt_request_() {
  uint8_t tt_frame[20];
  memset(tt_frame, FRAME_TT, 20);  // Fill with 0x74
  
  ESP_LOGD(TAG, "Sending tt request");
  this->write_to_device_(tt_frame, 20);
}

void DiamondLinqSoftener::send_uu_request_() {
  uint8_t uu_frame[20];
  memset(uu_frame, FRAME_UU, 20);  // Fill with 0x75
  
  ESP_LOGD(TAG, "Sending uu request");
  this->write_to_device_(uu_frame, 20);
}

void DiamondLinqSoftener::send_vv_request_() {
  uint8_t vv_frame[20];
  memset(vv_frame, FRAME_VV, 20);  // Fill with 0x76
  
  ESP_LOGD(TAG, "Sending vv request");
  this->write_to_device_(vv_frame, 20);
}

void DiamondLinqSoftener::write_to_device_(const uint8_t *data, uint16_t length) {
  if (this->rx_handle_ == 0) {
    ESP_LOGW(TAG, "Cannot write - RX handle not set");
    return;
  }

  auto status = esp_ble_gattc_write_char(
      this->parent()->get_gattc_if(),
      this->parent()->get_conn_id(),
      this->rx_handle_,
      length,
      const_cast<uint8_t *>(data),
      ESP_GATT_WRITE_TYPE_NO_RSP,  // Write without response
      ESP_GATT_AUTH_REQ_NONE);

  if (status != ESP_OK) {
    ESP_LOGW(TAG, "Write failed: %d", status);
  }
}

void DiamondLinqSoftener::parse_tt_frame_(const uint8_t *data, uint16_t length) {
  if (length < 18) {
    ESP_LOGW(TAG, "tt frame too short: %d bytes", length);
    return;
  }

  // Parse F3 status field (bytes 6-7, little-endian)
  uint16_t f3_status = data[6] | (data[7] << 8);
  bool was_authenticated = this->authenticated_;
  this->authenticated_ = (f3_status & 0x8000) != 0;

  ESP_LOGI(TAG, "tt frame: F3=0x%04x, authenticated=%s", 
           f3_status, this->authenticated_ ? "YES" : "NO");

  // Extract serial number from bytes 14-17
  if (this->serial_sensor_ != nullptr) {
    char serial[9];
    snprintf(serial, sizeof(serial), "%02d%02d%02d%02d",
             data[14], data[15], data[16], data[17]);
    if (this->serial_number_ != serial) {
      this->serial_number_ = serial;
      this->serial_sensor_->publish_state(serial);
    }
  }

  // Parse flow rate from F6 (bytes 12-13, little-endian) - GPM * 100
  if (this->flow_sensor_ != nullptr) {
    uint16_t flow_raw = data[12] | (data[13] << 8);
    float flow_gpm = flow_raw / 100.0f;
    this->flow_sensor_->publish_state(flow_gpm);
  }

  // Update auth status if changed
  if (was_authenticated != this->authenticated_) {
    this->update_auth_status_();
  }

  // Just log auth status but don't require it for data access
  // Password only needed for WRITE operations
  ESP_LOGD(TAG, "tt frame parsed - auth status logged but not enforced for reads");
}

void DiamondLinqSoftener::parse_uu_frame_(const uint8_t *data, uint16_t length) {
  ESP_LOGI(TAG, "Received uu frame (%d bytes)", length);

  if (length < 18) {
    ESP_LOGW(TAG, "uu frame too short");
    return;
  }

  // Parse soft water remaining (bytes 4-5, little-endian)
  if (this->soft_remaining_sensor_ != nullptr) {
    uint16_t remaining = data[4] | (data[5] << 8);
    this->soft_remaining_sensor_->publish_state(remaining);
  }

  // Parse salt level percentage (byte 8)
  if (this->salt_level_sensor_ != nullptr) {
    this->salt_level_sensor_->publish_state(data[8]);
  }

  // Parse days to empty (byte 10)
  if (this->days_to_empty_sensor_ != nullptr) {
    this->days_to_empty_sensor_->publish_state(data[10]);
  }

  ESP_LOGD(TAG, "uu frame parsed successfully");
}

void DiamondLinqSoftener::parse_vv_frame_(const uint8_t *data, uint16_t length) {
  ESP_LOGI(TAG, "Received vv frame (%d bytes)", length);

  if (length < 18) {
    ESP_LOGW(TAG, "vv frame too short");
    return;
  }

  // Parse water hardness (byte 4)
  if (this->hardness_sensor_ != nullptr) {
    this->hardness_sensor_->publish_state(data[4]);
  }

  ESP_LOGD(TAG, "vv frame parsed successfully");
}

void DiamondLinqSoftener::update_auth_status_() {
  if (this->auth_status_sensor_ != nullptr) {
    this->auth_status_sensor_->publish_state(
        this->authenticated_ ? "Authenticated" : "Not Authenticated");
  }
}

}  // namespace diamond_linq_softener
}  // namespace esphome
