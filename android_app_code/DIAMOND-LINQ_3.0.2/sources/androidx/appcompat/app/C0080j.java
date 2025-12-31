package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.j  reason: case insensitive filesystem */
class C0080j implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertController f417a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AlertController.a f418b;

    C0080j(AlertController.a aVar, AlertController alertController) {
        this.f418b = aVar;
        this.f417a = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f418b.x.onClick(this.f417a.f372b, i);
        if (!this.f418b.H) {
            this.f417a.f372b.dismiss();
        }
    }
}
