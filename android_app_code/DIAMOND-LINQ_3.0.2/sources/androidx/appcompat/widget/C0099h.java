package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.C0097g;

/* renamed from: androidx.appcompat.widget.h  reason: case insensitive filesystem */
class C0099h extends V {
    final /* synthetic */ C0097g j;
    final /* synthetic */ C0097g.d k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0099h(C0097g.d dVar, View view, C0097g gVar) {
        super(view);
        this.k = dVar;
        this.j = gVar;
    }

    public w a() {
        C0097g.e eVar = C0097g.this.z;
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    public boolean b() {
        C0097g.this.j();
        return true;
    }

    public boolean c() {
        C0097g gVar = C0097g.this;
        if (gVar.B != null) {
            return false;
        }
        gVar.f();
        return true;
    }
}
