package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.le.ScanResult;

class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScanResult f1652a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f1653b;
    final /* synthetic */ n c;

    k(n nVar, ScanResult scanResult, int i) {
        this.c = nVar;
        this.f1652a = scanResult;
        this.f1653b = i;
    }

    public void run() {
        this.c.f1659b.a(this.f1653b, ((o) d.a()).a(this.f1652a));
    }
}
