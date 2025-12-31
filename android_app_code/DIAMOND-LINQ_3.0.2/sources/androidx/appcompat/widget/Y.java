package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

class Y implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Z f573a;

    Y(Z z) {
        this.f573a = z;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        T t;
        if (i != -1 && (t = this.f573a.f) != null) {
            t.setListSelectionHidden(false);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
