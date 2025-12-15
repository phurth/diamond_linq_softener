async def async_unload_entry(hass: HomeAssistant, entry: ConfigEntry) -> bool:
    """Unload a config entry."""
    unload_ok = await hass.config_entries.async_unload_platforms(entry, PLATFORMS)
    # Note: ActiveBluetoothProcessorCoordinator doesn't have async_shutdown method
    # The coordinator will be automatically cleaned up by HA
    return unload_ok