package b.a.a.b;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.Da;
import b.a.a.d.i;
import b.a.a.pa;
import b.a.a.qa;
import b.a.a.ta;
import java.util.List;

public final class d extends RecyclerView.a<ta> {
    private final i c;
    private final List<pa> d;

    public d(List<pa> list, i iVar) {
        this.d = list;
        this.c = iVar;
    }

    /* renamed from: a */
    public void b(ta taVar, int i) {
        pa paVar = this.d.get(i);
        taVar.a(paVar.o());
        taVar.a(paVar.p(), paVar.q());
        taVar.a(paVar.k());
        taVar.b(paVar.t());
        taVar.c(paVar.x());
        taVar.a(paVar.v(), paVar.j(), paVar.i());
        taVar.a(paVar.u(), paVar.a());
        ta taVar2 = taVar;
        taVar2.a(paVar.c(), paVar.r(), paVar.s(), paVar.d(), paVar.e());
        taVar2.a(paVar.w(), paVar.s(), paVar.n(), paVar.m(), paVar.l(), paVar.c());
        if (paVar.g() != null && paVar.h() != null) {
            taVar.a(paVar.b(), paVar.f(), paVar.g(), paVar.h());
        }
    }

    public qa e(int i) {
        return this.d.get(i).k();
    }

    public ta b(ViewGroup viewGroup, int i) {
        return new ta(LayoutInflater.from(viewGroup.getContext()).inflate(Da.item_card, viewGroup, false), this.c);
    }

    public int a() {
        return this.d.size();
    }
}
