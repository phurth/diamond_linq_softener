package androidx.recyclerview.widget;

class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f995a;

    y(RecyclerView recyclerView) {
        this.f995a = recyclerView;
    }

    public void run() {
        RecyclerView recyclerView = this.f995a;
        if (recyclerView.E && !recyclerView.isLayoutRequested()) {
            RecyclerView recyclerView2 = this.f995a;
            if (!recyclerView2.B) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.H) {
                recyclerView2.G = true;
            } else {
                recyclerView2.b();
            }
        }
    }
}
