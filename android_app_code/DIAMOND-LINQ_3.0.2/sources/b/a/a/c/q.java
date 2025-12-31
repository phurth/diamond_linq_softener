package b.a.a.c;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import b.a.a.d.c;

final class q {

    /* renamed from: a  reason: collision with root package name */
    private final BluetoothAdapter f1105a = BluetoothAdapter.getDefaultAdapter();

    /* renamed from: b  reason: collision with root package name */
    private final s f1106b;
    /* access modifiers changed from: private */
    public c c;
    private final Handler d = new Handler();
    private boolean e;
    private final Runnable f = new k(this);
    private final BroadcastReceiver g = new p(this);

    q(s sVar) {
        this.f1106b = sVar;
    }

    public /* synthetic */ void b() {
        this.c.a(z.ClassicScan);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        try {
            this.f1106b.a().unregisterReceiver(this.g);
        } catch (IllegalArgumentException unused) {
        }
        if (this.f1105a.isDiscovering()) {
            this.f1105a.cancelDiscovery();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException unused2) {
        }
        this.d.removeCallbacks(this.f);
        if (this.e && this.c != null) {
            a(new C0174e(this), 50);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        if (this.c != null) {
            a(new C0173d(this), 250);
        }
        try {
            this.f1106b.a().unregisterReceiver(this.g);
        } catch (IllegalArgumentException unused) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        this.f1106b.a().registerReceiver(this.g, intentFilter);
        this.f1105a.startDiscovery();
        a(this.f, (long) i);
    }

    public /* synthetic */ void a() {
        this.c.d();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.e = z;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.c = cVar;
    }

    /* access modifiers changed from: private */
    public void a(Runnable runnable, long j) {
        this.d.postDelayed(runnable, j);
    }
}
