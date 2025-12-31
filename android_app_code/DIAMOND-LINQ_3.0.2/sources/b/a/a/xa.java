package b.a.a;

public enum xa {
    Unknown(0),
    MeteredSoftener(1),
    TimeClockSoftener(2),
    BackWashingFilter(4),
    HydroxRFilter(6),
    ReactRFilter(7),
    UltraFilter(8),
    CenturionNitroStandard(11),
    CenturionNitroFinal(12),
    CenturionNitroProStandard(13),
    CenturionNitroProFinal(14),
    CenturionNitroSidekick(15),
    CenturionNitroSidekickV3(16),
    TestValve(255);
    
    private final int p;

    private xa(int i) {
        this.p = i;
    }

    private int a() {
        return this.p;
    }

    public static xa a(int i) {
        for (xa xaVar : values()) {
            if (xaVar.a() == i) {
                return xaVar;
            }
        }
        return Unknown;
    }
}
