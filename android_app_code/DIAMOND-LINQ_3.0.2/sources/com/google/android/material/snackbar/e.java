package com.google.android.material.snackbar;

import a.g.i.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import b.c.a.a.j;
import com.google.android.material.internal.s;

public class e extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final View.OnTouchListener f1539a = new d();

    /* renamed from: b  reason: collision with root package name */
    private c f1540b;
    private b c;
    private int d;
    private final float e;
    private final float f;

    protected e(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: package-private */
    public float getActionTextColorAlpha() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public int getAnimationMode() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public float getBackgroundOverlayColorAlpha() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.c;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        y.F(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.c;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c cVar = this.f1540b;
        if (cVar != null) {
            cVar.a(this, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimationMode(int i) {
        this.d = i;
    }

    /* access modifiers changed from: package-private */
    public void setOnAttachStateChangeListener(b bVar) {
        this.c = bVar;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f1539a);
        super.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setOnLayoutChangeListener(c cVar) {
        this.f1540b = cVar;
    }

    protected e(Context context, AttributeSet attributeSet) {
        super(s.a(context, attributeSet, 0, 0), attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(j.SnackbarLayout_elevation)) {
            y.a((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(j.SnackbarLayout_elevation, 0));
        }
        this.d = obtainStyledAttributes.getInt(j.SnackbarLayout_animationMode, 0);
        this.e = obtainStyledAttributes.getFloat(j.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        this.f = obtainStyledAttributes.getFloat(j.SnackbarLayout_actionTextColorAlpha, 1.0f);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f1539a);
        setFocusable(true);
    }
}
