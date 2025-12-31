package no.nordicsemi.android.support.v18.scanner;

import no.nordicsemi.android.support.v18.scanner.d;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.a f1648a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ A f1649b;
    final /* synthetic */ h c;

    g(h hVar, d.a aVar, A a2) {
        this.c = hVar;
        this.f1648a = aVar;
        this.f1649b = a2;
    }

    public void run() {
        this.f1648a.a(1, this.f1649b);
    }
}
