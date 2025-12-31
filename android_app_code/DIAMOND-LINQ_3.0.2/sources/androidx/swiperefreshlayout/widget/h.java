package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class h extends Animation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1020a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1021b;
    final /* synthetic */ SwipeRefreshLayout c;

    h(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.c = swipeRefreshLayout;
        this.f1020a = i;
        this.f1021b = i2;
    }

    public void applyTransformation(float f, Transformation transformation) {
        d dVar = this.c.D;
        int i = this.f1020a;
        dVar.setAlpha((int) (((float) i) + (((float) (this.f1021b - i)) * f)));
    }
}
