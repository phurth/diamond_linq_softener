package androidx.appcompat.app;

import android.view.View;

/* renamed from: androidx.appcompat.app.e  reason: case insensitive filesystem */
class C0075e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f407a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f408b;
    final /* synthetic */ AlertController c;

    C0075e(AlertController alertController, View view, View view2) {
        this.c = alertController;
        this.f407a = view;
        this.f408b = view2;
    }

    public void run() {
        AlertController.a(this.c.A, this.f407a, this.f408b);
    }
}
