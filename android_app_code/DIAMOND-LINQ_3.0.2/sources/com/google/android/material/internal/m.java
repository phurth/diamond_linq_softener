package com.google.android.material.internal;

import a.g.i.I;
import a.g.i.q;
import a.g.i.y;
import android.graphics.Rect;
import android.view.View;

class m implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1520a;

    m(n nVar) {
        this.f1520a = nVar;
    }

    public I a(View view, I i) {
        n nVar = this.f1520a;
        if (nVar.f1522b == null) {
            nVar.f1522b = new Rect();
        }
        this.f1520a.f1522b.set(i.c(), i.e(), i.d(), i.b());
        this.f1520a.a(i);
        this.f1520a.setWillNotDraw(!i.f() || this.f1520a.f1521a == null);
        y.E(this.f1520a);
        return i.a();
    }
}
