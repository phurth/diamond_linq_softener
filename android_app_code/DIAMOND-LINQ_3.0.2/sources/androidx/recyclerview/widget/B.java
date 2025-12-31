package androidx.recyclerview.widget;

import androidx.recyclerview.widget.O;
import androidx.recyclerview.widget.RecyclerView;

class B implements O.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f884a;

    B(RecyclerView recyclerView) {
        this.f884a = recyclerView;
    }

    public void a(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        this.f884a.a(xVar, cVar, cVar2);
    }

    public void b(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        this.f884a.l.c(xVar);
        this.f884a.b(xVar, cVar, cVar2);
    }

    public void c(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        xVar.a(false);
        RecyclerView recyclerView = this.f884a;
        if (recyclerView.N) {
            if (recyclerView.W.a(xVar, xVar, cVar, cVar2)) {
                this.f884a.s();
            }
        } else if (recyclerView.W.c(xVar, cVar, cVar2)) {
            this.f884a.s();
        }
    }

    public void a(RecyclerView.x xVar) {
        RecyclerView recyclerView = this.f884a;
        recyclerView.w.a(xVar.f936b, recyclerView.l);
    }
}
