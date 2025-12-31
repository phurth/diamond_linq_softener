package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<q> f984a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static Comparator<b> f985b = new p();
    ArrayList<RecyclerView> c = new ArrayList<>();
    long d;
    long e;
    private ArrayList<b> f = new ArrayList<>();

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f988a;

        /* renamed from: b  reason: collision with root package name */
        public int f989b;
        public int c;
        public RecyclerView d;
        public int e;

        b() {
        }

        public void a() {
            this.f988a = false;
            this.f989b = 0;
            this.c = 0;
            this.d = null;
            this.e = 0;
        }
    }

    q() {
    }

    public void a(RecyclerView recyclerView) {
        this.c.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.c.remove(recyclerView);
    }

    public void run() {
        try {
            a.g.e.a.a("RV Prefetch");
            if (!this.c.isEmpty()) {
                int size = this.c.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.c.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j) + this.e);
                    this.d = 0;
                    a.g.e.a.a();
                }
            }
        } finally {
            this.d = 0;
            a.g.e.a.a();
        }
    }

    private void b(long j) {
        int i = 0;
        while (i < this.f.size()) {
            b bVar = this.f.get(i);
            if (bVar.d != null) {
                a(bVar, j);
                bVar.a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.d == 0) {
            this.d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.qa.b(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.c.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.qa.a(recyclerView, false);
                i += recyclerView.qa.d;
            }
        }
        this.f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.c.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.qa;
                int abs = Math.abs(aVar.f986a) + Math.abs(aVar.f987b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.d * 2; i6 += 2) {
                    if (i5 >= this.f.size()) {
                        bVar = new b();
                        this.f.add(bVar);
                    } else {
                        bVar = this.f.get(i5);
                    }
                    int i7 = aVar.c[i6 + 1];
                    bVar.f988a = i7 <= abs;
                    bVar.f989b = abs;
                    bVar.c = i7;
                    bVar.d = recyclerView2;
                    bVar.e = aVar.c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f, f985b);
    }

    @SuppressLint({"VisibleForTests"})
    static class a implements RecyclerView.i.a {

        /* renamed from: a  reason: collision with root package name */
        int f986a;

        /* renamed from: b  reason: collision with root package name */
        int f987b;
        int[] c;
        int d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.i iVar = recyclerView.w;
            if (recyclerView.v != null && iVar != null && iVar.v()) {
                if (z) {
                    if (!recyclerView.n.c()) {
                        iVar.a(recyclerView.v.a(), (RecyclerView.i.a) this);
                    }
                } else if (!recyclerView.j()) {
                    iVar.a(this.f986a, this.f987b, recyclerView.ra, (RecyclerView.i.a) this);
                }
                int i = this.d;
                if (i > iVar.m) {
                    iVar.m = i;
                    iVar.n = z;
                    recyclerView.l.j();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i, int i2) {
            this.f986a = i;
            this.f987b = i2;
        }

        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.d * 2;
                int[] iArr = this.c;
                if (iArr == null) {
                    this.c = new int[4];
                    Arrays.fill(this.c, -1);
                } else if (i3 >= iArr.length) {
                    this.c = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.c, 0, iArr.length);
                }
                int[] iArr2 = this.c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.d = 0;
        }
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int b2 = recyclerView.o.b();
        for (int i2 = 0; i2 < b2; i2++) {
            RecyclerView.x g = RecyclerView.g(recyclerView.o.d(i2));
            if (g.d == i && !g.o()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.x a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.p pVar = recyclerView.l;
        try {
            recyclerView.q();
            RecyclerView.x a2 = pVar.a(i, false, j);
            if (a2 != null) {
                if (!a2.n() || a2.o()) {
                    pVar.a(a2, false);
                } else {
                    pVar.b(a2.f936b);
                }
            }
            return a2;
        } finally {
            recyclerView.a(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.N && recyclerView.o.b() != 0) {
                recyclerView.t();
            }
            a aVar = recyclerView.qa;
            aVar.a(recyclerView, true);
            if (aVar.d != 0) {
                try {
                    a.g.e.a.a("RV Nested Prefetch");
                    recyclerView.ra.a(recyclerView.v);
                    for (int i = 0; i < aVar.d * 2; i += 2) {
                        a(recyclerView, aVar.c[i], j);
                    }
                } finally {
                    a.g.e.a.a();
                }
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.x a2 = a(bVar.d, bVar.e, bVar.f988a ? Long.MAX_VALUE : j);
        if (a2 != null && a2.c != null && a2.n() && !a2.o()) {
            a((RecyclerView) a2.c.get(), j);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        a();
        b(j);
    }
}
