"""Parser for Diamond Linq Water Softener BLE frames.

Frame types:
- tt (0x74 0x74): Real-time telemetry (flow rate)
- uu (0x75 0x75): Usage statistics and configuration
- vv (0x76 0x76): Static configuration data
"""
from __future__ import annotations

import asyncio
import logging
import struct
from dataclasses import dataclass, field
from typing import Optional

from bleak.backends.device import BLEDevice

_LOGGER = logging.getLogger(__name__)

# Frame type headers (ASCII)
FRAME_TT = bytes([0x74, 0x74])  # 'tt' - telemetry
FRAME_UU = bytes([0x75, 0x75])  # 'uu' - usage/config
FRAME_VV = bytes([0x76, 0x76])  # 'vv' - static config

# UU frame subtypes (single byte at offset 2)
UU_SUBTYPE_USAGE = 0x00   # Usage statistics (subtype byte = 0x00)
UU_SUBTYPE_CONFIG = 0x01  # Salt/tank geometry configuration (subtype byte = 0x01)
UU_SUBTYPE_HISTORY = 0x02  # Usage history data (subtype byte = 0x02)


@dataclass
class DiamondLinqData:
    """Holds all decoded data from the softener."""

    # Real-time telemetry (from tt frames)
    flow_gpm: Optional[float] = None

    # Usage statistics (from uu subtype 0x0003)
    soft_remaining_gal: Optional[int] = None
    avg_daily_use_gal: Optional[float] = None
    treated_today_gal: Optional[float] = None
    regen_hour: Optional[int] = None
    days_until_regen: Optional[int] = None

    # Salt/tank config (from uu subtype 0x0001) - raw values
    salt_config_f7: Optional[int] = None
    salt_config_f8: Optional[int] = None

    # Static configuration (from vv frames)
    water_hardness_gpg: Optional[int] = None
    reserve_capacity_pct: Optional[int] = None
    resin_capacity_grains: Optional[int] = None
    backwash_minutes: Optional[int] = None
    brine_draw_minutes: Optional[int] = None
    rapid_rinse_minutes: Optional[int] = None
    brine_refill_minutes: Optional[int] = None
    firmware_version: Optional[str] = None

    # Connection status
    last_update: Optional[float] = None

    async def async_poll(self, device: BLEDevice) -> "DiamondLinqData":
        """Poll the device for data. This is called by the coordinator.
        
        The actual BLE communication is handled by SoftenerBleClient.
        This method exists for compatibility with the coordinator pattern.
        """
        # Return self - the actual polling updates this object in place
        return self


