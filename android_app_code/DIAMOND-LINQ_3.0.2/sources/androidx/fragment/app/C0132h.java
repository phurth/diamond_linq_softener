package androidx.fragment.app;

import a.g.i.C0041e;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.i;
import androidx.lifecycle.D;
import androidx.lifecycle.E;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.n;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* renamed from: androidx.fragment.app.h  reason: case insensitive filesystem */
public class C0132h implements ComponentCallbacks, View.OnCreateContextMenuListener, l, E, androidx.savedstate.c {

    /* renamed from: a  reason: collision with root package name */
    static final Object f803a = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D = true;
    boolean E;
    ViewGroup F;
    View G;
    View H;
    boolean I;
    boolean J = true;
    a K;
    boolean L;
    boolean M;
    float N;
    LayoutInflater O;
    boolean P;
    n Q;
    T R;
    s<l> S = new s<>();
    androidx.savedstate.b T;
    private int U;

    /* renamed from: b  reason: collision with root package name */
    int f804b = 0;
    Bundle c;
    SparseArray<Parcelable> d;
    Boolean e;
    String f = UUID.randomUUID().toString();
    Bundle g;
    C0132h h;
    String i = null;
    int j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    int q;
    w r;
    C0138n s;
    w t;
    C0132h u;
    int v;
    int w;
    String x;
    boolean y;
    boolean z;

    /* renamed from: androidx.fragment.app.h$a */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        View f805a;

        /* renamed from: b  reason: collision with root package name */
        Animator f806b;
        int c;
        int d;
        int e;
        int f;
        Object g = null;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Boolean m;
        Boolean n;
        i o;
        i p;
        boolean q;
        c r;
        boolean s;

