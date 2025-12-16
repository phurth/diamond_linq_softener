    async def _apply_uu(self, subtype: int, fields: list[int]) -> None:
        """Update state from a uu frame."""
        async with self._lock:
            if subtype == 0x0003:
                # usage stats
                _, f2, f3, f4, f5, f6, f7, f8, f9, f10 = fields
                self.soft_remaining_gal = f5
                self.avg_daily_use_gal = f6 / 256.0
                self.treated_today_gal = f7 / 256.0
                self.regen_hour = f8
                _LOGGER.debug("Got usage data: soft=%d, avg=%.1f, today=%.1f, hour=%d",
                            self.soft_remaining_gal, self.avg_daily_use_gal,
                            self.treated_today_gal, self.regen_hour)
            elif subtype == 0x0001:
                # salt / geometry config: last two fields are our raw config codes
                *_, cfg_f7, cfg_f8 = fields
                self.salt_config_f7 = cfg_f7
                self.salt_config_f8 = cfg_f8
                _LOGGER.debug("Got config data: f7=%d, f8=%d", cfg_f7, cfg_f8)