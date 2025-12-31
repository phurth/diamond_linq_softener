package androidx.appcompat.view.menu;

import a.g.i.C0038b;
import a.g.i.z;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class k implements a.g.c.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f468a = {1, 4, 5, 3, 2, 0};
    private boolean A;

    /* renamed from: b  reason: collision with root package name */
    private final Context f469b;
    private final Resources c;
    private boolean d;
    private boolean e;
    private a f;
    private ArrayList<o> g;
    private ArrayList<o> h;
    private boolean i;
    private ArrayList<o> j;
    private ArrayList<o> k;
    private boolean l;
    private int m = 0;
    private ContextMenu.ContextMenuInfo n;
    CharSequence o;
    Drawable p;
    View q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<o> w = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<t>> x = new CopyOnWriteArrayList<>();
    private o y;
    private boolean z = false;

    public interface a {
        void a(k kVar);

        boolean a(k kVar, MenuItem menuItem);
    }

    public interface b {
        boolean a(o oVar);
    }

    public k(Context context) {
        this.f469b = context;
        this.c = context.getResources();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = true;
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        this.l = true;
        e(true);
    }

    private void d(boolean z2) {
        if (!this.x.isEmpty()) {
            s();
            Iterator<WeakReference<t>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                t tVar = (t) next.get();
                if (tVar == null) {
                    this.x.remove(next);
                } else {
                    tVar.a(z2);
                }
            }
            r();
        }
    }

    private void e(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null && !this.x.isEmpty()) {
            Iterator<WeakReference<t>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                t tVar = (t) next.get();
                if (tVar == null) {
                    this.x.remove(next);
                } else {
                    int id = tVar.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        tVar.a(parcelable);
                    }
                }
            }
        }
    }

    private void f(Bundle bundle) {
        Parcelable b2;
        if (!this.x.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<t>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                t tVar = (t) next.get();
                if (tVar == null) {
                    this.x.remove(next);
                } else {
                    int id = tVar.getId();
                    if (id > 0 && (b2 = tVar.b()) != null) {
                        sparseArray.put(id, b2);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public void a(t tVar) {
        a(tVar, this.f469b);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f469b.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(t tVar) {
        Iterator<WeakReference<t>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            t tVar2 = (t) next.get();
            if (tVar2 == null || tVar2 == tVar) {
                this.x.remove(next);
            }
        }
    }

    public k c(int i2) {
        this.m = i2;
        return this;
    }

    public void clear() {
        o oVar = this.y;
        if (oVar != null) {
            a(oVar);
        }
        this.g.clear();
        b(true);
    }

    public void clearHeader() {
        this.p = null;
        this.o = null;
        this.q = null;
        b(false);
    }

    public void close() {
        a(true);
    }

    /* access modifiers changed from: protected */
    public String d() {
        return "android:menu:actionviewstates";
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = this.g.get(i3);
            if (oVar.getItemId() == i2) {
                return oVar;
            }
            if (oVar.hasSubMenu() && (findItem = oVar.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public Drawable g() {
        return this.p;
    }

    public MenuItem getItem(int i2) {
        return this.g.get(i2);
    }

    public CharSequence h() {
        return this.o;
    }

    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.g.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public View i() {
        return this.q;
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return a(i2, keyEvent) != null;
    }

    public ArrayList<o> j() {
        b();
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public Resources l() {
        return this.c;
    }

    public k m() {
        return this;
    }

    public ArrayList<o> n() {
        if (!this.i) {
            return this.h;
        }
        this.h.clear();
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            o oVar = this.g.get(i2);
            if (oVar.isVisible()) {
                this.h.add(oVar);
            }
        }
        this.i = false;
        this.l = true;
        return this.h;
    }

    public boolean o() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.d;
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return a(findItem(i2), i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        o a2 = a(i2, keyEvent);
        boolean a3 = a2 != null ? a((MenuItem) a2, i3) : false;
        if ((i3 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    public boolean q() {
        return this.e;
    }

    public void r() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(this.t);
        }
    }

    public void removeGroup(int i2) {
        int a2 = a(i2);
        if (a2 >= 0) {
            int size = this.g.size() - a2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.g.get(a2).getGroupId() != i2) {
                    b(true);
                } else {
                    a(a2, false);
                    i3 = i4;
                }
            }
            b(true);
        }
    }

    public void removeItem(int i2) {
        a(b(i2), true);
    }

    public void s() {
        if (!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.g.size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = this.g.get(i3);
            if (oVar.getGroupId() == i2) {
                oVar.c(z3);
                oVar.setCheckable(z2);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.z = z2;
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.g.size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = this.g.get(i3);
            if (oVar.getGroupId() == i2) {
                oVar.setEnabled(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.g.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = this.g.get(i3);
            if (oVar.getGroupId() == i2 && oVar.e(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            b(true);
        }
    }

    public void setQwertyMode(boolean z2) {
        this.d = z2;
        b(false);
    }

    public int size() {
        return this.g.size();
    }

    public void a(t tVar, Context context) {
        this.x.add(new WeakReference(tVar));
        tVar.a(context, this);
        this.l = true;
    }

    public MenuItem add(int i2) {
        return a(0, 0, 0, this.c.getString(i2));
    }

    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, (CharSequence) this.c.getString(i2));
    }

    public void c(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((A) item.getSubMenu()).c(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(d(), sparseArray);
        }
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        o oVar = (o) a(i2, i3, i4, charSequence);
        A a2 = new A(this.f469b, this, oVar);
        oVar.a(a2);
        return a2;
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.c.getString(i5));
    }

    public void b(Bundle bundle) {
        e(bundle);
    }

    private boolean a(A a2, t tVar) {
        boolean z2 = false;
        if (this.x.isEmpty()) {
            return false;
        }
        if (tVar != null) {
            z2 = tVar.a(a2);
        }
        Iterator<WeakReference<t>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            t tVar2 = (t) next.get();
            if (tVar2 == null) {
                this.x.remove(next);
            } else if (!z2) {
                z2 = tVar2.a(a2);
            }
        }
        return z2;
    }

    public int b(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.g.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, (CharSequence) this.c.getString(i5));
    }

    public void b(boolean z2) {
        if (!this.r) {
            if (z2) {
                this.i = true;
                this.l = true;
            }
            d(z2);
            return;
        }
        this.s = true;
        if (z2) {
            this.t = true;
        }
    }

    public void d(Bundle bundle) {
        f(bundle);
    }

    private void e(boolean z2) {
        boolean z3 = true;
        if (!z2 || this.c.getConfiguration().keyboard == 1 || !z.c(ViewConfiguration.get(this.f469b), this.f469b)) {
            z3 = false;
        }
        this.e = z3;
    }

    /* access modifiers changed from: package-private */
    public void d(o oVar) {
        this.i = true;
        b(true);
    }

    private static int f(int i2) {
        int i3 = (-65536 & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = f468a;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public void a(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(d());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((A) item.getSubMenu()).a(bundle);
                }
            }
            int i3 = bundle.getInt("android:menu:expandedactionview");
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    /* access modifiers changed from: protected */
    public k d(int i2) {
        a(0, (CharSequence) null, i2, (Drawable) null, (View) null);
        return this;
    }

    public Context e() {
        return this.f469b;
    }

    public o f() {
        return this.y;
    }

    public void b() {
        ArrayList<o> n2 = n();
        if (this.l) {
            Iterator<WeakReference<t>> it = this.x.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                t tVar = (t) next.get();
                if (tVar == null) {
                    this.x.remove(next);
                } else {
                    z2 |= tVar.a();
                }
            }
            if (z2) {
                this.j.clear();
                this.k.clear();
                int size = n2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    o oVar = n2.get(i2);
                    if (oVar.h()) {
                        this.j.add(oVar);
                    } else {
                        this.k.add(oVar);
                    }
                }
            } else {
                this.j.clear();
                this.k.clear();
                this.k.addAll(n());
            }
            this.l = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(o oVar) {
        this.l = true;
        b(true);
    }

    /* access modifiers changed from: protected */
    public k e(int i2) {
        a(i2, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public ArrayList<o> c() {
        b();
        return this.j;
    }

    public void c(boolean z2) {
        this.A = z2;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int f2 = f(i4);
        o a2 = a(i2, i3, i4, f2, charSequence, this.m);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.n;
        if (contextMenuInfo != null) {
            a2.a(contextMenuInfo);
        }
        ArrayList<o> arrayList = this.g;
        arrayList.add(a(arrayList, f2), a2);
        b(true);
        return a2;
    }

    private o a(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new o(this, i2, i3, i4, i5, charSequence, i6);
    }

    public boolean b(o oVar) {
        boolean z2 = false;
        if (this.x.isEmpty()) {
            return false;
        }
        s();
        Iterator<WeakReference<t>> it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            t tVar = (t) next.get();
            if (tVar == null) {
                this.x.remove(next);
            } else {
                z2 = tVar.b(this, oVar);
                if (z2) {
                    break;
                }
            }
        }
        r();
        if (z2) {
            this.y = oVar;
        }
        return z2;
    }

    private void a(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.g.size()) {
            this.g.remove(i2);
            if (z2) {
                b(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.g.size();
        s();
        for (int i2 = 0; i2 < size; i2++) {
            o oVar = this.g.get(i2);
            if (oVar.getGroupId() == groupId && oVar.i() && oVar.isCheckable()) {
                oVar.b(oVar == menuItem);
            }
        }
        r();
    }

    public int a(int i2) {
        return a(i2, 0);
    }

    public int a(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.g.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean a(k kVar, MenuItem menuItem) {
        a aVar = this.f;
        return aVar != null && aVar.a(kVar, menuItem);
    }

    public void a() {
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    private static int a(ArrayList<o> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void a(List<o> list, int i2, KeyEvent keyEvent) {
        boolean p2 = p();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.g.size();
            for (int i3 = 0; i3 < size; i3++) {
                o oVar = this.g.get(i3);
                if (oVar.hasSubMenu()) {
                    ((k) oVar.getSubMenu()).a(list, i2, keyEvent);
                }
                char alphabeticShortcut = p2 ? oVar.getAlphabeticShortcut() : oVar.getNumericShortcut();
                if (((modifiers & 69647) == ((p2 ? oVar.getAlphabeticModifiers() : oVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (p2 && alphabeticShortcut == 8 && i2 == 67)) && oVar.isEnabled()) {
                        list.add(oVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public o a(int i2, KeyEvent keyEvent) {
        char c2;
        ArrayList<o> arrayList = this.w;
        arrayList.clear();
        a((List<o>) arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean p2 = p();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = arrayList.get(i3);
            if (p2) {
                c2 = oVar.getAlphabeticShortcut();
            } else {
                c2 = oVar.getNumericShortcut();
            }
            if ((c2 == keyData.meta[0] && (metaState & 2) == 0) || ((c2 == keyData.meta[2] && (metaState & 2) != 0) || (p2 && c2 == 8 && i2 == 67))) {
                return oVar;
            }
        }
        return null;
    }

    public boolean a(MenuItem menuItem, int i2) {
        return a(menuItem, (t) null, i2);
    }

    public boolean a(MenuItem menuItem, t tVar, int i2) {
        o oVar = (o) menuItem;
        if (oVar == null || !oVar.isEnabled()) {
            return false;
        }
        boolean g2 = oVar.g();
        C0038b a2 = oVar.a();
        boolean z2 = a2 != null && a2.a();
        if (oVar.f()) {
            g2 |= oVar.expandActionView();
            if (g2) {
                a(true);
            }
        } else if (oVar.hasSubMenu() || z2) {
            if ((i2 & 4) == 0) {
                a(false);
            }
            if (!oVar.hasSubMenu()) {
                oVar.a(new A(e(), this, oVar));
            }
            A a3 = (A) oVar.getSubMenu();
            if (z2) {
                a2.a((SubMenu) a3);
            }
            g2 |= a(a3, tVar);
            if (!g2) {
                a(true);
            }
        } else if ((i2 & 1) == 0) {
            a(true);
        }
        return g2;
    }

    public final void a(boolean z2) {
        if (!this.v) {
            this.v = true;
            Iterator<WeakReference<t>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                t tVar = (t) next.get();
                if (tVar == null) {
                    this.x.remove(next);
                } else {
                    tVar.a(this, z2);
                }
            }
            this.v = false;
        }
    }

    private void a(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources l2 = l();
        if (view != null) {
            this.q = view;
            this.o = null;
            this.p = null;
        } else {
            if (i2 > 0) {
                this.o = l2.getText(i2);
            } else if (charSequence != null) {
                this.o = charSequence;
            }
            if (i3 > 0) {
                this.p = a.g.a.a.c(e(), i3);
            } else if (drawable != null) {
                this.p = drawable;
            }
            this.q = null;
        }
        b(false);
    }

    /* access modifiers changed from: protected */
    public k a(CharSequence charSequence) {
        a(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public k a(Drawable drawable) {
        a(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    /* access modifiers changed from: protected */
    public k a(View view) {
        a(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public boolean a(o oVar) {
        boolean z2 = false;
        if (!this.x.isEmpty() && this.y == oVar) {
            s();
            Iterator<WeakReference<t>> it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                t tVar = (t) next.get();
                if (tVar == null) {
                    this.x.remove(next);
                } else {
                    z2 = tVar.a(this, oVar);
                    if (z2) {
                        break;
                    }
                }
            }
            r();
            if (z2) {
                this.y = null;
            }
        }
        return z2;
    }
}
