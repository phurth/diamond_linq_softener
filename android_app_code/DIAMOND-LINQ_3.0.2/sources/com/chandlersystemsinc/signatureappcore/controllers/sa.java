package com.chandlersystemsinc.signatureappcore.controllers;

import b.a.a.C0176ca;
import b.a.a.Fa;
import b.a.a.W;
import b.a.a.d.i;
import b.a.a.pa;
import no.nordicsemi.android.log.BuildConfig;

class sa implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ va f1409a;

    sa(va vaVar) {
        this.f1409a = vaVar;
    }

    public void a(int i) {
        String str;
        String str2;
        if (((pa) this.f1409a.ca.get(i)).r() && this.f1409a.V != null && this.f1409a.W != null) {
            if (i == 2) {
                if (this.f1409a.Z == C0176ca.Standard) {
                    str = this.f1409a.a(Fa.sh_total_gallons_reset_title);
                } else {
                    str = this.f1409a.a(Fa.sh_total_liters_reset_title);
                }
                String str3 = str;
                if (this.f1409a.Z == C0176ca.Standard) {
                    str2 = this.f1409a.a(Fa.sh_total_gallons_reset_message);
                } else {
                    str2 = this.f1409a.a(Fa.sh_total_liters_reset_message);
                }
                W.a(this.f1409a.V, this.f1409a.W, "com.ChandlerSystemsInc.signatureAppCore.controllers.status_and_history_fragment.total_gallons_reset", str3, str2, BuildConfig.FLAVOR);
            } else if (i == 4) {
                W.a(this.f1409a.V, this.f1409a.W, "com.ChandlerSystemsInc.signatureAppCore.controllers.status_and_history_fragment.regen_counter_reset", this.f1409a.a(Fa.sh_regen_counter_reset_title), this.f1409a.a(Fa.sh_regen_counter_reset_message), BuildConfig.FLAVOR);
            }
        }
    }

    public void a(boolean z, String str) {
    }

    public void b(String str) {
        this.f1409a.d(str);
    }

    public void a(String str) {
        this.f1409a.c(str);
    }
}
