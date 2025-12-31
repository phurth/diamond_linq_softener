package androidx.constraintlayout.widget;

import a.e.b.a.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

public class a extends d {
    private int h;
    private int i;
    private b j;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.j = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == m.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == m.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.j.c(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.d = this.j;
        a();
    }

    public boolean b() {
        return this.j.L();
    }

    public int getType() {
        return this.h;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.j.c(z);
    }

    public void setType(int i2) {
        this.h = i2;
        this.i = i2;
        if (Build.VERSION.SDK_INT < 17) {
            int i3 = this.h;
            if (i3 == 5) {
                this.i = 0;
            } else if (i3 == 6) {
                this.i = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i4 = this.h;
                if (i4 == 5) {
                    this.i = 1;
                } else if (i4 == 6) {
                    this.i = 0;
                }
            } else {
                int i5 = this.h;
                if (i5 == 5) {
                    this.i = 0;
                } else if (i5 == 6) {
                    this.i = 1;
                }
            }
        }
        this.j.v(this.i);
    }
}
