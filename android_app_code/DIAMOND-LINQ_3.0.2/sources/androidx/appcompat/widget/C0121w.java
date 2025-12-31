package androidx.appcompat.widget;

import a.a.j;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.i;

/* renamed from: androidx.appcompat.widget.w  reason: case insensitive filesystem */
class C0121w extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f648a = (Build.VERSION.SDK_INT < 21);

    /* renamed from: b  reason: collision with root package name */
    private boolean f649b;

    public C0121w(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        za a2 = za.a(context, attributeSet, j.PopupWindow, i, i2);
        if (a2.g(j.PopupWindow_overlapAnchor)) {
            a(a2.a(j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.b(j.PopupWindow_android_popupBackground));
        a2.a();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f648a && this.f649b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f648a && this.f649b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f648a && this.f649b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    private void a(boolean z) {
        if (f648a) {
            this.f649b = z;
        } else {
            i.a((PopupWindow) this, z);
        }
    }
}
