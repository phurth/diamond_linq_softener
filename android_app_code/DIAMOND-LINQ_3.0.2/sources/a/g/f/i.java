package a.g.f;

import a.g.f.k;
import android.os.Handler;
import java.util.concurrent.Callable;

class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Callable f163a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Handler f164b;
    final /* synthetic */ k.a c;
    final /* synthetic */ k d;

    i(k kVar, Callable callable, Handler handler, k.a aVar) {
        this.d = kVar;
        this.f163a = callable;
        this.f164b = handler;
        this.c = aVar;
    }

    public void run() {
        Object obj;
        try {
            obj = this.f163a.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.f164b.post(new h(this, obj));
    }
}
