package b.b.a.a.i;

import b.b.a.a.d.h;
import b.b.a.a.d.j;
import b.b.a.a.g.a.b;
import b.b.a.a.g.b.d;

public abstract class c extends d {
    protected a g = new a();

    protected class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1259a;

        /* renamed from: b  reason: collision with root package name */
        public int f1260b;
        public int c;

        protected a() {
        }

        public void a(b bVar, b.b.a.a.g.b.b bVar2) {
            int i;
            float max = Math.max(0.0f, Math.min(1.0f, c.this.f1261b.a()));
            float lowestVisibleX = bVar.getLowestVisibleX();
            float highestVisibleX = bVar.getHighestVisibleX();
            j a2 = bVar2.a(lowestVisibleX, Float.NaN, h.a.DOWN);
            j a3 = bVar2.a(highestVisibleX, Float.NaN, h.a.UP);
            int i2 = 0;
            if (a2 == null) {
                i = 0;
            } else {
                i = bVar2.a(a2);
            }
            this.f1259a = i;
            if (a3 != null) {
                i2 = bVar2.a(a3);
            }
            this.f1260b = i2;
            this.c = (int) (((float) (this.f1260b - this.f1259a)) * max);
        }
    }

    public c(b.b.a.a.a.a aVar, b.b.a.a.j.j jVar) {
        super(aVar, jVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(j jVar, b.b.a.a.g.b.b bVar) {
        if (jVar == null) {
            return false;
        }
        float a2 = (float) bVar.a(jVar);
        if (jVar == null || a2 >= ((float) bVar.r()) * this.f1261b.a()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean b(d dVar) {
        return dVar.isVisible() && (dVar.p() || dVar.d());
    }
}
