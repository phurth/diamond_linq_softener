package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.e  reason: case insensitive filesystem */
class C0154e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f959a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0160k f960b;

    C0154e(C0160k kVar, ArrayList arrayList) {
        this.f960b = kVar;
        this.f959a = arrayList;
    }

    public void run() {
        Iterator it = this.f959a.iterator();
        while (it.hasNext()) {
            this.f960b.t((RecyclerView.x) it.next());
        }
        this.f959a.clear();
        this.f960b.m.remove(this.f959a);
    }
}
