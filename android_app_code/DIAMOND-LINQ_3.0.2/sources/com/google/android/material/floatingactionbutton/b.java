package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1491a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f1492b;
    final /* synthetic */ ExtendedFloatingActionButton.a c;
    final /* synthetic */ ExtendedFloatingActionButton d;

    b(ExtendedFloatingActionButton extendedFloatingActionButton, boolean z, ExtendedFloatingActionButton.a aVar) {
        this.d = extendedFloatingActionButton;
        this.f1492b = z;
        this.c = aVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1491a = true;
    }

    public void onAnimationEnd(Animator animator) {
        int unused = this.d.v = 0;
        Animator unused2 = this.d.w = null;
        if (!this.f1491a) {
            this.d.a(this.f1492b ? 8 : 4, this.f1492b);
            ExtendedFloatingActionButton.a aVar = this.c;
            if (aVar != null) {
                aVar.b(this.d);
            }
        }
    }

    public void onAnimationStart(Animator animator) {
        this.d.a(0, this.f1492b);
        int unused = this.d.v = 1;
        Animator unused2 = this.d.w = animator;
        this.f1491a = false;
    }
}
