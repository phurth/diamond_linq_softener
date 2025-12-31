package com.chandlersystemsinc.signatureappcore.controllers;

import a.l.a.b;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.C0132h;
import androidx.fragment.app.C0139o;
import androidx.lifecycle.C;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.Ba;
import b.a.a.C0176ca;
import b.a.a.Ca;
import b.a.a.Da;
import b.a.a.Fa;
import b.a.a.G;
import b.a.a.I;
import b.a.a.J;
import b.a.a.b.d;
import b.a.a.c.F;
import b.a.a.c.y;
import b.a.a.d.f;
import b.a.a.e.a;
import b.a.a.la;
import b.a.a.ma;
import b.a.a.pa;
import b.a.a.qa;
import b.a.a.wa;
import b.a.a.za;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public final class Z extends C0132h {
    /* access modifiers changed from: private */
    public static final String[] V = {"com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.position1", "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.position2", "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.position3", "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.position4", "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.position5", "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.position6", "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.position7", "com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.position8"};
    private static final I[] W = {I.Position1, I.Position2, I.Position3, I.Position4, I.Position5, I.Position6, I.Position7, I.Position8};
    /* access modifiers changed from: private */
    public byte Aa;
    /* access modifiers changed from: private */
    public int Ba;
    /* access modifiers changed from: private */
    public final String[] Ca = new String[8];
    /* access modifiers changed from: private */
    public final String[] Da = new String[8];
    /* access modifiers changed from: private */
    public final byte[] Ea = new byte[8];
    private final String[] Fa = new String[8];
    /* access modifiers changed from: private */
    public final la[] Ga = new la[8];
    /* access modifiers changed from: private */
    public la Ha;
    /* access modifiers changed from: private */
    public la Ia;
    /* access modifiers changed from: private */
    public la Ja;
    /* access modifiers changed from: private */
    public la Ka;
    /* access modifiers changed from: private */
    public la La;
    /* access modifiers changed from: private */
    public la Ma;
    /* access modifiers changed from: private */
    public la Na;
    private final BroadcastReceiver Oa;
    private Context X;
    /* access modifiers changed from: private */
    public C0139o Y;
    private f Z;
    /* access modifiers changed from: private */
    public a aa;
    /* access modifiers changed from: private */
    public C0176ca ba = C0176ca.Standard;
    /* access modifiers changed from: private */
    public boolean ca;
    private Handler da;
    private Runnable ea;
    /* access modifiers changed from: private */
    public List<pa> fa;
    /* access modifiers changed from: private */
    public List<pa> ga;
    private pa ha;
    private pa ia;
    private d ja;
    private d ka;
    /* access modifiers changed from: private */
    public wa la;
    private boolean ma = true;
    private boolean na = true;
    /* access modifiers changed from: private */
    public int oa;
    private String pa;
    private String qa;
    private String ra;
    private String sa;
    /* access modifiers changed from: private */
    public byte ta;
    /* access modifiers changed from: private */
    public byte ua;
    /* access modifiers changed from: private */
    public int va;
    /* access modifiers changed from: private */
    public byte wa;
    /* access modifiers changed from: private */
    public byte xa;
    /* access modifiers changed from: private */
    public byte ya;
    /* access modifiers changed from: private */
    public byte za;

    public Z() {
        la laVar = la.Idle;
        this.Ha = laVar;
        this.Ia = laVar;
        this.Ja = laVar;
        this.Ka = laVar;
        this.La = laVar;
        this.Ma = laVar;
        this.Na = laVar;
        this.Oa = new W(this);
    }

    private void ja() {
        if (!ka()) {
            if (this.Ha == la.Sent) {
                if (this.ta != this.aa.k()) {
                    this.Ha = la.Pending;
                } else {
                    this.Ha = la.Idle;
                }
            }
            if (this.Ia == la.Sent) {
                if (this.ua != this.aa.m()) {
                    this.Ia = la.Pending;
                } else {
                    this.Ia = la.Idle;
                }
            }
            if (this.Ja == la.Sent) {
                if (this.va != this.aa.o()) {
                    this.Ja = la.Pending;
                } else {
                    this.Ja = la.Idle;
                }
            }
            if (this.La == la.Sent) {
                if (this.xa == this.aa.h() && this.ya == this.aa.c()) {
                    this.La = la.Idle;
                } else {
                    this.La = la.Pending;
                }
            }
        } else {
            if (this.Ma == la.Sent) {
                if (this.za != this.aa.a()) {
                    this.Ma = la.Pending;
                } else {
                    this.Ma = la.Idle;
                }
            }
            if (this.Na == la.Sent) {
                if (this.Aa != this.aa.i()) {
                    this.Na = la.Pending;
                } else {
                    this.Na = la.Idle;
                }
            }
        }
        int[] g = this.aa.g();
        for (int i = 0; i < this.Ba; i++) {
            la[] laVarArr = this.Ga;
            laVarArr[i] = a(laVarArr[i], this.Ea[i], (byte) g[i]);
        }
    }

    /* access modifiers changed from: private */
    public boolean ka() {
        wa waVar = this.la;
        return (waVar == wa.MeteredSoftener || waVar == wa.TimeClockSoftener || waVar == wa.BackWashingFilter || waVar == wa.UltraFilter) ? false : true;
    }

    private void la() {
        oa();
        ja();
        pa();
        ma();
        d dVar = this.ja;
        if (dVar != null) {
            dVar.c();
        }
        sa();
        na();
        if (this.ma) {
            f fVar = this.Z;
            if (fVar != null) {
                fVar.e();
            }
            this.ma = false;
        }
        f fVar2 = this.Z;
        if (fVar2 != null) {
            fVar2.a(this.aa.j() != 0, this.aa.q());
        }
        this.aa.a(false);
    }

    private void ma() {
        int c;
        if (ka()) {
            if (this.la == wa.CenturionNitroSidekickV3) {
                if (this.Aa == 0) {
                    this.pa = a(Fa.ci_air_draw_title);
                    this.qa = a(Fa.ci_air_draw_cycle_title);
                    this.ra = a(Fa.ci_air_draw_message);
                    this.sa = a(Fa.ci_air_draw_setting_message);
                } else {
                    this.pa = a(Fa.ci_air_draw_pulse_chlorine_title);
                    this.qa = a(Fa.ci_air_draw_pulse_chlorine_cycle_title);
                    this.ra = a(Fa.ci_air_draw_pulse_chlorine_message);
                    this.sa = a(Fa.ci_air_draw_pulse_chlorine_setting_message);
                }
                this.Ca[3] = this.qa;
                this.Da[3] = this.sa;
                this.ga.get(3).g(this.pa);
                this.ga.get(3).c(this.qa);
                this.ga.get(3).b(this.ra);
            }
            this.fa.get(0).h(this.aa.b());
            if (this.la == wa.CenturionNitroSidekickV3 && (c = c(a(Fa.ic_pulse_chlorine))) != -1) {
                this.fa.get(c).h(String.valueOf(this.Aa));
            }
        }
    }

    private void na() {
        int color = w().getColor(za.item_value_blue);
        int color2 = w().getColor(za.item_value_orange);
        int[] g = this.aa.g();
        boolean[] f = this.aa.f();
        if (this.la == wa.UltraFilter) {
            pa paVar = this.ga.get(0);
            paVar.h(String.valueOf(g[2]).concat(this.Fa[2]));
            if (!f[2]) {
                color = color2;
            }
            paVar.b(color);
            paVar.a(!f[2]);
        } else {
            for (int i = 0; i < this.Ba; i++) {
                pa paVar2 = this.ga.get(i);
                paVar2.h(String.valueOf(g[i]).concat(this.Fa[i]));
                paVar2.b(f[i] ? color : color2);
                paVar2.a(!f[i]);
            }
        }
        d dVar = this.ka;
        if (dVar != null) {
            dVar.c();
        }
    }

    private void oa() {
        Context context;
        if (this.ma) {
            if (!this.ca && this.la == wa.CenturionNitroSidekickV3 && (context = this.X) != null) {
                this.fa.add(new pa(context, qa.Value, a(Fa.ic_pulse_chlorine), w().getColor(za.item_value_orange), a(Fa.unit_set), true, false, true, a(Fa.ci_pulse_chlorine_title), a(Fa.ci_pulse_chlorine_message)));
            }
            wa waVar = this.la;
            if (waVar == wa.MeteredSoftener || waVar == wa.TimeClockSoftener || waVar == wa.BackWashingFilter || waVar == wa.UltraFilter) {
                this.xa = this.aa.h();
                this.ya = (byte) this.aa.c();
                int c = c(a(Fa.ic_brine_pre_fill));
                if (c != -1) {
                    pa paVar = this.fa.get(c);
                    boolean z = true;
                    if (this.xa != 1) {
                        z = false;
                    }
                    paVar.e(z);
                }
            } else {
                this.Aa = this.aa.i();
            }
            int[] g = this.aa.g();
            for (int i = 0; i < this.Ba; i++) {
                this.Ea[i] = (byte) g[i];
            }
        }
        if (this.aa.s()) {
            int c2 = c(a(Fa.ic_rental_unit_disable));
            if (c2 != -1) {
                this.fa.get(c2).e(this.aa.r());
                return;
            }
            pa paVar2 = this.ia;
            if (paVar2 != null) {
                paVar2.e(this.aa.r());
            }
            this.fa.add(this.ia);
            return;
        }
        this.fa.remove(this.ia);
    }

    private void pa() {
        if (!ka()) {
            if (this.la == wa.MeteredSoftener) {
                this.fa.get(0).h(String.valueOf(this.aa.e()));
                this.fa.get(1).h(this.aa.l());
                this.fa.get(2).h(this.aa.n());
                this.fa.get(3).h(this.aa.a(this.ba));
            }
            if (this.ca) {
                return;
            }
            if ((!b.a.a.Z.e(this.oa) && !b.a.a.Z.f(this.oa)) || this.La != la.Idle) {
                return;
            }
            if (this.xa == 1) {
                int c = c(a(Fa.ic_brine_soak_duration));
                if (c != -1) {
                    this.fa.get(c).h(this.aa.d());
                    return;
                }
                this.ha.h(this.aa.d());
                this.fa.add(this.ha);
                return;
            }
            this.fa.remove(this.ha);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void qa() {
        /*
            r17 = this;
            r0 = r17
            int r1 = b.a.a.Fa.time_min
            java.lang.String r1 = r0.a((int) r1)
            java.lang.String r2 = " "
            java.lang.String r1 = r2.concat(r1)
            int r3 = b.a.a.Fa.time_sec
            java.lang.String r3 = r0.a((int) r3)
            java.lang.String r2 = r2.concat(r3)
            boolean r3 = r17.ka()
            r4 = 7
            r5 = 6
            r6 = 5
            r7 = 8
            r8 = 2
            r9 = 4
            r10 = 3
            r11 = 1
            r12 = 0
            if (r3 != 0) goto L_0x00a1
            b.a.a.wa r2 = r0.la
            b.a.a.wa r3 = b.a.a.wa.MeteredSoftener
            if (r2 == r3) goto L_0x0035
            b.a.a.wa r3 = b.a.a.wa.TimeClockSoftener
            if (r2 != r3) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r2 = 0
            goto L_0x0036
        L_0x0035:
            r2 = 1
        L_0x0036:
            if (r2 == 0) goto L_0x003a
            r3 = 4
            goto L_0x003b
        L_0x003a:
            r3 = 3
        L_0x003b:
            r0.Ba = r3
            java.lang.String[] r3 = new java.lang.String[r9]
            int r13 = b.a.a.Fa.ci_backwash_title
            java.lang.String r13 = r0.a((int) r13)
            r3[r12] = r13
            if (r2 == 0) goto L_0x004c
            int r13 = b.a.a.Fa.ci_brine_draw_title
            goto L_0x004e
        L_0x004c:
            int r13 = b.a.a.Fa.ci_rest_cycle_title
        L_0x004e:
            java.lang.String r13 = r0.a((int) r13)
            r3[r11] = r13
            int r13 = b.a.a.Fa.ci_rapid_rinse_title
            java.lang.String r13 = r0.a((int) r13)
            r3[r8] = r13
            int r13 = b.a.a.Fa.ci_brine_refill_title
            java.lang.String r13 = r0.a((int) r13)
            r3[r10] = r13
            java.lang.String[] r13 = new java.lang.String[r9]
            int r14 = b.a.a.Fa.ci_backwash_setting_message
            java.lang.String r14 = r0.a((int) r14)
            r13[r12] = r14
            if (r2 == 0) goto L_0x0073
            int r2 = b.a.a.Fa.ci_brine_draw_setting_message
            goto L_0x0075
        L_0x0073:
            int r2 = b.a.a.Fa.ci_rest_setting_message
        L_0x0075:
            java.lang.String r2 = r0.a((int) r2)
            r13[r11] = r2
            int r2 = b.a.a.Fa.ci_rapid_rinse_setting_message
            java.lang.String r2 = r0.a((int) r2)
            r13[r8] = r2
            int r2 = b.a.a.Fa.ci_brine_refill_setting_message
            java.lang.String r2 = r0.a((int) r2)
            r13[r10] = r2
            java.lang.String[] r2 = new java.lang.String[r7]
            r2[r12] = r1
            r2[r11] = r1
            r2[r8] = r1
            r2[r10] = r1
            r2[r9] = r1
            r2[r6] = r1
            r2[r5] = r1
            r2[r4] = r1
            r15 = r3
            r5 = r13
            goto L_0x01c8
        L_0x00a1:
            b.a.a.wa r3 = r0.la
            b.a.a.wa r13 = b.a.a.wa.CenturionNitro
            if (r3 != r13) goto L_0x00a9
            r3 = 1
            goto L_0x00aa
        L_0x00a9:
            r3 = 0
        L_0x00aa:
            b.a.a.wa r13 = r0.la
            b.a.a.wa r14 = b.a.a.wa.CenturionNitroSidekick
            if (r13 == r14) goto L_0x00b7
            b.a.a.wa r14 = b.a.a.wa.CenturionNitroSidekickV3
            if (r13 != r14) goto L_0x00b5
            goto L_0x00b7
        L_0x00b5:
            r13 = 0
            goto L_0x00b8
        L_0x00b7:
            r13 = 1
        L_0x00b8:
            if (r3 != 0) goto L_0x00bf
            if (r13 == 0) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r14 = 0
            goto L_0x00c0
        L_0x00bf:
            r14 = 1
        L_0x00c0:
            b.a.a.wa r15 = r0.la
            b.a.a.wa r4 = b.a.a.wa.NitroPro
            if (r15 != r4) goto L_0x00c8
            r4 = 1
            goto L_0x00c9
        L_0x00c8:
            r4 = 0
        L_0x00c9:
            if (r14 == 0) goto L_0x00cd
            r15 = 5
            goto L_0x00cf
        L_0x00cd:
            r15 = 8
        L_0x00cf:
            r0.Ba = r15
            java.lang.String[] r15 = new java.lang.String[r7]
            int r7 = b.a.a.Fa.ci_air_release_title
            java.lang.String r7 = r0.a((int) r7)
            r15[r12] = r7
            if (r14 == 0) goto L_0x00e0
            int r7 = b.a.a.Fa.ci_backwash_title
            goto L_0x00e2
        L_0x00e0:
            int r7 = b.a.a.Fa.ci_chlorine_draw_cycle_title
        L_0x00e2:
            java.lang.String r7 = r0.a((int) r7)
            r15[r11] = r7
            if (r14 == 0) goto L_0x00ed
            int r7 = b.a.a.Fa.ci_rest_cycle_title
            goto L_0x00ef
        L_0x00ed:
            int r7 = b.a.a.Fa.ci_chlorine_rinse_cycle_title
        L_0x00ef:
            java.lang.String r7 = r0.a((int) r7)
            r15[r8] = r7
            if (r3 == 0) goto L_0x00fe
            int r7 = b.a.a.Fa.ci_rapid_rinse_title
        L_0x00f9:
            java.lang.String r7 = r0.a((int) r7)
            goto L_0x0106
        L_0x00fe:
            if (r13 == 0) goto L_0x0103
            java.lang.String r7 = r0.pa
            goto L_0x0106
        L_0x0103:
            int r7 = b.a.a.Fa.ci_chlorine_contact_title
            goto L_0x00f9
        L_0x0106:
            r15[r10] = r7
            if (r3 == 0) goto L_0x010d
            java.lang.String r7 = r0.pa
            goto L_0x0118
        L_0x010d:
            if (r13 == 0) goto L_0x0112
            int r7 = b.a.a.Fa.ci_rapid_rinse_title
            goto L_0x0114
        L_0x0112:
            int r7 = b.a.a.Fa.ci_backwash_title
        L_0x0114:
            java.lang.String r7 = r0.a((int) r7)
        L_0x0118:
            r15[r9] = r7
            int r7 = b.a.a.Fa.ci_chlorine_contact_cycle_title
            java.lang.String r7 = r0.a((int) r7)
            r15[r6] = r7
            if (r4 == 0) goto L_0x012b
            int r7 = b.a.a.Fa.ci_rapid_rinse_title
            java.lang.String r7 = r0.a((int) r7)
            goto L_0x012d
        L_0x012b:
            java.lang.String r7 = r0.pa
        L_0x012d:
            r15[r5] = r7
            if (r4 == 0) goto L_0x0134
            java.lang.String r7 = r0.pa
            goto L_0x013a
        L_0x0134:
            int r7 = b.a.a.Fa.ci_rapid_rinse_title
            java.lang.String r7 = r0.a((int) r7)
        L_0x013a:
            r16 = 7
            r15[r16] = r7
            r7 = 8
            java.lang.String[] r5 = new java.lang.String[r7]
            int r7 = b.a.a.Fa.ci_air_release_setting_message
            java.lang.String r7 = r0.a((int) r7)
            r5[r12] = r7
            if (r14 == 0) goto L_0x014f
            int r7 = b.a.a.Fa.ci_backwash_setting_message
            goto L_0x0151
        L_0x014f:
            int r7 = b.a.a.Fa.ci_chlorine_draw_setting_message
        L_0x0151:
            java.lang.String r7 = r0.a((int) r7)
            r5[r11] = r7
            if (r14 == 0) goto L_0x015c
            int r7 = b.a.a.Fa.ci_rest_setting_message
            goto L_0x015e
        L_0x015c:
            int r7 = b.a.a.Fa.ci_chlorine_rinse_setting_message
        L_0x015e:
            java.lang.String r7 = r0.a((int) r7)
            r5[r8] = r7
            if (r3 == 0) goto L_0x016d
            int r7 = b.a.a.Fa.ci_rapid_rinse_setting_message
        L_0x0168:
            java.lang.String r7 = r0.a((int) r7)
            goto L_0x0175
        L_0x016d:
            if (r13 == 0) goto L_0x0172
            int r7 = b.a.a.Fa.ci_air_draw_setting_message
            goto L_0x0168
        L_0x0172:
            int r7 = b.a.a.Fa.ci_chlorine_contact_setting_message
            goto L_0x0168
        L_0x0175:
            r5[r10] = r7
            if (r3 == 0) goto L_0x0180
            int r3 = b.a.a.Fa.ci_air_draw_setting_message
        L_0x017b:
            java.lang.String r3 = r0.a((int) r3)
            goto L_0x0188
        L_0x0180:
            if (r13 == 0) goto L_0x0185
            int r3 = b.a.a.Fa.ci_rapid_rinse_setting_message
            goto L_0x017b
        L_0x0185:
            int r3 = b.a.a.Fa.ci_backwash_setting_message
            goto L_0x017b
        L_0x0188:
            r5[r9] = r3
            int r3 = b.a.a.Fa.ci_rest_setting_message
            java.lang.String r3 = r0.a((int) r3)
            r5[r6] = r3
            if (r4 == 0) goto L_0x0197
            int r3 = b.a.a.Fa.ci_rapid_rinse_setting_message
            goto L_0x0199
        L_0x0197:
            int r3 = b.a.a.Fa.ci_air_draw_setting_message
        L_0x0199:
            java.lang.String r3 = r0.a((int) r3)
            r7 = 6
            r5[r7] = r3
            if (r4 == 0) goto L_0x01a5
            int r3 = b.a.a.Fa.ci_air_draw_setting_message
            goto L_0x01a7
        L_0x01a5:
            int r3 = b.a.a.Fa.ci_rapid_rinse_setting_message
        L_0x01a7:
            java.lang.String r3 = r0.a((int) r3)
            r4 = 7
            r5[r4] = r3
            r3 = 8
            java.lang.String[] r3 = new java.lang.String[r3]
            r3[r12] = r1
            if (r14 == 0) goto L_0x01b7
            r2 = r1
        L_0x01b7:
            r3[r11] = r2
            r3[r8] = r1
            r3[r10] = r1
            r3[r9] = r1
            r3[r6] = r1
            r2 = 6
            r3[r2] = r1
            r2 = 7
            r3[r2] = r1
            r2 = r3
        L_0x01c8:
            int r1 = r0.Ba
            if (r12 >= r1) goto L_0x01e7
            b.a.a.la[] r1 = r0.Ga
            b.a.a.la r3 = b.a.a.la.Idle
            r1[r12] = r3
            java.lang.String[] r1 = r0.Ca
            r3 = r15[r12]
            r1[r12] = r3
            java.lang.String[] r1 = r0.Da
            r3 = r5[r12]
            r1[r12] = r3
            java.lang.String[] r1 = r0.Fa
            r3 = r2[r12]
            r1[r12] = r3
            int r12 = r12 + 1
            goto L_0x01c8
        L_0x01e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.Z.qa():void");
    }

    private boolean ra() {
        for (int i = 0; i < this.Ba; i++) {
            if (this.Ga[i] == la.Pending) {
                return true;
            }
        }
        la laVar = this.Ha;
        la laVar2 = la.Pending;
        if (laVar == laVar2 || this.Ia == laVar2 || this.Ja == laVar2 || this.Ka == laVar2 || this.La == laVar2 || this.Ma == laVar2 || this.Na == laVar2) {
            return true;
        }
        return false;
    }

    private void sa() {
        if (this.aa.s() && c(a(Fa.ic_rental_unit_disable)) != -1) {
            this.fa.remove(this.ia);
            this.fa.add(this.ia);
        }
    }

    private void ta() {
        Handler handler = this.da;
        if (handler != null) {
            handler.removeCallbacks(this.ea);
        }
        this.da = new Handler();
        Handler handler2 = this.da;
        C0202a aVar = new C0202a(this);
        this.ea = aVar;
        handler2.post(aVar);
    }

    public void P() {
        super.P();
        this.na = false;
        Context m = m();
        if (m != null) {
            b.a(m).a(this.Oa);
        }
    }

    public void Q() {
        super.Q();
        this.na = true;
        Context m = m();
        if (m != null) {
            b.a(m).a(this.Oa, new IntentFilter("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_positive"));
        }
    }

    public void S() {
        super.S();
        Handler handler = this.da;
        if (handler != null) {
            handler.removeCallbacks(this.ea);
        }
    }

    public /* synthetic */ void ia() {
        if (CsMainCoreActivity.A()) {
            if (this.na) {
                if (ra()) {
                    if (!ka()) {
                        la laVar = this.Ha;
                        la laVar2 = la.Pending;
                        if (laVar == laVar2) {
                            a(G.e(J.AdvancedSettings, this.ta));
                            this.Ha = la.Sent;
                        } else if (this.Ia == laVar2) {
                            a(G.g(J.AdvancedSettings, this.ua));
                            this.Ia = la.Sent;
                        } else if (this.Ja == laVar2) {
                            a(G.b(J.AdvancedSettings, this.va));
                            this.Ja = la.Sent;
                        } else if (this.La == laVar2) {
                            a(G.a(J.AdvancedSettings, this.xa, this.ya));
                            f fVar = this.Z;
                            if (fVar != null) {
                                fVar.a(150);
                            }
                            this.La = la.Sent;
                        }
                    } else {
                        la laVar3 = this.Ma;
                        la laVar4 = la.Pending;
                        if (laVar3 == laVar4) {
                            a(G.b(J.AdvancedSettings, this.za));
                            this.Ma = la.Sent;
                        } else if (this.Na == laVar4) {
                            a(G.d(J.AdvancedSettings, this.Aa));
                            this.Na = la.Sent;
                        }
                    }
                    if (this.Ka == la.Pending) {
                        a(G.f(J.AdvancedSettings, this.wa));
                        f fVar2 = this.Z;
                        if (fVar2 != null) {
                            fVar2.a(150);
                        }
                        this.Ka = la.Sent;
                    }
                    for (int i = 0; i < this.Ba; i++) {
                        if (this.Ga[i] == la.Pending) {
                            a(G.a(J.AdvancedSettings, W[i], this.Ea[i]));
                            this.Ga[i] = la.Sent;
                        }
                    }
                } else {
                    a(G.a(J.AdvancedSettings));
                }
            }
            this.da.postDelayed(this.ea, 1000);
            return;
        }
        this.aa.t();
        f fVar3 = this.Z;
        if (fVar3 != null) {
            fVar3.o();
        }
        this.da.postDelayed(this.ea, 3000);
    }

    private void b(Activity activity) {
        try {
            this.Z = (f) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString().concat(" must implement CsFragmentEvents"));
        }
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        this.aa = new a();
        this.X = m();
        this.Y = r();
        this.ba = ma.c(this.X);
        this.pa = a(Fa.ci_air_draw_title);
        this.qa = a(Fa.ci_air_draw_info_title);
        this.ra = a(Fa.ci_air_draw_message);
        this.sa = a(Fa.ci_air_draw_setting_message);
        if (k() != null) {
            this.oa = k().getInt("com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.firmware_version", 0);
            this.la = wa.a(k().getInt("com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.valve_type", -1));
            this.ca = k().getBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.is_classic", false);
        } else {
            f fVar = this.Z;
            if (fVar != null) {
                fVar.j();
            }
        }
        if (!(f() == null || this.X == null)) {
            ((F) C.a(f()).a(F.class)).c().a(this, new C0203b(this));
        }
        qa();
    }

    public static Z a(int i, wa waVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.firmware_version", i);
        bundle.putInt("com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.valve_type", waVar.a());
        bundle.putBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.advanced_settings_fragment.is_classic", z);
        Z z2 = new Z();
        z2.m(bundle);
        return z2;
    }

    public /* synthetic */ void a(y yVar) {
        this.aa.a(this.X, yVar.a(), this.oa, yVar.b(), yVar.c());
        if (this.aa.p()) {
            la();
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        wa waVar;
        String str2;
        String str3;
        String str4;
        String str5;
        View inflate = layoutInflater.inflate(Da.fragment_advanced_settings, viewGroup, false);
        f fVar = this.Z;
        if (fVar != null) {
            fVar.b(w().getString(Fa.bt_status_loading));
        }
        int color = w().getColor(za.item_value_blue);
        int color2 = w().getColor(za.item_value_orange);
        String a2 = a(Fa.unit_set);
        this.fa = new ArrayList();
        if (!ka()) {
            if (this.la == wa.MeteredSoftener) {
                if (this.ba == C0176ca.Standard) {
                    str2 = a(Fa.ci_reserve_cap_message);
                } else {
                    str2 = a(Fa.ci_reserve_cap_metric_message);
                }
                String str6 = str2;
                if (this.ba == C0176ca.Standard) {
                    str3 = a(Fa.ic_resin_grains_capacity);
                } else {
                    str3 = a(Fa.ic_resin_grains_capacity_metric);
                }
                String str7 = str3;
                if (this.ba == C0176ca.Standard) {
                    str4 = a(Fa.ci_resin_grains_cap_title);
                } else {
                    str4 = a(Fa.ci_resin_grains_cap_metric_title);
                }
                String str8 = str4;
                if (this.ba == C0176ca.Standard) {
                    str5 = a(Fa.ci_resin_grains_cap_message);
                } else {
                    str5 = a(Fa.ci_resin_grains_cap_metric_message);
                }
                String str9 = str5;
                List<pa> list = this.fa;
                pa paVar = r5;
                str = a2;
                pa paVar2 = new pa(inflate.getContext(), qa.Value, a(Fa.ic_days_until_regeneration), color, BuildConfig.FLAVOR, false, false, true, a(Fa.ci_days_until_regeneration_title), a(Fa.ci_days_until_regeneration_message));
                list.add(paVar);
                int i = color2;
                String str10 = str;
                this.fa.add(new pa(inflate.getContext(), qa.Value, a(Fa.ic_regeneration_day_override), i, str10, true, false, true, a(Fa.ci_regen_day_override_title), a(Fa.ci_regen_day_override_message)));
                this.fa.add(new pa(inflate.getContext(), qa.Value, a(Fa.ic_reserve_capacity), i, str10, true, false, true, a(Fa.ci_reserve_cap_title), str6));
                this.fa.add(new pa(inflate.getContext(), qa.Value, str7, i, str10, true, false, true, str8, str9));
            } else {
                str = a2;
            }
            if (!this.ca && ((b.a.a.Z.e(this.oa) || b.a.a.Z.f(this.oa)) && ((waVar = this.la) == wa.MeteredSoftener || waVar == wa.TimeClockSoftener))) {
                this.fa.add(new pa(inflate.getContext(), qa.Toggle, a(Fa.ic_brine_pre_fill), color2, (String) null, true, false, true, a(Fa.ci_brine_preFill_title), a(Fa.ci_brine_preFill_message)));
            }
            if (!this.ca) {
                this.ha = new pa(inflate.getContext(), qa.Value, a(Fa.ic_brine_soak_duration), color2, str, true, false, true, a(Fa.ci_brine_soak_title), a(Fa.ci_brine_soak_message));
            }
        } else {
            str = a2;
            this.fa.add(new pa(inflate.getContext(), qa.Value, a(Fa.ic_air_charge_frequency), color2, str, true, false, true, a(Fa.ci_air_recharge_freq_title), a(Fa.ci_air_recharge_freq_message)));
        }
        Context context = this.X;
        if (context != null) {
            this.ia = new pa(context, qa.Toggle, a(Fa.ic_rental_unit_disable), 0, (String) null, true, false, false, (String) null, (String) null);
        }
        boolean z = w().getConfiguration().orientation == 1;
        int integer = w().getInteger(Ca.span_count_min);
        int integer2 = w().getInteger(Ca.span_count_max);
        if (!z) {
            integer = integer2;
        }
        this.ja = new d(this.fa, new X(this));
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(Ba.option_list);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setLayoutManager(new GridLayoutManager(f(), integer));
        recyclerView.setAdapter(this.ja);
        RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof androidx.recyclerview.widget.J) {
            itemAnimator.a(0);
            ((androidx.recyclerview.widget.J) itemAnimator).a(false);
        }
        this.ga = new ArrayList();
        if (!ka()) {
            wa waVar2 = this.la;
            if (waVar2 == wa.MeteredSoftener || waVar2 == wa.TimeClockSoftener) {
                int i2 = color2;
                String str11 = str;
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_backwash), i2, str11, true, false, true, a(Fa.ci_backwash_title), a(Fa.ci_backwash_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_brine_draw_slow_rinse), i2, str11, true, false, true, a(Fa.ci_brine_draw_title), a(Fa.ci_brine_draw_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rapid_rinse), i2, str11, true, false, true, a(Fa.ci_rapid_rinse_title), a(Fa.ci_rapid_rinse_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_brine_refill), i2, str11, true, false, true, a(Fa.ci_brine_refill_title), a(Fa.ci_brine_refill_message)));
            } else if (waVar2 == wa.UltraFilter) {
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_backwash), color2, str, true, false, true, a(Fa.ci_rapid_rinse_title), a(Fa.ci_rapid_rinse_message)));
            } else {
                int i3 = color2;
                String str12 = str;
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_backwash), i3, str12, true, false, true, a(Fa.ci_backwash_title), a(Fa.ci_backwash_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rest), i3, str12, true, false, true, a(Fa.ci_rest_cycle_title), a(Fa.ci_rest_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rapid_rinse), i3, str12, true, false, true, a(Fa.ci_rapid_rinse_title), a(Fa.ci_rapid_rinse_message)));
            }
        } else {
            wa waVar3 = this.la;
            if (waVar3 == wa.CenturionNitro) {
                int i4 = color2;
                String str13 = str;
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_release), i4, str13, true, false, true, a(Fa.ci_air_release_info_title), a(Fa.ci_air_release_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_backwash), i4, str13, true, false, true, a(Fa.ci_backwash_title), a(Fa.ci_backwash_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rest), i4, str13, true, false, true, a(Fa.ci_rest_cycle_title), a(Fa.ci_rest_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rapid_rinse), i4, str13, true, false, true, a(Fa.ci_rapid_rinse_title), a(Fa.ci_rapid_rinse_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_draw), i4, str13, true, false, true, a(Fa.ci_air_draw_info_title), a(Fa.ci_air_draw_message)));
            } else if (waVar3 == wa.CenturionNitroSidekick || waVar3 == wa.CenturionNitroSidekickV3) {
                int i5 = color2;
                String str14 = str;
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_release), i5, str14, true, false, true, a(Fa.ci_air_release_info_title), a(Fa.ci_air_release_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_backwash), i5, str14, true, false, true, a(Fa.ci_backwash_title), a(Fa.ci_backwash_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rest), i5, str14, true, false, true, a(Fa.ci_rest_cycle_title), a(Fa.ci_rest_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_draw), i5, str14, true, false, true, a(Fa.ci_air_draw_info_title), a(Fa.ci_air_draw_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rapid_rinse), i5, str14, true, false, true, a(Fa.ci_rapid_rinse_title), a(Fa.ci_rapid_rinse_message)));
            } else if (waVar3 == wa.NitroPro) {
                int i6 = color2;
                String str15 = str;
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_release), i6, str15, true, false, true, a(Fa.ci_air_release_info_title), a(Fa.ci_air_release_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_chlorine_draw), i6, str15, true, false, true, a(Fa.ci_chlorine_draw_cycle_title), a(Fa.ci_chlorine_draw_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_chlorine_rinse), i6, str15, true, false, true, a(Fa.ci_chlorine_rinse_cycle_title), a(Fa.ci_chlorine_rinse_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_chlorine_contact), i6, str15, true, false, true, a(Fa.ci_chlorine_contact_title), a(Fa.ci_chlorine_contact_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_backwash), i6, str15, true, false, true, a(Fa.ci_backwash_title), a(Fa.ci_backwash_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rest), i6, str15, true, false, true, a(Fa.ci_rest_cycle_title), a(Fa.ci_rest_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rapid_rinse), i6, str15, true, false, true, a(Fa.ci_rapid_rinse_title), a(Fa.ci_rapid_rinse_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_draw), i6, str15, true, false, true, a(Fa.ci_air_draw_info_title), a(Fa.ci_air_draw_message)));
            } else if (waVar3 == wa.NitroProSidekick) {
                int i7 = color2;
                String str16 = str;
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_release), i7, str16, true, false, true, a(Fa.ci_air_release_info_title), a(Fa.ci_air_release_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_chlorine_draw), i7, str16, true, false, true, a(Fa.ci_chlorine_draw_cycle_title), a(Fa.ci_chlorine_draw_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_chlorine_rinse), i7, str16, true, false, true, a(Fa.ci_chlorine_rinse_cycle_title), a(Fa.ci_chlorine_rinse_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_chlorine_contact), i7, str16, true, false, true, a(Fa.ci_chlorine_contact_title), a(Fa.ci_chlorine_contact_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_backwash), i7, str16, true, false, true, a(Fa.ci_backwash_title), a(Fa.ci_backwash_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rest), i7, str16, true, false, true, a(Fa.ci_rest_cycle_title), a(Fa.ci_rest_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_air_draw), i7, str16, true, false, true, a(Fa.ci_air_draw_info_title), a(Fa.ci_air_draw_message)));
                this.ga.add(new pa(this.X, qa.Value, a(Fa.ic_rapid_rinse), i7, str16, true, false, true, a(Fa.ci_rapid_rinse_title), a(Fa.ci_rapid_rinse_message)));
            }
        }
        this.ka = new d(this.ga, new Y(this));
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(Ba.cycle_times_list);
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setItemViewCacheSize(20);
        recyclerView2.setLayoutManager(new GridLayoutManager(f(), integer));
        recyclerView2.setAdapter(this.ka);
        RecyclerView.f itemAnimator2 = recyclerView2.getItemAnimator();
        if (itemAnimator2 instanceof androidx.recyclerview.widget.J) {
            itemAnimator2.a(0);
            ((androidx.recyclerview.widget.J) itemAnimator2).a(false);
        }
        ta();
        return inflate;
    }

    /* access modifiers changed from: private */
    public int c(String str) {
        for (int i = 0; i < this.fa.size(); i++) {
            if (this.fa.get(i).o().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void a(Context context) {
        super.a(context);
        b(context instanceof Activity ? (Activity) context : null);
    }

    public void a(Activity activity) {
        super.a(activity);
        if (Build.VERSION.SDK_INT < 23) {
            b(activity);
        }
    }

    private void a(byte[] bArr) {
        f fVar = this.Z;
        if (fVar != null && bArr != null) {
            fVar.a(bArr);
        }
    }

    private la a(la laVar, byte b2, byte b3) {
        if (laVar == la.Sent) {
            return b2 != b3 ? la.Pending : la.Idle;
        }
        return laVar;
    }
}
