package a.e.b.a;

import a.e.b.i;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private q f80a = new q(this);

    /* renamed from: b  reason: collision with root package name */
    final h f81b;
    final c c;
    f d;
    public int e = 0;
    int f = -1;
    private b g = b.NONE;
    private a h = a.RELAXED;
    private int i = 0;
    i j;

    public enum a {
        RELAXED,
        STRICT
    }

    public enum b {
        NONE,
        STRONG,
        WEAK
    }

    public enum c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public f(h hVar, c cVar) {
        this.f81b = hVar;
        this.c = cVar;
    }

    public void a(a.e.b.c cVar) {
        i iVar = this.j;
        if (iVar == null) {
            this.j = new i(i.a.UNRESTRICTED, (String) null);
        } else {
            iVar.b();
        }
    }

    public int b() {
        f fVar;
        if (this.f81b.s() == 8) {
            return 0;
        }
        if (this.f <= -1 || (fVar = this.d) == null || fVar.f81b.s() != 8) {
            return this.e;
        }
        return this.f;
    }

    public h c() {
        return this.f81b;
    }

    public q d() {
        return this.f80a;
    }

    public i e() {
        return this.j;
    }

    public b f() {
        return this.g;
    }

    public f g() {
        return this.d;
    }

    public c h() {
        return this.c;
    }

    public boolean i() {
        return this.d != null;
    }

    public void j() {
        this.d = null;
        this.e = 0;
        this.f = -1;
        this.g = b.STRONG;
        this.i = 0;
        this.h = a.RELAXED;
        this.f80a.d();
    }

    public String toString() {
        return this.f81b.g() + ":" + this.c.toString();
    }

    public int a() {
        return this.i;
    }

    public boolean a(f fVar, int i2, b bVar, int i3) {
        return a(fVar, i2, -1, bVar, i3, false);
    }

    public boolean a(f fVar, int i2, int i3, b bVar, int i4, boolean z) {
        if (fVar == null) {
            this.d = null;
            this.e = 0;
            this.f = -1;
            this.g = b.NONE;
            this.i = 2;
            return true;
        } else if (!z && !a(fVar)) {
            return false;
        } else {
            this.d = fVar;
            if (i2 > 0) {
                this.e = i2;
            } else {
                this.e = 0;
            }
            this.f = i3;
            this.g = bVar;
            this.i = i4;
            return true;
        }
    }

    public boolean a(f fVar) {
        if (fVar == null) {
            return false;
        }
        c h2 = fVar.h();
        c cVar = this.c;
        if (h2 != cVar) {
            switch (e.f79a[cVar.ordinal()]) {
                case 1:
                    if (h2 == c.BASELINE || h2 == c.CENTER_X || h2 == c.CENTER_Y) {
                        return false;
                    }
                    return true;
                case 2:
                case 3:
                    boolean z = h2 == c.LEFT || h2 == c.RIGHT;
                    if (fVar.c() instanceof l) {
                        return z || h2 == c.CENTER_X;
                    }
                    return z;
                case 4:
                case 5:
                    boolean z2 = h2 == c.TOP || h2 == c.BOTTOM;
                    if (fVar.c() instanceof l) {
                        return z2 || h2 == c.CENTER_Y;
                    }
                    return z2;
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    throw new AssertionError(this.c.name());
            }
        } else if (cVar != c.BASELINE || (fVar.c().y() && c().y())) {
            return true;
        } else {
            return false;
        }
    }
}
