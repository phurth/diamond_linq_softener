package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.a.j;

public final class M extends Q<j> implements J {
    /* access modifiers changed from: package-private */
    public void b(BluetoothDevice bluetoothDevice, int i) {
        T t = this.o;
        if (t != null) {
            ((j) t).a(bluetoothDevice, i);
        }
    }

    /* access modifiers changed from: package-private */
    public M a(C c) {
        super.a(c);
        return this;
    }
}
