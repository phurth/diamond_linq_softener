package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class B {

    /* renamed from: a  reason: collision with root package name */
    private final b f842a;

    /* renamed from: b  reason: collision with root package name */
    private final D f843b;

    public interface b {
        <T extends A> T a(Class<T> cls);
    }

    static abstract class c implements b {
        c() {
        }

        public <T extends A> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends A> T a(String str, Class<T> cls);
    }

    public static class d implements b {
        public <T extends A> T a(Class<T> cls) {
            try {
                return (A) cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    public B(D d2, b bVar) {
        this.f842a = bVar;
        this.f843b = d2;
    }

    public <T extends A> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public static class a extends d {

        /* renamed from: a  reason: collision with root package name */
        private static a f844a;

        /* renamed from: b  reason: collision with root package name */
        private Application f845b;

        public a(Application application) {
            this.f845b = application;
        }

        public static a a(Application application) {
            if (f844a == null) {
                f844a = new a(application);
            }
            return f844a;
        }

        public <T extends A> T a(Class<T> cls) {
            if (!C0145a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                return (A) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.f845b});
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }

    public <T extends A> T a(String str, Class<T> cls) {
        T t;
        T a2 = this.f843b.a(str);
        if (cls.isInstance(a2)) {
            return a2;
        }
        b bVar = this.f842a;
        if (bVar instanceof c) {
            t = ((c) bVar).a(str, cls);
        } else {
            t = bVar.a(cls);
        }
        this.f843b.a(str, t);
        return t;
    }
}
