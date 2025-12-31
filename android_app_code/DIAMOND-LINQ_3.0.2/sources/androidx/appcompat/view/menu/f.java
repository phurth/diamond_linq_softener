package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.h;

class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h.a f456a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ MenuItem f457b;
    final /* synthetic */ k c;
    final /* synthetic */ g d;

    f(g gVar, h.a aVar, MenuItem menuItem, k kVar) {
        this.d = gVar;
        this.f456a = aVar;
        this.f457b = menuItem;
        this.c = kVar;
    }

    public void run() {
        h.a aVar = this.f456a;
        if (aVar != null) {
            this.d.f458a.B = true;
            aVar.f461b.a(false);
            this.d.f458a.B = false;
        }
        if (this.f457b.isEnabled() && this.f457b.hasSubMenu()) {
            this.c.a(this.f457b, 4);
        }
    }
}
