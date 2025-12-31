package androidx.core.app;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f723a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Object f724b;

    d(Object obj, Object obj2) {
        this.f723a = obj;
        this.f724b = obj2;
    }

    public void run() {
        try {
            if (e.d != null) {
                e.d.invoke(this.f723a, new Object[]{this.f724b, false, "AppCompat recreation"});
                return;
            }
            e.e.invoke(this.f723a, new Object[]{this.f724b, false});
        } catch (RuntimeException e) {
            if (e.getClass() != RuntimeException.class || e.getMessage() == null || !e.getMessage().startsWith("Unable to stop")) {
                e.a((Throwable) e);
                return;
            }
            throw e;
        } catch (Throwable th) {
            e.a(th);
        }
    }
}
