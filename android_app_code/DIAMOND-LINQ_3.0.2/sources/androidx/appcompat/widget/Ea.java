package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.C0083a;

class Ea implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final C0083a f511a = new C0083a(this.f512b.f520a.getContext(), 0, 16908332, 0, 0, this.f512b.i);

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Ga f512b;

    Ea(Ga ga) {
        this.f512b = ga;
    }

    public void onClick(View view) {
        Ga ga = this.f512b;
        Window.Callback callback = ga.l;
        if (callback != null && ga.m) {
            callback.onMenuItemSelected(0, this.f511a);
        }
    }
}
