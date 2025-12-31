package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothAdapter;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1647a;

    f(i iVar) {
        this.f1647a = iVar;
    }

    public void run() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && this.f1647a.e > 0 && this.f1647a.f > 0) {
            defaultAdapter.startLeScan(this.f1647a.i);
            this.f1647a.d.postDelayed(this.f1647a.g, this.f1647a.f);
        }
    }
}
