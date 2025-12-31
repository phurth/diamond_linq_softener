package androidx.appcompat.widget;

import android.view.View;

/* renamed from: androidx.appcompat.widget.fa  reason: case insensitive filesystem */
class C0096fa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f596a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0098ga f597b;

    C0096fa(C0098ga gaVar, View view) {
        this.f597b = gaVar;
        this.f596a = view;
    }

    public void run() {
        this.f597b.smoothScrollTo(this.f596a.getLeft() - ((this.f597b.getWidth() - this.f596a.getWidth()) / 2), 0);
        this.f597b.f604b = null;
    }
}
