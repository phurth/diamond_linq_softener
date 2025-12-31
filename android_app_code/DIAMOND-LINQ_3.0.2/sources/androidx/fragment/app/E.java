package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

class E implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f767a;

    E(ArrayList arrayList) {
        this.f767a = arrayList;
    }

    public void run() {
        I.a((ArrayList<View>) this.f767a, 4);
    }
}
