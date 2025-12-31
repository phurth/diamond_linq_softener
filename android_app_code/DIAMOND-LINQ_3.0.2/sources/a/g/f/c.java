package a.g.f;

import a.g.a.a.h;
import a.g.f.f;
import a.g.f.k;
import android.os.Handler;

class c implements k.a<f.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h.a f149a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Handler f150b;

    c(h.a aVar, Handler handler) {
        this.f149a = aVar;
        this.f150b = handler;
    }

    public void a(f.c cVar) {
        if (cVar == null) {
            this.f149a.a(1, this.f150b);
            return;
        }
        int i = cVar.f159b;
        if (i == 0) {
            this.f149a.a(cVar.f158a, this.f150b);
        } else {
            this.f149a.a(i, this.f150b);
        }
    }
}
