package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class f<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a  reason: collision with root package name */
    private g f1442a;

    /* renamed from: b  reason: collision with root package name */
    private int f1443b = 0;
    private int c = 0;

    public f() {
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        b(coordinatorLayout, v, i);
        if (this.f1442a == null) {
            this.f1442a = new g(v);
        }
        this.f1442a.c();
        this.f1442a.a();
        int i2 = this.f1443b;
        if (i2 != 0) {
            this.f1442a.b(i2);
            this.f1443b = 0;
        }
        int i3 = this.c;
        if (i3 == 0) {
            return true;
        }
        this.f1442a.a(i3);
        this.c = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.c((View) v, i);
    }

    public int b() {
        g gVar = this.f1442a;
        if (gVar != null) {
            return gVar.b();
        }
        return 0;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int i) {
        g gVar = this.f1442a;
        if (gVar != null) {
            return gVar.b(i);
        }
        this.f1443b = i;
        return false;
    }
}
