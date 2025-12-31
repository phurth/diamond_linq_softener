package androidx.constraintlayout.widget;

import a.e.b.a.h;
import a.e.b.a.m;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;

public abstract class d extends View {

    /* renamed from: a  reason: collision with root package name */
    protected int[] f683a = new int[32];

    /* renamed from: b  reason: collision with root package name */
    protected int f684b;
    protected Context c;
    protected m d;
    protected boolean e = false;
    private String f;
    private View[] g = null;

    public d(Context context) {
        super(context);
        this.c = context;
        a((AttributeSet) null);
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    a(str.substring(i));
                    return;
                } else {
                    a(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == m.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f = obtainStyledAttributes.getString(index);
                    setIds(this.f);
                }
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
    }

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f);
        }
        m mVar = this.d;
        if (mVar != null) {
            mVar.a();
            for (int i = 0; i < this.f684b; i++) {
                View a2 = constraintLayout.a(this.f683a[i]);
                if (a2 != null) {
                    this.d.a(constraintLayout.a(a2));
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f683a, this.f684b);
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f684b = 0;
        for (int tag : iArr) {
            setTag(tag, (Object) null);
        }
    }

    public void setTag(int i, Object obj) {
        int i2 = this.f684b + 1;
        int[] iArr = this.f683a;
        if (i2 > iArr.length) {
            this.f683a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f683a;
        int i3 = this.f684b;
        iArr2[i3] = i;
        this.f684b = i3 + 1;
    }

    public void a() {
        if (this.d != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.a) {
                ((ConstraintLayout.a) layoutParams).ma = (h) this.d;
            }
        }
    }

    private void a(String str) {
        int i;
        Object a2;
        if (str != null && this.c != null) {
            String trim = str.trim();
            try {
                i = l.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) getParent()).a(0, (Object) trim)) != null && (a2 instanceof Integer)) {
                i = ((Integer) a2).intValue();
            }
            if (i == 0) {
                i = this.c.getResources().getIdentifier(trim, "id", this.c.getPackageName());
            }
            if (i != 0) {
                setTag(i, (Object) null);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }
}
