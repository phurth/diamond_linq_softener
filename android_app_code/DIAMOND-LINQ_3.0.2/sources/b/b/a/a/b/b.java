package b.b.a.a.b;

import b.b.a.a.g.b.a;

public class b extends a<a> {
    protected int g = 0;
    protected int h = 1;
    protected boolean i = false;
    protected boolean j = false;
    protected float k = 1.0f;

    public b(int i2, int i3, boolean z) {
        super(i2);
        this.h = i3;
        this.i = z;
    }

    public void a(float f) {
        this.k = f;
    }

    public void a(int i2) {
        this.g = i2;
    }

    public void a(boolean z) {
        this.j = z;
    }

    /* access modifiers changed from: protected */
    public void a(float f, float f2, float f3, float f4) {
        float[] fArr = this.f1204b;
        int i2 = this.f1203a;
        this.f1203a = i2 + 1;
        fArr[i2] = f;
        int i3 = this.f1203a;
        this.f1203a = i3 + 1;
        fArr[i3] = f2;
        int i4 = this.f1203a;
        this.f1203a = i4 + 1;
        fArr[i4] = f3;
        int i5 = this.f1203a;
        this.f1203a = i5 + 1;
        fArr[i5] = f4;
    }

    public void a(a aVar) {
        float f;
        float f2;
        float f3;
        float f4;
        float r = ((float) aVar.r()) * this.c;
        float f5 = this.k / 2.0f;
        for (int i2 = 0; ((float) i2) < r; i2++) {
            b.b.a.a.d.b bVar = (b.b.a.a.d.b) aVar.b(i2);
            if (bVar != null) {
                float d = bVar.d();
                float c = bVar.c();
                float[] h2 = bVar.h();
                if (!this.i || h2 == null) {
                    float f6 = d - f5;
                    float f7 = d + f5;
                    if (this.j) {
                        float f8 = c >= 0.0f ? c : 0.0f;
                        if (c > 0.0f) {
                            c = 0.0f;
                        }
                        float f9 = c;
                        c = f8;
                        f = f9;
                    } else {
                        f = c >= 0.0f ? c : 0.0f;
                        if (c > 0.0f) {
                            c = 0.0f;
                        }
                    }
                    if (f > 0.0f) {
                        f *= this.d;
                    } else {
                        c *= this.d;
                    }
                    a(f6, f, f7, c);
                } else {
                    float f10 = -bVar.e();
                    int i3 = 0;
                    float f11 = 0.0f;
                    while (i3 < h2.length) {
                        float f12 = h2[i3];
                        if (f12 == 0.0f && (f11 == 0.0f || f10 == 0.0f)) {
                            f2 = f10;
                            f3 = f11;
                            f11 = f12;
                        } else if (f12 >= 0.0f) {
                            f12 += f11;
                            f2 = f10;
                            f3 = f12;
                        } else {
                            float abs = Math.abs(f12) + f10;
                            float abs2 = Math.abs(f12) + f10;
                            float f13 = f10;
                            f3 = f11;
                            f11 = f13;
                            float f14 = abs;
                            f2 = abs2;
                            f12 = f14;
                        }
                        float f15 = d - f5;
                        float f16 = d + f5;
                        if (this.j) {
                            float f17 = f11 >= f12 ? f11 : f12;
                            if (f11 > f12) {
                                f11 = f12;
                            }
                            float f18 = f11;
                            f11 = f17;
                            f4 = f18;
                        } else {
                            f4 = f11 >= f12 ? f11 : f12;
                            if (f11 > f12) {
                                f11 = f12;
                            }
                        }
                        float f19 = this.d;
                        a(f15, f4 * f19, f16, f11 * f19);
                        i3++;
                        f11 = f3;
                        f10 = f2;
                    }
                }
            }
        }
        a();
    }
}
