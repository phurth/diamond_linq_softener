package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class a extends a.g.a.a {
    private static b c;

    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    public interface C0023a {
    }

    public interface b {
        boolean a(Activity activity, int i, int i2, Intent intent);
    }

    public interface c {
    }

    public static b a() {
        return c;
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else if (!e.a(activity)) {
            activity.recreate();
        }
    }

    public static void a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }
}
