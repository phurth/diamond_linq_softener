package androidx.appcompat.widget;

import a.h.a.a;
import android.database.Cursor;

/* renamed from: androidx.appcompat.widget.ja  reason: case insensitive filesystem */
class C0104ja implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchView f613a;

    C0104ja(SearchView searchView) {
        this.f613a = searchView;
    }

    public void run() {
        a aVar = this.f613a.S;
        if (aVar instanceof ta) {
            aVar.a((Cursor) null);
        }
    }
}
