package b.a.a;

public final class ka {
    private static double a(double d) {
        return d * 3.78541d;
    }

    public static double a(ra raVar, double d) {
        int i = ja.f1158a[raVar.ordinal()];
        if (i == 1) {
            return b(d);
        }
        if (i == 2 || i == 3) {
            return a(d);
        }
        if (i != 4) {
            return d;
        }
        return c(d);
    }

    private static double b(double d) {
        return d * 17.12d;
    }

    public static int b(ra raVar, int i) {
        long round;
        int i2 = ja.f1158a[raVar.ordinal()];
        if (i2 == 1) {
            round = Math.round(b((double) i));
        } else if (i2 == 2 || i2 == 3) {
            round = Math.round(a((double) i));
        } else if (i2 != 4) {
            return i;
        } else {
            round = Math.round(c((double) i));
        }
        return (int) round;
    }

    private static double c(double d) {
        return d / 15.432d;
    }

    public static String c(ra raVar, double d) {
        int i = ja.f1158a[raVar.ordinal()];
        if (i == 1) {
            return ia.a((int) Math.round(b(d)));
        }
        if (i == 2 || i == 3) {
            return ia.a((int) Math.round(a(d)));
        }
        if (i != 4) {
            return String.valueOf(d);
        }
        return ia.a((int) Math.round(c(d)));
    }

    private static double d(double d) {
        return d * 15.432d;
    }

    private static double e(double d) {
        return d * 0.2641720524d;
    }

    private static double f(double d) {
        return d * 0.05841d;
    }

    public static int a(ra raVar, int i) {
        long round;
        int i2 = ja.f1158a[raVar.ordinal()];
        if (i2 == 5) {
            round = Math.round(f((double) i));
        } else if (i2 == 6 || i2 == 7) {
            round = Math.round(e((double) i));
        } else if (i2 != 8) {
            return i;
        } else {
            round = Math.round(d((double) i));
        }
        return (int) round;
    }

    public static String b(ra raVar, double d) {
        int i = ja.f1158a[raVar.ordinal()];
        if (i == 1) {
            return ia.a(b(d));
        }
        if (i == 2 || i == 3) {
            return ia.a(a(d));
        }
        if (i != 4) {
            return String.valueOf(d);
        }
        return ia.a(c(d));
    }
}
