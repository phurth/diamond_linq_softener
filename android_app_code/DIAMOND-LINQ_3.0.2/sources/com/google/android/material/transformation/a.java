package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver;
import b.c.a.a.j.b;

class a implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1550a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1551b;
    final /* synthetic */ b c;
    final /* synthetic */ ExpandableBehavior d;

    a(ExpandableBehavior expandableBehavior, View view, int i, b bVar) {
        this.d = expandableBehavior;
        this.f1550a = view;
        this.f1551b = i;
        this.c = bVar;
    }

    public boolean onPreDraw() {
        this.f1550a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.d.f1546a == this.f1551b) {
            ExpandableBehavior expandableBehavior = this.d;
            b bVar = this.c;
            expandableBehavior.a((View) bVar, this.f1550a, bVar.a(), false);
        }
        return false;
    }
}
