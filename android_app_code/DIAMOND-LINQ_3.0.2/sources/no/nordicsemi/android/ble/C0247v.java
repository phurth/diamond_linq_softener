package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;

/* renamed from: no.nordicsemi.android.ble.v  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0247v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1623a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1624b;
    private final /* synthetic */ BluetoothGattDescriptor c;
    private final /* synthetic */ byte[] d;
    private final /* synthetic */ int e;

    public /* synthetic */ C0247v(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, int i) {
        this.f1623a = mainThreadBluetoothGattCallback;
        this.f1624b = bluetoothGatt;
        this.c = bluetoothGattDescriptor;
        this.d = bArr;
        this.e = i;
    }

    public final void run() {
        this.f1623a.b(this.f1624b, this.c, this.d, this.e);
    }
}
