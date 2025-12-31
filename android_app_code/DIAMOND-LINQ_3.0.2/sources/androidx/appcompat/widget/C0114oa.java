package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: androidx.appcompat.widget.oa  reason: case insensitive filesystem */
class C0114oa implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f628a;

    C0114oa(SearchView searchView) {
        this.f628a = searchView;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f628a.g();
        return true;
    }
}
