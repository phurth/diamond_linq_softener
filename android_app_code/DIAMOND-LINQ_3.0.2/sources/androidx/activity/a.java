package androidx.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.g;
import androidx.lifecycle.D;
import androidx.lifecycle.E;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.lifecycle.z;
import androidx.savedstate.b;
import androidx.savedstate.c;
import java.util.WeakHashMap;

public class a extends g implements l, E, c {

    /* renamed from: b  reason: collision with root package name */
    private final n f367b = new n(this);
    private final b c = b.a((c) this);
    private D d;
    private final OnBackPressedDispatcher e = new OnBackPressedDispatcher();
    private final WeakHashMap<b, a.b.a.c.b> f = new WeakHashMap<>();
    private int g;

    /* renamed from: androidx.activity.a$a  reason: collision with other inner class name */
    static final class C0017a {

        /* renamed from: a  reason: collision with root package name */
        Object f368a;

        /* renamed from: b  reason: collision with root package name */
        D f369b;

        C0017a() {
        }
    }

    public a() {
        if (a() != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                a().a(new ComponentActivity$1(this));
            }
            a().a(new ComponentActivity$2(this));
            int i = Build.VERSION.SDK_INT;
            if (19 <= i && i <= 23) {
                a().a(new ImmLeaksCleaner(this));
                return;
            }
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    public h a() {
        return this.f367b;
    }

    public final androidx.savedstate.a b() {
        return this.c.a();
    }

    public D c() {
        if (getApplication() != null) {
            if (this.d == null) {
                C0017a aVar = (C0017a) getLastNonConfigurationInstance();
                if (aVar != null) {
                    this.d = aVar.f369b;
                }
                if (this.d == null) {
                    this.d = new D();
                }
            }
            return this.d;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void onBackPressed() {
        if (!this.e.a()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c.a(bundle);
        z.b((Activity) this);
        int i = this.g;
        if (i != 0) {
            setContentView(i);
        }
    }

    public final Object onRetainNonConfigurationInstance() {
        C0017a aVar;
        Object r = r();
        D d2 = this.d;
        if (d2 == null && (aVar = (C0017a) getLastNonConfigurationInstance()) != null) {
            d2 = aVar.f369b;
        }
        if (d2 == null && r == null) {
            return null;
        }
        C0017a aVar2 = new C0017a();
        aVar2.f368a = r;
        aVar2.f369b = d2;
        return aVar2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        h a2 = a();
        if (a2 instanceof n) {
            ((n) a2).a(h.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.c.b(bundle);
    }

    public final OnBackPressedDispatcher q() {
        return this.e;
    }

    @Deprecated
    public Object r() {
        return null;
    }
}
