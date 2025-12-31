package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

final class f extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f738a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f739b;
    ColorStateList c = null;
    PorterDuff.Mode d = d.f736a;

    f(f fVar) {
        if (fVar != null) {
            this.f738a = fVar.f738a;
            this.f739b = fVar.f739b;
            this.c = fVar.c;
            this.d = fVar.d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f739b != null;
    }

    public int getChangingConfigurations() {
        int i = this.f738a;
        Drawable.ConstantState constantState = this.f739b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new e(this, resources);
        }
        return new d(this, resources);
    }
}
