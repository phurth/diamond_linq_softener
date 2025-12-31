package androidx.lifecycle;

class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LiveData f876a;

    q(LiveData liveData) {
        this.f876a = liveData;
    }

    public void run() {
        Object obj;
        synchronized (this.f876a.f852b) {
            obj = this.f876a.f;
            this.f876a.f = LiveData.f851a;
        }
        this.f876a.a(obj);
    }
}
