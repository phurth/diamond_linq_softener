package androidx.fragment.app;

import a.g.i.y;
import android.view.View;
import java.util.ArrayList;

class O implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f787a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f788b;
    final /* synthetic */ ArrayList c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ ArrayList e;
    final /* synthetic */ S f;

    O(S s, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f = s;
        this.f787a = i;
        this.f788b = arrayList;
        this.c = arrayList2;
        this.d = arrayList3;
        this.e = arrayList4;
    }

    public void run() {
        for (int i = 0; i < this.f787a; i++) {
            y.a((View) this.f788b.get(i), (String) this.c.get(i));
            y.a((View) this.d.get(i), (String) this.e.get(i));
        }
    }
}
