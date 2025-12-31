package a.n;

import a.n.E;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.S;
import java.util.ArrayList;
import java.util.List;

/* renamed from: a.n.t  reason: case insensitive filesystem */
public class C0064t extends S {
    public boolean a(Object obj) {
        return obj instanceof E;
    }

    public Object b(Object obj) {
        if (obj != null) {
            return ((E) obj).clone();
        }
        return null;
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        K k = new K();
        k.a((E) obj);
        return k;
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        E e = (E) obj;
        if (e != null) {
            int i = 0;
            if (e instanceof K) {
                K k = (K) e;
                int p = k.p();
                while (i < p) {
                    a((Object) k.a(i), arrayList);
                    i++;
                }
            } else if (!a(e) && S.a((List) e.l())) {
                int size = arrayList.size();
                while (i < size) {
                    e.a(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    public void b(Object obj, View view, ArrayList<View> arrayList) {
        K k = (K) obj;
        List<View> l = k.l();
        l.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            S.a(l, arrayList.get(i));
        }
        l.add(view);
        arrayList.add(view);
        a((Object) k, arrayList);
    }

    public void c(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((E) obj).a((E.b) new C0061p(this, rect));
        }
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        K k = new K();
        if (obj != null) {
            k.a((E) obj);
        }
        if (obj2 != null) {
            k.a((E) obj2);
        }
        if (obj3 != null) {
            k.a((E) obj3);
        }
        return k;
    }

    private static boolean a(E e) {
        return !S.a((List) e.i()) || !S.a((List) e.j()) || !S.a((List) e.k());
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        K k = (K) obj;
        if (k != null) {
            k.l().clear();
            k.l().addAll(arrayList2);
            a((Object) k, arrayList, arrayList2);
        }
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((E) obj).a((E.c) new C0062q(this, view, arrayList));
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        E e = (E) obj;
        E e2 = (E) obj2;
        E e3 = (E) obj3;
        if (e != null && e2 != null) {
            K k = new K();
            k.a(e);
            k.a(e2);
            k.b(1);
            e = k;
        } else if (e == null) {
            e = e2 != null ? e2 : null;
        }
        if (e3 == null) {
            return e;
        }
        K k2 = new K();
        if (e != null) {
            k2.a(e);
        }
        k2.a(e3);
        return k2;
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((E) obj).d(view);
        }
    }

    public void a(ViewGroup viewGroup, Object obj) {
        H.a(viewGroup, (E) obj);
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((E) obj).a((E.c) new r(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i;
        E e = (E) obj;
        int i2 = 0;
        if (e instanceof K) {
            K k = (K) e;
            int p = k.p();
            while (i2 < p) {
                a((Object) k.a(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!a(e)) {
            List<View> l = e.l();
            if (l.size() == arrayList.size() && l.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i = 0;
                } else {
                    i = arrayList2.size();
                }
                while (i2 < i) {
                    e.a(arrayList2.get(i2));
                    i2++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    e.d(arrayList.get(size));
                }
            }
        }
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((E) obj).a(view);
        }
    }

    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((E) obj).a((E.b) new C0063s(this, rect));
        }
    }
}
