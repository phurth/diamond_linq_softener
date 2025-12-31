package a.g.i;

import android.animation.ValueAnimator;
import android.view.View;

class D implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ H f198a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f199b;
    final /* synthetic */ E c;

    D(E e, H h, View view) {
        this.c = e;
        this.f198a = h;
        this.f199b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f198a.a(this.f199b);
    }
}
