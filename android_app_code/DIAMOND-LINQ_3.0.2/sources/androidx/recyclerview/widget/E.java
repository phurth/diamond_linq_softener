package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.RecyclerView;

class E implements N.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.i f887a;

    E(RecyclerView.i iVar) {
        this.f887a = iVar;
    }

    public View a(int i) {
        return this.f887a.c(i);
    }

    public int b() {
        return this.f887a.q() - this.f887a.o();
    }

    public int a() {
        return this.f887a.n();
    }

    public int b(View view) {
        return this.f887a.i(view) + ((RecyclerView.j) view.getLayoutParams()).rightMargin;
    }

    public int a(View view) {
        return this.f887a.f(view) - ((RecyclerView.j) view.getLayoutParams()).leftMargin;
    }
}
