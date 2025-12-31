package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class A extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C f1570a;

    A(C c) {
        this.f1570a = c;
    }

    public void onReceive(Context context, Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (this.f1570a.j != null && bluetoothDevice != null && bluetoothDevice.getAddress().equals(this.f1570a.j.getAddress())) {
            int intExtra = intent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 0);
            C c = this.f1570a;
            c.a(3, "[Broadcast] Action received: android.bluetooth.device.action.PAIRING_REQUEST, pairing variant: " + this.f1570a.b(intExtra) + " (" + intExtra + ")");
            this.f1570a.a(bluetoothDevice, intExtra);
        }
    }
}
