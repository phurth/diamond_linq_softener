package a.a.d;

import a.a.i;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f20a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f21b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    public d() {
        super((Context) null);
    }

    private Resources b() {
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                this.e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.e;
    }

    private void c() {
        boolean z = this.f21b == null;
        if (z) {
            this.f21b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f21b.setTo(theme);
            }
        }
        a(this.f21b, this.f20a, z);
    }

    public int a() {
        return this.f20a;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f21b;
        if (theme != null) {
            return theme;
        }
        if (this.f20a == 0) {
            this.f20a = i.Theme_AppCompat_Light;
        }
        c();
        return this.f21b;
    }

    public void setTheme(int i) {
        if (this.f20a != i) {
            this.f20a = i;
            c();
        }
    }

    public d(Context context, int i) {
        super(context);
        this.f20a = i;
    }

    /* access modifiers changed from: protected */
    public void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f21b = theme;
    }
}
