package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import b.b.a.a.d.k;
import b.b.a.a.g.a.d;
import b.b.a.a.i.i;

public class LineChart extends c<k> implements d {
    public LineChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void g() {
        super.g();
        this.r = new i(this, this.u, this.t);
    }

    public k getLineData() {
        return (k) this.f1430b;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        b.b.a.a.i.d dVar = this.r;
        if (dVar != null && (dVar instanceof i)) {
            ((i) dVar).b();
        }
        super.onDetachedFromWindow();
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
