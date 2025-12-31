DOMAIN = "diamond_linq_softener"

MANUFACTURER = "Diamond Linq"
NAME = "Diamond Linq Water Softener"

# Nordic UART Service UUIDs
NUS_SERVICE_UUID = "6e400001-b5a3-f393-e0a9-e50e24dcca9e"
NUS_RX_UUID = "6e400002-b5a3-f393-e0a9-e50e24dcca9e"  # write
NUS_TX_UUID = "6e400003-b5a3-f393-e0a9-e50e24dcca9e"  # notify

# BLE handles (from protocol analysis)
HANDLE_TX = 0x000F
HANDLE_RX = 0x000D

# Coordinator update interval (seconds)
DEFAULT_SCAN_INTERVAL = 30

# Configuration keys
CONF_AUTH_TOKEN = "auth_token"
CONF_PASSWORD = "password"

# Default password for PA authentication (from app analysis)
# The app stores per-device passwords with key "PWD-{address}", default is "1234"
DEFAULT_PASSWORD = "1234"

# Default auth token (empty means derive from password)
DEFAULT_AUTH_TOKEN = ""
