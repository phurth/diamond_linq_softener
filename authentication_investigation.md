# Diamond Linq Water Softener - Authentication Investigation

## Date: December 30, 2025

## Overview

This document captures the findings from attempting to implement BLE authentication for the Diamond Linq water softener Home Assistant integration. The device uses Nordic UART Service (NUS) for communication, and while we can successfully connect and receive `tt` (telemetry) frames, authentication is not being accepted by the device, preventing access to `uu` (usage) and `vv` (configuration) frames.

---

## Device Information

- **Device Name:** CS_Meter_Soft
- **MAC Address:** F1:01:E7:C8:D2:C8
- **Serial Number:** 00416327 (extracted from tt frames)
- **BLE Service:** Nordic UART Service (NUS)
  - Service UUID: `6e400001-b5a3-f393-e0a9-e50e24dcca9e`
  - RX (write): `6e400002-b5a3-f393-e0a9-e50e24dcca9e`
  - TX (notify): `6e400003-b5a3-f393-e0a9-e50e24dcca9e`

---

## Frame Types

| Frame | Header | Purpose | Auth Required |
|-------|--------|---------|---------------|
| `tt` | `74 74` | Telemetry (flow, heartbeat) | No |
| `uu` | `75 75` | Usage statistics, salt config | **Yes** |
| `vv` | `76 76` | Fixed configuration | **Yes** |

---

## Current Behavior

### What Works
- BLE connection establishes successfully
- Subscription to TX notifications works
- `tt` frames are received consistently
- Flow data (0.00 GPM) is parsed correctly

### What Doesn't Work
- Authentication is not being accepted
- `uu` and `vv` requests return no data
- F3 field in tt response stays at `0x0038` (bit 15 NOT set)

### Authentication Indicator
The F3 field (bytes 4-5) in tt frames indicates authentication status:
- `0x0038` or `0x0037` = Not authenticated (bit 15 = 0)
- `0x8038` or `0x8037` = Authenticated (bit 15 = 1)

Current device response: `F3=0x0038` (never changes to 0x80XX)

---

## Authentication Attempts

### Attempt 1: PA Frame with Random Token
**Based on:** BLE trace analysis showing `ttPA` + 16 random bytes

**Frame format:**
```
Bytes 0-1:  0x74 0x74  ("tt")
Bytes 2-3:  0x50 0x41  ("PA")
Bytes 4-19: 16 random bytes
```

**Example sent:** `747450412ecb1a43d7a4ba8ea822358f6cf58def`

**Result:** ❌ F3 stays at 0x0038

---

### Attempt 2: PW Frame with BCD Password
**Based on:** G.java analysis from decompiled Android app

**Frame format:**
```
Bytes 0-11:  0x74 padding (12 bytes)
Bytes 12-13: 0x50 0x57  ("PW")
Bytes 14-17: Password as BCD digits (1,2,3,4 → 0x01,0x02,0x03,0x04)
Bytes 18-19: 0x74 padding
```

**Example sent:** `7474747474747474747474745057010203047474`

**Result:** ❌ F3 stays at 0x0038

---

### Attempt 3: PW Frame with ASCII Password
**Based on:** Alternative interpretation of password encoding

**Frame format:**
```
Bytes 0-11:  0x74 padding (12 bytes)
Bytes 12-13: 0x50 0x57  ("PW")
Bytes 14-17: Password as ASCII ('1','2','3','4' → 0x31,0x32,0x33,0x34)
Bytes 18-19: 0x74 padding
```

**Example sent:** `7474747474747474747474745057313233347474`

**Result:** ❌ F3 stays at 0x0038

---

### Attempt 4: PA Frame with ASCII Password
**Based on:** Simpler format attempt

**Frame format:**
```
Bytes 0-1:  0x74 0x74  ("tt")
Bytes 2-3:  0x50 0x41  ("PA")
Bytes 4-7:  Password as ASCII
Bytes 8-19: 0x74 padding
```

**Example sent:** `7474504131323334747474747474747474747474`

**Result:** ❌ F3 stays at 0x0038

---

### Variations Tested
- Write with response (`response=True`) vs write without response (`response=False`)
- Various delays after connection (0.5s settle time)
- Different auth sequence timings

**All attempts failed** - device ignores authentication frames.

---

## Working Trace Analysis

From trace file `BT_HCI_2025_1215_143443.cfa.curf`:

### Successful Auth Sequence (from trace)
1. **tt request sent:** `7474747474747474747474747474747474747474`
2. **tt response received:** F3 = 0x0037 (no auth)
3. **PA frame sent:** `747450 41 d9872479f3e0751cb76af9496b4c8d7c`
4. **tt response received:** F3 = 0x8037 (AUTH CONFIRMED!)

The trace shows authentication **worked** with a random 16-byte token. The key observation:
- Before PA: F3 = 0x0037
- After PA: F3 = 0x8037 (bit 15 set)

### Key Difference
The trace was captured **before** any password was set on the device. After the user set password "1234" via the app, the same PA frame format no longer works.

---

## Hypothesis: Password-Protected Mode

When no password is set:
- Device accepts any PA frame with random token
- This is what the old traces show

When password IS set (current state):
- Device requires actual password validation
- The exact format for password submission is unknown
- Neither PW nor PA frame formats we've tried work

---

## Android App Code Analysis

