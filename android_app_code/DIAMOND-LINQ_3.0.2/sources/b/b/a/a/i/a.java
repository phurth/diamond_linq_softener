package b.b.a.a.i;

import android.graphics.Paint;
import b.b.a.a.j.c;
import b.b.a.a.j.g;
import b.b.a.a.j.i;
import b.b.a.a.j.j;

public abstract class a extends l {

    /* renamed from: b  reason: collision with root package name */
    protected b.b.a.a.c.a f1258b;
    protected g c;
    protected Paint d;
    protected Paint e;
    protected Paint f;
    protected Paint g;

    public a(j jVar, g gVar, b.b.a.a.c.a aVar) {
        super(jVar);
        this.c = gVar;
        this.f1258b = aVar;
        if (this.f1268a != null) {
            this.e = new Paint(1);
            this.d = new Paint();
            this.d.setColor(-7829368);
            this.d.setStrokeWidth(1.0f);
            this.d.setStyle(Paint.Style.STROKE);
            this.d.setAlpha(90);
            this.f = new Paint();
            this.f.setColor(-16777216);
            this.f.setStrokeWidth(1.0f);
            this.f.setStyle(Paint.Style.STROKE);
            this.g = new Paint(1);
            this.g.setStyle(Paint.Style.STROKE);
        }
    }

    public Paint a() {
        return this.e;
    }

    public void a(float f2, float f3, boolean z) {
        float f4;
        double d2;
        j jVar = this.f1268a;
        if (jVar != null && jVar.j() > 10.0f && !this.f1268a.u()) {
            c b2 = this.c.b(this.f1268a.g(), this.f1268a.i());
            c b3 = this.c.b(this.f1268a.g(), this.f1268a.e());
            if (!z) {
                f4 = (float) b3.e;
                d2 = b2.e;
            } else {
                f4 = (float) b2.e;
                d2 = b3.e;
            }
            c.a(b2);
            c.a(b3);
            f2 = f4;
            f3 = (float) d2;
        }
        a(f2, f3);
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
        double d2;
        double d3;
        float f4 = f2;
        float f5 = f3;
        int n = this.f1258b.n();
        double abs = (double) Math.abs(f5 - f4);
        if (n == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            b.b.a.a.c.a aVar = this.f1258b;
            aVar.l = new float[0];
            aVar.m = new float[0];
            aVar.n = 0;
            return;
        }
        double d4 = (double) n;
        Double.isNaN(abs);
        Double.isNaN(d4);
        double b2 = (double) i.b(abs / d4);
        if (this.f1258b.x() && b2 < ((double) this.f1258b.j())) {
            b2 = (double) this.f1258b.j();
        }
        double b3 = (double) i.b(Math.pow(10.0d, (double) ((int) Math.log10(b2))));
        Double.isNaN(b3);
        if (((int) (b2 / b3)) > 5) {
            Double.isNaN(b3);
            b2 = Math.floor(b3 * 10.0d);
        }
        int r = this.f1258b.r();
        if (this.f1258b.w()) {
            b2 = (double) (((float) abs) / ((float) (n - 1)));
            b.b.a.a.c.a aVar2 = this.f1258b;
            aVar2.n = n;
            if (aVar2.l.length < n) {
                aVar2.l = new float[n];
            }
            float f6 = f4;
            for (int i = 0; i < n; i++) {
                this.f1258b.l[i] = f6;
                double d5 = (double) f6;
                Double.isNaN(d5);
                Double.isNaN(b2);
                f6 = (float) (d5 + b2);
            }
        } else {
            if (b2 == 0.0d) {
                d2 = 0.0d;
            } else {
                double d6 = (double) f4;
                Double.isNaN(d6);
                d2 = Math.ceil(d6 / b2) * b2;
            }
            if (this.f1258b.r()) {
                d2 -= b2;
            }
            if (b2 == 0.0d) {
                d3 = 0.0d;
            } else {
                double d7 = (double) f5;
                Double.isNaN(d7);
                d3 = i.a(Math.floor(d7 / b2) * b2);
            }
            if (b2 != 0.0d) {
                for (double d8 = d2; d8 <= d3; d8 += b2) {
                    r++;
                }
            }
            n = r;
            b.b.a.a.c.a aVar3 = this.f1258b;
            aVar3.n = n;
            if (aVar3.l.length < n) {
                aVar3.l = new float[n];
            }
            for (int i2 = 0; i2 < n; i2++) {
                if (d2 == 0.0d) {
                    d2 = 0.0d;
                }
                this.f1258b.l[i2] = (float) d2;
                d2 += b2;
            }
        }
        if (b2 < 1.0d) {
            this.f1258b.o = (int) Math.ceil(-Math.log10(b2));
        } else {
            this.f1258b.o = 0;
        }
        if (this.f1258b.r()) {
            b.b.a.a.c.a aVar4 = this.f1258b;
            if (aVar4.m.length < n) {
                aVar4.m = new float[n];
            }
            float f7 = ((float) b2) / 2.0f;
            for (int i3 = 0; i3 < n; i3++) {
                b.b.a.a.c.a aVar5 = this.f1258b;
                aVar5.m[i3] = aVar5.l[i3] + f7;
            }
        }
    }
}
