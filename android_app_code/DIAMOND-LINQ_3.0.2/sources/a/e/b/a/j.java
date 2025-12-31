package a.e.b.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public List<h> f94a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f95b = false;
    public final int[] c = {-1, -1};
    List<h> d = new ArrayList();
    List<h> e = new ArrayList();
    HashSet<h> f = new HashSet<>();
    HashSet<h> g = new HashSet<>();
    List<h> h = new ArrayList();
    List<h> i = new ArrayList();

    j(List<h> list) {
        this.f94a = list;
    }

    public List<h> a(int i2) {
        if (i2 == 0) {
            return this.d;
        }
        if (i2 == 1) {
            return this.e;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Set<h> b(int i2) {
        if (i2 == 0) {
            return this.f;
        }
        if (i2 == 1) {
            return this.g;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar, int i2) {
        if (i2 == 0) {
            this.f.add(hVar);
        } else if (i2 == 1) {
            this.g.add(hVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int size = this.i.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.i.get(i2));
        }
    }

    /* access modifiers changed from: package-private */
    public List<h> a() {
        if (!this.h.isEmpty()) {
            return this.h;
        }
        int size = this.f94a.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.f94a.get(i2);
            if (!hVar.ja) {
                a((ArrayList<h>) (ArrayList) this.h, hVar);
            }
        }
        this.i.clear();
        this.i.addAll(this.f94a);
        this.i.removeAll(this.h);
        return this.h;
    }

    j(List<h> list, boolean z) {
        this.f94a = list;
        this.f95b = z;
    }

    private void a(ArrayList<h> arrayList, h hVar) {
        if (!hVar.ka) {
            arrayList.add(hVar);
            hVar.ka = true;
            if (!hVar.z()) {
                if (hVar instanceof n) {
                    n nVar = (n) hVar;
                    int i2 = nVar.va;
                    for (int i3 = 0; i3 < i2; i3++) {
                        a(arrayList, nVar.ua[i3]);
                    }
                }
                for (f fVar : hVar.D) {
                    f fVar2 = fVar.d;
                    if (fVar2 != null) {
                        h hVar2 = fVar2.f81b;
                        if (!(fVar2 == null || hVar2 == hVar.l())) {
                            a(arrayList, hVar2);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0093  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(a.e.b.a.h r7) {
        /*
            r6 = this;
            boolean r0 = r7.ja
            if (r0 == 0) goto L_0x00ee
            boolean r0 = r7.z()
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            a.e.b.a.f r0 = r7.x
            a.e.b.a.f r0 = r0.d
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x001d
            a.e.b.a.f r3 = r7.x
            a.e.b.a.f r3 = r3.d
            goto L_0x0021
        L_0x001d:
            a.e.b.a.f r3 = r7.v
            a.e.b.a.f r3 = r3.d
        L_0x0021:
            if (r3 == 0) goto L_0x0049
            a.e.b.a.h r4 = r3.f81b
            boolean r4 = r4.f(r1)
            if (r4 != 0) goto L_0x0030
            a.e.b.a.h r4 = r3.f81b
            r6.a((a.e.b.a.h) r4)
        L_0x0030:
            a.e.b.a.f$c r4 = r3.c
            a.e.b.a.f$c r5 = a.e.b.a.f.c.RIGHT
            if (r4 != r5) goto L_0x0040
            a.e.b.a.h r3 = r3.f81b
            int r4 = r3.L
            int r3 = r3.t()
            int r3 = r3 + r4
            goto L_0x004a
        L_0x0040:
            a.e.b.a.f$c r5 = a.e.b.a.f.c.LEFT
            if (r4 != r5) goto L_0x0049
            a.e.b.a.h r3 = r3.f81b
            int r3 = r3.L
            goto L_0x004a
        L_0x0049:
            r3 = 0
        L_0x004a:
            if (r0 == 0) goto L_0x0054
            a.e.b.a.f r0 = r7.x
            int r0 = r0.b()
            int r3 = r3 - r0
            goto L_0x0060
        L_0x0054:
            a.e.b.a.f r0 = r7.v
            int r0 = r0.b()
            int r4 = r7.t()
            int r0 = r0 + r4
            int r3 = r3 + r0
        L_0x0060:
            int r0 = r7.t()
            int r0 = r3 - r0
            r7.a(r0, r3)
            a.e.b.a.o.a((a.e.b.a.h) r7, (int) r1, (int) r0)
            a.e.b.a.f r0 = r7.z
            a.e.b.a.f r0 = r0.d
            if (r0 == 0) goto L_0x0093
            a.e.b.a.h r1 = r0.f81b
            boolean r1 = r1.f(r2)
            if (r1 != 0) goto L_0x007f
            a.e.b.a.h r1 = r0.f81b
            r6.a((a.e.b.a.h) r1)
        L_0x007f:
            a.e.b.a.h r0 = r0.f81b
            int r1 = r0.M
            int r0 = r0.V
            int r1 = r1 + r0
            int r0 = r7.V
            int r1 = r1 - r0
            int r0 = r7.I
            int r0 = r0 + r1
            r7.e(r1, r0)
            a.e.b.a.o.a((a.e.b.a.h) r7, (int) r2, (int) r1)
            return
        L_0x0093:
            a.e.b.a.f r0 = r7.y
            a.e.b.a.f r0 = r0.d
            if (r0 == 0) goto L_0x009a
            r1 = 1
        L_0x009a:
            if (r1 == 0) goto L_0x00a1
            a.e.b.a.f r0 = r7.y
            a.e.b.a.f r0 = r0.d
            goto L_0x00a5
        L_0x00a1:
            a.e.b.a.f r0 = r7.w
            a.e.b.a.f r0 = r0.d
        L_0x00a5:
            if (r0 == 0) goto L_0x00cc
            a.e.b.a.h r4 = r0.f81b
            boolean r4 = r4.f(r2)
            if (r4 != 0) goto L_0x00b4
            a.e.b.a.h r4 = r0.f81b
            r6.a((a.e.b.a.h) r4)
        L_0x00b4:
            a.e.b.a.f$c r4 = r0.c
            a.e.b.a.f$c r5 = a.e.b.a.f.c.BOTTOM
            if (r4 != r5) goto L_0x00c4
            a.e.b.a.h r0 = r0.f81b
            int r3 = r0.M
            int r0 = r0.j()
            int r3 = r3 + r0
            goto L_0x00cc
        L_0x00c4:
            a.e.b.a.f$c r5 = a.e.b.a.f.c.TOP
            if (r4 != r5) goto L_0x00cc
            a.e.b.a.h r0 = r0.f81b
            int r3 = r0.M
        L_0x00cc:
            if (r1 == 0) goto L_0x00d6
            a.e.b.a.f r0 = r7.y
            int r0 = r0.b()
            int r3 = r3 - r0
            goto L_0x00e2
        L_0x00d6:
            a.e.b.a.f r0 = r7.w
            int r0 = r0.b()
            int r1 = r7.j()
            int r0 = r0 + r1
            int r3 = r3 + r0
        L_0x00e2:
            int r0 = r7.j()
            int r0 = r3 - r0
            r7.e(r0, r3)
            a.e.b.a.o.a((a.e.b.a.h) r7, (int) r2, (int) r0)
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.b.a.j.a(a.e.b.a.h):void");
    }
}
