package b.b.a.a.f;

import b.b.a.a.c.j;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private float f1250a;

    /* renamed from: b  reason: collision with root package name */
    private float f1251b;
    private float c;
    private float d;
    private int e;
    private int f;
    private int g;
    private j.a h;
    private float i;
    private float j;

    public c(float f2, float f3, float f4, float f5, int i2, j.a aVar) {
        this.f1250a = Float.NaN;
        this.f1251b = Float.NaN;
        this.e = -1;
        this.g = -1;
        this.f1250a = f2;
        this.f1251b = f3;
        this.c = f4;
        this.d = f5;
        this.f = i2;
        this.h = aVar;
    }

    public j.a a() {
        return this.h;
    }

    public int b() {
        return this.f;
    }

    public float c() {
        return this.i;
    }

    public float d() {
        return this.j;
    }

    public int e() {
        return this.g;
    }

    public float f() {
        return this.f1250a;
    }

    public float g() {
        return this.c;
    }

    public float h() {
        return this.f1251b;
    }

    public float i() {
        return this.d;
    }

    public String toString() {
        return "Highlight, x: " + this.f1250a + ", y: " + this.f1251b + ", dataSetIndex: " + this.f + ", stackIndex (only stacked barentry): " + this.g;
    }

    public void a(float f2, float f3) {
        this.i = f2;
        this.j = f3;
    }

    public boolean a(c cVar) {
        return cVar != null && this.f == cVar.f && this.f1250a == cVar.f1250a && this.g == cVar.g && this.e == cVar.e;
    }

    public c(float f2, float f3, float f4, float f5, int i2, int i3, j.a aVar) {
        this(f2, f3, f4, f5, i2, aVar);
        this.g = i3;
    }
}
