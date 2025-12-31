package a.g.i;

import android.view.View;
import android.view.WindowInsets;

class u implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f232a;

    u(q qVar) {
        this.f232a = qVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return (WindowInsets) I.a(this.f232a.a(view, I.a((Object) windowInsets)));
    }
}
