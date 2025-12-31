package a.n;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class V {

    /* renamed from: a  reason: collision with root package name */
    private static Method f292a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f293b;

    static void a(ViewGroup viewGroup, boolean z) {
        a();
        Method method = f292a;
        if (method != null) {
            try {
                method.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e) {
                Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", e);
            } catch (InvocationTargetException e2) {
                Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", e2);
            }
        }
    }

    private static void a() {
        if (!f293b) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f292a = cls.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                f292a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e);
            }
            f293b = true;
        }
    }
}
