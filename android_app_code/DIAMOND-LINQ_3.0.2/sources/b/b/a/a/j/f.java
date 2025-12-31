package b.b.a.a.j;

import b.b.a.a.j.f.a;

public class f<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    private static int f1269a;

    /* renamed from: b  reason: collision with root package name */
    private int f1270b;
    private int c;
    private Object[] d;
    private int e;
    private T f;
    private float g;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public static int f1271a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f1272b = f1271a;

        /* access modifiers changed from: protected */
        public abstract a a();
    }

    private f(int i, T t) {
        if (i > 0) {
            this.c = i;
            this.d = new Object[this.c];
            this.e = 0;
            this.f = t;
            this.g = 1.0f;
            b();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized f a(int i, a aVar) {
        f fVar;
        synchronized (f.class) {
            fVar = new f(i, aVar);
            fVar.f1270b = f1269a;
            f1269a++;
        }
        return fVar;
    }

    private void b() {
        b(this.g);
    }

    private void c() {
        int i = this.c;
        this.c = i * 2;
        Object[] objArr = new Object[this.c];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = this.d[i2];
        }
        this.d = objArr;
    }

    private void b(float f2) {
        int i = this.c;
        int i2 = (int) (((float) i) * f2);
        if (i2 < 1) {
            i2 = 1;
        } else if (i2 > i) {
            i2 = i;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            this.d[i3] = this.f.a();
        }
        this.e = i2 - 1;
    }

    public void a(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.g = f2;
    }

    public synchronized T a() {
        T t;
        if (this.e == -1 && this.g > 0.0f) {
            b();
        }
        t = (a) this.d[this.e];
        t.f1272b = a.f1271a;
        this.e--;
        return t;
    }

    public synchronized void a(T t) {
        if (t.f1272b == a.f1271a) {
            this.e++;
            if (this.e >= this.d.length) {
                c();
            }
            t.f1272b = this.f1270b;
            this.d[this.e] = t;
        } else if (t.f1272b == this.f1270b) {
            throw new IllegalArgumentException("The object passed is already stored in this pool!");
        } else {
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.f1272b + ".  Object cannot belong to two different pool instances simultaneously!");
        }
    }
}
