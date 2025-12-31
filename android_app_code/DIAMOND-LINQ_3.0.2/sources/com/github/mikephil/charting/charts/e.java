package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.b.a.a.a.a;
import b.b.a.a.c.f;
import b.b.a.a.c.i;
import b.b.a.a.d.g;
import b.b.a.a.d.j;
import b.b.a.a.g.a.c;
import b.b.a.a.g.b.d;
import b.b.a.a.h.b;
import java.util.ArrayList;
import java.util.Iterator;
import no.nordicsemi.android.log.BuildConfig;

@SuppressLint({"NewApi"})
public abstract class e<T extends g<? extends d<? extends j>>> extends ViewGroup implements c {
    protected b.b.a.a.f.c[] A;
    protected float B = 0.0f;
    protected boolean C = true;
    protected b.b.a.a.c.d D;
    protected ArrayList<Runnable> E = new ArrayList<>();
    private boolean F = false;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f1429a = false;

    /* renamed from: b  reason: collision with root package name */
    protected T f1430b = null;
    protected boolean c = true;
    private boolean d = true;
    private float e = 0.9f;
    protected b.b.a.a.e.c f = new b.b.a.a.e.c(0);
    protected Paint g;
    protected Paint h;
    protected i i;
    protected boolean j = true;
    protected b.b.a.a.c.c k;
    protected f l;
    protected b.b.a.a.h.d m;
    protected b n;
    private String o = "No chart data available.";
    private b.b.a.a.h.c p;
    protected b.b.a.a.i.g q;
    protected b.b.a.a.i.d r;
    protected b.b.a.a.f.e s;
    protected b.b.a.a.j.j t = new b.b.a.a.j.j();
    protected a u;
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;
    private float y = 0.0f;
    private boolean z = false;

    public e(Context context) {
        super(context);
        g();
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        float f2;
        float f3;
        b.b.a.a.c.c cVar = this.k;
        if (cVar != null && cVar.f()) {
            b.b.a.a.j.e g2 = this.k.g();
            this.g.setTypeface(this.k.c());
            this.g.setTextSize(this.k.b());
            this.g.setColor(this.k.a());
            this.g.setTextAlign(this.k.i());
            if (g2 == null) {
                f3 = (((float) getWidth()) - this.t.x()) - this.k.d();
                f2 = (((float) getHeight()) - this.t.v()) - this.k.e();
            } else {
                float f4 = g2.e;
                f2 = g2.f;
                f3 = f4;
            }
            canvas.drawText(this.k.h(), f3, f2, this.g);
        }
    }

    /* access modifiers changed from: protected */
    public void b(float f2, float f3) {
        float f4;
        T t2 = this.f1430b;
        if (t2 == null || t2.d() < 2) {
            f4 = Math.max(Math.abs(f2), Math.abs(f3));
        } else {
            f4 = Math.abs(f3 - f2);
        }
        this.f.a(b.b.a.a.j.i.b(f4));
    }

    /* access modifiers changed from: protected */
    public abstract void d();

