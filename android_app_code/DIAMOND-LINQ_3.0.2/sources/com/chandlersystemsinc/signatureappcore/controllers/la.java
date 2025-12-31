package com.chandlersystemsinc.signatureappcore.controllers;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
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
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.C0132h;
import androidx.fragment.app.C0134j;
import androidx.fragment.app.C0139o;
import androidx.fragment.app.D;
import androidx.lifecycle.C;
import androidx.recyclerview.widget.C0160k;
import androidx.recyclerview.widget.C0161l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.a.a.Aa;
import b.a.a.Ba;
import b.a.a.C0176ca;
import b.a.a.Da;
import b.a.a.E;
import b.a.a.Fa;
import b.a.a.G;
import b.a.a.J;
import b.a.a.K;
import b.a.a.S;
import b.a.a.W;
import b.a.a.Y;
import b.a.a.Z;
import b.a.a.c.F;
import b.a.a.c.y;
import b.a.a.e.e;
import b.a.a.ia;
import b.a.a.ma;
import b.a.a.oa;
import b.a.a.za;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import no.nordicsemi.android.ble.b.f;
import no.nordicsemi.android.log.BuildConfig;

public final class la extends C0132h implements SwipeRefreshLayout.b {
    /* access modifiers changed from: private */
    public static Handler V;
    /* access modifiers changed from: private */
    public static Runnable W;
    private static Handler X;
    private static Runnable Y;
    private static Handler Z;
    private static Runnable aa;
    private static Handler ba;
    private static Runnable ca;
    private String Aa;
    /* access modifiers changed from: private */
    public boolean Ba = false;
    /* access modifiers changed from: private */
    public boolean Ca;
    private boolean Da;
    private boolean Ea;
    /* access modifiers changed from: private */
    public boolean Fa = false;
    /* access modifiers changed from: private */
    public boolean Ga = false;
    /* access modifiers changed from: private */
    public boolean Ha = false;
    /* access modifiers changed from: private */
    public boolean Ia = false;
    private boolean Ja = false;
    /* access modifiers changed from: private */
    public boolean Ka = false;
    /* access modifiers changed from: private */
    public boolean La = false;
    private boolean Ma = false;
    private boolean Na;
    private int Oa;
    private int Pa;
    /* access modifiers changed from: private */
    public int Qa = 0;
    private int Ra;
    private int Sa;
    private int Ta;
    /* access modifiers changed from: private */
    public boolean Ua = true;
    private boolean Va;
    /* access modifiers changed from: private */
    public boolean Wa;
    private boolean Xa;
    private f Ya;
    private final byte[][] Za = ((byte[][]) Array.newInstance(byte.class, new int[]{128, 256}));
    private final byte[][] _a = ((byte[][]) Array.newInstance(byte.class, new int[]{128, 256}));
    private final byte[] ab = new byte[32768];
    private int bb = 0;
    private int cb = 0;
    /* access modifiers changed from: private */
    public RecyclerView da;
    private int db = 0;
    /* access modifiers changed from: private */
    public Context ea;
    private byte eb = 0;
    /* access modifiers changed from: private */
    public C0139o fa;
    private byte fb = 0;
    /* access modifiers changed from: private */
    public b.a.a.d.f ga;
    private byte gb = 0;
    /* access modifiers changed from: private */
    public C0176ca ha;
    /* access modifiers changed from: private */
    public boolean hb = false;
    private Handler ia;
    private boolean ib = false;
    private Runnable ja;
    private boolean jb = false;
    private S ka;
    private boolean kb = false;
    /* access modifiers changed from: private */
    public boolean la = true;
    private final byte[] lb = new byte[128];
    /* access modifiers changed from: private */
    public boolean ma = false;
    private final byte[] mb = new byte[128];
    /* access modifiers changed from: private */
    public final List<oa> na = new ArrayList();
    private final byte[] nb = new byte[128];
    /* access modifiers changed from: private */
    public oa oa;
    private final byte[] ob = new byte[128];
    /* access modifiers changed from: private */
    public a pa;
    /* access modifiers changed from: private */
    public int pb;
    private final List<K> qa = new ArrayList();
    /* access modifiers changed from: private */
    public boolean qb = false;
    /* access modifiers changed from: private */
    public int ra;
    /* access modifiers changed from: private */
    public boolean rb = false;
    private int sa;
    /* access modifiers changed from: private */
    public boolean sb = false;
    /* access modifiers changed from: private */
    public HashMap<String, String> ta = new HashMap<>();
    private boolean tb = false;
    private Z ua;
    /* access modifiers changed from: private */
    public boolean ub = false;
    /* access modifiers changed from: private */
    public int va;
    private boolean vb = false;
    /* access modifiers changed from: private */
    public int wa = 0;
    /* access modifiers changed from: private */
    public b.a.a.la wb = b.a.a.la.Idle;
    private byte xa;
    private final BroadcastReceiver xb = new ha(this);
    private byte ya;
    private final BroadcastReceiver yb = new ia(this);
    private String za;
    private final BroadcastReceiver zb = new ja(this);

    public class a extends RecyclerView.a<C0034a> {
        private final b c;
        private final c d;
        private final List<oa> e;

        /* renamed from: com.chandlersystemsinc.signatureappcore.controllers.la$a$a  reason: collision with other inner class name */
        class C0034a extends RecyclerView.x implements View.OnClickListener {
            final b t;
            final c u;
            final TextView v;
            final TextView w;
            final ImageView x;
            final ImageView y;

            C0034a(View view, b bVar, c cVar) {
                super(view);
                view.setOnClickListener(this);
                this.t = bVar;
                this.u = cVar;
                this.v = (TextView) view.findViewById(Ba.device_name);
                this.w = (TextView) view.findViewById(Ba.device_alias);
                this.x = (ImageView) view.findViewById(Ba.rssi);
                this.y = (ImageView) view.findViewById(Ba.options_menu);
                this.y.setFocusable(false);
                this.y.setOnClickListener(new C0216o(this));
                la.this.a((View) this.y);
            }

