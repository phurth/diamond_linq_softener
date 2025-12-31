package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import no.nordicsemi.android.ble.N;

abstract class U extends N {
    private T o;
    private Runnable p;
    private Handler q;
    protected long r;

    U(N.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: package-private */
    public U a(C c) {
        super.a(c);
        this.q = c.h;
        this.o = c;
        return this;
    }

    public void b() {
        super.b();
    }

    /* access modifiers changed from: package-private */
    public void c(BluetoothDevice bluetoothDevice) {
        if (!this.n) {
            this.q.removeCallbacks(this.p);
            this.p = null;
        }
        super.c(bluetoothDevice);
    }

    public /* synthetic */ void d(BluetoothDevice bluetoothDevice) {
        this.p = null;
        if (!this.n) {
            a(bluetoothDevice, -5);
            this.o.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (!this.n) {
            this.q.removeCallbacks(this.p);
            this.p = null;
        }
        super.f();
    }

    /* access modifiers changed from: package-private */
    public void b(BluetoothDevice bluetoothDevice) {
        long j = this.r;
        if (j > 0) {
            this.p = new C0249x(this, bluetoothDevice);
            this.q.postDelayed(this.p, j);
        }
        super.b(bluetoothDevice);
    }

    /* access modifiers changed from: package-private */
    public void a(BluetoothDevice bluetoothDevice, int i) {
        if (!this.n) {
            this.q.removeCallbacks(this.p);
            this.p = null;
        }
        super.a(bluetoothDevice, i);
    }
}
