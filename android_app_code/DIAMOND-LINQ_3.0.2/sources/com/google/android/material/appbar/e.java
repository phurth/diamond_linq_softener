package com.google.android.material.appbar;

import a.g.d.a;
import a.g.i.C0039c;
import a.g.i.I;
import a.g.i.y;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

abstract class e extends f<View> {
    final Rect d = new Rect();
    final Rect e = new Rect();
    private int f = 0;
    private int g;

    public e() {
    }

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public abstract View a(List<View> list);

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View a2;
        I lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (a2 = a(coordinatorLayout.b(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (y.j(a2) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.e() + lastWindowInsets.b();
        }
        int c = size + c(a2);
        int measuredHeight = a2.getMeasuredHeight();
        if (e()) {
            view.setTranslationY((float) (-measuredHeight));
        } else {
            c -= measuredHeight;
        }
        coordinatorLayout.a(view, i, i2, View.MeasureSpec.makeMeasureSpec(c, i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract float b(View view);

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a2 = a(coordinatorLayout.b(view));
        if (a2 != null) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
            Rect rect = this.d;
            rect.set(coordinatorLayout.getPaddingLeft() + eVar.leftMargin, a2.getBottom() + eVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin, ((coordinatorLayout.getHeight() + a2.getBottom()) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
            I lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && y.j(coordinatorLayout) && !y.j(view)) {
                rect.left += lastWindowInsets.c();
                rect.right -= lastWindowInsets.d();
            }
            Rect rect2 = this.e;
            C0039c.a(c(eVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int a3 = a(a2);
            view.layout(rect2.left, rect2.top - a3, rect2.right, rect2.bottom - a3);
            this.f = rect2.top - a2.getBottom();
            return;
        }
        super.b(coordinatorLayout, view, i);
        this.f = 0;
    }

    /* access modifiers changed from: package-private */
    public int c(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        return this.f;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return false;
    }

    public final int c() {
        return this.g;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public final int a(View view) {
        if (this.g == 0) {
            return 0;
        }
        float b2 = b(view);
        int i = this.g;
        return a.a((int) (b2 * ((float) i)), 0, i);
    }

    public final void b(int i) {
        this.g = i;
    }
}
