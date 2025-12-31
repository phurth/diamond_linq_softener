package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;

/* renamed from: androidx.appcompat.app.f  reason: case insensitive filesystem */
class C0076f implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f409a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f410b;
    final /* synthetic */ AlertController c;

    C0076f(AlertController alertController, View view, View view2) {
        this.c = alertController;
        this.f409a = view;
        this.f410b = view2;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlertController.a(absListView, this.f409a, this.f410b);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
