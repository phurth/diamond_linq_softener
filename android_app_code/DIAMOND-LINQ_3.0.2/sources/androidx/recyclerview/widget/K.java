package androidx.recyclerview.widget;

class K implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StaggeredGridLayoutManager f891a;

    K(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f891a = staggeredGridLayoutManager;
    }

    public void run() {
        this.f891a.F();
    }
}
