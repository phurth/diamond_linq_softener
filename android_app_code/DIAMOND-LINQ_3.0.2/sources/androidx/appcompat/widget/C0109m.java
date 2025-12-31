package androidx.appcompat.widget;

import a.a.a;
import a.g.i.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.core.widget.k;

/* renamed from: androidx.appcompat.widget.m  reason: case insensitive filesystem */
public class C0109m extends CheckBox implements k, t {

    /* renamed from: a  reason: collision with root package name */
    private final C0113o f620a;

    /* renamed from: b  reason: collision with root package name */
    private final C0105k f621b;
    private final L c;

    public C0109m(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0105k kVar = this.f621b;
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
        C0113o oVar = this.f620a;
        return oVar != null ? oVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0105k kVar = this.f621b;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0105k kVar = this.f621b;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C0113o oVar = this.f620a;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0113o oVar = this.f620a;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0105k kVar = this.f621b;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0105k kVar = this.f621b;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0113o oVar = this.f620a;
        if (oVar != null) {
            oVar.d();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0105k kVar = this.f621b;
        if (kVar != null) {
            kVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0105k kVar = this.f621b;
        if (kVar != null) {
            kVar.a(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0113o oVar = this.f620a;
        if (oVar != null) {
            oVar.a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0113o oVar = this.f620a;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public C0109m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.checkboxStyle);
    }

    public C0109m(Context context, AttributeSet attributeSet, int i) {
        super(wa.a(context), attributeSet, i);
        this.f620a = new C0113o(this);
        this.f620a.a(attributeSet, i);
        this.f621b = new C0105k(this);
        this.f621b.a(attributeSet, i);
        this.c = new L(this);
        this.c.a(attributeSet, i);
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(a.a.a.a.a.b(getContext(), i));
    }
}
