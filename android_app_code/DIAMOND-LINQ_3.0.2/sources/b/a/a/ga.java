package b.a.a;

public enum ga {
    Unknown(-1),
    SaltOkay(0),
    SaltLow(1);
    
    private final int e;

    private ga(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public static ga a(int i) {
        for (ga gaVar : values()) {
            if (gaVar.a() == i) {
                return gaVar;
            }
        }
        return Unknown;
    }
}
