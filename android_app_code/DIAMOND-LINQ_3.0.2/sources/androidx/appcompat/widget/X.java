package androidx.appcompat.widget;

import android.view.View;

class X implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Z f572a;

    X(Z z) {
        this.f572a = z;
    }

    public void run() {
        View i = this.f572a.i();
        if (i != null && i.getWindowToken() != null) {
            this.f572a.d();
        }
    }
}