    public void e() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void f() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT < 11) {
            this.u = new a();
        } else {
            this.u = new a(new d(this));
        }
        b.b.a.a.j.i.a(getContext());
        this.B = b.b.a.a.j.i.a(500.0f);
        this.k = new b.b.a.a.c.c();
        this.l = new f();
        this.q = new b.b.a.a.i.g(this.t, this.l);
        this.i = new i();
        this.g = new Paint(1);
        this.h = new Paint(1);
        this.h.setColor(Color.rgb(247, 189, 51));
        this.h.setTextAlign(Paint.Align.CENTER);
        this.h.setTextSize(b.b.a.a.j.i.a(12.0f));
        if (this.f1429a) {
            Log.i(BuildConfig.FLAVOR, "Chart.init()");
        }
    }

    public a getAnimator() {
        return this.u;
    }

    public b.b.a.a.j.e getCenter() {
        return b.b.a.a.j.e.a(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    public b.b.a.a.j.e getCenterOfView() {
        return getCenter();
    }

    public b.b.a.a.j.e getCenterOffsets() {
        return this.t.m();
    }

    public Bitmap getChartBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return createBitmap;
    }

    public RectF getContentRect() {
        return this.t.n();
    }

    public T getData() {
        return this.f1430b;
    }

    public b.b.a.a.e.f getDefaultValueFormatter() {
        return this.f;
    }

    public b.b.a.a.c.c getDescription() {
        return this.k;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.e;
    }

    public float getExtraBottomOffset() {
        return this.x;
    }

    public float getExtraLeftOffset() {
        return this.y;
    }

    public float getExtraRightOffset() {
        return this.w;
    }

    public float getExtraTopOffset() {
        return this.v;
    }

    public b.b.a.a.f.c[] getHighlighted() {
        return this.A;
    }

    public b.b.a.a.f.e getHighlighter() {
        return this.s;
    }

    public ArrayList<Runnable> getJobs() {
        return this.E;
    }

    public f getLegend() {
        return this.l;
    }

    public b.b.a.a.i.g getLegendRenderer() {
        return this.q;
    }

    public b.b.a.a.c.d getMarker() {
        return this.D;
    }

    @Deprecated
    public b.b.a.a.c.d getMarkerView() {
        return getMarker();
    }

    public float getMaxHighlightDistance() {
        return this.B;
    }

    public b.b.a.a.h.c getOnChartGestureListener() {
        return this.p;
    }

    public b getOnTouchListener() {
        return this.n;
    }

    public b.b.a.a.i.d getRenderer() {
        return this.r;
    }

    public b.b.a.a.j.j getViewPortHandler() {
        return this.t;
    }

    public i getXAxis() {
        return this.i;
    }

    public float getXChartMax() {
        return this.i.F;
    }

    public float getXChartMin() {
        return this.i.G;
    }

    public float getXRange() {
        return this.i.H;
    }

    public float getYMax() {
        return this.f1430b.g();
    }

    public float getYMin() {
        return this.f1430b.h();
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        return this.C;
    }

    public boolean j() {
        return this.c;
    }

    public boolean k() {
        return this.f1429a;
    }

    public abstract void l();

    public boolean m() {
        b.b.a.a.f.c[] cVarArr = this.A;
        return (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.F) {
            a((View) this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f1430b == null) {
            if (!TextUtils.isEmpty(this.o)) {
                b.b.a.a.j.e center = getCenter();
                canvas.drawText(this.o, center.e, center.f, this.h);
            }
        } else if (!this.z) {
            d();
            this.z = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            getChildAt(i6).layout(i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int a2 = (int) b.b.a.a.j.i.a(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), ViewGroup.resolveSize(a2, i2)), Math.max(getSuggestedMinimumHeight(), ViewGroup.resolveSize(a2, i3)));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (this.f1429a) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i2 > 0 && i3 > 0 && i2 < 10000 && i3 < 10000) {
            if (this.f1429a) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i2 + ", height: " + i3);
            }
            this.t.b((float) i2, (float) i3);
        } else if (this.f1429a) {
            Log.w("MPAndroidChart", "*Avoiding* setting chart dimens! width: " + i2 + ", height: " + i3);
        }
        l();
        Iterator<Runnable> it = this.E.iterator();
        while (it.hasNext()) {
            post(it.next());
        }
        this.E.clear();
        super.onSizeChanged(i2, i3, i4, i5);
    }

    public void setData(T t2) {
        this.f1430b = t2;
        this.z = false;
        if (t2 != null) {
            b(t2.h(), t2.g());
            for (d dVar : this.f1430b.c()) {
                if (dVar.m() || dVar.i() == this.f) {
                    dVar.a((b.b.a.a.e.f) this.f);
                }
            }
            l();
            if (this.f1429a) {
                Log.i("MPAndroidChart", "Data is set.");
            }
        }
    }

    public void setDescription(b.b.a.a.c.c cVar) {
        this.k = cVar;
    }

    public void setDragDecelerationEnabled(boolean z2) {
        this.d = z2;
    }

    public void setDragDecelerationFrictionCoef(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 >= 1.0f) {
            f2 = 0.999f;
        }
        this.e = f2;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z2) {
        setDrawMarkers(z2);
    }

    public void setDrawMarkers(boolean z2) {
        this.C = z2;
    }

    public void setExtraBottomOffset(float f2) {
        this.x = b.b.a.a.j.i.a(f2);
    }

    public void setExtraLeftOffset(float f2) {
        this.y = b.b.a.a.j.i.a(f2);
    }

    public void setExtraRightOffset(float f2) {
        this.w = b.b.a.a.j.i.a(f2);
    }

    public void setExtraTopOffset(float f2) {
        this.v = b.b.a.a.j.i.a(f2);
    }

    public void setHardwareAccelerationEnabled(boolean z2) {
        if (Build.VERSION.SDK_INT < 11) {
            Log.e("MPAndroidChart", "Cannot enable/disable hardware acceleration for devices below API level 11.");
        } else if (z2) {
            setLayerType(2, (Paint) null);
        } else {
            setLayerType(1, (Paint) null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z2) {
        this.c = z2;
    }

    public void setHighlighter(b.b.a.a.f.b bVar) {
        this.s = bVar;
    }

    /* access modifiers changed from: protected */
    public void setLastHighlighted(b.b.a.a.f.c[] cVarArr) {
        if (cVarArr == null || cVarArr.length <= 0 || cVarArr[0] == null) {
            this.n.a((b.b.a.a.f.c) null);
        } else {
            this.n.a(cVarArr[0]);
        }
    }

    public void setLogEnabled(boolean z2) {
        this.f1429a = z2;
    }

    public void setMarker(b.b.a.a.c.d dVar) {
        this.D = dVar;
    }

    @Deprecated
    public void setMarkerView(b.b.a.a.c.d dVar) {
        setMarker(dVar);
    }

    public void setMaxHighlightDistance(float f2) {
        this.B = b.b.a.a.j.i.a(f2);
    }

    public void setNoDataText(String str) {
        this.o = str;
    }

    public void setNoDataTextColor(int i2) {
        this.h.setColor(i2);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.h.setTypeface(typeface);
    }

    public void setOnChartGestureListener(b.b.a.a.h.c cVar) {
        this.p = cVar;
    }

    public void setOnChartValueSelectedListener(b.b.a.a.h.d dVar) {
        this.m = dVar;
    }

    public void setOnTouchListener(b bVar) {
        this.n = bVar;
    }

    public void setRenderer(b.b.a.a.i.d dVar) {
        if (dVar != null) {
            this.r = dVar;
        }
    }

    public void setTouchEnabled(boolean z2) {
        this.j = z2;
    }

    public void setUnbindEnabled(boolean z2) {
        this.F = z2;
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas) {
        if (this.D != null && i() && m()) {
            int i2 = 0;
            while (true) {
                b.b.a.a.f.c[] cVarArr = this.A;
                if (i2 < cVarArr.length) {
                    b.b.a.a.f.c cVar = cVarArr[i2];
                    d a2 = this.f1430b.a(cVar.b());
                    j a3 = this.f1430b.a(this.A[i2]);
                    int a4 = a2.a(a3);
                    if (a3 != null && ((float) a4) <= ((float) a2.r()) * this.u.a()) {
                        float[] a5 = a(cVar);
                        if (this.t.a(a5[0], a5[1])) {
                            this.D.a(a3, cVar);
                            this.D.a(canvas, a5[0], a5[1]);
                        }
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b.b.a.a.f.c cVar, boolean z2) {
        j jVar;
        if (cVar == null) {
            this.A = null;
            jVar = null;
        } else {
            if (this.f1429a) {
                Log.i("MPAndroidChart", "Highlighted: " + cVar.toString());
            }
            jVar = this.f1430b.a(cVar);
            if (jVar == null) {
                this.A = null;
                cVar = null;
            } else {
                this.A = new b.b.a.a.f.c[]{cVar};
            }
        }
        setLastHighlighted(this.A);
        if (z2 && this.m != null) {
            if (!m()) {
                this.m.a();
            } else {
                this.m.a(jVar, cVar);
            }
        }
        invalidate();
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public b.b.a.a.f.c a(float f2, float f3) {
        if (this.f1430b != null) {
            return getHighlighter().a(f2, f3);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    /* access modifiers changed from: protected */
    public float[] a(b.b.a.a.f.c cVar) {
        return new float[]{cVar.c(), cVar.d()};
    }

    private void a(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback((Drawable.Callback) null);
        }
        if (view instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 < viewGroup.getChildCount()) {
                    a(viewGroup.getChildAt(i2));
                    i2++;
                } else {
                    viewGroup.removeAllViews();
                    return;
                }
            }
        }
    }

    public e(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g();
    }
}
