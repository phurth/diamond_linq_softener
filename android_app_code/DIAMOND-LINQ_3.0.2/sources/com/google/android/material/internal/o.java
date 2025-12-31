package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class o extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f1523a;

    o(p pVar) {
        this.f1523a = pVar;
    }

    public void onAnimationEnd(Animator animator) {
        p pVar = this.f1523a;
        if (pVar.c == animator) {
            pVar.c = null;
        }
    }
}
