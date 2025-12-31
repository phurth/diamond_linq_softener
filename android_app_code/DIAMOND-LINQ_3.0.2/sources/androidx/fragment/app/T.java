package androidx.fragment.app;

import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.lifecycle.n;

class T implements l {

    /* renamed from: a  reason: collision with root package name */
    private n f793a = null;

    T() {
    }

    public h a() {
        c();
        return this.f793a;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f793a == null) {
            this.f793a = new n(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f793a != null;
    }

    /* access modifiers changed from: package-private */
    public void a(h.a aVar) {
        this.f793a.b(aVar);
    }
}
