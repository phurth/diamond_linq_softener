package androidx.appcompat.widget;

import a.g.i.t;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.m;

/* renamed from: androidx.appcompat.widget.u  reason: case insensitive filesystem */
public class C0119u extends ImageView implements t, m {

    /* renamed from: a  reason: collision with root package name */
    private final C0105k f642a;

    /* renamed from: b  reason: collision with root package name */
    private final C0118t f643b;

    public C0119u(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0105k kVar = this.f642a;
        if (kVar != null) {
            kVar.a();
        }
        C0118t tVar = this.f643b;
        if (tVar != null) {
            tVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0105k kVar = this.f642a;
        if (kVar != null) {
            return kVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0105k kVar = this.f642a;
        if (kVar != null) {
            return kVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0118t tVar = this.f643b;
        if (tVar != null) {
            return tVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0118t tVar = this.f643b;
        if (tVar != null) {
            return tVar.c();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f643b.d() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0105k kVar = this.f642a;
        if (kVar != null) {
            kVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0105k kVar = this.f642a;
        if (kVar != null) {
            kVar.a(i);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0118t tVar = this.f643b;
        if (tVar != null) {
            tVar.a();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0118t tVar = this.f643b;
        if (tVar != null) {
            tVar.a();
        }
    }

    public void setImageResource(int i) {
        C0118t tVar = this.f643b;
        if (tVar != null) {
            tVar.a(i);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0118t tVar = this.f643b;
        if (tVar != null) {
            tVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0105k kVar = this.f642a;
        if (kVar != null) {
            kVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0105k kVar = this.f642a;
        if (kVar != null) {
            kVar.a(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0118t tVar = this.f643b;
        if (tVar != null) {
            tVar.a(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0118t tVar = this.f643b;
        if (tVar != null) {
            tVar.a(mode);
        }
    }

    public C0119u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0119u(Context context, AttributeSet attributeSet, int i) {
        super(wa.a(context), attributeSet, i);
        this.f642a = new C0105k(this);
        this.f642a.a(attributeSet, i);
        this.f643b = new C0118t(this);
        this.f643b.a(attributeSet, i);
    }
}
