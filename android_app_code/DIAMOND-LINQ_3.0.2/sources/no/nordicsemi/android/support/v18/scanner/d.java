package no.nordicsemi.android.support.v18.scanner;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import no.nordicsemi.android.support.v18.scanner.C;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f1643a;

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Object f1644a = new Object();

        /* renamed from: b  reason: collision with root package name */
        private final boolean f1645b;
        private final boolean c;
        private final boolean d;
        /* access modifiers changed from: private */
        public boolean e;
        final List<x> f;
        final C g;
        final v h;
        final Handler i;
        private final List<A> j = new ArrayList();
        private final Set<String> k = new HashSet();
        /* access modifiers changed from: private */
        public final Map<String, A> l = new HashMap();
        private final Runnable m = new C0251a(this);
        private final Runnable n = new C0253c(this);

        a(boolean z, boolean z2, List<x> list, C c2, v vVar, Handler handler) {
            this.f = Collections.unmodifiableList(list);
            this.g = c2;
            this.h = vVar;
            this.i = handler;
            boolean z3 = false;
            this.e = false;
            this.d = c2.b() != 1 && (!(Build.VERSION.SDK_INT >= 23) || !c2.n());
            this.f1645b = !list.isEmpty() && (!z2 || !c2.o());
            long k2 = c2.k();
            if (k2 > 0 && (!z || !c2.m())) {
                z3 = true;
            }
            this.c = z3;
            if (this.c) {
                handler.postDelayed(this.m, k2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.e = true;
            this.i.removeCallbacksAndMessages((Object) null);
            synchronized (this.f1644a) {
                this.l.clear();
                this.k.clear();
                this.j.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.c && !this.e) {
                synchronized (this.f1644a) {
                    this.h.a((List<A>) new ArrayList(this.j));
                    this.j.clear();
                    this.k.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, A a2) {
            boolean isEmpty;
            A put;
            if (this.e) {
                return;
            }
            if (this.f.isEmpty() || a(a2)) {
                String address = a2.a().getAddress();
                if (this.d) {
                    synchronized (this.l) {
                        isEmpty = this.l.isEmpty();
                        put = this.l.put(address, a2);
                    }
                    if (put == null && (this.g.b() & 2) > 0) {
                        this.h.a(2, a2);
                    }
                    if (isEmpty && (this.g.b() & 4) > 0) {
                        this.i.removeCallbacks(this.n);
                        this.i.postDelayed(this.n, this.g.e());
                    }
                } else if (this.c) {
                    synchronized (this.f1644a) {
                        if (!this.k.contains(address)) {
                            this.j.add(a2);
                            this.k.add(address);
                        }
                    }
                } else {
                    this.h.a(i2, a2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(List<A> list) {
            if (!this.e) {
                if (this.f1645b) {
                    ArrayList arrayList = new ArrayList();
                    for (A next : list) {
                        if (a(next)) {
                            arrayList.add(next);
                        }
                    }
                    list = arrayList;
                }
                this.h.a(list);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.h.a(i2);
        }

        private boolean a(A a2) {
            for (x a3 : this.f) {
                if (a3.a(a2)) {
                    return true;
                }
            }
            return false;
        }
    }

    d() {
    }

    public static synchronized d a() {
        synchronized (d.class) {
            if (f1643a != null) {
                d dVar = f1643a;
                return dVar;
            } else if (Build.VERSION.SDK_INT >= 26) {
                q qVar = new q();
                f1643a = qVar;
                return qVar;
            } else if (Build.VERSION.SDK_INT >= 23) {
                p pVar = new p();
                f1643a = pVar;
                return pVar;
            } else if (Build.VERSION.SDK_INT >= 21) {
                o oVar = new o();
                f1643a = oVar;
                return oVar;
            } else {
                i iVar = new i();
                f1643a = iVar;
                return iVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void a(List<x> list, C c, v vVar, Handler handler);

    /* access modifiers changed from: package-private */
    public abstract void b(v vVar);

    public final void a(List<x> list, C c, v vVar) {
        if (vVar != null) {
            Handler handler = new Handler(Looper.getMainLooper());
            if (list == null) {
                list = Collections.emptyList();
            }
            if (c == null) {
                c = new C.a().a();
            }
            a(list, c, vVar, handler);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public final void a(v vVar) {
        if (vVar != null) {
            b(vVar);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }
}
