package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.RecyclerView;

class F implements N.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.i f888a;

    F(RecyclerView.i iVar) {
        this.f888a = iVar;
    }

    public View a(int i) {
        return this.f888a.c(i);
    }

    public int b() {
        return this.f888a.h() - this.f888a.m();
    }

    public int a() {
        return this.f888a.p();
    }

    public int a(View view) {
        return this.f888a.j(view) - ((RecyclerView.j) view.getLayoutParams()).topMargin;
    }

    public int b(View view) {
        return this.f888a.e(view) + ((RecyclerView.j) view.getLayoutParams()).bottomMargin;
    }
}
