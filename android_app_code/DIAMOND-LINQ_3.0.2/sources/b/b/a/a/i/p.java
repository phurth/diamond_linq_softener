package b.b.a.a.i;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import b.b.a.a.c.h;
import b.b.a.a.c.j;
import b.b.a.a.j.c;
import b.b.a.a.j.g;
import b.b.a.a.j.i;
import b.b.a.a.j.j;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public class p extends o {
    protected Path r = new Path();
    protected Path s = new Path();
    protected float[] t = new float[4];

    public p(j jVar, b.b.a.a.c.j jVar2, g gVar) {
        super(jVar, jVar2, gVar);
        this.g.setTextAlign(Paint.Align.LEFT);
    }

    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.f1268a.f() > 10.0f && !this.f1268a.t()) {
            c b2 = this.c.b(this.f1268a.g(), this.f1268a.i());
            c b3 = this.c.b(this.f1268a.h(), this.f1268a.i());
            if (!z) {
                f3 = (float) b2.d;
                d = b3.d;
            } else {
                f3 = (float) b3.d;
                d = b2.d;
            }
            c.a(b2);
            c.a(b3);
            f = f3;
            f2 = (float) d;
        }
        a(f, f2);
    }

    public void b(Canvas canvas) {
        float f;
        float f2;
        float f3;
        if (this.h.f() && this.h.u()) {
            float[] c = c();
            this.e.setTypeface(this.h.c());
            this.e.setTextSize(this.h.b());
            this.e.setColor(this.h.a());
            this.e.setTextAlign(Paint.Align.CENTER);
            float a2 = i.a(2.5f);
            float a3 = (float) i.a(this.e, "Q");
            j.a y = this.h.y();
            j.b z = this.h.z();
            if (y == j.a.LEFT) {
                if (z == j.b.OUTSIDE_CHART) {
                    f3 = this.f1268a.i();
                } else {
                    f3 = this.f1268a.i();
                }
                f = f3 - a2;
            } else {
                if (z == j.b.OUTSIDE_CHART) {
                    f2 = this.f1268a.e();
                } else {
                    f2 = this.f1268a.e();
                }
                f = f2 + a3 + a2;
            }
            a(canvas, f, c, this.h.e());
        }
    }

    public void c(Canvas canvas) {
        if (this.h.f() && this.h.s()) {
            this.f.setColor(this.h.g());
            this.f.setStrokeWidth(this.h.i());
            if (this.h.y() == j.a.LEFT) {
                canvas.drawLine(this.f1268a.g(), this.f1268a.i(), this.f1268a.h(), this.f1268a.i(), this.f);
                return;
            }
            canvas.drawLine(this.f1268a.g(), this.f1268a.e(), this.f1268a.h(), this.f1268a.e(), this.f);
        }
    }

    public void e(Canvas canvas) {
        Canvas canvas2 = canvas;
        List<h> o = this.h.o();
        if (o != null && o.size() > 0) {
            float[] fArr = this.t;
            float f = 0.0f;
            fArr[0] = 0.0f;
            char c = 1;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            Path path = this.s;
            path.reset();
            int i = 0;
            while (i < o.size()) {
                h hVar = o.get(i);
                if (hVar.f()) {
                    int save = canvas.save();
                    this.q.set(this.f1268a.n());
                    this.q.inset(-hVar.l(), f);
                    canvas2.clipRect(this.q);
                    fArr[0] = hVar.j();
                    fArr[2] = hVar.j();
                    this.c.b(fArr);
                    fArr[c] = this.f1268a.i();
                    fArr[3] = this.f1268a.e();
                    path.moveTo(fArr[0], fArr[c]);
                    path.lineTo(fArr[2], fArr[3]);
                    this.g.setStyle(Paint.Style.STROKE);
                    this.g.setColor(hVar.k());
                    this.g.setPathEffect(hVar.g());
                    this.g.setStrokeWidth(hVar.l());
                    canvas2.drawPath(path, this.g);
                    path.reset();
                    String h = hVar.h();
                    if (h != null && !h.equals(BuildConfig.FLAVOR)) {
                        this.g.setStyle(hVar.m());
                        this.g.setPathEffect((PathEffect) null);
                        this.g.setColor(hVar.a());
                        this.g.setTypeface(hVar.c());
                        this.g.setStrokeWidth(0.5f);
                        this.g.setTextSize(hVar.b());
                        float l = hVar.l() + hVar.d();
                        float a2 = i.a(2.0f) + hVar.e();
                        h.a i2 = hVar.i();
                        if (i2 == h.a.RIGHT_TOP) {
                            this.g.setTextAlign(Paint.Align.LEFT);
                            canvas2.drawText(h, fArr[0] + l, this.f1268a.i() + a2 + ((float) i.a(this.g, h)), this.g);
                        } else if (i2 == h.a.RIGHT_BOTTOM) {
                            this.g.setTextAlign(Paint.Align.LEFT);
                            canvas2.drawText(h, fArr[0] + l, this.f1268a.e() - a2, this.g);
                        } else if (i2 == h.a.LEFT_TOP) {
                            this.g.setTextAlign(Paint.Align.RIGHT);
                            canvas2.drawText(h, fArr[0] - l, this.f1268a.i() + a2 + ((float) i.a(this.g, h)), this.g);
                        } else {
                            this.g.setTextAlign(Paint.Align.RIGHT);
                            canvas2.drawText(h, fArr[0] - l, this.f1268a.e() - a2, this.g);
                        }
                    }
                    canvas2.restoreToCount(save);
                }
                i++;
                f = 0.0f;
                c = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public float[] c() {
        int length = this.l.length;
        int i = this.h.n;
        if (length != i * 2) {
            this.l = new float[(i * 2)];
        }
        float[] fArr = this.l;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2] = this.h.l[i2 / 2];
        }
        this.c.b(fArr);
        return fArr;
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f, float[] fArr, float f2) {
        this.e.setTypeface(this.h.c());
        this.e.setTextSize(this.h.b());
        this.e.setColor(this.h.a());
        int i = this.h.H() ? this.h.n : this.h.n - 1;
        for (int i2 = !this.h.G(); i2 < i; i2++) {
            canvas.drawText(this.h.b(i2), fArr[i2 * 2], f - f2, this.e);
        }
    }

    public RectF b() {
        this.k.set(this.f1268a.n());
        this.k.inset(-this.f1258b.m(), 0.0f);
        return this.k;
    }

    /* access modifiers changed from: protected */
    public Path a(Path path, int i, float[] fArr) {
        path.moveTo(fArr[i], this.f1268a.i());
        path.lineTo(fArr[i], this.f1268a.e());
        return path;
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        int save = canvas.save();
        this.n.set(this.f1268a.n());
        this.n.inset(-this.h.F(), 0.0f);
        canvas.clipRect(this.q);
        c a2 = this.c.a(0.0f, 0.0f);
        this.i.setColor(this.h.E());
        this.i.setStrokeWidth(this.h.F());
        Path path = this.r;
        path.reset();
        path.moveTo(((float) a2.d) - 1.0f, this.f1268a.i());
        path.lineTo(((float) a2.d) - 1.0f, this.f1268a.e());
        canvas.drawPath(path, this.i);
        canvas.restoreToCount(save);
    }
}
