package b.a.a;

public enum Q {
    StringInput(0),
    IntInput(1),
    ByteInput(2);
    
    private final int e;

    private Q(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public static Q a(int i) {
        for (Q q : values()) {
            if (q.a() == i) {
                return q;
            }
        }
        return null;
    }
}
