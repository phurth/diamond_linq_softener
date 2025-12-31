package b.c.a.a.m;

import a.g.a.a.h;
import android.graphics.Typeface;

class c extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1309a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e f1310b;

    c(e eVar, g gVar) {
        this.f1310b = eVar;
        this.f1309a = gVar;
    }

    public void a(Typeface typeface) {
        e eVar = this.f1310b;
        Typeface unused = eVar.o = Typeface.create(typeface, eVar.e);
        boolean unused2 = this.f1310b.n = true;
        this.f1309a.a(this.f1310b.o, false);
    }

    public void a(int i) {
        boolean unused = this.f1310b.n = true;
        this.f1309a.a(i);
    }
}
