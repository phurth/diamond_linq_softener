package a.n;

import a.n.E;
import android.view.View;
import java.util.ArrayList;

/* renamed from: a.n.q  reason: case insensitive filesystem */
class C0062q implements E.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f327a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f328b;
    final /* synthetic */ C0064t c;

    C0062q(C0064t tVar, View view, ArrayList arrayList) {
        this.c = tVar;
        this.f327a = view;
        this.f328b = arrayList;
    }

    public void a(E e) {
    }

    public void b(E e) {
    }

    public void c(E e) {
        e.b((E.c) this);
        this.f327a.setVisibility(8);
        int size = this.f328b.size();
        for (int i = 0; i < size; i++) {
            ((View) this.f328b.get(i)).setVisibility(0);
        }
    }

    public void d(E e) {
    }
}
