package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import b.c.a.a.f.f;

class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1557a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Drawable f1558b;
    final /* synthetic */ FabTransformationBehavior c;

    e(FabTransformationBehavior fabTransformationBehavior, f fVar, Drawable drawable) {
        this.c = fabTransformationBehavior;
        this.f1557a = fVar;
        this.f1558b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1557a.setCircularRevealOverlayDrawable((Drawable) null);
    }

    public void onAnimationStart(Animator animator) {
        this.f1557a.setCircularRevealOverlayDrawable(this.f1558b);
    }
}
