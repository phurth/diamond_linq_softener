package com.google.android.material.internal;

import android.widget.ImageButton;

public class u extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    private int f1533a;

    public final void a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f1533a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f1533a;
    }

    public void setVisibility(int i) {
        a(i, true);
    }
}
