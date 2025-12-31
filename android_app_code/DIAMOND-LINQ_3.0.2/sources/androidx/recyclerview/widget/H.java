package androidx.recyclerview.widget;

import a.g.i.C0037a;
import a.g.i.a.c;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class H extends C0037a {
    final RecyclerView d;
    final C0037a e = new a(this);

    public H(RecyclerView recyclerView) {
        this.d = recyclerView;
    }

    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (c() || this.d.getLayoutManager() == null) {
            return false;
        }
        return this.d.getLayoutManager().a(i, bundle);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return this.d.j();
    }

    public void a(View view, c cVar) {
        super.a(view, cVar);
        if (!c() && this.d.getLayoutManager() != null) {
            this.d.getLayoutManager().a(cVar);
        }
    }

    public static class a extends C0037a {
        final H d;

        public a(H h) {
            this.d = h;
        }

        public void a(View view, c cVar) {
            super.a(view, cVar);
            if (!this.d.c() && this.d.d.getLayoutManager() != null) {
                this.d.d.getLayoutManager().a(view, cVar);
            }
        }

        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (this.d.c() || this.d.d.getLayoutManager() == null) {
                return false;
            }
            return this.d.d.getLayoutManager().a(view, i, bundle);
        }
    }

    public C0037a b() {
        return this.e;
    }
}
