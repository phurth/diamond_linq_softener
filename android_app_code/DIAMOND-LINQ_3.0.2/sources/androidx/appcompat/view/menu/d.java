package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.h;

class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f454a;

    d(h hVar) {
        this.f454a = hVar;
    }

    public void onGlobalLayout() {
        if (this.f454a.c() && this.f454a.j.size() > 0 && !this.f454a.j.get(0).f460a.l()) {
            View view = this.f454a.q;
            if (view == null || !view.isShown()) {
                this.f454a.dismiss();
                return;
            }
            for (h.a aVar : this.f454a.j) {
                aVar.f460a.d();
            }
        }
    }
}
