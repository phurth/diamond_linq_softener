package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import no.nordicsemi.android.ble.N;
import no.nordicsemi.android.ble.a.c;
import no.nordicsemi.android.ble.a.i;
import no.nordicsemi.android.ble.b.b;
import no.nordicsemi.android.ble.b.d;
import no.nordicsemi.android.ble.b.f;

public final class L extends Q<c> implements J {
    private i p;
    private d q;
    private f r;
    private no.nordicsemi.android.ble.b.c s;
    private int t = 0;

    L(N.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.t > 0;
    }

    /* access modifiers changed from: package-private */
    public L a(C c) {
        super.a(c);
        return this;
    }

    L(N.a aVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(aVar, bluetoothGattCharacteristic);
    }

    public L a(c cVar) {
        super.a(cVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean a(byte[] bArr) {
        no.nordicsemi.android.ble.b.c cVar = this.s;
        return cVar == null || cVar.a(bArr);
    }

    /* access modifiers changed from: package-private */
    public void a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        c cVar = (c) this.o;
        if (cVar != null) {
            if (this.q == null) {
                cVar.a(bluetoothDevice, new b(bArr));
                return;
            }
            i iVar = this.p;
            if (iVar != null) {
                iVar.a(bluetoothDevice, bArr, this.t);
            }
            if (this.r == null) {
                this.r = new f();
            }
            d dVar = this.q;
            f fVar = this.r;
            int i = this.t;
            this.t = i + 1;
            if (dVar.a(fVar, bArr, i)) {
                cVar.a(bluetoothDevice, this.r.b());
                this.r = null;
                this.t = 0;
            }
        }
    }
}
