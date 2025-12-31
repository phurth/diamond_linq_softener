package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class v extends x {
    v(RecyclerView.i iVar) {
        super(iVar, (v) null);
    }

    public int a() {
        return this.f993a.q();
    }

    public int b() {
        return this.f993a.q() - this.f993a.o();
    }

    public int c(View view) {
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return this.f993a.g(view) + jVar.topMargin + jVar.bottomMargin;
    }

    public int d(View view) {
        return this.f993a.f(view) - ((RecyclerView.j) view.getLayoutParams()).leftMargin;
    }

    public int e(View view) {
        this.f993a.a(view, true, this.c);
        return this.c.right;
    }

    public int f() {
        return this.f993a.n();
    }

    public int g() {
        return (this.f993a.q() - this.f993a.n()) - this.f993a.o();
    }

    public void a(int i) {
        this.f993a.d(i);
    }

    public int b(View view) {
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return this.f993a.h(view) + jVar.leftMargin + jVar.rightMargin;
    }

    public int f(View view) {
        this.f993a.a(view, true, this.c);
        return this.c.left;
    }

    public int a(View view) {
        return this.f993a.i(view) + ((RecyclerView.j) view.getLayoutParams()).rightMargin;
    }

    public int c() {
        return this.f993a.o();
    }

    public int d() {
        return this.f993a.r();
    }

    public int e() {
        return this.f993a.i();
    }
}
