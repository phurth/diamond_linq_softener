package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

class b extends ViewOutlineProvider {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Chip f1482a;

    b(Chip chip) {
        this.f1482a = chip;
    }

    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        if (this.f1482a.f != null) {
            this.f1482a.f.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
