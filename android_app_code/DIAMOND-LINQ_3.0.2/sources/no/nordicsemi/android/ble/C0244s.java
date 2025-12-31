package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;

/* renamed from: no.nordicsemi.android.ble.s  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0244s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1617a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1618b;
    private final /* synthetic */ int c;

    public /* synthetic */ C0244s(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, int i) {
        this.f1617a = mainThreadBluetoothGattCallback;
        this.f1618b = bluetoothGatt;
        this.c = i;
    }

    public final void run() {
        this.f1617a.b(this.f1618b, this.c);
    }
}
