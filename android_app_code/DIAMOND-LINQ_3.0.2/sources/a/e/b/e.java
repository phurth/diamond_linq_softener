package a.e.b;

import a.e.b.a.f;
import a.e.b.a.h;
import a.e.b.i;
import java.util.Arrays;
import java.util.HashMap;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static int f108a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static f f109b;
    int c = 0;
    private HashMap<String, i> d = null;
    private a e;
    private int f = 32;
    private int g;
    b[] h;
    public boolean i;
    private boolean[] j;
    int k;
    int l;
    private int m;
    final c n;
    private i[] o;
    private int p;
    private b[] q;
    private final a r;

    interface a {
        i a(e eVar, boolean[] zArr);

        void a(a aVar);

        void a(i iVar);

        void clear();

        i getKey();
    }

    public e() {
        int i2 = this.f;
        this.g = i2;
        this.h = null;
        this.i = false;
        this.j = new boolean[i2];
        this.k = 1;
        this.l = 0;
        this.m = i2;
        this.o = new i[f108a];
        this.p = 0;
        this.q = new b[i2];
        this.h = new b[i2];
        j();
        this.n = new c();
        this.e = new d(this.n);
        this.r = new b(this.n);
    }

    private final void d(b bVar) {
        if (this.l > 0) {
            bVar.d.a(bVar, this.h);
            if (bVar.d.f75a == 0) {
                bVar.e = true;
            }
        }
    }

    public static f e() {
        return f109b;
    }

    private void h() {
        for (int i2 = 0; i2 < this.l; i2++) {
            b bVar = this.h[i2];
            bVar.f104a.f = bVar.f105b;
        }
    }

    private void i() {
        this.f *= 2;
        this.h = (b[]) Arrays.copyOf(this.h, this.f);
        c cVar = this.n;
        cVar.c = (i[]) Arrays.copyOf(cVar.c, this.f);
        int i2 = this.f;
        this.j = new boolean[i2];
        this.g = i2;
        this.m = i2;
        f fVar = f109b;
        if (fVar != null) {
            fVar.d++;
            fVar.o = Math.max(fVar.o, (long) i2);
            f fVar2 = f109b;
            fVar2.A = fVar2.o;
        }
    }

    private void j() {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.h;
            if (i2 < bVarArr.length) {
                b bVar = bVarArr[i2];
                if (bVar != null) {
                    this.n.f106a.a(bVar);
                }
                this.h[i2] = null;
                i2++;
            } else {
                return;
            }
        }
    }

    public i a(Object obj) {
        i iVar = null;
        if (obj == null) {
            return null;
        }
        if (this.k + 1 >= this.g) {
            i();
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            iVar = fVar.e();
            if (iVar == null) {
                fVar.a(this.n);
                iVar = fVar.e();
            }
            int i2 = iVar.c;
            if (i2 == -1 || i2 > this.c || this.n.c[i2] == null) {
                if (iVar.c != -1) {
                    iVar.b();
                }
                this.c++;
                this.k++;
                int i3 = this.c;
                iVar.c = i3;
                iVar.h = i.a.UNRESTRICTED;
                this.n.c[i3] = iVar;
            }
        }
        return iVar;
    }

    public b b() {
        b a2 = this.n.f106a.a();
        if (a2 == null) {
            a2 = new b(this.n);
        } else {
            a2.d();
        }
        i.a();
        return a2;
    }

    public i c() {
        f fVar = f109b;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.k + 1 >= this.g) {
            i();
        }
        i a2 = a(i.a.SLACK, (String) null);
        this.c++;
        this.k++;
        int i2 = this.c;
        a2.c = i2;
        this.n.c[i2] = a2;
        return a2;
    }

    public void f() {
        f fVar = f109b;
        if (fVar != null) {
            fVar.e++;
        }
        if (this.i) {
            f fVar2 = f109b;
            if (fVar2 != null) {
                fVar2.q++;
            }
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= this.l) {
                    z = true;
                    break;
                } else if (!this.h[i2].e) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                a(this.e);
                return;
            }
            f fVar3 = f109b;
            if (fVar3 != null) {
                fVar3.p++;
            }
            h();
            return;
        }
        a(this.e);
    }

    public void g() {
        c cVar;
        int i2 = 0;
        while (true) {
            cVar = this.n;
            i[] iVarArr = cVar.c;
            if (i2 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i2];
            if (iVar != null) {
                iVar.b();
            }
            i2++;
        }
        cVar.f107b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.c, (Object) null);
        HashMap<String, i> hashMap = this.d;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.c = 0;
        this.e.clear();
        this.k = 1;
        for (int i3 = 0; i3 < this.l; i3++) {
            this.h[i3].c = false;
        }
        j();
        this.l = 0;
    }

    private void b(b bVar) {
        bVar.a(this, 0);
    }

    public c d() {
        return this.n;
    }

    public int b(Object obj) {
        i e2 = ((f) obj).e();
        if (e2 != null) {
            return (int) (e2.f + 0.5f);
        }
        return 0;
    }

    private int b(a aVar) {
        float f2;
        boolean z;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.l) {
                z = false;
                break;
            }
            b[] bVarArr = this.h;
            if (bVarArr[i2].f104a.h != i.a.UNRESTRICTED && bVarArr[i2].f105b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar = f109b;
            if (fVar != null) {
                fVar.k++;
            }
            i3++;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            float f3 = Float.MAX_VALUE;
            int i7 = 0;
            while (i4 < this.l) {
                b bVar = this.h[i4];
                if (bVar.f104a.h != i.a.UNRESTRICTED && !bVar.e && bVar.f105b < f2) {
                    int i8 = 1;
                    while (i8 < this.k) {
                        i iVar = this.n.c[i8];
                        float b2 = bVar.d.b(iVar);
                        if (b2 > f2) {
                            int i9 = i7;
                            float f4 = f3;
                            int i10 = i6;
                            int i11 = i5;
                            for (int i12 = 0; i12 < 7; i12++) {
                                float f5 = iVar.g[i12] / b2;
                                if ((f5 < f4 && i12 == i9) || i12 > i9) {
                                    i10 = i8;
                                    i11 = i4;
                                    f4 = f5;
                                    i9 = i12;
                                }
                            }
                            i5 = i11;
                            i6 = i10;
                            f3 = f4;
                            i7 = i9;
                        }
                        i8++;
                        f2 = 0.0f;
                    }
                }
                i4++;
                f2 = 0.0f;
            }
            if (i5 != -1) {
                b bVar2 = this.h[i5];
                bVar2.f104a.d = -1;
                f fVar2 = f109b;
                if (fVar2 != null) {
                    fVar2.j++;
                }
                bVar2.d(this.n.c[i6]);
                i iVar2 = bVar2.f104a;
                iVar2.d = i5;
                iVar2.c(bVar2);
            } else {
                z2 = true;
            }
            if (i3 > this.k / 2) {
                z2 = true;
            }
            f2 = 0.0f;
        }
        return i3;
    }

    private final void c(b bVar) {
        b[] bVarArr = this.h;
        int i2 = this.l;
        if (bVarArr[i2] != null) {
            this.n.f106a.a(bVarArr[i2]);
        }
        b[] bVarArr2 = this.h;
        int i3 = this.l;
        bVarArr2[i3] = bVar;
        i iVar = bVar.f104a;
        iVar.d = i3;
        this.l = i3 + 1;
        iVar.c(bVar);
    }

    public i a() {
        f fVar = f109b;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.k + 1 >= this.g) {
            i();
        }
        i a2 = a(i.a.SLACK, (String) null);
        this.c++;
        this.k++;
        int i2 = this.c;
        a2.c = i2;
        this.n.c[i2] = a2;
        return a2;
    }

    public void c(i iVar, i iVar2, int i2, int i3) {
        b b2 = b();
        i c2 = c();
        c2.e = 0;
        b2.b(iVar, iVar2, c2, i2);
        if (i3 != 6) {
            a(b2, (int) (b2.d.b(c2) * -1.0f), i3);
        }
        a(b2);
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, int i2, int i3) {
        bVar.a(a(i3, (String) null), i2);
    }

    public i a(int i2, String str) {
        f fVar = f109b;
        if (fVar != null) {
            fVar.l++;
        }
        if (this.k + 1 >= this.g) {
            i();
        }
        i a2 = a(i.a.ERROR, str);
        this.c++;
        this.k++;
        int i3 = this.c;
        a2.c = i3;
        a2.e = i2;
        this.n.c[i3] = a2;
        this.e.a(a2);
        return a2;
    }

    public void b(i iVar, i iVar2, int i2, int i3) {
        b b2 = b();
        i c2 = c();
        c2.e = 0;
        b2.a(iVar, iVar2, c2, i2);
        if (i3 != 6) {
            a(b2, (int) (b2.d.b(c2) * -1.0f), i3);
        }
        a(b2);
    }

    private i a(i.a aVar, String str) {
        i a2 = this.n.f107b.a();
        if (a2 == null) {
            a2 = new i(aVar, str);
            a2.a(aVar, str);
        } else {
            a2.b();
            a2.a(aVar, str);
        }
        int i2 = this.p;
        int i3 = f108a;
        if (i2 >= i3) {
            f108a = i3 * 2;
            this.o = (i[]) Arrays.copyOf(this.o, f108a);
        }
        i[] iVarArr = this.o;
        int i4 = this.p;
        this.p = i4 + 1;
        iVarArr[i4] = a2;
        return a2;
    }

    public void b(i iVar, i iVar2, boolean z) {
        b b2 = b();
        i c2 = c();
        c2.e = 0;
        b2.b(iVar, iVar2, c2, 0);
        if (z) {
            a(b2, (int) (b2.d.b(c2) * -1.0f), 1);
        }
        a(b2);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        f fVar = f109b;
        if (fVar != null) {
            fVar.s++;
            fVar.t = Math.max(fVar.t, (long) this.k);
            f fVar2 = f109b;
            fVar2.u = Math.max(fVar2.u, (long) this.l);
        }
        d((b) aVar);
        b(aVar);
        a(aVar, false);
        h();
    }

    public void a(b bVar) {
        i c2;
        if (bVar != null) {
            f fVar = f109b;
            if (fVar != null) {
                fVar.f++;
                if (bVar.e) {
                    fVar.g++;
                }
            }
            if (this.l + 1 >= this.m || this.k + 1 >= this.g) {
                i();
            }
            boolean z = false;
            if (!bVar.e) {
                d(bVar);
                if (!bVar.c()) {
                    bVar.a();
                    if (bVar.a(this)) {
                        i a2 = a();
                        bVar.f104a = a2;
                        c(bVar);
                        this.r.a((a) bVar);
                        a(this.r, true);
                        if (a2.d == -1) {
                            if (bVar.f104a == a2 && (c2 = bVar.c(a2)) != null) {
                                f fVar2 = f109b;
                                if (fVar2 != null) {
                                    fVar2.j++;
                                }
                                bVar.d(c2);
                            }
                            if (!bVar.e) {
                                bVar.f104a.c(bVar);
                            }
                            this.l--;
                        }
                        z = true;
                    }
                    if (!bVar.b()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z) {
                c(bVar);
            }
        }
    }

    private final int a(a aVar, boolean z) {
        f fVar = f109b;
        if (fVar != null) {
            fVar.h++;
        }
        for (int i2 = 0; i2 < this.k; i2++) {
            this.j[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            f fVar2 = f109b;
            if (fVar2 != null) {
                fVar2.i++;
            }
            i3++;
            if (i3 >= this.k * 2) {
                return i3;
            }
            if (aVar.getKey() != null) {
                this.j[aVar.getKey().c] = true;
            }
            i a2 = aVar.a(this, this.j);
            if (a2 != null) {
                boolean[] zArr = this.j;
                int i4 = a2.c;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (a2 != null) {
                int i5 = -1;
                float f2 = Float.MAX_VALUE;
                for (int i6 = 0; i6 < this.l; i6++) {
                    b bVar = this.h[i6];
                    if (bVar.f104a.h != i.a.UNRESTRICTED && !bVar.e && bVar.b(a2)) {
                        float b2 = bVar.d.b(a2);
                        if (b2 < 0.0f) {
                            float f3 = (-bVar.f105b) / b2;
                            if (f3 < f2) {
                                i5 = i6;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    b bVar2 = this.h[i5];
                    bVar2.f104a.d = -1;
                    f fVar3 = f109b;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.d(a2);
                    i iVar = bVar2.f104a;
                    iVar.d = i5;
                    iVar.c(bVar2);
                }
            }
            z2 = true;
        }
        return i3;
    }

    public void a(i iVar, i iVar2, boolean z) {
        b b2 = b();
        i c2 = c();
        c2.e = 0;
        b2.a(iVar, iVar2, c2, 0);
        if (z) {
            a(b2, (int) (b2.d.b(c2) * -1.0f), 1);
        }
        a(b2);
    }

    public void a(i iVar, i iVar2, int i2, float f2, i iVar3, i iVar4, int i3, int i4) {
        int i5 = i4;
        b b2 = b();
        b2.a(iVar, iVar2, i2, f2, iVar3, iVar4, i3);
        if (i5 != 6) {
            b2.a(this, i5);
        }
        a(b2);
    }

    public void a(i iVar, i iVar2, i iVar3, i iVar4, float f2, int i2) {
        b b2 = b();
        b2.a(iVar, iVar2, iVar3, iVar4, f2);
        if (i2 != 6) {
            b2.a(this, i2);
        }
        a(b2);
    }

    public b a(i iVar, i iVar2, int i2, int i3) {
        b b2 = b();
        b2.a(iVar, iVar2, i2);
        if (i3 != 6) {
            b2.a(this, i3);
        }
        a(b2);
        return b2;
    }

    public void a(i iVar, int i2) {
        int i3 = iVar.d;
        if (i3 != -1) {
            b bVar = this.h[i3];
            if (bVar.e) {
                bVar.f105b = (float) i2;
            } else if (bVar.d.f75a == 0) {
                bVar.e = true;
                bVar.f105b = (float) i2;
            } else {
                b b2 = b();
                b2.c(iVar, i2);
                a(b2);
            }
        } else {
            b b3 = b();
            b3.b(iVar, i2);
            a(b3);
        }
    }

    public static b a(e eVar, i iVar, i iVar2, i iVar3, float f2, boolean z) {
        b b2 = eVar.b();
        if (z) {
            eVar.b(b2);
        }
        b2.a(iVar, iVar2, iVar3, f2);
        return b2;
    }

    public void a(h hVar, h hVar2, float f2, int i2) {
        h hVar3 = hVar;
        h hVar4 = hVar2;
        i a2 = a((Object) hVar3.a(f.c.LEFT));
        i a3 = a((Object) hVar3.a(f.c.TOP));
        i a4 = a((Object) hVar3.a(f.c.RIGHT));
        i a5 = a((Object) hVar3.a(f.c.BOTTOM));
        i a6 = a((Object) hVar4.a(f.c.LEFT));
        i a7 = a((Object) hVar4.a(f.c.TOP));
        i a8 = a((Object) hVar4.a(f.c.RIGHT));
        i a9 = a((Object) hVar4.a(f.c.BOTTOM));
        b b2 = b();
        double d2 = (double) f2;
        double sin = Math.sin(d2);
        i iVar = a4;
        double d3 = (double) i2;
        Double.isNaN(d3);
        b2.b(a3, a5, a7, a9, (float) (sin * d3));
        a(b2);
        b b3 = b();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        b3.b(a2, iVar, a6, a8, (float) (cos * d3));
        a(b3);
    }
}
