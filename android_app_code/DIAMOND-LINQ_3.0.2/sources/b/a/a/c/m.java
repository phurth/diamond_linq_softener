package b.a.a.c;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import no.nordicsemi.android.ble.C;
import no.nordicsemi.android.ble.E;
import no.nordicsemi.android.ble.L;

class m extends C<E>.a {
    final /* synthetic */ n h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m(n nVar) {
        super();
        this.h = nVar;
    }

    /* access modifiers changed from: protected */
    public void b() {
        n nVar = this.h;
        L c = nVar.b(nVar.N);
        c.a(this.h.R);
        c.b();
        this.h.a(25).b();
        n nVar2 = this.h;
        nVar2.c(nVar2.N).a(this.h.R);
        this.h.a(25).b();
        n nVar3 = this.h;
        nVar3.a(nVar3.N).b();
        this.h.a(25).b();
    }

    public boolean c(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service;
        BluetoothGattService service2 = bluetoothGatt.getService(n.K);
        if (service2 != null) {
            BluetoothGattCharacteristic unused = this.h.N = service2.getCharacteristic(n.L);
            BluetoothGattCharacteristic unused2 = this.h.O = service2.getCharacteristic(n.M);
        }
        if (this.h.O == null && (service = bluetoothGatt.getService(n.H)) != null) {
            BluetoothGattCharacteristic unused3 = this.h.N = service.getCharacteristic(n.I);
            BluetoothGattCharacteristic unused4 = this.h.O = service.getCharacteristic(n.J);
        }
        boolean z = true;
        boolean z2 = this.h.O != null && (this.h.O.getProperties() & 8) > 0;
        n nVar = this.h;
        if (nVar.N == null || this.h.O == null || !z2) {
            z = false;
        }
        boolean unused5 = nVar.Q = z;
        return this.h.Q;
    }

    /* access modifiers changed from: protected */
    public void c() {
        BluetoothGattCharacteristic unused = this.h.N = null;
        BluetoothGattCharacteristic unused2 = this.h.O = null;
    }
}
