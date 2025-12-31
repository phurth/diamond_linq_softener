package androidx.appcompat.widget;

import a.a.a.a.a;
import a.g.g.c;
import a.g.i.t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.widget.b;
import androidx.core.widget.j;
import androidx.core.widget.l;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class M extends TextView implements t, l, b {

    /* renamed from: a  reason: collision with root package name */
    private final C0105k f536a;

    /* renamed from: b  reason: collision with root package name */
    private final L f537b;
    private final J c;
    private Future<c> d;

    public M(Context context) {
        this(context, (AttributeSet) null);
    }

    private void d() {
        Future<c> future = this.d;
        if (future != null) {
            try {
                this.d = null;
                j.a((TextView) this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0105k kVar = this.f536a;
        if (kVar != null) {
            kVar.a();
        }
        L l = this.f537b;
        if (l != null) {
            l.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f748a) {
            return super.getAutoSizeMaxTextSize();
        }
        L l = this.f537b;
        if (l != null) {
            return l.c();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f748a) {
            return super.getAutoSizeMinTextSize();
        }
        L l = this.f537b;
        if (l != null) {
            return l.d();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f748a) {
            return super.getAutoSizeStepGranularity();
        }
        L l = this.f537b;
        if (l != null) {
            return l.e();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f748a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        L l = this.f537b;
        if (l != null) {
            return l.f();
        }
        return new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!b.f748a) {
            L l = this.f537b;
            if (l != null) {
                return l.g();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getFirstBaselineToTopHeight() {
        return j.a((TextView) this);
    }

    public int getLastBaselineToBottomHeight() {
        return j.b(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0105k kVar = this.f536a;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0105k kVar = this.f536a;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f537b.h();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f537b.i();
    }

    public CharSequence getText() {
        d();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        J j;
        if (Build.VERSION.SDK_INT >= 28 || (j = this.c) == null) {
            return super.getTextClassifier();
        }
        return j.a();
    }

    public c.a getTextMetricsParamsCompat() {
        return j.c(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        L l = this.f537b;
        if (l != null) {
            l.a(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        d();
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        L l = this.f537b;
        if (l != null && !b.f748a && l.j()) {
            this.f537b.b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (b.f748a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        L l = this.f537b;
        if (l != null) {
            l.a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (b.f748a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        L l = this.f537b;
        if (l != null) {
            l.a(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.f748a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        L l = this.f537b;
        if (l != null) {
            l.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0105k kVar = this.f536a;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0105k kVar = this.f536a;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        L l = this.f537b;
        if (l != null) {
            l.k();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        L l = this.f537b;
        if (l != null) {
            l.k();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        L l = this.f537b;
        if (l != null) {
            l.k();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        L l = this.f537b;
        if (l != null) {
            l.k();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            j.a((TextView) this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            j.b(this, i);
        }
    }

    public void setLineHeight(int i) {
        j.c(this, i);
    }

    public void setPrecomputedText(c cVar) {
        j.a((TextView) this, cVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0105k kVar = this.f536a;
        if (kVar != null) {
            kVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0105k kVar = this.f536a;
        if (kVar != null) {
            kVar.a(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f537b.a(colorStateList);
        this.f537b.a();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f537b.a(mode);
        this.f537b.a();
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        L l = this.f537b;
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

    public void setTextFuture(Future<c> future) {
        this.d = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        j.a((TextView) this, aVar);
    }

    public void setTextSize(int i, float f) {
        if (b.f748a) {
            super.setTextSize(i, f);
            return;
        }
        L l = this.f537b;
        if (l != null) {
            l.a(i, f);
        }
    }

    public void setTypeface(Typeface typeface, int i) {
        Typeface a2 = (typeface == null || i <= 0) ? null : a.g.b.c.a(getContext(), typeface, i);
        if (a2 != null) {
            typeface = a2;
        }
        super.setTypeface(typeface, i);
    }

    public M(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public M(Context context, AttributeSet attributeSet, int i) {
        super(wa.a(context), attributeSet, i);
        this.f536a = new C0105k(this);
        this.f536a.a(attributeSet, i);
        this.f537b = new L(this);
        this.f537b.a(attributeSet, i);
        this.f537b.a();
        this.c = new J(this);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i != 0 ? a.b(context, i) : null;
        Drawable b3 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? a.b(context, i3) : null;
        if (i4 != 0) {
            drawable = a.b(context, i4);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b3, b4, drawable);
        L l = this.f537b;
        if (l != null) {
            l.k();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i != 0 ? a.b(context, i) : null;
        Drawable b3 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? a.b(context, i3) : null;
        if (i4 != 0) {
            drawable = a.b(context, i4);
        }
        setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, drawable);
        L l = this.f537b;
        if (l != null) {
            l.k();
        }
    }
}
