package com.chandlersystemsinc.signatureappcore.controllers;

import android.content.DialogInterface;

/* compiled from: lambda */
public final /* synthetic */ class A implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ CsMainCoreActivity f1342a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String[] f1343b;

    public /* synthetic */ A(CsMainCoreActivity csMainCoreActivity, String[] strArr) {
        this.f1342a = csMainCoreActivity;
        this.f1343b = strArr;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f1342a.a(this.f1343b, dialogInterface);
    }
}
