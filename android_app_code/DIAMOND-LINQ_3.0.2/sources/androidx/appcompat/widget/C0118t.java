package androidx.appcompat.widget;

import a.a.a.a.a;
import a.a.j;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.e;

/* renamed from: androidx.appcompat.widget.t  reason: case insensitive filesystem */
public class C0118t {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f638a;

    /* renamed from: b  reason: collision with root package name */
    private xa f639b;
    private xa c;
    private xa d;

    public C0118t(ImageView imageView) {
        this.f638a = imageView;
    }

    private boolean e() {
        int i = Build.VERSION.SDK_INT;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f639b != null) {
            return true;
        }
        return false;
    }

    public void a(AttributeSet attributeSet, int i) {
        int g;
        za a2 = za.a(this.f638a.getContext(), attributeSet, j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f638a.getDrawable();
            if (!(drawable != null || (g = a2.g(j.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.b(this.f638a.getContext(), g)) == null)) {
                this.f638a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                S.b(drawable);
            }
            if (a2.g(j.AppCompatImageView_tint)) {
                e.a(this.f638a, a2.a(j.AppCompatImageView_tint));
            }
            if (a2.g(j.AppCompatImageView_tintMode)) {
                e.a(this.f638a, S.a(a2.d(j.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        xa xaVar = this.c;
        if (xaVar != null) {
            return xaVar.f654a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        xa xaVar = this.c;
        if (xaVar != null) {
            return xaVar.f655b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f638a.getBackground() instanceof RippleDrawable);
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b2 = a.b(this.f638a.getContext(), i);
            if (b2 != null) {
                S.b(b2);
            }
            this.f638a.setImageDrawable(b2);
        } else {
            this.f638a.setImageDrawable((Drawable) null);
        }
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new xa();
        }
        xa xaVar = this.c;
        xaVar.f654a = colorStateList;
        xaVar.d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new xa();
        }
        xa xaVar = this.c;
        xaVar.f655b = mode;
        xaVar.c = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable drawable = this.f638a.getDrawable();
        if (drawable != null) {
            S.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            xa xaVar = this.c;
            if (xaVar != null) {
                C0116q.a(drawable, xaVar, this.f638a.getDrawableState());
                return;
            }
            xa xaVar2 = this.f639b;
            if (xaVar2 != null) {
                C0116q.a(drawable, xaVar2, this.f638a.getDrawableState());
            }
        }
    }

    private boolean a(Drawable drawable) {
        if (this.d == null) {
            this.d = new xa();
        }
        xa xaVar = this.d;
        xaVar.a();
        ColorStateList a2 = e.a(this.f638a);
        if (a2 != null) {
            xaVar.d = true;
            xaVar.f654a = a2;
        }
        PorterDuff.Mode b2 = e.b(this.f638a);
        if (b2 != null) {
            xaVar.c = true;
            xaVar.f655b = b2;
        }
        if (!xaVar.d && !xaVar.c) {
            return false;
        }
        C0116q.a(drawable, xaVar, this.f638a.getDrawableState());
        return true;
    }
}
