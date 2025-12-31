package b.a.a.c;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import androidx.appcompat.app.m;
import b.a.a.d.b;
import b.a.a.d.c;
import java.util.ArrayList;
import java.util.List;

public final class A implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f1075a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private x f1076b;
    private q c;
    private b d;
    private B e = B.Idle;
    private z f = z.LeScan;
    private boolean g;
    private boolean h;
    private int i;

    public A(Context context, m mVar) {
        a(context, mVar);
    }

    private void a(Context context, m mVar) {
        this.f1076b = new x(mVar);
        this.f1076b.a((c) this);
        this.c = new q(new s(r.class, context));
        this.c.a((c) this);
    }

    public z b() {
        return this.f;
    }

    public void c() {
        if (this.e != B.Scanning) {
            e();
            f1075a.clear();
            this.i = 0;
            this.h = false;
            this.g = false;
            this.f = z.LeScan;
            this.e = B.Scanning;
            this.f1076b.a(7500);
        }
    }

    public void d() {
        b bVar = this.d;
        if (bVar != null && this.f == z.LeScan && !this.g) {
            bVar.d();
        }
        this.f1076b.a(true);
        this.c.a(true);
    }

    public void e() {
        if (this.h || this.e != B.Idle) {
            this.e = B.Idle;
            z zVar = this.f;
            if (zVar == z.LeScan) {
                this.f1076b.a(false);
                this.f1076b.c();
            } else if (zVar == z.ClassicScan) {
                this.c.a(false);
                this.c.c();
            }
        }
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public void a() {
        this.h = true;
        this.f1076b.a(false);
        this.f1076b.c();
        this.c.a(false);
        this.c.c();
    }

    public void a(z zVar) {
        int i2;
        if (this.d != null && (this.h || ((zVar == z.ClassicScan && !this.g) || (zVar == z.LeScan && this.g)))) {
            this.d.i();
        }
        if (this.h) {
            return;
        }
        if (zVar == z.LeScan) {
            this.f = z.ClassicScan;
            this.c.a(8000);
        } else if (zVar == z.ClassicScan && (i2 = this.i) == 0 && this.g) {
            this.g = false;
            this.i = i2 + 1;
            this.f1076b.a(5000);
        }
    }

    public void a(BluetoothDevice bluetoothDevice) {
        if (!f1075a.contains(bluetoothDevice.getAddress())) {
            this.g = true;
        }
    }

    public void a(boolean z, BluetoothDevice bluetoothDevice, int i2, no.nordicsemi.android.support.v18.scanner.A a2) {
        if (!f1075a.contains(bluetoothDevice.getAddress())) {
            f1075a.add(bluetoothDevice.getAddress());
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(z, bluetoothDevice, i2, a2);
        }
    }
}
