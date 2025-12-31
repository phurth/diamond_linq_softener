package b.a.a.c;

public enum v {
    Unknown(0),
    Flags(1),
    ServiceUuids16BitPartial(2),
    ServiceUuids16BitComplete(3),
    ServiceUuids32BitPartial(4),
    ServiceUuids32BitComplete(5),
    ServiceUuids128BitPartial(6),
    ServiceUuids128BitComplete(7),
    DataTypeLocalNameShort(8),
    DataTypeLocalNameComplete(9),
    DataTypeTxPowerLevel(10),
    DataTypeClassOfDevices(13),
    DataTypeSimplePairingHashC192(14),
    DataTypeSimplePairingRandomizerR192(15),
    DataTypeDeviceId(16),
    DataTypeSecurityManagerOobFlags(17),
    DataTypeSlaveConnectionIntervalRange(18),
    DataTypeServiceSolicitation16Bit(20),
    DataTypeServiceSolicitation128Bit(21),
    DataTypeServiceData16Bit(22),
    DataTypePublicTargetAddress(23),
    DataTypeRandomTargetAddress(24),
    DataTypeAppearance(25),
    AdvertisingInterval(26),
    DataTypeLeDeviceAddress(27),
    DataTypeLeRoles(28),
    DataTypeSimplePairingHashC256(29),
    DataTypeSimplePairingRandomizerR256(30),
    DataTypeServiceSolicitation32Bit(31),
    DataTypeServiceData32Bit(32),
    DataTypeServiceData128Bit(33),
    DataTypeLeSecureConnectionsConfirmationValue(34),
    DataTypeLeSecureConnectionsRandomValue(35),
    DataTypeUri(36),
    DataTypeIndoorPositioning(37),
    DataTypeTransportDiscoveryData(38),
    DataTypeLeSupportedFeatures(39),
    DataTypeChannelMapUpdateIndication(40),
    DataTypePbAdv(41),
    DataTypeMeshMessage(42),
    DataTypeMeshBeacon(43),
    DataType3dInformationData(61),
    DataTypeManufacturerSpecificData(255);
    
    private final int S;

    private v(int i) {
        this.S = i;
    }

    public int a() {
        return this.S;
    }

    public static v a(int i) {
        for (v vVar : values()) {
            if (vVar.a() == i) {
                return vVar;
            }
        }
        return Unknown;
    }
}
