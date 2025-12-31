package com.chandlersystemsinc.signatureappcore.controllers;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

/* compiled from: lambda */
public final /* synthetic */ class H implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ qa f1355a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ TextView f1356b;
    private final /* synthetic */ TextView c;
    private final /* synthetic */ Switch d;

    public /* synthetic */ H(qa qaVar, TextView textView, TextView textView2, Switch switchR) {
        this.f1355a = qaVar;
        this.f1356b = textView;
        this.c = textView2;
        this.d = switchR;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1355a.a(this.f1356b, this.c, this.d, compoundButton, z);
    }
}
