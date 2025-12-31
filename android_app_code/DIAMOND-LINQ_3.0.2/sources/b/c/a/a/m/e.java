package b.c.a.a.m;

import a.g.a.a.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import b.c.a.a.j;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final float f1313a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f1314b;
    public final ColorStateList c;
    public final ColorStateList d;
    public final int e;
    public final int f;
    public final String g;
    public final boolean h;
    public final ColorStateList i;
    public final float j;
    public final float k;
    public final float l;
    private final int m;
    /* access modifiers changed from: private */
    public boolean n = false;
    /* access modifiers changed from: private */
    public Typeface o;

    public e(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, j.TextAppearance);
        this.f1313a = obtainStyledAttributes.getDimension(j.TextAppearance_android_textSize, 0.0f);
        this.f1314b = b.a(context, obtainStyledAttributes, j.TextAppearance_android_textColor);
        this.c = b.a(context, obtainStyledAttributes, j.TextAppearance_android_textColorHint);
        this.d = b.a(context, obtainStyledAttributes, j.TextAppearance_android_textColorLink);
        this.e = obtainStyledAttributes.getInt(j.TextAppearance_android_textStyle, 0);
        this.f = obtainStyledAttributes.getInt(j.TextAppearance_android_typeface, 1);
        int a2 = b.a(obtainStyledAttributes, j.TextAppearance_fontFamily, j.TextAppearance_android_fontFamily);
        this.m = obtainStyledAttributes.getResourceId(a2, 0);
        this.g = obtainStyledAttributes.getString(a2);
        this.h = obtainStyledAttributes.getBoolean(j.TextAppearance_textAllCaps, false);
        this.i = b.a(context, obtainStyledAttributes, j.TextAppearance_android_shadowColor);
        this.j = obtainStyledAttributes.getFloat(j.TextAppearance_android_shadowDx, 0.0f);
        this.k = obtainStyledAttributes.getFloat(j.TextAppearance_android_shadowDy, 0.0f);
        this.l = obtainStyledAttributes.getFloat(j.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private void b() {
        String str;
        if (this.o == null && (str = this.g) != null) {
            this.o = Typeface.create(str, this.e);
        }
        if (this.o == null) {
            int i2 = this.f;
            if (i2 == 1) {
                this.o = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.o = Typeface.SERIF;
            } else if (i2 != 3) {
                this.o = Typeface.DEFAULT;
            } else {
                this.o = Typeface.MONOSPACE;
            }
            this.o = Typeface.create(this.o, this.e);
        }
    }

    public void c(Context context, TextPaint textPaint, g gVar) {
        if (f.a()) {
            a(textPaint, a(context));
        } else {
            a(context, textPaint, gVar);
        }
    }

    public Typeface a(Context context) {
        if (this.n) {
            return this.o;
        }
        if (!context.isRestricted()) {
            try {
                this.o = h.a(context, this.m);
                if (this.o != null) {
                    this.o = Typeface.create(this.o, this.e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.g, e2);
            }
        }
        b();
        this.n = true;
        return this.o;
    }

    public void b(Context context, TextPaint textPaint, g gVar) {
        c(context, textPaint, gVar);
        ColorStateList colorStateList = this.f1314b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.l;
        float f3 = this.j;
        float f4 = this.k;
        ColorStateList colorStateList2 = this.i;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void a(Context context, g gVar) {
        if (f.a()) {
            a(context);
        } else {
            b();
        }
        if (this.m == 0) {
            this.n = true;
        }
        if (this.n) {
            gVar.a(this.o, true);
            return;
        }
        try {
            h.a(context, this.m, new c(this, gVar), (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.n = true;
            gVar.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.g, e2);
            this.n = true;
            gVar.a(-3);
        }
    }

    public void a(Context context, TextPaint textPaint, g gVar) {
        a(textPaint, a());
        a(context, (g) new d(this, textPaint, gVar));
    }

    public Typeface a() {
        b();
        return this.o;
    }

    public void a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ -1) & this.e;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f1313a);
    }
}
