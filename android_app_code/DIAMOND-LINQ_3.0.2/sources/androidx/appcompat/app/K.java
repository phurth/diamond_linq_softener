package androidx.appcompat.app;

import a.g.i.H;
import android.view.View;

class K implements H {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ L f400a;

    K(L l) {
        this.f400a = l;
    }

    public void a(View view) {
        ((View) this.f400a.h.getParent()).invalidate();
    }
}
