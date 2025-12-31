package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.g  reason: case insensitive filesystem */
class C0131g extends C0135k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0132h f802a;

    C0131g(C0132h hVar) {
        this.f802a = hVar;
    }

    public View a(int i) {
        View view = this.f802a.G;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + this + " does not have a view");
    }

    public boolean a() {
        return this.f802a.G != null;
    }
}
