package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.b;
import b.c.a.a.a.h;
import b.c.a.a.j;
import b.c.a.a.p.e;
import com.google.android.material.internal.r;
import com.google.android.material.internal.s;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import no.nordicsemi.android.log.BuildConfig;

public class c extends e implements b, Drawable.Callback, r.a {
    private static final int[] u = {16842910};
    private static final int[][] v = {new int[]{16842910, 16842913}, new int[]{16842910, 16842912}, new int[]{16842910}, new int[0]};
    private ColorStateList A;
    private int Aa;
    private float B;
    private boolean Ba;
    private ColorStateList C;
    private CharSequence D;
    private boolean E;
    private Drawable F;
    private ColorStateList G;
    private float H;
    private boolean I;
    private Drawable J;
    private ColorStateList K;
    private float L;
    private CharSequence M;
    private boolean N;
    private boolean O;
    private Drawable P;
    private h Q;
    private h R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;
    private float X;
    private float Y;
    private float Z;
    private final Context aa;
    private final Paint ba = new Paint(1);
    private final Paint ca;
    private final Paint.FontMetrics da = new Paint.FontMetrics();
    private final RectF ea = new RectF();
    private final PointF fa = new PointF();
    private final Path ga = new Path();
    private final r ha;
    private int ia;
    private int ja;
    private int ka;
    private int la;
    private int ma;
    private boolean na;
    private int oa;
    private int pa = 255;
    private ColorFilter qa;
    private PorterDuffColorFilter ra;
    private ColorStateList sa;
    private PorterDuff.Mode ta = PorterDuff.Mode.SRC_IN;
    private int[] ua;
    private boolean va;
    private ColorStateList w;
    private ColorStateList wa;
    private ColorStateList x;
    private WeakReference<a> xa = new WeakReference<>((Object) null);
    private float y;
    private TextUtils.TruncateAt ya;
    private float z;
    private boolean za;

    public interface a {
        void a();
    }

