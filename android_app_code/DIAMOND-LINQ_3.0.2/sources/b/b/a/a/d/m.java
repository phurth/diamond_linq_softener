package b.b.a.a.d;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import b.b.a.a.d.j;
import b.b.a.a.g.b.f;
import java.util.List;

public abstract class m<T extends j> extends n<T> implements f<T> {
    private int A = Color.rgb(140, 234, 255);
    protected Drawable B;
    private int C = 85;
    private float D = 2.5f;
    private boolean E = false;

    public m(List<T> list, String str) {
        super(list, str);
    }

    public int B() {
        return this.A;
    }

    public int C() {
        return this.C;
    }

    public float E() {
        return this.D;
    }

    public Drawable J() {
        return this.B;
    }

    public boolean L() {
        return this.E;
    }

    @TargetApi(18)
    public void a(Drawable drawable) {
        this.B = drawable;
    }

    public void c(boolean z) {
        this.E = z;
    }
}
