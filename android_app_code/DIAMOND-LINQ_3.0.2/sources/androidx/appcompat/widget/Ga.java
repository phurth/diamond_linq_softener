package androidx.appcompat.widget;

import a.a.a.a.a;
import a.a.e;
import a.a.f;
import a.a.h;
import a.a.j;
import a.g.i.E;
import a.g.i.F;
import a.g.i.y;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.widget.Toolbar;

public class Ga implements Q {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f520a;

    /* renamed from: b  reason: collision with root package name */
    private int f521b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    CharSequence i;
    private CharSequence j;
    private CharSequence k;
    Window.Callback l;
    boolean m;
    private C0097g n;
    private int o;
    private int p;
    private Drawable q;

    public Ga(Toolbar toolbar, boolean z) {
        this(toolbar, z, h.abc_action_bar_up_description, e.abc_ic_ab_back_material);
    }

    private void c(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.f521b & 8) != 0) {
            this.f520a.setTitle(charSequence);
        }
    }

    private int o() {
        if (this.f520a.getNavigationIcon() == null) {
            return 11;
        }
        this.q = this.f520a.getNavigationIcon();
        return 15;
    }

    private void p() {
        if ((this.f521b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.f520a.setNavigationContentDescription(this.p);
        } else {
            this.f520a.setNavigationContentDescription(this.k);
        }
    }

    private void q() {
        if ((this.f521b & 4) != 0) {
            Toolbar toolbar = this.f520a;
            Drawable drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f520a.setNavigationIcon((Drawable) null);
    }

    private void r() {
        Drawable drawable;
        int i2 = this.f521b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) != 0) {
            drawable = this.f;
            if (drawable == null) {
                drawable = this.e;
            }
        } else {
            drawable = this.e;
        }
        this.f520a.setLogo(drawable);
    }

    public void a(Drawable drawable) {
        this.f = drawable;
        r();
    }

    public void a(boolean z) {
    }

    public void b(CharSequence charSequence) {
        this.j = charSequence;
        if ((this.f521b & 8) != 0) {
            this.f520a.setSubtitle(charSequence);
        }
    }

    public void collapseActionView() {
        this.f520a.c();
    }

    public boolean d() {
        return this.f520a.h();
    }

    public void e(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.f520a.getNavigationContentDescription())) {
                f(this.p);
            }
        }
    }

    public boolean f() {
        return this.f520a.k();
    }

    public void g() {
        this.f520a.d();
    }

    public Context getContext() {
        return this.f520a.getContext();
    }

    public CharSequence getTitle() {
        return this.f520a.getTitle();
    }

    public boolean h() {
        return this.f520a.f();
    }

    public Menu i() {
        return this.f520a.getMenu();
    }

    public int j() {
        return this.o;
    }

    public ViewGroup k() {
        return this.f520a;
    }

    public int l() {
        return this.f521b;
    }

    public void m() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void setIcon(int i2) {
        setIcon(i2 != 0 ? a.b(getContext(), i2) : null);
    }

    public void setTitle(CharSequence charSequence) {
        this.h = true;
        c(charSequence);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        if (!this.h) {
            c(charSequence);
        }
    }

    public Ga(Toolbar toolbar, boolean z, int i2, int i3) {
        Drawable drawable;
        this.o = 0;
        this.p = 0;
        this.f520a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        za a2 = za.a(toolbar.getContext(), (AttributeSet) null, j.ActionBar, a.a.a.actionBarStyle, 0);
        this.q = a2.b(j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e2 = a2.e(j.ActionBar_title);
            if (!TextUtils.isEmpty(e2)) {
                setTitle(e2);
            }
            CharSequence e3 = a2.e(j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e3)) {
                b(e3);
            }
            Drawable b2 = a2.b(j.ActionBar_logo);
            if (b2 != null) {
                a(b2);
            }
            Drawable b3 = a2.b(j.ActionBar_icon);
            if (b3 != null) {
                setIcon(b3);
            }
            if (this.g == null && (drawable = this.q) != null) {
                b(drawable);
            }
            a(a2.d(j.ActionBar_displayOptions, 0));
            int g2 = a2.g(j.ActionBar_customNavigationLayout, 0);
            if (g2 != 0) {
                a(LayoutInflater.from(this.f520a.getContext()).inflate(g2, this.f520a, false));
                a(this.f521b | 16);
            }
            int f2 = a2.f(j.ActionBar_height, 0);
            if (f2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f520a.getLayoutParams();
                layoutParams.height = f2;
                this.f520a.setLayoutParams(layoutParams);
            }
            int b4 = a2.b(j.ActionBar_contentInsetStart, -1);
            int b5 = a2.b(j.ActionBar_contentInsetEnd, -1);
            if (b4 >= 0 || b5 >= 0) {
                this.f520a.a(Math.max(b4, 0), Math.max(b5, 0));
            }
            int g3 = a2.g(j.ActionBar_titleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar2 = this.f520a;
                toolbar2.b(toolbar2.getContext(), g3);
            }
            int g4 = a2.g(j.ActionBar_subtitleTextStyle, 0);
            if (g4 != 0) {
                Toolbar toolbar3 = this.f520a;
                toolbar3.a(toolbar3.getContext(), g4);
            }
            int g5 = a2.g(j.ActionBar_popupTheme, 0);
            if (g5 != 0) {
                this.f520a.setPopupTheme(g5);
            }
        } else {
            this.f521b = o();
        }
        a2.a();
        e(i2);
        this.k = this.f520a.getNavigationContentDescription();
        this.f520a.setNavigationOnClickListener(new Ea(this));
    }

    public void d(int i2) {
        this.f520a.setVisibility(i2);
    }

    public void f(int i2) {
        a((CharSequence) i2 == 0 ? null : getContext().getString(i2));
    }

    public void setIcon(Drawable drawable) {
        this.e = drawable;
        r();
    }

    public boolean a() {
        return this.f520a.i();
    }

    public void a(Menu menu, t.a aVar) {
        if (this.n == null) {
            this.n = new C0097g(this.f520a.getContext());
            this.n.a(f.action_menu_presenter);
        }
        this.n.a(aVar);
        this.f520a.a((k) menu, this.n);
    }

    public void b(int i2) {
        a(i2 != 0 ? a.b(getContext(), i2) : null);
    }

    public boolean c() {
        return this.f520a.b();
    }

    public void b() {
        this.m = true;
    }

    public void c(int i2) {
        b(i2 != 0 ? a.b(getContext(), i2) : null);
    }

    public boolean e() {
        return this.f520a.g();
    }

    public void b(boolean z) {
        this.f520a.setCollapsible(z);
    }

    public void b(Drawable drawable) {
        this.g = drawable;
        q();
    }

    public void a(int i2) {
        View view;
        int i3 = this.f521b ^ i2;
        this.f521b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    p();
                }
                q();
            }
            if ((i3 & 3) != 0) {
                r();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.f520a.setTitle(this.i);
                    this.f520a.setSubtitle(this.j);
                } else {
                    this.f520a.setTitle((CharSequence) null);
                    this.f520a.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) != 0 && (view = this.d) != null) {
                if ((i2 & 16) != 0) {
                    this.f520a.addView(view);
                } else {
                    this.f520a.removeView(view);
                }
            }
        }
    }

    public void a(C0098ga gaVar) {
        Toolbar toolbar;
        View view = this.c;
        if (view != null && view.getParent() == (toolbar = this.f520a)) {
            toolbar.removeView(this.c);
        }
        this.c = gaVar;
        if (gaVar != null && this.o == 2) {
            this.f520a.addView(this.c, 0);
            Toolbar.b bVar = (Toolbar.b) this.c.getLayoutParams();
            bVar.width = -2;
            bVar.height = -2;
            bVar.f403a = 8388691;
            gaVar.setAllowCollapse(true);
        }
    }

    public void a(View view) {
        View view2 = this.d;
        if (!(view2 == null || (this.f521b & 16) == 0)) {
            this.f520a.removeView(view2);
        }
        this.d = view;
        if (view != null && (this.f521b & 16) != 0) {
            this.f520a.addView(this.d);
        }
    }

    public E a(int i2, long j2) {
        E a2 = y.a(this.f520a);
        a2.a(i2 == 0 ? 1.0f : 0.0f);
        a2.a(j2);
        a2.a((F) new Fa(this, i2));
        return a2;
    }

    public void a(CharSequence charSequence) {
        this.k = charSequence;
        p();
    }

    public void a(t.a aVar, k.a aVar2) {
        this.f520a.a(aVar, aVar2);
    }
}
