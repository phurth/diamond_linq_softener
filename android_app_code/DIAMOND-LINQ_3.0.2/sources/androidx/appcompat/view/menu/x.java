package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;

class x implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f484a;

    x(z zVar) {
        this.f484a = zVar;
    }

    public void onGlobalLayout() {
        if (this.f484a.c() && !this.f484a.j.l()) {
            View view = this.f484a.o;
            if (view == null || !view.isShown()) {
                this.f484a.dismiss();
            } else {
                this.f484a.j.d();
            }
        }
    }
}
