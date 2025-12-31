package a.n;

import a.n.E;
import android.view.View;
import java.util.ArrayList;

class r implements E.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f329a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f330b;
    final /* synthetic */ Object c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ Object e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ C0064t g;

    r(C0064t tVar, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.g = tVar;
        this.f329a = obj;
        this.f330b = arrayList;
        this.c = obj2;
        this.d = arrayList2;
        this.e = obj3;
        this.f = arrayList3;
    }

    public void a(E e2) {
        Object obj = this.f329a;
        if (obj != null) {
            this.g.a(obj, (ArrayList<View>) this.f330b, (ArrayList<View>) null);
        }
        Object obj2 = this.c;
        if (obj2 != null) {
            this.g.a(obj2, (ArrayList<View>) this.d, (ArrayList<View>) null);
        }
        Object obj3 = this.e;
        if (obj3 != null) {
            this.g.a(obj3, (ArrayList<View>) this.f, (ArrayList<View>) null);
        }
    }

    public void b(E e2) {
    }

    public void c(E e2) {
    }

    public void d(E e2) {
    }
}
