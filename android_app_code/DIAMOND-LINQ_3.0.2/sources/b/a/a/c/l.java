package b.a.a.c;

import android.bluetooth.BluetoothDevice;
import b.a.a.C0168ba;
import b.a.a.ia;
import no.nordicsemi.android.ble.a.c;
import no.nordicsemi.android.ble.b.b;

class l implements c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1101a;

    l(n nVar) {
        this.f1101a = nVar;
    }

    public void a(BluetoothDevice bluetoothDevice, b bVar) {
        if (bVar.a() != null && bVar.b() != 0) {
            C0168ba.b(ia.a(">>>+  Read", bVar.a(), bVar.b()));
            this.f1101a.P.a(bVar.a(), bVar.b());
        }
    }
}
