package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* renamed from: no.nordicsemi.android.ble.m  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0239m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1605a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1606b;
    private final /* synthetic */ BluetoothGattCharacteristic c;
    private final /* synthetic */ byte[] d;

    public /* synthetic */ C0239m(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        this.f1605a = mainThreadBluetoothGattCallback;
        this.f1606b = bluetoothGatt;
        this.c = bluetoothGattCharacteristic;
        this.d = bArr;
    }

    public final void run() {
        this.f1605a.a(this.f1606b, this.c, this.d);
    }
}
