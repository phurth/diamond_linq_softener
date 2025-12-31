package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.a.c;
import no.nordicsemi.android.ble.a.i;
import no.nordicsemi.android.ble.b.b;
import no.nordicsemi.android.ble.b.d;
import no.nordicsemi.android.ble.b.f;

public class W {

    /* renamed from: a  reason: collision with root package name */
    private i f1580a;

    /* renamed from: b  reason: collision with root package name */
    private c f1581b;
    private d c;
    private f d;
    private no.nordicsemi.android.ble.b.c e;
    private int f = 0;

    W() {
    }

    public W a(c cVar) {
        this.f1581b = cVar;
        return this;
    }

    /* access modifiers changed from: package-private */
    public W a() {
        this.f1581b = null;
        this.c = null;
        this.f1580a = null;
        this.d = null;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean a(byte[] bArr) {
        no.nordicsemi.android.ble.b.c cVar = this.e;
        return cVar == null || cVar.a(bArr);
    }

    /* access modifiers changed from: package-private */
    public void a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        c cVar = this.f1581b;
        if (cVar != null) {
            if (this.c == null) {
                cVar.a(bluetoothDevice, new b(bArr));
                return;
            }
            i iVar = this.f1580a;
            if (iVar != null) {
                iVar.a(bluetoothDevice, bArr, this.f);
            }
            if (this.d == null) {
                this.d = new f();
            }
            d dVar = this.c;
            f fVar = this.d;
            int i = this.f;
            this.f = i + 1;
            if (dVar.a(fVar, bArr, i)) {
                cVar.a(bluetoothDevice, this.d.b());
                this.d = null;
                this.f = 0;
            }
        }
    }
}
