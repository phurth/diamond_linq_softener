package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

class Aa implements ActionMenuView.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Toolbar f488a;

    Aa(Toolbar toolbar) {
        this.f488a = toolbar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        Toolbar.c cVar = this.f488a.G;
        if (cVar != null) {
            return cVar.onMenuItemClick(menuItem);
        }
        return false;
    }
}
