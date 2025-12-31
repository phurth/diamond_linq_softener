package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.u;
import java.util.ArrayList;

public class j extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    k f466a;

    /* renamed from: b  reason: collision with root package name */
    private int f467b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public j(k kVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.f466a = kVar;
        this.f = i;
        a();
    }

    public void a(boolean z) {
        this.c = z;
    }

    public k b() {
        return this.f466a;
    }

    public int getCount() {
        ArrayList<o> j = this.d ? this.f466a.j() : this.f466a.n();
        if (this.f467b < 0) {
            return j.size();
        }
        return j.size() - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f466a.o() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        u.a aVar = (u.a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        o f2 = this.f466a.f();
        if (f2 != null) {
            ArrayList<o> j = this.f466a.j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (j.get(i) == f2) {
                    this.f467b = i;
                    return;
                }
            }
        }
        this.f467b = -1;
    }

    public o getItem(int i) {
        ArrayList<o> j = this.d ? this.f466a.j() : this.f466a.n();
        int i2 = this.f467b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return j.get(i);
    }
}