### From G.java (Password Frame Builder)
```java
// Builds PW frame at positions 12-17
j.f[12] = (byte) 80;  // 'P'
j.f[13] = (byte) 87;  // 'W'
// Password digits at positions 14-17 as integer values (BCD)
```

### From e.java (TT Frame Parser)
```java
// Checks bit 15 of byte 6 for auth status
// Extracts password from bytes 7-11
```

### From ma.java (Default Password)
```java
// Default password is "1234"
```

---

## Next Steps

1. **Capture new BLE trace** with the official app now that password is set
   - This will show exactly what the app sends for authentication
   - Compare to our attempts

2. **Investigate other auth mechanisms**
   - The device might use challenge-response
   - Password might need to be hashed/encrypted
   - There might be a session establishment step we're missing

3. **Check if password can be removed**
   - If possible, test if removing password restores random-token auth
   - This would confirm the hypothesis

---

## Technical Details

### TT Frame Structure (18 bytes)
```
Bytes 0-1:   Header (0x74 0x74)
Bytes 2-3:   F1 - Session counter
Bytes 4-5:   F2 - Configuration ID
Bytes 6-7:   F3 - Flags (bit 15 = auth status)
Bytes 8-9:   F4 - Internal counter
Bytes 10-11: F5 - Tick counter
Bytes 12-13: F6 - Flow (GPM × 100)
Bytes 14-15: F7 - Timestamp/checksum
Bytes 16-17: Serial number fragment
```

### Current TT Response
```
747400010004380004010048000041632700
    ^^^^    ^^^^
    F1=256  F3=0x0038 (no auth)
```

---

## Files Modified

- `ble_client.py` - BLE communication and auth logic
- `parser.py` - Frame parsing
- `sensor.py` - HA sensor entities
- `switch.py` - HA switch entities (display on/off)
- `config_flow.py` - HA config UI
- `coordinator.py` - Data coordinator
- `__init__.py` - Integration setup

---

## Resources

- Decompiled Android app: `android_app_code/DIAMOND-LINQ_3.0.2/`
- BLE traces: `traces/`
- Protocol documentation: `softener_ble_protocol_v3.3.md`

---

## Update: December 31, 2025

### New Trace Captured

**File:** `traces/BT_HCI_2025_1231_104820.cfa.curf`

**Conditions:**
- Fresh device with clean install of official app
- Official app functioned normally
- **No password prompt appeared** (previously set '1234' password was NOT requested)

**Key Observations:**
- Password may be device-local, not cloud-synced
- OR password protection might not be enabled by default
- OR authentication works differently than expected

**Next:** Analyze the new trace to identify the actual authentication sequence used

### Trace Analysis Results

**Authentication Sequence Found:**

1. **Initial tt request sent:**
   ```
   74 74 74 74 74 74 74 74 74 74 74 74 74 74 74 74 74 74 74 74
   ```
   (20 bytes of 0x74)

2. **tt response received (NOT authenticated):**
   ```
   74 74 00 01 00 04 38 00 04 01 00 48 00 00 41 63 27 00
   ```
   - F3 = `0x0038` (bit 15 = 0, NOT authenticated)
   - Serial: 00416327

3. **PA authentication frame sent:**
   ```
   74 74 50 41 35 c4 35 6b bc f5 1a 4d e1 8f a5 eb a6 60 95 f7
   ```
   - Header: `74 74` ("tt")
   - Auth command: `50 41` ("PA")
   - Random token: `35 c4 35 6b bc f5 1a 4d e1 8f a5 eb a6 60 95 f7` (16 bytes)

4. **tt response received (AUTHENTICATED!):**
   ```
   74 74 00 01 00 04 38 80 04 01 00 49 00 00 41 63 27 00
   ```
   - F3 = `0x3880` (bit 15 = 1, AUTHENTICATED! ✓)
   - Serial: 00416327

5. **uu request sent (now works because authenticated):**
   ```
   75 75 75 75 75 75 75 75 75 75 75 75 75 75 75 75 75 75 75 75
   ```

**Key Finding:** Authentication succeeded with a random 16-byte token using the PA frame format, exactly like the old traces. **No password was required!**

**Conclusion:**
- The password setting in the app may not actually enable password protection on the device
- OR the password is optional/not enforced by default
- OR the password only applies to certain operations, not basic authentication
- The simple PA frame with random token is sufficient for authentication

**Root Cause Found:**

Reviewed the current `ble_client.py` implementation and found the bug:

The code currently sends a **PW frame** (password):
```
74 74 ... 50 57 31 32 33 34 ... 74 74
          ^^ ^^ = PW
                ^^ ^^ ^^ ^^ = "1234" as ASCII
```

But the trace shows it should send a **PA frame** (authentication with random token):
```
74 74 50 41 35 c4 35 6b bc f5 1a 4d e1 8f a5 eb a6 60 95 f7
      ^^ ^^ = PA (not PW!)
            ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ = 16 random bytes
```

**The Fix:**
- Change `build_pw_frame()` to actually build a PA frame
- Use `ttPA` (0x74 0x74 0x50 0x41) header
- Follow with 16 random bytes
- No password encoding needed!

**Timing from Trace:**
- tt request sent
- ttPA sent **78ms later**
- uu request sent **338ms after PA**
- Subsequent uu requests every ~1 second

Our current implementation has similar timing (100-300ms delays), so that should be fine.

---

*Investigation complete - fix identified, ready to implement.*
