package b.b.a.a.i;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import b.b.a.a.b.c;
import b.b.a.a.d.b;
import b.b.a.a.e.f;
import b.b.a.a.g.a.a;
import b.b.a.a.g.b.d;
import b.b.a.a.j.g;
import b.b.a.a.j.i;
import b.b.a.a.j.j;
import java.util.List;

public class e extends b {
    private RectF n = new RectF();

    public e(a aVar, b.b.a.a.a.a aVar2, j jVar) {
        super(aVar, aVar2, jVar);
        this.f.setTextAlign(Paint.Align.LEFT);
    }

    public void a() {
        b.b.a.a.d.a barData = this.h.getBarData();
        this.j = new c[barData.b()];
        for (int i = 0; i < this.j.length; i++) {
            b.b.a.a.g.b.a aVar = (b.b.a.a.g.b.a) barData.a(i);
            this.j[i] = new c(aVar.r() * 4 * (aVar.Y() ? aVar.W() : 1), barData.b(), aVar.Y());
        }
    }

    public void c(Canvas canvas) {
        List list;
        boolean z;
        b.b.a.a.j.e eVar;
        int i;
        boolean z2;
        float[] fArr;
        float f;
        float f2;
        int i2;
        float[] fArr2;
        float f3;
        b bVar;
        boolean z3;
        List list2;
        int i3;
        float f4;
        b.b.a.a.b.b bVar2;
        f fVar;
        b.b.a.a.j.e eVar2;
        String str;
        float f5;
        f fVar2;
        float f6;
        float f7;
        if (a(this.h)) {
            List c = this.h.getBarData().c();
            float a2 = i.a(5.0f);
            boolean b2 = this.h.b();
            int i4 = 0;
            while (i4 < this.h.getBarData().b()) {
                b.b.a.a.g.b.a aVar = (b.b.a.a.g.b.a) c.get(i4);
                if (!b(aVar)) {
                    list = c;
                    z = b2;
                } else {
                    boolean b3 = this.h.b(aVar.q());
                    a((d) aVar);
                    float f8 = 2.0f;
                    float a3 = ((float) i.a(this.f, "10")) / 2.0f;
                    f i5 = aVar.i();
                    b.b.a.a.b.b bVar3 = this.j[i4];
                    float b4 = this.f1261b.b();
                    b.b.a.a.j.e a4 = b.b.a.a.j.e.a(aVar.s());
                    a4.e = i.a(a4.e);
                    a4.f = i.a(a4.f);
                    if (!aVar.Y()) {
                        int i6 = 0;
                        while (((float) i6) < ((float) bVar3.f1204b.length) * this.f1261b.a()) {
                            float[] fArr3 = bVar3.f1204b;
                            int i7 = i6 + 1;
                            float f9 = (fArr3[i7] + fArr3[i6 + 3]) / f8;
                            if (!this.f1268a.d(fArr3[i7])) {
                                break;
                            }
                            if (this.f1268a.e(bVar3.f1204b[i6]) && this.f1268a.a(bVar3.f1204b[i7])) {
                                b bVar4 = (b) aVar.b(i6 / 4);
                                float c2 = bVar4.c();
                                String a5 = i5.a(c2, bVar4, i4, this.f1268a);
                                b.b.a.a.j.e eVar3 = a4;
                                float c3 = (float) i.c(this.f, a5);
                                if (b2) {
                                    str = a5;
                                    f5 = a2;
                                } else {
                                    str = a5;
                                    f5 = -(c3 + a2);
                                }
                                if (b2) {
                                    fVar2 = i5;
                                    f6 = -(c3 + a2);
                                } else {
                                    fVar2 = i5;
                                    f6 = a2;
                                }
                                if (b3) {
                                    f5 = (-f5) - c3;
                                    f6 = (-f6) - c3;
                                }
                                float f10 = f5;
                                float f11 = f6;
                                if (aVar.p()) {
                                    f7 = c2;
                                    i3 = i6;
                                    list2 = c;
                                    eVar2 = eVar3;
                                    f4 = a3;
                                    bVar2 = bVar3;
                                    z3 = b3;
                                    fVar = fVar2;
                                    a(canvas, str, (c2 >= 0.0f ? f10 : f11) + bVar3.f1204b[i6 + 2], f9 + a3, aVar.d(i6 / 2));
                                } else {
                                    f7 = c2;
                                    i3 = i6;
                                    list2 = c;
                                    z3 = b3;
                                    eVar2 = eVar3;
                                    fVar = fVar2;
                                    f4 = a3;
                                    bVar2 = bVar3;
                                }
                                if (bVar4.b() != null && aVar.d()) {
                                    Drawable b5 = bVar4.b();
                                    float f12 = bVar2.f1204b[i3 + 2];
                                    if (f7 >= 0.0f) {
                                        f11 = f10;
                                    }
                                    i.a(canvas, b5, (int) (f12 + f11 + eVar2.e), (int) (f9 + eVar2.f), b5.getIntrinsicWidth(), b5.getIntrinsicHeight());
                                }
                            } else {
                                i3 = i6;
                                list2 = c;
                                z3 = b3;
                                f4 = a3;
                                eVar2 = a4;
                                bVar2 = bVar3;
                                fVar = i5;
                            }
                            i6 = i3 + 4;
                            a4 = eVar2;
                            i5 = fVar;
                            bVar3 = bVar2;
                            a3 = f4;
                            c = list2;
                            b3 = z3;
                            f8 = 2.0f;
                        }
                        list = c;
                        eVar = a4;
                    } else {
                        list = c;
                        boolean z4 = b3;
                        float f13 = a3;
                        eVar = a4;
                        b.b.a.a.b.b bVar5 = bVar3;
                        f fVar3 = i5;
                        g a6 = this.h.a(aVar.q());
                        int i8 = 0;
                        int i9 = 0;
                        while (((float) i8) < ((float) aVar.r()) * this.f1261b.a()) {
                            b bVar6 = (b) aVar.b(i8);
                            int d = aVar.d(i8);
                            float[] h = bVar6.h();
                            if (h != null) {
                                b bVar7 = bVar6;
                                i = i8;
                                fArr = h;
                                float[] fArr4 = new float[(fArr.length * 2)];
                                float f14 = -bVar7.e();
                                int i10 = 0;
                                int i11 = 0;
                                float f15 = 0.0f;
                                while (i10 < fArr4.length) {
                                    float f16 = fArr[i11];
                                    if (!(f16 == 0.0f && (f15 == 0.0f || f14 == 0.0f))) {
                                        if (f16 >= 0.0f) {
                                            f16 = f15 + f16;
                                            f15 = f16;
                                        } else {
                                            float f17 = f14;
                                            f14 -= f16;
                                            f16 = f17;
                                        }
                                    }
                                    fArr4[i10] = f16 * b4;
                                    i10 += 2;
                                    i11++;
                                }
                                a6.b(fArr4);
                                int i12 = 0;
                                while (true) {
                                    if (i12 >= fArr4.length) {
                                        break;
                                    }
                                    float f18 = fArr[i12 / 2];
                                    b bVar8 = bVar7;
                                    String a7 = fVar3.a(f18, bVar8, i4, this.f1268a);
                                    float c4 = (float) i.c(this.f, a7);
                                    if (b2) {
                                        bVar7 = bVar8;
                                        f = a2;
                                    } else {
                                        bVar7 = bVar8;
                                        f = -(c4 + a2);
                                    }
                                    if (b2) {
                                        z2 = b2;
                                        f2 = -(c4 + a2);
                                    } else {
                                        z2 = b2;
                                        f2 = a2;
                                    }
                                    if (z4) {
                                        f = (-f) - c4;
                                        f2 = (-f2) - c4;
                                    }
                                    boolean z5 = (f18 == 0.0f && f14 == 0.0f && f15 > 0.0f) || f18 < 0.0f;
                                    float f19 = fArr4[i12];
                                    if (z5) {
                                        f = f2;
                                    }
                                    float f20 = f19 + f;
                                    float[] fArr5 = bVar5.f1204b;
                                    float f21 = (fArr5[i9 + 1] + fArr5[i9 + 3]) / 2.0f;
                                    if (!this.f1268a.d(f21)) {
                                        break;
                                    }
                                    if (this.f1268a.e(f20) && this.f1268a.a(f21)) {
                                        if (aVar.p()) {
                                            f3 = f21;
                                            i2 = i12;
                                            fArr2 = fArr4;
                                            a(canvas, a7, f20, f21 + f13, d);
                                        } else {
                                            f3 = f21;
                                            i2 = i12;
                                            fArr2 = fArr4;
                                        }
                                        if (bVar7.b() != null && aVar.d()) {
                                            Drawable b6 = bVar7.b();
                                            i.a(canvas, b6, (int) (f20 + eVar.e), (int) (f3 + eVar.f), b6.getIntrinsicWidth(), b6.getIntrinsicHeight());
                                        }
                                    } else {
                                        i2 = i12;
                                        fArr2 = fArr4;
                                    }
                                    i12 = i2 + 2;
                                    b2 = z2;
                                    fArr4 = fArr2;
                                }
                            } else {
                                int i13 = i9 + 1;
                                if (!this.f1268a.d(bVar5.f1204b[i13])) {
                                    break;
                                } else if (this.f1268a.e(bVar5.f1204b[i9]) && this.f1268a.a(bVar5.f1204b[i13])) {
                                    String a8 = fVar3.a(bVar6.c(), bVar6, i4, this.f1268a);
                                    float c5 = (float) i.c(this.f, a8);
                                    float f22 = b2 ? a2 : -(c5 + a2);
                                    float f23 = b2 ? -(c5 + a2) : a2;
                                    if (z4) {
                                        f22 = (-f22) - c5;
                                        f23 = (-f23) - c5;
                                    }
                                    float f24 = f22;
                                    float f25 = f23;
                                    if (aVar.p()) {
                                        i = i8;
                                        fArr = h;
                                        bVar = bVar6;
                                        a(canvas, a8, bVar5.f1204b[i9 + 2] + (bVar6.c() >= 0.0f ? f24 : f25), bVar5.f1204b[i13] + f13, d);
                                    } else {
                                        bVar = bVar6;
                                        i = i8;
                                        fArr = h;
                                    }
                                    if (bVar.b() != null && aVar.d()) {
                                        Drawable b7 = bVar.b();
                                        float f26 = bVar5.f1204b[i9 + 2];
                                        if (bVar.c() >= 0.0f) {
                                            f25 = f24;
                                        }
                                        i.a(canvas, b7, (int) (f26 + f25 + eVar.e), (int) (bVar5.f1204b[i13] + eVar.f), b7.getIntrinsicWidth(), b7.getIntrinsicHeight());
                                    }
                                }
                            }
                            z2 = b2;
                            if (fArr == null) {
                                i9 += 4;
                            } else {
                                i9 += fArr.length * 4;
                            }
                            i8 = i + 1;
                            b2 = z2;
                        }
                    }
                    z = b2;
                    b.b.a.a.j.e.b(eVar);
                }
                i4++;
                b2 = z;
                c = list;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, b.b.a.a.g.b.a aVar, int i) {
        b.b.a.a.g.b.a aVar2 = aVar;
        int i2 = i;
        g a2 = this.h.a(aVar.q());
        this.l.setColor(aVar.T());
        this.l.setStrokeWidth(i.a(aVar.U()));
        int i3 = 0;
        boolean z = true;
        boolean z2 = aVar.U() > 0.0f;
        float a3 = this.f1261b.a();
        float b2 = this.f1261b.b();
        if (this.h.a()) {
            this.k.setColor(aVar.V());
            float j = this.h.getBarData().j() / 2.0f;
            int min = Math.min((int) Math.ceil((double) (((float) aVar.r()) * a3)), aVar.r());
            for (int i4 = 0; i4 < min; i4++) {
                float d = ((b) aVar2.b(i4)).d();
                RectF rectF = this.n;
                rectF.top = d - j;
                rectF.bottom = d + j;
                a2.a(rectF);
                if (!this.f1268a.d(this.n.bottom)) {
                    Canvas canvas2 = canvas;
                } else if (!this.f1268a.a(this.n.top)) {
                    break;
                } else {
                    this.n.left = this.f1268a.g();
                    this.n.right = this.f1268a.h();
                    canvas.drawRect(this.n, this.k);
                }
            }
        }
        Canvas canvas3 = canvas;
        b.b.a.a.b.b bVar = this.j[i2];
        bVar.a(a3, b2);
        bVar.a(i2);
        bVar.a(this.h.b(aVar.q()));
        bVar.a(this.h.getBarData().j());
        bVar.a(aVar2);
        a2.b(bVar.f1204b);
        if (aVar.n().size() != 1) {
            z = false;
        }
        if (z) {
            this.c.setColor(aVar.t());
        }
        while (i3 < bVar.b()) {
            int i5 = i3 + 3;
            if (this.f1268a.d(bVar.f1204b[i5])) {
                int i6 = i3 + 1;
                if (this.f1268a.a(bVar.f1204b[i6])) {
                    if (!z) {
                        this.c.setColor(aVar2.c(i3 / 4));
                    }
                    float[] fArr = bVar.f1204b;
                    int i7 = i3 + 2;
                    canvas.drawRect(fArr[i3], fArr[i6], fArr[i7], fArr[i5], this.c);
                    if (z2) {
                        float[] fArr2 = bVar.f1204b;
                        canvas.drawRect(fArr2[i3], fArr2[i6], fArr2[i7], fArr2[i5], this.l);
                    }
                }
                i3 += 4;
                Canvas canvas4 = canvas;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, String str, float f, float f2, int i) {
        this.f.setColor(i);
        canvas.drawText(str, f, f2, this.f);
    }

    /* access modifiers changed from: protected */
    public void a(float f, float f2, float f3, float f4, g gVar) {
        this.i.set(f2, f - f4, f3, f + f4);
        gVar.b(this.i, this.f1261b.b());
    }

    /* access modifiers changed from: protected */
    public void a(b.b.a.a.f.c cVar, RectF rectF) {
        cVar.a(rectF.centerY(), rectF.right);
    }

    /* access modifiers changed from: protected */
    public boolean a(b.b.a.a.g.a.c cVar) {
        return ((float) cVar.getData().d()) < ((float) cVar.getMaxVisibleCount()) * this.f1268a.q();
    }
}
