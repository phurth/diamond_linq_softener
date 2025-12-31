package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.h;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final c f1001a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1002b = new a();

    private b(c cVar) {
        this.f1001a = cVar;
    }

    public a a() {
        return this.f1002b;
    }

    public void b(Bundle bundle) {
        this.f1002b.a(bundle);
    }

    public void a(Bundle bundle) {
        h a2 = this.f1001a.a();
        if (a2.a() == h.b.INITIALIZED) {
            a2.a(new Recreator(this.f1001a));
            this.f1002b.a(a2, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public static b a(c cVar) {
        return new b(cVar);
    }
}
