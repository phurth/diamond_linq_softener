package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.view.View;

/* renamed from: androidx.appcompat.widget.na  reason: case insensitive filesystem */
class C0112na implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f625a;

    C0112na(SearchView searchView) {
        this.f625a = searchView;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        SearchView searchView = this.f625a;
        if (searchView.ga == null) {
            return false;
        }
        if (searchView.q.isPopupShowing() && this.f625a.q.getListSelection() != -1) {
            return this.f625a.a(view, i, keyEvent);
        }
        if (this.f625a.q.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
            return false;
        }
        view.cancelLongPress();
        SearchView searchView2 = this.f625a;
        searchView2.a(0, (String) null, searchView2.q.getText().toString());
        return true;
    }
}
