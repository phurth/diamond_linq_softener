package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import androidx.appcompat.widget.E;

class G implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E.c f519a;

    G(E.c cVar) {
        this.f519a = cVar;
    }

    public void onGlobalLayout() {
        E.c cVar = this.f519a;
        if (!cVar.b(E.this)) {
            this.f519a.dismiss();
            return;
        }
        this.f519a.m();
        G.super.d();
    }
}
