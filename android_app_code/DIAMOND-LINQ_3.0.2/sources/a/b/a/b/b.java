package a.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    c<K, V> f43a;

    /* renamed from: b  reason: collision with root package name */
    private c<K, V> f44b;
    private WeakHashMap<f<K, V>, Boolean> c = new WeakHashMap<>();
    private int d = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.c;
        }
    }

    /* renamed from: a.b.a.b.b$b  reason: collision with other inner class name */
    private static class C0002b<K, V> extends e<K, V> {
        C0002b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            return cVar.c;
        }

        /* access modifiers changed from: package-private */
        public c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f45a;

        /* renamed from: b  reason: collision with root package name */
        final V f46b;
        c<K, V> c;
        c<K, V> d;

        c(K k, V v) {
            this.f45a = k;
            this.f46b = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f45a.equals(cVar.f45a) || !this.f46b.equals(cVar.f46b)) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f45a;
        }

        public V getValue() {
            return this.f46b;
        }

        public int hashCode() {
            return this.f45a.hashCode() ^ this.f46b.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f45a + "=" + this.f46b;
        }
    }

    private class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private c<K, V> f47a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f48b = true;

        d() {
        }

        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f47a;
            if (cVar == cVar2) {
                this.f47a = cVar2.d;
                this.f48b = this.f47a == null;
            }
        }

        public boolean hasNext() {
            if (!this.f48b) {
                c<K, V> cVar = this.f47a;
                if (cVar == null || cVar.c == null) {
                    return false;
                }
                return true;
            } else if (b.this.f43a != null) {
                return true;
            } else {
                return false;
            }
        }

        public Map.Entry<K, V> next() {
            if (this.f48b) {
                this.f48b = false;
                this.f47a = b.this.f43a;
            } else {
                c<K, V> cVar = this.f47a;
                this.f47a = cVar != null ? cVar.c : null;
            }
            return this.f47a;
        }
    }

    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        c<K, V> f49a;

        /* renamed from: b  reason: collision with root package name */
        c<K, V> f50b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f49a = cVar2;
            this.f50b = cVar;
        }

        public void a(c<K, V> cVar) {
            if (this.f49a == cVar && cVar == this.f50b) {
                this.f50b = null;
                this.f49a = null;
            }
            c<K, V> cVar2 = this.f49a;
            if (cVar2 == cVar) {
                this.f49a = b(cVar2);
            }
            if (this.f50b == cVar) {
                this.f50b = a();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract c<K, V> b(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> c(c<K, V> cVar);

        public boolean hasNext() {
            return this.f50b != null;
        }

        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f50b;
            this.f50b = a();
            return cVar;
        }

        private c<K, V> a() {
            c<K, V> cVar = this.f50b;
            c<K, V> cVar2 = this.f49a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }
    }

    interface f<K, V> {
        void a(c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k) {
        c<K, V> cVar = this.f43a;
        while (cVar != null && !cVar.f45a.equals(k)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public V b(K k, V v) {
        c a2 = a(k);
        if (a2 != null) {
            return a2.f46b;
        }
        a(k, v);
        return null;
    }

    public Map.Entry<K, V> c() {
        return this.f44b;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0002b bVar = new C0002b(this.f44b, this.f43a);
        this.c.put(bVar, false);
        return bVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f43a, this.f44b);
        this.c.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        c a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.d--;
        if (!this.c.isEmpty()) {
            for (f<K, V> a3 : this.c.keySet()) {
                a3.a(a2);
            }
        }
        c<K, V> cVar = a2.d;
        if (cVar != null) {
            cVar.c = a2.c;
        } else {
            this.f43a = a2.c;
        }
        c<K, V> cVar2 = a2.c;
        if (cVar2 != null) {
            cVar2.d = a2.d;
        } else {
            this.f44b = a2.d;
        }
        a2.c = null;
        a2.d = null;
        return a2.f46b;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.d++;
        c<K, V> cVar2 = this.f44b;
        if (cVar2 == null) {
            this.f43a = cVar;
            this.f44b = this.f43a;
            return cVar;
        }
        cVar2.c = cVar;
        cVar.d = cVar2;
        this.f44b = cVar;
        return cVar;
    }

    public b<K, V>.d b() {
        b<K, V>.d dVar = new d();
        this.c.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> a() {
        return this.f43a;
    }
}
