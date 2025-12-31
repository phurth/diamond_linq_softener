package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

class i {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f868a = new AtomicBoolean(false);

    static class a extends C0147c {
        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            z.b(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static void a(Context context) {
        if (!f868a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
        }
    }
}
