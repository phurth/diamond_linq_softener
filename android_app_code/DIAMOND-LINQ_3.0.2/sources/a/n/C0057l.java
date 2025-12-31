package a.n;

import a.n.E;
import android.view.ViewGroup;

/* renamed from: a.n.l  reason: case insensitive filesystem */
class C0057l extends F {

    /* renamed from: a  reason: collision with root package name */
    boolean f317a = false;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewGroup f318b;
    final /* synthetic */ C0058m c;

    C0057l(C0058m mVar, ViewGroup viewGroup) {
        this.c = mVar;
        this.f318b = viewGroup;
    }

    public void b(E e) {
        S.a(this.f318b, false);
    }

    public void c(E e) {
        if (!this.f317a) {
            S.a(this.f318b, false);
        }
        e.b((E.c) this);
    }

    public void d(E e) {
        S.a(this.f318b, true);
    }
}
