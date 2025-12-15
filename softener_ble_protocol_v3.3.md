# Water Softener BLE Protocol Analysis (v3.3)

## Overview
This document consolidates confirmed and newly discovered mappings of BLE data from the connected water softener. Version 3.3 includes verified daily usage counters, flow metrics, and updated notes on the "salt / tank geometry" configuration block (salt weight, tank width, max fill height).

---

## 1. Device and Environment
- **Device Type:** Water softener with Bluetooth control app (CS_Meter_Soft)
- **BLE Service:** Nordic UART Service (NUS)
- **Service UUIDs:**
  - Service: `6e400001-b5a3-f393-e0a9-e50e24dcca9e`
  - RX (write): `6e400002-b5a3-f393-e0a9-e50e24dcca9e`
  - TX (notify): `6e400003-b5a3-f393-e0a9-e50e24dcca9e`
- **Handles:**
  - TX Notifications: `0x000F`
  - RX Writes: `0x000D`

---

## 2. BLE Frame Types
| Frame | Header | Purpose | Notes |
|--------|--------|----------|--------|
| `tt` | `74 74` | Telemetry | High-frequency flow & heartbeat |
| `uu` | `75 75` | Usage statistics & config | Daily totals, soft remaining, regen counters, **salt/tank config (subtype 1)** |
| `vv` | `76 76` | Fixed configuration | Hardness, capacity, timers, dealer info (no salt/geometry here in current captures) |

All values are little-endian (least significant byte first).

---

## 3. `tt` Frame (Telemetry)
Real-time readings broadcast multiple times per second.

| Field | Bytes | Example | Description | Scaling | Status |
|--------|--------|----------|--------------|----------|----------|
| F1 | 00–01 | 256 | Session counter | — | Stable |
| F2 | 02–03 | 1024 | Configuration ID | — | Stable |
| F3 | 04–05 | 0x0037 / 0x8037 | Flag bits | Bit 15 toggles on flow start |
| F4 | 06–07 | 772 | Internal counter | — | Stable |
| F5 | 08–09 | 7936 → 8192 | Tick counter | +256 per cycle | ✅ Confirmed |
| **F6** | **0A–0B** | **0 → 1** | **Instantaneous Flow (GPM ×100)** | ÷100 | ✅ Confirmed (in captures with live flow) |
| F7 | 0C–0D | 0xXXXX | Timestamp/checksum | — | TBD |
| F8 | 0E–0F | 0x0039 | Record index | — | TBD |

---

## 4. `uu` Frame (Usage, Statistics, and Config)
`uu` frames carry both usage statistics and some configuration blocks. Different **subtypes** (first `uint16` after the `uu` header) correspond to different payload layouts.

### 4.1 Usage Subtype (Subtype = 0x0003)
Contains running totals and daily statistics.

Example transition (soft water remaining drop 449 → 448 gal):
```text
75 75 00 03 1F 01 07 00 00 01 C1 00 1C 02 3D 28 02 00 00 39
75 75 00 03 1F 01 07 00 00 01 C0 00 1C 02 3D 28 02 00 00 39
```

| Field | Bytes | Example | Meaning | Scaling | Confidence |
|--------|--------|----------|----------|----------|-------------|
| F1 | 00–01 | 0x0003 | Subtype (usage) | — | High |
| F2 | 02–03 | 0x011F | Status bitmask | — | Medium |
| **F3** | **04–05** | **0x0007 → 0x0009** | **Regen countdown/day index** | — | Medium |
| F4 | 06–07 | 0x0100 | Counter | — | Low |
| **F5** | **08–09** | **0x01C3 → 0x01BF** | **Soft Water Remaining (gallons)** | ×1 | ✅ Confirmed |
| **F6** | **0A–0B** | **0x021C → 0x021D** | **Average Daily Use (gal/day)** | ÷256 | ✅ Confirmed |
| **F7** | **0C–0D** | **0x283D → 0x2A3D** | **Treated Water Today (gallons)** | ÷256 | ✅ Confirmed |
| **F8** | **0E–0F** | **0x0002** | **Regeneration Time (2 AM)** | hours | ✅ Confirmed |
| F9 | 10–11 | 0x0039 | Record/checksum | — | Low |

### 4.2 Salt / Tank Geometry Config (Subtype = 0x0001)
Subtype **1** `uu` frames are 20 bytes long and carry a compact configuration block for:

