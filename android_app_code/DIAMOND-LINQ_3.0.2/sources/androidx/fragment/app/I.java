package androidx.fragment.app;

import a.d.b;
import a.g.i.r;
import a.g.i.y;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class I {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f775a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b  reason: collision with root package name */
    private static final S f776b = (Build.VERSION.SDK_INT >= 21 ? new N() : null);
    private static final S c = a();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public C0132h f777a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f778b;
        public C0125a c;
        public C0132h d;
        public boolean e;
        public C0125a f;

        a() {
        }
    }

    private static S a() {
        try {
            return (S) Class.forName("a.n.t").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r11 = r4.f777a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(androidx.fragment.app.w r17, int r18, androidx.fragment.app.I.a r19, android.view.View r20, a.d.b<java.lang.String, java.lang.String> r21) {
        /*
            r0 = r17
            r4 = r19
            r9 = r20
            androidx.fragment.app.k r1 = r0.t
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x0019
            androidx.fragment.app.k r0 = r0.t
            r1 = r18
            android.view.View r0 = r0.a(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r10 = r0
            if (r10 != 0) goto L_0x001e
            return
        L_0x001e:
            androidx.fragment.app.h r11 = r4.f777a
            androidx.fragment.app.h r12 = r4.d
            androidx.fragment.app.S r13 = a((androidx.fragment.app.C0132h) r12, (androidx.fragment.app.C0132h) r11)
            if (r13 != 0) goto L_0x0029
            return
        L_0x0029:
            boolean r14 = r4.f778b
            boolean r0 = r4.e
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.Object r7 = a((androidx.fragment.app.S) r13, (androidx.fragment.app.C0132h) r11, (boolean) r14)
            java.lang.Object r6 = b((androidx.fragment.app.S) r13, (androidx.fragment.app.C0132h) r12, (boolean) r0)
            r0 = r13
            r1 = r10
            r2 = r20
            r3 = r21
            r4 = r19
            r5 = r8
            r17 = r6
            r6 = r15
            r18 = r7
            r16 = r10
            r10 = r8
            r8 = r17
            java.lang.Object r8 = b(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r6 = r18
            if (r6 != 0) goto L_0x0061
            if (r8 != 0) goto L_0x0061
            r7 = r17
            if (r7 != 0) goto L_0x0063
            return
        L_0x0061:
            r7 = r17
        L_0x0063:
            java.util.ArrayList r5 = a((androidx.fragment.app.S) r13, (java.lang.Object) r7, (androidx.fragment.app.C0132h) r12, (java.util.ArrayList<android.view.View>) r10, (android.view.View) r9)
            java.util.ArrayList r9 = a((androidx.fragment.app.S) r13, (java.lang.Object) r6, (androidx.fragment.app.C0132h) r11, (java.util.ArrayList<android.view.View>) r15, (android.view.View) r9)
            r0 = 4
            a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r0 = r13
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r11
            r11 = r5
            r5 = r14
            java.lang.Object r14 = a((androidx.fragment.app.S) r0, (java.lang.Object) r1, (java.lang.Object) r2, (java.lang.Object) r3, (androidx.fragment.app.C0132h) r4, (boolean) r5)
            if (r14 == 0) goto L_0x00a4
            a((androidx.fragment.app.S) r13, (java.lang.Object) r7, (androidx.fragment.app.C0132h) r12, (java.util.ArrayList<android.view.View>) r11)
            java.util.ArrayList r12 = r13.a((java.util.ArrayList<android.view.View>) r15)
            r0 = r13
            r1 = r14
            r2 = r6
            r3 = r9
            r4 = r7
            r5 = r11
            r6 = r8
            r7 = r15
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            r13.a((android.view.ViewGroup) r0, (java.lang.Object) r14)
            r1 = r13
            r2 = r0
            r3 = r10
            r4 = r15
            r5 = r12
            r6 = r21
            r1.a(r2, r3, r4, r5, r6)
            r0 = 0
            a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r13.b((java.lang.Object) r8, (java.util.ArrayList<android.view.View>) r10, (java.util.ArrayList<android.view.View>) r15)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.I.b(androidx.fragment.app.w, int, androidx.fragment.app.I$a, android.view.View, a.d.b):void");
    }

    static void a(w wVar, ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (wVar.r >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                C0125a aVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    b(aVar, (SparseArray<a>) sparseArray, z);
                } else {
                    a(aVar, (SparseArray<a>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(wVar.s.d());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    b<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                    a aVar2 = (a) sparseArray.valueAt(i4);
                    if (z) {
                        b(wVar, keyAt, aVar2, view, a2);
                    } else {
                        a(wVar, keyAt, aVar2, view, a2);
                    }
                }
            }
        }
    }

    private static b<String, String> a(int i, ArrayList<C0125a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        b<String, String> bVar = new b<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0125a aVar = arrayList.get(i4);
            if (aVar.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = aVar.r;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar.r;
                        arrayList4 = aVar.s;
                    } else {
                        ArrayList<String> arrayList6 = aVar.r;
                        arrayList3 = aVar.s;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = bVar.remove(str2);
                        if (remove != null) {
                            bVar.put(str, remove);
                        } else {
                            bVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return bVar;
    }

    private static Object b(S s, C0132h hVar, boolean z) {
        Object obj;
        if (hVar == null) {
            return null;
        }
        if (z) {
            obj = hVar.y();
        } else {
            obj = hVar.p();
        }
        return s.b(obj);
    }

    private static Object b(S s, ViewGroup viewGroup, View view, b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        Rect rect;
        View view2;
        S s2 = s;
        View view3 = view;
        b<String, String> bVar2 = bVar;
        a aVar2 = aVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        C0132h hVar = aVar2.f777a;
        C0132h hVar2 = aVar2.d;
        if (hVar != null) {
            hVar.fa().setVisibility(0);
        }
        if (hVar == null || hVar2 == null) {
            return null;
        }
        boolean z = aVar2.f778b;
        if (bVar.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = a(s, hVar, hVar2, z);
        }
        b<String, View> b2 = b(s, bVar2, obj3, aVar2);
        b<String, View> a2 = a(s, bVar2, obj3, aVar2);
        if (bVar.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a2 != null) {
                a2.clear();
            }
            obj4 = null;
        } else {
            a(arrayList3, b2, (Collection<String>) bVar.keySet());
            a(arrayList4, a2, bVar.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(hVar, hVar2, z, b2, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            s.b(obj4, view3, arrayList3);
            a(s, obj4, obj2, b2, aVar2.e, aVar2.f);
            Rect rect2 = new Rect();
            View a3 = a(a2, aVar2, obj5, z);
            if (a3 != null) {
                s.a(obj5, rect2);
            }
            rect = rect2;
            view2 = a3;
        } else {
            view2 = null;
            rect = null;
        }
        r.a(viewGroup, new G(hVar, hVar2, z, a2, view2, s, rect));
        return obj4;
    }

    private static void a(S s, Object obj, C0132h hVar, ArrayList<View> arrayList) {
        if (hVar != null && obj != null && hVar.k && hVar.y && hVar.M) {
            hVar.f(true);
            s.a(obj, hVar.D(), arrayList);
            r.a(hVar.F, new E(arrayList));
        }
    }

    private static void a(w wVar, int i, a aVar, View view, b<String, String> bVar) {
        C0132h hVar;
        C0132h hVar2;
        S a2;
        Object obj;
        w wVar2 = wVar;
        a aVar2 = aVar;
        View view2 = view;
        b<String, String> bVar2 = bVar;
        ViewGroup viewGroup = wVar2.t.a() ? (ViewGroup) wVar2.t.a(i) : null;
        if (viewGroup != null && (a2 = a(hVar2, hVar)) != null) {
            boolean z = aVar2.f778b;
            boolean z2 = aVar2.e;
            Object a3 = a(a2, (hVar = aVar2.f777a), z);
            Object b2 = b(a2, (hVar2 = aVar2.d), z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = b2;
            S s = a2;
            Object a4 = a(a2, viewGroup, view, bVar, aVar, (ArrayList<View>) arrayList, (ArrayList<View>) arrayList2, a3, obj2);
            Object obj3 = a3;
            if (obj3 == null && a4 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> a5 = a(s, obj, hVar2, (ArrayList<View>) arrayList3, view2);
            Object obj4 = (a5 == null || a5.isEmpty()) ? null : obj;
            s.a(obj3, view2);
            Object a6 = a(s, obj3, obj4, a4, hVar, aVar2.f778b);
            if (a6 != null) {
                ArrayList arrayList4 = new ArrayList();
                S s2 = s;
                s2.a(a6, obj3, arrayList4, obj4, a5, a4, arrayList2);
                a(s2, viewGroup, hVar, view, (ArrayList<View>) arrayList2, obj3, (ArrayList<View>) arrayList4, obj4, a5);
                ArrayList arrayList5 = arrayList2;
                s.a((View) viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) bVar2);
                s.a(viewGroup, a6);
                s.a(viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) bVar2);
            }
        }
    }

    private static b<String, View> b(S s, b<String, String> bVar, Object obj, a aVar) {
        i iVar;
        ArrayList<String> arrayList;
        if (bVar.isEmpty() || obj == null) {
            bVar.clear();
            return null;
        }
        C0132h hVar = aVar.d;
        b<String, View> bVar2 = new b<>();
        s.a((Map<String, View>) bVar2, hVar.fa());
        C0125a aVar2 = aVar.f;
        if (aVar.e) {
            iVar = hVar.o();
            arrayList = aVar2.s;
        } else {
            iVar = hVar.q();
            arrayList = aVar2.r;
        }
        bVar2.a(arrayList);
        if (iVar != null) {
            iVar.a(arrayList, bVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = bVar2.get(str);
                if (view == null) {
                    bVar.remove(str);
                } else if (!str.equals(y.s(view))) {
                    bVar.put(y.s(view), bVar.remove(str));
                }
            }
        } else {
            bVar.a(bVar2.keySet());
        }
        return bVar2;
    }

    private static void a(S s, ViewGroup viewGroup, C0132h hVar, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        ViewGroup viewGroup2 = viewGroup;
        r.a(viewGroup, new F(obj, s, view, hVar, arrayList, arrayList2, arrayList3, obj2));
    }

    private static S a(C0132h hVar, C0132h hVar2) {
        ArrayList arrayList = new ArrayList();
        if (hVar != null) {
            Object p = hVar.p();
            if (p != null) {
                arrayList.add(p);
            }
            Object y = hVar.y();
            if (y != null) {
                arrayList.add(y);
            }
            Object A = hVar.A();
            if (A != null) {
                arrayList.add(A);
            }
        }
        if (hVar2 != null) {
            Object n = hVar2.n();
            if (n != null) {
                arrayList.add(n);
            }
            Object v = hVar2.v();
            if (v != null) {
                arrayList.add(v);
            }
            Object z = hVar2.z();
            if (z != null) {
                arrayList.add(z);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        S s = f776b;
        if (s != null && a(s, (List<Object>) arrayList)) {
            return f776b;
        }
        S s2 = c;
        if (s2 != null && a(s2, (List<Object>) arrayList)) {
            return c;
        }
        if (f776b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static void b(C0125a aVar, SparseArray<a> sparseArray, boolean z) {
        if (aVar.f794a.t.a()) {
            for (int size = aVar.f795b.size() - 1; size >= 0; size--) {
                a(aVar, aVar.f795b.get(size), sparseArray, true, z);
            }
        }
    }

    private static boolean a(S s, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!s.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(S s, C0132h hVar, C0132h hVar2, boolean z) {
        Object obj;
        if (hVar == null || hVar2 == null) {
            return null;
        }
        if (z) {
            obj = hVar2.A();
        } else {
            obj = hVar.z();
        }
        return s.c(s.b(obj));
    }

    private static Object a(S s, C0132h hVar, boolean z) {
        Object obj;
        if (hVar == null) {
            return null;
        }
        if (z) {
            obj = hVar.v();
        } else {
            obj = hVar.n();
        }
        return s.b(obj);
    }

    private static void a(ArrayList<View> arrayList, b<String, View> bVar, Collection<String> collection) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View d = bVar.d(size);
            if (collection.contains(y.s(d))) {
                arrayList.add(d);
            }
        }
    }

    private static Object a(S s, ViewGroup viewGroup, View view, b<String, String> bVar, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        b<String, String> bVar2;
        Object obj3;
        Object obj4;
        Rect rect;
        S s2 = s;
        a aVar2 = aVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        C0132h hVar = aVar2.f777a;
        C0132h hVar2 = aVar2.d;
        if (hVar == null || hVar2 == null) {
            return null;
        }
        boolean z = aVar2.f778b;
        if (bVar.isEmpty()) {
            bVar2 = bVar;
            obj3 = null;
        } else {
            obj3 = a(s2, hVar, hVar2, z);
            bVar2 = bVar;
        }
        b<String, View> b2 = b(s2, bVar2, obj3, aVar2);
        if (bVar.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b2.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(hVar, hVar2, z, b2, true);
        if (obj4 != null) {
            rect = new Rect();
            s2.b(obj4, view, arrayList3);
            a(s, obj4, obj2, b2, aVar2.e, aVar2.f);
            if (obj5 != null) {
                s2.a(obj5, rect);
            }
        } else {
            rect = null;
        }
        H h = r0;
        H h2 = new H(s, bVar, obj4, aVar, arrayList2, view, hVar, hVar2, z, arrayList, obj, rect);
        r.a(viewGroup, h);
        return obj4;
    }

    static b<String, View> a(S s, b<String, String> bVar, Object obj, a aVar) {
        i iVar;
        ArrayList<String> arrayList;
        String a2;
        C0132h hVar = aVar.f777a;
        View D = hVar.D();
        if (bVar.isEmpty() || obj == null || D == null) {
            bVar.clear();
            return null;
        }
        b<String, View> bVar2 = new b<>();
        s.a((Map<String, View>) bVar2, D);
        C0125a aVar2 = aVar.c;
        if (aVar.f778b) {
            iVar = hVar.q();
            arrayList = aVar2.r;
        } else {
            iVar = hVar.o();
            arrayList = aVar2.s;
        }
        if (arrayList != null) {
            bVar2.a(arrayList);
            bVar2.a(bVar.values());
        }
        if (iVar != null) {
            iVar.a(arrayList, bVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = bVar2.get(str);
                if (view == null) {
                    String a3 = a(bVar, str);
                    if (a3 != null) {
                        bVar.remove(a3);
                    }
                } else if (!str.equals(y.s(view)) && (a2 = a(bVar, str)) != null) {
                    bVar.put(a2, y.s(view));
                }
            }
        } else {
            a(bVar, bVar2);
        }
        return bVar2;
    }

    private static String a(b<String, String> bVar, String str) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(bVar.d(i))) {
                return bVar.b(i);
            }
        }
        return null;
    }

    static View a(b<String, View> bVar, a aVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        C0125a aVar2 = aVar.c;
        if (obj == null || bVar == null || (arrayList = aVar2.r) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = aVar2.r.get(0);
        } else {
            str = aVar2.s.get(0);
        }
        return bVar.get(str);
    }

    private static void a(S s, Object obj, Object obj2, b<String, View> bVar, boolean z, C0125a aVar) {
        String str;
        ArrayList<String> arrayList = aVar.r;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z) {
                str = aVar.s.get(0);
            } else {
                str = aVar.r.get(0);
            }
            View view = bVar.get(str);
            s.c(obj, view);
            if (obj2 != null) {
                s.c(obj2, view);
            }
        }
    }

    private static void a(b<String, String> bVar, b<String, View> bVar2) {
        for (int size = bVar.size() - 1; size >= 0; size--) {
            if (!bVar2.containsKey(bVar.d(size))) {
                bVar.c(size);
            }
        }
    }

    static void a(C0132h hVar, C0132h hVar2, boolean z, b<String, View> bVar, boolean z2) {
        i iVar;
        int i;
        if (z) {
            iVar = hVar2.o();
        } else {
            iVar = hVar.o();
        }
        if (iVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (bVar == null) {
                i = 0;
            } else {
                i = bVar.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(bVar.b(i2));
                arrayList.add(bVar.d(i2));
            }
            if (z2) {
                iVar.b(arrayList2, arrayList, (List<View>) null);
            } else {
                iVar.a(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    static ArrayList<View> a(S s, Object obj, C0132h hVar, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View D = hVar.D();
        if (D != null) {
            s.a(arrayList2, D);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        s.a(obj, arrayList2);
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    private static Object a(S s, Object obj, Object obj2, Object obj3, C0132h hVar, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || hVar == null) {
            z2 = true;
        } else {
            z2 = z ? hVar.h() : hVar.g();
        }
        if (z2) {
            return s.b(obj2, obj, obj3);
        }
        return s.a(obj2, obj, obj3);
    }

    public static void a(C0125a aVar, SparseArray<a> sparseArray, boolean z) {
        int size = aVar.f795b.size();
        for (int i = 0; i < size; i++) {
            a(aVar, aVar.f795b.get(i), sparseArray, false, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        if (r10.k != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0092, code lost:
        if (r10.y == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0094, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(androidx.fragment.app.C0125a r16, androidx.fragment.app.C0125a.C0025a r17, android.util.SparseArray<androidx.fragment.app.I.a> r18, boolean r19, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            androidx.fragment.app.h r10 = r1.f797b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.w
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = f775a
            int r1 = r1.f796a
            r1 = r4[r1]
            goto L_0x001d
        L_0x001b:
            int r1 = r1.f796a
        L_0x001d:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x0087
            r6 = 3
            if (r1 == r6) goto L_0x005f
            r6 = 4
            if (r1 == r6) goto L_0x0047
            r6 = 5
            if (r1 == r6) goto L_0x0035
            r6 = 6
            if (r1 == r6) goto L_0x005f
            r6 = 7
            if (r1 == r6) goto L_0x0087
            r1 = 0
        L_0x0031:
            r12 = 0
            r13 = 0
            goto L_0x009a
        L_0x0035:
            if (r20 == 0) goto L_0x0044
            boolean r1 = r10.M
            if (r1 == 0) goto L_0x0096
            boolean r1 = r10.y
            if (r1 != 0) goto L_0x0096
            boolean r1 = r10.k
            if (r1 == 0) goto L_0x0096
            goto L_0x0094
        L_0x0044:
            boolean r1 = r10.y
            goto L_0x0097
        L_0x0047:
            if (r20 == 0) goto L_0x0056
            boolean r1 = r10.M
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.k
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.y
            if (r1 == 0) goto L_0x0078
        L_0x0055:
            goto L_0x0076
        L_0x0056:
            boolean r1 = r10.k
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.y
            if (r1 != 0) goto L_0x0078
            goto L_0x0055
        L_0x005f:
            if (r20 == 0) goto L_0x007a
            boolean r1 = r10.k
            if (r1 != 0) goto L_0x0078
            android.view.View r1 = r10.G
            if (r1 == 0) goto L_0x0078
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0078
            float r1 = r10.N
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0078
        L_0x0076:
            r1 = 1
            goto L_0x0083
        L_0x0078:
            r1 = 0
            goto L_0x0083
        L_0x007a:
            boolean r1 = r10.k
            if (r1 == 0) goto L_0x0078
            boolean r1 = r10.y
            if (r1 != 0) goto L_0x0078
            goto L_0x0076
        L_0x0083:
            r13 = r1
            r1 = 0
            r12 = 1
            goto L_0x009a
        L_0x0087:
            if (r20 == 0) goto L_0x008c
            boolean r1 = r10.L
            goto L_0x0097
        L_0x008c:
            boolean r1 = r10.k
            if (r1 != 0) goto L_0x0096
            boolean r1 = r10.y
            if (r1 != 0) goto L_0x0096
        L_0x0094:
            r1 = 1
            goto L_0x0097
        L_0x0096:
            r1 = 0
        L_0x0097:
            r4 = r1
            r1 = 1
            goto L_0x0031
        L_0x009a:
            java.lang.Object r6 = r2.get(r11)
            androidx.fragment.app.I$a r6 = (androidx.fragment.app.I.a) r6
            if (r4 == 0) goto L_0x00ac
            androidx.fragment.app.I$a r6 = a((androidx.fragment.app.I.a) r6, (android.util.SparseArray<androidx.fragment.app.I.a>) r2, (int) r11)
            r6.f777a = r10
            r6.f778b = r3
            r6.c = r0
        L_0x00ac:
            r14 = r6
            r15 = 0
            if (r20 != 0) goto L_0x00d3
            if (r1 == 0) goto L_0x00d3
            if (r14 == 0) goto L_0x00ba
            androidx.fragment.app.h r1 = r14.d
            if (r1 != r10) goto L_0x00ba
            r14.d = r15
        L_0x00ba:
            androidx.fragment.app.w r4 = r0.f794a
            int r1 = r10.f804b
            if (r1 >= r5) goto L_0x00d3
            int r1 = r4.r
            if (r1 < r5) goto L_0x00d3
            boolean r1 = r0.t
            if (r1 != 0) goto L_0x00d3
            r4.i(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.a((androidx.fragment.app.C0132h) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
        L_0x00d3:
            if (r13 == 0) goto L_0x00e5
            if (r14 == 0) goto L_0x00db
            androidx.fragment.app.h r1 = r14.d
            if (r1 != 0) goto L_0x00e5
        L_0x00db:
            androidx.fragment.app.I$a r14 = a((androidx.fragment.app.I.a) r14, (android.util.SparseArray<androidx.fragment.app.I.a>) r2, (int) r11)
            r14.d = r10
            r14.e = r3
            r14.f = r0
        L_0x00e5:
            if (r20 != 0) goto L_0x00f1
            if (r12 == 0) goto L_0x00f1
            if (r14 == 0) goto L_0x00f1
            androidx.fragment.app.h r0 = r14.f777a
            if (r0 != r10) goto L_0x00f1
            r14.f777a = r15
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.I.a(androidx.fragment.app.a, androidx.fragment.app.a$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }
}
