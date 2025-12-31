package a.a.d;

import a.a.d.b;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class e extends b implements k.a {
    private Context c;
    private ActionBarContextView d;
    private b.a e;
    private WeakReference<View> f;
    private boolean g;
    private boolean h;
    private k i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.c = context;
        this.d = actionBarContextView;
        this.e = aVar;
        k kVar = new k(actionBarContextView.getContext());
        kVar.c(1);
        this.i = kVar;
        this.i.a((k.a) this);
        this.h = z;
    }

    public void a(CharSequence charSequence) {
        this.d.setSubtitle(charSequence);
    }

    public void b(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    public Menu c() {
        return this.i;
    }

    public MenuInflater d() {
        return new g(this.d.getContext());
    }

    public CharSequence e() {
        return this.d.getSubtitle();
    }

    public CharSequence g() {
        return this.d.getTitle();
    }

    public void i() {
        this.e.b(this, this.i);
    }

    public boolean j() {
        return this.d.b();
    }

    public void a(int i2) {
        a((CharSequence) this.c.getString(i2));
    }

    public void b(int i2) {
        b((CharSequence) this.c.getString(i2));
    }

    public void a(boolean z) {
        super.a(z);
        this.d.setTitleOptional(z);
    }

    public View b() {
        WeakReference<View> weakReference = this.f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public void a(View view) {
        this.d.setCustomView(view);
        this.f = view != null ? new WeakReference<>(view) : null;
    }

    public void a() {
        if (!this.g) {
            this.g = true;
            this.d.sendAccessibilityEvent(32);
            this.e.a(this);
        }
    }

    public boolean a(k kVar, MenuItem menuItem) {
        return this.e.a((b) this, menuItem);
    }

    public void a(k kVar) {
        i();
        this.d.d();
    }
}
