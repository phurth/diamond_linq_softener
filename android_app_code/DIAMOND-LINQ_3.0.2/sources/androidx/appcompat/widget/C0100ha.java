package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: androidx.appcompat.widget.ha  reason: case insensitive filesystem */
class C0100ha implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f609a;

    C0100ha(SearchView searchView) {
        this.f609a = searchView;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f609a.b(charSequence);
    }
}
