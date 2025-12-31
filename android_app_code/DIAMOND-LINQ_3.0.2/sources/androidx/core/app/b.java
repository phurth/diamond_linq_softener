package androidx.core.app;

import androidx.core.app.e;

class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e.a f719a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f720b;

    b(e.a aVar, Object obj) {
        this.f719a = aVar;
        this.f720b = obj;
    }

    public void run() {
        this.f719a.f727a = this.f720b;
    }
}
