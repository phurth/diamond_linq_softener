package androidx.fragment.app;

import android.graphics.Paint;
import androidx.fragment.app.w;

class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w.a f823a;

    v(w.a aVar) {
        this.f823a = aVar;
    }

    public void run() {
        this.f823a.f824b.setLayerType(0, (Paint) null);
    }
}
