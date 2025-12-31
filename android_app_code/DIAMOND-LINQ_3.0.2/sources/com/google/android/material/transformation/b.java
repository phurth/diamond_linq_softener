package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;

class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ExpandableTransformationBehavior f1552a;

    b(ExpandableTransformationBehavior expandableTransformationBehavior) {
        this.f1552a = expandableTransformationBehavior;
    }

    public void onAnimationEnd(Animator animator) {
        AnimatorSet unused = this.f1552a.f1547b = null;
    }
}
