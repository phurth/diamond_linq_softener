package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

class c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1493a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ExtendedFloatingActionButton.a f1494b;
    final /* synthetic */ ExtendedFloatingActionButton c;

    c(ExtendedFloatingActionButton extendedFloatingActionButton, boolean z, ExtendedFloatingActionButton.a aVar) {
        this.c = extendedFloatingActionButton;
        this.f1493a = z;
        this.f1494b = aVar;
    }

    public void onAnimationEnd(Animator animator) {
        int unused = this.c.v = 0;
        Animator unused2 = this.c.w = null;
        ExtendedFloatingActionButton.a aVar = this.f1494b;
        if (aVar != null) {
            aVar.c(this.c);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.c.a(0, this.f1493a);
        int unused = this.c.v = 2;
        Animator unused2 = this.c.w = animator;
    }
}
