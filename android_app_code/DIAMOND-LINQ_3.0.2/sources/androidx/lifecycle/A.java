package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public abstract class A {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f840a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f841b = false;

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f841b = true;
        ConcurrentHashMap<String, Object> concurrentHashMap = this.f840a;
        if (concurrentHashMap != null) {
            for (Object a2 : concurrentHashMap.values()) {
                a(a2);
            }
        }
        b();
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    private static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
