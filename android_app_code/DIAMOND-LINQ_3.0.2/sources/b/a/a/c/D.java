package b.a.a.c;

public enum D {
    Disconnected(0),
    Connecting(1),
    Connected(2);
    
    private final int e;

    private D(int i) {
        this.e = i;
    }

    public String toString() {
        int i = this.e;
        if (i != 1) {
            return i != 2 ? "Disconnected" : "Connected";
        }
        return "Connecting";
    }
}
