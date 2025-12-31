package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.a.h;

public final class K extends Q<h> implements J {
    private final int p;
    private final int q;
    private final int r;

    /* access modifiers changed from: package-private */
    public void d(BluetoothDevice bluetoothDevice) {
        T t = this.o;
        if (t != null) {
            ((h) t).a(bluetoothDevice, 1, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public K a(C c) {
        super.a(c);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(BluetoothDevice bluetoothDevice, int i, int i2) {
        T t = this.o;
        if (t != null) {
            ((h) t).a(bluetoothDevice, i, i2);
        }
    }
}
