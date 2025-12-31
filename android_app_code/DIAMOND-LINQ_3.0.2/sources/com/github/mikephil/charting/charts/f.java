package com.github.mikephil.charting.charts;

import android.graphics.RectF;
import android.util.Log;
import b.b.a.a.c.i;
import b.b.a.a.c.j;
import b.b.a.a.f.c;
import b.b.a.a.f.d;
import b.b.a.a.i.e;
import b.b.a.a.i.n;
import b.b.a.a.i.p;
import b.b.a.a.j.b;
import b.b.a.a.j.g;
import b.b.a.a.j.h;

public class f extends a {
    private RectF va;

    /* access modifiers changed from: protected */
    public void C() {
        g gVar = this.fa;
        j jVar = this.ba;
        float f = jVar.G;
        float f2 = jVar.H;
        i iVar = this.i;
        gVar.a(f, f2, iVar.H, iVar.G);
        g gVar2 = this.ea;
        j jVar2 = this.aa;
        float f3 = jVar2.G;
        float f4 = jVar2.H;
        i iVar2 = this.i;
        gVar2.a(f3, f4, iVar2.H, iVar2.G);
    }

    /* access modifiers changed from: protected */
    public float[] a(c cVar) {
        return new float[]{cVar.d(), cVar.c()};
    }

    public void d() {
        a(this.va);
        RectF rectF = this.va;
        float f = rectF.left + 0.0f;
        float f2 = rectF.top + 0.0f;
        float f3 = rectF.right + 0.0f;
        float f4 = rectF.bottom + 0.0f;
        if (this.aa.K()) {
            f2 += this.aa.a(this.ca.a());
        }
        if (this.ba.K()) {
            f4 += this.ba.a(this.da.a());
        }
        i iVar = this.i;
        float f5 = (float) iVar.K;
        if (iVar.f()) {
            if (this.i.z() == i.a.BOTTOM) {
                f += f5;
            } else {
                if (this.i.z() != i.a.TOP) {
                    if (this.i.z() == i.a.BOTH_SIDED) {
                        f += f5;
                    }
                }
                f3 += f5;
            }
        }
        float extraTopOffset = f2 + getExtraTopOffset();
        float extraRightOffset = f3 + getExtraRightOffset();
        float extraBottomOffset = f4 + getExtraBottomOffset();
        float extraLeftOffset = f + getExtraLeftOffset();
        float a2 = b.b.a.a.j.i.a(this.U);
        this.t.a(Math.max(a2, extraLeftOffset), Math.max(a2, extraTopOffset), Math.max(a2, extraRightOffset), Math.max(a2, extraBottomOffset));
        if (this.f1429a) {
            Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb = new StringBuilder();
            sb.append("Content: ");
            sb.append(this.t.n().toString());
            Log.i("MPAndroidChart", sb.toString());
        }
        B();
        C();
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.t = new b();
        super.g();
        this.ea = new h(this.t);
        this.fa = new h(this.t);
        this.r = new e(this, this.u, this.t);
        setHighlighter(new d(this));
        this.ca = new p(this.t, this.aa, this.ea);
        this.da = new p(this.t, this.ba, this.fa);
        this.ga = new n(this.t, this.i, this.ea, this);
    }

    public float getHighestVisibleX() {
        a(j.a.LEFT).a(this.t.g(), this.t.i(), this.pa);
        return (float) Math.min((double) this.i.F, this.pa.e);
    }

    public float getLowestVisibleX() {
        a(j.a.LEFT).a(this.t.g(), this.t.e(), this.oa);
        return (float) Math.max((double) this.i.G, this.oa.e);
    }

    public void setVisibleXRangeMaximum(float f) {
        this.t.l(this.i.H / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.t.j(this.i.H / f);
    }

    public c a(float f, float f2) {
        if (this.f1430b != null) {
            return getHighlighter().a(f2, f);
        }
        if (!this.f1429a) {
            return null;
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }
}
