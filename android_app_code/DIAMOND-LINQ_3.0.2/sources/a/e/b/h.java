package a.e.b;

class h<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f112a;

    /* renamed from: b  reason: collision with root package name */
    private int f113b;

    h(int i) {
        if (i > 0) {
            this.f112a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int i = this.f113b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        T[] tArr = this.f112a;
        T t = tArr[i2];
        tArr[i2] = null;
        this.f113b = i - 1;
        return t;
    }

    public boolean a(T t) {
        int i = this.f113b;
        Object[] objArr = this.f112a;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = t;
        this.f113b = i + 1;
        return true;
    }

    public void a(T[] tArr, int i) {
        if (i > tArr.length) {
            i = tArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            T t = tArr[i2];
            int i3 = this.f113b;
            Object[] objArr = this.f112a;
            if (i3 < objArr.length) {
                objArr[i3] = t;
                this.f113b = i3 + 1;
            }
        }
    }
}
