package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0150a;
import androidx.recyclerview.widget.RecyclerView;

class D implements C0150a.C0027a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f886a;

    D(RecyclerView recyclerView) {
        this.f886a = recyclerView;
    }

    public RecyclerView.x a(int i) {
        RecyclerView.x a2 = this.f886a.a(i, true);
        if (a2 != null && !this.f886a.o.c(a2.f936b)) {
            return a2;
        }
        return null;
    }

    public void b(int i, int i2) {
        this.f886a.a(i, i2, false);
        this.f886a.ua = true;
    }

    /* access modifiers changed from: package-private */
    public void c(C0150a.b bVar) {
        int i = bVar.f949a;
        if (i == 1) {
            RecyclerView recyclerView = this.f886a;
            recyclerView.w.a(recyclerView, bVar.f950b, bVar.d);
        } else if (i == 2) {
            RecyclerView recyclerView2 = this.f886a;
            recyclerView2.w.b(recyclerView2, bVar.f950b, bVar.d);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.f886a;
            recyclerView3.w.a(recyclerView3, bVar.f950b, bVar.d, bVar.c);
        } else if (i == 8) {
            RecyclerView recyclerView4 = this.f886a;
            recyclerView4.w.a(recyclerView4, bVar.f950b, bVar.d, 1);
        }
    }

    public void d(int i, int i2) {
        this.f886a.a(i, i2, true);
        RecyclerView recyclerView = this.f886a;
        recyclerView.ua = true;
        recyclerView.ra.d += i2;
    }

    public void a(int i, int i2, Object obj) {
        this.f886a.a(i, i2, obj);
        this.f886a.va = true;
    }

    public void b(C0150a.b bVar) {
        c(bVar);
    }

    public void a(C0150a.b bVar) {
        c(bVar);
    }

    public void a(int i, int i2) {
        this.f886a.g(i, i2);
        this.f886a.ua = true;
    }

    public void c(int i, int i2) {
        this.f886a.f(i, i2);
        this.f886a.ua = true;
    }
}
