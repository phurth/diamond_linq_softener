package b.b.a.a.j;

import b.b.a.a.j.f;

public class c extends f.a {
    private static f<c> c = f.a(64, new c(0.0d, 0.0d));
    public double d;
    public double e;

    static {
        c.a(0.5f);
    }

    private c(double d2, double d3) {
        this.d = d2;
        this.e = d3;
    }

    public static c a(double d2, double d3) {
        c a2 = c.a();
        a2.d = d2;
        a2.e = d3;
        return a2;
    }

    public String toString() {
        return "MPPointD, x: " + this.d + ", y: " + this.e;
    }

    public static void a(c cVar) {
        c.a(cVar);
    }

    /* access modifiers changed from: protected */
    public f.a a() {
        return new c(0.0d, 0.0d);
    }
}
