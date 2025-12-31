package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.h;
import androidx.lifecycle.z;

public class y implements l {

    /* renamed from: a  reason: collision with root package name */
    private static final y f881a = new y();

    /* renamed from: b  reason: collision with root package name */
    private int f882b = 0;
    private int c = 0;
    private boolean d = true;
    private boolean e = true;
    private Handler f;
    private final n g = new n(this);
    private Runnable h = new v(this);
    z.a i = new w(this);

    private y() {
    }

    static void b(Context context) {
        f881a.a(context);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        this.f = new Handler();
        this.g.b(h.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new x(this));
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.c--;
        if (this.c == 0) {
            this.f.postDelayed(this.h, 700);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.c++;
        if (this.c != 1) {
            return;
        }
        if (this.d) {
            this.g.b(h.a.ON_RESUME);
            this.d = false;
            return;
        }
        this.f.removeCallbacks(this.h);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f882b++;
        if (this.f882b == 1 && this.e) {
            this.g.b(h.a.ON_START);
            this.e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f882b--;
        h();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.c == 0) {
            this.d = true;
            this.g.b(h.a.ON_PAUSE);
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.f882b == 0 && this.d) {
            this.g.b(h.a.ON_STOP);
            this.e = true;
        }
    }

    public h a() {
        return this.g;
    }
}
