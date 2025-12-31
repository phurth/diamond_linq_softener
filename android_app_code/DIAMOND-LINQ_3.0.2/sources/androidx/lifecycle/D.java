package androidx.lifecycle;

import java.util.HashMap;

public class D {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, A> f847a = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final void a(String str, A a2) {
        A put = this.f847a.put(str, a2);
        if (put != null) {
            put.b();
        }
    }

    /* access modifiers changed from: package-private */
    public final A a(String str) {
        return this.f847a.get(str);
    }

    public final void a() {
        for (A a2 : this.f847a.values()) {
            a2.a();
        }
        this.f847a.clear();
    }
}
