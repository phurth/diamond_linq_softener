package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.N;
import no.nordicsemi.android.ble.a.e;
import no.nordicsemi.android.ble.a.f;

public class F extends U {
    private BluetoothDevice s;
    private int t;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private boolean x = false;

    F(N.a aVar, BluetoothDevice bluetoothDevice) {
        super(aVar);
        this.s = bluetoothDevice;
        this.t = 1;
    }

    public /* synthetic */ void b() {
        super.b();
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        int i = this.v;
        if (i <= 0) {
            return false;
        }
        this.v = i - 1;
        return true;
    }

    public BluetoothDevice h() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        int i = this.u;
        this.u = i + 1;
        return i == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public F a(C c) {
        super.a(c);
        return this;
    }

    public F a(e eVar) {
        super.a(eVar);
        return this;
    }

    public F a(f fVar) {
        super.a(fVar);
        return this;
    }

    public F a(int i, int i2) {
        this.v = i;
        this.w = i2;
        return this;
    }

    public F a(boolean z) {
        this.x = z;
        return this;
    }

    public F a(int i) {
        this.t = i;
        return this;
    }
}
