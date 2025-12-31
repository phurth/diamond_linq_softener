package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

class E implements Toolbar.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ F f385a;

    E(F f) {
        this.f385a = f;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f385a.c.onMenuItemSelected(0, menuItem);
    }
}
