package a.g.a.a;

import a.g.a.a.h;
import android.graphics.Typeface;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Typeface f129a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ h.a f130b;

    f(h.a aVar, Typeface typeface) {
        this.f130b = aVar;
        this.f129a = typeface;
    }

    public void run() {
        this.f130b.a(this.f129a);
    }
}
