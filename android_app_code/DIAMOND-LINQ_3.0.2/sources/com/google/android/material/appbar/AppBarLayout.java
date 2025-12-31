package com.google.android.material.appbar;

import a.g.i.I;
import a.g.i.k;
import a.g.i.q;
import a.g.i.y;
import a.i.a.c;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.c.a.a.i;
import b.c.a.a.j;
import com.google.android.material.internal.s;
import java.lang.ref.WeakReference;
import java.util.List;

@CoordinatorLayout.c(Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f1431a;

    /* renamed from: b  reason: collision with root package name */
    private int f1432b;
    private int c;
    private boolean d;
    private int e;
    private I f;
    private List<a> g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private WeakReference<View> m;
    private int[] n;

    protected static class BaseBehavior<T extends AppBarLayout> extends d<T> {
        /* access modifiers changed from: private */
        public int k;
        private int l;
        private ValueAnimator m;
        private int n = -1;
        private boolean o;
        private float p;
        private WeakReference<View> q;
        private a r;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        public BaseBehavior() {
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        private void d(CoordinatorLayout coordinatorLayout, T t) {
            int c = c();
            int b2 = b(t, c);
            if (b2 >= 0) {
                View childAt = t.getChildAt(b2);
                b bVar = (b) childAt.getLayoutParams();
                int a2 = bVar.a();
                if ((a2 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (b2 == t.getChildCount() - 1) {
                        i2 += t.getTopInset();
                    }
                    if (a(a2, 2)) {
                        i2 += y.n(childAt);
                    } else if (a(a2, 5)) {
                        int n2 = y.n(childAt) + i2;
                        if (c < n2) {
                            i = n2;
                        } else {
                            i2 = n2;
                        }
                    }
                    if (a(a2, 32)) {
                        i += bVar.topMargin;
                        i2 -= bVar.bottomMargin;
                    }
                    if (c < (i2 + i) / 2) {
                        i = i2;
                    }
                    a(coordinatorLayout, t, a.g.d.a.a(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int c(T t) {
            return t.getTotalScrollRange();
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int c(T t, int i) {
            int abs = Math.abs(i);
            int childCount = t.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i3);
                b bVar = (b) childAt.getLayoutParams();
                Interpolator b2 = bVar.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (b2 != null) {
                    int a2 = bVar.a();
                    if ((a2 & 1) != 0) {
                        i2 = 0 + childAt.getHeight() + bVar.topMargin + bVar.bottomMargin;
                        if ((a2 & 2) != 0) {
                            i2 -= y.n(childAt);
                        }
                    }
                    if (y.j(childAt)) {
                        i2 -= t.getTopInset();
                    }
                    if (i2 > 0) {
                        float f = (float) i2;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * b2.getInterpolation(((float) (abs - childAt.getTop())) / f)));
                    }
                }
            }
            return i;
        }

        protected static class b extends c {
            public static final Parcelable.Creator<b> CREATOR = new c();

            /* renamed from: a  reason: collision with root package name */
            int f1433a;

            /* renamed from: b  reason: collision with root package name */
            float f1434b;
            boolean c;

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f1433a = parcel.readInt();
                this.f1434b = parcel.readFloat();
                this.c = parcel.readByte() != 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f1433a);
                parcel.writeFloat(this.f1434b);
                parcel.writeByte(this.c ? (byte) 1 : 0);
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }
        }

        private int b(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                b bVar = (b) childAt.getLayoutParams();
                if (a(bVar.a(), 32)) {
                    top -= bVar.topMargin;
                    bottom += bVar.bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (t.c() || a(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = i2;
            return z;
        }

        /* access modifiers changed from: package-private */
        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* renamed from: b */
        public Parcelable d(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable d = super.d(coordinatorLayout, t);
            int b2 = b();
            int childCount = t.getChildCount();
            boolean z = false;
            int i = 0;
            while (i < childCount) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    b bVar = new b(d);
                    bVar.f1433a = i;
                    if (bottom == y.n(childAt) + t.getTopInset()) {
                        z = true;
                    }
                    bVar.c = z;
                    bVar.f1434b = ((float) bottom) / ((float) childAt.getHeight());
                    return bVar;
                }
            }
            return d;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.b() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i6 = -t.getTotalScrollRange();
                    i5 = i6;
                    i4 = t.getDownNestedPreScrollRange() + i6;
                } else {
                    i5 = -t.getUpNestedPreScrollRange();
                    i4 = 0;
                }
                if (i5 != i4) {
                    iArr[1] = a(coordinatorLayout, t, i2, i5, i4);
                }
            }
            if (t.c()) {
                t.a(t.a(view));
            }
        }

        private boolean c(CoordinatorLayout coordinatorLayout, T t) {
            List<View> c = coordinatorLayout.c((View) t);
            int size = c.size();
            int i = 0;
            while (i < size) {
                CoordinatorLayout.b d = ((CoordinatorLayout.e) c.get(i).getLayoutParams()).d();
                if (!(d instanceof ScrollingViewBehavior)) {
                    i++;
                } else if (((ScrollingViewBehavior) d).c() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                iArr[1] = a(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.l == 0 || i == 1) {
                d(coordinatorLayout, t);
                if (t.c()) {
                    t.a(t.a(view));
                }
            }
            this.q = new WeakReference<>(view);
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return b() + this.k;
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int i2;
            int abs = Math.abs(c() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                i2 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i2 = (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, t, i, i2);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
            int c = c();
            if (c == i) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                this.m = new ValueAnimator();
                this.m.setInterpolator(b.c.a.a.a.a.e);
                this.m.addUpdateListener(new b(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration((long) Math.min(i2, 600));
            this.m.setIntValues(new int[]{c, i});
            this.m.start();
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((CoordinatorLayout.e) t.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, t, i, i2, i3, i4);
            }
            coordinatorLayout.a((View) t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i) {
            int i2;
            boolean a2 = super.a(coordinatorLayout, t, i);
            int pendingAction = t.getPendingAction();
            int i3 = this.n;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i3);
                int i4 = -childAt.getBottom();
                if (this.o) {
                    i2 = y.n(childAt) + t.getTopInset();
                } else {
                    i2 = Math.round(((float) childAt.getHeight()) * this.p);
                }
                c(coordinatorLayout, t, i4 + i2);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i5 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, t, i5, 0.0f);
                    } else {
                        c(coordinatorLayout, t, i5);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, t, 0, 0.0f);
                    } else {
                        c(coordinatorLayout, t, 0);
                    }
                }
            }
            t.d();
            this.n = -1;
            a(a.g.d.a.a(b(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, t, b(), 0, true);
            t.a(b());
            return a2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(T t) {
            a aVar = this.r;
            if (aVar != null) {
                return aVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void e(CoordinatorLayout coordinatorLayout, T t) {
            d(coordinatorLayout, t);
            if (t.c()) {
                t.a(t.a(a(coordinatorLayout)));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int b(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int c = c();
            int i4 = 0;
            if (i2 == 0 || c < i2 || c > i3) {
                this.k = 0;
            } else {
                int a2 = a.g.d.a.a(i, i2, i3);
                if (c != a2) {
                    int c2 = t.a() ? c(t, a2) : a2;
                    boolean a3 = a(c2);
                    i4 = c - a2;
                    this.k = a2 - c2;
                    if (!a3 && t.a()) {
                        coordinatorLayout.a((View) t);
                    }
                    t.a(b());
                    a(coordinatorLayout, t, a2, a2 < c ? -1 : 1, false);
                }
            }
            return i4;
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, boolean z) {
            View a2 = a((AppBarLayout) t, i);
            if (a2 != null) {
                int a3 = ((b) a2.getLayoutParams()).a();
                boolean z2 = false;
                if ((a3 & 1) != 0) {
                    int n2 = y.n(a2);
                    if (i2 <= 0 || (a3 & 12) == 0 ? !((a3 & 2) == 0 || (-i) < (a2.getBottom() - n2) - t.getTopInset()) : (-i) >= (a2.getBottom() - n2) - t.getTopInset()) {
                        z2 = true;
                    }
                }
                if (t.c()) {
                    z2 = t.a(a(coordinatorLayout));
                }
                boolean a4 = t.a(z2);
                if (Build.VERSION.SDK_INT < 11) {
                    return;
                }
                if (z || (a4 && c(coordinatorLayout, t))) {
                    t.jumpDrawablesToCurrentState();
                }
            }
        }

        private static View a(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof k) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof b) {
                b bVar = (b) parcelable;
                super.a(coordinatorLayout, t, bVar.a());
                this.n = bVar.f1433a;
                this.p = bVar.f1434b;
                this.o = bVar.c;
                return;
            }
            super.a(coordinatorLayout, t, parcelable);
            this.n = -1;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.a(coordinatorLayout, appBarLayout, i);
        }

        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.d(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.a(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super.a(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.b(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.a(coordinatorLayout, appBarLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }
    }

    public static class ScrollingViewBehavior extends e {
        public ScrollingViewBehavior() {
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        /* access modifiers changed from: package-private */
        public int c(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.c(view);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(j.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        /* access modifiers changed from: package-private */
        public float b(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + a2 > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) a2) / ((float) i)) + 1.0f;
                }
            }
            return 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout a2 = a((List) coordinatorLayout.b(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.c()) {
                    appBarLayout.a(appBarLayout.a(view));
                }
            }
        }

        private void a(View view, View view2) {
            CoordinatorLayout.b d = ((CoordinatorLayout.e) view2.getLayoutParams()).d();
            if (d instanceof BaseBehavior) {
                y.c(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) d).k) + d()) - a(view2));
            }
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.b d = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).d();
            if (d instanceof BaseBehavior) {
                return ((BaseBehavior) d).c();
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    public AppBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void e() {
        WeakReference<View> weakReference = this.m;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.m = null;
    }

    private View f() {
        View view;
        if (this.m == null && this.l != -1) {
            Activity a2 = com.google.android.material.internal.b.a(getContext());
            if (a2 != null) {
                view = a2.findViewById(this.l);
            } else {
                view = getParent() instanceof ViewGroup ? ((ViewGroup) getParent()).findViewById(this.l) : null;
            }
            if (view != null) {
                this.m = new WeakReference<>(view);
            }
        }
        WeakReference<View> weakReference = this.m;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private boolean g() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((b) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void h() {
        this.f1431a = -1;
        this.f1432b = -1;
        this.c = -1;
    }

    private boolean i() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || y.j(childAt)) {
            return false;
        }
        return true;
    }

    public void a(boolean z, boolean z2) {
        a(z, z2, true);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return getTotalScrollRange() != 0;
    }

    public boolean c() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.e = 0;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i2;
        int n2;
        int i3 = this.f1432b;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f1435a;
            if ((i5 & 5) == 5) {
                int i6 = bVar.topMargin + bVar.bottomMargin;
                if ((i5 & 8) != 0) {
                    n2 = y.n(childAt);
                } else if ((i5 & 2) != 0) {
                    n2 = measuredHeight - y.n(childAt);
                } else {
                    i2 = i6 + measuredHeight;
                    if (childCount == 0 && y.j(childAt)) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                    i4 += i2;
                }
                i2 = i6 + n2;
                i2 = Math.min(i2, measuredHeight - getTopInset());
                i4 += i2;
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f1432b = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i2 = this.c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin;
            int i5 = bVar.f1435a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= y.n(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.c = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.l;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int n2 = y.n(this);
        if (n2 == 0) {
            int childCount = getChildCount();
            n2 = childCount >= 1 ? y.n(getChildAt(childCount - 1)) : 0;
            if (n2 == 0) {
                return getHeight() / 3;
            }
        }
        return (n2 * 2) + topInset;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        I i2 = this.f;
        if (i2 != null) {
            return i2.e();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f1431a;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = bVar.f1435a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + bVar.topMargin + bVar.bottomMargin;
            if (i3 == 0 && y.j(childAt)) {
                i4 -= getTopInset();
            }
            if ((i5 & 2) != 0) {
                i4 -= y.n(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f1431a = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.n == null) {
            this.n = new int[4];
        }
        int[] iArr = this.n;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.i ? b.c.a.a.b.state_liftable : -b.c.a.a.b.state_liftable;
        iArr[1] = (!this.i || !this.j) ? -b.c.a.a.b.state_lifted : b.c.a.a.b.state_lifted;
        iArr[2] = this.i ? b.c.a.a.b.state_collapsible : -b.c.a.a.b.state_collapsible;
        iArr[3] = (!this.i || !this.j) ? -b.c.a.a.b.state_collapsed : b.c.a.a.b.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (y.j(this) && i()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                y.c(getChildAt(childCount), topInset);
            }
        }
        h();
        boolean z2 = false;
        this.d = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            } else if (((b) getChildAt(i6).getLayoutParams()).b() != null) {
                this.d = true;
                break;
            } else {
                i6++;
            }
        }
        if (!this.h) {
            if (this.k || g()) {
                z2 = true;
            }
            b(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && y.j(this) && i()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = a.g.d.a.a(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        h();
    }

    public void setExpanded(boolean z) {
        a(z, y.A(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.k = z;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.l = i2;
        e();
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.a(this, f2);
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z3) {
            i2 = 8;
        }
        this.e = i3 | i2;
        requestLayout();
    }

    private boolean b(boolean z) {
        if (this.i == z) {
            return false;
        }
        this.i = z;
        refreshDrawableState();
        return true;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1431a = -1;
        this.f1432b = -1;
        this.c = -1;
        this.e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            h.a(this);
            h.a(this, attributeSet, i2, i.Widget_Design_AppBarLayout);
        }
        TypedArray a2 = s.a(context, attributeSet, j.AppBarLayout, i2, i.Widget_Design_AppBarLayout, new int[0]);
        y.a((View) this, a2.getDrawable(j.AppBarLayout_android_background));
        if (a2.hasValue(j.AppBarLayout_expanded)) {
            a(a2.getBoolean(j.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && a2.hasValue(j.AppBarLayout_elevation)) {
            h.a(this, (float) a2.getDimensionPixelSize(j.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (a2.hasValue(j.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(a2.getBoolean(j.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (a2.hasValue(j.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(a2.getBoolean(j.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.k = a2.getBoolean(j.AppBarLayout_liftOnScroll, false);
        this.l = a2.getResourceId(j.AppBarLayout_liftOnScrollTargetViewId, -1);
        a2.recycle();
        y.a((View) this, (q) new a(this));
    }

    /* access modifiers changed from: protected */
    public b generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        List<a> list = this.g;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.g.get(i3);
                if (aVar != null) {
                    aVar.a(this, i2);
                }
            }
        }
    }

    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new b((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    public static class b extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f1435a = 1;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f1436b;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.AppBarLayout_Layout);
            this.f1435a = obtainStyledAttributes.getInt(j.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(j.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f1436b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(j.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f1435a;
        }

        public Interpolator b() {
            return this.f1436b;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            int i = this.f1435a;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z) {
        if (this.j == z) {
            return false;
        }
        this.j = z;
        refreshDrawableState();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view) {
        View f2 = f();
        if (f2 != null) {
            view = f2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    /* access modifiers changed from: package-private */
    public I a(I i2) {
        I i3 = y.j(this) ? i2 : null;
        if (!a.g.h.c.a(this.f, i3)) {
            this.f = i3;
            requestLayout();
        }
        return i2;
    }
}
