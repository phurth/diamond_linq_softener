# Water Softener BLE Protocol Analysis

## Overview
This document summarizes the findings from analysis of the captured Bluetooth Low Energy (BLE) traffic between the softener's Android app and the water softener unit. The purpose of this analysis is to document communication characteristics, data structures, and known control/telemetry mappings that will support future integration projects (e.g., Home Assistant BLE sensors).

---

## 1. Device and Environment
- **Device Type:** Water softener with Bluetooth control app
- **BLE Service Type:** Nordic UART Service (NUS)
- **Connection Duration:** ~3–4 minutes
- **Source File:** `btsnoop_hci.log` (311 KB)
- **Connected Peripheral MAC:** `F1:01:E7:C8:D2:C8`
- **Characteristic Handles:**
  - TX (notifications): `0x000F`
  - RX (write): `0x000D`
- **Service UUIDs:**
  - `6e400001-b5a3-f393-e0a9-e50e24dcca9e` — NUS service
  - `6e400002-b5a3-f393-e0a9-e50e24dcca9e` — RX (write)
  - `6e400003-b5a3-f393-e0a9-e50e24dcca9e` — TX (notify)

---

## 2. BLE Communication Flow

### 2.1 Sequence Summary
| Phase | Activity | Description |
|--------|-----------|--------------|
| 1 | Advertising & Connection | Single connection established at ~38s into log |
| 2 | Service Discovery | Exchange MTU and discovery of characteristics |
| 3 | Authentication / Handshake | Repeated `t...`, `u...`, and `v...` write frames (keepalive/auth) |
| 4 | Configuration Readout | Burst of 15–20 notification packets containing static text and configuration values |
| 5 | Control Commands | Two unique writes corresponding to display ON/OFF toggles |
| 6 | Disconnect | Session ends normally |

### 2.2 Characteristic Usage
| Characteristic | Handle | Direction | Purpose |
|----------------|---------|------------|----------|
| RX | 0x000D | Central → Peripheral | Commands and keepalives |
| TX | 0x000F | Peripheral → Central | Telemetry, configuration, responses |

---

## 3. Static Configuration Data

The configuration burst contains both ASCII strings and numeric values (16-bit little endian). Notable identifiable segments include:

| Field | Example Bytes | Decoded Value | Notes |
|--------|----------------|----------------|--------|
| Firmware version | `43 34 2E 33 37` | **C4.37** | Matches app display |
| Dealer name | `41 6C 62 69 65 72 6F` | **Albiero** | Text block with following digits 2623345000 |
| Dealer phone | `32 36 32 33 33 34 35 30 30 30` | **2623345000** | ASCII digits |
| Dealer web | `68 74 74 70 73 ... 63 6F 6D` | **https://albieroplumbing.com** | Full URL present |
| Water hardness | `28 00` | **40 GPG** | 16-bit LE integer |
| Regen time | `02 00 00 00` | **2:00 AM** | Hour=2, Minute=0 |
| Reserve capacity | `0A 00` | **10%** | 16-bit LE integer |
| Resin capacity | `25 00` | **36000–37000 grains** | Value aligns with app data |
| Backwash duration | `0A 00` | **10 min** | |
| Brine draw / slow rinse | `3C 00` | **60 min** | |
| Rapid rinse | `08 00` | **8 min** | |
| Brine refill | `0B 00` | **11 min** | |
| Brine prefill mode | `50 6F 73 74` | **Post** | Indicates post-fill operation |
| Display state | `47 00` / `47 01` | **Display ON/OFF** | From control commands |

### ASCII Segment (Excerpt)
```
...43 34 2E 33 37 00 41 6C 62 69 65 72 6F 20 50 6C 75 6D 62 69 6E 67 20 32 36 32 33 33 34 35 30 30 30 00 68 74 74 70 73 3A 2F 2F 61 6C 62 69 65 72 6F 70 6C 75 6D 62 69 6E 67 2E 63 6F 6D 00...
```
This decodes directly to:
```
C4.37 Albiero Plumbing 2623345000 https://albieroplumbing.com
```

---

## 4. Control Command Mapping

