package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.o;

class n extends ScanCallback {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public long f1658a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ o.a f1659b;

    n(o.a aVar) {
        this.f1659b = aVar;
    }

    public void onBatchScanResults(List<ScanResult> list) {
        this.f1659b.i.post(new l(this, list));
    }

    public void onScanFailed(int i) {
        this.f1659b.i.post(new m(this, i));
    }

    public void onScanResult(int i, ScanResult scanResult) {
        this.f1659b.i.post(new k(this, scanResult, i));
    }
}
