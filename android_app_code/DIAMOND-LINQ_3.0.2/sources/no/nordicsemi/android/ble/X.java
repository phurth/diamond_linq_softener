package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.a.c;
import no.nordicsemi.android.ble.a.i;
import no.nordicsemi.android.ble.b.b;
import no.nordicsemi.android.ble.b.d;
import no.nordicsemi.android.ble.b.f;

public final class X extends V<c> implements J {
    private i t;
    private d u;
    private f v;
    private no.nordicsemi.android.ble.b.c w;
    private N x;
    private int y;
    private int z;

    /* access modifiers changed from: package-private */
    public N g() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.z > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.y != -123455;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.y == -123456;
    }

    /* access modifiers changed from: package-private */
    public X a(C c) {
        super.a(c);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean a(byte[] bArr) {
        no.nordicsemi.android.ble.b.c cVar = this.w;
        return cVar == null || cVar.a(bArr);
    }

    /* access modifiers changed from: package-private */
    public void a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        c cVar = (c) this.s;
        if (cVar != null) {
            if (this.u == null) {
                cVar.a(bluetoothDevice, new b(bArr));
                return;
            }
            i iVar = this.t;
            if (iVar != null) {
                iVar.a(bluetoothDevice, bArr, this.z);
            }
            if (this.v == null) {
                this.v = new f();
            }
            d dVar = this.u;
            f fVar = this.v;
            int i = this.z;
            this.z = i + 1;
            if (dVar.a(fVar, bArr, i)) {
                cVar.a(bluetoothDevice, this.v.b());
                this.v = null;
                this.z = 0;
            }
        }
    }
}
