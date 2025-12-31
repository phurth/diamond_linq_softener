package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f1462a;

    d(BottomAppBar bottomAppBar) {
        this.f1462a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1462a.t();
        Animator unused = this.f1462a.U = null;
    }

    public void onAnimationStart(Animator animator) {
        this.f1462a.u();
    }
}
