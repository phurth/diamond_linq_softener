package a.g.i;

import android.view.View;
import android.view.ViewTreeObserver;

public final class r implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f230a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f231b;
    private final Runnable c;

    private r(View view, Runnable runnable) {
        this.f230a = view;
        this.f231b = view.getViewTreeObserver();
        this.c = runnable;
    }

    public static r a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        } else if (runnable != null) {
            r rVar = new r(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(rVar);
            view.addOnAttachStateChangeListener(rVar);
            return rVar;
        } else {
            throw new NullPointerException("runnable == null");
        }
    }

    public boolean onPreDraw() {
        a();
        this.c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f231b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }

    public void a() {
        if (this.f231b.isAlive()) {
            this.f231b.removeOnPreDrawListener(this);
        } else {
            this.f230a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f230a.removeOnAttachStateChangeListener(this);
    }
}
