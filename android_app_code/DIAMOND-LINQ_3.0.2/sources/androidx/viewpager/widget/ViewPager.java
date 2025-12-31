package androidx.viewpager.widget;

import a.g.i.C0037a;
import a.g.i.q;
import a.g.i.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f1029a = {16842931};

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<b> f1030b = new b();
    private static final Interpolator c = new c();
    private static final j d = new j();
    private boolean A;
    private int B = 1;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private float H;
    private float I;
    private float J;
    private float K;
    private int L = -1;
    private VelocityTracker M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private EdgeEffect S;
    private EdgeEffect T;
    private boolean U = true;
    private boolean V = false;
    private boolean W;
    private int aa;
    private List<f> ba;
    private f ca;
    private f da;
    private int e;
    private List<e> ea;
    private final ArrayList<b> f = new ArrayList<>();
    private g fa;
    private final b g = new b();
    private int ga;
    private final Rect h = new Rect();
    private int ha;
    a i;
    private ArrayList<View> ia;
    int j;
    private final Runnable ja = new d(this);
    private int k = -1;
    private int ka = 0;
    private Parcelable l = null;
    private ClassLoader m = null;
    private Scroller n;
    private boolean o;
    private h p;
    private int q;
    private Drawable r;
    private int s;
    private int t;
    private float u = -3.4028235E38f;
    private float v = Float.MAX_VALUE;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        Object f1031a;

        /* renamed from: b  reason: collision with root package name */
        int f1032b;
        boolean c;
        float d;
        float e;

        b() {
        }
    }

    public interface e {
        void a(ViewPager viewPager, a aVar, a aVar2);
    }

    public interface f {
        void a(int i);

        void a(int i, float f, int i2);

        void b(int i);
    }

    public interface g {
        void a(View view, float f);
    }

    private class h extends DataSetObserver {
        h() {
        }

        public void onChanged() {
            ViewPager.this.a();
        }

        public void onInvalidated() {
            ViewPager.this.a();
        }
    }

    public static class i extends a.i.a.c {
        public static final Parcelable.Creator<i> CREATOR = new f();

        /* renamed from: a  reason: collision with root package name */
        int f1036a;

        /* renamed from: b  reason: collision with root package name */
        Parcelable f1037b;
        ClassLoader c;

        public i(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f1036a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1036a);
            parcel.writeParcelable(this.f1037b, i);
        }

        i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? i.class.getClassLoader() : classLoader;
            this.f1036a = parcel.readInt();
            this.f1037b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }
    }

    static class j implements Comparator<View> {
        j() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            boolean z = cVar.f1033a;
            if (z != cVar2.f1033a) {
                return z ? 1 : -1;
            }
            return cVar.e - cVar2.e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        b();
    }

    private void d(int i2) {
        f fVar = this.ca;
        if (fVar != null) {
            fVar.b(i2);
        }
        List<f> list = this.ba;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar2 = this.ba.get(i3);
                if (fVar2 != null) {
                    fVar2.b(i2);
                }
            }
        }
        f fVar3 = this.da;
        if (fVar3 != null) {
            fVar3.b(i2);
        }
    }

    private boolean f(int i2) {
        if (this.f.size() != 0) {
            b g2 = g();
            int clientWidth = getClientWidth();
            int i3 = this.q;
            int i4 = clientWidth + i3;
            float f2 = (float) clientWidth;
            int i5 = g2.f1032b;
            float f3 = ((((float) i2) / f2) - g2.e) / (g2.d + (((float) i3) / f2));
            this.W = false;
            a(i5, f3, (int) (((float) i4) * f3));
            if (this.W) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.U) {
            return false;
        } else {
            this.W = false;
            a(0, 0.0f, 0);
            if (this.W) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private b g() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f2 = clientWidth > 0 ? ((float) this.q) / ((float) clientWidth) : 0.0f;
        b bVar = null;
        int i3 = 0;
        boolean z2 = true;
        int i4 = -1;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (i3 < this.f.size()) {
            b bVar2 = this.f.get(i3);
            if (!z2 && bVar2.f1032b != (i2 = i4 + 1)) {
                bVar2 = this.g;
                bVar2.e = f3 + f4 + f2;
                bVar2.f1032b = i2;
                bVar2.d = this.i.a(bVar2.f1032b);
                i3--;
            }
            f3 = bVar2.e;
            float f5 = bVar2.d + f3 + f2;
            if (!z2 && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i3 == this.f.size() - 1) {
                return bVar2;
            }
            i4 = bVar2.f1032b;
            f4 = bVar2.d;
            i3++;
            bVar = bVar2;
            z2 = false;
        }
        return bVar;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).f1033a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private boolean i() {
        this.L = -1;
        f();
        this.S.onRelease();
        this.T.onRelease();
        return this.S.isFinished() || this.T.isFinished();
    }

    private void j() {
        if (this.ha != 0) {
            ArrayList<View> arrayList = this.ia;
            if (arrayList == null) {
                this.ia = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.ia.add(getChildAt(i2));
            }
            Collections.sort(this.ia, d);
        }
    }

    private void setScrollingCacheEnabled(boolean z2) {
        if (this.z != z2) {
            this.z = z2;
        }
    }

    public void a(int i2, boolean z2) {
        this.A = false;
        a(i2, z2, false);
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b b2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1032b == this.j) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        b b2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1032b == this.j) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        cVar.f1033a |= c(view);
        if (!this.y) {
            super.addView(view, i2, layoutParams);
        } else if (cVar == null || !cVar.f1033a) {
            cVar.d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.n = new Scroller(context, c);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.G = viewConfiguration.getScaledPagingTouchSlop();
        this.N = (int) (400.0f * f2);
        this.O = viewConfiguration.getScaledMaximumFlingVelocity();
        this.S = new EdgeEffect(context);
        this.T = new EdgeEffect(context);
        this.P = (int) (25.0f * f2);
        this.Q = (int) (2.0f * f2);
        this.E = (int) (f2 * 16.0f);
        y.a((View) this, (C0037a) new d());
        if (y.k(this) == 0) {
            y.d(this, 1);
        }
        y.a((View) this, (q) new e(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r9 == r10) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r8 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.j
            if (r2 == r1) goto L_0x000f
            androidx.viewpager.widget.ViewPager$b r2 = r0.b((int) r2)
            r0.j = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.viewpager.widget.a r1 = r0.i
            if (r1 != 0) goto L_0x0018
            r17.j()
            return
        L_0x0018:
            boolean r1 = r0.A
            if (r1 == 0) goto L_0x0020
            r17.j()
            return
        L_0x0020:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            androidx.viewpager.widget.a r1 = r0.i
            r1.b((android.view.ViewGroup) r0)
            int r1 = r0.B
            int r4 = r0.j
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.a r6 = r0.i
            int r6 = r6.a()
            int r7 = r6 + -1
            int r8 = r0.j
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.e
            if (r6 != r7) goto L_0x0211
            r7 = 0
        L_0x004a:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r8 = r0.f
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x0066
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r8 = r0.f
            java.lang.Object r8 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$b r8 = (androidx.viewpager.widget.ViewPager.b) r8
            int r9 = r8.f1032b
            int r10 = r0.j
            if (r9 < r10) goto L_0x0063
            if (r9 != r10) goto L_0x0066
            goto L_0x0067
        L_0x0063:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0066:
            r8 = 0
        L_0x0067:
            if (r8 != 0) goto L_0x0071
            if (r6 <= 0) goto L_0x0071
            int r8 = r0.j
            androidx.viewpager.widget.ViewPager$b r8 = r0.a((int) r8, (int) r7)
        L_0x0071:
            r9 = 0
            if (r8 == 0) goto L_0x019e
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0081
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r11 = r0.f
            java.lang.Object r11 = r11.get(r10)
            androidx.viewpager.widget.ViewPager$b r11 = (androidx.viewpager.widget.ViewPager.b) r11
            goto L_0x0082
        L_0x0081:
            r11 = 0
        L_0x0082:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x008c
            r3 = 0
            goto L_0x0099
        L_0x008c:
            float r14 = r8.d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r3 = r14 + r15
        L_0x0099:
            int r14 = r0.j
            int r14 = r14 + -1
            r15 = r10
            r10 = r7
            r7 = 0
        L_0x00a0:
            if (r14 < 0) goto L_0x0100
            int r16 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x00ce
            if (r14 >= r4) goto L_0x00ce
            if (r11 != 0) goto L_0x00ab
            goto L_0x0100
        L_0x00ab:
            int r5 = r11.f1032b
            if (r14 != r5) goto L_0x00fc
            boolean r5 = r11.c
            if (r5 != 0) goto L_0x00fc
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            r5.remove(r15)
            androidx.viewpager.widget.a r5 = r0.i
            java.lang.Object r11 = r11.f1031a
            r5.a((android.view.ViewGroup) r0, (int) r14, (java.lang.Object) r11)
            int r15 = r15 + -1
            int r10 = r10 + -1
            if (r15 < 0) goto L_0x00fa
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            java.lang.Object r5 = r5.get(r15)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x00fb
        L_0x00ce:
            if (r11 == 0) goto L_0x00e4
            int r5 = r11.f1032b
            if (r14 != r5) goto L_0x00e4
            float r5 = r11.d
            float r7 = r7 + r5
            int r15 = r15 + -1
            if (r15 < 0) goto L_0x00fa
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            java.lang.Object r5 = r5.get(r15)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x00fb
        L_0x00e4:
            int r5 = r15 + 1
            androidx.viewpager.widget.ViewPager$b r5 = r0.a((int) r14, (int) r5)
            float r5 = r5.d
            float r7 = r7 + r5
            int r10 = r10 + 1
            if (r15 < 0) goto L_0x00fa
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            java.lang.Object r5 = r5.get(r15)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x00fb
        L_0x00fa:
            r5 = 0
        L_0x00fb:
            r11 = r5
        L_0x00fc:
            int r14 = r14 + -1
            r5 = 0
            goto L_0x00a0
        L_0x0100:
            float r3 = r8.d
            int r4 = r10 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0192
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0119
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x011a
        L_0x0119:
            r5 = 0
        L_0x011a:
            if (r12 > 0) goto L_0x011e
            r7 = 0
            goto L_0x0126
        L_0x011e:
            int r7 = r17.getPaddingRight()
            float r7 = (float) r7
            float r11 = (float) r12
            float r7 = r7 / r11
            float r7 = r7 + r13
        L_0x0126:
            int r11 = r0.j
        L_0x0128:
            int r11 = r11 + 1
            if (r11 >= r6) goto L_0x0192
            int r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r12 < 0) goto L_0x015c
            if (r11 <= r1) goto L_0x015c
            if (r5 != 0) goto L_0x0135
            goto L_0x0192
        L_0x0135:
            int r12 = r5.f1032b
            if (r11 != r12) goto L_0x0191
            boolean r12 = r5.c
            if (r12 != 0) goto L_0x0191
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r12 = r0.f
            r12.remove(r4)
            androidx.viewpager.widget.a r12 = r0.i
            java.lang.Object r5 = r5.f1031a
            r12.a((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r5)
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015a
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x0191
        L_0x015a:
            r5 = 0
            goto L_0x0191
        L_0x015c:
            if (r5 == 0) goto L_0x0178
            int r12 = r5.f1032b
            if (r11 != r12) goto L_0x0178
            float r5 = r5.d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015a
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
            goto L_0x0191
        L_0x0178:
            androidx.viewpager.widget.ViewPager$b r5 = r0.a((int) r11, (int) r4)
            int r4 = r4 + 1
            float r5 = r5.d
            float r3 = r3 + r5
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x015a
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$b> r5 = r0.f
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$b r5 = (androidx.viewpager.widget.ViewPager.b) r5
        L_0x0191:
            goto L_0x0128
        L_0x0192:
            r0.a((androidx.viewpager.widget.ViewPager.b) r8, (int) r10, (androidx.viewpager.widget.ViewPager.b) r2)
            androidx.viewpager.widget.a r1 = r0.i
            int r2 = r0.j
            java.lang.Object r3 = r8.f1031a
            r1.b(r0, r2, r3)
        L_0x019e:
            androidx.viewpager.widget.a r1 = r0.i
            r1.a((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x01a8:
            if (r2 >= r1) goto L_0x01d1
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r4 = (androidx.viewpager.widget.ViewPager.c) r4
            r4.f = r2
            boolean r5 = r4.f1033a
            if (r5 != 0) goto L_0x01ce
            float r5 = r4.c
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01ce
            androidx.viewpager.widget.ViewPager$b r3 = r0.b((android.view.View) r3)
            if (r3 == 0) goto L_0x01ce
            float r5 = r3.d
            r4.c = r5
            int r3 = r3.f1032b
            r4.e = r3
        L_0x01ce:
            int r2 = r2 + 1
            goto L_0x01a8
        L_0x01d1:
            r17.j()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x0210
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01e5
            androidx.viewpager.widget.ViewPager$b r3 = r0.a((android.view.View) r1)
            goto L_0x01e6
        L_0x01e5:
            r3 = 0
        L_0x01e6:
            if (r3 == 0) goto L_0x01ee
            int r1 = r3.f1032b
            int r2 = r0.j
            if (r1 == r2) goto L_0x0210
        L_0x01ee:
            r1 = 0
        L_0x01ef:
            int r2 = r17.getChildCount()
            if (r1 >= r2) goto L_0x0210
            android.view.View r2 = r0.getChildAt(r1)
            androidx.viewpager.widget.ViewPager$b r3 = r0.b((android.view.View) r2)
            if (r3 == 0) goto L_0x020d
            int r3 = r3.f1032b
            int r4 = r0.j
            if (r3 != r4) goto L_0x020d
            r3 = 2
            boolean r2 = r2.requestFocus(r3)
            if (r2 == 0) goto L_0x020d
            goto L_0x0210
        L_0x020d:
            int r1 = r1 + 1
            goto L_0x01ef
        L_0x0210:
            return
        L_0x0211:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x021e }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x021e }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x021e }
            goto L_0x0226
        L_0x021e:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0226:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.e
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class<androidx.viewpager.widget.ViewPager> r1 = androidx.viewpager.widget.ViewPager.class
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.a r1 = r0.i
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.c(int):void");
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.i == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.u))) {
                return true;
            }
            return false;
        } else if (i2 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.v))) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.o = true;
        if (this.n.isFinished() || !this.n.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.n.getCurrX();
        int currY = this.n.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!f(currX)) {
                this.n.abortAnimation();
                scrollTo(0, currY);
            }
        }
        y.E(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b b2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1032b == this.j && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z2 = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.i) != null && aVar.a() > 1)) {
            if (!this.S.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.u * ((float) width));
                this.S.setSize(height, width);
                z2 = false | this.S.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.T.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.v + 1.0f)) * ((float) width2));
                this.T.setSize(height2, width2);
                z2 |= this.T.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.S.finish();
            this.T.finish();
        }
        if (z2) {
            y.E(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.r;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        c(this.j);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public a getAdapter() {
        return this.i;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.ha == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.ia.get(i3).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.j;
    }

    public int getOffscreenPageLimit() {
        return this.B;
    }

    public int getPageMargin() {
        return this.q;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.U = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.ja);
        Scroller scroller = this.n;
        if (scroller != null && !scroller.isFinished()) {
            this.n.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.q > 0 && this.r != null && this.f.size() > 0 && this.i != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f4 = (float) width;
            float f5 = ((float) this.q) / f4;
            int i2 = 0;
            b bVar = this.f.get(0);
            float f6 = bVar.e;
            int size = this.f.size();
            int i3 = bVar.f1032b;
            int i4 = this.f.get(size - 1).f1032b;
            while (i3 < i4) {
                while (i3 > bVar.f1032b && i2 < size) {
                    i2++;
                    bVar = this.f.get(i2);
                }
                if (i3 == bVar.f1032b) {
                    float f7 = bVar.e;
                    float f8 = bVar.d;
                    f2 = (f7 + f8) * f4;
                    f6 = f7 + f8 + f5;
                } else {
                    float a2 = this.i.a(i3);
                    f2 = (f6 + a2) * f4;
                    f6 += a2 + f5;
                }
                if (((float) this.q) + f2 > ((float) scrollX)) {
                    f3 = f5;
                    this.r.setBounds(Math.round(f2), this.s, Math.round(((float) this.q) + f2), this.t);
                    this.r.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f3 = f5;
                }
                if (f2 <= ((float) (scrollX + width))) {
                    i3++;
                    f5 = f3;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            i();
            return false;
        }
        if (action != 0) {
            if (this.C) {
                return true;
            }
            if (this.D) {
                return false;
            }
        }
        if (action == 0) {
            float x2 = motionEvent.getX();
            this.J = x2;
            this.H = x2;
            float y2 = motionEvent.getY();
            this.K = y2;
            this.I = y2;
            this.L = motionEvent2.getPointerId(0);
            this.D = false;
            this.o = true;
            this.n.computeScrollOffset();
            if (this.ka != 2 || Math.abs(this.n.getFinalX() - this.n.getCurrX()) <= this.Q) {
                a(false);
                this.C = false;
            } else {
                this.n.abortAnimation();
                this.A = false;
                e();
                this.C = true;
                c(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.L;
            if (i2 != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i2);
                float x3 = motionEvent2.getX(findPointerIndex);
                float f2 = x3 - this.H;
                float abs = Math.abs(f2);
                float y3 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y3 - this.K);
                if (f2 != 0.0f && !a(this.H, f2)) {
                    if (a(this, false, (int) f2, (int) x3, (int) y3)) {
                        this.H = x3;
                        this.I = y3;
                        this.D = true;
                        return false;
                    }
                }
                if (abs > ((float) this.G) && abs * 0.5f > abs2) {
                    this.C = true;
                    c(true);
                    setScrollState(1);
                    this.H = f2 > 0.0f ? this.J + ((float) this.G) : this.J - ((float) this.G);
                    this.I = y3;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) this.G)) {
                    this.D = true;
                }
                if (this.C && b(x3)) {
                    y.E(this);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent2);
        return this.C;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean z3;
        b b2;
        int i6;
        int i7;
        int childCount = getChildCount();
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i10 = paddingBottom;
        int i11 = 0;
        int i12 = paddingTop;
        int i13 = paddingLeft;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f1033a) {
                    int i15 = cVar.f1034b;
                    int i16 = i15 & 7;
                    int i17 = i15 & 112;
                    if (i16 == 1) {
                        i6 = Math.max((i8 - childAt.getMeasuredWidth()) / 2, i13);
                    } else if (i16 == 3) {
                        i6 = i13;
                        i13 = childAt.getMeasuredWidth() + i13;
                    } else if (i16 != 5) {
                        i6 = i13;
                    } else {
                        i6 = (i8 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i17 == 16) {
                        i7 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, i12);
                    } else if (i17 == 48) {
                        i7 = i12;
                        i12 = childAt.getMeasuredHeight() + i12;
                    } else if (i17 != 80) {
                        i7 = i12;
                    } else {
                        i7 = (i9 - i10) - childAt.getMeasuredHeight();
                        i10 += childAt.getMeasuredHeight();
                    }
                    int i18 = i6 + scrollX;
                    childAt.layout(i18, i7, childAt.getMeasuredWidth() + i18, i7 + childAt.getMeasuredHeight());
                    i11++;
                }
            }
        }
        int i19 = (i8 - i13) - paddingRight;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                c cVar2 = (c) childAt2.getLayoutParams();
                if (!cVar2.f1033a && (b2 = b(childAt2)) != null) {
                    float f2 = (float) i19;
                    int i21 = ((int) (b2.e * f2)) + i13;
                    if (cVar2.d) {
                        cVar2.d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * cVar2.c), 1073741824), View.MeasureSpec.makeMeasureSpec((i9 - i12) - i10, 1073741824));
                    }
                    childAt2.layout(i21, i12, childAt2.getMeasuredWidth() + i21, childAt2.getMeasuredHeight() + i12);
                }
            }
        }
        this.s = i12;
        this.t = i9 - i10;
        this.aa = i11;
        if (this.U) {
            z3 = false;
            a(this.j, false, 0, false);
        } else {
            z3 = false;
        }
        this.U = z3;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r0 = 0
            int r14 = android.view.ViewGroup.getDefaultSize(r0, r14)
            int r15 = android.view.ViewGroup.getDefaultSize(r0, r15)
            r13.setMeasuredDimension(r14, r15)
            int r14 = r13.getMeasuredWidth()
            int r15 = r14 / 10
            int r1 = r13.E
            int r15 = java.lang.Math.min(r15, r1)
            r13.F = r15
            int r15 = r13.getPaddingLeft()
            int r14 = r14 - r15
            int r15 = r13.getPaddingRight()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredHeight()
            int r1 = r13.getPaddingTop()
            int r15 = r15 - r1
            int r1 = r13.getPaddingBottom()
            int r15 = r15 - r1
            int r1 = r13.getChildCount()
            r2 = r15
            r15 = r14
            r14 = 0
        L_0x0039:
            r3 = 8
            r4 = 1
            r5 = 1073741824(0x40000000, float:2.0)
            if (r14 >= r1) goto L_0x00b4
            android.view.View r6 = r13.getChildAt(r14)
            int r7 = r6.getVisibility()
            if (r7 == r3) goto L_0x00b1
            android.view.ViewGroup$LayoutParams r3 = r6.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r3 = (androidx.viewpager.widget.ViewPager.c) r3
            if (r3 == 0) goto L_0x00b1
            boolean r7 = r3.f1033a
            if (r7 == 0) goto L_0x00b1
            int r7 = r3.f1034b
            r8 = r7 & 7
            r7 = r7 & 112(0x70, float:1.57E-43)
            r9 = 48
            if (r7 == r9) goto L_0x0067
            r9 = 80
            if (r7 != r9) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r7 = 0
            goto L_0x0068
        L_0x0067:
            r7 = 1
        L_0x0068:
            r9 = 3
            if (r8 == r9) goto L_0x0070
            r9 = 5
            if (r8 != r9) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r7 == 0) goto L_0x0077
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x007c
        L_0x0077:
            if (r4 == 0) goto L_0x007c
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x007e
        L_0x007c:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x007e:
            int r10 = r3.width
            r11 = -1
            r12 = -2
            if (r10 == r12) goto L_0x008b
            if (r10 == r11) goto L_0x0087
            goto L_0x0088
        L_0x0087:
            r10 = r15
        L_0x0088:
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x008c
        L_0x008b:
            r10 = r15
        L_0x008c:
            int r3 = r3.height
            if (r3 == r12) goto L_0x0095
            if (r3 == r11) goto L_0x0093
            goto L_0x0097
        L_0x0093:
            r3 = r2
            goto L_0x0097
        L_0x0095:
            r3 = r2
            r5 = r9
        L_0x0097:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r8)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r5)
            r6.measure(r8, r3)
            if (r7 == 0) goto L_0x00aa
            int r3 = r6.getMeasuredHeight()
            int r2 = r2 - r3
            goto L_0x00b1
        L_0x00aa:
            if (r4 == 0) goto L_0x00b1
            int r3 = r6.getMeasuredWidth()
            int r15 = r15 - r3
        L_0x00b1:
            int r14 = r14 + 1
            goto L_0x0039
        L_0x00b4:
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r5)
            r13.w = r14
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r5)
            r13.x = r14
            r13.y = r4
            r13.e()
            r13.y = r0
            int r14 = r13.getChildCount()
        L_0x00cb:
            if (r0 >= r14) goto L_0x00f5
            android.view.View r1 = r13.getChildAt(r0)
            int r2 = r1.getVisibility()
            if (r2 == r3) goto L_0x00f2
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r2 = (androidx.viewpager.widget.ViewPager.c) r2
            if (r2 == 0) goto L_0x00e3
            boolean r4 = r2.f1033a
            if (r4 != 0) goto L_0x00f2
        L_0x00e3:
            float r4 = (float) r15
            float r2 = r2.c
            float r4 = r4 * r2
            int r2 = (int) r4
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r5)
            int r4 = r13.x
            r1.measure(r2, r4)
        L_0x00f2:
            int r0 = r0 + 1
            goto L_0x00cb
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b b2;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
        }
        while (i4 != i5) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (b2 = b(childAt)) != null && b2.f1032b == this.j && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i4 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.a());
        a aVar = this.i;
        if (aVar != null) {
            aVar.a(iVar.f1037b, iVar.c);
            a(iVar.f1036a, false, true);
            return;
        }
        this.k = iVar.f1036a;
        this.l = iVar.f1037b;
        this.m = iVar.c;
    }

    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        iVar.f1036a = this.j;
        a aVar = this.i;
        if (aVar != null) {
            iVar.f1037b = aVar.b();
        }
        return iVar;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.q;
            a(i2, i4, i6, i6);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.R) {
            return true;
        }
        boolean z2 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.i) == null || aVar.a() == 0) {
            return false;
        }
        if (this.M == null) {
            this.M = VelocityTracker.obtain();
        }
        this.M.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.n.abortAnimation();
            this.A = false;
            e();
            float x2 = motionEvent.getX();
            this.J = x2;
            this.H = x2;
            float y2 = motionEvent.getY();
            this.K = y2;
            this.I = y2;
            this.L = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.C) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.L);
                    if (findPointerIndex == -1) {
                        z2 = i();
                    } else {
                        float x3 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x3 - this.H);
                        float y3 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y3 - this.I);
                        if (abs > ((float) this.G) && abs > abs2) {
                            this.C = true;
                            c(true);
                            float f2 = this.J;
                            this.H = x3 - f2 > 0.0f ? f2 + ((float) this.G) : f2 - ((float) this.G);
                            this.I = y3;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.C) {
                    z2 = false | b(motionEvent.getX(motionEvent.findPointerIndex(this.L)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.H = motionEvent.getX(actionIndex);
                    this.L = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    a(motionEvent);
                    this.H = motionEvent.getX(motionEvent.findPointerIndex(this.L));
                }
            } else if (this.C) {
                a(this.j, true, 0, false);
                z2 = i();
            }
        } else if (this.C) {
            VelocityTracker velocityTracker = this.M;
            velocityTracker.computeCurrentVelocity(1000, (float) this.O);
            int xVelocity = (int) velocityTracker.getXVelocity(this.L);
            this.A = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            b g2 = g();
            float f3 = (float) clientWidth;
            a(a(g2.f1032b, ((((float) scrollX) / f3) - g2.e) / (g2.d + (((float) this.q) / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.L)) - this.J)), true, true, xVelocity);
            z2 = i();
        }
        if (z2) {
            y.E(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.y) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(a aVar) {
        a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.a((DataSetObserver) null);
            this.i.b((ViewGroup) this);
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                b bVar = this.f.get(i2);
                this.i.a((ViewGroup) this, bVar.f1032b, bVar.f1031a);
            }
            this.i.a((ViewGroup) this);
            this.f.clear();
            h();
            this.j = 0;
            scrollTo(0, 0);
        }
        a aVar3 = this.i;
        this.i = aVar;
        this.e = 0;
        if (this.i != null) {
            if (this.p == null) {
                this.p = new h();
            }
            this.i.a((DataSetObserver) this.p);
            this.A = false;
            boolean z2 = this.U;
            this.U = true;
            this.e = this.i.a();
            if (this.k >= 0) {
                this.i.a(this.l, this.m);
                a(this.k, false, true);
                this.k = -1;
                this.l = null;
                this.m = null;
            } else if (!z2) {
                e();
            } else {
                requestLayout();
            }
        }
        List<e> list = this.ea;
        if (list != null && !list.isEmpty()) {
            int size = this.ea.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.ea.get(i3).a(this, aVar3, aVar);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.A = false;
        a(i2, !this.U, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to " + 1);
            i2 = 1;
        }
        if (i2 != this.B) {
            this.B = i2;
            e();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(f fVar) {
        this.ca = fVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.q;
        this.q = i2;
        int width = getWidth();
        a(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.r = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (this.ka != i2) {
            this.ka = i2;
            if (this.fa != null) {
                b(i2 != 0);
            }
            e(i2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1033a;

        /* renamed from: b  reason: collision with root package name */
        public int f1034b;
        float c = 0.0f;
        boolean d;
        int e;
        int f;

        public c() {
            super(-1, -1);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1029a);
            this.f1034b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    private void e(int i2) {
        f fVar = this.ca;
        if (fVar != null) {
            fVar.a(i2);
        }
        List<f> list = this.ba;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                f fVar2 = this.ba.get(i3);
                if (fVar2 != null) {
                    fVar2.a(i2);
                }
            }
        }
        f fVar3 = this.da;
        if (fVar3 != null) {
            fVar3.a(i2);
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2, boolean z3) {
        a(i2, z2, z3, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2, boolean z3, int i3) {
        a aVar = this.i;
        if (aVar == null || aVar.a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z3 || this.j != i2 || this.f.size() == 0) {
            boolean z4 = true;
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.i.a()) {
                i2 = this.i.a() - 1;
            }
            int i4 = this.B;
            int i5 = this.j;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.f.size(); i6++) {
                    this.f.get(i6).c = true;
                }
            }
            if (this.j == i2) {
                z4 = false;
            }
            if (this.U) {
                this.j = i2;
                if (z4) {
                    d(i2);
                }
                requestLayout();
                return;
            }
            c(i2);
            a(i2, z2, i3, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(a.g.a.a.c(getContext(), i2));
    }

    class d extends C0037a {
        d() {
        }

        public void a(View view, a.g.i.a.c cVar) {
            super.a(view, cVar);
            cVar.b((CharSequence) ViewPager.class.getName());
            cVar.k(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                cVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                cVar.a(8192);
            }
        }

        public void b(View view, AccessibilityEvent accessibilityEvent) {
            a aVar;
            super.b(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() == 4096 && (aVar = ViewPager.this.i) != null) {
                accessibilityEvent.setItemCount(aVar.a());
                accessibilityEvent.setFromIndex(ViewPager.this.j);
                accessibilityEvent.setToIndex(ViewPager.this.j);
            }
        }

        private boolean b() {
            a aVar = ViewPager.this.i;
            return aVar != null && aVar.a() > 1;
        }

        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.j - 1);
                return true;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.setCurrentItem(viewPager2.j + 1);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.i;
        if (aVar == null || this.j >= aVar.a() - 1) {
            return false;
        }
        a(this.j + 1, true);
        return true;
    }

    private void f() {
        this.C = false;
        this.D = false;
        VelocityTracker velocityTracker = this.M;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.M = null;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public void b(f fVar) {
        List<f> list = this.ba;
        if (list != null) {
            list.remove(fVar);
        }
    }

    private void a(int i2, boolean z2, int i3, boolean z3) {
        b b2 = b(i2);
        int clientWidth = b2 != null ? (int) (((float) getClientWidth()) * Math.max(this.u, Math.min(b2.e, this.v))) : 0;
        if (z2) {
            a(clientWidth, 0, i3);
            if (z3) {
                d(i2);
                return;
            }
            return;
        }
        if (z3) {
            d(i2);
        }
        a(false);
        scrollTo(clientWidth, 0);
        f(clientWidth);
    }

    /* access modifiers changed from: package-private */
    public b b(View view) {
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            b bVar = this.f.get(i2);
            if (this.i.a(view, bVar.f1031a)) {
                return bVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public b b(int i2) {
        for (int i3 = 0; i3 < this.f.size(); i3++) {
            b bVar = this.f.get(i3);
            if (bVar.f1032b == i2) {
                return bVar;
            }
        }
        return null;
    }

    private void b(int i2, float f2, int i3) {
        f fVar = this.ca;
        if (fVar != null) {
            fVar.a(i2, f2, i3);
        }
        List<f> list = this.ba;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar2 = this.ba.get(i4);
                if (fVar2 != null) {
                    fVar2.a(i2, f2, i3);
                }
            }
        }
        f fVar3 = this.da;
        if (fVar3 != null) {
            fVar3.a(i2, f2, i3);
        }
    }

    public void a(f fVar) {
        if (this.ba == null) {
            this.ba = new ArrayList();
        }
        this.ba.add(fVar);
    }

    /* access modifiers changed from: package-private */
    public float a(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    private void b(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z2 ? this.ga : 0, (Paint) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4) {
        int i5;
        int i6;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.n;
        if (scroller != null && !scroller.isFinished()) {
            i5 = this.o ? this.n.getCurrX() : this.n.getStartX();
            this.n.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            i5 = getScrollX();
        }
        int i7 = i5;
        int scrollY = getScrollY();
        int i8 = i2 - i7;
        int i9 = i3 - scrollY;
        if (i8 == 0 && i9 == 0) {
            a(false);
            e();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i10 = clientWidth / 2;
        float f2 = (float) clientWidth;
        float f3 = (float) i10;
        float a2 = f3 + (a(Math.min(1.0f, (((float) Math.abs(i8)) * 1.0f) / f2)) * f3);
        int abs = Math.abs(i4);
        if (abs > 0) {
            i6 = Math.round(Math.abs(a2 / ((float) abs)) * 1000.0f) * 4;
        } else {
            i6 = (int) (((((float) Math.abs(i8)) / ((f2 * this.i.a(this.j)) + ((float) this.q))) + 1.0f) * 100.0f);
        }
        int min = Math.min(i6, 600);
        this.o = false;
        this.n.startScroll(i7, scrollY, i8, i9, min);
        y.E(this);
    }

    private boolean b(float f2) {
        boolean z2;
        boolean z3;
        float f3 = this.H - f2;
        this.H = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.u * clientWidth;
        float f5 = this.v * clientWidth;
        boolean z4 = false;
        b bVar = this.f.get(0);
        ArrayList<b> arrayList = this.f;
        b bVar2 = arrayList.get(arrayList.size() - 1);
        if (bVar.f1032b != 0) {
            f4 = bVar.e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (bVar2.f1032b != this.i.a() - 1) {
            f5 = bVar2.e * clientWidth;
            z3 = false;
        } else {
            z3 = true;
        }
        if (scrollX < f4) {
            if (z2) {
                this.S.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z3) {
                this.T.onPull(Math.abs(scrollX - f5) / clientWidth);
                z4 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.H += scrollX - ((float) i2);
        scrollTo(i2, getScrollY());
        f(i2);
        return z4;
    }

    /* access modifiers changed from: package-private */
    public b a(int i2, int i3) {
        b bVar = new b();
        bVar.f1032b = i2;
        bVar.f1031a = this.i.a((ViewGroup) this, i2);
        bVar.d = this.i.a(i2);
        if (i3 < 0 || i3 >= this.f.size()) {
            this.f.add(bVar);
        } else {
            this.f.add(i3, bVar);
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int a2 = this.i.a();
        this.e = a2;
        boolean z2 = this.f.size() < (this.B * 2) + 1 && this.f.size() < a2;
        int i2 = this.j;
        int i3 = 0;
        boolean z3 = false;
        while (i3 < this.f.size()) {
            b bVar = this.f.get(i3);
            int a3 = this.i.a(bVar.f1031a);
            if (a3 != -1) {
                if (a3 == -2) {
                    this.f.remove(i3);
                    i3--;
                    if (!z3) {
                        this.i.b((ViewGroup) this);
                        z3 = true;
                    }
                    this.i.a((ViewGroup) this, bVar.f1032b, bVar.f1031a);
                    int i4 = this.j;
                    if (i4 == bVar.f1032b) {
                        i2 = Math.max(0, Math.min(i4, a2 - 1));
                    }
                } else {
                    int i5 = bVar.f1032b;
                    if (i5 != a3) {
                        if (i5 == this.j) {
                            i2 = a3;
                        }
                        bVar.f1032b = a3;
                    }
                }
                z2 = true;
            }
            i3++;
        }
        if (z3) {
            this.i.a((ViewGroup) this);
        }
        Collections.sort(this.f, f1030b);
        if (z2) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                c cVar = (c) getChildAt(i6).getLayoutParams();
                if (!cVar.f1033a) {
                    cVar.c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    private static boolean c(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    private void c(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        int i2 = this.j;
        if (i2 <= 0) {
            return false;
        }
        a(i2 - 1, true);
        return true;
    }

    private void a(b bVar, int i2, b bVar2) {
        int i3;
        int i4;
        b bVar3;
        b bVar4;
        int a2 = this.i.a();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.q) / ((float) clientWidth) : 0.0f;
        if (bVar2 != null) {
            int i5 = bVar2.f1032b;
            int i6 = bVar.f1032b;
            if (i5 < i6) {
                float f3 = bVar2.e + bVar2.d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= bVar.f1032b && i8 < this.f.size()) {
                    Object obj = this.f.get(i8);
                    while (true) {
                        bVar4 = (b) obj;
                        if (i7 > bVar4.f1032b && i8 < this.f.size() - 1) {
                            i8++;
                            obj = this.f.get(i8);
                        }
                    }
                    while (i7 < bVar4.f1032b) {
                        f3 += this.i.a(i7) + f2;
                        i7++;
                    }
                    bVar4.e = f3;
                    f3 += bVar4.d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.f.size() - 1;
                float f4 = bVar2.e;
                while (true) {
                    i5--;
                    if (i5 < bVar.f1032b || size < 0) {
                        break;
                    }
                    Object obj2 = this.f.get(size);
                    while (true) {
                        bVar3 = (b) obj2;
                        if (i5 < bVar3.f1032b && size > 0) {
                            size--;
                            obj2 = this.f.get(size);
                        }
                    }
                    while (i5 > bVar3.f1032b) {
                        f4 -= this.i.a(i5) + f2;
                        i5--;
                    }
                    f4 -= bVar3.d + f2;
                    bVar3.e = f4;
                }
            }
        }
        int size2 = this.f.size();
        float f5 = bVar.e;
        int i9 = bVar.f1032b;
        int i10 = i9 - 1;
        this.u = i9 == 0 ? f5 : -3.4028235E38f;
        int i11 = a2 - 1;
        this.v = bVar.f1032b == i11 ? (bVar.e + bVar.d) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            b bVar5 = this.f.get(i12);
            while (true) {
                i4 = bVar5.f1032b;
                if (i10 <= i4) {
                    break;
                }
                f5 -= this.i.a(i10) + f2;
                i10--;
            }
            f5 -= bVar5.d + f2;
            bVar5.e = f5;
            if (i4 == 0) {
                this.u = f5;
            }
            i12--;
            i10--;
        }
        float f6 = bVar.e + bVar.d + f2;
        int i13 = bVar.f1032b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            b bVar6 = this.f.get(i14);
            while (true) {
                i3 = bVar6.f1032b;
                if (i13 >= i3) {
                    break;
                }
                f6 += this.i.a(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.v = (bVar6.d + f6) - 1.0f;
            }
            bVar6.e = f6;
            f6 += bVar6.d + f2;
            i14++;
            i13++;
        }
        this.V = false;
    }

    /* access modifiers changed from: package-private */
    public b a(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return b(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 <= 0 || this.f.isEmpty()) {
            b b2 = b(this.j);
            int min = (int) ((b2 != null ? Math.min(b2.e, this.v) : 0.0f) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
            }
        } else if (!this.n.isFinished()) {
            this.n.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.aa
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L_0x001d:
            if (r3 >= r6) goto L_0x006d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r9 = (androidx.viewpager.widget.ViewPager.c) r9
            boolean r10 = r9.f1033a
            if (r10 != 0) goto L_0x002e
            goto L_0x006a
        L_0x002e:
            int r9 = r9.f1034b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004f
            r10 = 3
            if (r9 == r10) goto L_0x0049
            r10 = 5
            if (r9 == r10) goto L_0x003c
            r9 = r4
            goto L_0x005e
        L_0x003c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L_0x005b
        L_0x0049:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L_0x005e
        L_0x004f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L_0x005b:
            r11 = r9
            r9 = r4
            r4 = r11
        L_0x005e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L_0x0069
            r8.offsetLeftAndRight(r4)
        L_0x0069:
            r4 = r9
        L_0x006a:
            int r3 = r3 + 1
            goto L_0x001d
        L_0x006d:
            r12.b(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$g r13 = r12.fa
            if (r13 == 0) goto L_0x00a1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007c:
            if (r1 >= r14) goto L_0x00a1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$c r0 = (androidx.viewpager.widget.ViewPager.c) r0
            boolean r0 = r0.f1033a
            if (r0 == 0) goto L_0x008d
            goto L_0x009e
        L_0x008d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$g r3 = r12.fa
            r3.a(r15, r0)
        L_0x009e:
            int r1 = r1 + 1
            goto L_0x007c
        L_0x00a1:
            r12.W = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.a(int, float, int):void");
    }

    private void a(boolean z2) {
        boolean z3 = this.ka == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            if (!this.n.isFinished()) {
                this.n.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.n.getCurrX();
                int currY = this.n.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        f(currX);
                    }
                }
            }
        }
        this.A = false;
        boolean z4 = z3;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            b bVar = this.f.get(i2);
            if (bVar.c) {
                bVar.c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z2) {
            y.a((View) this, this.ja);
        } else {
            this.ja.run();
        }
    }

    private boolean a(float f2, float f3) {
        return (f2 < ((float) this.F) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.F)) && f3 < 0.0f);
    }

    private int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.P || Math.abs(i3) <= this.N) {
            i2 += (int) (f2 + (i2 >= this.j ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f.size() <= 0) {
            return i2;
        }
        ArrayList<b> arrayList = this.f;
        return Math.max(this.f.get(0).f1032b, Math.min(i2, arrayList.get(arrayList.size() - 1).f1032b));
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.L) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.H = motionEvent.getX(i2);
            this.L = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.M;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, boolean z2, int i2, int i3, int i4) {
        int i5;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom()) {
                    if (a(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (!z2 || !view.canScrollHorizontally(-i2)) {
            return false;
        }
        return true;
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return a(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return a(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return d();
                } else {
                    return a(66);
                }
            } else if (keyEvent.hasModifiers(2)) {
                return c();
            } else {
                return a(17);
            }
        }
        return false;
    }

    public boolean a(int i2) {
        boolean requestFocus;
        boolean z2;
        View findFocus = findFocus();
        boolean z3 = false;
        View view = null;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z2 = false;
                        break;
                    } else if (parent == this) {
                        z2 = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i2);
        if (findNextFocus != null && findNextFocus != view) {
            if (i2 == 17) {
                int i3 = a(this.h, findNextFocus).left;
                int i4 = a(this.h, view).left;
                if (view == null || i3 < i4) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = c();
                }
            } else if (i2 == 66) {
                int i5 = a(this.h, findNextFocus).left;
                int i6 = a(this.h, view).left;
                if (view == null || i5 > i6) {
                    requestFocus = findNextFocus.requestFocus();
                } else {
                    requestFocus = d();
                }
            }
            z3 = requestFocus;
        } else if (i2 == 17 || i2 == 1) {
            z3 = c();
        } else if (i2 == 66 || i2 == 2) {
            z3 = d();
        }
        if (z3) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return z3;
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }
}
