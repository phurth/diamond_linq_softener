package b.b.a.a.d;

import android.graphics.DashPathEffect;
import b.b.a.a.d.j;
import b.b.a.a.g.b.g;
import b.b.a.a.j.i;
import java.util.List;

public abstract class n<T extends j> extends d<T> implements g<T> {
    protected boolean w;
    protected boolean x;
    protected float y;
    protected DashPathEffect z;

    public n(List<T> list, String str) {
        super(list, str);
        this.w = true;
        this.x = true;
        this.y = 0.5f;
        this.z = null;
        this.y = i.a(0.5f);
    }

    public void a(boolean z2) {
        this.x = z2;
    }

    public void b(boolean z2) {
        this.w = z2;
    }

    public float w() {
        return this.y;
    }

    public DashPathEffect x() {
        return this.z;
    }

    public boolean y() {
        return this.w;
    }

    public boolean z() {
        return this.x;
    }
}
