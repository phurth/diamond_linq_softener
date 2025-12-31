package b.c.a.a.g;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

public class a {
    public static int a(View view, int i) {
        return b.c.a.a.m.a.a(view, i).data;
    }

    public static int a(Context context, int i, int i2) {
        TypedValue a2 = b.c.a.a.m.a.a(context, i);
        return a2 != null ? a2.data : i2;
    }

    public static int a(int i, int i2, float f) {
        return a(i, a.g.b.a.b(i2, Math.round(((float) Color.alpha(i2)) * f)));
    }

    public static int a(int i, int i2) {
        return a.g.b.a.a(i2, i);
    }
}
