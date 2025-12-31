package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import b.c.a.a.f.f;

class f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b.c.a.a.f.f f1559a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f1560b;

    f(FabTransformationBehavior fabTransformationBehavior, b.c.a.a.f.f fVar) {
        this.f1560b = fabTransformationBehavior;
        this.f1559a = fVar;
    }

    public void onAnimationEnd(Animator animator) {
        f.d revealInfo = this.f1559a.getRevealInfo();
        revealInfo.c = Float.MAX_VALUE;
        this.f1559a.setRevealInfo(revealInfo);
    }
}
