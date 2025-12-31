package androidx.appcompat.widget;

import a.a.a;
import a.g.i.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* renamed from: androidx.appcompat.widget.v  reason: case insensitive filesystem */
public class C0120v extends MultiAutoCompleteTextView implements t {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f646a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final C0105k f647b;
    private final L c;

    public C0120v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.autoCompleteTextViewStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0105k kVar = this.f647b;
        if (kVar != null) {
            kVar.a();
        }
        L l = this.c;
        if (l != null) {
            l.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0105k kVar = this.f647b;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0105k kVar = this.f647b;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0105k kVar = this.f647b;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0105k kVar = this.f647b;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(a.a.a.a.a.b(getContext(), i));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0105k kVar = this.f647b;
        if (kVar != null) {
            kVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0105k kVar = this.f647b;
        if (kVar != null) {
            kVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        L l = this.c;
        if (l != null) {
            l.a(context, i);
        }
    }

    public C0120v(Context context, AttributeSet attributeSet, int i) {
        super(wa.a(context), attributeSet, i);
        za a2 = za.a(getContext(), attributeSet, f646a, i, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.a();
        this.f647b = new C0105k(this);
        this.f647b.a(attributeSet, i);
        this.c = new L(this);
        this.c.a(attributeSet, i);
        this.c.a();
    }
}
