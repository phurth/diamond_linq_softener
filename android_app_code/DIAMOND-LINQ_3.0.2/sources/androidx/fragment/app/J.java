package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

class J extends Transition.EpicenterCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f779a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ N f780b;

    J(N n, Rect rect) {
        this.f780b = n;
        this.f779a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f779a;
    }
}
