package a.b.a.a;

import java.util.concurrent.Executor;

public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f37a;

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f38b = new a();
    private static final Executor c = new b();
    private f d = this.e;
    private f e = new e();

    private c() {
    }

    public static c b() {
        if (f37a != null) {
            return f37a;
        }
        synchronized (c.class) {
            if (f37a == null) {
                f37a = new c();
            }
        }
        return f37a;
    }

    public void a(Runnable runnable) {
        this.d.a(runnable);
    }

    public boolean a() {
        return this.d.a();
    }

    public void b(Runnable runnable) {
        this.d.b(runnable);
    }
}
