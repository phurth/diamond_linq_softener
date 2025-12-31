package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.l;

class ComponentActivity$1 implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f358a;

    ComponentActivity$1(a aVar) {
        this.f358a = aVar;
    }

    public void a(l lVar, h.a aVar) {
        if (aVar == h.a.ON_STOP) {
            Window window = this.f358a.getWindow();
            View peekDecorView = window != null ? window.peekDecorView() : null;
            if (peekDecorView != null) {
                peekDecorView.cancelPendingInputEvents();
            }
        }
    }
}
