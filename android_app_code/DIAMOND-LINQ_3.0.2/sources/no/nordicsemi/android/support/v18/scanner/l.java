package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.le.ScanResult;
import android.os.SystemClock;
import java.util.List;

class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f1654a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n f1655b;

    l(n nVar, List list) {
        this.f1655b = nVar;
        this.f1654a = list;
    }

    public void run() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f1655b.f1658a <= (elapsedRealtime - this.f1655b.f1659b.g.k()) + 5) {
            long unused = this.f1655b.f1658a = elapsedRealtime;
            this.f1655b.f1659b.a((List<A>) ((o) d.a()).a((List<ScanResult>) this.f1654a));
        }
    }
}
