package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;

/* renamed from: no.nordicsemi.android.ble.n  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0240n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1607a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1608b;
    private final /* synthetic */ int c;

    public /* synthetic */ C0240n(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, int i) {
        this.f1607a = mainThreadBluetoothGattCallback;
        this.f1608b = bluetoothGatt;
        this.c = i;
    }

    public final void run() {
        this.f1607a.a(this.f1608b, this.c);
    }
}
