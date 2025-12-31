package b.b.a.a.i;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import b.b.a.a.c.h;
import b.b.a.a.c.i;
import b.b.a.a.e.d;
import b.b.a.a.j.a;
import b.b.a.a.j.c;
import b.b.a.a.j.e;
import b.b.a.a.j.g;
import b.b.a.a.j.j;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public class m extends a {
    protected i h;
    protected Path i = new Path();
    protected float[] j = new float[2];
    protected RectF k = new RectF();
    protected float[] l = new float[2];
    protected RectF m = new RectF();
    float[] n = new float[4];
    private Path o = new Path();

    public m(j jVar, i iVar, g gVar) {
        super(jVar, gVar, iVar);
        this.h = iVar;
        this.e.setColor(-16777216);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setTextSize(b.b.a.a.j.i.a(10.0f));
    }

    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.f1268a.j() > 10.0f && !this.f1268a.t()) {
            c b2 = this.c.b(this.f1268a.g(), this.f1268a.i());
            c b3 = this.c.b(this.f1268a.h(), this.f1268a.i());
            if (z) {
                f3 = (float) b3.d;
                d = b2.d;
            } else {
                f3 = (float) b2.d;
                d = b3.d;
            }
            c.a(b2);
            c.a(b3);
            f = f3;
            f2 = (float) d;
        }
        a(f, f2);
    }

    /* access modifiers changed from: protected */
    public void b() {
        String p = this.h.p();
        this.e.setTypeface(this.h.c());
        this.e.setTextSize(this.h.b());
        a b2 = b.b.a.a.j.i.b(this.e, p);
        float f = b2.d;
        float a2 = (float) b.b.a.a.j.i.a(this.e, "Q");
        a a3 = b.b.a.a.j.i.a(f, a2, this.h.y());
        this.h.I = Math.round(f);
        this.h.J = Math.round(a2);
        this.h.K = Math.round(a3.d);
        this.h.L = Math.round(a3.e);
        a.a(a3);
        a.a(b2);
    }

    public void c(Canvas canvas) {
        if (this.h.t() && this.h.f()) {
            int save = canvas.save();
            canvas.clipRect(c());
            if (this.j.length != this.f1258b.n * 2) {
                this.j = new float[(this.h.n * 2)];
            }
            float[] fArr = this.j;
            for (int i2 = 0; i2 < fArr.length; i2 += 2) {
                float[] fArr2 = this.h.l;
                int i3 = i2 / 2;
                fArr[i2] = fArr2[i3];
                fArr[i2 + 1] = fArr2[i3];
            }
            this.c.b(fArr);
            d();
            Path path = this.i;
            path.reset();
            for (int i4 = 0; i4 < fArr.length; i4 += 2) {
                a(canvas, fArr[i4], fArr[i4 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.d.setColor(this.h.k());
        this.d.setStrokeWidth(this.h.m());
        this.d.setPathEffect(this.h.l());
    }

    public void d(Canvas canvas) {
        List<h> o2 = this.h.o();
        if (o2 != null && o2.size() > 0) {
            float[] fArr = this.l;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            for (int i2 = 0; i2 < o2.size(); i2++) {
                h hVar = o2.get(i2);
                if (hVar.f()) {
                    int save = canvas.save();
                    this.m.set(this.f1268a.n());
                    this.m.inset(-hVar.l(), 0.0f);
                    canvas.clipRect(this.m);
                    fArr[0] = hVar.j();
                    fArr[1] = 0.0f;
                    this.c.b(fArr);
                    a(canvas, hVar, fArr);
                    a(canvas, hVar, fArr, hVar.e() + 2.0f);
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(float f, float f2) {
        super.a(f, f2);
        b();
    }

    public void a(Canvas canvas) {
        if (this.h.f() && this.h.u()) {
            float e = this.h.e();
            this.e.setTypeface(this.h.c());
            this.e.setTextSize(this.h.b());
            this.e.setColor(this.h.a());
            e a2 = e.a(0.0f, 0.0f);
            if (this.h.z() == i.a.TOP) {
                a2.e = 0.5f;
                a2.f = 1.0f;
                a(canvas, this.f1268a.i() - e, a2);
            } else if (this.h.z() == i.a.TOP_INSIDE) {
                a2.e = 0.5f;
                a2.f = 1.0f;
                a(canvas, this.f1268a.i() + e + ((float) this.h.L), a2);
            } else if (this.h.z() == i.a.BOTTOM) {
                a2.e = 0.5f;
                a2.f = 0.0f;
                a(canvas, this.f1268a.e() + e, a2);
            } else if (this.h.z() == i.a.BOTTOM_INSIDE) {
                a2.e = 0.5f;
                a2.f = 0.0f;
                a(canvas, (this.f1268a.e() - e) - ((float) this.h.L), a2);
            } else {
                a2.e = 0.5f;
                a2.f = 1.0f;
                a(canvas, this.f1268a.i() - e, a2);
                a2.e = 0.5f;
                a2.f = 0.0f;
                a(canvas, this.f1268a.e() + e, a2);
            }
            e.b(a2);
        }
    }

    public void b(Canvas canvas) {
        if (this.h.s() && this.h.f()) {
            this.f.setColor(this.h.g());
            this.f.setStrokeWidth(this.h.i());
            this.f.setPathEffect(this.h.h());
            if (this.h.z() == i.a.TOP || this.h.z() == i.a.TOP_INSIDE || this.h.z() == i.a.BOTH_SIDED) {
                canvas.drawLine(this.f1268a.g(), this.f1268a.i(), this.f1268a.h(), this.f1268a.i(), this.f);
            }
            if (this.h.z() == i.a.BOTTOM || this.h.z() == i.a.BOTTOM_INSIDE || this.h.z() == i.a.BOTH_SIDED) {
                canvas.drawLine(this.f1268a.g(), this.f1268a.e(), this.f1268a.h(), this.f1268a.e(), this.f);
            }
        }
    }

    public RectF c() {
        this.k.set(this.f1268a.n());
        this.k.inset(-this.f1258b.m(), 0.0f);
        return this.k;
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f, e eVar) {
        float y = this.h.y();
        boolean r = this.h.r();
        float[] fArr = new float[(this.h.n * 2)];
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            if (r) {
                fArr[i2] = this.h.m[i2 / 2];
            } else {
                fArr[i2] = this.h.l[i2 / 2];
            }
        }
        this.c.b(fArr);
        for (int i3 = 0; i3 < fArr.length; i3 += 2) {
            float f2 = fArr[i3];
            if (this.f1268a.e(f2)) {
                d q = this.h.q();
                i iVar = this.h;
                String a2 = q.a(iVar.l[i3 / 2], iVar);
                if (this.h.A()) {
                    int i4 = this.h.n;
                    if (i3 == i4 - 1 && i4 > 1) {
                        float c = (float) b.b.a.a.j.i.c(this.e, a2);
                        if (c > this.f1268a.x() * 2.0f && f2 + c > this.f1268a.l()) {
                            f2 -= c / 2.0f;
                        }
                    } else if (i3 == 0) {
                        f2 += ((float) b.b.a.a.j.i.c(this.e, a2)) / 2.0f;
                    }
                }
                a(canvas, a2, f2, f, eVar, y);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, String str, float f, float f2, e eVar, float f3) {
        b.b.a.a.j.i.a(canvas, str, f, f2, this.e, eVar, f3);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(f, this.f1268a.e());
        path.lineTo(f, this.f1268a.i());
        canvas.drawPath(path, this.d);
        path.reset();
    }

    public void a(Canvas canvas, h hVar, float[] fArr) {
        float[] fArr2 = this.n;
        fArr2[0] = fArr[0];
        fArr2[1] = this.f1268a.i();
        float[] fArr3 = this.n;
        fArr3[2] = fArr[0];
        fArr3[3] = this.f1268a.e();
        this.o.reset();
        Path path = this.o;
        float[] fArr4 = this.n;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.o;
        float[] fArr5 = this.n;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setColor(hVar.k());
        this.g.setStrokeWidth(hVar.l());
        this.g.setPathEffect(hVar.g());
        canvas.drawPath(this.o, this.g);
    }

    public void a(Canvas canvas, h hVar, float[] fArr, float f) {
        String h2 = hVar.h();
        if (h2 != null && !h2.equals(BuildConfig.FLAVOR)) {
            this.g.setStyle(hVar.m());
            this.g.setPathEffect((PathEffect) null);
            this.g.setColor(hVar.a());
            this.g.setStrokeWidth(0.5f);
            this.g.setTextSize(hVar.b());
            float l2 = hVar.l() + hVar.d();
            h.a i2 = hVar.i();
            if (i2 == h.a.RIGHT_TOP) {
                this.g.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(h2, fArr[0] + l2, this.f1268a.i() + f + ((float) b.b.a.a.j.i.a(this.g, h2)), this.g);
            } else if (i2 == h.a.RIGHT_BOTTOM) {
                this.g.setTextAlign(Paint.Align.LEFT);
                canvas.drawText(h2, fArr[0] + l2, this.f1268a.e() - f, this.g);
            } else if (i2 == h.a.LEFT_TOP) {
                this.g.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(h2, fArr[0] - l2, this.f1268a.i() + f + ((float) b.b.a.a.j.i.a(this.g, h2)), this.g);
            } else {
                this.g.setTextAlign(Paint.Align.RIGHT);
                canvas.drawText(h2, fArr[0] - l2, this.f1268a.e() - f, this.g);
            }
        }
    }
}
