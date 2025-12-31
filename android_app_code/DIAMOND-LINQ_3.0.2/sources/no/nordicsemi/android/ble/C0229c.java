package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.ble.C;

/* renamed from: no.nordicsemi.android.ble.c  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0229c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C.a f1588a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ G f1589b;
    private final /* synthetic */ BluetoothDevice c;

    public /* synthetic */ C0229c(C.a aVar, G g, BluetoothDevice bluetoothDevice) {
        this.f1588a = aVar;
        this.f1589b = g;
        this.c = bluetoothDevice;
    }

    public final void run() {
        this.f1588a.a(this.f1589b, this.c);
    }
}
