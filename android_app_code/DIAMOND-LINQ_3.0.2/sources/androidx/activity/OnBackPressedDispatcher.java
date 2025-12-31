package androidx.activity;

import a.b.a.c.b;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.l;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    final ArrayDeque<b> f362a = new ArrayDeque<>();

    private class LifecycleOnBackPressedCancellable implements g, b {

        /* renamed from: a  reason: collision with root package name */
        private final h f363a;

        /* renamed from: b  reason: collision with root package name */
        private final b f364b;
        private b c;
        private boolean d = false;

        LifecycleOnBackPressedCancellable(h hVar, b bVar) {
            this.f363a = hVar;
            this.f364b = bVar;
            hVar.a(this);
        }

        public void a(l lVar, h.a aVar) {
            if (aVar == h.a.ON_START) {
                this.c = OnBackPressedDispatcher.this.a(this.f364b);
            } else if (aVar == h.a.ON_STOP) {
                b bVar = this.c;
                if (bVar != null) {
                    bVar.cancel();
                }
            } else if (aVar == h.a.ON_DESTROY) {
                cancel();
            }
        }

        public void cancel() {
            this.f363a.b(this);
            b bVar = this.c;
            if (bVar != null) {
                bVar.cancel();
                this.c = null;
            }
            this.d = true;
        }
    }

    private class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final b f365a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f366b;

        a(b bVar) {
            this.f365a = bVar;
        }

        public void cancel() {
            synchronized (OnBackPressedDispatcher.this.f362a) {
                OnBackPressedDispatcher.this.f362a.remove(this.f365a);
                this.f366b = true;
            }
        }
    }

    OnBackPressedDispatcher() {
    }

    public b a(b bVar) {
        synchronized (this.f362a) {
            this.f362a.add(bVar);
        }
        return new a(bVar);
    }

    public b a(l lVar, b bVar) {
        h a2 = lVar.a();
        if (a2.a() == h.b.DESTROYED) {
            return b.f51a;
        }
        return new LifecycleOnBackPressedCancellable(a2, bVar);
    }

    public boolean a() {
        synchronized (this.f362a) {
            Iterator<b> descendingIterator = this.f362a.descendingIterator();
            while (descendingIterator.hasNext()) {
                if (descendingIterator.next().a()) {
                    return true;
                }
            }
            return false;
        }
    }
}
