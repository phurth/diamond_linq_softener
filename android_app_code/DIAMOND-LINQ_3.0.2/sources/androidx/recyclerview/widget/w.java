package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class w extends x {
    w(RecyclerView.i iVar) {
        super(iVar, (v) null);
    }

    public int a() {
        return this.f993a.h();
    }

    public int b() {
        return this.f993a.h() - this.f993a.m();
    }

    public int c(View view) {
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return this.f993a.h(view) + jVar.leftMargin + jVar.rightMargin;
    }

    public int d(View view) {
        return this.f993a.j(view) - ((RecyclerView.j) view.getLayoutParams()).topMargin;
    }

    public int e(View view) {
        this.f993a.a(view, true, this.c);
        return this.c.bottom;
    }

    public int f() {
        return this.f993a.p();
    }

    public int g() {
        return (this.f993a.h() - this.f993a.p()) - this.f993a.m();
    }

    public void a(int i) {
        this.f993a.e(i);
    }

    public int b(View view) {
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        return this.f993a.g(view) + jVar.topMargin + jVar.bottomMargin;
    }

    public int f(View view) {
        this.f993a.a(view, true, this.c);
        return this.c.top;
    }

    public int a(View view) {
        return this.f993a.e(view) + ((RecyclerView.j) view.getLayoutParams()).bottomMargin;
    }

    public int c() {
        return this.f993a.m();
    }

    public int d() {
        return this.f993a.i();
    }

    public int e() {
        return this.f993a.r();
    }
}
