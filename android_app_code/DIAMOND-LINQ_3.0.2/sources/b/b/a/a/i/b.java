package b.b.a.a.i;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import b.b.a.a.f.f;
import b.b.a.a.g.a.a;
import b.b.a.a.g.a.c;
import b.b.a.a.g.b.d;
import b.b.a.a.j.e;
import b.b.a.a.j.g;
import b.b.a.a.j.i;
import b.b.a.a.j.j;
import java.util.List;

public class b extends c {
    protected a h;
    protected RectF i = new RectF();
    protected b.b.a.a.b.b[] j;
    protected Paint k;
    protected Paint l;
    private RectF m = new RectF();

    public b(a aVar, b.b.a.a.a.a aVar2, j jVar) {
        super(aVar2, jVar);
        this.h = aVar;
        this.d = new Paint(1);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setColor(Color.rgb(0, 0, 0));
        this.d.setAlpha(120);
        this.k = new Paint(1);
        this.k.setStyle(Paint.Style.FILL);
        this.l = new Paint(1);
        this.l.setStyle(Paint.Style.STROKE);
    }

    public void a() {
        b.b.a.a.d.a barData = this.h.getBarData();
        this.j = new b.b.a.a.b.b[barData.b()];
        for (int i2 = 0; i2 < this.j.length; i2++) {
            b.b.a.a.g.b.a aVar = (b.b.a.a.g.b.a) barData.a(i2);
            this.j[i2] = new b.b.a.a.b.b(aVar.r() * 4 * (aVar.Y() ? aVar.W() : 1), barData.b(), aVar.Y());
        }
    }

    public void b(Canvas canvas) {
    }

