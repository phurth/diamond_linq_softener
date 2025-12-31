package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.C;

/* renamed from: no.nordicsemi.android.ble.b  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0228b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C.a f1583a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ S f1584b;
    private final /* synthetic */ BluetoothDevice c;

    public /* synthetic */ C0228b(C.a aVar, S s, BluetoothDevice bluetoothDevice) {
        this.f1583a = aVar;
        this.f1584b = s;
        this.c = bluetoothDevice;
    }

    public final void run() {
        this.f1583a.a(this.f1584b, this.c);
    }
}