            public /* synthetic */ void a(View view) {
                c cVar;
                if (la.this.da.isEnabled() && la.this.pa != null) {
                    int unused = la.this.ra = f();
                    oa e = la.this.pa.e(la.this.ra);
                    if (e != null) {
                        oa unused2 = la.this.oa = e;
                        boolean unused3 = la.this.ma = e.i();
                        if (e.i()) {
                            String string = la.this.w().getString(Fa.dld_pair_title);
                            String string2 = la.this.w().getString(Fa.dld_pair_message);
                            Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
                            if (bondedDevices.size() > 0) {
                                boolean z2 = false;
                                for (BluetoothDevice equals : bondedDevices) {
                                    if (e.c().equals(equals)) {
                                        c cVar2 = this.u;
                                        if (cVar2 != null) {
                                            cVar2.a(e, view, f());
                                        }
                                        z2 = true;
                                    }
                                }
                                if (!z2 && !la.this.qb) {
                                    la.this.za();
                                    if (la.this.fa != null) {
                                        W.a(la.this.fa, "com.chandlersystemsinc.signatureappcore.controllers.pair_request", string, string2, (String) null, (String) null, 255, (String) null);
                                    }
                                    boolean unused4 = la.this.qb = true;
                                }
                            } else if (!la.this.qb) {
                                la.this.za();
                                if (la.this.fa != null) {
                                    W.a(la.this.fa, "com.chandlersystemsinc.signatureappcore.controllers.pair_request", string, string2, (String) null, (String) null, 255, (String) null);
                                }
                                boolean unused5 = la.this.qb = true;
                            }
                        } else if (e.j() && (cVar = this.u) != null) {
                            cVar.a(e, view, f());
                        }
                    }
                }
            }

            public void onClick(View view) {
                b bVar;
                if (la.this.pa != null) {
                    oa e = la.this.pa.e(f());
                    int unused = la.this.ra = f();
                    if (e != null && (bVar = this.t) != null) {
                        bVar.a(e, view, f());
                    }
                }
            }
        }

        a(List<oa> list, b bVar, c cVar) {
            this.e = list;
            this.c = bVar;
            this.d = cVar;
        }

        private int f(int i) {
            if (i >= 45) {
                return Aa.ic_rssi_5;
            }
            if (i >= 35) {
                return Aa.ic_rssi_4;
            }
            if (i >= 25) {
                return Aa.ic_rssi_3;
            }
            if (i >= 15) {
                return Aa.ic_rssi_2;
            }
            if (i >= 5) {
                return Aa.ic_rssi_1;
            }
            return Aa.ic_rssi_0;
        }

        /* access modifiers changed from: package-private */
        public oa e(int i) {
            return this.e.get(i);
        }

        /* renamed from: a */
        public void b(C0034a aVar, int i) {
            oa oaVar = this.e.get(i);
            aVar.v.setText(oaVar.d());
            aVar.v.setTextColor(la.this.w().getColor(oaVar.e()));
            aVar.w.setText(oaVar.b());
            aVar.x.setImageResource(f(oaVar.f()));
        }

        public C0034a b(ViewGroup viewGroup, int i) {
            return new C0034a(LayoutInflater.from(viewGroup.getContext()).inflate(Da.device_list_row, viewGroup, false), this.c, this.d);
        }

        public int a() {
            return this.e.size();
        }

        /* access modifiers changed from: private */
        public void a(int i, String str) {
            this.e.get(i).a(str);
        }
    }

    private interface b {
        void a(oa oaVar, View view, int i);
    }

    private interface c {
        void a(oa oaVar, View view, int i);
    }

