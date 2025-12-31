package com.chandlersystemsinc.signatureappcore.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.C0139o;
import b.a.a.Aa;
import b.a.a.Ba;
import b.a.a.Da;
import b.a.a.Fa;
import b.a.a.ia;
import b.a.a.za;
import b.b.a.a.c.i;
import b.b.a.a.d.j;
import b.b.a.a.d.k;
import b.b.a.a.d.l;
import b.b.a.a.e.d;
import b.b.a.a.e.f;
import com.github.mikephil.charting.charts.LineChart;
import java.util.ArrayList;
import java.util.Calendar;
import no.nordicsemi.android.log.BuildConfig;

public final class CsGridGraphView extends b {
    private LineChart d;
    private TextView e;
    private C0139o f;
    /* access modifiers changed from: private */
    public a g;
    private boolean h;
    /* access modifiers changed from: private */
    public long i;
    private float[] j;
    private float[] k;
    private String l;
    private String m;
    private boolean n = true;

    public enum a {
        Daily,
        Gallons
    }

    class b implements f {
        b() {
        }

        public String a(float f, j jVar, int i, b.b.a.a.j.j jVar2) {
            return String.valueOf((int) f);
        }
    }

    class c implements d {
        c() {
        }

        public String a(float f, b.b.a.a.c.a aVar) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(CsGridGraphView.this.i);
            if (CsGridGraphView.this.g != a.Daily) {
                return CsGridGraphView.this.g == a.Gallons ? String.valueOf(Integer.valueOf(42 - ((int) f))) : BuildConfig.FLAVOR;
            }
            instance.set(5, (instance.get(5) - 1) - 61);
            instance.add(5, (int) f);
            instance.getTime();
            return String.valueOf(instance.get(2) + 1).concat("/").concat(ia.b(instance.get(5)));
        }
    }

    public CsGridGraphView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void c() {
        View inflate = View.inflate(getContext(), Da.view_grid_graph, (ViewGroup) null);
        this.d = (LineChart) inflate.findViewById(Ba.line_chart);
        this.e = (TextView) inflate.findViewById(Ba.title);
        setGridCount(2);
        addView(inflate);
    }

    public void d() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            float[] fArr = this.k;
            if (i2 >= fArr.length) {
                break;
            }
            arrayList.add(new j(this.j[i2], fArr[i2]));
            i2++;
        }
        i xAxis = this.d.getXAxis();
        xAxis.a(i.a.BOTTOM);
        xAxis.c(false);
        xAxis.a(getResources().getColor(za.graph_text_color));
        xAxis.a((d) new c());
        xAxis.b(1.0f);
        b.b.a.a.c.j axisLeft = this.d.getAxisLeft();
        axisLeft.c(false);
        axisLeft.a(getResources().getColor(za.graph_text_color));
        axisLeft.a(0.0f);
        b.b.a.a.c.j axisRight = this.d.getAxisRight();
        axisRight.b(false);
        axisRight.d(false);
        axisRight.c(false);
        axisRight.a(0.0f);
        l lVar = new l(arrayList, BuildConfig.FLAVOR);
        lVar.a(false);
        lVar.b(false);
        lVar.d(false);
        lVar.a((f) new b());
        lVar.f(getResources().getColor(za.graph_stroke_color));
        if (this.h) {
            lVar.c(true);
            lVar.a(getResources().getDrawable(Aa.graph_fill_color));
        }
        k kVar = new k(lVar);
        kVar.b(getResources().getColor(za.graph_text_color));
        b.b.a.a.c.c cVar = new b.b.a.a.c.c();
        cVar.a(false);
        this.d.setDescription(cVar);
        this.d.setNoDataText(getResources().getString(Fa.graph_loading));
        this.d.setMaxVisibleValueCount(10);
        this.d.getLegend().a(false);
        this.d.setPinchZoom(false);
        this.d.setScaleEnabled(false);
        this.d.setData(kVar);
        this.d.setOnClickListener(new a(this));
        this.d.invalidate();
    }

    public void setBaseTime(long j2) {
        this.i = j2;
    }

    public void setChartType(a aVar) {
        this.g = aVar;
    }

    public void setDrawFilled(boolean z) {
        this.h = z;
    }

    public void setFragmentManager(C0139o oVar) {
        this.f = oVar;
    }

    public void setGraphTitle(String str) {
        this.l = str;
        this.e.setVisibility(8);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        LineChart lineChart = this.d;
        if (lineChart != null) {
            lineChart.setOnClickListener(onClickListener);
        }
    }

    public void setUnits(String str) {
        this.m = str;
    }

    public void setXValues(float[] fArr) {
        this.j = fArr;
    }

    public void setYValues(float[] fArr) {
        this.k = fArr;
    }

    public /* synthetic */ void a(View view) {
        if (this.n) {
            new b.a.a.a.c().a(this.f, this.g, this.h, this.j, this.k, this.i, this.l, this.m);
        }
    }

    public CsGridGraphView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CsGridGraphView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
