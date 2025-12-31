package androidx.appcompat.widget;

import android.view.View;

/* renamed from: androidx.appcompat.widget.ma  reason: case insensitive filesystem */
class C0110ma implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f622a;

    C0110ma(SearchView searchView) {
        this.f622a = searchView;
    }

    public void onClick(View view) {
        SearchView searchView = this.f622a;
        if (view == searchView.u) {
            searchView.f();
        } else if (view == searchView.w) {
            searchView.e();
        } else if (view == searchView.v) {
            searchView.g();
        } else if (view == searchView.x) {
            searchView.i();
        } else if (view == searchView.q) {
            searchView.c();
        }
    }
}
