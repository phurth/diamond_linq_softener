package b.b.a.a.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import b.b.a.a.e.c;
import b.b.a.a.e.f;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static DisplayMetrics f1275a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f1276b = 50;
    private static int c = 8000;
    public static final double d = Double.longBitsToDouble(1);
    public static final float e = Float.intBitsToFloat(1);
    private static Rect f = new Rect();
    private static Paint.FontMetrics g = new Paint.FontMetrics();
    private static Rect h = new Rect();
    private static final int[] i = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    private static f j = e();
    private static Rect k = new Rect();
    private static Rect l = new Rect();
    private static Paint.FontMetrics m = new Paint.FontMetrics();

    public static void a(Context context) {
        if (context == null) {
            f1276b = ViewConfiguration.getMinimumFlingVelocity();
            c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        f1276b = viewConfiguration.getScaledMinimumFlingVelocity();
        c = viewConfiguration.getScaledMaximumFlingVelocity();
        f1275a = context.getResources().getDisplayMetrics();
    }

    public static float b(Paint paint) {
        return b(paint, g);
    }

    public static int c(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static int d() {
        return Build.VERSION.SDK_INT;
    }

    private static f e() {
        return new c(1);
    }

    public static float b(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int c() {
        return f1276b;
    }

    public static a b(Paint paint, String str) {
        a a2 = a.a(0.0f, 0.0f);
        a(paint, str, a2);
        return a2;
    }

    public static float b(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 == 0.0d) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, (double) (1 - ((int) ((float) Math.ceil((double) ((float) Math.log10(d2 < 0.0d ? -d2 : d2)))))));
        double d3 = (double) pow;
        Double.isNaN(d3);
        return ((float) Math.round(d2 * d3)) / pow;
    }

    public static float a(float f2) {
        DisplayMetrics displayMetrics = f1275a;
        if (displayMetrics != null) {
            return f2 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static int b(float f2) {
        float b2 = b((double) f2);
        if (Float.isInfinite(b2)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10((double) b2))) + 2;
    }

    public static int a(Paint paint, String str) {
        Rect rect = f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static int b() {
        return c;
    }

    public static a b(float f2, float f3, float f4) {
        double d2 = (double) f4;
        return a.a(Math.abs(((float) Math.cos(d2)) * f2) + Math.abs(((float) Math.sin(d2)) * f3), Math.abs(f2 * ((float) Math.sin(d2))) + Math.abs(f3 * ((float) Math.cos(d2))));
    }

    public static float a(Paint paint) {
        return a(paint, g);
    }

    public static float a(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static void a(Paint paint, String str, a aVar) {
        Rect rect = h;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        aVar.d = (float) rect.width();
        aVar.e = (float) rect.height();
    }

    public static f a() {
        return j;
    }

    public static double a(double d2) {
        if (d2 == Double.POSITIVE_INFINITY) {
            return d2;
        }
        double d3 = d2 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d3) + (d3 >= 0.0d ? 1 : -1));
    }

    public static void a(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, (float) c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (i2 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10);
        }
    }

    public static void a(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5) {
        e b2 = e.b();
        b2.e = (float) (i2 - (i4 / 2));
        b2.f = (float) (i3 - (i5 / 2));
        drawable.copyBounds(k);
        Rect rect = k;
        int i6 = rect.left;
        int i7 = rect.top;
        drawable.setBounds(i6, i7, i6 + i4, i4 + i7);
        int save = canvas.save();
        canvas.translate(b2.e, b2.f);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void a(Canvas canvas, String str, float f2, float f3, Paint paint, e eVar, float f4) {
        float fontMetrics = paint.getFontMetrics(m);
        paint.getTextBounds(str, 0, str.length(), l);
        float f5 = 0.0f - ((float) l.left);
        float f6 = (-m.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f4 != 0.0f) {
            float width = f5 - (((float) l.width()) * 0.5f);
            float f7 = f6 - (fontMetrics * 0.5f);
            if (!(eVar.e == 0.5f && eVar.f == 0.5f)) {
                a a2 = a((float) l.width(), fontMetrics, f4);
                f2 -= a2.d * (eVar.e - 0.5f);
                f3 -= a2.e * (eVar.f - 0.5f);
                a.a(a2);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.drawText(str, width, f7, paint);
            canvas.restore();
        } else {
            if (!(eVar.e == 0.0f && eVar.f == 0.0f)) {
                f5 -= ((float) l.width()) * eVar.e;
                f6 -= fontMetrics * eVar.f;
            }
            canvas.drawText(str, f5 + f2, f6 + f3, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static a a(float f2, float f3, float f4) {
        return b(f2, f3, f4 * 0.017453292f);
    }
}
