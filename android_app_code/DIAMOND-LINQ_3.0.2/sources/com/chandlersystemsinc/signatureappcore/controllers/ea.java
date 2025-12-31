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
import b.a.a.B;
import b.a.a.Ba;
import b.a.a.C0176ca;
import b.a.a.C0182fa;
import b.a.a.Ca;
import b.a.a.Da;
import b.a.a.Fa;
import b.a.a.G;
import b.a.a.J;
import b.a.a.W;
import b.a.a.Y;
import b.a.a.b.d;
import b.a.a.c.F;
import b.a.a.c.y;
import b.a.a.d.f;
import b.a.a.e.c;
import b.a.a.ia;
import b.a.a.ka;
import b.a.a.la;
import b.a.a.ma;
import b.a.a.pa;
import b.a.a.qa;
import b.a.a.ra;
import b.a.a.wa;
import b.a.a.ya;
import b.a.a.za;
import com.chandlersystemsinc.signatureappcore.views.CsGridGraphView;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public final class ea extends C0132h {
    /* access modifiers changed from: private */
    public Context V;
    /* access modifiers changed from: private */
    public C0139o W;
    private f X;
    /* access modifiers changed from: private */
    public c Y;
    /* access modifiers changed from: private */
    public C0176ca Z;
    private Handler aa;
    private Runnable ba;
    /* access modifiers changed from: private */
    public d ca;
    /* access modifiers changed from: private */
    public List<pa> da;
    /* access modifiers changed from: private */
    public wa ea;
    private float[] fa;
    private boolean ga = true;
    private boolean ha;
    private int ia;
    /* access modifiers changed from: private */
    public byte ja = 0;
    /* access modifiers changed from: private */
    public byte ka = 0;
    /* access modifiers changed from: private */
    public byte la = 0;
    /* access modifiers changed from: private */
    public B ma = B.PM;
    /* access modifiers changed from: private */
    public la na;
    /* access modifiers changed from: private */
    public la oa;
    /* access modifiers changed from: private */
    public la pa;
    /* access modifiers changed from: private */
    public la qa;
    private final BroadcastReceiver ra;

    public ea() {
        la laVar = la.Idle;
        this.na = laVar;
        this.oa = laVar;
        this.pa = laVar;
        this.qa = laVar;
        this.ra = new aa(this);
    }

    private void ia() {
        if (this.oa == la.Sent) {
            if (this.ja != this.Y.o()) {
                this.oa = la.Pending;
            } else {
                this.oa = la.Idle;
            }
        }
        if (this.pa == la.Sent) {
            if (this.ka != this.Y.c()) {
                this.pa = la.Pending;
            } else {
                this.pa = la.Idle;
            }
        }
        if (this.qa != la.Sent) {
            return;
        }
        if (this.la != this.Y.k()) {
            this.qa = la.Pending;
        } else {
            this.qa = la.Idle;
        }
    }

    /* access modifiers changed from: private */
    public void ja() {
        String str;
        if (this.V != null && this.W != null) {
            float[] p = this.Y.p();
            int i = 61;
            String str2 = "\"Date\",\"Usage\"\r\n";
            int i2 = 1;
            while (i >= 0) {
                str2 = str2.concat("\"").concat(ia.c(62 - i2)).concat("\",\"").concat(String.valueOf(p[i])).concat("\"\r\n");
                i--;
                i2++;
            }
            if (this.Z == C0176ca.Standard) {
                str = a(Fa.db_water_usage_graph_file);
            } else {
                str = a(Fa.db_water_usage_graph_file_metric);
            }
            if (Y.a(this.V, str, str2.getBytes())) {
                W.b(this.W, "com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.share_data", a(Fa.di_export_successful_title), String.format(a(Fa.di_export_successful_message), new Object[]{a(Fa.app_name), str}), str);
                return;
            }
            W.a(this.W, a(Fa.di_export_failed_title), a(Fa.di_export_failed_message));
        }
    }

    private void ka() {
        ia();
        this.da.get(0).h(this.Y.e());
        boolean z = true;
        this.da.get(1).h(BuildConfig.FLAVOR);
        this.da.get(1).a(this.Y.b());
        if (this.ea == wa.MeteredSoftener) {
            this.da.get(2).h(this.Y.b(this.Z));
            this.da.get(3).h(this.Y.d(this.Z));
            this.da.get(4).h(this.Y.e(this.Z));
            this.da.get(5).h(this.Y.a(this.Z));
            this.da.get(6).h(this.Y.c(this.Z));
            this.da.get(7).h(this.Y.j());
        } else {
            this.da.get(3).h(this.Y.j());
            this.da.get(3).e(this.Y.l());
            this.da.get(4).h(this.Y.e(this.Z));
            this.da.get(5).h(this.Y.a(this.Z));
            this.da.get(6).h(this.Y.b(this.Z));
            if (this.ea == wa.TimeClockSoftener) {
                this.da.get(7).g(a(Fa.ic_regeneration_day_override));
                this.da.get(7).h(String.valueOf(this.Y.c()));
            } else {
                this.da.get(7).g(a(Fa.ic_filter_backwash_frequency));
                this.da.get(7).h(this.Y.d());
            }
        }
        ma();
        if (this.ca != null) {
            for (int i = 0; i < 8; i++) {
                this.ca.c(i);
            }
        }
        if (this.Y.q() && !this.ha) {
            double a2 = a(this.Y.p());
            if (this.Z != C0176ca.Standard) {
                a2 = ka.a(ra.Gallons, a2);
            }
            this.da.get(8).h(String.valueOf(Math.round(a2)));
            this.ca.c(8);
            this.da.get(9).a(this.Y.p());
            this.ca.c(9);
            this.ha = true;
        }
        if (this.ga) {
            f fVar = this.X;
            if (fVar != null) {
                fVar.e();
            }
            this.ga = false;
        }
        f fVar2 = this.X;
        if (fVar2 != null) {
            if (this.Y.h() == 0) {
                z = false;
            }
            fVar2.a(z, this.Y.t());
        }
        this.Y.a(false);
    }

    private void la() {
        Handler handler = this.aa;
        if (handler != null) {
            handler.removeCallbacks(this.ba);
        }
    }

    private void ma() {
        String str;
        String str2;
        String str3;
        if (this.Y.t() || this.Y.h() != 0) {
            this.da.get(2).c(false);
            pa paVar = this.da.get(2);
            if (this.Y.f() > 100) {
                str = a(Fa.rg_moving_to);
            } else {
                str = a(Fa.rg_step);
            }
            paVar.f(str);
            if (!this.Y.t() || this.Y.n() == 0) {
                this.da.get(2).h(this.Y.g());
            } else {
                this.da.get(2).h(String.valueOf(this.Y.n()));
            }
            wa waVar = this.ea;
            if (waVar == wa.MeteredSoftener || waVar == wa.TimeClockSoftener) {
                this.da.get(2).g(a(Fa.db_in_regeneration));
            } else {
                pa paVar2 = this.da.get(2);
                if (this.Y.r()) {
                    str3 = a(Fa.db_in_aeration);
                } else {
                    str3 = a(Fa.db_in_backwash);
                }
                paVar2.g(str3);
            }
            pa paVar3 = this.da.get(2);
            if (this.Y.m() == C0182fa.Minutes) {
                str2 = a(Fa.db_minutes_remaining);
            } else {
                str2 = a(Fa.db_seconds_remaining);
            }
            paVar3.d(str2);
            this.da.get(2).e(this.Y.l());
            this.da.get(2).d(true);
            return;
        }
        wa waVar2 = this.ea;
        if (waVar2 == wa.MeteredSoftener) {
            this.da.get(2).g(a(Fa.db_current_water_flow));
        } else if (waVar2 == wa.TimeClockSoftener) {
            this.da.get(2).g(a(Fa.db_days_until_regeneration));
        } else if (!this.Y.r()) {
            this.da.get(2).g(a(Fa.db_days_until_backwash));
        }
        if (this.ea == wa.MeteredSoftener) {
            this.da.get(2).c(false);
            this.da.get(2).a(this.da.get(2).c());
            this.da.get(2).h(this.Y.b(this.Z));
            this.da.get(2).d(false);
            return;
        }
        this.da.get(2).c(true);
        this.da.get(2).a(this.da.get(2).c());
        this.da.get(2).h(String.valueOf(this.Y.a()));
        this.da.get(2).d(false);
    }

    /* access modifiers changed from: private */
    public void na() {
        String str;
        if (this.V != null && this.W != null) {
            float[] p = this.Y.p();
            ArrayList arrayList = new ArrayList();
            int i = 61;
            int i2 = 1;
            while (i >= 0) {
                arrayList.add(ia.c(62 - i2).concat(" - ").concat(String.valueOf(p[i])));
                i--;
                i2++;
            }
            if (this.Z == C0176ca.Standard) {
                str = a(Fa.ic_water_usage_gallons_per_day);
            } else {
                str = a(Fa.ic_water_usage_liters_per_day);
            }
            W.a(this.W, str, (String[]) arrayList.toArray(new String[0]));
        }
    }

    private void oa() {
        la();
        this.aa = new Handler();
        Handler handler = this.aa;
        C0204c cVar = new C0204c(this);
        this.ba = cVar;
        handler.post(cVar);
    }

    public void P() {
        super.P();
        la();
        Context m = m();
        if (m != null && this.ra != null) {
            b.a(m).a(this.ra);
        }
    }

    public void Q() {
        super.Q();
        this.ga = true;
        this.ha = false;
        oa();
        Context m = m();
        if (m != null && this.ra != null) {
            b.a(m).a(this.ra, new IntentFilter("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_positive"));
        }
    }

    public void S() {
        super.S();
        la();
    }

    public /* synthetic */ void ha() {
        if (CsMainCoreActivity.A()) {
            la laVar = this.na;
            la laVar2 = la.Pending;
            if (laVar == laVar2) {
                a(G.f(J.Dashboard));
                this.na = la.Sent;
            } else if (this.oa == laVar2) {
                a(G.h(J.Dashboard, this.ja));
                this.oa = la.Sent;
            } else if (this.pa == laVar2) {
                a(G.c(J.Dashboard, this.ka));
                this.pa = la.Sent;
            } else if (this.qa == laVar2) {
                a(G.a(J.Dashboard, this.la, this.ma));
                this.qa = la.Sent;
            } else {
                a(G.a(J.Dashboard));
            }
            this.aa.postDelayed(this.ba, 1000);
            return;
        }
        this.Y.u();
        f fVar = this.X;
        if (fVar != null) {
            fVar.o();
        }
        this.aa.postDelayed(this.ba, 3000);
    }

    private void b(Activity activity) {
        try {
            this.X = (f) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString().concat(" must implement CsFragmentEvents"));
        }
    }

    public void c(Bundle bundle) {
        f fVar;
        super.c(bundle);
        this.Y = new c();
        this.V = m();
        this.W = l();
        this.Z = ma.c(this.V);
        if (k() != null) {
            this.ia = k().getInt("com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.firmware_version", 0);
            this.ea = wa.a(k().getInt("com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.valve_type", -1));
        } else {
            f fVar2 = this.X;
            if (fVar2 != null) {
                fVar2.j();
            }
        }
        if (this.ea == wa.Unknown && (fVar = this.X) != null) {
            fVar.j();
        }
        if (!(f() == null || this.V == null)) {
            ((F) C.a(f()).a(F.class)).c().a(this, new C0205d(this));
        }
        this.fa = new float[62];
        for (int i = 0; i < 62; i++) {
            this.fa[i] = (float) i;
        }
    }

    public static ea a(int i, wa waVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.firmware_version", i);
        bundle.putInt("com.ChandlerSystemsInc.signatureAppCore.controllers.dashboard_fragment.valve_type", waVar.a());
        ea eaVar = new ea();
        eaVar.m(bundle);
        return eaVar;
    }

    public /* synthetic */ void a(y yVar) {
        this.Y.a(this.V, this.Z, yVar.a(), this.ia, this.ea, yVar.b(), yVar.c());
        if (this.Y.s()) {
            ka();
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        String str3;
        View view;
        int i;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        View inflate = layoutInflater.inflate(Da.fragment_dashboard, viewGroup, false);
        f fVar = this.X;
        if (fVar != null) {
            fVar.b(w().getString(Fa.bt_status_loading));
        }
        int color = w().getColor(za.item_value_blue);
        int color2 = w().getColor(za.item_value_orange);
        String a2 = a(Fa.unit_set);
        if (this.Z == C0176ca.Standard) {
            str = a(Fa.unit_gpm);
        } else {
            str = a(Fa.unit_lpm);
        }
        String str9 = str;
        if (this.Z == C0176ca.Standard) {
            str2 = a(Fa.unit_gallons);
        } else {
            str2 = a(Fa.unit_liters);
        }
        String str10 = str2;
        if (this.Z == C0176ca.Standard) {
            str3 = a(Fa.ic_water_usage_gallons_per_day);
        } else {
            str3 = a(Fa.ic_water_usage_liters_per_day);
        }
        String str11 = str3;
        if (this.V != null) {
            this.da = new ArrayList();
            List<pa> list = this.da;
            pa paVar = r6;
            pa paVar2 = new pa(this.V, qa.Value, a(Fa.ic_time_of_day_on_unit), color2, a2, true, false, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            list.add(paVar);
            List<pa> list2 = this.da;
            view = inflate;
            pa paVar3 = r5;
            pa paVar4 = new pa(this.V, qa.Value, a(Fa.ic_battery_on_unit), color, BuildConfig.FLAVOR, false, false, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            list2.add(paVar3);
            this.da.get(1).b(true);
            wa waVar = this.ea;
            if (waVar == wa.MeteredSoftener) {
                List<pa> list3 = this.da;
                int i2 = color;
                pa paVar5 = r5;
                pa paVar6 = new pa(this.V, qa.Value, a(Fa.ic_current_water_flow), i2, str9, false, false, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
                list3.add(paVar5);
                this.da.add(new pa(this.V, qa.Value, a(Fa.ic_soft_water_remaining), i2, str10, false, false, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR));
            } else {
                if (waVar == wa.TimeClockSoftener) {
                    str7 = a(Fa.ci_days_until_regeneration_title);
                } else {
                    str7 = a(Fa.ci_days_until_backwash_title);
                }
                String str12 = str7;
                if (this.ea == wa.TimeClockSoftener) {
                    str8 = a(Fa.ci_days_until_regeneration_message);
                } else {
                    str8 = a(Fa.ci_days_until_backwash_message);
                }
                this.da.add(new pa(this.V, qa.Value, a(Fa.ic_days_until_backwash), color, BuildConfig.FLAVOR, false, false, true, str12, str8));
                this.da.add(new pa(this.V, qa.Value, a(Fa.ic_regeneration_time), color2, a2, true, false, true, a(Fa.ci_regen_time_title), a(Fa.ci_regen_time_message)));
            }
            int i3 = color;
            this.da.add(new pa(this.V, qa.Value, a(Fa.ic_water_usage_today), i3, str10, false, false, true, a(Fa.ci_water_usage_today_title), a(Fa.ci_water_usage_graph_message)));
            this.da.add(new pa(this.V, qa.Value, a(Fa.ic_peak_flow_today), i3, str9, false, false, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR));
            wa waVar2 = this.ea;
            if (waVar2 == wa.MeteredSoftener) {
                if (this.Z == C0176ca.Standard) {
                    str6 = a(Fa.ci_water_hardness_message);
                } else {
                    str6 = a(Fa.ci_water_hardness_metric_message);
                }
                int i4 = color2;
                String str13 = a2;
                this.da.add(new pa(this.V, qa.Value, a(Fa.ic_water_hardness), i4, str13, true, false, true, a(Fa.ci_water_hardness_title), str6));
                this.da.add(new pa(this.V, qa.Value, a(Fa.ic_regeneration_time), i4, str13, true, false, true, a(Fa.ci_regen_time_title), a(Fa.ci_regen_time_message)));
                i = color;
            } else {
                if (waVar2 == wa.TimeClockSoftener) {
                    str4 = a(Fa.ci_regen_day_override_title);
                } else {
                    str4 = a(Fa.ci_filter_backwash_freq_info_title);
                }
                if (this.Z == C0176ca.Standard) {
                    str5 = a(Fa.ci_regen_day_override_message);
                } else {
                    str5 = a(Fa.ci_regen_day_override_metric_message);
                }
                if (this.ea != wa.TimeClockSoftener) {
                    str5 = a(Fa.ci_filter_backwash_freq_message);
                }
                String str14 = str5;
                List<pa> list4 = this.da;
                i = color;
                pa paVar7 = r5;
                pa paVar8 = new pa(this.V, qa.Value, a(Fa.ic_current_water_flow), color, str9, false, false, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
                list4.add(paVar7);
                this.da.add(new pa(this.V, qa.Value, a(Fa.ic_filter_backwash_frequency), color2, a2, true, false, true, str4, str14));
            }
            this.da.add(new pa(this.V, qa.Value, a(Fa.ic_average_water_usage_gallons_per_day), i, str10, false, false, true, a(Fa.ci_average_water_usage_per_day_title), a(Fa.ci_average_water_usage_per_day_message)));
            this.da.add(new pa(this.V, qa.Graph, CsGridGraphView.a.Daily, str11, str10, w().getBoolean(ya.draw_graph_filled), this.fa, true, a(Fa.ci_water_usage_graph_title), a(Fa.ci_water_usage_graph_message)));
        } else {
            view = inflate;
        }
        this.ca = new d(this.da, new ba(this));
        boolean z = w().getConfiguration().orientation == 1;
        int integer = w().getInteger(Ca.span_count_min);
        int integer2 = w().getInteger(Ca.span_count_max);
        if (!z) {
            integer = integer2;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(f(), integer);
        gridLayoutManager.a((GridLayoutManager.c) new ca(this, integer));
        View view2 = view;
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(Ba.option_list);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(this.ca);
        RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof androidx.recyclerview.widget.J) {
            itemAnimator.a(0);
            ((androidx.recyclerview.widget.J) itemAnimator).a(false);
        }
        oa();
        return view2;
    }

    public void a(Context context) {
        f fVar;
        super.a(context);
        b(context instanceof Activity ? (Activity) context : null);
        if (!this.ga && (fVar = this.X) != null) {
            fVar.e();
        }
    }

    public void a(Activity activity) {
        super.a(activity);
        if (Build.VERSION.SDK_INT < 23) {
            b(activity);
        }
    }

    private void a(byte[] bArr) {
        f fVar = this.X;
        if (fVar != null && bArr != null) {
            fVar.a(bArr);
        }
    }

    private double a(float[] fArr) {
        int length = (fArr.length / 2) - 1;
        int i = 0;
        float f = 0.0f;
        for (int length2 = fArr.length - 1; length2 >= length; length2--) {
            if (fArr[length2] != 0.0f) {
                f += fArr[length2];
                i++;
            }
        }
        if (i > 0) {
            return (double) (f / ((float) i));
        }
        return 0.0d;
    }
}
