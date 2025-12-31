package b.c.a.a.d;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import b.c.a.a.b;
import b.c.a.a.i;

public class a extends CardView implements Checkable {
    private static final int[] j = {16842911};
    private static final int[] k = {16842912};
    private static final int[] l = {b.state_dragged};
    private static final int m = i.Widget_MaterialComponents_CardView;
    private final b n;
    private final FrameLayout o;
    private final boolean p;
    private boolean q;
    private boolean r;
    private C0033a s;

    /* renamed from: b.c.a.a.d.a$a  reason: collision with other inner class name */
    public interface C0033a {
        void a(a aVar, boolean z);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        this.o.addView(view, i, layoutParams);
    }

    public boolean c() {
        b bVar = this.n;
        if (bVar == null) {
            return false;
        }
        bVar.l();
        throw null;
    }

    public boolean d() {
        return this.r;
    }

    public ColorStateList getCardBackgroundColor() {
        this.n.b();
        throw null;
    }

    /* access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        this.n.c();
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        this.n.d();
        throw null;
    }

    public int getContentPaddingBottom() {
        this.n.j();
        throw null;
    }

    public int getContentPaddingLeft() {
        this.n.j();
        throw null;
    }

    public int getContentPaddingRight() {
        this.n.j();
        throw null;
    }

    public int getContentPaddingTop() {
        this.n.j();
        throw null;
    }

    public float getRadius() {
        this.n.e();
        throw null;
    }

    public ColorStateList getRippleColor() {
        this.n.f();
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        this.n.g();
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        this.n.h();
        throw null;
    }

    public int getStrokeWidth() {
        this.n.i();
        throw null;
    }

    public boolean isChecked() {
        return this.q;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
        if (c()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, j);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, k);
        }
        if (d()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, l);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(a.class.getName());
        accessibilityNodeInfo.setCheckable(c());
        accessibilityNodeInfo.setLongClickable(c());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.n.a(getMeasuredWidth(), getMeasuredHeight());
        throw null;
    }

    public void removeAllViews() {
        this.o.removeAllViews();
    }

    public void removeView(View view) {
        this.o.removeView(view);
    }

    public void removeViewAt(int i) {
        this.o.removeViewAt(i);
    }

    public void removeViewInLayout(View view) {
        this.o.removeViewInLayout(view);
    }

    public void removeViews(int i, int i2) {
        this.o.removeViews(i, i2);
    }

    public void removeViewsInLayout(int i, int i2) {
        this.o.removeViewsInLayout(i, i2);
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.p) {
            this.n.k();
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(int i) {
        this.n.a(ColorStateList.valueOf(i));
        throw null;
    }

    public void setCardElevation(float f) {
        super.setCardElevation(f);
        this.n.n();
        throw null;
    }

    public void setCheckable(boolean z) {
        this.n.a(z);
        throw null;
    }

    public void setChecked(boolean z) {
        if (this.q != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.n.a(drawable);
        throw null;
    }

    public void setCheckedIconResource(int i) {
        this.n.a(a.a.a.a.a.b(getContext(), i));
        throw null;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.n.b(colorStateList);
        throw null;
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        this.n.m();
        throw null;
    }

    public void setDragged(boolean z) {
        if (this.r != z) {
            this.r = z;
            refreshDrawableState();
            invalidate();
        }
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.o.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            layoutParams2.gravity = ((FrameLayout.LayoutParams) layoutParams).gravity;
            this.o.requestLayout();
        }
    }

    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.n.o();
        throw null;
    }

    public void setOnCheckedChangeListener(C0033a aVar) {
        this.s = aVar;
    }

    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.n.o();
        throw null;
    }

    public void setRadius(float f) {
        super.setRadius(f);
        this.n.a(f);
        throw null;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.n.c(colorStateList);
        throw null;
    }

    public void setRippleColorResource(int i) {
        this.n.c(a.a.a.a.a.a(getContext(), i));
        throw null;
    }

    public void setStrokeColor(int i) {
        this.n.d(ColorStateList.valueOf(i));
        throw null;
    }

    public void setStrokeWidth(int i) {
        this.n.a(i);
        throw null;
    }

    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.n.o();
        throw null;
    }

    public void toggle() {
        if (c() && isEnabled()) {
            this.q = !this.q;
            refreshDrawableState();
            if (Build.VERSION.SDK_INT <= 26) {
                C0033a aVar = this.s;
                if (aVar != null) {
                    aVar.a(this, this.q);
                    return;
                }
                return;
            }
            this.n.a();
            throw null;
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.n.a(colorStateList);
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.n.d(colorStateList);
        throw null;
    }
}
