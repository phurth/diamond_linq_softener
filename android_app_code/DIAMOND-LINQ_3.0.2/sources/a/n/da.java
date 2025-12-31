package a.n;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class da extends ca {
    private static Method e;
    private static boolean f;
    private static Method g;
    private static boolean h;

    da() {
    }

    private void c() {
        if (!f) {
            try {
                e = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                e.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
            }
            f = true;
        }
    }

    private void d() {
        if (!h) {
            try {
                g = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                g.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
            }
            h = true;
        }
    }

    public void a(View view, Matrix matrix) {
        c();
        Method method = e;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void b(View view, Matrix matrix) {
        d();
        Method method = g;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
