package b.a.a;

import android.content.Context;
import com.chandlersystemsinc.signatureappcore.views.CsGridGraphView;
import no.nordicsemi.android.log.BuildConfig;

public final class pa {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1172a;

    /* renamed from: b  reason: collision with root package name */
    private final qa f1173b;
    private String c;
    private boolean d;
    private String e;
    private String f;
    private String g;
    private String h;
    private boolean i;
    private String j;
    private int k;
    private CsGridGraphView.a l;
    private float[] m;
    private float[] n;
    private String o = BuildConfig.FLAVOR;
    private boolean p;
    private boolean q;
    private final int r;
    private final int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private String x;
    private String y;

    public pa(Context context, qa qaVar, String str, int i2, String str2, boolean z, boolean z2, boolean z3, String str3, String str4) {
        this.f1172a = context;
        this.f1173b = qaVar;
        this.c = str;
        this.k = i2;
        this.o = str2 == null ? BuildConfig.FLAVOR : str2;
        this.p = z;
        this.t = z2;
        this.u = z3;
        this.x = str3 == null ? BuildConfig.FLAVOR : str3;
        this.y = str4 == null ? BuildConfig.FLAVOR : str4;
        this.r = this.f1172a.getResources().getColor(za.item_function_color);
        this.s = this.f1172a.getResources().getColor(za.item_function_secondary_color);
    }

    public void a(float[] fArr) {
        this.n = fArr;
    }

    public CsGridGraphView.a b() {
        return this.l;
    }

    public String c() {
        return this.o;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public void e(String str) {
        this.f = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof pa)) {
            return false;
        }
        pa paVar = (pa) obj;
        if (!this.c.equals(paVar.o()) || !this.o.equals(paVar.c())) {
            return false;
        }
        return true;
    }

    public void f(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.c = str;
    }

    public void h(String str) {
        this.j = str;
    }

    public String i() {
        return this.y;
    }

    public String j() {
        return this.x;
    }

    public qa k() {
        return this.f1173b;
    }

    public String l() {
        return this.g;
    }

    public String m() {
        return this.f;
    }

    public String n() {
        return this.e;
    }

    public String o() {
        return this.c;
    }

    public String p() {
        return this.j;
    }

    public int q() {
        return this.k;
    }

    public boolean r() {
        return this.p;
    }

    public boolean s() {
        return this.q;
    }

    public boolean t() {
        return this.i;
    }

    public boolean u() {
        return this.v;
    }

    public boolean v() {
        return this.u;
    }

    public boolean w() {
        return this.d;
    }

    public boolean x() {
        return this.t;
    }

    public void a(String str) {
        this.o = str;
    }

    public void b(int i2) {
        this.k = i2;
    }

    public void c(boolean z) {
        this.u = z && !ia.a(this.x) && !ia.a(this.y);
    }

    public void d(String str) {
        this.g = str;
    }

    public int e() {
        return this.s;
    }

    public String f() {
        return this.h;
    }

    public float[] g() {
        return this.m;
    }

    public float[] h() {
        return this.n;
    }

    public void a(boolean z) {
        this.p = z;
        this.q = !z;
    }

    public void b(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.y = str;
    }

    public int d() {
        return this.r;
    }

    public void e(boolean z) {
        this.t = z;
    }

    public void b(boolean z) {
        this.v = z;
    }

    public int a() {
        return this.w;
    }

    public void c(String str) {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.x = str;
    }

    public void a(int i2) {
        this.w = i2;
    }

    public pa(Context context, qa qaVar, CsGridGraphView.a aVar, String str, String str2, boolean z, float[] fArr, boolean z2, String str3, String str4) {
        this.f1172a = context;
        this.f1173b = qaVar;
        this.l = aVar;
        this.c = str;
        this.h = str2;
        this.i = z;
        this.m = fArr;
        this.u = z2;
        this.x = str3 == null ? BuildConfig.FLAVOR : str3;
        this.y = str4 == null ? BuildConfig.FLAVOR : str4;
        this.r = this.f1172a.getResources().getColor(za.item_function_color);
        this.s = this.f1172a.getResources().getColor(za.item_function_secondary_color);
    }
}
