package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.view.View;

class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1555a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f1556b;

    d(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.f1556b = fabTransformationBehavior;
        this.f1555a = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1555a.invalidate();
    }
}
