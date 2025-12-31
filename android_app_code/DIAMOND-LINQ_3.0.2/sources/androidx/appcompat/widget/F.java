package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.E;

class F implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E f513a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ E.c f514b;

    F(E.c cVar, E e) {
        this.f514b = cVar;
        this.f513a = e;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        E.this.setSelection(i);
        if (E.this.getOnItemClickListener() != null) {
            E.c cVar = this.f514b;
            E.this.performItemClick(view, i, cVar.L.getItemId(i));
        }
        this.f514b.dismiss();
    }
}
