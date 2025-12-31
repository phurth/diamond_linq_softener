package me.relex.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    protected int f1563a = -1;

    /* renamed from: b  reason: collision with root package name */
    protected int f1564b = -1;
    protected int c = -1;
    protected int d;
    protected int e;
    protected Animator f;
    protected Animator g;
    protected Animator h;
    protected Animator i;
    protected int j = -1;

    /* renamed from: me.relex.circleindicator.a$a  reason: collision with other inner class name */
    protected class C0036a implements Interpolator {
        protected C0036a() {
        }

        public float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    public a(Context context) {
        super(context);
        b(context, (AttributeSet) null);
    }

    private d a(Context context, AttributeSet attributeSet) {
        d dVar = new d();
        if (attributeSet == null) {
            return dVar;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.BaseCircleIndicator);
        dVar.f1568a = obtainStyledAttributes.getDimensionPixelSize(g.BaseCircleIndicator_ci_width, -1);
        dVar.f1569b = obtainStyledAttributes.getDimensionPixelSize(g.BaseCircleIndicator_ci_height, -1);
        dVar.c = obtainStyledAttributes.getDimensionPixelSize(g.BaseCircleIndicator_ci_margin, -1);
        dVar.d = obtainStyledAttributes.getResourceId(g.BaseCircleIndicator_ci_animator, e.scale_with_alpha);
        dVar.e = obtainStyledAttributes.getResourceId(g.BaseCircleIndicator_ci_animator_reverse, 0);
        dVar.f = obtainStyledAttributes.getResourceId(g.BaseCircleIndicator_ci_drawable, f.white_radius);
        dVar.g = obtainStyledAttributes.getResourceId(g.BaseCircleIndicator_ci_drawable_unselected, dVar.f);
        dVar.h = obtainStyledAttributes.getInt(g.BaseCircleIndicator_ci_orientation, -1);
        dVar.i = obtainStyledAttributes.getInt(g.BaseCircleIndicator_ci_gravity, -1);
        obtainStyledAttributes.recycle();
        return dVar;
    }

    private void b(Context context, AttributeSet attributeSet) {
        c(a(context, attributeSet));
    }

    public void c(d dVar) {
        int i2 = 1;
        int applyDimension = (int) (TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()) + 0.5f);
        int i3 = dVar.f1568a;
        if (i3 < 0) {
            i3 = applyDimension;
        }
        this.f1564b = i3;
        int i4 = dVar.f1569b;
        if (i4 < 0) {
            i4 = applyDimension;
        }
        this.c = i4;
        int i5 = dVar.c;
        if (i5 >= 0) {
            applyDimension = i5;
        }
        this.f1563a = applyDimension;
        this.f = b(dVar);
        this.h = b(dVar);
        this.h.setDuration(0);
        this.g = a(dVar);
        this.i = a(dVar);
        this.i.setDuration(0);
        int i6 = dVar.f;
        if (i6 == 0) {
            i6 = f.white_radius;
        }
        this.d = i6;
        int i7 = dVar.g;
        if (i7 == 0) {
            i7 = dVar.f;
        }
        this.e = i7;
        if (dVar.h != 1) {
            i2 = 0;
        }
        setOrientation(i2);
        int i8 = dVar.i;
        if (i8 < 0) {
            i8 = 17;
        }
        setGravity(i8);
    }

    /* access modifiers changed from: protected */
    public Animator b(d dVar) {
        return AnimatorInflater.loadAnimator(getContext(), dVar.d);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context, attributeSet);
    }

    @TargetApi(21)
    public a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        b(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public Animator a(d dVar) {
        if (dVar.e != 0) {
            return AnimatorInflater.loadAnimator(getContext(), dVar.e);
        }
        Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), dVar.d);
        loadAnimator.setInterpolator(new C0036a());
        return loadAnimator;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) {
        int orientation = getOrientation();
        for (int i4 = 0; i4 < i2; i4++) {
            if (i3 == i4) {
                a(orientation, this.d, this.h);
            } else {
                a(orientation, this.e, this.i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i3);
        addView(view, this.f1564b, this.c);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i2 == 0) {
            int i4 = this.f1563a;
            layoutParams.leftMargin = i4;
            layoutParams.rightMargin = i4;
        } else {
            int i5 = this.f1563a;
            layoutParams.topMargin = i5;
            layoutParams.bottomMargin = i5;
        }
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        View childAt;
        if (this.g.isRunning()) {
            this.g.end();
            this.g.cancel();
        }
        if (this.f.isRunning()) {
            this.f.end();
            this.f.cancel();
        }
        int i3 = this.j;
        if (i3 >= 0 && (childAt = getChildAt(i3)) != null) {
            childAt.setBackgroundResource(this.e);
            this.g.setTarget(childAt);
            this.g.start();
        }
        View childAt2 = getChildAt(i2);
        if (childAt2 != null) {
            childAt2.setBackgroundResource(this.d);
            this.f.setTarget(childAt2);
            this.f.start();
        }
    }
}
