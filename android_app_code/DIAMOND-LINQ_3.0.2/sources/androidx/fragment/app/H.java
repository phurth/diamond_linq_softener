package androidx.fragment.app;

import a.d.b;
import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.I;
import java.util.ArrayList;

class H implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ S f773a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f774b;
    final /* synthetic */ Object c;
    final /* synthetic */ I.a d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ View f;
    final /* synthetic */ C0132h g;
    final /* synthetic */ C0132h h;
    final /* synthetic */ boolean i;
    final /* synthetic */ ArrayList j;
    final /* synthetic */ Object k;
    final /* synthetic */ Rect l;

    H(S s, b bVar, Object obj, I.a aVar, ArrayList arrayList, View view, C0132h hVar, C0132h hVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f773a = s;
        this.f774b = bVar;
        this.c = obj;
        this.d = aVar;
        this.e = arrayList;
        this.f = view;
        this.g = hVar;
        this.h = hVar2;
        this.i = z;
        this.j = arrayList2;
        this.k = obj2;
        this.l = rect;
    }

    public void run() {
        b<String, View> a2 = I.a(this.f773a, (b<String, String>) this.f774b, this.c, this.d);
        if (a2 != null) {
            this.e.addAll(a2.values());
            this.e.add(this.f);
        }
        I.a(this.g, this.h, this.i, a2, false);
        Object obj = this.c;
        if (obj != null) {
            this.f773a.b(obj, (ArrayList<View>) this.j, (ArrayList<View>) this.e);
            View a3 = I.a(a2, this.d, this.k, this.i);
            if (a3 != null) {
                this.f773a.a(a3, this.l);
            }
        }
    }
}
