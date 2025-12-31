package com.google.android.material.chip;

import a.g.i.C0037a;
import a.g.i.a.c;
import a.g.i.y;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.C0109m;
import b.c.a.a.b;
import b.c.a.a.h;
import b.c.a.a.i;
import b.c.a.a.j;
import b.c.a.a.m.e;
import b.c.a.a.m.g;
import b.c.a.a.p.l;
import com.google.android.material.chip.c;
import com.google.android.material.internal.s;
import com.google.android.material.internal.t;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public class Chip extends C0109m implements c.a, l {
    /* access modifiers changed from: private */
    public static final Rect d = new Rect();
    private static final int[] e = {16842913};
    /* access modifiers changed from: private */
    public c f;
    private InsetDrawable g;
    private RippleDrawable h;
    private View.OnClickListener i;
    private CompoundButton.OnCheckedChangeListener j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private final a s;
    private final Rect t;
    private final RectF u;
    private final g v;

    private class a extends a.i.b.c {
        a(Chip chip) {
            super(chip);
        }

        /* access modifiers changed from: protected */
        public int a(float f, float f2) {
            return (!Chip.this.j() || !Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? -1 : 0;
        }

        /* access modifiers changed from: protected */
        public void a(List<Integer> list) {
            if (Chip.this.j()) {
                list.add(0);
            }
        }

        /* access modifiers changed from: protected */
        public void a(int i, a.g.i.a.c cVar) {
            if (Chip.this.j()) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    cVar.c(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = h.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (TextUtils.isEmpty(text)) {
                        text = BuildConfig.FLAVOR;
                    }
                    objArr[0] = text;
                    cVar.c((CharSequence) context.getString(i2, objArr).trim());
                }
                cVar.c(Chip.this.getCloseIconTouchBoundsInt());
                cVar.a(c.a.e);
                cVar.e(Chip.this.isEnabled());
                return;
            }
            cVar.c((CharSequence) BuildConfig.FLAVOR);
            cVar.c(Chip.d);
        }

        /* access modifiers changed from: protected */
        public void a(a.g.i.a.c cVar) {
            cVar.b(Chip.this.c());
            cVar.d(Chip.this.isClickable());
            cVar.b((CharSequence) Chip.class.getName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.f(text);
            } else {
                cVar.c(text);
            }
        }

        /* access modifiers changed from: protected */
        public boolean a(int i, int i2, Bundle bundle) {
            if (i2 == 16 && i == 0) {
                return Chip.this.e();
            }
            return false;
        }
    }

    public Chip(Context context) {
        this(context, (AttributeSet) null);
    }

    private int[] g() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.o) {
            i3++;
        }
        if (this.n) {
            i3++;
        }
        if (this.m) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.o) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.n) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.m) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    /* access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.u.setEmpty();
        if (j()) {
            this.f.a(this.u);
        }
        return this.u;
    }

    /* access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.t.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.t;
    }

    private e getTextAppearance() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.H();
        }
        return null;
    }

    private void h() {
        if (getBackgroundDrawable() == this.g && this.f.getCallback() == null) {
            this.f.setCallback(this.g);
        }
    }

    private void i() {
        if (this.l == Integer.MIN_VALUE) {
            setFocusedVirtualView(-1);
        }
    }

    /* access modifiers changed from: private */
    public boolean j() {
        c cVar = this.f;
        return (cVar == null || cVar.t() == null) ? false : true;
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b(this));
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT < 24) {
            if (!j() || !d()) {
                y.a((View) this, (C0037a) null);
            } else {
                y.a((View) this, (C0037a) this.s);
            }
        }
    }

    private void m() {
        if (b.c.a.a.n.a.f1316a) {
            n();
            return;
        }
        this.f.f(true);
        y.a((View) this, getBackgroundDrawable());
        h();
    }

    private void n() {
        this.h = new RippleDrawable(b.c.a.a.n.a.a(this.f.E()), getBackgroundDrawable(), (Drawable) null);
        this.f.f(false);
        y.a((View) this, (Drawable) this.h);
    }

    private void o() {
        c cVar;
        if (!TextUtils.isEmpty(getText()) && (cVar = this.f) != null) {
            y.a(this, (int) (this.f.q() + this.f.J() + this.f.g()), getPaddingTop(), (int) (cVar.l() + this.f.I() + this.f.h()), getPaddingBottom());
        }
    }

    private void p() {
        TextPaint paint = getPaint();
        c cVar = this.f;
        if (cVar != null) {
            paint.drawableState = cVar.getState();
        }
        e textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.b(getContext(), paint, this.v);
        }
    }

    private void setCloseIconFocused(boolean z) {
        if (this.o != z) {
            this.o = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.n != z) {
            this.n = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.m != z) {
            this.m = z;
            refreshDrawableState();
        }
    }

    private void setFocusedVirtualView(int i2) {
        int i3 = this.l;
        if (i3 != i2) {
            if (i3 == 0) {
                setCloseIconFocused(false);
            }
            this.l = i2;
            if (i2 == 0) {
                setCloseIconFocused(true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return a(motionEvent) || this.s.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.s.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c cVar = this.f;
        if ((cVar == null || !cVar.M()) ? false : this.f.a(g())) {
            invalidate();
        }
    }

    public boolean e() {
        boolean z;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.i;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        } else {
            z = false;
        }
        this.s.a(0, 1);
        return z;
    }

    public boolean f() {
        return this.p;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.g;
        return insetDrawable == null ? this.f : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.i();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.j();
        }
        return null;
    }

    public float getChipCornerRadius() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.k();
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f;
    }

    public float getChipEndPadding() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.l();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.m();
        }
        return null;
    }

    public float getChipIconSize() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.n();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.o();
        }
        return null;
    }

    public float getChipMinHeight() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.p();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.q();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.r();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.s();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.t();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.u();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.v();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.w();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.x();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.z();
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.A();
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        if (this.l == 0) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public b.c.a.a.a.h getHideMotionSpec() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.B();
        }
        return null;
    }

    public float getIconEndPadding() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.C();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.D();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.E();
        }
        return null;
    }

    public b.c.a.a.p.h getShapeAppearanceModel() {
        return this.f.e();
    }

    public b.c.a.a.a.h getShowMotionSpec() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.F();
        }
        return null;
    }

    public float getTextEndPadding() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.I();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        c cVar = this.f;
        if (cVar != null) {
            return cVar.J();
        }
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, e);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (z) {
            setFocusedVirtualView(-1);
        } else {
            setFocusedVirtualView(Integer.MIN_VALUE);
        }
        invalidate();
        super.onFocusChanged(z, i2, rect);
        this.s.a(z, i2, rect);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Chip.class.getName());
        accessibilityNodeInfo.setCheckable(c());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
            r6 = this;
            int r0 = r8.getKeyCode()
            r1 = 61
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0041
            r1 = 66
            if (r0 == r1) goto L_0x0031
            switch(r0) {
                case 21: goto L_0x0022;
                case 22: goto L_0x0012;
                case 23: goto L_0x0031;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x006d
        L_0x0012:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006d
            boolean r0 = com.google.android.material.internal.t.a(r6)
            r0 = r0 ^ r3
            boolean r2 = r6.a((boolean) r0)
            goto L_0x006d
        L_0x0022:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x006d
            boolean r0 = com.google.android.material.internal.t.a(r6)
            boolean r2 = r6.a((boolean) r0)
            goto L_0x006d
        L_0x0031:
            int r0 = r6.l
            r1 = -1
            if (r0 == r1) goto L_0x003d
            if (r0 == 0) goto L_0x0039
            goto L_0x006d
        L_0x0039:
            r6.e()
            return r3
        L_0x003d:
            r6.performClick()
            return r3
        L_0x0041:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L_0x0049
            r0 = 2
            goto L_0x0052
        L_0x0049:
            boolean r0 = r8.hasModifiers(r3)
            if (r0 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            if (r0 == 0) goto L_0x006d
            android.view.ViewParent r1 = r6.getParent()
            r4 = r6
        L_0x0059:
            android.view.View r4 = r4.focusSearch(r0)
            if (r4 == 0) goto L_0x0067
            if (r4 == r6) goto L_0x0067
            android.view.ViewParent r5 = r4.getParent()
            if (r5 == r1) goto L_0x0059
        L_0x0067:
            if (r4 == 0) goto L_0x006d
            r4.requestFocus()
            return r3
        L_0x006d:
            if (r2 == 0) goto L_0x0073
            r6.invalidate()
            return r3
        L_0x0073:
            boolean r7 = super.onKeyDown(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.q != i2) {
            this.q = i2;
            o();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 == r3) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0034
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.m
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x003e
            r5.setCloseIconPressed(r2)
            goto L_0x003e
        L_0x002b:
            boolean r0 = r5.m
            if (r0 == 0) goto L_0x0034
            r5.e()
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r5.setCloseIconPressed(r2)
            goto L_0x0041
        L_0x0039:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r3)
        L_0x003e:
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r0 != 0) goto L_0x0049
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
        L_0x0049:
            r2 = 1
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.h) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundColor(int i2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.h) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundResource(int i2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(z);
        }
    }

    public void setCheckableResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.b(i2);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        c cVar = this.f;
        if (cVar == null) {
            this.k = z;
        } else if (cVar.L()) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.j) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.c(i2);
        }
    }

    public void setCheckedIconVisible(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.d(i2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.e(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.d(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.f(i2);
        }
    }

    public void setChipDrawable(c cVar) {
        c cVar2 = this.f;
        if (cVar2 != cVar) {
            b(cVar2);
            this.f = cVar;
            a(this.f);
            a(this.r);
            m();
        }
    }

    public void setChipEndPadding(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.e(f2);
        }
    }

    public void setChipEndPaddingResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.g(i2);
        }
    }

    public void setChipIcon(Drawable drawable) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.b(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.h(i2);
        }
    }

    public void setChipIconSize(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.f(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.i(i2);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.d(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.j(i2);
        }
    }

    public void setChipIconVisible(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.k(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.g(f2);
        }
    }

    public void setChipMinHeightResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.l(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.h(f2);
        }
    }

    public void setChipStartPaddingResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.m(i2);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.e(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.n(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.i(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.o(i2);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(Drawable drawable) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.c(drawable);
        }
        l();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.j(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.p(i2);
        }
    }

    public void setCloseIconResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.q(i2);
        }
        l();
    }

    public void setCloseIconSize(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.k(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.r(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.l(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.s(i2);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.f(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.t(i2);
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(f2);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                c cVar = this.f;
                if (cVar != null) {
                    cVar.a(truncateAt);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.p = z;
        a(this.r);
    }

    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(b.c.a.a.a.h hVar) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(hVar);
        }
    }

    public void setHideMotionSpecResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.u(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.m(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.v(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.n(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.w(i2);
        }
    }

    public void setLayoutDirection(int i2) {
        if (this.f != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        c cVar = this.f;
        if (cVar != null) {
            cVar.x(i2);
        }
    }

    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.j = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.g(colorStateList);
        }
        if (!this.f.K()) {
            n();
        }
    }

    public void setRippleColorResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.y(i2);
            if (!this.f.K()) {
                n();
            }
        }
    }

    public void setShapeAppearanceModel(b.c.a.a.p.h hVar) {
        this.f.a(hVar);
    }

    public void setShowMotionSpec(b.c.a.a.a.h hVar) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.b(hVar);
        }
    }

    public void setShowMotionSpecResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.z(i2);
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f != null) {
            if (charSequence == null) {
                charSequence = BuildConfig.FLAVOR;
            }
            super.setText(this.f.P() ? null : charSequence, bufferType);
            c cVar = this.f;
            if (cVar != null) {
                cVar.b(charSequence);
            }
        }
    }

    public void setTextAppearance(e eVar) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(eVar);
        }
        p();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.o(f2);
        }
    }

    public void setTextEndPaddingResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.B(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.p(f2);
        }
    }

    public void setTextStartPaddingResource(int i2) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.C(i2);
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.chipStyle);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        if (attributeSet != null) {
            TypedArray a2 = s.a(context, attributeSet, j.Chip, i2, i.Widget_MaterialComponents_Chip_Action, new int[0]);
            this.p = a2.getBoolean(j.Chip_ensureMinTouchTargetSize, false);
            this.r = (int) Math.ceil((double) a2.getDimension(j.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) t.a(getContext(), 48))));
            a2.recycle();
        }
    }

    public boolean c() {
        c cVar = this.f;
        return cVar != null && cVar.L();
    }

    public boolean d() {
        c cVar = this.f;
        return cVar != null && cVar.N();
    }

    public void setCloseIconVisible(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.d(z);
        }
        l();
    }

    public Chip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = Integer.MIN_VALUE;
        this.t = new Rect();
        this.u = new RectF();
        this.v = new a(this);
        a(attributeSet);
        c a2 = c.a(context, attributeSet, i2, i.Widget_MaterialComponents_Chip_Action);
        a(context, attributeSet, i2);
        setChipDrawable(a2);
        a2.a(y.i(this));
        TypedArray a3 = s.a(context, attributeSet, j.Chip, i2, i.Widget_MaterialComponents_Chip_Action, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(b.c.a.a.m.b.a(context, a3, j.Chip_android_textColor));
        }
        boolean hasValue = a3.hasValue(j.Chip_shapeAppearance);
        a3.recycle();
        this.s = new a(this);
        if (Build.VERSION.SDK_INT >= 24) {
            y.a((View) this, (C0037a) this.s);
        } else {
            l();
        }
        if (!hasValue) {
            k();
        }
        setChecked(this.k);
        a2.e(false);
        setText(a2.G());
        setEllipsize(a2.A());
        setIncludeFontPadding(false);
        p();
        if (!this.f.P()) {
            setSingleLine();
        }
        setGravity(8388627);
        o();
        if (f()) {
            setMinHeight(this.r);
        }
        this.q = y.m(this);
    }

    private void b(c cVar) {
        if (cVar != null) {
            cVar.a((c.a) null);
        }
    }

    public void setCheckedIconVisible(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.b(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        c cVar = this.f;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        c cVar = this.f;
        if (cVar != null) {
            cVar.A(i2);
        }
        p();
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        c cVar = this.f;
        if (cVar != null) {
            cVar.A(i2);
        }
        p();
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
    }

    private void a(c cVar) {
        cVar.a((c.a) this);
    }

    public void a() {
        a(this.r);
        m();
        o();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = a.i.b.c.class.getDeclaredField("p");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.s)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = a.i.b.c.class.getDeclaredMethod("i", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.s, new Object[]{Integer.MIN_VALUE});
                    return true;
                }
            } catch (NoSuchMethodException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (IllegalAccessException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (InvocationTargetException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            } catch (NoSuchFieldException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    private boolean a(boolean z) {
        i();
        if (z) {
            if (this.l == -1) {
                setFocusedVirtualView(0);
                return true;
            }
        } else if (this.l == 0) {
            setFocusedVirtualView(-1);
            return true;
        }
        return false;
    }

    public boolean a(int i2) {
        this.r = i2;
        int i3 = 0;
        if (!f()) {
            return false;
        }
        int max = Math.max(0, i2 - this.f.getIntrinsicHeight());
        int max2 = Math.max(0, i2 - this.f.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i4 = max2 > 0 ? max2 / 2 : 0;
            if (max > 0) {
                i3 = max / 2;
            }
            if (this.g != null) {
                Rect rect = new Rect();
                this.g.getPadding(rect);
                if (rect.top == i3 && rect.bottom == i3 && rect.left == i4 && rect.right == i4) {
                    return true;
                }
            }
            if (Build.VERSION.SDK_INT < 16) {
                setMinHeight(i2);
            } else if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            a(i4, i3, i4, i3);
            return true;
        }
        this.g = null;
        return false;
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.g = new InsetDrawable(this.f, i2, i3, i4, i5);
    }
}
