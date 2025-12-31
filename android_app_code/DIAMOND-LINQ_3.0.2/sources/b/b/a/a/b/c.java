package b.b.a.a.b;

import b.b.a.a.d.b;
import b.b.a.a.g.b.a;

public class c extends b {
    public c(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    public void a(a aVar) {
        float f;
        float f2;
        float f3;
        float f4;
        float r = ((float) aVar.r()) * this.c;
        float f5 = this.k / 2.0f;
        for (int i = 0; ((float) i) < r; i++) {
            b bVar = (b) aVar.b(i);
            if (bVar != null) {
                float d = bVar.d();
                float c = bVar.c();
                float[] h = bVar.h();
                if (!this.i || h == null) {
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
                    a(c, f7, f, f6);
                } else {
                    float f10 = -bVar.e();
                    int i2 = 0;
                    float f11 = 0.0f;
                    while (i2 < h.length) {
                        float f12 = h[i2];
                        if (f12 >= 0.0f) {
                            f3 = f12 + f11;
                            f2 = f10;
                            f10 = f11;
                            f11 = f3;
                        } else {
                            float abs = Math.abs(f12) + f10;
                            f2 = Math.abs(f12) + f10;
                            f3 = abs;
                        }
                        float f13 = d - f5;
                        float f14 = d + f5;
                        if (this.j) {
                            float f15 = f10 >= f3 ? f10 : f3;
                            if (f10 > f3) {
                                f10 = f3;
                            }
                            float f16 = f10;
                            f10 = f15;
                            f4 = f16;
                        } else {
                            f4 = f10 >= f3 ? f10 : f3;
                            if (f10 > f3) {
                                f10 = f3;
                            }
                        }
                        float f17 = this.d;
                        a(f10 * f17, f14, f4 * f17, f13);
                        i2++;
                        f10 = f2;
                    }
                }
            }
        }
        a();
    }
}
