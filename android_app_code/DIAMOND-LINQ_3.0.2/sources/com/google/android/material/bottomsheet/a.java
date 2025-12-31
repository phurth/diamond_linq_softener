package com.google.android.material.bottomsheet;

import android.view.View;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1474a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1475b;
    final /* synthetic */ BottomSheetBehavior c;

    a(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.c = bottomSheetBehavior;
        this.f1474a = view;
        this.f1475b = i;
    }

    public void run() {
        this.c.a(this.f1474a, this.f1475b);
    }
}
