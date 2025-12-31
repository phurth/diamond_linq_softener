package androidx.appcompat.app;

import a.g.i.I;
import a.g.i.q;
import a.g.i.y;
import android.view.View;

class r implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f426a;

    r(x xVar) {
        this.f426a = xVar;
    }

    public I a(View view, I i) {
        int e = i.e();
        int j = this.f426a.j(e);
        if (e != j) {
            i = i.a(i.c(), j, i.d(), i.b());
        }
        return y.b(view, i);
    }
}
