package androidx.appcompat.app;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* renamed from: androidx.appcompat.app.d  reason: case insensitive filesystem */
class C0074d implements NestedScrollView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f405a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f406b;
    final /* synthetic */ AlertController c;

    C0074d(AlertController alertController, View view, View view2) {
        this.c = alertController;
        this.f405a = view;
        this.f406b = view2;
    }

    public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        AlertController.a(nestedScrollView, this.f405a, this.f406b);
    }
}