    public void c(Canvas canvas) {
        boolean z;
        float f;
        float f2;
        boolean z2;
        List list;
        e eVar;
        int i2;
        float f3;
        boolean z3;
        g gVar;
        float[] fArr;
        float f4;
        float[] fArr2;
        int i3;
        float f5;
        float f6;
        int i4;
        List list2;
        e eVar2;
        b.b.a.a.b.b bVar;
        float f7;
        if (a((c) this.h)) {
            List c = this.h.getBarData().c();
            float a2 = i.a(4.5f);
            boolean b2 = this.h.b();
            int i5 = 0;
            while (i5 < this.h.getBarData().b()) {
                b.b.a.a.g.b.a aVar = (b.b.a.a.g.b.a) c.get(i5);
                if (!b(aVar)) {
                    list = c;
                    f2 = f;
                    z2 = z;
                } else {
                    a((d) aVar);
                    boolean b3 = this.h.b(aVar.q());
                    float a3 = (float) i.a(this.f, "8");
                    float f8 = z ? -f : a3 + f;
                    float f9 = z ? a3 + f : -f;
                    if (b3) {
                        f8 = (-f8) - a3;
                        f9 = (-f9) - a3;
                    }
                    float f10 = f8;
                    float f11 = f9;
                    b.b.a.a.b.b bVar2 = this.j[i5];
                    float b4 = this.f1261b.b();
                    e a4 = e.a(aVar.s());
                    a4.e = i.a(a4.e);
                    a4.f = i.a(a4.f);
                    if (!aVar.Y()) {
                        int i6 = 0;
                        while (((float) i6) < ((float) bVar2.f1204b.length) * this.f1261b.a()) {
                            float[] fArr3 = bVar2.f1204b;
                            float f12 = (fArr3[i6] + fArr3[i6 + 2]) / 2.0f;
                            if (!this.f1268a.c(f12)) {
                                break;
                            }
                            int i7 = i6 + 1;
                            if (!this.f1268a.f(bVar2.f1204b[i7]) || !this.f1268a.b(f12)) {
                                i4 = i6;
                                eVar2 = a4;
                                list2 = c;
                                bVar = bVar2;
                            } else {
                                int i8 = i6 / 4;
                                b.b.a.a.d.b bVar3 = (b.b.a.a.d.b) aVar.b(i8);
                                float c2 = bVar3.c();
                                if (aVar.p()) {
                                    f7 = f12;
                                    i4 = i6;
                                    eVar2 = a4;
                                    list2 = c;
                                    bVar = bVar2;
                                    a(canvas, aVar.i(), c2, bVar3, i5, f7, c2 >= 0.0f ? bVar2.f1204b[i7] + f10 : bVar2.f1204b[i6 + 3] + f11, aVar.d(i8));
                                } else {
                                    f7 = f12;
                                    i4 = i6;
                                    eVar2 = a4;
                                    list2 = c;
                                    bVar = bVar2;
                                }
                                if (bVar3.b() != null && aVar.d()) {
                                    Drawable b5 = bVar3.b();
                                    i.a(canvas, b5, (int) (f7 + eVar2.e), (int) ((c2 >= 0.0f ? bVar.f1204b[i7] + f10 : bVar.f1204b[i4 + 3] + f11) + eVar2.f), b5.getIntrinsicWidth(), b5.getIntrinsicHeight());
                                }
                            }
                            i6 = i4 + 4;
                            bVar2 = bVar;
                            a4 = eVar2;
                            c = list2;
                        }
                        eVar = a4;
                        list = c;
                    } else {
                        eVar = a4;
                        list = c;
                        b.b.a.a.b.b bVar4 = bVar2;
                        g a5 = this.h.a(aVar.q());
                        int i9 = 0;
                        int i10 = 0;
                        while (((float) i9) < ((float) aVar.r()) * this.f1261b.a()) {
                            b.b.a.a.d.b bVar5 = (b.b.a.a.d.b) aVar.b(i9);
                            float[] h2 = bVar5.h();
                            float[] fArr4 = bVar4.f1204b;
                            float f13 = (fArr4[i10] + fArr4[i10 + 2]) / 2.0f;
                            int d = aVar.d(i9);
                            if (h2 != null) {
                                i2 = i9;
                                f3 = f;
                                z3 = z;
                                fArr = h2;
                                gVar = a5;
                                float f14 = f13;
                                float[] fArr5 = new float[(fArr.length * 2)];
                                float f15 = -bVar5.e();
                                int i11 = 0;
                                int i12 = 0;
                                float f16 = 0.0f;
                                while (i11 < fArr5.length) {
                                    float f17 = fArr[i12];
                                    if (!(f17 == 0.0f && (f16 == 0.0f || f15 == 0.0f))) {
                                        if (f17 >= 0.0f) {
                                            f17 = f16 + f17;
                                            f16 = f17;
                                        } else {
                                            float f18 = f15;
                                            f15 -= f17;
                                            f17 = f18;
                                        }
                                    }
                                    fArr5[i11 + 1] = f17 * b4;
                                    i11 += 2;
                                    i12++;
                                }
                                gVar.b(fArr5);
                                int i13 = 0;
                                while (i13 < fArr5.length) {
                                    int i14 = i13 / 2;
                                    float f19 = fArr[i14];
                                    float f20 = fArr5[i13 + 1] + (((f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) == 0 && (f15 > 0.0f ? 1 : (f15 == 0.0f ? 0 : -1)) == 0 && (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1)) > 0) || (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) < 0 ? f11 : f10);
                                    if (!this.f1268a.c(f14)) {
                                        break;
                                    }
                                    if (!this.f1268a.f(f20) || !this.f1268a.b(f14)) {
                                        i3 = i13;
                                        fArr2 = fArr5;
                                        f4 = f14;
                                    } else {
                                        if (aVar.p()) {
                                            f5 = f20;
                                            i3 = i13;
                                            fArr2 = fArr5;
                                            f4 = f14;
                                            a(canvas, aVar.i(), fArr[i14], bVar5, i5, f14, f5, d);
                                        } else {
                                            f5 = f20;
                                            i3 = i13;
                                            fArr2 = fArr5;
                                            f4 = f14;
                                        }
                                        if (bVar5.b() != null && aVar.d()) {
                                            Drawable b6 = bVar5.b();
                                            i.a(canvas, b6, (int) (f4 + eVar.e), (int) (f5 + eVar.f), b6.getIntrinsicWidth(), b6.getIntrinsicHeight());
                                        }
                                    }
                                    i13 = i3 + 2;
                                    fArr5 = fArr2;
                                    f14 = f4;
                                }
                            } else if (!this.f1268a.c(f13)) {
                                break;
                            } else {
                                int i15 = i10 + 1;
                                if (!this.f1268a.f(bVar4.f1204b[i15]) || !this.f1268a.b(f13)) {
                                    a5 = a5;
                                    z = z;
                                    f = f;
                                    i9 = i9;
                                } else {
                                    if (aVar.p()) {
                                        f6 = f13;
                                        f3 = f;
                                        fArr = h2;
                                        i2 = i9;
                                        z3 = z;
                                        gVar = a5;
                                        a(canvas, aVar.i(), bVar5.c(), bVar5, i5, f6, bVar4.f1204b[i15] + (bVar5.c() >= 0.0f ? f10 : f11), d);
                                    } else {
                                        f6 = f13;
                                        i2 = i9;
                                        f3 = f;
                                        z3 = z;
                                        fArr = h2;
                                        gVar = a5;
                                    }
                                    if (bVar5.b() != null && aVar.d()) {
                                        Drawable b7 = bVar5.b();
                                        i.a(canvas, b7, (int) (f6 + eVar.e), (int) (bVar4.f1204b[i15] + (bVar5.c() >= 0.0f ? f10 : f11) + eVar.f), b7.getIntrinsicWidth(), b7.getIntrinsicHeight());
                                    }
                                }
                            }
                            if (fArr == null) {
                                i10 += 4;
                            } else {
                                i10 += fArr.length * 4;
                            }
                            i9 = i2 + 1;
                            a5 = gVar;
                            z = z3;
                            f = f3;
                        }
                    }
                    f2 = f;
                    z2 = z;
                    e.b(eVar);
                }
                i5++;
                c = list;
                b2 = z2;
                a2 = f2;
            }
        }
    }

    public void a(Canvas canvas) {
        b.b.a.a.d.a barData = this.h.getBarData();
        for (int i2 = 0; i2 < barData.b(); i2++) {
            b.b.a.a.g.b.a aVar = (b.b.a.a.g.b.a) barData.a(i2);
            if (aVar.isVisible()) {
                a(canvas, aVar, i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, b.b.a.a.g.b.a aVar, int i2) {
        b.b.a.a.g.b.a aVar2 = aVar;
        int i3 = i2;
        g a2 = this.h.a(aVar.q());
        this.l.setColor(aVar.T());
        this.l.setStrokeWidth(i.a(aVar.U()));
        int i4 = 0;
        boolean z = true;
        boolean z2 = aVar.U() > 0.0f;
        float a3 = this.f1261b.a();
        float b2 = this.f1261b.b();
        if (this.h.a()) {
            this.k.setColor(aVar.V());
            float j2 = this.h.getBarData().j() / 2.0f;
            int min = Math.min((int) Math.ceil((double) (((float) aVar.r()) * a3)), aVar.r());
            for (int i5 = 0; i5 < min; i5++) {
                float d = ((b.b.a.a.d.b) aVar2.b(i5)).d();
                RectF rectF = this.m;
                rectF.left = d - j2;
                rectF.right = d + j2;
                a2.a(rectF);
                if (!this.f1268a.b(this.m.right)) {
                    Canvas canvas2 = canvas;
                } else if (!this.f1268a.c(this.m.left)) {
                    break;
                } else {
                    this.m.top = this.f1268a.i();
                    this.m.bottom = this.f1268a.e();
                    canvas.drawRect(this.m, this.k);
                }
            }
        }
        Canvas canvas3 = canvas;
        b.b.a.a.b.b bVar = this.j[i3];
        bVar.a(a3, b2);
        bVar.a(i3);
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
        while (i4 < bVar.b()) {
            int i6 = i4 + 2;
            if (this.f1268a.b(bVar.f1204b[i6])) {
                if (this.f1268a.c(bVar.f1204b[i4])) {
                    if (!z) {
                        this.c.setColor(aVar2.c(i4 / 4));
                    }
                    float[] fArr = bVar.f1204b;
                    int i7 = i4 + 1;
                    int i8 = i4 + 3;
                    canvas.drawRect(fArr[i4], fArr[i7], fArr[i6], fArr[i8], this.c);
                    if (z2) {
                        float[] fArr2 = bVar.f1204b;
                        canvas.drawRect(fArr2[i4], fArr2[i7], fArr2[i6], fArr2[i8], this.l);
                    }
                } else {
                    return;
                }
            }
            i4 += 4;
            Canvas canvas4 = canvas;
        }
    }

    /* access modifiers changed from: protected */
    public void a(float f, float f2, float f3, float f4, g gVar) {
        this.i.set(f - f4, f2, f + f4, f3);
        gVar.a(this.i, this.f1261b.b());
    }

    public void a(Canvas canvas, b.b.a.a.f.c[] cVarArr) {
        float f;
        float f2;
        b.b.a.a.d.a barData = this.h.getBarData();
        for (b.b.a.a.f.c cVar : cVarArr) {
            b.b.a.a.g.b.a aVar = (b.b.a.a.g.b.a) barData.a(cVar.b());
            if (aVar != null && aVar.u()) {
                b.b.a.a.d.b bVar = (b.b.a.a.d.b) aVar.a(cVar.f(), cVar.h());
                if (a(bVar, aVar)) {
                    g a2 = this.h.a(aVar.q());
                    this.d.setColor(aVar.v());
                    this.d.setAlpha(aVar.X());
                    if (!(cVar.e() >= 0 && bVar.i())) {
                        f2 = bVar.c();
                        f = 0.0f;
                    } else if (this.h.c()) {
                        float f3 = bVar.f();
                        f = -bVar.e();
                        f2 = f3;
                    } else {
                        f fVar = bVar.g()[cVar.e()];
                        f2 = fVar.f1252a;
                        f = fVar.f1253b;
                    }
                    a(bVar.d(), f2, f, barData.j() / 2.0f, a2);
                    a(cVar, this.i);
                    canvas.drawRect(this.i, this.d);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(b.b.a.a.f.c cVar, RectF rectF) {
        cVar.a(rectF.centerX(), rectF.top);
    }
}
