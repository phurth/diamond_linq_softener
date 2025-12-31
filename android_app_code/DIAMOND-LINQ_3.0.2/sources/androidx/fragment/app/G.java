package androidx.fragment.app;

import a.d.b;
import android.graphics.Rect;
import android.view.View;

class G implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0132h f771a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0132h f772b;
    final /* synthetic */ boolean c;
    final /* synthetic */ b d;
    final /* synthetic */ View e;
    final /* synthetic */ S f;
    final /* synthetic */ Rect g;

    G(C0132h hVar, C0132h hVar2, boolean z, b bVar, View view, S s, Rect rect) {
        this.f771a = hVar;
        this.f772b = hVar2;
        this.c = z;
        this.d = bVar;
        this.e = view;
        this.f = s;
        this.g = rect;
    }

    public void run() {
        I.a(this.f771a, this.f772b, this.c, (b<String, View>) this.d, false);
        View view = this.e;
        if (view != null) {
            this.f.a(view, this.g);
        }
    }
}
