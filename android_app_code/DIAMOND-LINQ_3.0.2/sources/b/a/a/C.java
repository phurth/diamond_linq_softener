package b.a.a;

import android.util.Base64;
import java.nio.charset.StandardCharsets;

public final class C {
    public static String a(String str) {
        String str2 = new String(Base64.decode(str.getBytes(StandardCharsets.UTF_8), 2));
        return str2.startsWith("CsiEncoded.") ? str2.substring(11) : str2;
    }

    static String b(String str) {
        return Base64.encodeToString(("CsiEncoded." + str).getBytes(StandardCharsets.UTF_8), 2);
    }

    public static boolean c(String str) {
        if (ia.a(str)) {
            return false;
        }
        try {
            str = new String(Base64.decode(str.getBytes(StandardCharsets.UTF_8), 2));
        } catch (Exception unused) {
        }
        return str.startsWith("CsiEncoded.");
    }
}
