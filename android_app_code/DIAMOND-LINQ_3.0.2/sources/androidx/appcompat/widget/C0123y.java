package androidx.appcompat.widget;

import a.a.a;
import a.g.i.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.core.widget.k;

/* renamed from: androidx.appcompat.widget.y  reason: case insensitive filesystem */
public class C0123y extends RadioButton implements k, t {

    /* renamed from: a  reason: collision with root package name */
    private final C0113o f656a;

    /* renamed from: b  reason: collision with root package name */
    private final C0105k f657b;
    private final L c;

    public C0123y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.radioButtonStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0105k kVar = this.f657b;
        if (kVar != null) {
            kVar.a();
        }
        L l = this.c;
        if (l != null) {
            l.a();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0113o oVar = this.f656a;
        return oVar != null ? oVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0105k kVar = this.f657b;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0105k kVar = this.f657b;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C0113o oVar = this.f656a;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0113o oVar = this.f656a;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0105k kVar = this.f657b;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0105k kVar = this.f657b;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0113o oVar = this.f656a;
        if (oVar != null) {
            oVar.d();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0105k kVar = this.f657b;
        if (kVar != null) {
            kVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0105k kVar = this.f657b;
        if (kVar != null) {
            kVar.a(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0113o oVar = this.f656a;
        if (oVar != null) {
            oVar.a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0113o oVar = this.f656a;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public C0123y(Context context, AttributeSet attributeSet, int i) {
        super(wa.a(context), attributeSet, i);
        this.f656a = new C0113o(this);
        this.f656a.a(attributeSet, i);
        this.f657b = new C0105k(this);
        this.f657b.a(attributeSet, i);
        this.c = new L(this);
        this.c.a(attributeSet, i);
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(a.a.a.a.a.b(getContext(), i));
    }
}
