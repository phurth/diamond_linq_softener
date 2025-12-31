package com.chandlersystemsinc.signatureappcore.controllers;

import a.l.a.b;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.C0132h;
import androidx.fragment.app.C0139o;
import androidx.lifecycle.C;
import b.a.a.Ba;
import b.a.a.Da;
import b.a.a.Fa;
import b.a.a.G;
import b.a.a.H;
import b.a.a.J;
import b.a.a.W;
import b.a.a.Y;
import b.a.a.c.F;
import b.a.a.c.y;
import b.a.a.d.f;
import b.a.a.e.d;
import b.a.a.ia;
import b.a.a.la;
import b.a.a.ya;
import b.a.a.za;
import no.nordicsemi.android.log.BuildConfig;

public final class ga extends C0132h {
    private float Aa;
    private long Ba;
    private boolean Ca;
    private int Da;
    private String Ea;
    private String Fa;
    private String Ga;
    private String Ha;
    private String Ia;
    private String Ja;
    private la Ka;
    private la La;
    private la Ma;
    private la Na;
    private la Oa;
    private la Pa;
    private final BroadcastReceiver Qa;
    private EditText V;
    private TextView W;
    private EditText X;
    private TextView Y;
    private EditText Z;
    private TextView aa;
    private EditText ba;
    private TextView ca;
    private EditText da;
    private TextView ea;
    private EditText fa;
    private TextView ga;
    private Button ha;
    private Button ia;
    private Button ja;
    private Button ka;
    /* access modifiers changed from: private */
    public Context la;
    private C0139o ma;
    private f na;
    private d oa;
    private Handler pa;
    private Runnable qa;
    private a ra = a.Updating;
    private ProgressDialog sa;
    private boolean ta = true;
    private boolean ua = true;
    private boolean va;
    private boolean wa;
    private boolean xa;
    private int ya;
    private int za;

    private enum a {
        Updating,
        Editing,
        Saving
    }

    public ga() {
        la laVar = la.Idle;
        this.Ka = laVar;
        this.La = laVar;
        this.Ma = laVar;
        this.Na = laVar;
        this.Oa = laVar;
        this.Pa = laVar;
        this.Qa = new fa(this);
    }

    public static ga e(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.firmware_version", i);
        ga gaVar = new ga();
        gaVar.m(bundle);
        return gaVar;
    }

    private void g(boolean z) {
        int i;
        int i2;
        Context context = this.la;
        boolean z2 = false;
        boolean a2 = context != null ? Y.a(context, a(Fa.di_dealer_file)) : false;
        if (z) {
            i = w().getColor(za.blue);
        } else {
            i = w().getColor(za.disabled_grey);
        }
        if (!z || !a2) {
            i2 = w().getColor(za.disabled_grey);
        } else {
            i2 = w().getColor(za.blue);
        }
        this.ja.setEnabled(z);
        this.ja.setTextColor(i);
        this.ka.setEnabled(z);
        this.ka.setTextColor(i);
        Button button = this.ha;
        if (z && a2) {
            z2 = true;
        }
        button.setEnabled(z2);
        this.ha.setTextColor(i2);
        this.ia.setEnabled(z);
        this.ia.setTextColor(i);
    }

    /* access modifiers changed from: private */
    public void ia() {
        g(false);
        f fVar = this.na;
        if (fVar != null) {
            fVar.b(a(Fa.di_dealer_clear_status));
        }
        a(BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, true, false);
    }

    private void ja() {
        g(true);
        f fVar = this.na;
        if (fVar != null) {
            fVar.e();
        }
        this.ra = a.Updating;
        this.ja.setText(a(Fa.di_dealer_edit_button));
        la();
    }

