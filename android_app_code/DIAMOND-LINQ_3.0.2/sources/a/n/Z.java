package a.n;

import android.util.Property;
import android.view.View;

class Z extends Property<View, Float> {
    Z(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public Float get(View view) {
        return Float.valueOf(ba.c(view));
    }

    /* renamed from: a */
    public void set(View view, Float f) {
        ba.a(view, f.floatValue());
    }
}
