package b.a.a;

public final class D {
    public static double a(byte b2) {
        if (!d(b2)) {
            return (double) b2;
        }
        double d = (double) b2;
        Double.isNaN(d);
        return d + 256.0d;
    }

    public static float b(byte b2) {
        return d(b2) ? ((float) b2) + 256.0f : (float) b2;
    }

    public static int c(byte b2) {
        return d(b2) ? b2 + 256 : b2;
    }

    public static boolean d(byte b2) {
        return (b2 & 128) == 128;
    }

    public static double a(byte b2, byte b3) {
        return (a(b3) * 256.0d) + a(b2);
    }

    public static int b(byte b2, byte b3) {
        return (c(b3) * 256) + c(b2);
    }

    public static double a(byte b2, byte b3, byte b4) {
        return (a(b4) * 256.0d * 256.0d) + (a(b3) * 256.0d) + a(b2);
    }
}
