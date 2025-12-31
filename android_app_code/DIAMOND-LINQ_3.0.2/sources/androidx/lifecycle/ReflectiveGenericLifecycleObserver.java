package androidx.lifecycle;

import androidx.lifecycle.C0146b;
import androidx.lifecycle.h;

class ReflectiveGenericLifecycleObserver implements j {

    /* renamed from: a  reason: collision with root package name */
    private final Object f855a;

    /* renamed from: b  reason: collision with root package name */
    private final C0146b.a f856b = C0146b.f858a.a(this.f855a.getClass());

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f855a = obj;
    }

    public void a(l lVar, h.a aVar) {
        this.f856b.a(lVar, aVar, this.f855a);
    }
}
