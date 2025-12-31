package androidx.recyclerview.widget;

import a.g.i.a.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.i implements RecyclerView.t.a {
    boolean A = false;
    private BitSet B;
    int C = -1;
    int D = Integer.MIN_VALUE;
    c E = new c();
    private int F = 2;
    private boolean G;
    private boolean H;
    private d I;
    private int J;
    private final Rect K = new Rect();
    private final a L = new a();
    private boolean M = false;
    private boolean N = true;
    private int[] O;
    private final Runnable P = new K(this);
    private int s = -1;
    e[] t;
    x u;
    x v;
    private int w;
    private int x;
    private final s y;
    boolean z = false;

    public static class b extends RecyclerView.j {
        e e;
        boolean f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int e() {
            e eVar = this.e;
            if (eVar == null) {
                return -1;
            }
            return eVar.e;
        }

        public boolean f() {
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

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new M();

        /* renamed from: a  reason: collision with root package name */
        int f943a;

        /* renamed from: b  reason: collision with root package name */
        int f944b;
        int c;
        int[] d;
        int e;
        int[] f;
        List<c.a> g;
        boolean h;
        boolean i;
        boolean j;

        public d() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.d = null;
            this.c = 0;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f943a);
            parcel.writeInt(this.f944b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.d);
            }
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f);
            }
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeList(this.g);
        }

        d(Parcel parcel) {
            this.f943a = parcel.readInt();
            this.f944b = parcel.readInt();
            this.c = parcel.readInt();
            int i2 = this.c;
            if (i2 > 0) {
                this.d = new int[i2];
                parcel.readIntArray(this.d);
            }
            this.e = parcel.readInt();
            int i3 = this.e;
            if (i3 > 0) {
                this.f = new int[i3];
                parcel.readIntArray(this.f);
            }
            boolean z = false;
            this.h = parcel.readInt() == 1;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1 ? true : z;
            this.g = parcel.readArrayList(c.a.class.getClassLoader());
        }

        public d(d dVar) {
            this.c = dVar.c;
            this.f943a = dVar.f943a;
            this.f944b = dVar.f944b;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.h = dVar.h;
            this.i = dVar.i;
            this.j = dVar.j;
            this.g = dVar.g;
        }
    }

    class e {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f945a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f946b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = 0;
        final int e;

        e(int i) {
            this.e = i;
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            int i2 = this.c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f945a.size() == 0) {
                return i;
            }
            a();
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            int i2 = this.f946b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f945a.size() == 0) {
                return i;
            }
            b();
            return this.f946b;
        }

        /* access modifiers changed from: package-private */
        public void c(View view) {
            b b2 = b(view);
            b2.e = this;
            this.f945a.add(0, view);
            this.f946b = Integer.MIN_VALUE;
            if (this.f945a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(int i) {
            this.f946b = i;
            this.c = i;
        }

        public int e() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(0, this.f945a.size(), true);
            }
            return a(this.f945a.size() - 1, -1, true);
        }

        public int f() {
            return this.d;
        }

        /* access modifiers changed from: package-private */
        public int g() {
            int i = this.c;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            a();
            return this.c;
        }

        /* access modifiers changed from: package-private */
        public int h() {
            int i = this.f946b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            b();
            return this.f946b;
        }

        /* access modifiers changed from: package-private */
        public void i() {
            this.f946b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int size = this.f945a.size();
            View remove = this.f945a.remove(size - 1);
            b b2 = b(remove);
            b2.e = null;
            if (b2.c() || b2.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            if (size == 1) {
                this.f946b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void k() {
            View remove = this.f945a.remove(0);
            b b2 = b(remove);
            b2.e = null;
            if (this.f945a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.d -= StaggeredGridLayoutManager.this.u.b(remove);
            }
            this.f946b = Integer.MIN_VALUE;
        }

        public int d() {
            if (StaggeredGridLayoutManager.this.z) {
                return a(this.f945a.size() - 1, -1, true);
            }
            return a(0, this.f945a.size(), true);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            c.a c2;
            ArrayList<View> arrayList = this.f945a;
            View view = arrayList.get(arrayList.size() - 1);
            b b2 = b(view);
            this.c = StaggeredGridLayoutManager.this.u.a(view);
            if (b2.f && (c2 = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c2.f942b == 1) {
                this.c += c2.a(this.e);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            c.a c2;
            View view = this.f945a.get(0);
            b b2 = b(view);
            this.f946b = StaggeredGridLayoutManager.this.u.d(view);
            if (b2.f && (c2 = StaggeredGridLayoutManager.this.E.c(b2.a())) != null && c2.f942b == -1) {
                this.f946b -= c2.a(this.e);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f945a.clear();
            i();
            this.d = 0;
        }

        /* access modifiers changed from: package-private */
        public void c(int i) {
            int i2 = this.f946b;
            if (i2 != Integer.MIN_VALUE) {
                this.f946b = i2 + i;
            }
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                this.c = i3 + i;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            b b2 = b(view);
            b2.e = this;
            this.f945a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.f945a.size() == 1) {
                this.f946b = Integer.MIN_VALUE;
            }
            if (b2.c() || b2.b()) {
                this.d += StaggeredGridLayoutManager.this.u.b(view);
            }
        }

        /* access modifiers changed from: package-private */
        public b b(View view) {
            return (b) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z, int i) {
            int i2;
            if (z) {
                i2 = a(Integer.MIN_VALUE);
            } else {
                i2 = b(Integer.MIN_VALUE);
            }
            c();
            if (i2 != Integer.MIN_VALUE) {
                if (z && i2 < StaggeredGridLayoutManager.this.u.b()) {
                    return;
                }
                if (z || i2 <= StaggeredGridLayoutManager.this.u.f()) {
                    if (i != Integer.MIN_VALUE) {
                        i2 += i;
                    }
                    this.c = i2;
                    this.f946b = i2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int f2 = StaggeredGridLayoutManager.this.u.f();
            int b2 = StaggeredGridLayoutManager.this.u.b();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f945a.get(i);
                int d2 = StaggeredGridLayoutManager.this.u.d(view);
                int a2 = StaggeredGridLayoutManager.this.u.a(view);
                boolean z4 = false;
                boolean z5 = !z3 ? d2 < b2 : d2 <= b2;
                if (!z3 ? a2 > f2 : a2 >= f2) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.l(view);
                        }
                        if (d2 < f2 || a2 > b2) {
                            return StaggeredGridLayoutManager.this.l(view);
                        }
                    } else if (d2 >= f2 && a2 <= b2) {
                        return StaggeredGridLayoutManager.this.l(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int a(int i, int i2, boolean z) {
            return a(i, i2, false, false, z);
        }

        public View a(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f945a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f945a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.l(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.l(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f945a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f945a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.l(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.l(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.i.b a2 = RecyclerView.i.a(context, attributeSet, i, i2);
        h(a2.f919a);
        i(a2.f920b);
        c(a2.c);
        this.y = new s();
        M();
    }

    private void M() {
        this.u = x.a(this, this.w);
        this.v = x.a(this, 1 - this.w);
    }

    private void N() {
        if (this.v.d() != 1073741824) {
            int e2 = e();
            float f = 0.0f;
            for (int i = 0; i < e2; i++) {
                View c2 = c(i);
                float b2 = (float) this.v.b(c2);
                if (b2 >= f) {
                    if (((b) c2.getLayoutParams()).f()) {
                        b2 = (b2 * 1.0f) / ((float) this.s);
                    }
                    f = Math.max(f, b2);
                }
            }
            int i2 = this.x;
            int round = Math.round(f * ((float) this.s));
            if (this.v.d() == Integer.MIN_VALUE) {
                round = Math.min(round, this.v.g());
            }
            j(round);
            if (this.x != i2) {
                for (int i3 = 0; i3 < e2; i3++) {
                    View c3 = c(i3);
                    b bVar = (b) c3.getLayoutParams();
                    if (!bVar.f) {
                        if (!L() || this.w != 1) {
                            int i4 = bVar.e.e;
                            int i5 = this.x * i4;
                            int i6 = i4 * i2;
                            if (this.w == 1) {
                                c3.offsetLeftAndRight(i5 - i6);
                            } else {
                                c3.offsetTopAndBottom(i5 - i6);
                            }
                        } else {
                            int i7 = this.s;
                            int i8 = bVar.e.e;
                            c3.offsetLeftAndRight(((-((i7 - 1) - i8)) * this.x) - ((-((i7 - 1) - i8)) * i2));
                        }
                    }
                }
            }
        }
    }

    private void O() {
        if (this.w == 1 || !L()) {
            this.A = this.z;
        } else {
            this.A = !this.z;
        }
    }

    private boolean a(e eVar) {
        if (this.A) {
            if (eVar.g() < this.u.b()) {
                ArrayList<View> arrayList = eVar.f945a;
                return !eVar.b(arrayList.get(arrayList.size() - 1)).f;
            }
        } else if (eVar.h() > this.u.f()) {
            return !eVar.b(eVar.f945a.get(0)).f;
        }
        return false;
    }

    private int k(int i) {
        if (e() != 0) {
            if ((i < H()) != this.A) {
                return -1;
            }
            return 1;
        } else if (this.A) {
            return 1;
        } else {
            return -1;
        }
    }

    private int l(int i) {
        if (i == 1) {
            return (this.w != 1 && L()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.w != 1 && L()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    return (i == 130 && this.w == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.w == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.w == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.w == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private c.a m(int i) {
        c.a aVar = new c.a();
        aVar.c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.c[i2] = i - this.t[i2].a(i);
        }
        return aVar;
    }

    private c.a n(int i) {
        c.a aVar = new c.a();
        aVar.c = new int[this.s];
        for (int i2 = 0; i2 < this.s; i2++) {
            aVar.c[i2] = this.t[i2].b(i) - i;
        }
        return aVar;
    }

    private int o(int i) {
        int e2 = e();
        for (int i2 = 0; i2 < e2; i2++) {
            int l = l(c(i2));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    private void p(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].a(view);
        }
    }

    private void q(View view) {
        for (int i = this.s - 1; i >= 0; i--) {
            this.t[i].c(view);
        }
    }

    private int r(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private int s(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private int t(int i) {
        int b2 = this.t[0].b(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int b3 = this.t[i2].b(i);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void v(int i) {
        s sVar = this.y;
        sVar.e = i;
        int i2 = 1;
        if (this.A != (i == -1)) {
            i2 = -1;
        }
        sVar.d = i2;
    }

    public boolean C() {
        return this.I == null;
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        int a2 = this.t[0].a(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        int b2 = this.t[0].b(Integer.MIN_VALUE);
        for (int i = 1; i < this.s; i++) {
            if (this.t[i].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        int i;
        int i2;
        if (e() == 0 || this.F == 0 || !t()) {
            return false;
        }
        if (this.A) {
            i2 = I();
            i = H();
        } else {
            i2 = H();
            i = I();
        }
        if (i2 == 0 && J() != null) {
            this.E.a();
            z();
            y();
            return true;
        } else if (!this.M) {
            return false;
        } else {
            int i3 = this.A ? -1 : 1;
            int i4 = i + 1;
            c.a a2 = this.E.a(i2, i4, i3, true);
            if (a2 == null) {
                this.M = false;
                this.E.b(i4);
                return false;
            }
            c.a a3 = this.E.a(i2, a2.f941a, i3 * -1, true);
            if (a3 == null) {
                this.E.b(a2.f941a);
            } else {
                this.E.b(a3.f941a + 1);
            }
            z();
            y();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public int G() {
        View view;
        if (this.A) {
            view = a(true);
        } else {
            view = b(true);
        }
        if (view == null) {
            return -1;
        }
        return l(view);
    }

    /* access modifiers changed from: package-private */
    public int H() {
        if (e() == 0) {
            return 0;
        }
        return l(c(0));
    }

    /* access modifiers changed from: package-private */
    public int I() {
        int e2 = e();
        if (e2 == 0) {
            return 0;
        }
        return l(c(e2 - 1));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View J() {
        /*
            r12 = this;
            int r0 = r12.e()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.s
            r2.<init>(r3)
            int r3 = r12.s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.w
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.L()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.A
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.c((int) r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.e
            int r9 = r9.e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.e
            boolean r9 = r12.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.e) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r8.e
            int r9 = r9.e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.c((int) r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.x r10 = r12.u
            int r10 = r10.a((android.view.View) r7)
            androidx.recyclerview.widget.x r11 = r12.u
            int r11 = r11.a((android.view.View) r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.x r10 = r12.u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.x r11 = r12.u
            int r11 = r11.d(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r8 = r8.e
            int r8 = r8.e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e r9 = r9.e
            int r9 = r9.e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.J():android.view.View");
    }

    public void K() {
        this.E.a();
        y();
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        return j() == 1;
    }

    public void b(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.b(recyclerView, pVar);
        a(this.P);
        for (int i = 0; i < this.s; i++) {
            this.t[i].c();
        }
        recyclerView.requestLayout();
    }

    public void c(boolean z2) {
        a((String) null);
        d dVar = this.I;
        if (!(dVar == null || dVar.h == z2)) {
            dVar.h = z2;
        }
        this.z = z2;
        y();
    }

    public int d(RecyclerView.u uVar) {
        return h(uVar);
    }

    public void e(RecyclerView.p pVar, RecyclerView.u uVar) {
        c(pVar, uVar, true);
    }

    public void f(int i) {
        if (i == 0) {
            F();
        }
    }

    public void g(RecyclerView.u uVar) {
        super.g(uVar);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.b();
    }

    public void h(int i) {
        if (i == 0 || i == 1) {
            a((String) null);
            if (i != this.w) {
                this.w = i;
                x xVar = this.u;
                this.u = this.v;
                this.v = xVar;
                y();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void i(int i) {
        a((String) null);
        if (i != this.s) {
            K();
            this.s = i;
            this.B = new BitSet(this.s);
            this.t = new e[this.s];
            for (int i2 = 0; i2 < this.s; i2++) {
                this.t[i2] = new e(i2);
            }
            y();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(int i) {
        this.x = i / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(i, this.v.d());
    }

    public boolean u() {
        return this.F != 0;
    }

    public Parcelable x() {
        int i;
        int i2;
        int i3;
        int[] iArr;
        d dVar = this.I;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        dVar2.h = this.z;
        dVar2.i = this.G;
        dVar2.j = this.H;
        c cVar = this.E;
        if (cVar == null || (iArr = cVar.f939a) == null) {
            dVar2.e = 0;
        } else {
            dVar2.f = iArr;
            dVar2.e = dVar2.f.length;
            dVar2.g = cVar.f940b;
        }
        if (e() > 0) {
            if (this.G) {
                i = I();
            } else {
                i = H();
            }
            dVar2.f943a = i;
            dVar2.f944b = G();
            int i4 = this.s;
            dVar2.c = i4;
            dVar2.d = new int[i4];
            for (int i5 = 0; i5 < this.s; i5++) {
                if (this.G) {
                    i2 = this.t[i5].a(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.u.b();
                    } else {
                        dVar2.d[i5] = i2;
                    }
                } else {
                    i2 = this.t[i5].b(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.u.f();
                    } else {
                        dVar2.d[i5] = i2;
                    }
                }
                i2 -= i3;
                dVar2.d[i5] = i2;
            }
        } else {
            dVar2.f943a = -1;
            dVar2.f944b = -1;
            dVar2.c = 0;
        }
        return dVar2;
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        int[] f939a;

        /* renamed from: b  reason: collision with root package name */
        List<a> f940b;

        c() {
        }

        private void c(int i, int i2) {
            List<a> list = this.f940b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = this.f940b.get(size);
                    int i3 = aVar.f941a;
                    if (i3 >= i) {
                        aVar.f941a = i3 + i2;
                    }
                }
            }
        }

        private int g(int i) {
            if (this.f940b == null) {
                return -1;
            }
            a c = c(i);
            if (c != null) {
                this.f940b.remove(c);
            }
            int size = this.f940b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f940b.get(i2).f941a >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return -1;
            }
            this.f940b.remove(i2);
            return this.f940b.get(i2).f941a;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, e eVar) {
            a(i);
            this.f939a[i] = eVar.e;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            List<a> list = this.f940b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f940b.get(size).f941a >= i) {
                        this.f940b.remove(size);
                    }
                }
            }
            return e(i);
        }

        /* access modifiers changed from: package-private */
        public int d(int i) {
            int[] iArr = this.f939a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        /* access modifiers changed from: package-private */
        public int e(int i) {
            int[] iArr = this.f939a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int g = g(i);
            if (g == -1) {
                int[] iArr2 = this.f939a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f939a.length;
            }
            int i2 = g + 1;
            Arrays.fill(this.f939a, i, i2, -1);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int f(int i) {
            int length = this.f939a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        private void d(int i, int i2) {
            List<a> list = this.f940b;
            if (list != null) {
                int i3 = i + i2;
                for (int size = list.size() - 1; size >= 0; size--) {
                    a aVar = this.f940b.get(size);
                    int i4 = aVar.f941a;
                    if (i4 >= i) {
                        if (i4 < i3) {
                            this.f940b.remove(size);
                        } else {
                            aVar.f941a = i4 - i2;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            int[] iArr = this.f939a;
            if (iArr == null) {
                this.f939a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f939a, -1);
            } else if (i >= iArr.length) {
                this.f939a = new int[f(i)];
                System.arraycopy(iArr, 0, this.f939a, 0, iArr.length);
                int[] iArr2 = this.f939a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        public a c(int i) {
            List<a> list = this.f940b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f940b.get(size);
                if (aVar.f941a == i) {
                    return aVar;
                }
            }
            return null;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new L();

            /* renamed from: a  reason: collision with root package name */
            int f941a;

            /* renamed from: b  reason: collision with root package name */
            int f942b;
            int[] c;
            boolean d;

            a(Parcel parcel) {
                this.f941a = parcel.readInt();
                this.f942b = parcel.readInt();
                this.d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.c = new int[readInt];
                    parcel.readIntArray(this.c);
                }
            }

            /* access modifiers changed from: package-private */
            public int a(int i) {
                int[] iArr = this.c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f941a + ", mGapDir=" + this.f942b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f941a);
                parcel.writeInt(this.f942b);
                parcel.writeInt(this.d ? 1 : 0);
                int[] iArr = this.c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.c);
            }

            a() {
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i, int i2) {
            int[] iArr = this.f939a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                a(i3);
                int[] iArr2 = this.f939a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f939a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                d(i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f939a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f940b = null;
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2) {
            int[] iArr = this.f939a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                a(i3);
                int[] iArr2 = this.f939a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f939a, i, i3, -1);
                c(i, i2);
            }
        }

        public void a(a aVar) {
            if (this.f940b == null) {
                this.f940b = new ArrayList();
            }
            int size = this.f940b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f940b.get(i);
                if (aVar2.f941a == aVar.f941a) {
                    this.f940b.remove(i);
                }
                if (aVar2.f941a >= aVar.f941a) {
                    this.f940b.add(i, aVar);
                    return;
                }
            }
            this.f940b.add(aVar);
        }

        public a a(int i, int i2, int i3, boolean z) {
            List<a> list = this.f940b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f940b.get(i4);
                int i5 = aVar.f941a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.f942b == i3 || (z && aVar.d))) {
                    return aVar;
                }
            }
            return null;
        }
    }

    private int d(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    private boolean u(int i) {
        if (this.w == 0) {
            if ((i == -1) != this.A) {
                return true;
            }
            return false;
        }
        if (((i == -1) == this.A) == L()) {
            return true;
        }
        return false;
    }

    public int e(RecyclerView.u uVar) {
        return i(uVar);
    }

    public int f(RecyclerView.u uVar) {
        return j(uVar);
    }

    private int p(int i) {
        for (int e2 = e() - 1; e2 >= 0; e2--) {
            int l = l(c(e2));
            if (l >= 0 && l < i) {
                return l;
            }
        }
        return 0;
    }

    private int q(int i) {
        int a2 = this.t[0].a(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int a3 = this.t[i2].a(i);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    public void e(int i) {
        super.e(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        int f937a;

        /* renamed from: b  reason: collision with root package name */
        int f938b;
        boolean c;
        boolean d;
        boolean e;
        int[] f;

        a() {
            b();
        }

        /* access modifiers changed from: package-private */
        public void a(e[] eVarArr) {
            int length = eVarArr.length;
            int[] iArr = this.f;
            if (iArr == null || iArr.length < length) {
                this.f = new int[StaggeredGridLayoutManager.this.t.length];
            }
            for (int i = 0; i < length; i++) {
                this.f[i] = eVarArr[i].b(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f937a = -1;
            this.f938b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
            this.e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i;
            if (this.c) {
                i = StaggeredGridLayoutManager.this.u.b();
            } else {
                i = StaggeredGridLayoutManager.this.u.f();
            }
            this.f938b = i;
        }

        /* access modifiers changed from: package-private */
        public void a(int i) {
            if (this.c) {
                this.f938b = StaggeredGridLayoutManager.this.u.b() - i;
            } else {
                this.f938b = StaggeredGridLayoutManager.this.u.f() + i;
            }
        }
    }

    private int j(RecyclerView.u uVar) {
        if (e() == 0) {
            return 0;
        }
        return I.b(uVar, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    public void d(int i) {
        super.d(i);
        for (int i2 = 0; i2 < this.s; i2++) {
            this.t[i2].c(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (F() != false) goto L_0x015b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(androidx.recyclerview.widget.RecyclerView.p r9, androidx.recyclerview.widget.RecyclerView.u r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r0 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r1 = r8.I
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.C
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.a()
            if (r1 != 0) goto L_0x0018
            r8.b((androidx.recyclerview.widget.RecyclerView.p) r9)
            r0.b()
            return
        L_0x0018:
            boolean r1 = r0.e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.C
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r1 = r8.I
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.b()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.I
            if (r5 == 0) goto L_0x0037
            r8.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            goto L_0x003e
        L_0x0037:
            r8.O()
            boolean r5 = r8.A
            r0.c = r5
        L_0x003e:
            r8.b((androidx.recyclerview.widget.RecyclerView.u) r10, (androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            r0.e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.I
            if (r5 != 0) goto L_0x0060
            int r5 = r8.C
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.c
            boolean r6 = r8.G
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.L()
            boolean r6 = r8.H
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r5 = r8.E
            r5.a()
            r0.d = r4
        L_0x0060:
            int r5 = r8.e()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r5 = r8.I
            if (r5 == 0) goto L_0x006e
            int r5 = r5.c
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.d
            if (r5 == 0) goto L_0x008e
            r1 = 0
        L_0x0073:
            int r5 = r8.s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.t
            r5 = r5[r1]
            r5.c()
            int r5 = r0.f938b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r6 = r8.t
            r6 = r6[r1]
            r6.d(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.L
            int[] r1 = r1.f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = 0
        L_0x0098:
            int r5 = r8.s
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.t
            r5 = r5[r1]
            r5.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r6 = r8.L
            int[] r6 = r6.f
            r6 = r6[r1]
            r5.d(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = 0
        L_0x00b0:
            int r5 = r8.s
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.t
            r5 = r5[r1]
            boolean r6 = r8.A
            int r7 = r0.f938b
            r5.a((boolean) r6, (int) r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.L
            androidx.recyclerview.widget.StaggeredGridLayoutManager$e[] r5 = r8.t
            r1.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.e[]) r5)
        L_0x00c9:
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9)
            androidx.recyclerview.widget.s r1 = r8.y
            r1.f990a = r3
            r8.M = r3
            androidx.recyclerview.widget.x r1 = r8.v
            int r1 = r1.g()
            r8.j((int) r1)
            int r1 = r0.f937a
            r8.b((int) r1, (androidx.recyclerview.widget.RecyclerView.u) r10)
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x00fc
            r8.v(r2)
            androidx.recyclerview.widget.s r1 = r8.y
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.s) r1, (androidx.recyclerview.widget.RecyclerView.u) r10)
            r8.v(r4)
            androidx.recyclerview.widget.s r1 = r8.y
            int r2 = r0.f937a
            int r5 = r1.d
            int r2 = r2 + r5
            r1.c = r2
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.s) r1, (androidx.recyclerview.widget.RecyclerView.u) r10)
            goto L_0x0113
        L_0x00fc:
            r8.v(r4)
            androidx.recyclerview.widget.s r1 = r8.y
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.s) r1, (androidx.recyclerview.widget.RecyclerView.u) r10)
            r8.v(r2)
            androidx.recyclerview.widget.s r1 = r8.y
            int r2 = r0.f937a
            int r5 = r1.d
            int r2 = r2 + r5
            r1.c = r2
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.s) r1, (androidx.recyclerview.widget.RecyclerView.u) r10)
        L_0x0113:
            r8.N()
            int r1 = r8.e()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.A
            if (r1 == 0) goto L_0x0127
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.u) r10, (boolean) r4)
            r8.b((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.u) r10, (boolean) r3)
            goto L_0x012d
        L_0x0127:
            r8.b((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.u) r10, (boolean) r4)
            r8.a((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.u) r10, (boolean) r3)
        L_0x012d:
            if (r11 == 0) goto L_0x015a
            boolean r11 = r10.d()
            if (r11 != 0) goto L_0x015a
            int r11 = r8.F
            if (r11 == 0) goto L_0x014b
            int r11 = r8.e()
            if (r11 <= 0) goto L_0x014b
            boolean r11 = r8.M
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.J()
            if (r11 == 0) goto L_0x014b
        L_0x0149:
            r11 = 1
            goto L_0x014c
        L_0x014b:
            r11 = 0
        L_0x014c:
            if (r11 == 0) goto L_0x015a
            java.lang.Runnable r11 = r8.P
            r8.a((java.lang.Runnable) r11)
            boolean r11 = r8.F()
            if (r11 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r4 = 0
        L_0x015b:
            boolean r11 = r10.d()
            if (r11 == 0) goto L_0x0166
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.L
            r11.b()
        L_0x0166:
            boolean r11 = r0.c
            r8.G = r11
            boolean r11 = r8.L()
            r8.H = r11
            if (r4 == 0) goto L_0x017a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.L
            r11.b()
            r8.c((androidx.recyclerview.widget.RecyclerView.p) r9, (androidx.recyclerview.widget.RecyclerView.u) r10, (boolean) r3)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$u, boolean):void");
    }

    private void e(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].f945a.isEmpty()) {
                a(this.t[i3], i, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.u uVar, a aVar) {
        if (!a(uVar, aVar) && !c(uVar, aVar)) {
            aVar.a();
            aVar.f937a = 0;
        }
    }

    public void d(RecyclerView recyclerView) {
        this.E.a();
        y();
    }

    private int h(RecyclerView.u uVar) {
        if (e() == 0) {
            return 0;
        }
        return I.a(uVar, this.u, b(!this.N), a(!this.N), this, this.N);
    }

    private int i(RecyclerView.u uVar) {
        if (e() == 0) {
            return 0;
        }
        return I.a(uVar, this.u, b(!this.N), a(!this.N), this, this.N, this.A);
    }

    public void a(String str) {
        if (this.I == null) {
            super.a(str);
        }
    }

    public int b(RecyclerView.u uVar) {
        return i(uVar);
    }

    public int b(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.w == 0) {
            return this.s;
        }
        return super.b(pVar, uVar);
    }

    public void a(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int n = n() + o();
        int p = p() + m();
        if (this.w == 1) {
            i4 = RecyclerView.i.a(i2, rect.height() + p, k());
            i3 = RecyclerView.i.a(i, (this.x * this.s) + n, l());
        } else {
            i3 = RecyclerView.i.a(i, rect.width() + n, l());
            i4 = RecyclerView.i.a(i2, (this.x * this.s) + p, k());
        }
        c(i3, i4);
    }

    /* access modifiers changed from: package-private */
    public View b(boolean z2) {
        int f = this.u.f();
        int b2 = this.u.b();
        int e2 = e();
        View view = null;
        for (int i = 0; i < e2; i++) {
            View c2 = c(i);
            int d2 = this.u.d(c2);
            if (this.u.a(c2) > f && d2 < b2) {
                if (d2 >= f || !z2) {
                    return c2;
                }
                if (view == null) {
                    view = c2;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.p pVar, RecyclerView.u uVar, boolean z2) {
        int f;
        int t2 = t(Integer.MAX_VALUE);
        if (t2 != Integer.MAX_VALUE && (f = t2 - this.u.f()) > 0) {
            int c2 = f - c(f, pVar, uVar);
            if (z2 && c2 > 0) {
                this.u.a(-c2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r5, androidx.recyclerview.widget.RecyclerView.u r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.s r0 = r4.y
            r1 = 0
            r0.f991b = r1
            r0.c = r5
            boolean r0 = r4.w()
            r2 = 1
            if (r0 == 0) goto L_0x002e
            int r6 = r6.b()
            r0 = -1
            if (r6 == r0) goto L_0x002e
            boolean r0 = r4.A
            if (r6 >= r5) goto L_0x001b
            r5 = 1
            goto L_0x001c
        L_0x001b:
            r5 = 0
        L_0x001c:
            if (r0 != r5) goto L_0x0025
            androidx.recyclerview.widget.x r5 = r4.u
            int r5 = r5.g()
            goto L_0x002f
        L_0x0025:
            androidx.recyclerview.widget.x r5 = r4.u
            int r5 = r5.g()
            r6 = r5
            r5 = 0
            goto L_0x0030
        L_0x002e:
            r5 = 0
        L_0x002f:
            r6 = 0
        L_0x0030:
            boolean r0 = r4.f()
            if (r0 == 0) goto L_0x004d
            androidx.recyclerview.widget.s r0 = r4.y
            androidx.recyclerview.widget.x r3 = r4.u
            int r3 = r3.f()
            int r3 = r3 - r6
            r0.f = r3
            androidx.recyclerview.widget.s r6 = r4.y
            androidx.recyclerview.widget.x r0 = r4.u
            int r0 = r0.b()
            int r0 = r0 + r5
            r6.g = r0
            goto L_0x005d
        L_0x004d:
            androidx.recyclerview.widget.s r0 = r4.y
            androidx.recyclerview.widget.x r3 = r4.u
            int r3 = r3.a()
            int r3 = r3 + r5
            r0.g = r3
            androidx.recyclerview.widget.s r5 = r4.y
            int r6 = -r6
            r5.f = r6
        L_0x005d:
            androidx.recyclerview.widget.s r5 = r4.y
            r5.h = r1
            r5.f990a = r2
            androidx.recyclerview.widget.x r6 = r4.u
            int r6 = r6.d()
            if (r6 != 0) goto L_0x0074
            androidx.recyclerview.widget.x r6 = r4.u
            int r6 = r6.a()
            if (r6 != 0) goto L_0x0074
            r1 = 1
        L_0x0074:
            r5.i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$u):void");
    }

    private void a(a aVar) {
        int i;
        d dVar = this.I;
        int i2 = dVar.c;
        if (i2 > 0) {
            if (i2 == this.s) {
                for (int i3 = 0; i3 < this.s; i3++) {
                    this.t[i3].c();
                    d dVar2 = this.I;
                    int i4 = dVar2.d[i3];
                    if (i4 != Integer.MIN_VALUE) {
                        if (dVar2.i) {
                            i = this.u.b();
                        } else {
                            i = this.u.f();
                        }
                        i4 += i;
                    }
                    this.t[i3].d(i4);
                }
            } else {
                dVar.a();
                d dVar3 = this.I;
                dVar3.f943a = dVar3.f944b;
            }
        }
        d dVar4 = this.I;
        this.H = dVar4.j;
        c(dVar4.h);
        O();
        d dVar5 = this.I;
        int i5 = dVar5.f943a;
        if (i5 != -1) {
            this.C = i5;
            aVar.c = dVar5.i;
        } else {
            aVar.c = this.A;
        }
        d dVar6 = this.I;
        if (dVar6.e > 1) {
            c cVar = this.E;
            cVar.f939a = dVar6.f;
            cVar.f940b = dVar6.g;
        }
    }

    public void b(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 2);
    }

    private void b(RecyclerView.p pVar, int i) {
        while (e() > 0) {
            View c2 = c(0);
            if (this.u.a(c2) <= i && this.u.e(c2) <= i) {
                b bVar = (b) c2.getLayoutParams();
                if (bVar.f) {
                    int i2 = 0;
                    while (i2 < this.s) {
                        if (this.t[i2].f945a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].k();
                    }
                } else if (bVar.e.f945a.size() != 1) {
                    bVar.e.k();
                } else {
                    return;
                }
                a(c2, pVar);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.u uVar, a aVar) {
        int i;
        int i2;
        int i3;
        boolean z2 = false;
        if (!uVar.d() && (i = this.C) != -1) {
            if (i < 0 || i >= uVar.a()) {
                this.C = -1;
                this.D = Integer.MIN_VALUE;
            } else {
                d dVar = this.I;
                if (dVar == null || dVar.f943a == -1 || dVar.c < 1) {
                    View b2 = b(this.C);
                    if (b2 != null) {
                        if (this.A) {
                            i2 = I();
                        } else {
                            i2 = H();
                        }
                        aVar.f937a = i2;
                        if (this.D != Integer.MIN_VALUE) {
                            if (aVar.c) {
                                aVar.f938b = (this.u.b() - this.D) - this.u.a(b2);
                            } else {
                                aVar.f938b = (this.u.f() + this.D) - this.u.d(b2);
                            }
                            return true;
                        } else if (this.u.b(b2) > this.u.g()) {
                            if (aVar.c) {
                                i3 = this.u.b();
                            } else {
                                i3 = this.u.f();
                            }
                            aVar.f938b = i3;
                            return true;
                        } else {
                            int d2 = this.u.d(b2) - this.u.f();
                            if (d2 < 0) {
                                aVar.f938b = -d2;
                                return true;
                            }
                            int b3 = this.u.b() - this.u.a(b2);
                            if (b3 < 0) {
                                aVar.f938b = b3;
                                return true;
                            }
                            aVar.f938b = Integer.MIN_VALUE;
                        }
                    } else {
                        aVar.f937a = this.C;
                        int i4 = this.D;
                        if (i4 == Integer.MIN_VALUE) {
                            if (k(aVar.f937a) == 1) {
                                z2 = true;
                            }
                            aVar.c = z2;
                            aVar.a();
                        } else {
                            aVar.a(i4);
                        }
                        aVar.d = true;
                    }
                } else {
                    aVar.f938b = Integer.MIN_VALUE;
                    aVar.f937a = this.C;
                }
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return this.w == 1;
    }

    public int b(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        return c(i, pVar, uVar);
    }

    private boolean c(RecyclerView.u uVar, a aVar) {
        int i;
        if (this.G) {
            i = p(uVar.a());
        } else {
            i = o(uVar.a());
        }
        aVar.f937a = i;
        aVar.f938b = Integer.MIN_VALUE;
        return true;
    }

    public int c(RecyclerView.u uVar) {
        return j(uVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L_0x0009
            int r0 = r6.I()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.H()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001b
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001d
        L_0x0016:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L_0x001f
        L_0x001b:
            int r2 = r7 + r8
        L_0x001d:
            r3 = r2
            r2 = r7
        L_0x001f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r4 = r6.E
            r4.e(r2)
            r4 = 1
            if (r9 == r4) goto L_0x003e
            r5 = 2
            if (r9 == r5) goto L_0x0038
            if (r9 == r1) goto L_0x002d
            goto L_0x0043
        L_0x002d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r6.E
            r9.b(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r7 = r6.E
            r7.a((int) r8, (int) r4)
            goto L_0x0043
        L_0x0038:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r6.E
            r9.b(r7, r8)
            goto L_0x0043
        L_0x003e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r6.E
            r9.a((int) r7, (int) r8)
        L_0x0043:
            if (r3 > r0) goto L_0x0046
            return
        L_0x0046:
            boolean r7 = r6.A
            if (r7 == 0) goto L_0x004f
            int r7 = r6.H()
            goto L_0x0053
        L_0x004f:
            int r7 = r6.I()
        L_0x0053:
            if (r2 > r7) goto L_0x0058
            r6.y()
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    public int a(RecyclerView.u uVar) {
        return h(uVar);
    }

    private void a(View view, b bVar, boolean z2) {
        if (bVar.f) {
            if (this.w == 1) {
                a(view, this.J, RecyclerView.i.a(h(), i(), p() + m(), bVar.height, true), z2);
            } else {
                a(view, RecyclerView.i.a(q(), r(), n() + o(), bVar.width, true), this.J, z2);
            }
        } else if (this.w == 1) {
            a(view, RecyclerView.i.a(this.x, r(), 0, bVar.width, false), RecyclerView.i.a(h(), i(), p() + m(), bVar.height, true), z2);
        } else {
            a(view, RecyclerView.i.a(q(), r(), n() + o(), bVar.width, true), RecyclerView.i.a(this.x, i(), 0, bVar.height, false), z2);
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (e() == 0 || i == 0) {
            return 0;
        }
        a(i, uVar);
        int a2 = a(pVar, this.y, uVar);
        if (this.y.f991b >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.u.a(-i);
        this.G = this.A;
        s sVar = this.y;
        sVar.f991b = 0;
        a(pVar, sVar);
        return i;
    }

    public RecyclerView.j c() {
        if (this.w == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    private void a(View view, int i, int i2, boolean z2) {
        boolean z3;
        a(view, this.K);
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin;
        Rect rect = this.K;
        int d2 = d(i, i3 + rect.left, bVar.rightMargin + rect.right);
        int i4 = bVar.topMargin;
        Rect rect2 = this.K;
        int d3 = d(i2, i4 + rect2.top, bVar.bottomMargin + rect2.bottom);
        if (z2) {
            z3 = b(view, d2, d3, bVar);
        } else {
            z3 = a(view, d2, d3, (RecyclerView.j) bVar);
        }
        if (z3) {
            view.measure(d2, d3);
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.I = (d) parcelable;
            y();
        }
    }

    public void a(RecyclerView.p pVar, RecyclerView.u uVar, View view, a.g.i.a.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.a(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        if (this.w == 0) {
            cVar.b((Object) c.C0009c.a(bVar.e(), bVar.f ? this.s : 1, -1, -1, bVar.f, false));
        } else {
            cVar.b((Object) c.C0009c.a(-1, -1, bVar.e(), bVar.f ? this.s : 1, bVar.f, false));
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            View b2 = b(false);
            View a2 = a(false);
            if (b2 != null && a2 != null) {
                int l = l(b2);
                int l2 = l(a2);
                if (l < l2) {
                    accessibilityEvent.setFromIndex(l);
                    accessibilityEvent.setToIndex(l2);
                    return;
                }
                accessibilityEvent.setFromIndex(l2);
                accessibilityEvent.setToIndex(l);
            }
        }
    }

    public int a(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.w == 1) {
            return this.s;
        }
        return super.a(pVar, uVar);
    }

    /* access modifiers changed from: package-private */
    public View a(boolean z2) {
        int f = this.u.f();
        int b2 = this.u.b();
        View view = null;
        for (int e2 = e() - 1; e2 >= 0; e2--) {
            View c2 = c(e2);
            int d2 = this.u.d(c2);
            int a2 = this.u.a(c2);
            if (a2 > f && d2 < b2) {
                if (a2 <= b2 || !z2) {
                    return c2;
                }
                if (view == null) {
                    view = c2;
                }
            }
        }
        return view;
    }

    private void a(RecyclerView.p pVar, RecyclerView.u uVar, boolean z2) {
        int b2;
        int q = q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE && (b2 = this.u.b() - q) > 0) {
            int i = b2 - (-c(-b2, pVar, uVar));
            if (z2 && i > 0) {
                this.u.a(i);
            }
        }
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        c(i, i2, 1);
    }

    public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        c(i, i2, 8);
    }

    public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
        c(i, i2, 4);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v4 */
    private int a(RecyclerView.p pVar, s sVar, RecyclerView.u uVar) {
        int i;
        int i2;
        int i3;
        e eVar;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z2;
        int i10;
        int i11;
        int i12;
        RecyclerView.p pVar2 = pVar;
        s sVar2 = sVar;
        ? r9 = 0;
        this.B.set(0, this.s, true);
        if (this.y.i) {
            i = sVar2.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (sVar2.e == 1) {
                i12 = sVar2.g + sVar2.f991b;
            } else {
                i12 = sVar2.f - sVar2.f991b;
            }
            i = i12;
        }
        e(sVar2.e, i);
        if (this.A) {
            i2 = this.u.b();
        } else {
            i2 = this.u.f();
        }
        int i13 = i2;
        boolean z3 = false;
        while (sVar.a(uVar) && (this.y.i || !this.B.isEmpty())) {
            View a2 = sVar2.a(pVar2);
            b bVar = (b) a2.getLayoutParams();
            int a3 = bVar.a();
            int d2 = this.E.d(a3);
            boolean z4 = d2 == -1;
            if (z4) {
                eVar = bVar.f ? this.t[r9] : a(sVar2);
                this.E.a(a3, eVar);
            } else {
                eVar = this.t[d2];
            }
            e eVar2 = eVar;
            bVar.e = eVar2;
            if (sVar2.e == 1) {
                b(a2);
            } else {
                b(a2, (int) r9);
            }
            a(a2, bVar, (boolean) r9);
            if (sVar2.e == 1) {
                if (bVar.f) {
                    i11 = q(i13);
                } else {
                    i11 = eVar2.a(i13);
                }
                int b2 = this.u.b(a2) + i11;
                if (z4 && bVar.f) {
                    c.a m = m(i11);
                    m.f942b = -1;
                    m.f941a = a3;
                    this.E.a(m);
                }
                i4 = b2;
                i5 = i11;
            } else {
                if (bVar.f) {
                    i10 = t(i13);
                } else {
                    i10 = eVar2.b(i13);
                }
                i5 = i10 - this.u.b(a2);
                if (z4 && bVar.f) {
                    c.a n = n(i10);
                    n.f942b = 1;
                    n.f941a = a3;
                    this.E.a(n);
                }
                i4 = i10;
            }
            if (bVar.f && sVar2.d == -1) {
                if (z4) {
                    this.M = true;
                } else {
                    if (sVar2.e == 1) {
                        z2 = D();
                    } else {
                        z2 = E();
                    }
                    if (!z2) {
                        c.a c2 = this.E.c(a3);
                        if (c2 != null) {
                            c2.d = true;
                        }
                        this.M = true;
                    }
                }
            }
            a(a2, bVar, sVar2);
            if (!L() || this.w != 1) {
                if (bVar.f) {
                    i8 = this.v.f();
                } else {
                    i8 = (eVar2.e * this.x) + this.v.f();
                }
                i7 = i8;
                i6 = this.v.b(a2) + i8;
            } else {
                if (bVar.f) {
                    i9 = this.v.b();
                } else {
                    i9 = this.v.b() - (((this.s - 1) - eVar2.e) * this.x);
                }
                i6 = i9;
                i7 = i9 - this.v.b(a2);
            }
            if (this.w == 1) {
                a(a2, i7, i5, i6, i4);
            } else {
                a(a2, i5, i7, i4, i6);
            }
            if (bVar.f) {
                e(this.y.e, i);
            } else {
                a(eVar2, this.y.e, i);
            }
            a(pVar2, this.y);
            if (this.y.h && a2.hasFocusable()) {
                if (bVar.f) {
                    this.B.clear();
                } else {
                    this.B.set(eVar2.e, false);
                    z3 = true;
                    r9 = 0;
                }
            }
            z3 = true;
            r9 = 0;
        }
        if (!z3) {
            a(pVar2, this.y);
        }
        if (this.y.e == -1) {
            i3 = this.u.f() - t(this.u.f());
        } else {
            i3 = q(this.u.b()) - this.u.b();
        }
        if (i3 > 0) {
            return Math.min(sVar2.f991b, i3);
        }
        return 0;
    }

    private void a(View view, b bVar, s sVar) {
        if (sVar.e == 1) {
            if (bVar.f) {
                p(view);
            } else {
                bVar.e.a(view);
            }
        } else if (bVar.f) {
            q(view);
        } else {
            bVar.e.c(view);
        }
    }

    private void a(RecyclerView.p pVar, s sVar) {
        int i;
        int i2;
        if (sVar.f990a && !sVar.i) {
            if (sVar.f991b == 0) {
                if (sVar.e == -1) {
                    a(pVar, sVar.g);
                } else {
                    b(pVar, sVar.f);
                }
            } else if (sVar.e == -1) {
                int i3 = sVar.f;
                int r = i3 - r(i3);
                if (r < 0) {
                    i2 = sVar.g;
                } else {
                    i2 = sVar.g - Math.min(r, sVar.f991b);
                }
                a(pVar, i2);
            } else {
                int s2 = s(sVar.g) - sVar.g;
                if (s2 < 0) {
                    i = sVar.f;
                } else {
                    i = Math.min(s2, sVar.f991b) + sVar.f;
                }
                b(pVar, i);
            }
        }
    }

    private void a(e eVar, int i, int i2) {
        int f = eVar.f();
        if (i == -1) {
            if (eVar.h() + f <= i2) {
                this.B.set(eVar.e, false);
            }
        } else if (eVar.g() - f >= i2) {
            this.B.set(eVar.e, false);
        }
    }

    private void a(RecyclerView.p pVar, int i) {
        int e2 = e() - 1;
        while (e2 >= 0) {
            View c2 = c(e2);
            if (this.u.d(c2) >= i && this.u.f(c2) >= i) {
                b bVar = (b) c2.getLayoutParams();
                if (bVar.f) {
                    int i2 = 0;
                    while (i2 < this.s) {
                        if (this.t[i2].f945a.size() != 1) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].j();
                    }
                } else if (bVar.e.f945a.size() != 1) {
                    bVar.e.j();
                } else {
                    return;
                }
                a(c2, pVar);
                e2--;
            } else {
                return;
            }
        }
    }

    private e a(s sVar) {
        int i;
        int i2;
        int i3 = -1;
        if (u(sVar.e)) {
            i2 = this.s - 1;
            i = -1;
        } else {
            i2 = 0;
            i3 = this.s;
            i = 1;
        }
        e eVar = null;
        if (sVar.e == 1) {
            int i4 = Integer.MAX_VALUE;
            int f = this.u.f();
            while (i2 != i3) {
                e eVar2 = this.t[i2];
                int a2 = eVar2.a(f);
                if (a2 < i4) {
                    eVar = eVar2;
                    i4 = a2;
                }
                i2 += i;
            }
            return eVar;
        }
        int i5 = Integer.MIN_VALUE;
        int b2 = this.u.b();
        while (i2 != i3) {
            e eVar3 = this.t[i2];
            int b3 = eVar3.b(b2);
            if (b3 > i5) {
                eVar = eVar3;
                i5 = b3;
            }
            i2 += i;
        }
        return eVar;
    }

    public boolean a() {
        return this.w == 0;
    }

    public int a(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        return c(i, pVar, uVar);
    }

    public void a(int i, int i2, RecyclerView.u uVar, RecyclerView.i.a aVar) {
        int i3;
        int i4;
        if (this.w != 0) {
            i = i2;
        }
        if (e() != 0 && i != 0) {
            a(i, uVar);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.s) {
                this.O = new int[this.s];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.s; i6++) {
                s sVar = this.y;
                if (sVar.d == -1) {
                    i4 = sVar.f;
                    i3 = this.t[i6].b(i4);
                } else {
                    i4 = this.t[i6].a(sVar.g);
                    i3 = this.y.g;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.O[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.O, 0, i5);
            for (int i8 = 0; i8 < i5 && this.y.a(uVar); i8++) {
                aVar.a(this.y.c, this.O[i8]);
                s sVar2 = this.y;
                sVar2.c += sVar2.d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i, RecyclerView.u uVar) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = I();
            i2 = 1;
        } else {
            i3 = H();
            i2 = -1;
        }
        this.y.f990a = true;
        b(i3, uVar);
        v(i2);
        s sVar = this.y;
        sVar.c = i3 + sVar.d;
        sVar.f991b = Math.abs(i);
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

    public boolean a(RecyclerView.j jVar) {
        return jVar instanceof b;
    }

    public View a(View view, int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        View c2;
        int i2;
        int i3;
        int i4;
        int i5;
        View a2;
        if (e() == 0 || (c2 = c(view)) == null) {
            return null;
        }
        O();
        int l = l(i);
        if (l == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) c2.getLayoutParams();
        boolean z2 = bVar.f;
        e eVar = bVar.e;
        if (l == 1) {
            i2 = I();
        } else {
            i2 = H();
        }
        b(i2, uVar);
        v(l);
        s sVar = this.y;
        sVar.c = sVar.d + i2;
        sVar.f991b = (int) (((float) this.u.g()) * 0.33333334f);
        s sVar2 = this.y;
        sVar2.h = true;
        sVar2.f990a = false;
        a(pVar, sVar2, uVar);
        this.G = this.A;
        if (!z2 && (a2 = eVar.a(i2, l)) != null && a2 != c2) {
            return a2;
        }
        if (u(l)) {
            for (int i6 = this.s - 1; i6 >= 0; i6--) {
                View a3 = this.t[i6].a(i2, l);
                if (a3 != null && a3 != c2) {
                    return a3;
                }
            }
        } else {
            for (int i7 = 0; i7 < this.s; i7++) {
                View a4 = this.t[i7].a(i2, l);
                if (a4 != null && a4 != c2) {
                    return a4;
                }
            }
        }
        boolean z3 = (this.z ^ true) == (l == -1);
        if (!z2) {
            if (z3) {
                i5 = eVar.d();
            } else {
                i5 = eVar.e();
            }
            View b2 = b(i5);
            if (!(b2 == null || b2 == c2)) {
                return b2;
            }
        }
        if (u(l)) {
            for (int i8 = this.s - 1; i8 >= 0; i8--) {
                if (i8 != eVar.e) {
                    if (z3) {
                        i4 = this.t[i8].d();
                    } else {
                        i4 = this.t[i8].e();
                    }
                    View b3 = b(i4);
                    if (!(b3 == null || b3 == c2)) {
                        return b3;
                    }
                }
            }
        } else {
            for (int i9 = 0; i9 < this.s; i9++) {
                if (z3) {
                    i3 = this.t[i9].d();
                } else {
                    i3 = this.t[i9].e();
                }
                View b4 = b(i3);
                if (b4 != null && b4 != c2) {
                    return b4;
                }
            }
        }
        return null;
    }
}
