package a.e.b;

import a.e.b.e;
import a.e.b.i;

public class b implements e.a {

    /* renamed from: a  reason: collision with root package name */
    i f104a = null;

    /* renamed from: b  reason: collision with root package name */
    float f105b = 0.0f;
    boolean c = false;
    public final a d;
    boolean e = false;

    public b(c cVar) {
        this.d = new a(this, cVar);
    }

    public b a(i iVar, i iVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f105b = (float) i;
        }
        if (!z) {
            this.d.a(iVar, -1.0f);
            this.d.a(iVar2, 1.0f);
        } else {
            this.d.a(iVar, 1.0f);
            this.d.a(iVar2, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        i iVar = this.f104a;
        return iVar != null && (iVar.h == i.a.UNRESTRICTED || this.f105b >= 0.0f);
    }

    public b c(i iVar, int i) {
        if (i < 0) {
            this.f105b = (float) (i * -1);
            this.d.a(iVar, 1.0f);
        } else {
            this.f105b = (float) i;
            this.d.a(iVar, -1.0f);
        }
        return this;
    }

    public void clear() {
        this.d.a();
        this.f104a = null;
        this.f105b = 0.0f;
    }

    public void d() {
        this.f104a = null;
        this.d.a();
        this.f105b = 0.0f;
        this.e = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String e() {
        /*
            r9 = this;
            a.e.b.i r0 = r9.f104a
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0029
        L_0x0018:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            a.e.b.i r1 = r9.f104a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0029:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r9.f105b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0056
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r9.f105b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L_0x0057
        L_0x0056:
            r1 = 0
        L_0x0057:
            a.e.b.a r5 = r9.d
            int r5 = r5.f75a
        L_0x005b:
            if (r2 >= r5) goto L_0x00ec
            a.e.b.a r6 = r9.d
            a.e.b.i r6 = r6.a((int) r2)
            if (r6 != 0) goto L_0x0067
            goto L_0x00e8
        L_0x0067:
            a.e.b.a r7 = r9.d
            float r7 = r7.b((int) r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x0073
            goto L_0x00e8
        L_0x0073:
            java.lang.String r6 = r6.toString()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0091
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ba
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00b8
        L_0x0091:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00a7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00ba
        L_0x00a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00b8:
            float r7 = r7 * r8
        L_0x00ba:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00d0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            goto L_0x00e7
        L_0x00d0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L_0x00e7:
            r1 = 1
        L_0x00e8:
            int r2 = r2 + 1
            goto L_0x005b
        L_0x00ec:
            if (r1 != 0) goto L_0x00ff
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00ff:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.b.b.e():java.lang.String");
    }

    public i getKey() {
        return this.f104a;
    }

    public String toString() {
        return e();
    }

    /* access modifiers changed from: package-private */
    public boolean b(i iVar) {
        return this.d.a(iVar);
    }

    /* access modifiers changed from: package-private */
    public b b(i iVar, int i) {
        this.f104a = iVar;
        float f = (float) i;
        iVar.f = f;
        this.f105b = f;
        this.e = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    public i c(i iVar) {
        return this.d.a((boolean[]) null, iVar);
    }

    /* access modifiers changed from: package-private */
    public void d(i iVar) {
        i iVar2 = this.f104a;
        if (iVar2 != null) {
            this.d.a(iVar2, -1.0f);
            this.f104a = null;
        }
        float a2 = this.d.a(iVar, true) * -1.0f;
        this.f104a = iVar;
        if (a2 != 1.0f) {
            this.f105b /= a2;
            this.d.a(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public b a(i iVar, int i) {
        this.d.a(iVar, (float) i);
        return this;
    }

    public boolean c() {
        return this.f104a == null && this.f105b == 0.0f && this.d.f75a == 0;
    }

    public b a(i iVar, i iVar2, i iVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f105b = (float) i;
        }
        if (!z) {
            this.d.a(iVar, -1.0f);
            this.d.a(iVar2, 1.0f);
            this.d.a(iVar3, 1.0f);
        } else {
            this.d.a(iVar, 1.0f);
            this.d.a(iVar2, -1.0f);
            this.d.a(iVar3, -1.0f);
        }
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f105b = (float) i;
        }
        if (!z) {
            this.d.a(iVar, -1.0f);
            this.d.a(iVar2, 1.0f);
            this.d.a(iVar3, -1.0f);
        } else {
            this.d.a(iVar, 1.0f);
            this.d.a(iVar2, -1.0f);
            this.d.a(iVar3, 1.0f);
        }
        return this;
    }

    public b a(float f, float f2, float f3, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f105b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.d.a(iVar, 1.0f);
            this.d.a(iVar2, -1.0f);
            this.d.a(iVar4, 1.0f);
            this.d.a(iVar3, -1.0f);
        } else if (f == 0.0f) {
            this.d.a(iVar, 1.0f);
            this.d.a(iVar2, -1.0f);
        } else if (f3 == 0.0f) {
            this.d.a(iVar3, 1.0f);
            this.d.a(iVar4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.d.a(iVar, 1.0f);
            this.d.a(iVar2, -1.0f);
            this.d.a(iVar4, f4);
            this.d.a(iVar3, -f4);
        }
        return this;
    }

    public b b(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        this.d.a(iVar3, 0.5f);
        this.d.a(iVar4, 0.5f);
        this.d.a(iVar, -0.5f);
        this.d.a(iVar2, -0.5f);
        this.f105b = -f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(i iVar, i iVar2, int i, float f, i iVar3, i iVar4, int i2) {
        if (iVar2 == iVar3) {
            this.d.a(iVar, 1.0f);
            this.d.a(iVar4, 1.0f);
            this.d.a(iVar2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.d.a(iVar, 1.0f);
            this.d.a(iVar2, -1.0f);
            this.d.a(iVar3, -1.0f);
            this.d.a(iVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f105b = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            this.d.a(iVar, -1.0f);
            this.d.a(iVar2, 1.0f);
            this.f105b = (float) i;
        } else if (f >= 1.0f) {
            this.d.a(iVar3, -1.0f);
            this.d.a(iVar4, 1.0f);
            this.f105b = (float) i2;
        } else {
            float f2 = 1.0f - f;
            this.d.a(iVar, f2 * 1.0f);
            this.d.a(iVar2, f2 * -1.0f);
            this.d.a(iVar3, -1.0f * f);
            this.d.a(iVar4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.f105b = (((float) (-i)) * f2) + (((float) i2) * f);
            }
        }
        return this;
    }

    public b a(e eVar, int i) {
        this.d.a(eVar.a(i, "ep"), 1.0f);
        this.d.a(eVar.a(i, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public b a(i iVar, i iVar2, i iVar3, float f) {
        this.d.a(iVar, -1.0f);
        this.d.a(iVar2, 1.0f - f);
        this.d.a(iVar3, f);
        return this;
    }

    public b a(i iVar, i iVar2, i iVar3, i iVar4, float f) {
        this.d.a(iVar, -1.0f);
        this.d.a(iVar2, 1.0f);
        this.d.a(iVar3, f);
        this.d.a(iVar4, -f);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        float f = this.f105b;
        if (f < 0.0f) {
            this.f105b = f * -1.0f;
            this.d.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(e eVar) {
        boolean z;
        i a2 = this.d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            d(a2);
            z = false;
        }
        if (this.d.f75a == 0) {
            this.e = true;
        }
        return z;
    }

    public i a(e eVar, boolean[] zArr) {
        return this.d.a(zArr, (i) null);
    }

    public void a(e.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f104a = null;
            this.d.a();
            int i = 0;
            while (true) {
                a aVar2 = bVar.d;
                if (i < aVar2.f75a) {
                    this.d.a(aVar2.a(i), bVar.d.b(i), true);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void a(i iVar) {
        int i = iVar.e;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.d.a(iVar, f);
    }
}
