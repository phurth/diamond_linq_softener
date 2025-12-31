package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* renamed from: androidx.appcompat.app.k  reason: case insensitive filesystem */
class C0081k implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AlertController.RecycleListView f419a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AlertController f420b;
    final /* synthetic */ AlertController.a c;

    C0081k(AlertController.a aVar, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.c = aVar;
        this.f419a = recycleListView;
        this.f420b = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean[] zArr = this.c.F;
        if (zArr != null) {
            zArr[i] = this.f419a.isItemChecked(i);
        }
        this.c.J.onClick(this.f420b.f372b, i, this.f419a.isItemChecked(i));
    }
}
