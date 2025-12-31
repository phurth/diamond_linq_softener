package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;

class x extends C0147c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f880a;

    x(y yVar) {
        this.f880a = yVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        z.a(activity).a(this.f880a.i);
    }

    public void onActivityPaused(Activity activity) {
        this.f880a.c();
    }

    public void onActivityStopped(Activity activity) {
        this.f880a.f();
    }
}
