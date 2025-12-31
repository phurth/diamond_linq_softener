package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

class f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f1465a;

    f(BottomAppBar bottomAppBar) {
        this.f1465a = bottomAppBar;
    }

    public void onAnimationStart(Animator animator) {
        this.f1465a.fa.onAnimationStart(animator);
        FloatingActionButton a2 = this.f1465a.v();
        if (a2 != null) {
            a2.setTranslationX(this.f1465a.getFabTranslationX());
        }
    }
}
