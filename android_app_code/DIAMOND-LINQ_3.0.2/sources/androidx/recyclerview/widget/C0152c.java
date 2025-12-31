package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C0160k;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.c  reason: case insensitive filesystem */
class C0152c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f955a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0160k f956b;

    C0152c(C0160k kVar, ArrayList arrayList) {
        this.f956b = kVar;
        this.f955a = arrayList;
    }

    public void run() {
        Iterator it = this.f955a.iterator();
        while (it.hasNext()) {
            C0160k.b bVar = (C0160k.b) it.next();
            this.f956b.b(bVar.f973a, bVar.f974b, bVar.c, bVar.d, bVar.e);
        }
        this.f955a.clear();
        this.f956b.n.remove(this.f955a);
    }
}
