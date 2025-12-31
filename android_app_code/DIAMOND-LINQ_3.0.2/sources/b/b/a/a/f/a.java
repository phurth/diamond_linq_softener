package b.b.a.a.f;

import b.b.a.a.d.b;
import b.b.a.a.j.c;

public class a extends b<b.b.a.a.g.a.a> {
    public a(b.b.a.a.g.a.a aVar) {
        super(aVar);
    }

    public c a(float f, float f2) {
        c a2 = super.a(f, f2);
        if (a2 == null) {
            return null;
        }
        c b2 = b(f, f2);
        b.b.a.a.g.b.a aVar = (b.b.a.a.g.b.a) ((b.b.a.a.g.a.a) this.f1248a).getBarData().a(a2.b());
        if (aVar.Y()) {
            return a(a2, aVar, (float) b2.d, (float) b2.e);
        }
        c.a(b2);
        return a2;
    }

    public c a(c cVar, b.b.a.a.g.b.a aVar, float f, float f2) {
        b bVar = (b) aVar.a(f, f2);
        if (bVar == null) {
            return null;
        }
        if (bVar.h() == null) {
            return cVar;
        }
        f[] g = bVar.g();
        if (g.length <= 0) {
            return null;
        }
        int a2 = a(g, f2);
        c a3 = ((b.b.a.a.g.a.a) this.f1248a).a(aVar.q()).a(cVar.f(), g[a2].f1253b);
        c cVar2 = new c(bVar.d(), bVar.c(), (float) a3.d, (float) a3.e, cVar.b(), a2, cVar.a());
        c.a(a3);
        return cVar2;
    }

    /* access modifiers changed from: protected */
    public int a(f[] fVarArr, float f) {
        if (fVarArr == null || fVarArr.length == 0) {
            return 0;
        }
        if (fVarArr.length <= 0) {
            int max = Math.max(fVarArr.length - 1, 0);
            if (f > fVarArr[max].f1253b) {
                return max;
            }
            return 0;
        }
        fVarArr[0].a(f);
        throw null;
    }

    /* access modifiers changed from: protected */
    public float a(float f, float f2, float f3, float f4) {
        return Math.abs(f - f3);
    }

    /* access modifiers changed from: protected */
    public b.b.a.a.d.c a() {
        return ((b.b.a.a.g.a.a) this.f1248a).getBarData();
    }
}
