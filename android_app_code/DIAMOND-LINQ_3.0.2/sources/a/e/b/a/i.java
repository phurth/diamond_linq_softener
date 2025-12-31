package a.e.b.a;

import a.e.b.a.f;
import a.e.b.a.h;
import a.e.b.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class i extends u {
    int Aa;
    int Ba;
    int Ca = 0;
    int Da = 0;
    d[] Ea = new d[4];
    d[] Fa = new d[4];
    public List<j> Ga = new ArrayList();
    public boolean Ha = false;
    public boolean Ia = false;
    public boolean Ja = false;
    public int Ka = 0;
    public int La = 0;
    private int Ma = 7;
    public boolean Na = false;
    private boolean Oa = false;
    private boolean Pa = false;
    int Qa = 0;
    private boolean va = false;
    protected e wa = new e();
    private t xa;
    int ya;
    int za;

    private void Y() {
        this.Ca = 0;
        this.Da = 0;
    }

    private void e(h hVar) {
        int i = this.Da + 1;
        d[] dVarArr = this.Ea;
        if (i >= dVarArr.length) {
            this.Ea = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.Ea[this.Da] = new d(hVar, 1, S());
        this.Da++;
    }

    public void E() {
        this.wa.g();
        this.ya = 0;
        this.Aa = 0;
        this.za = 0;
        this.Ba = 0;
        this.Ga.clear();
        this.Na = false;
        super.E();
    }

    /* JADX WARNING: type inference failed for: r8v10, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v11 */
    /* JADX WARNING: type inference failed for: r8v12 */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void N() {
        /*
            r21 = this;
            r1 = r21
            int r2 = r1.L
            int r3 = r1.M
            int r0 = r21.t()
            r4 = 0
            int r5 = java.lang.Math.max(r4, r0)
            int r0 = r21.j()
            int r6 = java.lang.Math.max(r4, r0)
            r1.Oa = r4
            r1.Pa = r4
            a.e.b.a.h r0 = r1.G
            if (r0 == 0) goto L_0x0046
            a.e.b.a.t r0 = r1.xa
            if (r0 != 0) goto L_0x002a
            a.e.b.a.t r0 = new a.e.b.a.t
            r0.<init>(r1)
            r1.xa = r0
        L_0x002a:
            a.e.b.a.t r0 = r1.xa
            r0.b(r1)
            int r0 = r1.ya
            r1.t(r0)
            int r0 = r1.za
            r1.u(r0)
            r21.F()
            a.e.b.e r0 = r1.wa
            a.e.b.c r0 = r0.d()
            r1.a((a.e.b.c) r0)
            goto L_0x004a
        L_0x0046:
            r1.L = r4
            r1.M = r4
        L_0x004a:
            int r0 = r1.Ma
            r7 = 8
            r8 = 32
            r9 = 1
            if (r0 == 0) goto L_0x00b7
            boolean r0 = r1.v(r7)
            if (r0 != 0) goto L_0x0062
            boolean r0 = r1.v(r8)
            if (r0 != 0) goto L_0x0062
            r21.V()
        L_0x0062:
            boolean r0 = r1.v(r8)
            if (r0 != 0) goto L_0x006b
            r21.U()
        L_0x006b:
            boolean r0 = r1.v(r4)
            if (r0 == 0) goto L_0x00b2
            java.util.ArrayList r0 = r21.L()
            int r10 = r0.size()
            r11 = 0
        L_0x007a:
            if (r11 >= r10) goto L_0x0097
            java.lang.Object r12 = r0.get(r11)
            a.e.b.a.h r12 = (a.e.b.a.h) r12
            boolean r13 = r12.A()
            if (r13 == 0) goto L_0x008b
            r12.g(r4)
        L_0x008b:
            boolean r13 = r12.B()
            if (r13 == 0) goto L_0x0094
            r12.g(r9)
        L_0x0094:
            int r11 = r11 + 1
            goto L_0x007a
        L_0x0097:
            r11 = 0
        L_0x0098:
            if (r11 >= r10) goto L_0x00b2
            java.lang.Object r12 = r0.get(r11)
            a.e.b.a.h r12 = (a.e.b.a.h) r12
            boolean r13 = r12.B()
            if (r13 != 0) goto L_0x00ac
            boolean r13 = r12.A()
            if (r13 == 0) goto L_0x00af
        L_0x00ac:
            r12.I()
        L_0x00af:
            int r11 = r11 + 1
            goto L_0x0098
        L_0x00b2:
            a.e.b.e r0 = r1.wa
            r0.i = r9
            goto L_0x00bb
        L_0x00b7:
            a.e.b.e r0 = r1.wa
            r0.i = r4
        L_0x00bb:
            a.e.b.a.h$a[] r0 = r1.F
            r10 = r0[r9]
            r11 = r0[r4]
            r21.Y()
            java.util.List<a.e.b.a.j> r0 = r1.Ga
            int r0 = r0.size()
            if (r0 != 0) goto L_0x00dd
            java.util.List<a.e.b.a.j> r0 = r1.Ga
            r0.clear()
            java.util.List<a.e.b.a.j> r0 = r1.Ga
            a.e.b.a.j r12 = new a.e.b.a.j
            java.util.ArrayList<a.e.b.a.h> r13 = r1.ua
            r12.<init>(r13)
            r0.add(r4, r12)
        L_0x00dd:
            java.util.List<a.e.b.a.j> r0 = r1.Ga
            int r12 = r0.size()
            java.util.ArrayList<a.e.b.a.h> r13 = r1.ua
            a.e.b.a.h$a r0 = r21.k()
            a.e.b.a.h$a r14 = a.e.b.a.h.a.WRAP_CONTENT
            if (r0 == r14) goto L_0x00f8
            a.e.b.a.h$a r0 = r21.r()
            a.e.b.a.h$a r14 = a.e.b.a.h.a.WRAP_CONTENT
            if (r0 != r14) goto L_0x00f6
            goto L_0x00f8
        L_0x00f6:
            r14 = 0
            goto L_0x00f9
        L_0x00f8:
            r14 = 1
        L_0x00f9:
            r0 = 0
            r15 = 0
        L_0x00fb:
            if (r15 >= r12) goto L_0x0341
            boolean r7 = r1.Na
            if (r7 != 0) goto L_0x0341
            java.util.List<a.e.b.a.j> r7 = r1.Ga
            java.lang.Object r7 = r7.get(r15)
            a.e.b.a.j r7 = (a.e.b.a.j) r7
            boolean r7 = r7.f95b
            if (r7 == 0) goto L_0x0111
            r19 = r12
            goto L_0x0335
        L_0x0111:
            boolean r7 = r1.v(r8)
            if (r7 == 0) goto L_0x0146
            a.e.b.a.h$a r7 = r21.k()
            a.e.b.a.h$a r8 = a.e.b.a.h.a.FIXED
            if (r7 != r8) goto L_0x0138
            a.e.b.a.h$a r7 = r21.r()
            a.e.b.a.h$a r8 = a.e.b.a.h.a.FIXED
            if (r7 != r8) goto L_0x0138
            java.util.List<a.e.b.a.j> r7 = r1.Ga
            java.lang.Object r7 = r7.get(r15)
            a.e.b.a.j r7 = (a.e.b.a.j) r7
            java.util.List r7 = r7.a()
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.ua = r7
            goto L_0x0146
        L_0x0138:
            java.util.List<a.e.b.a.j> r7 = r1.Ga
            java.lang.Object r7 = r7.get(r15)
            a.e.b.a.j r7 = (a.e.b.a.j) r7
            java.util.List<a.e.b.a.h> r7 = r7.f94a
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            r1.ua = r7
        L_0x0146:
            r21.Y()
            java.util.ArrayList<a.e.b.a.h> r7 = r1.ua
            int r7 = r7.size()
            r8 = 0
        L_0x0150:
            if (r8 >= r7) goto L_0x0168
            java.util.ArrayList<a.e.b.a.h> r4 = r1.ua
            java.lang.Object r4 = r4.get(r8)
            a.e.b.a.h r4 = (a.e.b.a.h) r4
            boolean r9 = r4 instanceof a.e.b.a.u
            if (r9 == 0) goto L_0x0163
            a.e.b.a.u r4 = (a.e.b.a.u) r4
            r4.N()
        L_0x0163:
            int r8 = r8 + 1
            r4 = 0
            r9 = 1
            goto L_0x0150
        L_0x0168:
            r9 = r0
            r0 = 0
            r4 = 1
        L_0x016b:
            if (r4 == 0) goto L_0x0324
            r17 = r4
            r8 = 1
            int r4 = r0 + 1
            a.e.b.e r0 = r1.wa     // Catch:{ Exception -> 0x01af }
            r0.g()     // Catch:{ Exception -> 0x01af }
            r21.Y()     // Catch:{ Exception -> 0x01af }
            a.e.b.e r0 = r1.wa     // Catch:{ Exception -> 0x01af }
            r1.b((a.e.b.e) r0)     // Catch:{ Exception -> 0x01af }
            r0 = 0
        L_0x0180:
            if (r0 >= r7) goto L_0x0196
            java.util.ArrayList<a.e.b.a.h> r8 = r1.ua     // Catch:{ Exception -> 0x01af }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ Exception -> 0x01af }
            a.e.b.a.h r8 = (a.e.b.a.h) r8     // Catch:{ Exception -> 0x01af }
            r18 = r9
            a.e.b.e r9 = r1.wa     // Catch:{ Exception -> 0x01ad }
            r8.b((a.e.b.e) r9)     // Catch:{ Exception -> 0x01ad }
            int r0 = r0 + 1
            r9 = r18
            goto L_0x0180
        L_0x0196:
            r18 = r9
            a.e.b.e r0 = r1.wa     // Catch:{ Exception -> 0x01ad }
            boolean r8 = r1.d((a.e.b.e) r0)     // Catch:{ Exception -> 0x01ad }
            if (r8 == 0) goto L_0x01a8
            a.e.b.e r0 = r1.wa     // Catch:{ Exception -> 0x01a6 }
            r0.f()     // Catch:{ Exception -> 0x01a6 }
            goto L_0x01a8
        L_0x01a6:
            r0 = move-exception
            goto L_0x01b4
        L_0x01a8:
            r17 = r8
            r19 = r12
            goto L_0x01d1
        L_0x01ad:
            r0 = move-exception
            goto L_0x01b2
        L_0x01af:
            r0 = move-exception
            r18 = r9
        L_0x01b2:
            r8 = r17
        L_0x01b4:
            r0.printStackTrace()
            java.io.PrintStream r9 = java.lang.System.out
            r17 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r19 = r12
            java.lang.String r12 = "EXCEPTION : "
            r8.append(r12)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            r9.println(r0)
        L_0x01d1:
            if (r17 == 0) goto L_0x01dc
            a.e.b.e r8 = r1.wa
            boolean[] r9 = a.e.b.a.o.f97a
            r1.a((a.e.b.e) r8, (boolean[]) r9)
        L_0x01da:
            r9 = 2
            goto L_0x0225
        L_0x01dc:
            a.e.b.e r8 = r1.wa
            r1.c((a.e.b.e) r8)
            r8 = 0
        L_0x01e2:
            if (r8 >= r7) goto L_0x01da
            java.util.ArrayList<a.e.b.a.h> r9 = r1.ua
            java.lang.Object r9 = r9.get(r8)
            a.e.b.a.h r9 = (a.e.b.a.h) r9
            a.e.b.a.h$a[] r12 = r9.F
            r16 = 0
            r12 = r12[r16]
            a.e.b.a.h$a r0 = a.e.b.a.h.a.MATCH_CONSTRAINT
            if (r12 != r0) goto L_0x0207
            int r0 = r9.t()
            int r12 = r9.v()
            if (r0 >= r12) goto L_0x0207
            boolean[] r0 = a.e.b.a.o.f97a
            r8 = 2
            r12 = 1
            r0[r8] = r12
            goto L_0x01da
        L_0x0207:
            r12 = 1
            a.e.b.a.h$a[] r0 = r9.F
            r0 = r0[r12]
            a.e.b.a.h$a r12 = a.e.b.a.h.a.MATCH_CONSTRAINT
            if (r0 != r12) goto L_0x0221
            int r0 = r9.j()
            int r9 = r9.u()
            if (r0 >= r9) goto L_0x0221
            boolean[] r0 = a.e.b.a.o.f97a
            r8 = 1
            r9 = 2
            r0[r9] = r8
            goto L_0x0225
        L_0x0221:
            r9 = 2
            int r8 = r8 + 1
            goto L_0x01e2
        L_0x0225:
            if (r14 == 0) goto L_0x029f
            r8 = 8
            if (r4 >= r8) goto L_0x029f
            boolean[] r0 = a.e.b.a.o.f97a
            boolean r0 = r0[r9]
            if (r0 == 0) goto L_0x029f
            r0 = 0
            r9 = 0
            r12 = 0
        L_0x0234:
            if (r0 >= r7) goto L_0x025e
            java.util.ArrayList<a.e.b.a.h> r8 = r1.ua
            java.lang.Object r8 = r8.get(r0)
            a.e.b.a.h r8 = (a.e.b.a.h) r8
            r17 = r4
            int r4 = r8.L
            int r20 = r8.t()
            int r4 = r4 + r20
            int r9 = java.lang.Math.max(r9, r4)
            int r4 = r8.M
            int r8 = r8.j()
            int r4 = r4 + r8
            int r12 = java.lang.Math.max(r12, r4)
            int r0 = r0 + 1
            r4 = r17
            r8 = 8
            goto L_0x0234
        L_0x025e:
            r17 = r4
            int r0 = r1.W
            int r0 = java.lang.Math.max(r0, r9)
            int r4 = r1.X
            int r4 = java.lang.Math.max(r4, r12)
            a.e.b.a.h$a r8 = a.e.b.a.h.a.WRAP_CONTENT
            if (r11 != r8) goto L_0x0284
            int r8 = r21.t()
            if (r8 >= r0) goto L_0x0284
            r1.q(r0)
            a.e.b.a.h$a[] r0 = r1.F
            a.e.b.a.h$a r8 = a.e.b.a.h.a.WRAP_CONTENT
            r9 = 0
            r0[r9] = r8
            r0 = 1
            r18 = 1
            goto L_0x0285
        L_0x0284:
            r0 = 0
        L_0x0285:
            a.e.b.a.h$a r8 = a.e.b.a.h.a.WRAP_CONTENT
            if (r10 != r8) goto L_0x029c
            int r8 = r21.j()
            if (r8 >= r4) goto L_0x029c
            r1.i(r4)
            a.e.b.a.h$a[] r0 = r1.F
            a.e.b.a.h$a r4 = a.e.b.a.h.a.WRAP_CONTENT
            r8 = 1
            r0[r8] = r4
            r0 = 1
            r9 = 1
            goto L_0x02a4
        L_0x029c:
            r9 = r18
            goto L_0x02a4
        L_0x029f:
            r17 = r4
            r9 = r18
            r0 = 0
        L_0x02a4:
            int r4 = r1.W
            int r8 = r21.t()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.t()
            if (r4 <= r8) goto L_0x02c0
            r1.q(r4)
            a.e.b.a.h$a[] r0 = r1.F
            a.e.b.a.h$a r4 = a.e.b.a.h.a.FIXED
            r8 = 0
            r0[r8] = r4
            r0 = 1
            r9 = 1
        L_0x02c0:
            int r4 = r1.X
            int r8 = r21.j()
            int r4 = java.lang.Math.max(r4, r8)
            int r8 = r21.j()
            if (r4 <= r8) goto L_0x02dd
            r1.i(r4)
            a.e.b.a.h$a[] r0 = r1.F
            a.e.b.a.h$a r4 = a.e.b.a.h.a.FIXED
            r8 = 1
            r0[r8] = r4
            r0 = 1
            r9 = 1
            goto L_0x02de
        L_0x02dd:
            r8 = 1
        L_0x02de:
            if (r9 != 0) goto L_0x031d
            a.e.b.a.h$a[] r4 = r1.F
            r12 = 0
            r4 = r4[r12]
            a.e.b.a.h$a r12 = a.e.b.a.h.a.WRAP_CONTENT
            if (r4 != r12) goto L_0x02ff
            if (r5 <= 0) goto L_0x02ff
            int r4 = r21.t()
            if (r4 <= r5) goto L_0x02ff
            r1.Oa = r8
            a.e.b.a.h$a[] r0 = r1.F
            a.e.b.a.h$a r4 = a.e.b.a.h.a.FIXED
            r9 = 0
            r0[r9] = r4
            r1.q(r5)
            r0 = 1
            r9 = 1
        L_0x02ff:
            a.e.b.a.h$a[] r4 = r1.F
            r4 = r4[r8]
            a.e.b.a.h$a r12 = a.e.b.a.h.a.WRAP_CONTENT
            if (r4 != r12) goto L_0x031d
            if (r6 <= 0) goto L_0x031d
            int r4 = r21.j()
            if (r4 <= r6) goto L_0x031d
            r1.Pa = r8
            a.e.b.a.h$a[] r0 = r1.F
            a.e.b.a.h$a r4 = a.e.b.a.h.a.FIXED
            r0[r8] = r4
            r1.i(r6)
            r4 = 1
            r9 = 1
            goto L_0x031e
        L_0x031d:
            r4 = r0
        L_0x031e:
            r0 = r17
            r12 = r19
            goto L_0x016b
        L_0x0324:
            r18 = r9
            r19 = r12
            java.util.List<a.e.b.a.j> r0 = r1.Ga
            java.lang.Object r0 = r0.get(r15)
            a.e.b.a.j r0 = (a.e.b.a.j) r0
            r0.b()
            r0 = r18
        L_0x0335:
            int r15 = r15 + 1
            r12 = r19
            r4 = 0
            r7 = 8
            r8 = 32
            r9 = 1
            goto L_0x00fb
        L_0x0341:
            r1.ua = r13
            a.e.b.a.h r4 = r1.G
            if (r4 == 0) goto L_0x0373
            int r2 = r1.W
            int r3 = r21.t()
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r1.X
            int r4 = r21.j()
            int r3 = java.lang.Math.max(r3, r4)
            a.e.b.a.t r4 = r1.xa
            r4.a(r1)
            int r4 = r1.ya
            int r2 = r2 + r4
            int r4 = r1.Aa
            int r2 = r2 + r4
            r1.q(r2)
            int r2 = r1.za
            int r3 = r3 + r2
            int r2 = r1.Ba
            int r3 = r3 + r2
            r1.i(r3)
            goto L_0x0377
        L_0x0373:
            r1.L = r2
            r1.M = r3
        L_0x0377:
            if (r0 == 0) goto L_0x0381
            a.e.b.a.h$a[] r0 = r1.F
            r2 = 0
            r0[r2] = r11
            r2 = 1
            r0[r2] = r10
        L_0x0381:
            a.e.b.e r0 = r1.wa
            a.e.b.c r0 = r0.d()
            r1.a((a.e.b.c) r0)
            a.e.b.a.i r0 = r21.M()
            if (r1 != r0) goto L_0x0393
            r21.J()
        L_0x0393:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.b.a.i.N():void");
    }

    public int P() {
        return this.Ma;
    }

    public boolean Q() {
        return false;
    }

    public boolean R() {
        return this.Pa;
    }

    public boolean S() {
        return this.va;
    }

    public boolean T() {
        return this.Oa;
    }

    public void U() {
        if (!v(8)) {
            a(this.Ma);
        }
        X();
    }

    public void V() {
        int size = this.ua.size();
        G();
        for (int i = 0; i < size; i++) {
            this.ua.get(i).G();
        }
    }

    public void W() {
        V();
        a(this.Ma);
    }

    public void X() {
        q d = a(f.c.LEFT).d();
        q d2 = a(f.c.TOP).d();
        d.a((q) null, 0.0f);
        d2.a((q) null, 0.0f);
    }

    public void a(e eVar, boolean[] zArr) {
        zArr[2] = false;
        c(eVar);
        int size = this.ua.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.ua.get(i);
            hVar.c(eVar);
            if (hVar.F[0] == h.a.MATCH_CONSTRAINT && hVar.t() < hVar.v()) {
                zArr[2] = true;
            }
            if (hVar.F[1] == h.a.MATCH_CONSTRAINT && hVar.j() < hVar.u()) {
                zArr[2] = true;
            }
        }
    }

    public void c(boolean z) {
        this.va = z;
    }

    public boolean d(e eVar) {
        a(eVar);
        int size = this.ua.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.ua.get(i);
            if (hVar instanceof i) {
                h.a[] aVarArr = hVar.F;
                h.a aVar = aVarArr[0];
                h.a aVar2 = aVarArr[1];
                if (aVar == h.a.WRAP_CONTENT) {
                    hVar.a(h.a.FIXED);
                }
                if (aVar2 == h.a.WRAP_CONTENT) {
                    hVar.b(h.a.FIXED);
                }
                hVar.a(eVar);
                if (aVar == h.a.WRAP_CONTENT) {
                    hVar.a(aVar);
                }
                if (aVar2 == h.a.WRAP_CONTENT) {
                    hVar.b(aVar2);
                }
            } else {
                o.a(this, eVar, hVar);
                hVar.a(eVar);
            }
        }
        if (this.Ca > 0) {
            c.a(this, eVar, 0);
        }
        if (this.Da > 0) {
            c.a(this, eVar, 1);
        }
        return true;
    }

    public void f(int i, int i2) {
        r rVar;
        r rVar2;
        if (!(this.F[0] == h.a.WRAP_CONTENT || (rVar2 = this.d) == null)) {
            rVar2.a(i);
        }
        if (this.F[1] != h.a.WRAP_CONTENT && (rVar = this.e) != null) {
            rVar.a(i2);
        }
    }

    public boolean v(int i) {
        return (this.Ma & i) == i;
    }

    public void w(int i) {
        this.Ma = i;
    }

    public void a(int i) {
        super.a(i);
        int size = this.ua.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.ua.get(i2).a(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar, int i) {
        if (i == 0) {
            d(hVar);
        } else if (i == 1) {
            e(hVar);
        }
    }

    private void d(h hVar) {
        int i = this.Ca + 1;
        d[] dVarArr = this.Fa;
        if (i >= dVarArr.length) {
            this.Fa = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.Fa[this.Ca] = new d(hVar, 0, S());
        this.Ca++;
    }
}
