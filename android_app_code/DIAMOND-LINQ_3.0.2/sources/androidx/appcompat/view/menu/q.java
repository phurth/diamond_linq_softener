package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

abstract class q implements w, t, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Rect f480a;

    q() {
    }

    protected static boolean b(k kVar) {
        int size = kVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = kVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void a(int i);

    public void a(Context context, k kVar) {
    }

    public void a(Rect rect) {
        this.f480a = rect;
    }

    public abstract void a(View view);

    public abstract void a(PopupWindow.OnDismissListener onDismissListener);

    public abstract void a(k kVar);

    public boolean a(k kVar, o oVar) {
        return false;
    }

    public abstract void b(int i);

    public abstract void b(boolean z);

    public boolean b(k kVar, o oVar) {
        return false;
    }

    public abstract void c(int i);

    public abstract void c(boolean z);

    /* access modifiers changed from: protected */
    public boolean e() {
        return true;
    }

    public Rect g() {
        return this.f480a;
    }

    public int getId() {
        return 0;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        a(listAdapter).f466a.a((MenuItem) listAdapter.getItem(i), (t) this, e() ? 0 : 4);
    }

    protected static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    protected static j a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (j) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (j) listAdapter;
    }
}
