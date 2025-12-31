package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;

class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1428a;

    d(e eVar) {
        this.f1428a = eVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1428a.postInvalidate();
    }
}