- **Salt in Tank (lbs)**  
- **Tank width (16" / 18")**  
- **Max fill height (inches)**

These frames have the form:

```text
75 75 01 00 00 00 00 00 00 00 10 00 XX XX YY YY 0B 00 3A
         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ ^^^^^ ^^^^^
         fixed / unused / other fields   F7    F8   (F9 likely checksum)
```

Where:

- The leading bytes (`01 00 00 00 00 00 00 00 10 00`) are constant in all observed captures.
- The last two `uint16` fields (`F7`, `F8`) change **only when the app’s salt/width/height settings are changed**.
- Multiple controlled captures (weights 0, 66, 83, 116, 165, 215, 248, 363; widths 16/18; height ~36") show that:
  - `F7` and `F8` together encode the **triple (salt weight, tank width, max fill height)**.
  - Each salt update sent by the app produces a `uu`-style write command to RX and a new steady-state subtype-1 `uu` frame with updated `F7`/`F8`.

**Current state of decoding (December 2025):**

- We can say with high confidence that:
  - **`uu`, subtype 1 is the salt / tank geometry config block.**
  - **`F7` and `F8` (the last two 16‑bit values) encode salt lbs, tank width, and max fill height.**
  - The exact formulas for converting raw values to human-readable units (lbs/inches) are still being refined; multiple hex patterns correspond to known UI combinations, but the relationship is non-trivial and appears to mix multiple parameters in these fields.
- For integration purposes, these can be exposed as **raw config sensors** (e.g. `salt_config_f7`, `salt_config_f8`) until the final mapping is pinned down.

Example subtype‑1 payload variants observed (from several traces):

```text
# 18" width, 36" height, various salt weights (examples)
75 75 01 00 00 00 00 00 00 00 10 00 00 05 03 10 21 0B 00 3A
75 75 01 00 00 00 00 00 00 00 10 00 00 07 04 12 20 0B 00 3A
75 75 01 00 00 00 00 00 00 00 10 00 00 07 04 12 24 0B 00 3A

# 16" width, 36" height, different salt weights (examples)
75 75 01 00 00 00 00 00 00 00 10 00 00 08 04 12 24 0B 00 3A
75 75 01 00 00 00 00 00 00 00 10 00 00 16 04 12 24 0B 00 3A
75 75 01 00 00 00 00 00 00 00 10 00 00 0A 04 12 24 0B 00 3A
```

In all of these, only the `F7`/`F8` values change when the user edits salt weight and/or tank geometry in the app.

---

## 5. `vv` Frame (Fixed Configuration)
`vv` frames include fixed parameters that persist across devices and app sessions. In the current captures they are primarily used for **cycle timing and basic installation parameters**, not for salt/geometry.

| Parameter | Example | Type | Description |
|------------|-----------|--------|-------------|
| Firmware version | `43 34 2E 33 37` → C4.37 | ASCII | Matches app |
| Water hardness | `28 00` → 40 | int16 | grains per gallon |
| Reserve capacity | `0A 00` → 10 | int16 | percent |
| Resin capacity | `25 00` → 36,000 | int16 | grains |
| Backwash / Rinse / Fill | `0A 00`, `3C 00`, `08 00`, `0B 00` | int16 | minutes |
| Brine fill mode | `50 6F 73 74` → "Post" | ASCII | mode |
| Display state (in commands) | `47 00` / `47 01` | int8 | ON/OFF toggle when used in write frames |

In several captures, periodic `vv` notifications take the form:

```text
76 76 00 00 00 0A 00 24 0A 00 00 00 00 03 10 02 00 00 00 42
76 76 01 0A 3C 08 0B 00 00 00 00 00 00 00 00 00 00 00 00 43
```

Those match the backwash/slow rinse/rapid rinse/fill durations and related static config.

Salt weight and tank geometry have **not** been observed in any `vv` payload in the current log set; they live in `uu` subtype‑1 instead.

---

## 6. Control Commands (Handle 0x000D)

### 6.1 Display ON/OFF

| Command | Example Bytes | Action |
|----------|----------------|--------|
| Display OFF | `76 76 ... 47 01 ...` | Turns front panel off |
| Display ON | `76 76 ... 47 00 ...` | Turns front panel on |

These appear as **write commands** (`0x52`) to handle `0x000D` with a 20‑byte payload dominated by `0x76` (`'v'`) bytes, with the single `0x47 0x01` or `0x47 0x00` byte pair differentiating OFF vs ON.

### 6.2 Salt / Tank Config Set (Weight, Width, Height)

Salt and tank-geometry configuration writes use a **`uu`-style padded frame** as a write command to RX (`0x000D`). The pattern is:

```text
52 0D 00 75 75 75 75 75 75 75 75 75 75 75 75 75 53 XX YY ZZ WW 75 75
                  ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^   ^^^^^^^^
                  padding of 0x75 ('u') bytes     encoded config
```

Where:

- The payload after the handle (`0x0D 0x00`) is 20 bytes.
- The **leading 13 bytes** are usually all `0x75` (ASCII `u`), acting as padding/marker.
- The next 5 bytes (`53 XX YY ZZ WW`) encode salt/width/height in the same format used by the `uu` subtype‑1 `F7`/`F8` fields.
- The last two bytes are `0x75 0x75` padding.

Each of these writes is immediately followed (or shortly thereafter) by a stable new `uu` subtype‑1 frame whose `F7`/`F8` fields reflect the new configuration.

**Status:** The exact bit/field mapping between (`XX`, `YY`, `ZZ`, `WW`) and (salt lbs, width, height) is still being finalized, but the command structure and the fact that this write updates those settings are now confirmed by multiple traces.

---

## 7. Field Confidence Matrix

| Frame | Field | Metric | Unit | Confidence | Notes |
|--------|--------|---------|------|-------------|--------|
| tt | F6 | Instantaneous Flow | GPM | ✅ High | Matches flow activity |
| uu (subtype 0x0003) | F5 | Soft Remaining | Gallons | ✅ High | Matches 449→448 |
| uu (subtype 0x0003) | F6 | Average Daily Use | Gallons | ✅ High | ÷256 scaling |
| uu (subtype 0x0003) | F7 | Treated Today | Gallons | ✅ High | ÷256 scaling |
| uu (subtype 0x0003) | F3 | Regen Countdown | days | 🟡 Medium | Needs regen capture |
| uu (subtype 0x0003) | F8 | Regeneration Time | hours | 🟢 High | Always 2 AM |
| uu (subtype 0x0001) | F7/F8 | Salt / Width / Height config | raw | 🟡 Medium | Clearly correlated to UI, exact formulas TBD |
| vv | Cycle Timers / Hardness / Capacity | minutes / gpg / grains | 🟢 High | Static config, matches app |

---

## 8. Future Investigation: Salt / Geometry Mapping

To fully decode the salt/width/height encoding in `uu` subtype‑1 and the `53 XX YY ZZ WW` write payloads:

1. Capture short sessions where **only one parameter is changed at a time** while logging:
   - Salt weight (lbs)
   - Tank width (16" / 18")
   - Max fill height (inches)
2. For each change, record:
   - The `uu` subtype‑1 `F7`/`F8` values before and after.
   - The exact `53 XX YY ZZ WW` sequence in the corresponding RX write.
3. Fit formulas that map these raw values to:
   - `salt_lbs`
   - `tank_width_in`
   - `max_fill_height_in`
4. Update this document to promote these fields from "raw config" to fully decoded units and incorporate them as first‑class sensors in the Home Assistant integration.

---

## 9. Integration Notes (Home Assistant / ESP32)

| Sensor | Frame | Field | Conversion |
|---------|--------|--------|-------------|
| Current Flow | `tt` | F6 | value / 100 |
| Soft Remaining | `uu` (subtype 0x0003) | F5 | value |
| Treated Today | `uu` (subtype 0x0003) | F7 | value / 256 |
| Average Use | `uu` (subtype 0x0003) | F6 | value / 256 |
| Regen Time | `uu` (subtype 0x0003) | F8 | value (hours) |
| Salt/Width/Height (raw) | `uu` (subtype 0x0001) | F7/F8 | expose as raw config sensors |

Pending sensors (after further mapping): Regen Countdown (friendly), fully decoded Salt Weight (lbs), Tank Width (in), Max Fill Height (in), and derived alerts (e.g., low salt).

---

*Document generated from BLE capture analysis — December 2025 (v3.3, updated with salt/tank config block findings).*