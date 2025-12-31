package androidx.fragment.app;

import a.g.i.y;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;

class Q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f791a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Map f792b;
    final /* synthetic */ S c;

    Q(S s, ArrayList arrayList, Map map) {
        this.c = s;
        this.f791a = arrayList;
        this.f792b = map;
    }

    public void run() {
        int size = this.f791a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f791a.get(i);
            y.a(view, (String) this.f792b.get(y.s(view)));
        }
    }
}
