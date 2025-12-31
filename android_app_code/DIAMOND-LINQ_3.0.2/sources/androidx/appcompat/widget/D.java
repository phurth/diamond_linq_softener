package androidx.appcompat.widget;

import android.os.Build;
import android.view.ViewTreeObserver;

class D implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E f503a;

    D(E e) {
        this.f503a = e;
    }

    public void onGlobalLayout() {
        if (!this.f503a.getInternalPopup().c()) {
            this.f503a.a();
        }
        ViewTreeObserver viewTreeObserver = this.f503a.getViewTreeObserver();
        if (viewTreeObserver == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }
}
