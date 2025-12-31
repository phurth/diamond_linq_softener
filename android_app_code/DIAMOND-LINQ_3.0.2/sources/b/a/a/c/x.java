package b.a.a.c;

import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import androidx.appcompat.app.m;
import b.a.a.d.c;
import java.util.ArrayList;
import no.nordicsemi.android.support.v18.scanner.C;
import no.nordicsemi.android.support.v18.scanner.d;
import no.nordicsemi.android.support.v18.scanner.v;

final class x {

    /* renamed from: a  reason: collision with root package name */
    private final BluetoothAdapter f1118a = BluetoothAdapter.getDefaultAdapter();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public c f1119b;
    private final Handler c = new Handler();
    private final m d;
    private boolean e;
    private final Runnable f = new C0170a(this);
    private final v g = new w(this);

    x(m mVar) {
        this.d = mVar;
    }

    public /* synthetic */ void b() {
        this.f1119b.a(z.LeScan);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|6|(1:13)(2:10|11)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r3 = this;
            no.nordicsemi.android.support.v18.scanner.d r0 = no.nordicsemi.android.support.v18.scanner.d.a()
            no.nordicsemi.android.support.v18.scanner.v r1 = r3.g     // Catch:{ Exception -> 0x000a }
            r0.a(r1)     // Catch:{ Exception -> 0x000a }
            goto L_0x001e
        L_0x000a:
            androidx.appcompat.app.m r0 = r3.d     // Catch:{ Exception -> 0x001d }
            androidx.appcompat.app.m r1 = r3.d     // Catch:{ Exception -> 0x001d }
            android.content.Intent r1 = r1.getIntent()     // Catch:{ Exception -> 0x001d }
            r2 = 335577088(0x14008000, float:6.487592E-27)
            android.content.Intent r1 = r1.addFlags(r2)     // Catch:{ Exception -> 0x001d }
            r0.startActivity(r1)     // Catch:{ Exception -> 0x001d }
            goto L_0x001e
        L_0x001d:
        L_0x001e:
            android.os.Handler r0 = r3.c
            java.lang.Runnable r1 = r3.f
            r0.removeCallbacks(r1)
            boolean r0 = r3.e
            if (r0 == 0) goto L_0x0037
            b.a.a.d.c r0 = r3.f1119b
            if (r0 == 0) goto L_0x0037
            b.a.a.c.h r0 = new b.a.a.c.h
            r0.<init>(r3)
            r1 = 150(0x96, double:7.4E-322)
            r3.a(r0, r1)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.c.x.c():void");
    }

    public void a(int i) {
        if (this.f1119b != null) {
            a(new i(this), 250);
        }
        d a2 = d.a();
        C.a aVar = new C.a();
        aVar.a(true);
        aVar.e(2);
        aVar.a(0);
        aVar.b(false);
        a2.a(new ArrayList(), aVar.a(), this.g);
        a(this.f, (long) i);
    }

    public /* synthetic */ void a() {
        this.f1119b.d();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.e = z;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.f1119b = cVar;
    }

    /* access modifiers changed from: private */
    public void a(Runnable runnable, long j) {
        this.c.postDelayed(runnable, j);
    }
}
