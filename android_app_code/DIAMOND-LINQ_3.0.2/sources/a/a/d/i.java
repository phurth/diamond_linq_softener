package a.a.d;

import a.g.i.E;
import a.g.i.F;
import a.g.i.G;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public class i {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<E> f34a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private long f35b = -1;
    private Interpolator c;
    F d;
    private boolean e;
    private final G f = new h(this);

    public i a(E e2) {
        if (!this.e) {
            this.f34a.add(e2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.e = false;
    }

    public void c() {
        if (!this.e) {
            Iterator<E> it = this.f34a.iterator();
            while (it.hasNext()) {
                E next = it.next();
                long j = this.f35b;
                if (j >= 0) {
                    next.a(j);
                }
                Interpolator interpolator = this.c;
                if (interpolator != null) {
                    next.a(interpolator);
                }
                if (this.d != null) {
                    next.a((F) this.f);
                }
                next.c();
            }
            this.e = true;
        }
    }

    public i a(E e2, E e3) {
        this.f34a.add(e2);
        e3.b(e2.b());
        this.f34a.add(e3);
        return this;
    }

    public void a() {
        if (this.e) {
            Iterator<E> it = this.f34a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.e = false;
        }
    }

    public i a(long j) {
        if (!this.e) {
            this.f35b = j;
        }
        return this;
    }

    public i a(Interpolator interpolator) {
        if (!this.e) {
            this.c = interpolator;
        }
        return this;
    }

    public i a(F f2) {
        if (!this.e) {
            this.d = f2;
        }
        return this;
    }
}
