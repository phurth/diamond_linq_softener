package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothAdapter;

class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1646a;

    e(i iVar) {
        this.f1646a = iVar;
    }

    public void run() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && this.f1646a.e > 0 && this.f1646a.f > 0) {
            defaultAdapter.stopLeScan(this.f1646a.i);
            this.f1646a.d.postDelayed(this.f1646a.h, this.f1646a.e);
        }
    }
}
