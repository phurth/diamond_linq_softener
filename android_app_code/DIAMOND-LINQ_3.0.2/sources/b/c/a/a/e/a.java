package b.c.a.a.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.C0109m;
import androidx.core.widget.c;
import b.c.a.a.b;
import b.c.a.a.i;
import b.c.a.a.j;
import com.google.android.material.internal.s;

public class a extends C0109m {
    private static final int d = i.Widget_MaterialComponents_CompoundButton_CheckBox;
    private static final int[][] e = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    private ColorStateList f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.checkboxStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f == null) {
            int[] iArr = new int[e.length];
            int a2 = b.c.a.a.g.a.a((View) this, b.colorControlActivated);
            int a3 = b.c.a.a.g.a.a((View) this, b.colorSurface);
            int a4 = b.c.a.a.g.a.a((View) this, b.colorOnSurface);
            iArr[0] = b.c.a.a.g.a.a(a3, a2, 1.0f);
            iArr[1] = b.c.a.a.g.a.a(a3, a4, 0.54f);
            iArr[2] = b.c.a.a.g.a.a(a3, a4, 0.38f);
            iArr[3] = b.c.a.a.g.a.a(a3, a4, 0.38f);
            this.f = new ColorStateList(e, iArr);
        }
        return this.f;
    }

    public void setUseMaterialThemeColors(boolean z) {
        if (z) {
            c.a((CompoundButton) this, getMaterialThemeColorsTintList());
        } else {
            c.a((CompoundButton) this, (ColorStateList) null);
        }
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(s.a(context, attributeSet, i, d), attributeSet, i);
        TypedArray a2 = s.a(getContext(), attributeSet, j.MaterialCheckBox, i, d, new int[0]);
        boolean z = a2.getBoolean(j.MaterialCheckBox_useMaterialThemeColors, false);
        a2.recycle();
        if (z && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }
}
