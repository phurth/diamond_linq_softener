package androidx.appcompat.app;

import a.a.d.b;
import a.a.j;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.appcompat.app.a  reason: case insensitive filesystem */
public abstract class C0071a {

    /* renamed from: androidx.appcompat.app.a$b */
    public interface b {
        void onMenuVisibilityChanged(boolean z);
    }

    @Deprecated
    /* renamed from: androidx.appcompat.app.a$c */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public a.a.d.b a(b.a aVar) {
        return null;
    }

    public void a(Configuration configuration) {
    }

    public abstract void a(CharSequence charSequence);

    public abstract boolean a(int i, KeyEvent keyEvent);

    public boolean a(KeyEvent keyEvent) {
        return false;
    }

    public abstract void b(int i);

    public abstract void b(CharSequence charSequence);

    public abstract void b(boolean z);

    public abstract void c(boolean z);

    public abstract void d(boolean z);

    public abstract void e(boolean z);

    public boolean e() {
        return false;
    }

    public abstract boolean f();

    public abstract int g();

    public abstract Context h();

    public boolean i() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void j() {
    }

    public boolean k() {
        return false;
    }

    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    public static class C0019a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f403a;

        public C0019a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f403a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBarLayout);
            this.f403a = obtainStyledAttributes.getInt(j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0019a(int i, int i2) {
            super(i, i2);
            this.f403a = 0;
            this.f403a = 8388627;
        }

        public C0019a(C0019a aVar) {
            super(aVar);
            this.f403a = 0;
            this.f403a = aVar.f403a;
        }

        public C0019a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f403a = 0;
        }
    }
}
