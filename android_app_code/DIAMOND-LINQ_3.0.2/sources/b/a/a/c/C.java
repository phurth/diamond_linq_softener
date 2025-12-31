package b.a.a.c;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import b.a.a.d.a;

public abstract class C {

    /* renamed from: a  reason: collision with root package name */
    static C f1079a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1080b = new Handler();
    final s c;
    D d = D.Disconnected;
    a e;

    C(s sVar) {
        this.c = sVar;
    }

    public static void a(s sVar) {
        C c2 = f1079a;
        if (c2 != null) {
            c2.e();
            f1079a = null;
        }
        f1079a = new r(sVar);
    }

    public static synchronized C c() {
        C c2;
        synchronized (C.class) {
            c2 = f1079a;
        }
        return c2;
    }

    public abstract void a();

    public abstract void a(BluetoothDevice bluetoothDevice);

    public abstract void a(byte[] bArr);

    public abstract BluetoothDevice b();

    /* access modifiers changed from: package-private */
    public synchronized void b(D d2) {
        this.d = d2;
        if (this.e != null) {
            a(new j(this, d2), 50);
        }
    }

    public synchronized D d() {
        return this.d;
    }

    public abstract void e();

    public void a(a aVar) {
        this.e = aVar;
    }

    public /* synthetic */ void a(D d2) {
        this.e.a(d2);
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable, long j) {
        if (j > 0) {
            this.f1080b.postDelayed(runnable, j);
        } else {
            this.f1080b.post(runnable);
        }
    }
}
