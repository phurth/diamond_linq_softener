package b.a.a;

public enum va {
    Unknown(-1),
    Version2(2),
    Version3(3);
    
    private final int e;

    private va(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public static va a(int i) {
        for (va vaVar : values()) {
            if (vaVar.a() == i) {
                return vaVar;
            }
        }
        return Unknown;
    }
}
