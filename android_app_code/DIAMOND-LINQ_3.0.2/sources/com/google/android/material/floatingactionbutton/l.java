package com.google.android.material.floatingactionbutton;

import android.view.ViewTreeObserver;

class l implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1503a;

    l(m mVar) {
        this.f1503a = mVar;
    }

    public boolean onPreDraw() {
        this.f1503a.o();
        return true;
    }
}
