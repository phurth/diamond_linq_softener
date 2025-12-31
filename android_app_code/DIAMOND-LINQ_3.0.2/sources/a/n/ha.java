package a.n;

import a.n.C0046a;
import a.n.E;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class ha extends E {
    private static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    private int L = 3;

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f309a;

        /* renamed from: b  reason: collision with root package name */
        boolean f310b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        b() {
        }
    }

    private b b(M m, M m2) {
        b bVar = new b();
        bVar.f309a = false;
        bVar.f310b = false;
        if (m == null || !m.f285a.containsKey("android:visibility:visibility")) {
            bVar.c = -1;
            bVar.e = null;
        } else {
            bVar.c = ((Integer) m.f285a.get("android:visibility:visibility")).intValue();
            bVar.e = (ViewGroup) m.f285a.get("android:visibility:parent");
        }
        if (m2 == null || !m2.f285a.containsKey("android:visibility:visibility")) {
            bVar.d = -1;
            bVar.f = null;
        } else {
            bVar.d = ((Integer) m2.f285a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) m2.f285a.get("android:visibility:parent");
        }
        if (m == null || m2 == null) {
            if (m == null && bVar.d == 0) {
                bVar.f310b = true;
                bVar.f309a = true;
            } else if (m2 == null && bVar.c == 0) {
                bVar.f310b = false;
                bVar.f309a = true;
            }
        } else if (bVar.c == bVar.d && bVar.e == bVar.f) {
            return bVar;
        } else {
            int i = bVar.c;
            int i2 = bVar.d;
            if (i != i2) {
                if (i == 0) {
                    bVar.f310b = false;
                    bVar.f309a = true;
                } else if (i2 == 0) {
                    bVar.f310b = true;
                    bVar.f309a = true;
                }
            } else if (bVar.f == null) {
                bVar.f310b = false;
                bVar.f309a = true;
            } else if (bVar.e == null) {
                bVar.f310b = true;
                bVar.f309a = true;
            }
        }
        return bVar;
    }

    private void d(M m) {
        m.f285a.put("android:visibility:visibility", Integer.valueOf(m.f286b.getVisibility()));
        m.f285a.put("android:visibility:parent", m.f286b.getParent());
        int[] iArr = new int[2];
        m.f286b.getLocationOnScreen(iArr);
        m.f285a.put("android:visibility:screenLocation", iArr);
    }

    public abstract Animator a(ViewGroup viewGroup, View view, M m, M m2);

    public void a(int i) {
        if ((i & -4) == 0) {
            this.L = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public abstract Animator b(ViewGroup viewGroup, View view, M m, M m2);

    public void c(M m) {
        d(m);
    }

    public String[] m() {
        return K;
    }

    public void a(M m) {
        d(m);
    }

    public Animator a(ViewGroup viewGroup, M m, M m2) {
        b b2 = b(m, m2);
        if (!b2.f309a) {
            return null;
        }
        if (b2.e == null && b2.f == null) {
            return null;
        }
        if (b2.f310b) {
            return a(viewGroup, m, b2.c, m2, b2.d);
        }
        return b(viewGroup, m, b2.c, m2, b2.d);
    }

    private static class a extends AnimatorListenerAdapter implements E.c, C0046a.C0016a {

        /* renamed from: a  reason: collision with root package name */
        private final View f307a;

        /* renamed from: b  reason: collision with root package name */
        private final int f308b;
        private final ViewGroup c;
        private final boolean d;
        private boolean e;
        boolean f = false;

        a(View view, int i, boolean z) {
            this.f307a = view;
            this.f308b = i;
            this.c = (ViewGroup) view.getParent();
            this.d = z;
            a(true);
        }

        private void a() {
            if (!this.f) {
                ba.a(this.f307a, this.f308b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        public void a(E e2) {
        }

        public void b(E e2) {
            a(false);
        }

        public void c(E e2) {
            a();
            e2.b((E.c) this);
        }

        public void d(E e2) {
            a(true);
        }

        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f) {
                ba.a(this.f307a, this.f308b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f) {
                ba.a(this.f307a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (this.d && this.e != z && (viewGroup = this.c) != null) {
                this.e = z;
                S.a(viewGroup, z);
            }
        }
    }

    public Animator a(ViewGroup viewGroup, M m, int i, M m2, int i2) {
        if ((this.L & 1) != 1 || m2 == null) {
            return null;
        }
        if (m == null) {
            View view = (View) m2.f286b.getParent();
            if (b(a(view, false), b(view, false)).f309a) {
                return null;
            }
        }
        return a(viewGroup, m2.f286b, m, m2);
    }

    public boolean a(M m, M m2) {
        if (m == null && m2 == null) {
            return false;
        }
        if (m != null && m2 != null && m2.f285a.containsKey("android:visibility:visibility") != m.f285a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(m, m2);
        if (!b2.f309a) {
            return false;
        }
        if (b2.c == 0 || b2.d == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ee A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator b(android.view.ViewGroup r7, a.n.M r8, int r9, a.n.M r10, int r11) {
        /*
            r6 = this;
            int r9 = r6.L
            r0 = 2
            r9 = r9 & r0
            r1 = 0
            if (r9 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r8 == 0) goto L_0x000d
            android.view.View r9 = r8.f286b
            goto L_0x000e
        L_0x000d:
            r9 = r1
        L_0x000e:
            if (r10 == 0) goto L_0x0013
            android.view.View r2 = r10.f286b
            goto L_0x0014
        L_0x0013:
            r2 = r1
        L_0x0014:
            r3 = 1
            if (r2 == 0) goto L_0x0037
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x001e
            goto L_0x0037
        L_0x001e:
            r4 = 4
            if (r11 != r4) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            if (r9 != r2) goto L_0x0027
        L_0x0024:
            r9 = r1
            goto L_0x0084
        L_0x0027:
            boolean r2 = r6.z
            if (r2 == 0) goto L_0x002c
            goto L_0x0044
        L_0x002c:
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            android.view.View r9 = a.n.L.a(r7, r9, r2)
            goto L_0x003a
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r9 = r2
        L_0x003a:
            r2 = r1
            goto L_0x0084
        L_0x003c:
            if (r9 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            if (r2 != 0) goto L_0x0045
        L_0x0044:
            goto L_0x003a
        L_0x0045:
            android.view.ViewParent r2 = r9.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x0082
            android.view.ViewParent r2 = r9.getParent()
            android.view.View r2 = (android.view.View) r2
            a.n.M r4 = r6.b((android.view.View) r2, (boolean) r3)
            a.n.M r5 = r6.a((android.view.View) r2, (boolean) r3)
            a.n.ha$b r4 = r6.b(r4, r5)
            boolean r4 = r4.f309a
            if (r4 != 0) goto L_0x0068
            android.view.View r9 = a.n.L.a(r7, r9, r2)
            goto L_0x003a
        L_0x0068:
            android.view.ViewParent r4 = r2.getParent()
            if (r4 != 0) goto L_0x0080
            int r2 = r2.getId()
            r4 = -1
            if (r2 == r4) goto L_0x0080
            android.view.View r2 = r7.findViewById(r2)
            if (r2 == 0) goto L_0x0080
            boolean r2 = r6.z
            if (r2 == 0) goto L_0x0080
            goto L_0x003a
        L_0x0080:
            r9 = r1
            goto L_0x003a
        L_0x0082:
            r9 = r1
            r2 = r9
        L_0x0084:
            r4 = 0
            if (r9 == 0) goto L_0x00cc
            if (r8 == 0) goto L_0x00cc
            java.util.Map<java.lang.String, java.lang.Object> r11 = r8.f285a
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r11 = r11.get(r1)
            int[] r11 = (int[]) r11
            r1 = r11[r4]
            r11 = r11[r3]
            int[] r0 = new int[r0]
            r7.getLocationOnScreen(r0)
            r2 = r0[r4]
            int r1 = r1 - r2
            int r2 = r9.getLeft()
            int r1 = r1 - r2
            r9.offsetLeftAndRight(r1)
            r0 = r0[r3]
            int r11 = r11 - r0
            int r0 = r9.getTop()
            int r11 = r11 - r0
            r9.offsetTopAndBottom(r11)
            a.n.Q r11 = a.n.S.a(r7)
            r11.a(r9)
            android.animation.Animator r7 = r6.b(r7, r9, r8, r10)
            if (r7 != 0) goto L_0x00c3
            r11.b(r9)
            goto L_0x00cb
        L_0x00c3:
            a.n.ga r8 = new a.n.ga
            r8.<init>(r6, r11, r9)
            r7.addListener(r8)
        L_0x00cb:
            return r7
        L_0x00cc:
            if (r2 == 0) goto L_0x00ee
            int r9 = r2.getVisibility()
            a.n.ba.a((android.view.View) r2, (int) r4)
            android.animation.Animator r7 = r6.b(r7, r2, r8, r10)
            if (r7 == 0) goto L_0x00ea
            a.n.ha$a r8 = new a.n.ha$a
            r8.<init>(r2, r11, r3)
            r7.addListener(r8)
            a.n.C0046a.a(r7, r8)
            r6.a((a.n.E.c) r8)
            goto L_0x00ed
        L_0x00ea:
            a.n.ba.a((android.view.View) r2, (int) r9)
        L_0x00ed:
            return r7
        L_0x00ee:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.n.ha.b(android.view.ViewGroup, a.n.M, int, a.n.M, int):android.animation.Animator");
    }
}
