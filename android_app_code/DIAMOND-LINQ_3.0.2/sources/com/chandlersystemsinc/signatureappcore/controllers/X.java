package com.chandlersystemsinc.signatureappcore.controllers;

import b.a.a.C0176ca;
import b.a.a.Fa;
import b.a.a.W;
import b.a.a.Z;
import b.a.a.d.i;
import b.a.a.ka;
import b.a.a.la;
import b.a.a.pa;
import b.a.a.ra;
import b.a.a.wa;

class X implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Z f1371a;

    X(Z z) {
        this.f1371a = z;
    }

    public void a(int i) {
        String str;
        int i2;
        String str2;
        int i3 = i;
        if (((pa) this.f1371a.fa.get(i3)).r()) {
            if (!this.f1371a.ka()) {
                int i4 = 3;
                if (this.f1371a.la == wa.MeteredSoftener && this.f1371a.Y != null) {
                    if (i3 == 1) {
                        if (((pa) this.f1371a.fa.get(i3)).p().equals(this.f1371a.a(Fa.disabled))) {
                            str2 = "0";
                        } else {
                            str2 = ((pa) this.f1371a.fa.get(i3)).p();
                        }
                        String str3 = str2;
                        W.a(this.f1371a.Y, "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.regen_day_override", this.f1371a.a(Fa.ci_regen_day_override_title), this.f1371a.a(Fa.ci_regen_day_override_setting_message), str3.concat(this.f1371a.a(Fa.enter_range_disable, 0, 29)), str3, 2, 0, 29, (String) null);
                    } else if (i3 == 2) {
                        String valueOf = String.valueOf(this.f1371a.aa.m());
                        W.a(this.f1371a.Y, "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.reserve_capacity", this.f1371a.a(Fa.ci_reserve_cap_title), this.f1371a.a(Fa.ci_reserve_cap_setting_message), valueOf.concat(this.f1371a.a(Fa.enter_range, 0, 49)), valueOf, 2, 0, 49, (String) null);
                    } else if (i3 == 3) {
                        if (this.f1371a.ba == C0176ca.Standard) {
                            str = String.valueOf(this.f1371a.aa.o());
                        } else {
                            str = String.valueOf(ka.b(ra.Grains, this.f1371a.aa.o() * 1000));
                        }
                        String str4 = str;
                        if (this.f1371a.ba == C0176ca.Standard) {
                            i2 = 399;
                        } else {
                            i2 = ka.b(ra.Grains, 399000);
                        }
                        W.b(this.f1371a.Y, "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.resin_grains_capacity", this.f1371a.a(Fa.ci_resin_grains_cap_title), this.f1371a.a(Fa.ci_resin_grains_cap_setting_message), str4.concat(this.f1371a.a(Fa.enter_range, 0, Integer.valueOf(i2))), str4, this.f1371a.ba == C0176ca.Standard ? 3 : 5, 0, i2, (String) null);
                    }
                }
                if (this.f1371a.ca) {
                    return;
                }
                if (Z.e(this.f1371a.oa) || Z.f(this.f1371a.oa)) {
                    if (this.f1371a.la == wa.TimeClockSoftener || this.f1371a.la == wa.UltraFilter) {
                        i4 = 0;
                    }
                    if (i3 > i4 && !this.f1371a.ka()) {
                        Z z = this.f1371a;
                        int a2 = z.c(z.a(Fa.ic_brine_pre_fill));
                        boolean x = a2 != -1 ? ((pa) this.f1371a.fa.get(a2)).x() : false;
                        Z z2 = this.f1371a;
                        if (z2.c(z2.a(Fa.ic_brine_soak_duration)) != -1 && x && this.f1371a.Y != null) {
                            String valueOf2 = String.valueOf(this.f1371a.aa.c());
                            W.a(this.f1371a.Y, "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.brine_soak_duration", this.f1371a.a(Fa.ci_brine_soak_title), this.f1371a.a(Fa.ci_brine_soak_setting_message), valueOf2.concat(this.f1371a.a(Fa.enter_range, 1, 4)), valueOf2, 1, 1, 4, (String) null);
                        }
                    }
                }
            } else if (this.f1371a.Y == null) {
            } else {
                if (i3 == 0) {
                    String valueOf3 = String.valueOf(this.f1371a.aa.a());
                    W.a(this.f1371a.Y, "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.air_recharge_frequency", this.f1371a.a(Fa.ci_air_recharge_freq_title), this.f1371a.a(Fa.ci_air_recharge_freq_setting_message), valueOf3.concat(this.f1371a.a(Fa.enter_range, 0, 49)), valueOf3, 1, 0, 49, (String) null);
                } else if (i3 == 1 && this.f1371a.la == wa.CenturionNitroSidekickV3) {
                    String valueOf4 = String.valueOf(this.f1371a.aa.i());
                    W.a(this.f1371a.Y, "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.pulse_chlorine", this.f1371a.a(Fa.ci_pulse_chlorine_title), this.f1371a.a(Fa.ci_pulse_chlorine_setting_message), valueOf4.concat(this.f1371a.a(Fa.enter_range, 0, 4)), valueOf4, 1, 0, 4, (String) null);
                }
            }
        }
    }

    public void a(String str) {
    }

    public void b(String str) {
    }

    public void a(boolean z, String str) {
        if (str.equals(this.f1371a.a(Fa.ic_rental_unit_disable))) {
            byte i = this.f1371a.wa;
            byte unused = this.f1371a.wa = z;
            Z z2 = this.f1371a;
            int a2 = z2.c(z2.a(Fa.ic_rental_unit_disable));
            if (a2 != -1) {
                ((pa) this.f1371a.fa.get(a2)).e(z);
            }
            if (i != this.f1371a.wa) {
                la unused2 = this.f1371a.Ka = la.Pending;
            }
        } else if (str.equals(this.f1371a.a(Fa.ic_brine_pre_fill))) {
            byte j = this.f1371a.xa;
            byte unused3 = this.f1371a.xa = z ? (byte) 1 : 0;
            Z z3 = this.f1371a;
            int a3 = z3.c(z3.a(Fa.ic_brine_pre_fill));
            if (a3 != -1) {
                ((pa) this.f1371a.fa.get(a3)).e(z);
            }
            if (j != this.f1371a.xa) {
                la unused4 = this.f1371a.La = la.Pending;
            }
        }
    }
}
