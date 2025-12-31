package b.a.a.c;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import no.nordicsemi.android.support.v18.scanner.A;

class p extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f1104a;

    p(q qVar) {
        this.f1104a = qVar;
    }

    public /* synthetic */ void a(BluetoothDevice bluetoothDevice) {
        this.f1104a.c.a(bluetoothDevice);
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.device.action.FOUND".equals(intent.getAction())) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            short shortExtra = intent.getShortExtra("android.bluetooth.device.extra.RSSI", Short.MIN_VALUE);
            if (this.f1104a.c != null) {
                if (bluetoothDevice.getType() == 2) {
                    this.f1104a.a(new C0171b(this, bluetoothDevice), 100);
                }
                this.f1104a.a(new C0172c(this, bluetoothDevice, shortExtra), 150);
            }
        }
    }

    public /* synthetic */ void a(BluetoothDevice bluetoothDevice, int i) {
        this.f1104a.c.a(true, bluetoothDevice, i, (A) null);
    }
}
