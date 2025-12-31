package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;

class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HideBottomViewOnScrollBehavior f1453a;

    a(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.f1453a = hideBottomViewOnScrollBehavior;
    }

    public void onAnimationEnd(Animator animator) {
        ViewPropertyAnimator unused = this.f1453a.c = null;
    }
}
