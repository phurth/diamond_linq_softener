package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

class pa implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f631a;

    pa(SearchView searchView) {
        this.f631a = searchView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f631a.a(i, 0, (String) null);
    }
}
