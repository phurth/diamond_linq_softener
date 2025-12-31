package b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

public final class ma {

    /* renamed from: a  reason: collision with root package name */
    private static final C0176ca f1166a = C0176ca.Standard;

    public static String a() {
        return "1234";
    }

    public static void a(Context context, boolean z) {
        SharedPreferences e;
        if (context != null && (e = e(context)) != null) {
            e.edit().putBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.intro_shown", z).apply();
        }
    }

    public static boolean b(Context context) {
        SharedPreferences e;
        if (context == null || (e = e(context)) == null) {
            return false;
        }
        return e.getBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.intro_shown", false);
    }

    public static C0176ca c(Context context) {
        SharedPreferences e;
        if (context == null || (e = e(context)) == null) {
            return f1166a;
        }
        return C0176ca.a(e.getInt("com.ChandlerSystemsInc.signatureAppCore.controllers.unit_type", f1166a.a()));
    }

    public static boolean d(Context context) {
        SharedPreferences e;
        if (context == null || (e = e(context)) == null) {
            return false;
        }
        return e.getBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.session_started", false);
    }

    private static SharedPreferences e(Context context) {
        if (context != null) {
            return context.getApplicationContext().getSharedPreferences("com.ChandlerSystemsInc.signatureAppCore.controllers.cs_valve_prefs", 0);
        }
        return null;
    }

    public static void a(Context context, C0176ca caVar) {
        SharedPreferences e;
        if (context != null && (e = e(context)) != null) {
            e.edit().putInt("com.ChandlerSystemsInc.signatureAppCore.controllers.unit_type", caVar.a()).apply();
        }
    }

    public static void b(Context context, boolean z) {
        SharedPreferences e;
        if (context != null && (e = e(context)) != null) {
            e.edit().putBoolean("com.ChandlerSystemsInc.signatureAppCore.controllers.session_started", z).apply();
        }
    }

    public static void c(Context context, int i) {
        SharedPreferences e;
        if (context != null && (e = e(context)) != null) {
            e.edit().putInt("FW-".concat("inAppFirmwareVersion4x"), i).apply();
        }
    }

    public static void a(Context context, int i) {
        SharedPreferences e;
        if (context != null && (e = e(context)) != null) {
            e.edit().putInt("FW-".concat("inAppFirmwareVersion2x"), i).apply();
        }
    }

    public static void b(Context context, int i) {
        SharedPreferences e;
        if (context != null && (e = e(context)) != null) {
            e.edit().putInt("FW-".concat("inAppFirmwareVersion3x"), i).apply();
        }
    }

    public static String a(Context context, String str) {
        SharedPreferences e;
        if (context == null || (e = e(context)) == null) {
            return "1234";
        }
        String string = e.getString("PWD-".concat(str), "1234");
        if (string == null) {
            return "1234";
        }
        return string;
    }

    public static void b(Context context, String str, String str2) {
        SharedPreferences e;
        if (context != null && (e = e(context)) != null) {
            e.edit().putString("PWD-".concat(str), str2).apply();
        }
    }

    public static HashMap<String, String> a(Context context) {
        SharedPreferences e;
        HashMap<String, String> hashMap = new HashMap<>();
        if (!(context == null || (e = e(context)) == null)) {
            for (Map.Entry next : e.getAll().entrySet()) {
                if (((String) next.getKey()).startsWith("ALIAS-")) {
                    hashMap.put(((String) next.getKey()).substring(6), next.getValue().toString());
                }
            }
        }
        return hashMap;
    }

    public static void b(Context context, String str) {
        SharedPreferences e;
        if (context != null && (e = e(context)) != null) {
            e.edit().remove("ALIAS-".concat(str)).apply();
        }
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences e;
        if (context != null && (e = e(context)) != null) {
            e.edit().putString("ALIAS-".concat(str), str2).apply();
        }
    }
}
