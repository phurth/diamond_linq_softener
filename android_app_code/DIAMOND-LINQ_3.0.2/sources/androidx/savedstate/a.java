package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.h;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private a.b.a.b.b<String, b> f999a = new a.b.a.b.b<>();

    /* renamed from: b  reason: collision with root package name */
    private Bundle f1000b;
    private boolean c;
    boolean d = true;

    /* renamed from: androidx.savedstate.a$a  reason: collision with other inner class name */
    public interface C0029a {
        void a(c cVar);
    }

    public interface b {
        Bundle a();
    }

    a() {
    }

    public Bundle a(String str) {
        if (this.c) {
            Bundle bundle = this.f1000b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f1000b.remove(str);
            if (this.f1000b.isEmpty()) {
                this.f1000b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar, Bundle bundle) {
        if (!this.c) {
            if (bundle != null) {
                this.f1000b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            hVar.a(new SavedStateRegistry$1(this));
            this.c = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f1000b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        a.b.a.b.b<K, V>.d b2 = this.f999a.b();
        while (b2.hasNext()) {
            Map.Entry entry = (Map.Entry) b2.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
