package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class wa extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f650a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ArrayList<WeakReference<wa>> f651b;
    private final Resources c;
    private final Resources.Theme d;

    private wa(Context context) {
        super(context);
        if (Ma.b()) {
            this.c = new Ma(this, context.getResources());
            this.d = this.c.newTheme();
            this.d.setTo(context.getTheme());
            return;
        }
        this.c = new ya(this, context.getResources());
        this.d = null;
    }

    public static Context a(Context context) {
        if (!b(context)) {
            return context;
        }
        synchronized (f650a) {
            if (f651b == null) {
                f651b = new ArrayList<>();
            } else {
                for (int size = f651b.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f651b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f651b.remove(size);
                    }
                }
                for (int size2 = f651b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f651b.get(size2);
                    wa waVar = weakReference2 != null ? (wa) weakReference2.get() : null;
                    if (waVar != null && waVar.getBaseContext() == context) {
                        return waVar;
                    }
                }
            }
            wa waVar2 = new wa(context);
            f651b.add(new WeakReference(waVar2));
            return waVar2;
        }
    }

    private static boolean b(Context context) {
        if ((context instanceof wa) || (context.getResources() instanceof ya) || (context.getResources() instanceof Ma)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 21 || Ma.b()) {
            return true;
        }
        return false;
    }

    public AssetManager getAssets() {
        return this.c.getAssets();
    }

    public Resources getResources() {
        return this.c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.d;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
