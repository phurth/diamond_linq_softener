package no.nordicsemi.android.support.v18.scanner;

import android.os.SystemClock;
import java.util.Iterator;
import no.nordicsemi.android.support.v18.scanner.d;

/* renamed from: no.nordicsemi.android.support.v18.scanner.c  reason: case insensitive filesystem */
class C0253c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.a f1642a;

    C0253c(d.a aVar) {
        this.f1642a = aVar;
    }

    public void run() {
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        synchronized (this.f1642a.f1644a) {
            Iterator it = this.f1642a.l.values().iterator();
            while (it.hasNext()) {
                A a2 = (A) it.next();
                if (a2.d() < elapsedRealtimeNanos - this.f1642a.g.d()) {
                    it.remove();
                    this.f1642a.i.post(new C0252b(this, a2));
                }
            }
            if (!this.f1642a.l.isEmpty()) {
                this.f1642a.i.postDelayed(this, this.f1642a.g.e());
            }
        }
    }
}
