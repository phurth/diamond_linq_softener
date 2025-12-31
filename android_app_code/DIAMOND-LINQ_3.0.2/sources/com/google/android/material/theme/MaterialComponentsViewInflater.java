package com.google.android.material.theme;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.C0107l;
import androidx.appcompat.widget.C0109m;
import androidx.appcompat.widget.C0123y;
import b.c.a.a.b.a;

@Keep
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    private static int floatingToolbarItemBackgroundResId = -1;

    /* access modifiers changed from: protected */
    public C0107l createButton(Context context, AttributeSet attributeSet) {
        if (shouldInflateAppCompatButton(context, attributeSet)) {
            return new C0107l(context, attributeSet);
        }
        return new a(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0109m createCheckBox(Context context, AttributeSet attributeSet) {
        return new b.c.a.a.e.a(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public C0123y createRadioButton(Context context, AttributeSet attributeSet) {
        return new b.c.a.a.l.a(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean shouldInflateAppCompatButton(Context context, AttributeSet attributeSet) {
        int i = Build.VERSION.SDK_INT;
        if (i != 23 && i != 24 && i != 25) {
            return false;
        }
        if (floatingToolbarItemBackgroundResId == -1) {
            floatingToolbarItemBackgroundResId = context.getResources().getIdentifier("floatingToolbarItemBackgroundDrawable", "^attr-private", "android");
        }
        int i2 = floatingToolbarItemBackgroundResId;
        if (!(i2 == 0 || i2 == -1)) {
            for (int i3 = 0; i3 < attributeSet.getAttributeCount(); i3++) {
                if (attributeSet.getAttributeNameResource(i3) == 16842964 && floatingToolbarItemBackgroundResId == attributeSet.getAttributeListValue(i3, (String[]) null, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
