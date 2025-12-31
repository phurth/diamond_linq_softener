package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f1458a;

    a(BottomAppBar bottomAppBar) {
        this.f1458a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1458a.t();
    }

    public void onAnimationStart(Animator animator) {
        this.f1458a.u();
    }
}
