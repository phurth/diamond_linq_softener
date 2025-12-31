package androidx.savedstate;

import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.l;

class SavedStateRegistry$1 implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f998a;

    SavedStateRegistry$1(a aVar) {
        this.f998a = aVar;
    }

    public void a(l lVar, h.a aVar) {
        if (aVar == h.a.ON_START) {
            this.f998a.d = true;
        } else if (aVar == h.a.ON_STOP) {
            this.f998a.d = false;
        }
    }
}
