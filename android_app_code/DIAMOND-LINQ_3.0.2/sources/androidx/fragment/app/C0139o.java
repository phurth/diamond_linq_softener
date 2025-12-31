package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* renamed from: androidx.fragment.app.o  reason: case insensitive filesystem */
public abstract class C0139o {

    /* renamed from: a  reason: collision with root package name */
    static final C0137m f812a = new C0137m();

    /* renamed from: b  reason: collision with root package name */
    private C0137m f813b = null;

    /* renamed from: androidx.fragment.app.o$a */
    public interface a {
    }

    /* renamed from: androidx.fragment.app.o$b */
    public static abstract class b {
        public abstract void a(C0139o oVar, C0132h hVar);

        public abstract void a(C0139o oVar, C0132h hVar, Context context);

        public abstract void a(C0139o oVar, C0132h hVar, Bundle bundle);

        public abstract void a(C0139o oVar, C0132h hVar, View view, Bundle bundle);

        public abstract void b(C0139o oVar, C0132h hVar);

        public abstract void b(C0139o oVar, C0132h hVar, Context context);

        public abstract void b(C0139o oVar, C0132h hVar, Bundle bundle);

        public abstract void c(C0139o oVar, C0132h hVar);

        public abstract void c(C0139o oVar, C0132h hVar, Bundle bundle);

        public abstract void d(C0139o oVar, C0132h hVar);

        public abstract void d(C0139o oVar, C0132h hVar, Bundle bundle);

        public abstract void e(C0139o oVar, C0132h hVar);

        public abstract void f(C0139o oVar, C0132h hVar);

        public abstract void g(C0139o oVar, C0132h hVar);
    }

    /* renamed from: androidx.fragment.app.o$c */
    public interface c {
        void onBackStackChanged();
    }

    public abstract D a();

    public abstract C0132h a(String str);

    public abstract void a(int i, int i2);

    public void a(C0137m mVar) {
        this.f813b = mVar;
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean b();

    public C0137m c() {
        if (this.f813b == null) {
            this.f813b = f812a;
        }
        return this.f813b;
    }

    public abstract List<C0132h> d();

    public abstract boolean e();
}
