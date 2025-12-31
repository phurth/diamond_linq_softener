package a.n;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class ba {

    /* renamed from: a  reason: collision with root package name */
    private static final fa f298a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f299b;
    private static boolean c;
    static final Property<View, Float> d = new Z(Float.class, "translationAlpha");
    static final Property<View, Rect> e = new aa(Rect.class, "clipBounds");

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 22) {
            f298a = new ea();
        } else if (i >= 21) {
            f298a = new da();
        } else if (i >= 19) {
            f298a = new ca();
        } else {
            f298a = new fa();
        }
    }

    static void a(View view, float f) {
        f298a.a(view, f);
    }

    static Y b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new X(view);
        }
        return W.c(view);
    }

    static float c(View view) {
        return f298a.b(view);
    }

    static ka d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ja(view);
        }
        return new ia(view.getWindowToken());
    }

    static void e(View view) {
        f298a.c(view);
    }

    static void a(View view) {
        f298a.a(view);
    }

    static void a(View view, int i) {
        a();
        Field field = f299b;
        if (field != null) {
            try {
                f299b.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    static void b(View view, Matrix matrix) {
        f298a.b(view, matrix);
    }

    static void a(View view, Matrix matrix) {
        f298a.a(view, matrix);
    }

    static void a(View view, int i, int i2, int i3, int i4) {
        f298a.a(view, i, i2, i3, i4);
    }

    private static void a() {
        if (!c) {
            try {
                f299b = View.class.getDeclaredField("mViewFlags");
                f299b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            c = true;
        }
    }
}
