package androidx.appcompat.view.menu;

import a.a.g;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.view.menu.u;
import java.util.ArrayList;

public class i implements t, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    Context f462a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f463b;
    k c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    private t.a h;
    a i;
    private int j;

    private class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private int f464a = -1;

        public a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            o f = i.this.c.f();
            if (f != null) {
                ArrayList<o> j = i.this.c.j();
                int size = j.size();
                for (int i = 0; i < size; i++) {
                    if (j.get(i) == f) {
                        this.f464a = i;
                        return;
                    }
                }
            }
            this.f464a = -1;
        }

        public int getCount() {
            int size = i.this.c.j().size() - i.this.e;
            return this.f464a < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                i iVar = i.this;
                view = iVar.f463b.inflate(iVar.g, viewGroup, false);
            }
            ((u.a) view).a(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        public o getItem(int i) {
            ArrayList<o> j = i.this.c.j();
            int i2 = i + i.this.e;
            int i3 = this.f464a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return j.get(i2);
        }
    }

    public i(Context context, int i2) {
        this(i2, 0);
        this.f462a = context;
        this.f463b = LayoutInflater.from(this.f462a);
    }

    public void a(Context context, k kVar) {
        int i2 = this.f;
        if (i2 != 0) {
            this.f462a = new ContextThemeWrapper(context, i2);
            this.f463b = LayoutInflater.from(this.f462a);
        } else if (this.f462a != null) {
            this.f462a = context;
            if (this.f463b == null) {
                this.f463b = LayoutInflater.from(this.f462a);
            }
        }
        this.c = kVar;
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public boolean a() {
        return false;
    }

    public boolean a(k kVar, o oVar) {
        return false;
    }

    public void b(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public boolean b(k kVar, o oVar) {
        return false;
    }

    public ListAdapter c() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    public int getId() {
        return this.j;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.c.a((MenuItem) this.i.getItem(i2), (t) this, 0);
    }

    public i(int i2, int i3) {
        this.g = i2;
        this.f = i3;
    }

    public Parcelable b() {
        if (this.d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        b(bundle);
        return bundle;
    }

    public u a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.f463b.inflate(g.abc_expanded_menu_layout, viewGroup, false);
            if (this.i == null) {
                this.i = new a();
            }
            this.d.setAdapter(this.i);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    public void a(boolean z) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void a(t.a aVar) {
        this.h = aVar;
    }

    public boolean a(A a2) {
        if (!a2.hasVisibleItems()) {
            return false;
        }
        new l(a2).a((IBinder) null);
        t.a aVar = this.h;
        if (aVar == null) {
            return true;
        }
        aVar.a(a2);
        return true;
    }

    public void a(k kVar, boolean z) {
        t.a aVar = this.h;
        if (aVar != null) {
            aVar.a(kVar, z);
        }
    }

    public void a(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void a(Parcelable parcelable) {
        a((Bundle) parcelable);
    }
}
