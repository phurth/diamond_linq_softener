package androidx.appcompat.view.menu;

import a.g.c.a.b;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class c {

    /* renamed from: a  reason: collision with root package name */
    final Context f452a;

    /* renamed from: b  reason: collision with root package name */
    private Map<b, MenuItem> f453b;
    private Map<a.g.c.a.c, SubMenu> c;

    c(Context context) {
        this.f452a = context;
    }

    /* access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof b)) {
            return menuItem;
        }
        b bVar = (b) menuItem;
        if (this.f453b == null) {
            this.f453b = new a.d.b();
        }
        MenuItem menuItem2 = this.f453b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        p pVar = new p(this.f452a, bVar);
        this.f453b.put(bVar, pVar);
        return pVar;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        Map<b, MenuItem> map = this.f453b;
        if (map != null) {
            map.clear();
        }
        Map<a.g.c.a.c, SubMenu> map2 = this.c;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(int i) {
        Map<b, MenuItem> map = this.f453b;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (!(subMenu instanceof a.g.c.a.c)) {
            return subMenu;
        }
        a.g.c.a.c cVar = (a.g.c.a.c) subMenu;
        if (this.c == null) {
            this.c = new a.d.b();
        }
        SubMenu subMenu2 = this.c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        B b2 = new B(this.f452a, cVar);
        this.c.put(cVar, b2);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        Map<b, MenuItem> map = this.f453b;
        if (map != null) {
            Iterator<b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }
}
