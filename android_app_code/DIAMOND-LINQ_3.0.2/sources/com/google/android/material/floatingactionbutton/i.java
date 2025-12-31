package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.m;

class i extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1499a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f1500b;
    final /* synthetic */ m.e c;
    final /* synthetic */ m d;

    i(m mVar, boolean z, m.e eVar) {
        this.d = mVar;
        this.f1500b = z;
        this.c = eVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1499a = true;
    }

    public void onAnimationEnd(Animator animator) {
        int unused = this.d.B = 0;
        Animator unused2 = this.d.v = null;
        if (!this.f1499a) {
            this.d.F.a(this.f1500b ? 8 : 4, this.f1500b);
            m.e eVar = this.c;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.d.F.a(0, this.f1500b);
        int unused = this.d.B = 1;
        Animator unused2 = this.d.v = animator;
        this.f1499a = false;
    }
}
