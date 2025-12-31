package androidx.fragment.app;

import a.g.i.r;
import a.g.i.y;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.fragment.app.C0132h;
import androidx.fragment.app.C0139o;
import androidx.lifecycle.D;
import androidx.lifecycle.E;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class w extends C0139o implements LayoutInflater.Factory2 {
    static boolean c = false;
    static Field d;
    static final Interpolator e = new DecelerateInterpolator(2.5f);
    static final Interpolator f = new DecelerateInterpolator(1.5f);
    boolean A;
    ArrayList<C0125a> B;
    ArrayList<Boolean> C;
    ArrayList<C0132h> D;
    Bundle E = null;
    SparseArray<Parcelable> F = null;
    ArrayList<j> G;
    private A H;
    Runnable I = new C0140p(this);
    ArrayList<h> g;
    boolean h;
    int i = 0;
    final ArrayList<C0132h> j = new ArrayList<>();
    final HashMap<String, C0132h> k = new HashMap<>();
    ArrayList<C0125a> l;
    ArrayList<C0132h> m;
    ArrayList<C0125a> n;
    ArrayList<Integer> o;
    ArrayList<C0139o.c> p;
    private final CopyOnWriteArrayList<f> q = new CopyOnWriteArrayList<>();
    int r = 0;
    C0138n s;
    C0135k t;
    C0132h u;
    C0132h v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;

    private static class a extends b {

        /* renamed from: b  reason: collision with root package name */
        View f824b;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f824b = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (y.z(this.f824b) || Build.VERSION.SDK_INT >= 24) {
                this.f824b.post(new v(this));
            } else {
                this.f824b.setLayerType(0, (Paint) null);
            }
            super.onAnimationEnd(animation);
        }
    }

    private static class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        private final Animation.AnimationListener f825a;

        b(Animation.AnimationListener animationListener) {
            this.f825a = animationListener;
        }

        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f825a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f825a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f825a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    private static class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        View f828a;

        d(View view) {
            this.f828a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f828a.setLayerType(0, (Paint) null);
            animator.removeListener(this);
        }

        public void onAnimationStart(Animator animator) {
            this.f828a.setLayerType(2, (Paint) null);
        }
    }

    private static final class f {

        /* renamed from: a  reason: collision with root package name */
        final C0139o.b f831a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f832b;
    }

    static class g {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f833a = {16842755, 16842960, 16842961};
    }

    interface h {
        boolean a(ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class i implements h {

        /* renamed from: a  reason: collision with root package name */
        final String f834a;

        /* renamed from: b  reason: collision with root package name */
        final int f835b;
        final int c;

        i(String str, int i, int i2) {
            this.f834a = str;
            this.f835b = i;
            this.c = i2;
        }

        public boolean a(ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2) {
            C0139o T;
            C0132h hVar = w.this.v;
            if (hVar != null && this.f835b < 0 && this.f834a == null && (T = hVar.T()) != null && T.e()) {
                return false;
            }
            return w.this.a(arrayList, arrayList2, this.f834a, this.f835b, this.c);
        }
    }

    static class j implements C0132h.c {

        /* renamed from: a  reason: collision with root package name */
        final boolean f836a;

        /* renamed from: b  reason: collision with root package name */
        final C0125a f837b;
        private int c;

        j(C0125a aVar, boolean z) {
            this.f836a = z;
            this.f837b = aVar;
        }

        public void a() {
            this.c++;
        }

        public void b() {
            this.c--;
            if (this.c == 0) {
                this.f837b.f794a.w();
            }
        }

        public void c() {
            C0125a aVar = this.f837b;
            aVar.f794a.a(aVar, this.f836a, false, false);
        }

        public void d() {
            boolean z = this.c > 0;
            w wVar = this.f837b.f794a;
            int size = wVar.j.size();
            for (int i = 0; i < size; i++) {
                C0132h hVar = wVar.j.get(i);
                hVar.a((C0132h.c) null);
                if (z && hVar.I()) {
                    hVar.ga();
                }
            }
            C0125a aVar = this.f837b;
            aVar.f794a.a(aVar, this.f836a, !z, true);
        }

        public boolean e() {
            return this.c == 0;
        }
    }

    w() {
    }

    private void A() {
        this.h = false;
        this.C.clear();
        this.B.clear();
    }

    private void B() {
        for (C0132h next : this.k.values()) {
            if (next != null) {
                if (next.i() != null) {
                    int B2 = next.B();
                    View i2 = next.i();
                    Animation animation = i2.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        i2.clearAnimation();
                    }
                    next.b((View) null);
                    a(next, B2, 0, 0, false);
                } else if (next.j() != null) {
                    next.j().end();
                }
            }
        }
    }

    private void C() {
        if (this.G != null) {
            while (!this.G.isEmpty()) {
                this.G.remove(0).d();
            }
        }
    }

    static boolean a(c cVar) {
        Animation animation = cVar.f826a;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return a(cVar.f827b);
        }
        List<Animation> animations = ((AnimationSet) animation).getAnimations();
        for (int i2 = 0; i2 < animations.size(); i2++) {
            if (animations.get(i2) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    public static int b(int i2, boolean z2) {
        if (i2 == 4097) {
            return z2 ? 1 : 2;
        }
        if (i2 == 4099) {
            return z2 ? 5 : 6;
        }
        if (i2 != 8194) {
            return -1;
        }
        return z2 ? 3 : 4;
    }

    public static int d(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private C0132h t(C0132h hVar) {
        ViewGroup viewGroup = hVar.F;
        View view = hVar.G;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.j.indexOf(hVar) - 1; indexOf >= 0; indexOf--) {
                C0132h hVar2 = this.j.get(indexOf);
                if (hVar2.F == viewGroup && hVar2.G != null) {
                    return hVar2;
                }
            }
        }
        return null;
    }

    private void y() {
        this.k.values().removeAll(Collections.singleton((Object) null));
    }

    private void z() {
        if (s()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public boolean b() {
        boolean p2 = p();
        C();
        return p2;
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2) {
        return this.r >= i2;
    }

    public List<C0132h> d() {
        List<C0132h> list;
        if (this.j.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.j) {
            list = (List) this.j.clone();
        }
        return list;
    }

    public boolean e() {
        z();
        return a((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public A f(C0132h hVar) {
        return this.H.c(hVar);
    }

    /* access modifiers changed from: package-private */
    public D g(C0132h hVar) {
        return this.H.d(hVar);
    }

    public void h(C0132h hVar) {
        if (c) {
            Log.v("FragmentManager", "hide: " + hVar);
        }
        if (!hVar.y) {
            hVar.y = true;
            hVar.M = true ^ hVar.M;
        }
    }

    /* access modifiers changed from: package-private */
    public void i(C0132h hVar) {
        if (this.k.get(hVar.f) == null) {
            this.k.put(hVar.f, hVar);
            if (hVar.B) {
                if (hVar.A) {
                    a(hVar);
                } else {
                    o(hVar);
                }
                hVar.B = false;
            }
            if (c) {
                Log.v("FragmentManager", "Added fragment to active set " + hVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j(C0132h hVar) {
        if (this.k.get(hVar.f) != null) {
            if (c) {
                Log.v("FragmentManager", "Removed fragment from active set " + hVar);
            }
            for (C0132h next : this.k.values()) {
                if (next != null && hVar.f.equals(next.i)) {
                    next.h = hVar;
                    next.i = null;
                }
            }
            this.k.put(hVar.f, (Object) null);
            o(hVar);
            String str = hVar.i;
            if (str != null) {
                hVar.h = this.k.get(str);
            }
            hVar.E();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r0 = r0.G;
        r1 = r11.F;
        r0 = r1.indexOfChild(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(androidx.fragment.app.C0132h r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r10.r
            boolean r1 = r11.l
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001a
            boolean r1 = r11.H()
            if (r1 == 0) goto L_0x0016
            int r0 = java.lang.Math.min(r0, r2)
            goto L_0x001a
        L_0x0016:
            int r0 = java.lang.Math.min(r0, r3)
        L_0x001a:
            r6 = r0
            int r7 = r11.t()
            int r8 = r11.u()
            r9 = 0
            r4 = r10
            r5 = r11
            r4.a((androidx.fragment.app.C0132h) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
            android.view.View r0 = r11.G
            if (r0 == 0) goto L_0x008c
            androidx.fragment.app.h r0 = r10.t(r11)
            if (r0 == 0) goto L_0x004b
            android.view.View r0 = r0.G
            android.view.ViewGroup r1 = r11.F
            int r0 = r1.indexOfChild(r0)
            android.view.View r4 = r11.G
            int r4 = r1.indexOfChild(r4)
            if (r4 >= r0) goto L_0x004b
            r1.removeViewAt(r4)
            android.view.View r4 = r11.G
            r1.addView(r4, r0)
        L_0x004b:
            boolean r0 = r11.L
            if (r0 == 0) goto L_0x008c
            android.view.ViewGroup r0 = r11.F
            if (r0 == 0) goto L_0x008c
            float r0 = r11.N
            r1 = 0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L_0x005f
            android.view.View r4 = r11.G
            r4.setAlpha(r0)
        L_0x005f:
            r11.N = r1
            r11.L = r3
            int r0 = r11.t()
            int r1 = r11.u()
            androidx.fragment.app.w$c r0 = r10.a((androidx.fragment.app.C0132h) r11, (int) r0, (boolean) r2, (int) r1)
            if (r0 == 0) goto L_0x008c
            android.view.View r1 = r11.G
            b((android.view.View) r1, (androidx.fragment.app.w.c) r0)
            android.view.animation.Animation r1 = r0.f826a
            if (r1 == 0) goto L_0x0080
            android.view.View r0 = r11.G
            r0.startAnimation(r1)
            goto L_0x008c
        L_0x0080:
            android.animation.Animator r1 = r0.f827b
            android.view.View r2 = r11.G
            r1.setTarget(r2)
            android.animation.Animator r0 = r0.f827b
            r0.start()
        L_0x008c:
            boolean r0 = r11.M
            if (r0 == 0) goto L_0x0093
            r10.c((androidx.fragment.app.C0132h) r11)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.w.k(androidx.fragment.app.h):void");
    }

    /* access modifiers changed from: package-private */
    public void l(C0132h hVar) {
        a(hVar, this.r, 0, 0, false);
    }

    public void m(C0132h hVar) {
        if (!hVar.I) {
            return;
        }
        if (this.h) {
            this.A = true;
            return;
        }
        hVar.I = false;
        a(hVar, this.r, 0, 0, false);
    }

    public void n(C0132h hVar) {
        if (c) {
            Log.v("FragmentManager", "remove: " + hVar + " nesting=" + hVar.q);
        }
        boolean z2 = !hVar.H();
        if (!hVar.z || z2) {
            synchronized (this.j) {
                this.j.remove(hVar);
            }
            if (hVar.C && hVar.D) {
                this.w = true;
            }
            hVar.k = false;
            hVar.l = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void o(C0132h hVar) {
        this.H.e(hVar);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        C0132h hVar;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        C0132h hVar2 = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue((String) null, "class");
        Context context2 = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, g.f833a);
        int i2 = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str3 == null || !C0137m.b(context.getClassLoader(), str3)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str3);
        }
        if (resourceId != -1) {
            hVar2 = a(resourceId);
        }
        if (hVar2 == null && string != null) {
            hVar2 = a(string);
        }
        if (hVar2 == null && i2 != -1) {
            hVar2 = a(i2);
        }
        if (c) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str3 + " existing=" + hVar2);
        }
        if (hVar2 == null) {
            C0132h a2 = c().a(context.getClassLoader(), str3);
            a2.m = true;
            a2.v = resourceId != 0 ? resourceId : i2;
            a2.w = i2;
            a2.x = string;
            a2.n = true;
            a2.r = this;
            C0138n nVar = this.s;
            a2.s = nVar;
            a2.a(nVar.d(), attributeSet2, a2.c);
            a(a2, true);
            hVar = a2;
        } else if (!hVar2.n) {
            hVar2.n = true;
            C0138n nVar2 = this.s;
            hVar2.s = nVar2;
            hVar2.a(nVar2.d(), attributeSet2, hVar2.c);
            hVar = hVar2;
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i2) + " with another fragment for " + str3);
        }
        if (this.r >= 1 || !hVar.m) {
            l(hVar);
        } else {
            a(hVar, 1, 0, 0, false);
        }
        View view2 = hVar.G;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (hVar.G.getTag() == null) {
                hVar.G.setTag(string);
            }
            return hVar.G;
        }
        throw new IllegalStateException("Fragment " + str3 + " did not create a view.");
    }

    /* JADX INFO: finally extract failed */
    public boolean p() {
        c(true);
        boolean z2 = false;
        while (b(this.B, this.C)) {
            this.h = true;
            try {
                c(this.B, this.C);
                A();
                z2 = true;
            } catch (Throwable th) {
                A();
                throw th;
            }
        }
        o();
        y();
        return z2;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 q() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public void q(C0132h hVar) {
        if (hVar.H != null) {
            SparseArray<Parcelable> sparseArray = this.F;
            if (sparseArray == null) {
                this.F = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            hVar.H.saveHierarchyState(this.F);
            if (this.F.size() > 0) {
                hVar.d = this.F;
                this.F = null;
            }
        }
    }

    public void r(C0132h hVar) {
        if (hVar == null || (this.k.get(hVar.f) == hVar && (hVar.s == null || hVar.r() == this))) {
            this.v = hVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + hVar + " is not an active fragment of FragmentManager " + this);
    }

    public void s(C0132h hVar) {
        if (c) {
            Log.v("FragmentManager", "show: " + hVar);
        }
        if (hVar.y) {
            hVar.y = false;
            hVar.M = !hVar.M;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0132h hVar = this.u;
        if (hVar != null) {
            a.g.h.a.a(hVar, sb);
        } else {
            a.g.h.a.a(this.s, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        if (this.p != null) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                this.p.get(i2).onBackStackChanged();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Parcelable v() {
        ArrayList<String> arrayList;
        int size;
        C();
        B();
        p();
        this.x = true;
        C0127c[] cVarArr = null;
        if (this.k.isEmpty()) {
            return null;
        }
        ArrayList<C> arrayList2 = new ArrayList<>(this.k.size());
        boolean z2 = false;
        for (C0132h next : this.k.values()) {
            if (next != null) {
                if (next.r == this) {
                    C c2 = new C(next);
                    arrayList2.add(c2);
                    if (next.f804b <= 0 || c2.k != null) {
                        c2.k = next.c;
                    } else {
                        c2.k = p(next);
                        String str = next.i;
                        if (str != null) {
                            C0132h hVar = this.k.get(str);
                            if (hVar != null) {
                                if (c2.k == null) {
                                    c2.k = new Bundle();
                                }
                                a(c2.k, "android:target_state", hVar);
                                int i2 = next.j;
                                if (i2 != 0) {
                                    c2.k.putInt("android:target_req_state", i2);
                                }
                            } else {
                                a((RuntimeException) new IllegalStateException("Failure saving state: " + next + " has target not in fragment manager: " + next.i));
                                throw null;
                            }
                        }
                    }
                    if (c) {
                        Log.v("FragmentManager", "Saved state of " + next + ": " + c2.k);
                    }
                    z2 = true;
                } else {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                    throw null;
                }
            }
        }
        if (!z2) {
            if (c) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.j.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<C0132h> it = this.j.iterator();
            while (it.hasNext()) {
                C0132h next2 = it.next();
                arrayList.add(next2.f);
                if (next2.r != this) {
                    a((RuntimeException) new IllegalStateException("Failure saving state: active " + next2 + " was removed from the FragmentManager"));
                    throw null;
                } else if (c) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next2.f + "): " + next2);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<C0125a> arrayList3 = this.l;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            cVarArr = new C0127c[size];
            for (int i3 = 0; i3 < size; i3++) {
                cVarArr[i3] = new C0127c(this.l.get(i3));
                if (c) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.l.get(i3));
                }
            }
        }
        y yVar = new y();
        yVar.f838a = arrayList2;
        yVar.f839b = arrayList;
        yVar.c = cVarArr;
        C0132h hVar2 = this.v;
        if (hVar2 != null) {
            yVar.d = hVar2.f;
        }
        yVar.e = this.i;
        return yVar;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        synchronized (this) {
            boolean z2 = false;
            boolean z3 = this.G != null && !this.G.isEmpty();
            if (this.g != null && this.g.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.s.e().removeCallbacks(this.I);
                this.s.e().post(this.I);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        for (C0132h next : this.k.values()) {
            if (next != null) {
                m(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(C0132h hVar) {
        Animator animator;
        if (hVar.G != null) {
            c a2 = a(hVar, hVar.t(), !hVar.y, hVar.u());
            if (a2 == null || (animator = a2.f827b) == null) {
                if (a2 != null) {
                    b(hVar.G, a2);
                    hVar.G.startAnimation(a2.f826a);
                    a2.f826a.start();
                }
                hVar.G.setVisibility((!hVar.y || hVar.G()) ? 0 : 8);
                if (hVar.G()) {
                    hVar.f(false);
                }
            } else {
                animator.setTarget(hVar.G);
                if (!hVar.y) {
                    hVar.G.setVisibility(0);
                } else if (hVar.G()) {
                    hVar.f(false);
                } else {
                    ViewGroup viewGroup = hVar.F;
                    View view = hVar.G;
                    viewGroup.startViewTransition(view);
                    a2.f827b.addListener(new C0143t(this, viewGroup, view, hVar));
                }
                b(hVar.G, a2);
                a2.f827b.start();
            }
        }
        if (hVar.k && hVar.C && hVar.D) {
            this.w = true;
        }
        hVar.M = false;
        hVar.a(hVar.y);
    }

    public void f() {
        this.x = false;
        this.y = false;
        e(2);
    }

    public void g() {
        this.x = false;
        this.y = false;
        e(1);
    }

    public void l() {
        this.x = false;
        this.y = false;
        e(4);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        if (this.A) {
            this.A = false;
            x();
        }
    }

    private static void b(View view, c cVar) {
        if (view != null && cVar != null && a(view, cVar)) {
            Animator animator = cVar.f827b;
            if (animator != null) {
                animator.addListener(new d(view));
                return;
            }
            Animation.AnimationListener a2 = a(cVar.f826a);
            view.setLayerType(2, (Paint) null);
            cVar.f826a.setAnimationListener(new a(view, a2));
        }
    }

    /* access modifiers changed from: package-private */
    public void e(C0132h hVar) {
        if (hVar.m && !hVar.p) {
            hVar.b(hVar.i(hVar.c), (ViewGroup) null, hVar.c);
            View view = hVar.G;
            if (view != null) {
                hVar.H = view;
                view.setSaveFromParentEnabled(false);
                if (hVar.y) {
                    hVar.G.setVisibility(8);
                }
                hVar.a(hVar.G, hVar.c);
                a(hVar, hVar.G, hVar.c, false);
                return;
            }
            hVar.H = null;
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f826a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f827b;

        c(Animation animation) {
            this.f826a = animation;
            this.f827b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        c(Animator animator) {
            this.f826a = null;
            this.f827b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(C0132h hVar, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).f(hVar, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.e(this, hVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(C0132h hVar, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).g(hVar, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.f(this, hVar);
            }
        }
    }

    public void h() {
        this.z = true;
        p();
        e(0);
        this.s = null;
        this.t = null;
        this.u = null;
    }

    public C0132h r() {
        return this.v;
    }

    public boolean s() {
        return this.x || this.y;
    }

    private static class e extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f829a;

        /* renamed from: b  reason: collision with root package name */
        private final View f830b;
        private boolean c;
        private boolean d;
        private boolean e = true;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f829a = viewGroup;
            this.f830b = view;
            addAnimation(animation);
            this.f829a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                r.a(this.f829a, this);
            }
            return true;
        }

        public void run() {
            if (this.c || !this.e) {
                this.f829a.endViewTransition(this.f830b);
                this.d = true;
                return;
            }
            this.e = false;
            this.f829a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                r.a(this.f829a, this);
            }
            return true;
        }
    }

    public void d(C0132h hVar) {
        if (c) {
            Log.v("FragmentManager", "detach: " + hVar);
        }
        if (!hVar.z) {
            hVar.z = true;
            if (hVar.k) {
                if (c) {
                    Log.v("FragmentManager", "remove from detach: " + hVar);
                }
                synchronized (this.j) {
                    this.j.remove(hVar);
                }
                if (hVar.C && hVar.D) {
                    this.w = true;
                }
                hVar.k = false;
            }
        }
    }

    public void m() {
        this.x = false;
        this.y = false;
        e(3);
    }

    public void t() {
        this.x = false;
        this.y = false;
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0132h hVar = this.j.get(i2);
            if (hVar != null) {
                hVar.K();
            }
        }
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            PropertyValuesHolder[] values = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : values) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i2 = 0; i2 < childAnimations.size(); i2++) {
                if (a(childAnimations.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Bundle p(C0132h hVar) {
        Bundle bundle;
        if (this.E == null) {
            this.E = new Bundle();
        }
        hVar.j(this.E);
        d(hVar, this.E, false);
        if (!this.E.isEmpty()) {
            bundle = this.E;
            this.E = null;
        } else {
            bundle = null;
        }
        if (hVar.G != null) {
            q(hVar);
        }
        if (hVar.d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", hVar.d);
        }
        if (!hVar.J) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", hVar.J);
        }
        return bundle;
    }

    public void b(C0132h hVar) {
        if (c) {
            Log.v("FragmentManager", "attach: " + hVar);
        }
        if (hVar.z) {
            hVar.z = false;
            if (hVar.k) {
                return;
            }
            if (!this.j.contains(hVar)) {
                if (c) {
                    Log.v("FragmentManager", "add from attach: " + hVar);
                }
                synchronized (this.j) {
                    this.j.add(hVar);
                }
                hVar.k = true;
                if (hVar.C && hVar.D) {
                    this.w = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + hVar);
        }
    }

    public void i() {
        e(1);
    }

    /* access modifiers changed from: package-private */
    public void h(C0132h hVar, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).h(hVar, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.g(this, hVar);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void e(int i2) {
        try {
            this.h = true;
            a(i2, false);
            this.h = false;
            p();
        } catch (Throwable th) {
            this.h = false;
            throw th;
        }
    }

    public void j() {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            C0132h hVar = this.j.get(i2);
            if (hVar != null) {
                hVar.X();
            }
        }
    }

    public void n() {
        this.y = true;
        e(2);
    }

    static boolean a(View view, c cVar) {
        if (view == null || cVar == null || Build.VERSION.SDK_INT < 19 || view.getLayerType() != 0 || !y.w(view) || !a(cVar)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e(C0132h hVar, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).e(hVar, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.d(this, hVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(C0132h hVar, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).d(hVar, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.c(this, hVar);
            }
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new a.g.h.b("FragmentManager"));
        C0138n nVar = this.s;
        if (nVar != null) {
            try {
                nVar.a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        throw runtimeException;
    }

    public C0132h b(String str) {
        C0132h b2;
        for (C0132h next : this.k.values()) {
            if (next != null && (b2 = next.b(str)) != null) {
                return b2;
            }
        }
        return null;
    }

    public int b(C0125a aVar) {
        synchronized (this) {
            if (this.o != null) {
                if (this.o.size() > 0) {
                    int intValue = this.o.remove(this.o.size() - 1).intValue();
                    if (c) {
                        Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                    }
                    this.n.set(intValue, aVar);
                    return intValue;
                }
            }
            if (this.n == null) {
                this.n = new ArrayList<>();
            }
            int size = this.n.size();
            if (c) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.n.add(aVar);
            return size;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(C0132h hVar, Bundle bundle, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).d(hVar, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.d(this, hVar, bundle);
            }
        }
    }

    private void c(boolean z2) {
        if (this.h) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.s == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.s.e().getLooper()) {
            if (!z2) {
                z();
            }
            if (this.B == null) {
                this.B = new ArrayList<>();
                this.C = new ArrayList<>();
            }
            this.h = true;
            try {
                a((ArrayList<C0125a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.h = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    public D a() {
        return new C0125a(this);
    }

    public void k() {
        e(3);
    }

    public void a(int i2, int i3) {
        if (i2 >= 0) {
            a((h) new i((String) null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    private boolean a(String str, int i2, int i3) {
        C0139o T;
        p();
        c(true);
        C0132h hVar = this.v;
        if (hVar != null && i2 < 0 && str == null && (T = hVar.T()) != null && T.e()) {
            return true;
        }
        boolean a2 = a(this.B, this.C, str, i2, i3);
        if (a2) {
            this.h = true;
            try {
                c(this.B, this.C);
            } finally {
                A();
            }
        }
        o();
        y();
        return a2;
    }

    public void b(int i2) {
        synchronized (this) {
            this.n.set(i2, (Object) null);
            if (this.o == null) {
                this.o = new ArrayList<>();
            }
            if (c) {
                Log.v("FragmentManager", "Freeing back stack index " + i2);
            }
            this.o.add(Integer.valueOf(i2));
        }
    }

    private void c(ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!arrayList.get(i2).t) {
                    if (i3 != i2) {
                        b(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (arrayList2.get(i2).booleanValue()) {
                        while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).t) {
                            i3++;
                        }
                    }
                    b(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                b(arrayList, arrayList2, i3, size);
            }
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public void a(Bundle bundle, String str, C0132h hVar) {
        if (hVar.r == this) {
            bundle.putString(str, hVar.f);
            return;
        }
        a((RuntimeException) new IllegalStateException("Fragment " + hVar + " is not currently in the FragmentManager"));
        throw null;
    }

    private void b(ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        int i4;
        int i5;
        ArrayList<C0125a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i6 = i2;
        int i7 = i3;
        boolean z2 = arrayList3.get(i6).t;
        ArrayList<C0132h> arrayList5 = this.D;
        if (arrayList5 == null) {
            this.D = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.D.addAll(this.j);
        C0132h r2 = r();
        boolean z3 = false;
        for (int i8 = i6; i8 < i7; i8++) {
            C0125a aVar = arrayList3.get(i8);
            if (!arrayList4.get(i8).booleanValue()) {
                r2 = aVar.a(this.D, r2);
            } else {
                r2 = aVar.b(this.D, r2);
            }
            z3 = z3 || aVar.i;
        }
        this.D.clear();
        if (!z2) {
            I.a(this, arrayList, arrayList2, i2, i3, false);
        }
        a(arrayList, arrayList2, i2, i3);
        if (z2) {
            a.d.d dVar = new a.d.d();
            a((a.d.d<C0132h>) dVar);
            int a2 = a(arrayList, arrayList2, i2, i3, (a.d.d<C0132h>) dVar);
            b((a.d.d<C0132h>) dVar);
            i4 = a2;
        } else {
            i4 = i7;
        }
        if (i4 != i6 && z2) {
            I.a(this, arrayList, arrayList2, i2, i4, true);
            a(this.r, true);
        }
        while (i6 < i7) {
            C0125a aVar2 = arrayList3.get(i6);
            if (arrayList4.get(i6).booleanValue() && (i5 = aVar2.m) >= 0) {
                b(i5);
                aVar2.m = -1;
            }
            aVar2.f();
            i6++;
        }
        if (z3) {
            u();
        }
    }

    public C0132h a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        C0132h hVar = this.k.get(string);
        if (hVar != null) {
            return hVar;
        }
        a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    /* access modifiers changed from: package-private */
    public void a(C0132h hVar) {
        this.H.a(hVar);
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.k.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (C0132h next : this.k.values()) {
                printWriter.print(str);
                printWriter.println(next);
                if (next != null) {
                    next.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.j.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.j.get(i2).toString());
            }
        }
        ArrayList<C0132h> arrayList = this.m;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.m.get(i3).toString());
            }
        }
        ArrayList<C0125a> arrayList2 = this.l;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                C0125a aVar = this.l.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.n != null && (size2 = this.n.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(this.n.get(i5));
                }
            }
            if (this.o != null && this.o.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.o.toArray()));
            }
        }
        ArrayList<h> arrayList3 = this.g;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(this.g.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.t);
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.u);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.r);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.x);
        printWriter.print(" mStopped=");
        printWriter.print(this.y);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.z);
        if (this.w) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.w);
        }
    }

    public C0137m c() {
        if (super.c() == C0139o.f812a) {
            C0132h hVar = this.u;
            if (hVar != null) {
                return hVar.r.c();
            }
            a((C0137m) new C0144u(this));
        }
        return super.c();
    }

    /* access modifiers changed from: package-private */
    public void c(C0132h hVar, Bundle bundle, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).c(hVar, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.c(this, hVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(C0132h hVar, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).c(hVar, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.b(this, hVar);
            }
        }
    }

    private void b(a.d.d<C0132h> dVar) {
        int size = dVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0132h c2 = dVar.c(i2);
            if (!c2.k) {
                View fa = c2.fa();
                c2.N = fa.getAlpha();
                fa.setAlpha(0.0f);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(java.util.ArrayList<androidx.fragment.app.C0125a> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<androidx.fragment.app.w$h> r0 = r4.g     // Catch:{ all -> 0x003c }
            r1 = 0
            if (r0 == 0) goto L_0x003a
            java.util.ArrayList<androidx.fragment.app.w$h> r0 = r4.g     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            java.util.ArrayList<androidx.fragment.app.w$h> r0 = r4.g     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            r2 = 0
        L_0x0016:
            if (r1 >= r0) goto L_0x0028
            java.util.ArrayList<androidx.fragment.app.w$h> r3 = r4.g     // Catch:{ all -> 0x003c }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x003c }
            androidx.fragment.app.w$h r3 = (androidx.fragment.app.w.h) r3     // Catch:{ all -> 0x003c }
            boolean r3 = r3.a(r5, r6)     // Catch:{ all -> 0x003c }
            r2 = r2 | r3
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0028:
            java.util.ArrayList<androidx.fragment.app.w$h> r5 = r4.g     // Catch:{ all -> 0x003c }
            r5.clear()     // Catch:{ all -> 0x003c }
            androidx.fragment.app.n r5 = r4.s     // Catch:{ all -> 0x003c }
            android.os.Handler r5 = r5.e()     // Catch:{ all -> 0x003c }
            java.lang.Runnable r6 = r4.I     // Catch:{ all -> 0x003c }
            r5.removeCallbacks(r6)     // Catch:{ all -> 0x003c }
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003a:
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r1
        L_0x003c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.w.b(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    public void b(boolean z2) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            C0132h hVar = this.j.get(size);
            if (hVar != null) {
                hVar.e(z2);
            }
        }
    }

    public boolean b(Menu menu) {
        if (this.r < 1) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            C0132h hVar = this.j.get(i2);
            if (hVar != null && hVar.d(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean b(MenuItem menuItem) {
        if (this.r < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            C0132h hVar = this.j.get(i2);
            if (hVar != null && hVar.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(C0132h hVar, Context context, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).b(hVar, context, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.b((C0139o) this, hVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(C0132h hVar, Bundle bundle, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).b(hVar, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.b((C0139o) this, hVar, bundle);
            }
        }
    }

    static c a(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(e);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(f);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new c((Animation) animationSet);
    }

    /* access modifiers changed from: package-private */
    public void b(C0132h hVar, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).b(hVar, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.a(this, hVar);
            }
        }
    }

    static c a(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(f);
        alphaAnimation.setDuration(220);
        return new c((Animation) alphaAnimation);
    }

    /* access modifiers changed from: package-private */
    public c a(C0132h hVar, int i2, boolean z2, int i3) {
        int b2;
        int s2 = hVar.s();
        Animation a2 = hVar.a(i2, z2, s2);
        if (a2 != null) {
            return new c(a2);
        }
        Animator b3 = hVar.b(i2, z2, s2);
        if (b3 != null) {
            return new c(b3);
        }
        if (s2 != 0) {
            boolean equals = "anim".equals(this.s.d().getResources().getResourceTypeName(s2));
            boolean z3 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.s.d(), s2);
                    if (loadAnimation != null) {
                        return new c(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.s.d(), s2);
                    if (loadAnimator != null) {
                        return new c(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.s.d(), s2);
                        if (loadAnimation2 != null) {
                            return new c(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i2 == 0 || (b2 = b(i2, z2)) < 0) {
            return null;
        }
        switch (b2) {
            case 1:
                return a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(0.0f, 1.0f);
            case 6:
                return a(1.0f, 0.0f);
            default:
                if (i3 == 0 && this.s.h()) {
                    i3 = this.s.g();
                }
                if (i3 == 0) {
                }
                return null;
        }
    }

    private static Animation.AnimationListener a(Animation animation) {
        try {
            if (d == null) {
                d = Animation.class.getDeclaredField("mListener");
                d.setAccessible(true);
            }
            return (Animation.AnimationListener) d.get(animation);
        } catch (NoSuchFieldException e2) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e2);
            return null;
        } catch (IllegalAccessException e3) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e3);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: boolean} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0072, code lost:
        if (r0 != 3) goto L_0x04db;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x04e0  */
    /* JADX WARNING: Removed duplicated region for block: B:260:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.fragment.app.C0132h r19, int r20, int r21, int r22, boolean r23) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            boolean r0 = r7.k
            r8 = 1
            if (r0 == 0) goto L_0x0011
            boolean r0 = r7.z
            if (r0 == 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0 = r20
            goto L_0x0016
        L_0x0011:
            r0 = r20
            if (r0 <= r8) goto L_0x0016
            r0 = 1
        L_0x0016:
            boolean r1 = r7.l
            if (r1 == 0) goto L_0x002a
            int r1 = r7.f804b
            if (r0 <= r1) goto L_0x002a
            if (r1 != 0) goto L_0x0028
            boolean r0 = r19.H()
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x002a
        L_0x0028:
            int r0 = r7.f804b
        L_0x002a:
            boolean r1 = r7.I
            r9 = 3
            r10 = 2
            if (r1 == 0) goto L_0x0038
            int r1 = r7.f804b
            if (r1 >= r9) goto L_0x0038
            if (r0 <= r10) goto L_0x0038
            r11 = 2
            goto L_0x0039
        L_0x0038:
            r11 = r0
        L_0x0039:
            int r0 = r7.f804b
            java.lang.String r12 = "FragmentManager"
            r13 = 0
            r14 = 0
            if (r0 > r11) goto L_0x0338
            boolean r0 = r7.m
            if (r0 == 0) goto L_0x004a
            boolean r0 = r7.n
            if (r0 != 0) goto L_0x004a
            return
        L_0x004a:
            android.view.View r0 = r19.i()
            if (r0 != 0) goto L_0x0056
            android.animation.Animator r0 = r19.j()
            if (r0 == 0) goto L_0x006a
        L_0x0056:
            r7.b((android.view.View) r14)
            r7.a((android.animation.Animator) r14)
            int r2 = r19.B()
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r18
            r1 = r19
            r0.a((androidx.fragment.app.C0132h) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
        L_0x006a:
            int r0 = r7.f804b
            if (r0 == 0) goto L_0x007c
            if (r0 == r8) goto L_0x01fc
            if (r0 == r10) goto L_0x0079
            if (r0 == r9) goto L_0x0076
            goto L_0x04db
        L_0x0076:
            r0 = 3
            goto L_0x0312
        L_0x0079:
            r0 = 2
            goto L_0x02f0
        L_0x007c:
            if (r11 <= 0) goto L_0x01fc
            boolean r0 = c
            if (r0 == 0) goto L_0x0096
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0096:
            android.os.Bundle r0 = r7.c
            if (r0 == 0) goto L_0x00ef
            androidx.fragment.app.n r1 = r6.s
            android.content.Context r1 = r1.d()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r7.c
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r7.d = r0
            android.os.Bundle r0 = r7.c
            java.lang.String r1 = "android:target_state"
            androidx.fragment.app.h r0 = r6.a((android.os.Bundle) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x00be
            java.lang.String r0 = r0.f
            goto L_0x00bf
        L_0x00be:
            r0 = r14
        L_0x00bf:
            r7.i = r0
            java.lang.String r0 = r7.i
            if (r0 == 0) goto L_0x00cf
            android.os.Bundle r0 = r7.c
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r13)
            r7.j = r0
        L_0x00cf:
            java.lang.Boolean r0 = r7.e
            if (r0 == 0) goto L_0x00dc
            boolean r0 = r0.booleanValue()
            r7.J = r0
            r7.e = r14
            goto L_0x00e6
        L_0x00dc:
            android.os.Bundle r0 = r7.c
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r8)
            r7.J = r0
        L_0x00e6:
            boolean r0 = r7.J
            if (r0 != 0) goto L_0x00ef
            r7.I = r8
            if (r11 <= r10) goto L_0x00ef
            r11 = 2
        L_0x00ef:
            androidx.fragment.app.n r0 = r6.s
            r7.s = r0
            androidx.fragment.app.h r1 = r6.u
            r7.u = r1
            if (r1 == 0) goto L_0x00fc
            androidx.fragment.app.w r0 = r1.t
            goto L_0x00fe
        L_0x00fc:
            androidx.fragment.app.w r0 = r0.e
        L_0x00fe:
            r7.r = r0
            androidx.fragment.app.h r0 = r7.h
            java.lang.String r15 = " that does not belong to this FragmentManager!"
            java.lang.String r5 = " declared target fragment "
            java.lang.String r4 = "Fragment "
            if (r0 == 0) goto L_0x0159
            java.util.HashMap<java.lang.String, androidx.fragment.app.h> r1 = r6.k
            java.lang.String r0 = r0.f
            java.lang.Object r0 = r1.get(r0)
            androidx.fragment.app.h r1 = r7.h
            if (r0 != r1) goto L_0x0137
            int r0 = r1.f804b
            if (r0 >= r8) goto L_0x012c
            r2 = 1
            r3 = 0
            r16 = 0
            r17 = 1
            r0 = r18
            r9 = r4
            r4 = r16
            r10 = r5
            r5 = r17
            r0.a((androidx.fragment.app.C0132h) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
            goto L_0x012e
        L_0x012c:
            r9 = r4
            r10 = r5
        L_0x012e:
            androidx.fragment.app.h r0 = r7.h
            java.lang.String r0 = r0.f
            r7.i = r0
            r7.h = r14
            goto L_0x015b
        L_0x0137:
            r9 = r4
            r10 = r5
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r7)
            r1.append(r10)
            androidx.fragment.app.h r2 = r7.h
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0159:
            r9 = r4
            r10 = r5
        L_0x015b:
            java.lang.String r0 = r7.i
            if (r0 == 0) goto L_0x0198
            java.util.HashMap<java.lang.String, androidx.fragment.app.h> r1 = r6.k
            java.lang.Object r0 = r1.get(r0)
            r1 = r0
            androidx.fragment.app.h r1 = (androidx.fragment.app.C0132h) r1
            if (r1 == 0) goto L_0x0178
            int r0 = r1.f804b
            if (r0 >= r8) goto L_0x0198
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r18
            r0.a((androidx.fragment.app.C0132h) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
            goto L_0x0198
        L_0x0178:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r7)
            r1.append(r10)
            java.lang.String r2 = r7.i
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0198:
            androidx.fragment.app.n r0 = r6.s
            android.content.Context r0 = r0.d()
            r6.b((androidx.fragment.app.C0132h) r7, (android.content.Context) r0, (boolean) r13)
            r7.E = r13
            androidx.fragment.app.n r0 = r6.s
            android.content.Context r0 = r0.d()
            r7.a((android.content.Context) r0)
            boolean r0 = r7.E
            if (r0 == 0) goto L_0x01e2
            androidx.fragment.app.h r0 = r7.u
            if (r0 != 0) goto L_0x01ba
            androidx.fragment.app.n r0 = r6.s
            r0.a((androidx.fragment.app.C0132h) r7)
            goto L_0x01bd
        L_0x01ba:
            r0.a((androidx.fragment.app.C0132h) r7)
        L_0x01bd:
            androidx.fragment.app.n r0 = r6.s
            android.content.Context r0 = r0.d()
            r6.a((androidx.fragment.app.C0132h) r7, (android.content.Context) r0, (boolean) r13)
            boolean r0 = r7.P
            if (r0 != 0) goto L_0x01da
            android.os.Bundle r0 = r7.c
            r6.c(r7, r0, r13)
            android.os.Bundle r0 = r7.c
            r7.h(r0)
            android.os.Bundle r0 = r7.c
            r6.b((androidx.fragment.app.C0132h) r7, (android.os.Bundle) r0, (boolean) r13)
            goto L_0x01fc
        L_0x01da:
            android.os.Bundle r0 = r7.c
            r7.k(r0)
            r7.f804b = r8
            goto L_0x01fc
        L_0x01e2:
            androidx.fragment.app.U r0 = new androidx.fragment.app.U
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r7)
            java.lang.String r2 = " did not call through to super.onAttach()"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01fc:
            r18.e((androidx.fragment.app.C0132h) r19)
            if (r11 <= r8) goto L_0x0079
            boolean r0 = c
            if (r0 == 0) goto L_0x0219
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0219:
            boolean r0 = r7.m
            if (r0 != 0) goto L_0x02d9
            int r0 = r7.w
            if (r0 == 0) goto L_0x028f
            r1 = -1
            if (r0 == r1) goto L_0x0270
            androidx.fragment.app.k r1 = r6.t
            android.view.View r0 = r1.a(r0)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0290
            boolean r1 = r7.o
            if (r1 == 0) goto L_0x0233
            goto L_0x0290
        L_0x0233:
            android.content.res.Resources r0 = r19.w()     // Catch:{ NotFoundException -> 0x023e }
            int r1 = r7.w     // Catch:{ NotFoundException -> 0x023e }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x023e }
            goto L_0x0240
        L_0x023e:
            java.lang.String r0 = "unknown"
        L_0x0240:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            int r3 = r7.w
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            r6.a((java.lang.RuntimeException) r1)
            throw r14
        L_0x0270:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r6.a((java.lang.RuntimeException) r0)
            throw r14
        L_0x028f:
            r0 = r14
        L_0x0290:
            r7.F = r0
            android.os.Bundle r1 = r7.c
            android.view.LayoutInflater r1 = r7.i(r1)
            android.os.Bundle r2 = r7.c
            r7.b((android.view.LayoutInflater) r1, (android.view.ViewGroup) r0, (android.os.Bundle) r2)
            android.view.View r1 = r7.G
            if (r1 == 0) goto L_0x02d7
            r7.H = r1
            r1.setSaveFromParentEnabled(r13)
            if (r0 == 0) goto L_0x02ad
            android.view.View r1 = r7.G
            r0.addView(r1)
        L_0x02ad:
            boolean r0 = r7.y
            if (r0 == 0) goto L_0x02b8
            android.view.View r0 = r7.G
            r1 = 8
            r0.setVisibility(r1)
        L_0x02b8:
            android.view.View r0 = r7.G
            android.os.Bundle r1 = r7.c
            r7.a((android.view.View) r0, (android.os.Bundle) r1)
            android.view.View r0 = r7.G
            android.os.Bundle r1 = r7.c
            r6.a((androidx.fragment.app.C0132h) r7, (android.view.View) r0, (android.os.Bundle) r1, (boolean) r13)
            android.view.View r0 = r7.G
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x02d3
            android.view.ViewGroup r0 = r7.F
            if (r0 == 0) goto L_0x02d3
            goto L_0x02d4
        L_0x02d3:
            r8 = 0
        L_0x02d4:
            r7.L = r8
            goto L_0x02d9
        L_0x02d7:
            r7.H = r14
        L_0x02d9:
            android.os.Bundle r0 = r7.c
            r7.g(r0)
            android.os.Bundle r0 = r7.c
            r6.a((androidx.fragment.app.C0132h) r7, (android.os.Bundle) r0, (boolean) r13)
            android.view.View r0 = r7.G
            if (r0 == 0) goto L_0x02ec
            android.os.Bundle r0 = r7.c
            r7.l(r0)
        L_0x02ec:
            r7.c = r14
            goto L_0x0079
        L_0x02f0:
            if (r11 <= r0) goto L_0x0076
            boolean r0 = c
            if (r0 == 0) goto L_0x030a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto STARTED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x030a:
            r19.aa()
            r6.f(r7, r13)
            goto L_0x0076
        L_0x0312:
            if (r11 <= r0) goto L_0x04db
            boolean r0 = c
            if (r0 == 0) goto L_0x032c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveto RESUMED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x032c:
            r19.Z()
            r6.e(r7, r13)
            r7.c = r14
            r7.d = r14
            goto L_0x04db
        L_0x0338:
            if (r0 <= r11) goto L_0x04db
            if (r0 == r8) goto L_0x040a
            r1 = 2
            if (r0 == r1) goto L_0x0388
            r1 = 3
            if (r0 == r1) goto L_0x0367
            r1 = 4
            if (r0 == r1) goto L_0x0347
            goto L_0x04db
        L_0x0347:
            if (r11 >= r1) goto L_0x0367
            boolean r0 = c
            if (r0 == 0) goto L_0x0361
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom RESUMED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0361:
            r19.Y()
            r6.d(r7, r13)
        L_0x0367:
            r0 = 3
            if (r11 >= r0) goto L_0x0388
            boolean r0 = c
            if (r0 == 0) goto L_0x0382
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom STARTED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0382:
            r19.ba()
            r6.g(r7, r13)
        L_0x0388:
            r0 = 2
            if (r11 >= r0) goto L_0x040a
            boolean r0 = c
            if (r0 == 0) goto L_0x03a3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom ACTIVITY_CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x03a3:
            android.view.View r0 = r7.G
            if (r0 == 0) goto L_0x03b6
            androidx.fragment.app.n r0 = r6.s
            boolean r0 = r0.b(r7)
            if (r0 == 0) goto L_0x03b6
            android.util.SparseArray<android.os.Parcelable> r0 = r7.d
            if (r0 != 0) goto L_0x03b6
            r18.q(r19)
        L_0x03b6:
            r19.V()
            r6.h(r7, r13)
            android.view.View r0 = r7.G
            if (r0 == 0) goto L_0x03fb
            android.view.ViewGroup r1 = r7.F
            if (r1 == 0) goto L_0x03fb
            r1.endViewTransition(r0)
            android.view.View r0 = r7.G
            r0.clearAnimation()
            int r0 = r6.r
            r1 = 0
            if (r0 <= 0) goto L_0x03ec
            boolean r0 = r6.z
            if (r0 != 0) goto L_0x03ec
            android.view.View r0 = r7.G
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x03ec
            float r0 = r7.N
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x03ec
            r0 = r21
            r2 = r22
            androidx.fragment.app.w$c r0 = r6.a((androidx.fragment.app.C0132h) r7, (int) r0, (boolean) r13, (int) r2)
            goto L_0x03ed
        L_0x03ec:
            r0 = r14
        L_0x03ed:
            r7.N = r1
            if (r0 == 0) goto L_0x03f4
            r6.a((androidx.fragment.app.C0132h) r7, (androidx.fragment.app.w.c) r0, (int) r11)
        L_0x03f4:
            android.view.ViewGroup r0 = r7.F
            android.view.View r1 = r7.G
            r0.removeView(r1)
        L_0x03fb:
            r7.F = r14
            r7.G = r14
            r7.R = r14
            androidx.lifecycle.s<androidx.lifecycle.l> r0 = r7.S
            r0.a(r14)
            r7.H = r14
            r7.n = r13
        L_0x040a:
            if (r11 >= r8) goto L_0x04db
            boolean r0 = r6.z
            if (r0 == 0) goto L_0x0431
            android.view.View r0 = r19.i()
            if (r0 == 0) goto L_0x0421
            android.view.View r0 = r19.i()
            r7.b((android.view.View) r14)
            r0.clearAnimation()
            goto L_0x0431
        L_0x0421:
            android.animation.Animator r0 = r19.j()
            if (r0 == 0) goto L_0x0431
            android.animation.Animator r0 = r19.j()
            r7.a((android.animation.Animator) r14)
            r0.cancel()
        L_0x0431:
            android.view.View r0 = r19.i()
            if (r0 != 0) goto L_0x04d7
            android.animation.Animator r0 = r19.j()
            if (r0 == 0) goto L_0x043f
            goto L_0x04d7
        L_0x043f:
            boolean r0 = c
            if (r0 == 0) goto L_0x0457
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "movefrom CREATED: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r12, r0)
        L_0x0457:
            boolean r0 = r7.l
            if (r0 == 0) goto L_0x0463
            boolean r0 = r19.H()
            if (r0 != 0) goto L_0x0463
            r0 = 1
            goto L_0x0464
        L_0x0463:
            r0 = 0
        L_0x0464:
            if (r0 != 0) goto L_0x0472
            androidx.fragment.app.A r1 = r6.H
            boolean r1 = r1.f(r7)
            if (r1 == 0) goto L_0x046f
            goto L_0x0472
        L_0x046f:
            r7.f804b = r13
            goto L_0x04a3
        L_0x0472:
            androidx.fragment.app.n r1 = r6.s
            boolean r2 = r1 instanceof androidx.lifecycle.E
            if (r2 == 0) goto L_0x047f
            androidx.fragment.app.A r1 = r6.H
            boolean r8 = r1.d()
            goto L_0x0494
        L_0x047f:
            android.content.Context r1 = r1.d()
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0494
            androidx.fragment.app.n r1 = r6.s
            android.content.Context r1 = r1.d()
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r1 = r1.isChangingConfigurations()
            r8 = r8 ^ r1
        L_0x0494:
            if (r0 != 0) goto L_0x0498
            if (r8 == 0) goto L_0x049d
        L_0x0498:
            androidx.fragment.app.A r1 = r6.H
            r1.b(r7)
        L_0x049d:
            r19.U()
            r6.b((androidx.fragment.app.C0132h) r7, (boolean) r13)
        L_0x04a3:
            r19.W()
            r6.c((androidx.fragment.app.C0132h) r7, (boolean) r13)
            if (r23 != 0) goto L_0x04db
            if (r0 != 0) goto L_0x04d3
            androidx.fragment.app.A r0 = r6.H
            boolean r0 = r0.f(r7)
            if (r0 == 0) goto L_0x04b6
            goto L_0x04d3
        L_0x04b6:
            r7.s = r14
            r7.u = r14
            r7.r = r14
            java.lang.String r0 = r7.i
            if (r0 == 0) goto L_0x04db
            java.util.HashMap<java.lang.String, androidx.fragment.app.h> r1 = r6.k
            java.lang.Object r0 = r1.get(r0)
            androidx.fragment.app.h r0 = (androidx.fragment.app.C0132h) r0
            if (r0 == 0) goto L_0x04db
            boolean r1 = r0.x()
            if (r1 == 0) goto L_0x04db
            r7.h = r0
            goto L_0x04db
        L_0x04d3:
            r18.j(r19)
            goto L_0x04db
        L_0x04d7:
            r7.d((int) r11)
            goto L_0x04dc
        L_0x04db:
            r8 = r11
        L_0x04dc:
            int r0 = r7.f804b
            if (r0 == r8) goto L_0x0508
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r7.f804b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r12, r0)
            r7.f804b = r8
        L_0x0508:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.w.a(androidx.fragment.app.h, int, int, int, boolean):void");
    }

    private void a(C0132h hVar, c cVar, int i2) {
        View view = hVar.G;
        ViewGroup viewGroup = hVar.F;
        viewGroup.startViewTransition(view);
        hVar.d(i2);
        Animation animation = cVar.f826a;
        if (animation != null) {
            e eVar = new e(animation, viewGroup, view);
            hVar.b(hVar.G);
            eVar.setAnimationListener(new r(this, viewGroup, hVar));
            b(view, cVar);
            hVar.G.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.f827b;
        hVar.a(animator);
        animator.addListener(new C0142s(this, viewGroup, view, hVar));
        animator.setTarget(hVar.G);
        b(hVar.G, cVar);
        animator.start();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2) {
        C0138n nVar;
        if (this.s == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.r) {
            this.r = i2;
            int size = this.j.size();
            for (int i3 = 0; i3 < size; i3++) {
                k(this.j.get(i3));
            }
            for (C0132h next : this.k.values()) {
                if (next != null && ((next.l || next.z) && !next.L)) {
                    k(next);
                }
            }
            x();
            if (this.w && (nVar = this.s) != null && this.r == 4) {
                nVar.i();
                this.w = false;
            }
        }
    }

    public void a(C0132h hVar, boolean z2) {
        if (c) {
            Log.v("FragmentManager", "add: " + hVar);
        }
        i(hVar);
        if (hVar.z) {
            return;
        }
        if (!this.j.contains(hVar)) {
            synchronized (this.j) {
                this.j.add(hVar);
            }
            hVar.k = true;
            hVar.l = false;
            if (hVar.G == null) {
                hVar.M = false;
            }
            if (hVar.C && hVar.D) {
                this.w = true;
            }
            if (z2) {
                l(hVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + hVar);
    }

    public C0132h a(int i2) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            C0132h hVar = this.j.get(size);
            if (hVar != null && hVar.v == i2) {
                return hVar;
            }
        }
        for (C0132h next : this.k.values()) {
            if (next != null && next.v == i2) {
                return next;
            }
        }
        return null;
    }

    public C0132h a(String str) {
        if (str != null) {
            for (int size = this.j.size() - 1; size >= 0; size--) {
                C0132h hVar = this.j.get(size);
                if (hVar != null && str.equals(hVar.x)) {
                    return hVar;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (C0132h next : this.k.values()) {
            if (next != null && str.equals(next.x)) {
                return next;
            }
        }
        return null;
    }

    public void a(h hVar, boolean z2) {
        if (!z2) {
            z();
        }
        synchronized (this) {
            if (!this.z) {
                if (this.s != null) {
                    if (this.g == null) {
                        this.g = new ArrayList<>();
                    }
                    this.g.add(hVar);
                    w();
                    return;
                }
            }
            if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public void a(int i2, C0125a aVar) {
        synchronized (this) {
            if (this.n == null) {
                this.n = new ArrayList<>();
            }
            int size = this.n.size();
            if (i2 < size) {
                if (c) {
                    Log.v("FragmentManager", "Setting back stack index " + i2 + " to " + aVar);
                }
                this.n.set(i2, aVar);
            } else {
                while (size < i2) {
                    this.n.add((Object) null);
                    if (this.o == null) {
                        this.o = new ArrayList<>();
                    }
                    if (c) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.o.add(Integer.valueOf(size));
                    size++;
                }
                if (c) {
                    Log.v("FragmentManager", "Adding back stack index " + i2 + " with " + aVar);
                }
                this.n.add(aVar);
            }
        }
    }

    private void a(ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<j> arrayList3 = this.G;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            j jVar = this.G.get(i2);
            if (arrayList != null && !jVar.f836a && (indexOf2 = arrayList.indexOf(jVar.f837b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                jVar.c();
            } else if (jVar.e() || (arrayList != null && jVar.f837b.a(arrayList, 0, arrayList.size()))) {
                this.G.remove(i2);
                i2--;
                size--;
                if (arrayList == null || jVar.f836a || (indexOf = arrayList.indexOf(jVar.f837b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                    jVar.d();
                } else {
                    jVar.c();
                }
            }
            i2++;
        }
    }

    private int a(ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, a.d.d<C0132h> dVar) {
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            C0125a aVar = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (aVar.e() && !aVar.a(arrayList, i5 + 1, i3)) {
                if (this.G == null) {
                    this.G = new ArrayList<>();
                }
                j jVar = new j(aVar, booleanValue);
                this.G.add(jVar);
                aVar.a((C0132h.c) jVar);
                if (booleanValue) {
                    aVar.c();
                } else {
                    aVar.b(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, aVar);
                }
                a(dVar);
            }
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public void a(C0125a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.b(z4);
        } else {
            aVar.c();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            I.a(this, (ArrayList<C0125a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z4) {
            a(this.r, true);
        }
        for (C0132h next : this.k.values()) {
            if (next != null && next.G != null && next.L && aVar.b(next.w)) {
                float f2 = next.N;
                if (f2 > 0.0f) {
                    next.G.setAlpha(f2);
                }
                if (z4) {
                    next.N = 0.0f;
                } else {
                    next.N = -1.0f;
                    next.L = false;
                }
            }
        }
    }

    private static void a(ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            C0125a aVar = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                aVar.a(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                aVar.b(z2);
            } else {
                aVar.a(1);
                aVar.c();
            }
            i2++;
        }
    }

    private void a(a.d.d<C0132h> dVar) {
        int i2 = this.r;
        if (i2 >= 1) {
            int min = Math.min(i2, 3);
            int size = this.j.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0132h hVar = this.j.get(i3);
                if (hVar.f804b < min) {
                    a(hVar, min, hVar.s(), hVar.t(), false);
                    if (hVar.G != null && !hVar.y && hVar.L) {
                        dVar.add(hVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(C0125a aVar) {
        if (this.l == null) {
            this.l = new ArrayList<>();
        }
        this.l.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<C0125a> arrayList3 = this.l;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.l.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i2 >= 0) {
                i4 = this.l.size() - 1;
                while (i4 >= 0) {
                    C0125a aVar = this.l.get(i4);
                    if ((str != null && str.equals(aVar.d())) || (i2 >= 0 && i2 == aVar.m)) {
                        break;
                    }
                    i4--;
                }
                if (i4 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        i4--;
                        if (i4 < 0) {
                            break;
                        }
                        C0125a aVar2 = this.l.get(i4);
                        if ((str == null || !str.equals(aVar2.d())) && (i2 < 0 || i2 != aVar2.m)) {
                            break;
                        }
                    }
                }
            } else {
                i4 = -1;
            }
            if (i4 == this.l.size() - 1) {
                return false;
            }
            for (int size2 = this.l.size() - 1; size2 > i4; size2--) {
                arrayList.add(this.l.remove(size2));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(Parcelable parcelable) {
        C c2;
        if (parcelable != null) {
            y yVar = (y) parcelable;
            if (yVar.f838a != null) {
                for (C0132h next : this.H.c()) {
                    if (c) {
                        Log.v("FragmentManager", "restoreAllState: re-attaching retained " + next);
                    }
                    Iterator<C> it = yVar.f838a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            c2 = null;
                            break;
                        }
                        c2 = it.next();
                        if (c2.f766b.equals(next.f)) {
                            break;
                        }
                    }
                    if (c2 != null) {
                        c2.l = next;
                        next.d = null;
                        next.q = 0;
                        next.n = false;
                        next.k = false;
                        C0132h hVar = next.h;
                        next.i = hVar != null ? hVar.f : null;
                        next.h = null;
                        Bundle bundle = c2.k;
                        if (bundle != null) {
                            bundle.setClassLoader(this.s.d().getClassLoader());
                            next.d = c2.k.getSparseParcelableArray("android:view_state");
                            next.c = c2.k;
                        }
                    } else {
                        a((RuntimeException) new IllegalStateException("Could not find active fragment with unique id " + next.f));
                        throw null;
                    }
                }
                this.k.clear();
                Iterator<C> it2 = yVar.f838a.iterator();
                while (it2.hasNext()) {
                    C next2 = it2.next();
                    if (next2 != null) {
                        C0132h a2 = next2.a(this.s.d().getClassLoader(), c());
                        a2.r = this;
                        if (c) {
                            Log.v("FragmentManager", "restoreAllState: active (" + a2.f + "): " + a2);
                        }
                        this.k.put(a2.f, a2);
                        next2.l = null;
                    }
                }
                this.j.clear();
                ArrayList<String> arrayList = yVar.f839b;
                if (arrayList != null) {
                    Iterator<String> it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        String next3 = it3.next();
                        C0132h hVar2 = this.k.get(next3);
                        if (hVar2 != null) {
                            hVar2.k = true;
                            if (c) {
                                Log.v("FragmentManager", "restoreAllState: added (" + next3 + "): " + hVar2);
                            }
                            if (!this.j.contains(hVar2)) {
                                synchronized (this.j) {
                                    this.j.add(hVar2);
                                }
                            } else {
                                throw new IllegalStateException("Already added!");
                            }
                        } else {
                            a((RuntimeException) new IllegalStateException("No instantiated fragment for (" + next3 + ")"));
                            throw null;
                        }
                    }
                }
                C0127c[] cVarArr = yVar.c;
                if (cVarArr != null) {
                    this.l = new ArrayList<>(cVarArr.length);
                    int i2 = 0;
                    while (true) {
                        C0127c[] cVarArr2 = yVar.c;
                        if (i2 >= cVarArr2.length) {
                            break;
                        }
                        C0125a a3 = cVarArr2[i2].a(this);
                        if (c) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + a3.m + "): " + a3);
                            PrintWriter printWriter = new PrintWriter(new a.g.h.b("FragmentManager"));
                            a3.a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.l.add(a3);
                        int i3 = a3.m;
                        if (i3 >= 0) {
                            a(i3, a3);
                        }
                        i2++;
                    }
                } else {
                    this.l = null;
                }
                String str = yVar.d;
                if (str != null) {
                    this.v = this.k.get(str);
                }
                this.i = yVar.e;
            }
        }
    }

    public void a(C0138n nVar, C0135k kVar, C0132h hVar) {
        if (this.s == null) {
            this.s = nVar;
            this.t = kVar;
            this.u = hVar;
            if (hVar != null) {
                this.H = hVar.r.f(hVar);
            } else if (nVar instanceof E) {
                this.H = A.a(((E) nVar).c());
            } else {
                this.H = new A(false);
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    public void a(boolean z2) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            C0132h hVar = this.j.get(size);
            if (hVar != null) {
                hVar.d(z2);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            C0132h hVar = this.j.get(i2);
            if (hVar != null) {
                hVar.a(configuration);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.r < 1) {
            return false;
        }
        ArrayList<C0132h> arrayList = null;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            C0132h hVar = this.j.get(i2);
            if (hVar != null && hVar.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(hVar);
                z2 = true;
            }
        }
        if (this.m != null) {
            for (int i3 = 0; i3 < this.m.size(); i3++) {
                C0132h hVar2 = this.m.get(i3);
                if (arrayList == null || !arrayList.contains(hVar2)) {
                    hVar2.M();
                }
            }
        }
        this.m = arrayList;
        return z2;
    }

    public boolean a(MenuItem menuItem) {
        if (this.r < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            C0132h hVar = this.j.get(i2);
            if (hVar != null && hVar.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(Menu menu) {
        if (this.r >= 1) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                C0132h hVar = this.j.get(i2);
                if (hVar != null) {
                    hVar.c(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(C0132h hVar, Context context, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).a(hVar, context, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.a((C0139o) this, hVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(C0132h hVar, Bundle bundle, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).a(hVar, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.a((C0139o) this, hVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(C0132h hVar, View view, Bundle bundle, boolean z2) {
        C0132h hVar2 = this.u;
        if (hVar2 != null) {
            C0139o r2 = hVar2.r();
            if (r2 instanceof w) {
                ((w) r2).a(hVar, view, bundle, true);
            }
        }
        Iterator<f> it = this.q.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!z2 || next.f832b) {
                next.f831a.a(this, hVar, view, bundle);
            }
        }
    }
}
