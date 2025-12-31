package androidx.appcompat.widget;

import a.a.j;
import a.g.i.y;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: androidx.appcompat.widget.k  reason: case insensitive filesystem */
class C0105k {

    /* renamed from: a  reason: collision with root package name */
    private final View f614a;

    /* renamed from: b  reason: collision with root package name */
    private final C0116q f615b;
    private int c = -1;
    private xa d;
    private xa e;
    private xa f;

    C0105k(View view) {
        this.f614a = view;
        this.f615b = C0116q.b();
    }

    private boolean d() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.d != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        za a2 = za.a(this.f614a.getContext(), attributeSet, j.ViewBackgroundHelper, i, 0);
        try {
            if (a2.g(j.ViewBackgroundHelper_android_background)) {
                this.c = a2.g(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f615b.b(this.f614a.getContext(), this.c);
                if (b2 != null) {
                    a(b2);
                }
            }
            if (a2.g(j.ViewBackgroundHelper_backgroundTint)) {
                y.a(this.f614a, a2.a(j.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(j.ViewBackgroundHelper_backgroundTintMode)) {
                y.a(this.f614a, S.a(a2.d(j.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new xa();
        }
        xa xaVar = this.e;
        xaVar.f654a = colorStateList;
        xaVar.d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        xa xaVar = this.e;
        if (xaVar != null) {
            return xaVar.f655b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        xa xaVar = this.e;
        if (xaVar != null) {
            return xaVar.f654a;
        }
        return null;
    }

    private boolean b(Drawable drawable) {
        if (this.f == null) {
            this.f = new xa();
        }
        xa xaVar = this.f;
        xaVar.a();
        ColorStateList e2 = y.e(this.f614a);
        if (e2 != null) {
            xaVar.d = true;
            xaVar.f654a = e2;
        }
        PorterDuff.Mode f2 = y.f(this.f614a);
        if (f2 != null) {
            xaVar.c = true;
            xaVar.f655b = f2;
        }
        if (!xaVar.d && !xaVar.c) {
            return false;
        }
        C0116q.a(drawable, xaVar, this.f614a.getDrawableState());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.c = i;
        C0116q qVar = this.f615b;
        a(qVar != null ? qVar.b(this.f614a.getContext(), i) : null);
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.c = -1;
        a((ColorStateList) null);
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new xa();
        }
        xa xaVar = this.e;
        xaVar.f655b = mode;
        xaVar.c = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable background = this.f614a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            xa xaVar = this.e;
            if (xaVar != null) {
                C0116q.a(background, xaVar, this.f614a.getDrawableState());
                return;
            }
            xa xaVar2 = this.d;
            if (xaVar2 != null) {
                C0116q.a(background, xaVar2, this.f614a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new xa();
            }
            xa xaVar = this.d;
            xaVar.f654a = colorStateList;
            xaVar.d = true;
        } else {
            this.d = null;
        }
        a();
    }
}
