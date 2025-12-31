package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* renamed from: no.nordicsemi.android.ble.q  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0243q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1613a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1614b;
    private final /* synthetic */ BluetoothGattCharacteristic c;
    private final /* synthetic */ byte[] d;
    private final /* synthetic */ int e;

    public /* synthetic */ C0243q(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        this.f1613a = mainThreadBluetoothGattCallback;
        this.f1614b = bluetoothGatt;
        this.c = bluetoothGattCharacteristic;
        this.d = bArr;
        this.e = i;
    }

    public final void run() {
        this.f1613a.b(this.f1614b, this.c, this.d, this.e);
    }
}
