package b.a.a;

/* renamed from: b.a.a.ca  reason: case insensitive filesystem */
public enum C0176ca {
    Standard(0),
    Metric(1);
    
    private final int d;

    private C0176ca(int i) {
        this.d = i;
    }

    public int a() {
        return this.d;
    }

    public static C0176ca a(int i) {
        for (C0176ca caVar : values()) {
            if (caVar.a() == i) {
                return caVar;
            }
        }
        return Standard;
    }
}
