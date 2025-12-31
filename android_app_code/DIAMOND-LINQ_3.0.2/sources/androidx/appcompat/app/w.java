package androidx.appcompat.app;

import a.g.i.F;
import a.g.i.G;
import a.g.i.y;
import android.view.View;

class w extends G {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f431a;

    w(x xVar) {
        this.f431a = xVar;
    }

    public void b(View view) {
        this.f431a.r.setAlpha(1.0f);
        this.f431a.u.a((F) null);
        this.f431a.u = null;
    }

    public void c(View view) {
        this.f431a.r.setVisibility(0);
        this.f431a.r.sendAccessibilityEvent(32);
        if (this.f431a.r.getParent() instanceof View) {
            y.F((View) this.f431a.r.getParent());
        }
    }
}
