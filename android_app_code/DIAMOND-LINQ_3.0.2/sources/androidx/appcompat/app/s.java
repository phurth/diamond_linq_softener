package androidx.appcompat.app;

import android.graphics.Rect;
import androidx.appcompat.widget.U;

class s implements U.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f427a;

    s(x xVar) {
        this.f427a = xVar;
    }

    public void a(Rect rect) {
        rect.top = this.f427a.j(rect.top);
    }
}
