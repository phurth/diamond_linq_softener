package b.a.a.c;

import android.content.Context;
import java.util.UUID;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private static final UUID f1111a = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* renamed from: b  reason: collision with root package name */
    private final Class<? extends C> f1112b;
    private final Context c;
    private final UUID d = f1111a;

    public s(Class<? extends C> cls, Context context) {
        this.f1112b = cls;
        this.c = context;
    }

    public static boolean a(Context context) {
        return b(context) || c(context);
    }

    private static boolean b(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    private static boolean c(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public Context a() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public UUID b() {
        return this.d;
    }
}
