package androidx.recyclerview.widget;

import a.g.i.C0037a;
import a.g.i.C0045i;
import a.g.i.a.c;
import a.g.i.y;
import a.g.i.z;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.O;
import androidx.recyclerview.widget.q;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public class RecyclerView extends ViewGroup implements a.g.i.s, C0045i, a.g.i.j {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f908a = {16843830};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f909b = {16842987};
    static final boolean c;
    static final boolean d = (Build.VERSION.SDK_INT >= 23);
    static final boolean e = (Build.VERSION.SDK_INT >= 16);
    static final boolean f = (Build.VERSION.SDK_INT >= 21);
    private static final boolean g = (Build.VERSION.SDK_INT <= 15);
    private static final boolean h = (Build.VERSION.SDK_INT <= 15);
    private static final Class<?>[] i;
    static final Interpolator j = new A();
    private m A;
    private final int[] Aa;
    boolean B;
    private a.g.i.l Ba;
    boolean C;
    private final int[] Ca;
    boolean D;
    private final int[] Da;
    boolean E;
    final int[] Ea;
    private int F;
    final List<x> Fa;
    boolean G;
    private Runnable Ga;
    boolean H;
    private final O.b Ha;
    private boolean I;
    private int J;
    boolean K;
    private final AccessibilityManager L;
    private List<k> M;
    boolean N;
    boolean O;
    private int P;
    private int Q;
    private e R;
    private EdgeEffect S;
    private EdgeEffect T;
    private EdgeEffect U;
    private EdgeEffect V;
    f W;
    private int aa;
    private int ba;
    private VelocityTracker ca;
    private int da;
    private int ea;
    private int fa;
    private int ga;
    private int ha;
    private l ia;
    private final int ja;
    private final r k;
    private final int ka;
    final p l;
    private float la;
    private s m;
    private float ma;
    C0150a n;
    private boolean na;
    C0151b o;
    final w oa;
    final O p;
    q pa;
    boolean q;
    q.a qa;
    final Runnable r;
    final u ra;
    final Rect s;
    private n sa;
    private final Rect t;
    private List<n> ta;
    final RectF u;
    boolean ua;
    a v;
    boolean va;
    i w;
    private f.b wa;
    q x;
    boolean xa;
    final ArrayList<h> y;
    H ya;
    private final ArrayList<m> z;
    private d za;

    public static abstract class a<VH extends x> {

        /* renamed from: a  reason: collision with root package name */
        private final b f910a = new b();

        /* renamed from: b  reason: collision with root package name */
        private boolean f911b = false;

        public abstract int a();

        public long a(int i) {
            return -1;
        }

        public void a(VH vh, int i, List<Object> list) {
            b(vh, i);
        }

        public void a(RecyclerView recyclerView) {
        }

        public boolean a(VH vh) {
            return false;
        }

        public int b(int i) {
            return 0;
        }

        public abstract VH b(ViewGroup viewGroup, int i);

        public void b(VH vh) {
        }

        public abstract void b(VH vh, int i);

        public void b(RecyclerView recyclerView) {
        }

        public final boolean b() {
            return this.f911b;
        }

        public final void c() {
            this.f910a.a();
        }

        public void c(VH vh) {
        }

        public final void d(int i) {
            this.f910a.b(i, 1);
        }

        public void d(VH vh) {
        }

        public final VH a(ViewGroup viewGroup, int i) {
            try {
                a.g.e.a.a("RV CreateView");
                VH b2 = b(viewGroup, i);
                if (b2.f936b.getParent() == null) {
                    b2.g = i;
                    return b2;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                a.g.e.a.a();
            }
        }

        public void b(c cVar) {
            this.f910a.unregisterObserver(cVar);
        }

        public final void c(int i) {
            this.f910a.a(i, 1);
        }

        public final void a(VH vh, int i) {
            vh.d = i;
            if (b()) {
                vh.f = a(i);
            }
            vh.a(1, 519);
            a.g.e.a.a("RV OnBindView");
            a(vh, i, vh.k());
            vh.b();
            ViewGroup.LayoutParams layoutParams = vh.f936b.getLayoutParams();
            if (layoutParams instanceof j) {
                ((j) layoutParams).c = true;
            }
            a.g.e.a.a();
        }

        public void a(c cVar) {
            this.f910a.registerObserver(cVar);
        }

        public final void a(int i, Object obj) {
            this.f910a.a(i, 1, obj);
        }
    }

    public static abstract class c {
        public void a() {
        }

        public void a(int i, int i2) {
        }

        public void a(int i, int i2, Object obj) {
            a(i, i2);
        }

        public void b(int i, int i2) {
        }
    }

    public interface d {
        int a(int i, int i2);
    }

    public static class e {
        /* access modifiers changed from: protected */
        public EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        private b f912a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f913b = new ArrayList<>();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(x xVar);
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f914a;

            /* renamed from: b  reason: collision with root package name */
            public int f915b;
            public int c;
            public int d;

            public c a(x xVar) {
                a(xVar, 0);
                return this;
            }

            public c a(x xVar, int i) {
                View view = xVar.f936b;
                this.f914a = view.getLeft();
                this.f915b = view.getTop();
                this.c = view.getRight();
                this.d = view.getBottom();
                return this;
            }
        }

        public void a(long j) {
            this.f = j;
        }

        public abstract boolean a(x xVar, c cVar, c cVar2);

        public abstract boolean a(x xVar, x xVar2, c cVar, c cVar2);

        public abstract void b();

        public abstract boolean b(x xVar);

        public abstract boolean b(x xVar, c cVar, c cVar2);

        public long c() {
            return this.c;
        }

        public abstract boolean c(x xVar, c cVar, c cVar2);

        public long d() {
            return this.f;
        }

        public abstract void d(x xVar);

        public long e() {
            return this.e;
        }

        public void e(x xVar) {
        }

        public long f() {
            return this.d;
        }

        public abstract boolean g();

        public c h() {
            return new c();
        }

        public abstract void i();

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f912a = bVar;
        }

        public final void c(x xVar) {
            e(xVar);
            b bVar = this.f912a;
            if (bVar != null) {
                bVar.a(xVar);
            }
        }

        public c a(u uVar, x xVar, int i, List<Object> list) {
            c h = h();
            h.a(xVar);
            return h;
        }

        public c a(u uVar, x xVar) {
            c h = h();
            h.a(xVar);
            return h;
        }

        static int a(x xVar) {
            int i = xVar.k & 14;
            if (xVar.o()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int j = xVar.j();
            int f2 = xVar.f();
            return (j == -1 || f2 == -1 || j == f2) ? i : i | 2048;
        }

        public boolean a(x xVar, List<Object> list) {
            return b(xVar);
        }

        public final void a() {
            int size = this.f913b.size();
            for (int i = 0; i < size; i++) {
                this.f913b.get(i).a();
            }
            this.f913b.clear();
        }
    }

    private class g implements f.b {
        g() {
        }

        public void a(x xVar) {
            xVar.a(true);
            if (xVar.i != null && xVar.j == null) {
                xVar.i = null;
            }
            xVar.j = null;
            if (!xVar.x() && !RecyclerView.this.k(xVar.f936b) && xVar.s()) {
                RecyclerView.this.removeDetachedView(xVar.f936b, false);
            }
        }
    }

    public static abstract class h {
        @Deprecated
        public void a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void a(Canvas canvas, RecyclerView recyclerView, u uVar) {
            a(canvas, recyclerView);
        }

        @Deprecated
        public void b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void b(Canvas canvas, RecyclerView recyclerView, u uVar) {
            b(canvas, recyclerView);
        }

        @Deprecated
        public void a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void a(Rect rect, View view, RecyclerView recyclerView, u uVar) {
            a(rect, ((j) view.getLayoutParams()).a(), recyclerView);
        }
    }

    public static abstract class i {

        /* renamed from: a  reason: collision with root package name */
        C0151b f917a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView f918b;
        private final N.b c = new E(this);
        private final N.b d = new F(this);
        N e = new N(this.c);
        N f = new N(this.d);
        t g;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        private boolean k = true;
        private boolean l = true;
        int m;
        boolean n;
        private int o;
        private int p;
        private int q;
        private int r;

        public interface a {
            void a(int i, int i2);
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f919a;

            /* renamed from: b  reason: collision with root package name */
            public int f920b;
            public boolean c;
            public boolean d;
        }

        /* access modifiers changed from: package-private */
        public boolean A() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void B() {
            t tVar = this.g;
            if (tVar != null) {
                tVar.d();
            }
        }

        public boolean C() {
            return false;
        }

        public int a(int i2, p pVar, u uVar) {
            return 0;
        }

        public int a(u uVar) {
            return 0;
        }

        public View a(View view, int i2, p pVar, u uVar) {
            return null;
        }

        public void a(int i2, int i3, u uVar, a aVar) {
        }

        public void a(int i2, a aVar) {
        }

        public void a(Rect rect, int i2, int i3) {
            c(a(i2, rect.width() + n() + o(), l()), a(i3, rect.height() + p() + m(), k()));
        }

        public void a(Parcelable parcelable) {
        }

        public void a(a aVar, a aVar2) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(j jVar) {
            return jVar != null;
        }

        public boolean a(p pVar, u uVar, View view, int i2, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        public int b(int i2, p pVar, u uVar) {
            return 0;
        }

        public int b(u uVar) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            this.q = View.MeasureSpec.getSize(i2);
            this.o = View.MeasureSpec.getMode(i2);
            if (this.o == 0 && !RecyclerView.d) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i3);
            this.p = View.MeasureSpec.getMode(i3);
            if (this.p == 0 && !RecyclerView.d) {
                this.r = 0;
            }
        }

        public void b(RecyclerView recyclerView) {
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
        }

        public boolean b() {
            return false;
        }

        public int c(p pVar, u uVar) {
            return 0;
        }

        public int c(u uVar) {
            return 0;
        }

        public View c(View view) {
            View c2;
            RecyclerView recyclerView = this.f918b;
            if (recyclerView == null || (c2 = recyclerView.c(view)) == null || this.f917a.c(c2)) {
                return null;
            }
            return c2;
        }

        public abstract j c();

        @Deprecated
        public void c(RecyclerView recyclerView) {
        }

        public void c(RecyclerView recyclerView, int i2, int i3) {
        }

        public int d() {
            return -1;
        }

        public int d(u uVar) {
            return 0;
        }

        public View d(View view, int i2) {
            return null;
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, int i3) {
            int e2 = e();
            if (e2 == 0) {
                this.f918b.c(i2, i3);
                return;
            }
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            for (int i8 = 0; i8 < e2; i8++) {
                View c2 = c(i8);
                Rect rect = this.f918b.s;
                b(c2, rect);
                int i9 = rect.left;
                if (i9 < i4) {
                    i4 = i9;
                }
                int i10 = rect.right;
                if (i10 > i6) {
                    i6 = i10;
                }
                int i11 = rect.top;
                if (i11 < i5) {
                    i5 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i7) {
                    i7 = i12;
                }
            }
            this.f918b.s.set(i4, i5, i6, i7);
            a(this.f918b.s, i2, i3);
        }

        public void d(RecyclerView recyclerView) {
        }

        public boolean d(p pVar, u uVar) {
            return false;
        }

        public int e(u uVar) {
            return 0;
        }

        public void e(p pVar, u uVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int f(u uVar) {
            return 0;
        }

        public void f(int i2) {
        }

        /* access modifiers changed from: package-private */
        public void f(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f918b = null;
                this.f917a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.f918b = recyclerView;
                this.f917a = recyclerView.o;
                this.q = recyclerView.getWidth();
                this.r = recyclerView.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public void g(int i2) {
            if (c(i2) != null) {
                this.f917a.e(i2);
            }
        }

        public void g(u uVar) {
        }

        public int h() {
            return this.r;
        }

        public int i() {
            return this.p;
        }

        public int j() {
            return y.m(this.f918b);
        }

        public int k(View view) {
            return ((j) view.getLayoutParams()).f922b.left;
        }

        public int l(View view) {
            return ((j) view.getLayoutParams()).a();
        }

        public int m() {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int n() {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void o(View view) {
            this.f917a.d(view);
        }

        public int p() {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int q() {
            return this.q;
        }

        public int r() {
            return this.o;
        }

        /* access modifiers changed from: package-private */
        public boolean s() {
            int e2 = e();
            for (int i2 = 0; i2 < e2; i2++) {
                ViewGroup.LayoutParams layoutParams = c(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean t() {
            return this.i;
        }

        public boolean u() {
            return this.j;
        }

        public final boolean v() {
            return this.l;
        }

        public boolean w() {
            t tVar = this.g;
            return tVar != null && tVar.c();
        }

        public Parcelable x() {
            return null;
        }

        public void y() {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void z() {
            this.h = true;
        }

        public int e() {
            C0151b bVar = this.f917a;
            if (bVar != null) {
                return bVar.a();
            }
            return 0;
        }

        public int h(View view) {
            Rect rect = ((j) view.getLayoutParams()).f922b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int i(View view) {
            return view.getRight() + m(view);
        }

        public int j(View view) {
            return view.getTop() - n(view);
        }

        public int k() {
            return y.n(this.f918b);
        }

        public int l() {
            return y.o(this.f918b);
        }

        public int m(View view) {
            return ((j) view.getLayoutParams()).f922b.right;
        }

        public int n(View view) {
            return ((j) view.getLayoutParams()).f922b.top;
        }

        public int o() {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void e(int i2) {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null) {
                recyclerView.d(i2);
            }
        }

        public View g() {
            View focusedChild;
            RecyclerView recyclerView = this.f918b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f917a.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void c(View view, int i2) {
            a(view, i2, (j) view.getLayoutParams());
        }

        public View c(int i2) {
            C0151b bVar = this.f917a;
            if (bVar != null) {
                return bVar.c(i2);
            }
            return null;
        }

        public int e(View view) {
            return view.getBottom() + d(view);
        }

        public static int a(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        /* access modifiers changed from: package-private */
        public void c(p pVar) {
            int e2 = pVar.e();
            for (int i2 = e2 - 1; i2 >= 0; i2--) {
                View c2 = pVar.c(i2);
                x g2 = RecyclerView.g(c2);
                if (!g2.y()) {
                    g2.a(false);
                    if (g2.s()) {
                        this.f918b.removeDetachedView(c2, false);
                    }
                    f fVar = this.f918b.W;
                    if (fVar != null) {
                        fVar.d(g2);
                    }
                    g2.a(true);
                    pVar.a(c2);
                }
            }
            pVar.c();
            if (e2 > 0) {
                this.f918b.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public void e(RecyclerView recyclerView) {
            b(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int g(View view) {
            Rect rect = ((j) view.getLayoutParams()).f922b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void b(RecyclerView recyclerView, p pVar) {
            c(recyclerView);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i2) {
            a(view, i2, false);
        }

        public boolean f() {
            RecyclerView recyclerView = this.f918b;
            return recyclerView != null && recyclerView.q;
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView) {
            this.i = true;
            b(recyclerView);
        }

        public View b(int i2) {
            int e2 = e();
            for (int i3 = 0; i3 < e2; i3++) {
                View c2 = c(i3);
                x g2 = RecyclerView.g(c2);
                if (g2 != null && g2.i() == i2 && !g2.y() && (this.f918b.ra.d() || !g2.q())) {
                    return c2;
                }
            }
            return null;
        }

        public void d(int i2) {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null) {
                recyclerView.c(i2);
            }
        }

        public int f(View view) {
            return view.getLeft() - k(view);
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, p pVar) {
            this.i = false;
            b(recyclerView, pVar);
        }

        public int d(View view) {
            return ((j) view.getLayoutParams()).f922b.bottom;
        }

        private boolean d(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int n2 = n();
            int p2 = p();
            int q2 = q() - o();
            int h2 = h() - m();
            Rect rect = this.f918b.s;
            b(focusedChild, rect);
            if (rect.left - i2 >= q2 || rect.right - i2 <= n2 || rect.top - i3 >= h2 || rect.bottom - i3 <= p2) {
                return false;
            }
            return true;
        }

        public boolean a(Runnable runnable) {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, int i2, int i3, j jVar) {
            return !this.k || !b(view.getMeasuredWidth(), i2, jVar.width) || !b(view.getMeasuredHeight(), i3, jVar.height);
        }

        public j a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof j) {
                return new j((j) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new j((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new j(layoutParams);
        }

        private int[] c(View view, Rect rect) {
            int[] iArr = new int[2];
            int n2 = n();
            int p2 = p();
            int q2 = q() - o();
            int h2 = h() - m();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i2 = left - n2;
            int min = Math.min(0, i2);
            int i3 = top - p2;
            int min2 = Math.min(0, i3);
            int i4 = width - q2;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height - h2);
            if (j() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private static boolean b(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        public void b(View view, Rect rect) {
            RecyclerView.b(view, rect);
        }

        public j a(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public void b(p pVar) {
            for (int e2 = e() - 1; e2 >= 0; e2--) {
                if (!RecyclerView.g(c(e2)).y()) {
                    a(e2, pVar);
                }
            }
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i2) {
            a(view, i2, true);
        }

        private void a(View view, int i2, boolean z) {
            x g2 = RecyclerView.g(view);
            if (z || g2.q()) {
                this.f918b.p.a(g2);
            } else {
                this.f918b.p.g(g2);
            }
            j jVar = (j) view.getLayoutParams();
            if (g2.A() || g2.r()) {
                if (g2.r()) {
                    g2.z();
                } else {
                    g2.c();
                }
                this.f917a.a(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f918b) {
                int b2 = this.f917a.b(view);
                if (i2 == -1) {
                    i2 = this.f917a.a();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f918b.indexOfChild(view) + this.f918b.i());
                } else if (b2 != i2) {
                    this.f918b.w.a(b2, i2);
                }
            } else {
                this.f917a.a(view, i2, false);
                jVar.c = true;
                t tVar = this.g;
                if (tVar != null && tVar.c()) {
                    this.g.a(view);
                }
            }
            if (jVar.d) {
                g2.f936b.invalidate();
                jVar.d = false;
            }
        }

        public int b(p pVar, u uVar) {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView == null || recyclerView.v == null || !b()) {
                return 1;
            }
            return this.f918b.v.a();
        }

        public void c(int i2, int i3) {
            this.f918b.setMeasuredDimension(i2, i3);
        }

        public void a(int i2) {
            a(i2, c(i2));
        }

        private void a(int i2, View view) {
            this.f917a.a(i2);
        }

        public void a(View view, int i2, j jVar) {
            x g2 = RecyclerView.g(view);
            if (g2.q()) {
                this.f918b.p.a(g2);
            } else {
                this.f918b.p.g(g2);
            }
            this.f917a.a(view, i2, jVar, g2.q());
        }

        public void a(int i2, int i3) {
            View c2 = c(i2);
            if (c2 != null) {
                a(i2);
                c(c2, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.f918b.toString());
        }

        public void a(View view, p pVar) {
            o(view);
            pVar.b(view);
        }

        public void a(int i2, p pVar) {
            View c2 = c(i2);
            g(i2);
            pVar.b(c2);
        }

        public void a(p pVar) {
            for (int e2 = e() - 1; e2 >= 0; e2--) {
                a(pVar, e2, c(e2));
            }
        }

        private void a(p pVar, int i2, View view) {
            x g2 = RecyclerView.g(view);
            if (!g2.y()) {
                if (!g2.o() || g2.q() || this.f918b.v.b()) {
                    a(i2);
                    pVar.c(view);
                    this.f918b.p.d(g2);
                    return;
                }
                g(i2);
                pVar.b(g2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i2, int i3, j jVar) {
            return view.isLayoutRequested() || !this.k || !b(view.getWidth(), i2, jVar.width) || !b(view.getHeight(), i3, jVar.height);
        }

        public void a(View view, int i2, int i3) {
            j jVar = (j) view.getLayoutParams();
            Rect h2 = this.f918b.h(view);
            int i4 = i2 + h2.left + h2.right;
            int i5 = i3 + h2.top + h2.bottom;
            int a2 = a(q(), r(), n() + o() + jVar.leftMargin + jVar.rightMargin + i4, jVar.width, a());
            int a3 = a(h(), i(), p() + m() + jVar.topMargin + jVar.bottomMargin + i5, jVar.height, b());
            if (a(view, a2, a3, jVar)) {
                view.measure(a2, a3);
            }
        }

        public static int a(int i2, int i3, int i4, int i5, boolean z) {
            int i6;
            int i7 = i2 - i4;
            int i8 = 0;
            int max = Math.max(0, i7);
            if (z) {
                if (i5 < 0) {
                    if (i5 == -1) {
                        if (i3 == Integer.MIN_VALUE || (i3 != 0 && i3 == 1073741824)) {
                            i6 = max;
                        } else {
                            i3 = 0;
                            i6 = 0;
                        }
                        i8 = i3;
                        max = i6;
                        return View.MeasureSpec.makeMeasureSpec(max, i8);
                    }
                    max = 0;
                    return View.MeasureSpec.makeMeasureSpec(max, i8);
                }
            } else if (i5 < 0) {
                if (i5 == -1) {
                    i8 = i3;
                } else {
                    if (i5 == -2) {
                        if (i3 == Integer.MIN_VALUE || i3 == 1073741824) {
                            i8 = Integer.MIN_VALUE;
                        }
                    }
                    max = 0;
                }
                return View.MeasureSpec.makeMeasureSpec(max, i8);
            }
            max = i5;
            i8 = 1073741824;
            return View.MeasureSpec.makeMeasureSpec(max, i8);
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            j jVar = (j) view.getLayoutParams();
            Rect rect = jVar.f922b;
            view.layout(i2 + rect.left + jVar.leftMargin, i3 + rect.top + jVar.topMargin, (i4 - rect.right) - jVar.rightMargin, (i5 - rect.bottom) - jVar.bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((j) view.getLayoutParams()).f922b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f918b == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f918b.u;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.h(view));
            }
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] c2 = c(view, rect);
            int i2 = c2[0];
            int i3 = c2[1];
            if ((z2 && !d(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.i(i2, i3);
            }
            return true;
        }

        public boolean a(View view, boolean z, boolean z2) {
            boolean z3 = this.e.a(view, 24579) && this.f.a(view, 24579);
            return z ? z3 : !z3;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return w() || recyclerView.n();
        }

        public boolean a(RecyclerView recyclerView, u uVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
            c(recyclerView, i2, i3);
        }

        public void a(p pVar, u uVar, int i2, int i3) {
            this.f918b.c(i2, i3);
        }

        /* access modifiers changed from: package-private */
        public void a(a.g.i.a.c cVar) {
            RecyclerView recyclerView = this.f918b;
            a(recyclerView.l, recyclerView.ra, cVar);
        }

        public void a(p pVar, u uVar, a.g.i.a.c cVar) {
            if (this.f918b.canScrollVertically(-1) || this.f918b.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.k(true);
            }
            if (this.f918b.canScrollVertically(1) || this.f918b.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.k(true);
            }
            cVar.a((Object) c.b.a(b(pVar, uVar), a(pVar, uVar), d(pVar, uVar), c(pVar, uVar)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f918b;
            a(recyclerView.l, recyclerView.ra, accessibilityEvent);
        }

        public void a(p pVar, u uVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.f918b.canScrollVertically(-1) && !this.f918b.canScrollHorizontally(-1) && !this.f918b.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                a aVar = this.f918b.v;
                if (aVar != null) {
                    accessibilityEvent.setItemCount(aVar.a());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(View view, a.g.i.a.c cVar) {
            x g2 = RecyclerView.g(view);
            if (g2 != null && !g2.q() && !this.f917a.c(g2.f936b)) {
                RecyclerView recyclerView = this.f918b;
                a(recyclerView.l, recyclerView.ra, view, cVar);
            }
        }

        public void a(p pVar, u uVar, View view, a.g.i.a.c cVar) {
            cVar.b((Object) c.C0009c.a(b() ? l(view) : 0, 1, a() ? l(view) : 0, 1, false, false));
        }

        public int a(p pVar, u uVar) {
            RecyclerView recyclerView = this.f918b;
            if (recyclerView == null || recyclerView.v == null || !a()) {
                return 1;
            }
            return this.f918b.v.a();
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f918b;
            return a(recyclerView.l, recyclerView.ra, i2, bundle);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(androidx.recyclerview.widget.RecyclerView.p r2, androidx.recyclerview.widget.RecyclerView.u r3, int r4, android.os.Bundle r5) {
            /*
                r1 = this;
                androidx.recyclerview.widget.RecyclerView r2 = r1.f918b
                r3 = 0
                if (r2 != 0) goto L_0x0006
                return r3
            L_0x0006:
                r5 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r4 == r5) goto L_0x0042
                r5 = 8192(0x2000, float:1.14794E-41)
                if (r4 == r5) goto L_0x0012
                r2 = 0
            L_0x0010:
                r4 = 0
                goto L_0x006e
            L_0x0012:
                r4 = -1
                boolean r2 = r2.canScrollVertically(r4)
                if (r2 == 0) goto L_0x0029
                int r2 = r1.h()
                int r5 = r1.p()
                int r2 = r2 - r5
                int r5 = r1.m()
                int r2 = r2 - r5
                int r2 = -r2
                goto L_0x002a
            L_0x0029:
                r2 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r5 = r1.f918b
                boolean r4 = r5.canScrollHorizontally(r4)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
                int r4 = -r4
                goto L_0x006e
            L_0x0042:
                boolean r2 = r2.canScrollVertically(r0)
                if (r2 == 0) goto L_0x0057
                int r2 = r1.h()
                int r4 = r1.p()
                int r2 = r2 - r4
                int r4 = r1.m()
                int r2 = r2 - r4
                goto L_0x0058
            L_0x0057:
                r2 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r4 = r1.f918b
                boolean r4 = r4.canScrollHorizontally(r0)
                if (r4 == 0) goto L_0x0010
                int r4 = r1.q()
                int r5 = r1.n()
                int r4 = r4 - r5
                int r5 = r1.o()
                int r4 = r4 - r5
            L_0x006e:
                if (r2 != 0) goto L_0x0073
                if (r4 != 0) goto L_0x0073
                return r3
            L_0x0073:
                androidx.recyclerview.widget.RecyclerView r3 = r1.f918b
                r3.i(r4, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i.a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u, int, android.os.Bundle):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i2, Bundle bundle) {
            RecyclerView recyclerView = this.f918b;
            return a(recyclerView.l, recyclerView.ra, view, i2, bundle);
        }

        public static b a(Context context, AttributeSet attributeSet, int i2, int i3) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.m.b.RecyclerView, i2, i3);
            bVar.f919a = obtainStyledAttributes.getInt(a.m.b.RecyclerView_android_orientation, 1);
            bVar.f920b = obtainStyledAttributes.getInt(a.m.b.RecyclerView_spanCount, 1);
            bVar.c = obtainStyledAttributes.getBoolean(a.m.b.RecyclerView_reverseLayout, false);
            bVar.d = obtainStyledAttributes.getBoolean(a.m.b.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }
    }

    public interface k {
        void a(View view);

        void b(View view);
    }

    public static abstract class l {
        public abstract boolean a(int i, int i2);
    }

    public interface m {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        void a(boolean z);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class n {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public final class p {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<x> f927a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        ArrayList<x> f928b = null;
        final ArrayList<x> c = new ArrayList<>();
        private final List<x> d = Collections.unmodifiableList(this.f927a);
        private int e = 2;
        int f = 2;
        o g;
        private v h;

        public p() {
        }

        private void e(x xVar) {
            if (RecyclerView.this.m()) {
                View view = xVar.f936b;
                if (y.k(view) == 0) {
                    y.d(view, 1);
                }
                C0037a b2 = y.b(view);
                if (b2 == null || b2.getClass().equals(C0037a.class)) {
                    xVar.a(16384);
                    y.a(view, RecyclerView.this.ya.b());
                }
            }
        }

        public void a() {
            this.f927a.clear();
            i();
        }

        /* access modifiers changed from: package-private */
        public View b(int i2, boolean z) {
            return a(i2, z, Long.MAX_VALUE).f936b;
        }

        /* access modifiers changed from: package-private */
        public void c(View view) {
            x g2 = RecyclerView.g(view);
            if (!g2.b(12) && g2.t() && !RecyclerView.this.a(g2)) {
                if (this.f928b == null) {
                    this.f928b = new ArrayList<>();
                }
                g2.a(this, true);
                this.f928b.add(g2);
            } else if (!g2.o() || g2.q() || RecyclerView.this.v.b()) {
                g2.a(this, false);
                this.f927a.add(g2);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.i());
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(x xVar) {
            if (xVar.q()) {
                return RecyclerView.this.ra.d();
            }
            int i2 = xVar.d;
            if (i2 < 0 || i2 >= RecyclerView.this.v.a()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + xVar + RecyclerView.this.i());
            } else if (!RecyclerView.this.ra.d() && RecyclerView.this.v.b(xVar.d) != xVar.h()) {
                return false;
            } else {
                if (!RecyclerView.this.v.b() || xVar.g() == RecyclerView.this.v.a(xVar.d)) {
                    return true;
                }
                return false;
            }
        }

        public void f(int i2) {
            this.e = i2;
            j();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                j jVar = (j) this.c.get(i2).f936b.getLayoutParams();
                if (jVar != null) {
                    jVar.c = true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = this.c.get(i2);
                if (xVar != null) {
                    xVar.a(6);
                    xVar.a((Object) null);
                }
            }
            a aVar = RecyclerView.this.v;
            if (aVar == null || !aVar.b()) {
                i();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                e(size);
            }
            this.c.clear();
            if (RecyclerView.f) {
                RecyclerView.this.qa.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            i iVar = RecyclerView.this.w;
            this.f = this.e + (iVar != null ? iVar.m : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                e(size);
            }
        }

        public void b(View view) {
            x g2 = RecyclerView.g(view);
            if (g2.s()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (g2.r()) {
                g2.z();
            } else if (g2.A()) {
                g2.c();
            }
            b(g2);
            if (RecyclerView.this.W != null && !g2.p()) {
                RecyclerView.this.W.d(g2);
            }
        }

        private boolean a(x xVar, int i2, int i3, long j) {
            xVar.s = RecyclerView.this;
            int h2 = xVar.h();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.g.a(h2, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.v.a(xVar, i2);
            this.g.a(xVar.h(), RecyclerView.this.getNanoTime() - nanoTime);
            e(xVar);
            if (!RecyclerView.this.ra.d()) {
                return true;
            }
            xVar.h = i3;
            return true;
        }

        public List<x> f() {
            return this.d;
        }

        private void f(x xVar) {
            View view = xVar.f936b;
            if (view instanceof ViewGroup) {
                a((ViewGroup) view, false);
            }
        }

        public View d(int i2) {
            return b(i2, false);
        }

        /* access modifiers changed from: package-private */
        public void e(int i2) {
            a(this.c.get(i2), true);
            this.c.remove(i2);
        }

        /* access modifiers changed from: package-private */
        public void b(x xVar) {
            boolean z;
            boolean z2 = false;
            if (xVar.r() || xVar.f936b.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(xVar.r());
                sb.append(" isAttached:");
                if (xVar.f936b.getParent() != null) {
                    z2 = true;
                }
                sb.append(z2);
                sb.append(RecyclerView.this.i());
                throw new IllegalArgumentException(sb.toString());
            } else if (xVar.s()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + xVar + RecyclerView.this.i());
            } else if (!xVar.y()) {
                boolean e2 = xVar.e();
                a aVar = RecyclerView.this.v;
                if ((aVar != null && e2 && aVar.a(xVar)) || xVar.p()) {
                    if (this.f <= 0 || xVar.b(526)) {
                        z = false;
                    } else {
                        int size = this.c.size();
                        if (size >= this.f && size > 0) {
                            e(0);
                            size--;
                        }
                        if (RecyclerView.f && size > 0 && !RecyclerView.this.qa.a(xVar.d)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.qa.a(this.c.get(i2).d)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.c.add(size, xVar);
                        z = true;
                    }
                    if (!z) {
                        a(xVar, true);
                        z2 = true;
                    }
                } else {
                    z = false;
                }
                RecyclerView.this.p.h(xVar);
                if (!z && !z2 && e2) {
                    xVar.s = null;
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.i());
            }
        }

        /* access modifiers changed from: package-private */
        public o d() {
            if (this.g == null) {
                this.g = new o();
            }
            return this.g;
        }

        /* access modifiers changed from: package-private */
        public void c(x xVar) {
            if (xVar.p) {
                this.f928b.remove(xVar);
            } else {
                this.f927a.remove(xVar);
            }
            xVar.o = null;
            xVar.p = false;
            xVar.c();
        }

        public int a(int i2) {
            if (i2 < 0 || i2 >= RecyclerView.this.ra.a()) {
                throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.ra.a() + RecyclerView.this.i());
            } else if (!RecyclerView.this.ra.d()) {
                return i2;
            } else {
                return RecyclerView.this.n.b(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.f927a.size();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01a1  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01ca  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01cd  */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x01fd  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x020b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.x a(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x022e
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r1 = r1.ra
                int r1 = r1.a()
                if (r3 >= r1) goto L_0x022e
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r1 = r1.ra
                boolean r1 = r1.d()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$x r1 = r16.b((int) r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$x r1 = r16.a((int) r17, (boolean) r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.d((androidx.recyclerview.widget.RecyclerView.x) r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.a((int) r5)
                boolean r5 = r1.r()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.f936b
                r5.removeDetachedView(r9, r8)
                r1.z()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.A()
                if (r5 == 0) goto L_0x0057
                r1.c()
            L_0x0057:
                r6.b((androidx.recyclerview.widget.RecyclerView.x) r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0180
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.n
                int r5 = r5.b((int) r3)
                if (r5 < 0) goto L_0x0148
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.v
                int r9 = r9.a()
                if (r5 >= r9) goto L_0x0148
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r9 = r9.v
                int r9 = r9.b((int) r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r10 = r10.v
                boolean r10 = r10.b()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r1 = r1.v
                long r10 = r1.a((int) r5)
                androidx.recyclerview.widget.RecyclerView$x r1 = r6.a((long) r10, (int) r9, (boolean) r0)
                if (r1 == 0) goto L_0x0096
                r1.d = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$v r0 = r6.h
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.a(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$x r1 = r1.f((android.view.View) r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.y()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                if (r1 != 0) goto L_0x0101
                androidx.recyclerview.widget.RecyclerView$o r0 = r16.d()
                androidx.recyclerview.widget.RecyclerView$x r1 = r0.a((int) r9)
                if (r1 == 0) goto L_0x0101
                r1.v()
                boolean r0 = androidx.recyclerview.widget.RecyclerView.c
                if (r0 == 0) goto L_0x0101
                r6.f((androidx.recyclerview.widget.RecyclerView.x) r1)
            L_0x0101:
                if (r1 != 0) goto L_0x0180
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x011f
                androidx.recyclerview.widget.RecyclerView$o r10 = r6.g
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.b(r11, r12, r14)
                if (r5 != 0) goto L_0x011f
                return r2
            L_0x011f:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$a r5 = r2.v
                androidx.recyclerview.widget.RecyclerView$x r2 = r5.a((android.view.ViewGroup) r2, (int) r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.f
                if (r5 == 0) goto L_0x013a
                android.view.View r5 = r2.f936b
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.e((android.view.View) r5)
                if (r5 == 0) goto L_0x013a
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.c = r10
            L_0x013a:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$o r5 = r6.g
                long r10 = r10 - r0
                r5.b(r9, r10)
                r10 = r2
                goto L_0x0181
            L_0x0148:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r2 = r2.ra
                int r2 = r2.a()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0180:
                r10 = r1
            L_0x0181:
                r9 = r4
                if (r9 == 0) goto L_0x01ba
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r0 = r0.ra
                boolean r0 = r0.d()
                if (r0 != 0) goto L_0x01ba
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r10.b((int) r0)
                if (r1 == 0) goto L_0x01ba
                r10.a((int) r8, (int) r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r0 = r0.ra
                boolean r0 = r0.k
                if (r0 == 0) goto L_0x01ba
                int r0 = androidx.recyclerview.widget.RecyclerView.f.a((androidx.recyclerview.widget.RecyclerView.x) r10)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$f r2 = r1.W
                androidx.recyclerview.widget.RecyclerView$u r1 = r1.ra
                java.util.List r4 = r10.k()
                androidx.recyclerview.widget.RecyclerView$f$c r0 = r2.a((androidx.recyclerview.widget.RecyclerView.u) r1, (androidx.recyclerview.widget.RecyclerView.x) r10, (int) r0, (java.util.List<java.lang.Object>) r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.a((androidx.recyclerview.widget.RecyclerView.x) r10, (androidx.recyclerview.widget.RecyclerView.f.c) r0)
            L_0x01ba:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r0 = r0.ra
                boolean r0 = r0.d()
                if (r0 == 0) goto L_0x01cd
                boolean r0 = r10.n()
                if (r0 == 0) goto L_0x01cd
                r10.h = r3
                goto L_0x01e0
            L_0x01cd:
                boolean r0 = r10.n()
                if (r0 == 0) goto L_0x01e2
                boolean r0 = r10.u()
                if (r0 != 0) goto L_0x01e2
                boolean r0 = r10.o()
                if (r0 == 0) goto L_0x01e0
                goto L_0x01e2
            L_0x01e0:
                r0 = 0
                goto L_0x01f5
            L_0x01e2:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.n
                int r2 = r0.b((int) r3)
                r0 = r16
                r1 = r10
                r3 = r17
                r4 = r19
                boolean r0 = r0.a(r1, r2, r3, r4)
            L_0x01f5:
                android.view.View r1 = r10.f936b
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x020b
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.j) r1
                android.view.View r2 = r10.f936b
                r2.setLayoutParams(r1)
                goto L_0x0223
            L_0x020b:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x0221
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.j) r1
                android.view.View r2 = r10.f936b
                r2.setLayoutParams(r1)
                goto L_0x0223
            L_0x0221:
                androidx.recyclerview.widget.RecyclerView$j r1 = (androidx.recyclerview.widget.RecyclerView.j) r1
            L_0x0223:
                r1.f921a = r10
                if (r9 == 0) goto L_0x022a
                if (r0 == 0) goto L_0x022a
                goto L_0x022b
            L_0x022a:
                r7 = 0
            L_0x022b:
                r1.d = r7
                return r10
            L_0x022e:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$u r2 = r2.ra
                int r2 = r2.a()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.i()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$x");
        }

        /* access modifiers changed from: package-private */
        public View c(int i2) {
            return this.f927a.get(i2).f936b;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f927a.clear();
            ArrayList<x> arrayList = this.f928b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                x xVar = this.c.get(size);
                if (xVar != null && (i4 = xVar.d) >= i2 && i4 < i5) {
                    xVar.a(2);
                    e(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public x b(int i2) {
            int size;
            int b2;
            ArrayList<x> arrayList = this.f928b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    x xVar = this.f928b.get(i4);
                    if (xVar.A() || xVar.i() != i2) {
                        i4++;
                    } else {
                        xVar.a(32);
                        return xVar;
                    }
                }
                if (RecyclerView.this.v.b() && (b2 = RecyclerView.this.n.b(i2)) > 0 && b2 < RecyclerView.this.v.a()) {
                    long a2 = RecyclerView.this.v.a(b2);
                    while (i3 < size) {
                        x xVar2 = this.f928b.get(i3);
                        if (xVar2.A() || xVar2.g() != a2) {
                            i3++;
                        } else {
                            xVar2.a(32);
                            return xVar2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            int i7;
            if (i2 < i3) {
                i6 = i2;
                i5 = i3;
                i4 = -1;
            } else {
                i5 = i2;
                i6 = i3;
                i4 = 1;
            }
            int size = this.c.size();
            for (int i8 = 0; i8 < size; i8++) {
                x xVar = this.c.get(i8);
                if (xVar != null && (i7 = xVar.d) >= i6 && i7 <= i5) {
                    if (i7 == i2) {
                        xVar.a(i3 - i2, false);
                    } else {
                        xVar.a(i4, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.c.get(i2).a();
            }
            int size2 = this.f927a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f927a.get(i3).a();
            }
            ArrayList<x> arrayList = this.f928b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f928b.get(i4).a();
                }
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(x xVar, boolean z) {
            RecyclerView.b(xVar);
            if (xVar.b(16384)) {
                xVar.a(0, 16384);
                y.a(xVar.f936b, (C0037a) null);
            }
            if (z) {
                a(xVar);
            }
            xVar.s = null;
            d().a(xVar);
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            x g2 = RecyclerView.g(view);
            g2.o = null;
            g2.p = false;
            g2.c();
            b(g2);
        }

        /* access modifiers changed from: package-private */
        public x a(int i2, boolean z) {
            View b2;
            int size = this.f927a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                x xVar = this.f927a.get(i4);
                if (xVar.A() || xVar.i() != i2 || xVar.o() || (!RecyclerView.this.ra.h && xVar.q())) {
                    i4++;
                } else {
                    xVar.a(32);
                    return xVar;
                }
            }
            if (z || (b2 = RecyclerView.this.o.b(i2)) == null) {
                int size2 = this.c.size();
                while (i3 < size2) {
                    x xVar2 = this.c.get(i3);
                    if (xVar2.o() || xVar2.i() != i2 || xVar2.m()) {
                        i3++;
                    } else {
                        if (!z) {
                            this.c.remove(i3);
                        }
                        return xVar2;
                    }
                }
                return null;
            }
            x g2 = RecyclerView.g(b2);
            RecyclerView.this.o.f(b2);
            int b3 = RecyclerView.this.o.b(b2);
            if (b3 != -1) {
                RecyclerView.this.o.a(b3);
                c(b2);
                g2.a(8224);
                return g2;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + g2 + RecyclerView.this.i());
        }

        /* access modifiers changed from: package-private */
        public x a(long j, int i2, boolean z) {
            for (int size = this.f927a.size() - 1; size >= 0; size--) {
                x xVar = this.f927a.get(size);
                if (xVar.g() == j && !xVar.A()) {
                    if (i2 == xVar.h()) {
                        xVar.a(32);
                        if (xVar.q() && !RecyclerView.this.ra.d()) {
                            xVar.a(2, 14);
                        }
                        return xVar;
                    } else if (!z) {
                        this.f927a.remove(size);
                        RecyclerView.this.removeDetachedView(xVar.f936b, false);
                        a(xVar.f936b);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                x xVar2 = this.c.get(size2);
                if (xVar2.g() == j && !xVar2.m()) {
                    if (i2 == xVar2.h()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return xVar2;
                    } else if (!z) {
                        e(size2);
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(x xVar) {
            q qVar = RecyclerView.this.x;
            if (qVar != null) {
                qVar.a(xVar);
            }
            a aVar = RecyclerView.this.v;
            if (aVar != null) {
                aVar.d(xVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.ra != null) {
                recyclerView.p.h(xVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar, a aVar2, boolean z) {
            a();
            d().a(aVar, aVar2, z);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            int size = this.c.size();
            for (int i4 = 0; i4 < size; i4++) {
                x xVar = this.c.get(i4);
                if (xVar != null && xVar.d >= i2) {
                    xVar.a(i3, true);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, boolean z) {
            int i4 = i2 + i3;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                x xVar = this.c.get(size);
                if (xVar != null) {
                    int i5 = xVar.d;
                    if (i5 >= i4) {
                        xVar.a(-i3, z);
                    } else if (i5 >= i2) {
                        xVar.a(8);
                        e(size);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(v vVar) {
            this.h = vVar;
        }

        /* access modifiers changed from: package-private */
        public void a(o oVar) {
            o oVar2 = this.g;
            if (oVar2 != null) {
                oVar2.c();
            }
            this.g = oVar;
            if (this.g != null && RecyclerView.this.getAdapter() != null) {
                this.g.a();
            }
        }
    }

    public interface q {
        void a(x xVar);
    }

    public static abstract class t {

        public interface a {
        }

        public abstract int a();

        public abstract void a(int i);

        /* access modifiers changed from: package-private */
        public abstract void a(int i, int i2);

        /* access modifiers changed from: protected */
        public abstract void a(View view);

        public abstract boolean b();

        public abstract boolean c();

        /* access modifiers changed from: protected */
        public final void d() {
            throw null;
        }
    }

    public static abstract class v {
        public abstract View a(p pVar, int i, int i2);
    }

    public static abstract class x {

        /* renamed from: a  reason: collision with root package name */
        private static final List<Object> f935a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public final View f936b;
        WeakReference<RecyclerView> c;
        int d = -1;
        int e = -1;
        long f = -1;
        int g = -1;
        int h = -1;
        x i = null;
        x j = null;
        int k;
        List<Object> l = null;
        List<Object> m = null;
        private int n = 0;
        p o = null;
        boolean p = false;
        private int q = 0;
        int r = -1;
        RecyclerView s;

        public x(View view) {
            if (view != null) {
                this.f936b = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void B() {
            if (this.l == null) {
                this.l = new ArrayList();
                this.m = Collections.unmodifiableList(this.l);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean A() {
            return (this.k & 32) != 0;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, boolean z) {
            a(8);
            a(i3, z);
            this.d = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2) {
            return (i2 & this.k) != 0;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.k &= -33;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.k &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            return (this.k & 16) == 0 && y.x(this.f936b);
        }

        public final int f() {
            RecyclerView recyclerView = this.s;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.c(this);
        }

        public final long g() {
            return this.f;
        }

        public final int h() {
            return this.g;
        }

        public final int i() {
            int i2 = this.h;
            return i2 == -1 ? this.d : i2;
        }

        public final int j() {
            return this.e;
        }

        /* access modifiers changed from: package-private */
        public List<Object> k() {
            if ((this.k & 1024) != 0) {
                return f935a;
            }
            List<Object> list = this.l;
            if (list == null || list.size() == 0) {
                return f935a;
            }
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public boolean l() {
            return (this.k & 512) != 0 || o();
        }

        /* access modifiers changed from: package-private */
        public boolean m() {
            return (this.f936b.getParent() == null || this.f936b.getParent() == this.s) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return (this.k & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean o() {
            return (this.k & 4) != 0;
        }

        public final boolean p() {
            return (this.k & 16) == 0 && !y.x(this.f936b);
        }

        /* access modifiers changed from: package-private */
        public boolean q() {
            return (this.k & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean r() {
            return this.o != null;
        }

        /* access modifiers changed from: package-private */
        public boolean s() {
            return (this.k & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean t() {
            return (this.k & 2) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.d + " id=" + this.f + ", oldPos=" + this.e + ", pLpos:" + this.h);
            if (r()) {
                sb.append(" scrap ");
                sb.append(this.p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (o()) {
                sb.append(" invalid");
            }
            if (!n()) {
                sb.append(" unbound");
            }
            if (u()) {
                sb.append(" update");
            }
            if (q()) {
                sb.append(" removed");
            }
            if (y()) {
                sb.append(" ignored");
            }
            if (s()) {
                sb.append(" tmpDetached");
            }
            if (!p()) {
                sb.append(" not recyclable(" + this.n + ")");
            }
            if (l()) {
                sb.append(" undefined adapter position");
            }
            if (this.f936b.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public boolean u() {
            return (this.k & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            this.k = 0;
            this.d = -1;
            this.e = -1;
            this.f = -1;
            this.h = -1;
            this.n = 0;
            this.i = null;
            this.j = null;
            b();
            this.q = 0;
            this.r = -1;
            RecyclerView.b(this);
        }

        /* access modifiers changed from: package-private */
        public void w() {
            if (this.e == -1) {
                this.e = this.d;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean x() {
            return (this.k & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean y() {
            return (this.k & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        public void z() {
            this.o.c(this);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            List<Object> list = this.l;
            if (list != null) {
                list.clear();
            }
            this.k &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, boolean z) {
            if (this.e == -1) {
                this.e = this.d;
            }
            if (this.h == -1) {
                this.h = this.d;
            }
            if (z) {
                this.h += i2;
            }
            this.d += i2;
            if (this.f936b.getLayoutParams() != null) {
                ((j) this.f936b.getLayoutParams()).c = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.q);
            this.q = 0;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.e = -1;
            this.h = -1;
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar, boolean z) {
            this.o = pVar;
            this.p = z;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            this.k = (i2 & i3) | (this.k & (i3 ^ -1));
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.k = i2 | this.k;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            if (obj == null) {
                a(1024);
            } else if ((1024 & this.k) == 0) {
                B();
                this.l.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView) {
            int i2 = this.r;
            if (i2 != -1) {
                this.q = i2;
            } else {
                this.q = y.k(this.f936b);
            }
            recyclerView.a(this, 4);
        }

        public final void a(boolean z) {
            this.n = z ? this.n - 1 : this.n + 1;
            int i2 = this.n;
            if (i2 < 0) {
                this.n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.k |= 16;
            } else if (z && this.n == 0) {
                this.k &= -17;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            int[] r1 = new int[r0]
            r2 = 0
            r3 = 16843830(0x1010436, float:2.369658E-38)
            r1[r2] = r3
            f908a = r1
            int[] r1 = new int[r0]
            r3 = 16842987(0x10100eb, float:2.3694217E-38)
            r1[r2] = r3
            f909b = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 18
            if (r1 == r3) goto L_0x0025
            r3 = 19
            if (r1 == r3) goto L_0x0025
            r3 = 20
            if (r1 != r3) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r1 = 0
            goto L_0x0026
        L_0x0025:
            r1 = 1
        L_0x0026:
            c = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r1 < r3) goto L_0x0030
            r1 = 1
            goto L_0x0031
        L_0x0030:
            r1 = 0
        L_0x0031:
            d = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 16
            if (r1 < r3) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            e = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r1 < r3) goto L_0x0046
            r1 = 1
            goto L_0x0047
        L_0x0046:
            r1 = 0
        L_0x0047:
            f = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 15
            if (r1 > r3) goto L_0x0051
            r1 = 1
            goto L_0x0052
        L_0x0051:
            r1 = 0
        L_0x0052:
            g = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 > r3) goto L_0x005a
            r1 = 1
            goto L_0x005b
        L_0x005a:
            r1 = 0
        L_0x005b:
            h = r1
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r1[r2] = r3
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r1[r0] = r2
            r0 = 2
            java.lang.Class r2 = java.lang.Integer.TYPE
            r1[r0] = r2
            r0 = 3
            r1[r0] = r2
            i = r1
            androidx.recyclerview.widget.A r0 = new androidx.recyclerview.widget.A
            r0.<init>()
            j = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void A() {
        boolean z2 = true;
        this.ra.a(1);
        a(this.ra);
        this.ra.j = false;
        w();
        this.p.a();
        q();
        I();
        N();
        u uVar = this.ra;
        if (!uVar.k || !this.va) {
            z2 = false;
        }
        uVar.i = z2;
        this.va = false;
        this.ua = false;
        u uVar2 = this.ra;
        uVar2.h = uVar2.l;
        uVar2.f = this.v.a();
        a(this.Aa);
        if (this.ra.k) {
            int a2 = this.o.a();
            for (int i2 = 0; i2 < a2; i2++) {
                x g2 = g(this.o.c(i2));
                if (!g2.y() && (!g2.o() || this.v.b())) {
                    this.p.c(g2, this.W.a(this.ra, g2, f.a(g2), g2.k()));
                    if (this.ra.i && g2.t() && !g2.q() && !g2.y() && !g2.o()) {
                        this.p.a(d(g2), g2);
                    }
                }
            }
        }
        if (this.ra.l) {
            v();
            u uVar3 = this.ra;
            boolean z3 = uVar3.g;
            uVar3.g = false;
            this.w.e(this.l, uVar3);
            this.ra.g = z3;
            for (int i3 = 0; i3 < this.o.a(); i3++) {
                x g3 = g(this.o.c(i3));
                if (!g3.y() && !this.p.c(g3)) {
                    int a3 = f.a(g3);
                    boolean b2 = g3.b(8192);
                    if (!b2) {
                        a3 |= 4096;
                    }
                    f.c a4 = this.W.a(this.ra, g3, a3, g3.k());
                    if (b2) {
                        a(g3, a4);
                    } else {
                        this.p.a(g3, a4);
                    }
                }
            }
            a();
        } else {
            a();
        }
        r();
        c(false);
        this.ra.e = 2;
    }

    private void B() {
        w();
        q();
        this.ra.a(6);
        this.n.b();
        this.ra.f = this.v.a();
        u uVar = this.ra;
        uVar.d = 0;
        uVar.h = false;
        this.w.e(this.l, uVar);
        u uVar2 = this.ra;
        uVar2.g = false;
        this.m = null;
        uVar2.k = uVar2.k && this.W != null;
        this.ra.e = 4;
        r();
        c(false);
    }

    private void C() {
        this.ra.a(4);
        w();
        q();
        u uVar = this.ra;
        uVar.e = 1;
        if (uVar.k) {
            for (int a2 = this.o.a() - 1; a2 >= 0; a2--) {
                x g2 = g(this.o.c(a2));
                if (!g2.y()) {
                    long d2 = d(g2);
                    f.c a3 = this.W.a(this.ra, g2);
                    x a4 = this.p.a(d2);
                    if (a4 == null || a4.y()) {
                        this.p.b(g2, a3);
                    } else {
                        boolean b2 = this.p.b(a4);
                        boolean b3 = this.p.b(g2);
                        if (!b2 || a4 != g2) {
                            f.c f2 = this.p.f(a4);
                            this.p.b(g2, a3);
                            f.c e2 = this.p.e(g2);
                            if (f2 == null) {
                                a(d2, g2, a4);
                            } else {
                                a(a4, g2, f2, e2, b2, b3);
                            }
                        } else {
                            this.p.b(g2, a3);
                        }
                    }
                }
            }
            this.p.a(this.Ha);
        }
        this.w.c(this.l);
        u uVar2 = this.ra;
        uVar2.c = uVar2.f;
        this.N = false;
        this.O = false;
        uVar2.k = false;
        uVar2.l = false;
        this.w.h = false;
        ArrayList<x> arrayList = this.l.f928b;
        if (arrayList != null) {
            arrayList.clear();
        }
        i iVar = this.w;
        if (iVar.n) {
            iVar.m = 0;
            iVar.n = false;
            this.l.j();
        }
        this.w.g(this.ra);
        r();
        c(false);
        this.p.a();
        int[] iArr = this.Aa;
        if (k(iArr[0], iArr[1])) {
            d(0, 0);
        }
        J();
        L();
    }

    private View D() {
        x b2;
        int i2 = this.ra.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int a2 = this.ra.a();
        int i3 = i2;
        while (i3 < a2) {
            x b3 = b(i3);
            if (b3 == null) {
                break;
            } else if (b3.f936b.hasFocusable()) {
                return b3.f936b;
            } else {
                i3++;
            }
        }
        int min = Math.min(a2, i2);
        while (true) {
            min--;
            if (min < 0 || (b2 = b(min)) == null) {
                return null;
            }
            if (b2.f936b.hasFocusable()) {
                return b2.f936b;
            }
        }
    }

    private boolean E() {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            x g2 = g(this.o.c(i2));
            if (g2 != null && !g2.y() && g2.t()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void F() {
        if (y.l(this) == 0) {
            y.e(this, 8);
        }
    }

    private void G() {
        this.o = new C0151b(new C(this));
    }

    private boolean H() {
        return this.W != null && this.w.C();
    }

    private void I() {
        if (this.N) {
            this.n.f();
            if (this.O) {
                this.w.d(this);
            }
        }
        if (H()) {
            this.n.e();
        } else {
            this.n.b();
        }
        boolean z2 = false;
        boolean z3 = this.ua || this.va;
        this.ra.k = this.E && this.W != null && (this.N || z3 || this.w.h) && (!this.N || this.v.b());
        u uVar = this.ra;
        if (uVar.k && z3 && !this.N && H()) {
            z2 = true;
        }
        uVar.l = z2;
    }

    private void J() {
        View view;
        if (this.na && this.v != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!h || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.o.c(focusedChild)) {
                            return;
                        }
                    } else if (this.o.a() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view2 = null;
                x a2 = (this.ra.n == -1 || !this.v.b()) ? null : a(this.ra.n);
                if (a2 != null && !this.o.c(a2.f936b) && a2.f936b.hasFocusable()) {
                    view2 = a2.f936b;
                } else if (this.o.a() > 0) {
                    view2 = D();
                }
                if (view2 != null) {
                    int i2 = this.ra.o;
                    if (((long) i2) == -1 || (view = view2.findViewById(i2)) == null || !view.isFocusable()) {
                        view = view2;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void K() {
        boolean z2;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.S.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.T;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.T.isFinished();
        }
        EdgeEffect edgeEffect3 = this.U;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.U.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.V.isFinished();
        }
        if (z2) {
            y.E(this);
        }
    }

    private void L() {
        u uVar = this.ra;
        uVar.n = -1;
        uVar.m = -1;
        uVar.o = -1;
    }

    private void M() {
        VelocityTracker velocityTracker = this.ca;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        f(0);
        K();
    }

    private void N() {
        int i2;
        x xVar = null;
        View focusedChild = (!this.na || !hasFocus() || this.v == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            xVar = d(focusedChild);
        }
        if (xVar == null) {
            L();
            return;
        }
        this.ra.n = this.v.b() ? xVar.g() : -1;
        u uVar = this.ra;
        if (this.N) {
            i2 = -1;
        } else if (xVar.q()) {
            i2 = xVar.e;
        } else {
            i2 = xVar.f();
        }
        uVar.m = i2;
        this.ra.o = l(xVar.f936b);
    }

    private void O() {
        this.oa.b();
        i iVar = this.w;
        if (iVar != null) {
            iVar.B();
        }
    }

    private void e(x xVar) {
        View view = xVar.f936b;
        boolean z2 = view.getParent() == this;
        this.l.c(f(view));
        if (xVar.s()) {
            this.o.a(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.o.a(view, true);
        } else {
            this.o.a(view);
        }
    }

    private a.g.i.l getScrollingChildHelper() {
        if (this.Ba == null) {
            this.Ba = new a.g.i.l(this);
        }
        return this.Ba;
    }

    private void y() {
        M();
        setScrollState(0);
    }

    private void z() {
        int i2 = this.J;
        this.J = 0;
        if (i2 != 0 && m()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            a.g.i.a.b.a(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.w;
        if (iVar == null || !iVar.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void b(h hVar) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.y.remove(hVar);
        if (this.y.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        o();
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z2) {
        if (this.F < 1) {
            this.F = 1;
        }
        if (!z2 && !this.H) {
            this.G = false;
        }
        if (this.F == 1) {
            if (z2 && this.G && !this.H && this.w != null && this.v != null) {
                c();
            }
            if (!this.H) {
                this.G = false;
            }
        }
        this.F--;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof j) && this.w.a((j) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        i iVar = this.w;
        if (iVar != null && iVar.a()) {
            return this.w.a(this.ra);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        i iVar = this.w;
        if (iVar != null && iVar.a()) {
            return this.w.b(this.ra);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        i iVar = this.w;
        if (iVar != null && iVar.a()) {
            return this.w.c(this.ra);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        i iVar = this.w;
        if (iVar != null && iVar.b()) {
            return this.w.d(this.ra);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        i iVar = this.w;
        if (iVar != null && iVar.b()) {
            return this.w.e(this.ra);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        i iVar = this.w;
        if (iVar != null && iVar.b()) {
            return this.w.f(this.ra);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public long d(x xVar) {
        return this.v.b() ? xVar.g() : (long) xVar.d;
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        super.draw(canvas);
        int size = this.y.size();
        boolean z4 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).b(canvas, this, this.ra);
        }
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.q ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.S;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.q) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.T;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.U;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.q ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-paddingTop), (float) (-width));
            EdgeEffect edgeEffect6 = this.U;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.V;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z3 = z2;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.q) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.V;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 = z4 | z2;
            canvas.restoreToCount(save4);
        }
        if (!z3 && this.W != null && this.y.size() > 0 && this.W.g()) {
            z3 = true;
        }
        if (z3) {
            y.E(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void e(int i2) {
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.S == null) {
            this.S = this.R.a(this, 0);
            if (this.q) {
                this.S.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.S.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View d2 = this.w.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z3 = this.v != null && this.w != null && !n() && !this.H;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z3 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z3) {
                view2 = findNextFocus;
            } else {
                b();
                if (c(view) == null) {
                    return null;
                }
                w();
                view2 = this.w.a(view, i2, this.l, this.ra);
                c(false);
            }
        } else {
            if (this.w.b()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (g) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.w.a()) {
                int i4 = (this.w.j() == 1) ^ (i2 == 2) ? 66 : 17;
                z2 = instance.findNextFocus(this, view, i4) == null;
                if (g) {
                    i2 = i4;
                }
            }
            if (z2) {
                b();
                if (c(view) == null) {
                    return null;
                }
                w();
                this.w.a(view, i2, this.l, this.ra);
                c(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a(view2, (View) null);
        return view;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.U == null) {
            this.U = this.R.a(this, 2);
            if (this.q) {
                this.U.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.U.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.c();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public a getAdapter() {
        return this.v;
    }

    public int getBaseline() {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.d();
        }
        return super.getBaseline();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.za;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.a(i2, i3);
    }

    public boolean getClipToPadding() {
        return this.q;
    }

    public H getCompatAccessibilityDelegate() {
        return this.ya;
    }

    public e getEdgeEffectFactory() {
        return this.R;
    }

    public f getItemAnimator() {
        return this.W;
    }

    public int getItemDecorationCount() {
        return this.y.size();
    }

    public i getLayoutManager() {
        return this.w;
    }

    public int getMaxFlingVelocity() {
        return this.ka;
    }

    public int getMinFlingVelocity() {
        return this.ja;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (f) {
            return System.nanoTime();
        }
        return 0;
    }

    public l getOnFlingListener() {
        return this.ia;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.na;
    }

    public o getRecycledViewPool() {
        return this.l.d();
    }

    public int getScrollState() {
        return this.aa;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.T == null) {
            this.T = this.R.a(this, 1);
            if (this.q) {
                this.T.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.T.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void h(int i2, int i3) {
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a();
    }

    /* access modifiers changed from: package-private */
    public String i() {
        return " " + super.toString() + ", adapter:" + this.v + ", layout:" + this.w + ", context:" + getContext();
    }

    public void i(View view) {
    }

    public boolean isAttachedToWindow() {
        return this.B;
    }

    public final boolean isLayoutSuppressed() {
        return this.H;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().b();
    }

    public void j(View view) {
    }

    public boolean j() {
        return !this.E || this.N || this.n.c();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.n = new C0150a(new D(this));
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.V = null;
        this.T = null;
        this.U = null;
        this.S = null;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        AccessibilityManager accessibilityManager = this.L;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean n() {
        return this.P > 0;
    }

    /* access modifiers changed from: package-private */
    public void o() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((j) this.o.d(i2).getLayoutParams()).c = true;
        }
        this.l.g();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r0 >= 30.0f) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.P = r0
            r1 = 1
            r4.B = r1
            boolean r2 = r4.E
            if (r2 == 0) goto L_0x0014
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            r4.E = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.w
            if (r1 == 0) goto L_0x001e
            r1.a((androidx.recyclerview.widget.RecyclerView) r4)
        L_0x001e:
            r4.xa = r0
            boolean r0 = f
            if (r0 == 0) goto L_0x0067
            java.lang.ThreadLocal<androidx.recyclerview.widget.q> r0 = androidx.recyclerview.widget.q.f984a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.q r0 = (androidx.recyclerview.widget.q) r0
            r4.pa = r0
            androidx.recyclerview.widget.q r0 = r4.pa
            if (r0 != 0) goto L_0x0062
            androidx.recyclerview.widget.q r0 = new androidx.recyclerview.widget.q
            r0.<init>()
            r4.pa = r0
            android.view.Display r0 = a.g.i.y.h(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L_0x0052
            if (r0 == 0) goto L_0x0052
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r0 = 1114636288(0x42700000, float:60.0)
        L_0x0054:
            androidx.recyclerview.widget.q r1 = r4.pa
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.e = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.q> r0 = androidx.recyclerview.widget.q.f984a
            r0.set(r1)
        L_0x0062:
            androidx.recyclerview.widget.q r0 = r4.pa
            r0.a((androidx.recyclerview.widget.RecyclerView) r4)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        q qVar;
        super.onDetachedFromWindow();
        f fVar = this.W;
        if (fVar != null) {
            fVar.b();
        }
        x();
        this.B = false;
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(this, this.l);
        }
        this.Fa.clear();
        removeCallbacks(this.Ga);
        this.p.b();
        if (f && (qVar = this.pa) != null) {
            qVar.b(this);
            this.pa = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.y.get(i2).a(canvas, this, this.ra);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.w != null && !this.H && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.w.b() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.w.a()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == 0.0f && f2 == 0.0f)) {
                        a((int) (f2 * this.la), (int) (f3 * this.ma), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.w.b()) {
                        f3 = -axisValue;
                    } else if (this.w.a()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        a((int) (f2 * this.la), (int) (f3 * this.ma), motionEvent);
                    }
                }
                f3 = 0.0f;
            }
            f2 = 0.0f;
            a((int) (f2 * this.la), (int) (f3 * this.ma), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.H) {
            return false;
        }
        this.A = null;
        if (b(motionEvent)) {
            y();
            return true;
        }
        i iVar = this.w;
        if (iVar == null) {
            return false;
        }
        boolean a2 = iVar.a();
        boolean b2 = this.w.b();
        if (this.ca == null) {
            this.ca = VelocityTracker.obtain();
        }
        this.ca.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.I) {
                this.I = false;
            }
            this.ba = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.fa = x2;
            this.da = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.ga = y2;
            this.ea = y2;
            if (this.aa == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                f(1);
            }
            int[] iArr = this.Da;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = a2 ? 1 : 0;
            if (b2) {
                i2 |= 2;
            }
            j(i2, 0);
        } else if (actionMasked == 1) {
            this.ca.clear();
            f(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.ba);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ba + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.aa != 1) {
                int i3 = x3 - this.da;
                int i4 = y3 - this.ea;
                if (!a2 || Math.abs(i3) <= this.ha) {
                    z2 = false;
                } else {
                    this.fa = x3;
                    z2 = true;
                }
                if (b2 && Math.abs(i4) > this.ha) {
                    this.ga = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.ba = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.fa = x4;
            this.da = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ga = y4;
            this.ea = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        if (this.aa == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        a.g.e.a.a("RV OnLayout");
        c();
        a.g.e.a.a();
        this.E = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        i iVar = this.w;
        if (iVar == null) {
            c(i2, i3);
            return;
        }
        boolean z2 = false;
        if (iVar.u()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.w.a(this.l, this.ra, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            if (!z2 && this.v != null) {
                if (this.ra.e == 1) {
                    A();
                }
                this.w.b(i2, i3);
                this.ra.j = true;
                B();
                this.w.d(i2, i3);
                if (this.w.A()) {
                    this.w.b(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.ra.j = true;
                    B();
                    this.w.d(i2, i3);
                }
            }
        } else if (this.C) {
            this.w.a(this.l, this.ra, i2, i3);
        } else {
            if (this.K) {
                w();
                q();
                I();
                r();
                u uVar = this.ra;
                if (uVar.l) {
                    uVar.h = true;
                } else {
                    this.n.b();
                    this.ra.h = false;
                }
                this.K = false;
                c(false);
            } else if (this.ra.l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            a aVar = this.v;
            if (aVar != null) {
                this.ra.f = aVar.a();
            } else {
                this.ra.f = 0;
            }
            w();
            this.w.a(this.l, this.ra, i2, i3);
            c(false);
            this.ra.h = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (n()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof s)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.m = (s) parcelable;
        super.onRestoreInstanceState(this.m.a());
        i iVar = this.w;
        if (iVar != null && (parcelable2 = this.m.f930a) != null) {
            iVar.a(parcelable2);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        s sVar = new s(super.onSaveInstanceState());
        s sVar2 = this.m;
        if (sVar2 != null) {
            sVar.a(sVar2);
        } else {
            i iVar = this.w;
            if (iVar != null) {
                sVar.f930a = iVar.x();
            } else {
                sVar.f930a = null;
            }
        }
        return sVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            l();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        boolean z3 = false;
        if (this.H || this.I) {
            return false;
        }
        if (a(motionEvent)) {
            y();
            return true;
        }
        i iVar = this.w;
        if (iVar == null) {
            return false;
        }
        boolean a2 = iVar.a();
        boolean b2 = this.w.b();
        if (this.ca == null) {
            this.ca = VelocityTracker.obtain();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.Da;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.Da;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked == 0) {
            this.ba = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.fa = x2;
            this.da = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.ga = y2;
            this.ea = y2;
            int i6 = a2 ? 1 : 0;
            if (b2) {
                i6 |= 2;
            }
            j(i6, 0);
        } else if (actionMasked == 1) {
            this.ca.addMovement(obtain);
            this.ca.computeCurrentVelocity(1000, (float) this.ka);
            float f2 = a2 ? -this.ca.getXVelocity(this.ba) : 0.0f;
            float f3 = b2 ? -this.ca.getYVelocity(this.ba) : 0.0f;
            if ((f2 == 0.0f && f3 == 0.0f) || !e((int) f2, (int) f3)) {
                setScrollState(0);
            }
            M();
            z3 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.ba);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ba + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i7 = this.fa - x3;
            int i8 = this.ga - y3;
            int[] iArr3 = this.Ea;
            iArr3[0] = 0;
            iArr3[1] = 0;
            if (a(i7, i8, iArr3, this.Ca, 0)) {
                int[] iArr4 = this.Ea;
                i7 -= iArr4[0];
                i8 -= iArr4[1];
                int[] iArr5 = this.Ca;
                obtain.offsetLocation((float) iArr5[0], (float) iArr5[1]);
                int[] iArr6 = this.Da;
                int i9 = iArr6[0];
                int[] iArr7 = this.Ca;
                iArr6[0] = i9 + iArr7[0];
                iArr6[1] = iArr6[1] + iArr7[1];
            }
            if (this.aa != 1) {
                if (!a2 || Math.abs(i3) <= (i5 = this.ha)) {
                    z2 = false;
                } else {
                    i3 = i3 > 0 ? i3 - i5 : i3 + i5;
                    z2 = true;
                }
                if (b2 && Math.abs(i2) > (i4 = this.ha)) {
                    i2 = i2 > 0 ? i2 - i4 : i2 + i4;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
            if (this.aa == 1) {
                int[] iArr8 = this.Ca;
                this.fa = x3 - iArr8[0];
                this.ga = y3 - iArr8[1];
                if (a(a2 ? i3 : 0, b2 ? i2 : 0, obtain)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (!(this.pa == null || (i3 == 0 && i2 == 0))) {
                    this.pa.a(this, i3, i2);
                }
            }
        } else if (actionMasked == 3) {
            y();
        } else if (actionMasked == 5) {
            this.ba = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.fa = x4;
            this.da = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ga = y4;
            this.ea = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        if (!z3) {
            this.ca.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            x g2 = g(this.o.d(i2));
            if (g2 != null && !g2.y()) {
                g2.a(6);
            }
        }
        o();
        this.l.h();
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.P++;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        a(true);
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        x g2 = g(view);
        if (g2 != null) {
            if (g2.s()) {
                g2.d();
            } else if (!g2.y()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + g2 + i());
            }
        }
        view.clearAnimation();
        b(view);
        super.removeDetachedView(view, z2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.w.a(this, this.ra, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.w.a(this, view, rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.z.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.F != 0 || this.H) {
            this.G = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        if (!this.xa && this.B) {
            y.a((View) this, this.Ga);
            this.xa = true;
        }
    }

    public void scrollBy(int i2, int i3) {
        i iVar = this.w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.H) {
            boolean a2 = iVar.a();
            boolean b2 = this.w.b();
            if (a2 || b2) {
                if (!a2) {
                    i2 = 0;
                }
                if (!b2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(H h2) {
        this.ya = h2;
        y.a((View) this, (C0037a) this.ya);
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        a(aVar, false, true);
        b(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar != this.za) {
            this.za = dVar;
            setChildrenDrawingOrderEnabled(this.za != null);
        }
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.q) {
            l();
        }
        this.q = z2;
        super.setClipToPadding(z2);
        if (this.E) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(e eVar) {
        a.g.h.g.a(eVar);
        this.R = eVar;
        l();
    }

    public void setHasFixedSize(boolean z2) {
        this.C = z2;
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.W;
        if (fVar2 != null) {
            fVar2.b();
            this.W.a((f.b) null);
        }
        this.W = fVar;
        f fVar3 = this.W;
        if (fVar3 != null) {
            fVar3.a(this.wa);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.l.f(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(i iVar) {
        if (iVar != this.w) {
            x();
            if (this.w != null) {
                f fVar = this.W;
                if (fVar != null) {
                    fVar.b();
                }
                this.w.b(this.l);
                this.w.c(this.l);
                this.l.a();
                if (this.B) {
                    this.w.a(this, this.l);
                }
                this.w.f((RecyclerView) null);
                this.w = null;
            } else {
                this.l.a();
            }
            this.o.c();
            this.w = iVar;
            if (iVar != null) {
                if (iVar.f918b == null) {
                    this.w.f(this);
                    if (this.B) {
                        this.w.a(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.f918b.i());
                }
            }
            this.l.j();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().a(z2);
    }

    public void setOnFlingListener(l lVar) {
        this.ia = lVar;
    }

    @Deprecated
    public void setOnScrollListener(n nVar) {
        this.sa = nVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.na = z2;
    }

    public void setRecycledViewPool(o oVar) {
        this.l.a(oVar);
    }

    public void setRecyclerListener(q qVar) {
        this.x = qVar;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.aa) {
            this.aa = i2;
            if (i2 != 2) {
                O();
            }
            a(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.ha = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.ha = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(v vVar) {
        this.l.a(vVar);
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    public final void suppressLayout(boolean z2) {
        if (z2 != this.H) {
            a("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.H = false;
                if (!(!this.G || this.w == null || this.v == null)) {
                    requestLayout();
                }
                this.G = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.H = true;
            this.I = true;
            x();
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        f fVar = this.W;
        if (fVar != null) {
            fVar.b();
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.b(this.l);
            this.w.c(this.l);
        }
        this.l.a();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        x xVar;
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View c2 = this.o.c(i2);
            x f2 = f(c2);
            if (!(f2 == null || (xVar = f2.j) == null)) {
                View view = xVar.f936b;
                int left = c2.getLeft();
                int top = c2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            x g2 = g(this.o.d(i2));
            if (!g2.y()) {
                g2.w();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.F++;
        if (this.F == 1 && !this.H) {
            this.G = false;
        }
    }

    public void x() {
        setScrollState(0);
        O();
    }

    static class b extends Observable<c> {
        b() {
        }

        public void a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a();
            }
        }

        public void b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).b(i, i2);
            }
        }

        public void a(int i, int i2) {
            a(i, i2, (Object) null);
        }

        public void a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).a(i, i2, obj);
            }
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int l(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public x d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return f(c2);
    }

    /* access modifiers changed from: package-private */
    public boolean k(View view) {
        w();
        boolean e2 = this.o.e(view);
        if (e2) {
            x g2 = g(view);
            this.l.c(g2);
            this.l.b(g2);
        }
        c(!e2);
        return e2;
    }

    public static class o {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f923a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f924b = 0;

        static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<x> f925a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f926b = 5;
            long c = 0;
            long d = 0;

            a() {
            }
        }

        public x a(int i) {
            a aVar = this.f923a.get(i);
            if (aVar == null || aVar.f925a.isEmpty()) {
                return null;
            }
            ArrayList<x> arrayList = aVar.f925a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).m()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public void b() {
            for (int i = 0; i < this.f923a.size(); i++) {
                this.f923a.valueAt(i).f925a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f924b--;
        }

        /* access modifiers changed from: package-private */
        public void b(int i, long j) {
            a b2 = b(i);
            b2.c = a(b2.c, j);
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i, long j, long j2) {
            long j3 = b(i).c;
            return j3 == 0 || j + j3 < j2;
        }

        private a b(int i) {
            a aVar = this.f923a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f923a.put(i, aVar2);
            return aVar2;
        }

        public void a(x xVar) {
            int h = xVar.h();
            ArrayList<x> arrayList = b(h).f925a;
            if (this.f923a.get(h).f926b > arrayList.size()) {
                xVar.v();
                arrayList.add(xVar);
            }
        }

        /* access modifiers changed from: package-private */
        public long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        /* access modifiers changed from: package-private */
        public void a(int i, long j) {
            a b2 = b(i);
            b2.d = a(b2.d, j);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i, long j, long j2) {
            long j3 = b(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f924b++;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.f924b == 0) {
                b();
            }
            if (aVar2 != null) {
                a();
            }
        }
    }

    private class r extends c {
        r() {
        }

        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.ra.g = true;
            recyclerView.b(true);
            if (!RecyclerView.this.n.c()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void b(int i, int i2) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.n.b(i, i2)) {
                b();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (RecyclerView.e) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.C && recyclerView.B) {
                    y.a((View) recyclerView, recyclerView.r);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.K = true;
            recyclerView2.requestLayout();
        }

        public void a(int i, int i2, Object obj) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.n.a(i, i2, obj)) {
                b();
            }
        }
    }

    class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f933a;

        /* renamed from: b  reason: collision with root package name */
        private int f934b;
        OverScroller c;
        Interpolator d = RecyclerView.j;
        private boolean e = false;
        private boolean f = false;

        w() {
            this.c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.j);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            y.a((View) RecyclerView.this, (Runnable) this);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.e) {
                this.f = true;
            } else {
                c();
            }
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.c.abortAnimation();
        }

        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.w == null) {
                b();
                return;
            }
            this.f = false;
            this.e = true;
            recyclerView.b();
            OverScroller overScroller = this.c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f933a;
                int i4 = currY - this.f934b;
                this.f933a = currX;
                this.f934b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.Ea;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.a(i3, i4, iArr, (int[]) null, 1)) {
                    int[] iArr2 = RecyclerView.this.Ea;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.b(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.v != null) {
                    int[] iArr3 = recyclerView3.Ea;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.a(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.Ea;
                    i = iArr4[0];
                    i2 = iArr4[1];
                    i3 -= i;
                    i4 -= i2;
                    t tVar = recyclerView4.w.g;
                    if (tVar != null && !tVar.b() && tVar.c()) {
                        int a2 = RecyclerView.this.ra.a();
                        if (a2 == 0) {
                            tVar.d();
                        } else if (tVar.a() >= a2) {
                            tVar.a(a2 - 1);
                            tVar.a(i, i2);
                        } else {
                            tVar.a(i, i2);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.y.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.Ea;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.a(i, i2, i3, i4, (int[]) null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.Ea;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (!(i == 0 && i2 == 0)) {
                    RecyclerView.this.d(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                t tVar2 = RecyclerView.this.w.g;
                if ((tVar2 != null && tVar2.b()) || !z) {
                    a();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    q qVar = recyclerView6.pa;
                    if (qVar != null) {
                        qVar.a(recyclerView6, i5, i6);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i7, currVelocity);
                    }
                    if (RecyclerView.f) {
                        RecyclerView.this.qa.a();
                    }
                }
            }
            t tVar3 = RecyclerView.this.w.g;
            if (tVar3 != null && tVar3.b()) {
                tVar3.a(0, 0);
            }
            this.e = false;
            if (this.f) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.f(1);
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f934b = 0;
            this.f933a = 0;
            Interpolator interpolator = this.d;
            Interpolator interpolator2 = RecyclerView.j;
            if (interpolator != interpolator2) {
                this.d = interpolator2;
                this.c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.j);
            }
            this.c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.j;
            }
            if (this.d != interpolator) {
                this.d = interpolator;
                this.c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f934b = 0;
            this.f933a = 0;
            RecyclerView.this.setScrollState(2);
            this.c.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.c.computeScrollOffset();
            }
            a();
        }

        private float a(float f2) {
            return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
        }

        private int a(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i6 = width / 2;
            float f2 = (float) width;
            float f3 = (float) i6;
            float a2 = f3 + (a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / f2)) * f3);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(a2 / ((float) sqrt)) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((((float) abs) / f2) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = new r();
        this.l = new p();
        this.p = new O();
        this.r = new y(this);
        this.s = new Rect();
        this.t = new Rect();
        this.u = new RectF();
        this.y = new ArrayList<>();
        this.z = new ArrayList<>();
        this.F = 0;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.Q = 0;
        this.R = new e();
        this.W = new C0160k();
        this.aa = 0;
        this.ba = -1;
        this.la = Float.MIN_VALUE;
        this.ma = Float.MIN_VALUE;
        boolean z2 = true;
        this.na = true;
        this.oa = new w();
        this.qa = f ? new q.a() : null;
        this.ra = new u();
        this.ua = false;
        this.va = false;
        this.wa = new g();
        this.xa = false;
        this.Aa = new int[2];
        this.Ca = new int[2];
        this.Da = new int[2];
        this.Ea = new int[2];
        this.Fa = new ArrayList();
        this.Ga = new z(this);
        this.Ha = new B(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f909b, i2, 0);
            this.q = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.q = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ha = viewConfiguration.getScaledTouchSlop();
        this.la = z.a(viewConfiguration, context);
        this.ma = z.b(viewConfiguration, context);
        this.ja = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ka = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.W.a(this.wa);
        k();
        G();
        F();
        if (y.k(this) == 0) {
            y.d(this, 1);
        }
        this.L = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new H(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.m.b.RecyclerView, i2, 0);
            String string = obtainStyledAttributes2.getString(a.m.b.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(a.m.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.D = obtainStyledAttributes2.getBoolean(a.m.b.RecyclerView_fastScrollEnabled, false);
            if (this.D) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(a.m.b.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(a.m.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(a.m.b.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(a.m.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f908a, i2, 0);
                boolean z3 = obtainStyledAttributes3.getBoolean(0, true);
                obtainStyledAttributes3.recycle();
                z2 = z3;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z2);
    }

    public void i(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    public static class j extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        x f921a;

        /* renamed from: b  reason: collision with root package name */
        final Rect f922b = new Rect();
        boolean c = true;
        boolean d = false;

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.f921a.i();
        }

        public boolean b() {
            return this.f921a.t();
        }

        public boolean c() {
            return this.f921a.q();
        }

        public boolean d() {
            return this.f921a.o();
        }

        public j(int i, int i2) {
            super(i, i2);
        }

        public j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public j(j jVar) {
            super(jVar);
        }
    }

    public static class s extends a.i.a.c {
        public static final Parcelable.Creator<s> CREATOR = new G();

        /* renamed from: a  reason: collision with root package name */
        Parcelable f930a;

        s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f930a = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        /* access modifiers changed from: package-private */
        public void a(s sVar) {
            this.f930a = sVar.f930a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f930a, 0);
        }

        s(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class u {

        /* renamed from: a  reason: collision with root package name */
        int f931a = -1;

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<Object> f932b;
        int c = 0;
        int d = 0;
        int e = 1;
        int f = 0;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        boolean l = false;
        int m;
        long n;
        int o;
        int p;
        int q;

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if ((this.e & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.e));
            }
        }

        public int b() {
            return this.f931a;
        }

        public boolean c() {
            return this.f931a != -1;
        }

        public boolean d() {
            return this.h;
        }

        public boolean e() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f931a + ", mData=" + this.f932b + ", mItemCount=" + this.f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            this.e = 1;
            this.f = aVar.a();
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public int a() {
            return this.h ? this.c - this.d : this.f;
        }
    }

    public void d(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetTopAndBottom(i2);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i iVar = this.w;
        if (iVar != null) {
            return iVar.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a2 = a(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = classLoader.loadClass(a2).asSubclass(i.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(i);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((i) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e3) {
                    e3.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e8);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, int i3) {
        this.Q++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i2, i3);
        n nVar = this.sa;
        if (nVar != null) {
            nVar.a(this, i2, i3);
        }
        List<n> list = this.ta;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ta.get(size).a(this, i2, i3);
            }
        }
        this.Q--;
    }

    private boolean k(int i2, int i3) {
        a(this.Aa);
        int[] iArr = this.Aa;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    public void b(n nVar) {
        List<n> list = this.ta;
        if (list != null) {
            list.remove(nVar);
        }
    }

    public boolean e(int i2, int i3) {
        i iVar = this.w;
        int i4 = 0;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.H) {
            return false;
        } else {
            boolean a2 = iVar.a();
            boolean b2 = this.w.b();
            if (!a2 || Math.abs(i2) < this.ja) {
                i2 = 0;
            }
            if (!b2 || Math.abs(i3) < this.ja) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f2 = (float) i2;
            float f3 = (float) i3;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z2 = a2 || b2;
                dispatchNestedFling(f2, f3, z2);
                l lVar = this.ia;
                if (lVar != null && lVar.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    if (a2) {
                        i4 = 1;
                    }
                    if (b2) {
                        i4 |= 2;
                    }
                    j(i4, 1);
                    int i5 = this.ka;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.ka;
                    this.oa.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, int i3) {
        int b2 = this.o.b();
        for (int i4 = 0; i4 < b2; i4++) {
            x g2 = g(this.o.d(i4));
            if (g2 != null && !g2.y() && g2.d >= i2) {
                g2.a(i3, false);
                this.ra.g = true;
            }
        }
        this.l.a(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void g(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int b2 = this.o.b();
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i8 = 0; i8 < b2; i8++) {
            x g2 = g(this.o.d(i8));
            if (g2 != null && (i7 = g2.d) >= i6 && i7 <= i5) {
                if (i7 == i2) {
                    g2.a(i3 - i2, false);
                } else {
                    g2.a(i4, false);
                }
                this.ra.g = true;
            }
        }
        this.l.b(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public Rect h(View view) {
        j jVar = (j) view.getLayoutParams();
        if (!jVar.c) {
            return jVar.f922b;
        }
        if (this.ra.d() && (jVar.b() || jVar.d())) {
            return jVar.f922b;
        }
        Rect rect = jVar.f922b;
        rect.set(0, 0, 0, 0);
        int size = this.y.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.s.set(0, 0, 0, 0);
            this.y.get(i2).a(this.s, view, this, this.ra);
            int i3 = rect.left;
            Rect rect2 = this.s;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        jVar.c = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.E || this.N) {
            a.g.e.a.a("RV FullInvalidate");
            c();
            a.g.e.a.a();
        } else if (this.n.c()) {
            if (this.n.c(4) && !this.n.c(11)) {
                a.g.e.a.a("RV PartialInvalidate");
                w();
                q();
                this.n.e();
                if (!this.G) {
                    if (E()) {
                        c();
                    } else {
                        this.n.a();
                    }
                }
                c(true);
                r();
                a.g.e.a.a();
            } else if (this.n.c()) {
                a.g.e.a.a("RV FullInvalidate");
                c();
                a.g.e.a.a();
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ba) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.ba = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.fa = x2;
            this.da = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.ga = y2;
            this.ea = y2;
        }
    }

    public x f(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return g(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    static x g(View view) {
        if (view == null) {
            return null;
        }
        return ((j) view.getLayoutParams()).f921a;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, int i3) {
        setMeasuredDimension(i.a(i2, getPaddingLeft() + getPaddingRight(), y.o(this)), i.a(i3, getPaddingTop() + getPaddingBottom(), y.n(this)));
    }

    /* access modifiers changed from: package-private */
    public void d() {
        int i2;
        for (int size = this.Fa.size() - 1; size >= 0; size--) {
            x xVar = this.Fa.get(size);
            if (xVar.f936b.getParent() == this && !xVar.y() && (i2 = xVar.r) != -1) {
                y.d(xVar.f936b, i2);
                xVar.r = -1;
            }
        }
        this.Fa.clear();
    }

    public void f(int i2) {
        getScrollingChildHelper().c(i2);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.V == null) {
            this.V = this.R.a(this, 3);
            if (this.q) {
                this.V.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.V.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.v == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.w == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            u uVar = this.ra;
            uVar.j = false;
            if (uVar.e == 1) {
                A();
                this.w.e(this);
                B();
            } else if (!this.n.d() && this.w.q() == getWidth() && this.w.h() == getHeight()) {
                this.w.e(this);
            } else {
                this.w.e(this);
                B();
            }
            C();
        }
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private void a(a aVar, boolean z2, boolean z3) {
        a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.b((c) this.k);
            this.v.b(this);
        }
        if (!z2 || z3) {
            t();
        }
        this.n.f();
        a aVar3 = this.v;
        this.v = aVar;
        if (aVar != null) {
            aVar.a((c) this.k);
            aVar.a(this);
        }
        i iVar = this.w;
        if (iVar != null) {
            iVar.a(aVar3, this.v);
        }
        this.l.a(aVar3, this.v, z2);
        this.ra.g = true;
    }

    static RecyclerView e(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView e2 = e(viewGroup.getChildAt(i2));
            if (e2 != null) {
                return e2;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.S;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.S.onRelease();
            z2 = this.S.isFinished();
        }
        EdgeEffect edgeEffect2 = this.U;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.U.onRelease();
            z2 |= this.U.isFinished();
        }
        EdgeEffect edgeEffect3 = this.T;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.T.onRelease();
            z2 |= this.T.isFinished();
        }
        EdgeEffect edgeEffect4 = this.V;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.V.onRelease();
            z2 |= this.V.isFinished();
        }
        if (z2) {
            y.E(this);
        }
    }

    public View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public void a(h hVar, int i2) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.y.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.y.add(hVar);
        } else {
            this.y.add(i2, hVar);
        }
        o();
        requestLayout();
    }

    public void c(int i2) {
        int a2 = this.o.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.o.c(i3).offsetLeftAndRight(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public int c(x xVar) {
        if (xVar.b(524) || !xVar.n()) {
            return -1;
        }
        return this.n.a(xVar.d);
    }

    public void b(m mVar) {
        this.z.remove(mVar);
        if (this.A == mVar) {
            this.A = null;
        }
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.z.size();
        int i2 = 0;
        while (i2 < size) {
            m mVar = this.z.get(i2);
            if (!mVar.b(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.A = mVar;
                return true;
            }
        }
        return false;
    }

    public void a(h hVar) {
        a(hVar, -1);
    }

    public void a(n nVar) {
        if (this.ta == null) {
            this.ta = new ArrayList();
        }
        this.ta.add(nVar);
    }

    /* access modifiers changed from: package-private */
    public void b(x xVar, f.c cVar, f.c cVar2) {
        e(xVar);
        xVar.a(false);
        if (this.W.b(xVar, cVar, cVar2)) {
            s();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int[] iArr) {
        w();
        q();
        a.g.e.a.a("RV Scroll");
        a(this.ra);
        int a2 = i2 != 0 ? this.w.a(i2, this.l, this.ra) : 0;
        int b2 = i3 != 0 ? this.w.b(i3, this.l, this.ra) : 0;
        a.g.e.a.a();
        u();
        r();
        c(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.O = z2 | this.O;
        this.N = true;
        p();
    }

    public x b(int i2) {
        x xVar = null;
        if (this.N) {
            return null;
        }
        int b2 = this.o.b();
        for (int i3 = 0; i3 < b2; i3++) {
            x g2 = g(this.o.d(i3));
            if (g2 != null && !g2.q() && c(g2) == i2) {
                if (!this.o.c(g2.f936b)) {
                    return g2;
                }
                xVar = g2;
            }
        }
        return xVar;
    }

    static void b(View view, Rect rect) {
        j jVar = (j) view.getLayoutParams();
        Rect rect2 = jVar.f922b;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b5, code lost:
        if (r0 != 0) goto L_0x00ba;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r22, int r23, android.view.MotionEvent r24) {
        /*
            r21 = this;
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r21.b()
            androidx.recyclerview.widget.RecyclerView$a r0 = r8.v
            r12 = 1
            r13 = 0
            if (r0 == 0) goto L_0x0029
            int[] r0 = r8.Ea
            r0[r13] = r13
            r0[r12] = r13
            r8.a((int) r9, (int) r10, (int[]) r0)
            int[] r0 = r8.Ea
            r1 = r0[r13]
            r0 = r0[r12]
            int r2 = r9 - r1
            int r3 = r10 - r0
            r6 = r0
            r7 = r1
            r14 = r2
            r15 = r3
            goto L_0x002d
        L_0x0029:
            r6 = 0
            r7 = 0
            r14 = 0
            r15 = 0
        L_0x002d:
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$h> r0 = r8.y
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0038
            r21.invalidate()
        L_0x0038:
            int[] r5 = r8.Ea
            r5[r13] = r13
            r5[r12] = r13
            int[] r4 = r8.Ca
            r16 = 0
            r0 = r21
            r1 = r7
            r2 = r6
            r3 = r14
            r17 = r4
            r4 = r15
            r18 = r5
            r5 = r17
            r19 = r6
            r6 = r16
            r20 = r7
            r7 = r18
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            int[] r0 = r8.Ea
            r1 = r0[r13]
            int r14 = r14 - r1
            r0 = r0[r12]
            int r15 = r15 - r0
            int r0 = r8.fa
            int[] r1 = r8.Ca
            r2 = r1[r13]
            int r0 = r0 - r2
            r8.fa = r0
            int r0 = r8.ga
            r2 = r1[r12]
            int r0 = r0 - r2
            r8.ga = r0
            if (r11 == 0) goto L_0x007c
            r0 = r1[r13]
            float r0 = (float) r0
            r1 = r1[r12]
            float r1 = (float) r1
            r11.offsetLocation(r0, r1)
        L_0x007c:
            int[] r0 = r8.Da
            r1 = r0[r13]
            int[] r2 = r8.Ca
            r3 = r2[r13]
            int r1 = r1 + r3
            r0[r13] = r1
            r1 = r0[r12]
            r2 = r2[r12]
            int r1 = r1 + r2
            r0[r12] = r1
            int r0 = r21.getOverScrollMode()
            r1 = 2
            if (r0 == r1) goto L_0x00af
            if (r11 == 0) goto L_0x00ac
            r0 = 8194(0x2002, float:1.1482E-41)
            boolean r0 = a.g.i.C0044h.a(r11, r0)
            if (r0 != 0) goto L_0x00ac
            float r0 = r24.getX()
            float r1 = (float) r14
            float r2 = r24.getY()
            float r3 = (float) r15
            r8.a((float) r0, (float) r1, (float) r2, (float) r3)
        L_0x00ac:
            r21.b((int) r22, (int) r23)
        L_0x00af:
            r1 = r20
            if (r1 != 0) goto L_0x00b8
            r0 = r19
            if (r0 == 0) goto L_0x00bd
            goto L_0x00ba
        L_0x00b8:
            r0 = r19
        L_0x00ba:
            r8.d(r1, r0)
        L_0x00bd:
            boolean r2 = r21.awakenScrollBars()
            if (r2 != 0) goto L_0x00c6
            r21.invalidate()
        L_0x00c6:
            if (r1 != 0) goto L_0x00cc
            if (r0 == 0) goto L_0x00cb
            goto L_0x00cc
        L_0x00cb:
            r12 = 0
        L_0x00cc:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(int, int, android.view.MotionEvent):boolean");
    }

    static void b(x xVar) {
        WeakReference<RecyclerView> weakReference = xVar.c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view != xVar.f936b) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            xVar.c = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        x g2 = g(view);
        j(view);
        a aVar = this.v;
        if (!(aVar == null || g2 == null)) {
            aVar.c(g2);
        }
        List<k> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.M.get(size).a(view);
            }
        }
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        i iVar = this.w;
        if (iVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.H) {
            if (!iVar.a()) {
                i2 = 0;
            }
            if (!this.w.b()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                this.oa.a(i2, i3, Integer.MIN_VALUE, interpolator);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.f()
            android.widget.EdgeEffect r3 = r6.S
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.d.a(r3, r4, r9)
        L_0x001f:
            r9 = 1
            goto L_0x003c
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            r6.g()
            android.widget.EdgeEffect r3 = r6.U
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.d.a(r3, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0056
            r6.h()
            android.widget.EdgeEffect r9 = r6.T
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.d.a(r9, r0, r7)
            goto L_0x0072
        L_0x0056:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0071
            r6.e()
            android.widget.EdgeEffect r9 = r6.V
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.d.a(r9, r3, r0)
            goto L_0x0072
        L_0x0071:
            r1 = r9
        L_0x0072:
            if (r1 != 0) goto L_0x007c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            a.g.i.y.E(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(float, float, float, float):void");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        if (i2 < 0) {
            f();
            if (this.S.isFinished()) {
                this.S.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            g();
            if (this.U.isFinished()) {
                this.U.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            h();
            if (this.T.isFinished()) {
                this.T.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            e();
            if (this.V.isFinished()) {
                this.V.onAbsorb(i3);
            }
        }
        if (i2 != 0 || i3 != 0) {
            y.E(this);
        }
    }

    private boolean a(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.s.set(0, 0, view.getWidth(), view.getHeight());
        this.t.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.s);
        offsetDescendantRectToMyCoords(view2, this.t);
        char c2 = 65535;
        int i4 = this.w.j() == 1 ? -1 : 1;
        Rect rect = this.s;
        int i5 = rect.left;
        int i6 = this.t.left;
        if ((i5 < i6 || rect.right <= i6) && this.s.right < this.t.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.s;
            int i7 = rect2.right;
            int i8 = this.t.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.s.left > this.t.left) ? -1 : 0;
        }
        Rect rect3 = this.s;
        int i9 = rect3.top;
        int i10 = this.t.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.s.bottom < this.t.bottom) {
            c2 = 1;
        } else {
            Rect rect4 = this.s;
            int i11 = rect4.bottom;
            int i12 = this.t.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.s.top <= this.t.top) {
                c2 = 0;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 != 66) {
                            if (i2 != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i2 + i());
                            } else if (c2 > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i3 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c2 < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i3 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c2 > 0 || (c2 == 0 && i3 * i4 >= 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c2 < 0 || (c2 == 0 && i3 * i4 <= 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.s.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof j) {
            j jVar = (j) layoutParams;
            if (!jVar.c) {
                Rect rect = jVar.f922b;
                Rect rect2 = this.s;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.s);
            offsetRectIntoDescendantCoords(view, this.s);
        }
        this.w.a(this, view, this.s, !this.E, view2 == null);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (n()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + i());
            }
            throw new IllegalStateException(str);
        } else if (this.Q > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(BuildConfig.FLAVOR + i()));
        }
    }

    public void a(m mVar) {
        this.z.add(mVar);
    }

    private boolean a(MotionEvent motionEvent) {
        m mVar = this.A;
        if (mVar != null) {
            mVar.a(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.A = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return b(motionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.P--;
        if (this.P < 1) {
            this.P = 0;
            if (z2) {
                z();
                d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(AccessibilityEvent accessibilityEvent) {
        if (!n()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? a.g.i.a.b.a(accessibilityEvent) : 0;
        if (a2 == 0) {
            a2 = 0;
        }
        this.J = a2 | this.J;
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a(u uVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.oa.c;
            uVar.p = overScroller.getFinalX() - overScroller.getCurrX();
            uVar.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        uVar.p = 0;
        uVar.q = 0;
    }

    private void a(long j2, x xVar, x xVar2) {
        int a2 = this.o.a();
        for (int i2 = 0; i2 < a2; i2++) {
            x g2 = g(this.o.c(i2));
            if (g2 != xVar && d(g2) == j2) {
                a aVar = this.v;
                if (aVar == null || !aVar.b()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + g2 + " \n View Holder 2:" + xVar + i());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + g2 + " \n View Holder 2:" + xVar + i());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + xVar2 + " cannot be found but it is necessary for " + xVar + i());
    }

    /* access modifiers changed from: package-private */
    public void a(x xVar, f.c cVar) {
        xVar.a(0, 8192);
        if (this.ra.i && xVar.t() && !xVar.q() && !xVar.y()) {
            this.p.a(d(xVar), xVar);
        }
        this.p.c(xVar, cVar);
    }

    private void a(int[] iArr) {
        int a2 = this.o.a();
        if (a2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            x g2 = g(this.o.c(i4));
            if (!g2.y()) {
                int i5 = g2.i();
                if (i5 < i2) {
                    i2 = i5;
                }
                if (i5 > i3) {
                    i3 = i5;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    /* access modifiers changed from: package-private */
    public void a(x xVar, f.c cVar, f.c cVar2) {
        xVar.a(false);
        if (this.W.a(xVar, cVar, cVar2)) {
            s();
        }
    }

    private void a(x xVar, x xVar2, f.c cVar, f.c cVar2, boolean z2, boolean z3) {
        xVar.a(false);
        if (z2) {
            e(xVar);
        }
        if (xVar != xVar2) {
            if (z3) {
                e(xVar2);
            }
            xVar.i = xVar2;
            e(xVar);
            this.l.c(xVar);
            xVar2.a(false);
            xVar2.j = xVar;
        }
        if (this.W.a(xVar, xVar2, cVar, cVar2)) {
            s();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int b2 = this.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            x g2 = g(this.o.d(i2));
            if (!g2.y()) {
                g2.a();
            }
        }
        this.l.b();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int b2 = this.o.b();
        for (int i5 = 0; i5 < b2; i5++) {
            x g2 = g(this.o.d(i5));
            if (g2 != null && !g2.y()) {
                int i6 = g2.d;
                if (i6 >= i4) {
                    g2.a(-i3, z2);
                    this.ra.g = true;
                } else if (i6 >= i2) {
                    g2.a(i2 - 1, -i3, z2);
                    this.ra.g = true;
                }
            }
        }
        this.l.a(i2, i3, z2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, Object obj) {
        int i4;
        int b2 = this.o.b();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < b2; i6++) {
            View d2 = this.o.d(i6);
            x g2 = g(d2);
            if (g2 != null && !g2.y() && (i4 = g2.d) >= i2 && i4 < i5) {
                g2.a(2);
                g2.a(obj);
                ((j) d2.getLayoutParams()).c = true;
            }
        }
        this.l.c(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public boolean a(x xVar) {
        f fVar = this.W;
        return fVar == null || fVar.a(xVar, xVar.k());
    }

    /* access modifiers changed from: package-private */
    public x a(int i2, boolean z2) {
        int b2 = this.o.b();
        x xVar = null;
        for (int i3 = 0; i3 < b2; i3++) {
            x g2 = g(this.o.d(i3));
            if (g2 != null && !g2.q()) {
                if (z2) {
                    if (g2.d != i2) {
                        continue;
                    }
                } else if (g2.i() != i2) {
                    continue;
                }
                if (!this.o.c(g2.f936b)) {
                    return g2;
                }
                xVar = g2;
            }
        }
        return xVar;
    }

    public x a(long j2) {
        a aVar = this.v;
        x xVar = null;
        if (aVar != null && aVar.b()) {
            int b2 = this.o.b();
            for (int i2 = 0; i2 < b2; i2++) {
                x g2 = g(this.o.d(i2));
                if (g2 != null && !g2.q() && g2.g() == j2) {
                    if (!this.o.c(g2.f936b)) {
                        return g2;
                    }
                    xVar = g2;
                }
            }
        }
        return xVar;
    }

    public void a(View view, Rect rect) {
        b(view, rect);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        i iVar = this.w;
        if (iVar != null) {
            iVar.f(i2);
        }
        e(i2);
        n nVar = this.sa;
        if (nVar != null) {
            nVar.a(this, i2);
        }
        List<n> list = this.ta;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ta.get(size).a(this, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        x g2 = g(view);
        i(view);
        a aVar = this.v;
        if (!(aVar == null || g2 == null)) {
            aVar.b(g2);
        }
        List<k> list = this.M;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.M.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(x xVar, int i2) {
        if (n()) {
            xVar.r = i2;
            this.Fa.add(xVar);
            return false;
        }
        y.d(xVar.f936b, i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + i());
        }
        Resources resources = getContext().getResources();
        new C0164o(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(a.m.a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.m.a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.m.a.fastscroll_margin));
    }

    public final void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }
}
