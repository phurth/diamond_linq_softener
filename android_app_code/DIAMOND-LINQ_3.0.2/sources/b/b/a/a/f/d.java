package b.b.a.a.f;

import b.b.a.a.d.h;
import b.b.a.a.d.j;
import b.b.a.a.g.a.a;
import b.b.a.a.j.c;
import java.util.ArrayList;
import java.util.List;

public class d extends a {
    public d(a aVar) {
        super(aVar);
    }

    public c a(float f, float f2) {
        b.b.a.a.d.a barData = ((a) this.f1248a).getBarData();
        c b2 = b(f2, f);
        c a2 = a((float) b2.e, f2, f);
        if (a2 == null) {
            return null;
        }
        b.b.a.a.g.b.a aVar = (b.b.a.a.g.b.a) barData.a(a2.b());
        if (aVar.Y()) {
            return a(a2, aVar, (float) b2.e, (float) b2.d);
        }
        c.a(b2);
        return a2;
    }

    /* access modifiers changed from: protected */
    public List<c> a(b.b.a.a.g.b.d dVar, int i, float f, h.a aVar) {
        j a2;
        ArrayList arrayList = new ArrayList();
        List<j> a3 = dVar.a(f);
        if (a3.size() == 0 && (a2 = dVar.a(f, Float.NaN, aVar)) != null) {
            a3 = dVar.a(a2.d());
        }
        if (a3.size() == 0) {
            return arrayList;
        }
        for (j jVar : a3) {
            c a4 = ((a) this.f1248a).a(dVar.q()).a(jVar.c(), jVar.d());
            arrayList.add(new c(jVar.d(), jVar.c(), (float) a4.d, (float) a4.e, i, dVar.q()));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public float a(float f, float f2, float f3, float f4) {
        return Math.abs(f2 - f4);
    }
}
