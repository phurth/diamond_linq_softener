package com.chandlersystemsinc.signatureappcore.controllers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.a.a.ia;
import b.a.a.oa;

class ha extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ la f1387a;

    ha(la laVar) {
        this.f1387a = laVar;
    }

    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.broadcast_extra_valve_address");
        if (!ia.a(stringExtra)) {
            oa c = CsMainCoreActivity.c(stringExtra);
            String a2 = this.f1387a.c(stringExtra);
            if (c != null) {
                c.a(a2);
                if (this.f1387a.na.contains(c)) {
                    int indexOf = this.f1387a.na.indexOf(c);
                    this.f1387a.na.set(indexOf, c);
                    this.f1387a.pa.a(indexOf, (Object) c);
                    return;
                }
                this.f1387a.na.add(c);
                this.f1387a.pa.d(this.f1387a.na.size() - 1);
            }
        }
    }
}