    /* access modifiers changed from: private */
    public void Aa() {
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.h();
            this.ga.a((oa) null);
        }
        za();
        b.a.a.d.f fVar2 = this.ga;
        if (fVar2 != null) {
            fVar2.k();
        }
    }

    static /* synthetic */ int B(la laVar) {
        int i = laVar.Ra;
        laVar.Ra = i + 1;
        return i;
    }

    private void Ba() {
        if (this.ea != null && this.oa != null) {
            this.qa.clear();
            this.qa.add(new K(this.ea, a(Fa.dld_menu_change_pwd), Aa.ic_dl_password));
            this.qa.add(new K(this.ea, a(Fa.dld_menu_label_device), Aa.ic_dl_edit));
            if (!this.ma) {
                this.qa.add(new K(this.ea, a(Fa.dld_menu_check_firmware), Aa.ic_dl_check));
                Z z = this.ua;
                if (z != null) {
                    if (z.e()) {
                        if (this.ua.d()) {
                            this.qa.add(new K(this.ea, a(Fa.dld_menu_firmware_download), Aa.ic_dl_download));
                            if (this.oa.h().a()) {
                                this.qa.add(new K(this.ea, a(Fa.dld_menu_firmware_upload_4x), Aa.ic_dl_upload));
                                return;
                            }
                            this.qa.add(new K(this.ea, a(Fa.dld_menu_firmware_upload_2x), Aa.ic_dl_upload));
                            this.qa.add(new K(this.ea, a(Fa.dld_menu_firmware_upload_3x), Aa.ic_dl_upload));
                            return;
                        }
                        this.qa.add(new K(this.ea, a(Fa.dld_menu_firmware_download), Aa.ic_dl_download));
                        this.qa.add(new K(this.ea, a(Fa.dld_menu_firmware_upload), Aa.ic_dl_upload));
                    } else if (!this.ua.d()) {
                    } else {
                        if (this.oa.h().a()) {
                            this.qa.add(new K(this.ea, a(Fa.dld_menu_firmware_upload_4x), Aa.ic_dl_upload));
                            return;
                        }
                        this.qa.add(new K(this.ea, a(Fa.dld_menu_firmware_upload_2x), Aa.ic_dl_upload));
                        this.qa.add(new K(this.ea, a(Fa.dld_menu_firmware_upload_3x), Aa.ic_dl_upload));
                    }
                }
            }
        }
    }

    private void Ca() {
        String str;
        Z z = this.ua;
        if (z != null && this.fa != null) {
            this.va = z.a(this.wa, false);
            this.za = Z.a(this.wa);
            this.Aa = this.ua.b(this.wa);
            if (!this.Ha) {
                this.Ha = true;
                b.a.a.d.f fVar = this.ga;
                if (fVar != null) {
                    fVar.e();
                    this.ga.m();
                }
                C0134j f = f();
                if (f != null) {
                    f.getWindow().addFlags(128);
                }
                if (this.ua.d()) {
                    if (!this.ua.f()) {
                        int i = this.wa;
                        if (i >= 300 && i < 400) {
                            str = a(Fa.fw_warning_2x);
                            W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_upload_crossover", a(Fa.fw_transfer_app_to_valve_title), a(Fa.fw_valve_version).concat(this.za).concat("\n").concat(a(Fa.fw_selected_version)).concat(this.Aa).concat("\n\n").concat(str).concat(a(Fa.bt_warning_10_feet)), a(Fa.fw_upload), a(Fa.cancel), (String) null);
                            return;
                        }
                    } else if (this.wa < 300) {
                        str = a(Fa.fw_warning_3x);
                        W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_upload_crossover", a(Fa.fw_transfer_app_to_valve_title), a(Fa.fw_valve_version).concat(this.za).concat("\n").concat(a(Fa.fw_selected_version)).concat(this.Aa).concat("\n\n").concat(str).concat(a(Fa.bt_warning_10_feet)), a(Fa.fw_upload), a(Fa.cancel), (String) null);
                        return;
                    }
                    str = BuildConfig.FLAVOR;
                    W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_upload_crossover", a(Fa.fw_transfer_app_to_valve_title), a(Fa.fw_valve_version).concat(this.za).concat("\n").concat(a(Fa.fw_selected_version)).concat(this.Aa).concat("\n\n").concat(str).concat(a(Fa.bt_warning_10_feet)), a(Fa.fw_upload), a(Fa.cancel), (String) null);
                    return;
                }
                W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_upload", a(Fa.fw_transfer_app_to_valve_title), a(Fa.fw_valve_version).concat(this.za).concat("\n").concat(a(Fa.fw_selected_version)).concat(this.Aa).concat("\n\n").concat(a(Fa.bt_warning_10_feet)), a(Fa.fw_upload), a(Fa.cancel), (String) null);
            }
        }
    }

    private void Da() {
        this.eb = (byte) (this.eb + 1);
        this.Ta = 0;
        this.Sa = 0;
        this.Na = true;
        this.Oa = 0;
        this.Ra = 0;
        try {
            if (this.ka != null) {
                this.ka.e(32768);
                this.ka.f((this.eb + 1) * 256);
                this.ka.ka();
                this.ka.na();
            }
        } catch (Exception unused) {
            m(true);
        }
        Ha();
    }

    private void Ea() {
        m(false);
        xa();
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.e();
            this.ga.n();
            this.ga.b(false);
        }
        C0139o oVar = this.fa;
        if (oVar != null) {
            W.a(oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.reset", a(Fa.fw_transfer_app_to_valve_title), a(Fa.fw_upload_completed), (String) null);
        }
    }

    /* access modifiers changed from: private */
    public void Fa() {
        i(false);
        if (this.fa != null) {
            String a2 = a(Fa.fw_version, this.za);
            if (this.wa > this.va) {
                a2 = a(Fa.fw_version_greater, this.za, this.Aa);
            }
            W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_confirm_upload", a(Fa.fw_transfer_app_to_valve_title), a2, a(Fa.fw_proceed_anyway), a(Fa.cancel), (String) null);
        }
    }

    private void Ga() {
        za();
        V = new Handler();
        Handler handler = V;
        ka kaVar = new ka(this);
        W = kaVar;
        handler.post(kaVar);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r2 >= 100) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Ha() {
        /*
            r9 = this;
            boolean r0 = r9.Xa
            r1 = 0
            if (r0 != 0) goto L_0x001a
            b.a.a.J r0 = b.a.a.J.DeviceList
            byte[] r0 = b.a.a.G.b(r0)
            if (r0 == 0) goto L_0x0014
            b.a.a.d.f r2 = r9.ga
            if (r2 == 0) goto L_0x0014
            r2.a((byte[]) r0)
        L_0x0014:
            r2 = 125(0x7d, double:6.2E-322)
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0082 }
            goto L_0x0082
        L_0x001a:
            b.a.a.J r0 = b.a.a.J.DeviceList
            byte r2 = r9.eb
            byte[][] r3 = r9._a
            r3 = r3[r2]
            byte[] r4 = r9.lb
            byte r4 = r4[r2]
            byte[] r0 = b.a.a.G.a(r0, r2, r3, r4)
            if (r0 == 0) goto L_0x0082
            b.a.a.d.f r2 = r9.ga
            if (r2 == 0) goto L_0x0082
            boolean r2 = r9.Ua
            if (r2 == 0) goto L_0x0050
            r2 = 140(0x8c, float:1.96E-43)
            byte[] r3 = new byte[r2]
            boolean r4 = r9.Va
            if (r4 != 0) goto L_0x0045
            java.lang.System.arraycopy(r0, r1, r3, r1, r2)
            b.a.a.d.f r0 = r9.ga
            r0.a((byte[]) r3)
            goto L_0x0082
        L_0x0045:
            java.lang.System.arraycopy(r0, r2, r3, r1, r2)
            b.a.a.d.f r0 = r9.ga
            r0.a((byte[]) r3)
            r9.Va = r1
            goto L_0x0082
        L_0x0050:
            boolean r2 = r9.Na
            if (r2 != 0) goto L_0x005e
            int r2 = r9.Oa
            int r3 = r2 + 1
            r9.Oa = r3
            r3 = 100
            if (r2 < r3) goto L_0x0082
        L_0x005e:
            int r2 = r0.length
            r3 = 20
            int r2 = r2 / r3
            byte[] r4 = new byte[r3]
            r5 = 0
        L_0x0065:
            if (r5 >= r2) goto L_0x007e
            int r6 = r5 * 20
            java.lang.System.arraycopy(r0, r6, r4, r1, r3)
            b.a.a.d.f r6 = r9.ga
            r6.a((byte[]) r4)
            b.a.a.d.f r6 = r9.ga
            int r7 = r9.Qa
            int r7 = r7 + 4
            long r7 = (long) r7
            r6.a((long) r7)
            int r5 = r5 + 1
            goto L_0x0065
        L_0x007e:
            r9.Na = r1
            r9.Oa = r1
        L_0x0082:
            r9.Pa = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.la.Ha():void");
    }

    /* access modifiers changed from: private */
    public void Ia() {
        Z z = this.ua;
        if (z != null) {
            byte[] bArr = new byte[32768];
            try {
                InputStream d = z.d(this.wa);
                int read = d.read(bArr);
                d.close();
                if (!(read == 32768 || this.fa == null)) {
                    W.a(this.fa, a(Fa.fw_invalid_firmware_file_title), a(Fa.fw_invalid_firmware_file_message));
                    return;
                }
            } catch (IOException unused) {
            }
            for (int i = 0; i < 128; i++) {
                System.arraycopy(bArr, i * 256, this._a[i], 0, 256);
                this.lb[i] = E.a(this._a[i]);
            }
            l(true);
            this.Xa = this.wa < 400;
            this.Ua = this.wa >= 400;
            this.Ea = true;
            this.Pa = 0;
            this.cb = 0;
            this.Ra = 0;
            this.Na = true;
            this.Oa = 0;
            this.Ta = 0;
            this.eb = 0;
            b.a.a.d.f fVar = this.ga;
            if (fVar != null) {
                fVar.b(this.Ua);
            }
            Ga();
        }
    }

    /* access modifiers changed from: private */
    public boolean Ja() {
        String str;
        int i = this.cb;
        this.cb = i + 1;
        if (i > (this.Ua ? 150 : 600) && this.Ea) {
            S s = this.ka;
            if (s != null) {
                s.ha();
            }
            this.Ea = false;
            this.hb = true;
            b.a.a.d.f fVar = this.ga;
            if (fVar != null) {
                fVar.e();
                this.ga.b(false);
            }
            if (this.fa != null) {
                String a2 = a(Fa.fw_transfer_app_to_valve_title);
                if (this.eb >= Byte.MAX_VALUE) {
                    str = a(Fa.fw_upload_completed);
                } else {
                    str = a(Fa.bt_warning_upload);
                }
                W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_timeout", a2, str, (String) null);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void Ka() {
        za();
        this.ia = new Handler();
        Handler handler = this.ia;
        C0221u uVar = new C0221u(this);
        this.ja = uVar;
        handler.post(uVar);
    }

    public static la ma() {
        return new la();
    }

    /* access modifiers changed from: private */
    public void na() {
        if (this.tb && this.rb && this.fa != null && this.oa != null) {
            String a2 = ma.a();
            W.b(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_new_password", a(Fa.dld_enter_new_pwd_title), a(Fa.dld_enter_new_pwd_message), a2, a2, 4, 0, 9999, this.oa.a());
            this.rb = false;
        }
    }

    private void oa() {
        Handler handler = ba;
        if (handler != null) {
            handler.removeCallbacks(ca);
        }
        this.sa = 30;
        ba = new Handler();
        Handler handler2 = ba;
        C0223w wVar = new C0223w(this);
        ca = wVar;
        handler2.post(wVar);
    }

    private void pa() {
        i(true);
        if (this.wa != 0 && !this.Ia) {
            Ka();
            if (this.wa < this.va) {
                this.Ia = true;
                b.a.a.d.f fVar = this.ga;
                if (fVar != null) {
                    fVar.e();
                    this.ga.m();
                }
                if (this.fa != null) {
                    W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_upload_new_version", a(Fa.dl_upload_fw_title), a(Fa.fw_upload_message, this.za, this.Aa), a(Fa.fw_upload), a(Fa.dl_continue_no_upload), (String) null);
                    return;
                }
                return;
            }
            this.Ca = false;
            b.a.a.d.f fVar2 = this.ga;
            if (!(fVar2 == null || this.oa == null)) {
                fVar2.b(a(Fa.bt_status_connecting));
                this.ga.l();
            }
            Ka();
        }
    }

    private void qa() {
        if (this.wa != 0) {
            i(true);
            if (!this.Ha) {
                this.Ha = true;
                b.a.a.d.f fVar = this.ga;
                if (fVar != null) {
                    fVar.m();
                }
                if (this.fa != null) {
                    W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_download", a(Fa.fw_transfer_valve_to_app_title), a(Fa.fw_valve_version).concat(this.za).concat("\n").concat(a(Fa.fw_app_version)).concat(this.Aa), a(Fa.fw_download), a(Fa.cancel), (String) null);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void ra() {
        i(true);
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.m();
        }
        if (this.fa != null) {
            String a2 = a(Fa.fw_version, this.za);
            if (this.wa < this.va) {
                a2 = a(Fa.fw_version_lesser, this.za, this.Aa);
            }
            W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_confirm_download", a(Fa.fw_transfer_valve_to_app_title), a2, a(Fa.fw_proceed_anyway), a(Fa.cancel), (String) null);
        }
    }

    private void sa() {
        za();
        X = new Handler();
        Handler handler = X;
        C0215n nVar = new C0215n(this);
        Y = nVar;
        handler.post(nVar);
    }

    /* access modifiers changed from: private */
    public void ta() {
        this.Da = true;
        this.db = 4000;
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.m();
        }
        sa();
    }

    private void ua() {
        this.Ka = true;
        this.Na = false;
        h(false);
    }

    static /* synthetic */ int v(la laVar) {
        int i = laVar.Pa + 1;
        laVar.Pa = i;
        return i;
    }

    private void va() {
        byte b2 = this.gb;
        if (b2 == Byte.MAX_VALUE) {
            byte[][] bArr = this.Za;
            bArr[b2][254] = this.ya;
            bArr[b2][255] = this.xa;
        }
        if (this.gb == 0 && !this.jb) {
            this.jb = true;
            b.a.a.d.f fVar = this.ga;
            if (fVar != null) {
                fVar.e();
            }
        }
        S s = this.ka;
        if (s != null) {
            s.e(32768);
            this.ka.f((this.gb + 1) * 256);
            this.ka.ka();
            this.ka.na();
        }
        S s2 = this.ka;
        if (s2 != null && s2.la()) {
            for (int i = 0; i < 128; i++) {
                System.arraycopy(this.Za[i], 0, this.ab, i * 256, 256);
            }
            boolean a2 = a(this.ab);
            if (Z.f(this.wa)) {
                ma.c(this.ea, this.wa);
            } else if (Z.e(this.wa)) {
                ma.b(this.ea, this.wa);
            } else {
                ma.a(this.ea, this.wa);
            }
            k(false);
            xa();
            String a3 = a(Fa.fw_download_completed);
            if (!a2) {
                a3 = a(Fa.fw_download_failed);
            }
            C0139o oVar = this.fa;
            if (oVar != null) {
                W.a(oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.reset", a(Fa.fw_transfer_valve_to_app_title), a3, (String) null);
            }
        }
        byte b3 = this.gb;
        if (b3 < 0 || b3 >= Byte.MAX_VALUE) {
            this.hb = true;
            return;
        }
        this.fb = (byte) (b3 + 1);
        this.db = 4000;
        this.Na = true;
    }

    private void wa() {
        oa oaVar;
        this.ga.e();
        if (this.ma && (oaVar = this.oa) != null) {
            try {
                oaVar.c().getClass().getMethod("removeBond", (Class[]) null).invoke(this.oa.c(), (Object[]) null);
            } catch (Exception unused) {
            }
            za();
            this.ga.h();
            Aa();
        }
        W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_new_password", a(Fa.dl_fw_new_password_title), a(Fa.dl_fw_new_password_message), a(Fa.ok), a(Fa.cancel), (String) null);
    }

    private void xa() {
        try {
            if (this.ka != null) {
                this.ka.ma();
                this.ka.ha();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void ya() {
        if (this.fa != null) {
            String a2 = ma.a();
            W.b(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_new_pair_password", a(Fa.bt_change_pair_password_title), a(Fa.bt_change_pair_password_message), a2, a2, 4, 0, 9999, (String) null);
        }
    }

    /* access modifiers changed from: private */
    public void za() {
        Handler handler = ba;
        if (handler != null) {
            handler.removeCallbacks(ca);
        }
        Handler handler2 = Z;
        if (handler2 != null) {
            handler2.removeCallbacks(aa);
        }
        Handler handler3 = V;
        if (handler3 != null) {
            handler3.removeCallbacks(W);
        }
        Handler handler4 = X;
        if (handler4 != null) {
            handler4.removeCallbacks(Y);
        }
        Handler handler5 = this.ia;
        if (handler5 != null) {
            handler5.removeCallbacks(this.ja);
        }
    }

    public void O() {
        super.O();
        za();
    }

    public void P() {
        super.P();
        this.la = false;
        Context context = this.ea;
        if (context != null) {
            a.l.a.b.a(context).a(this.xb);
            a.l.a.b.a(this.ea).a(this.yb);
            a.l.a.b.a(this.ea).a(this.zb);
        }
    }

    public void Q() {
        super.Q();
        this.la = true;
        Context context = this.ea;
        if (context != null) {
            a.l.a.b a2 = a.l.a.b.a(context);
            a2.a(this.xb, new IntentFilter("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.broadcast_device_discovered"));
            a2.a(this.yb, new IntentFilter("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_positive"));
            a2.a(this.zb, new IntentFilter("com.ChandlerSystemsInc.signatureAppCore.controllers.main_core_activity.dialog_data_negative"));
        }
    }

    public /* synthetic */ void ja() {
        if (CsMainCoreActivity.A()) {
            ya();
            return;
        }
        b.a.a.d.f fVar = this.ga;
        if (!(fVar == null || this.oa == null)) {
            fVar.b(a(Fa.bt_status_connecting));
            this.ga.l();
        }
        int i = this.sa;
        this.sa = i - 1;
        if (i > 0) {
            ba.postDelayed(ca, 1000);
            return;
        }
        Handler handler = ba;
        if (handler != null) {
            handler.removeCallbacks(ca);
        }
        Aa();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r0 >= 100) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void ka() {
        /*
            r6 = this;
            int r0 = r6.db
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0028
            boolean r0 = r6.Da
            if (r0 == 0) goto L_0x002b
            r6.xa()
            r6.Da = r3
            r6.hb = r2
            androidx.fragment.app.o r0 = r6.fa
            if (r0 == 0) goto L_0x002b
            int r2 = b.a.a.Fa.fw_transfer_valve_to_app_title
            java.lang.String r2 = r6.a((int) r2)
            int r4 = b.a.a.Fa.bt_warning_download
            java.lang.String r4 = r6.a((int) r4)
            java.lang.String r5 = "com.ChandlerSystemsInc.signatureAppCore.controllers.firmware_timeout"
            b.a.a.W.a(r0, r5, r2, r4, r1)
            goto L_0x002b
        L_0x0028:
            int r0 = r0 - r2
            r6.db = r0
        L_0x002b:
            boolean r0 = com.chandlersystemsinc.signatureappcore.controllers.CsMainCoreActivity.A()
            if (r0 == 0) goto L_0x0069
            b.a.a.d.f r0 = r6.ga
            if (r0 == 0) goto L_0x0038
            r0.e()
        L_0x0038:
            boolean r0 = r6.Na
            if (r0 != 0) goto L_0x0046
            int r0 = r6.Oa
            int r2 = r0 + 1
            r6.Oa = r2
            r2 = 100
            if (r0 < r2) goto L_0x005b
        L_0x0046:
            r6.Na = r3
            r6.Oa = r3
            r6.Ya = r1
            r6.bb = r3
            b.a.a.J r0 = b.a.a.J.DeviceList
            byte r1 = r6.fb
            byte[] r0 = b.a.a.G.a((b.a.a.J) r0, (byte) r1)
            b.a.a.d.f r1 = r6.ga
            r1.a((byte[]) r0)
        L_0x005b:
            boolean r0 = r6.hb
            if (r0 != 0) goto L_0x0088
            android.os.Handler r0 = X
            java.lang.Runnable r1 = Y
            r2 = 5
            r0.postDelayed(r1, r2)
            goto L_0x0088
        L_0x0069:
            b.a.a.d.f r0 = r6.ga
            if (r0 == 0) goto L_0x007f
            b.a.a.oa r1 = r6.oa
            if (r1 == 0) goto L_0x007f
            int r1 = b.a.a.Fa.bt_status_connecting
            java.lang.String r1 = r6.a((int) r1)
            r0.b((java.lang.String) r1)
            b.a.a.d.f r0 = r6.ga
            r0.l()
        L_0x007f:
            android.os.Handler r0 = X
            java.lang.Runnable r1 = Y
            r2 = 500(0x1f4, double:2.47E-321)
            r0.postDelayed(r1, r2)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chandlersystemsinc.signatureappcore.controllers.la.ka():void");
    }

    public /* synthetic */ void la() {
        if (CsMainCoreActivity.A()) {
            if (this.la && !this.Ea && !this.Da) {
                if (this.wb == b.a.a.la.Pending) {
                    d(G.a(J.DeviceList, this.pb));
                    this.wb = b.a.a.la.Sent;
                } else {
                    d(G.a(J.DeviceList));
                }
            }
            this.ia.postDelayed(this.ja, 1000);
            na();
            return;
        }
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.o();
        }
        this.ia.postDelayed(this.ja, 1500);
    }

    private void h(boolean z) {
        this.Ca = true;
        this.Ma = !z;
    }

    private void i(boolean z) {
        Z z2 = this.ua;
        if (z2 != null) {
            this.va = z2.a(this.wa, z);
            this.za = Z.a(this.wa);
            this.Aa = Z.a(this.va);
        }
    }

    /* access modifiers changed from: private */
    public void j(boolean z) {
        if (this.fa != null) {
            Z = new Handler();
            Handler handler = Z;
            C0220t tVar = new C0220t(this, z);
            aa = tVar;
            handler.postDelayed(tVar, 200000);
        }
    }

    private void k(boolean z) {
        this.hb = true;
        this.Da = false;
        this.Ca = false;
        this.kb = true;
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.e();
            this.ga.n();
            if (z) {
                this.ga.k();
            }
        }
    }

    private void l(boolean z) {
        if (this.fa != null) {
            String a2 = a(z ? Fa.fw_transfer_app_to_valve_title : Fa.fw_transfer_valve_to_app_title);
            String a3 = a(z ? Fa.fw_upload_in_progress : Fa.fw_download_in_progress);
            this.ka = (S) this.fa.a("com.ChandlerSystemsInc.signatureAppCore.controllers.progress_dialog");
            try {
                if (this.ka == null) {
                    this.ka = new S();
                    this.ka.a(a2, a3);
                    this.ka.e(32768);
                    D a4 = this.fa.a();
                    a4.a((C0132h) this.ka, "com.ChandlerSystemsInc.signatureAppCore.controllers.progress_dialog");
                    a4.a();
                }
            } catch (Exception unused) {
                k(true);
            }
        }
    }

    private void m(boolean z) {
        this.hb = true;
        this.Ea = false;
        this.Ca = false;
        this.ib = true;
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.e();
            this.ga.n();
            if (z) {
                this.ga.k();
            }
        }
    }

    public void d() {
        Aa();
    }

    public /* synthetic */ void g(boolean z) {
        int i;
        C0139o oVar = this.fa;
        String str = z ? "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_password_timeout_classic" : "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_password_timeout";
        if (z) {
            i = Fa.bt_change_pair_password_title;
        } else {
            i = Fa.dld_enter_pwd_title;
        }
        W.a(oVar, str, a(i), a(Fa.dld_enter_pwd_failed), (String) null);
    }

    private void d(byte[] bArr) {
        b.a.a.d.f fVar = this.ga;
        if (fVar != null && bArr != null) {
            fVar.a(bArr);
        }
    }

    public /* synthetic */ void b(oa oaVar, View view, int i) {
        C0134j f = f();
        if (f != null) {
            c((Activity) f);
        }
    }

    public void c(Bundle bundle) {
        super.c(bundle);
        this.ea = m();
        this.fa = r();
        this.ha = ma.c(this.ea);
        this.ta = ma.a(this.ea);
        Context context = this.ea;
        if (context != null) {
            this.ua = new Z(context);
        }
        Z z = this.ua;
        if (z != null) {
            ma.a(this.ea, z.a());
            ma.b(this.ea, this.ua.b());
            ma.c(this.ea, this.ua.c());
        }
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.h();
        }
        if (f() != null) {
            ((F) C.a(f()).a(F.class)).c().a(this, new C0222v(this));
        }
    }

    private void b(Activity activity) {
        try {
            this.ga = (b.a.a.d.f) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString().concat(" must implement CsFragmentEvents"));
        }
    }

    private void d(String str) {
        String string = w().getString(Fa.dld_label_device_title);
        String string2 = w().getString(Fa.dld_label_device_message);
        String str2 = this.ta.containsKey(str) ? this.ta.get(str) : BuildConfig.FLAVOR;
        C0139o oVar = this.fa;
        if (oVar != null) {
            W.a(oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.label_device", string, string2, (String) null, str2, 255, str);
        }
    }

    public /* synthetic */ void a(y yVar) {
        if (this.oa == null) {
            return;
        }
        if (!this.ma && this.Da) {
            if (this.Ya == null) {
                this.Ya = new f();
            }
            f fVar = this.Ya;
            byte[] a2 = yVar.a();
            int i = this.bb;
            this.bb = i + 1;
            if (a(fVar, a2, i)) {
                b(this.Ya.a());
                this.Ya = null;
                this.bb = 0;
            }
        } else if (this.ma || !this.Ea) {
            a(yVar.a(), yVar.b(), this.ma);
        } else {
            c(yVar.a());
        }
    }

    private void b(byte[] bArr) {
        if (!this.kb && bArr.length == 280) {
            int i = 0;
            while (i < 18) {
                if (bArr[i] == 116) {
                    i++;
                } else {
                    return;
                }
            }
            l(false);
            this.gb = bArr[18];
            byte[] bArr2 = this.ob;
            byte b2 = this.gb;
            bArr2[b2] = bArr[19];
            if (b2 == this.fb) {
                System.arraycopy(bArr, 20, this.Za[b2], 0, 256);
                byte[] bArr3 = this.nb;
                byte b3 = this.gb;
                bArr3[b3] = E.a(this.Za[b3]);
                byte[] bArr4 = this.nb;
                byte b4 = this.gb;
                if (bArr4[b4] == this.ob[b4]) {
                    va();
                }
            }
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(Da.fragment_device_list, viewGroup, false);
        this.da = (RecyclerView) inflate.findViewById(Ba.device_list);
        this.da.setItemAnimator((RecyclerView.f) null);
        this.da.a((RecyclerView.h) new C0161l(inflate.getContext(), 1));
        this.da.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
        inflate.setOnTouchListener(new r(this));
        this.pa = new a(this.na, new C0218q(this), new C0219s(this));
        this.da.setAdapter(this.pa);
        ((SwipeRefreshLayout) inflate.findViewById(Ba.swipe_container)).setOnRefreshListener(this);
        return inflate;
    }

    private void c(Activity activity) {
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(Da.device_options_menu, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(activity);
        popupWindow.setContentView(inflate);
        double width = (double) this.da.getWidth();
        Double.isNaN(width);
        popupWindow.setWidth((int) (width * 0.75d));
        popupWindow.setHeight(-2);
        popupWindow.setFocusable(true);
        double height = (double) this.da.getHeight();
        Double.isNaN(height);
        int i = (int) (height * 0.75d);
        if (popupWindow.getHeight() > i) {
            popupWindow.setHeight(i);
        }
        Ba();
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(Ba.device_options);
        recyclerView.setItemAnimator(new C0160k());
        recyclerView.a((RecyclerView.h) new C0161l(inflate.getContext(), 1));
        recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
        recyclerView.setAdapter(new b.a.a.b.b(this.qa, new C0217p(this, popupWindow)));
        popupWindow.showAtLocation(inflate, 17, 0, 0);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) inflate.getRootView().getLayoutParams();
        layoutParams.flags |= 2;
        layoutParams.dimAmount = 0.6f;
        ((WindowManager) activity.getSystemService("window")).updateViewLayout(inflate.getRootView(), layoutParams);
    }

    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        Z z = this.ua;
        if (z == null) {
            return false;
        }
        if (z.a(motionEvent) || view.performClick()) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void a(oa oaVar, View view, int i) {
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.b(a(Fa.bt_status_connecting));
        }
        this.na.get(i).a(za.dlr_name_select_text_color);
        a aVar = this.pa;
        if (aVar != null) {
            aVar.c(i);
        }
        this.oa = oaVar;
        this.ma = oaVar.i();
        this.ga.a(this.oa);
        this.ga.l();
        this.Ca = true;
        this.Ba = true;
    }

    public void a(Context context) {
        super.a(context);
        b(context instanceof Activity ? (Activity) context : null);
    }

    /* access modifiers changed from: private */
    public String c(String str) {
        return this.ta.containsKey(str) ? this.ta.get(str) : BuildConfig.FLAVOR;
    }

    private void c(byte[] bArr) {
        if (!this.ib) {
            if (bArr.length == 16) {
                this.Na = true;
                this.Oa = 0;
                Ha();
            } else if (bArr.length == 4 && bArr[0] == 116 && bArr[1] == 116 && bArr[2] == this.eb && bArr[3] == 75) {
                this.Va = true;
                Ha();
            } else if (bArr.length == 20) {
                int i = 0;
                while (i < 18) {
                    if (bArr[i] == 116) {
                        i++;
                    } else {
                        return;
                    }
                }
                if ((bArr[18] & 255) == 255) {
                    if (bArr[19] != 74) {
                        int i2 = this.Ta;
                        this.Ta = i2 + 1;
                        if (i2 >= 2) {
                            this.Ua = false;
                        }
                    } else if (!this.Xa) {
                        this.Xa = true;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        int i3 = this.Ta;
                        this.Ta = i3 + 1;
                        if (i3 >= 1) {
                            this.Ua = false;
                        }
                    }
                    this.Na = true;
                    this.Oa = 0;
                    Ha();
                    return;
                }
                this.gb = bArr[18];
                byte[] bArr2 = this.mb;
                byte b2 = this.gb;
                bArr2[b2] = bArr[19];
                if (this.Ua && b2 == this.eb && this.lb[b2] != bArr2[b2]) {
                    int i4 = this.Sa;
                    this.Sa = i4 + 1;
                    if (i4 >= 3) {
                        this.Ua = false;
                    }
                }
                byte b3 = this.gb;
                if (b3 == this.eb && this.lb[b3] == this.mb[b3]) {
                    this.cb = 0;
                    if (b3 < Byte.MAX_VALUE) {
                        Da();
                    } else {
                        Ea();
                    }
                } else {
                    if (!this.Ua) {
                        int i5 = this.Qa;
                        if (i5 == 0) {
                            this.Qa = 6;
                        } else {
                            this.Qa = Math.min(25, i5 + 1);
                        }
                    }
                    this.Na = true;
                    this.Oa = 0;
                    Ha();
                }
            }
        }
    }

    public void a(Activity activity) {
        super.a(activity);
        if (Build.VERSION.SDK_INT < 23) {
            b(activity);
        }
    }

    public /* synthetic */ void a(PopupWindow popupWindow, View view, int i, String str) {
        if (!str.equals(a(Fa.dld_menu_label_device)) && !this.Ja) {
            this.ga.b(a(Fa.bt_status_connecting));
            this.ga.a(this.oa);
            this.ga.l();
            Ka();
            this.Ja = true;
        }
        if (str.equals(a(Fa.dld_menu_change_pwd))) {
            this.ga.b(a(Fa.bt_status_connecting));
            if (!this.ma) {
                this.Fa = true;
                this.rb = true;
            } else {
                this.ub = true;
                oa();
            }
        } else if (str.equals(a(Fa.dld_menu_check_firmware))) {
            h(true);
        } else if (str.equals(a(Fa.dld_menu_label_device))) {
            oa oaVar = this.oa;
            if (oaVar != null) {
                d(oaVar.a());
            }
        } else if (str.equals(a(Fa.dld_menu_firmware_download))) {
            ua();
        } else if (str.equals(a(Fa.dld_menu_firmware_upload)) || str.equals(a(Fa.dld_menu_firmware_upload_2x)) || str.equals(a(Fa.dld_menu_firmware_upload_3x))) {
            a(str.equals(a(Fa.dld_menu_firmware_upload_3x)), this.oa.h().a());
        }
        popupWindow.dismiss();
    }

    private void a(byte[] bArr, int i, boolean z) {
        boolean z2;
        oa oaVar;
        oa oaVar2;
        e eVar = new e(bArr, i, z);
        if (eVar.k()) {
            if (!z) {
                if (eVar.i()) {
                    this.wb = b.a.a.la.Pending;
                }
                int i2 = 1234;
                try {
                    i2 = Integer.valueOf(eVar.e()).intValue();
                    z2 = true;
                } catch (NumberFormatException unused) {
                    this.tb = true;
                    z2 = false;
                }
                if (this.wb == b.a.a.la.Sent) {
                    if (this.pb != i2) {
                        this.wb = b.a.a.la.Pending;
                    } else {
                        this.wb = b.a.a.la.Idle;
                    }
                }
                if (this.wb != b.a.a.la.Pending) {
                    this.pb = i2;
                    this.xa = eVar.b();
                    this.ya = eVar.c();
                    this.wa = eVar.a();
                    if (z2 && !this.sb && (oaVar2 = this.oa) != null) {
                        String a2 = ma.a(this.ea, oaVar2.a());
                        if (ia.a(a2) || !a2.equals(String.valueOf(i2))) {
                            this.tb = false;
                            this.sb = true;
                            Ka();
                            String a3 = ma.a();
                            C0139o oVar = this.fa;
                            if (oVar != null) {
                                W.b(oVar, "com.ChandlerSystemsInc.signatureAppCore.controllers.enter_password", a(Fa.dld_enter_pwd_title), a(Fa.dld_enter_new_message), a3, a3, 4, 0, 9999, this.oa.a().concat("✝").concat(eVar.e()));
                            }
                        } else {
                            this.tb = true;
                        }
                    }
                    if (this.tb) {
                        if (eVar.h() && !this.Ga) {
                            wa();
                        } else if (this.Ca) {
                            if (!this.Ka && !this.La && !this.Ba && !this.Ma) {
                                b.a.a.d.f fVar = this.ga;
                                if (fVar != null) {
                                    fVar.e();
                                }
                                this.Ca = false;
                                this.Ma = true;
                                if (!(this.fa == null || (oaVar = this.oa) == null)) {
                                    W.a(this.fa, "com.ChandlerSystemsInc.signatureAppCore.controllers.check_firmware", a(Fa.fw_version_number_title), a(Fa.fw_version_check, oaVar.d(), eVar.d()), (String) null);
                                }
                            } else if (this.Ka) {
                                qa();
                            } else if (this.La) {
                                if (eVar.j()) {
                                    Ca();
                                } else {
                                    this.La = false;
                                    C0139o oVar2 = this.fa;
                                    if (oVar2 != null) {
                                        W.a(oVar2, "com.ChandlerSystemsInc.signatureAppCore.controllers.reset", a(Fa.fw_transfer_app_to_valve_title), a(Fa.fw_upload_regen_notice), (String) null);
                                        return;
                                    }
                                    return;
                                }
                            } else if (eVar.j()) {
                                pa();
                            } else {
                                this.Ca = false;
                            }
                        }
                        b.a.a.d.f fVar2 = this.ga;
                        if (fVar2 != null && !this.Fa && !this.Ca && this.Ba) {
                            fVar2.a(eVar);
                        }
                    }
                }
            } else if (eVar.f() == 75) {
                if (eVar.h() && !this.Ga) {
                    Handler handler = Z;
                    if (handler != null) {
                        handler.removeCallbacks(aa);
                    }
                    if (!this.vb) {
                        this.vb = true;
                        wa();
                    }
                }
                if (!this.ub) {
                    za();
                    b.a.a.d.f fVar3 = this.ga;
                    if (fVar3 != null) {
                        fVar3.b(a(Fa.bt_status_connecting));
                        this.ga.a(eVar);
                    }
                }
            }
        }
    }

    private void a(boolean z, boolean z2) {
        b.a.a.d.f fVar = this.ga;
        if (fVar != null) {
            fVar.b(a(Fa.bt_status_connecting));
        }
        this.La = true;
        Z z3 = this.ua;
        if (z3 != null) {
            if (z2) {
                z3.b(true);
            } else {
                z3.a(z);
            }
        }
        h(false);
    }

    private boolean a(f fVar, byte[] bArr, int i) {
        fVar.a(bArr);
        return i == 13;
    }

    private boolean a(byte[] bArr) {
        Z z;
        if (this.ea == null || (z = this.ua) == null) {
            return false;
        }
        return Y.a(this.ea, z.c(this.wa), bArr);
    }
}
