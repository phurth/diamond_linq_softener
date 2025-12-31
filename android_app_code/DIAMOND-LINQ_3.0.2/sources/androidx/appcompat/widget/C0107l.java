package androidx.appcompat.widget;

import a.a.a;
import a.g.i.t;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.widget.b;
import androidx.core.widget.j;

/* renamed from: androidx.appcompat.widget.l  reason: case insensitive filesystem */
public class C0107l extends Button implements t, b {

    /* renamed from: a  reason: collision with root package name */
    private final C0105k f617a;

    /* renamed from: b  reason: collision with root package name */
    private final L f618b;

    public C0107l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.buttonStyle);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0105k kVar = this.f617a;
        if (kVar != null) {
            kVar.a();
        }
        L l = this.f618b;
        if (l != null) {
            l.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (b.f748a) {
            return super.getAutoSizeMaxTextSize();
        }
        L l = this.f618b;
        if (l != null) {
            return l.c();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (b.f748a) {
            return super.getAutoSizeMinTextSize();
        }
        L l = this.f618b;
        if (l != null) {
            return l.d();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (b.f748a) {
            return super.getAutoSizeStepGranularity();
        }
        L l = this.f618b;
        if (l != null) {
            return l.e();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (b.f748a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        L l = this.f618b;
        if (l != null) {
            return l.f();
        }
        return new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!b.f748a) {
            L l = this.f618b;
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

    public ColorStateList getSupportBackgroundTintList() {
        C0105k kVar = this.f617a;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0105k kVar = this.f617a;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        L l = this.f618b;
        if (l != null) {
            l.a(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        L l = this.f618b;
        if (l != null && !b.f748a && l.j()) {
            this.f618b.b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (b.f748a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        L l = this.f618b;
        if (l != null) {
            l.a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (b.f748a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        L l = this.f618b;
        if (l != null) {
            l.a(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.f748a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        L l = this.f618b;
        if (l != null) {
            l.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0105k kVar = this.f617a;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0105k kVar = this.f617a;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        L l = this.f618b;
        if (l != null) {
            l.a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0105k kVar = this.f617a;
        if (kVar != null) {
            kVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0105k kVar = this.f617a;
        if (kVar != null) {
            kVar.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        L l = this.f618b;
        if (l != null) {
            l.a(context, i);
        }
    }

    public void setTextSize(int i, float f) {
        if (b.f748a) {
            super.setTextSize(i, f);
            return;
        }
        L l = this.f618b;
        if (l != null) {
            l.a(i, f);
        }
    }

    public C0107l(Context context, AttributeSet attributeSet, int i) {
        super(wa.a(context), attributeSet, i);
        this.f617a = new C0105k(this);
        this.f617a.a(attributeSet, i);
        this.f618b = new L(this);
        this.f618b.a(attributeSet, i);
        this.f618b.a();
    }
}
