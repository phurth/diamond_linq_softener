package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.SystemClock;
import no.nordicsemi.android.support.v18.scanner.d;

class h implements BluetoothAdapter.LeScanCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1650a;

    h(i iVar) {
        this.f1650a = iVar;
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        A a2 = new A(bluetoothDevice, y.a(bArr), i, SystemClock.elapsedRealtimeNanos());
        synchronized (this.f1650a.f1651b) {
            for (d.a aVar : this.f1650a.f1651b.values()) {
                aVar.i.post(new g(this, aVar, a2));
            }
        }
    }
}
