package androidx.appcompat.widget;

import android.view.View;

/* renamed from: androidx.appcompat.widget.ka  reason: case insensitive filesystem */
class C0106ka implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f616a;

    C0106ka(SearchView searchView) {
        this.f616a = searchView;
    }

    public void onFocusChange(View view, boolean z) {
        SearchView searchView = this.f616a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.N;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z);
        }
    }
}
