package b.b.a.a.j;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.a.a.j.f;

public class e extends f.a {
    private static f<e> c = f.a(32, new e(0.0f, 0.0f));
    public static final Parcelable.Creator<e> d = new d();
    public float e;
    public float f;

    static {
        c.a(0.5f);
    }

    public e() {
    }

    public static e a(float f2, float f3) {
        e a2 = c.a();
        a2.e = f2;
        a2.f = f3;
        return a2;
    }

    public static e b() {
        return c.a();
    }

    public e(float f2, float f3) {
        this.e = f2;
        this.f = f3;
    }

    public static void b(e eVar) {
        c.a(eVar);
    }

    public static e a(e eVar) {
        e a2 = c.a();
        a2.e = eVar.e;
        a2.f = eVar.f;
        return a2;
    }

    public void a(Parcel parcel) {
        this.e = parcel.readFloat();
        this.f = parcel.readFloat();
    }

    /* access modifiers changed from: protected */
    public f.a a() {
        return new e(0.0f, 0.0f);
    }
}
