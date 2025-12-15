# Water Softener BLE Protocol Analysis (v3.1)

## Overview
This document details the decoded Bluetooth Low Energy (BLE) protocol for the connected water softener system. Version 3.1 consolidates verified mappings obtained from multiple BLE captures, including static configuration, telemetry during idle and active flow, and field correlations observed in real-time.

---

## 1. Device and Environment
- **Device Type:** Water softener with Bluetooth control app (CS_Meter_Soft)
- **BLE Service Type:** Nordic UART Service (NUS)
- **Connection Duration:** typically 3–4 minutes per session
- **Service UUIDs:**
  - `6e400001-b5a3-f393-e0a9-e50e24dcca9e` — NUS Service
  - `6e400002-b5a3-f393-e0a9-e50e24dcca9e` — RX (write)
  - `6e400003-b5a3-f393-e0a9-e50e24dcca9e` — TX (notify)
- **Handles:**
  - TX (notifications): `0x000F`
  - RX (write): `0x000D`

---

## 2. BLE Frame Types
Three distinct notification families are observed from handle `0x000F`:

| Frame | Header | Length | Purpose |
|--------|----------|----------|----------|
| `tt` | `74 74` | 18 bytes | Telemetry (real-time data) |
| `uu` | `75 75` | 20 bytes | Usage and daily statistics |
| `vv` | `76 76` | 20 bytes | Static configuration and status |

All frames use little-endian 16-bit fields unless otherwise stated.

---

## 3. `tt` Frame (Telemetry)
**Structure:**  `74 74` + 8x `uint16_le`

| Field | Bytes | Example | Meaning | Notes |
|--------|--------|---------|----------|--------|
| F1 | 00–01 | 256 | Session counter | Constant within session |
| F2 | 02–03 | 1024 | Fixed | Session/config constant |
| F3 | 04–05 | 0x0037 / 0x8037 | Flagged counter | Bit 15 = state flag |
| F4 | 06–07 | 772 | Internal index | Stable |
| F5 | 08–09 | 7936→8192 | Incrementing tick | +256 per cycle |
| **F6** | **0A–0B** | **0 → 1** | **Current Flow (GPM × 100)** | Verified by flowing capture |
| F7 | 0C–0D | 25409 | Timestamp / checksum | TBD |
| F8 | 0E–0F | 39 | Day index / record counter | TBD |

---

## 4. `uu` Frame (Usage and Daily Statistics)
**Structure:**  `75 75` + 9x `uint16_le`

Example (Soft Remaining 449 gal):
```
75 75 00 03 1F 01 07 00 00 01 C1 00 1C 02 3D 28 02 00 00 39
```
Subsequent frame (Soft Remaining 448 gal):
```
75 75 00 03 1F 01 07 00 00 01 C0 00 1C 02 3D 28 02 00 00 39
```

| Field | Bytes | Example | Meaning | Notes |
|--------|--------|----------|----------|--------|
| F1 | 00–01 | 3 | Record subtype | Frame index |
| F2 | 02–03 | 0x011F | Status code | TBD |
| F3 | 04–05 | 0x0007 | Cycle / regen day | TBD |
| F4 | 06–07 | 0x0100 | Counter | TBD |
| **F5** | **08–09** | **0x01C1 → 0x01C0** | **Soft Water Remaining (gallons)** | **Confirmed, 1:1 scaling** |
| F6 | 0A–0B | 0x021C | Possibly hardness or capacity per regen | TBD |
| F7 | 0C–0D | 0x283D | Usage total or average | TBD |
| F8 | 0E–0F | 0x0002 | Regen hour (2 AM) | Consistent with config |
| F9 | 10–11 | 0x0039 | Record ID / checksum | TBD |

---

## 5. `vv` Frame (Static Configuration)
Static configuration includes ASCII text for firmware and dealer information followed by numeric settings.

| Parameter | Example | Decoded | Notes |
|------------|-----------|----------|--------|
| Firmware version | `43 34 2E 33 37` | **C4.37** | Matches app display |
| Dealer name | `Albiero Plumbing` | **Albiero Plumbing** | ASCII string |
| Dealer phone | `2623345000` | Digits in ASCII |  |
| Dealer address | `1940 North Main St.` | ASCII |  |
| Dealer web | `https://albieroplumbing.com` | ASCII |  |
| Water hardness | `28 00` | 40 GPG | 16-bit int |
| Reserve capacity | `0A 00` | 10% | 16-bit int |
| Resin capacity | `25 00` | 36,000 grains | 16-bit int |
| Backwash / Rinse times | `0A 00` / `3C 00` / `08 00` / `0B 00` | 10 / 60 / 8 / 11 min | |
| Brine fill mode | `50 6F 73 74` | "Post" | Indicates post-fill |
| Display state | `47 00` / `47 01` | ON/OFF | Control command confirmed |

---

## 6. Field Confidence Matrix
| Frame | Field | Metric | Unit | Confidence | Notes |
|--------|--------|---------|------|-------------|--------|
| tt | F1 | Session counter | n/a | 🟢 High | Stable across sessions |
| tt | F2 | Config constant | n/a | 🟢 High | Static |
| tt | F3 | Status flag / bitfield | n/a | 🟡 Medium | Bit 15 toggles |
| tt | F4 | Internal counter | n/a | 🟡 Medium | Constant 772 |
| tt | F5 | Tick counter | n/a | 🟡 Medium | Increments by 256 |
| **tt | F6 | Current flow** | **GPM ×100** | 🟢 Confirmed | Verified via flow test |
| tt | F7 | Timestamp / checksum | n/a | ⚪ Low | TBD |
| tt | F8 | Day index / record ID | n/a | ⚪ Low | TBD |
| uu | F5 | Soft Water Remaining | Gallons | 🟢 Confirmed | Matches 449→448 transition |
| uu | F6 | Hardness or regen capacity | TBD | ⚪ Low | Needs change test |
| uu | F7 | Usage total / average | TBD | ⚪ Low | Awaiting treated-today increment |
| vv | Static config (multiple) | ASCII / int | 🟢 Confirmed | All verified static fields |

---

*Document generated from BLE capture analysis — December 2025 (v3.1).*