class FrameParser:
    """Parser for Diamond Linq BLE notification frames."""

    def __init__(self) -> None:
        self._lock = asyncio.Lock()
        self.data = DiamondLinqData()

    def parse_frame(self, raw: bytes) -> bool:
        """Parse a raw BLE notification frame.
        
        Returns True if the frame was successfully parsed.
        """
        if len(raw) < 4:
            _LOGGER.debug("Frame too short: %d bytes", len(raw))
            return False

        header = raw[:2]

        if header == FRAME_TT:
            return self._parse_tt(raw)
        elif header == FRAME_UU:
            return self._parse_uu(raw)
        elif header == FRAME_VV:
            return self._parse_vv(raw)
        else:
            _LOGGER.debug("Unknown frame header: %s", header.hex())
            return False

    def _parse_tt(self, raw: bytes) -> bool:
        """Parse a tt (telemetry) frame.
        
        tt frame structure (20 bytes):
        - Bytes 0-1: Header (0x74 0x74)
        - Bytes 2-3: F1 - Session counter
        - Bytes 4-5: F2 - Configuration ID
        - Bytes 6-7: F3 - Flag bits (bit 15 toggles on flow start)
        - Bytes 8-9: F4 - Internal counter
        - Bytes 10-11: F5 - Tick counter
        - Bytes 12-13: F6 - Instantaneous Flow (GPM × 100)
        - Bytes 14-15: F7 - Timestamp/checksum
        - Bytes 16-17: F8 - Record index
        """
        if len(raw) < 14:
            _LOGGER.debug("tt frame too short: %d bytes", len(raw))
            return False

        try:
            # Extract fields as little-endian uint16
            f1 = struct.unpack_from('<H', raw, 2)[0]
            f2 = struct.unpack_from('<H', raw, 4)[0]
            f3 = struct.unpack_from('<H', raw, 6)[0]
            f4 = struct.unpack_from('<H', raw, 8)[0]
            f5 = struct.unpack_from('<H', raw, 10)[0]
            f6 = struct.unpack_from('<H', raw, 12)[0]

            # F6 is flow rate in GPM × 100
            flow_gpm = f6 / 100.0

            self.data.flow_gpm = flow_gpm

            _LOGGER.debug(
                "tt frame: F1=%d F2=%d F3=0x%04X F4=%d F5=%d F6=%d -> flow=%.2f GPM",
                f1, f2, f3, f4, f5, f6, flow_gpm
            )
            return True

        except struct.error as e:
            _LOGGER.warning("Failed to parse tt frame: %s", e)
            return False

    def _parse_uu(self, raw: bytes) -> bool:
        """Parse a uu (usage/config) frame.
        
        uu frames have different subtypes identified by byte 2 (single byte).
        Byte 3 is a variant/counter that changes between frames.
        """
        if len(raw) < 6:
            _LOGGER.debug("uu frame too short: %d bytes", len(raw))
            return False

        try:
            # Subtype is a SINGLE BYTE at offset 2, not a uint16
            subtype = raw[2]
            variant = raw[3]  # This changes between frames
            
            _LOGGER.debug("uu frame: subtype=0x%02X, variant=0x%02X", subtype, variant)

            if subtype == UU_SUBTYPE_USAGE:
                return self._parse_uu_usage(raw)
            elif subtype == UU_SUBTYPE_CONFIG:
                return self._parse_uu_config(raw)
            elif subtype == UU_SUBTYPE_HISTORY:
                _LOGGER.debug("uu history frame (subtype 0x02) - not parsed")
                return True  # Acknowledge but don't parse history data
            else:
                _LOGGER.debug("Unknown uu subtype: 0x%02X", subtype)
                return False

        except Exception as e:
            _LOGGER.warning("Failed to parse uu frame: %s", e)
            return False

    def _parse_uu_usage(self, raw: bytes) -> bool:
        """Parse uu subtype 0x0003 (usage statistics).
        
        Structure (20 bytes):
        - Bytes 0-1: Header (0x75 0x75)
        - Bytes 2-3: Subtype (0x0003)
        - Bytes 4-5: F2 - Status bitmask
        - Bytes 6-7: F3 - Regen countdown/day index
        - Bytes 8-9: F4 - Counter
        - Bytes 10-11: F5 - Soft Water Remaining (gallons)
        - Bytes 12-13: F6 - Average Daily Use (gal/day × 256)
        - Bytes 14-15: F7 - Treated Water Today (gallons × 256)
        - Bytes 16-17: F8 - Regeneration Time (hours, e.g., 2 = 2 AM)
        - Bytes 18-19: F9 - Record/checksum
        """
        if len(raw) < 18:
            _LOGGER.debug("uu usage frame too short: %d bytes", len(raw))
            return False

        try:
            f2 = struct.unpack_from('<H', raw, 4)[0]   # Status bitmask
            f3 = struct.unpack_from('<H', raw, 6)[0]   # Regen countdown
            f4 = struct.unpack_from('<H', raw, 8)[0]   # Counter
            f5 = struct.unpack_from('<H', raw, 10)[0]  # Soft remaining
            f6 = struct.unpack_from('<H', raw, 12)[0]  # Avg daily use × 256
            f7 = struct.unpack_from('<H', raw, 14)[0]  # Treated today × 256
            f8 = struct.unpack_from('<H', raw, 16)[0]  # Regen hour

            # Apply scaling
            soft_remaining = f5  # gallons, no scaling
            avg_daily_use = f6 / 256.0  # divide by 256
            treated_today = f7 / 256.0  # divide by 256
            regen_hour = f8  # hours (0-23)

            # F3 appears to be days until regen (needs confirmation)
            days_until_regen = f3

            self.data.soft_remaining_gal = soft_remaining
            self.data.avg_daily_use_gal = round(avg_daily_use, 1)
            self.data.treated_today_gal = round(treated_today, 1)
            self.data.regen_hour = regen_hour
            self.data.days_until_regen = days_until_regen

            _LOGGER.debug(
                "uu usage: soft_remaining=%d gal, avg_daily=%.1f gal, "
                "treated_today=%.1f gal, regen_hour=%d, days_until_regen=%d",
                soft_remaining, avg_daily_use, treated_today, regen_hour, days_until_regen
            )
            return True

        except struct.error as e:
            _LOGGER.warning("Failed to parse uu usage frame: %s", e)
            return False

    def _parse_uu_config(self, raw: bytes) -> bool:
        """Parse uu subtype 0x0001 (salt/tank geometry config).
        
        Structure (20 bytes):
        - Bytes 0-1: Header (0x75 0x75)
        - Bytes 2-3: Subtype (0x0001)
        - Bytes 4-13: Fixed/unused bytes
        - Bytes 14-15: F7 - Salt/width/height encoded value 1
        - Bytes 16-17: F8 - Salt/width/height encoded value 2
        - Bytes 18-19: Padding/checksum
        
        The exact mapping of F7/F8 to salt weight, tank width, and max fill
        height is still being decoded. For now, expose as raw values.
        """
        if len(raw) < 18:
            _LOGGER.debug("uu config frame too short: %d bytes", len(raw))
            return False

        try:
            # The config values are at offsets 14-15 and 16-17 based on protocol doc
            # But the actual structure varies - let's parse what we can
            f7 = struct.unpack_from('<H', raw, 12)[0]
            f8 = struct.unpack_from('<H', raw, 14)[0]

            self.data.salt_config_f7 = f7
            self.data.salt_config_f8 = f8

            _LOGGER.debug("uu config: F7=0x%04X (%d), F8=0x%04X (%d)", f7, f7, f8, f8)
            return True

        except struct.error as e:
            _LOGGER.warning("Failed to parse uu config frame: %s", e)
            return False

    def _parse_vv(self, raw: bytes) -> bool:
        """Parse a vv (static configuration) frame.
        
        vv frames contain static configuration like hardness, capacity,
        cycle timers, and dealer info. There appear to be multiple
        vv frame variants.
        
        Common structure variant 1 (20 bytes):
        - Bytes 0-1: Header (0x76 0x76)
        - Bytes 2-3: Subtype (0x0000)
        - Bytes 4-5: Unknown
        - Bytes 6-7: Water hardness (GPG)
        - Bytes 8-9: Reserve capacity (%)
        - ... additional config fields
        
        Common structure variant 2 (cycle timers):
        - Header + backwash/rinse/fill durations
        """
        if len(raw) < 6:
            _LOGGER.debug("vv frame too short: %d bytes", len(raw))
            return False

        try:
            # Check for different vv frame variants
            subtype = struct.unpack_from('<H', raw, 2)[0]

            if subtype == 0x0000 and len(raw) >= 20:
                # Main config frame
                return self._parse_vv_main(raw)
            elif len(raw) >= 20:
                # Cycle timer frame (subtype 0x010A or similar)
                return self._parse_vv_timers(raw)
            else:
                _LOGGER.debug("vv frame subtype 0x%04X not handled", subtype)
                return False

        except struct.error as e:
            _LOGGER.warning("Failed to parse vv frame: %s", e)
            return False

    def _parse_vv_main(self, raw: bytes) -> bool:
        """Parse main vv configuration frame.
        
        Based on decompiled app code, the vv frame with subtype 0x0000
        contains:
        - Water hardness
        - Reserve capacity  
        - Resin capacity
        """
        try:
            # These offsets are based on protocol analysis
            # vv 00 00 ... format
            hardness = struct.unpack_from('<H', raw, 6)[0]
            reserve = struct.unpack_from('<H', raw, 8)[0]
            
            # Resin capacity might need different handling
            # From protocol doc: 0x25 0x00 -> 36000 grains
            # This suggests some scaling or lookup
            
            if hardness > 0 and hardness < 200:  # Sanity check
                self.data.water_hardness_gpg = hardness
            
            if reserve > 0 and reserve <= 100:  # Sanity check
                self.data.reserve_capacity_pct = reserve

            _LOGGER.debug(
                "vv main: hardness=%d GPG, reserve=%d%%",
                hardness, reserve
            )
            return True

        except struct.error as e:
            _LOGGER.warning("Failed to parse vv main frame: %s", e)
            return False

    def _parse_vv_timers(self, raw: bytes) -> bool:
        """Parse vv cycle timer frame.
        
        From protocol doc:
        - Backwash: 10 min
        - Brine draw/slow rinse: 60 min
        - Rapid rinse: 8 min
        - Brine refill: 11 min
        """
        try:
            # Based on protocol analysis, timer frame starts with vv 01
            if raw[2] != 0x01:
                return False

            # Offsets based on: 76 76 01 0A 3C 08 0B ...
            backwash = raw[3] if len(raw) > 3 else None
            brine_draw = raw[4] if len(raw) > 4 else None
            rapid_rinse = raw[5] if len(raw) > 5 else None
            brine_refill = raw[6] if len(raw) > 6 else None

            if backwash is not None and backwash < 60:
                self.data.backwash_minutes = backwash
            if brine_draw is not None:
                self.data.brine_draw_minutes = brine_draw
            if rapid_rinse is not None and rapid_rinse < 60:
                self.data.rapid_rinse_minutes = rapid_rinse
            if brine_refill is not None and brine_refill < 60:
                self.data.brine_refill_minutes = brine_refill

            _LOGGER.debug(
                "vv timers: backwash=%s, brine_draw=%s, rapid_rinse=%s, brine_refill=%s",
                backwash, brine_draw, rapid_rinse, brine_refill
            )
            return True

        except (IndexError, struct.error) as e:
            _LOGGER.warning("Failed to parse vv timer frame: %s", e)
            return False

    def get_data(self) -> DiamondLinqData:
        """Return the current parsed data."""
        return self.data

    def reset(self) -> None:
        """Reset all parsed data."""
        self.data = DiamondLinqData()
