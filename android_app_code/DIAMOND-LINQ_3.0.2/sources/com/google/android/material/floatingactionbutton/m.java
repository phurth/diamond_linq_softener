package com.google.android.material.floatingactionbutton;

import a.g.i.y;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import b.c.a.a.p.h;
import com.google.android.material.internal.p;
import java.util.ArrayList;
import java.util.Iterator;

class m {

    /* renamed from: a  reason: collision with root package name */
    static final TimeInterpolator f1504a = b.c.a.a.a.a.c;

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1505b = {16842919, 16842910};
    static final int[] c = {16843623, 16842908, 16842910};
    static final int[] d = {16842908, 16842910};
    static final int[] e = {16843623, 16842910};
    static final int[] f = {16842910};
    static final int[] g = new int[0];
    private int A;
    /* access modifiers changed from: private */
    public int B = 0;
    private ArrayList<Animator.AnimatorListener> C;
    private ArrayList<Animator.AnimatorListener> D;
    private ArrayList<d> E;
    final FloatingActionButton F;
    final b.c.a.a.o.b G;
    private final Rect H = new Rect();
    private final RectF I = new RectF();
    private final RectF J = new RectF();
    private final Matrix K = new Matrix();
    private ViewTreeObserver.OnPreDrawListener L;
    h h;
    b.c.a.a.p.e i;
    Drawable j;
    a k;
    Drawable l;
    boolean m;
    boolean n;
    float o;
    float p;
    float q;
    int r;
    private final p s;
    private b.c.a.a.a.h t;
    private b.c.a.a.a.h u;
    /* access modifiers changed from: private */
    public Animator v;
    private b.c.a.a.a.h w;
    private b.c.a.a.a.h x;
    private float y;
    /* access modifiers changed from: private */
    public float z = 1.0f;

    private class a extends g {
        a() {
            super(m.this, (i) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return 0.0f;
        }
    }

    private class b extends g {
        b() {
            super(m.this, (i) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            m mVar = m.this;
            return mVar.o + mVar.p;
        }
    }

    private class c extends g {
        c() {
            super(m.this, (i) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            m mVar = m.this;
            return mVar.o + mVar.q;
        }
    }

    interface d {
        void a();

        void b();
    }

    interface e {
        void a();

        void b();
    }

    private class f extends g {
        f() {
            super(m.this, (i) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return m.this.o;
        }
    }

    private abstract class g extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1506a;

        /* renamed from: b  reason: collision with root package name */
        private float f1507b;
        private float c;

        private g() {
        }

        /* access modifiers changed from: protected */
        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            m.this.e((float) ((int) this.c));
            this.f1506a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f1506a) {
                b.c.a.a.p.e eVar = m.this.i;
                this.f1507b = eVar == null ? 0.0f : eVar.d();
                this.c = a();
                this.f1506a = true;
            }
            m mVar = m.this;
            float f = this.f1507b;
            mVar.e((float) ((int) (f + ((this.c - f) * valueAnimator.getAnimatedFraction()))));
        }

        /* synthetic */ g(m mVar, i iVar) {
            this();
        }
    }

    m(FloatingActionButton floatingActionButton, b.c.a.a.o.b bVar) {
        this.F = floatingActionButton;
        this.G = bVar;
        this.s = new p();
        this.s.a(f1505b, a((g) new c()));
        this.s.a(c, a((g) new b()));
        this.s.a(d, a((g) new b()));
        this.s.a(e, a((g) new b()));
        this.s.a(f, a((g) new f()));
        this.s.a(g, a((g) new a()));
        this.y = this.F.getRotation();
    }

    private ViewTreeObserver.OnPreDrawListener A() {
        if (this.L == null) {
            this.L = new l(this);
        }
        return this.L;
    }

    private boolean B() {
        return y.A(this.F) && !this.F.isInEditMode();
    }

    private b.c.a.a.a.h y() {
        if (this.u == null) {
            this.u = b.c.a.a.a.h.a(this.F.getContext(), b.c.a.a.a.design_fab_hide_motion_spec);
        }
        b.c.a.a.a.h hVar = this.u;
        a.g.h.g.a(hVar);
        return hVar;
    }