During testing, two distinct write commands were recorded to handle `0x000D`:

| Timestamp (s) | Command Bytes | Interpretation |
|----------------|----------------|----------------|
| ~71.9 | `76 76 76 76 76 76 76 76 76 76 76 76 76 47 01 76 76 76 76 76` | Display OFF |
| ~75.1 | `76 76 76 76 76 76 76 76 76 76 76 76 76 47 00 76 76 76 76 76` | Display ON |

Both are 20-byte frames written to the NUS RX characteristic. The difference is only a single byte: `0x01` vs `0x00` following ASCII `G`.

---

## 5. Dynamic Telemetry Frames

Telemetry appears to be transmitted continuously as notifications (opcodes `0x1B`) from handle `0x000F`. Three frame types were identified by their ASCII headers:

| Header | Example | Likely Content |
|---------|----------|----------------|
| `tt` | `74 74 00 01 00 04 37 00 ...` | Real-time telemetry (flow rate, gallons, salt remaining) |
| `uu` | `75 75 00 07 19 01 08 00 ...` | Usage statistics (daily totals, averages) |
| `vv` | `76 76 00 00 ...` | Configuration/status frames (sent after connect) |

Each frame is typically 18–20 bytes long, structured as small integers. Decoding will require cross-correlation with app values at capture time.

---

## 6. Integration Recommendations

### For Home Assistant (HA) / ESP32
- Use ESP32 or similar BLE-capable MCU as central client.
- Discover NUS service and subscribe to TX characteristic (`6e400003...`).
- Decode notifications based on header (`tt`, `uu`, `vv`).
- For controls, send 20-byte write to RX characteristic (`6e400002...`).
- Implement basic keepalive (periodic `t...` or `u...` frame writes) to maintain connection.

### Suggested Sensors
| Sensor | Source Frame | Notes |
|---------|---------------|-------|
| Flow rate (GPM) | `tt` | Small changing integer (×0.1 scaling) |
| Daily usage (GAL) | `uu` | Incremental counter |
| Salt remaining | `uu` or `vv` | 16-bit integer |
| Water hardness | `vv` | Static 16-bit integer |
| Regen schedule | `vv` | Hour/min pair |
| Display switch | RX write | `G\x00` = on, `G\x01` = off |

---

## 7. Next Capture Template
To refine mapping of telemetry values, capture additional BLE sessions while recording app readings. The table below provides a standardized format for correlation.

### Capture Procedure
1. Enable **Bluetooth HCI snoop log** and start capture.
2. Open the softener app and ensure connection.
3. Record the values shown in the app at 15-second intervals.
4. Save and label the log with approximate timestamps.

### Data Recording Template
| Timestamp | App Field | Displayed Value | Notes |
|------------|------------|----------------|--------|
| 00:00 | Peak Flow Today | 3 GPM |  |
| 00:00 | Treated Water Usage Today | 33 GAL |  |
| 00:00 | Soft Water Remaining | 482 |  |
| 00:00 | Current Water Flow | 0.0 GPM |  |
| 00:00 | Days Until Regeneration | 0 |  |
| 00:00 | Ave Water Usage Per Day | 82 GAL |  |
| 00:00 | Regeneration Time | 2:00 AM |  |
| 00:00 | Firmware Version | C4.37 |  |
| 00:00 | Dealer Name | Albiero Plumbing |  |
| 00:00 | Phone | 2623345000 |  |
| 00:00 | Address | 1940 North Main St. |  |
| 00:00 | Web | https://albieroplumbing.com |  |

During analysis, correlate changing binary fields in the `tt` and `uu` frames with these recorded values.

---

## 8. Summary of Key Findings
- The softener communicates via **Nordic UART Service**.
- Static configuration and dealer data are transmitted as mixed ASCII and numeric payloads.
- Display control confirmed via single-byte toggle (`G 00` / `G 01`).
- Dynamic telemetry frames (`tt`, `uu`, `vv`) likely contain flow, usage, and status data.
- BLE protocol is straightforward to reproduce for local integration projects.

---

*Document generated from BLE capture analysis — December 2025.*
