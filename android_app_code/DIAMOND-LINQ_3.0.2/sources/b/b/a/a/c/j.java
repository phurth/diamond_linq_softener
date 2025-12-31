package b.b.a.a.c;

import android.graphics.Paint;
import b.b.a.a.j.i;

public class j extends a {
    private boolean I = true;
    private boolean J = true;
    protected boolean K = false;
    protected boolean L = false;
    protected int M = -7829368;
    protected float N = 1.0f;
    protected float O = 10.0f;
    protected float P = 10.0f;
    private b Q = b.OUTSIDE_CHART;
    private a R;
    protected float S = 0.0f;
    protected float T = Float.POSITIVE_INFINITY;

    public enum a {
        LEFT,
        RIGHT
    }

    public enum b {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public j(a aVar) {
        this.R = aVar;
        this.c = 0.0f;
    }

    public float A() {
        return this.T;
    }

    public float B() {
        return this.S;
    }

    public float C() {
        return this.P;
    }

    public float D() {
        return this.O;
    }

    public int E() {
        return this.M;
    }

    public float F() {
        return this.N;
    }

    public boolean G() {
        return this.I;
    }

    public boolean H() {
        return this.J;
    }

    public boolean I() {
        return this.L;
    }

    public boolean J() {
        return this.K;
    }

    public boolean K() {
        return f() && u() && z() == b.OUTSIDE_CHART;
    }

    public float a(Paint paint) {
        paint.setTextSize(this.e);
        return ((float) i.a(paint, p())) + (e() * 2.0f);
    }

    public float b(Paint paint) {
        paint.setTextSize(this.e);
        float c = ((float) i.c(paint, p())) + (d() * 2.0f);
        float B = B();
        float A = A();
        if (B > 0.0f) {
            B = i.a(B);
        }
        if (A > 0.0f && A != Float.POSITIVE_INFINITY) {
            A = i.a(A);
        }
        if (((double) A) <= 0.0d) {
            A = c;
        }
        return Math.max(B, Math.min(c, A));
    }

    public a y() {
        return this.R;
    }

    public b z() {
        return this.Q;
    }

    public void a(float f, float f2) {
        if (this.D) {
            f = this.G;
        }
        if (this.E) {
            f2 = this.F;
        }
        float abs = Math.abs(f2 - f);
        if (abs == 0.0f) {
            f2 += 1.0f;
            f -= 1.0f;
        }
        if (!this.D) {
            this.G = f - ((abs / 100.0f) * C());
        }
        if (!this.E) {
            this.F = f2 + ((abs / 100.0f) * D());
        }
        this.H = Math.abs(this.F - this.G);
    }
}