    private c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
        this.aa = context;
        this.ha = new r();
        this.D = BuildConfig.FLAVOR;
        this.ha.b().density = context.getResources().getDisplayMetrics().density;
        this.ca = null;
        Paint paint = this.ca;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(u);
        a(u);
        this.za = true;
    }

    private float Q() {
        this.ha.b().getFontMetrics(this.da);
        Paint.FontMetrics fontMetrics = this.da;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean R() {
        return this.O && this.P != null && this.N;
    }

    private ColorFilter S() {
        ColorFilter colorFilter = this.qa;
        return colorFilter != null ? colorFilter : this.ra;
    }

    private boolean T() {
        return this.O && this.P != null && this.na;
    }

    private boolean U() {
        return this.E && this.F != null;
    }

    private boolean V() {
        return this.I && this.J != null;
    }

    private void W() {
        this.wa = this.va ? b.c.a.a.n.a.a(this.C) : null;
    }

    public static c a(Context context, AttributeSet attributeSet, int i, int i2) {
        c cVar = new c(context, attributeSet, i, i2);
        cVar.a(attributeSet, i, i2);
        return cVar;
    }

    private void b(Canvas canvas, Rect rect) {
        if (!this.Ba) {
            this.ba.setColor(this.ja);
            this.ba.setStyle(Paint.Style.FILL);
            this.ba.setColorFilter(S());
            this.ea.set(rect);
            canvas.drawRoundRect(this.ea, k(), k(), this.ba);
        }
    }

    private void c(Canvas canvas, Rect rect) {
        if (U()) {
            a(rect, this.ea);
            RectF rectF = this.ea;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.F.setBounds(0, 0, (int) this.ea.width(), (int) this.ea.height());
            this.F.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void d(Canvas canvas, Rect rect) {
        if (this.B > 0.0f && !this.Ba) {
            this.ba.setColor(this.ka);
            this.ba.setStyle(Paint.Style.STROKE);
            if (!this.Ba) {
                this.ba.setColorFilter(S());
            }
            RectF rectF = this.ea;
            float f = this.B;
            rectF.set(((float) rect.left) + (f / 2.0f), ((float) rect.top) + (f / 2.0f), ((float) rect.right) - (f / 2.0f), ((float) rect.bottom) - (f / 2.0f));
            float f2 = this.z - (this.B / 2.0f);
            canvas.drawRoundRect(this.ea, f2, f2, this.ba);
        }
    }

    private void e(Canvas canvas, Rect rect) {
        if (!this.Ba) {
            this.ba.setColor(this.ia);
            this.ba.setStyle(Paint.Style.FILL);
            this.ea.set(rect);
            canvas.drawRoundRect(this.ea, k(), k(), this.ba);
        }
    }

    private void i(Canvas canvas, Rect rect) {
        if (this.D != null) {
            Paint.Align a2 = a(rect, this.fa);
            e(rect, this.ea);
            if (this.ha.a() != null) {
                this.ha.b().drawableState = getState();
                this.ha.a(this.aa);
            }
            this.ha.b().setTextAlign(a2);
            int i = 0;
            boolean z2 = Math.round(this.ha.a(G().toString())) > Math.round(this.ea.width());
            if (z2) {
                i = canvas.save();
                canvas.clipRect(this.ea);
            }
            CharSequence charSequence = this.D;
            if (z2 && this.ya != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.ha.b(), this.ea.width(), this.ya);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.fa;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.ha.b());
            if (z2) {
                canvas.restoreToCount(i);
            }
        }
    }

    public void A(int i) {
        a(new b.c.a.a.m.e(this.aa, i));
    }

    public h B() {
        return this.R;
    }

    public float C() {
        return this.U;
    }

    public float D() {
        return this.T;
    }

    public ColorStateList E() {
        return this.C;
    }

    public h F() {
        return this.Q;
    }

    public CharSequence G() {
        return this.D;
    }

    public b.c.a.a.m.e H() {
        return this.ha.a();
    }

    public float I() {
        return this.W;
    }

    public float J() {
        return this.V;
    }

    public boolean K() {
        return this.va;
    }

    public boolean L() {
        return this.N;
    }

    public boolean M() {
        return e(this.J);
    }

    public boolean N() {
        return this.I;
    }

    /* access modifiers changed from: protected */
    public void O() {
        a aVar = (a) this.xa.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean P() {
        return this.za;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i = 0;
            int i2 = this.pa;
            if (i2 < 255) {
                i = b.c.a.a.c.a.a(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i2);
            }
            e(canvas, bounds);
            b(canvas, bounds);
            if (this.Ba) {
                super.draw(canvas);
            }
            d(canvas, bounds);
            g(canvas, bounds);
            c(canvas, bounds);
            a(canvas, bounds);
            if (this.za) {
                i(canvas, bounds);
            }
            f(canvas, bounds);
            h(canvas, bounds);
            if (this.pa < 255) {
                canvas.restoreToCount(i);
            }
        }
    }

    public void f(boolean z2) {
        if (this.va != z2) {
            this.va = z2;
            W();
            onStateChange(getState());
        }
    }

    /* access modifiers changed from: package-private */
    public float g() {
        if (U() || T()) {
            return this.T + this.H + this.U;
        }
        return 0.0f;
    }

    public int getAlpha() {
        return this.pa;
    }

    public ColorFilter getColorFilter() {
        return this.qa;
    }

    public int getIntrinsicHeight() {
        return (int) this.y;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.S + g() + this.V + this.ha.a(G().toString()) + this.W + h() + this.Z), this.Aa);
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.Ba) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.z);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.z);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    /* access modifiers changed from: package-private */
    public float h() {
        if (V()) {
            return this.X + this.L + this.Y;
        }
        return 0.0f;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isStateful() {
        return h(this.w) || h(this.x) || h(this.A) || (this.va && h(this.wa)) || b(this.ha.a()) || R() || e(this.F) || e(this.P) || h(this.sa);
    }

    public ColorStateList j() {
        return this.x;
    }

    public float k() {
        return this.Ba ? e().g().a() : this.z;
    }

    public void l(int i) {
        g(this.aa.getResources().getDimension(i));
    }

    public Drawable m() {
        Drawable drawable = this.F;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public void n(int i) {
        e(a.a.a.a.a.a(this.aa, i));
    }

    public void o(int i) {
        i(this.aa.getResources().getDimension(i));
    }

    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (U()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.a(this.F, i);
        }
        if (T()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.a(this.P, i);
        }
        if (V()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.a(this.J, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (U()) {
            onLevelChange |= this.F.setLevel(i);
        }
        if (T()) {
            onLevelChange |= this.P.setLevel(i);
        }
        if (V()) {
            onLevelChange |= this.J.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public boolean onStateChange(int[] iArr) {
        if (this.Ba) {
            super.onStateChange(iArr);
        }
        return a(iArr, y());
    }

    public float p() {
        return this.y;
    }

    public void q(int i) {
        c(a.a.a.a.a.b(this.aa, i));
    }

    public ColorStateList r() {
        return this.A;
    }

    public float s() {
        return this.B;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.pa != i) {
            this.pa = i;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.qa != colorFilter) {
            this.qa = colorFilter;
            invalidateSelf();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.sa != colorStateList) {
            this.sa = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.ta != mode) {
            this.ta = mode;
            this.ra = b.c.a.a.h.a.a(this, this.sa, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (U()) {
            visible |= this.F.setVisible(z2, z3);
        }
        if (T()) {
            visible |= this.P.setVisible(z2, z3);
        }
        if (V()) {
            visible |= this.J.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public Drawable t() {
        Drawable drawable = this.J;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return null;
    }

    public CharSequence u() {
        return this.M;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v(int i) {
        m(this.aa.getResources().getDimension(i));
    }

    public float w() {
        return this.L;
    }

    public float x() {
        return this.X;
    }

    public int[] y() {
        return this.ua;
    }

    public ColorStateList z() {
        return this.K;
    }

    public TextUtils.TruncateAt A() {
        return this.ya;
    }

    public void B(int i) {
        o(this.aa.getResources().getDimension(i));
    }

    public void C(int i) {
        p(this.aa.getResources().getDimension(i));
    }

    public void j(int i) {
        d(a.a.a.a.a.a(this.aa, i));
    }

    public void l(float f) {
        if (this.X != f) {
            this.X = f;
            invalidateSelf();
            if (V()) {
                O();
            }
        }
    }

    public void m(int i) {
        h(this.aa.getResources().getDimension(i));
    }

    public float n() {
        return this.H;
    }

    public ColorStateList o() {
        return this.G;
    }

    public void p(float f) {
        if (this.V != f) {
            this.V = f;
            invalidateSelf();
            O();
        }
    }

    public float q() {
        return this.S;
    }

    public void r(int i) {
        k(this.aa.getResources().getDimension(i));
    }

    public void s(int i) {
        l(this.aa.getResources().getDimension(i));
    }

    public void t(int i) {
        f(a.a.a.a.a.a(this.aa, i));
    }

    public void u(int i) {
        a(h.a(this.aa, i));
    }

    public float v() {
        return this.Y;
    }

    public void w(int i) {
        n(this.aa.getResources().getDimension(i));
    }

    public void x(int i) {
        this.Aa = i;
    }

    public void y(int i) {
        g(a.a.a.a.a.a(this.aa, i));
    }

    public void z(int i) {
        b(h.a(this.aa, i));
    }

    private void a(AttributeSet attributeSet, int i, int i2) {
        TypedArray a2 = s.a(this.aa, attributeSet, j.Chip, i, i2, new int[0]);
        this.Ba = a2.hasValue(j.Chip_shapeAppearance);
        i(b.c.a.a.m.b.a(this.aa, a2, j.Chip_chipSurfaceColor));
        c(b.c.a.a.m.b.a(this.aa, a2, j.Chip_chipBackgroundColor));
        g(a2.getDimension(j.Chip_chipMinHeight, 0.0f));
        if (a2.hasValue(j.Chip_chipCornerRadius)) {
            d(a2.getDimension(j.Chip_chipCornerRadius, 0.0f));
        }
        e(b.c.a.a.m.b.a(this.aa, a2, j.Chip_chipStrokeColor));
        i(a2.getDimension(j.Chip_chipStrokeWidth, 0.0f));
        g(b.c.a.a.m.b.a(this.aa, a2, j.Chip_rippleColor));
        b(a2.getText(j.Chip_android_text));
        a(b.c.a.a.m.b.c(this.aa, a2, j.Chip_android_textAppearance));
        int i3 = a2.getInt(j.Chip_android_ellipsize, 0);
        if (i3 == 1) {
            a(TextUtils.TruncateAt.START);
        } else if (i3 == 2) {
            a(TextUtils.TruncateAt.MIDDLE);
        } else if (i3 == 3) {
            a(TextUtils.TruncateAt.END);
        }
        c(a2.getBoolean(j.Chip_chipIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            c(a2.getBoolean(j.Chip_chipIconEnabled, false));
        }
        b(b.c.a.a.m.b.b(this.aa, a2, j.Chip_chipIcon));
        d(b.c.a.a.m.b.a(this.aa, a2, j.Chip_chipIconTint));
        f(a2.getDimension(j.Chip_chipIconSize, 0.0f));
        d(a2.getBoolean(j.Chip_closeIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            d(a2.getBoolean(j.Chip_closeIconEnabled, false));
        }
        c(b.c.a.a.m.b.b(this.aa, a2, j.Chip_closeIcon));
        f(b.c.a.a.m.b.a(this.aa, a2, j.Chip_closeIconTint));
        k(a2.getDimension(j.Chip_closeIconSize, 0.0f));
        a(a2.getBoolean(j.Chip_android_checkable, false));
        b(a2.getBoolean(j.Chip_checkedIconVisible, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            b(a2.getBoolean(j.Chip_checkedIconEnabled, false));
        }
        a(b.c.a.a.m.b.b(this.aa, a2, j.Chip_checkedIcon));
        b(h.a(this.aa, a2, j.Chip_showMotionSpec));
        a(h.a(this.aa, a2, j.Chip_hideMotionSpec));
        h(a2.getDimension(j.Chip_chipStartPadding, 0.0f));
        n(a2.getDimension(j.Chip_iconStartPadding, 0.0f));
        m(a2.getDimension(j.Chip_iconEndPadding, 0.0f));
        p(a2.getDimension(j.Chip_textStartPadding, 0.0f));
        o(a2.getDimension(j.Chip_textEndPadding, 0.0f));
        l(a2.getDimension(j.Chip_closeIconStartPadding, 0.0f));
        j(a2.getDimension(j.Chip_closeIconEndPadding, 0.0f));
        e(a2.getDimension(j.Chip_chipEndPadding, 0.0f));
        x(a2.getDimensionPixelSize(j.Chip_android_maxWidth, Integer.MAX_VALUE));
        a2.recycle();
    }

    private void g(Canvas canvas, Rect rect) {
        this.ba.setColor(this.la);
        this.ba.setStyle(Paint.Style.FILL);
        this.ea.set(rect);
        if (!this.Ba) {
            canvas.drawRoundRect(this.ea, k(), k(), this.ba);
            return;
        }
        a(rect, this.ga);
        super.a(canvas, this.ba, this.ga, c());
    }

    private void h(Canvas canvas, Rect rect) {
        Paint paint = this.ca;
        if (paint != null) {
            paint.setColor(a.g.b.a.b(-16777216, 127));
            canvas.drawRect(rect, this.ca);
            if (U() || T()) {
                a(rect, this.ea);
                canvas.drawRect(this.ea, this.ca);
            }
            if (this.D != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.ca);
            }
            if (V()) {
                c(rect, this.ea);
                canvas.drawRect(this.ea, this.ca);
            }
            this.ca.setColor(a.g.b.a.b(-65536, 127));
            b(rect, this.ea);
            canvas.drawRect(this.ea, this.ca);
            this.ca.setColor(a.g.b.a.b(-16711936, 127));
            d(rect, this.ea);
            canvas.drawRect(this.ea, this.ca);
        }
    }

    public void j(float f) {
        if (this.Y != f) {
            this.Y = f;
            invalidateSelf();
            if (V()) {
                O();
            }
        }
    }

    public void k(int i) {
        c(this.aa.getResources().getBoolean(i));
    }

    public void m(float f) {
        if (this.U != f) {
            float g = g();
            this.U = f;
            float g2 = g();
            invalidateSelf();
            if (g != g2) {
                O();
            }
        }
    }

    public void n(float f) {
        if (this.T != f) {
            float g = g();
            this.T = f;
            float g2 = g();
            invalidateSelf();
            if (g != g2) {
                O();
            }
        }
    }

    public void o(float f) {
        if (this.W != f) {
            this.W = f;
            invalidateSelf();
            O();
        }
    }

    public void k(float f) {
        if (this.L != f) {
            this.L = f;
            invalidateSelf();
            if (V()) {
                O();
            }
        }
    }

    private void f(Canvas canvas, Rect rect) {
        if (V()) {
            c(rect, this.ea);
            RectF rectF = this.ea;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.J.setBounds(0, 0, (int) this.ea.width(), (int) this.ea.height());
            this.J.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void e(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.D != null) {
            float g = this.S + g() + this.V;
            float h = this.Z + h() + this.W;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.left = ((float) rect.left) + g;
                rectF.right = ((float) rect.right) - h;
            } else {
                rectF.left = ((float) rect.left) + h;
                rectF.right = ((float) rect.right) - g;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    public void p(int i) {
        j(this.aa.getResources().getDimension(i));
    }

    private void b(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (V()) {
            float f = this.Z + this.Y + this.L + this.X + this.W;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = ((float) rect.right) - f;
            } else {
                rectF.left = ((float) rect.left) + f;
            }
        }
    }

    public float l() {
        return this.Z;
    }

    private void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (V()) {
            float f = this.Z + this.Y;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = ((float) rect.right) - f;
                rectF.left = rectF.right - this.L;
            } else {
                rectF.left = ((float) rect.left) + f;
                rectF.right = rectF.left + this.L;
            }
            float exactCenterY = rect.exactCenterY();
            float f2 = this.L;
            rectF.top = exactCenterY - (f2 / 2.0f);
            rectF.bottom = rectF.top + f2;
        }
    }

    private void d(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (V()) {
            float f = this.Z + this.Y + this.L + this.X + this.W;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.right = (float) rect.right;
                rectF.left = rectF.right - f;
            } else {
                int i = rect.left;
                rectF.left = (float) i;
                rectF.right = ((float) i) + f;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    public void g(float f) {
        if (this.y != f) {
            this.y = f;
            invalidateSelf();
            O();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.f1314b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(b.c.a.a.m.e r0) {
        /*
            if (r0 == 0) goto L_0x000e
            android.content.res.ColorStateList r0 = r0.f1314b
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.c.b(b.c.a.a.m.e):boolean");
    }

    private void f(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    @Deprecated
    public void f(int i) {
        d(this.aa.getResources().getDimension(i));
    }

    public void g(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            W();
            onStateChange(getState());
        }
    }

    public void b(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = BuildConfig.FLAVOR;
        }
        if (!TextUtils.equals(this.D, charSequence)) {
            this.D = charSequence;
            this.ha.a(true);
            invalidateSelf();
            O();
        }
    }

    public void f(float f) {
        if (this.H != f) {
            float g = g();
            this.H = f;
            float g2 = g();
            invalidateSelf();
            if (g != g2) {
                O();
            }
        }
    }

    private static boolean e(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public void e(int i) {
        c(a.a.a.a.a.a(this.aa, i));
    }

    public void g(int i) {
        e(this.aa.getResources().getDimension(i));
    }

    private void d(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            androidx.core.graphics.drawable.a.a(drawable, androidx.core.graphics.drawable.a.e(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.J) {
                if (drawable.isStateful()) {
                    drawable.setState(y());
                }
                androidx.core.graphics.drawable.a.a(drawable, this.K);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.F;
            if (drawable == drawable2) {
                androidx.core.graphics.drawable.a.a(drawable2, this.G);
            }
        }
    }

    public void c(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (this.x != colorStateList) {
            this.x = colorStateList;
            if (!(!this.Ba || (colorStateList2 = this.w) == null || colorStateList == null)) {
                a(a(colorStateList, colorStateList2));
            }
            onStateChange(getState());
        }
    }

    public void e(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            if (this.Ba) {
                b(colorStateList);
            }
            onStateChange(getState());
        }
    }

    private void i(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (this.w != colorStateList) {
            this.w = colorStateList;
            if (!(!this.Ba || colorStateList == null || (colorStateList2 = this.x) == null)) {
                a(a(colorStateList2, colorStateList));
            }
            onStateChange(getState());
        }
    }

    public void b(Drawable drawable) {
        Drawable m = m();
        if (m != drawable) {
            float g = g();
            this.F = drawable != null ? androidx.core.graphics.drawable.a.i(drawable).mutate() : null;
            float g2 = g();
            f(m);
            if (U()) {
                d(this.F);
            }
            invalidateSelf();
            if (g != g2) {
                O();
            }
        }
    }

    public void f(ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (V()) {
                androidx.core.graphics.drawable.a.a(this.J, colorStateList);
            }
            onStateChange(getState());
        }
    }

    private static boolean h(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public void h(int i) {
        b(a.a.a.a.a.b(this.aa, i));
    }

    public void e(float f) {
        if (this.Z != f) {
            this.Z = f;
            invalidateSelf();
            O();
        }
    }

    public void h(float f) {
        if (this.S != f) {
            this.S = f;
            invalidateSelf();
            O();
        }
    }

    public void c(boolean z2) {
        if (this.E != z2) {
            boolean U2 = U();
            this.E = z2;
            boolean U3 = U();
            if (U2 != U3) {
                if (U3) {
                    d(this.F);
                } else {
                    f(this.F);
                }
                invalidateSelf();
                O();
            }
        }
    }

    public void i(float f) {
        if (this.B != f) {
            this.B = f;
            this.ba.setStrokeWidth(f);
            if (this.Ba) {
                super.c(f);
            }
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void e(boolean z2) {
        this.za = z2;
    }

    public void b(int i) {
        a(this.aa.getResources().getBoolean(i));
    }

    public void b(boolean z2) {
        if (this.O != z2) {
            boolean T2 = T();
            this.O = z2;
            boolean T3 = T();
            if (T2 != T3) {
                if (T3) {
                    d(this.P);
                } else {
                    f(this.P);
                }
                invalidateSelf();
                O();
            }
        }
    }

    @Deprecated
    public void d(float f) {
        if (this.z != f) {
            this.z = f;
            e().a(f);
            invalidateSelf();
        }
    }

    public void i(int i) {
        f(this.aa.getResources().getDimension(i));
    }

    public void c(Drawable drawable) {
        Drawable t = t();
        if (t != drawable) {
            float h = h();
            this.J = drawable != null ? androidx.core.graphics.drawable.a.i(drawable).mutate() : null;
            float h2 = h();
            f(t);
            if (V()) {
                d(this.J);
            }
            invalidateSelf();
            if (h != h2) {
                O();
            }
        }
    }

    public Drawable i() {
        return this.P;
    }

    public void d(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            if (U()) {
                androidx.core.graphics.drawable.a.a(this.F, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void b(h hVar) {
        this.Q = hVar;
    }

    public void d(boolean z2) {
        if (this.I != z2) {
            boolean V2 = V();
            this.I = z2;
            boolean V3 = V();
            if (V2 != V3) {
                if (V3) {
                    d(this.J);
                } else {
                    f(this.J);
                }
                invalidateSelf();
                O();
            }
        }
    }

    public void c(int i) {
        a(a.a.a.a.a.b(this.aa, i));
    }

    public void d(int i) {
        b(this.aa.getResources().getBoolean(i));
    }

    public void a(a aVar) {
        this.xa = new WeakReference<>(aVar);
    }

    public void a(RectF rectF) {
        d(getBounds(), rectF);
    }

    private void a(Canvas canvas, Rect rect) {
        if (T()) {
            a(rect, this.ea);
            RectF rectF = this.ea;
            float f = rectF.left;
            float f2 = rectF.top;
            canvas.translate(f, f2);
            this.P.setBounds(0, 0, (int) this.ea.width(), (int) this.ea.height());
            this.P.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (U() || T()) {
            float f = this.S + this.T;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                rectF.left = ((float) rect.left) + f;
                rectF.right = rectF.left + this.H;
            } else {
                rectF.right = ((float) rect.right) - f;
                rectF.left = rectF.right - this.H;
            }
            float exactCenterY = rect.exactCenterY();
            float f2 = this.H;
            rectF.top = exactCenterY - (f2 / 2.0f);
            rectF.bottom = rectF.top + f2;
        }
    }

    /* access modifiers changed from: package-private */
    public Paint.Align a(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.D != null) {
            float g = this.S + g() + this.V;
            if (androidx.core.graphics.drawable.a.e(this) == 0) {
                pointF.x = ((float) rect.left) + g;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = ((float) rect.right) - g;
                align = Paint.Align.RIGHT;
            }
            pointF.y = ((float) rect.centerY()) - Q();
        }
        return align;
    }

    public boolean a(int[] iArr) {
        if (Arrays.equals(this.ua, iArr)) {
            return false;
        }
        this.ua = iArr;
        if (V()) {
            return a(getState(), iArr);
        }
        return false;
    }

    public void a() {
        O();
        invalidateSelf();
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int[] r6, int[] r7) {
        /*
            r5 = this;
            boolean r0 = super.onStateChange(r6)
            android.content.res.ColorStateList r1 = r5.w
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r5.ia
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r3 = r5.ia
            r4 = 1
            if (r3 == r1) goto L_0x0019
            r5.ia = r1
            r0 = 1
        L_0x0019:
            android.content.res.ColorStateList r1 = r5.x
            if (r1 == 0) goto L_0x0024
            int r3 = r5.ja
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            int r3 = r5.ja
            if (r3 == r1) goto L_0x002c
            r5.ja = r1
            r0 = 1
        L_0x002c:
            android.content.res.ColorStateList r1 = r5.A
            if (r1 == 0) goto L_0x0037
            int r3 = r5.ka
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            int r3 = r5.ka
            if (r3 == r1) goto L_0x003f
            r5.ka = r1
            r0 = 1
        L_0x003f:
            android.content.res.ColorStateList r1 = r5.wa
            if (r1 == 0) goto L_0x004a
            int r3 = r5.la
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x004b
        L_0x004a:
            r1 = 0
        L_0x004b:
            int r3 = r5.la
            if (r3 == r1) goto L_0x0056
            r5.la = r1
            boolean r1 = r5.va
            if (r1 == 0) goto L_0x0056
            r0 = 1
        L_0x0056:
            com.google.android.material.internal.r r1 = r5.ha
            b.c.a.a.m.e r1 = r1.a()
            if (r1 == 0) goto L_0x0077
            com.google.android.material.internal.r r1 = r5.ha
            b.c.a.a.m.e r1 = r1.a()
            android.content.res.ColorStateList r1 = r1.f1314b
            if (r1 == 0) goto L_0x0077
            com.google.android.material.internal.r r1 = r5.ha
            b.c.a.a.m.e r1 = r1.a()
            android.content.res.ColorStateList r1 = r1.f1314b
            int r3 = r5.ma
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0078
        L_0x0077:
            r1 = 0
        L_0x0078:
            int r3 = r5.ma
            if (r3 == r1) goto L_0x007f
            r5.ma = r1
            r0 = 1
        L_0x007f:
            int[] r1 = r5.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            boolean r1 = a((int[]) r1, (int) r3)
            if (r1 == 0) goto L_0x0092
            boolean r1 = r5.N
            if (r1 == 0) goto L_0x0092
            r1 = 1
            goto L_0x0093
        L_0x0092:
            r1 = 0
        L_0x0093:
            boolean r3 = r5.na
            if (r3 == r1) goto L_0x00ad
            android.graphics.drawable.Drawable r3 = r5.P
            if (r3 == 0) goto L_0x00ad
            float r0 = r5.g()
            r5.na = r1
            float r1 = r5.g()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00ac
            r0 = 1
            r1 = 1
            goto L_0x00ae
        L_0x00ac:
            r0 = 1
        L_0x00ad:
            r1 = 0
        L_0x00ae:
            android.content.res.ColorStateList r3 = r5.sa
            if (r3 == 0) goto L_0x00b8
            int r2 = r5.oa
            int r2 = r3.getColorForState(r6, r2)
        L_0x00b8:
            int r3 = r5.oa
            if (r3 == r2) goto L_0x00c9
            r5.oa = r2
            android.content.res.ColorStateList r0 = r5.sa
            android.graphics.PorterDuff$Mode r2 = r5.ta
            android.graphics.PorterDuffColorFilter r0 = b.c.a.a.h.a.a(r5, r0, r2)
            r5.ra = r0
            r0 = 1
        L_0x00c9:
            android.graphics.drawable.Drawable r2 = r5.F
            boolean r2 = e((android.graphics.drawable.Drawable) r2)
            if (r2 == 0) goto L_0x00d8
            android.graphics.drawable.Drawable r2 = r5.F
            boolean r2 = r2.setState(r6)
            r0 = r0 | r2
        L_0x00d8:
            android.graphics.drawable.Drawable r2 = r5.P
            boolean r2 = e((android.graphics.drawable.Drawable) r2)
            if (r2 == 0) goto L_0x00e7
            android.graphics.drawable.Drawable r2 = r5.P
            boolean r6 = r2.setState(r6)
            r0 = r0 | r6
        L_0x00e7:
            android.graphics.drawable.Drawable r6 = r5.J
            boolean r6 = e((android.graphics.drawable.Drawable) r6)
            if (r6 == 0) goto L_0x00f6
            android.graphics.drawable.Drawable r6 = r5.J
            boolean r6 = r6.setState(r7)
            r0 = r0 | r6
        L_0x00f6:
            if (r0 == 0) goto L_0x00fb
            r5.invalidateSelf()
        L_0x00fb:
            if (r1 == 0) goto L_0x0100
            r5.O()
        L_0x0100:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.c.a(int[], int[]):boolean");
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList a(ColorStateList colorStateList, ColorStateList colorStateList2) {
        int[] iArr = new int[v.length];
        int i = 0;
        while (true) {
            int[][] iArr2 = v;
            if (i >= iArr2.length) {
                return new ColorStateList(iArr2, iArr);
            }
            iArr[i] = b.c.a.a.g.a.a(colorStateList2.getColorForState(iArr2[i], this.ia), colorStateList.getColorForState(v[i], this.ja));
            i++;
        }
    }

    public void a(b.c.a.a.m.e eVar) {
        this.ha.a(eVar, this.aa);
    }

    public void a(TextUtils.TruncateAt truncateAt) {
        this.ya = truncateAt;
    }

    public void a(CharSequence charSequence) {
        if (this.M != charSequence) {
            this.M = a.g.g.a.a().a(charSequence);
            invalidateSelf();
        }
    }

    public void a(boolean z2) {
        if (this.N != z2) {
            this.N = z2;
            float g = g();
            if (!z2 && this.na) {
                this.na = false;
            }
            float g2 = g();
            invalidateSelf();
            if (g != g2) {
                O();
            }
        }
    }

    public void a(Drawable drawable) {
        if (this.P != drawable) {
            float g = g();
            this.P = drawable;
            float g2 = g();
            f(this.P);
            d(this.P);
            invalidateSelf();
            if (g != g2) {
                O();
            }
        }
    }

    public void a(h hVar) {
        this.R = hVar;
    }
}
