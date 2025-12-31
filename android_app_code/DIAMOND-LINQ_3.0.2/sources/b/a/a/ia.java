package b.a.a;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public final class ia {

    /* renamed from: a  reason: collision with root package name */
    private static final DecimalFormat f1156a = new DecimalFormat("#,###,##0.00");

    public static boolean a(String str) {
        return str == null || b(str.trim());
    }

    static boolean b(String str) {
        return str == null || str.isEmpty();
    }

    public static String c(int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(instance.getTimeInMillis());
        instance.set(5, (instance.get(5) - 1) - 61);
        instance.add(5, i);
        instance.getTime();
        return String.valueOf(instance.get(2) + 1).concat("/").concat(b(instance.get(5))).concat("/").concat(String.valueOf(instance.get(1)));
    }

    public static String a(int i) {
        NumberFormat integerInstance = DecimalFormat.getIntegerInstance(Locale.ENGLISH);
        integerInstance.setGroupingUsed(true);
        return integerInstance.format((long) i);
    }

    public static String b(int i) {
        return i < 10 ? "0".concat(String.valueOf(i)) : String.valueOf(i);
    }

    public static String a(double d) {
        return f1156a.format(d);
    }

    public static String a(String str, byte[] bArr, int i) {
        return new StringBuilder().toString();
    }
}
