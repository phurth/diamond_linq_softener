# Diamond Linq Water Softener - ESPHome Component

This ESPHome component provides **native BLE communication** with Diamond Linq water softeners, bypassing the limitations of BLE proxy-based solutions.

## Why ESPHome?

The Home Assistant HACS integration relies on BLE proxies to communicate with the water softener. However, the PA authentication protocol appears to be incompatible with the proxy layer, causing authentication to fail consistently.

By running ESPHome directly on an ESP32 near the water softener, we get:
- **Direct BLE communication** - no proxy layer
- **Native ESP-IDF BLE stack** - full control over BLE operations
- **Reliable authentication** - the same method that works on Android phones
- **Lower latency** - faster response times

## Installation

### Method 1: External Components (Recommended)

Add this to your ESPHome configuration:

```yaml
external_components:
  - source:
      type: git
      url: https://github.com/phurth/diamond_linq_softener
      ref: master
    components: [diamond_linq_softener]
    refresh: 1d
```

### Method 2: Local Installation

Copy the `esphome/components/diamond_linq_softener/` folder to your ESPHome `custom_components/` directory.

## Configuration

```yaml
esp32_ble_tracker:
  scan_parameters:
    active: true

ble_client:
  - mac_address: "F1:01:E7:C8:D2:C8"  # Your softener's MAC
    id: softener_ble_client

diamond_linq_softener:
  ble_client_id: softener_ble_client
  password: "1234"  # Device password (default is 1234)
  update_interval: 60s
  
  flow_rate:
    name: "Water Softener Flow Rate"
    
  soft_remaining:
    name: "Soft Water Remaining"
    
  hardness:
    name: "Water Hardness"
    
  salt_level:
    name: "Salt Level"
    
  days_to_empty:
    name: "Days to Empty"
    
  serial_number:
    name: "Serial Number"
    
  auth_status:
    name: "Auth Status"
```

## Finding Your MAC Address

1. Open the Diamond Linq app on your phone
2. The app displays the device name (e.g., "CS_Meter_Soft")
3. Use an app like "nRF Connect" to scan for BLE devices
4. Find the device with that name and note its MAC address

Or check your ESPHome logs - the BLE tracker will show discovered devices.

## Sensors

| Sensor | Unit | Description |
|--------|------|-------------|
| `flow_rate` | GPM | Current water flow rate |
| `soft_remaining` | gallons | Estimated soft water remaining before regeneration |
| `hardness` | gpg | Configured water hardness (grains per gallon) |
| `salt_level` | % | Salt tank level percentage |
| `days_to_empty` | days | Estimated days until salt runs out |
| `serial_number` | text | Device serial number |
| `auth_status` | text | "Authenticated" or "Not Authenticated" |

## Troubleshooting

### Authentication Fails

1. Ensure you're using the correct password (default: "1234")
2. Make sure no other device is connected to the softener
3. Check that the ESP32 is close enough to the softener (BLE range is ~30 feet)
4. Look at the ESPHome logs for detailed error messages

### No Data Received

1. Verify the MAC address is correct
2. Check that `esp32_ble_tracker` is configured
3. Ensure notifications are being received (check logs for "RX" messages)

### Device Not Found

1. The softener advertises as "CS_Meter_Soft"
2. Make sure Bluetooth is enabled on the softener
3. Power cycle the softener to restart BLE advertising

## Protocol Details

The Diamond Linq uses Nordic UART Service (NUS) for BLE communication:
- Service UUID: `6e400001-b5a3-f393-e0a9-e50e24dcca9e`
- RX (write): `6e400002-b5a3-f393-e0a9-e50e24dcca9e`
- TX (notify): `6e400003-b5a3-f393-e0a9-e50e24dcca9e`

Authentication uses a PA frame with random 16-byte token.

## License

MIT License - See LICENSE file for details.

## Contributing

Issues and pull requests welcome at: https://github.com/phurth/diamond_linq_softener
