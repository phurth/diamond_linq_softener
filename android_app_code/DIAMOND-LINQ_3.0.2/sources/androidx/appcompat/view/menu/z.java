package androidx.appcompat.view.menu;

import a.a.d;
import a.a.g;
import a.g.i.y;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.widget.C0088ba;

final class z extends q implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, t, View.OnKeyListener {

    /* renamed from: b  reason: collision with root package name */
    private static final int f486b = g.abc_popup_menu_item_layout;
    private final Context c;
    private final k d;
    private final j e;
    private final boolean f;
    private final int g;
    private final int h;
    private final int i;
    final C0088ba j;
    final ViewTreeObserver.OnGlobalLayoutListener k = new x(this);
    private final View.OnAttachStateChangeListener l = new y(this);
    private PopupWindow.OnDismissListener m;
    private View n;
    View o;
    private t.a p;
    ViewTreeObserver q;
    private boolean r;
    private boolean s;
    private int t;
    private int u = 0;
    private boolean v;

    public z(Context context, k kVar, View view, int i2, int i3, boolean z) {
        this.c = context;
        this.d = kVar;
        this.f = z;
        this.e = new j(kVar, LayoutInflater.from(context), this.f, f486b);
        this.h = i2;
        this.i = i3;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.n = view;
        this.j = new C0088ba(this.c, (AttributeSet) null, this.h, this.i);
        kVar.a((t) this, context);
    }

    private boolean h() {
        View view;
        if (c()) {
            return true;
        }
        if (this.r || (view = this.n) == null) {
            return false;
        }
        this.o = view;
        this.j.a((PopupWindow.OnDismissListener) this);
        this.j.a((AdapterView.OnItemClickListener) this);
        this.j.a(true);
        View view2 = this.o;
        boolean z = this.q == null;
        this.q = view2.getViewTreeObserver();
        if (z) {
            this.q.addOnGlobalLayoutListener(this.k);
        }
        view2.addOnAttachStateChangeListener(this.l);
        this.j.a(view2);
        this.j.e(this.u);
        if (!this.s) {
            this.t = q.a(this.e, (ViewGroup) null, this.c, this.g);
            this.s = true;
        }
        this.j.d(this.t);
        this.j.f(2);
        this.j.a(g());
        this.j.d();
        ListView f2 = this.j.f();
        f2.setOnKeyListener(this);
        if (this.v && this.d.h() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(g.abc_popup_menu_header_item_layout, f2, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.d.h());
            }
            frameLayout.setEnabled(false);
            f2.addHeaderView(frameLayout, (Object) null, false);
        }
        this.j.a((ListAdapter) this.e);
        this.j.d();
        return true;
    }

    public void a(int i2) {
        this.u = i2;
    }

    public void a(Parcelable parcelable) {
    }

    public void a(k kVar) {
    }

    public boolean a() {
        return false;
    }

    public Parcelable b() {
        return null;
    }

    public void b(boolean z) {
        this.e.a(z);
    }

    public boolean c() {
        return !this.r && this.j.c();
    }

    public void d() {
        if (!h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void dismiss() {
        if (c()) {
            this.j.dismiss();
        }
    }

    public ListView f() {
        return this.j.f();
    }

    public void onDismiss() {
        this.r = true;
        this.d.close();
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void a(boolean z) {
        this.s = false;
        j jVar = this.e;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    public void b(int i2) {
        this.j.a(i2);
    }

    public void c(int i2) {
        this.j.b(i2);
    }

    public void c(boolean z) {
        this.v = z;
    }

    public void a(t.a aVar) {
        this.p = aVar;
    }

    public boolean a(A a2) {
        if (a2.hasVisibleItems()) {
            s sVar = new s(this.c, a2, this.o, this.f, this.h, this.i);
            sVar.a(this.p);
            sVar.a(q.b((k) a2));
            sVar.a(this.m);
            this.m = null;
            this.d.a(false);
            int a3 = this.j.a();
            int g2 = this.j.g();
            if ((Gravity.getAbsoluteGravity(this.u, y.m(this.n)) & 7) == 5) {
                a3 += this.n.getWidth();
            }
            if (sVar.a(a3, g2)) {
                t.a aVar = this.p;
                if (aVar == null) {
                    return true;
                }
                aVar.a(a2);
                return true;
            }
        }
        return false;
    }

    public void a(k kVar, boolean z) {
        if (kVar == this.d) {
            dismiss();
            t.a aVar = this.p;
            if (aVar != null) {
                aVar.a(kVar, z);
            }
        }
    }

    public void a(View view) {
        this.n = view;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }
}
