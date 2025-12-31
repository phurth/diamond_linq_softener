package b.c.a.a.i;

import android.content.Context;
import b.c.a.a.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1307a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1308b;
    private final int c;
    private final float d;

    public a(Context context) {
        this.f1307a = b.c.a.a.m.a.b(context, b.elevationOverlaysEnabled);
        this.f1308b = b.c.a.a.g.a.a(context, b.elevationOverlaysColor, 0);
        this.c = b.c.a.a.g.a.a(context, b.colorSurface, 0);
        this.d = context.getResources().getDisplayMetrics().density;
    }

    public int a(int i, float f) {
        return b.c.a.a.g.a.a(i, this.f1308b, a(f));
    }

    public int b(int i, float f) {
        return (!this.f1307a || !a(i)) ? i : a(i, f);
    }

    public float a(float f) {
        float f2 = this.d;
        if (f2 <= 0.0f || f <= 0.0f) {
            return 0.0f;
        }
        return Math.min((((float) Math.log1p((double) (f / f2))) * 4.5f) / 100.0f, 1.0f);
    }

    private boolean a(int i) {
        return a.g.b.a.b(i, 255) == this.c;
    }
}
