package a.a.d;

import a.a.d.b;
import a.d.i;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.v;
import java.util.ArrayList;

public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f22a;

    /* renamed from: b  reason: collision with root package name */
    final b f23b;

    public f(Context context, b bVar) {
        this.f22a = context;
        this.f23b = bVar;
    }

    public void finish() {
        this.f23b.a();
    }

    public View getCustomView() {
        return this.f23b.b();
    }

    public Menu getMenu() {
        return new v(this.f22a, (a.g.c.a.a) this.f23b.c());
    }

    public MenuInflater getMenuInflater() {
        return this.f23b.d();
    }

    public CharSequence getSubtitle() {
        return this.f23b.e();
    }

    public Object getTag() {
        return this.f23b.f();
    }

    public CharSequence getTitle() {
        return this.f23b.g();
    }

    public boolean getTitleOptionalHint() {
        return this.f23b.h();
    }

    public void invalidate() {
        this.f23b.i();
    }

    public boolean isTitleOptional() {
        return this.f23b.j();
    }

    public void setCustomView(View view) {
        this.f23b.a(view);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f23b.a(charSequence);
    }

    public void setTag(Object obj) {
        this.f23b.a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f23b.b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f23b.a(z);
    }

    public void setSubtitle(int i) {
        this.f23b.a(i);
    }

    public void setTitle(int i) {
        this.f23b.b(i);
    }

    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f24a;

        /* renamed from: b  reason: collision with root package name */
        final Context f25b;
        final ArrayList<f> c = new ArrayList<>();
        final i<Menu, Menu> d = new i<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f25b = context;
            this.f24a = callback;
        }

        public boolean a(b bVar, Menu menu) {
            return this.f24a.onCreateActionMode(b(bVar), a(menu));
        }

        public boolean b(b bVar, Menu menu) {
            return this.f24a.onPrepareActionMode(b(bVar), a(menu));
        }

        public boolean a(b bVar, MenuItem menuItem) {
            return this.f24a.onActionItemClicked(b(bVar), new p(this.f25b, (a.g.c.a.b) menuItem));
        }

        public ActionMode b(b bVar) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.c.get(i);
                if (fVar != null && fVar.f23b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f25b, bVar);
            this.c.add(fVar2);
            return fVar2;
        }

        public void a(b bVar) {
            this.f24a.onDestroyActionMode(b(bVar));
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            v vVar = new v(this.f25b, (a.g.c.a.a) menu);
            this.d.put(menu, vVar);
            return vVar;
        }
    }
}
