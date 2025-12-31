package com.google.android.material.behavior;

import a.g.i.y;
import a.i.b.g;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;

class b extends g.a {

    /* renamed from: a  reason: collision with root package name */
    private int f1454a;

    /* renamed from: b  reason: collision with root package name */
    private int f1455b = -1;
    final /* synthetic */ SwipeDismissBehavior c;

    b(SwipeDismissBehavior swipeDismissBehavior) {
        this.c = swipeDismissBehavior;
    }

    public void a(View view, int i) {
        this.f1455b = i;
        this.f1454a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public boolean b(View view, int i) {
        return this.f1455b == -1 && this.c.a(view);
    }

    public void c(int i) {
        SwipeDismissBehavior.a aVar = this.c.f1450b;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public int b(View view, int i, int i2) {
        return view.getTop();
    }

    public void a(View view, float f, float f2) {
        boolean z;
        int i;
        SwipeDismissBehavior.a aVar;
        this.f1455b = -1;
        int width = view.getWidth();
        if (a(view, f)) {
            int left = view.getLeft();
            int i2 = this.f1454a;
            i = left < i2 ? i2 - width : i2 + width;
            z = true;
        } else {
            i = this.f1454a;
            z = false;
        }
        if (this.c.f1449a.d(i, view.getTop())) {
            y.a(view, (Runnable) new SwipeDismissBehavior.b(view, z));
        } else if (z && (aVar = this.c.f1450b) != null) {
            aVar.a(view);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0034 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.view.View r6, float r7) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            int r3 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r3 == 0) goto L_0x0036
            int r6 = a.g.i.y.m(r6)
            if (r6 != r2) goto L_0x000f
            r6 = 1
            goto L_0x0010
        L_0x000f:
            r6 = 0
        L_0x0010:
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r5.c
            int r3 = r3.f
            r4 = 2
            if (r3 != r4) goto L_0x0018
            return r2
        L_0x0018:
            if (r3 != 0) goto L_0x0027
            if (r6 == 0) goto L_0x0021
            int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0026
            goto L_0x0025
        L_0x0021:
            int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x0026
        L_0x0025:
            r1 = 1
        L_0x0026:
            return r1
        L_0x0027:
            if (r3 != r2) goto L_0x0035
            if (r6 == 0) goto L_0x0030
            int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x0035
            goto L_0x0034
        L_0x0030:
            int r6 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r6 >= 0) goto L_0x0035
        L_0x0034:
            r1 = 1
        L_0x0035:
            return r1
        L_0x0036:
            int r7 = r6.getLeft()
            int r0 = r5.f1454a
            int r7 = r7 - r0
            int r6 = r6.getWidth()
            float r6 = (float) r6
            com.google.android.material.behavior.SwipeDismissBehavior r0 = r5.c
            float r0 = r0.g
            float r6 = r6 * r0
            int r6 = java.lang.Math.round(r6)
            int r7 = java.lang.Math.abs(r7)
            if (r7 < r6) goto L_0x0053
            r1 = 1
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.b.a(android.view.View, float):boolean");
    }

    public int a(View view) {
        return view.getWidth();
    }

    public int a(View view, int i, int i2) {
        int i3;
        int i4;
        int width;
        boolean z = y.m(view) == 1;
        int i5 = this.c.f;
        if (i5 != 0) {
            if (i5 != 1) {
                i3 = this.f1454a - view.getWidth();
                i4 = view.getWidth() + this.f1454a;
            } else if (z) {
                i3 = this.f1454a;
                width = view.getWidth();
            } else {
                i3 = this.f1454a - view.getWidth();
                i4 = this.f1454a;
            }
            return SwipeDismissBehavior.a(i3, i, i4);
        } else if (z) {
            i3 = this.f1454a - view.getWidth();
            i4 = this.f1454a;
            return SwipeDismissBehavior.a(i3, i, i4);
        } else {
            i3 = this.f1454a;
            width = view.getWidth();
        }
        i4 = width + i3;
        return SwipeDismissBehavior.a(i3, i, i4);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        float width = ((float) this.f1454a) + (((float) view.getWidth()) * this.c.h);
        float width2 = ((float) this.f1454a) + (((float) view.getWidth()) * this.c.i);
        float f = (float) i;
        if (f <= width) {
            view.setAlpha(1.0f);
        } else if (f >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f), 1.0f));
        }
    }
}
