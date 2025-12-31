package a.e.b.a;

import a.e.b.a.h;
import a.e.b.e;

public class o {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f97a = new boolean[3];

    static void a(i iVar, e eVar, h hVar) {
        if (iVar.F[0] != h.a.WRAP_CONTENT && hVar.F[0] == h.a.MATCH_PARENT) {
            int i = hVar.v.e;
            int t = iVar.t() - hVar.x.e;
            f fVar = hVar.v;
            fVar.j = eVar.a((Object) fVar);
            f fVar2 = hVar.x;
            fVar2.j = eVar.a((Object) fVar2);
            eVar.a(hVar.v.j, i);
            eVar.a(hVar.x.j, t);
            hVar.f91b = 2;
            hVar.a(i, t);
        }
        if (iVar.F[1] != h.a.WRAP_CONTENT && hVar.F[1] == h.a.MATCH_PARENT) {
            int i2 = hVar.w.e;
            int j = iVar.j() - hVar.y.e;
            f fVar3 = hVar.w;
            fVar3.j = eVar.a((Object) fVar3);
            f fVar4 = hVar.y;
            fVar4.j = eVar.a((Object) fVar4);
            eVar.a(hVar.w.j, i2);
            eVar.a(hVar.y.j, j);
            if (hVar.V > 0 || hVar.s() == 8) {
                f fVar5 = hVar.z;
                fVar5.j = eVar.a((Object) fVar5);
                eVar.a(hVar.z.j, hVar.V + i2);
            }
            hVar.c = 2;
            hVar.e(i2, j);
        }
    }

    private static boolean b(h hVar, int i, int i2) {
        if (hVar.J != 0.0f) {
            if (hVar.F[i == 0 ? (char) 1 : 0] != h.a.MATCH_CONSTRAINT && (i2 & 16) == 16) {
                return true;
            }
            return false;
        }
        return true;
    }

    private static boolean a(h hVar, int i) {
        if (hVar.F[i] != h.a.MATCH_CONSTRAINT) {
            return false;
        }
        if (i == 0) {
            if (hVar.f == 0 && hVar.i == 0 && hVar.j == 0) {
                return true;
            }
            return false;
        } else if (hVar.g == 0 && hVar.l == 0 && hVar.m == 0) {
            return true;
        } else {
            return false;
        }
    }

