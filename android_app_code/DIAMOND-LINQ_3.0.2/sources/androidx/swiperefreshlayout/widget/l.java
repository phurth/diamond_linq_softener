package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class l extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1025a;

    l(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1025a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f1025a;
        float f2 = swipeRefreshLayout.z;
        swipeRefreshLayout.setAnimationProgress(f2 + ((-f2) * f));
        this.f1025a.a(f);
    }
}
