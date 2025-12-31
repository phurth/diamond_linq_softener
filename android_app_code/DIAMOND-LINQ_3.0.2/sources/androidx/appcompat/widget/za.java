package androidx.appcompat.widget;

import a.a.a.a.a;
import a.g.a.a.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

public class za {

    /* renamed from: a  reason: collision with root package name */
    private final Context f660a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f661b;
    private TypedValue c;

    private za(Context context, TypedArray typedArray) {
        this.f660a = context;
        this.f661b = typedArray;
    }

    public static za a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new za(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public Drawable b(int i) {
        int resourceId;
        if (!this.f661b.hasValue(i) || (resourceId = this.f661b.getResourceId(i, 0)) == 0) {
            return this.f661b.getDrawable(i);
        }
        return a.b(this.f660a, resourceId);
    }

    public Drawable c(int i) {
        int resourceId;
        if (!this.f661b.hasValue(i) || (resourceId = this.f661b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C0116q.b().a(this.f660a, resourceId, true);
    }

    public String d(int i) {
        return this.f661b.getString(i);
    }

    public CharSequence e(int i) {
        return this.f661b.getText(i);
    }

    public int f(int i, int i2) {
        return this.f661b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.f661b.getResourceId(i, i2);
    }

    public static za a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new za(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public int d(int i, int i2) {
        return this.f661b.getInt(i, i2);
    }

    public int e(int i, int i2) {
        return this.f661b.getInteger(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.f661b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.f661b.hasValue(i);
    }

    public static za a(Context context, int i, int[] iArr) {
        return new za(context, context.obtainStyledAttributes(i, iArr));
    }

    public int c(int i, int i2) {
        return this.f661b.getDimensionPixelSize(i, i2);
    }

    public Typeface a(int i, int i2, h.a aVar) {
        int resourceId = this.f661b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return h.a(this.f660a, resourceId, this.c, i2, aVar);
    }

    public int b(int i, int i2) {
        return this.f661b.getDimensionPixelOffset(i, i2);
    }

    public boolean a(int i, boolean z) {
        return this.f661b.getBoolean(i, z);
    }

    public float a(int i, float f) {
        return this.f661b.getFloat(i, f);
    }

    public int a(int i, int i2) {
        return this.f661b.getColor(i, i2);
    }

    public ColorStateList a(int i) {
        int resourceId;
        ColorStateList a2;
        if (!this.f661b.hasValue(i) || (resourceId = this.f661b.getResourceId(i, 0)) == 0 || (a2 = a.a(this.f660a, resourceId)) == null) {
            return this.f661b.getColorStateList(i);
        }
        return a2;
    }

    public void a() {
        this.f661b.recycle();
    }
}
