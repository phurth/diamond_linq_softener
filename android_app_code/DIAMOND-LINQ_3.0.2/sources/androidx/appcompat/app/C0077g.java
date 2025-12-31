package androidx.appcompat.app;

import android.view.View;

/* renamed from: androidx.appcompat.app.g  reason: case insensitive filesystem */
class C0077g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f411a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f412b;
    final /* synthetic */ AlertController c;

    C0077g(AlertController alertController, View view, View view2) {
        this.c = alertController;
        this.f411a = view;
        this.f412b = view2;
    }

    public void run() {
        AlertController.a(this.c.g, this.f411a, this.f412b);
    }
}
