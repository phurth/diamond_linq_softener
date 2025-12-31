package androidx.recyclerview.widget;

import a.g.i.a.c;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean H = false;
    int I = -1;
    int[] J;
    View[] K;
    final SparseIntArray L = new SparseIntArray();
    final SparseIntArray M = new SparseIntArray();
    c N = new a();
    final Rect O = new Rect();
    private boolean P;

    public static final class a extends c {
        public int a(int i) {
            return 1;
        }

        public int d(int i, int i2) {
            return i % i2;
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f889a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f890b = new SparseIntArray();
        private boolean c = false;
        private boolean d = false;

        public abstract int a(int i);

        public void a() {
            this.f890b.clear();
        }

        public void b() {
            this.f889a.clear();
        }

        public int c(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int a2;
            if (!this.d || (a2 = a(this.f890b, i)) == -1) {
                i5 = 0;
                i4 = 0;
                i3 = 0;
            } else {
                i4 = this.f890b.get(a2);
                i3 = a2 + 1;
                i5 = a(a2) + b(a2, i2);
                if (i5 == i2) {
                    i4++;
                    i5 = 0;
                }
            }
            int a3 = a(i);
            while (i3 < i) {
                int a4 = a(i3);
                int i6 = i5 + a4;
                if (i6 == i2) {
                    i4++;
                    i6 = 0;
                } else if (i6 > i2) {
                    i4++;
                    i6 = a4;
                }
                i3++;
            }
            return i5 + a3 > i2 ? i4 + 1 : i4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int d(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.a(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.c
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.f889a
                int r2 = a((android.util.SparseIntArray) r2, (int) r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.f889a
                int r3 = r3.get(r2)
                int r4 = r5.a(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = 0
                r3 = 0
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.a(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = 0
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.d(int, int):int");
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2) {
            if (!this.d) {
                return c(i, i2);
            }
            int i3 = this.f890b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int c2 = c(i, i2);
            this.f890b.put(i, c2);
            return c2;
        }

        /* access modifiers changed from: package-private */
        public int b(int i, int i2) {
            if (!this.c) {
                return d(i, i2);
            }
            int i3 = this.f889a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int d2 = d(i, i2);
            this.f889a.put(i, d2);
            return d2;
        }

        static int a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        j(RecyclerView.i.a(context, attributeSet, i, i2).f920b);
    }

    private void L() {
        int e = e();
        for (int i = 0; i < e; i++) {
            b bVar = (b) c(i).getLayoutParams();
            int a2 = bVar.a();
            this.L.put(a2, bVar.f());
            this.M.put(a2, bVar.e());
        }
    }

    private void M() {
        this.L.clear();
        this.M.clear();
    }

    private void N() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    private void O() {
        int i;
        int i2;
        if (H() == 1) {
            i2 = q() - o();
            i = n();
        } else {
            i2 = h() - m();
            i = p();
        }
        k(i2 - i);
    }

    private int i(RecyclerView.u uVar) {
        int i;
        if (!(e() == 0 || uVar.a() == 0)) {
            E();
            boolean J2 = J();
            View b2 = b(!J2, true);
            View a2 = a(!J2, true);
            if (!(b2 == null || a2 == null)) {
                int a3 = this.N.a(l(b2), this.I);
                int a4 = this.N.a(l(a2), this.I);
                int min = Math.min(a3, a4);
                int max = Math.max(a3, a4);
                int a5 = this.N.a(uVar.a() - 1, this.I) + 1;
                if (this.x) {
                    i = Math.max(0, (a5 - max) - 1);
                } else {
                    i = Math.max(0, min);
                }
                if (!J2) {
                    return i;
                }
                return Math.round((((float) i) * (((float) Math.abs(this.u.a(a2) - this.u.d(b2))) / ((float) ((this.N.a(l(a2), this.I) - this.N.a(l(b2), this.I)) + 1)))) + ((float) (this.u.f() - this.u.d(b2))));
            }
        }
        return 0;
    }

    private void k(int i) {
        this.J = a(this.J, this.I, i);
    }

    public boolean C() {
        return this.D == null && !this.H;
    }

    public int a(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.s == 1) {
            return this.I;
        }
        if (uVar.a() < 1) {
            return 0;
        }
        return a(pVar, uVar, uVar.a() - 1) + 1;
    }

    public void b(boolean z) {
        if (!z) {
            super.b(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public RecyclerView.j c() {
        if (this.s == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    public void d(RecyclerView recyclerView) {
        this.N.b();
        this.N.a();
    }

    public void e(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (uVar.d()) {
            L();
        }
        super.e(pVar, uVar);
        M();
    }

    /* access modifiers changed from: package-private */
    public int f(int i, int i2) {
        if (this.s != 1 || !I()) {
            int[] iArr = this.J;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.J;
        int i3 = this.I;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public void g(RecyclerView.u uVar) {
        super.g(uVar);
        this.H = false;
    }

    public void j(int i) {
        if (i != this.I) {
            this.H = true;
            if (i >= 1) {
                this.I = i;
                this.N.b();
                y();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public static class b extends RecyclerView.j {
        int e = -1;
        int f = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public int b(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.s == 0) {
            return this.I;
        }
        if (uVar.a() < 1) {
            return 0;
        }
        return a(pVar, uVar, uVar.a() - 1) + 1;
    }

    private int c(RecyclerView.p pVar, RecyclerView.u uVar, int i) {
        if (!uVar.d()) {
            return this.N.a(i);
        }
        int i2 = this.L.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a2 = pVar.a(i);
        if (a2 != -1) {
            return this.N.a(a2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    public int f(RecyclerView.u uVar) {
        if (this.P) {
            return j(uVar);
        }
        return super.f(uVar);
    }

    public void a(RecyclerView.p pVar, RecyclerView.u uVar, View view, a.g.i.a.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int a2 = a(pVar, uVar, bVar.a());
        if (this.s == 0) {
            cVar.b((Object) c.C0009c.a(bVar.e(), bVar.f(), a2, 1, this.I > 1 && bVar.f() == this.I, false));
        } else {
            cVar.b((Object) c.C0009c.a(a2, 1, bVar.e(), bVar.f(), this.I > 1 && bVar.f() == this.I, false));
        }
    }

    public int e(RecyclerView.u uVar) {
        if (this.P) {
            return i(uVar);
        }
        return super.e(uVar);
    }

    private int j(RecyclerView.u uVar) {
        if (!(e() == 0 || uVar.a() == 0)) {
            E();
            View b2 = b(!J(), true);
            View a2 = a(!J(), true);
            if (!(b2 == null || a2 == null)) {
                if (!J()) {
                    return this.N.a(uVar.a() - 1, this.I) + 1;
                }
                return (int) ((((float) (this.u.a(a2) - this.u.d(b2))) / ((float) ((this.N.a(l(a2), this.I) - this.N.a(l(b2), this.I)) + 1))) * ((float) (this.N.a(uVar.a() - 1, this.I) + 1)));
            }
        }
        return 0;
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        this.N.b();
        this.N.a();
    }

    public int b(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        O();
        N();
        return super.b(i, pVar, uVar);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        j(i);
    }

    public int c(RecyclerView.u uVar) {
        if (this.P) {
            return j(uVar);
        }
        return super.c(uVar);
    }

    private void b(RecyclerView.p pVar, RecyclerView.u uVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b2 = b(pVar, uVar, aVar.f893b);
        if (z) {
            while (b2 > 0) {
                int i2 = aVar.f893b;
                if (i2 > 0) {
                    aVar.f893b = i2 - 1;
                    b2 = b(pVar, uVar, aVar.f893b);
                } else {
                    return;
                }
            }
            return;
        }
        int a2 = uVar.a() - 1;
        int i3 = aVar.f893b;
        while (i3 < a2) {
            int i4 = i3 + 1;
            int b3 = b(pVar, uVar, i4);
            if (b3 <= b2) {
                break;
            }
            i3 = i4;
            b2 = b3;
        }
        aVar.f893b = i3;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        this.N.b();
        this.N.a();
    }

    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.N.b();
        this.N.a();
    }

    private int b(RecyclerView.p pVar, RecyclerView.u uVar, int i) {
        if (!uVar.d()) {
            return this.N.b(i, this.I);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int a2 = pVar.a(i);
        if (a2 != -1) {
            return this.N.b(a2, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.N.b();
        this.N.a();
    }

    public RecyclerView.j a(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public RecyclerView.j a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    private void b(View view, int i, boolean z) {
        int i2;
        int i3;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f922b;
        int i4 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i5 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int f = f(bVar.e, bVar.f);
        if (this.s == 1) {
            i2 = RecyclerView.i.a(f, i, i5, bVar.width, false);
            i3 = RecyclerView.i.a(this.u.g(), i(), i4, bVar.height, true);
        } else {
            int a2 = RecyclerView.i.a(f, i, i4, bVar.height, false);
            int a3 = RecyclerView.i.a(this.u.g(), r(), i5, bVar.width, true);
            i3 = a2;
            i2 = a3;
        }
        a(view, i2, i3, z);
    }

    public boolean a(RecyclerView.j jVar) {
        return jVar instanceof b;
    }

    public void a(c cVar) {
        this.N = cVar;
    }

    public void a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.J == null) {
            super.a(rect, i, i2);
        }
        int n = n() + o();
        int p = p() + m();
        if (this.s == 1) {
            i4 = RecyclerView.i.a(i2, rect.height() + p, k());
            int[] iArr = this.J;
            i3 = RecyclerView.i.a(i, iArr[iArr.length - 1] + n, l());
        } else {
            i3 = RecyclerView.i.a(i, rect.width() + n, l());
            int[] iArr2 = this.J;
            i4 = RecyclerView.i.a(i2, iArr2[iArr2.length - 1] + p, k());
        }
        c(i3, i4);
    }

    public int b(RecyclerView.u uVar) {
        if (this.P) {
            return i(uVar);
        }
        return super.b(uVar);
    }

    static int[] a(int[] iArr, int i, int i2) {
        int i3;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.p pVar, RecyclerView.u uVar, LinearLayoutManager.a aVar, int i) {
        super.a(pVar, uVar, aVar, i);
        O();
        if (uVar.a() > 0 && !uVar.d()) {
            b(pVar, uVar, aVar, i);
        }
        N();
    }

    public int a(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        O();
        N();
        return super.a(i, pVar, uVar);
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.p pVar, RecyclerView.u uVar, int i, int i2, int i3) {
        E();
        int f = this.u.f();
        int b2 = this.u.b();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View c2 = c(i);
            int l = l(c2);
            if (l >= 0 && l < i3 && b(pVar, uVar, l) == 0) {
                if (((RecyclerView.j) c2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = c2;
                    }
                } else if (this.u.d(c2) < b2 && this.u.a(c2) >= f) {
                    return c2;
                } else {
                    if (view == null) {
                        view = c2;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private int a(RecyclerView.p pVar, RecyclerView.u uVar, int i) {
        if (!uVar.d()) {
            return this.N.a(i, this.I);
        }
        int a2 = pVar.a(i);
        if (a2 != -1) {
            return this.N.a(a2, this.I);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.u uVar, LinearLayoutManager.c cVar, RecyclerView.i.a aVar) {
        int i = this.I;
        for (int i2 = 0; i2 < this.I && cVar.a(uVar) && i > 0; i2++) {
            int i3 = cVar.d;
            aVar.a(i3, Math.max(0, cVar.g));
            i -= this.N.a(i3);
            cVar.d += cVar.e;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.p pVar, RecyclerView.u uVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        View a2;
        RecyclerView.p pVar2 = pVar;
        RecyclerView.u uVar2 = uVar;
        LinearLayoutManager.c cVar2 = cVar;
        LinearLayoutManager.b bVar2 = bVar;
        int e = this.u.e();
        boolean z = false;
        boolean z2 = e != 1073741824;
        int i11 = e() > 0 ? this.J[this.I] : 0;
        if (z2) {
            O();
        }
        boolean z3 = cVar2.e == 1;
        int i12 = this.I;
        if (!z3) {
            i12 = b(pVar2, uVar2, cVar2.d) + c(pVar2, uVar2, cVar2.d);
        }
        int i13 = i12;
        int i14 = 0;
        while (i14 < this.I && cVar2.a(uVar2) && i13 > 0) {
            int i15 = cVar2.d;
            int c2 = c(pVar2, uVar2, i15);
            if (c2 <= this.I) {
                i13 -= c2;
                if (i13 < 0 || (a2 = cVar2.a(pVar2)) == null) {
                    break;
                }
                this.K[i14] = a2;
                i14++;
            } else {
                throw new IllegalArgumentException("Item at position " + i15 + " requires " + c2 + " spans but GridLayoutManager has only " + this.I + " spans.");
            }
        }
        if (i14 == 0) {
            bVar2.f895b = true;
            return;
        }
        float f = 0.0f;
        a(pVar2, uVar2, i14, z3);
        int i16 = 0;
        int i17 = 0;
        while (i16 < i14) {
            View view = this.K[i16];
            if (cVar2.k == null) {
                if (z3) {
                    b(view);
                } else {
                    b(view, (int) z);
                }
            } else if (z3) {
                a(view);
            } else {
                a(view, z ? 1 : 0);
            }
            a(view, this.O);
            b(view, e, z);
            int b2 = this.u.b(view);
            if (b2 > i17) {
                i17 = b2;
            }
            float c3 = (((float) this.u.c(view)) * 1.0f) / ((float) ((b) view.getLayoutParams()).f);
            if (c3 > f) {
                f = c3;
            }
            i16++;
            z = false;
        }
        if (z2) {
            a(f, i11);
            i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                View view2 = this.K[i18];
                b(view2, 1073741824, true);
                int b3 = this.u.b(view2);
                if (b3 > i17) {
                    i17 = b3;
                }
            }
        }
        for (int i19 = 0; i19 < i14; i19++) {
            View view3 = this.K[i19];
            if (this.u.b(view3) != i17) {
                b bVar3 = (b) view3.getLayoutParams();
                Rect rect = bVar3.f922b;
                int i20 = rect.top + rect.bottom + bVar3.topMargin + bVar3.bottomMargin;
                int i21 = rect.left + rect.right + bVar3.leftMargin + bVar3.rightMargin;
                int f2 = f(bVar3.e, bVar3.f);
                if (this.s == 1) {
                    i10 = RecyclerView.i.a(f2, 1073741824, i21, bVar3.width, false);
                    i9 = View.MeasureSpec.makeMeasureSpec(i17 - i20, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - i21, 1073741824);
                    i9 = RecyclerView.i.a(f2, 1073741824, i20, bVar3.height, false);
                    i10 = makeMeasureSpec;
                }
                a(view3, i10, i9, true);
            }
        }
        int i22 = 0;
        bVar2.f894a = i17;
        if (this.s == 1) {
            if (cVar2.f == -1) {
                int i23 = cVar2.f897b;
                i3 = i23 - i17;
                i2 = i23;
            } else {
                int i24 = cVar2.f897b;
                i2 = i24 + i17;
                i3 = i24;
            }
            i4 = 0;
            i = 0;
        } else if (cVar2.f == -1) {
            i = cVar2.f897b;
            i4 = i - i17;
            i3 = 0;
            i2 = 0;
        } else {
            int i25 = cVar2.f897b;
            int i26 = i25 + i17;
            i3 = 0;
            i2 = 0;
            int i27 = i25;
            i = i26;
            i4 = i27;
        }
        while (i22 < i14) {
            View view4 = this.K[i22];
            b bVar4 = (b) view4.getLayoutParams();
            if (this.s != 1) {
                int p = p() + this.J[bVar4.e];
                i8 = i4;
                i7 = p;
                i5 = this.u.c(view4) + p;
                i6 = i;
            } else if (I()) {
                int n = n() + this.J[this.I - bVar4.e];
                i6 = n;
                i7 = i3;
                i5 = i2;
                i8 = n - this.u.c(view4);
            } else {
                int n2 = n() + this.J[bVar4.e];
                i8 = n2;
                i7 = i3;
                i5 = i2;
                i6 = this.u.c(view4) + n2;
            }
            a(view4, i8, i7, i6, i5);
            if (bVar4.c() || bVar4.b()) {
                bVar2.c = true;
            }
            bVar2.d |= view4.hasFocusable();
            i22++;
            i4 = i8;
            i3 = i7;
            i = i6;
            i2 = i5;
        }
        Arrays.fill(this.K, (Object) null);
    }

    private void a(float f, int i) {
        k(Math.max(Math.round(f * ((float) this.I)), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean z2;
        RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
        if (z) {
            z2 = b(view, i, i2, jVar);
        } else {
            z2 = a(view, i, i2, jVar);
        }
        if (z2) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.p pVar, RecyclerView.u uVar, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = i;
            i3 = 0;
            i2 = 1;
        } else {
            i3 = i - 1;
            i2 = -1;
        }
        while (i3 != i5) {
            View view = this.K[i3];
            b bVar = (b) view.getLayoutParams();
            bVar.f = c(pVar, uVar, l(view));
            bVar.e = i4;
            i4 += bVar.f;
            i3 += i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d7, code lost:
        if (r13 == (r2 > r8)) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f7, code lost:
        if (r13 == r11) goto L_0x00b7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View a(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.p r26, androidx.recyclerview.widget.RecyclerView.u r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.c((android.view.View) r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r5 = (androidx.recyclerview.widget.GridLayoutManager.b) r5
            int r6 = r5.e
            int r5 = r5.f
            int r5 = r5 + r6
            android.view.View r7 = super.a((android.view.View) r24, (int) r25, (androidx.recyclerview.widget.RecyclerView.p) r26, (androidx.recyclerview.widget.RecyclerView.u) r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.h((int) r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.x
            if (r7 == r10) goto L_0x0032
            r7 = 1
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.e()
            int r7 = r7 - r9
            r11 = -1
            r12 = -1
            goto L_0x0045
        L_0x003e:
            int r7 = r23.e()
            r11 = r7
            r7 = 0
            r12 = 1
        L_0x0045:
            int r13 = r0.s
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.I()
            if (r13 == 0) goto L_0x0051
            r13 = 1
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.a((androidx.recyclerview.widget.RecyclerView.p) r1, (androidx.recyclerview.widget.RecyclerView.u) r2, (int) r7)
            r10 = r4
            r8 = -1
            r15 = 0
            r16 = 0
            r17 = -1
        L_0x005d:
            if (r7 == r11) goto L_0x0147
            int r9 = r0.a((androidx.recyclerview.widget.RecyclerView.p) r1, (androidx.recyclerview.widget.RecyclerView.u) r2, (int) r7)
            android.view.View r1 = r0.c((int) r7)
            if (r1 != r3) goto L_0x006b
            goto L_0x0147
        L_0x006b:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0085
            if (r9 == r14) goto L_0x0085
            if (r4 == 0) goto L_0x0077
            goto L_0x0147
        L_0x0077:
            r18 = r3
            r19 = r8
            r21 = r10
            r20 = r11
            r8 = r16
            r10 = r17
            goto L_0x0133
        L_0x0085:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$b r9 = (androidx.recyclerview.widget.GridLayoutManager.b) r9
            int r2 = r9.e
            r18 = r3
            int r3 = r9.f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009d
            if (r2 != r6) goto L_0x009d
            if (r3 != r5) goto L_0x009d
            return r1
        L_0x009d:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a5
            if (r4 == 0) goto L_0x00ad
        L_0x00a5:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00b9
            if (r10 != 0) goto L_0x00b9
        L_0x00ad:
            r19 = r8
            r21 = r10
        L_0x00b1:
            r20 = r11
            r8 = r16
            r10 = r17
        L_0x00b7:
            r11 = 1
            goto L_0x0103
        L_0x00b9:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r10
            int r10 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00da
            if (r10 <= r15) goto L_0x00d0
        L_0x00cd:
            r19 = r8
            goto L_0x00b1
        L_0x00d0:
            if (r10 != r15) goto L_0x00fa
            if (r2 <= r8) goto L_0x00d6
            r10 = 1
            goto L_0x00d7
        L_0x00d6:
            r10 = 0
        L_0x00d7:
            if (r13 != r10) goto L_0x00fa
            goto L_0x00cd
        L_0x00da:
            if (r4 != 0) goto L_0x00fa
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.a((android.view.View) r1, (boolean) r8, (boolean) r11)
            if (r22 == 0) goto L_0x00fe
            r8 = r16
            if (r10 <= r8) goto L_0x00ef
            r10 = r17
            goto L_0x0103
        L_0x00ef:
            if (r10 != r8) goto L_0x0100
            r10 = r17
            if (r2 <= r10) goto L_0x00f6
            goto L_0x00f7
        L_0x00f6:
            r11 = 0
        L_0x00f7:
            if (r13 != r11) goto L_0x0102
            goto L_0x00b7
        L_0x00fa:
            r19 = r8
            r20 = r11
        L_0x00fe:
            r8 = r16
        L_0x0100:
            r10 = r17
        L_0x0102:
            r11 = 0
        L_0x0103:
            if (r11 == 0) goto L_0x0133
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0120
            int r4 = r9.e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r15 = r3
            r16 = r8
            r17 = r10
            r10 = r21
            r8 = r4
            r4 = r1
            goto L_0x013b
        L_0x0120:
            int r8 = r9.e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r3 = r3 - r2
            r10 = r1
            r16 = r3
            r17 = r8
            r8 = r19
            goto L_0x013b
        L_0x0133:
            r16 = r8
            r17 = r10
            r8 = r19
            r10 = r21
        L_0x013b:
            int r7 = r7 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005d
        L_0x0147:
            r21 = r10
            if (r4 == 0) goto L_0x014c
            goto L_0x014e
        L_0x014c:
            r4 = r21
        L_0x014e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u):android.view.View");
    }
}
