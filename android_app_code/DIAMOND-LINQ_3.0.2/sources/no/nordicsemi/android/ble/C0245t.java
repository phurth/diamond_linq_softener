package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;

/* renamed from: no.nordicsemi.android.ble.t  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0245t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1619a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1620b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;

    public /* synthetic */ C0245t(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, int i, int i2) {
        this.f1619a = mainThreadBluetoothGattCallback;
        this.f1620b = bluetoothGatt;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        this.f1619a.c(this.f1620b, this.c, this.d);
    }
}
