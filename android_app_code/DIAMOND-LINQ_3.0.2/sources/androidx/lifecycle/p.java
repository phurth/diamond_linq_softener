package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.log.BuildConfig;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class, Integer> f874a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class, List<Constructor<? extends f>>> f875b = new HashMap();

    static j a(Object obj) {
        boolean z = obj instanceof j;
        boolean z2 = obj instanceof C0148d;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((C0148d) obj, (j) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((C0148d) obj, (j) null);
        }
        if (z) {
            return (j) obj;
        }
        Class<?> cls = obj.getClass();
        if (b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f875b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        f[] fVarArr = new f[list.size()];
        for (int i = 0; i < list.size(); i++) {
            fVarArr[i] = a((Constructor) list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(fVarArr);
    }

    private static int b(Class<?> cls) {
        Integer num = f874a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int d = d(cls);
        f874a.put(cls, Integer.valueOf(d));
        return d;
    }

    private static boolean c(Class<?> cls) {
        return cls != null && k.class.isAssignableFrom(cls);
    }

    private static int d(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends f> a2 = a(cls);
        if (a2 != null) {
            f875b.put(cls, Collections.singletonList(a2));
            return 2;
        } else if (C0146b.f858a.b(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (c(superclass)) {
                if (b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f875b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (c(cls2)) {
                    if (b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f875b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f875b.put(cls, arrayList);
            return 2;
        }
    }

    private static f a(Constructor<? extends f> constructor, Object obj) {
        try {
            return (f) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Constructor<? extends f> a(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : BuildConfig.FLAVOR;
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a2 = a(canonicalName);
            if (!name.isEmpty()) {
                a2 = name + "." + a2;
            }
            Constructor<?> declaredConstructor = Class.forName(a2).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static String a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
