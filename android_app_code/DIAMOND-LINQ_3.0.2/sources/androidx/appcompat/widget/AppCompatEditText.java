package androidx.appcompat.widget;

import a.a.a;
import a.g.i.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.j;

public class AppCompatEditText extends EditText implements t {

    /* renamed from: a  reason: collision with root package name */
    private final C0105k f495a;

    /* renamed from: b  reason: collision with root package name */
    private final L f496b;
    private final J c;

    public AppCompatEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0105k kVar = this.f495a;
        if (kVar != null) {
            kVar.a();
        }
        L l = this.f496b;
        if (l != null) {
            l.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0105k kVar = this.f495a;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0105k kVar = this.f495a;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    public TextClassifier getTextClassifier() {
        J j;
        if (Build.VERSION.SDK_INT >= 28 || (j = this.c) == null) {
            return super.getTextClassifier();
        }
        return j.a();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0105k kVar = this.f495a;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0105k kVar = this.f495a;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0105k kVar = this.f495a;
        if (kVar != null) {
            kVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0105k kVar = this.f495a;
        if (kVar != null) {
            kVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        L l = this.f496b;
        if (l != null) {
            l.a(context, i);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        J j;
        if (Build.VERSION.SDK_INT >= 28 || (j = this.c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            j.a(textClassifier);
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.editTextStyle);
    }

    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(wa.a(context), attributeSet, i);
        this.f495a = new C0105k(this);
        this.f495a.a(attributeSet, i);
        this.f496b = new L(this);
        this.f496b.a(attributeSet, i);
        this.f496b.a();
        this.c = new J(this);
    }
}
