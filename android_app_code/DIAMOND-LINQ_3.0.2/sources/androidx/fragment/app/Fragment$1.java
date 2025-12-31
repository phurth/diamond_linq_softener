package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.l;

class Fragment$1 implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0132h f770a;

    Fragment$1(C0132h hVar) {
        this.f770a = hVar;
    }

    public void a(l lVar, h.a aVar) {
        View view;
        if (aVar == h.a.ON_STOP && (view = this.f770a.G) != null) {
            view.cancelPendingInputEvents();
        }
    }
}
