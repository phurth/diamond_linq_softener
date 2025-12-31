package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1561a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f1562b;
    final /* synthetic */ FabTransformationScrimBehavior c;

    g(FabTransformationScrimBehavior fabTransformationScrimBehavior, boolean z, View view) {
        this.c = fabTransformationScrimBehavior;
        this.f1561a = z;
        this.f1562b = view;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f1561a) {
            this.f1562b.setVisibility(4);
        }
    }

    public void onAnimationStart(Animator animator) {
        if (this.f1561a) {
            this.f1562b.setVisibility(0);
        }
    }
}
