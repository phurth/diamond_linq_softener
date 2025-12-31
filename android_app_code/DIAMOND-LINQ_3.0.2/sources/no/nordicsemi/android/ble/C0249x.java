package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;

/* renamed from: no.nordicsemi.android.ble.x  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0249x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ U f1627a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothDevice f1628b;

    public /* synthetic */ C0249x(U u, BluetoothDevice bluetoothDevice) {
        this.f1627a = u;
        this.f1628b = bluetoothDevice;
    }

    public final void run() {
        this.f1627a.d(this.f1628b);
    }
}
