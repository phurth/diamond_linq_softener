package androidx.fragment.app;

import a.g.i.y;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;

class P implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f789a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Map f790b;
    final /* synthetic */ S c;

    P(S s, ArrayList arrayList, Map map) {
        this.c = s;
        this.f789a = arrayList;
        this.f790b = map;
    }

    public void run() {
        int size = this.f789a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f789a.get(i);
            String s = y.s(view);
            if (s != null) {
                y.a(view, S.a((Map<String, String>) this.f790b, s));
            }
        }
    }
}
