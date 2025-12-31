# Diamond Linq Softener - ESPHome Integration Status

**Last Updated:** December 31, 2025

## Summary

This document tracks the development of a native ESPHome component for the Diamond Linq water softener, after the HACS Home Assistant integration failed to authenticate through the BLE proxy.

## Background

### Original Approach: HACS Integration
- Created a Home Assistant custom component using `bleak` BLE library
- Integration worked locally but failed when deployed through ESPHome BLE Proxy
- **Root Cause:** The BLE proxy layer appears incompatible with the PA authentication protocol
- Tested 7+ different authentication approaches - all rejected by the softener when going through proxy

### Current Approach: Native ESPHome Component
- Bypasses Home Assistant's BLE proxy entirely
- Runs directly on ESP32 using native ESP-IDF BLE stack
- Component hosted on GitHub for ESPHome's `external_components` feature

## Device Information

| Property | Value |
|----------|-------|
| Device Name | CS_Meter_Soft |
| MAC Address | F1:01:E7:C8:D2:C8 |
| Serial Number | 00416327 |
| BLE Service | Nordic UART Service (NUS) |
| Service UUID | 6e400001-b5a3-f393-e0a9-e50e24dcca9e |
| RX Characteristic (write) | 6e400002-b5a3-f393-e0a9-e50e24dcca9e |
| TX Characteristic (notify) | 6e400003-b5a3-f393-e0a9-e50e24dcca9e |

## BLE Protocol

### Authentication (PA Frame)
- 20 bytes: `0x74 0x74 0x50 0x41` + 16 random bytes
- Must be sent before data requests
- Response: tt frame with F3 status bit 15 set (authenticated)

### Data Frames
| Frame | Prefix | Contains |
|-------|--------|----------|
| tt | 0x74 0x74 | Auth status (F3), serial number, flow rate |
| uu | 0x75 0x75 | Soft water remaining, hardness |
| vv | 0x76 0x76 | Salt level, days to empty |

## Current Status

### ✅ Completed
- [x] ESPHome component created (Python config + C++ implementation)
- [x] Component pushed to GitHub: `https://github.com/phurth/diamond_linq_softener`
- [x] Fixed C++ compile errors (espbt namespace, address_str())
- [x] Fixed Python deprecated imports
- [x] Local ESPHome build environment set up (`/tmp/esphome_build` with Python 3.12 venv)
- [x] Firmware compiled successfully (ESPHome 2025.12.3, esp-idf framework)
- [x] Firmware uploaded via OTA to ESP32 at 192.168.1.171
- [x] BLE connection ESTABLISHED to softener
- [x] Set node_state to ESTABLISHED properly
- [x] PA authentication implemented and tested
- [x] PW (password) authentication implemented and tested

### 🔄 In Progress
- [ ] **BLOCKED**: Need to remove device password via mobile app

### ❌ Pending
- [ ] Confirm tt/uu/vv frame parsing works
- [ ] Verify sensor values populate in Home Assistant
- [ ] Long-term stability testing

## Current Issue

**Update: December 31, 2025 - 15:20**

Authentication is being **rejected by the device**. Both PA and PW authentication methods have been implemented and tested:

1. **PA Frame (Random Token)**: `74 74 50 41` + 16 random bytes - **REJECTED**
2. **PW Frame (Password)**: `74 74...74 74 50 57 01 02 03 04 74 74` (password "1234" in BCD) - **REJECTED**

ESP32 log evidence:
```
[15:18:28.663] Sending PA frame: 74.74.50.41.CD.4C.71.D2.47.F6.42.53.2B.88.24.A0.27.85.D2.DE
[15:18:28.778] tt frame: F3=0x0038, authenticated=NO
[15:18:28.783] PA authentication FAILED - trying PW format with password
[15:18:28.859] Sending PW frame (password=1234): 74.74.74.74.74.74.74.74.74.74.74.74.50.57.01.02.03.04.74.74
[15:18:28.997] tt frame: F3=0x0038, authenticated=NO
[15:18:29.002] PW authentication FAILED - giving up
```

**Root Cause**: The device had a password set via the mobile app. Analysis of old BLE traces shows PA authentication only worked BEFORE the password was set. Once password "1234" was configured, the same PA frames that previously worked are now rejected.

**Solution Required**: Remove the password from the device using the Diamond Linq mobile app. The app has a password setting that appears to enable a protection mode we haven't fully reverse-engineered. Without mobile app access to disable this, authentication will continue to fail.

## Key Files

### ESPHome Component (GitHub repo)
```
components/diamond_linq_softener/
├── __init__.py          # Python config schema, sensor definitions
├── diamond_linq_softener.h    # C++ header, NUS UUIDs, class definition
└── diamond_linq_softener.cpp  # Implementation: PA auth, frame parsing
```

### Local Build Environment
```
/tmp/esphome_build/
├── venv/                # Python 3.12 virtual environment
├── test-config.yaml     # Working ESPHome config
└── .esphome/           # Build cache
```

### ESPHome Configuration
- **Test config:** `/tmp/esphome_build/test-config.yaml`
- **HA config:** `/Volumes/config/esphome/esphome-web-f87b04.yaml`

## Network Configuration

| Setting | Value |
|---------|-------|
| WiFi SSID | kitihausu |
| WiFi Password | !kb9rem! |
| Static IP | 192.168.1.171 |
| Gateway | 192.168.1.1 |
| Subnet | 255.255.255.0 |
| Hostname | bt-proxy-freezers |

## Build Commands

```bash
# Activate build environment
cd /tmp/esphome_build
source venv/bin/activate

# Compile firmware
./venv/bin/esphome compile test-config.yaml

# Upload via OTA
./venv/bin/esphome upload test-config.yaml --device 192.168.1.171

# View logs
./venv/bin/esphome logs test-config.yaml --device 192.168.1.171
```

## Lessons Learned

1. **BLE Proxy Limitation:** Home Assistant's BLE proxy (via ESPHome) doesn't work well with Nordic UART Service authentication protocols. Native ESP32 BLE is required.

2. **WiFi Credentials:** Always verify WiFi credentials before OTA upload - placeholder values will brick the device off the network (requires USB recovery).

3. **ESPHome Sensor Structure:** Component sensors must be defined inline within the component's CONFIG_SCHEMA, not as separate `sensor:` platform entries.

4. **Python Version:** ESPHome 2025.12.3 requires Python 3.12 (3.14 is incompatible).

## Next Steps

1. **Debug connection timing** - Add more logging to track when `node_state` transitions to ESTABLISHED vs when `update()` is called

2. **Verify service discovery** - Ensure RX/TX handles are found before attempting writes

3. **Test PA authentication** - Once timing is fixed, verify the softener accepts our PA frame

4. **Parse response frames** - Confirm tt/uu/vv parsing extracts correct sensor values

## References

- [BLE Protocol Documentation](softener_ble_protocol_v3.3.md)
- [Android App Decompiled Sources](android_app_code/DIAMOND-LINQ_3.0.2/)
- [BLE Packet Traces](traces/)
- [GitHub Repository](https://github.com/phurth/diamond_linq_softener)
