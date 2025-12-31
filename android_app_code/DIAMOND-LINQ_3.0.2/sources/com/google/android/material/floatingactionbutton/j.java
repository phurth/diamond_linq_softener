package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.m;

class j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1501a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ m.e f1502b;
    final /* synthetic */ m c;

    j(m mVar, boolean z, m.e eVar) {
        this.c = mVar;
        this.f1501a = z;
        this.f1502b = eVar;
    }

    public void onAnimationEnd(Animator animator) {
        int unused = this.c.B = 0;
        Animator unused2 = this.c.v = null;
        m.e eVar = this.f1502b;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void onAnimationStart(Animator animator) {
        this.c.F.a(0, this.f1501a);
        int unused = this.c.B = 2;
        Animator unused2 = this.c.v = animator;
    }
}
