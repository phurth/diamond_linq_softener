package a.e.b.a;

import a.e.b.a.f;
import a.e.b.e;
import a.e.b.i;

public class q extends s {
    f c;
    float d;
    q e;
    float f;
    q g;
    float h;
    int i = 0;
    private q j;
    private float k;
    private r l = null;
    private int m = 1;
    private r n = null;
    private int o = 1;

    public q(f fVar) {
        this.c = fVar;
    }

    /* access modifiers changed from: package-private */
    public String a(int i2) {
        return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void a(q qVar, float f2) {
        if (this.f99b == 0 || !(this.g == qVar || this.h == f2)) {
            this.g = qVar;
            this.h = f2;
            if (this.f99b == 1) {
                b();
            }
            a();
        }
    }

    public void b(int i2) {
        this.i = i2;
    }

    public void d() {
        super.d();
        this.e = null;
        this.f = 0.0f;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.g = null;
        this.h = 0.0f;
        this.d = 0.0f;
        this.j = null;
        this.k = 0.0f;
        this.i = 0;
    }

    public void e() {
        q qVar;
        q qVar2;
        q qVar3;
        q qVar4;
        q qVar5;
        q qVar6;
        float f2;
        float f3;
        float f4;
        float f5;
        q qVar7;
        boolean z = true;
        if (this.f99b != 1 && this.i != 4) {
            r rVar = this.l;
            if (rVar != null) {
                if (rVar.f99b == 1) {
                    this.f = ((float) this.m) * rVar.c;
                } else {
                    return;
                }
            }
            r rVar2 = this.n;
            if (rVar2 != null) {
                if (rVar2.f99b == 1) {
                    this.k = ((float) this.o) * rVar2.c;
                } else {
                    return;
                }
            }
            if (this.i == 1 && ((qVar7 = this.e) == null || qVar7.f99b == 1)) {
                q qVar8 = this.e;
                if (qVar8 == null) {
                    this.g = this;
                    this.h = this.f;
                } else {
                    this.g = qVar8.g;
                    this.h = qVar8.h + this.f;
                }
                a();
            } else if (this.i == 2 && (qVar4 = this.e) != null && qVar4.f99b == 1 && (qVar5 = this.j) != null && (qVar6 = qVar5.e) != null && qVar6.f99b == 1) {
                if (e.e() != null) {
                    e.e().v++;
                }
                this.g = this.e.g;
                q qVar9 = this.j;
                qVar9.g = qVar9.e.g;
                f.c cVar = this.c.c;
                int i2 = 0;
                if (!(cVar == f.c.RIGHT || cVar == f.c.BOTTOM)) {
                    z = false;
                }
                if (z) {
                    f3 = this.e.h;
                    f2 = this.j.e.h;
                } else {
                    f3 = this.j.e.h;
                    f2 = this.e.h;
                }
                float f6 = f3 - f2;
                f fVar = this.c;
                f.c cVar2 = fVar.c;
                if (cVar2 == f.c.LEFT || cVar2 == f.c.RIGHT) {
                    f5 = f6 - ((float) this.c.f81b.t());
                    f4 = this.c.f81b.aa;
                } else {
                    f5 = f6 - ((float) fVar.f81b.j());
                    f4 = this.c.f81b.ba;
                }
                int b2 = this.c.b();
                int b3 = this.j.c.b();
                if (this.c.g() == this.j.c.g()) {
                    f4 = 0.5f;
                    b3 = 0;
                } else {
                    i2 = b2;
                }
                float f7 = (float) i2;
                float f8 = (float) b3;
                float f9 = (f5 - f7) - f8;
                if (z) {
                    q qVar10 = this.j;
                    qVar10.h = qVar10.e.h + f8 + (f9 * f4);
                    this.h = (this.e.h - f7) - (f9 * (1.0f - f4));
                } else {
                    this.h = this.e.h + f7 + (f9 * f4);
                    q qVar11 = this.j;
                    qVar11.h = (qVar11.e.h - f8) - (f9 * (1.0f - f4));
                }
                a();
                this.j.a();
            } else if (this.i == 3 && (qVar = this.e) != null && qVar.f99b == 1 && (qVar2 = this.j) != null && (qVar3 = qVar2.e) != null && qVar3.f99b == 1) {
                if (e.e() != null) {
                    e.e().w++;
                }
                q qVar12 = this.e;
                this.g = qVar12.g;
                q qVar13 = this.j;
                q qVar14 = qVar13.e;
                qVar13.g = qVar14.g;
                this.h = qVar12.h + this.f;
                qVar13.h = qVar14.h + qVar13.f;
                a();
                this.j.a();
            } else if (this.i == 5) {
                this.c.f81b.H();
            }
        }
    }

    public float f() {
        return this.h;
    }

    public void g() {
        f g2 = this.c.g();
        if (g2 != null) {
            if (g2.g() == this.c) {
                this.i = 4;
                g2.d().i = 4;
            }
            int b2 = this.c.b();
            f.c cVar = this.c.c;
            if (cVar == f.c.RIGHT || cVar == f.c.BOTTOM) {
                b2 = -b2;
            }
            a(g2.d(), b2);
        }
    }

    public String toString() {
        if (this.f99b != 1) {
            return "{ " + this.c + " UNRESOLVED} type: " + a(this.i);
        } else if (this.g == this) {
            return "[" + this.c + ", RESOLVED: " + this.h + "]  type: " + a(this.i);
        } else {
            return "[" + this.c + ", RESOLVED: " + this.g + ":" + this.h + "] type: " + a(this.i);
        }
    }

    public void b(q qVar, float f2) {
        this.j = qVar;
        this.k = f2;
    }

    public void b(q qVar, int i2, r rVar) {
        this.j = qVar;
        this.n = rVar;
        this.o = i2;
    }

    public void a(int i2, q qVar, int i3) {
        this.i = i2;
        this.e = qVar;
        this.f = (float) i3;
        this.e.a(this);
    }

    public void a(q qVar, int i2) {
        this.e = qVar;
        this.f = (float) i2;
        this.e.a(this);
    }

    public void a(q qVar, int i2, r rVar) {
        this.e = qVar;
        this.e.a(this);
        this.l = rVar;
        this.m = i2;
        this.l.a(this);
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        i e2 = this.c.e();
        q qVar = this.g;
        if (qVar == null) {
            eVar.a(e2, (int) (this.h + 0.5f));
        } else {
            eVar.a(e2, eVar.a((Object) qVar.c), (int) (this.h + 0.5f), 6);
        }
    }
}
