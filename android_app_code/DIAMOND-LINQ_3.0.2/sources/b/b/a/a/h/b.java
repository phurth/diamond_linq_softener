package b.b.a.a.h;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import b.b.a.a.f.c;
import com.github.mikephil.charting.charts.e;

public abstract class b<T extends e<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    protected a f1254a = a.NONE;

    /* renamed from: b  reason: collision with root package name */
    protected int f1255b = 0;
    protected c c;
    protected GestureDetector d;
    protected T e;

    public enum a {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public b(T t) {
        this.e = t;
        this.d = new GestureDetector(t.getContext(), this);
    }

    public void a(MotionEvent motionEvent) {
        c onChartGestureListener = this.e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, this.f1254a);
        }
    }

    public void b(MotionEvent motionEvent) {
        c onChartGestureListener = this.e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, this.f1254a);
        }
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    /* access modifiers changed from: protected */
    public void a(c cVar, MotionEvent motionEvent) {
        if (cVar == null || cVar.a(this.c)) {
            this.e.a((c) null, true);
            this.c = null;
            return;
        }
        this.e.a(cVar, true);
        this.c = cVar;
    }

    protected static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }
}
