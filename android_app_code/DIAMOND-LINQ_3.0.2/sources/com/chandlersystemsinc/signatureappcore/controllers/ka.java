package com.chandlersystemsinc.signatureappcore.controllers;

import b.a.a.Fa;

class ka implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ la f1393a;

    ka(la laVar) {
        this.f1393a = laVar;
    }

    public void run() {
        if (!this.f1393a.Ja()) {
            if (CsMainCoreActivity.A()) {
                if (la.v(this.f1393a) % (this.f1393a.wa < 400 ? 20 : 10) == 0) {
                    if (!this.f1393a.Ua) {
                        if (this.f1393a.Qa == 0) {
                            int unused = this.f1393a.Qa = 6;
                        } else {
                            la laVar = this.f1393a;
                            int unused2 = laVar.Qa = Math.min(25, laVar.Qa + 1);
                        }
                    }
                    this.f1393a.Ha();
                }
                if (!this.f1393a.hb) {
                    la.V.postDelayed(this, this.f1393a.Ua ? 100 : 25);
                }
                boolean unused3 = this.f1393a.Wa = false;
                return;
            }
            if (!this.f1393a.Wa) {
                if (la.B(this.f1393a) >= 2) {
                    boolean unused4 = this.f1393a.Ua = false;
                }
                if (this.f1393a.ga != null) {
                    this.f1393a.ga.b(this.f1393a.a(Fa.bt_status_connecting));
                    this.f1393a.ga.l();
                }
                boolean unused5 = this.f1393a.Wa = true;
            }
            la.V.postDelayed(la.W, 50);
        }
    }
}
