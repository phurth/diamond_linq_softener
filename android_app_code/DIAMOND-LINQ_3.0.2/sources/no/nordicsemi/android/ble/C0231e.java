package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.C;

/* renamed from: no.nordicsemi.android.ble.e  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0231e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C.a f1593a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothDevice f1594b;

    public /* synthetic */ C0231e(C.a aVar, BluetoothDevice bluetoothDevice) {
        this.f1593a = aVar;
        this.f1594b = bluetoothDevice;
    }

    public final void run() {
        this.f1593a.a(this.f1594b);
    }
}
