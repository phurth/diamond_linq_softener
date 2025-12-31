package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;

class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f1476a;

    b(BottomSheetBehavior bottomSheetBehavior) {
        this.f1476a = bottomSheetBehavior;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.f1476a.i != null) {
            this.f1476a.i.b(floatValue);
        }
    }
}
