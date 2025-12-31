package a.e.b.a;

import a.e.b.a.f;
import a.e.b.a.h;
import a.e.b.e;
import a.e.b.i;
import java.util.ArrayList;

public class l extends h {
    private int Aa;
    private p Ba;
    private int Ca;
    protected float ua = -1.0f;
    protected int va = -1;
    protected int wa = -1;
    private f xa = this.w;
    private int ya;
    private boolean za;

    public l() {
        this.ya = 0;
        this.za = false;
        this.Aa = 0;
        this.Ba = new p();
        this.Ca = 8;
        this.E.clear();
        this.E.add(this.xa);
        int length = this.D.length;
        for (int i = 0; i < length; i++) {
            this.D[i] = this.xa;
        }
    }

    public int L() {
        return this.ya;
    }

    public f a(f.c cVar) {
        switch (k.f96a[cVar.ordinal()]) {
            case 1:
            case 2:
                if (this.ya == 1) {
                    return this.xa;
                }
                break;
            case 3:
            case 4:
                if (this.ya == 0) {
                    return this.xa;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(cVar.name());
    }

    public boolean b() {
        return true;
    }

    public ArrayList<f> c() {
        return this.E;
    }

    public void e(float f) {
        if (f > -1.0f) {
            this.ua = f;
            this.va = -1;
            this.wa = -1;
        }
    }

    public void v(int i) {
        if (i > -1) {
            this.ua = -1.0f;
            this.va = i;
            this.wa = -1;
        }
    }

    public void w(int i) {
        if (i > -1) {
            this.ua = -1.0f;
            this.va = -1;
            this.wa = i;
        }
    }

    public void x(int i) {
        if (this.ya != i) {
            this.ya = i;
            this.E.clear();
            if (this.ya == 1) {
                this.xa = this.v;
            } else {
                this.xa = this.w;
            }
            this.E.add(this.xa);
            int length = this.D.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.D[i2] = this.xa;
            }
        }
    }

    public void c(e eVar) {
        if (l() != null) {
            int b2 = eVar.b((Object) this.xa);
            if (this.ya == 1) {
                t(b2);
                u(0);
                i(l().j());
                q(0);
                return;
            }
            t(0);
            u(b2);
            q(l().t());
            i(0);
        }
    }

    public void a(int i) {
        h l = l();
        if (l != null) {
            if (L() == 1) {
                this.w.d().a(1, l.w.d(), 0);
                this.y.d().a(1, l.w.d(), 0);
                if (this.va != -1) {
                    this.v.d().a(1, l.v.d(), this.va);
                    this.x.d().a(1, l.v.d(), this.va);
                } else if (this.wa != -1) {
                    this.v.d().a(1, l.x.d(), -this.wa);
                    this.x.d().a(1, l.x.d(), -this.wa);
                } else if (this.ua != -1.0f && l.k() == h.a.FIXED) {
                    int i2 = (int) (((float) l.H) * this.ua);
                    this.v.d().a(1, l.v.d(), i2);
                    this.x.d().a(1, l.v.d(), i2);
                }
            } else {
                this.v.d().a(1, l.v.d(), 0);
                this.x.d().a(1, l.v.d(), 0);
                if (this.va != -1) {
                    this.w.d().a(1, l.w.d(), this.va);
                    this.y.d().a(1, l.w.d(), this.va);
                } else if (this.wa != -1) {
                    this.w.d().a(1, l.y.d(), -this.wa);
                    this.y.d().a(1, l.y.d(), -this.wa);
                } else if (this.ua != -1.0f && l.r() == h.a.FIXED) {
                    int i3 = (int) (((float) l.I) * this.ua);
                    this.w.d().a(1, l.w.d(), i3);
                    this.y.d().a(1, l.w.d(), i3);
                }
            }
        }
    }

    public void a(e eVar) {
        i iVar = (i) l();
        if (iVar != null) {
            f a2 = iVar.a(f.c.LEFT);
            f a3 = iVar.a(f.c.RIGHT);
            h hVar = this.G;
            boolean z = hVar != null && hVar.F[0] == h.a.WRAP_CONTENT;
            if (this.ya == 0) {
                a2 = iVar.a(f.c.TOP);
                a3 = iVar.a(f.c.BOTTOM);
                h hVar2 = this.G;
                z = hVar2 != null && hVar2.F[1] == h.a.WRAP_CONTENT;
            }
            if (this.va != -1) {
                i a4 = eVar.a((Object) this.xa);
                eVar.a(a4, eVar.a((Object) a2), this.va, 6);
                if (z) {
                    eVar.b(eVar.a((Object) a3), a4, 0, 5);
                }
            } else if (this.wa != -1) {
                i a5 = eVar.a((Object) this.xa);
                i a6 = eVar.a((Object) a3);
                eVar.a(a5, a6, -this.wa, 6);
                if (z) {
                    eVar.b(a5, eVar.a((Object) a2), 0, 5);
                    eVar.b(a6, a5, 0, 5);
                }
            } else if (this.ua != -1.0f) {
                eVar.a(e.a(eVar, eVar.a((Object) this.xa), eVar.a((Object) a2), eVar.a((Object) a3), this.ua, this.za));
            }
        }
    }
}
