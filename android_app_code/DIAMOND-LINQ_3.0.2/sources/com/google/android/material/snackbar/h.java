package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f1542a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f1543b = new Object();
    private final Handler c = new Handler(Looper.getMainLooper(), new g(this));
    private b d;
    private b e;

    interface a {
        void a(int i);
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<a> f1544a;

        /* renamed from: b  reason: collision with root package name */
        int f1545b;
        boolean c;

        /* access modifiers changed from: package-private */
        public boolean a(a aVar) {
            return aVar != null && this.f1544a.get() == aVar;
        }
    }

    private h() {
    }

    static h a() {
        if (f1542a == null) {
            f1542a = new h();
        }
        return f1542a;
    }

    private boolean c(a aVar) {
        b bVar = this.d;
        return bVar != null && bVar.a(aVar);
    }

    public void b(a aVar) {
        synchronized (this.f1543b) {
            if (c(aVar) && this.d.c) {
                this.d.c = false;
                b(this.d);
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.f1543b) {
            if (c(aVar) && !this.d.c) {
                this.d.c = true;
                this.c.removeCallbacksAndMessages(this.d);
            }
        }
    }

    private void b(b bVar) {
        int i = bVar.f1545b;
        if (i != -2) {
            if (i <= 0) {
                i = i == -1 ? 1500 : 2750;
            }
            this.c.removeCallbacksAndMessages(bVar);
            Handler handler = this.c;
            handler.sendMessageDelayed(Message.obtain(handler, 0, bVar), (long) i);
        }
    }

    private boolean a(b bVar, int i) {
        a aVar = (a) bVar.f1544a.get();
        if (aVar == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(bVar);
        aVar.a(i);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        synchronized (this.f1543b) {
            if (this.d == bVar || this.e == bVar) {
                a(bVar, 2);
            }
        }
    }
}
