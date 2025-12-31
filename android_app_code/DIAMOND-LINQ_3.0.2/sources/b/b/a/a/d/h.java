package b.b.a.a.d;

import b.b.a.a.d.j;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public abstract class h<T extends j> extends e<T> {
    protected List<T> q = null;
    protected float r = -3.4028235E38f;
    protected float s = Float.MAX_VALUE;
    protected float t = -3.4028235E38f;
    protected float u = Float.MAX_VALUE;

    public enum a {
        UP,
        DOWN,
        CLOSEST
    }

    public h(List<T> list, String str) {
        super(str);
        this.q = list;
        if (this.q == null) {
            this.q = new ArrayList();
        }
        ba();
    }

    public float a() {
        return this.u;
    }

    public void b(float f, float f2) {
        List<T> list = this.q;
        if (list != null && !list.isEmpty()) {
            this.r = -3.4028235E38f;
            this.s = Float.MAX_VALUE;
            int b2 = b(f2, Float.NaN, a.UP);
            for (int b3 = b(f, Float.NaN, a.DOWN); b3 <= b2; b3++) {
                d((j) this.q.get(b3));
            }
        }
    }

    public void ba() {
        List<T> list = this.q;
        if (list != null && !list.isEmpty()) {
            this.r = -3.4028235E38f;
            this.s = Float.MAX_VALUE;
            this.t = -3.4028235E38f;
            this.u = Float.MAX_VALUE;
            for (T b2 : this.q) {
                b(b2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(T t2) {
        if (t2.d() < this.u) {
            this.u = t2.d();
        }
        if (t2.d() > this.t) {
            this.t = t2.d();
        }
    }

    public String ca() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(f() == null ? BuildConfig.FLAVOR : f());
        sb.append(", entries: ");
        sb.append(this.q.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public void d(T t2) {
        if (t2.c() < this.s) {
            this.s = t2.c();
        }
        if (t2.c() > this.r) {
            this.r = t2.c();
        }
    }

    public float g() {
        return this.s;
    }

    public float o() {
        return this.t;
    }

    public int r() {
        return this.q.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ca());
        for (int i = 0; i < this.q.size(); i++) {
            stringBuffer.append(((j) this.q.get(i)).toString() + " ");
        }
        return stringBuffer.toString();
    }

    public int a(j jVar) {
        return this.q.indexOf(jVar);
    }

    public T a(float f, float f2, a aVar) {
        int b2 = b(f, f2, aVar);
        if (b2 > -1) {
            return (j) this.q.get(b2);
        }
        return null;
    }

    public T a(float f, float f2) {
        return a(f, f2, a.CLOSEST);
    }

    public List<T> a(float f) {
        ArrayList arrayList = new ArrayList();
        int size = this.q.size() - 1;
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            }
            int i2 = (size + i) / 2;
            j jVar = (j) this.q.get(i2);
            if (f == jVar.d()) {
                while (i2 > 0 && ((j) this.q.get(i2 - 1)).d() == f) {
                    i2--;
                }
                int size2 = this.q.size();
                while (i2 < size2) {
                    j jVar2 = (j) this.q.get(i2);
                    if (jVar2.d() != f) {
                        break;
                    }
                    arrayList.add(jVar2);
                    i2++;
                }
            } else if (f > jVar.d()) {
                i = i2 + 1;
            } else {
                size = i2 - 1;
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void b(T t2) {
        if (t2 != null) {
            c(t2);
            d(t2);
        }
    }

    public float b() {
        return this.r;
    }

    public T b(int i) {
        return (j) this.q.get(i);
    }

    public int b(float f, float f2, a aVar) {
        int i;
        j jVar;
        List<T> list = this.q;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i2 = 0;
        int size = this.q.size() - 1;
        while (i2 < size) {
            int i3 = (i2 + size) / 2;
            float d = ((j) this.q.get(i3)).d() - f;
            int i4 = i3 + 1;
            float abs = Math.abs(d);
            float abs2 = Math.abs(((j) this.q.get(i4)).d() - f);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d2 = (double) d;
                    if (d2 < 0.0d) {
                        if (d2 >= 0.0d) {
                        }
                    }
                }
                size = i3;
            }
            i2 = i4;
        }
        if (size == -1) {
            return size;
        }
        float d3 = ((j) this.q.get(size)).d();
        if (aVar == a.UP) {
            if (d3 < f && size < this.q.size() - 1) {
                size++;
            }
        } else if (aVar == a.DOWN && d3 > f && size > 0) {
            size--;
        }
        if (Float.isNaN(f2)) {
            return size;
        }
        while (size > 0 && ((j) this.q.get(size - 1)).d() == d3) {
            size--;
        }
        float c = ((j) this.q.get(size)).c();
        loop2:
        while (true) {
            i = size;
            do {
                size++;
                if (size >= this.q.size()) {
                    break loop2;
                }
                jVar = (j) this.q.get(size);
                if (jVar.d() != d3) {
                    break loop2;
                }
            } while (Math.abs(jVar.c() - f2) >= Math.abs(c - f2));
            c = f2;
        }
        return i;
    }
}
