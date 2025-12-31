package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;

/* renamed from: no.nordicsemi.android.ble.w  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0248w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1625a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1626b;
    private final /* synthetic */ BluetoothGattDescriptor c;
    private final /* synthetic */ byte[] d;
    private final /* synthetic */ int e;

    public /* synthetic */ C0248w(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, int i) {
        this.f1625a = mainThreadBluetoothGattCallback;
        this.f1626b = bluetoothGatt;
        this.c = bluetoothGattDescriptor;
        this.d = bArr;
        this.e = i;
    }

    public final void run() {
        this.f1625a.a(this.f1626b, this.c, this.d, this.e);
    }
}
