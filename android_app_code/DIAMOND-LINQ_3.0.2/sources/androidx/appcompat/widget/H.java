package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.appcompat.widget.E;

class H implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f522a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ E.c f523b;

    H(E.c cVar, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.f523b = cVar;
        this.f522a = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = E.this.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f522a);
        }
    }
}
