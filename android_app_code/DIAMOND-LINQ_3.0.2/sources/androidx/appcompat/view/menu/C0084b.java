package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.t;
import androidx.appcompat.view.menu.u;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.b  reason: case insensitive filesystem */
public abstract class C0084b implements t {

    /* renamed from: a  reason: collision with root package name */
    protected Context f450a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f451b;
    protected k c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    private t.a f;
    private int g;
    private int h;
    protected u i;
    private int j;

    public C0084b(Context context, int i2, int i3) {
        this.f450a = context;
        this.d = LayoutInflater.from(context);
        this.g = i2;
        this.h = i3;
    }

    public void a(Context context, k kVar) {
        this.f451b = context;
        this.e = LayoutInflater.from(this.f451b);
        this.c = kVar;
    }

    public abstract void a(o oVar, u.a aVar);

    public abstract boolean a(int i2, o oVar);

    public boolean a(k kVar, o oVar) {
        return false;
    }

    public u b(ViewGroup viewGroup) {
        if (this.i == null) {
            this.i = (u) this.d.inflate(this.g, viewGroup, false);
            this.i.a(this.c);
            a(true);
        }
        return this.i;
    }

    public boolean b(k kVar, o oVar) {
        return false;
    }

    public t.a c() {
        return this.f;
    }

    public int getId() {
        return this.j;
    }

    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.i;
        if (viewGroup != null) {
            k kVar = this.c;
            int i2 = 0;
            if (kVar != null) {
                kVar.b();
                ArrayList<o> n = this.c.n();
                int size = n.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    o oVar = n.get(i4);
                    if (a(i3, oVar)) {
                        View childAt = viewGroup.getChildAt(i3);
                        o itemData = childAt instanceof u.a ? ((u.a) childAt).getItemData() : null;
                        View a2 = a(oVar, childAt, viewGroup);
                        if (oVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            a(a2, i3);
                        }
                        i3++;
                    }
                }
                i2 = i3;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!a(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.i).addView(view, i2);
    }

    /* access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public void a(t.a aVar) {
        this.f = aVar;
    }

    public u.a a(ViewGroup viewGroup) {
        return (u.a) this.d.inflate(this.h, viewGroup, false);
    }

    public View a(o oVar, View view, ViewGroup viewGroup) {
        u.a aVar;
        if (view instanceof u.a) {
            aVar = (u.a) view;
        } else {
            aVar = a(viewGroup);
        }
        a(oVar, aVar);
        return (View) aVar;
    }

    public void a(k kVar, boolean z) {
        t.a aVar = this.f;
        if (aVar != null) {
            aVar.a(kVar, z);
        }
    }

    public boolean a(A a2) {
        t.a aVar = this.f;
        if (aVar != null) {
            return aVar.a(a2);
        }
        return false;
    }

    public void a(int i2) {
        this.j = i2;
    }
}
