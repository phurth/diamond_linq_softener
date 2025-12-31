package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView;

class sa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView.SearchAutoComplete f637a;

    sa(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f637a = searchAutoComplete;
    }

    public void run() {
        this.f637a.b();
    }
}