    private void ka() {
        if (!w().getBoolean(ya.permanently_hide_dealer_info_buttons) && this.la != null && this.ma != null) {
            String concat = this.W.getText().toString().concat("\r\n").concat(this.Y.getText().toString()).concat("\r\n").concat(this.aa.getText().toString()).concat("\r\n").concat(this.ca.getText().toString()).concat("\r\n").concat(this.ea.getText().toString()).concat("\r\n").concat(this.ga.getText().toString());
            this.ia.setText(a(Fa.di_dealer_exporting));
            if (Y.a(this.la, a(Fa.di_dealer_file), concat.getBytes())) {
                String a2 = a(Fa.di_dealer_file);
                W.b(this.ma, "com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.share_data", a(Fa.di_export_successful_title), String.format(a(Fa.di_export_successful_message), new Object[]{a(Fa.app_name), a2}), a2);
            } else {
                W.a(this.ma, a(Fa.di_export_failed_title), a(Fa.di_export_failed_message));
            }
            this.ia.setText(a(Fa.di_dealer_export));
            g(true);
        }
    }

    private void la() {
        ProgressDialog progressDialog = this.sa;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.sa = null;
        }
    }

    /* access modifiers changed from: private */
    public void ma() {
        Context context;
        byte[] b2;
        if (!w().getBoolean(ya.permanently_hide_dealer_info_buttons) && (context = this.la) != null && (b2 = Y.b(context, a(Fa.di_dealer_file))) != null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            int i = 0;
            g(false);
            f fVar = this.na;
            if (fVar != null) {
                fVar.b(a(Fa.di_dealer_importing));
            }
            int i2 = 0;
            while (i < b2.length) {
                if (b2[i] == 10 || b2[i] == 13) {
                    i2++;
                    int i3 = i + 1;
                    if (b2[i3] == 10) {
                        i = i3;
                    }
                } else {
                    String valueOf = String.valueOf((char) b2[i]);
                    if (i2 == 0) {
                        sb.append(valueOf);
                    } else if (i2 == 1) {
                        sb2.append(valueOf);
                    } else if (i2 == 2) {
                        sb3.append(valueOf);
                    } else if (i2 == 3) {
                        sb4.append(valueOf);
                    } else if (i2 == 4) {
                        sb5.append(valueOf);
                    } else if (i2 == 5) {
                        sb6.append(valueOf);
                    }
                }
                i++;
            }
            a(sb.toString(), sb2.toString(), sb3.toString(), sb4.toString(), sb5.toString(), sb6.toString(), false, true);
        }
    }

    private void na() {
        boolean z = true;
        if (this.ta) {
            g(true);
            f fVar = this.na;
            if (fVar != null) {
                fVar.e();
            }
            this.ta = false;
        }
        if (this.na != null && this.oa != null) {
            if (w().getBoolean(ya.permanently_hide_dealer_info_buttons)) {
                this.Ea = a(Fa.di_static_dealer_name);
                this.Fa = a(Fa.di_static_dealer_phone);
                this.Ga = a(Fa.di_static_dealer_address1);
                this.Ha = a(Fa.di_static_dealer_address2);
                this.Ia = a(Fa.di_static_dealer_email);
                this.Ja = a(Fa.di_static_dealer_web);
                c(this.V, this.W, this.Ea);
                c(this.X, this.Y, this.Fa);
                c(this.Z, this.aa, this.Ga);
                c(this.ba, this.ca, this.Ha);
                c(this.da, this.ea, this.Ia);
                c(this.fa, this.ga, this.Ja);
            } else {
                a aVar = this.ra;
                if (aVar == a.Saving) {
                    int i = 6;
                    if (!this.oa.d().trim().equals(this.V.getText().toString().trim())) {
                        this.Ka = la.Pending;
                        i = 5;
                    }
                    if (!this.oa.e().trim().equals(this.X.getText().toString().trim())) {
                        this.La = la.Pending;
                        i--;
                    }
                    if (!this.oa.a().trim().equals(this.Z.getText().toString().trim())) {
                        this.Ma = la.Pending;
                        i--;
                    }
                    if (!this.oa.b().trim().equals(this.ba.getText().toString().trim())) {
                        this.Na = la.Pending;
                        i--;
                    }
                    if (!this.oa.c().trim().equals(this.da.getText().toString().trim())) {
                        this.Oa = la.Pending;
                        i--;
                    }
                    if (!this.oa.g().trim().equals(this.fa.getText().toString().trim())) {
                        this.Pa = la.Pending;
                        i--;
                    }
                    if (!qa()) {
                        ja();
                    } else {
                        this.wa = true;
                        this.ya = 0;
                        ProgressDialog progressDialog = this.sa;
                        if (progressDialog != null) {
                            progressDialog.setProgress(i);
                        }
                    }
                } else if (aVar == a.Updating) {
                    this.Ea = this.oa.d();
                    this.Fa = this.oa.e();
                    this.Ga = this.oa.a();
                    this.Ha = this.oa.b();
                    this.Ia = this.oa.c();
                    this.Ja = this.oa.g();
                    c(this.V, this.W, this.Ea);
                    c(this.X, this.Y, this.Fa);
                    c(this.Z, this.aa, this.Ga);
                    c(this.ba, this.ca, this.Ha);
                    c(this.da, this.ea, this.Ia);
                    c(this.fa, this.ga, this.Ja);
                }
            }
            f fVar2 = this.na;
            if (this.oa.f() == 0) {
                z = false;
            }
            fVar2.a(z, this.oa.i());
            this.oa.a(false);
        }
    }

    private void oa() {
        Handler handler = this.pa;
        if (handler != null) {
            handler.removeCallbacks(this.qa);
        }
    }

    private void pa() {
        if (!w().getBoolean(ya.permanently_hide_dealer_info_buttons)) {
            a aVar = this.ra;
            if (aVar == a.Updating) {
                this.ra = a.Editing;
                this.ja.setText(a(Fa.di_dealer_save_button));
                a((Object) this.V, (Object) this.W, a(Fa.di_dealer_name_hint));
                a((Object) this.X, (Object) this.Y, a(Fa.di_dealer_phone_hint));
                a((Object) this.Z, (Object) this.aa, a(Fa.di_dealer_address1_hint));
                a((Object) this.ba, (Object) this.ca, a(Fa.di_dealer_address2_hint));
                a((Object) this.da, (Object) this.ea, a(Fa.di_dealer_email_hint));
                a((Object) this.fa, (Object) this.ga, a(Fa.di_dealer_web_hint));
            } else if (aVar == a.Editing) {
                this.ja.setText(a(Fa.di_dealer_save_status));
                g(false);
                a(this.V.getText().toString(), this.X.getText().toString(), this.Z.getText().toString(), this.ba.getText().toString(), this.da.getText().toString(), this.fa.getText().toString(), false, false);
                b(this.V, this.W, this.Ea);
                b(this.X, this.Y, this.Fa);
                b(this.Z, this.aa, this.Ga);
                b(this.ba, this.ca, this.Ha);
                b(this.da, this.ea, this.Ia);
                b(this.fa, this.ga, this.Ja);
            }
        }
    }

    private boolean qa() {
        la laVar = this.Ka;
        la laVar2 = la.Pending;
        return laVar == laVar2 || this.La == laVar2 || this.Ma == laVar2 || this.Na == laVar2 || this.Oa == laVar2 || this.Pa == laVar2;
    }

    private void ra() {
        oa();
        this.pa = new Handler();
        Handler handler = this.pa;
        C0213l lVar = new C0213l(this);
        this.qa = lVar;
        handler.post(lVar);
    }

    public void N() {
        super.N();
        oa();
    }

    public void P() {
        super.P();
        this.ua = false;
        Context m = m();
        if (m != null) {
            b.a(m).a(this.Qa);
        }
    }

    public void Q() {
        super.Q();
        this.ua = true;
        Context m = m();
        if (m != null) {
            b.a(m).a(this.Qa, new IntentFilter("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_positive"));
        }
    }

    public /* synthetic */ void d(View view) {
        C0139o oVar;
        if (this.la != null && (oVar = this.ma) != null) {
            W.a(oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.clear_info", a(Fa.di_dealer_clear_title), a(Fa.di_dealer_clear_message), a(Fa.yes), a(Fa.f1049no), (String) null);
        }
    }

    public /* synthetic */ void f(View view) {
        ka();
    }

    public /* synthetic */ void ha() {
        f fVar;
        if (CsMainCoreActivity.A()) {
            if (!qa() && this.ra == a.Saving) {
                ja();
            }
            int i = this.ra == a.Saving ? this.va ? 175 : 50 : 2000;
            int i2 = this.va ? 15 : 200;
            this.xa = false;
            if (this.ua) {
                if (qa()) {
                    this.ya++;
                }
                if (!qa()) {
                    f fVar2 = this.na;
                    if (fVar2 != null) {
                        fVar2.a(G.a(J.DealerInformation));
                    }
                } else if (this.wa || this.ya >= i2) {
                    byte[] bArr = null;
                    la laVar = this.Ka;
                    la laVar2 = la.Pending;
                    if (laVar == laVar2) {
                        bArr = G.a(H.Name, this.V.getText().toString(), this.va);
                        this.Ka = la.Sent;
                    } else if (this.La == laVar2) {
                        bArr = G.a(H.Phone, this.X.getText().toString(), this.va);
                        this.La = la.Sent;
                    } else if (this.Ma == laVar2) {
                        bArr = G.a(H.Address1, this.Z.getText().toString(), this.va);
                        this.Ma = la.Sent;
                    } else if (this.Na == laVar2) {
                        bArr = G.a(H.Address2, this.ba.getText().toString(), this.va);
                        this.Na = la.Sent;
                    } else if (this.Oa == laVar2) {
                        bArr = G.a(H.Email, this.da.getText().toString(), this.va);
                        this.Oa = la.Sent;
                    } else if (this.Pa == laVar2) {
                        bArr = G.a(H.Web, this.fa.getText().toString(), this.va);
                        this.Pa = la.Sent;
                    }
                    f fVar3 = this.na;
                    if (!(fVar3 == null || bArr == null || bArr.length <= 0)) {
                        if (this.va) {
                            fVar3.a(bArr);
                        } else {
                            int length = bArr.length / 20;
                            byte[] bArr2 = new byte[20];
                            for (int i3 = 0; i3 < length; i3++) {
                                System.arraycopy(bArr, i3 * 20, bArr2, 0, 20);
                                this.na.a(bArr2);
                            }
                        }
                    }
                    this.ya = 0;
                    this.wa = false;
                } else if (this.va && (fVar = this.na) != null) {
                    fVar.a(G.a(J.DealerInformation));
                }
            }
            this.pa.postDelayed(this.qa, (long) i);
            return;
        }
        if (!this.xa) {
            d dVar = this.oa;
            if (dVar != null) {
                dVar.j();
            }
            f fVar4 = this.na;
            if (fVar4 != null) {
                fVar4.o();
            }
            this.xa = true;
        }
        this.pa.postDelayed(this.qa, 50);
    }

    public /* synthetic */ void a(y yVar) {
        this.va = yVar.c();
        this.oa.a(yVar.a(), this.Da, yVar.b(), this.va);
        if (this.oa.h()) {
            na();
        }
    }

    public /* synthetic */ boolean b(View view, MotionEvent motionEvent) {
        return a(motionEvent) || view.performClick();
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        this.ta = true;
        this.la = m();
        this.ma = r();
        this.oa = new d();
        if (bundle != null) {
            this.Ea = bundle.getString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_name", BuildConfig.FLAVOR);
            this.Fa = bundle.getString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_phone", BuildConfig.FLAVOR);
            this.Ga = bundle.getString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_address1", BuildConfig.FLAVOR);
            this.Ha = bundle.getString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_address2", BuildConfig.FLAVOR);
            this.Ia = bundle.getString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_email", BuildConfig.FLAVOR);
            this.Ja = bundle.getString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_web", BuildConfig.FLAVOR);
        }
        if (w().getBoolean(ya.permanently_hide_dealer_info_buttons)) {
            this.Ea = a(Fa.di_static_dealer_name);
            this.Fa = a(Fa.di_static_dealer_phone);
            this.Ga = a(Fa.di_static_dealer_address1);
            this.Ha = a(Fa.di_static_dealer_address2);
            this.Ia = a(Fa.di_static_dealer_email);
            this.Ja = a(Fa.di_static_dealer_web);
        }
        if (k() != null) {
            this.Da = k().getInt("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.firmware_version", 0);
        } else {
            f fVar = this.na;
            if (fVar != null) {
                fVar.j();
            }
        }
        if (f() != null) {
            ((F) C.a(f()).a(F.class)).c().a(this, new C0207f(this));
        }
    }

    private void b(Activity activity) {
        try {
            this.na = (f) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString().concat(" must implement CsFragmentEvents"));
        }
    }

    private void b(Object obj, Object obj2, String str) {
        TextView textView = (TextView) obj2;
        ((EditText) obj).setVisibility(4);
        textView.setText(str.trim());
        textView.setVisibility(0);
    }

    public /* synthetic */ void e(View view) {
        C0139o oVar;
        if (this.la != null && (oVar = this.ma) != null) {
            W.a(oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.import_info", a(Fa.di_dealer_import_title), a(Fa.di_dealer_import_message), a(Fa.yes), a(Fa.f1049no), (String) null);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(Da.fragment_dealer_information, viewGroup, false);
        inflate.setOnTouchListener(new C0212k(this));
        f fVar = this.na;
        if (fVar != null) {
            fVar.b(w().getString(Fa.bt_status_loading));
        }
        this.Ca = !w().getBoolean(ya.permanently_hide_dealer_info_buttons) && w().getBoolean(ya.show_dealer_info_buttons_by_default);
        inflate.findViewById(Ba.scrollView).setOnTouchListener(new C0210i(this));
        inflate.findViewById(Ba.scrollViewHorizontal).setOnTouchListener(new C0208g(this));
        this.V = (EditText) inflate.findViewById(Ba.dealer_name);
        this.W = (TextView) inflate.findViewById(Ba.dealer_name_display);
        this.X = (EditText) inflate.findViewById(Ba.dealer_phone);
        this.Y = (TextView) inflate.findViewById(Ba.dealer_phone_display);
        this.Z = (EditText) inflate.findViewById(Ba.dealer_address1);
        this.aa = (TextView) inflate.findViewById(Ba.dealer_address1_display);
        this.ba = (EditText) inflate.findViewById(Ba.dealer_address2);
        this.ca = (TextView) inflate.findViewById(Ba.dealer_address2_display);
        this.da = (EditText) inflate.findViewById(Ba.dealer_email);
        this.ea = (TextView) inflate.findViewById(Ba.dealer_email_display);
        this.fa = (EditText) inflate.findViewById(Ba.dealer_web);
        this.ga = (TextView) inflate.findViewById(Ba.dealer_web_display);
        this.ja = (Button) inflate.findViewById(Ba.edit_dealer_info_button);
        int i = 4;
        this.ja.setVisibility(this.Ca ? 0 : 4);
        this.ja.setOnClickListener(new C0206e(this));
        this.ka = (Button) inflate.findViewById(Ba.clear_dealer_info_button);
        this.ka.setVisibility(this.Ca ? 0 : 4);
        this.ka.setOnClickListener(new C0214m(this));
        this.ha = (Button) inflate.findViewById(Ba.import_button);
        this.ha.setVisibility(this.Ca ? 0 : 4);
        this.ha.setOnClickListener(new C0211j(this));
        this.ia = (Button) inflate.findViewById(Ba.export_button);
        Button button = this.ia;
        if (this.Ca) {
            i = 0;
        }
        button.setVisibility(i);
        this.ia.setOnClickListener(new C0209h(this));
        g(false);
        if (!ia.a(this.Ea)) {
            this.W.setText(this.Ea);
            this.Y.setText(this.Fa);
            this.aa.setText(this.Ga);
            this.ca.setText(this.Ha);
            this.ea.setText(this.Ia);
            this.ga.setText(this.Ja);
        }
        ra();
        return inflate;
    }

    public void e(Bundle bundle) {
        TextView textView = this.W;
        if (textView != null && !ia.a(textView.getText().toString())) {
            bundle.putString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_name", this.W.getText().toString());
        }
        TextView textView2 = this.Y;
        if (textView2 != null && !ia.a(textView2.getText().toString())) {
            bundle.putString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_phone", this.Y.getText().toString());
        }
        TextView textView3 = this.aa;
        if (textView3 != null && !ia.a(textView3.getText().toString())) {
            bundle.putString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_address1", this.aa.getText().toString());
        }
        TextView textView4 = this.ca;
        if (textView4 != null && !ia.a(textView4.getText().toString())) {
            bundle.putString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_address2", this.ca.getText().toString());
        }
        TextView textView5 = this.ea;
        if (textView5 != null && !ia.a(textView5.getText().toString())) {
            bundle.putString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_email", this.ea.getText().toString());
        }
        TextView textView6 = this.ga;
        if (textView6 != null && !ia.a(textView6.getText().toString())) {
            bundle.putString("com.ChandlerSystemsInc.signatureAppCore.controllers.dealer_information_fragment.dealer_web", this.ga.getText().toString());
        }
        super.e(bundle);
    }

    public /* synthetic */ boolean c(View view, MotionEvent motionEvent) {
        return a(motionEvent) || view.performClick();
    }

    public /* synthetic */ void c(View view) {
        pa();
    }

    private void c(Object obj, Object obj2, String str) {
        TextView textView = (TextView) obj2;
        textView.setText(str.trim());
        textView.setVisibility(0);
        ((EditText) obj).setVisibility(4);
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return a(motionEvent) || view.performClick();
    }

    public void a(Context context) {
        super.a(context);
        b(context instanceof Activity ? (Activity) context : null);
    }

    public void a(Activity activity) {
        f fVar;
        super.a(activity);
        if (!this.ta && (fVar = this.na) != null) {
            fVar.e();
        }
        if (Build.VERSION.SDK_INT < 23) {
            b(activity);
        }
    }

    private void a(Object obj, Object obj2, String str) {
        EditText editText = (EditText) obj;
        TextView textView = (TextView) obj2;
        if (!ia.a(textView.getText().toString())) {
            editText.setHint(textView.getText().toString());
        } else {
            editText.setHint(str);
        }
        editText.setText(textView.getText().toString().trim());
        editText.setVisibility(0);
        textView.setVisibility(4);
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
        if (!w().getBoolean(ya.permanently_hide_dealer_info_buttons)) {
            this.ra = a.Saving;
            this.wa = true;
            this.ya = 0;
            this.Ea = str;
            this.Fa = str2;
            this.Ga = str3;
            this.Ha = str4;
            this.Ia = str5;
            this.Ja = str6;
            this.V.setText(str);
            this.X.setText(str2);
            this.Z.setText(str3);
            this.ba.setText(str4);
            this.da.setText(str5);
            this.fa.setText(str6);
            this.W.setText(str);
            this.Y.setText(str2);
            this.aa.setText(str3);
            this.ca.setText(str4);
            this.ea.setText(str5);
            this.ga.setText(str6);
            la laVar = la.Pending;
            this.Ka = laVar;
            this.La = laVar;
            this.Ma = laVar;
            this.Na = laVar;
            this.Oa = laVar;
            this.Pa = laVar;
            a(z, z2);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = z ? Fa.di_clear_progress_title : z2 ? Fa.di_import_progress_title : Fa.di_save_progress_title;
        String a2 = a(z ? Fa.di_clear_progress_message : z2 ? Fa.di_import_progress_message : Fa.di_save_progress_message);
        this.sa = new ProgressDialog(this.la);
        this.sa.setTitle(i);
        this.sa.setMessage(a2);
        this.sa.setProgressStyle(1);
        this.sa.setProgress(0);
        this.sa.setMax(6);
        this.sa.setCanceledOnTouchOutside(false);
        this.sa.show();
    }

    private boolean a(MotionEvent motionEvent) {
        if (w().getBoolean(ya.permanently_hide_dealer_info_buttons)) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Aa = motionEvent.getY();
            return true;
        } else if (actionMasked != 1) {
            return false;
        } else {
            float y = motionEvent.getY() - this.Aa;
            int i = y > 0.0f ? 1 : 0;
            long currentTimeMillis = System.currentTimeMillis() - this.Ba;
            if (Math.abs(y) < 150.0f) {
                return false;
            }
            if (currentTimeMillis > 3500) {
                this.za = 0;
            }
            this.za += i;
            if (this.za >= 5) {
                this.Ca = !this.Ca;
                int i2 = 4;
                this.ja.setVisibility(this.Ca ? 0 : 4);
                this.ka.setVisibility(this.Ca ? 0 : 4);
                this.ha.setVisibility(this.Ca ? 0 : 4);
                Button button = this.ia;
                if (this.Ca) {
                    i2 = 0;
                }
                button.setVisibility(i2);
                this.za = 0;
            }
            this.Ba = System.currentTimeMillis();
            return true;
        }
    }
}
