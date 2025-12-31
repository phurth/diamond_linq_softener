package com.google.android.material.internal;

import a.g.i.I;
import a.g.i.q;
import a.g.i.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import b.c.a.a.i;
import b.c.a.a.j;

public class n extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Drawable f1521a;

    /* renamed from: b  reason: collision with root package name */
    Rect f1522b;
    private Rect c;

    public n(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void a(I i) {
        throw null;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f1522b != null && this.f1521a != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.c.set(0, 0, width, this.f1522b.top);
            this.f1521a.setBounds(this.c);
            this.f1521a.draw(canvas);
            this.c.set(0, height - this.f1522b.bottom, width, height);
            this.f1521a.setBounds(this.c);
            this.f1521a.draw(canvas);
            Rect rect = this.c;
            Rect rect2 = this.f1522b;
            rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
            this.f1521a.setBounds(this.c);
            this.f1521a.draw(canvas);
            Rect rect3 = this.c;
            Rect rect4 = this.f1522b;
            rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
            this.f1521a.setBounds(this.c);
            this.f1521a.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f1521a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f1521a;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        TypedArray a2 = s.a(context, attributeSet, j.ScrimInsetsFrameLayout, i, i.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f1521a = a2.getDrawable(j.ScrimInsetsFrameLayout_insetForeground);
        a2.recycle();
        setWillNotDraw(true);
        y.a((View) this, (q) new m(this));
    }
}