    private b.c.a.a.a.h z() {
        if (this.t == null) {
            this.t = b.c.a.a.a.h.a(this.F.getContext(), b.c.a.a.a.design_fab_show_motion_spec);
        }
        b.c.a.a.a.h hVar = this.t;
        a.g.h.g.a(hVar);
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, b.c.a.a.n.a.a(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(float f2) {
        this.z = f2;
        Matrix matrix = this.K;
        a(f2, matrix);
        this.F.setImageMatrix(matrix);
    }

    /* access modifiers changed from: package-private */
    public final void d(float f2) {
        if (this.q != f2) {
            this.q = f2;
            a(this.o, this.p, this.q);
        }
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public final h g() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public final b.c.a.a.a.h h() {
        return this.w;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        if (this.F.getVisibility() == 0) {
            if (this.B == 1) {
                return true;
            }
            return false;
        } else if (this.B != 2) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        if (this.F.getVisibility() != 0) {
            if (this.B == 2) {
                return true;
            }
            return false;
        } else if (this.B != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.s.a();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (r()) {
            this.F.getViewTreeObserver().addOnPreDrawListener(A());
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
    }

    /* access modifiers changed from: package-private */
    public void n() {
        ViewTreeObserver viewTreeObserver = this.F.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.L;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.L = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void o() {
        float rotation = this.F.getRotation();
        if (this.y != rotation) {
            this.y = rotation;
            u();
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        ArrayList<d> arrayList = this.E;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q() {
        ArrayList<d> arrayList = this.E;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean t() {
        return !this.n || this.F.getSizeDimension() >= this.r;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.y % 90.0f != 0.0f) {
                if (this.F.getLayerType() != 1) {
                    this.F.setLayerType(1, (Paint) null);
                }
            } else if (this.F.getLayerType() != 0) {
                this.F.setLayerType(0, (Paint) null);
            }
        }
        b.c.a.a.p.e eVar = this.i;
        if (eVar != null) {
            eVar.a((int) this.y);
        }
    }

    /* access modifiers changed from: package-private */
    public final void v() {
        c(this.z);
    }

    /* access modifiers changed from: package-private */
    public final void w() {
        Rect rect = this.H;
        a(rect);
        b(rect);
        this.G.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void x() {
        b.c.a.a.p.e eVar;
        if (this.m && (eVar = this.i) != null) {
            eVar.e().a(((float) this.F.getSizeDimension()) / 2.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(float f2) {
        b.c.a.a.p.e eVar = this.i;
        if (eVar != null) {
            eVar.a(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        b.c.a.a.p.e eVar = this.i;
        if (eVar != null) {
            eVar.setTintList(colorStateList);
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(colorStateList);
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public final b.c.a.a.a.h d() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public final void b(float f2) {
        if (this.p != f2) {
            this.p = f2;
            a(this.o, this.p, this.q);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        b.c.a.a.p.e eVar = this.i;
        if (eVar != null) {
            eVar.setTintMode(mode);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(b.c.a.a.a.h hVar) {
        this.w = hVar;
    }

    /* access modifiers changed from: package-private */
    public void b(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2) {
        if (this.o != f2) {
            this.o = f2;
            a(this.o, this.p, this.q);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(e eVar, boolean z2) {
        if (!j()) {
            Animator animator = this.v;
            if (animator != null) {
                animator.cancel();
            }
            if (B()) {
                if (this.F.getVisibility() != 0) {
                    this.F.setAlpha(0.0f);
                    this.F.setScaleY(0.0f);
                    this.F.setScaleX(0.0f);
                    c(0.0f);
                }
                b.c.a.a.a.h hVar = this.w;
                if (hVar == null) {
                    hVar = z();
                }
                AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
                a2.addListener(new j(this, z2, eVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.C;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            this.F.a(0, z2);
            this.F.setAlpha(1.0f);
            this.F.setScaleY(1.0f);
            this.F.setScaleX(1.0f);
            c(1.0f);
            if (eVar != null) {
                eVar.a();
            }
        }
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.F.getDrawable();
        if (drawable != null && this.A != 0) {
            RectF rectF = this.I;
            RectF rectF2 = this.J;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.A;
            rectF2.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.A;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(h hVar, boolean z2) {
        if (z2) {
            hVar.a((float) (this.F.getSizeDimension() / 2));
        }
        this.h = hVar;
        this.m = z2;
        b.c.a.a.p.e eVar = this.i;
        if (eVar != null) {
            eVar.a(hVar);
        }
        Drawable drawable = this.j;
        if (drawable instanceof b.c.a.a.p.e) {
            ((b.c.a.a.p.e) drawable).a(hVar);
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(hVar);
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(b.c.a.a.a.h hVar) {
        this.x = hVar;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.n = z2;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4) {
        w();
        e(f2);
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        this.s.a(iArr);
    }

    /* access modifiers changed from: package-private */
    public void b(Rect rect) {
        if (s()) {
            this.G.a(new InsetDrawable(this.l, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.G.a(this.l);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar, boolean z2) {
        if (!i()) {
            Animator animator = this.v;
            if (animator != null) {
                animator.cancel();
            }
            if (B()) {
                b.c.a.a.a.h hVar = this.x;
                if (hVar == null) {
                    hVar = y();
                }
                AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
                a2.addListener(new i(this, z2, eVar));
                ArrayList<Animator.AnimatorListener> arrayList = this.D;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
                return;
            }
            this.F.a(z2 ? 8 : 4, z2);
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    private AnimatorSet a(b.c.a.a.a.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.F, View.ALPHA, new float[]{f2});
        hVar.b("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.F, View.SCALE_X, new float[]{f3});
        hVar.b("scale").a((Animator) ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.F, View.SCALE_Y, new float[]{f3});
        hVar.b("scale").a((Animator) ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.K);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.F, new b.c.a.a.a.f(), new k(this), new Matrix[]{new Matrix(this.K)});
        hVar.b("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        b.c.a.a.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void a(d dVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(dVar);
    }

    /* access modifiers changed from: package-private */
    public final Drawable a() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        int sizeDimension = this.n ? (this.r - this.F.getSizeDimension()) / 2 : 0;
        float b2 = b() + this.q;
        int max = Math.max(sizeDimension, (int) Math.ceil((double) b2));
        int max2 = Math.max(sizeDimension, (int) Math.ceil((double) (b2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    private ValueAnimator a(g gVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f1504a);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(gVar);
        valueAnimator.addUpdateListener(gVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }
}
