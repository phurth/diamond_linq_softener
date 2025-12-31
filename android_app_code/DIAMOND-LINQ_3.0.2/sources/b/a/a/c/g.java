package b.a.a.c;

import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.support.v18.scanner.A;

/* compiled from: lambda */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ w f1094a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ BluetoothDevice f1095b;
    private final /* synthetic */ int c;
    private final /* synthetic */ A d;

    public /* synthetic */ g(w wVar, BluetoothDevice bluetoothDevice, int i, A a2) {
        this.f1094a = wVar;
        this.f1095b = bluetoothDevice;
        this.c = i;
        this.d = a2;
    }

    public final void run() {
        this.f1094a.a(this.f1095b, this.c, this.d);
    }
}
