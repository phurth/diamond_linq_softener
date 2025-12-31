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

### 🔄 In Progress
- [ ] Waiting for authentication sequence to trigger
- [ ] Need to verify PA frame is accepted by softener

### ❌ Pending
- [ ] Confirm tt/uu/vv frame parsing works
- [ ] Verify sensor values populate in Home Assistant
- [ ] Long-term stability testing

## Current Issue

The logs show:
```
[14:46:16.872][W][diamond_linq_softener:034]: Not connected to device, skipping update
```

This occurs when `update()` is called by the 60-second polling interval. The BLE client shows "ESTABLISHED" in config dump, but the `update()` check finds the connection not ready. This may be a timing issue where:
1. Connection is established
2. Service discovery is in progress
3. `update()` is called before characteristics are discovered
4. `rx_handle_` is still 0, or `node_state` not yet ESTABLISHED

The component does have an "initial_poll" timeout that should trigger after notifications are registered, but we haven't seen logs showing that sequence completing.

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
