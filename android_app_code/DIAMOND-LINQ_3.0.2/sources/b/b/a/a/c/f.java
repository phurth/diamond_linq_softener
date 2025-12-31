package b.b.a.a.c;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import b.b.a.a.j.i;
import b.b.a.a.j.j;
import java.util.ArrayList;
import java.util.List;

public class f extends b {
    public float A = 0.0f;
    private boolean B = false;
    private List<b.b.a.a.j.a> C = new ArrayList(16);
    private List<Boolean> D = new ArrayList(16);
    private List<b.b.a.a.j.a> E = new ArrayList(16);
    private g[] g = new g[0];
    private g[] h;
    private boolean i = false;
    private c j = c.LEFT;
    private C0031f k = C0031f.BOTTOM;
    private d l = d.HORIZONTAL;
    private boolean m = false;
    private a n = a.LEFT_TO_RIGHT;
    private b o = b.SQUARE;
    private float p = 8.0f;
    private float q = 3.0f;
    private DashPathEffect r = null;
    private float s = 6.0f;
    private float t = 0.0f;
    private float u = 5.0f;
    private float v = 3.0f;
    private float w = 0.95f;
    public float x = 0.0f;
    public float y = 0.0f;
    public float z = 0.0f;

    public enum a {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum b {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum c {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum d {
        HORIZONTAL,
        VERTICAL
    }

    @Deprecated
    public enum e {
        RIGHT_OF_CHART,
        RIGHT_OF_CHART_CENTER,
        RIGHT_OF_CHART_INSIDE,
        LEFT_OF_CHART,
        LEFT_OF_CHART_CENTER,
        LEFT_OF_CHART_INSIDE,
        BELOW_CHART_LEFT,
        BELOW_CHART_RIGHT,
        BELOW_CHART_CENTER,
        ABOVE_CHART_LEFT,
        ABOVE_CHART_RIGHT,
        ABOVE_CHART_CENTER,
        PIECHART_CENTER
    }

    /* renamed from: b.b.a.a.c.f$f  reason: collision with other inner class name */
    public enum C0031f {
        TOP,
        CENTER,
        BOTTOM
    }

    public f() {
        this.e = i.a(10.0f);
        this.f1206b = i.a(5.0f);
        this.c = i.a(3.0f);
    }

    public void a(List<g> list) {
        this.g = (g[]) list.toArray(new g[list.size()]);
    }

    public float b(Paint paint) {
        float a2 = i.a(this.u);
        float f = 0.0f;
        float f2 = 0.0f;
        for (g gVar : this.g) {
            float a3 = i.a(Float.isNaN(gVar.c) ? this.p : gVar.c);
            if (a3 > f2) {
                f2 = a3;
            }
            String str = gVar.f1221a;
            if (str != null) {
                float c2 = (float) i.c(paint, str);
                if (c2 > f) {
                    f = c2;
                }
            }
        }
        return f + f2 + a2;
    }

    public List<Boolean> g() {
        return this.D;
    }

    public List<b.b.a.a.j.a> h() {
        return this.C;
    }

    public List<b.b.a.a.j.a> i() {
        return this.E;
    }

    public a j() {
        return this.n;
    }

    public g[] k() {
        return this.g;
    }

    public g[] l() {
        return this.h;
    }

    public b m() {
        return this.o;
    }

    public DashPathEffect n() {
        return this.r;
    }

    public float o() {
        return this.q;
    }

    public float p() {
        return this.p;
    }

    public float q() {
        return this.u;
    }

    public c r() {
        return this.j;
    }

    public float s() {
        return this.w;
    }

    public d t() {
        return this.l;
    }

    public float u() {
        return this.v;
    }

    public C0031f v() {
        return this.k;
    }

    public float w() {
        return this.s;
    }

    public float x() {
        return this.t;
    }

    public boolean y() {
        return this.m;
    }

    public boolean z() {
        return this.i;
    }

    public float a(Paint paint) {
        float f = 0.0f;
        for (g gVar : this.g) {
            String str = gVar.f1221a;
            if (str != null) {
                float a2 = (float) i.a(paint, str);
                if (a2 > f) {
                    f = a2;
                }
            }
        }
        return f;
    }

