package androidx.lifecycle;

import androidx.lifecycle.h;

class FullLifecycleObserverAdapter implements j {

    /* renamed from: a  reason: collision with root package name */
    private final C0148d f848a;

    /* renamed from: b  reason: collision with root package name */
    private final j f849b;

    FullLifecycleObserverAdapter(C0148d dVar, j jVar) {
        this.f848a = dVar;
        this.f849b = jVar;
    }

    public void a(l lVar, h.a aVar) {
        switch (C0149e.f864a[aVar.ordinal()]) {
            case 1:
                this.f848a.b(lVar);
                break;
            case 2:
                this.f848a.f(lVar);
                break;
            case 3:
                this.f848a.a(lVar);
                break;
            case 4:
                this.f848a.c(lVar);
                break;
            case 5:
                this.f848a.d(lVar);
                break;
            case 6:
                this.f848a.e(lVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        j jVar = this.f849b;
        if (jVar != null) {
            jVar.a(lVar, aVar);
        }
    }
}
