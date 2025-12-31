package a.n;

import a.n.E;
import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class K extends E {
    private ArrayList<E> K = new ArrayList<>();
    private boolean L = true;
    int M;
    boolean N = false;
    private int O = 0;

    static class a extends F {

        /* renamed from: a  reason: collision with root package name */
        K f282a;

        a(K k) {
            this.f282a = k;
        }

        public void a(E e) {
            K k = this.f282a;
            if (!k.N) {
                k.o();
                this.f282a.N = true;
            }
        }

        public void c(E e) {
            K k = this.f282a;
            k.M--;
            if (k.M == 0) {
                k.N = false;
                k.a();
            }
            e.b((E.c) this);
        }
    }

    private void q() {
        a aVar = new a(this);
        Iterator<E> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().a((E.c) aVar);
        }
        this.M = this.K.size();
    }

    public void c(M m) {
        if (b(m.f286b)) {
            Iterator<E> it = this.K.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next.b(m.f286b)) {
                    next.c(m);
                    m.c.add(next);
                }
            }
        }
    }

    public void e(View view) {
        super.e(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).e(view);
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        if (this.K.isEmpty()) {
            o();
            a();
            return;
        }
        q();
        if (!this.L) {
            for (int i = 1; i < this.K.size(); i++) {
                this.K.get(i - 1).a((E.c) new J(this, this.K.get(i)));
            }
            E e = this.K.get(0);
            if (e != null) {
                e.n();
                return;
            }
            return;
        }
        Iterator<E> it = this.K.iterator();
        while (it.hasNext()) {
            it.next().n();
        }
    }

    public int p() {
        return this.K.size();
    }

    public E clone() {
        K k = (K) super.clone();
        k.K = new ArrayList<>();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            k.a(this.K.get(i).clone());
        }
        return k;
    }

    public K d(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).d(view);
        }
        super.d(view);
        return this;
    }

    public K b(int i) {
        if (i == 0) {
            this.L = true;
        } else if (i == 1) {
            this.L = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public K a(E e) {
        this.K.add(e);
        e.u = this;
        long j = this.f;
        if (j >= 0) {
            e.a(j);
        }
        if ((this.O & 1) != 0) {
            e.a(d());
        }
        if ((this.O & 2) != 0) {
            e.a(g());
        }
        if ((this.O & 4) != 0) {
            e.a(f());
        }
        if ((this.O & 8) != 0) {
            e.a(c());
        }
        return this;
    }

    public K b(long j) {
        super.b(j);
        return this;
    }

    public void c(View view) {
        super.c(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).c(view);
        }
    }

    public K b(E.c cVar) {
        super.b(cVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b(M m) {
        super.b(m);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).b(m);
        }
    }

    public E a(int i) {
        if (i < 0 || i >= this.K.size()) {
            return null;
        }
        return this.K.get(i);
    }

    public K a(long j) {
        super.a(j);
        if (this.f >= 0) {
            int size = this.K.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(j);
            }
        }
        return this;
    }

    public K a(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList<E> arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.K.get(i).a(timeInterpolator);
            }
        }
        super.a(timeInterpolator);
        return this;
    }

    public K a(View view) {
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(view);
        }
        super.a(view);
        return this;
    }

    public K a(E.c cVar) {
        super.a(cVar);
        return this;
    }

    public void a(C0066v vVar) {
        super.a(vVar);
        this.O |= 4;
        for (int i = 0; i < this.K.size(); i++) {
            this.K.get(i).a(vVar);
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, N n, N n2, ArrayList<M> arrayList, ArrayList<M> arrayList2) {
        long h = h();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            E e = this.K.get(i);
            if (h > 0 && (this.L || i == 0)) {
                long h2 = e.h();
                if (h2 > 0) {
                    e.b(h2 + h);
                } else {
                    e.b(h);
                }
            }
            e.a(viewGroup, n, n2, arrayList, arrayList2);
        }
    }

    public void a(M m) {
        if (b(m.f286b)) {
            Iterator<E> it = this.K.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next.b(m.f286b)) {
                    next.a(m);
                    m.c.add(next);
                }
            }
        }
    }

    public void a(I i) {
        super.a(i);
        this.O |= 2;
        int size = this.K.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.K.get(i2).a(i);
        }
    }

    public void a(E.b bVar) {
        super.a(bVar);
        this.O |= 8;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            this.K.get(i).a(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String a2 = super.a(str);
        for (int i = 0; i < this.K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append("\n");
            sb.append(this.K.get(i).a(str + "  "));
            a2 = sb.toString();
        }
        return a2;
    }
}
