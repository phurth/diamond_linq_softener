package b.a.a;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.Toast;
import java.io.InputStream;
import java.util.Locale;

public final class Z {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1060a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1061b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private float h;
    private long i;

    public Z(Context context) {
        this.f1060a = context;
    }

    public static boolean e(int i2) {
        return i2 >= 300 && i2 < 400;
    }

    public static boolean f(int i2) {
        return i2 >= 400;
    }

    public int a() {
        return 217;
    }

    public void a(boolean z) {
        this.d = z;
        this.e = false;
    }

    public int b() {
        return 309;
    }

    public void b(boolean z) {
        this.d = false;
        this.e = z;
    }

    public int c() {
        return 401;
    }

    public String c(int i2) {
        if (f(i2)) {
            return "downloadexternal4x.txt";
        }
        return e(i2) ? "downloadexternal3x.txt" : "downloadexternal2x.txt";
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        return this.f1061b;
    }

    public boolean f() {
        return this.d;
    }

    public InputStream d(int i2) {
        boolean z;
        if (f(i2)) {
            return this.f1060a.getResources().openRawResource(Ea.firmwareexternal4x);
        }
        if (this.c) {
            z = this.d;
        } else {
            z = e(i2);
        }
        return this.f1060a.getResources().openRawResource(z ? Ea.firmwareexternal3x : Ea.firmwareexternal2x);
    }

    public int a(int i2, boolean z) {
        if (f(i2)) {
            return 401;
        }
        if (z || !this.c) {
            if (i2 >= 300) {
                return 309;
            }
            return 217;
        } else if (this.d) {
            return 309;
        } else {
            return 217;
        }
    }

    public String b(int i2) {
        if (f(i2)) {
            return a(i2);
        }
        if (!this.c) {
            return a(i2);
        }
        return a(this.d ? 309 : 217);
    }

    static String a(Context context) {
        return context.getString(Fa.fw_in_app_version, new Object[]{a(217), a(309), a(401)});
    }

    public static String a(int i2) {
        try {
            return String.format(Locale.ENGLISH, "C%d.%02d", new Object[]{Integer.valueOf(i2 / 100), Integer.valueOf(i2 % 100)});
        } catch (Exception unused) {
            return "E0.00";
        }
    }

    public boolean a(MotionEvent motionEvent) {
        String str;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = motionEvent.getY();
            return true;
        } else if (actionMasked != 1) {
            return false;
        } else {
            int i2 = motionEvent.getY() - this.h > 0.0f ? 1 : 0;
            if (System.currentTimeMillis() - this.i >= 3500) {
                this.f = 0;
                this.g = 0;
            }
            this.f += i2;
            this.g += i2 ^ 1;
            String str2 = "enabled.";
            if (this.f >= 10) {
                this.f1061b = !this.f1061b;
                StringBuilder sb = new StringBuilder();
                sb.append("Download menu item ");
                if (this.f1061b) {
                    str = str2;
                } else {
                    str = "disabled.";
                }
                sb.append(str);
                Toast.makeText(this.f1060a, sb.toString(), 1).show();
                this.c = this.f1061b;
                this.f = 0;
            }
            if (this.g >= 5) {
                this.c = !this.c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Firmware crossover mode ");
                if (!this.c) {
                    str2 = "disabled.";
                }
                sb2.append(str2);
                Toast.makeText(this.f1060a, sb2.toString(), 1).show();
                this.g = 0;
            }
            this.i = System.currentTimeMillis();
            return true;
        }
    }
}
