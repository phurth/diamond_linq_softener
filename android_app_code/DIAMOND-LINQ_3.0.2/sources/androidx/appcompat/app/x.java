package androidx.appcompat.app;

import a.a.d.b;
import a.a.d.f;
import a.a.j;
import a.g.i.C0040d;
import a.g.i.C0041e;
import a.g.i.E;
import a.g.i.F;
import a.g.i.q;
import a.g.i.y;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.view.menu.u;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.C0116q;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Ma;
import androidx.appcompat.widget.Na;
import androidx.appcompat.widget.P;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.U;
import androidx.appcompat.widget.za;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

class x extends o implements k.a, LayoutInflater.Factory2 {

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<?>, Integer> f432b = new a.d.b();
    private static final boolean c = (Build.VERSION.SDK_INT < 21);
    private static final int[] d = {16842836};
    private static boolean e = true;
    private boolean A;
    private boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    private boolean H;
    private h[] I;
    private h J;
    private boolean K;
    private boolean L;
    private boolean M;
    boolean N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private e S;
    private e T;
    boolean U;
    int V;
    private final Runnable W;
    private boolean X;
    private Rect Y;
    private Rect Z;
    private AppCompatViewInflater aa;
    final Object f;
    final Context g;
    Window h;
    private c i;
    final n j;
    C0071a k;
    MenuInflater l;
    private CharSequence m;
    private P n;
    private a o;
    private i p;
    a.a.d.b q;
    ActionBarContextView r;
    PopupWindow s;
    Runnable t;
    E u;
    private boolean v;
    private boolean w;
    private ViewGroup x;
    private TextView y;
    private View z;

    class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private b.a f434a;

        public b(b.a aVar) {
            this.f434a = aVar;
        }

        public boolean a(a.a.d.b bVar, Menu menu) {
            return this.f434a.a(bVar, menu);
        }

        public boolean b(a.a.d.b bVar, Menu menu) {
            return this.f434a.b(bVar, menu);
        }

        public boolean a(a.a.d.b bVar, MenuItem menuItem) {
            return this.f434a.a(bVar, menuItem);
        }

