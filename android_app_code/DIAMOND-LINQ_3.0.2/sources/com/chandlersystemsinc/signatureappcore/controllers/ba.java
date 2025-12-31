package com.chandlersystemsinc.signatureappcore.controllers;

import b.a.a.C0176ca;
import b.a.a.Fa;
import b.a.a.W;
import b.a.a.d.i;
import b.a.a.ka;
import b.a.a.pa;
import b.a.a.ra;
import b.a.a.wa;
import no.nordicsemi.android.log.BuildConfig;

class ba implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ea f1376a;

    ba(ea eaVar) {
        this.f1376a = eaVar;
    }

    public void a(int i) {
        int i2 = i;
        pa paVar = (pa) this.f1376a.da.get(i2);
        String p = paVar.p();
        if (paVar.r() && this.f1376a.W != null) {
            if (i2 == 0) {
                W.a(this.f1376a.V, this.f1376a.W, "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.set_time", this.f1376a.a(Fa.db_set_time_title), this.f1376a.a(Fa.db_set_time_message), BuildConfig.FLAVOR);
            } else if (i2 == 6 && this.f1376a.ea == wa.MeteredSoftener) {
                int i3 = this.f1376a.Z == C0176ca.Metric ? 4 : 2;
                int b2 = this.f1376a.Z == C0176ca.Metric ? ka.b(ra.GPG, 99) : 99;
                if (this.f1376a.Z == C0176ca.Metric) {
                    String[] split = p.split("\\s+");
                    try {
                        if (split.length > 0) {
                            p = String.valueOf(Math.round(Double.valueOf(split[0]).doubleValue()));
                        }
                    } catch (Exception unused) {
                    }
                }
                String str = p;
                W.a(this.f1376a.W, "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.water_hardness", this.f1376a.a(Fa.db_water_hardness_title), this.f1376a.a(Fa.db_water_hardness_message), str.concat(this.f1376a.a(Fa.enter_range, 0, Integer.valueOf(b2))), str, i3, 0, b2, (String) null);
            } else if (i2 == 7 && this.f1376a.ea != wa.MeteredSoftener) {
                String a2 = this.f1376a.a(Fa.ci_filter_backwash_freq_title);
                String a3 = this.f1376a.a(Fa.ci_filter_backwash_freq_setting_message);
                if (this.f1376a.ea == wa.TimeClockSoftener) {
                    a2 = this.f1376a.a(Fa.ci_regen_day_override_title);
                    a3 = this.f1376a.a(Fa.ci_regen_day_override_setting_message);
                }
                W.a(this.f1376a.W, "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.backwash_frequency", a2, a3, p.concat(this.f1376a.a(Fa.enter_range, 0, 29)), p, 2, 0, 29, (String) null);
            } else if ((i2 == 3 && this.f1376a.ea != wa.MeteredSoftener) || i2 == 7) {
                W.a(this.f1376a.W, "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.regen_time", this.f1376a.a(Fa.db_regen_time_title), this.f1376a.a(Fa.db_regen_time_message), p.concat(this.f1376a.a(Fa.enter_range, 1, 12)), (String) null, 2, 1, 12, this.f1376a.Y.i(), (String) null);
            }
        }
    }

    public void a(boolean z, String str) {
    }

    public void b(String str) {
        this.f1376a.na();
    }

    public void a(String str) {
        this.f1376a.ja();
    }
}