    public void a(Paint paint, j jVar) {
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        Paint paint2 = paint;
        float a2 = i.a(this.p);
        float a3 = i.a(this.v);
        float a4 = i.a(this.u);
        float a5 = i.a(this.s);
        float a6 = i.a(this.t);
        boolean z2 = this.B;
        g[] gVarArr = this.g;
        int length = gVarArr.length;
        this.A = b(paint);
        this.z = a(paint);
        int i3 = e.f1208b[this.l.ordinal()];
        if (i3 == 1) {
            float f7 = a2;
            float f8 = a3;
            g[] gVarArr2 = gVarArr;
            float a7 = i.a(paint);
            float f9 = 0.0f;
            float f10 = 0.0f;
            boolean z3 = false;
            float f11 = 0.0f;
            for (int i4 = 0; i4 < length; i4++) {
                g gVar = gVarArr2[i4];
                boolean z4 = gVar.f1222b != b.NONE;
                if (Float.isNaN(gVar.c)) {
                    f = f7;
                } else {
                    f = i.a(gVar.c);
                }
                String str = gVar.f1221a;
                if (!z3) {
                    f11 = 0.0f;
                }
                if (z4) {
                    if (z3) {
                        f11 += f8;
                    }
                    f11 += f;
                }
                if (str != null) {
                    if (z4 && !z3) {
                        f11 += a4;
                    } else if (z3) {
                        f9 = Math.max(f9, f11);
                        f10 += a7 + a6;
                        z3 = false;
                        f11 = 0.0f;
                    }
                    f11 += (float) i.c(paint2, str);
                    if (i4 < length - 1) {
                        f10 += a7 + a6;
                    }
                } else {
                    f11 += f;
                    if (i4 < length - 1) {
                        f11 += f8;
                    }
                    z3 = true;
                }
                f9 = Math.max(f9, f11);
            }
            this.x = f9;
            this.y = f10;
        } else if (i3 == 2) {
            float a8 = i.a(paint);
            float b2 = i.b(paint) + a6;
            float j2 = jVar.j() * this.w;
            this.D.clear();
            this.C.clear();
            this.E.clear();
            int i5 = 0;
            int i6 = -1;
            float f12 = 0.0f;
            float f13 = 0.0f;
            float f14 = 0.0f;
            while (i5 < length) {
                g gVar2 = gVarArr[i5];
                float f15 = a2;
                boolean z5 = gVar2.f1222b != b.NONE;
                if (Float.isNaN(gVar2.c)) {
                    f2 = f15;
                } else {
                    f2 = i.a(gVar2.c);
                }
                String str2 = gVar2.f1221a;
                float f16 = a5;
                g[] gVarArr3 = gVarArr;
                this.D.add(false);
                float f17 = i6 == -1 ? 0.0f : f13 + a3;
                if (str2 != null) {
                    f3 = a3;
                    this.C.add(i.b(paint2, str2));
                    f4 = f17 + (z5 ? a4 + f2 : 0.0f) + this.C.get(i5).d;
                } else {
                    f3 = a3;
                    float f18 = f2;
                    this.C.add(b.b.a.a.j.a.a(0.0f, 0.0f));
                    if (!z5) {
                        f18 = 0.0f;
                    }
                    f4 = f17 + f18;
                    if (i6 == -1) {
                        i6 = i5;
                    }
                }
                if (str2 != null || i5 == length - 1) {
                    float f19 = f14;
                    float f20 = f19 == 0.0f ? 0.0f : f16;
                    if (!z2 || f19 == 0.0f || j2 - f19 >= f20 + f4) {
                        f5 = f12;
                        f6 = f19 + f20 + f4;
                    } else {
                        this.E.add(b.b.a.a.j.a.a(f19, a8));
                        float max = Math.max(f12, f19);
                        this.D.set(i6 > -1 ? i6 : i5, true);
                        f6 = f4;
                        f5 = max;
                    }
                    if (i5 == length - 1) {
                        this.E.add(b.b.a.a.j.a.a(f6, a8));
                        f14 = f6;
                        f12 = Math.max(f5, f6);
                    } else {
                        f14 = f6;
                        f12 = f5;
                    }
                }
                if (str2 != null) {
                    i6 = -1;
                }
                i5++;
                a3 = f3;
                a2 = f15;
                gVarArr = gVarArr3;
                f13 = f4;
                a5 = f16;
            }
            this.x = f12;
            float size = a8 * ((float) this.E.size());
            if (this.E.size() == 0) {
                i2 = 0;
            } else {
                i2 = this.E.size() - 1;
            }
            this.y = size + (b2 * ((float) i2));
        }
        this.y += this.c;
        this.x += this.f1206b;
    }
}
