package com.google.android.material.floatingactionbutton;

import android.util.Property;
import android.view.View;

class g extends Property<View, Float> {
    g(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public void set(View view, Float f) {
        ((ExtendedFloatingActionButton) view).setCornerRadius(f.intValue());
    }

    /* renamed from: a */
    public Float get(View view) {
        return Float.valueOf((float) ((ExtendedFloatingActionButton) view).getCornerRadius());
    }
}
