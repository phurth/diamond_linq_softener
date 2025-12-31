package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;

/* renamed from: no.nordicsemi.android.ble.p  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0242p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1611a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1612b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;

    public /* synthetic */ C0242p(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        this.f1611a = mainThreadBluetoothGattCallback;
        this.f1612b = bluetoothGatt;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public final void run() {
        this.f1611a.b(this.f1612b, this.c, this.d, this.e);
    }
}
