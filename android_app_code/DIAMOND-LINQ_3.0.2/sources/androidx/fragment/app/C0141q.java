package androidx.fragment.app;

import android.view.View;

/* renamed from: androidx.fragment.app.q  reason: case insensitive filesystem */
class C0141q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f815a;

    C0141q(r rVar) {
        this.f815a = rVar;
    }

    public void run() {
        if (this.f815a.f817b.i() != null) {
            this.f815a.f817b.b((View) null);
            r rVar = this.f815a;
            w wVar = rVar.c;
            C0132h hVar = rVar.f817b;
            wVar.a(hVar, hVar.B(), 0, 0, false);
        }
    }
}
