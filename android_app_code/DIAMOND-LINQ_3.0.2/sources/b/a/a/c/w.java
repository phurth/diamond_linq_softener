package b.a.a.c;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.support.v18.scanner.A;
import no.nordicsemi.android.support.v18.scanner.v;

class w extends v {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1117a;

    w(x xVar) {
        this.f1117a = xVar;
    }

    public void a(int i, A a2) {
        super.a(i, a2);
        BluetoothDevice a3 = a2.a();
        int b2 = a2.b();
        if (this.f1117a.f1119b != null) {
            this.f1117a.a(new g(this, a3, b2, a2), 25);
        }
    }

    public /* synthetic */ void a(BluetoothDevice bluetoothDevice, int i, A a2) {
        this.f1117a.f1119b.a(false, bluetoothDevice, i, a2);
    }
}
