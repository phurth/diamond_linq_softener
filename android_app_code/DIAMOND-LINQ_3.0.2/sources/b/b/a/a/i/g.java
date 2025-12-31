package b.b.a.a.i;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import b.b.a.a.c.f;
import b.b.a.a.j.i;
import b.b.a.a.j.j;
import java.util.ArrayList;
import java.util.List;

public class g extends l {

    /* renamed from: b  reason: collision with root package name */
    protected Paint f1264b;
    protected Paint c;
    protected f d;
    protected List<b.b.a.a.c.g> e = new ArrayList(16);
    protected Paint.FontMetrics f = new Paint.FontMetrics();
    private Path g = new Path();

    public g(j jVar, f fVar) {
        super(jVar);
        this.d = fVar;
        this.f1264b = new Paint(1);
        this.f1264b.setTextSize(i.a(9.0f));
        this.f1264b.setTextAlign(Paint.Align.LEFT);
        this.c = new Paint(1);
        this.c.setStyle(Paint.Style.FILL);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: b.b.a.a.d.g<?>} */
    /* JADX WARNING: type inference failed for: r7v2, types: [b.b.a.a.g.b.d] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(b.b.a.a.d.g<?> r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            b.b.a.a.c.f r2 = r0.d
            boolean r2 = r2.z()
            if (r2 != 0) goto L_0x01c1
            java.util.List<b.b.a.a.c.g> r2 = r0.e
            r2.clear()
            r3 = 0
        L_0x0012:
            int r4 = r19.b()
            if (r3 >= r4) goto L_0x01a7
            b.b.a.a.g.b.d r4 = r1.a((int) r3)
            java.util.List r5 = r4.n()
            int r6 = r4.r()
            boolean r7 = r4 instanceof b.b.a.a.g.b.a
            if (r7 == 0) goto L_0x0096
            r7 = r4
            b.b.a.a.g.b.a r7 = (b.b.a.a.g.b.a) r7
            boolean r8 = r7.Y()
            if (r8 == 0) goto L_0x0096
            java.lang.String[] r6 = r7.Z()
            r8 = 0
        L_0x0036:
            int r9 = r5.size()
            if (r8 >= r9) goto L_0x0074
            int r9 = r7.W()
            if (r8 >= r9) goto L_0x0074
            java.util.List<b.b.a.a.c.g> r9 = r0.e
            b.b.a.a.c.g r15 = new b.b.a.a.c.g
            int r10 = r6.length
            int r10 = r8 % r10
            r11 = r6[r10]
            b.b.a.a.c.f$b r12 = r4.e()
            float r13 = r4.k()
            float r14 = r4.j()
            android.graphics.DashPathEffect r16 = r4.c()
            java.lang.Object r10 = r5.get(r8)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r17 = r10.intValue()
            r10 = r15
            r2 = r15
            r15 = r16
            r16 = r17
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r9.add(r2)
            int r8 = r8 + 1
            goto L_0x0036
        L_0x0074:
            java.lang.String r2 = r7.f()
            if (r2 == 0) goto L_0x0093
            java.util.List<b.b.a.a.c.g> r2 = r0.e
            b.b.a.a.c.g r12 = new b.b.a.a.c.g
            java.lang.String r6 = r4.f()
            b.b.a.a.c.f$b r7 = b.b.a.a.c.f.b.NONE
            r8 = 2143289344(0x7fc00000, float:NaN)
            r9 = 2143289344(0x7fc00000, float:NaN)
            r10 = 0
            r11 = 1122867(0x112233, float:1.573472E-39)
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2.add(r12)
        L_0x0093:
            r2 = r1
            goto L_0x01a2
        L_0x0096:
            boolean r2 = r4 instanceof b.b.a.a.g.b.h
            if (r2 == 0) goto L_0x00fe
            r2 = r4
            b.b.a.a.g.b.h r2 = (b.b.a.a.g.b.h) r2
            r7 = 0
        L_0x009e:
            int r8 = r5.size()
            if (r7 >= r8) goto L_0x00dd
            if (r7 >= r6) goto L_0x00dd
            java.util.List<b.b.a.a.c.g> r8 = r0.e
            b.b.a.a.c.g r15 = new b.b.a.a.c.g
            b.b.a.a.d.j r9 = r2.b(r7)
            b.b.a.a.d.o r9 = (b.b.a.a.d.o) r9
            java.lang.String r10 = r9.e()
            b.b.a.a.c.f$b r11 = r4.e()
            float r12 = r4.k()
            float r13 = r4.j()
            android.graphics.DashPathEffect r14 = r4.c()
            java.lang.Object r9 = r5.get(r7)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r16 = r9.intValue()
            r9 = r15
            r1 = r15
            r15 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r8.add(r1)
            int r7 = r7 + 1
            r1 = r19
            goto L_0x009e
        L_0x00dd:
            java.lang.String r1 = r2.f()
            if (r1 == 0) goto L_0x01a0
            java.util.List<b.b.a.a.c.g> r1 = r0.e
            b.b.a.a.c.g r2 = new b.b.a.a.c.g
            java.lang.String r6 = r4.f()
            b.b.a.a.c.f$b r7 = b.b.a.a.c.f.b.NONE
            r8 = 2143289344(0x7fc00000, float:NaN)
            r9 = 2143289344(0x7fc00000, float:NaN)
            r10 = 0
            r11 = 1122867(0x112233, float:1.573472E-39)
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1.add(r2)
            goto L_0x01a0
        L_0x00fe:
            boolean r1 = r4 instanceof b.b.a.a.g.b.c
            if (r1 == 0) goto L_0x0153
            r1 = r4
            b.b.a.a.g.b.c r1 = (b.b.a.a.g.b.c) r1
            int r2 = r1.S()
            r7 = 1122867(0x112233, float:1.573472E-39)
            if (r2 == r7) goto L_0x0153
            int r14 = r1.S()
            int r1 = r1.R()
            java.util.List<b.b.a.a.c.g> r2 = r0.e
            b.b.a.a.c.g r5 = new b.b.a.a.c.g
            r9 = 0
            b.b.a.a.c.f$b r10 = r4.e()
            float r11 = r4.k()
            float r12 = r4.j()
            android.graphics.DashPathEffect r13 = r4.c()
            r8 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r2.add(r5)
            java.util.List<b.b.a.a.c.g> r2 = r0.e
            b.b.a.a.c.g r12 = new b.b.a.a.c.g
            java.lang.String r6 = r4.f()
            b.b.a.a.c.f$b r7 = r4.e()
            float r8 = r4.k()
            float r9 = r4.j()
            android.graphics.DashPathEffect r10 = r4.c()
            r5 = r12
            r11 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2.add(r12)
            goto L_0x01a0
        L_0x0153:
            r1 = 0
        L_0x0154:
            int r2 = r5.size()
            if (r1 >= r2) goto L_0x01a0
            if (r1 >= r6) goto L_0x01a0
            int r2 = r5.size()
            int r2 = r2 + -1
            if (r1 >= r2) goto L_0x016d
            int r2 = r6 + -1
            if (r1 >= r2) goto L_0x016d
            r2 = 0
            r9 = r2
            r2 = r19
            goto L_0x0178
        L_0x016d:
            r2 = r19
            b.b.a.a.g.b.d r7 = r2.a((int) r3)
            java.lang.String r7 = r7.f()
            r9 = r7
        L_0x0178:
            java.util.List<b.b.a.a.c.g> r7 = r0.e
            b.b.a.a.c.g r15 = new b.b.a.a.c.g
            b.b.a.a.c.f$b r10 = r4.e()
            float r11 = r4.k()
            float r12 = r4.j()
            android.graphics.DashPathEffect r13 = r4.c()
            java.lang.Object r8 = r5.get(r1)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r14 = r8.intValue()
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r7.add(r15)
            int r1 = r1 + 1
            goto L_0x0154
        L_0x01a0:
            r2 = r19
        L_0x01a2:
            int r3 = r3 + 1
            r1 = r2
            goto L_0x0012
        L_0x01a7:
            b.b.a.a.c.f r1 = r0.d
            b.b.a.a.c.g[] r1 = r1.l()
            if (r1 == 0) goto L_0x01ba
            java.util.List<b.b.a.a.c.g> r1 = r0.e
            b.b.a.a.c.f r2 = r0.d
            b.b.a.a.c.g[] r2 = r2.l()
            java.util.Collections.addAll(r1, r2)
        L_0x01ba:
            b.b.a.a.c.f r1 = r0.d
            java.util.List<b.b.a.a.c.g> r2 = r0.e
            r1.a((java.util.List<b.b.a.a.c.g>) r2)
        L_0x01c1:
            b.b.a.a.c.f r1 = r0.d
            android.graphics.Typeface r1 = r1.c()
            if (r1 == 0) goto L_0x01ce
            android.graphics.Paint r2 = r0.f1264b
            r2.setTypeface(r1)
        L_0x01ce:
            android.graphics.Paint r1 = r0.f1264b
            b.b.a.a.c.f r2 = r0.d
            float r2 = r2.b()
            r1.setTextSize(r2)
            android.graphics.Paint r1 = r0.f1264b
            b.b.a.a.c.f r2 = r0.d
            int r2 = r2.a()
            r1.setColor(r2)
            b.b.a.a.c.f r1 = r0.d
            android.graphics.Paint r2 = r0.f1264b
            b.b.a.a.j.j r3 = r0.f1268a
            r1.a(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.i.g.a(b.b.a.a.d.g):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x016f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Canvas r35) {
        /*
            r34 = this;
            r6 = r34
            r7 = r35
            b.b.a.a.c.f r0 = r6.d
            boolean r0 = r0.f()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            b.b.a.a.c.f r0 = r6.d
            android.graphics.Typeface r0 = r0.c()
            if (r0 == 0) goto L_0x001a
            android.graphics.Paint r1 = r6.f1264b
            r1.setTypeface(r0)
        L_0x001a:
            android.graphics.Paint r0 = r6.f1264b
            b.b.a.a.c.f r1 = r6.d
            float r1 = r1.b()
            r0.setTextSize(r1)
            android.graphics.Paint r0 = r6.f1264b
            b.b.a.a.c.f r1 = r6.d
            int r1 = r1.a()
            r0.setColor(r1)
            android.graphics.Paint r0 = r6.f1264b
            android.graphics.Paint$FontMetrics r1 = r6.f
            float r8 = b.b.a.a.j.i.a((android.graphics.Paint) r0, (android.graphics.Paint.FontMetrics) r1)
            android.graphics.Paint r0 = r6.f1264b
            android.graphics.Paint$FontMetrics r1 = r6.f
            float r0 = b.b.a.a.j.i.b((android.graphics.Paint) r0, (android.graphics.Paint.FontMetrics) r1)
            b.b.a.a.c.f r1 = r6.d
            float r1 = r1.x()
            float r1 = b.b.a.a.j.i.a((float) r1)
            float r9 = r0 + r1
            android.graphics.Paint r0 = r6.f1264b
            java.lang.String r1 = "ABC"
            int r0 = b.b.a.a.j.i.a((android.graphics.Paint) r0, (java.lang.String) r1)
            float r0 = (float) r0
            r10 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r10
            float r11 = r8 - r0
            b.b.a.a.c.f r0 = r6.d
            b.b.a.a.c.g[] r12 = r0.k()
            b.b.a.a.c.f r0 = r6.d
            float r0 = r0.q()
            float r13 = b.b.a.a.j.i.a((float) r0)
            b.b.a.a.c.f r0 = r6.d
            float r0 = r0.w()
            float r14 = b.b.a.a.j.i.a((float) r0)
            b.b.a.a.c.f r0 = r6.d
            b.b.a.a.c.f$d r0 = r0.t()
            b.b.a.a.c.f r1 = r6.d
            b.b.a.a.c.f$c r15 = r1.r()
            b.b.a.a.c.f r1 = r6.d
            b.b.a.a.c.f$f r1 = r1.v()
            b.b.a.a.c.f r2 = r6.d
            b.b.a.a.c.f$a r5 = r2.j()
            b.b.a.a.c.f r2 = r6.d
            float r2 = r2.p()
            float r16 = b.b.a.a.j.i.a((float) r2)
            b.b.a.a.c.f r2 = r6.d
            float r2 = r2.u()
            float r4 = b.b.a.a.j.i.a((float) r2)
            b.b.a.a.c.f r2 = r6.d
            float r2 = r2.e()
            b.b.a.a.c.f r3 = r6.d
            float r3 = r3.d()
            int[] r17 = b.b.a.a.i.f.f1262a
            int r18 = r15.ordinal()
            r10 = r17[r18]
            r17 = r4
            r4 = 2
            r20 = 0
            r21 = r14
            r14 = 1
            if (r10 == r14) goto L_0x014b
            if (r10 == r4) goto L_0x0129
            r4 = 3
            if (r10 == r4) goto L_0x00c9
            r26 = r8
            r14 = r9
            r7 = 0
            goto L_0x0164
        L_0x00c9:
            b.b.a.a.c.f$d r4 = b.b.a.a.c.f.d.VERTICAL
            if (r0 != r4) goto L_0x00d7
            b.b.a.a.j.j r4 = r6.f1268a
            float r4 = r4.l()
            r10 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r10
            goto L_0x00e7
        L_0x00d7:
            r10 = 1073741824(0x40000000, float:2.0)
            b.b.a.a.j.j r4 = r6.f1268a
            float r4 = r4.g()
            b.b.a.a.j.j r14 = r6.f1268a
            float r14 = r14.j()
            float r14 = r14 / r10
            float r4 = r4 + r14
        L_0x00e7:
            b.b.a.a.c.f$a r10 = b.b.a.a.c.f.a.LEFT_TO_RIGHT
            if (r5 != r10) goto L_0x00ed
            r10 = r3
            goto L_0x00ee
        L_0x00ed:
            float r10 = -r3
        L_0x00ee:
            float r4 = r4 + r10
            b.b.a.a.c.f$d r10 = b.b.a.a.c.f.d.VERTICAL
            if (r0 != r10) goto L_0x0125
            r14 = r9
            double r9 = (double) r4
            b.b.a.a.c.f$a r4 = b.b.a.a.c.f.a.LEFT_TO_RIGHT
            r24 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r5 != r4) goto L_0x010e
            b.b.a.a.c.f r4 = r6.d
            float r4 = r4.x
            float r4 = -r4
            r26 = r8
            double r7 = (double) r4
            java.lang.Double.isNaN(r7)
            double r7 = r7 / r24
            double r3 = (double) r3
            java.lang.Double.isNaN(r3)
            double r7 = r7 + r3
            goto L_0x011f
        L_0x010e:
            r26 = r8
            b.b.a.a.c.f r4 = r6.d
            float r4 = r4.x
            double r7 = (double) r4
            java.lang.Double.isNaN(r7)
            double r7 = r7 / r24
            double r3 = (double) r3
            java.lang.Double.isNaN(r3)
            double r7 = r7 - r3
        L_0x011f:
            java.lang.Double.isNaN(r9)
            double r9 = r9 + r7
            float r3 = (float) r9
            goto L_0x0163
        L_0x0125:
            r26 = r8
            r14 = r9
            goto L_0x0149
        L_0x0129:
            r26 = r8
            r14 = r9
            b.b.a.a.c.f$d r4 = b.b.a.a.c.f.d.VERTICAL
            if (r0 != r4) goto L_0x0137
            b.b.a.a.j.j r4 = r6.f1268a
            float r4 = r4.l()
            goto L_0x013d
        L_0x0137:
            b.b.a.a.j.j r4 = r6.f1268a
            float r4 = r4.h()
        L_0x013d:
            float r4 = r4 - r3
            b.b.a.a.c.f$a r3 = b.b.a.a.c.f.a.LEFT_TO_RIGHT
            if (r5 != r3) goto L_0x0149
            b.b.a.a.c.f r3 = r6.d
            float r3 = r3.x
            float r3 = r4 - r3
            goto L_0x0163
        L_0x0149:
            r7 = r4
            goto L_0x0164
        L_0x014b:
            r26 = r8
            r14 = r9
            b.b.a.a.c.f$d r4 = b.b.a.a.c.f.d.VERTICAL
            if (r0 != r4) goto L_0x0153
            goto L_0x015a
        L_0x0153:
            b.b.a.a.j.j r4 = r6.f1268a
            float r4 = r4.g()
            float r3 = r3 + r4
        L_0x015a:
            b.b.a.a.c.f$a r4 = b.b.a.a.c.f.a.RIGHT_TO_LEFT
            if (r5 != r4) goto L_0x0163
            b.b.a.a.c.f r4 = r6.d
            float r4 = r4.x
            float r3 = r3 + r4
        L_0x0163:
            r7 = r3
        L_0x0164:
            int[] r3 = b.b.a.a.i.f.c
            int r0 = r0.ordinal()
            r0 = r3[r0]
            r3 = 1
            if (r0 == r3) goto L_0x0275
            r4 = 2
            if (r0 == r4) goto L_0x0174
            goto L_0x03d8
        L_0x0174:
            int[] r0 = b.b.a.a.i.f.f1263b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            if (r0 == r3) goto L_0x01b2
            if (r0 == r4) goto L_0x019a
            r1 = 3
            if (r0 == r1) goto L_0x0185
            r0 = 0
            goto L_0x01bf
        L_0x0185:
            b.b.a.a.j.j r0 = r6.f1268a
            float r0 = r0.k()
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            b.b.a.a.c.f r2 = r6.d
            float r3 = r2.y
            float r3 = r3 / r1
            float r0 = r0 - r3
            float r1 = r2.e()
            float r0 = r0 + r1
            goto L_0x01bf
        L_0x019a:
            b.b.a.a.c.f$c r0 = b.b.a.a.c.f.c.CENTER
            if (r15 != r0) goto L_0x01a5
            b.b.a.a.j.j r0 = r6.f1268a
            float r0 = r0.k()
            goto L_0x01ab
        L_0x01a5:
            b.b.a.a.j.j r0 = r6.f1268a
            float r0 = r0.e()
        L_0x01ab:
            b.b.a.a.c.f r1 = r6.d
            float r1 = r1.y
            float r1 = r1 + r2
            float r0 = r0 - r1
            goto L_0x01bf
        L_0x01b2:
            b.b.a.a.c.f$c r0 = b.b.a.a.c.f.c.CENTER
            if (r15 != r0) goto L_0x01b8
            r0 = 0
            goto L_0x01be
        L_0x01b8:
            b.b.a.a.j.j r0 = r6.f1268a
            float r0 = r0.i()
        L_0x01be:
            float r0 = r0 + r2
        L_0x01bf:
            r15 = r0
            r9 = 0
            r10 = 0
            r18 = 0
        L_0x01c4:
            int r0 = r12.length
            if (r9 >= r0) goto L_0x03d8
            r4 = r12[r9]
            b.b.a.a.c.f$b r0 = r4.f1222b
            b.b.a.a.c.f$b r1 = b.b.a.a.c.f.b.NONE
            if (r0 == r1) goto L_0x01d2
            r19 = 1
            goto L_0x01d4
        L_0x01d2:
            r19 = 0
        L_0x01d4:
            float r0 = r4.c
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x01df
            r21 = r16
            goto L_0x01e7
        L_0x01df:
            float r0 = r4.c
            float r0 = b.b.a.a.j.i.a((float) r0)
            r21 = r0
        L_0x01e7:
            if (r19 == 0) goto L_0x0219
            b.b.a.a.c.f$a r0 = b.b.a.a.c.f.a.LEFT_TO_RIGHT
            if (r5 != r0) goto L_0x01f0
            float r0 = r7 + r10
            goto L_0x01f4
        L_0x01f0:
            float r0 = r21 - r10
            float r0 = r7 - r0
        L_0x01f4:
            r22 = r0
            float r3 = r15 + r11
            b.b.a.a.c.f r2 = r6.d
            r0 = r34
            r1 = r35
            r24 = r2
            r2 = r22
            r8 = r17
            r17 = r4
            r27 = r11
            r11 = r5
            r5 = r24
            r0.a(r1, r2, r3, r4, r5)
            b.b.a.a.c.f$a r0 = b.b.a.a.c.f.a.LEFT_TO_RIGHT
            if (r11 != r0) goto L_0x0216
            float r0 = r22 + r21
            r22 = r0
        L_0x0216:
            r0 = r17
            goto L_0x0221
        L_0x0219:
            r27 = r11
            r8 = r17
            r11 = r5
            r0 = r4
            r22 = r7
        L_0x0221:
            java.lang.String r1 = r0.f1221a
            if (r1 == 0) goto L_0x0264
            if (r19 == 0) goto L_0x0233
            if (r18 != 0) goto L_0x0233
            b.b.a.a.c.f$a r1 = b.b.a.a.c.f.a.LEFT_TO_RIGHT
            if (r11 != r1) goto L_0x022f
            r1 = r13
            goto L_0x0230
        L_0x022f:
            float r1 = -r13
        L_0x0230:
            float r1 = r22 + r1
            goto L_0x0239
        L_0x0233:
            if (r18 == 0) goto L_0x0237
            r1 = r7
            goto L_0x0239
        L_0x0237:
            r1 = r22
        L_0x0239:
            b.b.a.a.c.f$a r2 = b.b.a.a.c.f.a.RIGHT_TO_LEFT
            if (r11 != r2) goto L_0x0247
            android.graphics.Paint r2 = r6.f1264b
            java.lang.String r3 = r0.f1221a
            int r2 = b.b.a.a.j.i.c(r2, r3)
            float r2 = (float) r2
            float r1 = r1 - r2
        L_0x0247:
            if (r18 != 0) goto L_0x0253
            float r2 = r15 + r26
            java.lang.String r0 = r0.f1221a
            r5 = r35
            r6.a(r5, r1, r2, r0)
            goto L_0x025f
        L_0x0253:
            r5 = r35
            float r2 = r26 + r14
            float r15 = r15 + r2
            float r2 = r15 + r26
            java.lang.String r0 = r0.f1221a
            r6.a(r5, r1, r2, r0)
        L_0x025f:
            float r0 = r26 + r14
            float r15 = r15 + r0
            r10 = 0
            goto L_0x026c
        L_0x0264:
            r5 = r35
            float r21 = r21 + r8
            float r10 = r10 + r21
            r18 = 1
        L_0x026c:
            int r9 = r9 + 1
            r17 = r8
            r5 = r11
            r11 = r27
            goto L_0x01c4
        L_0x0275:
            r27 = r11
            r8 = r17
            r11 = r5
            r5 = r35
            b.b.a.a.c.f r0 = r6.d
            java.util.List r9 = r0.i()
            b.b.a.a.c.f r0 = r6.d
            java.util.List r10 = r0.h()
            b.b.a.a.c.f r0 = r6.d
            java.util.List r4 = r0.g()
            int[] r0 = b.b.a.a.i.f.f1263b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r3 = 1
            if (r0 == r3) goto L_0x02be
            r1 = 2
            if (r0 == r1) goto L_0x02b1
            r1 = 3
            if (r0 == r1) goto L_0x02a1
            r2 = 0
            goto L_0x02be
        L_0x02a1:
            b.b.a.a.j.j r0 = r6.f1268a
            float r0 = r0.k()
            b.b.a.a.c.f r1 = r6.d
            float r1 = r1.y
            float r0 = r0 - r1
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r1
            float r2 = r2 + r0
            goto L_0x02be
        L_0x02b1:
            b.b.a.a.j.j r0 = r6.f1268a
            float r0 = r0.k()
            float r0 = r0 - r2
            b.b.a.a.c.f r1 = r6.d
            float r1 = r1.y
            float r2 = r0 - r1
        L_0x02be:
            int r1 = r12.length
            r0 = r2
            r17 = r7
            r2 = 0
            r3 = 0
        L_0x02c4:
            if (r2 >= r1) goto L_0x03d8
            r18 = r8
            r8 = r12[r2]
            r20 = r1
            b.b.a.a.c.f$b r1 = r8.f1222b
            b.b.a.a.c.f$b r5 = b.b.a.a.c.f.b.NONE
            if (r1 == r5) goto L_0x02d5
            r22 = 1
            goto L_0x02d7
        L_0x02d5:
            r22 = 0
        L_0x02d7:
            float r1 = r8.c
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x02e2
            r24 = r16
            goto L_0x02ea
        L_0x02e2:
            float r1 = r8.c
            float r1 = b.b.a.a.j.i.a((float) r1)
            r24 = r1
        L_0x02ea:
            int r1 = r4.size()
            if (r2 >= r1) goto L_0x0304
            java.lang.Object r1 = r4.get(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0304
            float r1 = r26 + r14
            float r0 = r0 + r1
            r28 = r0
            r17 = r7
            goto L_0x0306
        L_0x0304:
            r28 = r0
        L_0x0306:
            int r0 = (r17 > r7 ? 1 : (r17 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0333
            b.b.a.a.c.f$c r0 = b.b.a.a.c.f.c.CENTER
            if (r15 != r0) goto L_0x0333
            int r0 = r9.size()
            if (r3 >= r0) goto L_0x0333
            b.b.a.a.c.f$a r0 = b.b.a.a.c.f.a.RIGHT_TO_LEFT
            if (r11 != r0) goto L_0x0321
            java.lang.Object r0 = r9.get(r3)
            b.b.a.a.j.a r0 = (b.b.a.a.j.a) r0
            float r0 = r0.d
            goto L_0x032a
        L_0x0321:
            java.lang.Object r0 = r9.get(r3)
            b.b.a.a.j.a r0 = (b.b.a.a.j.a) r0
            float r0 = r0.d
            float r0 = -r0
        L_0x032a:
            r19 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r19
            float r17 = r17 + r0
            int r3 = r3 + 1
            goto L_0x0335
        L_0x0333:
            r19 = 1073741824(0x40000000, float:2.0)
        L_0x0335:
            r29 = r3
            java.lang.String r0 = r8.f1221a
            if (r0 != 0) goto L_0x033e
            r30 = 1
            goto L_0x0340
        L_0x033e:
            r30 = 0
        L_0x0340:
            if (r22 == 0) goto L_0x0368
            b.b.a.a.c.f$a r0 = b.b.a.a.c.f.a.RIGHT_TO_LEFT
            if (r11 != r0) goto L_0x0348
            float r17 = r17 - r24
        L_0x0348:
            float r3 = r28 + r27
            b.b.a.a.c.f r5 = r6.d
            r0 = r34
            r1 = r35
            r31 = r7
            r7 = r2
            r2 = r17
            r23 = 1
            r32 = r4
            r4 = r8
            r33 = r9
            r9 = r35
            r0.a(r1, r2, r3, r4, r5)
            b.b.a.a.c.f$a r0 = b.b.a.a.c.f.a.LEFT_TO_RIGHT
            if (r11 != r0) goto L_0x0373
            float r17 = r17 + r24
            goto L_0x0373
        L_0x0368:
            r32 = r4
            r31 = r7
            r33 = r9
            r23 = 1
            r9 = r35
            r7 = r2
        L_0x0373:
            if (r30 != 0) goto L_0x03b5
            if (r22 == 0) goto L_0x0380
            b.b.a.a.c.f$a r0 = b.b.a.a.c.f.a.RIGHT_TO_LEFT
            if (r11 != r0) goto L_0x037d
            float r0 = -r13
            goto L_0x037e
        L_0x037d:
            r0 = r13
        L_0x037e:
            float r17 = r17 + r0
        L_0x0380:
            b.b.a.a.c.f$a r0 = b.b.a.a.c.f.a.RIGHT_TO_LEFT
            if (r11 != r0) goto L_0x038e
            java.lang.Object r0 = r10.get(r7)
            b.b.a.a.j.a r0 = (b.b.a.a.j.a) r0
            float r0 = r0.d
            float r17 = r17 - r0
        L_0x038e:
            r0 = r17
            float r1 = r28 + r26
            java.lang.String r2 = r8.f1221a
            r6.a(r9, r0, r1, r2)
            b.b.a.a.c.f$a r1 = b.b.a.a.c.f.a.LEFT_TO_RIGHT
            if (r11 != r1) goto L_0x03a4
            java.lang.Object r1 = r10.get(r7)
            b.b.a.a.j.a r1 = (b.b.a.a.j.a) r1
            float r1 = r1.d
            float r0 = r0 + r1
        L_0x03a4:
            b.b.a.a.c.f$a r1 = b.b.a.a.c.f.a.RIGHT_TO_LEFT
            if (r11 != r1) goto L_0x03ac
            r1 = r21
            float r2 = -r1
            goto L_0x03af
        L_0x03ac:
            r1 = r21
            r2 = r1
        L_0x03af:
            float r0 = r0 + r2
            r17 = r0
            r0 = r18
            goto L_0x03c4
        L_0x03b5:
            r1 = r21
            b.b.a.a.c.f$a r0 = b.b.a.a.c.f.a.RIGHT_TO_LEFT
            if (r11 != r0) goto L_0x03bf
            r0 = r18
            float r4 = -r0
            goto L_0x03c2
        L_0x03bf:
            r0 = r18
            r4 = r0
        L_0x03c2:
            float r17 = r17 + r4
        L_0x03c4:
            int r2 = r7 + 1
            r8 = r0
            r21 = r1
            r5 = r9
            r1 = r20
            r0 = r28
            r3 = r29
            r7 = r31
            r4 = r32
            r9 = r33
            goto L_0x02c4
        L_0x03d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.i.g.a(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, float f3, b.b.a.a.c.g gVar, f fVar) {
        int i = gVar.f;
        if (i != 1122868 && i != 1122867 && i != 0) {
            int save = canvas.save();
            f.b bVar = gVar.f1222b;
            if (bVar == f.b.DEFAULT) {
                bVar = fVar.m();
            }
            this.c.setColor(gVar.f);
            float a2 = i.a(Float.isNaN(gVar.c) ? fVar.p() : gVar.c);
            float f4 = a2 / 2.0f;
            switch (f.d[bVar.ordinal()]) {
                case 3:
                case 4:
                    this.c.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(f2 + f4, f3, f4, this.c);
                    break;
                case 5:
                    this.c.setStyle(Paint.Style.FILL);
                    canvas.drawRect(f2, f3 - f4, f2 + a2, f3 + f4, this.c);
                    break;
                case 6:
                    float a3 = i.a(Float.isNaN(gVar.d) ? fVar.o() : gVar.d);
                    DashPathEffect dashPathEffect = gVar.e;
                    if (dashPathEffect == null) {
                        dashPathEffect = fVar.n();
                    }
                    this.c.setStyle(Paint.Style.STROKE);
                    this.c.setStrokeWidth(a3);
                    this.c.setPathEffect(dashPathEffect);
                    this.g.reset();
                    this.g.moveTo(f2, f3);
                    this.g.lineTo(f2 + a2, f3);
                    canvas.drawPath(this.g, this.c);
                    break;
            }
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, float f3, String str) {
        canvas.drawText(str, f2, f3, this.f1264b);
    }
}
