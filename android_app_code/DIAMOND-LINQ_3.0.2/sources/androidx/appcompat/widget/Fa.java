package androidx.appcompat.widget;

import a.g.i.G;
import android.view.View;

class Fa extends G {

    /* renamed from: a  reason: collision with root package name */
    private boolean f515a = false;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f516b;
    final /* synthetic */ Ga c;

    Fa(Ga ga, int i) {
        this.c = ga;
        this.f516b = i;
    }

    public void a(View view) {
        this.f515a = true;
    }

    public void b(View view) {
        if (!this.f515a) {
            this.c.f520a.setVisibility(this.f516b);
        }
    }

    public void c(View view) {
        this.c.f520a.setVisibility(0);
    }
}
