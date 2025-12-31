package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.C0151b;
import androidx.recyclerview.widget.RecyclerView;

class C implements C0151b.C0028b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView f885a;

    C(RecyclerView recyclerView) {
        this.f885a = recyclerView;
    }

    public int a() {
        return this.f885a.getChildCount();
    }

    public int b(View view) {
        return this.f885a.indexOfChild(view);
    }

    public void c(int i) {
        View childAt = this.f885a.getChildAt(i);
        if (childAt != null) {
            this.f885a.b(childAt);
            childAt.clearAnimation();
        }
        this.f885a.removeViewAt(i);
    }

    public void d(View view) {
        RecyclerView.x g = RecyclerView.g(view);
        if (g != null) {
            g.b(this.f885a);
        }
    }

    public void a(View view, int i) {
        this.f885a.addView(view, i);
        this.f885a.a(view);
    }

    public void b() {
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            View a3 = a(i);
            this.f885a.b(a3);
            a3.clearAnimation();
        }
        this.f885a.removeAllViews();
    }

    public View a(int i) {
        return this.f885a.getChildAt(i);
    }

    public void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        RecyclerView.x g = RecyclerView.g(view);
        if (g != null) {
            if (g.s() || g.y()) {
                g.d();
            } else {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + g + this.f885a.i());
            }
        }
        this.f885a.attachViewToParent(view, i, layoutParams);
    }

    public RecyclerView.x c(View view) {
        return RecyclerView.g(view);
    }

    public void b(int i) {
        RecyclerView.x g;
        View a2 = a(i);
        if (!(a2 == null || (g = RecyclerView.g(a2)) == null)) {
            if (!g.s() || g.y()) {
                g.a(256);
            } else {
                throw new IllegalArgumentException("called detach on an already detached child " + g + this.f885a.i());
            }
        }
        this.f885a.detachViewFromParent(i);
    }

    public void a(View view) {
        RecyclerView.x g = RecyclerView.g(view);
        if (g != null) {
            g.a(this.f885a);
        }
    }
}
