package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import b.b.a.a.c.f;
import b.b.a.a.c.i;
import b.b.a.a.c.j;
import b.b.a.a.d.c;
import b.b.a.a.d.j;
import b.b.a.a.g.b.b;
import b.b.a.a.h.a;
import b.b.a.a.h.e;
import b.b.a.a.i.d;
import b.b.a.a.i.m;
import b.b.a.a.i.o;
import b.b.a.a.j.g;

@SuppressLint({"RtlHardcoded"})
public abstract class c<T extends b.b.a.a.d.c<? extends b<? extends j>>> extends e<T> implements b.b.a.a.g.a.b {
    protected int G = 100;
    protected boolean H = false;
    protected boolean I = false;
    protected boolean J = true;
    protected boolean K = true;
    private boolean L = true;
    private boolean M = true;
    private boolean N = true;
    private boolean O = true;
    protected Paint P;
    protected Paint Q;
    protected boolean R = false;
    protected boolean S = false;
    protected boolean T = false;
    protected float U = 15.0f;
    protected boolean V = false;
    protected e W;
    protected b.b.a.a.c.j aa;
    protected b.b.a.a.c.j ba;
    protected o ca;
    protected o da;
    protected g ea;
    protected g fa;
    protected m ga;
    private long ha = 0;
    private long ia = 0;
    private RectF ja = new RectF();
    protected Matrix ka = new Matrix();
    protected Matrix la = new Matrix();
    private boolean ma = false;
    protected float[] na = new float[2];
    protected b.b.a.a.j.c oa = b.b.a.a.j.c.a(0.0d, 0.0d);
    protected b.b.a.a.j.c pa = b.b.a.a.j.c.a(0.0d, 0.0d);
    protected float[] qa = new float[2];

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean A() {
        return this.O;
    }

    /* access modifiers changed from: protected */
    public void B() {
        this.fa.a(this.ba.J());
        this.ea.a(this.aa.J());
    }

    /* access modifiers changed from: protected */
    public void C() {
        if (this.f1429a) {
            Log.i("MPAndroidChart", "Preparing Value-Px Matrix, xmin: " + this.i.G + ", xmax: " + this.i.F + ", xdelta: " + this.i.H);
        }
        g gVar = this.fa;
        i iVar = this.i;
        float f = iVar.G;
        float f2 = iVar.H;
        b.b.a.a.c.j jVar = this.ba;
        gVar.a(f, f2, jVar.H, jVar.G);
        g gVar2 = this.ea;
        i iVar2 = this.i;
        float f3 = iVar2.G;
        float f4 = iVar2.H;
        b.b.a.a.c.j jVar2 = this.aa;
        gVar2.a(f3, f4, jVar2.H, jVar2.G);
    }

    /* access modifiers changed from: protected */
    public void a(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        f fVar = this.l;
        if (fVar != null && fVar.f() && !this.l.y()) {
            int i = b.c[this.l.t().ordinal()];
            if (i == 1) {
                int i2 = b.f1427b[this.l.r().ordinal()];
                if (i2 == 1) {
                    rectF.left += Math.min(this.l.x, this.t.l() * this.l.s()) + this.l.d();
                } else if (i2 == 2) {
                    rectF.right += Math.min(this.l.x, this.t.l() * this.l.s()) + this.l.d();
                } else if (i2 == 3) {
                    int i3 = b.f1426a[this.l.v().ordinal()];
                    if (i3 == 1) {
                        rectF.top += Math.min(this.l.y, this.t.k() * this.l.s()) + this.l.e();
                    } else if (i3 == 2) {
                        rectF.bottom += Math.min(this.l.y, this.t.k() * this.l.s()) + this.l.e();
                    }
                }
            } else if (i == 2) {
                int i4 = b.f1426a[this.l.v().ordinal()];
                if (i4 == 1) {
                    rectF.top += Math.min(this.l.y, this.t.k() * this.l.s()) + this.l.e();
                    if (getXAxis().f() && getXAxis().u()) {
                        rectF.top += (float) getXAxis().L;
                    }
                } else if (i4 == 2) {
                    rectF.bottom += Math.min(this.l.y, this.t.k() * this.l.s()) + this.l.e();
                    if (getXAxis().f() && getXAxis().u()) {
                        rectF.bottom += (float) getXAxis().L;
                    }
                }
            }
        }
    }

