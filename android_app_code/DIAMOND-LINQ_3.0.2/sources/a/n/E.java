package a.n;

import a.d.f;
import a.d.i;
import a.g.i.y;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import no.nordicsemi.android.log.BuildConfig;

public abstract class E implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f270a = {2, 1, 3, 4};

    /* renamed from: b  reason: collision with root package name */
    private static final C0066v f271b = new B();
    private static ThreadLocal<a.d.b<Animator, a>> c = new ThreadLocal<>();
    ArrayList<Animator> A = new ArrayList<>();
    private int B = 0;
    private boolean C = false;
    private boolean D = false;
    private ArrayList<c> E = null;
    private ArrayList<Animator> F = new ArrayList<>();
    I G;
    private b H;
    private a.d.b<String, String> I;
    private C0066v J = f271b;
    private String d = getClass().getName();
    private long e = -1;
    long f = -1;
    private TimeInterpolator g = null;
    ArrayList<Integer> h = new ArrayList<>();
    ArrayList<View> i = new ArrayList<>();
    private ArrayList<String> j = null;
    private ArrayList<Class> k = null;
    private ArrayList<Integer> l = null;
    private ArrayList<View> m = null;
    private ArrayList<Class> n = null;
    private ArrayList<String> o = null;
    private ArrayList<Integer> p = null;
    private ArrayList<View> q = null;
    private ArrayList<Class> r = null;
    private N s = new N();
    private N t = new N();
    K u = null;
    private int[] v = f270a;
    private ArrayList<M> w;
    private ArrayList<M> x;
    private ViewGroup y = null;
    boolean z = false;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        View f272a;

        /* renamed from: b  reason: collision with root package name */
        String f273b;
        M c;
        ka d;
        E e;

        a(View view, String str, E e2, ka kaVar, M m) {
            this.f272a = view;
            this.f273b = str;
            this.c = m;
            this.d = kaVar;
            this.e = e2;
        }
    }

    public static abstract class b {
    }

    public interface c {
        void a(E e);

        void b(E e);

        void c(E e);

        void d(E e);
    }

    private void c(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.l;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.m;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class> arrayList3 = this.n;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!this.n.get(i2).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        M m2 = new M();
                        m2.f286b = view;
                        if (z2) {
                            c(m2);
                        } else {
                            a(m2);
                        }
                        m2.c.add(this);
                        b(m2);
                        if (z2) {
                            a(this.s, view, m2);
                        } else {
                            a(this.t, view, m2);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.p;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.q;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class> arrayList6 = this.r;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        if (!this.r.get(i3).isInstance(view)) {
                                            i3++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    c(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static a.d.b<Animator, a> p() {
        a.d.b<Animator, a> bVar = c.get();
        if (bVar != null) {
            return bVar;
        }
        a.d.b<Animator, a> bVar2 = new a.d.b<>();
        c.set(bVar2);
        return bVar2;
    }

    public E a(long j2) {
        this.f = j2;
        return this;
    }

    public Animator a(ViewGroup viewGroup, M m2, M m3) {
        return null;
    }

    public abstract void a(M m2);

    public long b() {
        return this.f;
    }

    public abstract void c(M m2);

    public TimeInterpolator d() {
        return this.g;
    }

    public void e(View view) {
        if (this.C) {
            if (!this.D) {
                a.d.b<Animator, a> p2 = p();
                int size = p2.size();
                ka d2 = ba.d(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a d3 = p2.d(i2);
                    if (d3.f272a != null && d2.equals(d3.d)) {
                        C0046a.b(p2.b(i2));
                    }
                }
                ArrayList<c> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.E.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((c) arrayList2.get(i3)).d(this);
                    }
                }
            }
            this.C = false;
        }
    }

    public C0066v f() {
        return this.J;
    }

    public I g() {
        return this.G;
    }

    public long h() {
        return this.e;
    }

    public List<Integer> i() {
        return this.h;
    }

    public List<String> j() {
        return this.j;
    }

    public List<Class> k() {
        return this.k;
    }

    public List<View> l() {
        return this.i;
    }

    public String[] m() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void n() {
        o();
        a.d.b<Animator, a> p2 = p();
        Iterator<Animator> it = this.F.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (p2.containsKey(next)) {
                o();
                a(next, p2);
            }
        }
        this.F.clear();
        a();
    }

    /* access modifiers changed from: protected */
    public void o() {
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).a(this);
                }
            }
            this.D = false;
        }
        this.B++;
    }

    public String toString() {
        return a(BuildConfig.FLAVOR);
    }

    public E a(TimeInterpolator timeInterpolator) {
        this.g = timeInterpolator;
        return this;
    }

    public E b(long j2) {
        this.e = j2;
        return this;
    }

    public E clone() {
        try {
            E e2 = (E) super.clone();
            e2.F = new ArrayList<>();
            e2.s = new N();
            e2.t = new N();
            e2.w = null;
            e2.x = null;
            return e2;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public E d(View view) {
        this.i.remove(view);
        return this;
    }

    private void a(a.d.b<View, M> bVar, a.d.b<View, M> bVar2, f<View> fVar, f<View> fVar2) {
        View b2;
        int b3 = fVar.b();
        for (int i2 = 0; i2 < b3; i2++) {
            View c2 = fVar.c(i2);
            if (c2 != null && b(c2) && (b2 = fVar2.b(fVar.a(i2))) != null && b(b2)) {
                M m2 = bVar.get(c2);
                M m3 = bVar2.get(b2);
                if (!(m2 == null || m3 == null)) {
                    this.w.add(m2);
                    this.x.add(m3);
                    bVar.remove(c2);
                    bVar2.remove(b2);
                }
            }
        }
    }

    private void b(a.d.b<View, M> bVar, a.d.b<View, M> bVar2) {
        M remove;
        View view;
        for (int size = bVar.size() - 1; size >= 0; size--) {
            View b2 = bVar.b(size);
            if (!(b2 == null || !b(b2) || (remove = bVar2.remove(b2)) == null || (view = remove.f286b) == null || !b(view))) {
                this.w.add(bVar.c(size));
                this.x.add(remove);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.l;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.m;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList5 = this.n;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.n.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.o != null && y.s(view) != null && this.o.contains(y.s(view))) {
            return false;
        }
        if ((this.h.size() == 0 && this.i.size() == 0 && (((arrayList = this.k) == null || arrayList.isEmpty()) && ((arrayList2 = this.j) == null || arrayList2.isEmpty()))) || this.h.contains(Integer.valueOf(id)) || this.i.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.j;
        if (arrayList6 != null && arrayList6.contains(y.s(view))) {
            return true;
        }
        if (this.k != null) {
            for (int i3 = 0; i3 < this.k.size(); i3++) {
                if (this.k.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(a.d.b<View, M> bVar, a.d.b<View, M> bVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && b(view)) {
                M m2 = bVar.get(valueAt);
                M m3 = bVar2.get(view);
                if (!(m2 == null || m3 == null)) {
                    this.w.add(m2);
                    this.x.add(m3);
                    bVar.remove(valueAt);
                    bVar2.remove(view);
                }
            }
        }
    }

    public String e() {
        return this.d;
    }

    private void a(a.d.b<View, M> bVar, a.d.b<View, M> bVar2, a.d.b<String, View> bVar3, a.d.b<String, View> bVar4) {
        View view;
        int size = bVar3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View d2 = bVar3.d(i2);
            if (d2 != null && b(d2) && (view = bVar4.get(bVar3.b(i2))) != null && b(view)) {
                M m2 = bVar.get(d2);
                M m3 = bVar2.get(view);
                if (!(m2 == null || m3 == null)) {
                    this.w.add(m2);
                    this.x.add(m3);
                    bVar.remove(d2);
                    bVar2.remove(view);
                }
            }
        }
    }

    public void c(View view) {
        if (!this.D) {
            a.d.b<Animator, a> p2 = p();
            int size = p2.size();
            ka d2 = ba.d(view);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a d3 = p2.d(i2);
                if (d3.f272a != null && d2.equals(d3.d)) {
                    C0046a.a(p2.b(i2));
                }
            }
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((c) arrayList2.get(i3)).b(this);
                }
            }
            this.C = true;
        }
    }

    public M b(View view, boolean z2) {
        K k2 = this.u;
        if (k2 != null) {
            return k2.b(view, z2);
        }
        return (z2 ? this.s : this.t).f287a.get(view);
    }

    public E b(c cVar) {
        ArrayList<c> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    private void a(a.d.b<View, M> bVar, a.d.b<View, M> bVar2) {
        for (int i2 = 0; i2 < bVar.size(); i2++) {
            M d2 = bVar.d(i2);
            if (b(d2.f286b)) {
                this.w.add(d2);
                this.x.add((Object) null);
            }
        }
        for (int i3 = 0; i3 < bVar2.size(); i3++) {
            M d3 = bVar2.d(i3);
            if (b(d3.f286b)) {
                this.x.add(d3);
                this.w.add((Object) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(M m2) {
        String[] a2;
        if (this.G != null && !m2.f285a.isEmpty() && (a2 = this.G.a()) != null) {
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= a2.length) {
                    z2 = true;
                    break;
                } else if (!m2.f285a.containsKey(a2[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                this.G.a(m2);
            }
        }
    }

    public b c() {
        return this.H;
    }

    private void a(N n2, N n3) {
        a.d.b bVar = new a.d.b((i) n2.f287a);
        a.d.b bVar2 = new a.d.b((i) n3.f287a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.v;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    b((a.d.b<View, M>) bVar, (a.d.b<View, M>) bVar2);
                } else if (i3 == 2) {
                    a((a.d.b<View, M>) bVar, (a.d.b<View, M>) bVar2, n2.d, n3.d);
                } else if (i3 == 3) {
                    a((a.d.b<View, M>) bVar, (a.d.b<View, M>) bVar2, n2.f288b, n3.f288b);
                } else if (i3 == 4) {
                    a((a.d.b<View, M>) bVar, (a.d.b<View, M>) bVar2, n2.c, n3.c);
                }
                i2++;
            } else {
                a((a.d.b<View, M>) bVar, (a.d.b<View, M>) bVar2);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, N n2, N n3, ArrayList<M> arrayList, ArrayList<M> arrayList2) {
        int i2;
        int i3;
        Animator a2;
        View view;
        Animator animator;
        M m2;
        M m3;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        a.d.b<Animator, a> p2 = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Long.MAX_VALUE;
        int i4 = 0;
        while (i4 < size) {
            M m4 = arrayList.get(i4);
            M m5 = arrayList2.get(i4);
            if (m4 != null && !m4.c.contains(this)) {
                m4 = null;
            }
            if (m5 != null && !m5.c.contains(this)) {
                m5 = null;
            }
            if (!(m4 == null && m5 == null)) {
                if ((m4 == null || m5 == null || a(m4, m5)) && (a2 = a(viewGroup2, m4, m5)) != null) {
                    if (m5 != null) {
                        view = m5.f286b;
                        String[] m6 = m();
                        if (view != null && m6 != null && m6.length > 0) {
                            m3 = new M();
                            m3.f286b = view;
                            Animator animator3 = a2;
                            i3 = size;
                            M m7 = n3.f287a.get(view);
                            if (m7 != null) {
                                int i5 = 0;
                                while (i5 < m6.length) {
                                    m3.f285a.put(m6[i5], m7.f285a.get(m6[i5]));
                                    i5++;
                                    ArrayList<M> arrayList3 = arrayList2;
                                    i4 = i4;
                                    m7 = m7;
                                }
                            }
                            i2 = i4;
                            int size2 = p2.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                a aVar = p2.get(p2.b(i6));
                                if (aVar.c != null && aVar.f272a == view && aVar.f273b.equals(e()) && aVar.c.equals(m3)) {
                                    animator2 = null;
                                    break;
                                }
                                i6++;
                            }
                        } else {
                            i3 = size;
                            i2 = i4;
                            animator2 = a2;
                            m3 = null;
                        }
                        animator = animator2;
                        m2 = m3;
                    } else {
                        i3 = size;
                        i2 = i4;
                        view = m4.f286b;
                        animator = a2;
                        m2 = null;
                    }
                    if (animator != null) {
                        I i7 = this.G;
                        if (i7 != null) {
                            long a3 = i7.a(viewGroup2, this, m4, m5);
                            sparseIntArray.put(this.F.size(), (int) a3);
                            j2 = Math.min(a3, j2);
                        }
                        p2.put(animator, new a(view, e(), this, ba.d(viewGroup), m2));
                        this.F.add(animator);
                        j2 = j2;
                    }
                    i4 = i2 + 1;
                    size = i3;
                }
            }
            i3 = size;
            i2 = i4;
            i4 = i2 + 1;
            size = i3;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator4 = this.F.get(sparseIntArray.keyAt(i8));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i8)) - j2) + animator4.getStartDelay());
            }
        }
    }

    private void a(Animator animator, a.d.b<Animator, a> bVar) {
        if (animator != null) {
            animator.addListener(new C(this, bVar));
            a(animator);
        }
    }

    public E a(View view) {
        this.i.add(view);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup, boolean z2) {
        a.d.b<String, String> bVar;
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        a(z2);
        if ((this.h.size() > 0 || this.i.size() > 0) && (((arrayList = this.j) == null || arrayList.isEmpty()) && ((arrayList2 = this.k) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.h.get(i2).intValue());
                if (findViewById != null) {
                    M m2 = new M();
                    m2.f286b = findViewById;
                    if (z2) {
                        c(m2);
                    } else {
                        a(m2);
                    }
                    m2.c.add(this);
                    b(m2);
                    if (z2) {
                        a(this.s, findViewById, m2);
                    } else {
                        a(this.t, findViewById, m2);
                    }
                }
            }
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                View view = this.i.get(i3);
                M m3 = new M();
                m3.f286b = view;
                if (z2) {
                    c(m3);
                } else {
                    a(m3);
                }
                m3.c.add(this);
                b(m3);
                if (z2) {
                    a(this.s, view, m3);
                } else {
                    a(this.t, view, m3);
                }
            }
        } else {
            c(viewGroup, z2);
        }
        if (!z2 && (bVar = this.I) != null) {
            int size = bVar.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                arrayList3.add(this.s.d.remove(this.I.b(i4)));
            }
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) arrayList3.get(i5);
                if (view2 != null) {
                    this.s.d.put(this.I.d(i5), view2);
                }
            }
        }
    }

    private static void a(N n2, View view, M m2) {
        n2.f287a.put(view, m2);
        int id = view.getId();
        if (id >= 0) {
            if (n2.f288b.indexOfKey(id) >= 0) {
                n2.f288b.put(id, (Object) null);
            } else {
                n2.f288b.put(id, view);
            }
        }
        String s2 = y.s(view);
        if (s2 != null) {
            if (n2.d.containsKey(s2)) {
                n2.d.put(s2, null);
            } else {
                n2.d.put(s2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (n2.c.c(itemIdAtPosition) >= 0) {
                    View b2 = n2.c.b(itemIdAtPosition);
                    if (b2 != null) {
                        y.b(b2, false);
                        n2.c.c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                y.b(view, true);
                n2.c.c(itemIdAtPosition, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (z2) {
            this.s.f287a.clear();
            this.s.f288b.clear();
            this.s.c.a();
            return;
        }
        this.t.f287a.clear();
        this.t.f288b.clear();
        this.t.c.a();
    }

    /* access modifiers changed from: package-private */
    public M a(View view, boolean z2) {
        K k2 = this.u;
        if (k2 != null) {
            return k2.a(view, z2);
        }
        ArrayList<M> arrayList = z2 ? this.w : this.x;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            M m2 = arrayList.get(i3);
            if (m2 == null) {
                return null;
            }
            if (m2.f286b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z2 ? this.x : this.w).get(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
        a aVar;
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        a(this.s, this.t);
        a.d.b<Animator, a> p2 = p();
        int size = p2.size();
        ka d2 = ba.d(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator b2 = p2.b(i2);
            if (!(b2 == null || (aVar = p2.get(b2)) == null || aVar.f272a == null || !d2.equals(aVar.d))) {
                M m2 = aVar.c;
                View view = aVar.f272a;
                M b3 = b(view, true);
                M a2 = a(view, true);
                if (b3 == null && a2 == null) {
                    a2 = this.t.f287a.get(view);
                }
                if (!(b3 == null && a2 == null) && aVar.e.a(m2, a2)) {
                    if (b2.isRunning() || b2.isStarted()) {
                        b2.cancel();
                    } else {
                        p2.remove(b2);
                    }
                }
            }
        }
        a(viewGroup, this.s, this.t, this.w, this.x);
        n();
    }

    public boolean a(M m2, M m3) {
        if (m2 == null || m3 == null) {
            return false;
        }
        String[] m4 = m();
        if (m4 != null) {
            int length = m4.length;
            int i2 = 0;
            while (i2 < length) {
                if (!a(m2, m3, m4[i2])) {
                    i2++;
                }
            }
            return false;
        }
        for (String a2 : m2.f285a.keySet()) {
            if (a(m2, m3, a2)) {
            }
        }
        return false;
        return true;
    }

    private static boolean a(M m2, M m3, String str) {
        Object obj = m2.f285a.get(str);
        Object obj2 = m3.f285a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    /* access modifiers changed from: protected */
    public void a(Animator animator) {
        if (animator == null) {
            a();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (h() >= 0) {
            animator.setStartDelay(h());
        }
        if (d() != null) {
            animator.setInterpolator(d());
        }
        animator.addListener(new D(this));
        animator.start();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.B--;
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((c) arrayList2.get(i2)).c(this);
                }
            }
            for (int i3 = 0; i3 < this.s.c.b(); i3++) {
                View c2 = this.s.c.c(i3);
                if (c2 != null) {
                    y.b(c2, false);
                }
            }
            for (int i4 = 0; i4 < this.t.c.b(); i4++) {
                View c3 = this.t.c.c(i4);
                if (c3 != null) {
                    y.b(c3, false);
                }
            }
            this.D = true;
        }
    }

    public E a(c cVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(cVar);
        return this;
    }

    public void a(C0066v vVar) {
        if (vVar == null) {
            this.J = f271b;
        } else {
            this.J = vVar;
        }
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public void a(I i2) {
        this.G = i2;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f != -1) {
            str2 = str2 + "dur(" + this.f + ") ";
        }
        if (this.e != -1) {
            str2 = str2 + "dly(" + this.e + ") ";
        }
        if (this.g != null) {
            str2 = str2 + "interp(" + this.g + ") ";
        }
        if (this.h.size() <= 0 && this.i.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.h.size() > 0) {
            String str4 = str3;
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (i2 > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.h.get(i2);
            }
            str3 = str4;
        }
        if (this.i.size() > 0) {
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.i.get(i3);
            }
        }
        return str3 + ")";
    }
}
