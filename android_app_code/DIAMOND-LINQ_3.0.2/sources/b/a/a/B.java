package b.a.a;

public enum B {
    AM((byte) 0),
    PM((byte) 1);
    
    private final byte d;

    private B(byte b2) {
        this.d = b2;
    }

    public byte a() {
        return this.d;
    }

    public String toString() {
        return this.d == 0 ? "AM" : "PM";
    }

    public static B a(int i) {
        for (B b2 : values()) {
            if (b2.a() == i) {
                return b2;
            }
        }
        return AM;
    }
}
