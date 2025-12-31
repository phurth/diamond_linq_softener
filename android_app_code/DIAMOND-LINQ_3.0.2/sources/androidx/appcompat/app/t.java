package androidx.appcompat.app;

import androidx.appcompat.widget.ContentFrameLayout;

class t implements ContentFrameLayout.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f428a;

    t(x xVar) {
        this.f428a = xVar;
    }

    public void a() {
    }

    public void onDetachedFromWindow() {
        this.f428a.l();
    }
}
