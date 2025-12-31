package a.a.d;

import a.g.i.F;
import a.g.i.G;
import android.view.View;

class h extends G {

    /* renamed from: a  reason: collision with root package name */
    private boolean f32a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f33b = 0;
    final /* synthetic */ i c;

    h(i iVar) {
        this.c = iVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f33b = 0;
        this.f32a = false;
        this.c.b();
    }

    public void b(View view) {
        int i = this.f33b + 1;
        this.f33b = i;
        if (i == this.c.f34a.size()) {
            F f = this.c.d;
            if (f != null) {
                f.b((View) null);
            }
            a();
        }
    }

    public void c(View view) {
        if (!this.f32a) {
            this.f32a = true;
            F f = this.c.d;
            if (f != null) {
                f.c((View) null);
            }
        }
    }
}
