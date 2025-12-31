package com.google.android.material.floatingactionbutton;

import android.graphics.Matrix;
import b.c.a.a.a.g;

class k extends g {
    final /* synthetic */ m d;

    k(m mVar) {
        this.d = mVar;
    }

    /* renamed from: a */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        float unused = this.d.z = f;
        return super.a(f, matrix, matrix2);
    }
}
