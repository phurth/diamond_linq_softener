package b.a.a.c;

import android.bluetooth.BluetoothDevice;

/* renamed from: b.a.a.c.c  reason: case insensitive filesystem */
/* compiled from: lambda */
public final /* synthetic */ class C0172c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ p f1088a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothDevice f1089b;
    private final /* synthetic */ int c;

    public /* synthetic */ C0172c(p pVar, BluetoothDevice bluetoothDevice, int i) {
        this.f1088a = pVar;
        this.f1089b = bluetoothDevice;
        this.c = i;
    }

    public final void run() {
        this.f1088a.a(this.f1089b, this.c);
    }
}
