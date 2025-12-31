package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0160k;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.d  reason: case insensitive filesystem */
class C0153d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f957a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0160k f958b;

    C0153d(C0160k kVar, ArrayList arrayList) {
        this.f958b = kVar;
        this.f957a = arrayList;
    }

    public void run() {
        Iterator it = this.f957a.iterator();
        while (it.hasNext()) {
            this.f958b.a((C0160k.a) it.next());
        }
        this.f957a.clear();
        this.f958b.o.remove(this.f957a);
    }
}
