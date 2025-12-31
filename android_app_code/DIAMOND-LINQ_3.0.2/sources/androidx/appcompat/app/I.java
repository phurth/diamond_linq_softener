package androidx.appcompat.app;

import a.g.i.G;
import a.g.i.y;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;

class I extends G {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ L f398a;

    I(L l) {
        this.f398a = l;
    }

    public void b(View view) {
        View view2;
        L l = this.f398a;
        if (l.w && (view2 = l.k) != null) {
            view2.setTranslationY(0.0f);
            this.f398a.h.setTranslationY(0.0f);
        }
        this.f398a.h.setVisibility(8);
        this.f398a.h.setTransitioning(false);
        L l2 = this.f398a;
        l2.B = null;
        l2.l();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f398a.g;
        if (actionBarOverlayLayout != null) {
            y.F(actionBarOverlayLayout);
        }
    }
}
