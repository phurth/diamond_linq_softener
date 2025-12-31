package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.a.g;

public final class I extends Q<g> implements J {
    private final int p;

    /* access modifiers changed from: package-private */
    public void b(BluetoothDevice bluetoothDevice, int i) {
        T t = this.o;
        if (t != null) {
            ((g) t).a(bluetoothDevice, i);
        }
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public I a(C c) {
        super.a(c);
        return this;
    }
}
