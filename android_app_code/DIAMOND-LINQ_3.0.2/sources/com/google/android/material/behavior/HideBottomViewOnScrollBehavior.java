package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.c.a.a.a.a;

public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f1447a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1448b = 2;
    /* access modifiers changed from: private */
    public ViewPropertyAnimator c;

    public HideBottomViewOnScrollBehavior() {
    }

    public void b(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f1448b = 2;
        a(v, 0, 225, a.d);
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f1447a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.a(coordinatorLayout, v, i);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (this.f1448b != 1 && i2 > 0) {
            a(v);
        } else if (this.f1448b != 2 && i2 < 0) {
            b(v);
        }
    }

    public void a(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f1448b = 1;
        a(v, this.f1447a, 175, a.c);
    }

    private void a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.c = v.animate().translationY((float) i).setInterpolator(timeInterpolator).setDuration(j).setListener(new a(this));
    }
}
