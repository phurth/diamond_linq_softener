package androidx.lifecycle;

import a.b.a.b.b;
import androidx.lifecycle.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class n extends h {

    /* renamed from: b  reason: collision with root package name */
    private a.b.a.b.a<k, a> f871b = new a.b.a.b.a<>();
    private h.b c;
    private final WeakReference<l> d;
    private int e = 0;
    private boolean f = false;
    private boolean g = false;
    private ArrayList<h.b> h = new ArrayList<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        h.b f872a;

        /* renamed from: b  reason: collision with root package name */
        j f873b;

        a(k kVar, h.b bVar) {
            this.f873b = p.a((Object) kVar);
            this.f872a = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, h.a aVar) {
            h.b a2 = n.a(aVar);
            this.f872a = n.a(this.f872a, a2);
            this.f873b.a(lVar, aVar);
            this.f872a = a2;
        }
    }

    public n(l lVar) {
        this.d = new WeakReference<>(lVar);
        this.c = h.b.INITIALIZED;
    }

    private h.b c(k kVar) {
        Map.Entry<k, a> b2 = this.f871b.b(kVar);
        h.b bVar = null;
        h.b bVar2 = b2 != null ? b2.getValue().f872a : null;
        if (!this.h.isEmpty()) {
            ArrayList<h.b> arrayList = this.h;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.c, bVar2), bVar);
    }

    private void d(h.b bVar) {
        if (this.c != bVar) {
            this.c = bVar;
            if (this.f || this.e != 0) {
                this.g = true;
                return;
            }
            this.f = true;
            d();
            this.f = false;
        }
    }

    private void e(h.b bVar) {
        this.h.add(bVar);
    }

    private static h.a f(h.b bVar) {
        int i = m.f870b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return h.a.ON_START;
            }
            if (i == 3) {
                return h.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            } else if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return h.a.ON_CREATE;
    }

    @Deprecated
    public void a(h.b bVar) {
        b(bVar);
    }

    public void b(h.b bVar) {
        d(bVar);
    }

    public void a(k kVar) {
        l lVar;
        h.b bVar = this.c;
        h.b bVar2 = h.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = h.b.INITIALIZED;
        }
        a aVar = new a(kVar, bVar2);
        if (this.f871b.b(kVar, aVar) == null && (lVar = (l) this.d.get()) != null) {
            boolean z = this.e != 0 || this.f;
            h.b c2 = c(kVar);
            this.e++;
            while (aVar.f872a.compareTo(c2) < 0 && this.f871b.contains(kVar)) {
                e(aVar.f872a);
                aVar.a(lVar, f(aVar.f872a));
                c();
                c2 = c(kVar);
            }
            if (!z) {
                d();
            }
            this.e--;
        }
    }

    public void b(h.a aVar) {
        d(a(aVar));
    }

    private boolean b() {
        if (this.f871b.size() == 0) {
            return true;
        }
        h.b bVar = this.f871b.a().getValue().f872a;
        h.b bVar2 = this.f871b.c().getValue().f872a;
        if (bVar == bVar2 && this.c == bVar2) {
            return true;
        }
        return false;
    }

    private void c() {
        ArrayList<h.b> arrayList = this.h;
        arrayList.remove(arrayList.size() - 1);
    }

    private static h.a c(h.b bVar) {
        int i = m.f870b[bVar.ordinal()];
        if (i == 1) {
            throw new IllegalArgumentException();
        } else if (i == 2) {
            return h.a.ON_DESTROY;
        } else {
            if (i == 3) {
                return h.a.ON_STOP;
            }
            if (i == 4) {
                return h.a.ON_PAUSE;
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
            throw new IllegalArgumentException();
        }
    }

    private void d() {
        l lVar = (l) this.d.get();
        if (lVar != null) {
            while (!b()) {
                this.g = false;
                if (this.c.compareTo(this.f871b.a().getValue().f872a) < 0) {
                    a(lVar);
                }
                Map.Entry<k, a> c2 = this.f871b.c();
                if (!this.g && c2 != null && this.c.compareTo(c2.getValue().f872a) > 0) {
                    b(lVar);
                }
            }
            this.g = false;
            return;
        }
        throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
    }

    public void b(k kVar) {
        this.f871b.remove(kVar);
    }

    private void b(l lVar) {
        b<K, V>.d b2 = this.f871b.b();
        while (b2.hasNext() && !this.g) {
            Map.Entry entry = (Map.Entry) b2.next();
            a aVar = (a) entry.getValue();
            while (aVar.f872a.compareTo(this.c) < 0 && !this.g && this.f871b.contains(entry.getKey())) {
                e(aVar.f872a);
                aVar.a(lVar, f(aVar.f872a));
                c();
            }
        }
    }

    public h.b a() {
        return this.c;
    }

    static h.b a(h.a aVar) {
        switch (m.f869a[aVar.ordinal()]) {
            case 1:
            case 2:
                return h.b.CREATED;
            case 3:
            case 4:
                return h.b.STARTED;
            case 5:
                return h.b.RESUMED;
            case 6:
                return h.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    private void a(l lVar) {
        Iterator<Map.Entry<k, a>> descendingIterator = this.f871b.descendingIterator();
        while (descendingIterator.hasNext() && !this.g) {
            Map.Entry next = descendingIterator.next();
            a aVar = (a) next.getValue();
            while (aVar.f872a.compareTo(this.c) > 0 && !this.g && this.f871b.contains(next.getKey())) {
                h.a c2 = c(aVar.f872a);
                e(a(c2));
                aVar.a(lVar, c2);
                c();
            }
        }
    }

    static h.b a(h.b bVar, h.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }
}
