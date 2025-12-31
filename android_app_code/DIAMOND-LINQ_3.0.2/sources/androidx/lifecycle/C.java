package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.C0134j;
import androidx.lifecycle.B;

public class C {
    private static Application a(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    public static B a(C0134j jVar) {
        return a(jVar, (B.b) null);
    }

    public static B a(C0134j jVar, B.b bVar) {
        Application a2 = a((Activity) jVar);
        if (bVar == null) {
            bVar = B.a.a(a2);
        }
        return new B(jVar.c(), bVar);
    }
}
