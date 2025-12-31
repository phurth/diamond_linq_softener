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
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public class o extends a {
    protected j h;
    protected Paint i;
    protected Path j = new Path();
    protected RectF k = new RectF();
    protected float[] l = new float[2];
    protected Path m = new Path();
    protected RectF n = new RectF();
    protected Path o = new Path();
    protected float[] p = new float[2];
    protected RectF q = new RectF();

    public o(b.b.a.a.j.j jVar, j jVar2, g gVar) {
        super(jVar, gVar, jVar2);
        this.h = jVar2;
        if (this.f1268a != null) {
            this.e.setColor(-16777216);
            this.e.setTextSize(i.a(10.0f));
            this.i = new Paint(1);
            this.i.setColor(-7829368);
            this.i.setStrokeWidth(1.0f);
            this.i.setStyle(Paint.Style.STROKE);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f, float[] fArr, float f2) {
        int i2 = this.h.H() ? this.h.n : this.h.n - 1;
        for (int i3 = !this.h.G(); i3 < i2; i3++) {
            canvas.drawText(this.h.b(i3), f, fArr[(i3 * 2) + 1] + f2, this.e);
        }
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
            float d = this.h.d();
            float a2 = (((float) i.a(this.e, "A")) / 2.5f) + this.h.e();
            j.a y = this.h.y();
            j.b z = this.h.z();
            if (y == j.a.LEFT) {
                if (z == j.b.OUTSIDE_CHART) {
                    this.e.setTextAlign(Paint.Align.RIGHT);
                    f2 = this.f1268a.w();
                    f = f2 - d;
                    a(canvas, f, c, a2);
                }
                this.e.setTextAlign(Paint.Align.LEFT);
                f3 = this.f1268a.w();
            } else if (z == j.b.OUTSIDE_CHART) {
                this.e.setTextAlign(Paint.Align.LEFT);
                f3 = this.f1268a.h();
            } else {
                this.e.setTextAlign(Paint.Align.RIGHT);
                f2 = this.f1268a.h();
                f = f2 - d;
                a(canvas, f, c, a2);
            }
            f = f3 + d;
            a(canvas, f, c, a2);
        }
    }

    public void c(Canvas canvas) {
        if (this.h.f() && this.h.s()) {
            this.f.setColor(this.h.g());
            this.f.setStrokeWidth(this.h.i());
            if (this.h.y() == j.a.LEFT) {
                canvas.drawLine(this.f1268a.g(), this.f1268a.i(), this.f1268a.g(), this.f1268a.e(), this.f);
                return;
            }
            canvas.drawLine(this.f1268a.h(), this.f1268a.i(), this.f1268a.h(), this.f1268a.e(), this.f);
        }
    }

    public void d(Canvas canvas) {
        if (this.h.f()) {
            if (this.h.t()) {
                int save = canvas.save();
                canvas.clipRect(b());
                float[] c = c();
                this.d.setColor(this.h.k());
                this.d.setStrokeWidth(this.h.m());
                this.d.setPathEffect(this.h.l());
                Path path = this.j;
                path.reset();
                for (int i2 = 0; i2 < c.length; i2 += 2) {
                    canvas.drawPath(a(path, i2, c), this.d);
                    path.reset();
                }
                canvas.restoreToCount(save);
            }
            if (this.h.I()) {
                a(canvas);
            }
        }
    }

    public void e(Canvas canvas) {
        List<h> o2 = this.h.o();
        if (o2 != null && o2.size() > 0) {
            float[] fArr = this.p;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.o;
            path.reset();
            for (int i2 = 0; i2 < o2.size(); i2++) {
                h hVar = o2.get(i2);
                if (hVar.f()) {
                    int save = canvas.save();
                    this.q.set(this.f1268a.n());
                    this.q.inset(0.0f, -hVar.l());
                    canvas.clipRect(this.q);
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
                    String h2 = hVar.h();
                    if (h2 != null && !h2.equals(BuildConfig.FLAVOR)) {
                        this.g.setStyle(hVar.m());
                        this.g.setPathEffect((PathEffect) null);
                        this.g.setColor(hVar.a());
                        this.g.setTypeface(hVar.c());
                        this.g.setStrokeWidth(0.5f);
                        this.g.setTextSize(hVar.b());
                        float a2 = (float) i.a(this.g, h2);
                        float a3 = i.a(4.0f) + hVar.d();
                        float l2 = hVar.l() + a2 + hVar.e();
                        h.a i3 = hVar.i();
                        if (i3 == h.a.RIGHT_TOP) {
                            this.g.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(h2, this.f1268a.h() - a3, (fArr[1] - l2) + a2, this.g);
                        } else if (i3 == h.a.RIGHT_BOTTOM) {
                            this.g.setTextAlign(Paint.Align.RIGHT);
                            canvas.drawText(h2, this.f1268a.h() - a3, fArr[1] + l2, this.g);
                        } else if (i3 == h.a.LEFT_TOP) {
                            this.g.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(h2, this.f1268a.g() + a3, (fArr[1] - l2) + a2, this.g);
                        } else {
                            this.g.setTextAlign(Paint.Align.LEFT);
                            canvas.drawText(h2, this.f1268a.w() + a3, fArr[1] + l2, this.g);
                        }
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public Path a(Path path, int i2, float[] fArr) {
        int i3 = i2 + 1;
        path.moveTo(this.f1268a.w(), fArr[i3]);
        path.lineTo(this.f1268a.h(), fArr[i3]);
        return path;
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        int save = canvas.save();
        this.n.set(this.f1268a.n());
        this.n.inset(0.0f, -this.h.F());
        canvas.clipRect(this.n);
        c a2 = this.c.a(0.0f, 0.0f);
        this.i.setColor(this.h.E());
        this.i.setStrokeWidth(this.h.F());
        Path path = this.m;
        path.reset();
        path.moveTo(this.f1268a.g(), (float) a2.e);
        path.lineTo(this.f1268a.h(), (float) a2.e);
        canvas.drawPath(path, this.i);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public float[] c() {
        int length = this.l.length;
        int i2 = this.h.n;
        if (length != i2 * 2) {
            this.l = new float[(i2 * 2)];
        }
        float[] fArr = this.l;
        for (int i3 = 0; i3 < fArr.length; i3 += 2) {
            fArr[i3 + 1] = this.h.l[i3 / 2];
        }
        this.c.b(fArr);
        return fArr;
    }

    public RectF b() {
        this.k.set(this.f1268a.n());
        this.k.inset(0.0f, -this.f1258b.m());
        return this.k;
    }
}
