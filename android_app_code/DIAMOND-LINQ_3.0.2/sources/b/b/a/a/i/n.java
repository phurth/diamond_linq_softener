package b.b.a.a.i;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import b.b.a.a.c.h;
import b.b.a.a.c.i;
import b.b.a.a.e.d;
import b.b.a.a.j.c;
import b.b.a.a.j.e;
import b.b.a.a.j.g;
import b.b.a.a.j.j;
import com.github.mikephil.charting.charts.a;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public class n extends m {
    protected a p;
    protected Path q = new Path();

    public n(j jVar, i iVar, g gVar, a aVar) {
        super(jVar, iVar, gVar);
        this.p = aVar;
    }

    public void a(float f, float f2, boolean z) {
        float f3;
        double d;
        if (this.f1268a.j() > 10.0f && !this.f1268a.u()) {
            c b2 = this.c.b(this.f1268a.g(), this.f1268a.e());
            c b3 = this.c.b(this.f1268a.g(), this.f1268a.i());
            if (z) {
                f3 = (float) b3.e;
                d = b2.e;
            } else {
                f3 = (float) b2.e;
                d = b3.e;
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
        this.e.setTypeface(this.h.c());
        this.e.setTextSize(this.h.b());
        b.b.a.a.j.a b2 = b.b.a.a.j.i.b(this.e, this.h.p());
        float f = b2.e;
        b.b.a.a.j.a a2 = b.b.a.a.j.i.a(b2.d, f, this.h.y());
        this.h.I = Math.round((float) ((int) (b2.d + (this.h.d() * 3.5f))));
        this.h.J = Math.round(f);
        i iVar = this.h;
        iVar.K = (int) (a2.d + (iVar.d() * 3.5f));
        this.h.L = Math.round(a2.e);
        b.b.a.a.j.a.a(a2);
    }

    public RectF c() {
        this.k.set(this.f1268a.n());
        this.k.inset(0.0f, -this.f1258b.m());
        return this.k;
    }

    public void d(Canvas canvas) {
        List<h> o = this.h.o();
        if (o != null && o.size() > 0) {
            float[] fArr = this.l;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.q;
            path.reset();
            for (int i = 0; i < o.size(); i++) {
                h hVar = o.get(i);
                if (hVar.f()) {
                    int save = canvas.save();
                    this.m.set(this.f1268a.n());
                    this.m.inset(0.0f, -hVar.l());
                    canvas.clipRect(this.m);
                    this.g.setStyle(Paint.Style.STROKE);
                    this.g.setColor(hVar.k());
                    this.g.setStrokeWidth(hVar.l());
                    this.g.setPathEffect(hVar.g());
                    fArr[1] = hVar.j();
                    this.c.b(fArr);
                    path.moveTo(this.f1268a.g(), fArr[1]);
                    path.lineTo(this.f1268a.h(), fArr[1]);
                    canvas.drawPath(path, this.g);
                    path.reset();
                    String h = hVar.h();
                    if (h != null && !h.equals(BuildConfig.FLAVOR)) {
                        this.g.setStyle(hVar.m());
                        this.g.setPathEffect((PathEffect) null);
                        this.g.setColor(hVar.a());
                        this.g.setStrokeWidth(0.5f);
                        this.g.setTextSize(hVar.b());
                        float a2 = (float) b.b.a.a.j.i.a(this.g, h);
                        float a3 = b.b.a.a.j.i.a(4.0f) + hVar.d();
                        float l = hVar.l() + a2 + hVar.e();
                        h.a i2 = hVar.i();
                        if (i2 == h.a.RIGHT_TOP) {
                            this.g.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(h, this.f1268a.h() - a3, (fArr[1] - l) + a2, this.g);
                        } else if (i2 == h.a.RIGHT_BOTTOM) {
                            this.g.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(h, this.f1268a.h() - a3, fArr[1] + l, this.g);
                        } else if (i2 == h.a.LEFT_TOP) {
                            this.g.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(h, this.f1268a.g() + a3, (fArr[1] - l) + a2, this.g);
                        } else {
                            this.g.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(h, this.f1268a.w() + a3, fArr[1] + l, this.g);
                        }
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    public void a(Canvas canvas) {
        if (this.h.f() && this.h.u()) {
            float d = this.h.d();
            this.e.setTypeface(this.h.c());
            this.e.setTextSize(this.h.b());
            this.e.setColor(this.h.a());
            e a2 = e.a(0.0f, 0.0f);
            if (this.h.z() == i.a.TOP) {
                a2.e = 0.0f;
                a2.f = 0.5f;
                a(canvas, this.f1268a.h() + d, a2);
            } else if (this.h.z() == i.a.TOP_INSIDE) {
                a2.e = 1.0f;
                a2.f = 0.5f;
                a(canvas, this.f1268a.h() - d, a2);
            } else if (this.h.z() == i.a.BOTTOM) {
                a2.e = 1.0f;
                a2.f = 0.5f;
                a(canvas, this.f1268a.g() - d, a2);
            } else if (this.h.z() == i.a.BOTTOM_INSIDE) {
                a2.e = 1.0f;
                a2.f = 0.5f;
                a(canvas, this.f1268a.g() + d, a2);
            } else {
                a2.e = 0.0f;
                a2.f = 0.5f;
                a(canvas, this.f1268a.h() + d, a2);
                a2.e = 1.0f;
                a2.f = 0.5f;
                a(canvas, this.f1268a.g() - d, a2);
            }
            e.b(a2);
        }
    }

    public void b(Canvas canvas) {
        if (this.h.s() && this.h.f()) {
            this.f.setColor(this.h.g());
            this.f.setStrokeWidth(this.h.i());
            if (this.h.z() == i.a.TOP || this.h.z() == i.a.TOP_INSIDE || this.h.z() == i.a.BOTH_SIDED) {
                canvas.drawLine(this.f1268a.h(), this.f1268a.i(), this.f1268a.h(), this.f1268a.e(), this.f);
            }
            if (this.h.z() == i.a.BOTTOM || this.h.z() == i.a.BOTTOM_INSIDE || this.h.z() == i.a.BOTH_SIDED) {
                canvas.drawLine(this.f1268a.g(), this.f1268a.i(), this.f1268a.g(), this.f1268a.e(), this.f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f, e eVar) {
        float y = this.h.y();
        boolean r = this.h.r();
        float[] fArr = new float[(this.h.n * 2)];
        for (int i = 0; i < fArr.length; i += 2) {
            if (r) {
                fArr[i + 1] = this.h.m[i / 2];
            } else {
                fArr[i + 1] = this.h.l[i / 2];
            }
        }
        this.c.b(fArr);
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            float f2 = fArr[i2 + 1];
            if (this.f1268a.f(f2)) {
                d q2 = this.h.q();
                i iVar = this.h;
                a(canvas, q2.a(iVar.l[i2 / 2], iVar), f, f2, eVar, y);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f, float f2, Path path) {
        path.moveTo(this.f1268a.h(), f2);
        path.lineTo(this.f1268a.g(), f2);
        canvas.drawPath(path, this.d);
        path.reset();
    }
}
