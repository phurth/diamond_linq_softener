package a.e.b.a;

import a.e.b.a.h;
import a.e.b.e;
import a.e.b.i;
import java.util.ArrayList;

public class b extends n {
    private int wa = 0;
    private ArrayList<q> xa = new ArrayList<>(4);
    private boolean ya = true;

    public void G() {
        super.G();
        this.xa.clear();
    }

    public void H() {
        q qVar;
        float f;
        q qVar2;
        int i = this.wa;
        float f2 = Float.MAX_VALUE;
        if (i != 0) {
            if (i == 1) {
                qVar = this.x.d();
            } else if (i == 2) {
                qVar = this.w.d();
            } else if (i == 3) {
                qVar = this.y.d();
            } else {
                return;
            }
            f2 = 0.0f;
        } else {
            qVar = this.v.d();
        }
        int size = this.xa.size();
        q qVar3 = null;
        int i2 = 0;
        while (i2 < size) {
            q qVar4 = this.xa.get(i2);
            if (qVar4.f99b == 1) {
                int i3 = this.wa;
                if (i3 == 0 || i3 == 2) {
                    f = qVar4.h;
                    if (f < f2) {
                        qVar2 = qVar4.g;
                    } else {
                        i2++;
                    }
                } else {
                    f = qVar4.h;
                    if (f > f2) {
                        qVar2 = qVar4.g;
                    } else {
                        i2++;
                    }
                }
                qVar3 = qVar2;
                f2 = f;
                i2++;
            } else {
                return;
            }
        }
        if (e.e() != null) {
            e.e().y++;
        }
        qVar.g = qVar3;
        qVar.h = f2;
        qVar.a();
        int i4 = this.wa;
        if (i4 == 0) {
            this.x.d().a(qVar3, f2);
        } else if (i4 == 1) {
            this.v.d().a(qVar3, f2);
        } else if (i4 == 2) {
            this.y.d().a(qVar3, f2);
        } else if (i4 == 3) {
            this.w.d().a(qVar3, f2);
        }
    }

    public boolean L() {
        return this.ya;
    }

    public void a(int i) {
        q qVar;
        q qVar2;
        h hVar = this.G;
        if (hVar != null && ((i) hVar).v(2)) {
            int i2 = this.wa;
            if (i2 == 0) {
                qVar = this.v.d();
            } else if (i2 == 1) {
                qVar = this.x.d();
            } else if (i2 == 2) {
                qVar = this.w.d();
            } else if (i2 == 3) {
                qVar = this.y.d();
            } else {
                return;
            }
            qVar.b(5);
            int i3 = this.wa;
            if (i3 == 0 || i3 == 1) {
                this.w.d().a((q) null, 0.0f);
                this.y.d().a((q) null, 0.0f);
            } else {
                this.v.d().a((q) null, 0.0f);
                this.x.d().a((q) null, 0.0f);
            }
            this.xa.clear();
            for (int i4 = 0; i4 < this.va; i4++) {
                h hVar2 = this.ua[i4];
                if (this.ya || hVar2.b()) {
                    int i5 = this.wa;
                    if (i5 == 0) {
                        qVar2 = hVar2.v.d();
                    } else if (i5 == 1) {
                        qVar2 = hVar2.x.d();
                    } else if (i5 == 2) {
                        qVar2 = hVar2.w.d();
                    } else if (i5 != 3) {
                        qVar2 = null;
                    } else {
                        qVar2 = hVar2.y.d();
                    }
                    if (qVar2 != null) {
                        this.xa.add(qVar2);
                        qVar2.a(qVar);
                    }
                }
            }
        }
    }

    public boolean b() {
        return true;
    }

    public void c(boolean z) {
        this.ya = z;
    }

    public void v(int i) {
        this.wa = i;
    }

    public void a(e eVar) {
        f[] fVarArr;
        boolean z;
        int i;
        int i2;
        f[] fVarArr2 = this.D;
        fVarArr2[0] = this.v;
        fVarArr2[2] = this.w;
        fVarArr2[1] = this.x;
        fVarArr2[3] = this.y;
        int i3 = 0;
        while (true) {
            fVarArr = this.D;
            if (i3 >= fVarArr.length) {
                break;
            }
            fVarArr[i3].j = eVar.a((Object) fVarArr[i3]);
            i3++;
        }
        int i4 = this.wa;
        if (i4 >= 0 && i4 < 4) {
            f fVar = fVarArr[i4];
            int i5 = 0;
            while (true) {
                if (i5 >= this.va) {
                    z = false;
                    break;
                }
                h hVar = this.ua[i5];
                if ((this.ya || hVar.b()) && ((((i = this.wa) == 0 || i == 1) && hVar.k() == h.a.MATCH_CONSTRAINT) || (((i2 = this.wa) == 2 || i2 == 3) && hVar.r() == h.a.MATCH_CONSTRAINT))) {
                    z = true;
                } else {
                    i5++;
                }
            }
            int i6 = this.wa;
            if (i6 == 0 || i6 == 1 ? l().k() == h.a.WRAP_CONTENT : l().r() == h.a.WRAP_CONTENT) {
                z = false;
            }
            for (int i7 = 0; i7 < this.va; i7++) {
                h hVar2 = this.ua[i7];
                if (this.ya || hVar2.b()) {
                    i a2 = eVar.a((Object) hVar2.D[this.wa]);
                    f[] fVarArr3 = hVar2.D;
                    int i8 = this.wa;
                    fVarArr3[i8].j = a2;
                    if (i8 == 0 || i8 == 2) {
                        eVar.b(fVar.j, a2, z);
                    } else {
                        eVar.a(fVar.j, a2, z);
                    }
                }
            }
            int i9 = this.wa;
            if (i9 == 0) {
                eVar.a(this.x.j, this.v.j, 0, 6);
                if (!z) {
                    eVar.a(this.v.j, this.G.x.j, 0, 5);
                }
            } else if (i9 == 1) {
                eVar.a(this.v.j, this.x.j, 0, 6);
                if (!z) {
                    eVar.a(this.v.j, this.G.v.j, 0, 5);
                }
            } else if (i9 == 2) {
                eVar.a(this.y.j, this.w.j, 0, 6);
                if (!z) {
                    eVar.a(this.w.j, this.G.y.j, 0, 5);
                }
            } else if (i9 == 3) {
                eVar.a(this.w.j, this.y.j, 0, 6);
                if (!z) {
                    eVar.a(this.w.j, this.G.w.j, 0, 5);
                }
            }
        }
    }
}
