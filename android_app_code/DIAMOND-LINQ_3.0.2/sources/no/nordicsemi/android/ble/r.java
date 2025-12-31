package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;

/* compiled from: lambda */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1615a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1616b;
    private final /* synthetic */ int c;
    private final /* synthetic */ int d;
    private final /* synthetic */ int e;
    private final /* synthetic */ int f;

    public /* synthetic */ r(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4) {
        this.f1615a = mainThreadBluetoothGattCallback;
        this.f1616b = bluetoothGatt;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }

    public final void run() {
        this.f1615a.a(this.f1616b, this.c, this.d, this.e, this.f);
    }
}
