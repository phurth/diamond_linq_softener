package b.b.a.a.h;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import b.b.a.a.d.j;
import b.b.a.a.g.b.b;
import b.b.a.a.g.b.d;
import b.b.a.a.h.b;
import b.b.a.a.j.e;
import b.b.a.a.j.i;
import com.github.mikephil.charting.charts.c;
import com.github.mikephil.charting.charts.f;

public class a extends b<c<? extends b.b.a.a.d.c<? extends b<? extends j>>>> {
    private Matrix f = new Matrix();
    private Matrix g = new Matrix();
    private e h = e.a(0.0f, 0.0f);
    private e i = e.a(0.0f, 0.0f);
    private float j = 1.0f;
    private float k = 1.0f;
    private float l = 1.0f;
    private d m;
    private VelocityTracker n;
    private long o = 0;
    private e p = e.a(0.0f, 0.0f);
    private e q = e.a(0.0f, 0.0f);
    private float r;
    private float s;

    public a(c<? extends b.b.a.a.d.c<? extends b<? extends j>>> cVar, Matrix matrix, float f2) {
        super(cVar);
        this.f = matrix;
        this.r = i.a(f2);
        this.s = i.a(3.5f);
    }

    private void a(MotionEvent motionEvent, float f2, float f3) {
        this.f1254a = b.a.DRAG;
        this.f.set(this.g);
        c onChartGestureListener = ((c) this.e).getOnChartGestureListener();
        if (c()) {
            if (this.e instanceof f) {
                f2 = -f2;
            } else {
                f3 = -f3;
            }
        }
        this.f.postTranslate(f2, f3);
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, f2, f3);
        }
    }

    private static float c(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float d(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    private void e(MotionEvent motionEvent) {
        b.b.a.a.f.c a2 = ((c) this.e).a(motionEvent.getX(), motionEvent.getY());
        if (a2 != null && !a2.a(this.c)) {
            this.c = a2;
            ((c) this.e).a(a2, true);
        }
    }

    private void f(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (motionEvent.getPointerCount() >= 2) {
            c onChartGestureListener = ((c) this.e).getOnChartGestureListener();
            float h2 = h(motionEvent);
            if (h2 > this.s) {
                e eVar = this.i;
                e a2 = a(eVar.e, eVar.f);
                b.b.a.a.j.j viewPortHandler = ((c) this.e).getViewPortHandler();
                int i2 = this.f1255b;
                boolean z5 = true;
                if (i2 == 4) {
                    this.f1254a = b.a.PINCH_ZOOM;
                    float f2 = h2 / this.l;
                    if (f2 >= 1.0f) {
                        z5 = false;
                    }
                    if (z5) {
                        z3 = viewPortHandler.c();
                    } else {
                        z3 = viewPortHandler.a();
                    }
                    if (z5) {
                        z4 = viewPortHandler.d();
                    } else {
                        z4 = viewPortHandler.b();
                    }
                    float f3 = ((c) this.e).z() ? f2 : 1.0f;
                    if (!((c) this.e).A()) {
                        f2 = 1.0f;
                    }
                    if (z4 || z3) {
                        this.f.set(this.g);
                        this.f.postScale(f3, f2, a2.e, a2.f);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, f3, f2);
                        }
                    }
                } else if (i2 == 2 && ((c) this.e).z()) {
                    this.f1254a = b.a.X_ZOOM;
                    float c = c(motionEvent) / this.j;
                    if (c >= 1.0f) {
                        z5 = false;
                    }
                    if (z5) {
                        z2 = viewPortHandler.c();
                    } else {
                        z2 = viewPortHandler.a();
                    }
                    if (z2) {
                        this.f.set(this.g);
                        this.f.postScale(c, 1.0f, a2.e, a2.f);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, c, 1.0f);
                        }
                    }
                } else if (this.f1255b == 3 && ((c) this.e).A()) {
                    this.f1254a = b.a.Y_ZOOM;
                    float d = d(motionEvent) / this.k;
                    if (d >= 1.0f) {
                        z5 = false;
                    }
                    if (z5) {
                        z = viewPortHandler.d();
                    } else {
                        z = viewPortHandler.b();
                    }
                    if (z) {
                        this.f.set(this.g);
                        this.f.postScale(1.0f, d, a2.e, a2.f);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, 1.0f, d);
                        }
                    }
                }
                e.b(a2);
            }
        }
    }

    private void g(MotionEvent motionEvent) {
        this.g.set(this.f);
        this.h.e = motionEvent.getX();
        this.h.f = motionEvent.getY();
        this.m = ((c) this.e).c(motionEvent.getX(), motionEvent.getY());
    }

    private static float h(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public void b() {
        e eVar = this.q;
        eVar.e = 0.0f;
        eVar.f = 0.0f;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f1254a = b.a.DOUBLE_TAP;
        c onChartGestureListener = ((c) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
        if (((c) this.e).s() && ((b.b.a.a.d.c) ((c) this.e).getData()).d() > 0) {
            e a2 = a(motionEvent.getX(), motionEvent.getY());
            T t = this.e;
            c cVar = (c) t;
            float f2 = 1.4f;
            float f3 = ((c) t).z() ? 1.4f : 1.0f;
            if (!((c) this.e).A()) {
                f2 = 1.0f;
            }
            cVar.a(f3, f2, a2.e, a2.f);
            if (((c) this.e).k()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + a2.e + ", y: " + a2.f);
            }
            e.b(a2);
        }
        return super.onDoubleTap(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f1254a = b.a.FLING;
        c onChartGestureListener = ((c) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, motionEvent2, f2, f3);
        }
        return super.onFling(motionEvent, motionEvent2, f2, f3);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f1254a = b.a.LONG_PRESS;
        c onChartGestureListener = ((c) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f1254a = b.a.SINGLE_TAP;
        c onChartGestureListener = ((c) this.e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent);
        }
        if (!((c) this.e).j()) {
            return false;
        }
        a(((c) this.e).a(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
        this.n.addMovement(motionEvent);
        int i2 = 3;
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.n) != null) {
            velocityTracker.recycle();
            this.n = null;
        }
        if (this.f1255b == 0) {
            this.d.onTouchEvent(motionEvent);
        }
        if (!((c) this.e).t() && !((c) this.e).z() && !((c) this.e).A()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            boolean z = false;
            if (action == 1) {
                VelocityTracker velocityTracker2 = this.n;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker2.computeCurrentVelocity(1000, (float) i.b());
                float yVelocity = velocityTracker2.getYVelocity(pointerId);
                float xVelocity = velocityTracker2.getXVelocity(pointerId);
                if ((Math.abs(xVelocity) > ((float) i.c()) || Math.abs(yVelocity) > ((float) i.c())) && this.f1255b == 1 && ((c) this.e).h()) {
                    b();
                    this.o = AnimationUtils.currentAnimationTimeMillis();
                    this.p.e = motionEvent.getX();
                    this.p.f = motionEvent.getY();
                    e eVar = this.q;
                    eVar.e = xVelocity;
                    eVar.f = yVelocity;
                    i.a((View) this.e);
                }
                int i3 = this.f1255b;
                if (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
                    ((c) this.e).d();
                    ((c) this.e).postInvalidate();
                }
                this.f1255b = 0;
                ((c) this.e).f();
                VelocityTracker velocityTracker3 = this.n;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.n = null;
                }
                a(motionEvent);
            } else if (action == 2) {
                int i4 = this.f1255b;
                if (i4 == 1) {
                    ((c) this.e).e();
                    float f2 = 0.0f;
                    float x = ((c) this.e).u() ? motionEvent.getX() - this.h.e : 0.0f;
                    if (((c) this.e).v()) {
                        f2 = motionEvent.getY() - this.h.f;
                    }
                    a(motionEvent, x, f2);
                } else if (i4 == 2 || i4 == 3 || i4 == 4) {
                    ((c) this.e).e();
                    if (((c) this.e).z() || ((c) this.e).A()) {
                        f(motionEvent);
                    }
                } else if (i4 == 0 && Math.abs(b.a(motionEvent.getX(), this.h.e, motionEvent.getY(), this.h.f)) > this.r && ((c) this.e).t()) {
                    if (!((c) this.e).w() || !((c) this.e).p()) {
                        z = true;
                    }
                    if (z) {
                        float abs = Math.abs(motionEvent.getX() - this.h.e);
                        float abs2 = Math.abs(motionEvent.getY() - this.h.f);
                        if ((((c) this.e).u() || abs2 >= abs) && (((c) this.e).v() || abs2 <= abs)) {
                            this.f1254a = b.a.DRAG;
                            this.f1255b = 1;
                        }
                    } else if (((c) this.e).x()) {
                        this.f1254a = b.a.DRAG;
                        if (((c) this.e).x()) {
                            e(motionEvent);
                        }
                    }
                }
            } else if (action == 3) {
                this.f1255b = 0;
                a(motionEvent);
            } else if (action != 5) {
                if (action == 6) {
                    i.a(motionEvent, this.n);
                    this.f1255b = 5;
                }
            } else if (motionEvent.getPointerCount() >= 2) {
                ((c) this.e).e();
                g(motionEvent);
                this.j = c(motionEvent);
                this.k = d(motionEvent);
                this.l = h(motionEvent);
                if (this.l > 10.0f) {
                    if (((c) this.e).y()) {
                        this.f1255b = 4;
                    } else if (((c) this.e).z() != ((c) this.e).A()) {
                        if (((c) this.e).z()) {
                            i2 = 2;
                        }
                        this.f1255b = i2;
                    } else {
                        if (this.j > this.k) {
                            i2 = 2;
                        }
                        this.f1255b = i2;
                    }
                }
                a(this.i, motionEvent);
            }
        } else {
            b(motionEvent);
            b();
            g(motionEvent);
        }
        b.b.a.a.j.j viewPortHandler = ((c) this.e).getViewPortHandler();
        Matrix matrix = this.f;
        viewPortHandler.a(matrix, this.e, true);
        this.f = matrix;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r2.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c() {
        /*
            r2 = this;
            b.b.a.a.g.b.d r0 = r2.m
            if (r0 != 0) goto L_0x000e
            T r0 = r2.e
            com.github.mikephil.charting.charts.c r0 = (com.github.mikephil.charting.charts.c) r0
            boolean r0 = r0.q()
            if (r0 != 0) goto L_0x0020
        L_0x000e:
            b.b.a.a.g.b.d r0 = r2.m
            if (r0 == 0) goto L_0x0022
            T r1 = r2.e
            com.github.mikephil.charting.charts.c r1 = (com.github.mikephil.charting.charts.c) r1
            b.b.a.a.c.j$a r0 = r0.q()
            boolean r0 = r1.b(r0)
            if (r0 == 0) goto L_0x0022
        L_0x0020:
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a.h.a.c():boolean");
    }

    private static void a(e eVar, MotionEvent motionEvent) {
        eVar.e = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        eVar.f = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
    }

    public e a(float f2, float f3) {
        float f4;
        b.b.a.a.j.j viewPortHandler = ((c) this.e).getViewPortHandler();
        float w = f2 - viewPortHandler.w();
        if (c()) {
            f4 = -(f3 - viewPortHandler.y());
        } else {
            f4 = -((((float) ((c) this.e).getMeasuredHeight()) - f3) - viewPortHandler.v());
        }
        return e.a(w, f4);
    }

    public void a() {
        e eVar = this.q;
        float f2 = 0.0f;
        if (eVar.e != 0.0f || eVar.f != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.q.e *= ((c) this.e).getDragDecelerationFrictionCoef();
            this.q.f *= ((c) this.e).getDragDecelerationFrictionCoef();
            float f3 = ((float) (currentAnimationTimeMillis - this.o)) / 1000.0f;
            e eVar2 = this.q;
            float f4 = eVar2.e * f3;
            float f5 = eVar2.f * f3;
            e eVar3 = this.p;
            eVar3.e += f4;
            eVar3.f += f5;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, eVar3.e, eVar3.f, 0);
            float f6 = ((c) this.e).u() ? this.p.e - this.h.e : 0.0f;
            if (((c) this.e).v()) {
                f2 = this.p.f - this.h.f;
            }
            a(obtain, f6, f2);
            obtain.recycle();
            b.b.a.a.j.j viewPortHandler = ((c) this.e).getViewPortHandler();
            Matrix matrix = this.f;
            viewPortHandler.a(matrix, this.e, false);
            this.f = matrix;
            this.o = currentAnimationTimeMillis;
            if (((double) Math.abs(this.q.e)) >= 0.01d || ((double) Math.abs(this.q.f)) >= 0.01d) {
                i.a((View) this.e);
                return;
            }
            ((c) this.e).d();
            ((c) this.e).postInvalidate();
            b();
        }
    }
}
