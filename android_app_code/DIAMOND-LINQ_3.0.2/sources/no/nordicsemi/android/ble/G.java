package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.a.b;

public final class G extends Q<b> implements J {
    private final int p;

    /* access modifiers changed from: package-private */
    public int g() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public G a(C c) {
        super.a(c);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        T t = this.o;
        if (t != null) {
            ((b) t).a(bluetoothDevice, i, i2, i3);
        }
    }
}
