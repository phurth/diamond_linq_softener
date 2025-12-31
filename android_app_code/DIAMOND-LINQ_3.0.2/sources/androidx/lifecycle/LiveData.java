package androidx.lifecycle;

import a.b.a.a.c;
import a.b.a.b.b;
import androidx.lifecycle.h;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    static final Object f851a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final Object f852b = new Object();
    private b<t<? super T>, LiveData<T>.a> c = new b<>();
    int d = 0;
    private volatile Object e = f851a;
    volatile Object f = f851a;
    private int g = -1;
    private boolean h;
    private boolean i;
    private final Runnable j = new q(this);

    private abstract class a {

        /* renamed from: a  reason: collision with root package name */
        final t<? super T> f853a;

        /* renamed from: b  reason: collision with root package name */
        boolean f854b;
        int c = -1;

        a(t<? super T> tVar) {
            this.f853a = tVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            if (z != this.f854b) {
                this.f854b = z;
                int i = 1;
                boolean z2 = LiveData.this.d == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.d;
                if (!this.f854b) {
                    i = -1;
                }
                liveData.d = i2 + i;
                if (z2 && this.f854b) {
                    LiveData.this.a();
                }
                LiveData liveData2 = LiveData.this;
                if (liveData2.d == 0 && !this.f854b) {
                    liveData2.b();
                }
                if (this.f854b) {
                    LiveData.this.a((LiveData<T>.a) this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(l lVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean b();
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.f854b) {
            if (!aVar.b()) {
                aVar.a(false);
                return;
            }
            int i2 = aVar.c;
            int i3 = this.g;
            if (i2 < i3) {
                aVar.c = i3;
                aVar.f853a.a(this.e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: package-private */
    public void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar == null) {
                b<K, V>.d b2 = this.c.b();
                while (b2.hasNext()) {
                    b((a) ((Map.Entry) b2.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            } else {
                b(aVar);
                aVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    class LifecycleBoundObserver extends LiveData<T>.a implements j {
        final l e;

        LifecycleBoundObserver(l lVar, t<? super T> tVar) {
            super(tVar);
            this.e = lVar;
        }

        public void a(l lVar, h.a aVar) {
            if (this.e.a().a() == h.b.DESTROYED) {
                LiveData.this.a(this.f853a);
            } else {
                a(b());
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.e.a().a().a(h.b.STARTED);
        }

        /* access modifiers changed from: package-private */
        public boolean a(l lVar) {
            return this.e == lVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.e.a().b(this);
        }
    }

    public void a(l lVar, t<? super T> tVar) {
        a("observe");
        if (lVar.a().a() != h.b.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lVar, tVar);
            a b2 = this.c.b(tVar, lifecycleBoundObserver);
            if (b2 != null && !b2.a(lVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (b2 == null) {
                lVar.a().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(t<? super T> tVar) {
        a("removeObserver");
        a remove = this.c.remove(tVar);
        if (remove != null) {
            remove.a();
            remove.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t) {
        a("setValue");
        this.g++;
        this.e = t;
        a((LiveData<T>.a) null);
    }

    static void a(String str) {
        if (!c.b().a()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }
}
