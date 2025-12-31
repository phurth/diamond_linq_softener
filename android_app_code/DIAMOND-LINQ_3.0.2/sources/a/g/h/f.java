package a.g.h;

public class f<T> extends e<T> {
    private final Object c = new Object();

    public f(int i) {
        super(i);
    }

    public T a() {
        T a2;
        synchronized (this.c) {
            a2 = super.a();
        }
        return a2;
    }

    public boolean a(T t) {
        boolean a2;
        synchronized (this.c) {
            a2 = super.a(t);
        }
        return a2;
    }
}
