package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

class qa implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f634a;

    qa(SearchView searchView) {
        this.f634a = searchView;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.f634a.d(i);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
