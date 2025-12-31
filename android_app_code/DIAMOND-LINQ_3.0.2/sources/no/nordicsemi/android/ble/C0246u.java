package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;

/* renamed from: no.nordicsemi.android.ble.u  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0246u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1621a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1622b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;

    public /* synthetic */ C0246u(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f1621a = mainThreadBluetoothGattCallback;
        this.f1622b = bluetoothGatt;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        this.f1621a.a(this.f1622b, this.c, this.d);
    }
}
