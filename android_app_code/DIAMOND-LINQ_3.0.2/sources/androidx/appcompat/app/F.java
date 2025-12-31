package androidx.appcompat.app;

import a.a.d.j;
import a.g.i.y;
import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.C0071a;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.widget.Ga;
import androidx.appcompat.widget.Q;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

class F extends C0071a {

    /* renamed from: a  reason: collision with root package name */
    Q f386a;

    /* renamed from: b  reason: collision with root package name */
    boolean f387b;
    Window.Callback c;
    private boolean d;
    private boolean e;
    private ArrayList<C0071a.b> f = new ArrayList<>();
    private final Runnable g = new D(this);
    private final Toolbar.c h = new E(this);

    private final class b implements k.a {
        b() {
        }

        public void a(k kVar) {
            F f = F.this;
            if (f.c == null) {
                return;
            }
            if (f.f386a.a()) {
                F.this.c.onPanelClosed(108, kVar);
            } else if (F.this.c.onPreparePanel(0, (View) null, kVar)) {
                F.this.c.onMenuOpened(108, kVar);
            }
        }

        public boolean a(k kVar, MenuItem menuItem) {
            return false;
        }
    }

    private class c extends j {
        public c(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i) {
            if (i == 0) {
                return new View(F.this.f386a.getContext());
            }
            return super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                F f = F.this;
                if (!f.f387b) {
                    f.f386a.b();
                    F.this.f387b = true;
                }
            }
            return onPreparePanel;
        }
    }

    F(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f386a = new Ga(toolbar, false);
        this.c = new c(callback);
        this.f386a.setWindowCallback(this.c);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f386a.setWindowTitle(charSequence);
    }

    private Menu n() {
        if (!this.d) {
            this.f386a.a((t.a) new a(), (k.a) new b());
            this.d = true;
        }
        return this.f386a.i();
    }

    public void a(Configuration configuration) {
        super.a(configuration);
    }

    public void b(int i) {
        this.f386a.c(i);
    }

    public void c(boolean z) {
    }

    public void d(boolean z) {
        a(z ? 4 : 0, 4);
    }

    public void e(boolean z) {
    }

    public boolean e() {
        return this.f386a.e();
    }

    public boolean f() {
        if (!this.f386a.h()) {
            return false;
        }
        this.f386a.collapseActionView();
        return true;
    }

    public int g() {
        return this.f386a.l();
    }

    public Context h() {
        return this.f386a.getContext();
    }

    public boolean i() {
        this.f386a.k().removeCallbacks(this.g);
        y.a((View) this.f386a.k(), this.g);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f386a.k().removeCallbacks(this.g);
    }

    public boolean k() {
        return this.f386a.f();
    }

    public Window.Callback l() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        Menu n = n();
        k kVar = n instanceof k ? (k) n : null;
        if (kVar != null) {
            kVar.s();
        }
        try {
            n.clear();
            if (!this.c.onCreatePanelMenu(0, n) || !this.c.onPreparePanel(0, (View) null, n)) {
                n.clear();
            }
        } finally {
            if (kVar != null) {
                kVar.r();
            }
        }
    }

    private final class a implements t.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f388a;

        a() {
        }

        public boolean a(k kVar) {
            Window.Callback callback = F.this.c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, kVar);
            return true;
        }

        public void a(k kVar, boolean z) {
            if (!this.f388a) {
                this.f388a = true;
                F.this.f386a.g();
                Window.Callback callback = F.this.c;
                if (callback != null) {
                    callback.onPanelClosed(108, kVar);
                }
                this.f388a = false;
            }
        }
    }

    public void a(CharSequence charSequence) {
        this.f386a.setTitle(charSequence);
    }

    public void b(CharSequence charSequence) {
        this.f386a.setWindowTitle(charSequence);
    }

    public void a(int i, int i2) {
        this.f386a.a((i & i2) | ((i2 ^ -1) & this.f386a.l()));
    }

    public void b(boolean z) {
        if (z != this.e) {
            this.e = z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i).onMenuVisibilityChanged(z);
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            k();
        }
        return true;
    }

    public boolean a(int i, KeyEvent keyEvent) {
        Menu n = n();
        if (n == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        n.setQwertyMode(z);
        return n.performShortcut(i, keyEvent, 0);
    }
}
