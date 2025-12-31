package b.b.a.a.d;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import b.b.a.a.e.b;
import b.b.a.a.g.b.e;
import b.b.a.a.j.i;
import java.util.ArrayList;
import java.util.List;

public class l extends m<j> implements e {
    private a F = a.LINEAR;
    private List<Integer> G = null;
    private int H = -1;
    private float I = 8.0f;
    private float J = 4.0f;
    private float K = 0.2f;
    private DashPathEffect L = null;
    private b.b.a.a.e.e M = new b();
    private boolean N = true;
    private boolean O = true;

    public enum a {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public l(List<j> list, String str) {
        super(list, str);
        if (this.G == null) {
            this.G = new ArrayList();
        }
        this.G.clear();
        this.G.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    public int A() {
        return this.G.size();
    }

    public b.b.a.a.e.e D() {
        return this.M;
    }

    public boolean F() {
        return this.L != null;
    }

    public int G() {
        return this.H;
    }

    public float H() {
        return this.K;
    }

    public DashPathEffect I() {
        return this.L;
    }

    public float K() {
        return this.I;
    }

    public a M() {
        return this.F;
    }

    public boolean N() {
        return this.N;
    }

    public float O() {
        return this.J;
    }

    public boolean P() {
        return this.O;
    }

    @Deprecated
    public boolean Q() {
        return this.F == a.STEPPED;
    }

    public void b(float f) {
        if (f >= 1.0f) {
            this.I = i.a(f);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 1");
        }
    }

    public void d(boolean z) {
        this.N = z;
    }

    public void da() {
        if (this.G == null) {
            this.G = new ArrayList();
        }
        this.G.clear();
    }

    public int e(int i) {
        return this.G.get(i).intValue();
    }

    public void g(int i) {
        da();
        this.G.add(Integer.valueOf(i));
    }
}
