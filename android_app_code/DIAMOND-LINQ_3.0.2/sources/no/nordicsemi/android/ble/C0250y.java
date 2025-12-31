package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Deque;
import no.nordicsemi.android.ble.C;
import no.nordicsemi.android.ble.N;

/* renamed from: no.nordicsemi.android.ble.y  reason: case insensitive filesystem */
class C0250y extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C f1629a;

    C0250y(C c) {
        this.f1629a = c;
    }

    private String a(int i) {
        switch (i) {
            case 10:
                return "OFF";
            case 11:
                return "TURNING ON";
            case 12:
                return "ON";
            case 13:
                return "TURNING OFF";
            default:
                return "UNKNOWN (" + i + ")";
        }
    }

    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
        int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
        this.f1629a.a(3, "[Broadcast] Action received: android.bluetooth.adapter.action.STATE_CHANGED, state changed to " + a(intExtra));
        if (intExtra != 10 && intExtra != 13) {
            return;
        }
        if (intExtra2 == 13 || intExtra2 == 10) {
            this.f1629a.d();
            return;
        }
        C.a a2 = this.f1629a.k;
        if (a2 != null) {
            boolean unused = a2.e = true;
            a2.a();
            Deque unused2 = a2.c = null;
        }
        BluetoothDevice n = this.f1629a.j;
        if (n != null) {
            if (!(this.f1629a.z == null || this.f1629a.z.c == N.a.DISCONNECT)) {
                this.f1629a.z.a(n, -100);
                N unused3 = this.f1629a.z = null;
            }
            if (this.f1629a.C != null) {
                this.f1629a.C.a(n, -100);
                X unused4 = this.f1629a.C = null;
            }
            if (this.f1629a.y != null) {
                this.f1629a.y.a(n, -100);
                F unused5 = this.f1629a.y = null;
            }
        }
        boolean unused6 = this.f1629a.m = true;
        if (a2 != null) {
            boolean unused7 = a2.e = false;
            if (n != null) {
                a2.b(n);
            }
        }
    }
}
