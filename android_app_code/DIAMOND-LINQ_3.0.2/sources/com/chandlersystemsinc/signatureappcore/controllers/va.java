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
import b.a.a.J;
import b.a.a.W;
import b.a.a.Y;
import b.a.a.b.d;
import b.a.a.c.F;
import b.a.a.c.y;
import b.a.a.d.f;
import b.a.a.ia;
import b.a.a.la;
import b.a.a.ma;
import b.a.a.pa;
import b.a.a.qa;
import b.a.a.ya;
import b.a.a.za;
import com.chandlersystemsinc.signatureappcore.views.CsGridGraphView;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public final class va extends C0132h {
    /* access modifiers changed from: private */
    public Context V;
    /* access modifiers changed from: private */
    public C0139o W;
    private f X;
    private b.a.a.e.f Y;
    /* access modifiers changed from: private */
    public C0176ca Z;
    private Handler aa;
    private Runnable ba;
    /* access modifiers changed from: private */
    public List<pa> ca;
    /* access modifiers changed from: private */
    public d da;
    private float[] ea;
    private float[] fa;
    private boolean ga = true;
    private boolean ha = true;
    private boolean ia;
    private boolean ja;
    private int ka;
    /* access modifiers changed from: private */
    public la la;
    /* access modifiers changed from: private */
    public la ma;
    private final BroadcastReceiver na;

    public va() {
        la laVar = la.Idle;
        this.la = laVar;
        this.ma = laVar;
        this.na = new ra(this);
    }

    private void ia() {
        List<pa> list;
        if (this.Y != null && (list = this.ca) != null && this.da != null) {
            list.get(0).h(this.Y.a(this.Z));
            boolean z = true;
            this.ca.get(1).h(this.Y.c(this.Z));
            this.ca.get(2).h(this.Y.b(this.Z));
            this.ca.get(3).h(this.Y.d());
            this.ca.get(4).h(this.Y.c());
            for (int i = 0; i < 5; i++) {
                this.da.c(i);
            }
            if (this.Y.g() && !this.ia) {
                this.ca.get(5).a(this.Y.e());
                this.ca.get(6).a(this.Y.f());
                this.ca.get(7).a(this.Y.a());
                this.da.c(5);
                this.da.c(6);
                this.da.c(7);
                this.ia = true;
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
                if (this.Y.b() == 0) {
                    z = false;
                }
                fVar2.a(z, this.Y.i());
            }
            this.Y.a(false);
        }
    }

    private void ja() {
        Handler handler = this.aa;
        if (handler != null) {
            handler.removeCallbacks(this.ba);
        }
        this.aa = new Handler();
        Handler handler2 = this.aa;
        U u = new U(this);
        this.ba = u;
        handler2.post(u);
    }

    public void P() {
        super.P();
        this.ha = false;
        Context m = m();
        if (m != null) {
            b.a(m).a(this.na);
        }
    }

    public void Q() {
        super.Q();
        this.ga = true;
        this.ia = false;
        this.ha = true;
        Context m = m();
        if (m != null) {
            b.a(m).a(this.na, new IntentFilter("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_positive"));
        }
    }

    public void S() {
        super.S();
        Handler handler = this.aa;
        if (handler != null) {
            handler.removeCallbacks(this.ba);
        }
    }

    public /* synthetic */ void ha() {
        if (CsMainCoreActivity.A()) {
            if (this.ha) {
                la laVar = this.la;
                la laVar2 = la.Pending;
                if (laVar == laVar2) {
                    a(G.g(J.StatusAndHistory));
                    this.la = la.Sent;
                } else if (this.ma == laVar2) {
                    a(G.e(J.StatusAndHistory));
                    this.ma = la.Sent;
                } else if (this.ja) {
                    a(G.a(J.AdvancedSettings));
                    this.ja = false;
                } else {
                    a(G.a(J.StatusAndHistory));
                }
            }
            this.aa.postDelayed(this.ba, 1000);
            return;
        }
        b.a.a.e.f fVar = this.Y;
        if (fVar != null) {
            fVar.j();
        }
        f fVar2 = this.X;
        if (fVar2 != null) {
            fVar2.o();
        }
        this.aa.postDelayed(this.ba, 3000);
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        if (this.Y != null && this.V != null && this.W != null) {
            if (this.Z == C0176ca.Standard) {
                str2 = a(Fa.ic_total_water_usage_gallons_between_regenerations);
            } else {
                str2 = a(Fa.ic_total_water_usage_liters_between_regenerations);
            }
            boolean equals = str.equals(a(Fa.ic_peak_flow_recorded_per_day));
            boolean equals2 = str.equals(str2);
            float[] e = this.Y.e();
            ArrayList arrayList = new ArrayList();
            if (this.Z == C0176ca.Standard) {
                str3 = a(Fa.ic_water_usage_gallons_per_day);
            } else {
                str3 = a(Fa.ic_water_usage_liters_per_day);
            }
            if (equals) {
                e = this.Y.a();
                str3 = a(Fa.ic_peak_flow_recorded_per_day);
            } else if (equals2) {
                e = this.Y.f();
                if (this.Z == C0176ca.Standard) {
                    str5 = a(Fa.ic_total_water_usage_gallons_between_regenerations);
                } else {
                    str5 = a(Fa.ic_total_water_usage_liters_between_regenerations);
                }
                str3 = str5;
            }
            int i2 = equals2 ? 41 : 61;
            int i3 = 1;
            while (i2 >= 0) {
                if (equals2) {
                    i = i3 + 1;
                    str4 = String.valueOf(i3);
                } else {
                    i = i3 + 1;
                    str4 = ia.c(62 - i3);
                }
                arrayList.add(str4.concat(" - ").concat(String.valueOf(e[i2])));
                i2--;
                i3 = i;
            }
            W.a(this.W, str3, (String[]) arrayList.toArray(new String[0]));
        }
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        this.Y = new b.a.a.e.f();
        this.V = m();
        this.W = r();
        this.Z = ma.c(this.V);
        if (k() != null) {
            this.ka = k().getInt("com.ChandlerSystemsInc.signatureAppCore.controllers.status_and_history_fragment.firmware_version", 0);
            this.ja = k().getBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.status_and_history_fragment.is_classic", false);
        } else {
            f fVar = this.X;
            if (fVar != null) {
                fVar.j();
            }
        }
        if (f() != null) {
            ((F) C.a(f()).a(F.class)).c().a(this, new V(this));
        }
        this.ea = new float[62];
        for (int i = 0; i < 62; i++) {
            this.ea[i] = (float) i;
        }
        this.fa = new float[42];
        for (int i2 = 0; i2 < 42; i2++) {
            this.fa[i2] = (float) i2;
        }
    }

    public static va a(int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.ChandlerSystemsInc.signatureAppCore.controllers.status_and_history_fragment.firmware_version", i);
        bundle.putBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.status_and_history_fragment.is_classic", z);
        va vaVar = new va();
        vaVar.m(bundle);
        return vaVar;
    }

    private void b(Activity activity) {
        try {
            this.X = (f) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString().concat(" must implement CsFragmentEvents"));
        }
    }

    public /* synthetic */ void a(y yVar) {
        this.Y.a(this.Z, yVar.a(), this.ka, yVar.b(), yVar.c());
        if (this.Y.h()) {
            ia();
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        View inflate = layoutInflater.inflate(Da.fragment_dashboard, viewGroup, false);
        f fVar = this.X;
        if (fVar != null) {
            fVar.b(w().getString(Fa.bt_status_loading));
        }
        int color = w().getColor(za.item_value_blue);
        int color2 = w().getColor(za.item_value_orange);
        if (this.Z == C0176ca.Standard) {
            str = a(Fa.unit_gpm);
        } else {
            str = a(Fa.unit_lpm);
        }
        String str7 = str;
        if (this.Z == C0176ca.Standard) {
            str2 = a(Fa.unit_gallons);
        } else {
            str2 = a(Fa.unit_liters);
        }
        String str8 = str2;
        String a2 = a(Fa.unit_reset);
        if (this.Z == C0176ca.Standard) {
            str3 = a(Fa.ic_total_gallons_treated);
        } else {
            str3 = a(Fa.ic_total_liters_treated);
        }
        String str9 = str3;
        if (this.Z == C0176ca.Standard) {
            str4 = a(Fa.ic_total_gallons_treated_since_reset);
        } else {
            str4 = a(Fa.ic_total_liters_treated_since_reset);
        }
        String str10 = str4;
        if (this.Z == C0176ca.Standard) {
            str5 = a(Fa.ic_total_water_usage_gallons_per_day);
        } else {
            str5 = a(Fa.ic_total_water_usage_liters_per_day);
        }
        String str11 = str5;
        if (this.Z == C0176ca.Standard) {
            str6 = a(Fa.ic_total_water_usage_gallons_between_regenerations);
        } else {
            str6 = a(Fa.ic_total_water_usage_liters_between_regenerations);
        }
        String str12 = str6;
        this.ca = new ArrayList();
        List<pa> list = this.ca;
        int i = color;
        pa paVar = r5;
        int i2 = color2;
        pa paVar2 = new pa(inflate.getContext(), qa.Value, a(Fa.ic_current_water_flow), i, str7, false, false, false, (String) null, (String) null);
        list.add(paVar);
        this.ca.add(new pa(inflate.getContext(), qa.Value, str9, i, BuildConfig.FLAVOR, false, false, false, (String) null, (String) null));
        this.ca.add(new pa(inflate.getContext(), qa.Value, str10, i2, a2, true, false, false, (String) null, (String) null));
        this.ca.add(new pa(inflate.getContext(), qa.Value, a(Fa.ic_total_regenerations), color, BuildConfig.FLAVOR, false, false, false, (String) null, (String) null));
        this.ca.add(new pa(inflate.getContext(), qa.Value, a(Fa.ic_total_regenerations_since_reset), i2, a2, true, false, false, (String) null, (String) null));
        String str13 = str8;
        this.ca.add(new pa(inflate.getContext(), qa.Graph, CsGridGraphView.a.Daily, str11, str13, w().getBoolean(ya.draw_graph_filled), this.ea, false, (String) null, (String) null));
        this.ca.add(new pa(inflate.getContext(), qa.Graph, CsGridGraphView.a.Gallons, str12, str13, w().getBoolean(ya.draw_graph_filled), this.fa, false, (String) null, (String) null));
        this.ca.add(new pa(inflate.getContext(), qa.Graph, CsGridGraphView.a.Daily, a(Fa.ic_peak_flow_recorded_per_day), str13, w().getBoolean(ya.draw_graph_filled), this.ea, false, (String) null, (String) null));
        this.da = new d(this.ca, new sa(this));
        boolean z = w().getConfiguration().orientation == 1;
        int integer = w().getInteger(Ca.span_count_min);
        int integer2 = w().getInteger(Ca.span_count_max);
        if (!z) {
            integer = integer2;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(f(), integer);
        gridLayoutManager.a((GridLayoutManager.c) new ta(this, integer));
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(Ba.option_list);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(this.da);
        RecyclerView.f itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator instanceof androidx.recyclerview.widget.J) {
            itemAnimator.a(0);
            ((androidx.recyclerview.widget.J) itemAnimator).a(false);
        }
        ja();
        return inflate;
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        if (this.Y != null && this.V != null && this.W != null) {
            if (this.Z == C0176ca.Standard) {
                str2 = a(Fa.ic_total_water_usage_gallons_between_regenerations);
            } else {
                str2 = a(Fa.ic_total_water_usage_liters_between_regenerations);
            }
            boolean equals = str.equals(a(Fa.ic_peak_flow_recorded_per_day));
            boolean equals2 = str.equals(str2);
            float[] e = this.Y.e();
            String str6 = equals ? "\"Day\",\"Peak\"\r\n" : equals2 ? "\"Regeneration\",\"Usage\"\n" : "\"Date\",\"Usage\"\r\n";
            if (this.Z == C0176ca.Standard) {
                str3 = a(Fa.sh_water_usage_graph_file);
            } else {
                str3 = a(Fa.sh_water_usage_graph_file_metric);
            }
            if (equals) {
                e = this.Y.a();
                str3 = a(Fa.sh_peak_flow_graph_file);
            } else if (equals2) {
                e = this.Y.f();
                if (this.Z == C0176ca.Standard) {
                    str5 = a(Fa.sh_water_usage_between_regenerations_graph_file);
                } else {
                    str5 = a(Fa.sh_water_usage_between_regenerations_graph_file_metric);
                }
                str3 = str5;
            }
            int i2 = equals2 ? 41 : 61;
            int i3 = 1;
            while (i2 >= 0) {
                if (equals2) {
                    i = i3 + 1;
                    str4 = String.valueOf(i3);
                } else {
                    i = i3 + 1;
                    str4 = ia.c(62 - i3);
                }
                str6 = str6.concat("\"").concat(str4).concat("\",\"").concat(String.valueOf(e[i2])).concat("\"\r\n");
                i2--;
                i3 = i;
            }
            if (Y.a(this.V, str3, str6.getBytes())) {
                W.b(this.W, "com.ChandlerSystemsInc.signatureAppCore.controllers.status_and_history_fragment.share_data", a(Fa.di_export_successful_title), String.format(a(Fa.di_export_successful_message), new Object[]{a(Fa.app_name), str3}), str3);
            } else {
                W.a(this.W, a(Fa.di_export_failed_title), a(Fa.di_export_failed_message));
            }
        }
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
        f fVar = this.X;
        if (fVar != null && bArr != null) {
            fVar.a(bArr);
        }
    }
}