    static void a(int i, h hVar) {
        int i2 = i;
        h hVar2 = hVar;
        hVar.K();
        q d = hVar2.v.d();
        q d2 = hVar2.w.d();
        q d3 = hVar2.x.d();
        q d4 = hVar2.y.d();
        boolean z = false;
        boolean z2 = (i2 & 8) == 8;
        boolean z3 = hVar2.F[0] == h.a.MATCH_CONSTRAINT && a(hVar2, 0);
        if (!(d.i == 4 || d3.i == 4)) {
            if (hVar2.F[0] == h.a.FIXED || (z3 && hVar.s() == 8)) {
                if (hVar2.v.d == null && hVar2.x.d == null) {
                    d.b(1);
                    d3.b(1);
                    if (z2) {
                        d3.a(d, 1, hVar.n());
                    } else {
                        d3.a(d, hVar.t());
                    }
                } else if (hVar2.v.d != null && hVar2.x.d == null) {
                    d.b(1);
                    d3.b(1);
                    if (z2) {
                        d3.a(d, 1, hVar.n());
                    } else {
                        d3.a(d, hVar.t());
                    }
                } else if (hVar2.v.d == null && hVar2.x.d != null) {
                    d.b(1);
                    d3.b(1);
                    d.a(d3, -hVar.t());
                    if (z2) {
                        d.a(d3, -1, hVar.n());
                    } else {
                        d.a(d3, -hVar.t());
                    }
                } else if (!(hVar2.v.d == null || hVar2.x.d == null)) {
                    d.b(2);
                    d3.b(2);
                    if (z2) {
                        hVar.n().a(d);
                        hVar.n().a(d3);
                        d.b(d3, -1, hVar.n());
                        d3.b(d, 1, hVar.n());
                    } else {
                        d.b(d3, (float) (-hVar.t()));
                        d3.b(d, (float) hVar.t());
                    }
                }
            } else if (z3 && b(hVar2, 0, i2)) {
                a.a(hVar);
                int t = hVar.t();
                d.b(1);
                d3.b(1);
                if (hVar2.v.d == null && hVar2.x.d == null) {
                    if (z2) {
                        d3.a(d, 1, hVar.n());
                    } else {
                        d3.a(d, t);
                    }
                } else if (hVar2.v.d == null || hVar2.x.d != null) {
                    if (hVar2.v.d != null || hVar2.x.d == null) {
                        if (!(hVar2.v.d == null || hVar2.x.d == null)) {
                            if (z2) {
                                hVar.n().a(d);
                                hVar.n().a(d3);
                            }
                            if (hVar2.J == 0.0f) {
                                d.b(3);
                                d3.b(3);
                                d.b(d3, 0.0f);
                                d3.b(d, 0.0f);
                            } else {
                                d.b(2);
                                d3.b(2);
                                d.b(d3, (float) (-t));
                                d3.b(d, (float) t);
                                hVar2.q(t);
                            }
                        }
                    } else if (z2) {
                        d.a(d3, -1, hVar.n());
                    } else {
                        d.a(d3, -t);
                    }
                } else if (z2) {
                    d3.a(d, 1, hVar.n());
                } else {
                    d3.a(d, t);
                }
            }
        }
        if (hVar2.F[1] == h.a.MATCH_CONSTRAINT && a(hVar2, 1)) {
            z = true;
        }
        if (d2.i != 4 && d4.i != 4) {
            if (hVar2.F[1] == h.a.FIXED || (z && hVar.s() == 8)) {
                if (hVar2.w.d == null && hVar2.y.d == null) {
                    d2.b(1);
                    d4.b(1);
                    if (z2) {
                        d4.a(d2, 1, hVar.m());
                    } else {
                        d4.a(d2, hVar.j());
                    }
                    f fVar = hVar2.z;
                    if (fVar.d != null) {
                        fVar.d().b(1);
                        d2.a(1, hVar2.z.d(), -hVar2.V);
                    }
                } else if (hVar2.w.d != null && hVar2.y.d == null) {
                    d2.b(1);
                    d4.b(1);
                    if (z2) {
                        d4.a(d2, 1, hVar.m());
                    } else {
                        d4.a(d2, hVar.j());
                    }
                    if (hVar2.V > 0) {
                        hVar2.z.d().a(1, d2, hVar2.V);
                    }
                } else if (hVar2.w.d == null && hVar2.y.d != null) {
                    d2.b(1);
                    d4.b(1);
                    if (z2) {
                        d2.a(d4, -1, hVar.m());
                    } else {
                        d2.a(d4, -hVar.j());
                    }
                    if (hVar2.V > 0) {
                        hVar2.z.d().a(1, d2, hVar2.V);
                    }
                } else if (hVar2.w.d != null && hVar2.y.d != null) {
                    d2.b(2);
                    d4.b(2);
                    if (z2) {
                        d2.b(d4, -1, hVar.m());
                        d4.b(d2, 1, hVar.m());
                        hVar.m().a(d2);
                        hVar.n().a(d4);
                    } else {
                        d2.b(d4, (float) (-hVar.j()));
                        d4.b(d2, (float) hVar.j());
                    }
                    if (hVar2.V > 0) {
                        hVar2.z.d().a(1, d2, hVar2.V);
                    }
                }
            } else if (z && b(hVar2, 1, i2)) {
                a.a(hVar);
                int j = hVar.j();
                d2.b(1);
                d4.b(1);
                if (hVar2.w.d == null && hVar2.y.d == null) {
                    if (z2) {
                        d4.a(d2, 1, hVar.m());
                    } else {
                        d4.a(d2, j);
                    }
                } else if (hVar2.w.d == null || hVar2.y.d != null) {
                    if (hVar2.w.d != null || hVar2.y.d == null) {
                        if (hVar2.w.d != null && hVar2.y.d != null) {
                            if (z2) {
                                hVar.m().a(d2);
                                hVar.n().a(d4);
                            }
                            if (hVar2.J == 0.0f) {
                                d2.b(3);
                                d4.b(3);
                                d2.b(d4, 0.0f);
                                d4.b(d2, 0.0f);
                                return;
                            }
                            d2.b(2);
                            d4.b(2);
                            d2.b(d4, (float) (-j));
                            d4.b(d2, (float) j);
                            hVar2.i(j);
                            if (hVar2.V > 0) {
                                hVar2.z.d().a(1, d2, hVar2.V);
                            }
                        }
                    } else if (z2) {
                        d2.a(d4, -1, hVar.m());
                    } else {
                        d2.a(d4, -j);
                    }
                } else if (z2) {
                    d4.a(d2, 1, hVar.m());
                } else {
                    d4.a(d2, j);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        if (r7.la == 2) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0057, code lost:
        if (r7.ma == 2) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(a.e.b.a.i r20, a.e.b.e r21, int r22, int r23, a.e.b.a.d r24) {
        /*
            r0 = r21
            r1 = r22
            r2 = r24
            a.e.b.a.h r3 = r2.f77a
            a.e.b.a.h r4 = r2.c
            a.e.b.a.h r5 = r2.f78b
            a.e.b.a.h r6 = r2.d
            a.e.b.a.h r7 = r2.e
            int r8 = r2.j
            float r9 = r2.k
            a.e.b.a.h r10 = r2.f
            a.e.b.a.h r10 = r2.g
            r11 = r20
            a.e.b.a.h$a[] r10 = r11.F
            r10 = r10[r1]
            a.e.b.a.h$a r11 = a.e.b.a.h.a.WRAP_CONTENT
            int r10 = r2.m
            float r10 = (float) r10
            int r11 = r2.n
            int r11 = r2.l
            boolean r2 = r2.o
            r12 = 0
            if (r2 != 0) goto L_0x002d
            return r12
        L_0x002d:
            r2 = 2
            r13 = 1
            if (r1 != 0) goto L_0x0047
            int r14 = r7.la
            if (r14 != 0) goto L_0x0037
            r14 = 1
            goto L_0x0038
        L_0x0037:
            r14 = 0
        L_0x0038:
            int r15 = r7.la
            if (r15 != r13) goto L_0x003e
            r15 = 1
            goto L_0x003f
        L_0x003e:
            r15 = 0
        L_0x003f:
            int r7 = r7.la
            if (r7 != r2) goto L_0x0045
        L_0x0043:
            r2 = 1
            goto L_0x005a
        L_0x0045:
            r2 = 0
            goto L_0x005a
        L_0x0047:
            int r14 = r7.ma
            if (r14 != 0) goto L_0x004d
            r14 = 1
            goto L_0x004e
        L_0x004d:
            r14 = 0
        L_0x004e:
            int r15 = r7.ma
            if (r15 != r13) goto L_0x0054
            r15 = 1
            goto L_0x0055
        L_0x0054:
            r15 = 0
        L_0x0055:
            int r7 = r7.ma
            if (r7 != r2) goto L_0x0045
            goto L_0x0043
        L_0x005a:
            a.e.b.a.f[] r7 = r3.D
            r7 = r7[r23]
            a.e.b.a.q r7 = r7.d()
            a.e.b.a.f[] r12 = r4.D
            int r16 = r23 + 1
            r12 = r12[r16]
            a.e.b.a.q r12 = r12.d()
            a.e.b.a.q r13 = r7.e
            if (r13 == 0) goto L_0x02de
            r17 = r11
            a.e.b.a.q r11 = r12.e
            if (r11 != 0) goto L_0x0078
            goto L_0x02de
        L_0x0078:
            int r13 = r13.f99b
            r0 = 1
            if (r13 != r0) goto L_0x02dc
            int r11 = r11.f99b
            if (r11 == r0) goto L_0x0083
            goto L_0x02dc
        L_0x0083:
            r0 = 0
            if (r2 != 0) goto L_0x008d
            if (r14 != 0) goto L_0x008d
            if (r15 == 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r11 = 0
            goto L_0x00a6
        L_0x008d:
            if (r5 == 0) goto L_0x0099
            a.e.b.a.f[] r11 = r5.D
            r11 = r11[r23]
            int r11 = r11.b()
            float r11 = (float) r11
            goto L_0x009a
        L_0x0099:
            r11 = 0
        L_0x009a:
            if (r6 == 0) goto L_0x00a6
            a.e.b.a.f[] r13 = r6.D
            r13 = r13[r16]
            int r13 = r13.b()
            float r13 = (float) r13
            float r11 = r11 + r13
        L_0x00a6:
            a.e.b.a.q r13 = r7.e
            float r13 = r13.h
            a.e.b.a.q r12 = r12.e
            float r12 = r12.h
            int r18 = (r13 > r12 ? 1 : (r13 == r12 ? 0 : -1))
            if (r18 >= 0) goto L_0x00b4
            float r12 = r12 - r13
            goto L_0x00b6
        L_0x00b4:
            float r12 = r13 - r12
        L_0x00b6:
            float r12 = r12 - r10
            r10 = 8
            r18 = 1
            if (r8 <= 0) goto L_0x0187
            a.e.b.a.h r2 = r3.l()
            if (r2 == 0) goto L_0x00d1
            a.e.b.a.h r2 = r3.l()
            a.e.b.a.h$a[] r2 = r2.F
            r2 = r2[r1]
            a.e.b.a.h$a r11 = a.e.b.a.h.a.WRAP_CONTENT
            if (r2 != r11) goto L_0x00d1
            r2 = 0
            return r2
        L_0x00d1:
            if (r5 == 0) goto L_0x00dd
            a.e.b.a.f[] r2 = r5.D
            r2 = r2[r23]
            int r2 = r2.b()
            float r2 = (float) r2
            float r12 = r12 - r2
        L_0x00dd:
            if (r6 == 0) goto L_0x00e9
            a.e.b.a.f[] r2 = r6.D
            r2 = r2[r16]
            int r2 = r2.b()
            float r2 = (float) r2
            float r12 = r12 - r2
        L_0x00e9:
            if (r3 == 0) goto L_0x0185
            a.e.b.f r2 = a.e.b.e.f109b
            if (r2 == 0) goto L_0x0101
            long r5 = r2.z
            long r5 = r5 - r18
            r2.z = r5
            long r5 = r2.r
            long r5 = r5 + r18
            r2.r = r5
            long r5 = r2.x
            long r5 = r5 + r18
            r2.x = r5
        L_0x0101:
            a.e.b.a.h[] r2 = r3.ra
            r2 = r2[r1]
            if (r2 != 0) goto L_0x010e
            if (r3 != r4) goto L_0x010a
            goto L_0x010e
        L_0x010a:
            r6 = r21
            goto L_0x0182
        L_0x010e:
            a.e.b.a.h$a r5 = r3.c((int) r1)
            a.e.b.a.h$a r6 = a.e.b.a.h.a.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0136
            float r5 = (float) r8
            float r5 = r12 / r5
            int r6 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x012e
            float[] r5 = r3.pa
            r6 = r5[r1]
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r6 != 0) goto L_0x0129
            r5 = 0
            goto L_0x012e
        L_0x0129:
            r5 = r5[r1]
            float r5 = r5 * r12
            float r5 = r5 / r9
        L_0x012e:
            int r6 = r3.s()
            if (r6 != r10) goto L_0x013b
            r5 = 0
            goto L_0x013b
        L_0x0136:
            int r5 = r3.d((int) r1)
            float r5 = (float) r5
        L_0x013b:
            a.e.b.a.f[] r6 = r3.D
            r6 = r6[r23]
            int r6 = r6.b()
            float r6 = (float) r6
            float r13 = r13 + r6
            a.e.b.a.f[] r6 = r3.D
            r6 = r6[r23]
            a.e.b.a.q r6 = r6.d()
            a.e.b.a.q r11 = r7.g
            r6.a((a.e.b.a.q) r11, (float) r13)
            a.e.b.a.f[] r6 = r3.D
            r6 = r6[r16]
            a.e.b.a.q r6 = r6.d()
            a.e.b.a.q r11 = r7.g
            float r13 = r13 + r5
            r6.a((a.e.b.a.q) r11, (float) r13)
            a.e.b.a.f[] r5 = r3.D
            r5 = r5[r23]
            a.e.b.a.q r5 = r5.d()
            r6 = r21
            r5.a((a.e.b.e) r6)
            a.e.b.a.f[] r5 = r3.D
            r5 = r5[r16]
            a.e.b.a.q r5 = r5.d()
            r5.a((a.e.b.e) r6)
            a.e.b.a.f[] r3 = r3.D
            r3 = r3[r16]
            int r3 = r3.b()
            float r3 = (float) r3
            float r13 = r13 + r3
        L_0x0182:
            r3 = r2
            goto L_0x00e9
        L_0x0185:
            r2 = 1
            return r2
        L_0x0187:
            r6 = r21
            int r0 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0190
            r2 = 1
            r14 = 0
            r15 = 0
        L_0x0190:
            if (r2 == 0) goto L_0x020d
            float r12 = r12 - r11
            float r0 = r3.b((int) r1)
            float r12 = r12 * r0
            float r13 = r13 + r12
        L_0x019a:
            if (r3 == 0) goto L_0x0212
            a.e.b.f r0 = a.e.b.e.f109b
            if (r0 == 0) goto L_0x01b2
            long r8 = r0.z
            long r8 = r8 - r18
            r0.z = r8
            long r8 = r0.r
            long r8 = r8 + r18
            r0.r = r8
            long r8 = r0.x
            long r8 = r8 + r18
            r0.x = r8
        L_0x01b2:
            a.e.b.a.h[] r0 = r3.ra
            r0 = r0[r1]
            if (r0 != 0) goto L_0x01ba
            if (r3 != r4) goto L_0x020b
        L_0x01ba:
            if (r1 != 0) goto L_0x01c1
            int r2 = r3.t()
            goto L_0x01c5
        L_0x01c1:
            int r2 = r3.j()
        L_0x01c5:
            float r2 = (float) r2
            a.e.b.a.f[] r5 = r3.D
            r5 = r5[r23]
            int r5 = r5.b()
            float r5 = (float) r5
            float r13 = r13 + r5
            a.e.b.a.f[] r5 = r3.D
            r5 = r5[r23]
            a.e.b.a.q r5 = r5.d()
            a.e.b.a.q r8 = r7.g
            r5.a((a.e.b.a.q) r8, (float) r13)
            a.e.b.a.f[] r5 = r3.D
            r5 = r5[r16]
            a.e.b.a.q r5 = r5.d()
            a.e.b.a.q r8 = r7.g
            float r13 = r13 + r2
            r5.a((a.e.b.a.q) r8, (float) r13)
            a.e.b.a.f[] r2 = r3.D
            r2 = r2[r23]
            a.e.b.a.q r2 = r2.d()
            r2.a((a.e.b.e) r6)
            a.e.b.a.f[] r2 = r3.D
            r2 = r2[r16]
            a.e.b.a.q r2 = r2.d()
            r2.a((a.e.b.e) r6)
            a.e.b.a.f[] r2 = r3.D
            r2 = r2[r16]
            int r2 = r2.b()
            float r2 = (float) r2
            float r13 = r13 + r2
        L_0x020b:
            r3 = r0
            goto L_0x019a
        L_0x020d:
            if (r14 != 0) goto L_0x0215
            if (r15 == 0) goto L_0x0212
            goto L_0x0215
        L_0x0212:
            r0 = 1
            goto L_0x02db
        L_0x0215:
            if (r14 == 0) goto L_0x0219
        L_0x0217:
            float r12 = r12 - r11
            goto L_0x021c
        L_0x0219:
            if (r15 == 0) goto L_0x021c
            goto L_0x0217
        L_0x021c:
            int r11 = r17 + 1
            float r0 = (float) r11
            float r0 = r12 / r0
            if (r15 == 0) goto L_0x0231
            r2 = r17
            r8 = 1
            if (r2 <= r8) goto L_0x022c
            int r11 = r2 + -1
            float r0 = (float) r11
            goto L_0x022e
        L_0x022c:
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x022e:
            float r0 = r12 / r0
            goto L_0x0233
        L_0x0231:
            r2 = r17
        L_0x0233:
            int r8 = r3.s()
            if (r8 == r10) goto L_0x023c
            float r8 = r13 + r0
            goto L_0x023d
        L_0x023c:
            r8 = r13
        L_0x023d:
            if (r15 == 0) goto L_0x024d
            r9 = 1
            if (r2 <= r9) goto L_0x024d
            a.e.b.a.f[] r2 = r5.D
            r2 = r2[r23]
            int r2 = r2.b()
            float r2 = (float) r2
            float r8 = r13 + r2
        L_0x024d:
            if (r14 == 0) goto L_0x025b
            if (r5 == 0) goto L_0x025b
            a.e.b.a.f[] r2 = r5.D
            r2 = r2[r23]
            int r2 = r2.b()
            float r2 = (float) r2
            float r8 = r8 + r2
        L_0x025b:
            if (r3 == 0) goto L_0x0212
            a.e.b.f r2 = a.e.b.e.f109b
            if (r2 == 0) goto L_0x0273
            long r11 = r2.z
            long r11 = r11 - r18
            r2.z = r11
            long r11 = r2.r
            long r11 = r11 + r18
            r2.r = r11
            long r11 = r2.x
            long r11 = r11 + r18
            r2.x = r11
        L_0x0273:
            a.e.b.a.h[] r2 = r3.ra
            r2 = r2[r1]
            if (r2 != 0) goto L_0x027b
            if (r3 != r4) goto L_0x02d9
        L_0x027b:
            if (r1 != 0) goto L_0x0282
            int r9 = r3.t()
            goto L_0x0286
        L_0x0282:
            int r9 = r3.j()
        L_0x0286:
            float r9 = (float) r9
            if (r3 == r5) goto L_0x0293
            a.e.b.a.f[] r11 = r3.D
            r11 = r11[r23]
            int r11 = r11.b()
            float r11 = (float) r11
            float r8 = r8 + r11
        L_0x0293:
            a.e.b.a.f[] r11 = r3.D
            r11 = r11[r23]
            a.e.b.a.q r11 = r11.d()
            a.e.b.a.q r12 = r7.g
            r11.a((a.e.b.a.q) r12, (float) r8)
            a.e.b.a.f[] r11 = r3.D
            r11 = r11[r16]
            a.e.b.a.q r11 = r11.d()
            a.e.b.a.q r12 = r7.g
            float r13 = r8 + r9
            r11.a((a.e.b.a.q) r12, (float) r13)
            a.e.b.a.f[] r11 = r3.D
            r11 = r11[r23]
            a.e.b.a.q r11 = r11.d()
            r11.a((a.e.b.e) r6)
            a.e.b.a.f[] r11 = r3.D
            r11 = r11[r16]
            a.e.b.a.q r11 = r11.d()
            r11.a((a.e.b.e) r6)
            a.e.b.a.f[] r3 = r3.D
            r3 = r3[r16]
            int r3 = r3.b()
            float r3 = (float) r3
            float r9 = r9 + r3
            float r8 = r8 + r9
            if (r2 == 0) goto L_0x02d9
            int r3 = r2.s()
            if (r3 == r10) goto L_0x02d9
            float r8 = r8 + r0
        L_0x02d9:
            r3 = r2
            goto L_0x025b
        L_0x02db:
            return r0
        L_0x02dc:
            r0 = 0
            return r0
        L_0x02de:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.b.a.o.a(a.e.b.a.i, a.e.b.e, int, int, a.e.b.a.d):boolean");
    }

    static void a(h hVar, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        hVar.D[i3].d().g = hVar.l().D[i3].d();
        hVar.D[i3].d().h = (float) i2;
        hVar.D[i3].d().f99b = 1;
        hVar.D[i4].d().g = hVar.l().D[i3].d();
        hVar.D[i4].d().h = (float) (hVar.d(i) + i2);
        hVar.D[i4].d().f99b = 1;
    }
}
