package com.google.android.material.chip;

import android.graphics.Typeface;
import b.c.a.a.m.g;

class a extends g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Chip f1481a;

    a(Chip chip) {
        this.f1481a = chip;
    }

    public void a(int i) {
    }

    public void a(Typeface typeface, boolean z) {
        Chip chip = this.f1481a;
        chip.setText(chip.f.P() ? this.f1481a.f.G() : this.f1481a.getText());
        this.f1481a.requestLayout();
        this.f1481a.invalidate();
    }
}
