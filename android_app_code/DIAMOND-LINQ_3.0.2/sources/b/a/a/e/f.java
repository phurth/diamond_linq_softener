package b.a.a.e;

import b.a.a.C0176ca;
import b.a.a.D;
import b.a.a.G;
import b.a.a.ia;
import b.a.a.ka;
import b.a.a.ra;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private byte f1140a;

    /* renamed from: b  reason: collision with root package name */
    private double f1141b;
    private double c;
    private double d;
    private double e;
    private double f;
    private final float[] g = new float[62];
    private final float[] h = new float[42];
    private final float[] i = new float[62];
    private byte j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    public String a(C0176ca caVar) {
        if (caVar == null) {
            return ia.a(this.f1141b);
        }
        if (caVar == C0176ca.Standard) {
            return ia.a(this.f1141b);
        }
        return ka.b(ra.GPM, this.f1141b);
    }

    public String b(C0176ca caVar) {
        if (caVar == null) {
            return ia.a(this.d);
        }
        if (caVar == C0176ca.Standard) {
            return ia.a((int) this.d);
        }
        return ia.a(ka.b(ra.Gallons, (int) this.d));
    }

    public String c(C0176ca caVar) {
        if (caVar == null) {
            return ia.a(this.c);
        }
        if (caVar == C0176ca.Standard) {
            return ia.a((int) this.c);
        }
        return ia.a(ka.b(ra.Gallons, (int) this.c));
    }

    public String d() {
        return ia.a((int) this.e);
    }

    public float[] e() {
        return this.g;
    }

    public float[] f() {
        return this.h;
    }

    public boolean g() {
        return this.p;
    }

    public boolean h() {
        return this.o;
    }

    public boolean i() {
        return this.k;
    }

    public void j() {
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.l = 0;
        this.m = 0;
        this.n = 0;
    }

    public float[] a() {
        return this.i;
    }

    public byte b() {
        return this.j;
    }

    public String c() {
        return ia.a((int) this.f);
    }

    private void b(C0176ca caVar, byte[] bArr, int i2) {
        int i3;
        int i4;
        int i5;
        byte[] bArr2 = bArr;
        int i6 = i2;
        int i7 = this.l;
        if ((i7 == 0 || i7 > 3) && (((i4 = this.m) == 0 || i4 > 4) && ((i5 = this.n) == 0 || i5 > 3))) {
            boolean z = false;
            if (bArr2[0] == 119 && bArr2[1] == 119 && bArr2[2] == 0) {
                if (bArr2.length >= (i6 > 210 ? 19 : 17)) {
                    this.f1141b = D.a(bArr2[4], bArr2[3]) / 100.0d;
                    this.c = D.a(bArr2[7], bArr2[6], bArr2[5]);
                    this.d = D.a(bArr2[10], bArr2[9], bArr2[8]);
                    this.e = D.a(bArr2[12], bArr2[11]);
                    this.f = D.a(bArr2[14], bArr2[13]);
                    this.j = bArr2[15];
                    if (i6 >= 210) {
                        if ((bArr2[17] & 8) != 0) {
                            z = true;
                        }
                        this.k = z;
                        return;
                    }
                    return;
                }
            }
            if (bArr2[0] == 119 && bArr2[1] == 119 && bArr2[2] == 1 && bArr2.length == 20) {
                b(caVar, bArr, 3, 20, -3);
            } else if (bArr2[0] == 119 && bArr2[1] == 119 && bArr2[2] == 2 && bArr2[3] == 68 && bArr2.length == 20) {
                a(caVar, bArr, 4, 20, -4, true);
            } else if (bArr2[0] == 119 && bArr2[1] == 119 && bArr2[2] == 3 && bArr2.length == 20) {
                a(caVar, bArr, 3, 20, -3);
            }
        } else {
            int i8 = this.l;
            if (i8 > 3) {
                i3 = 1;
            } else if (i8 == 1 && bArr2.length == 20) {
                i3 = 1;
                b(caVar, bArr, 0, 20, 17);
            } else {
                i3 = 1;
                if (this.l == 2 && bArr2.length == 20) {
                    b(caVar, bArr, 0, 20, 37);
                } else if (this.l == 3 && bArr2.length == 6) {
                    b(caVar, bArr, 0, 5, 57);
                    this.q = bArr2[5] == 56;
                }
            }
            int i9 = this.m;
            if (i9 <= 4) {
                if (i9 == i3 && bArr2.length == 20) {
                    a(caVar, bArr, 0, 20, 8, false);
                } else if (this.m == 2 && bArr2.length == 20) {
                    a(caVar, bArr, 0, 20, 18, false);
                } else if (this.m == 3 && bArr2.length == 20) {
                    a(caVar, bArr, 0, 20, 28, false);
                } else if (this.m == 4 && bArr2.length == 9) {
                    a(caVar, bArr, 0, 8, 38, false);
                    this.r = bArr2[8] == 57;
                }
            }
            int i10 = this.n;
            if (i10 > 3) {
                return;
            }
            if (i10 == i3 && bArr2.length == 20) {
                a(caVar, bArr, 0, 20, 17);
            } else if (this.n == 2 && bArr2.length == 20) {
                a(caVar, bArr, 0, 20, 37);
            } else if (this.n == 3 && bArr2.length == 6) {
                a(caVar, bArr, 0, 5, 57);
                this.s = bArr2[5] == 58;
                boolean z2 = false;
                this.l = 0;
                this.m = 0;
                this.n = 0;
                if (this.q && this.r && this.s) {
                    z2 = true;
                }
                this.p = z2;
                this.o = this.p;
            }
        }
    }

    public void a(boolean z) {
        this.o = z;
    }

    public void a(C0176ca caVar, byte[] bArr, int i2, int i3, boolean z) {
        if (!G.a(bArr, 5)) {
            if (z) {
                a(caVar, bArr, i3);
            } else {
                b(caVar, bArr, i2);
            }
        }
    }

    private void a(C0176ca caVar, byte[] bArr, int i2) {
        boolean z = false;
        if (bArr[0] == 119 && bArr[1] == 119 && bArr[2] == 119) {
            if (i2 >= 22 && i2 < 33) {
                this.f1140a = bArr[i2 - 15];
                this.j = bArr[i2 - 14];
                this.f1141b = D.a(bArr[i2 - 11], bArr[i2 - 12]) / 100.0d;
                this.c = D.a(bArr[i2 - 8], bArr[i2 - 9], bArr[i2 - 10]);
                this.d = D.a(bArr[i2 - 5], bArr[i2 - 6], bArr[i2 - 7]);
                this.e = D.a(bArr[i2 - 3], bArr[i2 - 4]);
                this.f = D.a(bArr[i2 - 1], bArr[i2 - 2]);
            }
            if (!this.p && i2 >= 230 && i2 < 252) {
                for (int i3 = 0; i3 < 62; i3++) {
                    float b2 = D.b(bArr[i2 - (i3 + 162)]) * 10.0f;
                    float[] fArr = this.g;
                    int i4 = 61 - i3;
                    if (caVar != C0176ca.Standard) {
                        b2 = (float) ka.a(ra.Gallons, (double) b2);
                    }
                    fArr[i4] = b2;
                }
                for (int i5 = 0; i5 < 42; i5++) {
                    int i6 = (i5 * 2) + 78;
                    int i7 = 41 - i5;
                    float b3 = D.b(bArr[i2 - i6]);
                    float b4 = (D.b(bArr[i2 - (i6 + 1)]) * 256.0f) + b3;
                    float[] fArr2 = this.h;
                    if (caVar != C0176ca.Standard) {
                        b3 = (float) ka.a(ra.Gallons, (double) b3);
                    }
                    fArr2[i7] = b3;
                    float[] fArr3 = this.h;
                    if (caVar != C0176ca.Standard) {
                        b4 = (float) ka.a(ra.Gallons, (double) b4);
                    }
                    fArr3[i7] = b4;
                }
                for (int i8 = 0; i8 < 62; i8++) {
                    float b5 = D.b(bArr[i2 - (i8 + 16)]) * 10.0f;
                    float[] fArr4 = this.i;
                    int i9 = 61 - i8;
                    if (caVar != C0176ca.Standard) {
                        b5 = (float) ka.a(ra.GPM, (double) b5);
                    }
                    fArr4[i9] = b5;
                }
                this.p = true;
            }
            if (this.p && this.f1140a == 75) {
                z = true;
            }
            this.o = z;
        }
    }

    private void a(C0176ca caVar, byte[] bArr, int i2, int i3, int i4, boolean z) {
        this.m++;
        if (!this.r) {
            while (i2 < i3) {
                int i5 = z ? (i2 + i4) / 2 : (i2 / 2) + i4;
                float b2 = (D.b(bArr[i2]) * 256.0f) + D.b(bArr[i2 + 1]);
                float[] fArr = this.h;
                if (caVar != C0176ca.Standard) {
                    b2 = (float) ka.a(ra.Gallons, (double) b2);
                }
                fArr[i5] = b2;
                i2 += 2;
            }
        }
    }

    private void a(C0176ca caVar, byte[] bArr, int i2, int i3, int i4) {
        this.n++;
        if (!this.s) {
            while (i2 < i3) {
                float b2 = (D.b(bArr[i2]) * 10.0f) / 100.0f;
                float[] fArr = this.i;
                int i5 = i2 + i4;
                if (caVar != C0176ca.Standard) {
                    b2 = (float) ka.a(ra.GPM, (double) b2);
                }
                fArr[i5] = b2;
                i2++;
            }
        }
    }

    private void b(C0176ca caVar, byte[] bArr, int i2, int i3, int i4) {
        this.l++;
        if (!this.q) {
            while (i2 < i3) {
                float b2 = D.b(bArr[i2]) * 10.0f;
                float[] fArr = this.g;
                int i5 = i2 + i4;
                if (caVar != C0176ca.Standard) {
                    b2 = (float) ka.a(ra.Gallons, (double) b2);
                }
                fArr[i5] = b2;
                i2++;
            }
        }
    }
}
