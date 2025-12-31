package androidx.recyclerview.widget;

import a.d.f;
import a.g.h.d;
import a.g.h.e;
import androidx.recyclerview.widget.RecyclerView;

class O {

    /* renamed from: a  reason: collision with root package name */
    final a.d.b<RecyclerView.x, a> f904a = new a.d.b<>();

    /* renamed from: b  reason: collision with root package name */
    final f<RecyclerView.x> f905b = new f<>();

    interface b {
        void a(RecyclerView.x xVar);

        void a(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.x xVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    O() {
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f904a.clear();
        this.f905b.a();
    }

    /* access modifiers changed from: package-private */
    public boolean b(RecyclerView.x xVar) {
        a aVar = this.f904a.get(xVar);
        if (aVar == null || (aVar.f907b & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c(RecyclerView.x xVar, RecyclerView.f.c cVar) {
        a aVar = this.f904a.get(xVar);
        if (aVar == null) {
            aVar = a.b();
            this.f904a.put(xVar, aVar);
        }
        aVar.c = cVar;
        aVar.f907b |= 4;
    }

    public void d(RecyclerView.x xVar) {
        g(xVar);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.f.c e(RecyclerView.x xVar) {
        return a(xVar, 8);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.f.c f(RecyclerView.x xVar) {
        return a(xVar, 4);
    }

    /* access modifiers changed from: package-private */
    public void g(RecyclerView.x xVar) {
        a aVar = this.f904a.get(xVar);
        if (aVar != null) {
            aVar.f907b &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void h(RecyclerView.x xVar) {
        int b2 = this.f905b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (xVar == this.f905b.c(b2)) {
                this.f905b.b(b2);
                break;
            } else {
                b2--;
            }
        }
        a remove = this.f904a.remove(xVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    private RecyclerView.f.c a(RecyclerView.x xVar, int i) {
        a d;
        RecyclerView.f.c cVar;
        int a2 = this.f904a.a((Object) xVar);
        if (a2 >= 0 && (d = this.f904a.d(a2)) != null) {
            int i2 = d.f907b;
            if ((i2 & i) != 0) {
                d.f907b = (i ^ -1) & i2;
                if (i == 4) {
                    cVar = d.c;
                } else if (i == 8) {
                    cVar = d.d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((d.f907b & 12) == 0) {
                    this.f904a.c(a2);
                    a.a(d);
                }
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.x xVar, RecyclerView.f.c cVar) {
        a aVar = this.f904a.get(xVar);
        if (aVar == null) {
            aVar = a.b();
            this.f904a.put(xVar, aVar);
        }
        aVar.d = cVar;
        aVar.f907b |= 8;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static d<a> f906a = new e(20);

        /* renamed from: b  reason: collision with root package name */
        int f907b;
        RecyclerView.f.c c;
        RecyclerView.f.c d;

        private a() {
        }

        static void a(a aVar) {
            aVar.f907b = 0;
            aVar.c = null;
            aVar.d = null;
            f906a.a(aVar);
        }

        static a b() {
            a a2 = f906a.a();
            return a2 == null ? new a() : a2;
        }

        static void a() {
            do {
            } while (f906a.a() != null);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(RecyclerView.x xVar) {
        a aVar = this.f904a.get(xVar);
        return (aVar == null || (aVar.f907b & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        a.a();
    }

    /* access modifiers changed from: package-private */
    public void a(long j, RecyclerView.x xVar) {
        this.f905b.c(j, xVar);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.x xVar, RecyclerView.f.c cVar) {
        a aVar = this.f904a.get(xVar);
        if (aVar == null) {
            aVar = a.b();
            this.f904a.put(xVar, aVar);
        }
        aVar.f907b |= 2;
        aVar.c = cVar;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.x a(long j) {
        return this.f905b.b(j);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.x xVar) {
        a aVar = this.f904a.get(xVar);
        if (aVar == null) {
            aVar = a.b();
            this.f904a.put(xVar, aVar);
        }
        aVar.f907b |= 1;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        for (int size = this.f904a.size() - 1; size >= 0; size--) {
            RecyclerView.x b2 = this.f904a.b(size);
            a c = this.f904a.c(size);
            int i = c.f907b;
            if ((i & 3) == 3) {
                bVar.a(b2);
            } else if ((i & 1) != 0) {
                RecyclerView.f.c cVar = c.c;
                if (cVar == null) {
                    bVar.a(b2);
                } else {
                    bVar.b(b2, cVar, c.d);
                }
            } else if ((i & 14) == 14) {
                bVar.a(b2, c.c, c.d);
            } else if ((i & 12) == 12) {
                bVar.c(b2, c.c, c.d);
            } else if ((i & 4) != 0) {
                bVar.b(b2, c.c, (RecyclerView.f.c) null);
            } else if ((i & 8) != 0) {
                bVar.a(b2, c.c, c.d);
            }
            a.a(c);
        }
    }
}
