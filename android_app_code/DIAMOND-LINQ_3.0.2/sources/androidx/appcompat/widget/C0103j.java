package androidx.appcompat.widget;

import a.a.a.a.a;
import a.g.i.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.core.widget.j;

/* renamed from: androidx.appcompat.widget.j  reason: case insensitive filesystem */
public class C0103j extends AutoCompleteTextView implements t {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f611a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final C0105k f612b;
    private final L c;

    public C0103j(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0105k kVar = this.f612b;
        if (kVar != null) {
            kVar.a();
        }
        L l = this.c;
        if (l != null) {
            l.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0105k kVar = this.f612b;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0105k kVar = this.f612b;
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
        C0105k kVar = this.f612b;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0105k kVar = this.f612b;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(a.b(getContext(), i));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0105k kVar = this.f612b;
        if (kVar != null) {
            kVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0105k kVar = this.f612b;
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

    public C0103j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.a.autoCompleteTextViewStyle);
    }

    public C0103j(Context context, AttributeSet attributeSet, int i) {
        super(wa.a(context), attributeSet, i);
        za a2 = za.a(getContext(), attributeSet, f611a, i, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.b(0));
        }
        a2.a();
        this.f612b = new C0105k(this);
        this.f612b.a(attributeSet, i);
        this.c = new L(this);
        this.c.a(attributeSet, i);
        this.c.a();
    }
}
