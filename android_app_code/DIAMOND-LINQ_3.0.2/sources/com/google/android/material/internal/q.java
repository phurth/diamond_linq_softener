package com.google.android.material.internal;

import android.graphics.Typeface;
import b.c.a.a.m.g;
import com.google.android.material.internal.r;

class q extends g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f1528a;

    q(r rVar) {
        this.f1528a = rVar;
    }

    public void a(Typeface typeface, boolean z) {
        if (!z) {
            boolean unused = this.f1528a.d = true;
            r.a aVar = (r.a) this.f1528a.e.get();
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void a(int i) {
        boolean unused = this.f1528a.d = true;
        r.a aVar = (r.a) this.f1528a.e.get();
        if (aVar != null) {
            aVar.a();
        }
    }
}
