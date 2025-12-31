package com.github.mikephil.charting.charts;

import android.util.Log;
import b.b.a.a.c.j;
import b.b.a.a.f.c;
import b.b.a.a.i.b;

public class a extends c<b.b.a.a.d.a> implements b.b.a.a.g.a.a {
    protected boolean ra;
    private boolean sa;
    private boolean ta;
    private boolean ua;

    public c a(float f, float f2) {
        if (this.f1430b == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        c a2 = getHighlighter().a(f, f2);
        return (a2 == null || !c()) ? a2 : new c(a2.f(), a2.h(), a2.g(), a2.i(), a2.b(), -1, a2.a());
    }

    public boolean b() {
        return this.sa;
    }

    public boolean c() {
        return this.ra;
    }

    /* access modifiers changed from: protected */
    public void g() {
        super.g();
        this.r = new b(this, this.u, this.t);
        setHighlighter(new b.b.a.a.f.a(this));
        getXAxis().d(0.5f);
        getXAxis().c(0.5f);
    }

    public b.b.a.a.d.a getBarData() {
        return (b.b.a.a.d.a) this.f1430b;
    }

    /* access modifiers changed from: protected */
    public void o() {
        if (this.ua) {
            this.i.a(((b.b.a.a.d.a) this.f1430b).f() - (((b.b.a.a.d.a) this.f1430b).j() / 2.0f), ((b.b.a.a.d.a) this.f1430b).e() + (((b.b.a.a.d.a) this.f1430b).j() / 2.0f));
        } else {
            this.i.a(((b.b.a.a.d.a) this.f1430b).f(), ((b.b.a.a.d.a) this.f1430b).e());
        }
        this.aa.a(((b.b.a.a.d.a) this.f1430b).b(j.a.LEFT), ((b.b.a.a.d.a) this.f1430b).a(j.a.LEFT));
        this.ba.a(((b.b.a.a.d.a) this.f1430b).b(j.a.RIGHT), ((b.b.a.a.d.a) this.f1430b).a(j.a.RIGHT));
    }

    public void setDrawBarShadow(boolean z) {
        this.ta = z;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.sa = z;
    }

    public void setFitBars(boolean z) {
        this.ua = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.ra = z;
    }

    public boolean a() {
        return this.ta;
    }
}
