package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

/* renamed from: no.nordicsemi.android.ble.o  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0241o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ MainThreadBluetoothGattCallback f1609a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1610b;
    private final /* synthetic */ BluetoothGattCharacteristic c;
    private final /* synthetic */ byte[] d;
    private final /* synthetic */ int e;

    public /* synthetic */ C0241o(MainThreadBluetoothGattCallback mainThreadBluetoothGattCallback, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        this.f1609a = mainThreadBluetoothGattCallback;
        this.f1610b = bluetoothGatt;
        this.c = bluetoothGattCharacteristic;
        this.d = bArr;
        this.e = i;
    }

    public final void run() {
        this.f1609a.a(this.f1610b, this.c, this.d, this.e);
    }
}
