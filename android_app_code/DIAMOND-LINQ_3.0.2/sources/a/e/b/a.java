package a.e.b;

import a.e.b.i;
import java.util.Arrays;
import no.nordicsemi.android.log.BuildConfig;

public class a {

    /* renamed from: a  reason: collision with root package name */
    int f75a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final b f76b;
    private final c c;
    private int d = 8;
    private i e = null;
    private int[] f;
    private int[] g;
    private float[] h;
    private int i;
    private int j;
    private boolean k;

    a(b bVar, c cVar) {
        int i2 = this.d;
        this.f = new int[i2];
        this.g = new int[i2];
        this.h = new float[i2];
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f76b = bVar;
        this.c = cVar;
    }

    public final void a(i iVar, float f2) {
        if (f2 == 0.0f) {
            a(iVar, true);
            return;
        }
        int i2 = this.i;
        if (i2 == -1) {
            this.i = 0;
            float[] fArr = this.h;
            int i3 = this.i;
            fArr[i3] = f2;
            this.f[i3] = iVar.c;
            this.g[i3] = -1;
            iVar.k++;
            iVar.a(this.f76b);
            this.f75a++;
            if (!this.k) {
                this.j++;
                int i4 = this.j;
                int[] iArr = this.f;
                if (i4 >= iArr.length) {
                    this.k = true;
                    this.j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i5 = 0;
        int i6 = -1;
        while (i2 != -1 && i5 < this.f75a) {
            int[] iArr2 = this.f;
            int i7 = iArr2[i2];
            int i8 = iVar.c;
            if (i7 == i8) {
                this.h[i2] = f2;
                return;
            }
            if (iArr2[i2] < i8) {
                i6 = i2;
            }
            i2 = this.g[i2];
            i5++;
        }
        int i9 = this.j;
        int i10 = i9 + 1;
        if (this.k) {
            int[] iArr3 = this.f;
            if (iArr3[i9] != -1) {
                i9 = iArr3.length;
            }
        } else {
            i9 = i10;
        }
        int[] iArr4 = this.f;
        if (i9 >= iArr4.length && this.f75a < iArr4.length) {
            int i11 = 0;
            while (true) {
                int[] iArr5 = this.f;
                if (i11 >= iArr5.length) {
                    break;
                } else if (iArr5[i11] == -1) {
                    i9 = i11;
                    break;
                } else {
                    i11++;
                }
            }
        }
        int[] iArr6 = this.f;
        if (i9 >= iArr6.length) {
            i9 = iArr6.length;
            this.d *= 2;
            this.k = false;
            this.j = i9 - 1;
            this.h = Arrays.copyOf(this.h, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[i9] = iVar.c;
        this.h[i9] = f2;
        if (i6 != -1) {
            int[] iArr7 = this.g;
            iArr7[i9] = iArr7[i6];
            iArr7[i6] = i9;
        } else {
            this.g[i9] = this.i;
            this.i = i9;
        }
        iVar.k++;
        iVar.a(this.f76b);
        this.f75a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f75a >= this.f.length) {
            this.k = true;
        }
        int i12 = this.j;
        int[] iArr8 = this.f;
        if (i12 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f75a) {
            float[] fArr = this.h;
            fArr[i2] = fArr[i2] * -1.0f;
            i2 = this.g[i2];
            i3++;
        }
    }

    public String toString() {
        int i2 = this.i;
        String str = BuildConfig.FLAVOR;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f75a) {
            str = ((str + " -> ") + this.h[i2] + " : ") + this.c.c[this.f[i2]];
            i2 = this.g[i2];
            i3++;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final float b(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f75a) {
            if (i4 == i2) {
                return this.h[i3];
            }
            i3 = this.g[i3];
            i4++;
        }
        return 0.0f;
    }

    public final float b(i iVar) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f75a) {
            if (this.f[i2] == iVar.c) {
                return this.h[i2];
            }
            i2 = this.g[i2];
            i3++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final void a(i iVar, float f2, boolean z) {
        if (f2 != 0.0f) {
            int i2 = this.i;
            if (i2 == -1) {
                this.i = 0;
                float[] fArr = this.h;
                int i3 = this.i;
                fArr[i3] = f2;
                this.f[i3] = iVar.c;
                this.g[i3] = -1;
                iVar.k++;
                iVar.a(this.f76b);
                this.f75a++;
                if (!this.k) {
                    this.j++;
                    int i4 = this.j;
                    int[] iArr = this.f;
                    if (i4 >= iArr.length) {
                        this.k = true;
                        this.j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i5 = 0;
            int i6 = -1;
            while (i2 != -1 && i5 < this.f75a) {
                int[] iArr2 = this.f;
                int i7 = iArr2[i2];
                int i8 = iVar.c;
                if (i7 == i8) {
                    float[] fArr2 = this.h;
                    fArr2[i2] = fArr2[i2] + f2;
                    if (fArr2[i2] == 0.0f) {
                        if (i2 == this.i) {
                            this.i = this.g[i2];
                        } else {
                            int[] iArr3 = this.g;
                            iArr3[i6] = iArr3[i2];
                        }
                        if (z) {
                            iVar.b(this.f76b);
                        }
                        if (this.k) {
                            this.j = i2;
                        }
                        iVar.k--;
                        this.f75a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i8) {
                    i6 = i2;
                }
                i2 = this.g[i2];
                i5++;
            }
            int i9 = this.j;
            int i10 = i9 + 1;
            if (this.k) {
                int[] iArr4 = this.f;
                if (iArr4[i9] != -1) {
                    i9 = iArr4.length;
                }
            } else {
                i9 = i10;
            }
            int[] iArr5 = this.f;
            if (i9 >= iArr5.length && this.f75a < iArr5.length) {
                int i11 = 0;
                while (true) {
                    int[] iArr6 = this.f;
                    if (i11 >= iArr6.length) {
                        break;
                    } else if (iArr6[i11] == -1) {
                        i9 = i11;
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            int[] iArr7 = this.f;
            if (i9 >= iArr7.length) {
                i9 = iArr7.length;
                this.d *= 2;
                this.k = false;
                this.j = i9 - 1;
                this.h = Arrays.copyOf(this.h, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
                this.g = Arrays.copyOf(this.g, this.d);
            }
            this.f[i9] = iVar.c;
            this.h[i9] = f2;
            if (i6 != -1) {
                int[] iArr8 = this.g;
                iArr8[i9] = iArr8[i6];
                iArr8[i6] = i9;
            } else {
                this.g[i9] = this.i;
                this.i = i9;
            }
            iVar.k++;
            iVar.a(this.f76b);
            this.f75a++;
            if (!this.k) {
                this.j++;
            }
            int i12 = this.j;
            int[] iArr9 = this.f;
            if (i12 >= iArr9.length) {
                this.k = true;
                this.j = iArr9.length - 1;
            }
        }
    }

    public final float a(i iVar, boolean z) {
        if (this.e == iVar) {
            this.e = null;
        }
        int i2 = this.i;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f75a) {
            if (this.f[i2] == iVar.c) {
                if (i2 == this.i) {
                    this.i = this.g[i2];
                } else {
                    int[] iArr = this.g;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    iVar.b(this.f76b);
                }
                iVar.k--;
                this.f75a--;
                this.f[i2] = -1;
                if (this.k) {
                    this.j = i2;
                }
                return this.h[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.g[i2];
        }
        return 0.0f;
    }

    public final void a() {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f75a) {
            i iVar = this.c.c[this.f[i2]];
            if (iVar != null) {
                iVar.b(this.f76b);
            }
            i2 = this.g[i2];
            i3++;
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f75a = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(i iVar) {
        int i2 = this.i;
        if (i2 == -1) {
            return false;
        }
        int i3 = 0;
        while (i2 != -1 && i3 < this.f75a) {
            if (this.f[i2] == iVar.c) {
                return true;
            }
            i2 = this.g[i2];
            i3++;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        int i2 = this.i;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f75a) {
            float[] fArr = this.h;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.g[i2];
            i3++;
        }
    }

    private boolean a(i iVar, e eVar) {
        return iVar.k <= 1;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.e.b.i a(a.e.b.e r15) {
        /*
            r14 = this;
            int r0 = r14.i
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x000a:
            r9 = -1
            if (r0 == r9) goto L_0x0097
            int r9 = r14.f75a
            if (r2 >= r9) goto L_0x0097
            float[] r9 = r14.h
            r10 = r9[r0]
            r11 = 981668463(0x3a83126f, float:0.001)
            a.e.b.c r12 = r14.c
            a.e.b.i[] r12 = r12.c
            int[] r13 = r14.f
            r13 = r13[r0]
            r12 = r12[r13]
            int r13 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x0035
            r11 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x0041
            r9[r0] = r3
            a.e.b.b r9 = r14.f76b
            r12.b(r9)
            goto L_0x0040
        L_0x0035:
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0041
            r9[r0] = r3
            a.e.b.b r9 = r14.f76b
            r12.b(r9)
        L_0x0040:
            r10 = 0
        L_0x0041:
            r9 = 1
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 == 0) goto L_0x008f
            a.e.b.i$a r11 = r12.h
            a.e.b.i$a r13 = a.e.b.i.a.UNRESTRICTED
            if (r11 != r13) goto L_0x006b
            if (r4 != 0) goto L_0x0056
            boolean r4 = r14.a((a.e.b.i) r12, (a.e.b.e) r15)
        L_0x0052:
            r6 = r4
            r5 = r10
            r4 = r12
            goto L_0x008f
        L_0x0056:
            int r11 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x005f
            boolean r4 = r14.a((a.e.b.i) r12, (a.e.b.e) r15)
            goto L_0x0052
        L_0x005f:
            if (r6 != 0) goto L_0x008f
            boolean r11 = r14.a((a.e.b.i) r12, (a.e.b.e) r15)
            if (r11 == 0) goto L_0x008f
            r5 = r10
            r4 = r12
            r6 = 1
            goto L_0x008f
        L_0x006b:
            if (r4 != 0) goto L_0x008f
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x008f
            if (r1 != 0) goto L_0x007b
            boolean r1 = r14.a((a.e.b.i) r12, (a.e.b.e) r15)
        L_0x0077:
            r8 = r1
            r7 = r10
            r1 = r12
            goto L_0x008f
        L_0x007b:
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x0084
            boolean r1 = r14.a((a.e.b.i) r12, (a.e.b.e) r15)
            goto L_0x0077
        L_0x0084:
            if (r8 != 0) goto L_0x008f
            boolean r11 = r14.a((a.e.b.i) r12, (a.e.b.e) r15)
            if (r11 == 0) goto L_0x008f
            r7 = r10
            r1 = r12
            r8 = 1
        L_0x008f:
            int[] r9 = r14.g
            r0 = r9[r0]
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0097:
            if (r4 == 0) goto L_0x009a
            return r4
        L_0x009a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.b.a.a(a.e.b.e):a.e.b.i");
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar, b bVar2, boolean z) {
        int i2 = this.i;
        while (true) {
            int i3 = 0;
            while (i2 != -1 && i3 < this.f75a) {
                int i4 = this.f[i2];
                i iVar = bVar2.f104a;
                if (i4 == iVar.c) {
                    float f2 = this.h[i2];
                    a(iVar, z);
                    a aVar = bVar2.d;
                    int i5 = aVar.i;
                    int i6 = 0;
                    while (i5 != -1 && i6 < aVar.f75a) {
                        a(this.c.c[aVar.f[i5]], aVar.h[i5] * f2, z);
                        i5 = aVar.g[i5];
                        i6++;
                    }
                    bVar.f105b += bVar2.f105b * f2;
                    if (z) {
                        bVar2.f104a.b(bVar);
                    }
                    i2 = this.i;
                } else {
                    i2 = this.g[i2];
                    i3++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, b[] bVarArr) {
        int i2 = this.i;
        while (true) {
            int i3 = 0;
            while (i2 != -1 && i3 < this.f75a) {
                i iVar = this.c.c[this.f[i2]];
                if (iVar.d != -1) {
                    float f2 = this.h[i2];
                    a(iVar, true);
                    b bVar2 = bVarArr[iVar.d];
                    if (!bVar2.e) {
                        a aVar = bVar2.d;
                        int i4 = aVar.i;
                        int i5 = 0;
                        while (i4 != -1 && i5 < aVar.f75a) {
                            a(this.c.c[aVar.f[i4]], aVar.h[i4] * f2, true);
                            i4 = aVar.g[i4];
                            i5++;
                        }
                    }
                    bVar.f105b += bVar2.f105b * f2;
                    bVar2.f104a.b(bVar);
                    i2 = this.i;
                } else {
                    i2 = this.g[i2];
                    i3++;
                }
            }
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public i a(boolean[] zArr, i iVar) {
        i.a aVar;
        int i2 = this.i;
        int i3 = 0;
        i iVar2 = null;
        float f2 = 0.0f;
        while (i2 != -1 && i3 < this.f75a) {
            if (this.h[i2] < 0.0f) {
                i iVar3 = this.c.c[this.f[i2]];
                if ((zArr == null || !zArr[iVar3.c]) && iVar3 != iVar && ((aVar = iVar3.h) == i.a.SLACK || aVar == i.a.ERROR)) {
                    float f3 = this.h[i2];
                    if (f3 < f2) {
                        iVar2 = iVar3;
                        f2 = f3;
                    }
                }
            }
            i2 = this.g[i2];
            i3++;
        }
        return iVar2;
    }

    /* access modifiers changed from: package-private */
    public final i a(int i2) {
        int i3 = this.i;
        int i4 = 0;
        while (i3 != -1 && i4 < this.f75a) {
            if (i4 == i2) {
                return this.c.c[this.f[i3]];
            }
            i3 = this.g[i3];
            i4++;
        }
        return null;
    }
}
