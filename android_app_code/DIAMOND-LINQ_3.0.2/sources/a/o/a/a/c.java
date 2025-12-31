package a.o.a.a;

import android.graphics.drawable.Drawable;

class c implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f338a;

    c(d dVar) {
        this.f338a = dVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f338a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f338a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f338a.unscheduleSelf(runnable);
    }
}
