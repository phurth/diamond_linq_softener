package androidx.appcompat.app;

import a.a.d.b;
import a.a.d.g;
import a.a.d.i;
import a.a.f;
import a.a.j;
import a.g.i.E;
import a.g.i.F;
import a.g.i.H;
import a.g.i.y;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.C0071a;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.C0098ga;
import androidx.appcompat.widget.Q;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class L extends C0071a implements ActionBarOverlayLayout.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f401a = new AccelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f402b = new DecelerateInterpolator();
    private boolean A = true;
    i B;
    private boolean C;
    boolean D;
    final F E = new I(this);
    final F F = new J(this);
    final H G = new K(this);
    Context c;
    private Context d;
    private Activity e;
    private Dialog f;
    ActionBarOverlayLayout g;
    ActionBarContainer h;
    Q i;
    ActionBarContextView j;
    View k;
    C0098ga l;
    private ArrayList<Object> m = new ArrayList<>();
    private int n = -1;
    private boolean o;
    a p;
    b q;
    b.a r;
    private boolean s;
    private ArrayList<C0071a.b> t = new ArrayList<>();
    private boolean u;
    private int v = 0;
    boolean w = true;
    boolean x;
    boolean y;
    private boolean z;

    public class a extends b implements k.a {
        private final Context c;
        private final k d;
        private b.a e;
        private WeakReference<View> f;

        public a(Context context, b.a aVar) {
            this.c = context;
            this.e = aVar;
            k kVar = new k(context);
            kVar.c(1);
            this.d = kVar;
            this.d.a((k.a) this);
        }

        public void a() {
            L l = L.this;
            if (l.p == this) {
                if (!L.a(l.x, l.y, false)) {
                    L l2 = L.this;
                    l2.q = this;
                    l2.r = this.e;
                } else {
                    this.e.a(this);
                }
                this.e = null;
                L.this.f(false);
                L.this.j.a();
                L.this.i.k().sendAccessibilityEvent(32);
                L l3 = L.this;
                l3.g.setHideOnContentScrollEnabled(l3.D);
                L.this.p = null;
            }
        }

        public void b(CharSequence charSequence) {
            L.this.j.setTitle(charSequence);
        }

        public Menu c() {
            return this.d;
        }

        public MenuInflater d() {
            return new g(this.c);
        }

        public CharSequence e() {
            return L.this.j.getSubtitle();
        }

        public CharSequence g() {
            return L.this.j.getTitle();
        }

        public void i() {
            if (L.this.p == this) {
                this.d.s();
                try {
                    this.e.b(this, this.d);
                } finally {
                    this.d.r();
                }
            }
        }

        public boolean j() {
            return L.this.j.b();
        }

        public boolean k() {
            this.d.s();
            try {
                return this.e.a((b) this, (Menu) this.d);
            } finally {
                this.d.r();
            }
        }

        public void b(int i) {
            b((CharSequence) L.this.c.getResources().getString(i));
        }

        public View b() {
            WeakReference<View> weakReference = this.f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public void a(View view) {
            L.this.j.setCustomView(view);
            this.f = new WeakReference<>(view);
        }

        public void a(CharSequence charSequence) {
            L.this.j.setSubtitle(charSequence);
        }

        public void a(int i) {
            a((CharSequence) L.this.c.getResources().getString(i));
        }

        public void a(boolean z) {
            super.a(z);
            L.this.j.setTitleOptional(z);
        }

        public boolean a(k kVar, MenuItem menuItem) {
            b.a aVar = this.e;
            if (aVar != null) {
                return aVar.a((b) this, menuItem);
            }
            return false;
        }

        public void a(k kVar) {
            if (this.e != null) {
                i();
                L.this.j.d();
            }
        }
    }

    public L(Activity activity, boolean z2) {
        this.e = activity;
        View decorView = activity.getWindow().getDecorView();
        b(decorView);
        if (!z2) {
            this.k = decorView.findViewById(16908290);
        }
    }

    private Q a(View view) {
        if (view instanceof Q) {
            return (Q) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    static boolean a(boolean z2, boolean z3, boolean z4) {
        if (z4) {
            return true;
        }
        return !z2 && !z3;
    }

    private void b(View view) {
        this.g = (ActionBarOverlayLayout) view.findViewById(f.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.i = a(view.findViewById(f.action_bar));
        this.j = (ActionBarContextView) view.findViewById(f.action_context_bar);
        this.h = (ActionBarContainer) view.findViewById(f.action_bar_container);
        Q q2 = this.i;
        if (q2 == null || this.j == null || this.h == null) {
            throw new IllegalStateException(L.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.c = q2.getContext();
        boolean z2 = (this.i.l() & 4) != 0;
        if (z2) {
            this.o = true;
        }
        a.a.d.a a2 = a.a.d.a.a(this.c);
        j(a2.a() || z2);
        k(a2.f());
        TypedArray obtainStyledAttributes = this.c.obtainStyledAttributes((AttributeSet) null, j.ActionBar, a.a.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            i(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void k(boolean z2) {
        this.u = z2;
        if (!this.u) {
            this.i.a((C0098ga) null);
            this.h.setTabContainer(this.l);
        } else {
            this.h.setTabContainer((C0098ga) null);
            this.i.a(this.l);
        }
        boolean z3 = true;
        boolean z4 = m() == 2;
        C0098ga gaVar = this.l;
        if (gaVar != null) {
            if (z4) {
                gaVar.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.g;
                if (actionBarOverlayLayout != null) {
                    y.F(actionBarOverlayLayout);
                }
            } else {
                gaVar.setVisibility(8);
            }
        }
        this.i.b(!this.u && z4);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.g;
        if (this.u || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z3);
    }

    private void n() {
        if (this.z) {
            this.z = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private boolean o() {
        return y.A(this.h);
    }

    private void p() {
        if (!this.z) {
            this.z = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    public void b() {
    }

    public void c() {
        if (!this.y) {
            this.y = true;
            l(true);
        }
    }

    public void d(boolean z2) {
        a(z2 ? 4 : 0, 4);
    }

    public void e(boolean z2) {
        i iVar;
        this.C = z2;
        if (!z2 && (iVar = this.B) != null) {
            iVar.a();
        }
    }

    public void f(boolean z2) {
        E e2;
        E e3;
        if (z2) {
            p();
        } else {
            n();
        }
        if (o()) {
            if (z2) {
                e2 = this.i.a(4, 100);
                e3 = this.j.a(0, 200);
            } else {
                e3 = this.i.a(0, 200);
                e2 = this.j.a(8, 100);
            }
            i iVar = new i();
            iVar.a(e2, e3);
            iVar.c();
        } else if (z2) {
            this.i.d(4);
            this.j.setVisibility(0);
        } else {
            this.i.d(0);
            this.j.setVisibility(8);
        }
    }

    public int g() {
        return this.i.l();
    }

    public void h(boolean z2) {
        View view;
        View view2;
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
        }
        this.h.setVisibility(0);
        if (this.v != 0 || (!this.C && !z2)) {
            this.h.setAlpha(1.0f);
            this.h.setTranslationY(0.0f);
            if (this.w && (view = this.k) != null) {
                view.setTranslationY(0.0f);
            }
            this.F.b((View) null);
        } else {
            this.h.setTranslationY(0.0f);
            float f2 = (float) (-this.h.getHeight());
            if (z2) {
                int[] iArr = {0, 0};
                this.h.getLocationInWindow(iArr);
                f2 -= (float) iArr[1];
            }
            this.h.setTranslationY(f2);
            i iVar2 = new i();
            E a2 = y.a(this.h);
            a2.b(0.0f);
            a2.a(this.G);
            iVar2.a(a2);
            if (this.w && (view2 = this.k) != null) {
                view2.setTranslationY(f2);
                E a3 = y.a(this.k);
                a3.b(0.0f);
                iVar2.a(a3);
            }
            iVar2.a(f402b);
            iVar2.a(250);
            iVar2.a(this.F);
            this.B = iVar2;
            iVar2.c();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.g;
        if (actionBarOverlayLayout != null) {
            y.F(actionBarOverlayLayout);
        }
    }

    public void i(boolean z2) {
        if (!z2 || this.g.i()) {
            this.D = z2;
            this.g.setHideOnContentScrollEnabled(z2);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void j(boolean z2) {
        this.i.a(z2);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        b.a aVar = this.r;
        if (aVar != null) {
            aVar.a(this.q);
            this.q = null;
            this.r = null;
        }
    }

    public int m() {
        return this.i.j();
    }

    public void d() {
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
            this.B = null;
        }
    }

    public void g(boolean z2) {
        View view;
        i iVar = this.B;
        if (iVar != null) {
            iVar.a();
        }
        if (this.v != 0 || (!this.C && !z2)) {
            this.E.b((View) null);
            return;
        }
        this.h.setAlpha(1.0f);
        this.h.setTransitioning(true);
        i iVar2 = new i();
        float f2 = (float) (-this.h.getHeight());
        if (z2) {
            int[] iArr = {0, 0};
            this.h.getLocationInWindow(iArr);
            f2 -= (float) iArr[1];
        }
        E a2 = y.a(this.h);
        a2.b(f2);
        a2.a(this.G);
        iVar2.a(a2);
        if (this.w && (view = this.k) != null) {
            E a3 = y.a(view);
            a3.b(f2);
            iVar2.a(a3);
        }
        iVar2.a(f401a);
        iVar2.a(250);
        iVar2.a(this.E);
        this.B = iVar2;
        iVar2.c();
    }

    public void c(boolean z2) {
        if (!this.o) {
            d(z2);
        }
    }

    private void l(boolean z2) {
        if (a(this.x, this.y, this.z)) {
            if (!this.A) {
                this.A = true;
                h(z2);
            }
        } else if (this.A) {
            this.A = false;
            g(z2);
        }
    }

    public void a(float f2) {
        y.a((View) this.h, f2);
    }

    public void a(Configuration configuration) {
        k(a.a.d.a.a(this.c).f());
    }

    public void a(int i2) {
        this.v = i2;
    }

    public void a(CharSequence charSequence) {
        this.i.setTitle(charSequence);
    }

    public void a(int i2, int i3) {
        int l2 = this.i.l();
        if ((i3 & 4) != 0) {
            this.o = true;
        }
        this.i.a((i2 & i3) | ((i3 ^ -1) & l2));
    }

    public b a(b.a aVar) {
        a aVar2 = this.p;
        if (aVar2 != null) {
            aVar2.a();
        }
        this.g.setHideOnContentScrollEnabled(false);
        this.j.c();
        a aVar3 = new a(this.j.getContext(), aVar);
        if (!aVar3.k()) {
            return null;
        }
        this.p = aVar3;
        aVar3.i();
        this.j.a(aVar3);
        f(true);
        this.j.sendAccessibilityEvent(32);
        return aVar3;
    }

    public boolean f() {
        Q q2 = this.i;
        if (q2 == null || !q2.h()) {
            return false;
        }
        this.i.collapseActionView();
        return true;
    }

    public L(Dialog dialog) {
        this.f = dialog;
        b(dialog.getWindow().getDecorView());
    }

    public void b(boolean z2) {
        if (z2 != this.s) {
            this.s = z2;
            int size = this.t.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.t.get(i2).onMenuVisibilityChanged(z2);
            }
        }
    }

    public void a(boolean z2) {
        this.w = z2;
    }

    public void b(CharSequence charSequence) {
        this.i.setWindowTitle(charSequence);
    }

    public void a() {
        if (this.y) {
            this.y = false;
            l(true);
        }
    }

    public void b(int i2) {
        this.i.c(i2);
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        Menu c2;
        a aVar = this.p;
        if (aVar == null || (c2 = aVar.c()) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        c2.setQwertyMode(z2);
        return c2.performShortcut(i2, keyEvent, 0);
    }

    public Context h() {
        if (this.d == null) {
            TypedValue typedValue = new TypedValue();
            this.c.getTheme().resolveAttribute(a.a.a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.d = new ContextThemeWrapper(this.c, i2);
            } else {
                this.d = this.c;
            }
        }
        return this.d;
    }
}
