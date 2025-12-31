package b.b.a.a.j;

import b.b.a.a.j.f;

public final class a extends f.a {
    private static f<a> c = f.a(256, new a(0.0f, 0.0f));
    public float d;
    public float e;

    static {
        c.a(0.5f);
    }

    public a() {
    }

    /* access modifiers changed from: protected */
    public f.a a() {
        return new a(0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.d == aVar.d && this.e == aVar.e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.d) ^ Float.floatToIntBits(this.e);
    }

    public String toString() {
        return this.d + "x" + this.e;
    }

    public a(float f, float f2) {
        this.d = f;
        this.e = f2;
    }

    public static a a(float f, float f2) {
        a a2 = c.a();
        a2.d = f;
        a2.e = f2;
        return a2;
    }

    public static void a(a aVar) {
        c.a(aVar);
    }
}
