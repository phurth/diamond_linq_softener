package b.a.a;

public enum ua {
    Unknown(0),
    Protocol1(1);
    
    private final int d;

    private ua(int i) {
        this.d = i;
    }

    public int a() {
        return this.d;
    }

    public static ua a(int i) {
        for (ua uaVar : values()) {
            if (uaVar.a() == i) {
                return uaVar;
            }
        }
        return Unknown;
    }
}
