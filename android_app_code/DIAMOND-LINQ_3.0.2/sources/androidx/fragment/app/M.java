package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;

class M extends Transition.EpicenterCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rect f785a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ N f786b;

    M(N n, Rect rect) {
        this.f786b = n;
        this.f785a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        Rect rect = this.f785a;
        if (rect == null || rect.isEmpty()) {
            return null;
        }
        return this.f785a;
    }
}
