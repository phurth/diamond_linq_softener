package com.chandlersystemsinc.signatureappcore.controllers;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.C0071a;
import androidx.appcompat.app.C0082l;
import androidx.appcompat.app.m;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.C0132h;
import androidx.fragment.app.C0134j;
import androidx.fragment.app.C0139o;
import androidx.viewpager.widget.ViewPager;
import b.a.a.Aa;
import b.a.a.Ba;
import b.a.a.C0176ca;
import b.a.a.Da;
import b.a.a.Fa;
import b.a.a.G;
import b.a.a.J;
import b.a.a.W;
import b.a.a.b.c;
import b.a.a.c.A;
import b.a.a.c.C;
import b.a.a.c.D;
import b.a.a.c.F;
import b.a.a.c.n;
import b.a.a.c.o;
import b.a.a.c.r;
import b.a.a.c.s;
import b.a.a.c.y;
import b.a.a.d.e;
import b.a.a.d.f;
import b.a.a.d.g;
import b.a.a.d.h;
import b.a.a.ha;
import b.a.a.ia;
import b.a.a.ma;
import b.a.a.oa;
import b.a.a.wa;
import b.a.a.ya;
import b.a.a.za;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import me.relex.circleindicator.CircleIndicator;
import no.nordicsemi.android.log.BuildConfig;

public final class CsMainCoreActivity extends m implements b.a.a.d.b, b.a.a.d.a, h, f, e, g {
    private static Runnable A;
    private static final String[] r = {"com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_fragment", "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_full_fragment", "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.device_list_fragment", "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dashboard_fragment", "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.advanced_settings_fragment", "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.status_and_history_fragment", "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dealer_information_fragment"};
    private static C s;
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public static n t;
    private static List<oa> u;
    private static oa v;
    private static boolean w;
    private static boolean x;
    private static b.a.a.e.e y;
    private static Handler z;
    private DrawerLayout B;
    private NavigationView C;
    private ProgressBar D;
    /* access modifiers changed from: private */
    public TextView E;
    private ConstraintLayout F;
    private ConstraintLayout G;
    private Context H;
    private C0139o I;
    private A J;
    private F K;
    private List<String> L;
    private boolean M;
    private int N;
    private int O;
    private long P;
    /* access modifiers changed from: private */
    public boolean Q = true;
    private boolean R;
    private boolean S;
    private boolean T = true;
    private final Map<String, o> U = new HashMap();
    private b V;
    private C0132h W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private boolean aa;
    private boolean ba;
    private boolean ca;
    private int da = 0;
    private int ea = 0;
    private boolean fa = false;

    private enum a {
        NavFragment(0),
        NavFullFragment(1),
        DeviceList(2),
        Dashboard(3),
        AdvancedSettings(4),
        StatusAndHistory(5),
        DealerInformation(6);
        
        private final int i;

        private a(int i2) {
            this.i = i2;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.i;
        }
    }

    private enum b {
        DeviceList(0),
        Dashboard(1),
        AdvancedSettings(2),
        StatusAndHistory(3),
        DealerInformation(4);
        
        private final int g;

        private b(int i) {
            this.g = i;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.g;
        }

        static b a(int i) {
            for (b bVar : values()) {
                if (bVar.a() == i) {
                    return bVar;
                }
            }
            return DeviceList;
        }
    }

    public static boolean A() {
        n nVar = t;
        if (nVar != null) {
            return nVar.h();
        }
        C c = s;
        if (c == null) {
            s = C.c();
            return false;
        } else if (c.d() == D.Connected) {
            return true;
        } else {
            return false;
        }
    }

