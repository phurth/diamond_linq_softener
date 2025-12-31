package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;

/* renamed from: no.nordicsemi.android.ble.l  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0238l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1603a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1604b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;

    public /* synthetic */ C0238l(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        this.f1603a = mainThreadBluetoothGattCallback;
        this.f1604b = bluetoothGatt;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public final void run() {
        this.f1603a.a(this.f1604b, this.c, this.d, this.e);
    }
}
