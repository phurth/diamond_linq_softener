package a.n;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class X implements Y {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f297a;

    X(View view) {
        this.f297a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f297a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f297a.remove(drawable);
    }
}
