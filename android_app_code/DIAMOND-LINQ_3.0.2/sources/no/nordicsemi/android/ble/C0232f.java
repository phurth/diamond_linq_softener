package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;
import no.nordicsemi.android.ble.C;

/* renamed from: no.nordicsemi.android.ble.f  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0232f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C.a f1595a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f1596b;
    private final /* synthetic */ BluetoothGatt c;

    public /* synthetic */ C0232f(C.a aVar, int i, BluetoothGatt bluetoothGatt) {
        this.f1595a = aVar;
        this.f1596b = i;
        this.c = bluetoothGatt;
    }

    public final void run() {
        this.f1595a.a(this.f1596b, this.c);
    }
}
