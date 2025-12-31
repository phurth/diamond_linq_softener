package com.google.android.material.bottomsheet;

import a.g.d.a;
import a.i.b.g;
import android.view.View;
import java.lang.ref.WeakReference;

class c extends g.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BottomSheetBehavior f1477a;

    c(BottomSheetBehavior bottomSheetBehavior) {
        this.f1477a = bottomSheetBehavior;
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.f1477a.a(i2);
    }

    public boolean b(View view, int i) {
        BottomSheetBehavior bottomSheetBehavior = this.f1477a;
        int i2 = bottomSheetBehavior.r;
        if (i2 == 1 || bottomSheetBehavior.E) {
            return false;
        }
        if (i2 == 3 && bottomSheetBehavior.C == i) {
            WeakReference<View> weakReference = bottomSheetBehavior.z;
            View view2 = weakReference != null ? (View) weakReference.get() : null;
            if (view2 != null && view2.canScrollVertically(-1)) {
                return false;
            }
        }
        WeakReference<V> weakReference2 = this.f1477a.y;
        if (weakReference2 == null || weakReference2.get() != view) {
            return false;
        }
        return true;
    }

    public void c(int i) {
        if (i == 1) {
            this.f1477a.e(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f9 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r8, float r9, float r10) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r2 = 4
            r3 = 6
            r4 = 3
            int r5 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x0028
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            boolean r9 = r9.c
            if (r9 == 0) goto L_0x0018
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            int r9 = r9.l
        L_0x0015:
            r2 = 3
            goto L_0x00c7
        L_0x0018:
            int r9 = r8.getTop()
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f1477a
            int r10 = r10.m
            if (r9 <= r10) goto L_0x0026
            r9 = r10
        L_0x0023:
            r2 = 6
            goto L_0x00c7
        L_0x0026:
            r9 = 0
            goto L_0x0015
        L_0x0028:
            com.google.android.material.bottomsheet.BottomSheetBehavior r5 = r7.f1477a
            boolean r6 = r5.p
            if (r6 == 0) goto L_0x0051
            boolean r5 = r5.a((android.view.View) r8, (float) r10)
            if (r5 == 0) goto L_0x0051
            int r5 = r8.getTop()
            com.google.android.material.bottomsheet.BottomSheetBehavior r6 = r7.f1477a
            int r6 = r6.o
            if (r5 > r6) goto L_0x004a
            float r5 = java.lang.Math.abs(r9)
            float r6 = java.lang.Math.abs(r10)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x0051
        L_0x004a:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            int r9 = r9.x
            r2 = 5
            goto L_0x00c7
        L_0x0051:
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0067
            float r9 = java.lang.Math.abs(r9)
            float r10 = java.lang.Math.abs(r10)
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x0062
            goto L_0x0067
        L_0x0062:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            int r9 = r9.o
            goto L_0x00c7
        L_0x0067:
            int r9 = r8.getTop()
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f1477a
            boolean r10 = r10.c
            if (r10 == 0) goto L_0x0094
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f1477a
            int r10 = r10.l
            int r10 = r9 - r10
            int r10 = java.lang.Math.abs(r10)
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r7.f1477a
            int r0 = r0.o
            int r9 = r9 - r0
            int r9 = java.lang.Math.abs(r9)
            if (r10 >= r9) goto L_0x008e
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            int r0 = r9.l
            r9 = r0
            goto L_0x0015
        L_0x008e:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            int r0 = r9.o
        L_0x0092:
            r9 = r0
            goto L_0x00c7
        L_0x0094:
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f1477a
            int r1 = r10.m
            if (r9 >= r1) goto L_0x00aa
            int r10 = r10.o
            int r10 = r9 - r10
            int r10 = java.lang.Math.abs(r10)
            if (r9 >= r10) goto L_0x00a5
            goto L_0x0026
        L_0x00a5:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            int r0 = r9.m
            goto L_0x00bf
        L_0x00aa:
            int r10 = r9 - r1
            int r10 = java.lang.Math.abs(r10)
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = r7.f1477a
            int r0 = r0.o
            int r9 = r9 - r0
            int r9 = java.lang.Math.abs(r9)
            if (r10 >= r9) goto L_0x00c2
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            int r0 = r9.m
        L_0x00bf:
            r9 = r0
            goto L_0x0023
        L_0x00c2:
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            int r0 = r9.o
            goto L_0x0092
        L_0x00c7:
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f1477a
            a.i.b.g r10 = r10.s
            int r0 = r8.getLeft()
            boolean r9 = r10.d(r0, r9)
            if (r9 == 0) goto L_0x00f9
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            r10 = 2
            r9.e((int) r10)
            if (r2 != r4) goto L_0x00ee
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            android.animation.ValueAnimator r9 = r9.k
            if (r9 == 0) goto L_0x00ee
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = r7.f1477a
            android.animation.ValueAnimator r9 = r9.k
            r9.reverse()
        L_0x00ee:
            com.google.android.material.bottomsheet.BottomSheetBehavior$c r9 = new com.google.android.material.bottomsheet.BottomSheetBehavior$c
            com.google.android.material.bottomsheet.BottomSheetBehavior r10 = r7.f1477a
            r9.<init>(r8, r2)
            a.g.i.y.a((android.view.View) r8, (java.lang.Runnable) r9)
            goto L_0x0111
        L_0x00f9:
            if (r2 != r4) goto L_0x010c
            com.google.android.material.bottomsheet.BottomSheetBehavior r8 = r7.f1477a
            android.animation.ValueAnimator r8 = r8.k
            if (r8 == 0) goto L_0x010c
            com.google.android.material.bottomsheet.BottomSheetBehavior r8 = r7.f1477a
            android.animation.ValueAnimator r8 = r8.k
            r8.reverse()
        L_0x010c:
            com.google.android.material.bottomsheet.BottomSheetBehavior r8 = r7.f1477a
            r8.e((int) r2)
        L_0x0111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.c.a(android.view.View, float, float):void");
    }

    public int b(View view, int i, int i2) {
        int d = this.f1477a.e();
        BottomSheetBehavior bottomSheetBehavior = this.f1477a;
        return a.a(i, d, bottomSheetBehavior.p ? bottomSheetBehavior.x : bottomSheetBehavior.o);
    }

    public int b(View view) {
        BottomSheetBehavior bottomSheetBehavior = this.f1477a;
        if (bottomSheetBehavior.p) {
            return bottomSheetBehavior.x;
        }
        return bottomSheetBehavior.o;
    }

    public int a(View view, int i, int i2) {
        return view.getLeft();
    }
}
