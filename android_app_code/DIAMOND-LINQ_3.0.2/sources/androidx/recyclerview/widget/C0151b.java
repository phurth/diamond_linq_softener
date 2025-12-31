package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.b  reason: case insensitive filesystem */
class C0151b {

    /* renamed from: a  reason: collision with root package name */
    final C0028b f951a;

    /* renamed from: b  reason: collision with root package name */
    final a f952b = new a();
    final List<View> c = new ArrayList();

    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    interface C0028b {
        int a();

        View a(int i);

        void a(View view);

        void a(View view, int i);

        void a(View view, int i, ViewGroup.LayoutParams layoutParams);

        int b(View view);

        void b();

        void b(int i);

        RecyclerView.x c(View view);

        void c(int i);

        void d(View view);
    }

    C0151b(C0028b bVar) {
        this.f951a = bVar;
    }

    private int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = this.f951a.a();
        int i2 = i;
        while (i2 < a2) {
            int b2 = i - (i2 - this.f952b.b(i2));
            if (b2 == 0) {
                while (this.f952b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b2;
        }
        return -1;
    }

    private void g(View view) {
        this.c.add(view);
        this.f951a.a(view);
    }

    private boolean h(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        this.f951a.d(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z) {
        a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    public View b(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.c.get(i2);
            RecyclerView.x c2 = this.f951a.c(view);
            if (c2.i() == i && !c2.o() && !c2.q()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View c(int i) {
        return this.f951a.a(f(i));
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        int b2 = this.f951a.b(view);
        if (b2 >= 0) {
            if (this.f952b.d(b2)) {
                h(view);
            }
            this.f951a.c(b2);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i) {
        int f = f(i);
        View a2 = this.f951a.a(f);
        if (a2 != null) {
            if (this.f952b.d(f)) {
                h(a2);
            }
            this.f951a.c(f);
        }
    }

    public String toString() {
        return this.f952b.toString() + ", hidden list:" + this.c.size();
    }

    /* renamed from: androidx.recyclerview.widget.b$a */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        long f953a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f954b;

        a() {
        }

        private void b() {
            if (this.f954b == null) {
                this.f954b = new a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (i >= 64) {
                a aVar = this.f954b;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.f953a &= (1 << i) ^ -1;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i) {
            if (i < 64) {
                return (this.f953a & (1 << i)) != 0;
            }
            b();
            return this.f954b.c(i - 64);
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i) {
            if (i >= 64) {
                b();
                return this.f954b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f953a & j) != 0;
            this.f953a &= j ^ -1;
            long j2 = j - 1;
            long j3 = this.f953a;
            this.f953a = Long.rotateRight(j3 & (j2 ^ -1), 1) | (j3 & j2);
            a aVar = this.f954b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.f954b.d(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public void e(int i) {
            if (i >= 64) {
                b();
                this.f954b.e(i - 64);
                return;
            }
            this.f953a |= 1 << i;
        }

        public String toString() {
            if (this.f954b == null) {
                return Long.toBinaryString(this.f953a);
            }
            return this.f954b.toString() + "xx" + Long.toBinaryString(this.f953a);
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            a aVar = this.f954b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f953a);
                }
                return Long.bitCount(this.f953a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f953a & ((1 << i) - 1));
            } else {
                return aVar.b(i - 64) + Long.bitCount(this.f953a);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f953a = 0;
            a aVar = this.f954b;
            if (aVar != null) {
                aVar.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i, boolean z) {
            if (i >= 64) {
                b();
                this.f954b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.f953a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f953a;
            this.f953a = ((j2 & (j ^ -1)) << 1) | (j2 & j);
            if (z) {
                e(i);
            } else {
                a(i);
            }
            if (z2 || this.f954b != null) {
                b();
                this.f954b.a(0, z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f951a.a();
        } else {
            i2 = f(i);
        }
        this.f952b.a(i2, z);
        if (z) {
            g(view);
        }
        this.f951a.a(view, i2);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f952b.a();
        for (int size = this.c.size() - 1; size >= 0; size--) {
            this.f951a.d(this.c.get(size));
            this.c.remove(size);
        }
        this.f951a.b();
    }

    /* access modifiers changed from: package-private */
    public void f(View view) {
        int b2 = this.f951a.b(view);
        if (b2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f952b.c(b2)) {
            this.f952b.a(b2);
            h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    /* access modifiers changed from: package-private */
    public View d(int i) {
        return this.f951a.a(i);
    }

    /* access modifiers changed from: package-private */
    public boolean e(View view) {
        int b2 = this.f951a.b(view);
        if (b2 == -1) {
            h(view);
            return true;
        } else if (!this.f952b.c(b2)) {
            return false;
        } else {
            this.f952b.d(b2);
            h(view);
            this.f951a.c(b2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = this.f951a.a();
        } else {
            i2 = f(i);
        }
        this.f952b.a(i2, z);
        if (z) {
            g(view);
        }
        this.f951a.a(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f951a.a();
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        int b2 = this.f951a.b(view);
        if (b2 != -1 && !this.f952b.c(b2)) {
            return b2 - this.f952b.b(b2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view) {
        return this.c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f951a.a() - this.c.size();
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        int f = f(i);
        this.f952b.d(f);
        this.f951a.b(f);
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        int b2 = this.f951a.b(view);
        if (b2 >= 0) {
            this.f952b.e(b2);
            g(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }
}
