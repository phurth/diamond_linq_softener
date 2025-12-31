package androidx.appcompat.widget;

import a.g.i.y;
import a.g.i.z;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

class Ka implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private static Ka f530a;

    /* renamed from: b  reason: collision with root package name */
    private static Ka f531b;
    private final View c;
    private final CharSequence d;
    private final int e;
    private final Runnable f = new Ia(this);
    private final Runnable g = new Ja(this);
    private int h;
    private int i;
    private La j;
    private boolean k;

    private Ka(View view, CharSequence charSequence) {
        this.c = view;
        this.d = charSequence;
        this.e = z.a(ViewConfiguration.get(this.c.getContext()));
        c();
        this.c.setOnLongClickListener(this);
        this.c.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        Ka ka = f530a;
        if (ka != null && ka.c == view) {
            a((Ka) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            Ka ka2 = f531b;
            if (ka2 != null && ka2.c == view) {
                ka2.a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new Ka(view, charSequence);
    }

    private void b() {
        this.c.removeCallbacks(this.f);
    }

    private void c() {
        this.h = Integer.MAX_VALUE;
        this.i = Integer.MAX_VALUE;
    }

    private void d() {
        this.c.postDelayed(this.f, (long) ViewConfiguration.getLongPressTimeout());
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.j != null && this.k) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.c.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                a();
            }
        } else if (this.c.isEnabled() && this.j == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.h = view.getWidth() / 2;
        this.i = view.getHeight() / 2;
        a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        long j2;
        int i2;
        long j3;
        if (y.z(this.c)) {
            a((Ka) null);
            Ka ka = f531b;
            if (ka != null) {
                ka.a();
            }
            f531b = this;
            this.k = z;
            this.j = new La(this.c.getContext());
            this.j.a(this.c, this.h, this.i, this.k, this.d);
            this.c.addOnAttachStateChangeListener(this);
            if (this.k) {
                j2 = 2500;
            } else {
                if ((y.t(this.c) & 1) == 1) {
                    j3 = 3000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = 15000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j3 - ((long) i2);
            }
            this.c.removeCallbacks(this.g);
            this.c.postDelayed(this.g, j2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (f531b == this) {
            f531b = null;
            La la = this.j;
            if (la != null) {
                la.a();
                this.j = null;
                c();
                this.c.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f530a == this) {
            a((Ka) null);
        }
        this.c.removeCallbacks(this.g);
    }

    private static void a(Ka ka) {
        Ka ka2 = f530a;
        if (ka2 != null) {
            ka2.b();
        }
        f530a = ka;
        Ka ka3 = f530a;
        if (ka3 != null) {
            ka3.d();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.h) <= this.e && Math.abs(y - this.i) <= this.e) {
            return false;
        }
        this.h = x;
        this.i = y;
        return true;
    }
}
