package b.a.a;

public enum ha {
    DeviceList(0),
    Dashboard(1),
    AdvancedSettings(2),
    StatusAndHistory(3),
    DealerInformation(4);
    
    private final int g;

    private ha(int i) {
        this.g = i;
    }

    public int a() {
        return this.g;
    }

    public static ha a(int i) {
        for (ha haVar : values()) {
            if (haVar.a() == i) {
                return haVar;
            }
        }
        return null;
    }
}
