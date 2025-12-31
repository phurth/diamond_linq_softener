package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

class c extends FloatingActionButton.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1460a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BottomAppBar f1461b;

    c(BottomAppBar bottomAppBar, int i) {
        this.f1461b = bottomAppBar;
        this.f1460a = i;
    }

    public void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.setTranslationX(this.f1461b.d(this.f1460a));
        floatingActionButton.b((FloatingActionButton.a) new b(this));
    }
}
