package a.g.i;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: a.g.i.b  reason: case insensitive filesystem */
public abstract class C0038b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f220a;

    /* renamed from: b  reason: collision with root package name */
    private a f221b;
    private C0011b c;

    /* renamed from: a.g.i.b$a */
    public interface a {
    }

    /* renamed from: a.g.i.b$b  reason: collision with other inner class name */
    public interface C0011b {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public C0038b(Context context) {
        this.f220a = context;
    }

    public View a(MenuItem menuItem) {
        return c();
    }

    public void a(SubMenu subMenu) {
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void f() {
        this.c = null;
        this.f221b = null;
    }

    public void a(a aVar) {
        this.f221b = aVar;
    }

    public void a(C0011b bVar) {
        if (!(this.c == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.c = bVar;
    }
}
