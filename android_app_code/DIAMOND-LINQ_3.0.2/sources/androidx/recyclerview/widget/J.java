package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class J extends RecyclerView.f {
    boolean g = true;

    public void a(boolean z) {
        this.g = z;
    }

    public abstract boolean a(RecyclerView.x xVar, int i, int i2, int i3, int i4);

    public abstract boolean a(RecyclerView.x xVar, RecyclerView.x xVar2, int i, int i2, int i3, int i4);

    public boolean b(RecyclerView.x xVar) {
        return !this.g || xVar.o();
    }

    public void c(RecyclerView.x xVar, boolean z) {
    }

    public boolean c(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar.f914a == cVar2.f914a && cVar.f915b == cVar2.f915b) {
            j(xVar);
            return false;
        }
        return a(xVar, cVar.f914a, cVar.f915b, cVar2.f914a, cVar2.f915b);
    }

    public void d(RecyclerView.x xVar, boolean z) {
    }

    public abstract boolean f(RecyclerView.x xVar);

    public abstract boolean g(RecyclerView.x xVar);

    public final void h(RecyclerView.x xVar) {
        n(xVar);
        c(xVar);
    }

    public final void i(RecyclerView.x xVar) {
        o(xVar);
    }

    public final void j(RecyclerView.x xVar) {
        p(xVar);
        c(xVar);
    }

    public final void k(RecyclerView.x xVar) {
        q(xVar);
    }

    public final void l(RecyclerView.x xVar) {
        r(xVar);
        c(xVar);
    }

    public final void m(RecyclerView.x xVar) {
        s(xVar);
    }

    public void n(RecyclerView.x xVar) {
    }

    public void o(RecyclerView.x xVar) {
    }

    public void p(RecyclerView.x xVar) {
    }

    public void q(RecyclerView.x xVar) {
    }

    public void r(RecyclerView.x xVar) {
    }

    public void s(RecyclerView.x xVar) {
    }

    public boolean a(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        if (cVar == null || (cVar.f914a == cVar2.f914a && cVar.f915b == cVar2.f915b)) {
            return f(xVar);
        }
        return a(xVar, cVar.f914a, cVar.f915b, cVar2.f914a, cVar2.f915b);
    }

    public boolean b(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i = cVar.f914a;
        int i2 = cVar.f915b;
        View view = xVar.f936b;
        int left = cVar2 == null ? view.getLeft() : cVar2.f914a;
        int top = cVar2 == null ? view.getTop() : cVar2.f915b;
        if (xVar.q() || (i == left && i2 == top)) {
            return g(xVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(xVar, i, i2, left, top);
    }

    public boolean a(RecyclerView.x xVar, RecyclerView.x xVar2, RecyclerView.f.c cVar, RecyclerView.f.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.f914a;
        int i4 = cVar.f915b;
        if (xVar2.y()) {
            int i5 = cVar.f914a;
            i = cVar.f915b;
            i2 = i5;
        } else {
            i2 = cVar2.f914a;
            i = cVar2.f915b;
        }
        return a(xVar, xVar2, i3, i4, i2, i);
    }

    public final void a(RecyclerView.x xVar, boolean z) {
        c(xVar, z);
        c(xVar);
    }

    public final void b(RecyclerView.x xVar, boolean z) {
        d(xVar, z);
    }
}
