package com.google.android.material.appbar;

import a.g.i.y;
import android.view.View;

class g {

    /* renamed from: a  reason: collision with root package name */
    private final View f1444a;

    /* renamed from: b  reason: collision with root package name */
    private int f1445b;
    private int c;
    private int d;
    private int e;
    private boolean f = true;
    private boolean g = true;

    public g(View view) {
        this.f1444a = view;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view = this.f1444a;
        y.c(view, this.d - (view.getTop() - this.f1445b));
        View view2 = this.f1444a;
        y.b(view2, this.e - (view2.getLeft() - this.c));
    }

    public boolean b(int i) {
        if (!this.f || this.d == i) {
            return false;
        }
        this.d = i;
        a();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f1445b = this.f1444a.getTop();
        this.c = this.f1444a.getLeft();
    }

    public boolean a(int i) {
        if (!this.g || this.e == i) {
            return false;
        }
        this.e = i;
        a();
        return true;
    }

    public int b() {
        return this.d;
    }
}