    public boolean b(j.a aVar) {
        return c(aVar).J();
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas) {
        if (this.R) {
            canvas.drawRect(this.t.n(), this.P);
        }
        if (this.S) {
            canvas.drawRect(this.t.n(), this.Q);
        }
    }

    public void computeScroll() {
        b.b.a.a.h.b bVar = this.n;
        if (bVar instanceof a) {
            ((a) bVar).a();
        }
    }

    public void d() {
        if (!this.ma) {
            a(this.ja);
            RectF rectF = this.ja;
            float f = rectF.left + 0.0f;
            float f2 = rectF.top + 0.0f;
            float f3 = rectF.right + 0.0f;
            float f4 = rectF.bottom + 0.0f;
            if (this.aa.K()) {
                f += this.aa.b(this.ca.a());
            }
            if (this.ba.K()) {
                f3 += this.ba.b(this.da.a());
            }
            if (this.i.f() && this.i.u()) {
                i iVar = this.i;
                float e = ((float) iVar.L) + iVar.e();
                if (this.i.z() == i.a.BOTTOM) {
                    f4 += e;
                } else {
                    if (this.i.z() != i.a.TOP) {
                        if (this.i.z() == i.a.BOTH_SIDED) {
                            f4 += e;
                        }
                    }
                    f2 += e;
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
        }
        B();
        C();
    }

    /* access modifiers changed from: protected */
    public void g() {
        super.g();
        this.aa = new b.b.a.a.c.j(j.a.LEFT);
        this.ba = new b.b.a.a.c.j(j.a.RIGHT);
        this.ea = new g(this.t);
        this.fa = new g(this.t);
        this.ca = new o(this.t, this.aa, this.ea);
        this.da = new o(this.t, this.ba, this.fa);
        this.ga = new m(this.t, this.i, this.ea);
        setHighlighter(new b.b.a.a.f.b(this));
        this.n = new a(this, this.t.o(), 3.0f);
        this.P = new Paint();
        this.P.setStyle(Paint.Style.FILL);
        this.P.setColor(Color.rgb(240, 240, 240));
        this.Q = new Paint();
        this.Q.setStyle(Paint.Style.STROKE);
        this.Q.setColor(-16777216);
        this.Q.setStrokeWidth(b.b.a.a.j.i.a(1.0f));
    }

    public b.b.a.a.c.j getAxisLeft() {
        return this.aa;
    }

    public b.b.a.a.c.j getAxisRight() {
        return this.ba;
    }

    public /* bridge */ /* synthetic */ b.b.a.a.d.c getData() {
        return (b.b.a.a.d.c) super.getData();
    }

    public e getDrawListener() {
        return this.W;
    }

    public float getHighestVisibleX() {
        a(j.a.LEFT).a(this.t.h(), this.t.e(), this.pa);
        return (float) Math.min((double) this.i.F, this.pa.d);
    }

    public float getLowestVisibleX() {
        a(j.a.LEFT).a(this.t.g(), this.t.e(), this.oa);
        return (float) Math.max((double) this.i.G, this.oa.d);
    }

    public int getMaxVisibleCount() {
        return this.G;
    }

    public float getMinOffset() {
        return this.U;
    }

    public o getRendererLeftYAxis() {
        return this.ca;
    }

    public o getRendererRightYAxis() {
        return this.da;
    }

    public m getRendererXAxis() {
        return this.ga;
    }

    public float getScaleX() {
        b.b.a.a.j.j jVar = this.t;
        if (jVar == null) {
            return 1.0f;
        }
        return jVar.p();
    }

    public float getScaleY() {
        b.b.a.a.j.j jVar = this.t;
        if (jVar == null) {
            return 1.0f;
        }
        return jVar.q();
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    public float getYChartMax() {
        return Math.max(this.aa.F, this.ba.F);
    }

    public float getYChartMin() {
        return Math.min(this.aa.G, this.ba.G);
    }

    public void l() {
        if (this.f1430b != null) {
            if (this.f1429a) {
                Log.i("MPAndroidChart", "Preparing...");
            }
            d dVar = this.r;
            if (dVar != null) {
                dVar.a();
            }
            o();
            o oVar = this.ca;
            b.b.a.a.c.j jVar = this.aa;
            oVar.a(jVar.G, jVar.F, jVar.J());
            o oVar2 = this.da;
            b.b.a.a.c.j jVar2 = this.ba;
            oVar2.a(jVar2.G, jVar2.F, jVar2.J());
            m mVar = this.ga;
            i iVar = this.i;
            mVar.a(iVar.G, iVar.F, false);
            if (this.l != null) {
                this.q.a((b.b.a.a.d.g<?>) this.f1430b);
            }
            d();
        } else if (this.f1429a) {
            Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        ((b.b.a.a.d.c) this.f1430b).a(getLowestVisibleX(), getHighestVisibleX());
        this.i.a(((b.b.a.a.d.c) this.f1430b).f(), ((b.b.a.a.d.c) this.f1430b).e());
        if (this.aa.f()) {
            this.aa.a(((b.b.a.a.d.c) this.f1430b).b(j.a.LEFT), ((b.b.a.a.d.c) this.f1430b).a(j.a.LEFT));
        }
        if (this.ba.f()) {
            this.ba.a(((b.b.a.a.d.c) this.f1430b).b(j.a.RIGHT), ((b.b.a.a.d.c) this.f1430b).a(j.a.RIGHT));
        }
        d();
    }

    /* access modifiers changed from: protected */
    public void o() {
        this.i.a(((b.b.a.a.d.c) this.f1430b).f(), ((b.b.a.a.d.c) this.f1430b).e());
        this.aa.a(((b.b.a.a.d.c) this.f1430b).b(j.a.LEFT), ((b.b.a.a.d.c) this.f1430b).a(j.a.LEFT));
        this.ba.a(((b.b.a.a.d.c) this.f1430b).b(j.a.RIGHT), ((b.b.a.a.d.c) this.f1430b).a(j.a.RIGHT));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1430b != null) {
            long currentTimeMillis = System.currentTimeMillis();
            c(canvas);
            if (this.H) {
                n();
            }
            if (this.aa.f()) {
                o oVar = this.ca;
                b.b.a.a.c.j jVar = this.aa;
                oVar.a(jVar.G, jVar.F, jVar.J());
            }
            if (this.ba.f()) {
                o oVar2 = this.da;
                b.b.a.a.c.j jVar2 = this.ba;
                oVar2.a(jVar2.G, jVar2.F, jVar2.J());
            }
            if (this.i.f()) {
                m mVar = this.ga;
                i iVar = this.i;
                mVar.a(iVar.G, iVar.F, false);
            }
            this.ga.b(canvas);
            this.ca.c(canvas);
            this.da.c(canvas);
            this.ga.c(canvas);
            this.ca.d(canvas);
            this.da.d(canvas);
            if (this.i.f() && this.i.v()) {
                this.ga.d(canvas);
            }
            if (this.aa.f() && this.aa.v()) {
                this.ca.e(canvas);
            }
            if (this.ba.f() && this.ba.v()) {
                this.da.e(canvas);
            }
            int save = canvas.save();
            canvas.clipRect(this.t.n());
            this.r.a(canvas);
            if (m()) {
                this.r.a(canvas, this.A);
            }
            canvas.restoreToCount(save);
            this.r.b(canvas);
            if (this.i.f() && !this.i.v()) {
                this.ga.d(canvas);
            }
            if (this.aa.f() && !this.aa.v()) {
                this.ca.e(canvas);
            }
            if (this.ba.f() && !this.ba.v()) {
                this.da.e(canvas);
            }
            this.ga.a(canvas);
            this.ca.b(canvas);
            this.da.b(canvas);
            if (r()) {
                int save2 = canvas.save();
                canvas.clipRect(this.t.n());
                this.r.c(canvas);
                canvas.restoreToCount(save2);
            } else {
                this.r.c(canvas);
            }
            this.q.a(canvas);
            a(canvas);
            b(canvas);
            if (this.f1429a) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.ha += currentTimeMillis2;
                this.ia++;
                Log.i("MPAndroidChart", "Drawtime: " + currentTimeMillis2 + " ms, average: " + (this.ha / this.ia) + " ms, cycles: " + this.ia);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float[] fArr = this.qa;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.V) {
            fArr[0] = this.t.g();
            this.qa[1] = this.t.i();
            a(j.a.LEFT).a(this.qa);
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.V) {
            a(j.a.LEFT).b(this.qa);
            this.t.a(this.qa, (View) this);
            return;
        }
        b.b.a.a.j.j jVar = this.t;
        jVar.a(jVar.o(), this, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        b.b.a.a.h.b bVar = this.n;
        if (bVar == null || this.f1430b == null || !this.j) {
            return false;
        }
        return bVar.onTouch(this, motionEvent);
    }

    public boolean p() {
        return this.t.r();
    }

    public boolean q() {
        if (!this.aa.J() && !this.ba.J()) {
            return false;
        }
        return true;
    }

    public boolean r() {
        return this.T;
    }

    public boolean s() {
        return this.J;
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.H = z;
    }

    public void setBorderColor(int i) {
        this.Q.setColor(i);
    }

    public void setBorderWidth(float f) {
        this.Q.setStrokeWidth(b.b.a.a.j.i.a(f));
    }

    public void setClipValuesToContent(boolean z) {
        this.T = z;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.J = z;
    }

    public void setDragEnabled(boolean z) {
        this.L = z;
        this.M = z;
    }

    public void setDragOffsetX(float f) {
        this.t.g(f);
    }

    public void setDragOffsetY(float f) {
        this.t.h(f);
    }

    public void setDragXEnabled(boolean z) {
        this.L = z;
    }

    public void setDragYEnabled(boolean z) {
        this.M = z;
    }

    public void setDrawBorders(boolean z) {
        this.S = z;
    }

    public void setDrawGridBackground(boolean z) {
        this.R = z;
    }

    public void setGridBackgroundColor(int i) {
        this.P.setColor(i);
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.K = z;
    }

    public void setKeepPositionOnRotation(boolean z) {
        this.V = z;
    }

    public void setMaxVisibleValueCount(int i) {
        this.G = i;
    }

    public void setMinOffset(float f) {
        this.U = f;
    }

    public void setOnDrawListener(e eVar) {
        this.W = eVar;
    }

    public void setPinchZoom(boolean z) {
        this.I = z;
    }

    public void setRendererLeftYAxis(o oVar) {
        this.ca = oVar;
    }

    public void setRendererRightYAxis(o oVar) {
        this.da = oVar;
    }

    public void setScaleEnabled(boolean z) {
        this.N = z;
        this.O = z;
    }

    public void setScaleXEnabled(boolean z) {
        this.N = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.O = z;
    }

    public void setVisibleXRangeMaximum(float f) {
        this.t.k(this.i.H / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.t.i(this.i.H / f);
    }

    public void setXAxisRenderer(m mVar) {
        this.ga = mVar;
    }

    public boolean t() {
        return this.L || this.M;
    }

    public boolean u() {
        return this.L;
    }

    public boolean v() {
        return this.M;
    }

    public boolean w() {
        return this.t.s();
    }

    public boolean x() {
        return this.K;
    }

    public boolean y() {
        return this.I;
    }

    public boolean z() {
        return this.N;
    }

    public b c(float f, float f2) {
        b.b.a.a.f.c a2 = a(f, f2);
        if (a2 != null) {
            return (b) ((b.b.a.a.d.c) this.f1430b).a(a2.b());
        }
        return null;
    }

    public b.b.a.a.c.j c(j.a aVar) {
        if (aVar == j.a.LEFT) {
            return this.aa;
        }
        return this.ba;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g a(j.a aVar) {
        if (aVar == j.a.LEFT) {
            return this.ea;
        }
        return this.fa;
    }

    public void a(float f, float f2, float f3, float f4) {
        this.t.a(f, f2, f3, -f4, this.ka);
        this.t.a(this.ka, this, false);
        d();
        postInvalidate();
    }

    public c(Context context) {
        super(context);
    }
}
