package a.n;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ca extends fa {

    /* renamed from: a  reason: collision with root package name */
    private static Method f302a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f303b;
    private static Method c;
    private static boolean d;

    ca() {
    }

    public void a(View view) {
    }

    public void a(View view, float f) {
        b();
        Method method = f302a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Float.valueOf(f)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        } else {
            view.setAlpha(f);
        }
    }

    public float b(View view) {
        a();
        Method method = c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return super.b(view);
    }

    public void c(View view) {
    }

    private void a() {
        if (!d) {
            try {
                c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                c.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e);
            }
            d = true;
        }
    }

    private void b() {
        if (!f303b) {
            Class<View> cls = View.class;
            try {
                f302a = cls.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                f302a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e);
            }
            f303b = true;
        }
    }
}
