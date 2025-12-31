package com.chandlersystemsinc.signatureappcore.controllers;

import android.view.View;

/* compiled from: lambda */
public final /* synthetic */ class B implements View.OnSystemUiVisibilityChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ CsMainCoreActivity f1344a;

    public /* synthetic */ B(CsMainCoreActivity csMainCoreActivity) {
        this.f1344a = csMainCoreActivity;
    }

    public final void onSystemUiVisibilityChange(int i) {
        this.f1344a.c(i);
    }
}
