package b.b.a.a.j;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import b.b.a.a.d.j;
import b.b.a.a.g.b.e;

public class g {

    /* renamed from: a  reason: collision with root package name */
    protected Matrix f1273a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    protected Matrix f1274b = new Matrix();
    protected j c;
    protected float[] d = new float[1];
    protected float[] e = new float[1];
    protected float[] f = new float[1];
    protected float[] g = new float[1];
    protected Matrix h = new Matrix();
    float[] i = new float[2];
    private Matrix j = new Matrix();
    private Matrix k = new Matrix();

    public g(j jVar) {
        this.c = jVar;
    }

    public void a(float f2, float f3, float f4, float f5) {
        float j2 = this.c.j() / f3;
        float f6 = this.c.f() / f4;
        if (Float.isInfinite(j2)) {
            j2 = 0.0f;
        }
        if (Float.isInfinite(f6)) {
            f6 = 0.0f;
        }
        this.f1273a.reset();
        this.f1273a.postTranslate(-f2, -f5);
        this.f1273a.postScale(j2, -f6);
    }

    public void b(float[] fArr) {
        this.f1273a.mapPoints(fArr);
        this.c.o().mapPoints(fArr);
        this.f1274b.mapPoints(fArr);
    }

    public void b(RectF rectF, float f2) {
        rectF.left *= f2;
        rectF.right *= f2;
        this.f1273a.mapRect(rectF);
        this.c.o().mapRect(rectF);
        this.f1274b.mapRect(rectF);
    }

    public void a(boolean z) {
        this.f1274b.reset();
        if (!z) {
            this.f1274b.postTranslate(this.c.w(), this.c.k() - this.c.v());
            return;
        }
        this.f1274b.setTranslate(this.c.w(), -this.c.y());
        this.f1274b.postScale(1.0f, -1.0f);
    }

    public c b(float f2, float f3) {
        c a2 = c.a(0.0d, 0.0d);
        a(f2, f3, a2);
        return a2;
    }

    public float[] a(e eVar, float f2, float f3, int i2, int i3) {
        int i4 = (((int) (((float) (i3 - i2)) * f2)) + 1) * 2;
        if (this.f.length != i4) {
            this.f = new float[i4];
        }
        float[] fArr = this.f;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            j b2 = eVar.b((i5 / 2) + i2);
            if (b2 != null) {
                fArr[i5] = b2.d();
                fArr[i5 + 1] = b2.c() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        a().mapPoints(fArr);
        return fArr;
    }

    public void a(Path path) {
        path.transform(this.f1273a);
        path.transform(this.c.o());
        path.transform(this.f1274b);
    }

    public void a(RectF rectF) {
        this.f1273a.mapRect(rectF);
        this.c.o().mapRect(rectF);
        this.f1274b.mapRect(rectF);
    }

    public void a(RectF rectF, float f2) {
        rectF.top *= f2;
        rectF.bottom *= f2;
        this.f1273a.mapRect(rectF);
        this.c.o().mapRect(rectF);
        this.f1274b.mapRect(rectF);
    }

    public void a(float[] fArr) {
        Matrix matrix = this.h;
        matrix.reset();
        this.f1274b.invert(matrix);
        matrix.mapPoints(fArr);
        this.c.o().invert(matrix);
        matrix.mapPoints(fArr);
        this.f1273a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void a(float f2, float f3, c cVar) {
        float[] fArr = this.i;
        fArr[0] = f2;
        fArr[1] = f3;
        a(fArr);
        float[] fArr2 = this.i;
        cVar.d = (double) fArr2[0];
        cVar.e = (double) fArr2[1];
    }

    public c a(float f2, float f3) {
        float[] fArr = this.i;
        fArr[0] = f2;
        fArr[1] = f3;
        b(fArr);
        float[] fArr2 = this.i;
        return c.a((double) fArr2[0], (double) fArr2[1]);
    }

    public Matrix a() {
        this.j.set(this.f1273a);
        this.j.postConcat(this.c.f1277a);
        this.j.postConcat(this.f1274b);
        return this.j;
    }
}
