package androidx.fragment.app;

import a.d.i;
import androidx.fragment.app.C0132h;
import java.lang.reflect.InvocationTargetException;

/* renamed from: androidx.fragment.app.m  reason: case insensitive filesystem */
public class C0137m {

    /* renamed from: a  reason: collision with root package name */
    private static final i<String, Class<?>> f809a = new i<>();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return C0132h.class.isAssignableFrom(d(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class<? extends C0132h> c(ClassLoader classLoader, String str) {
        try {
            return d(classLoader, str);
        } catch (ClassNotFoundException e) {
            throw new C0132h.b("Unable to instantiate fragment " + str + ": make sure class name exists", e);
        } catch (ClassCastException e2) {
            throw new C0132h.b("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        }
    }

    private static Class<?> d(ClassLoader classLoader, String str) {
        Class<?> cls = f809a.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> loadClass = classLoader.loadClass(str);
        f809a.put(str, loadClass);
        return loadClass;
    }

    public C0132h a(ClassLoader classLoader, String str) {
        try {
            return (C0132h) c(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e) {
            throw new C0132h.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new C0132h.b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new C0132h.b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new C0132h.b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
