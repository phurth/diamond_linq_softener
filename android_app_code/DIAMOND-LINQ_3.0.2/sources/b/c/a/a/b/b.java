package b.c.a.a.b;

import a.g.i.y;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.graphics.drawable.a;
import b.c.a.a.j;
import b.c.a.a.p.e;
import b.c.a.a.p.h;
import com.google.android.material.internal.t;

class b {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f1294a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    private final a f1295b;
    private h c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private PorterDuff.Mode j;
    private ColorStateList k;
    private ColorStateList l;
    private ColorStateList m;
    private e n;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r;
    private LayerDrawable s;

    b(a aVar, h hVar) {
        this.f1295b = aVar;
        this.c = hVar;
    }

    private Drawable m() {
        e eVar = new e(this.c);
        eVar.a(this.f1295b.getContext());
        a.a((Drawable) eVar, this.k);
        PorterDuff.Mode mode = this.j;
        if (mode != null) {
            a.a((Drawable) eVar, mode);
        }
        eVar.a((float) this.i, this.l);
        e eVar2 = new e(this.c);
        eVar2.setTint(0);
        eVar2.a((float) this.i, this.o ? b.c.a.a.g.a.a((View) this.f1295b, b.c.a.a.b.colorSurface) : 0);
        this.n = new e(this.c);
        if (f1294a) {
            if (this.i > 0) {
                h hVar = new h(this.c);
                a(hVar, ((float) this.i) / 2.0f);
                eVar.a(hVar);
                eVar2.a(hVar);
                this.n.a(hVar);
            }
            a.b(this.n, -1);
            this.s = new RippleDrawable(b.c.a.a.n.a.a(this.m), a((Drawable) new LayerDrawable(new Drawable[]{eVar2, eVar})), this.n);
            return this.s;
        }
        a.a((Drawable) this.n, b.c.a.a.n.a.a(this.m));
        this.s = new LayerDrawable(new Drawable[]{eVar2, eVar, this.n});
        return a((Drawable) this.s);
    }

    private e n() {
        return c(true);
    }

    private void o() {
        e c2 = c();
        e n2 = n();
        if (c2 != null) {
            c2.a((float) this.i, this.l);
            if (n2 != null) {
                n2.a((float) this.i, this.o ? b.c.a.a.g.a.a((View) this.f1295b, b.c.a.a.b.colorSurface) : 0);
            }
            if (f1294a) {
                h hVar = new h(this.c);
                a(hVar, ((float) this.i) / 2.0f);
                b(hVar);
                e eVar = this.n;
                if (eVar != null) {
                    eVar.a(hVar);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TypedArray typedArray) {
        this.d = typedArray.getDimensionPixelOffset(j.MaterialButton_android_insetLeft, 0);
        this.e = typedArray.getDimensionPixelOffset(j.MaterialButton_android_insetRight, 0);
        this.f = typedArray.getDimensionPixelOffset(j.MaterialButton_android_insetTop, 0);
        this.g = typedArray.getDimensionPixelOffset(j.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(j.MaterialButton_cornerRadius)) {
            this.h = typedArray.getDimensionPixelSize(j.MaterialButton_cornerRadius, -1);
            this.c.a((float) this.h);
            this.q = true;
        }
        this.i = typedArray.getDimensionPixelSize(j.MaterialButton_strokeWidth, 0);
        this.j = t.a(typedArray.getInt(j.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.k = b.c.a.a.m.b.a(this.f1295b.getContext(), typedArray, j.MaterialButton_backgroundTint);
        this.l = b.c.a.a.m.b.a(this.f1295b.getContext(), typedArray, j.MaterialButton_strokeColor);
        this.m = b.c.a.a.m.b.a(this.f1295b.getContext(), typedArray, j.MaterialButton_rippleColor);
        this.r = typedArray.getBoolean(j.MaterialButton_android_checkable, false);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(j.MaterialButton_elevation, 0);
        int q2 = y.q(this.f1295b);
        int paddingTop = this.f1295b.getPaddingTop();
        int p2 = y.p(this.f1295b);
        int paddingBottom = this.f1295b.getPaddingBottom();
        this.f1295b.setInternalBackground(m());
        e c2 = c();
        if (c2 != null) {
            c2.a((float) dimensionPixelSize);
        }
        y.a(this.f1295b, q2 + this.d, paddingTop + this.f, p2 + this.e, paddingBottom + this.g);
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        this.o = z;
        o();
    }

    /* access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            if (c() != null) {
                a.a((Drawable) c(), this.k);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList d() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public h e() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList h() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode i() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.p = true;
        this.f1295b.setSupportBackgroundTintList(this.k);
        this.f1295b.setSupportBackgroundTintMode(this.j);
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            o();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        if (this.i != i2) {
            this.i = i2;
            o();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (!this.q || this.h != i2) {
            this.h = i2;
            this.q = true;
            this.c.a(((float) i2) + (((float) this.i) / 2.0f));
            b(this.c);
        }
    }

    private e c(boolean z) {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (f1294a) {
            return (e) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(z ^ true ? 1 : 0);
        }
        return (e) this.s.getDrawable(z ^ true ? 1 : 0);
    }

    private void b(h hVar) {
        if (c() != null) {
            c().a(hVar);
        }
        if (n() != null) {
            n().a(hVar);
        }
        if (b() != null) {
            b().a(hVar);
        }
    }

    /* access modifiers changed from: package-private */
    public e c() {
        return c(false);
    }

    public e b() {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.s.getNumberOfLayers() > 2) {
            return (e) this.s.getDrawable(2);
        }
        return (e) this.s.getDrawable(1);
    }

    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.d, this.f, this.e, this.g);
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.j != mode) {
            this.j = mode;
            if (c() != null && this.j != null) {
                a.a((Drawable) c(), this.j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        e eVar = this.n;
        if (eVar != null) {
            eVar.setBounds(this.d, this.f, i3 - this.e, i2 - this.g);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (c() != null) {
            c().setTint(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            if (f1294a && (this.f1295b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f1295b.getBackground()).setColor(b.c.a.a.n.a.a(colorStateList));
            } else if (!f1294a && b() != null) {
                a.a((Drawable) b(), b.c.a.a.n.a.a(colorStateList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.h;
    }

    private void a(h hVar, float f2) {
        hVar.g().a(hVar.g().a() + f2);
        hVar.h().a(hVar.h().a() + f2);
        hVar.c().a(hVar.c().a() + f2);
        hVar.b().a(hVar.b().a() + f2);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.r = z;
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar) {
        this.c = hVar;
        b(hVar);
    }
}
