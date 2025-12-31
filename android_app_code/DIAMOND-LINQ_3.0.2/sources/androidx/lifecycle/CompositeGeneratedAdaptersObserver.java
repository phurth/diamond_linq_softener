package androidx.lifecycle;

import androidx.lifecycle.h;

class CompositeGeneratedAdaptersObserver implements j {

    /* renamed from: a  reason: collision with root package name */
    private final f[] f846a;

    CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.f846a = fVarArr;
    }

    public void a(l lVar, h.a aVar) {
        r rVar = new r();
        for (f a2 : this.f846a) {
            a2.a(lVar, aVar, false, rVar);
        }
        for (f a3 : this.f846a) {
            a3.a(lVar, aVar, true, rVar);
        }
    }
}
