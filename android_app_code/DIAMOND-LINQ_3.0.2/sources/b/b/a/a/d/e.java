package b.b.a.a.d;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import b.b.a.a.c.f;
import b.b.a.a.c.j;
import b.b.a.a.d.j;
import b.b.a.a.e.f;
import b.b.a.a.g.b.d;
import b.b.a.a.j.i;
import java.util.ArrayList;
import java.util.List;

public abstract class e<T extends j> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    protected List<Integer> f1232a;

    /* renamed from: b  reason: collision with root package name */
    protected List<Integer> f1233b;
    private String c;
    protected j.a d;
    protected boolean e;
    protected transient f f;
    protected Typeface g;
    private f.b h;
    private float i;
    private float j;
    private DashPathEffect k;
    protected boolean l;
    protected boolean m;
    protected b.b.a.a.j.e n;
    protected float o;
    protected boolean p;

    public e() {
        this.f1232a = null;
        this.f1233b = null;
        this.c = "DataSet";
        this.d = j.a.LEFT;
        this.e = true;
        this.h = f.b.DEFAULT;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = null;
        this.l = true;
        this.m = true;
        this.n = new b.b.a.a.j.e();
        this.o = 17.0f;
        this.p = true;
        this.f1232a = new ArrayList();
        this.f1233b = new ArrayList();
        this.f1232a.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.f1233b.add(-16777216);
    }

    public void a(b.b.a.a.e.f fVar) {
        if (fVar != null) {
            this.f = fVar;
        }
    }

    public void aa() {
        if (this.f1232a == null) {
            this.f1232a = new ArrayList();
        }
        this.f1232a.clear();
    }

    public int c(int i2) {
        List<Integer> list = this.f1232a;
        return list.get(i2 % list.size()).intValue();
    }

    public int d(int i2) {
        List<Integer> list = this.f1233b;
        return list.get(i2 % list.size()).intValue();
    }

    public f.b e() {
        return this.h;
    }

    public void f(int i2) {
        aa();
        this.f1232a.add(Integer.valueOf(i2));
    }

    public float h() {
        return this.o;
    }

    public b.b.a.a.e.f i() {
        if (m()) {
            return i.a();
        }
        return this.f;
    }

    public boolean isVisible() {
        return this.p;
    }

    public float j() {
        return this.j;
    }

    public float k() {
        return this.i;
    }

    public Typeface l() {
        return this.g;
    }

    public boolean m() {
        return this.f == null;
    }

    public List<Integer> n() {
        return this.f1232a;
    }

    public boolean p() {
        return this.l;
    }

    public j.a q() {
        return this.d;
    }

    public b.b.a.a.j.e s() {
        return this.n;
    }

    public int t() {
        return this.f1232a.get(0).intValue();
    }

    public boolean u() {
        return this.e;
    }

    public void a(int i2) {
        this.f1233b.clear();
        this.f1233b.add(Integer.valueOf(i2));
    }

    public DashPathEffect c() {
        return this.k;
    }

    public boolean d() {
        return this.m;
    }

    public String f() {
        return this.c;
    }

    public e(String str) {
        this();
        this.c = str;
    }
}
