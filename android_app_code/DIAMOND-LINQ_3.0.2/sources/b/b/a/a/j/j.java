package b.b.a.a.j;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public class j {

    /* renamed from: a  reason: collision with root package name */
    protected final Matrix f1277a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    protected RectF f1278b = new RectF();
    protected float c = 0.0f;
    protected float d = 0.0f;
    private float e = 1.0f;
    private float f = Float.MAX_VALUE;
    private float g = 1.0f;
    private float h = Float.MAX_VALUE;
    private float i = 1.0f;
    private float j = 1.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private float n = 0.0f;
    protected float[] o = new float[9];
    protected Matrix p = new Matrix();
    protected final float[] q = new float[9];

    public void a(float f2, float f3, float f4, float f5) {
        this.f1278b.set(f2, f3, this.c - f4, this.d - f5);
    }

    public void b(float f2, float f3) {
        float w = w();
        float y = y();
        float x = x();
        float v = v();
        this.d = f3;
        this.c = f2;
        a(w, y, x, v);
    }

    public boolean c(float f2) {
        return this.f1278b.right >= (((float) ((int) (f2 * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean d(float f2) {
        return this.f1278b.top <= f2;
    }

    public float e() {
        return this.f1278b.bottom;
    }

    public float f() {
        return this.f1278b.height();
    }

    public float g() {
        return this.f1278b.left;
    }

    public float h() {
        return this.f1278b.right;
    }

    public float i() {
        return this.f1278b.top;
    }

    public float j() {
        return this.f1278b.width();
    }

    public float k() {
        return this.d;
    }

    public float l() {
        return this.c;
    }

    public e m() {
        return e.a(this.f1278b.centerX(), this.f1278b.centerY());
    }

    public RectF n() {
        return this.f1278b;
    }

    public Matrix o() {
        return this.f1277a;
    }

    public float p() {
        return this.i;
    }

    public float q() {
        return this.j;
    }

    public boolean r() {
        return this.m <= 0.0f && this.n <= 0.0f;
    }

    public boolean s() {
        return t() && u();
    }

    public boolean t() {
        float f2 = this.i;
        float f3 = this.g;
        return f2 <= f3 && f3 <= 1.0f;
    }

    public boolean u() {
        float f2 = this.j;
        float f3 = this.e;
        return f2 <= f3 && f3 <= 1.0f;
    }

    public float v() {
        return this.d - this.f1278b.bottom;
    }

    public float w() {
        return this.f1278b.left;
    }

    public float x() {
        return this.c - this.f1278b.right;
    }

    public float y() {
        return this.f1278b.top;
    }

    public void a(float f2, float f3, float f4, float f5, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f1277a);
        matrix.postScale(f2, f3, f4, f5);
    }

    public boolean c() {
        return this.i > this.g;
    }

    public boolean d() {
        return this.j > this.e;
    }

    public boolean e(float f2) {
        return b(f2) && c(f2);
    }

    public boolean f(float f2) {
        return d(f2) && a(f2);
    }

    public void g(float f2) {
        this.m = i.a(f2);
    }

    public void h(float f2) {
        this.n = i.a(f2);
    }

    public void i(float f2) {
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.h = f2;
        a(this.f1277a, this.f1278b);
    }

    public void j(float f2) {
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.f = f2;
        a(this.f1277a, this.f1278b);
    }

    public void k(float f2) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        this.g = f2;
        a(this.f1277a, this.f1278b);
    }

    public void l(float f2) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        this.e = f2;
        a(this.f1277a, this.f1278b);
    }

    public void a(float[] fArr, View view) {
        Matrix matrix = this.p;
        matrix.reset();
        matrix.set(this.f1277a);
        matrix.postTranslate(-(fArr[0] - w()), -(fArr[1] - y()));
        a(matrix, view, true);
    }

    public boolean b(float f2) {
        return this.f1278b.left <= f2 + 1.0f;
    }

    public boolean b() {
        return this.j < this.f;
    }

    public Matrix a(Matrix matrix, View view, boolean z) {
        this.f1277a.set(matrix);
        a(this.f1277a, this.f1278b);
        if (z) {
            view.invalidate();
        }
        matrix.set(this.f1277a);
        return matrix;
    }

    public void a(Matrix matrix, RectF rectF) {
        float f2;
        matrix.getValues(this.q);
        float[] fArr = this.q;
        float f3 = fArr[2];
        float f4 = fArr[0];
        float f5 = fArr[5];
        float f6 = fArr[4];
        this.i = Math.min(Math.max(this.g, f4), this.h);
        this.j = Math.min(Math.max(this.e, f6), this.f);
        float f7 = 0.0f;
        if (rectF != null) {
            f7 = rectF.width();
            f2 = rectF.height();
        } else {
            f2 = 0.0f;
        }
        this.k = Math.min(Math.max(f3, ((-f7) * (this.i - 1.0f)) - this.m), this.m);
        this.l = Math.max(Math.min(f5, (f2 * (this.j - 1.0f)) + this.n), -this.n);
        float[] fArr2 = this.q;
        fArr2[2] = this.k;
        fArr2[0] = this.i;
        fArr2[5] = this.l;
        fArr2[4] = this.j;
        matrix.setValues(fArr2);
    }

    public boolean a(float f2, float f3) {
        return e(f2) && f(f3);
    }

    public boolean a(float f2) {
        return this.f1278b.bottom >= ((float) ((int) (f2 * 100.0f))) / 100.0f;
    }

    public boolean a() {
        return this.i < this.h;
    }
}
