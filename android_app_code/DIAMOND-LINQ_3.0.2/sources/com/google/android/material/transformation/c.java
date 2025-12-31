package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1553a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f1554b;
    final /* synthetic */ View c;
    final /* synthetic */ FabTransformationBehavior d;

    c(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
        this.d = fabTransformationBehavior;
        this.f1553a = z;
        this.f1554b = view;
        this.c = view2;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f1553a) {
            this.f1554b.setVisibility(4);
            this.c.setAlpha(1.0f);
            this.c.setVisibility(0);
        }
    }

    public void onAnimationStart(Animator animator) {
        if (this.f1553a) {
            this.f1554b.setVisibility(0);
            this.c.setAlpha(0.0f);
            this.c.setVisibility(4);
        }
    }
}
