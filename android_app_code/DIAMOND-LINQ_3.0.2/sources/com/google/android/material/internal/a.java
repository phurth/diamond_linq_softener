package com.google.android.material.internal;

import a.g.i.C0037a;
import a.g.i.a.c;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

class a extends C0037a {
    final /* synthetic */ CheckableImageButton d;

    a(CheckableImageButton checkableImageButton) {
        this.d = checkableImageButton;
    }

    public void a(View view, c cVar) {
        super.a(view, cVar);
        cVar.b(true);
        cVar.c(this.d.isChecked());
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.d.isChecked());
    }
}
