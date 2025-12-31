package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f996a;

    z(RecyclerView recyclerView) {
        this.f996a = recyclerView;
    }

    public void run() {
        RecyclerView.f fVar = this.f996a.W;
        if (fVar != null) {
            fVar.i();
        }
        this.f996a.xa = false;
    }
}
