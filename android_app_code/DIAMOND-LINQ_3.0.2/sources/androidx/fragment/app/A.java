package androidx.fragment.app;

import androidx.lifecycle.B;
import androidx.lifecycle.D;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class A extends androidx.lifecycle.A {
    private static final B.b c = new z();
    private final HashSet<C0132h> d = new HashSet<>();
    private final HashMap<String, A> e = new HashMap<>();
    private final HashMap<String, D> f = new HashMap<>();
    private final boolean g;
    private boolean h = false;
    private boolean i = false;

    A(boolean z) {
        this.g = z;
    }

    static A a(D d2) {
        return (A) new B(d2, c).a(A.class);
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.h = true;
    }

    /* access modifiers changed from: package-private */
    public Collection<C0132h> c() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public void e(C0132h hVar) {
        this.d.remove(hVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || A.class != obj.getClass()) {
            return false;
        }
        A a2 = (A) obj;
        if (!this.d.equals(a2.d) || !this.e.equals(a2.e) || !this.f.equals(a2.f)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean f(C0132h hVar) {
        if (!this.d.contains(hVar)) {
            return true;
        }
        if (this.g) {
            return this.h;
        }
        return !this.i;
    }

    public int hashCode() {
        return (((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<C0132h> it = this.d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.e.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void b(C0132h hVar) {
        A a2 = this.e.get(hVar.f);
        if (a2 != null) {
            a2.b();
            this.e.remove(hVar.f);
        }
        D d2 = this.f.get(hVar.f);
        if (d2 != null) {
            d2.a();
            this.f.remove(hVar.f);
        }
    }

    /* access modifiers changed from: package-private */
    public A c(C0132h hVar) {
        A a2 = this.e.get(hVar.f);
        if (a2 != null) {
            return a2;
        }
        A a3 = new A(this.g);
        this.e.put(hVar.f, a3);
        return a3;
    }

    /* access modifiers changed from: package-private */
    public D d(C0132h hVar) {
        D d2 = this.f.get(hVar.f);
        if (d2 != null) {
            return d2;
        }
        D d3 = new D();
        this.f.put(hVar.f, d3);
        return d3;
    }

    /* access modifiers changed from: package-private */
    public void a(C0132h hVar) {
        this.d.add(hVar);
    }
}
