package com.chandlersystemsinc.signatureappcore.controllers;

import b.a.a.Fa;
import b.a.a.W;
import b.a.a.d.i;
import b.a.a.pa;
import b.a.a.wa;

class Y implements i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Z f1372a;

    Y(Z z) {
        this.f1372a = z;
    }

    public void a(int i) {
        if (i != -1 && ((pa) this.f1372a.ga.get(i)).r() && this.f1372a.Y != null) {
            if (this.f1372a.la == wa.UltraFilter) {
                i = 2;
            }
            if (this.f1372a.aa.f()[i]) {
                W.a(this.f1372a.Y, this.f1372a.Ca[i], this.f1372a.a(Fa.ci_time_not_adjustable_message));
                return;
            }
            String valueOf = String.valueOf(this.f1372a.aa.g()[i]);
            W.b(this.f1372a.Y, Z.V[i], this.f1372a.Ca[i], this.f1372a.Da[i], valueOf.concat(this.f1372a.a(Fa.enter_range, 0, 99)), valueOf, 2, 0, 99, (String) null);
        }
    }

    public void a(String str) {
    }

    public void a(boolean z, String str) {
    }

    public void b(String str) {
    }
}
