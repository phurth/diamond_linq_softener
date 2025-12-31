package b.a.a;

public enum I {
    Position1((byte) 49),
    Position2((byte) 50),
    Position3((byte) 51),
    Position4((byte) 52),
    Position5((byte) 53),
    Position6((byte) 54),
    Position7((byte) 55),
    Position8((byte) 56);
    
    private final byte j;

    private I(byte b2) {
        this.j = b2;
    }

    public byte a() {
        return this.j;
    }
}
