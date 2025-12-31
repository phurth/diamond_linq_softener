package com.chandlersystemsinc.signatureappcore.controllers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import b.a.a.Fa;

class oa extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ qa f1401a;

    oa(qa qaVar) {
        this.f1401a = qaVar;
    }

    public void onReceive(Context context, Intent intent) {
        qa qaVar;
        int i;
        boolean booleanExtra = intent.getBooleanExtra("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_active", false);
        TextView a2 = this.f1401a.ba;
        if (booleanExtra) {
            qaVar = this.f1401a;
            i = Fa.npm_regen_next_step_menu;
        } else {
            qaVar = this.f1401a;
            i = Fa.npm_regen_now;
        }
        a2.setText(qaVar.a(i));
    }
}
