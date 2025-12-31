package androidx.appcompat.app;

import a.g.i.E;
import a.g.i.F;
import a.g.i.y;

class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f430a;

    v(x xVar) {
        this.f430a = xVar;
    }

    public void run() {
        x xVar = this.f430a;
        xVar.s.showAtLocation(xVar.r, 55, 0, 0);
        this.f430a.m();
        if (this.f430a.u()) {
            this.f430a.r.setAlpha(0.0f);
            x xVar2 = this.f430a;
            E a2 = y.a(xVar2.r);
            a2.a(1.0f);
            xVar2.u = a2;
            this.f430a.u.a((F) new u(this));
            return;
        }
        this.f430a.r.setAlpha(1.0f);
        this.f430a.r.setVisibility(0);
    }
}
