package a.e.b.a;

import a.e.b.a.f;
import a.e.b.a.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
    public static void a(i iVar) {
        if ((iVar.P() & 32) != 32) {
            c(iVar);
            return;
        }
        iVar.Na = true;
        iVar.Ha = false;
        iVar.Ia = false;
        iVar.Ja = false;
        ArrayList<h> arrayList = iVar.ua;
        List<j> list = iVar.Ga;
        boolean z = iVar.k() == h.a.WRAP_CONTENT;
        boolean z2 = iVar.r() == h.a.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (h next : arrayList) {
            next.s = null;
            next.ka = false;
            next.G();
        }
        for (h next2 : arrayList) {
            if (next2.s == null && !a(next2, list, z3)) {
                c(iVar);
                iVar.Na = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (j next3 : list) {
            i = Math.max(i, a(next3, 0));
            i2 = Math.max(i2, a(next3, 1));
        }
        if (z) {
            iVar.a(h.a.FIXED);
            iVar.q(i);
            iVar.Ha = true;
            iVar.Ia = true;
            iVar.Ka = i;
        }
        if (z2) {
            iVar.b(h.a.FIXED);
            iVar.i(i2);
            iVar.Ha = true;
            iVar.Ja = true;
            iVar.La = i2;
        }
        a(list, 0, iVar.t());
        a(list, 1, iVar.j());
    }

    public static void b(i iVar) {
        if (iVar.F[0] == h.a.FIXED) {
            iVar.v.d().i = 1;
            iVar.x.d().i = 1;
            iVar.v.d().f99b = 1;
            iVar.v.d().h = 0.0f;
            iVar.x.d().f99b = 1;
            iVar.x.d().g = iVar.v.d();
            iVar.x.d().h = (float) iVar.t();
        } else {
            iVar.v.j();
            iVar.x.j();
        }
        if (iVar.F[1] == h.a.FIXED) {
            iVar.w.d().i = 1;
            iVar.y.d().i = 1;
            iVar.w.d().f99b = 1;
            iVar.w.d().h = 0.0f;
            iVar.y.d().f99b = 1;
            iVar.y.d().g = iVar.w.d();
            iVar.y.d().h = (float) iVar.j();
            return;
        }
        iVar.w.j();
        iVar.y.j();
    }

    private static void c(i iVar) {
        iVar.Ga.clear();
        iVar.Ga.add(0, new j(iVar.ua));
    }

    private static boolean a(h hVar, List<j> list, boolean z) {
        j jVar = new j(new ArrayList(), true);
        list.add(jVar);
        return a(hVar, jVar, list, z);
    }

    private static boolean a(h hVar, j jVar, List<j> list, boolean z) {
        f fVar;
        f fVar2;
        f fVar3;
        h hVar2;
        f fVar4;
        f fVar5;
        f fVar6;
        f fVar7;
        h hVar3;
        f fVar8;
        if (hVar == null) {
            return true;
        }
        i iVar = (i) hVar.l();
        j jVar2 = hVar.s;
        if (jVar2 == null) {
            hVar.ja = true;
            jVar.f94a.add(hVar);
            hVar.s = jVar;
            if (hVar.v.d == null && hVar.x.d == null && hVar.w.d == null && hVar.y.d == null && hVar.z.d == null && hVar.C.d == null) {
                a(iVar, hVar, jVar);
                if (z) {
                    return false;
                }
            }
            if (!(hVar.w.d == null || hVar.y.d == null)) {
                boolean z2 = iVar.r() == h.a.WRAP_CONTENT;
                if (!(hVar.w.d.f81b == hVar.l() && hVar.y.d.f81b == hVar.l())) {
                    a(iVar, hVar, jVar);
                    if (z) {
                        return false;
                    }
                } else if (z2) {
                    a(iVar, hVar, jVar);
                    return false;
                }
            }
            if (!(hVar.v.d == null || hVar.x.d == null)) {
                boolean z3 = iVar.k() == h.a.WRAP_CONTENT;
                if (!(hVar.v.d.f81b == hVar.l() && hVar.x.d.f81b == hVar.l())) {
                    a(iVar, hVar, jVar);
                    if (z) {
                        return false;
                    }
                } else if (z3) {
                    a(iVar, hVar, jVar);
                    return false;
                }
            }
            if (((hVar.k() == h.a.MATCH_CONSTRAINT) ^ (hVar.r() == h.a.MATCH_CONSTRAINT)) && hVar.J != 0.0f) {
                a(hVar);
            } else if (hVar.k() == h.a.MATCH_CONSTRAINT || hVar.r() == h.a.MATCH_CONSTRAINT) {
                a(iVar, hVar, jVar);
                if (z) {
                    return false;
                }
            }
            if (((hVar.v.d == null && hVar.x.d == null) || (((fVar5 = hVar.v.d) != null && fVar5.f81b == hVar.G && hVar.x.d == null) || (((fVar6 = hVar.x.d) != null && fVar6.f81b == hVar.G && hVar.v.d == null) || ((fVar7 = hVar.v.d) != null && fVar7.f81b == (hVar3 = hVar.G) && (fVar8 = hVar.x.d) != null && fVar8.f81b == hVar3)))) && hVar.C.d == null && !(hVar instanceof l) && !(hVar instanceof m)) {
                jVar.d.add(hVar);
            }
            if (((hVar.w.d == null && hVar.y.d == null) || (((fVar = hVar.w.d) != null && fVar.f81b == hVar.G && hVar.y.d == null) || (((fVar2 = hVar.y.d) != null && fVar2.f81b == hVar.G && hVar.w.d == null) || ((fVar3 = hVar.w.d) != null && fVar3.f81b == (hVar2 = hVar.G) && (fVar4 = hVar.y.d) != null && fVar4.f81b == hVar2)))) && hVar.C.d == null && hVar.z.d == null && !(hVar instanceof l) && !(hVar instanceof m)) {
                jVar.e.add(hVar);
            }
            if (hVar instanceof n) {
                a(iVar, hVar, jVar);
                if (z) {
                    return false;
                }
                n nVar = (n) hVar;
                for (int i = 0; i < nVar.va; i++) {
                    if (!a(nVar.ua[i], jVar, list, z)) {
                        return false;
                    }
                }
            }
            for (f fVar9 : hVar.D) {
                f fVar10 = fVar9.d;
                if (!(fVar10 == null || fVar10.f81b == hVar.l())) {
                    if (fVar9.c == f.c.CENTER) {
                        a(iVar, hVar, jVar);
                        if (z) {
                            return false;
                        }
                    } else {
                        a(fVar9);
                    }
                    if (!a(fVar9.d.f81b, jVar, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (jVar2 != jVar) {
            jVar.f94a.addAll(jVar2.f94a);
            jVar.d.addAll(hVar.s.d);
            jVar.e.addAll(hVar.s.e);
            if (!hVar.s.f95b) {
                jVar.f95b = false;
            }
            list.remove(hVar.s);
            for (h hVar4 : hVar.s.f94a) {
                hVar4.s = jVar;
            }
        }
        return true;
    }

    private static void a(i iVar, h hVar, j jVar) {
        jVar.f95b = false;
        iVar.Na = false;
        hVar.ja = false;
    }

    private static int a(j jVar, int i) {
        int i2 = i * 2;
        List<h> a2 = jVar.a(i);
        int size = a2.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            h hVar = a2.get(i4);
            f[] fVarArr = hVar.D;
            int i5 = i2 + 1;
            i3 = Math.max(i3, a(hVar, i, fVarArr[i5].d == null || !(fVarArr[i2].d == null || fVarArr[i5].d == null), 0));
        }
        jVar.c[i] = i3;
        return i3;
    }

    private static int a(h hVar, int i, boolean z, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int t;
        int i9;
        int i10;
        int i11;
        h hVar2 = hVar;
        int i12 = i;
        boolean z2 = z;
        int i13 = 0;
        if (!hVar2.ja) {
            return 0;
        }
        boolean z3 = hVar2.z.d != null && i12 == 1;
        if (z2) {
            i6 = hVar.d();
            i5 = hVar.j() - hVar.d();
            i4 = i12 * 2;
            i3 = i4 + 1;
        } else {
            i6 = hVar.j() - hVar.d();
            i5 = hVar.d();
            i3 = i12 * 2;
            i4 = i3 + 1;
        }
        f[] fVarArr = hVar2.D;
        if (fVarArr[i3].d == null || fVarArr[i4].d != null) {
            i7 = i3;
            i8 = 1;
        } else {
            i7 = i4;
            i4 = i3;
            i8 = -1;
        }
        int i14 = z3 ? i2 - i6 : i2;
        int b2 = (hVar2.D[i4].b() * i8) + a(hVar, i);
        int i15 = i14 + b2;
        int t2 = (i12 == 0 ? hVar.t() : hVar.j()) * i8;
        Iterator<s> it = hVar2.D[i4].d().f98a.iterator();
        while (it.hasNext()) {
            i13 = Math.max(i13, a(((q) it.next()).c.f81b, i12, z2, i15));
        }
        int i16 = 0;
        for (Iterator<s> it2 = hVar2.D[i7].d().f98a.iterator(); it2.hasNext(); it2 = it2) {
            i16 = Math.max(i16, a(((q) it2.next()).c.f81b, i12, z2, t2 + i15));
        }
        if (z3) {
            i13 -= i6;
            t = i16 + i5;
        } else {
            t = i16 + ((i12 == 0 ? hVar.t() : hVar.j()) * i8);
        }
        int i17 = 1;
        if (i12 == 1) {
            Iterator<s> it3 = hVar2.z.d().f98a.iterator();
            int i18 = 0;
            while (it3.hasNext()) {
                Iterator<s> it4 = it3;
                q qVar = (q) it3.next();
                if (i8 == i17) {
                    i18 = Math.max(i18, a(qVar.c.f81b, i12, z2, i6 + i15));
                    i11 = i7;
                } else {
                    i11 = i7;
                    i18 = Math.max(i18, a(qVar.c.f81b, i12, z2, (i5 * i8) + i15));
                }
                it3 = it4;
                i7 = i11;
                i17 = 1;
            }
            i9 = i7;
            int i19 = i18;
            i10 = (hVar2.z.d().f98a.size() <= 0 || z3) ? i19 : i8 == 1 ? i19 + i6 : i19 - i5;
        } else {
            i9 = i7;
            i10 = 0;
        }
        int max = b2 + Math.max(i13, Math.max(t, i10));
        int i20 = i15 + t2;
        if (i8 != -1) {
            int i21 = i15;
            i15 = i20;
            i20 = i21;
        }
        if (z2) {
            o.a(hVar2, i12, i20);
            hVar2.a(i20, i15, i12);
        } else {
            hVar2.s.a(hVar2, i12);
            hVar2.d(i20, i12);
        }
        if (hVar.c(i) == h.a.MATCH_CONSTRAINT && hVar2.J != 0.0f) {
            hVar2.s.a(hVar2, i12);
        }
        f[] fVarArr2 = hVar2.D;
        if (!(fVarArr2[i4].d == null || fVarArr2[i9].d == null)) {
            h l = hVar.l();
            f[] fVarArr3 = hVar2.D;
            if (fVarArr3[i4].d.f81b == l && fVarArr3[i9].d.f81b == l) {
                hVar2.s.a(hVar2, i12);
            }
        }
        return max;
    }

    private static void a(f fVar) {
        q d = fVar.d();
        f fVar2 = fVar.d;
        if (fVar2 != null && fVar2.d != fVar) {
            fVar2.d().a(d);
        }
    }

    public static void a(List<j> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (h next : list.get(i3).b(i)) {
                if (next.ja) {
                    a(next, i, i2);
                }
            }
        }
    }

    private static void a(h hVar, int i, int i2) {
        int i3 = i * 2;
        f[] fVarArr = hVar.D;
        f fVar = fVarArr[i3];
        f fVar2 = fVarArr[i3 + 1];
        if ((fVar.d == null || fVar2.d == null) ? false : true) {
            o.a(hVar, i, a(hVar, i) + fVar.b());
        } else if (hVar.J == 0.0f || hVar.c(i) != h.a.MATCH_CONSTRAINT) {
            int e = i2 - hVar.e(i);
            int d = e - hVar.d(i);
            hVar.a(d, e, i);
            o.a(hVar, i, d);
        } else {
            int a2 = a(hVar);
            int i4 = (int) hVar.D[i3].d().h;
            fVar2.d().g = fVar.d();
            fVar2.d().h = (float) a2;
            fVar2.d().f99b = 1;
            hVar.a(i4, i4 + a2, i);
        }
    }

    private static int a(h hVar, int i) {
        h hVar2;
        f fVar;
        int i2 = i * 2;
        f[] fVarArr = hVar.D;
        f fVar2 = fVarArr[i2];
        f fVar3 = fVarArr[i2 + 1];
        f fVar4 = fVar2.d;
        if (fVar4 == null || fVar4.f81b != (hVar2 = hVar.G) || (fVar = fVar3.d) == null || fVar.f81b != hVar2) {
            return 0;
        }
        return (int) (((float) (((hVar2.d(i) - fVar2.b()) - fVar3.b()) - hVar.d(i))) * (i == 0 ? hVar.aa : hVar.ba));
    }

    static int a(h hVar) {
        float f;
        if (hVar.J == 0.0f) {
            return -1;
        }
        if (hVar.k() == h.a.MATCH_CONSTRAINT) {
            int j = (int) (((float) hVar.j()) * hVar.J);
            hVar.q(j);
            return j;
        } else if (hVar.r() != h.a.MATCH_CONSTRAINT) {
            return -1;
        } else {
            if (hVar.K == -1) {
                f = ((float) hVar.t()) / hVar.J;
            } else {
                f = ((float) hVar.t()) * hVar.J;
            }
            int i = (int) f;
            hVar.i(i);
            return i;
        }
    }
}
