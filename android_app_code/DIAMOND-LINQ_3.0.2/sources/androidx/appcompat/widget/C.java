package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.appcompat.view.menu.w;
import androidx.appcompat.widget.E;

class C extends V {
    final /* synthetic */ E.c j;
    final /* synthetic */ E k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C(E e, View view, E.c cVar) {
        super(view);
        this.k = e;
        this.j = cVar;
    }

    public w a() {
        return this.j;
    }

    @SuppressLint({"SyntheticAccessor"})
    public boolean b() {
        if (this.k.getInternalPopup().c()) {
            return true;
        }
        this.k.a();
        return true;
    }
}
