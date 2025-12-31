package com.google.android.material.floatingactionbutton;

import a.g.h.g;
import a.g.i.y;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.c.a.a.a.b;
import b.c.a.a.a.h;
import b.c.a.a.j;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExtendedFloatingActionButton extends b.c.a.a.b.a implements CoordinatorLayout.a {
    private static final Property<View, Float> r = new e(Float.class, "width");
    private static final Property<View, Float> s = new f(Float.class, "height");
    private static final Property<View, Float> t = new g(Float.class, "cornerRadius");
    private h A;
    private h B;
    private h C;
    private h D;
    private h E;
    private h F;
    private final CoordinatorLayout.b<ExtendedFloatingActionButton> G;
    private int H;
    private ArrayList<Animator.AnimatorListener> I;
    private ArrayList<Animator.AnimatorListener> J;
    private ArrayList<Animator.AnimatorListener> K;
    private ArrayList<Animator.AnimatorListener> L;
    private boolean M;
    /* access modifiers changed from: private */
    public final Rect u;
    /* access modifiers changed from: private */
    public int v;
    /* access modifiers changed from: private */
    public Animator w;
    /* access modifiers changed from: private */
    public Animator x;
    private h y;
    private h z;

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.b<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f1483a;

        /* renamed from: b  reason: collision with root package name */
        private a f1484b;
        private a c;
        private boolean d;
        private boolean e;

        public ExtendedFloatingActionButtonBehavior() {
            this.d = false;
            this.e = true;
        }

        private boolean b(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((CoordinatorLayout.e) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                b(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        public void a(CoordinatorLayout.e eVar) {
            if (eVar.h == 0) {
                eVar.h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ExtendedFloatingActionButton_Behavior_Layout);
            this.d = obtainStyledAttributes.getBoolean(j.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.e = obtainStyledAttributes.getBoolean(j.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (!a(view)) {
                return false;
            } else {
                b(view, extendedFloatingActionButton);
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (this.e) {
                extendedFloatingActionButton.b(this.c);
            } else if (this.d) {
                extendedFloatingActionButton.a(false, true, this.f1484b);
            }
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) extendedFloatingActionButton.getLayoutParams();
            if ((this.d || this.e) && eVar.c() == view.getId() && extendedFloatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a((View) appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f1483a == null) {
                this.f1483a = new Rect();
            }
            Rect rect = this.f1483a;
            c.a((ViewGroup) coordinatorLayout, (View) appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                b(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        /* access modifiers changed from: protected */
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (this.e) {
                extendedFloatingActionButton.a(this.c);
            } else if (this.d) {
                extendedFloatingActionButton.c(false, true, this.f1484b);
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List<View> b2 = coordinatorLayout.b((View) extendedFloatingActionButton);
            int size = b2.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = b2.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.c((View) extendedFloatingActionButton, i);
            a(coordinatorLayout, extendedFloatingActionButton);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            Rect a2 = extendedFloatingActionButton.u;
            rect.set(extendedFloatingActionButton.getLeft() + a2.left, extendedFloatingActionButton.getTop() + a2.top, extendedFloatingActionButton.getRight() - a2.right, extendedFloatingActionButton.getBottom() - a2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i;
            Rect a2 = extendedFloatingActionButton.u;
            if (a2 != null && a2.centerX() > 0 && a2.centerY() > 0) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) extendedFloatingActionButton.getLayoutParams();
                int i2 = 0;
                if (extendedFloatingActionButton.getRight() >= coordinatorLayout.getWidth() - eVar.rightMargin) {
                    i = a2.right;
                } else {
                    i = extendedFloatingActionButton.getLeft() <= eVar.leftMargin ? -a2.left : 0;
                }
                if (extendedFloatingActionButton.getBottom() >= coordinatorLayout.getHeight() - eVar.bottomMargin) {
                    i2 = a2.bottom;
                } else if (extendedFloatingActionButton.getTop() <= eVar.topMargin) {
                    i2 = -a2.top;
                }
                if (i2 != 0) {
                    y.c(extendedFloatingActionButton, i2);
                }
                if (i != 0) {
                    y.b((View) extendedFloatingActionButton, i);
                }
            }
        }
    }

    public static abstract class a {
        public abstract void a(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void b(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void c(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void d(ExtendedFloatingActionButton extendedFloatingActionButton);
    }

    /* access modifiers changed from: private */
    public void c(boolean z2, boolean z3, a aVar) {
        if (!h()) {
            Animator animator = this.w;
            if (animator != null) {
                animator.cancel();
            }
            if (!z3 || !i()) {
                a(0, z2);
                setAlpha(1.0f);
                setScaleY(1.0f);
                setScaleX(1.0f);
                if (aVar != null) {
                    aVar.c(this);
                    return;
                }
                return;
            }
            AnimatorSet a2 = a(getCurrentShowMotionSpec());
            a2.addListener(new c(this, z2, aVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.I;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
        }
    }

    private void f() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            measure(0, 0);
            layoutParams.width = getMeasuredWidth();
            layoutParams.height = getMeasuredHeight();
            requestLayout();
        }
    }

    private boolean g() {
        if (getVisibility() == 0) {
            if (this.v == 1) {
                return true;
            }
            return false;
        } else if (this.v != 2) {
            return true;
        } else {
            return false;
        }
    }

    private h getCurrentExtendMotionSpec() {
        h hVar = this.A;
        if (hVar != null) {
            return hVar;
        }
        if (this.E == null) {
            this.E = h.a(getContext(), b.c.a.a.a.mtrl_extended_fab_extend_motion_spec);
        }
        h hVar2 = this.E;
        g.a(hVar2);
        return hVar2;
    }

    private h getCurrentHideMotionSpec() {
        h hVar = this.z;
        if (hVar != null) {
            return hVar;
        }
        if (this.D == null) {
            this.D = h.a(getContext(), b.c.a.a.a.mtrl_extended_fab_hide_motion_spec);
        }
        h hVar2 = this.D;
        g.a(hVar2);
        return hVar2;
    }

    private h getCurrentShowMotionSpec() {
        h hVar = this.y;
        if (hVar != null) {
            return hVar;
        }
        if (this.C == null) {
            this.C = h.a(getContext(), b.c.a.a.a.mtrl_extended_fab_show_motion_spec);
        }
        h hVar2 = this.C;
        g.a(hVar2);
        return hVar2;
    }

    private h getCurrentShrinkMotionSpec() {
        h hVar = this.B;
        if (hVar != null) {
            return hVar;
        }
        if (this.F == null) {
            this.F = h.a(getContext(), b.c.a.a.a.mtrl_extended_fab_shrink_motion_spec);
        }
        h hVar2 = this.F;
        g.a(hVar2);
        return hVar2;
    }

    private boolean h() {
        if (getVisibility() != 0) {
            if (this.v == 2) {
                return true;
            }
            return false;
        } else if (this.v != 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean i() {
        return y.A(this) && !isInEditMode();
    }

    private void j() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            int q = (y.q(this) * 2) + getIconSize();
            layoutParams.width = q;
            layoutParams.height = q;
            requestLayout();
        }
    }

    public CoordinatorLayout.b<ExtendedFloatingActionButton> getBehavior() {
        return this.G;
    }

    public h getExtendMotionSpec() {
        return this.A;
    }

    public h getHideMotionSpec() {
        return this.z;
    }

    public h getShowMotionSpec() {
        return this.y;
    }

    public h getShrinkMotionSpec() {
        return this.B;
    }

    public final int getUserSetVisibility() {
        return this.H;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.M && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.M = false;
            j();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setCornerRadius(a(getMeasuredHeight()));
    }

    public void setExtendMotionSpec(h hVar) {
        this.A = hVar;
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(h.a(getContext(), i));
    }

    public void setHideMotionSpec(h hVar) {
        this.z = hVar;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(h.a(getContext(), i));
    }

    public void setShowMotionSpec(h hVar) {
        this.y = hVar;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(h.a(getContext(), i));
    }

    public void setShrinkMotionSpec(h hVar) {
        this.B = hVar;
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(h.a(getContext(), i));
    }

    public void setVisibility(int i) {
        a(i, true);
    }

    public void b(a aVar) {
        b(false, true, aVar);
    }

    private void b(boolean z2, boolean z3, a aVar) {
        if (z2 != this.M && getIcon() != null && !TextUtils.isEmpty(getText())) {
            this.M = z2;
            Animator animator = this.x;
            if (animator != null) {
                animator.cancel();
            }
            if (z3 && i()) {
                measure(0, 0);
                AnimatorSet a2 = a(this.M ? getCurrentExtendMotionSpec() : getCurrentShrinkMotionSpec(), !this.M);
                a2.addListener(new d(this, aVar, z2));
                ArrayList<Animator.AnimatorListener> arrayList = z2 ? this.L : this.K;
                if (arrayList != null) {
                    Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                    while (it.hasNext()) {
                        a2.addListener(it.next());
                    }
                }
                a2.start();
            } else if (z2) {
                f();
                if (aVar != null) {
                    aVar.a(this);
                }
            } else {
                j();
                if (aVar != null) {
                    aVar.d(this);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i, boolean z2) {
        super.setVisibility(i);
        if (z2) {
            this.H = i;
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, boolean z3, a aVar) {
        if (!g()) {
            Animator animator = this.w;
            if (animator != null) {
                animator.cancel();
            }
            if (!z3 || !i()) {
                a(z2 ? 8 : 4, z2);
                if (aVar != null) {
                    aVar.b(this);
                    return;
                }
                return;
            }
            AnimatorSet a2 = a(getCurrentHideMotionSpec());
            a2.addListener(new b(this, z2, aVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.J;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
        }
    }

    public void a(a aVar) {
        b(true, true, aVar);
    }

    private AnimatorSet a(h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.c("opacity")) {
            arrayList.add(hVar.a("opacity", (View) this, (Property<View, Float>) View.ALPHA));
        }
        if (hVar.c("scale")) {
            arrayList.add(hVar.a("scale", (View) this, (Property<View, Float>) View.SCALE_Y));
            arrayList.add(hVar.a("scale", (View) this, (Property<View, Float>) View.SCALE_X));
        }
        if (hVar.c("width")) {
            arrayList.add(hVar.a("width", (View) this, r));
        }
        if (hVar.c("height")) {
            arrayList.add(hVar.a("height", (View) this, s));
        }
        if (hVar.c("cornerRadius")) {
            arrayList.add(hVar.a("cornerRadius", (View) this, t));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet a(h hVar, boolean z2) {
        int q = (y.q(this) * 2) + getIconSize();
        if (hVar.c("width")) {
            PropertyValuesHolder[] a2 = hVar.a("width");
            if (z2) {
                a2[0].setFloatValues(new float[]{(float) getMeasuredWidth(), (float) q});
            } else {
                a2[0].setFloatValues(new float[]{(float) getWidth(), (float) getMeasuredWidth()});
            }
            hVar.a("width", a2);
        }
        if (hVar.c("height")) {
            PropertyValuesHolder[] a3 = hVar.a("height");
            if (z2) {
                a3[0].setFloatValues(new float[]{(float) getMeasuredHeight(), (float) q});
            } else {
                a3[0].setFloatValues(new float[]{(float) getHeight(), (float) getMeasuredHeight()});
            }
            hVar.a("height", a3);
        }
        if (hVar.c("cornerRadius")) {
            PropertyValuesHolder[] a4 = hVar.a("cornerRadius");
            if (z2) {
                a4[0].setFloatValues(new float[]{(float) getCornerRadius(), (float) a(q)});
            } else {
                a4[0].setFloatValues(new float[]{(float) getCornerRadius(), (float) a(getHeight())});
            }
            hVar.a("cornerRadius", a4);
        }
        return a(hVar);
    }

    private int a(int i) {
        return (i - 1) / 2;
    }
}
