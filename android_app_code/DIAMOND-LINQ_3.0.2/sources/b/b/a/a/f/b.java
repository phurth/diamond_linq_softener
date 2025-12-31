package b.b.a.a.f;

import b.b.a.a.c.j;
import b.b.a.a.d.h;
import b.b.a.a.g.a.b;
import b.b.a.a.g.b.d;
import b.b.a.a.j.c;
import java.util.ArrayList;
import java.util.List;

public class b<T extends b.b.a.a.g.a.b> implements e {

    /* renamed from: a  reason: collision with root package name */
    protected T f1248a;

    /* renamed from: b  reason: collision with root package name */
    protected List<c> f1249b = new ArrayList();

    public b(T t) {
        this.f1248a = t;
    }

    public c a(float f, float f2) {
        c b2 = b(f, f2);
        c.a(b2);
        return a((float) b2.d, f, f2);
    }

    /* access modifiers changed from: protected */
    public c b(float f, float f2) {
        return this.f1248a.a(j.a.LEFT).b(f, f2);
    }

    /* access modifiers changed from: protected */
    public List<c> b(float f, float f2, float f3) {
        this.f1249b.clear();
        b.b.a.a.d.c a2 = a();
        if (a2 == null) {
            return this.f1249b;
        }
        int b2 = a2.b();
        for (int i = 0; i < b2; i++) {
            d a3 = a2.a(i);
            if (a3.u()) {
                this.f1249b.addAll(a(a3, i, f, h.a.CLOSEST));
            }
        }
        return this.f1249b;
    }

    /* access modifiers changed from: protected */
    public c a(float f, float f2, float f3) {
        List<c> b2 = b(f, f2, f3);
        if (b2.isEmpty()) {
            return null;
        }
        return a(b2, f2, f3, a(b2, f3, j.a.LEFT) < a(b2, f3, j.a.RIGHT) ? j.a.LEFT : j.a.RIGHT, this.f1248a.getMaxHighlightDistance());
    }

    /* access modifiers changed from: protected */
    public float a(List<c> list, float f, j.a aVar) {
        float f2 = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar.a() == aVar) {
                float abs = Math.abs(a(cVar) - f);
                if (abs < f2) {
                    f2 = abs;
                }
            }
        }
        return f2;
    }

    /* access modifiers changed from: protected */
    public float a(c cVar) {
        return cVar.i();
    }

    /* access modifiers changed from: protected */
    public List<c> a(d dVar, int i, float f, h.a aVar) {
        b.b.a.a.d.j a2;
        ArrayList arrayList = new ArrayList();
        List<b.b.a.a.d.j> a3 = dVar.a(f);
        if (a3.size() == 0 && (a2 = dVar.a(f, Float.NaN, aVar)) != null) {
            a3 = dVar.a(a2.d());
        }
        if (a3.size() == 0) {
            return arrayList;
        }
        for (b.b.a.a.d.j jVar : a3) {
            c a4 = this.f1248a.a(dVar.q()).a(jVar.d(), jVar.c());
            arrayList.add(new c(jVar.d(), jVar.c(), (float) a4.d, (float) a4.e, i, dVar.q()));
        }
        return arrayList;
    }

    public c a(List<c> list, float f, float f2, j.a aVar, float f3) {
        c cVar = null;
        for (int i = 0; i < list.size(); i++) {
            c cVar2 = list.get(i);
            if (aVar == null || cVar2.a() == aVar) {
                float a2 = a(f, f2, cVar2.g(), cVar2.i());
                if (a2 < f3) {
                    cVar = cVar2;
                    f3 = a2;
                }
            }
        }
        return cVar;
    }

    /* access modifiers changed from: protected */
    public float a(float f, float f2, float f3, float f4) {
        return (float) Math.hypot((double) (f - f3), (double) (f2 - f4));
    }

    /* access modifiers changed from: protected */
    public b.b.a.a.d.c a() {
        return this.f1248a.getData();
    }
}
