package com.chandlersystemsinc.signatureappcore.controllers;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/* compiled from: lambda */
public final /* synthetic */ class G implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ CsMainCoreActivity f1353a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ TextView f1354b;
    private final /* synthetic */ TextView c;
    private final /* synthetic */ Switch d;

    public /* synthetic */ G(CsMainCoreActivity csMainCoreActivity, TextView textView, TextView textView2, Switch switchR) {
        this.f1353a = csMainCoreActivity;
        this.f1354b = textView;
        this.c = textView2;
        this.d = switchR;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1353a.a(this.f1354b, this.c, this.d, compoundButton, z);
    }
}
