package androidx.coordinatorlayout.widget;

import a.d.i;
import a.g.h.d;
import a.g.h.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d<ArrayList<T>> f715a = new e(10);

    /* renamed from: b  reason: collision with root package name */
    private final i<T, ArrayList<T>> f716b = new i<>();
    private final ArrayList<T> c = new ArrayList<>();
    private final HashSet<T> d = new HashSet<>();

    public void a(T t) {
        if (!this.f716b.containsKey(t)) {
            this.f716b.put(t, null);
        }
    }

    public boolean b(T t) {
        return this.f716b.containsKey(t);
    }

    public List c(T t) {
        return this.f716b.get(t);
    }

    public List<T> d(T t) {
        int size = this.f716b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList d2 = this.f716b.d(i);
            if (d2 != null && d2.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f716b.b(i));
            }
        }
        return arrayList;
    }

    public boolean e(T t) {
        int size = this.f716b.size();
        for (int i = 0; i < size; i++) {
            ArrayList d2 = this.f716b.d(i);
            if (d2 != null && d2.contains(t)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<T> c() {
        ArrayList<T> a2 = this.f715a.a();
        return a2 == null ? new ArrayList<>() : a2;
    }

    public ArrayList<T> b() {
        this.c.clear();
        this.d.clear();
        int size = this.f716b.size();
        for (int i = 0; i < size; i++) {
            a(this.f716b.b(i), this.c, this.d);
        }
        return this.c;
    }

    public void a(T t, T t2) {
        if (!this.f716b.containsKey(t) || !this.f716b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f716b.get(t);
        if (arrayList == null) {
            arrayList = c();
            this.f716b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    public void a() {
        int size = this.f716b.size();
        for (int i = 0; i < size; i++) {
            ArrayList d2 = this.f716b.d(i);
            if (d2 != null) {
                a(d2);
            }
        }
        this.f716b.clear();
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.f716b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        a(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f715a.a(arrayList);
    }
}
