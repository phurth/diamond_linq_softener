package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class ya extends C0092da {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f658b;

    public ya(Context context, Resources resources) {
        super(resources);
        this.f658b = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f658b.get();
        if (!(drawable == null || context == null)) {
            C0090ca.a().a(context, i, drawable);
        }
        return drawable;
    }
}
