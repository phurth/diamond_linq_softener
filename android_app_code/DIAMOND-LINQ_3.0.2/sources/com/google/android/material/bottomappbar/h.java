package com.google.android.material.bottomappbar;

import b.c.a.a.p.c;
import b.c.a.a.p.k;

public class h extends c implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private float f1466a;

    /* renamed from: b  reason: collision with root package name */
    private float f1467b;
    private float c;
    private float d;
    private float e;

    public void a(float f, float f2, float f3, k kVar) {
        float f4 = f;
        k kVar2 = kVar;
        float f5 = this.c;
        if (f5 == 0.0f) {
            kVar2.a(f4, 0.0f);
            return;
        }
        float f6 = ((this.f1467b * 2.0f) + f5) / 2.0f;
        float f7 = f3 * this.f1466a;
        float f8 = f2 + this.e;
        float f9 = (this.d * f3) + ((1.0f - f3) * f6);
        if (f9 / f6 >= 1.0f) {
            kVar2.a(f4, 0.0f);
            return;
        }
        float f10 = f6 + f7;
        float f11 = f9 + f7;
        float sqrt = (float) Math.sqrt((double) ((f10 * f10) - (f11 * f11)));
        float f12 = f8 - sqrt;
        float f13 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f11)));
        float f14 = 90.0f - degrees;
        kVar2.a(f12, 0.0f);
        float f15 = f7 * 2.0f;
        float f16 = degrees;
        kVar.a(f12 - f7, 0.0f, f12 + f7, f15, 270.0f, degrees);
        kVar.a(f8 - f6, (-f6) - f9, f8 + f6, f6 - f9, 180.0f - f14, (f14 * 2.0f) - 180.0f);
        kVar.a(f13 - f7, 0.0f, f13 + f7, f15, 270.0f - f16, f16);
        kVar2.a(f4, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f1467b;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f1466a;
    }

    public float d() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void e(float f) {
        this.e = f;
    }

    /* access modifiers changed from: package-private */
    public void b(float f) {
        this.f1467b = f;
    }

    /* access modifiers changed from: package-private */
    public void c(float f) {
        this.f1466a = f;
    }

    public void d(float f) {
        this.c = f;
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void a(float f) {
        this.d = f;
    }
}
