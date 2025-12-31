package no.nordicsemi.android.support.v18.scanner;

import no.nordicsemi.android.support.v18.scanner.d;

/* renamed from: no.nordicsemi.android.support.v18.scanner.a  reason: case insensitive filesystem */
class C0251a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.a f1639a;

    C0251a(d.a aVar) {
        this.f1639a = aVar;
    }

    public void run() {
        if (!this.f1639a.e) {
            this.f1639a.b();
            d.a aVar = this.f1639a;
            aVar.i.postDelayed(this, aVar.g.k());
        }
    }
}
