package a.i.b;

import a.d.j;
import a.g.i.B;
import a.g.i.C0037a;
import a.g.i.a.e;
import a.g.i.y;
import a.i.b.d;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

public abstract class c extends C0037a {
    private static final Rect d = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final d.a<a.g.i.a.c> e = new a();
    private static final d.b<j<a.g.i.a.c>, a.g.i.a.c> f = new b();
    private final Rect g = new Rect();
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private final int[] j = new int[2];
    private final AccessibilityManager k;
    private final View l;
    private a m;
    int n = Integer.MIN_VALUE;
    int o = Integer.MIN_VALUE;
    private int p = Integer.MIN_VALUE;

    public c(View view) {
        if (view != null) {
            this.l = view;
            this.k = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (y.k(view) == 0) {
                y.d(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean b(int i2, Rect rect) {
        a.g.i.a.c cVar;
        a.g.i.a.c cVar2;
        j<a.g.i.a.c> d2 = d();
        int i3 = this.o;
        int i4 = Integer.MIN_VALUE;
        if (i3 == Integer.MIN_VALUE) {
            cVar = null;
        } else {
            cVar = d2.a(i3);
        }
        a.g.i.a.c cVar3 = cVar;
        if (i2 == 1 || i2 == 2) {
            cVar2 = (a.g.i.a.c) d.a(d2, f, e, cVar3, i2, y.m(this.l) == 1, false);
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i5 = this.o;
            if (i5 != Integer.MIN_VALUE) {
                a(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.l, i2, rect2);
            }
            cVar2 = (a.g.i.a.c) d.a(d2, f, e, cVar3, rect2, i2);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (cVar2 != null) {
            i4 = d2.c(d2.a(cVar2));
        }
        return c(i4);
    }

    private AccessibilityEvent c(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        a.g.i.a.c b2 = b(i2);
        obtain.getText().add(b2.g());
        obtain.setContentDescription(b2.d());
        obtain.setScrollable(b2.r());
        obtain.setPassword(b2.q());
        obtain.setEnabled(b2.m());
        obtain.setChecked(b2.k());
        a(i2, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(b2.c());
            e.a(obtain, this.l, i2);
            obtain.setPackageName(this.l.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private j<a.g.i.a.c> d() {
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        j<a.g.i.a.c> jVar = new j<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            jVar.c(i2, f(i2));
        }
        return jVar;
    }

    private AccessibilityEvent e(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.l.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private a.g.i.a.c f(int i2) {
        a.g.i.a.c u = a.g.i.a.c.u();
        u.e(true);
        u.f(true);
        u.b((CharSequence) "android.view.View");
        u.c(d);
        u.d(d);
        u.c(this.l);
        a(i2, u);
        if (u.g() == null && u.d() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        u.a(this.h);
        if (!this.h.equals(d)) {
            int a2 = u.a();
            if ((a2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((a2 & 128) == 0) {
                u.d((CharSequence) this.l.getContext().getPackageName());
                u.c(this.l, i2);
                if (this.n == i2) {
                    u.a(true);
                    u.a(128);
                } else {
                    u.a(false);
                    u.a(64);
                }
                boolean z = this.o == i2;
                if (z) {
                    u.a(2);
                } else if (u.n()) {
                    u.a(1);
                }
                u.g(z);
                this.l.getLocationOnScreen(this.j);
                u.b(this.g);
                if (this.g.equals(d)) {
                    u.a(this.g);
                    if (u.c != -1) {
                        a.g.i.a.c u2 = a.g.i.a.c.u();
                        for (int i3 = u.c; i3 != -1; i3 = u2.c) {
                            u2.b(this.l, -1);
                            u2.c(d);
                            a(i3, u2);
                            u2.a(this.h);
                            Rect rect = this.g;
                            Rect rect2 = this.h;
                            rect.offset(rect2.left, rect2.top);
                        }
                        u2.v();
                    }
                    this.g.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
                }
                if (this.l.getLocalVisibleRect(this.i)) {
                    this.i.offset(this.j[0] - this.l.getScrollX(), this.j[1] - this.l.getScrollY());
                    if (this.g.intersect(this.i)) {
                        u.d(this.g);
                        if (a(this.g)) {
                            u.m(true);
                        }
                    }
                }
                return u;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private static int g(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 != 21) {
            return i2 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean h(int i2) {
        int i3;
        if (!this.k.isEnabled() || !this.k.isTouchExplorationEnabled() || (i3 = this.n) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            d(i3);
        }
        this.n = i2;
        this.l.invalidate();
        a(i2, 32768);
        return true;
    }

    private void i(int i2) {
        int i3 = this.p;
        if (i3 != i2) {
            this.p = i2;
            a(i2, 128);
            a(i3, 256);
        }
    }

    /* access modifiers changed from: protected */
    public abstract int a(float f2, float f3);

    public a.g.i.a.d a(View view) {
        if (this.m == null) {
            this.m = new a();
        }
        return this.m;
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i2, a.g.i.a.c cVar);

    /* access modifiers changed from: protected */
    public void a(int i2, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void a(a.g.i.a.c cVar) {
    }

    /* access modifiers changed from: protected */
    public void a(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(List<Integer> list);

    /* access modifiers changed from: protected */
    public abstract boolean a(int i2, int i3, Bundle bundle);

    private class a extends a.g.i.a.d {
        a() {
        }

        public a.g.i.a.c a(int i) {
            return a.g.i.a.c.a(c.this.b(i));
        }

        public a.g.i.a.c b(int i) {
            int i2 = i == 2 ? c.this.n : c.this.o;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i2);
        }

        public boolean a(int i, int i2, Bundle bundle) {
            return c.this.b(i, i2, bundle);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        if (!this.k.isEnabled() || !this.k.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int a2 = a(motionEvent.getX(), motionEvent.getY());
            i(a2);
            if (a2 != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        } else if (action != 10 || this.p == Integer.MIN_VALUE) {
            return false;
        } else {
            i(Integer.MIN_VALUE);
            return true;
        }
    }

    private boolean d(int i2) {
        if (this.n != i2) {
            return false;
        }
        this.n = Integer.MIN_VALUE;
        this.l.invalidate();
        a(i2, 65536);
        return true;
    }

    public final boolean a(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int g2 = g(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i2 < repeatCount && b(g2, (Rect) null)) {
                            i2++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            b();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return b(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return b(1, (Rect) null);
            }
            return false;
        }
    }

    private a.g.i.a.c c() {
        a.g.i.a.c b2 = a.g.i.a.c.b(this.l);
        y.a(this.l, b2);
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        if (b2.b() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                b2.a(this.l, ((Integer) arrayList.get(i2)).intValue());
            }
            return b2;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private boolean b() {
        int i2 = this.o;
        return i2 != Integer.MIN_VALUE && a(i2, 16, (Bundle) null);
    }

    private AccessibilityEvent b(int i2, int i3) {
        if (i2 != -1) {
            return c(i2, i3);
        }
        return e(i3);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        a(accessibilityEvent);
    }

    /* access modifiers changed from: package-private */
    public a.g.i.a.c b(int i2) {
        if (i2 == -1) {
            return c();
        }
        return f(i2);
    }

    public final void a(boolean z, int i2, Rect rect) {
        int i3 = this.o;
        if (i3 != Integer.MIN_VALUE) {
            a(i3);
        }
        if (z) {
            b(i2, rect);
        }
    }

    private boolean c(int i2, int i3, Bundle bundle) {
        if (i3 == 1) {
            return c(i2);
        }
        if (i3 == 2) {
            return a(i2);
        }
        if (i3 == 64) {
            return h(i2);
        }
        if (i3 != 128) {
            return a(i2, i3, bundle);
        }
        return d(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, int i3, Bundle bundle) {
        if (i2 != -1) {
            return c(i2, i3, bundle);
        }
        return a(i3, bundle);
    }

    private void a(int i2, Rect rect) {
        b(i2).a(rect);
    }

    private static Rect a(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i2 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    public final boolean c(int i2) {
        int i3;
        if ((!this.l.isFocused() && !this.l.requestFocus()) || (i3 = this.o) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            a(i3);
        }
        this.o = i2;
        a(i2, true);
        a(i2, 8);
        return true;
    }

    public final boolean a(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.k.isEnabled() || (parent = this.l.getParent()) == null) {
            return false;
        }
        return B.a(parent, this.l, b(i2, i3));
    }

    public void a(View view, a.g.i.a.c cVar) {
        super.a(view, cVar);
        a(cVar);
    }

    private boolean a(int i2, Bundle bundle) {
        return y.a(this.l, i2, bundle);
    }

    private boolean a(Rect rect) {
        if (rect == null || rect.isEmpty() || this.l.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.l.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    public final boolean a(int i2) {
        if (this.o != i2) {
            return false;
        }
        this.o = Integer.MIN_VALUE;
        a(i2, false);
        a(i2, 8);
        return true;
    }
}
