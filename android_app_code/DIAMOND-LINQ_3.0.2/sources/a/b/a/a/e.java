package a.b.a.a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class e extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f41a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f42b = Executors.newFixedThreadPool(4, new d(this));
    private volatile Handler c;

    public void a(Runnable runnable) {
        this.f42b.execute(runnable);
    }

    public void b(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.f41a) {
                if (this.c == null) {
                    this.c = a(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }

    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private static Handler a(Looper looper) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return Handler.createAsync(looper);
        }
        if (i >= 16) {
            Class<Handler> cls = Handler.class;
            try {
                return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, true});
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }
}
