package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.i implements r, RecyclerView.t.a {
    int A;
    int B;
    private boolean C;
    d D;
    final a E;
    private final b F;
    private int G;
    int s;
    private c t;
    x u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f894a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f895b;
        public boolean c;
        public boolean d;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f894a = 0;
            this.f895b = false;
            this.c = false;
            this.d = false;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f896a = true;

        /* renamed from: b  reason: collision with root package name */
        int f897b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        boolean i = false;
        int j;
        List<RecyclerView.x> k = null;
        boolean l;

        c() {
        }

        private View b() {
            int size = this.k.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.k.get(i2).f936b;
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                if (!jVar.c() && this.d == jVar.a()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public boolean a(RecyclerView.u uVar) {
            int i2 = this.d;
            return i2 >= 0 && i2 < uVar.a();
        }

        /* access modifiers changed from: package-private */
        public View a(RecyclerView.p pVar) {
            if (this.k != null) {
                return b();
            }
            View d2 = pVar.d(this.d);
            this.d += this.e;
            return d2;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            if (b2 == null) {
                this.d = -1;
            } else {
                this.d = ((RecyclerView.j) b2.getLayoutParams()).a();
            }
        }

        public View b(View view) {
            int a2;
            int size = this.k.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.k.get(i3).f936b;
                RecyclerView.j jVar = (RecyclerView.j) view3.getLayoutParams();
                if (view3 != view && !jVar.c() && (a2 = (jVar.a() - this.d) * this.e) >= 0 && a2 < i2) {
                    if (a2 == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i2 = a2;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new t();

        /* renamed from: a  reason: collision with root package name */
        int f898a;

        /* renamed from: b  reason: collision with root package name */
        int f899b;
        boolean c;

        public d() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f898a >= 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f898a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f898a);
            parcel.writeInt(this.f899b);
            parcel.writeInt(this.c ? 1 : 0);
        }

        d(Parcel parcel) {
            this.f898a = parcel.readInt();
            this.f899b = parcel.readInt();
            this.c = parcel.readInt() != 1 ? false : true;
        }

        public d(d dVar) {
            this.f898a = dVar.f898a;
            this.f899b = dVar.f899b;
            this.c = dVar.c;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private View L() {
        return e(0, e());
    }

    private View M() {
        return e(e() - 1, -1);
    }

    private View N() {
        if (this.x) {
            return L();
        }
        return M();
    }

    private View O() {
        if (this.x) {
            return M();
        }
        return L();
    }

    private View P() {
        return c(this.x ? 0 : e() - 1);
    }

    private View Q() {
        return c(this.x ? e() - 1 : 0);
    }

    private void R() {
        if (this.s == 1 || !I()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    private void f(int i, int i2) {
        this.t.c = this.u.b() - i2;
        this.t.e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.d = i;
        cVar.f = 1;
        cVar.f897b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    private int j(RecyclerView.u uVar) {
        if (e() == 0) {
            return 0;
        }
        E();
        x xVar = this.u;
        View b2 = b(!this.z, true);
        return I.a(uVar, xVar, b2, a(!this.z, true), this, this.z, this.x);
    }

    private int k(RecyclerView.u uVar) {
        if (e() == 0) {
            return 0;
        }
        E();
        x xVar = this.u;
        View b2 = b(!this.z, true);
        return I.b(uVar, xVar, b2, a(!this.z, true), this, this.z);
    }

    /* access modifiers changed from: package-private */
    public boolean A() {
        return (i() == 1073741824 || r() == 1073741824 || !s()) ? false : true;
    }

    public boolean C() {
        return this.D == null && this.v == this.y;
    }

    /* access modifiers changed from: package-private */
    public c D() {
        return new c();
    }

    /* access modifiers changed from: package-private */
    public void E() {
        if (this.t == null) {
            this.t = D();
        }
    }

    public int F() {
        View a2 = a(0, e(), false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int G() {
        View a2 = a(e() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return l(a2);
    }

    public int H() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public boolean I() {
        return j() == 1;
    }

    public boolean J() {
        return this.z;
    }

    /* access modifiers changed from: package-private */
    public boolean K() {
        return this.u.d() == 0 && this.u.a() == 0;
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (e() > 0) {
            accessibilityEvent.setFromIndex(F());
            accessibilityEvent.setToIndex(G());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.p pVar, RecyclerView.u uVar, a aVar, int i) {
    }

    public void b(RecyclerView recyclerView, RecyclerView.p pVar) {
        super.b(recyclerView, pVar);
        if (this.C) {
            b(pVar);
            pVar.a();
        }
    }

    public RecyclerView.j c() {
        return new RecyclerView.j(-2, -2);
    }

    public int d(RecyclerView.u uVar) {
        return i(uVar);
    }

    public void e(RecyclerView.p pVar, RecyclerView.u uVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View b2;
        int i8;
        int i9;
        int i10 = -1;
        if (!(this.D == null && this.A == -1) && uVar.a() == 0) {
            b(pVar);
            return;
        }
        d dVar = this.D;
        if (dVar != null && dVar.a()) {
            this.A = this.D.f898a;
        }
        E();
        this.t.f896a = false;
        R();
        View g = g();
        if (!this.E.e || this.A != -1 || this.D != null) {
            this.E.b();
            a aVar = this.E;
            aVar.d = this.x ^ this.y;
            b(pVar, uVar, aVar);
            this.E.e = true;
        } else if (g != null && (this.u.d(g) >= this.u.b() || this.u.a(g) <= this.u.f())) {
            this.E.b(g, l(g));
        }
        int h = h(uVar);
        if (this.t.j >= 0) {
            i = h;
            h = 0;
        } else {
            i = 0;
        }
        int f = h + this.u.f();
        int c2 = i + this.u.c();
        if (!(!uVar.d() || (i7 = this.A) == -1 || this.B == Integer.MIN_VALUE || (b2 = b(i7)) == null)) {
            if (this.x) {
                i8 = this.u.b() - this.u.a(b2);
                i9 = this.B;
            } else {
                i9 = this.u.d(b2) - this.u.f();
                i8 = this.B;
            }
            int i11 = i8 - i9;
            if (i11 > 0) {
                f += i11;
            } else {
                c2 -= i11;
            }
        }
        if (!this.E.d ? !this.x : this.x) {
            i10 = 1;
        }
        a(pVar, uVar, this.E, i10);
        a(pVar);
        this.t.l = K();
        this.t.i = uVar.d();
        a aVar2 = this.E;
        if (aVar2.d) {
            b(aVar2);
            c cVar = this.t;
            cVar.h = f;
            a(pVar, cVar, uVar, false);
            c cVar2 = this.t;
            i3 = cVar2.f897b;
            int i12 = cVar2.d;
            int i13 = cVar2.c;
            if (i13 > 0) {
                c2 += i13;
            }
            a(this.E);
            c cVar3 = this.t;
            cVar3.h = c2;
            cVar3.d += cVar3.e;
            a(pVar, cVar3, uVar, false);
            c cVar4 = this.t;
            i2 = cVar4.f897b;
            int i14 = cVar4.c;
            if (i14 > 0) {
                g(i12, i3);
                c cVar5 = this.t;
                cVar5.h = i14;
                a(pVar, cVar5, uVar, false);
                i3 = this.t.f897b;
            }
        } else {
            a(aVar2);
            c cVar6 = this.t;
            cVar6.h = c2;
            a(pVar, cVar6, uVar, false);
            c cVar7 = this.t;
            i2 = cVar7.f897b;
            int i15 = cVar7.d;
            int i16 = cVar7.c;
            if (i16 > 0) {
                f += i16;
            }
            b(this.E);
            c cVar8 = this.t;
            cVar8.h = f;
            cVar8.d += cVar8.e;
            a(pVar, cVar8, uVar, false);
            c cVar9 = this.t;
            i3 = cVar9.f897b;
            int i17 = cVar9.c;
            if (i17 > 0) {
                f(i15, i2);
                c cVar10 = this.t;
                cVar10.h = i17;
                a(pVar, cVar10, uVar, false);
                i2 = this.t.f897b;
            }
        }
        if (e() > 0) {
            if (this.x ^ this.y) {
                int a2 = a(i2, pVar, uVar, true);
                i5 = i3 + a2;
                i4 = i2 + a2;
                i6 = b(i5, pVar, uVar, false);
            } else {
                int b3 = b(i3, pVar, uVar, true);
                i5 = i3 + b3;
                i4 = i2 + b3;
                i6 = a(i4, pVar, uVar, false);
            }
            i3 = i5 + i6;
            i2 = i4 + i6;
        }
        b(pVar, uVar, i3, i2);
        if (!uVar.d()) {
            this.u.i();
        } else {
            this.E.b();
        }
        this.v = this.y;
    }

    public void g(RecyclerView.u uVar) {
        super.g(uVar);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.b();
    }

    /* access modifiers changed from: protected */
    public int h(RecyclerView.u uVar) {
        if (uVar.c()) {
            return this.u.g();
        }
        return 0;
    }

    public void i(int i) {
        if (i == 0 || i == 1) {
            a((String) null);
            if (i != this.s || this.u == null) {
                this.u = x.a(this, i);
                this.E.f892a = this.u;
                this.s = i;
                y();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public boolean u() {
        return true;
    }

    public Parcelable x() {
        d dVar = this.D;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (e() > 0) {
            E();
            boolean z2 = this.v ^ this.x;
            dVar2.c = z2;
            if (z2) {
                View P = P();
                dVar2.f899b = this.u.b() - this.u.a(P);
                dVar2.f898a = l(P);
            } else {
                View Q = Q();
                dVar2.f898a = l(Q);
                dVar2.f899b = this.u.d(Q) - this.u.f();
            }
        } else {
            dVar2.b();
        }
        return dVar2;
    }

    public LinearLayoutManager(Context context, int i, boolean z2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        i(i);
        a(z2);
    }

    public int c(RecyclerView.u uVar) {
        return k(uVar);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        x f892a;

        /* renamed from: b  reason: collision with root package name */
        int f893b;
        int c;
        boolean d;
        boolean e;

        a() {
            b();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i;
            if (this.d) {
                i = this.f892a.b();
            } else {
                i = this.f892a.f();
            }
            this.c = i;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f893b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f893b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, RecyclerView.u uVar) {
            RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
            return !jVar.c() && jVar.a() >= 0 && jVar.a() < uVar.a();
        }

        public void b(View view, int i) {
            int h = this.f892a.h();
            if (h >= 0) {
                a(view, i);
                return;
            }
            this.f893b = i;
            if (this.d) {
                int b2 = (this.f892a.b() - h) - this.f892a.a(view);
                this.c = this.f892a.b() - b2;
                if (b2 > 0) {
                    int b3 = this.c - this.f892a.b(view);
                    int f = this.f892a.f();
                    int min = b3 - (f + Math.min(this.f892a.d(view) - f, 0));
                    if (min < 0) {
                        this.c += Math.min(b2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int d2 = this.f892a.d(view);
            int f2 = d2 - this.f892a.f();
            this.c = d2;
            if (f2 > 0) {
                int b4 = (this.f892a.b() - Math.min(0, (this.f892a.b() - h) - this.f892a.a(view))) - (d2 + this.f892a.b(view));
                if (b4 < 0) {
                    this.c -= Math.min(f2, -b4);
                }
            }
        }

        public void a(View view, int i) {
            if (this.d) {
                this.c = this.f892a.a(view) + this.f892a.h();
            } else {
                this.c = this.f892a.d(view);
            }
            this.f893b = i;
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (e() == 0 || i == 0) {
            return 0;
        }
        E();
        this.t.f896a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, uVar);
        c cVar = this.t;
        int a2 = cVar.g + a(pVar, cVar, uVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.u.a(-i);
        this.t.j = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    public int h(int i) {
        if (i == 1) {
            return (this.s != 1 && I()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.s != 1 && I()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    return (i == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE;
                }
                if (this.s == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            } else if (this.s == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.s == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.D = (d) parcelable;
            y();
        }
    }

    public boolean b() {
        return this.s == 1;
    }

    private void g(int i, int i2) {
        this.t.c = i2 - this.u.f();
        c cVar = this.t;
        cVar.d = i;
        cVar.e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f = -1;
        cVar2.f897b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    public void b(boolean z2) {
        a((String) null);
        if (this.y != z2) {
            this.y = z2;
            y();
        }
    }

    public int f(RecyclerView.u uVar) {
        return k(uVar);
    }

    private View f(RecyclerView.p pVar, RecyclerView.u uVar) {
        return a(pVar, uVar, 0, e(), uVar.a());
    }

    private int i(RecyclerView.u uVar) {
        if (e() == 0) {
            return 0;
        }
        E();
        x xVar = this.u;
        View b2 = b(!this.z, true);
        return I.a(uVar, xVar, b2, a(!this.z, true), this, this.z);
    }

    public boolean a() {
        return this.s == 0;
    }

    public void a(boolean z2) {
        a((String) null);
        if (z2 != this.w) {
            this.w = z2;
            y();
        }
    }

    public View b(int i) {
        int e = e();
        if (e == 0) {
            return null;
        }
        int l = i - l(c(0));
        if (l >= 0 && l < e) {
            View c2 = c(l);
            if (l(c2) == i) {
                return c2;
            }
        }
        return super.b(i);
    }

    private View h(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.x) {
            return f(pVar, uVar);
        }
        return g(pVar, uVar);
    }

    private View g(RecyclerView.p pVar, RecyclerView.u uVar) {
        return a(pVar, uVar, e() - 1, -1, uVar.a());
    }

    private boolean a(RecyclerView.p pVar, RecyclerView.u uVar, a aVar) {
        View view;
        int i;
        boolean z2 = false;
        if (e() == 0) {
            return false;
        }
        View g = g();
        if (g != null && aVar.a(g, uVar)) {
            aVar.b(g, l(g));
            return true;
        } else if (this.v != this.y) {
            return false;
        } else {
            if (aVar.d) {
                view = h(pVar, uVar);
            } else {
                view = i(pVar, uVar);
            }
            if (view == null) {
                return false;
            }
            aVar.a(view, l(view));
            if (!uVar.d() && C()) {
                if (this.u.d(view) >= this.u.b() || this.u.a(view) < this.u.f()) {
                    z2 = true;
                }
                if (z2) {
                    if (aVar.d) {
                        i = this.u.b();
                    } else {
                        i = this.u.f();
                    }
                    aVar.c = i;
                }
            }
            return true;
        }
    }

    private View i(RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.x) {
            return g(pVar, uVar);
        }
        return f(pVar, uVar);
    }

    private void b(RecyclerView.p pVar, RecyclerView.u uVar, int i, int i2) {
        RecyclerView.p pVar2 = pVar;
        RecyclerView.u uVar2 = uVar;
        if (uVar.e() && e() != 0 && !uVar.d() && C()) {
            List<RecyclerView.x> f = pVar.f();
            int size = f.size();
            int l = l(c(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.x xVar = f.get(i5);
                if (!xVar.q()) {
                    char c2 = 1;
                    if ((xVar.i() < l) != this.x) {
                        c2 = 65535;
                    }
                    if (c2 == 65535) {
                        i3 += this.u.b(xVar.f936b);
                    } else {
                        i4 += this.u.b(xVar.f936b);
                    }
                }
            }
            this.t.k = f;
            if (i3 > 0) {
                g(l(Q()), i);
                c cVar = this.t;
                cVar.h = i3;
                cVar.c = 0;
                cVar.a();
                a(pVar2, this.t, uVar2, false);
            }
            if (i4 > 0) {
                f(l(P()), i2);
                c cVar2 = this.t;
                cVar2.h = i4;
                cVar2.c = 0;
                cVar2.a();
                a(pVar2, this.t, uVar2, false);
            }
            this.t.k = null;
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new a();
        this.F = new b();
        this.G = 2;
        RecyclerView.i.b a2 = RecyclerView.i.a(context, attributeSet, i, i2);
        i(a2.f919a);
        a(a2.c);
        b(a2.d);
    }

    private boolean a(RecyclerView.u uVar, a aVar) {
        int i;
        int i2;
        boolean z2 = false;
        if (!uVar.d() && (i = this.A) != -1) {
            if (i < 0 || i >= uVar.a()) {
                this.A = -1;
                this.B = Integer.MIN_VALUE;
            } else {
                aVar.f893b = this.A;
                d dVar = this.D;
                if (dVar != null && dVar.a()) {
                    aVar.d = this.D.c;
                    if (aVar.d) {
                        aVar.c = this.u.b() - this.D.f899b;
                    } else {
                        aVar.c = this.u.f() + this.D.f899b;
                    }
                    return true;
                } else if (this.B == Integer.MIN_VALUE) {
                    View b2 = b(this.A);
                    if (b2 == null) {
                        if (e() > 0) {
                            if ((this.A < l(c(0))) == this.x) {
                                z2 = true;
                            }
                            aVar.d = z2;
                        }
                        aVar.a();
                    } else if (this.u.b(b2) > this.u.g()) {
                        aVar.a();
                        return true;
                    } else if (this.u.d(b2) - this.u.f() < 0) {
                        aVar.c = this.u.f();
                        aVar.d = false;
                        return true;
                    } else if (this.u.b() - this.u.a(b2) < 0) {
                        aVar.c = this.u.b();
                        aVar.d = true;
                        return true;
                    } else {
                        if (aVar.d) {
                            i2 = this.u.a(b2) + this.u.h();
                        } else {
                            i2 = this.u.d(b2);
                        }
                        aVar.c = i2;
                    }
                    return true;
                } else {
                    boolean z3 = this.x;
                    aVar.d = z3;
                    if (z3) {
                        aVar.c = this.u.b() - this.B;
                    } else {
                        aVar.c = this.u.f() + this.B;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void b(RecyclerView.p pVar, RecyclerView.u uVar, a aVar) {
        if (!a(uVar, aVar) && !a(pVar, uVar, aVar)) {
            aVar.a();
            aVar.f893b = this.y ? uVar.a() - 1 : 0;
        }
    }

    private int b(int i, RecyclerView.p pVar, RecyclerView.u uVar, boolean z2) {
        int f;
        int f2 = i - this.u.f();
        if (f2 <= 0) {
            return 0;
        }
        int i2 = -c(f2, pVar, uVar);
        int i3 = i + i2;
        if (!z2 || (f = i3 - this.u.f()) <= 0) {
            return i2;
        }
        this.u.a(-f);
        return i2 - f;
    }

    private void b(a aVar) {
        g(aVar.f893b, aVar.c);
    }

    public int b(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.s == 0) {
            return 0;
        }
        return c(i, pVar, uVar);
    }

    public int b(RecyclerView.u uVar) {
        return j(uVar);
    }

    private void b(RecyclerView.p pVar, int i) {
        if (i >= 0) {
            int e = e();
            if (this.x) {
                int i2 = e - 1;
                for (int i3 = i2; i3 >= 0; i3--) {
                    View c2 = c(i3);
                    if (this.u.a(c2) > i || this.u.e(c2) > i) {
                        a(pVar, i2, i3);
                        return;
                    }
                }
                return;
            }
            for (int i4 = 0; i4 < e; i4++) {
                View c3 = c(i4);
                if (this.u.a(c3) > i || this.u.e(c3) > i) {
                    a(pVar, 0, i4);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View b(boolean z2, boolean z3) {
        if (this.x) {
            return a(e() - 1, -1, z2, z3);
        }
        return a(0, e(), z2, z3);
    }

    private int a(int i, RecyclerView.p pVar, RecyclerView.u uVar, boolean z2) {
        int b2;
        int b3 = this.u.b() - i;
        if (b3 <= 0) {
            return 0;
        }
        int i2 = -c(-b3, pVar, uVar);
        int i3 = i + i2;
        if (!z2 || (b2 = this.u.b() - i3) <= 0) {
            return i2;
        }
        this.u.a(b2);
        return b2 + i2;
    }

    private void a(a aVar) {
        f(aVar.f893b, aVar.c);
    }

    public int a(int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        if (this.s == 1) {
            return 0;
        }
        return c(i, pVar, uVar);
    }

    public int a(RecyclerView.u uVar) {
        return i(uVar);
    }

    private void a(int i, int i2, boolean z2, RecyclerView.u uVar) {
        int i3;
        this.t.l = K();
        this.t.h = h(uVar);
        c cVar = this.t;
        cVar.f = i;
        int i4 = -1;
        if (i == 1) {
            cVar.h += this.u.c();
            View P = P();
            c cVar2 = this.t;
            if (!this.x) {
                i4 = 1;
            }
            cVar2.e = i4;
            c cVar3 = this.t;
            int l = l(P);
            c cVar4 = this.t;
            cVar3.d = l + cVar4.e;
            cVar4.f897b = this.u.a(P);
            i3 = this.u.a(P) - this.u.b();
        } else {
            View Q = Q();
            this.t.h += this.u.f();
            c cVar5 = this.t;
            if (this.x) {
                i4 = 1;
            }
            cVar5.e = i4;
            c cVar6 = this.t;
            int l2 = l(Q);
            c cVar7 = this.t;
            cVar6.d = l2 + cVar7.e;
            cVar7.f897b = this.u.d(Q);
            i3 = (-this.u.d(Q)) + this.u.f();
        }
        c cVar8 = this.t;
        cVar8.c = i2;
        if (z2) {
            cVar8.c -= i3;
        }
        this.t.g = i3;
    }

    public int e(RecyclerView.u uVar) {
        return j(uVar);
    }

    /* access modifiers changed from: package-private */
    public View e(int i, int i2) {
        int i3;
        int i4;
        E();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return c(i);
        }
        if (this.u.d(c(i)) < this.u.f()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        if (this.s == 0) {
            return this.e.a(i, i2, i4, i3);
        }
        return this.f.a(i, i2, i4, i3);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.u uVar, c cVar, RecyclerView.i.a aVar) {
        int i = cVar.d;
        if (i >= 0 && i < uVar.a()) {
            aVar.a(i, Math.max(0, cVar.g));
        }
    }

    public void a(int i, RecyclerView.i.a aVar) {
        boolean z2;
        int i2;
        d dVar = this.D;
        int i3 = -1;
        if (dVar == null || !dVar.a()) {
            R();
            z2 = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z2 ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.D;
            z2 = dVar2.c;
            i2 = dVar2.f898a;
        }
        if (!z2) {
            i3 = 1;
        }
        int i4 = i2;
        for (int i5 = 0; i5 < this.G && i4 >= 0 && i4 < i; i5++) {
            aVar.a(i4, 0);
            i4 += i3;
        }
    }

    public void a(int i, int i2, RecyclerView.u uVar, RecyclerView.i.a aVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (e() != 0 && i != 0) {
            E();
            a(i > 0 ? 1 : -1, Math.abs(i), true, uVar);
            a(uVar, this.t, aVar);
        }
    }

    public void a(String str) {
        if (this.D == null) {
            super.a(str);
        }
    }

    private void a(RecyclerView.p pVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    a(i3, pVar);
                }
                return;
            }
            while (i > i2) {
                a(i, pVar);
                i--;
            }
        }
    }

    private void a(RecyclerView.p pVar, int i) {
        int e = e();
        if (i >= 0) {
            int a2 = this.u.a() - i;
            if (this.x) {
                for (int i2 = 0; i2 < e; i2++) {
                    View c2 = c(i2);
                    if (this.u.d(c2) < a2 || this.u.f(c2) < a2) {
                        a(pVar, 0, i2);
                        return;
                    }
                }
                return;
            }
            int i3 = e - 1;
            for (int i4 = i3; i4 >= 0; i4--) {
                View c3 = c(i4);
                if (this.u.d(c3) < a2 || this.u.f(c3) < a2) {
                    a(pVar, i3, i4);
                    return;
                }
            }
        }
    }

    private void a(RecyclerView.p pVar, c cVar) {
        if (cVar.f896a && !cVar.l) {
            if (cVar.f == -1) {
                a(pVar, cVar.g);
            } else {
                b(pVar, cVar.g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int a(RecyclerView.p pVar, c cVar, RecyclerView.u uVar, boolean z2) {
        int i = cVar.c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            a(pVar, cVar);
        }
        int i3 = cVar.c + cVar.h;
        b bVar = this.F;
        while (true) {
            if ((!cVar.l && i3 <= 0) || !cVar.a(uVar)) {
                break;
            }
            bVar.a();
            a(pVar, uVar, cVar, bVar);
            if (!bVar.f895b) {
                cVar.f897b += bVar.f894a * cVar.f;
                if (!bVar.c || cVar.k != null || !uVar.d()) {
                    int i4 = cVar.c;
                    int i5 = bVar.f894a;
                    cVar.c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    cVar.g = i6 + bVar.f894a;
                    int i7 = cVar.c;
                    if (i7 < 0) {
                        cVar.g += i7;
                    }
                    a(pVar, cVar);
                }
                if (z2 && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.c;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.p pVar, RecyclerView.u uVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View a2 = cVar.a(pVar);
        if (a2 == null) {
            bVar.f895b = true;
            return;
        }
        RecyclerView.j jVar = (RecyclerView.j) a2.getLayoutParams();
        if (cVar.k == null) {
            if (this.x == (cVar.f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                a(a2);
            } else {
                a(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.f894a = this.u.b(a2);
        if (this.s == 1) {
            if (I()) {
                i5 = q() - o();
                i4 = i5 - this.u.c(a2);
            } else {
                i4 = n();
                i5 = this.u.c(a2) + i4;
            }
            if (cVar.f == -1) {
                int i6 = cVar.f897b;
                i = i6;
                i2 = i5;
                i3 = i6 - bVar.f894a;
            } else {
                int i7 = cVar.f897b;
                i3 = i7;
                i2 = i5;
                i = bVar.f894a + i7;
            }
        } else {
            int p = p();
            int c2 = this.u.c(a2) + p;
            if (cVar.f == -1) {
                int i8 = cVar.f897b;
                i2 = i8;
                i3 = p;
                i = c2;
                i4 = i8 - bVar.f894a;
            } else {
                int i9 = cVar.f897b;
                i3 = p;
                i2 = bVar.f894a + i9;
                i = c2;
                i4 = i9;
            }
        }
        a(a2, i4, i3, i2, i);
        if (jVar.c() || jVar.b()) {
            bVar.c = true;
        }
        bVar.d = a2.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public View a(boolean z2, boolean z3) {
        if (this.x) {
            return a(0, e(), z2, z3);
        }
        return a(e() - 1, -1, z2, z3);
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
            if (l >= 0 && l < i3) {
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

    /* access modifiers changed from: package-private */
    public View a(int i, int i2, boolean z2, boolean z3) {
        E();
        int i3 = 320;
        int i4 = z2 ? 24579 : 320;
        if (!z3) {
            i3 = 0;
        }
        if (this.s == 0) {
            return this.e.a(i, i2, i4, i3);
        }
        return this.f.a(i, i2, i4, i3);
    }

    public View a(View view, int i, RecyclerView.p pVar, RecyclerView.u uVar) {
        int h;
        View view2;
        View view3;
        R();
        if (e() == 0 || (h = h(i)) == Integer.MIN_VALUE) {
            return null;
        }
        E();
        a(h, (int) (((float) this.u.g()) * 0.33333334f), false, uVar);
        c cVar = this.t;
        cVar.g = Integer.MIN_VALUE;
        cVar.f896a = false;
        a(pVar, cVar, uVar, true);
        if (h == -1) {
            view2 = O();
        } else {
            view2 = N();
        }
        if (h == -1) {
            view3 = Q();
        } else {
            view3 = P();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }
}
