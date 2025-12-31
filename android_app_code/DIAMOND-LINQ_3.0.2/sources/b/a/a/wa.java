package b.a.a;

public enum wa {
    Unknown(-1),
    MeteredSoftener(0),
    TimeClockSoftener(1),
    BackWashingFilter(2),
    UltraFilter(3),
    CenturionNitro(4),
    CenturionNitroSidekick(5),
    CenturionNitroSidekickV3(6),
    NitroPro(7),
    NitroProSidekick(8);
    
    private final int l;

    private wa(int i) {
        this.l = i;
    }

    public int a() {
        return this.l;
    }

    public static wa a(int i) {
        for (wa waVar : values()) {
            if (waVar.a() == i) {
                return waVar;
            }
        }
        return Unknown;
    }
}
