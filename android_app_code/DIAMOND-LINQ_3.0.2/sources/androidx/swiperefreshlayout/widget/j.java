package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class j extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1023a;

    j(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1023a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        int i;
        SwipeRefreshLayout swipeRefreshLayout = this.f1023a;
        if (!swipeRefreshLayout.L) {
            i = swipeRefreshLayout.B - Math.abs(swipeRefreshLayout.A);
        } else {
            i = swipeRefreshLayout.B;
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.f1023a;
        int i2 = swipeRefreshLayout2.y;
        this.f1023a.setTargetOffsetTopAndBottom((i2 + ((int) (((float) (i - i2)) * f))) - swipeRefreshLayout2.w.getTop());
        this.f1023a.D.a(1.0f - f);
    }
}
