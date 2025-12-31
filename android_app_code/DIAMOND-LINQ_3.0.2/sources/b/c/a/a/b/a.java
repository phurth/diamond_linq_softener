package b.c.a.a.b;

import a.g.i.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import androidx.appcompat.widget.C0107l;
import androidx.core.widget.j;
import b.c.a.a.i;
import b.c.a.a.p.h;
import com.google.android.material.internal.s;
import com.google.android.material.internal.t;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class a extends C0107l implements Checkable {
    private static final int[] c = {16842911};
    private static final int[] d = {16842912};
    private static final int e = i.Widget_MaterialComponents_Button;
    private final b f;
    private int g;
    private PorterDuff.Mode h;
    private ColorStateList i;
    private Drawable j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private final LinkedHashSet<C0032a> o;
    private b p;
    private int q;

    /* renamed from: b.c.a.a.b.a$a  reason: collision with other inner class name */
    public interface C0032a {
        void a(a aVar, boolean z);
    }

    interface b {
        void a(a aVar, boolean z);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.c.a.a.b.materialButtonStyle);
    }

    private boolean b() {
        return y.m(this) == 1;
    }

    private boolean c() {
        b bVar = this.f;
        return bVar != null && !bVar.j();
    }

    private void d() {
        Drawable drawable = this.j;
        if (drawable != null) {
            this.j = androidx.core.graphics.drawable.a.i(drawable).mutate();
            androidx.core.graphics.drawable.a.a(this.j, this.i);
            PorterDuff.Mode mode = this.h;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a(this.j, mode);
            }
            int i2 = this.k;
            if (i2 == 0) {
                i2 = this.j.getIntrinsicWidth();
            }
            int i3 = this.k;
            if (i3 == 0) {
                i3 = this.j.getIntrinsicHeight();
            }
            Drawable drawable2 = this.j;
            int i4 = this.l;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        j.a(this, this.j, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void e() {
        if (this.j != null && this.q == 2 && getLayout() != null) {
            TextPaint paint = getPaint();
            String charSequence = getText().toString();
            if (getTransformationMethod() != null) {
                charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
            }
            int min = Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
            int i2 = this.k;
            if (i2 == 0) {
                i2 = this.j.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - min) - y.p(this)) - i2) - this.g) - y.q(this)) / 2;
            if (b()) {
                measuredWidth = -measuredWidth;
            }
            if (this.l != measuredWidth) {
                this.l = measuredWidth;
                d();
            }
        }
    }

    private String getA11yClassName() {
        return a() ? "android.widget.CompoundButton" : "android.widget.Button";
    }

    public boolean a() {
        b bVar = this.f;
        return bVar != null && bVar.k();
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (c()) {
            return this.f.a();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.j;
    }

    public int getIconGravity() {
        return this.q;
    }

    public int getIconPadding() {
        return this.g;
    }

    public int getIconSize() {
        return this.k;
    }

    public ColorStateList getIconTint() {
        return this.i;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.h;
    }

    public ColorStateList getRippleColor() {
        if (c()) {
            return this.f.d();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public h getShapeAppearanceModel() {
        if (c()) {
            return this.f.e();
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (c()) {
            return this.f.f();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (c()) {
            return this.f.g();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (c()) {
            return this.f.h();
        }
        return super.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (c()) {
            return this.f.i();
        }
        return super.getSupportBackgroundTintMode();
    }

    public boolean isChecked() {
        return this.m;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            Button.mergeDrawableStates(onCreateDrawableState, c);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, d);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b bVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (bVar = this.f) != null) {
            bVar.a(i5 - i3, i4 - i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        e();
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        e();
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i2) {
        if (c()) {
            this.f.a(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!c()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
            this.f.l();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? a.a.a.a.a.b(getContext(), i2) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (c()) {
            this.f.a(z);
        }
    }

    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.m != z) {
            this.m = z;
            refreshDrawableState();
            if (!this.n) {
                this.n = true;
                Iterator it = this.o.iterator();
                while (it.hasNext()) {
                    ((C0032a) it.next()).a(this, this.m);
                }
                this.n = false;
            }
        }
    }

    public void setCornerRadius(int i2) {
        if (c()) {
            this.f.b(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        if (c()) {
            this.f.c().a(f2);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.j != drawable) {
            this.j = drawable;
            d();
        }
    }

    public void setIconGravity(int i2) {
        this.q = i2;
    }

    public void setIconPadding(int i2) {
        if (this.g != i2) {
            this.g = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? a.a.a.a.a.b(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.k != i2) {
            this.k = i2;
            d();
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.i != colorStateList) {
            this.i = colorStateList;
            d();
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.h != mode) {
            this.h = mode;
            d();
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(a.a.a.a.a.a(getContext(), i2));
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(b bVar) {
        this.p = bVar;
    }

    public void setPressed(boolean z) {
        b bVar = this.p;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (c()) {
            this.f.a(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (c()) {
            setRippleColor(a.a.a.a.a.a(getContext(), i2));
        }
    }

    /* access modifiers changed from: package-private */
    public void setShapeAppearanceModel(h hVar) {
        if (c()) {
            this.f.a(hVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (c()) {
            this.f.b(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (c()) {
            this.f.b(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (c()) {
            setStrokeColor(a.a.a.a.a.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (c()) {
            this.f.c(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (c()) {
            this.f.c(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.f.a(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public void toggle() {
        setChecked(!this.m);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(s.a(context, attributeSet, i2, e), attributeSet, i2);
        this.m = false;
        this.n = false;
        this.o = new LinkedHashSet<>();
        Context context2 = getContext();
        TypedArray a2 = s.a(context2, attributeSet, b.c.a.a.j.MaterialButton, i2, e, new int[0]);
        this.g = a2.getDimensionPixelSize(b.c.a.a.j.MaterialButton_iconPadding, 0);
        this.h = t.a(a2.getInt(b.c.a.a.j.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.i = b.c.a.a.m.b.a(getContext(), a2, b.c.a.a.j.MaterialButton_iconTint);
        this.j = b.c.a.a.m.b.b(getContext(), a2, b.c.a.a.j.MaterialButton_icon);
        this.q = a2.getInteger(b.c.a.a.j.MaterialButton_iconGravity, 1);
        this.k = a2.getDimensionPixelSize(b.c.a.a.j.MaterialButton_iconSize, 0);
        this.f = new b(this, new h(context2, attributeSet, i2, e));
        this.f.a(a2);
        a2.recycle();
        setCompoundDrawablePadding(this.g);
        d();
    }
}
