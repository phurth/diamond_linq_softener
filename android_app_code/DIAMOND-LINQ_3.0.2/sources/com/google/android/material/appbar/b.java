package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CoordinatorLayout f1438a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppBarLayout f1439b;
    final /* synthetic */ AppBarLayout.BaseBehavior c;

    b(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.c = baseBehavior;
        this.f1438a = coordinatorLayout;
        this.f1439b = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.c.c(this.f1438a, this.f1439b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