        a() {
            Object obj = C0132h.f803a;
            this.h = obj;
            this.i = null;
            this.j = obj;
            this.k = null;
            this.l = obj;
            this.o = null;
            this.p = null;
        }
    }

    /* renamed from: androidx.fragment.app.h$b */
    public static class b extends RuntimeException {
        public b(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* renamed from: androidx.fragment.app.h$c */
    interface c {
        void a();

        void b();
    }

    public C0132h() {
        ia();
    }

    private a ha() {
        if (this.K == null) {
            this.K = new a();
        }
        return this.K;
    }

    private void ia() {
        this.Q = new n(this);
        this.T = androidx.savedstate.b.a((androidx.savedstate.c) this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.Q.a((k) new Fragment$1(this));
        }
    }

    public Object A() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.l;
        return obj == f803a ? z() : obj;
    }

    /* access modifiers changed from: package-private */
    public int B() {
        a aVar = this.K;
        if (aVar == null) {
            return 0;
        }
        return aVar.c;
    }

    public final C0132h C() {
        String str;
        C0132h hVar = this.h;
        if (hVar != null) {
            return hVar;
        }
        w wVar = this.r;
        if (wVar == null || (str = this.i) == null) {
            return null;
        }
        return wVar.k.get(str);
    }

    public View D() {
        return this.G;
    }

    /* access modifiers changed from: package-private */
    public void E() {
        ia();
        this.f = UUID.randomUUID().toString();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.q = 0;
        this.r = null;
        this.t = null;
        this.s = null;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = false;
        this.z = false;
    }

    /* access modifiers changed from: package-private */
    public void F() {
        if (this.s != null) {
            this.t = new w();
            this.t.a(this.s, (C0135k) new C0131g(this), this);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        a aVar = this.K;
        if (aVar == null) {
            return false;
        }
        return aVar.s;
    }

    /* access modifiers changed from: package-private */
    public final boolean H() {
        return this.q > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        a aVar = this.K;
        if (aVar == null) {
            return false;
        }
        return aVar.q;
    }

    public final boolean J() {
        w wVar = this.r;
        if (wVar == null) {
            return false;
        }
        return wVar.s();
    }

    /* access modifiers changed from: package-private */
    public void K() {
        w wVar = this.t;
        if (wVar != null) {
            wVar.t();
        }
    }

    public void L() {
        this.E = true;
    }

    public void M() {
    }

    public void N() {
        this.E = true;
    }

    public void O() {
        this.E = true;
    }

    public void P() {
        this.E = true;
    }

    public void Q() {
        this.E = true;
    }

    public void R() {
        this.E = true;
    }

    public void S() {
        this.E = true;
    }

    /* access modifiers changed from: package-private */
    public C0139o T() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public void U() {
        this.Q.b(h.a.ON_DESTROY);
        w wVar = this.t;
        if (wVar != null) {
            wVar.h();
        }
        this.f804b = 0;
        this.E = false;
        this.P = false;
        L();
        if (this.E) {
            this.t = null;
            return;
        }
        throw new U("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* access modifiers changed from: package-private */
    public void V() {
        if (this.G != null) {
            this.R.a(h.a.ON_DESTROY);
        }
        w wVar = this.t;
        if (wVar != null) {
            wVar.i();
        }
        this.f804b = 1;
        this.E = false;
        N();
        if (this.E) {
            a.k.a.a.a(this).a();
            this.p = false;
            return;
        }
        throw new U("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* access modifiers changed from: package-private */
    public void W() {
        this.E = false;
        O();
        this.O = null;
        if (this.E) {
            w wVar = this.t;
            if (wVar != null) {
                wVar.h();
                this.t = null;
                return;
            }
            return;
        }
        throw new U("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* access modifiers changed from: package-private */
    public void X() {
        onLowMemory();
        w wVar = this.t;
        if (wVar != null) {
            wVar.j();
        }
    }

    /* access modifiers changed from: package-private */
    public void Y() {
        if (this.G != null) {
            this.R.a(h.a.ON_PAUSE);
        }
        this.Q.b(h.a.ON_PAUSE);
        w wVar = this.t;
        if (wVar != null) {
            wVar.k();
        }
        this.f804b = 3;
        this.E = false;
        P();
        if (!this.E) {
            throw new U("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        w wVar = this.t;
        if (wVar != null) {
            wVar.t();
            this.t.p();
        }
        this.f804b = 4;
        this.E = false;
        Q();
        if (this.E) {
            w wVar2 = this.t;
            if (wVar2 != null) {
                wVar2.l();
                this.t.p();
            }
            this.Q.b(h.a.ON_RESUME);
            if (this.G != null) {
                this.R.a(h.a.ON_RESUME);
                return;
            }
            return;
        }
        throw new U("Fragment " + this + " did not call through to super.onResume()");
    }

    public Animation a(int i2, boolean z2, int i3) {
        return null;
    }

    public h a() {
        return this.Q;
    }

    public void a(int i2, int i3, Intent intent) {
    }

    public void a(int i2, String[] strArr, int[] iArr) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(C0132h hVar) {
    }

    public void a(boolean z2) {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void aa() {
        w wVar = this.t;
        if (wVar != null) {
            wVar.t();
            this.t.p();
        }
        this.f804b = 3;
        this.E = false;
        R();
        if (this.E) {
            w wVar2 = this.t;
            if (wVar2 != null) {
                wVar2.m();
            }
            this.Q.b(h.a.ON_START);
            if (this.G != null) {
                this.R.a(h.a.ON_START);
                return;
            }
            return;
        }
        throw new U("Fragment " + this + " did not call through to super.onStart()");
    }

    public Animator b(int i2, boolean z2, int i3) {
        return null;
    }

    public final androidx.savedstate.a b() {
        return this.T.a();
    }

    public void b(Menu menu) {
    }

    public void b(boolean z2) {
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void ba() {
        if (this.G != null) {
            this.R.a(h.a.ON_STOP);
        }
        this.Q.b(h.a.ON_STOP);
        w wVar = this.t;
        if (wVar != null) {
            wVar.n();
        }
        this.f804b = 2;
        this.E = false;
        S();
        if (!this.E) {
            throw new U("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public D c() {
        w wVar = this.r;
        if (wVar != null) {
            return wVar.g(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void c(boolean z2) {
    }

    public final C0134j ca() {
        C0134j f2 = f();
        if (f2 != null) {
            return f2;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public LayoutInflater d(Bundle bundle) {
        return a(bundle);
    }

    public final Context da() {
        Context m2 = m();
        if (m2 != null) {
            return m2;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a aVar = this.K;
        c cVar = null;
        if (aVar != null) {
            aVar.q = false;
            c cVar2 = aVar.r;
            aVar.r = null;
            cVar = cVar2;
        }
        if (cVar != null) {
            cVar.b();
        }
    }

    public void e(Bundle bundle) {
    }

    public final C0139o ea() {
        C0139o r2 = r();
        if (r2 != null) {
            return r2;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final C0134j f() {
        C0138n nVar = this.s;
        if (nVar == null) {
            return null;
        }
        return (C0134j) nVar.b();
    }

    public final View fa() {
        View D2 = D();
        if (D2 != null) {
            return D2;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public boolean g() {
        Boolean bool;
        a aVar = this.K;
        if (aVar == null || (bool = aVar.n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void ga() {
        w wVar = this.r;
        if (wVar == null || wVar.s == null) {
            ha().q = false;
        } else if (Looper.myLooper() != this.r.s.e().getLooper()) {
            this.r.s.e().postAtFrontOfQueue(new C0130f(this));
        } else {
            e();
        }
    }

    public boolean h() {
        Boolean bool;
        a aVar = this.K;
        if (aVar == null || (bool = aVar.m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater i(Bundle bundle) {
        this.O = d(bundle);
        return this.O;
    }

    /* access modifiers changed from: package-private */
    public void j(Bundle bundle) {
        Parcelable v2;
        e(bundle);
        this.T.b(bundle);
        w wVar = this.t;
        if (wVar != null && (v2 = wVar.v()) != null) {
            bundle.putParcelable("android:support:fragments", v2);
        }
    }

    public final Bundle k() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public final void l(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.d;
        if (sparseArray != null) {
            this.H.restoreHierarchyState(sparseArray);
            this.d = null;
        }
        this.E = false;
        f(bundle);
        if (!this.E) {
            throw new U("Fragment " + this + " did not call through to super.onViewStateRestored()");
        } else if (this.G != null) {
            this.R.a(h.a.ON_CREATE);
        }
    }

    public void m(Bundle bundle) {
        if (this.r == null || !J()) {
            this.g = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public Object n() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        return aVar.g;
    }

    /* access modifiers changed from: package-private */
    public i o() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        return aVar.o;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.E = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        ca().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.E = true;
    }

    public Object p() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        return aVar.i;
    }

    /* access modifiers changed from: package-private */
    public i q() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        return aVar.p;
    }

    public final C0139o r() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public int s() {
        a aVar = this.K;
        if (aVar == null) {
            return 0;
        }
        return aVar.d;
    }

    /* access modifiers changed from: package-private */
    public int t() {
        a aVar = this.K;
        if (aVar == null) {
            return 0;
        }
        return aVar.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        a.g.h.a.a(this, sb);
        sb.append(" (");
        sb.append(this.f);
        sb.append(")");
        if (this.v != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.v));
        }
        if (this.x != null) {
            sb.append(" ");
            sb.append(this.x);
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int u() {
        a aVar = this.K;
        if (aVar == null) {
            return 0;
        }
        return aVar.f;
    }

    public Object v() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.j;
        return obj == f803a ? p() : obj;
    }

    public final Resources w() {
        return da().getResources();
    }

    public final boolean x() {
        return this.A;
    }

    public Object y() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.h;
        return obj == f803a ? n() : obj;
    }

    public Object z() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        return aVar.k;
    }

    @Deprecated
    public static C0132h a(Context context, String str, Bundle bundle) {
        try {
            C0132h hVar = (C0132h) C0137m.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(hVar.getClass().getClassLoader());
                hVar.m(bundle);
            }
            return hVar;
        } catch (InstantiationException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (IllegalAccessException e3) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    public final CharSequence b(int i2) {
        return w().getText(i2);
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z2) {
        b(z2);
        w wVar = this.t;
        if (wVar != null) {
            wVar.a(z2);
        }
    }

    public void f(Bundle bundle) {
        this.E = true;
    }

    /* access modifiers changed from: package-private */
    public void k(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            if (this.t == null) {
                F();
            }
            this.t.a(parcelable);
            this.t.g();
        }
    }

    public void b(Bundle bundle) {
        this.E = true;
    }

    /* access modifiers changed from: package-private */
    public void f(boolean z2) {
        ha().s = z2;
    }

    /* access modifiers changed from: package-private */
    public void g(Bundle bundle) {
        w wVar = this.t;
        if (wVar != null) {
            wVar.t();
        }
        this.f804b = 2;
        this.E = false;
        b(bundle);
        if (this.E) {
            w wVar2 = this.t;
            if (wVar2 != null) {
                wVar2.f();
                return;
            }
            return;
        }
        throw new U("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    /* access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        w wVar = this.t;
        if (wVar != null) {
            wVar.t();
        }
        this.f804b = 1;
        this.E = false;
        this.T.a(bundle);
        c(bundle);
        this.P = true;
        if (this.E) {
            this.Q.b(h.a.ON_CREATE);
            return;
        }
        throw new U("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* access modifiers changed from: package-private */
    public C0132h b(String str) {
        if (str.equals(this.f)) {
            return this;
        }
        w wVar = this.t;
        if (wVar != null) {
            return wVar.b(str);
        }
        return null;
    }

    public void c(Bundle bundle) {
        this.E = true;
        k(bundle);
        w wVar = this.t;
        if (wVar != null && !wVar.c(1)) {
            this.t.g();
        }
    }

    /* access modifiers changed from: package-private */
    public View i() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        return aVar.f805a;
    }

    public Context m() {
        C0138n nVar = this.s;
        if (nVar == null) {
            return null;
        }
        return nVar.d();
    }

    /* access modifiers changed from: package-private */
    public boolean d(Menu menu) {
        boolean z2 = false;
        if (this.y) {
            return false;
        }
        if (this.C && this.D) {
            b(menu);
            z2 = true;
        }
        w wVar = this.t;
        return wVar != null ? z2 | wVar.b(menu) : z2;
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z2) {
        c(z2);
        w wVar = this.t;
        if (wVar != null) {
            wVar.b(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public Animator j() {
        a aVar = this.K;
        if (aVar == null) {
            return null;
        }
        return aVar.f806b;
    }

    /* access modifiers changed from: package-private */
    public void b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        w wVar = this.t;
        if (wVar != null) {
            wVar.t();
        }
        this.p = true;
        this.R = new T();
        this.G = a(layoutInflater, viewGroup, bundle);
        if (this.G != null) {
            this.R.c();
            this.S.a(this.R);
        } else if (!this.R.d()) {
            this.R = null;
        } else {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(MenuItem menuItem) {
        if (this.y) {
            return false;
        }
        if (a(menuItem)) {
            return true;
        }
        w wVar = this.t;
        if (wVar == null || !wVar.a(menuItem)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean d(MenuItem menuItem) {
        if (this.y) {
            return false;
        }
        if (this.C && this.D && b(menuItem)) {
            return true;
        }
        w wVar = this.t;
        if (wVar == null || !wVar.b(menuItem)) {
            return false;
        }
        return true;
    }

    public final C0139o l() {
        if (this.t == null) {
            F();
            int i2 = this.f804b;
            if (i2 >= 4) {
                this.t.l();
            } else if (i2 >= 3) {
                this.t.m();
            } else if (i2 >= 2) {
                this.t.f();
            } else if (i2 >= 1) {
                this.t.g();
            }
        }
        return this.t;
    }

    public final String a(int i2) {
        return w().getString(i2);
    }

    public final String a(int i2, Object... objArr) {
        return w().getString(i2, objArr);
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent) {
        a(intent, (Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public void c(Menu menu) {
        if (!this.y) {
            if (this.C && this.D) {
                a(menu);
            }
            w wVar = this.t;
            if (wVar != null) {
                wVar.a(menu);
            }
        }
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        C0138n nVar = this.s;
        if (nVar != null) {
            nVar.a(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        ha().c = i2;
    }

    @Deprecated
    public LayoutInflater a(Bundle bundle) {
        C0138n nVar = this.s;
        if (nVar != null) {
            LayoutInflater f2 = nVar.f();
            l();
            w wVar = this.t;
            wVar.q();
            C0041e.a(f2, wVar);
            return f2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z2 = false;
        if (this.y) {
            return false;
        }
        if (this.C && this.D) {
            a(menu, menuInflater);
            z2 = true;
        }
        w wVar = this.t;
        return wVar != null ? z2 | wVar.a(menu, menuInflater) : z2;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        if (this.K != null || i2 != 0) {
            ha().d = i2;
        }
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.E = true;
        C0138n nVar = this.s;
        Activity b2 = nVar == null ? null : nVar.b();
        if (b2 != null) {
            this.E = false;
            a(b2, attributeSet, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        ha().f805a = view;
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.E = true;
    }

    public void a(Context context) {
        this.E = true;
        C0138n nVar = this.s;
        Activity b2 = nVar == null ? null : nVar.b();
        if (b2 != null) {
            this.E = false;
            a(b2);
        }
    }

    @Deprecated
    public void a(Activity activity) {
        this.E = true;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.U;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void a(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.v));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.w));
        printWriter.print(" mTag=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f804b);
        printWriter.print(" mWho=");
        printWriter.print(this.f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.k);
        printWriter.print(" mRemoving=");
        printWriter.print(this.l);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.m);
        printWriter.print(" mInLayout=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.y);
        printWriter.print(" mDetached=");
        printWriter.print(this.z);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.D);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.C);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.A);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.J);
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.r);
        }
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.s);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.u);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.g);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.c);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.d);
        }
        C0132h C2 = C();
        if (C2 != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(C2);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.j);
        }
        if (s() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(s());
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.F);
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.G);
        }
        if (i() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(i());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(B());
        }
        if (m() != null) {
            a.k.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.t + ":");
            w wVar = this.t;
            wVar.a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        w wVar = this.t;
        if (wVar != null) {
            wVar.a(configuration);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        ha();
        c cVar2 = this.K.r;
        if (cVar != cVar2) {
            if (cVar == null || cVar2 == null) {
                a aVar = this.K;
                if (aVar.q) {
                    aVar.r = cVar;
                }
                if (cVar != null) {
                    cVar.a();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        if (this.K != null || i2 != 0 || i3 != 0) {
            ha();
            a aVar = this.K;
            aVar.e = i2;
            aVar.f = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Animator animator) {
        ha().f806b = animator;
    }
}
