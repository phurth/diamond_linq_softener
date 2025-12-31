package b.b.a.a.d;

import b.b.a.a.c.j;
import b.b.a.a.f.c;
import b.b.a.a.g.b.d;
import java.util.ArrayList;
import java.util.List;

public abstract class g<T extends d<? extends j>> {

    /* renamed from: a  reason: collision with root package name */
    protected float f1236a;

    /* renamed from: b  reason: collision with root package name */
    protected float f1237b;
    protected float c;
    protected float d;
    protected float e;
    protected float f;
    protected float g;
    protected float h;
    protected List<T> i;

    public g() {
        this.f1236a = -3.4028235E38f;
        this.f1237b = Float.MAX_VALUE;
        this.c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        this.i = new ArrayList();
    }

    private List<T> a(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public int b() {
        List<T> list = this.i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<T> c() {
        return this.i;
    }

    public int d() {
        int i2 = 0;
        for (T r : this.i) {
            i2 += r.r();
        }
        return i2;
    }

    public float e() {
        return this.c;
    }

    public float f() {
        return this.d;
    }

    public float g() {
        return this.f1236a;
    }

    public float h() {
        return this.f1237b;
    }

    public void i() {
        a();
    }

    public float b(j.a aVar) {
        if (aVar == j.a.LEFT) {
            float f2 = this.f;
            return f2 == Float.MAX_VALUE ? this.h : f2;
        }
        float f3 = this.h;
        return f3 == Float.MAX_VALUE ? this.f : f3;
    }

    public void a(float f2, float f3) {
        for (T b2 : this.i) {
            b2.b(f2, f3);
        }
        a();
    }

    /* access modifiers changed from: protected */
    public void a() {
        List<T> list = this.i;
        if (list != null) {
            this.f1236a = -3.4028235E38f;
            this.f1237b = Float.MAX_VALUE;
            this.c = -3.4028235E38f;
            this.d = Float.MAX_VALUE;
            for (T a2 : list) {
                a(a2);
            }
            this.e = -3.4028235E38f;
            this.f = Float.MAX_VALUE;
            this.g = -3.4028235E38f;
            this.h = Float.MAX_VALUE;
            d a3 = a(this.i);
            if (a3 != null) {
                this.e = a3.b();
                this.f = a3.g();
                for (T t : this.i) {
                    if (t.q() == j.a.LEFT) {
                        if (t.g() < this.f) {
                            this.f = t.g();
                        }
                        if (t.b() > this.e) {
                            this.e = t.b();
                        }
                    }
                }
            }
            d b2 = b(this.i);
            if (b2 != null) {
                this.g = b2.b();
                this.h = b2.g();
                for (T t2 : this.i) {
                    if (t2.q() == j.a.RIGHT) {
                        if (t2.g() < this.h) {
                            this.h = t2.g();
                        }
                        if (t2.b() > this.g) {
                            this.g = t2.b();
                        }
                    }
                }
            }
        }
    }

    public T b(List<T> list) {
        for (T t : list) {
            if (t.q() == j.a.RIGHT) {
                return t;
            }
        }
        return null;
    }

    public void b(int i2) {
        for (T a2 : this.i) {
            a2.a(i2);
        }
    }

    public g(T... tArr) {
        this.f1236a = -3.4028235E38f;
        this.f1237b = Float.MAX_VALUE;
        this.c = -3.4028235E38f;
        this.d = Float.MAX_VALUE;
        this.e = -3.4028235E38f;
        this.f = Float.MAX_VALUE;
        this.g = -3.4028235E38f;
        this.h = Float.MAX_VALUE;
        this.i = a(tArr);
        i();
    }

    public float a(j.a aVar) {
        if (aVar == j.a.LEFT) {
            float f2 = this.e;
            return f2 == -3.4028235E38f ? this.g : f2;
        }
        float f3 = this.g;
        return f3 == -3.4028235E38f ? this.e : f3;
    }

    public j a(c cVar) {
        if (cVar.b() >= this.i.size()) {
            return null;
        }
        return ((d) this.i.get(cVar.b())).a(cVar.f(), cVar.h());
    }

    public T a(int i2) {
        List<T> list = this.i;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return (d) this.i.get(i2);
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
        if (this.f1236a < t.b()) {
            this.f1236a = t.b();
        }
        if (this.f1237b > t.g()) {
            this.f1237b = t.g();
        }
        if (this.c < t.o()) {
            this.c = t.o();
        }
        if (this.d > t.a()) {
            this.d = t.a();
        }
        if (t.q() == j.a.LEFT) {
            if (this.e < t.b()) {
                this.e = t.b();
            }
            if (this.f > t.g()) {
                this.f = t.g();
                return;
            }
            return;
        }
        if (this.g < t.b()) {
            this.g = t.b();
        }
        if (this.h > t.g()) {
            this.h = t.g();
        }
    }

    /* access modifiers changed from: protected */
    public T a(List<T> list) {
        for (T t : list) {
            if (t.q() == j.a.LEFT) {
                return t;
            }
        }
        return null;
    }
}
