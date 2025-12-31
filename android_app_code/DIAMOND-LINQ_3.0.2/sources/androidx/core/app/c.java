package androidx.core.app;

import android.app.Application;
import androidx.core.app.e;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Application f721a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ e.a f722b;

    c(Application application, e.a aVar) {
        this.f721a = application;
        this.f722b = aVar;
    }

    public void run() {
        this.f721a.unregisterActivityLifecycleCallbacks(this.f722b);
    }
}
