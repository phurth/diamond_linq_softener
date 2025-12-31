package a.e.b.a;

import a.e.b.a.h;
import java.util.ArrayList;

public class d {

    /* renamed from: a  reason: collision with root package name */
    protected h f77a;

    /* renamed from: b  reason: collision with root package name */
    protected h f78b;
    protected h c;
    protected h d;
    protected h e;
    protected h f;
    protected h g;
    protected ArrayList<h> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    int l;
    int m;
    int n;
    boolean o;
    private int p;
    private boolean q = false;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    private boolean u;

    public d(h hVar, int i2, boolean z) {
        this.f77a = hVar;
        this.p = i2;
        this.q = z;
    }

    private static boolean a(h hVar, int i2) {
        if (hVar.s() != 8 && hVar.F[i2] == h.a.MATCH_CONSTRAINT) {
            int[] iArr = hVar.h;
            if (iArr[i2] == 0 || iArr[i2] == 3) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        int i2 = this.p * 2;
        h hVar = this.f77a;
        boolean z = true;
        this.o = true;
        h hVar2 = hVar;
        h hVar3 = hVar2;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            h[] hVarArr = hVar2.ra;
            int i3 = this.p;
            h hVar4 = null;
            hVarArr[i3] = null;
            hVar2.qa[i3] = null;
            if (hVar2.s() != 8) {
                this.l++;
                if (hVar2.c(this.p) != h.a.MATCH_CONSTRAINT) {
                    this.m += hVar2.d(this.p);
                }
                this.m += hVar2.D[i2].b();
                int i4 = i2 + 1;
                this.m += hVar2.D[i4].b();
                this.n += hVar2.D[i2].b();
                this.n += hVar2.D[i4].b();
                if (this.f78b == null) {
                    this.f78b = hVar2;
                }
                this.d = hVar2;
                h.a[] aVarArr = hVar2.F;
                int i5 = this.p;
                if (aVarArr[i5] == h.a.MATCH_CONSTRAINT) {
                    int[] iArr = hVar2.h;
                    if (iArr[i5] == 0 || iArr[i5] == 3 || iArr[i5] == 2) {
                        this.j++;
                        float[] fArr = hVar2.pa;
                        int i6 = this.p;
                        float f2 = fArr[i6];
                        if (f2 > 0.0f) {
                            this.k += fArr[i6];
                        }
                        if (a(hVar2, this.p)) {
                            if (f2 < 0.0f) {
                                this.r = true;
                            } else {
                                this.s = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList<>();
                            }
                            this.h.add(hVar2);
                        }
                        if (this.f == null) {
                            this.f = hVar2;
                        }
                        h hVar5 = this.g;
                        if (hVar5 != null) {
                            hVar5.qa[this.p] = hVar2;
                        }
                        this.g = hVar2;
                    }
                    if (this.p == 0) {
                        if (hVar2.f != 0) {
                            this.o = false;
                        } else if (!(hVar2.i == 0 && hVar2.j == 0)) {
                            this.o = false;
                        }
                    } else if (hVar2.g != 0) {
                        this.o = false;
                    } else if (!(hVar2.l == 0 && hVar2.m == 0)) {
                        this.o = false;
                    }
                    if (hVar2.J != 0.0f) {
                        this.o = false;
                    }
                }
            }
            if (hVar3 != hVar2) {
                hVar3.ra[this.p] = hVar2;
            }
            f fVar = hVar2.D[i2 + 1].d;
            if (fVar != null) {
                h hVar6 = fVar.f81b;
                f[] fVarArr = hVar6.D;
                if (fVarArr[i2].d != null && fVarArr[i2].d.f81b == hVar2) {
                    hVar4 = hVar6;
                }
            }
            if (hVar4 == null) {
                hVar4 = hVar2;
                z2 = true;
            }
            hVar3 = hVar2;
            hVar2 = hVar4;
        }
        h hVar7 = this.f78b;
        if (hVar7 != null) {
            this.m -= hVar7.D[i2].b();
        }
        h hVar8 = this.d;
        if (hVar8 != null) {
            this.m -= hVar8.D[i2 + 1].b();
        }
        this.c = hVar2;
        if (this.p != 0 || !this.q) {
            this.e = this.f77a;
        } else {
            this.e = this.c;
        }
        if (!this.s || !this.r) {
            z = false;
        }
        this.t = z;
    }

    public void a() {
        if (!this.u) {
            b();
        }
        this.u = true;
    }
}
