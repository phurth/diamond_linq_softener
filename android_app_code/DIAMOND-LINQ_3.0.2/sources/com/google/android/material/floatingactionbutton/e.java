package com.google.android.material.floatingactionbutton;

import android.util.Property;
import android.view.View;

class e extends Property<View, Float> {
    e(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public void set(View view, Float f) {
        view.getLayoutParams().width = f.intValue();
        view.requestLayout();
    }

    /* renamed from: a */
    public Float get(View view) {
        return Float.valueOf((float) view.getLayoutParams().width);
    }
}