        public void a(a.a.d.b bVar) {
            this.f434a.a(bVar);
            x xVar = x.this;
            if (xVar.s != null) {
                xVar.h.getDecorView().removeCallbacks(x.this.t);
            }
            x xVar2 = x.this;
            if (xVar2.r != null) {
                xVar2.m();
                x xVar3 = x.this;
                E a2 = y.a(xVar3.r);
                a2.a(0.0f);
                xVar3.u = a2;
                x.this.u.a((F) new y(this));
            }
            x xVar4 = x.this;
            n nVar = xVar4.j;
            if (nVar != null) {
                nVar.b(xVar4.q);
            }
            x.this.q = null;
        }
    }

    private class d extends e {
        private final PowerManager c;

        d(Context context) {
            super();
            this.c = (PowerManager) context.getSystemService("power");
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        public int c() {
            if (Build.VERSION.SDK_INT < 21 || !this.c.isPowerSaveMode()) {
                return 1;
            }
            return 2;
        }

        public void d() {
            x.this.k();
        }
    }

    abstract class e {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f437a;

        e() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.f437a;
            if (broadcastReceiver != null) {
                x.this.g.unregisterReceiver(broadcastReceiver);
                this.f437a = null;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract IntentFilter b();

        /* access modifiers changed from: package-private */
        public abstract int c();

        /* access modifiers changed from: package-private */
        public abstract void d();

        /* access modifiers changed from: package-private */
        public void e() {
            a();
            IntentFilter b2 = b();
            if (b2 != null && b2.countActions() != 0) {
                if (this.f437a == null) {
                    this.f437a = new z(this);
                }
                x.this.g.registerReceiver(this.f437a, b2);
            }
        }
    }

    private class f extends e {
        private final H c;

        f(H h) {
            super();
            this.c = h;
        }

        /* access modifiers changed from: package-private */
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        public int c() {
            return this.c.a() ? 2 : 1;
        }

        public void d() {
            x.this.k();
        }
    }

    private class g extends ContentFrameLayout {
        public g(Context context) {
            super(context);
        }

        private boolean a(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return x.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            x.this.e(0);
            return true;
        }

        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(a.a.a.a.a.b(getContext(), i2));
        }
    }

    static {
        if (c && !e) {
            Thread.setDefaultUncaughtExceptionHandler(new p(Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    x(Activity activity, n nVar) {
        this(activity, (Window) null, nVar, activity);
    }

    private e A() {
        if (this.T == null) {
            this.T = new d(this.g);
        }
        return this.T;
    }

    private void B() {
        y();
        if (this.C && this.k == null) {
            Object obj = this.f;
            if (obj instanceof Activity) {
                this.k = new L((Activity) obj, this.D);
            } else if (obj instanceof Dialog) {
                this.k = new L((Dialog) obj);
            }
            C0071a aVar = this.k;
            if (aVar != null) {
                aVar.c(this.X);
            }
        }
    }

    private boolean C() {
        if (!this.R && (this.f instanceof Activity)) {
            try {
                this.Q = (this.g.getPackageManager().getActivityInfo(new ComponentName(this.g, this.f.getClass()), 0).configChanges & 512) != 0;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.Q = false;
            }
        }
        this.R = true;
        return this.Q;
    }

    private void D() {
        if (this.w) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private m E() {
        Context context = this.g;
        while (context != null) {
            if (!(context instanceof m)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (m) context;
            }
        }
        return null;
    }

    private void k(int i2) {
        this.V = (1 << i2) | this.V;
        if (!this.U) {
            y.a(this.h.getDecorView(), this.W);
            this.U = true;
        }
    }

    private int l(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private void v() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.x.findViewById(16908290);
        View decorView = this.h.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.g.obtainStyledAttributes(j.AppCompatTheme);
        obtainStyledAttributes.getValue(j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private int w() {
        int i2 = this.O;
        return i2 != -100 ? i2 : o.a();
    }

    private ViewGroup x() {
        ViewGroup viewGroup;
        Context context;
        TypedArray obtainStyledAttributes = this.g.obtainStyledAttributes(j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(j.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowNoTitle, false)) {
                b(1);
            } else if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowActionBar, false)) {
                b(108);
            }
            if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowActionBarOverlay, false)) {
                b(109);
            }
            if (obtainStyledAttributes.getBoolean(j.AppCompatTheme_windowActionModeOverlay, false)) {
                b(10);
            }
            this.F = obtainStyledAttributes.getBoolean(j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            z();
            this.h.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.g);
            if (this.G) {
                if (this.E) {
                    viewGroup = (ViewGroup) from.inflate(a.a.g.abc_screen_simple_overlay_action_mode, (ViewGroup) null);
                } else {
                    viewGroup = (ViewGroup) from.inflate(a.a.g.abc_screen_simple, (ViewGroup) null);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    y.a((View) viewGroup, (q) new r(this));
                } else {
                    ((U) viewGroup).setOnFitSystemWindowsListener(new s(this));
                }
            } else if (this.F) {
                viewGroup = (ViewGroup) from.inflate(a.a.g.abc_dialog_title_material, (ViewGroup) null);
                this.D = false;
                this.C = false;
            } else if (this.C) {
                TypedValue typedValue = new TypedValue();
                this.g.getTheme().resolveAttribute(a.a.a.actionBarTheme, typedValue, true);
                int i2 = typedValue.resourceId;
                if (i2 != 0) {
                    context = new a.a.d.d(this.g, i2);
                } else {
                    context = this.g;
                }
                viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a.a.g.abc_screen_toolbar, (ViewGroup) null);
                this.n = (P) viewGroup.findViewById(a.a.f.decor_content_parent);
                this.n.setWindowCallback(q());
                if (this.D) {
                    this.n.a(109);
                }
                if (this.A) {
                    this.n.a(2);
                }
                if (this.B) {
                    this.n.a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (this.n == null) {
                    this.y = (TextView) viewGroup.findViewById(a.a.f.title);
                }
                Na.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(a.a.f.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.h.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.h.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new t(this));
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.C + ", windowActionBarOverlay: " + this.D + ", android:windowIsFloating: " + this.F + ", windowActionModeOverlay: " + this.E + ", windowNoTitle: " + this.G + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void y() {
        if (!this.w) {
            this.x = x();
            CharSequence p2 = p();
            if (!TextUtils.isEmpty(p2)) {
                P p3 = this.n;
                if (p3 != null) {
                    p3.setWindowTitle(p2);
                } else if (t() != null) {
                    t().b(p2);
                } else {
                    TextView textView = this.y;
                    if (textView != null) {
                        textView.setText(p2);
                    }
                }
            }
            v();
            a(this.x);
            this.w = true;
            h a2 = a(0, false);
            if (this.N) {
                return;
            }
            if (a2 == null || a2.j == null) {
                k(108);
            }
        }
    }

    private void z() {
        if (this.h == null) {
            Object obj = this.f;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.h == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public void a(Context context) {
        k();
        this.L = true;
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
    }

    public void b(Bundle bundle) {
        y();
    }

    public MenuInflater c() {
        if (this.l == null) {
            B();
            C0071a aVar = this.k;
            this.l = new a.a.d.g(aVar != null ? aVar.h() : this.g);
        }
        return this.l;
    }

    public C0071a d() {
        B();
        return this.k;
    }

    public void e() {
        LayoutInflater from = LayoutInflater.from(this.g);
        if (from.getFactory() == null) {
            C0041e.a(from, this);
        } else if (!(from.getFactory2() instanceof x)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void f() {
        C0071a d2 = d();
        if (d2 == null || !d2.i()) {
            k(0);
        }
    }

    public void g() {
        if (this.U) {
            this.h.getDecorView().removeCallbacks(this.W);
        }
        this.N = true;
        C0071a aVar = this.k;
        if (aVar != null) {
            aVar.j();
        }
        e eVar = this.S;
        if (eVar != null) {
            eVar.a();
        }
        e eVar2 = this.T;
        if (eVar2 != null) {
            eVar2.a();
        }
    }

    public void h() {
        C0071a d2 = d();
        if (d2 != null) {
            d2.e(true);
        }
    }

    public void i() {
        k();
    }

    public void j() {
        C0071a d2 = d();
        if (d2 != null) {
            d2.e(false);
        }
        e eVar = this.S;
        if (eVar != null) {
            eVar.a();
        }
        e eVar2 = this.T;
        if (eVar2 != null) {
            eVar2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        E e2 = this.u;
        if (e2 != null) {
            e2.a();
        }
    }

    /* access modifiers changed from: package-private */
    public final Context n() {
        C0071a d2 = d();
        Context h2 = d2 != null ? d2.h() : null;
        return h2 == null ? this.g : h2;
    }

    /* access modifiers changed from: package-private */
    public final e o() {
        if (this.S == null) {
            this.S = new f(H.a(this.g));
        }
        return this.S;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public final CharSequence p() {
        Object obj = this.f;
        if (obj instanceof Activity) {
            return ((Activity) obj).getTitle();
        }
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback q() {
        return this.h.getCallback();
    }

    public boolean r() {
        return this.v;
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        a.a.d.b bVar = this.q;
        if (bVar != null) {
            bVar.a();
            return true;
        }
        C0071a d2 = d();
        if (d2 == null || !d2.f()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final C0071a t() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.x;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u() {
        /*
            r1 = this;
            boolean r0 = r1.w
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.x
            if (r0 == 0) goto L_0x0010
            boolean r0 = a.g.i.y.A(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.x.u():boolean");
    }

    private final class a implements t.a {
        a() {
        }

        public boolean a(k kVar) {
            Window.Callback q = x.this.q();
            if (q == null) {
                return true;
            }
            q.onMenuOpened(108, kVar);
            return true;
        }

        public void a(k kVar, boolean z) {
            x.this.b(kVar);
        }
    }

    x(Dialog dialog, n nVar) {
        this(dialog.getContext(), dialog.getWindow(), nVar, dialog);
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.x.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.i.a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public void i(int i2) {
        if (i2 == 108) {
            C0071a d2 = d();
            if (d2 != null) {
                d2.b(false);
            }
        } else if (i2 == 0) {
            h a2 = a(i2, true);
            if (a2.o) {
                a(a2, false);
            }
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    protected static final class h {

        /* renamed from: a  reason: collision with root package name */
        int f439a;

        /* renamed from: b  reason: collision with root package name */
        int f440b;
        int c;
        int d;
        int e;
        int f;
        ViewGroup g;
        View h;
        View i;
        k j;
        androidx.appcompat.view.menu.i k;
        Context l;
        boolean m;
        boolean n;
        boolean o;
        public boolean p;
        boolean q = false;
        boolean r;
        Bundle s;

        h(int i2) {
            this.f439a = i2;
        }

        public boolean a() {
            if (this.h == null) {
                return false;
            }
            if (this.i == null && this.k.c().getCount() <= 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(a.a.a.actionBarPopupTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            }
            newTheme.resolveAttribute(a.a.a.panelMenuListTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                newTheme.applyStyle(i3, true);
            } else {
                newTheme.applyStyle(a.a.i.Theme_AppCompat_CompactMenu, true);
            }
            a.a.d.d dVar = new a.a.d.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(j.AppCompatTheme);
            this.f440b = obtainStyledAttributes.getResourceId(j.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(k kVar) {
            androidx.appcompat.view.menu.i iVar;
            k kVar2 = this.j;
            if (kVar != kVar2) {
                if (kVar2 != null) {
                    kVar2.b((t) this.k);
                }
                this.j = kVar;
                if (kVar != null && (iVar = this.k) != null) {
                    kVar.a((t) iVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public u a(t.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                this.k = new androidx.appcompat.view.menu.i(this.l, a.a.g.abc_list_menu_item_layout);
                this.k.a(aVar);
                this.j.a((t) this.k);
            }
            return this.k.a(this.g);
        }
    }

    private x(Context context, Window window, n nVar, Object obj) {
        Integer num;
        m E2;
        this.u = null;
        this.v = true;
        this.O = -100;
        this.W = new q(this);
        this.g = context;
        this.j = nVar;
        this.f = obj;
        if (window != null) {
            a(window);
        }
        if (this.O == -100 && (this.f instanceof Dialog) && (E2 = E()) != null) {
            this.O = E2.v().b();
        }
        if (this.O == -100 && (num = f432b.get(this.f.getClass())) != null) {
            this.O = num.intValue();
            f432b.remove(this.f.getClass());
        }
        C0116q.c();
    }

    private void m(int i2) {
        Resources resources = this.g.getResources();
        Configuration configuration = new Configuration();
        configuration.uiMode = i2 | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            C.a(resources);
        }
        int i3 = this.P;
        if (i3 != 0) {
            this.g.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.g.getTheme().applyStyle(this.P, true);
            }
        }
    }

    public void a(Bundle bundle) {
        String str;
        this.L = true;
        z();
        Object obj = this.f;
        if (obj instanceof Activity) {
            try {
                str = androidx.core.app.h.b((Activity) obj);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                C0071a t2 = t();
                if (t2 == null) {
                    this.X = true;
                } else {
                    t2.c(true);
                }
            }
        }
        k();
        za a2 = za.a(this.g, (AttributeSet) null, d);
        Drawable c2 = a2.c(0);
        if (c2 != null) {
            this.h.setBackgroundDrawable(c2);
        }
        a2.a();
        this.M = true;
    }

    public void d(int i2) {
        this.P = i2;
    }

    /* access modifiers changed from: package-private */
    public void h(int i2) {
        C0071a d2;
        if (i2 == 108 && (d2 = d()) != null) {
            d2.b(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        k kVar;
        P p2 = this.n;
        if (p2 != null) {
            p2.g();
        }
        if (this.s != null) {
            this.h.getDecorView().removeCallbacks(this.t);
            if (this.s.isShowing()) {
                try {
                    this.s.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.s = null;
        }
        m();
        h a2 = a(0, false);
        if (a2 != null && (kVar = a2.j) != null) {
            kVar.close();
        }
    }

    class c extends a.a.d.j {
        c(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(x.this.g, callback);
            a.a.d.b a2 = x.this.a((b.a) aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return x.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || x.this.b(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof k)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            x.this.h(i);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            x.this.i(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            k kVar = menu instanceof k ? (k) menu : null;
            if (i == 0 && kVar == null) {
                return false;
            }
            if (kVar != null) {
                kVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (kVar != null) {
                kVar.c(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            k kVar;
            h a2 = x.this.a(0, true);
            if (a2 == null || (kVar = a2.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, kVar, i);
            }
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            if (x.this.r()) {
                return a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (!x.this.r() || i != 0) {
                return super.onWindowStartingActionMode(callback, i);
            }
            return a(callback);
        }
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        h a2 = a(i2, true);
        if (!a2.o) {
            return b(a2, keyEvent);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        h a2;
        h a3 = a(i2, true);
        if (a3.j != null) {
            Bundle bundle = new Bundle();
            a3.j.c(bundle);
            if (bundle.size() > 0) {
                a3.s = bundle;
            }
            a3.j.s();
            a3.j.clear();
        }
        a3.r = true;
        a3.q = true;
        if ((i2 == 108 || i2 == 0) && this.n != null && (a2 = a(0, false)) != null) {
            a2.m = false;
            b(a2, (KeyEvent) null);
        }
    }

    private final class i implements t.a {
        i() {
        }

        public void a(k kVar, boolean z) {
            k m = kVar.m();
            boolean z2 = m != kVar;
            x xVar = x.this;
            if (z2) {
                kVar = m;
            }
            h a2 = xVar.a((Menu) kVar);
            if (a2 == null) {
                return;
            }
            if (z2) {
                x.this.a(a2.f439a, a2, m);
                x.this.a(a2, true);
                return;
            }
            x.this.a(a2, z);
        }

        public boolean a(k kVar) {
            Window.Callback q;
            if (kVar != null) {
                return true;
            }
            x xVar = x.this;
            if (!xVar.C || (q = xVar.q()) == null || x.this.N) {
                return true;
            }
            q.onMenuOpened(108, kVar);
            return true;
        }
    }

    public boolean k() {
        return b(true);
    }

    public void c(int i2) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.x.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.g).inflate(i2, viewGroup);
        this.i.a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        a(a(i2, true), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            a.a.d.b r0 = r3.q
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.x$h r2 = r3.a((int) r4, (boolean) r0)
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.P r4 = r3.n
            if (r4 == 0) goto L_0x0043
            boolean r4 = r4.c()
            if (r4 == 0) goto L_0x0043
            android.content.Context r4 = r3.g
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.P r4 = r3.n
            boolean r4 = r4.a()
            if (r4 != 0) goto L_0x003c
            boolean r4 = r3.N
            if (r4 != 0) goto L_0x0063
            boolean r4 = r3.b((androidx.appcompat.app.x.h) r2, (android.view.KeyEvent) r5)
            if (r4 == 0) goto L_0x0063
            androidx.appcompat.widget.P r4 = r3.n
            boolean r4 = r4.f()
            goto L_0x006a
        L_0x003c:
            androidx.appcompat.widget.P r4 = r3.n
            boolean r4 = r4.e()
            goto L_0x006a
        L_0x0043:
            boolean r4 = r2.o
            if (r4 != 0) goto L_0x0065
            boolean r4 = r2.n
            if (r4 == 0) goto L_0x004c
            goto L_0x0065
        L_0x004c:
            boolean r4 = r2.m
            if (r4 == 0) goto L_0x0063
            boolean r4 = r2.r
            if (r4 == 0) goto L_0x005b
            r2.m = r1
            boolean r4 = r3.b((androidx.appcompat.app.x.h) r2, (android.view.KeyEvent) r5)
            goto L_0x005c
        L_0x005b:
            r4 = 1
        L_0x005c:
            if (r4 == 0) goto L_0x0063
            r3.a((androidx.appcompat.app.x.h) r2, (android.view.KeyEvent) r5)
            r4 = 1
            goto L_0x006a
        L_0x0063:
            r4 = 0
            goto L_0x006a
        L_0x0065:
            boolean r4 = r2.o
            r3.a((androidx.appcompat.app.x.h) r2, (boolean) r0)
        L_0x006a:
            if (r4 == 0) goto L_0x0083
            android.content.Context r5 = r3.g
            java.lang.String r0 = "audio"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.media.AudioManager r5 = (android.media.AudioManager) r5
            if (r5 == 0) goto L_0x007c
            r5.playSoundEffect(r1)
            goto L_0x0083
        L_0x007c:
            java.lang.String r5 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r5, r0)
        L_0x0083:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.x.e(int, android.view.KeyEvent):boolean");
    }

    public boolean b(int i2) {
        int l2 = l(i2);
        if (this.G && l2 == 108) {
            return false;
        }
        if (this.C && l2 == 1) {
            this.C = false;
        }
        if (l2 == 1) {
            D();
            this.G = true;
            return true;
        } else if (l2 == 2) {
            D();
            this.A = true;
            return true;
        } else if (l2 == 5) {
            D();
            this.B = true;
            return true;
        } else if (l2 == 10) {
            D();
            this.E = true;
            return true;
        } else if (l2 == 108) {
            D();
            this.C = true;
            return true;
        } else if (l2 != 109) {
            return this.h.requestFeature(l2);
        } else {
            D();
            this.D = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public int j(int i2) {
        boolean z2;
        boolean z3;
        boolean z4;
        ActionBarContextView actionBarContextView = this.r;
        int i3 = 0;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.r.getLayoutParams();
            z2 = true;
            if (this.r.isShown()) {
                if (this.Y == null) {
                    this.Y = new Rect();
                    this.Z = new Rect();
                }
                Rect rect = this.Y;
                Rect rect2 = this.Z;
                rect.set(0, i2, 0, 0);
                Na.a(this.x, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i2 : 0)) {
                    marginLayoutParams.topMargin = i2;
                    View view = this.z;
                    if (view == null) {
                        this.z = new View(this.g);
                        this.z.setBackgroundColor(this.g.getResources().getColor(a.a.c.abc_input_method_navigation_guard));
                        this.x.addView(this.z, -1, new ViewGroup.LayoutParams(-1, i2));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        if (layoutParams.height != i2) {
                            layoutParams.height = i2;
                            this.z.setLayoutParams(layoutParams);
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.z == null) {
                    z2 = false;
                }
                if (!this.E && z2) {
                    i2 = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z4 = true;
                } else {
                    z4 = false;
                }
                z2 = false;
            }
            if (z3) {
                this.r.setLayoutParams(marginLayoutParams);
            }
        }
        View view2 = this.z;
        if (view2 != null) {
            if (!z2) {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public int g(int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 == -1) {
            return i2;
        }
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return i2;
            }
            if (i2 == 3) {
                return A().c();
            }
            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
        } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) this.g.getSystemService(UiModeManager.class)).getNightMode() != 0) {
            return o().c();
        } else {
            return -1;
        }
    }

    public void c(Bundle bundle) {
        if (this.O != -100) {
            f432b.put(this.f.getClass(), Integer.valueOf(this.O));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.K;
            this.K = false;
            h a2 = a(0, false);
            if (a2 != null && a2.o) {
                if (!z2) {
                    a(a2, true);
                }
                return true;
            } else if (s()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    public void a(Toolbar toolbar) {
        if (this.f instanceof Activity) {
            C0071a d2 = d();
            if (!(d2 instanceof L)) {
                this.l = null;
                if (d2 != null) {
                    d2.j();
                }
                if (toolbar != null) {
                    F f2 = new F(toolbar, p(), this.i);
                    this.k = f2;
                    this.h.setCallback(f2.l());
                } else {
                    this.k = null;
                    this.h.setCallback(this.i);
                }
                f();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    private boolean c(h hVar) {
        Context context = this.g;
        int i2 = hVar.f439a;
        if ((i2 == 0 || i2 == 108) && this.n != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(a.a.a.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(a.a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(a.a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                a.a.d.d dVar = new a.a.d.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        k kVar = new k(context);
        kVar.a((k.a) this);
        hVar.a(kVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a.a.d.b b(a.a.d.b.a r8) {
        /*
            r7 = this;
            r7.m()
            a.a.d.b r0 = r7.q
            if (r0 == 0) goto L_0x000a
            r0.a()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.x.b
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.x$b r0 = new androidx.appcompat.app.x$b
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.n r0 = r7.j
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.N
            if (r2 != 0) goto L_0x0022
            a.a.d.b r0 = r0.a((a.a.d.b.a) r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.q = r0
            goto L_0x0165
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.r
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d6
            boolean r0 = r7.F
            if (r0 == 0) goto L_0x00b7
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.g
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = a.a.a.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.g
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            a.a.d.d r4 = new a.a.d.d
            android.content.Context r6 = r7.g
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.g
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.r = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = a.a.a.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.s = r5
            android.widget.PopupWindow r5 = r7.s
            r6 = 2
            androidx.core.widget.i.a((android.widget.PopupWindow) r5, (int) r6)
            android.widget.PopupWindow r5 = r7.s
            androidx.appcompat.widget.ActionBarContextView r6 = r7.r
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.s
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = a.a.a.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.r
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.s
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.v r0 = new androidx.appcompat.app.v
            r0.<init>(r7)
            r7.t = r0
            goto L_0x00d6
        L_0x00b7:
            android.view.ViewGroup r0 = r7.x
            int r4 = a.a.f.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d6
            android.content.Context r4 = r7.n()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.r = r0
        L_0x00d6:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.r
            if (r0 == 0) goto L_0x0165
            r7.m()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.r
            r0.c()
            a.a.d.e r0 = new a.a.d.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.r
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.r
            android.widget.PopupWindow r6 = r7.s
            if (r6 != 0) goto L_0x00f1
            goto L_0x00f2
        L_0x00f1:
            r3 = 0
        L_0x00f2:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.c()
            boolean r8 = r8.a((a.a.d.b) r0, (android.view.Menu) r3)
            if (r8 == 0) goto L_0x0163
            r0.i()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.r
            r8.a(r0)
            r7.q = r0
            boolean r8 = r7.u()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012d
            androidx.appcompat.widget.ActionBarContextView r8 = r7.r
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.r
            a.g.i.E r8 = a.g.i.y.a(r8)
            r8.a((float) r0)
            r7.u = r8
            a.g.i.E r8 = r7.u
            androidx.appcompat.app.w r0 = new androidx.appcompat.app.w
            r0.<init>(r7)
            r8.a((a.g.i.F) r0)
            goto L_0x0153
        L_0x012d:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.r
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.r
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.r
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.r
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0153
            androidx.appcompat.widget.ActionBarContextView r8 = r7.r
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            a.g.i.y.F(r8)
        L_0x0153:
            android.widget.PopupWindow r8 = r7.s
            if (r8 == 0) goto L_0x0165
            android.view.Window r8 = r7.h
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.t
            r8.post(r0)
            goto L_0x0165
        L_0x0163:
            r7.q = r1
        L_0x0165:
            a.a.d.b r8 = r7.q
            if (r8 == 0) goto L_0x0170
            androidx.appcompat.app.n r0 = r7.j
            if (r0 == 0) goto L_0x0170
            r0.a((a.a.d.b) r8)
        L_0x0170:
            a.a.d.b r8 = r7.q
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.x.b(a.a.d.b$a):a.a.d.b");
    }

    public <T extends View> T a(int i2) {
        y();
        return this.h.findViewById(i2);
    }

    public void a(Configuration configuration) {
        C0071a d2;
        if (this.C && this.w && (d2 = d()) != null) {
            d2.a(configuration);
        }
        C0116q.b().a(this.g);
        b(false);
    }

    public void a(View view) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.x.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.i.a().onContentChanged();
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        y();
        ((ViewGroup) this.x.findViewById(16908290)).addView(view, layoutParams);
        this.i.a().onContentChanged();
    }

    private void a(Window window) {
        if (this.h == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof c)) {
                this.i = new c(callback);
                window.setCallback(this.i);
                this.h = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final void a(CharSequence charSequence) {
        this.m = charSequence;
        P p2 = this.n;
        if (p2 != null) {
            p2.setWindowTitle(charSequence);
        } else if (t() != null) {
            t().b(charSequence);
        } else {
            TextView textView = this.y;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    public boolean a(k kVar, MenuItem menuItem) {
        h a2;
        Window.Callback q2 = q();
        if (q2 == null || this.N || (a2 = a((Menu) kVar.m())) == null) {
            return false;
        }
        return q2.onMenuItemSelected(a2.f439a, menuItem);
    }

    public void a(k kVar) {
        a(kVar, true);
    }

    public a.a.d.b a(b.a aVar) {
        n nVar;
        if (aVar != null) {
            a.a.d.b bVar = this.q;
            if (bVar != null) {
                bVar.a();
            }
            b bVar2 = new b(aVar);
            C0071a d2 = d();
            if (d2 != null) {
                this.q = d2.a((b.a) bVar2);
                a.a.d.b bVar3 = this.q;
                if (!(bVar3 == null || (nVar = this.j) == null)) {
                    nVar.a(bVar3);
                }
            }
            if (this.q == null) {
                this.q = b((b.a) bVar2);
            }
            return this.q;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f;
        boolean z2 = true;
        if (((obj instanceof C0040d.a) || (obj instanceof B)) && (decorView = this.h.getDecorView()) != null && C0040d.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.i.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? a(keyCode, keyEvent) : c(keyCode, keyEvent);
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.K = z2;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, KeyEvent keyEvent) {
        C0071a d2 = d();
        if (d2 != null && d2.a(i2, keyEvent)) {
            return true;
        }
        h hVar = this.J;
        if (hVar == null || !a(hVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.J == null) {
                h a2 = a(0, true);
                b(a2, keyEvent);
                boolean a3 = a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        }
        h hVar2 = this.J;
        if (hVar2 != null) {
            hVar2.n = true;
        }
        return true;
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        boolean z3 = false;
        if (this.aa == null) {
            String string = this.g.obtainStyledAttributes(j.AppCompatTheme).getString(j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                this.aa = new AppCompatViewInflater();
            } else {
                try {
                    this.aa = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.aa = new AppCompatViewInflater();
                }
            }
        }
        if (c) {
            if (!(attributeSet instanceof XmlPullParser)) {
                z3 = a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        return this.aa.createView(view, str, context, attributeSet, z2, c, true, Ma.b());
    }

    private boolean b(h hVar) {
        hVar.a(n());
        hVar.g = new g(hVar.l);
        hVar.c = 81;
        return true;
    }

    private boolean b(h hVar, KeyEvent keyEvent) {
        P p2;
        P p3;
        P p4;
        if (this.N) {
            return false;
        }
        if (hVar.m) {
            return true;
        }
        h hVar2 = this.J;
        if (!(hVar2 == null || hVar2 == hVar)) {
            a(hVar2, false);
        }
        Window.Callback q2 = q();
        if (q2 != null) {
            hVar.i = q2.onCreatePanelView(hVar.f439a);
        }
        int i2 = hVar.f439a;
        boolean z2 = i2 == 0 || i2 == 108;
        if (z2 && (p4 = this.n) != null) {
            p4.b();
        }
        if (hVar.i == null && (!z2 || !(t() instanceof F))) {
            if (hVar.j == null || hVar.r) {
                if (hVar.j == null && (!c(hVar) || hVar.j == null)) {
                    return false;
                }
                if (z2 && this.n != null) {
                    if (this.o == null) {
                        this.o = new a();
                    }
                    this.n.a(hVar.j, this.o);
                }
                hVar.j.s();
                if (!q2.onCreatePanelMenu(hVar.f439a, hVar.j)) {
                    hVar.a((k) null);
                    if (z2 && (p3 = this.n) != null) {
                        p3.a((Menu) null, this.o);
                    }
                    return false;
                }
                hVar.r = false;
            }
            hVar.j.s();
            Bundle bundle = hVar.s;
            if (bundle != null) {
                hVar.j.a(bundle);
                hVar.s = null;
            }
            if (!q2.onPreparePanel(0, hVar.i, hVar.j)) {
                if (z2 && (p2 = this.n) != null) {
                    p2.a((Menu) null, this.o);
                }
                hVar.j.r();
                return false;
            }
            hVar.p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            hVar.j.setQwertyMode(hVar.p);
            hVar.j.r();
        }
        hVar.m = true;
        hVar.n = false;
        this.J = hVar;
        return true;
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.h.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || y.z((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void a(h hVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (!hVar.o && !this.N) {
            if (hVar.f439a == 0) {
                if ((this.g.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback q2 = q();
            if (q2 == null || q2.onMenuOpened(hVar.f439a, hVar.j)) {
                WindowManager windowManager = (WindowManager) this.g.getSystemService("window");
                if (windowManager != null && b(hVar, keyEvent)) {
                    if (hVar.g == null || hVar.q) {
                        ViewGroup viewGroup = hVar.g;
                        if (viewGroup == null) {
                            if (!b(hVar) || hVar.g == null) {
                                return;
                            }
                        } else if (hVar.q && viewGroup.getChildCount() > 0) {
                            hVar.g.removeAllViews();
                        }
                        if (a(hVar) && hVar.a()) {
                            ViewGroup.LayoutParams layoutParams2 = hVar.h.getLayoutParams();
                            if (layoutParams2 == null) {
                                layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                            }
                            hVar.g.setBackgroundResource(hVar.f440b);
                            ViewParent parent = hVar.h.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(hVar.h);
                            }
                            hVar.g.addView(hVar.h, layoutParams2);
                            if (!hVar.h.hasFocus()) {
                                hVar.h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else {
                        View view = hVar.i;
                        if (!(view == null || (layoutParams = view.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i2 = -1;
                            hVar.n = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, hVar.d, hVar.e, 1002, 8519680, -3);
                            layoutParams3.gravity = hVar.c;
                            layoutParams3.windowAnimations = hVar.f;
                            windowManager.addView(hVar.g, layoutParams3);
                            hVar.o = true;
                            return;
                        }
                    }
                    i2 = -2;
                    hVar.n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, hVar.d, hVar.e, 1002, 8519680, -3);
                    layoutParams32.gravity = hVar.c;
                    layoutParams32.windowAnimations = hVar.f;
                    windowManager.addView(hVar.g, layoutParams32);
                    hVar.o = true;
                    return;
                }
                return;
            }
            a(hVar, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(k kVar) {
        if (!this.H) {
            this.H = true;
            this.n.g();
            Window.Callback q2 = q();
            if (q2 != null && !this.N) {
                q2.onPanelClosed(108, kVar);
            }
            this.H = false;
        }
    }

    private void a(k kVar, boolean z2) {
        P p2 = this.n;
        if (p2 == null || !p2.c() || (ViewConfiguration.get(this.g).hasPermanentMenuKey() && !this.n.d())) {
            h a2 = a(0, true);
            a2.q = true;
            a(a2, false);
            a(a2, (KeyEvent) null);
            return;
        }
        Window.Callback q2 = q();
        if (this.n.a() && z2) {
            this.n.e();
            if (!this.N) {
                q2.onPanelClosed(108, a(0, true).j);
            }
        } else if (q2 != null && !this.N) {
            if (this.U && (this.V & 1) != 0) {
                this.h.getDecorView().removeCallbacks(this.W);
                this.W.run();
            }
            h a3 = a(0, true);
            k kVar2 = a3.j;
            if (kVar2 != null && !a3.r && q2.onPreparePanel(0, a3.i, kVar2)) {
                q2.onMenuOpened(108, a3.j);
                this.n.f();
            }
        }
    }

    private boolean b(boolean z2) {
        int w2 = w();
        boolean b2 = b(g(w2), z2);
        if (w2 == 0) {
            o().e();
        } else if (w2 == 3) {
            A().e();
        }
        return b2;
    }

    public int b() {
        return this.O;
    }

    private boolean b(int i2, boolean z2) {
        int i3 = this.g.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        int i4 = i2 != 1 ? i2 != 2 ? i3 : 32 : 16;
        boolean C2 = C();
        boolean z3 = false;
        if (i4 != i3 && !C2 && Build.VERSION.SDK_INT >= 17 && !this.L && (this.f instanceof ContextThemeWrapper)) {
            Configuration configuration = new Configuration();
            configuration.uiMode = (configuration.uiMode & -49) | i4;
            try {
                ((ContextThemeWrapper) this.f).applyOverrideConfiguration(configuration);
                z3 = true;
            } catch (IllegalStateException unused) {
            }
        }
        if (!z3 && !C2 && (this.g.getResources().getConfiguration().uiMode & 48) != i4) {
            if (z2 && (Build.VERSION.SDK_INT >= 17 || this.M)) {
                Object obj = this.f;
                if (obj instanceof Activity) {
                    androidx.core.app.a.b((Activity) obj);
                    z3 = true;
                }
            }
            if (!z3) {
                m(i4);
                z3 = true;
            }
        }
        if (z3 || C2) {
            Object obj2 = this.f;
            if (obj2 instanceof m) {
                ((m) obj2).b(i2);
            }
        }
        return z3;
    }

    private boolean a(h hVar) {
        View view = hVar.i;
        if (view != null) {
            hVar.h = view;
            return true;
        } else if (hVar.j == null) {
            return false;
        } else {
            if (this.p == null) {
                this.p = new i();
            }
            hVar.h = (View) hVar.a((t.a) this.p);
            if (hVar.h != null) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar, boolean z2) {
        ViewGroup viewGroup;
        P p2;
        if (!z2 || hVar.f439a != 0 || (p2 = this.n) == null || !p2.a()) {
            WindowManager windowManager = (WindowManager) this.g.getSystemService("window");
            if (!(windowManager == null || !hVar.o || (viewGroup = hVar.g) == null)) {
                windowManager.removeView(viewGroup);
                if (z2) {
                    a(hVar.f439a, hVar, (Menu) null);
                }
            }
            hVar.m = false;
            hVar.n = false;
            hVar.o = false;
            hVar.h = null;
            hVar.q = true;
            if (this.J == hVar) {
                this.J = null;
                return;
            }
            return;
        }
        b(hVar.j);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, h hVar, Menu menu) {
        if (menu == null) {
            if (hVar == null && i2 >= 0) {
                h[] hVarArr = this.I;
                if (i2 < hVarArr.length) {
                    hVar = hVarArr[i2];
                }
            }
            if (hVar != null) {
                menu = hVar.j;
            }
        }
        if ((hVar == null || hVar.o) && !this.N) {
            this.i.a().onPanelClosed(i2, menu);
        }
    }

    /* access modifiers changed from: package-private */
    public h a(Menu menu) {
        h[] hVarArr = this.I;
        int length = hVarArr != null ? hVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            h hVar = hVarArr[i2];
            if (hVar != null && hVar.j == menu) {
                return hVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public h a(int i2, boolean z2) {
        h[] hVarArr = this.I;
        if (hVarArr == null || hVarArr.length <= i2) {
            h[] hVarArr2 = new h[(i2 + 1)];
            if (hVarArr != null) {
                System.arraycopy(hVarArr, 0, hVarArr2, 0, hVarArr.length);
            }
            this.I = hVarArr2;
            hVarArr = hVarArr2;
        }
        h hVar = hVarArr[i2];
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(i2);
        hVarArr[i2] = hVar2;
        return hVar2;
    }

    private boolean a(h hVar, int i2, KeyEvent keyEvent, int i3) {
        k kVar;
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((hVar.m || b(hVar, keyEvent)) && (kVar = hVar.j) != null) {
            z2 = kVar.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.n == null) {
            a(hVar, true);
        }
        return z2;
    }
}
