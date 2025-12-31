package a.n;

import a.d.b;
import a.g.i.y;
import a.n.E;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class H {

    /* renamed from: a  reason: collision with root package name */
    private static E f276a = new C0047b();

    /* renamed from: b  reason: collision with root package name */
    private static ThreadLocal<WeakReference<b<ViewGroup, ArrayList<E>>>> f277b = new ThreadLocal<>();
    static ArrayList<ViewGroup> c = new ArrayList<>();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        E f278a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f279b;

        a(E e, ViewGroup viewGroup) {
            this.f278a = e;
            this.f279b = viewGroup;
        }

        private void a() {
            this.f279b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f279b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!H.c.remove(this.f279b)) {
                return true;
            }
            b<ViewGroup, ArrayList<E>> a2 = H.a();
            ArrayList arrayList = a2.get(this.f279b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a2.put(this.f279b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f278a);
            this.f278a.a((E.c) new G(this, a2));
            this.f278a.a(this.f279b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((E) it.next()).e(this.f279b);
                }
            }
            this.f278a.a(this.f279b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            H.c.remove(this.f279b);
            ArrayList arrayList = H.a().get(this.f279b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((E) it.next()).e(this.f279b);
                }
            }
            this.f278a.a(true);
        }
    }

    static b<ViewGroup, ArrayList<E>> a() {
        b<ViewGroup, ArrayList<E>> bVar;
        WeakReference weakReference = f277b.get();
        if (weakReference != null && (bVar = (b) weakReference.get()) != null) {
            return bVar;
        }
        b<ViewGroup, ArrayList<E>> bVar2 = new b<>();
        f277b.set(new WeakReference(bVar2));
        return bVar2;
    }

    private static void b(ViewGroup viewGroup, E e) {
        if (e != null && viewGroup != null) {
            a aVar = new a(e, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void c(ViewGroup viewGroup, E e) {
        ArrayList arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((E) it.next()).c((View) viewGroup);
            }
        }
        if (e != null) {
            e.a(viewGroup, true);
        }
        A a2 = A.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, E e) {
        if (!c.contains(viewGroup) && y.A(viewGroup)) {
            c.add(viewGroup);
            if (e == null) {
                e = f276a;
            }
            E clone = e.clone();
            c(viewGroup, clone);
            A.a(viewGroup, (A) null);
            b(viewGroup, clone);
        }
    }
}
