package androidx.activity;

import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.l;

class ComponentActivity$2 implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f359a;

    ComponentActivity$2(a aVar) {
        this.f359a = aVar;
    }

    public void a(l lVar, h.a aVar) {
        if (aVar == h.a.ON_DESTROY && !this.f359a.isChangingConfigurations()) {
            this.f359a.c().a();
        }
    }
}
