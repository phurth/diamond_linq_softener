    async def _apply_tt(self, vals: list[int]) -> None:
        """Update state from a tt telemetry frame."""
        async with self._lock:
            # tt: [F1..F8]; F6 is flow (GPM*100)
            f1, f2, f3, f4, f5, f6, f7, f8 = vals
            flow_gpm = f6 / 100.0
            _LOGGER.info("tt frame parsed - F1=%d F2=%d F3=%d F4=%d F5=%d F6=%d F7=%d F8=%d -> flow=%.2f gpm",
                         f1, f2, f3, f4, f5, f6, f7, f8, flow_gpm)
            self.flow_gpm = flow_gpm