    private void E() {
        C0139o oVar;
        oa oaVar;
        this.O++;
        if (this.O % 5 == 0 && s != null && (oaVar = v) != null && !ia.a(oaVar.a())) {
            s.a(v.c());
        }
        if (this.O >= 10 && (oVar = this.I) != null) {
            W.a(oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.connection_timeout", getString(Fa.bt_timeout_title), getString(Fa.bt_timeout_message), (String) null);
        }
    }

    private void F() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
            return;
        }
        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (Build.VERSION.SDK_INT < 23) {
            A a2 = this.J;
            if (a2 != null) {
                a2.c();
            }
        } else if (!a((Context) this, strArr)) {
            C0082l.a aVar = new C0082l.a(this);
            aVar.b(getString(Fa.permissions_request_title));
            aVar.a((CharSequence) getString(Fa.permissions_request_message));
            aVar.a(17039370, (DialogInterface.OnClickListener) null);
            aVar.a((DialogInterface.OnDismissListener) new A(this, strArr));
            aVar.c();
        } else {
            A a3 = this.J;
            if (a3 != null) {
                a3.c();
            }
        }
    }

    private void G() {
        try {
            if (t != null) {
                t.e();
                t.d();
                t = null;
            }
            if (s != null) {
                s.a();
                s.e();
                s = null;
                w = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void H() {
        if (!w) {
            C.a(new s(r.class, getApplicationContext()));
        }
        s = C.c();
        C c = s;
        if (c != null) {
            c.a((b.a.a.d.a) this);
            w = true;
        }
    }

    private void I() {
        v = null;
        n nVar = t;
        if (nVar != null) {
            nVar.e().b();
        }
    }

    private void J() {
        d((String) null);
    }

    private void K() {
        getWindow().getDecorView().setSystemUiVisibility(5894);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new B(this));
        getWindow().addFlags(1536);
    }

    private void L() {
        this.J = new A(getApplicationContext(), this);
        this.J.a((b.a.a.d.b) this);
    }

    /* access modifiers changed from: private */
    public void M() {
        n nVar;
        oa oaVar;
        if (!this.M && (nVar = t) != null && (oaVar = v) != null) {
            no.nordicsemi.android.ble.F a2 = nVar.a(oaVar.c());
            a2.a(3);
            a2.a(5, 200);
            a2.a((no.nordicsemi.android.ble.a.e) new C(this));
            a2.a((no.nordicsemi.android.ble.a.f) C0224x.f1416a);
            a2.a(false);
            a2.b();
        }
    }

    private void N() {
        if (!this.fa) {
            this.fa = true;
            z = new Handler();
            Handler handler = z;
            D d = new D(this);
            A = d;
            handler.postDelayed(d, 1000);
            C0139o oVar = this.I;
            if (oVar != null) {
                W.a(this, oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_next", getString(Fa.rg_regen_title), getString(Fa.rg_regen_next_message), (String) null);
            }
        }
    }

    private void O() {
        if (!this.fa) {
            this.fa = true;
            z = new Handler();
            Handler handler = z;
            E e = new E(this);
            A = e;
            handler.postDelayed(e, 1000);
            C0139o oVar = this.I;
            if (oVar != null) {
                W.a(this, oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_now", getString(Fa.rg_regen_title), getString(!this.aa ? Fa.rg_regen_now_message : Fa.rg_regen_next_step_message), (String) null);
            }
        }
    }

    private void P() {
        Handler handler = z;
        if (handler != null) {
            handler.removeCallbacks(A);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Q() {
        /*
            r4 = this;
            r0 = 0
            x = r0
            b.a.a.c.n r0 = t     // Catch:{ Exception -> 0x0045 }
            r1 = 0
            if (r0 == 0) goto L_0x002c
            b.a.a.c.n r0 = t     // Catch:{ Exception -> 0x0045 }
            boolean r0 = r0.h()     // Catch:{ Exception -> 0x0045 }
            if (r0 == 0) goto L_0x002c
            b.a.a.c.n r0 = t     // Catch:{ Exception -> 0x0045 }
            byte[] r2 = b.a.a.G.a()     // Catch:{ Exception -> 0x0045 }
            r0.a((byte[]) r2)     // Catch:{ Exception -> 0x0045 }
            b.a.a.c.n r0 = t     // Catch:{ Exception -> 0x0045 }
            r2 = 25
            r0.b((long) r2)     // Catch:{ Exception -> 0x0045 }
            r2 = 250(0xfa, double:1.235E-321)
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0025 }
        L_0x0025:
            b.a.a.c.n r0 = t     // Catch:{ Exception -> 0x0045 }
            r0.d()     // Catch:{ Exception -> 0x0045 }
            t = r1     // Catch:{ Exception -> 0x0045 }
        L_0x002c:
            b.a.a.c.C r0 = s     // Catch:{ Exception -> 0x0045 }
            if (r0 == 0) goto L_0x0043
            b.a.a.c.C r0 = s     // Catch:{ Exception -> 0x0045 }
            byte[] r2 = b.a.a.G.a()     // Catch:{ Exception -> 0x0045 }
            r0.a((byte[]) r2)     // Catch:{ Exception -> 0x0045 }
            r2 = 200(0xc8, double:9.9E-322)
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x003e }
        L_0x003e:
            b.a.a.c.C r0 = s     // Catch:{ Exception -> 0x0045 }
            r0.e()     // Catch:{ Exception -> 0x0045 }
        L_0x0043:
            v = r1     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            r4.R()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.Q():void");
    }

    private void R() {
        this.T = false;
        try {
            startActivity(getIntent().addFlags(335577088));
        } catch (Exception unused) {
        }
    }

    private void S() {
        String str;
        this.Y = false;
        this.Z = true;
        b bVar = this.V;
        if (bVar != null) {
            int i = na.f1399b[bVar.ordinal()];
            String str2 = BuildConfig.FLAVOR;
            if (i == 1) {
                this.W = a(a.DeviceList);
                str2 = getResources().getString(Fa.npm_device_list);
                this.Y = true;
                this.Z = false;
                str = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.device_list_fragment";
            } else if (i == 2) {
                this.W = a(a.Dashboard);
                str2 = getResources().getString(Fa.npm_dashboard);
                str = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dashboard_fragment";
            } else if (i == 3) {
                this.W = a(a.AdvancedSettings);
                str2 = getResources().getString(Fa.npm_advanced_settings);
                str = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.advanced_settings_fragment";
            } else if (i == 4) {
                this.W = a(a.StatusAndHistory);
                str2 = getResources().getString(Fa.npm_status_and_history);
                str = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.status_and_history_fragment";
            } else if (i != 5) {
                str = str2;
            } else {
                this.W = a(a.DealerInformation);
                str2 = getResources().getString(Fa.npm_dealer_information);
                str = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dealer_information_fragment";
            }
            C0139o oVar = this.I;
            if (oVar != null) {
                oVar.b();
                if (this.W != null && !ia.a(str)) {
                    if (!this.X) {
                        androidx.fragment.app.D a2 = this.I.a();
                        a2.a(Ba.content_pane, this.W);
                        a2.a((String) null);
                        a2.a();
                    } else {
                        androidx.fragment.app.D a3 = this.I.a();
                        a3.a(Ba.content_pane, this.W, str);
                        a3.a();
                    }
                    this.I.b();
                }
            }
            if (!this.X && w() != null) {
                w().a((CharSequence) str2);
            }
            T();
            X();
        }
    }

    private void T() {
        if (this.X && this.I != null) {
            a aVar = this.V == b.DeviceList ? a.NavFragment : a.NavFullFragment;
            String str = this.V == b.DeviceList ? "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_fragment" : "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_full_fragment";
            qa qaVar = (qa) a(aVar, this.V);
            if (qaVar != null) {
                androidx.fragment.app.D a2 = this.I.a();
                a2.a(Ba.nav_pane, qaVar, str);
                a2.a();
            }
        }
    }

    private void U() {
        NavigationView navigationView = this.C;
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(new F(this));
        }
    }

    private void V() {
        if (this.H != null) {
            boolean z2 = ma.c(this) == C0176ca.Metric;
            TextView textView = (TextView) findViewById(Ba.units_standard);
            TextView textView2 = (TextView) findViewById(Ba.units_metric);
            textView.setTextColor(this.H.getResources().getColor(z2 ? za.npm_nav_list_text_color : za.npm_nav_list_text_color_active));
            textView2.setTextColor(this.H.getResources().getColor(z2 ? za.npm_nav_list_text_color_active : za.npm_nav_list_text_color));
            Switch switchR = (Switch) findViewById(Ba.unit_toggle);
            switchR.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
            switchR.setChecked(z2);
            switchR.getThumbDrawable().setColorFilter(a.g.a.a.a(this.H, za.switch_thumb_off), PorterDuff.Mode.SRC_IN);
            switchR.getTrackDrawable().setColorFilter(a.g.a.a.a(this.H, za.switch_track_on), PorterDuff.Mode.SRC_IN);
            switchR.setOnCheckedChangeListener(new G(this, textView, textView2, switchR));
        }
    }

    private void W() {
        setRequestedOrientation(-1);
        this.Y = this.V == b.DeviceList;
        this.Z = this.V != b.DeviceList;
        if (!this.X) {
            a((Toolbar) findViewById(Ba.toolbar));
            C0071a w2 = w();
            if (w2 != null) {
                w2.d(true);
                w2.b(Aa.ic_menu);
            }
            this.B = (DrawerLayout) findViewById(Ba.drawer_layout);
            this.C = (NavigationView) findViewById(Ba.nav_view);
            this.G = (ConstraintLayout) findViewById(Ba.unit_container);
            this.C.setItemIconTintList((ColorStateList) null);
            if (this.I != null) {
                ((ImageView) this.C.a(0).findViewById(Ba.nav_logo_main)).setOnClickListener(new C0225y(this));
            }
            ((ImageView) findViewById(Ba.logo_bottom)).setOnClickListener(new C0226z(this));
            V();
            U();
        } else {
            T();
        }
        L();
        S();
        if (this.R) {
            F();
        }
    }

    private void X() {
        b bVar;
        ha a2;
        NavigationView navigationView;
        if (!this.X && (navigationView = this.C) != null) {
            Menu menu = navigationView.getMenu();
            menu.findItem(Ba.nav_dashboard).setVisible(this.Z);
            menu.findItem(Ba.nav_advanced_settings).setVisible(this.Z);
            menu.findItem(Ba.nav_status_and_history).setVisible(this.Z);
            menu.findItem(Ba.nav_dealer_information).setVisible(this.Z);
            menu.findItem(Ba.nav_regen_now).setVisible(this.Z);
            menu.findItem(Ba.nav_regen_next).setVisible(this.Z);
            this.G.setVisibility(this.Z ? 8 : 0);
            if (!this.Z) {
                menu.findItem(Ba.nav_device_list).setChecked(true);
            }
            b bVar2 = this.V;
            if (bVar2 != null) {
                int i = na.f1399b[bVar2.ordinal()];
                if (i == 1) {
                    menu.findItem(Ba.nav_device_list).setChecked(true);
                } else if (i == 2) {
                    menu.findItem(Ba.nav_dashboard).setChecked(true);
                } else if (i == 3) {
                    menu.findItem(Ba.nav_advanced_settings).setChecked(true);
                } else if (i == 4) {
                    menu.findItem(Ba.nav_status_and_history).setChecked(true);
                } else if (i == 5) {
                    menu.findItem(Ba.nav_dealer_information).setChecked(true);
                }
            }
        } else if (this.I != null) {
            qa qaVar = (qa) this.I.a(this.Z ? "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_full_fragment" : "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_fragment");
            if (qaVar != null && (bVar = this.V) != null && (a2 = ha.a(bVar.a())) != null) {
                try {
                    qaVar.a(a2);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void Y() {
        if (this.S) {
            b(G.b(J.DeviceList));
            return;
        }
        b bVar = this.V;
        if (bVar == b.Dashboard) {
            b(G.a(J.Dashboard));
        } else if (bVar == b.AdvancedSettings) {
            b(G.a(J.AdvancedSettings));
        } else if (bVar == b.StatusAndHistory) {
            b(G.a(J.StatusAndHistory));
        } else if (bVar == b.DealerInformation) {
            b(G.a(J.DealerInformation));
        } else {
            b(G.a(J.DeviceList));
        }
    }

    private void Z() {
        J j = J.Dashboard;
        b bVar = this.V;
        if (bVar != null) {
            int i = na.f1399b[bVar.ordinal()];
            if (i == 3) {
                j = J.AdvancedSettings;
            } else if (i == 4) {
                j = J.StatusAndHistory;
            } else if (i == 5) {
                j = J.DealerInformation;
            }
        }
        if (this.ea > 0) {
            b(G.d(j));
            if (!this.M) {
                n nVar = t;
                if (nVar != null) {
                    nVar.b(100);
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException unused) {
                }
            }
            this.ea--;
        } else if (this.da > 0) {
            b(G.c(j));
            if (!this.M) {
                n nVar2 = t;
                if (nVar2 != null) {
                    nVar2.b(100);
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException unused2) {
                }
            }
            this.da--;
        }
    }

    private void e(String str) {
        ProgressBar progressBar = this.D;
        if (progressBar != null && this.E != null) {
            progressBar.setVisibility(0);
            this.E.setVisibility(0);
            this.E.setText(str);
        }
    }

    public /* synthetic */ void C() {
        this.fa = false;
    }

    public /* synthetic */ void D() {
        this.fa = false;
    }

    public void f() {
        N();
    }

    public void h() {
        C c = s;
        if (c != null) {
            c.a();
        }
        I();
    }

    public void i() {
        if (!x) {
            d(getString(Fa.bt_status_scanning));
        }
    }

    public void j() {
        C0139o oVar = this.I;
        if (oVar != null) {
            W.a(oVar, "Advanced Settings", getString(Fa.invalid_arguments_exception));
        }
        finish();
    }

    public void k() {
        Q();
    }

    public void l() {
        c(true);
    }

    public void m() {
        setRequestedOrientation(14);
    }

    public void n() {
        setRequestedOrientation(-1);
    }

    public void o() {
        c(false);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            R();
            return;
        }
        C0139o oVar = this.I;
        if (oVar != null) {
            W.a(oVar, getString(Fa.bt_not_enabled_title), getString(Fa.bt_not_enabled_message));
        }
        finish();
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(Ba.drawer_layout);
        if (drawerLayout != null && drawerLayout.f(8388611)) {
            drawerLayout.a(8388611);
        }
        if (!this.Y) {
            this.V = b.DeviceList;
            S();
            return;
        }
        moveTaskToBack(true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(Da.activity_main_core);
        boolean z2 = true;
        androidx.appcompat.app.o.a(true);
        K();
        this.H = this;
        this.I = s();
        this.K = (F) androidx.lifecycle.C.a((C0134j) this).a(F.class);
        boolean b2 = ma.b(this.H);
        boolean d = ma.d(this.H);
        if (bundle != null) {
            this.V = b.a(bundle.getInt("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.selected_fragment", 0));
            d = bundle.getBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.session_started", ma.d(this.H));
            w = bundle.getBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.bluetooth_initialized", false);
            this.R = bundle.getBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.on_device_list", true);
        } else {
            this.V = b.DeviceList;
            w = false;
            this.R = true;
        }
        if (!getResources().getBoolean(ya.enable_feature_slides) || d) {
            b2 = true;
        }
        u = new ArrayList();
        this.L = new ArrayList();
        this.L.add("44:A6:E5:04:13:58");
        this.L.add("00:BA:55:56:FF:EB");
        if (findViewById(Ba.dual_pane) == null) {
            z2 = false;
        }
        this.X = z2;
        this.D = (ProgressBar) findViewById(Ba.connection_progress);
        this.E = (TextView) findViewById(Ba.progress_status);
        this.F = (ConstraintLayout) findViewById(Ba.intro_container);
        this.F.setVisibility(b2 ? 8 : 0);
        if (!b2) {
            setRequestedOrientation(0);
            setRequestedOrientation(14);
            ViewPager viewPager = (ViewPager) findViewById(Ba.intro_viewpager);
            viewPager.setAdapter(new c(this.H, this));
            ((CircleIndicator) findViewById(Ba.intro_indicator)).setViewPager(viewPager);
            return;
        }
        W();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.T) {
            ma.b(this.H, false);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.X || menuItem == null || menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.B.g(8388611);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.Q = false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 2) {
            return;
        }
        if (iArr[0] != 0) {
            C0139o oVar = this.I;
            if (oVar != null) {
                W.a(oVar, getString(Fa.permissions_denied_title), getString(Fa.permissions_denied_message));
            }
            finish();
        } else if (this.V == b.DeviceList) {
            L();
            A a2 = this.J;
            if (a2 != null) {
                a2.c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C c = s;
        if (c != null) {
            c.a((b.a.a.d.a) this);
        }
        this.Q = true;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        b bVar = this.V;
        if (bVar != null) {
            bundle.putInt("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.selected_fragment", bVar.a());
        }
        bundle.putBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.bluetooth_initialized", w);
        bundle.putBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.on_device_list", this.R);
        bundle.putBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.session_started", ma.d(this.H));
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        P();
        try {
            if (!isChangingConfigurations()) {
                try {
                    G();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Runtime.getRuntime().gc();
                finish();
                return;
            }
            this.T = false;
        } catch (Exception unused) {
        }
    }

    public void p() {
        O();
    }

    public static oa c(String str) {
        List<oa> list = u;
        if (!(list == null || list.size() == 0)) {
            for (oa next : u) {
                if (next.a().equals(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    private void d(String str) {
        if (ia.a(str)) {
            ProgressBar progressBar = this.D;
            if (progressBar != null && this.E != null) {
                progressBar.setVisibility(8);
                this.E.setVisibility(8);
                this.E.setText(BuildConfig.FLAVOR);
            }
        } else if (this.E.getText().toString().equals(str)) {
            this.D.setVisibility(8);
            this.E.setVisibility(8);
            this.E.setText(BuildConfig.FLAVOR);
        }
    }

    public void a(boolean z2) {
        this.F.setVisibility(8);
        ma.b(this.H, true);
        W();
    }

    public /* synthetic */ void b(View view) {
        if (!getResources().getBoolean(ya.disable_secondary_logo)) {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(getString(Fa.company_website)));
                startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public /* synthetic */ void a(View view) {
        W.a(view.getContext(), this.I, "com.ChandlerSystemsInc.signatureAppCore.nav_fragment.compliance");
    }

    public /* synthetic */ void c(int i) {
        if ((i & 4) == 0) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public void e() {
        J();
    }

    private void c(boolean z2) {
        if (v != null) {
            A a2 = this.J;
            if (a2 != null) {
                a2.a();
            }
            x = true;
            if (v.j()) {
                d(false);
                M();
                return;
            }
            String str = null;
            C c = s;
            if (!(c == null || c.b() == null)) {
                str = s.b().getAddress();
            }
            if (ia.a(str) || str.equals(v.a())) {
                e(z2);
                return;
            }
            s.a();
            int i = this.N;
            this.N = i + 1;
            if (i <= 5) {
                c(z2);
                return;
            }
            C0139o oVar = this.I;
            if (oVar != null) {
                W.a(oVar, "Unable to Connect", "Unable to connect to the specified address.");
            }
            finish();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(boolean r4) {
        /*
            r3 = this;
            b.a.a.oa r0 = v
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            if (r4 == 0) goto L_0x0010
            int r4 = b.a.a.Fa.bt_status_connecting
            java.lang.String r4 = r3.getString(r4)
            r3.e((java.lang.String) r4)
        L_0x0010:
            r0 = 250(0xfa, double:1.235E-321)
            b.a.a.c.C r4 = s     // Catch:{  }
            if (r4 == 0) goto L_0x001e
            b.a.a.c.C r4 = s     // Catch:{  }
            r4.a()     // Catch:{  }
            java.lang.Thread.sleep(r0)     // Catch:{ Throwable -> 0x001e }
        L_0x001e:
            b.a.a.oa r4 = v
            boolean r4 = r4.i()
            r3.d((boolean) r4)
            b.a.a.c.C r4 = s
            if (r4 == 0) goto L_0x0037
            b.a.a.oa r2 = v
            android.bluetooth.BluetoothDevice r2 = r2.c()
            r4.a((android.bluetooth.BluetoothDevice) r2)
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0037 }
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.e(boolean):void");
    }

    public /* synthetic */ void a(TextView textView, TextView textView2, Switch switchR, CompoundButton compoundButton, boolean z2) {
        textView.setTextColor(this.H.getResources().getColor(z2 ? za.npm_nav_list_text_color : za.npm_nav_list_text_color_active));
        textView2.setTextColor(this.H.getResources().getColor(z2 ? za.npm_nav_list_text_color_active : za.npm_nav_list_text_color));
        switchR.getThumbDrawable().setColorFilter(a.g.a.a.a(this.H, za.switch_thumb_off), PorterDuff.Mode.SRC_IN);
        switchR.getTrackDrawable().setColorFilter(a.g.a.a.a(this.H, za.switch_track_on), PorterDuff.Mode.SRC_IN);
        ma.a((Context) this, z2 ? C0176ca.Metric : C0176ca.Standard);
    }

    private void b(a aVar) {
        C0139o oVar = this.I;
        if (oVar != null) {
            C0132h a2 = oVar.a("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_fragment");
            switch (na.f1398a[aVar.ordinal()]) {
                case 2:
                    a2 = this.I.a("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_full_fragment");
                    break;
                case 3:
                    a2 = this.I.a("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.device_list_fragment");
                    break;
                case 4:
                    a2 = this.I.a("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dashboard_fragment");
                    break;
                case 5:
                    a2 = this.I.a("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.advanced_settings_fragment");
                    break;
                case 6:
                    a2 = this.I.a("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.status_and_history_fragment");
                    break;
                case 7:
                    a2 = this.I.a("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dealer_information_fragment");
                    break;
            }
            if (a2 != null) {
                androidx.fragment.app.D a3 = this.I.a();
                a3.a(a2);
                a3.a();
                this.I.b();
            }
        }
    }

    private C0132h a(a aVar) {
        return a(aVar, (b) null);
    }

    public void d() {
        e(getString(Fa.bt_status_scanning));
        List<oa> list = u;
        if (list != null) {
            list.clear();
        }
    }

    private C0132h a(a aVar, b bVar) {
        if (this.I == null) {
            return null;
        }
        C0132h a2 = this.I.a(r[aVar.a()]);
        if (a2 != null) {
            return a2;
        }
        boolean z2 = true;
        switch (na.f1398a[aVar.ordinal()]) {
            case 1:
            case 2:
                ha haVar = ha.DeviceList;
                if (bVar != null && (haVar = ha.a(bVar.a())) == null) {
                    haVar = ha.DeviceList;
                }
                return qa.a(this.Z, haVar);
            case 3:
                return la.ma();
            case 4:
                b.a.a.e.e eVar = y;
                if (eVar != null) {
                    return ea.a(eVar.a(), y.g());
                }
                return a2;
            case 5:
                b.a.a.e.e eVar2 = y;
                if (eVar2 == null) {
                    return a2;
                }
                int a3 = eVar2.a();
                wa g = y.g();
                oa oaVar = v;
                if (oaVar == null || !oaVar.i()) {
                    z2 = false;
                }
                return Z.a(a3, g, z2);
            case 6:
                b.a.a.e.e eVar3 = y;
                if (eVar3 == null) {
                    return a2;
                }
                int a4 = eVar3.a();
                oa oaVar2 = v;
                if (oaVar2 == null || !oaVar2.i()) {
                    z2 = false;
                }
                return va.a(a4, z2);
            case 7:
                b.a.a.e.e eVar4 = y;
                if (eVar4 != null) {
                    return ga.e(eVar4.a());
                }
                return a2;
            default:
                return a2;
        }
    }

    private void d(boolean z2) {
        this.M = z2;
        if (z2) {
            if (!s.a(getApplication())) {
                C0139o oVar = this.I;
                if (oVar != null) {
                    W.a(oVar, getString(Fa.bt_not_avail_title), getString(Fa.bt_not_avail_message));
                }
                finish();
                return;
            }
            H();
        } else if (t == null) {
            t = new n(getApplication(), this);
            t.a(new ma(this));
        }
    }

    private void b(boolean z2, boolean z3) {
        NavigationView navigationView;
        this.aa = z2;
        if (!(z2 == this.ba && z3 == this.ca)) {
            Intent intent = new Intent("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_update");
            intent.putExtra("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_active", z2 || z3);
            a.l.a.b.a((Context) this).a(intent);
            if (!this.X && (navigationView = this.C) != null && this.Z) {
                Menu menu = navigationView.getMenu();
                if (z2 || z3) {
                    menu.findItem(Ba.nav_regen_now).setTitle(getString(Fa.npm_regen_next_step_menu));
                } else {
                    menu.findItem(Ba.nav_regen_now).setTitle(getString(Fa.npm_regen_now_menu));
                }
            }
        }
        this.ba = z2;
        this.ca = z3;
    }

    public void b(String str) {
        e(str);
    }

    public void b(boolean z2) {
        this.S = z2;
    }

    private void b(byte[] bArr) {
        n nVar;
        if (!this.Q || this.M || (nVar = t) == null) {
            if (s != null && this.Q) {
                E();
                if (bArr != null) {
                    s.a(bArr);
                }
                if (s.d() == D.Connected) {
                    this.O = 0;
                } else if (v == null) {
                    Q();
                } else if (this.P == 0 || System.currentTimeMillis() - this.P > 5000) {
                    s.a(v.c());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException unused) {
                    }
                    this.P = System.currentTimeMillis();
                    b(bArr);
                }
            }
        } else if (bArr != null) {
            nVar.a(bArr);
        }
    }

    private a a(b bVar) {
        int i = na.f1399b[bVar.ordinal()];
        if (i == 1) {
            return a.DeviceList;
        }
        if (i == 2) {
            return a.Dashboard;
        }
        if (i == 3) {
            return a.AdvancedSettings;
        }
        if (i != 4) {
            return a.DealerInformation;
        }
        return a.StatusAndHistory;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ boolean a(android.view.MenuItem r5) {
        /*
            r4 = this;
            androidx.drawerlayout.widget.DrawerLayout r0 = r4.B
            r0.b()
            int r0 = r5.getItemId()
            int r1 = b.a.a.Ba.nav_device_list
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x0017
            com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity$b r0 = com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.b.DeviceList
            r4.V = r0
            r4.Q()
            goto L_0x004b
        L_0x0017:
            int r1 = b.a.a.Ba.nav_dashboard
            if (r0 != r1) goto L_0x0020
            com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity$b r0 = com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.b.Dashboard
            r4.V = r0
            goto L_0x004b
        L_0x0020:
            int r1 = b.a.a.Ba.nav_advanced_settings
            if (r0 != r1) goto L_0x0029
            com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity$b r0 = com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.b.AdvancedSettings
            r4.V = r0
            goto L_0x004b
        L_0x0029:
            int r1 = b.a.a.Ba.nav_status_and_history
            if (r0 != r1) goto L_0x0032
            com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity$b r0 = com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.b.StatusAndHistory
            r4.V = r0
            goto L_0x004b
        L_0x0032:
            int r1 = b.a.a.Ba.nav_dealer_information
            if (r0 != r1) goto L_0x003b
            com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity$b r0 = com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.b.DealerInformation
            r4.V = r0
            goto L_0x004b
        L_0x003b:
            int r1 = b.a.a.Ba.nav_regen_now
            if (r0 != r1) goto L_0x0043
            r4.O()
            goto L_0x004c
        L_0x0043:
            int r1 = b.a.a.Ba.nav_regen_next
            if (r0 != r1) goto L_0x004b
            r4.N()
            goto L_0x004c
        L_0x004b:
            r2 = 1
        L_0x004c:
            if (r2 == 0) goto L_0x0054
            r5.setChecked(r3)
            r4.S()
        L_0x0054:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.a(android.view.MenuItem):boolean");
    }

    public /* synthetic */ void a(String[] strArr, DialogInterface dialogInterface) {
        requestPermissions(strArr, 2);
    }

    private boolean a(Context context, String... strArr) {
        if (context == null || strArr == null) {
            return true;
        }
        for (String a2 : strArr) {
            if (a.g.a.a.a(context, a2) != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            switch(r0) {
                case -2130863331: goto L_0x0035;
                case -1944102414: goto L_0x002b;
                case -573999512: goto L_0x0021;
                case 1593830764: goto L_0x0017;
                case 1950442807: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x003f
        L_0x000d:
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.nav_fragment.compliance"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 4
            goto L_0x0040
        L_0x0017:
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_now"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 2
            goto L_0x0040
        L_0x0021:
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.connection_timeout"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 1
            goto L_0x0040
        L_0x002b:
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.request_pair"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 0
            goto L_0x0040
        L_0x0035:
            java.lang.String r0 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_next"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 3
            goto L_0x0040
        L_0x003f:
            r0 = -1
        L_0x0040:
            if (r0 == 0) goto L_0x0080
            if (r0 == r5) goto L_0x0080
            if (r0 == r3) goto L_0x0078
            if (r0 == r2) goto L_0x0070
            if (r0 == r1) goto L_0x0068
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_positive"
            r0.<init>(r1)
            java.lang.String r1 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_id"
            r0.putExtra(r1, r7)
            java.lang.String r7 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_value"
            r0.putExtra(r7, r8)
            java.lang.String r7 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_extra"
            r0.putExtra(r7, r9)
            a.l.a.b r7 = a.l.a.b.a((android.content.Context) r6)
            r7.a((android.content.Intent) r0)
            goto L_0x0083
        L_0x0068:
            androidx.fragment.app.o r7 = r6.I
            if (r7 == 0) goto L_0x0083
            b.a.a.W.a(r7)
            goto L_0x0083
        L_0x0070:
            r6.da = r5
            r6.fa = r4
            r6.Z()
            goto L_0x0083
        L_0x0078:
            r6.ea = r5
            r6.fa = r4
            r6.Z()
            goto L_0x0083
        L_0x0080:
            r6.Q()
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void a(String str) {
        if (str.equals("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_now") || str.equals("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.regen_next")) {
            this.fa = false;
            return;
        }
        Intent intent = new Intent("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_negative");
        intent.putExtra("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_id", str);
        a.l.a.b.a((Context) this).a(intent);
    }

    public void a(ha haVar) {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        boolean z2 = false;
        boolean z3 = true;
        if (haVar == ha.DeviceList) {
            Q();
            z3 = false;
        } else {
            if (haVar == ha.Dashboard && this.V != (bVar4 = b.Dashboard)) {
                this.V = bVar4;
            } else if (haVar == ha.AdvancedSettings && this.V != (bVar3 = b.AdvancedSettings)) {
                this.V = bVar3;
            } else if (haVar == ha.StatusAndHistory && this.V != (bVar2 = b.StatusAndHistory)) {
                this.V = bVar2;
            } else if (haVar == ha.DealerInformation && this.V != (bVar = b.DealerInformation)) {
                this.V = bVar;
            }
            z2 = true;
        }
        if (z2) {
            qa qaVar = (qa) this.I.a(z3 ? "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_full_fragment" : "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.nav_fragment");
            if (qaVar != null) {
                qaVar.a(haVar);
                S();
            }
        }
    }

    public void a(b.a.a.e.e eVar) {
        this.R = false;
        y = eVar;
        b bVar = this.V;
        if (bVar != null) {
            b(a(bVar));
        }
        this.W = null;
        this.V = b.Dashboard;
        S();
        Y();
    }

    public void a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            this.P = System.currentTimeMillis();
            b(bArr);
        }
    }

    public void a(long j) {
        n nVar = t;
        if (nVar != null) {
            nVar.b(j);
            return;
        }
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }

    public void a(oa oaVar) {
        v = oaVar;
    }

    public void a(boolean z2, boolean z3) {
        b(z2, z3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r13 = r13.c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r10, android.bluetooth.BluetoothDevice r11, int r12, no.nordicsemi.android.support.v18.scanner.A r13) {
        /*
            r9 = this;
            java.lang.String r2 = r11.getName()
            boolean r0 = b.a.a.ia.a((java.lang.String) r2)
            if (r0 != 0) goto L_0x0129
            int r0 = r2.length()
            r1 = 3
            if (r0 < r1) goto L_0x0129
            r7 = 0
            java.lang.String r0 = r2.substring(r7, r1)
            java.lang.String r1 = "CS_"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0129
        L_0x0020:
            java.lang.String r8 = r11.getAddress()
            java.lang.String r3 = r9.a((java.lang.String) r2, (java.lang.String) r8)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r13 == 0) goto L_0x0044
            no.nordicsemi.android.support.v18.scanner.y r13 = r13.c()
            if (r13 == 0) goto L_0x0044
            byte[] r1 = r13.a()
            if (r1 == 0) goto L_0x0044
            byte[] r13 = r13.a()
            java.util.List r13 = b.a.a.c.u.a(r13)
            goto L_0x0045
        L_0x0044:
            r13 = r0
        L_0x0045:
            r0 = 1120403456(0x42c80000, float:100.0)
            r1 = 1123942400(0x42fe0000, float:127.0)
            float r12 = (float) r12
            float r12 = r12 + r1
            float r12 = r12 * r0
            r0 = 1125318656(0x43130000, float:147.0)
            float r12 = r12 / r0
            int r12 = (int) r12
            java.util.Map<java.lang.String, b.a.a.c.o> r0 = r9.U
            boolean r0 = r0.containsKey(r8)
            if (r0 != 0) goto L_0x0064
            java.util.Map<java.lang.String, b.a.a.c.o> r0 = r9.U
            b.a.a.c.o r1 = new b.a.a.c.o
            r1.<init>()
            r0.put(r8, r1)
            goto L_0x0075
        L_0x0064:
            java.util.Map<java.lang.String, b.a.a.c.o> r0 = r9.U
            java.lang.Object r0 = r0.get(r8)
            b.a.a.c.o r0 = (b.a.a.c.o) r0
            if (r0 == 0) goto L_0x0075
            r0.a(r12)
            int r12 = r0.a()
        L_0x0075:
            r5 = r12
            b.a.a.oa r12 = new b.a.a.oa
            r0 = r12
            r1 = r11
            r4 = r8
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            java.util.List<b.a.a.oa> r11 = u
            if (r11 == 0) goto L_0x010b
            b.a.a.c.A r0 = r9.J
            if (r0 == 0) goto L_0x010b
            boolean r11 = r11.contains(r12)
            if (r11 == 0) goto L_0x0106
            b.a.a.c.A r11 = r9.J
            b.a.a.c.z r11 = r11.b()
            b.a.a.c.z r0 = b.a.a.c.z.LeScan
            if (r11 != r0) goto L_0x010b
            java.util.List<b.a.a.oa> r11 = u
            int r11 = r11.indexOf(r12)
            java.util.List<b.a.a.oa> r0 = u
            java.lang.Object r0 = r0.get(r11)
            b.a.a.oa r0 = (b.a.a.oa) r0
            java.util.List r1 = r0.g()
            if (r1 != 0) goto L_0x00b7
            java.util.List r12 = r12.g()
            if (r12 == 0) goto L_0x00b7
            java.util.List<b.a.a.oa> r12 = u
            r12.set(r11, r0)
            goto L_0x010b
        L_0x00b7:
            java.util.List r12 = r0.g()
            if (r12 == 0) goto L_0x010b
            java.util.List r12 = r0.g()
            java.util.Iterator r12 = r12.iterator()
            r1 = 0
        L_0x00c6:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x00e0
            java.lang.Object r2 = r12.next()
            b.a.a.c.t r2 = (b.a.a.c.t) r2
            b.a.a.c.v r3 = r2.c()
            b.a.a.c.v r4 = b.a.a.c.v.DataTypeManufacturerSpecificData
            if (r3 != r4) goto L_0x00c6
            int r2 = r2.a()
            int r1 = r1 + r2
            goto L_0x00c6
        L_0x00e0:
            java.util.Iterator r12 = r13.iterator()
        L_0x00e4:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x00fe
            java.lang.Object r13 = r12.next()
            b.a.a.c.t r13 = (b.a.a.c.t) r13
            b.a.a.c.v r2 = r13.c()
            b.a.a.c.v r3 = b.a.a.c.v.DataTypeManufacturerSpecificData
            if (r2 != r3) goto L_0x00e4
            int r13 = r13.a()
            int r7 = r7 + r13
            goto L_0x00e4
        L_0x00fe:
            if (r1 >= r7) goto L_0x010b
            java.util.List<b.a.a.oa> r12 = u
            r12.set(r11, r0)
            goto L_0x010b
        L_0x0106:
            java.util.List<b.a.a.oa> r11 = u
            r11.add(r12)
        L_0x010b:
            android.content.Context r11 = r9.H
            if (r11 == 0) goto L_0x0129
            android.content.Intent r11 = new android.content.Intent
            java.lang.String r12 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.broadcast_device_discovered"
            r11.<init>(r12)
            java.lang.String r12 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.broadcast_extra_valve_address"
            r11.putExtra(r12, r8)
            java.lang.String r12 = "com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.device_is_classic"
            r11.putExtra(r12, r10)
            android.content.Context r10 = r9.H
            a.l.a.b r10 = a.l.a.b.a((android.content.Context) r10)
            r10.a((android.content.Intent) r11)
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.a(boolean, android.bluetooth.BluetoothDevice, int, no.nordicsemi.android.support.v18.scanner.A):void");
    }

    public void a(D d) {
        x = false;
        if (d == D.Connected) {
            this.N = 0;
            this.P = System.currentTimeMillis();
            Y();
        } else if (d == D.Disconnected) {
            J();
        }
    }

    public void a(byte[] bArr, int i) {
        P();
        F f = this.K;
        if (f != null) {
            oa oaVar = v;
            f.a(new y(bArr, i, oaVar != null && oaVar.i()));
        }
    }

    public /* synthetic */ void a(BluetoothDevice bluetoothDevice, int i) {
        if (i == -1) {
            M();
        }
    }

    private String a(String str, String str2) {
        String str3 = BuildConfig.FLAVOR;
        if (str == null || str.length() == 0) {
            return str3;
        }
        List<String> list = this.L;
        if (list != null && list.contains(str2)) {
            str3 = " (Dev Device)";
        }
        String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -2048963251:
                if (lowerCase.equals("cs_time_soft")) {
                    c = 2;
                    break;
                }
                break;
            case -1533266731:
                if (lowerCase.equals("cs_ultrafilter")) {
                    c = 6;
                    break;
                }
                break;
            case -676735063:
                if (lowerCase.equals("cs_reactor_vs")) {
                    c = 5;
                    break;
                }
                break;
            case -452502125:
                if (lowerCase.equals("cs_bw_filter")) {
                    c = 3;
                    break;
                }
                break;
            case -210425746:
                if (lowerCase.equals("cs_meter_soft_db")) {
                    c = 1;
                    break;
                }
                break;
            case 762507855:
                if (lowerCase.equals("cs_meter_soft")) {
                    c = 0;
                    break;
                }
                break;
            case 1010809124:
                if (lowerCase.equals("cs_hydroxer")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return getResources().getString(Fa.dl_01_meter_soft).concat(str3);
            case 1:
                return getResources().getString(Fa.dl_01_meter_soft_db).concat(str3);
            case 2:
                return getResources().getString(Fa.dl_02_time_soft).concat(str3);
            case 3:
                return getResources().getString(Fa.dl_04_bw_filter).concat(str3);
            case 4:
                return getResources().getString(Fa.dl_06_hydroxr_filter).concat(str3);
            case 5:
                return getResources().getString(Fa.dl_07_reactr_filter).concat(str3);
            case 6:
                return getResources().getString(Fa.dl_08_ultra_filter).concat(str3);
            default:
                return getResources().getString(Fa.dl_11_aer_filter).concat(str3);
        }
    }
}
