package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class g extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1019a;

    g(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1019a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1019a.setAnimationProgress(1.0f - f);
    }
}
