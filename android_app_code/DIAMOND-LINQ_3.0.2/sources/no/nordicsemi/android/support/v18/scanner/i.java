package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.support.v18.scanner.d;

class i extends d {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map<v, d.a> f1651b = new HashMap();
    private HandlerThread c;
    /* access modifiers changed from: private */
    public Handler d;
    /* access modifiers changed from: private */
    public long e;
    /* access modifiers changed from: private */
    public long f;
    /* access modifiers changed from: private */
    public final Runnable g = new e(this);
    /* access modifiers changed from: private */
    public final Runnable h = new f(this);
    /* access modifiers changed from: private */
    public final BluetoothAdapter.LeScanCallback i = new h(this);

    i() {
    }

    /* access modifiers changed from: package-private */
    public void a(List<x> list, C c2, v vVar, Handler handler) {
        boolean isEmpty;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        r.a(defaultAdapter);
        synchronized (this.f1651b) {
            if (!this.f1651b.containsKey(vVar)) {
                d.a aVar = new d.a(false, false, list, c2, vVar, handler);
                isEmpty = this.f1651b.isEmpty();
                this.f1651b.put(vVar, aVar);
            } else {
                throw new IllegalArgumentException("scanner already started with given scanCallback");
            }
        }
        if (this.c == null) {
            this.c = new HandlerThread(i.class.getName());
            this.c.start();
            this.d = new Handler(this.c.getLooper());
        }
        b();
        if (isEmpty) {
            defaultAdapter.startLeScan(this.i);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(v vVar) {
        d.a remove;
        boolean isEmpty;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        r.a(defaultAdapter);
        synchronized (this.f1651b) {
            remove = this.f1651b.remove(vVar);
            isEmpty = this.f1651b.isEmpty();
        }
        if (remove != null) {
            remove.a();
            b();
            if (isEmpty) {
                defaultAdapter.stopLeScan(this.i);
                Handler handler = this.d;
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                }
                HandlerThread handlerThread = this.c;
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                    this.c = null;
                }
            }
        }
    }

    private void b() {
        long j;
        long j2;
        synchronized (this.f1651b) {
            j = Long.MAX_VALUE;
            j2 = Long.MAX_VALUE;
            for (d.a aVar : this.f1651b.values()) {
                C c2 = aVar.g;
                if (c2.p()) {
                    if (j > c2.i()) {
                        j = c2.i();
                    }
                    if (j2 > c2.j()) {
                        j2 = c2.j();
                    }
                }
            }
        }
        if (j >= Long.MAX_VALUE || j2 >= Long.MAX_VALUE) {
            this.f = 0;
            this.e = 0;
            Handler handler = this.d;
            if (handler != null) {
                handler.removeCallbacks(this.h);
                this.d.removeCallbacks(this.g);
                return;
            }
            return;
        }
        this.e = j;
        this.f = j2;
        Handler handler2 = this.d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.h);
            this.d.removeCallbacks(this.g);
            this.d.postDelayed(this.g, this.f);
        }
    }
}
