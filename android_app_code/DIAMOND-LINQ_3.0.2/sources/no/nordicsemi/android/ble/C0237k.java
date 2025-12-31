package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;

/* renamed from: no.nordicsemi.android.ble.k  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0237k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1601a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1602b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;

    public /* synthetic */ C0237k(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f1601a = mainThreadBluetoothGattCallback;
        this.f1602b = bluetoothGatt;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        this.f1601a.b(this.f1602b, this.c, this.d);
    }
}
