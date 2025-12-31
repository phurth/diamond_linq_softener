package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;
import no.nordicsemi.android.ble.C;

/* renamed from: no.nordicsemi.android.ble.d  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0230d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C.a f1590a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothGatt f1591b;

    public /* synthetic */ C0230d(C.a aVar, BluetoothGatt bluetoothGatt) {
        this.f1590a = aVar;
        this.f1591b = bluetoothGatt;
    }

    public final void run() {
        this.f1590a.d(this.f1591b);
    }
}
