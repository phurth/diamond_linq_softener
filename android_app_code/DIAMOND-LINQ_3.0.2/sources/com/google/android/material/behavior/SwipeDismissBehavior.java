package com.google.android.material.behavior;

import a.g.i.y;
import a.i.b.g;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a  reason: collision with root package name */
    g f1449a;

    /* renamed from: b  reason: collision with root package name */
    a f1450b;
    private boolean c;
    private float d = 0.0f;
    private boolean e;
    int f = 2;
    float g = 0.5f;
    float h = 0.0f;
    float i = 0.5f;
    private final g.a j = new b(this);

    public interface a {
        void a(int i);

        void a(View view);
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f1451a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1452b;

        b(View view, boolean z) {
            this.f1451a = view;
            this.f1452b = z;
        }

        public void run() {
            a aVar;
            g gVar = SwipeDismissBehavior.this.f1449a;
            if (gVar != null && gVar.a(true)) {
                y.a(this.f1451a, (Runnable) this);
            } else if (this.f1452b && (aVar = SwipeDismissBehavior.this.f1450b) != null) {
                aVar.a(this.f1451a);
            }
        }
    }

    static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public void a(int i2) {
        this.f = i2;
    }

    public boolean a(View view) {
        return true;
    }

    public void b(float f2) {
        this.h = a(0.0f, f2, 1.0f);
    }

    public void a(float f2) {
        this.i = a(0.0f, f2, 1.0f);
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        g gVar = this.f1449a;
        if (gVar == null) {
            return false;
        }
        gVar.a(motionEvent);
        return true;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.c = coordinatorLayout.a((View) v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.c = false;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f1449a.b(motionEvent);
    }

    private void a(ViewGroup viewGroup) {
        g gVar;
        if (this.f1449a == null) {
            if (this.e) {
                gVar = g.a(viewGroup, this.d, this.j);
            } else {
                gVar = g.a(viewGroup, this.j);
            }
            this.f1449a = gVar;
        }
    }

    static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }
}
