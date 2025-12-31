package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1495a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ExtendedFloatingActionButton.a f1496b;
    final /* synthetic */ boolean c;
    final /* synthetic */ ExtendedFloatingActionButton d;

    d(ExtendedFloatingActionButton extendedFloatingActionButton, ExtendedFloatingActionButton.a aVar, boolean z) {
        this.d = extendedFloatingActionButton;
        this.f1496b = aVar;
        this.c = z;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1495a = true;
    }

    public void onAnimationEnd(Animator animator) {
        ExtendedFloatingActionButton.a aVar;
        Animator unused = this.d.x = null;
        if (!this.f1495a && (aVar = this.f1496b) != null) {
            if (this.c) {
                aVar.a(this.d);
            } else {
                aVar.d(this.d);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        Animator unused = this.d.x = animator;
        this.f1495a = false;
    }
}
