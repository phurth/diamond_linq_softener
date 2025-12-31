package b.b.a.a.c;

import android.graphics.DashPathEffect;
import b.b.a.a.e.d;
import b.b.a.a.j.i;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public abstract class a extends b {
    protected boolean A = false;
    protected float B = 0.0f;
    protected float C = 0.0f;
    protected boolean D = false;
    protected boolean E = false;
    public float F = 0.0f;
    public float G = 0.0f;
    public float H = 0.0f;
    protected d g;
    private int h = -7829368;
    private float i = 1.0f;
    private int j = -7829368;
    private float k = 1.0f;
    public float[] l = new float[0];
    public float[] m = new float[0];
    public int n;
    public int o;
    private int p = 6;
    protected float q = 1.0f;
    protected boolean r = false;
    protected boolean s = false;
    protected boolean t = true;
    protected boolean u = true;
    protected boolean v = true;
    protected boolean w = false;
    private DashPathEffect x = null;
    private DashPathEffect y = null;
    protected List<h> z;

    public a() {
        this.e = i.a(10.0f);
        this.f1206b = i.a(5.0f);
        this.c = i.a(5.0f);
        this.z = new ArrayList();
    }

    public void a(d dVar) {
        if (dVar == null) {
            this.g = new b.b.a.a.e.a(this.o);
        } else {
            this.g = dVar;
        }
    }

    public void b(boolean z2) {
        this.u = z2;
    }

    public void c(boolean z2) {
        this.t = z2;
    }

    public void d(boolean z2) {
        this.v = z2;
    }

    public int g() {
        return this.j;
    }

    public DashPathEffect h() {
        return this.x;
    }

    public float i() {
        return this.k;
    }

    public float j() {
        return this.q;
    }

    public int k() {
        return this.h;
    }

    public DashPathEffect l() {
        return this.y;
    }

    public float m() {
        return this.i;
    }

    public int n() {
        return this.p;
    }

    public List<h> o() {
        return this.z;
    }

    public String p() {
        String str = BuildConfig.FLAVOR;
        for (int i2 = 0; i2 < this.l.length; i2++) {
            String b2 = b(i2);
            if (b2 != null && str.length() < b2.length()) {
                str = b2;
            }
        }
        return str;
    }

    public d q() {
        d dVar = this.g;
        if (dVar == null || ((dVar instanceof b.b.a.a.e.a) && ((b.b.a.a.e.a) dVar).a() != this.o)) {
            this.g = new b.b.a.a.e.a(this.o);
        }
        return this.g;
    }

    public boolean r() {
        return this.w && this.n > 0;
    }

    public boolean s() {
        return this.u;
    }

    public boolean t() {
        return this.t;
    }

    public boolean u() {
        return this.v;
    }

    public boolean v() {
        return this.A;
    }

    public boolean w() {
        return this.s;
    }

    public boolean x() {
        return this.r;
    }

    public void b(float f) {
        this.q = f;
        this.r = true;
    }

    public void c(float f) {
        this.C = f;
    }

    public void d(float f) {
        this.B = f;
    }

    public void a(float f) {
        this.D = true;
        this.G = f;
        this.H = Math.abs(this.F - f);
    }

    public String b(int i2) {
        return (i2 < 0 || i2 >= this.l.length) ? BuildConfig.FLAVOR : q().a(this.l[i2], this);
    }

    public void a(float f, float f2) {
        float f3 = this.D ? this.G : f - this.B;
        float f4 = this.E ? this.F : f2 + this.C;
        if (Math.abs(f4 - f3) == 0.0f) {
            f4 += 1.0f;
            f3 -= 1.0f;
        }
        this.G = f3;
        this.F = f4;
        this.H = Math.abs(f4 - f3);
    }
}
