package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1463a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ActionMenuView f1464b;
    final /* synthetic */ int c;
    final /* synthetic */ boolean d;
    final /* synthetic */ BottomAppBar e;

    e(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.e = bottomAppBar;
        this.f1464b = actionMenuView;
        this.c = i;
        this.d = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1463a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f1463a) {
            this.e.b(this.f1464b, this.c, this.d);
        }
    }
}
