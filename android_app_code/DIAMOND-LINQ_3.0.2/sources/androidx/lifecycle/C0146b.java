package androidx.lifecycle;

import androidx.lifecycle.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.b  reason: case insensitive filesystem */
class C0146b {

    /* renamed from: a  reason: collision with root package name */
    static C0146b f858a = new C0146b();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class, a> f859b = new HashMap();
    private final Map<Class, Boolean> c = new HashMap();

    /* renamed from: androidx.lifecycle.b$b  reason: collision with other inner class name */
    static class C0026b {

        /* renamed from: a  reason: collision with root package name */
        final int f862a;

        /* renamed from: b  reason: collision with root package name */
        final Method f863b;

        C0026b(int i, Method method) {
            this.f862a = i;
            this.f863b = method;
            this.f863b.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, h.a aVar, Object obj) {
            try {
                int i = this.f862a;
                if (i == 0) {
                    this.f863b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f863b.invoke(obj, new Object[]{lVar});
                } else if (i == 2) {
                    this.f863b.invoke(obj, new Object[]{lVar, aVar});
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0026b.class != obj.getClass()) {
                return false;
            }
            C0026b bVar = (C0026b) obj;
            if (this.f862a != bVar.f862a || !this.f863b.getName().equals(bVar.f863b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f862a * 31) + this.f863b.getName().hashCode();
        }
    }

    C0146b() {
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public a a(Class cls) {
        a aVar = this.f859b.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean b(Class cls) {
        Boolean bool = this.c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c2 = c(cls);
        for (Method annotation : c2) {
            if (((u) annotation.getAnnotation(u.class)) != null) {
                a(cls, c2);
                return true;
            }
        }
        this.c.put(cls, false);
        return false;
    }

    /* renamed from: androidx.lifecycle.b$a */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map<h.a, List<C0026b>> f860a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<C0026b, h.a> f861b;

        a(Map<C0026b, h.a> map) {
            this.f861b = map;
            for (Map.Entry next : map.entrySet()) {
                h.a aVar = (h.a) next.getValue();
                List list = this.f860a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f860a.put(aVar, list);
                }
                list.add(next.getKey());
            }
        }

        /* access modifiers changed from: package-private */
        public void a(l lVar, h.a aVar, Object obj) {
            a(this.f860a.get(aVar), lVar, aVar, obj);
            a(this.f860a.get(h.a.ON_ANY), lVar, aVar, obj);
        }

        private static void a(List<C0026b> list, l lVar, h.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lVar, aVar, obj);
                }
            }
        }
    }

    private void a(Map<C0026b, h.a> map, C0026b bVar, h.a aVar, Class cls) {
        h.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f863b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private a a(Class cls, Method[] methodArr) {
        int i;
        a a2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (a2 = a(superclass)) == null)) {
            hashMap.putAll(a2.f861b);
        }
        for (Class a3 : cls.getInterfaces()) {
            for (Map.Entry next : a(a3).f861b.entrySet()) {
                a(hashMap, (C0026b) next.getKey(), (h.a) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            u uVar = (u) method.getAnnotation(u.class);
            if (uVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(l.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                h.a value = uVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(h.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == h.a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new C0026b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f859b.put(cls, aVar);
        this.c.put(cls, Boolean.valueOf(z));
        return aVar;
    }
}
