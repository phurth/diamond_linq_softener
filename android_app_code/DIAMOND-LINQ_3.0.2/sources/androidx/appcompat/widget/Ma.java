package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public class Ma extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f538a = false;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f539b;

    public Ma(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f539b = new WeakReference<>(context);
    }

    public static boolean b() {
        return a() && Build.VERSION.SDK_INT <= 20;
    }

    /* access modifiers changed from: package-private */
    public final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f539b.get();
        if (context != null) {
            return C0090ca.a().a(context, this, i);
        }
        return super.getDrawable(i);
    }

    public static void a(boolean z) {
        f538a = z;
    }

    public static boolean a() {
        return f538a;
    }
}
