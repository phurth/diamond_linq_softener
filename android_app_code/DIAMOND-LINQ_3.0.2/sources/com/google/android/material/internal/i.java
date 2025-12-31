package com.google.android.material.internal;

import a.g.i.I;
import a.g.i.a.c;
import a.g.i.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.A;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.view.menu.u;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class i implements t {

    /* renamed from: a  reason: collision with root package name */
    private NavigationMenuView f1514a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f1515b;
    private t.a c;
    androidx.appcompat.view.menu.k d;
    private int e;
    b f;
    LayoutInflater g;
    int h;
    boolean i;
    ColorStateList j;
    ColorStateList k;
    Drawable l;
    int m;
    int n;
    int o;
    boolean p;
    private int q;
    int r;
    final View.OnClickListener s = new h(this);

    private static class a extends k {
        public a(View view) {
            super(view);
        }
    }

    private class b extends RecyclerView.a<k> {
        private final ArrayList<d> c = new ArrayList<>();
        private o d;
        private boolean e;

        b() {
            h();
        }

        private void h() {
            if (!this.e) {
                this.e = true;
                this.c.clear();
                this.c.add(new c());
                int size = i.this.d.n().size();
                int i = -1;
                boolean z = false;
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    o oVar = i.this.d.n().get(i3);
                    if (oVar.isChecked()) {
                        a(oVar);
                    }
                    if (oVar.isCheckable()) {
                        oVar.c(false);
                    }
                    if (oVar.hasSubMenu()) {
                        SubMenu subMenu = oVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.c.add(new e(i.this.r, 0));
                            }
                            this.c.add(new f(oVar));
                            int size2 = this.c.size();
                            int size3 = subMenu.size();
                            boolean z2 = false;
                            for (int i4 = 0; i4 < size3; i4++) {
                                o oVar2 = (o) subMenu.getItem(i4);
                                if (oVar2.isVisible()) {
                                    if (!z2 && oVar2.getIcon() != null) {
                                        z2 = true;
                                    }
                                    if (oVar2.isCheckable()) {
                                        oVar2.c(false);
                                    }
                                    if (oVar.isChecked()) {
                                        a(oVar);
                                    }
                                    this.c.add(new f(oVar2));
                                }
                            }
                            if (z2) {
                                a(size2, this.c.size());
                            }
                        }
                    } else {
                        int groupId = oVar.getGroupId();
                        if (groupId != i) {
                            i2 = this.c.size();
                            boolean z3 = oVar.getIcon() != null;
                            if (i3 != 0) {
                                i2++;
                                ArrayList<d> arrayList = this.c;
                                int i5 = i.this.r;
                                arrayList.add(new e(i5, i5));
                            }
                            z = z3;
                        } else if (!z && oVar.getIcon() != null) {
                            a(i2, this.c.size());
                            z = true;
                        }
                        f fVar = new f(oVar);
                        fVar.f1519b = z;
                        this.c.add(fVar);
                        i = groupId;
                    }
                }
                this.e = false;
            }
        }

        public int a() {
            return this.c.size();
        }

        public long a(int i) {
            return (long) i;
        }

        public o e() {
            return this.d;
        }

        /* access modifiers changed from: package-private */
        public int f() {
            int i = i.this.f1515b.getChildCount() == 0 ? 0 : 1;
            for (int i2 = 0; i2 < i.this.f.a(); i2++) {
                if (i.this.f.b(i2) == 0) {
                    i++;
                }
            }
            return i;
        }

        public void g() {
            h();
            c();
        }

        /* renamed from: a */
        public void b(k kVar, int i) {
            int b2 = b(i);
            if (b2 == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) kVar.f936b;
                navigationMenuItemView.setIconTintList(i.this.k);
                i iVar = i.this;
                if (iVar.i) {
                    navigationMenuItemView.setTextAppearance(iVar.h);
                }
                ColorStateList colorStateList = i.this.j;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable = i.this.l;
                y.a((View) navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
                f fVar = (f) this.c.get(i);
                navigationMenuItemView.setNeedsEmptyIcon(fVar.f1519b);
                navigationMenuItemView.setHorizontalPadding(i.this.m);
                navigationMenuItemView.setIconPadding(i.this.n);
                i iVar2 = i.this;
                if (iVar2.p) {
                    navigationMenuItemView.setIconSize(iVar2.o);
                }
                navigationMenuItemView.a(fVar.a(), 0);
            } else if (b2 == 1) {
                ((TextView) kVar.f936b).setText(((f) this.c.get(i)).a().getTitle());
            } else if (b2 == 2) {
                e eVar = (e) this.c.get(i);
                kVar.f936b.setPadding(0, eVar.b(), 0, eVar.a());
            }
        }

        public Bundle d() {
            Bundle bundle = new Bundle();
            o oVar = this.d;
            if (oVar != null) {
                bundle.putInt("android:menu:checked", oVar.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.c.get(i);
                if (dVar instanceof f) {
                    o a2 = ((f) dVar).a();
                    View actionView = a2 != null ? a2.getActionView() : null;
                    if (actionView != null) {
                        l lVar = new l();
                        actionView.saveHierarchyState(lVar);
                        sparseArray.put(a2.getItemId(), lVar);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public int b(int i) {
            d dVar = this.c.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public k b(ViewGroup viewGroup, int i) {
            if (i == 0) {
                i iVar = i.this;
                return new h(iVar.g, viewGroup, iVar.s);
            } else if (i == 1) {
                return new j(i.this.g, viewGroup);
            } else {
                if (i == 2) {
                    return new C0035i(i.this.g, viewGroup);
                }
                if (i != 3) {
                    return null;
                }
                return new a(i.this.f1515b);
            }
        }

        /* renamed from: a */
        public void d(k kVar) {
            if (kVar instanceof h) {
                ((NavigationMenuItemView) kVar.f936b).b();
            }
        }

        private void a(int i, int i2) {
            while (i < i2) {
                ((f) this.c.get(i)).f1519b = true;
                i++;
            }
        }

        public void a(o oVar) {
            if (this.d != oVar && oVar.isCheckable()) {
                o oVar2 = this.d;
                if (oVar2 != null) {
                    oVar2.setChecked(false);
                }
                this.d = oVar;
                oVar.setChecked(true);
            }
        }

        public void a(Bundle bundle) {
            o a2;
            View actionView;
            l lVar;
            o a3;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.e = true;
                int size = this.c.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    d dVar = this.c.get(i2);
                    if ((dVar instanceof f) && (a3 = ((f) dVar).a()) != null && a3.getItemId() == i) {
                        a(a3);
                        break;
                    }
                    i2++;
                }
                this.e = false;
                h();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = this.c.get(i3);
                    if (!(!(dVar2 instanceof f) || (a2 = ((f) dVar2).a()) == null || (actionView = a2.getActionView()) == null || (lVar = (l) sparseParcelableArray.get(a2.getItemId())) == null)) {
                        actionView.restoreHierarchyState(lVar);
                    }
                }
            }
        }

        public void a(boolean z) {
            this.e = z;
        }
    }

    private static class c implements d {
        c() {
        }
    }

    private interface d {
    }

    private static class e implements d {

        /* renamed from: a  reason: collision with root package name */
        private final int f1516a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1517b;

        public e(int i, int i2) {
            this.f1516a = i;
            this.f1517b = i2;
        }

        public int a() {
            return this.f1517b;
        }

        public int b() {
            return this.f1516a;
        }
    }

    private static class f implements d {

        /* renamed from: a  reason: collision with root package name */
        private final o f1518a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1519b;

        f(o oVar) {
            this.f1518a = oVar;
        }

        public o a() {
            return this.f1518a;
        }
    }

    private class g extends H {
        g(RecyclerView recyclerView) {
            super(recyclerView);
        }

        public void a(View view, a.g.i.a.c cVar) {
            super.a(view, cVar);
            cVar.a((Object) c.b.a(i.this.f.f(), 0, false));
        }
    }

    private static class h extends k {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(b.c.a.a.g.design_navigation_item, viewGroup, false));
            this.f936b.setOnClickListener(onClickListener);
        }
    }

    /* renamed from: com.google.android.material.internal.i$i  reason: collision with other inner class name */
    private static class C0035i extends k {
        public C0035i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(b.c.a.a.g.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class j extends k {
        public j(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(b.c.a.a.g.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class k extends RecyclerView.x {
        public k(View view) {
            super(view);
        }
    }

    public void a(Context context, androidx.appcompat.view.menu.k kVar) {
        this.g = LayoutInflater.from(context);
        this.d = kVar;
        this.r = context.getResources().getDimensionPixelOffset(b.c.a.a.c.design_navigation_separator_vertical_padding);
    }

    public boolean a() {
        return false;
    }

    public boolean a(A a2) {
        return false;
    }

    public boolean a(androidx.appcompat.view.menu.k kVar, o oVar) {
        return false;
    }

    public Parcelable b() {
        Bundle bundle = new Bundle();
        if (this.f1514a != null) {
            SparseArray sparseArray = new SparseArray();
            this.f1514a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        b bVar = this.f;
        if (bVar != null) {
            bundle.putBundle("android:menu:adapter", bVar.d());
        }
        if (this.f1515b != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.f1515b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public boolean b(androidx.appcompat.view.menu.k kVar, o oVar) {
        return false;
    }

    public void c(int i2) {
        this.e = i2;
    }

    public int d() {
        return this.f1515b.getChildCount();
    }

    public Drawable e() {
        return this.l;
    }

    public int f() {
        return this.m;
    }

    public void g(int i2) {
        this.h = i2;
        this.i = true;
        a(false);
    }

    public int getId() {
        return this.e;
    }

    public ColorStateList h() {
        return this.j;
    }

    public ColorStateList i() {
        return this.k;
    }

    public o c() {
        return this.f.e();
    }

    public void d(int i2) {
        this.m = i2;
        a(false);
    }

    public void e(int i2) {
        this.n = i2;
        a(false);
    }

    public void f(int i2) {
        if (this.o != i2) {
            this.o = i2;
            this.p = true;
            a(false);
        }
    }

    public int g() {
        return this.n;
    }

    public u a(ViewGroup viewGroup) {
        if (this.f1514a == null) {
            this.f1514a = (NavigationMenuView) this.g.inflate(b.c.a.a.g.design_navigation_menu, viewGroup, false);
            NavigationMenuView navigationMenuView = this.f1514a;
            navigationMenuView.setAccessibilityDelegateCompat(new g(navigationMenuView));
            if (this.f == null) {
                this.f = new b();
            }
            this.f1515b = (LinearLayout) this.g.inflate(b.c.a.a.g.design_navigation_item_header, this.f1514a, false);
            this.f1514a.setAdapter(this.f);
        }
        return this.f1514a;
    }

    public View b(int i2) {
        View inflate = this.g.inflate(i2, this.f1515b, false);
        a(inflate);
        return inflate;
    }

    public void b(ColorStateList colorStateList) {
        this.j = colorStateList;
        a(false);
    }

    public void a(boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void b(boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void a(androidx.appcompat.view.menu.k kVar, boolean z) {
        t.a aVar = this.c;
        if (aVar != null) {
            aVar.a(kVar, z);
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f1514a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f1515b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void a(o oVar) {
        this.f.a(oVar);
    }

    public void a(View view) {
        this.f1515b.addView(view);
        NavigationMenuView navigationMenuView = this.f1514a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public View a(int i2) {
        return this.f1515b.getChildAt(i2);
    }

    public void a(ColorStateList colorStateList) {
        this.k = colorStateList;
        a(false);
    }

    public void a(Drawable drawable) {
        this.l = drawable;
        a(false);
    }

    public void a(I i2) {
        int e2 = i2.e();
        if (this.q != e2) {
            this.q = e2;
            if (this.f1515b.getChildCount() == 0) {
                NavigationMenuView navigationMenuView = this.f1514a;
                navigationMenuView.setPadding(0, this.q, 0, navigationMenuView.getPaddingBottom());
            }
        }
        y.a((View) this.f1515b, i2);
    }
}
