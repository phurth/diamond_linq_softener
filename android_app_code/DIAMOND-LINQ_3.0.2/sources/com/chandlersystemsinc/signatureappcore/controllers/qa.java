package com.chandlersystemsinc.signatureappcore.controllers;

import a.g.a.a;
import a.l.a.b;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.C0132h;
import androidx.fragment.app.C0134j;
import androidx.fragment.app.C0139o;
import b.a.a.Ba;
import b.a.a.C0176ca;
import b.a.a.Da;
import b.a.a.Fa;
import b.a.a.W;
import b.a.a.d.e;
import b.a.a.d.h;
import b.a.a.ha;
import b.a.a.ma;
import b.a.a.ya;
import b.a.a.za;

public final class qa extends C0132h implements e {
    private TextView V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private TextView Z;
    private ImageView aa;
    /* access modifiers changed from: private */
    public TextView ba;
    private ImageView ca;
    private TextView da;
    private ConstraintLayout ea;
    private Context fa;
    private C0139o ga;
    private h ha;
    private boolean ia = false;
    private ha ja;
    private final BroadcastReceiver ka = new oa(this);

    private void b(Activity activity) {
        try {
            this.ha = (h) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString().concat(" must implement CsNavEvents"));
        }
    }

    private void ha() {
        int i = 0;
        int i2 = this.ia ? 0 : 4;
        this.W.setVisibility(i2);
        this.X.setVisibility(i2);
        this.Y.setVisibility(i2);
        this.Z.setVisibility(i2);
        this.aa.setVisibility(i2);
        this.ba.setVisibility(i2);
        this.ca.setVisibility(i2);
        this.da.setVisibility(i2);
        ConstraintLayout constraintLayout = this.ea;
        if (this.ia) {
            i = 8;
        }
        constraintLayout.setVisibility(i);
    }

    private void ia() {
        int color = w().getColor(za.npm_nav_list_text_color);
        int color2 = w().getColor(za.npm_nav_list_text_color_active);
        this.V.setTextColor(color);
        this.W.setTextColor(color);
        this.X.setTextColor(color);
        this.Y.setTextColor(color);
        this.Z.setTextColor(color);
        ha haVar = this.ja;
        if (haVar != null) {
            int i = pa.f1404a[haVar.ordinal()];
            if (i == 1) {
                this.V.setTextColor(color2);
            } else if (i == 2) {
                this.W.setTextColor(color2);
            } else if (i == 3) {
                this.X.setTextColor(color2);
            } else if (i == 4) {
                this.Y.setTextColor(color2);
            } else if (i == 5) {
                this.Z.setTextColor(color2);
            }
        }
    }

    private void n(View view) {
        boolean z = ma.c(m()) == C0176ca.Metric;
        Switch switchR = (Switch) view.findViewById(Ba.unit_toggle_nav);
        switchR.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        switchR.setChecked(z);
        if (this.fa != null) {
            switchR.getThumbDrawable().setColorFilter(a.a(this.fa, za.switch_thumb_off), PorterDuff.Mode.SRC_IN);
            switchR.getTrackDrawable().setColorFilter(a.a(this.fa, za.switch_track_on), PorterDuff.Mode.SRC_IN);
        }
        TextView textView = (TextView) view.findViewById(Ba.units_standard);
        TextView textView2 = (TextView) view.findViewById(Ba.units_metric);
        textView.setTextColor(this.fa.getResources().getColor(z ? za.npm_nav_list_text_color : za.npm_nav_list_text_color_active));
        textView2.setTextColor(this.fa.getResources().getColor(z ? za.npm_nav_list_text_color_active : za.npm_nav_list_text_color));
        switchR.setOnCheckedChangeListener(new H(this, textView, textView2, switchR));
    }

    public void O() {
        this.ha = null;
        super.O();
    }

    public void P() {
        super.P();
        Context m = m();
        if (m != null) {
            b.a(m).a(this.ka);
        }
    }

    public void Q() {
        super.Q();
        Context m = m();
        if (m != null) {
            b.a(m).a(this.ka, new IntentFilter("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_update"));
        }
    }

    public void a(String str) {
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        this.fa = m();
        this.ga = r();
        if (k() != null) {
            this.ia = k().getBoolean("com.ChandlerSystemsInc.signatureAppCore.nav_fragment.full_view", false);
            this.ja = ha.a(k().getInt("com.ChandlerSystemsInc.signatureAppCore.nav_fragment.selected_item", 0));
        }
    }

    public /* synthetic */ void d(View view) {
        if (!w().getBoolean(ya.disable_secondary_logo)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(a(Fa.company_website)));
            a(intent);
        }
    }

    public /* synthetic */ void e(View view) {
        h hVar = this.ha;
        if (hVar != null) {
            hVar.f();
        }
    }

    public /* synthetic */ void f(View view) {
        b(ha.DeviceList);
    }

    public /* synthetic */ void g(View view) {
        b(ha.Dashboard);
    }

    public /* synthetic */ void h(View view) {
        b(ha.AdvancedSettings);
    }

    public /* synthetic */ void i(View view) {
        b(ha.StatusAndHistory);
    }

    public /* synthetic */ void j(View view) {
        b(ha.DealerInformation);
    }

    public /* synthetic */ void k(View view) {
        h hVar = this.ha;
        if (hVar != null) {
            hVar.p();
        }
    }

    public /* synthetic */ void l(View view) {
        h hVar = this.ha;
        if (hVar != null) {
            hVar.p();
        }
    }

    public /* synthetic */ void m(View view) {
        h hVar = this.ha;
        if (hVar != null) {
            hVar.f();
        }
    }

    public void a(String str, String str2, String str3) {
        C0139o oVar;
        if (str.equals("com.ChandlerSystemsInc.signatureAppCore.nav_fragment.compliance") && (oVar = this.ga) != null) {
            W.a(oVar);
        }
    }

    private void b(ha haVar) {
        h hVar = this.ha;
        if (hVar != null) {
            hVar.a(haVar);
        }
    }

    public static qa a(boolean z, ha haVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.ChandlerSystemsInc.signatureAppCore.nav_fragment.full_view", z);
        bundle.putInt("com.ChandlerSystemsInc.signatureAppCore.nav_fragment.selected_item", haVar.a());
        qa qaVar = new qa();
        qaVar.m(bundle);
        return qaVar;
    }

    public /* synthetic */ void c(View view) {
        W.a(view.getContext(), this.ga, "com.ChandlerSystemsInc.signatureAppCore.nav_fragment.compliance");
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(Da.fragment_nav, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(Ba.nav_logo_main);
        if (this.ga != null) {
            imageView.setOnClickListener(new M(this));
        }
        ((ImageView) inflate.findViewById(Ba.nav_logo_bottom)).setOnClickListener(new K(this));
        this.V = (TextView) inflate.findViewById(Ba.device_list);
        this.V.setOnClickListener(new T(this));
        this.W = (TextView) inflate.findViewById(Ba.dashboard);
        this.W.setOnClickListener(new L(this));
        this.X = (TextView) inflate.findViewById(Ba.advanced_settings);
        this.X.setOnClickListener(new O(this));
        this.Y = (TextView) inflate.findViewById(Ba.status_and_history);
        this.Y.setOnClickListener(new P(this));
        this.Z = (TextView) inflate.findViewById(Ba.dealer_information);
        this.Z.setOnClickListener(new J(this));
        this.aa = (ImageView) inflate.findViewById(Ba.regen_now_btn);
        this.aa.setOnClickListener(new I(this));
        this.ba = (TextView) inflate.findViewById(Ba.regen_now_text);
        this.ba.setOnClickListener(new Q(this));
        this.ca = (ImageView) inflate.findViewById(Ba.regen_next_btn);
        this.ca.setOnClickListener(new N(this));
        this.da = (TextView) inflate.findViewById(Ba.regen_next_text);
        this.da.setOnClickListener(new S(this));
        this.ea = (ConstraintLayout) inflate.findViewById(Ba.unit_container);
        n(inflate);
        ha();
        ia();
        return inflate;
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

    /* access modifiers changed from: package-private */
    public void a(ha haVar) {
        this.ia = haVar != ha.DeviceList;
        this.ja = haVar;
        ia();
    }

    public /* synthetic */ void a(TextView textView, TextView textView2, Switch switchR, CompoundButton compoundButton, boolean z) {
        C0134j f = f();
        if (f != null) {
            textView.setTextColor(f.getResources().getColor(z ? za.npm_nav_list_text_color : za.npm_nav_list_text_color_active));
            textView2.setTextColor(f.getResources().getColor(z ? za.npm_nav_list_text_color_active : za.npm_nav_list_text_color));
            switchR.getThumbDrawable().setColorFilter(a.a(this.fa, za.switch_thumb_off), PorterDuff.Mode.SRC_IN);
            switchR.getTrackDrawable().setColorFilter(a.a(this.fa, za.switch_track_on), PorterDuff.Mode.SRC_IN);
            ma.a(m(), z ? C0176ca.Metric : C0176ca.Standard);
        }
    }
}
