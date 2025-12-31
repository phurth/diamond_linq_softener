package com.google.android.material.bottomsheet;

import a.g.i.y;
import a.i.b.g;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.c.a.a.i;
import b.c.a.a.j;
import b.c.a.a.p.e;
import b.c.a.a.p.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1468a = i.Widget_Design_BottomSheet_Modal;
    private a A;
    private VelocityTracker B;
    int C;
    private int D;
    boolean E;
    private Map<View, Integer> F;
    private final g.a G = new c(this);

    /* renamed from: b  reason: collision with root package name */
    private int f1469b = 0;
    /* access modifiers changed from: private */
    public boolean c = true;
    private float d;
    /* access modifiers changed from: private */
    public int e;
    private boolean f;
    private int g;
    private boolean h;
    /* access modifiers changed from: private */
    public e i;
    private h j;
    /* access modifiers changed from: private */
    public ValueAnimator k;
    int l;
    int m;
    float n = 0.5f;
    int o;
    boolean p;
    /* access modifiers changed from: private */
    public boolean q;
    int r = 4;
    g s;
    private boolean t;
    private int u;
    private boolean v;
    int w;
    int x;
    WeakReference<V> y;
    WeakReference<View> z;

    public static abstract class a {
        public abstract void a(View view, float f);

        public abstract void a(View view, int i);
    }

    private class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f1472a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1473b;

        c(View view, int i) {
            this.f1472a = view;
            this.f1473b = i;
        }

        public void run() {
            g gVar = BottomSheetBehavior.this.s;
            if (gVar == null || !gVar.a(true)) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.r == 2) {
                    bottomSheetBehavior.e(this.f1473b);
                    return;
                }
                return;
            }
            y.a(this.f1472a, (Runnable) this);
        }
    }

    public BottomSheetBehavior() {
    }

    private void g() {
        this.C = -1;
        VelocityTracker velocityTracker = this.B;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.B = null;
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    private void f(int i2) {
        View view = (View) this.y.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !y.z(view)) {
                a(view, i2);
            } else {
                view.post(new a(this, view, i2));
            }
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.a(coordinatorLayout, v2, bVar.a());
        a(bVar);
        int i2 = bVar.f1470a;
        if (i2 == 1 || i2 == 2) {
            this.r = 4;
        } else {
            this.r = i2;
        }
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.r == 1 && actionMasked == 0) {
            return true;
        }
        g gVar = this.s;
        if (gVar != null) {
            gVar.a(motionEvent);
        }
        if (actionMasked == 0) {
            g();
        }
        if (this.B == null) {
            this.B = VelocityTracker.obtain();
        }
        this.B.addMovement(motionEvent);
        if (actionMasked == 2 && !this.t && Math.abs(((float) this.D) - motionEvent.getY()) > ((float) this.s.d())) {
            this.s.a((View) v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.t;
    }

    public void c(boolean z2) {
        this.q = z2;
    }

    public Parcelable d(CoordinatorLayout coordinatorLayout, V v2) {
        return new b(super.d(coordinatorLayout, v2), this);
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        View view;
        int i3 = this.r;
        if (i3 != i2) {
            this.r = i2;
            WeakReference<V> weakReference = this.y;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i2 == 6 || i2 == 3) {
                    d(true);
                } else if (i2 == 5 || i2 == 4) {
                    d(false);
                }
                y.d(view, 1);
                view.sendAccessibilityEvent(32);
                a(i2, i3);
                a aVar = this.A;
                if (aVar != null) {
                    aVar.a(view, i2);
                }
            }
        }
    }

    public void c(int i2) {
        this.f1469b = i2;
    }

    public final void d(int i2) {
        int i3 = this.r;
        if (i2 != i3) {
            if (this.y != null) {
                f(i2);
                a(i2, i3);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.p && i2 == 5)) {
                this.r = i2;
            }
        }
    }

    private void c() {
        this.m = (int) (((float) this.x) * this.n);
    }

    protected static class b extends a.i.a.c {
        public static final Parcelable.Creator<b> CREATOR = new d();

        /* renamed from: a  reason: collision with root package name */
        final int f1470a;

        /* renamed from: b  reason: collision with root package name */
        int f1471b;
        boolean c;
        boolean d;
        boolean e;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1470a = parcel.readInt();
            this.f1471b = parcel.readInt();
            boolean z = false;
            this.c = parcel.readInt() == 1;
            this.d = parcel.readInt() == 1;
            this.e = parcel.readInt() == 1 ? true : z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1470a);
            parcel.writeInt(this.f1471b);
            parcel.writeInt(this.c ? 1 : 0);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeInt(this.e ? 1 : 0);
        }

        public b(Parcelable parcelable, BottomSheetBehavior bottomSheetBehavior) {
            super(parcelable);
            this.f1470a = bottomSheetBehavior.r;
            this.f1471b = bottomSheetBehavior.e;
            this.c = bottomSheetBehavior.c;
            this.d = bottomSheetBehavior.p;
            this.e = bottomSheetBehavior.q;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.BottomSheetBehavior_Layout);
        this.h = obtainStyledAttributes.hasValue(j.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(j.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            a(context, attributeSet, hasValue, b.c.a.a.m.b.a(context, obtainStyledAttributes, j.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            a(context, attributeSet, hasValue);
        }
        d();
        TypedValue peekValue = obtainStyledAttributes.peekValue(j.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || (i2 = peekValue.data) != -1) {
            b(obtainStyledAttributes.getDimensionPixelSize(j.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            b(i2);
        }
        b(obtainStyledAttributes.getBoolean(j.BottomSheetBehavior_Layout_behavior_hideable, false));
        a(obtainStyledAttributes.getBoolean(j.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(j.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        c(obtainStyledAttributes.getInt(j.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        a(obtainStyledAttributes.getFloat(j.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        obtainStyledAttributes.recycle();
        this.d = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private float f() {
        VelocityTracker velocityTracker = this.B;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.d);
        return this.B.getYVelocity(this.C);
    }

    public void a(CoordinatorLayout.e eVar) {
        super.a(eVar);
        this.y = null;
        this.s = null;
    }

    private void d() {
        this.k = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.k.setDuration(500);
        this.k.addUpdateListener(new b(this));
    }

    public void a() {
        super.a();
        this.y = null;
        this.s = null;
    }

    private void d(boolean z2) {
        WeakReference<V> weakReference = this.y;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z2) {
                    if (this.F == null) {
                        this.F = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.y.get()) {
                        if (!z2) {
                            Map<View, Integer> map = this.F;
                            if (map != null && map.containsKey(childAt)) {
                                y.d(childAt, this.F.get(childAt).intValue());
                            }
                        } else {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.F.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            y.d(childAt, 4);
                        }
                    }
                }
                if (!z2) {
                    this.F = null;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public int e() {
        if (this.c) {
            return this.l;
        }
        return 0;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        e eVar;
        if (y.j(coordinatorLayout) && !y.j(v2)) {
            v2.setFitsSystemWindows(true);
        }
        if (this.h && (eVar = this.i) != null) {
            y.a((View) v2, (Drawable) eVar);
        }
        float i3 = y.i(v2);
        e eVar2 = this.i;
        if (eVar2 != null) {
            eVar2.a(i3);
        }
        if (this.y == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(b.c.a.a.c.design_bottom_sheet_peek_height_min);
            this.y = new WeakReference<>(v2);
        }
        if (this.s == null) {
            this.s = g.a((ViewGroup) coordinatorLayout, this.G);
        }
        int top = v2.getTop();
        coordinatorLayout.c((View) v2, i2);
        this.w = coordinatorLayout.getWidth();
        this.x = coordinatorLayout.getHeight();
        this.l = Math.max(0, this.x - v2.getHeight());
        c();
        b();
        int i4 = this.r;
        if (i4 == 3) {
            y.c(v2, e());
        } else if (i4 == 6) {
            y.c(v2, this.m);
        } else if (!this.p || i4 != 5) {
            int i5 = this.r;
            if (i5 == 4) {
                y.c(v2, this.o);
            } else if (i5 == 1 || i5 == 2) {
                y.c(v2, top - v2.getTop());
            }
        } else {
            y.c(v2, this.x);
        }
        this.z = new WeakReference<>(a((View) v2));
        return true;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.u = 0;
        this.v = false;
        if ((i2 & 2) != 0) {
            return true;
        }
        return false;
    }

    public final void b(int i2) {
        a(i2, false);
    }

    public void b(boolean z2) {
        if (this.p != z2) {
            this.p = z2;
            if (!z2 && this.r == 5) {
                d(4);
            }
        }
    }

    private void b() {
        int i2;
        if (this.f) {
            i2 = Math.max(this.g, this.x - ((this.w * 9) / 16));
        } else {
            i2 = this.e;
        }
        if (this.c) {
            this.o = Math.max(this.x - i2, this.l);
        } else {
            this.o = this.x - i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            boolean r0 = r11.isShown()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000b
            r9.t = r2
            return r1
        L_0x000b:
            int r0 = r12.getActionMasked()
            if (r0 != 0) goto L_0x0014
            r9.g()
        L_0x0014:
            android.view.VelocityTracker r3 = r9.B
            if (r3 != 0) goto L_0x001e
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r9.B = r3
        L_0x001e:
            android.view.VelocityTracker r3 = r9.B
            r3.addMovement(r12)
            r3 = 0
            r4 = -1
            r5 = 2
            if (r0 == 0) goto L_0x0039
            if (r0 == r2) goto L_0x002e
            r11 = 3
            if (r0 == r11) goto L_0x002e
            goto L_0x007c
        L_0x002e:
            r9.E = r1
            r9.C = r4
            boolean r11 = r9.t
            if (r11 == 0) goto L_0x007c
            r9.t = r1
            return r1
        L_0x0039:
            float r6 = r12.getX()
            int r6 = (int) r6
            float r7 = r12.getY()
            int r7 = (int) r7
            r9.D = r7
            int r7 = r9.r
            if (r7 == r5) goto L_0x006b
            java.lang.ref.WeakReference<android.view.View> r7 = r9.z
            if (r7 == 0) goto L_0x0054
            java.lang.Object r7 = r7.get()
            android.view.View r7 = (android.view.View) r7
            goto L_0x0055
        L_0x0054:
            r7 = r3
        L_0x0055:
            if (r7 == 0) goto L_0x006b
            int r8 = r9.D
            boolean r7 = r10.a((android.view.View) r7, (int) r6, (int) r8)
            if (r7 == 0) goto L_0x006b
            int r7 = r12.getActionIndex()
            int r7 = r12.getPointerId(r7)
            r9.C = r7
            r9.E = r2
        L_0x006b:
            int r7 = r9.C
            if (r7 != r4) goto L_0x0079
            int r4 = r9.D
            boolean r11 = r10.a((android.view.View) r11, (int) r6, (int) r4)
            if (r11 != 0) goto L_0x0079
            r11 = 1
            goto L_0x007a
        L_0x0079:
            r11 = 0
        L_0x007a:
            r9.t = r11
        L_0x007c:
            boolean r11 = r9.t
            if (r11 != 0) goto L_0x008b
            a.i.b.g r11 = r9.s
            if (r11 == 0) goto L_0x008b
            boolean r11 = r11.b((android.view.MotionEvent) r12)
            if (r11 == 0) goto L_0x008b
            return r2
        L_0x008b:
            java.lang.ref.WeakReference<android.view.View> r11 = r9.z
            if (r11 == 0) goto L_0x0096
            java.lang.Object r11 = r11.get()
            r3 = r11
            android.view.View r3 = (android.view.View) r3
        L_0x0096:
            if (r0 != r5) goto L_0x00ce
            if (r3 == 0) goto L_0x00ce
            boolean r11 = r9.t
            if (r11 != 0) goto L_0x00ce
            int r11 = r9.r
            if (r11 == r2) goto L_0x00ce
            float r11 = r12.getX()
            int r11 = (int) r11
            float r0 = r12.getY()
            int r0 = (int) r0
            boolean r10 = r10.a((android.view.View) r3, (int) r11, (int) r0)
            if (r10 != 0) goto L_0x00ce
            a.i.b.g r10 = r9.s
            if (r10 == 0) goto L_0x00ce
            int r10 = r9.D
            float r10 = (float) r10
            float r11 = r12.getY()
            float r10 = r10 - r11
            float r10 = java.lang.Math.abs(r10)
            a.i.b.g r11 = r9.s
            int r11 = r11.d()
            float r11 = (float) r11
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x00ce
            r1 = 1
        L_0x00ce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 != 1) {
            WeakReference<View> weakReference = this.z;
            if (view == (weakReference != null ? (View) weakReference.get() : null)) {
                int top = v2.getTop();
                int i5 = top - i3;
                if (i3 > 0) {
                    if (i5 < e()) {
                        iArr[1] = top - e();
                        y.c(v2, -iArr[1]);
                        e(3);
                    } else {
                        iArr[1] = i3;
                        y.c(v2, -i3);
                        e(1);
                    }
                } else if (i3 < 0 && !view.canScrollVertically(-1)) {
                    int i6 = this.o;
                    if (i5 <= i6 || this.p) {
                        iArr[1] = i3;
                        y.c(v2, -i3);
                        e(1);
                    } else {
                        iArr[1] = top - i6;
                        y.c(v2, -iArr[1]);
                        e(4);
                    }
                }
                a(v2.getTop());
                this.u = i3;
                this.v = true;
            }
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
        int i3;
        int i4;
        int i5 = 3;
        if (v2.getTop() == e()) {
            e(3);
            return;
        }
        WeakReference<View> weakReference = this.z;
        if (weakReference != null && view == weakReference.get() && this.v) {
            if (this.u > 0) {
                i3 = e();
            } else if (!this.p || !a((View) v2, f())) {
                if (this.u == 0) {
                    int top = v2.getTop();
                    if (!this.c) {
                        int i6 = this.m;
                        if (top < i6) {
                            if (top < Math.abs(top - this.o)) {
                                i3 = 0;
                            } else {
                                i3 = this.m;
                            }
                        } else if (Math.abs(top - i6) < Math.abs(top - this.o)) {
                            i3 = this.m;
                        } else {
                            i4 = this.o;
                        }
                        i5 = 6;
                    } else if (Math.abs(top - this.l) < Math.abs(top - this.o)) {
                        i3 = this.l;
                    } else {
                        i4 = this.o;
                    }
                } else {
                    i4 = this.o;
                }
                i5 = 4;
            } else {
                i3 = this.x;
                i5 = 5;
            }
            if (this.s.b((View) v2, v2.getLeft(), i3)) {
                e(2);
                y.a((View) v2, (Runnable) new c(v2, i5));
            } else {
                e(i5);
            }
            this.v = false;
        }
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.z;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.r != 3 || super.a(coordinatorLayout, v2, view, f2, f3)) {
            return true;
        }
        return false;
    }

    public void a(boolean z2) {
        if (this.c != z2) {
            this.c = z2;
            if (this.y != null) {
                b();
            }
            e((!this.c || this.r != 6) ? this.r : 3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.f
            if (r4 != 0) goto L_0x0015
            r3.f = r0
            goto L_0x001f
        L_0x000c:
            boolean r2 = r3.f
            if (r2 != 0) goto L_0x0017
            int r2 = r3.e
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x001f
        L_0x0017:
            r3.f = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.e = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0042
            java.lang.ref.WeakReference<V> r4 = r3.y
            if (r4 == 0) goto L_0x0042
            r3.b()
            int r4 = r3.r
            r0 = 4
            if (r4 != r0) goto L_0x0042
            java.lang.ref.WeakReference<V> r4 = r3.y
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x0042
            if (r5 == 0) goto L_0x003f
            int r4 = r3.r
            r3.f((int) r4)
            goto L_0x0042
        L_0x003f:
            r4.requestLayout()
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(int, boolean):void");
    }

    public void a(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.n = f2;
    }

    private void a(int i2, int i3) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        if (this.i != null) {
            if (i2 == 3 && ((i3 == 5 || i3 == 4) && (valueAnimator2 = this.k) != null && valueAnimator2.getAnimatedFraction() == 1.0f)) {
                this.k.reverse();
            }
            if (i2 == 1 && i3 == 3 && (valueAnimator = this.k) != null) {
                valueAnimator.start();
            }
        }
    }

    private void a(b bVar) {
        int i2 = this.f1469b;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.e = bVar.f1471b;
            }
            int i3 = this.f1469b;
            if (i3 == -1 || (i3 & 2) == 2) {
                this.c = bVar.c;
            }
            int i4 = this.f1469b;
            if (i4 == -1 || (i4 & 4) == 4) {
                this.p = bVar.d;
            }
            int i5 = this.f1469b;
            if (i5 == -1 || (i5 & 8) == 8) {
                this.q = bVar.e;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, float f2) {
        if (this.q) {
            return true;
        }
        if (view.getTop() >= this.o && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.o)) / ((float) this.e) > 0.5f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public View a(View view) {
        if (y.B(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View a2 = a(viewGroup.getChildAt(i2));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    private void a(Context context, AttributeSet attributeSet, boolean z2) {
        a(context, attributeSet, z2, (ColorStateList) null);
    }

    private void a(Context context, AttributeSet attributeSet, boolean z2, ColorStateList colorStateList) {
        if (this.h) {
            this.j = new h(context, attributeSet, b.c.a.a.b.bottomSheetStyle, f1468a);
            this.i = new e(this.j);
            this.i.a(context);
            if (!z2 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.i.setTint(typedValue.data);
                return;
            }
            this.i.a(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.o;
        } else if (i2 == 6) {
            int i5 = this.m;
            if (!this.c || i5 > (i4 = this.l)) {
                i3 = i5;
            } else {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = e();
        } else if (!this.p || i2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        } else {
            i3 = this.x;
        }
        if (this.s.b(view, view.getLeft(), i3)) {
            e(2);
            y.a(view, (Runnable) new c(view, i2));
            return;
        }
        e(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        a aVar;
        View view = (View) this.y.get();
        if (view != null && (aVar = this.A) != null) {
            int i3 = this.o;
            if (i2 > i3) {
                aVar.a(view, ((float) (i3 - i2)) / ((float) (this.x - i3)));
            } else {
                aVar.a(view, ((float) (i3 - i2)) / ((float) (i3 - e())));
            }
        }
    }
}
