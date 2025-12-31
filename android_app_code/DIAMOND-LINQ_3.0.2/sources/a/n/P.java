package a.n;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class P implements Q {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f289a;

    P(ViewGroup viewGroup) {
        this.f289a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f289a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f289a.remove(drawable);
    }

    public void a(View view) {
        this.f289a.add(view);
    }

    public void b(View view) {
        this.f289a.remove(view);
    }
}
