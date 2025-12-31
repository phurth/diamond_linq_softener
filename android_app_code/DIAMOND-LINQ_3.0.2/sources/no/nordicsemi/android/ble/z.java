package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import no.nordicsemi.android.ble.N;

class z extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C f1630a;

    z(C c) {
        this.f1630a = c;
    }

    public /* synthetic */ void a() {
        this.f1630a.a(2, "Discovering services...");
        this.f1630a.a(3, "gatt.discoverServices()");
        this.f1630a.i.discoverServices();
    }

    public void onReceive(Context context, Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
        int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
        if (this.f1630a.j != null && bluetoothDevice.getAddress().equals(this.f1630a.j.getAddress())) {
            C c = this.f1630a;
            c.a(3, "[Broadcast] Action received: android.bluetooth.device.action.BOND_STATE_CHANGED, bond state changed to: " + this.f1630a.a(intExtra) + " (" + intExtra + ")");
            switch (intExtra) {
                case 10:
                    if (intExtra2 != 11) {
                        if (intExtra2 == 12 && this.f1630a.z != null && this.f1630a.z.c == N.a.REMOVE_BOND) {
                            this.f1630a.a(4, "Bond information removed");
                            this.f1630a.z.c(bluetoothDevice);
                            N unused = this.f1630a.z = null;
                            break;
                        }
                    } else {
                        this.f1630a.l.g(bluetoothDevice);
                        this.f1630a.a(5, "Bonding failed");
                        if (this.f1630a.z != null) {
                            this.f1630a.z.a(bluetoothDevice, -4);
                            N unused2 = this.f1630a.z = null;
                            break;
                        }
                    }
                    break;
                case 11:
                    this.f1630a.l.i(bluetoothDevice);
                    return;
                case 12:
                    this.f1630a.a(4, "Device bonded");
                    this.f1630a.l.f(bluetoothDevice);
                    if (this.f1630a.z != null && this.f1630a.z.c == N.a.CREATE_BOND) {
                        this.f1630a.z.c(bluetoothDevice);
                        N unused3 = this.f1630a.z = null;
                        break;
                    } else if (this.f1630a.r || this.f1630a.s) {
                        if (Build.VERSION.SDK_INT < 26 && this.f1630a.z != null && this.f1630a.z.c != N.a.CREATE_BOND) {
                            this.f1630a.k.b(this.f1630a.z);
                            break;
                        } else {
                            return;
                        }
                    } else {
                        boolean unused4 = this.f1630a.s = true;
                        this.f1630a.h.post(new C0227a(this));
                        return;
                    }
            }
            this.f1630a.k.a(true);
        }
    }
}
