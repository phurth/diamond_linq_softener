package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.i f993a;

    /* renamed from: b  reason: collision with root package name */
    private int f994b;
    final Rect c;

    /* synthetic */ x(RecyclerView.i iVar, v vVar) {
        this(iVar);
    }

    public static x a(RecyclerView.i iVar, int i) {
        if (i == 0) {
            return a(iVar);
        }
        if (i == 1) {
            return b(iVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static x b(RecyclerView.i iVar) {
        return new w(iVar);
    }

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public int h() {
        if (Integer.MIN_VALUE == this.f994b) {
            return 0;
        }
        return g() - this.f994b;
    }

    public void i() {
        this.f994b = g();
    }

    private x(RecyclerView.i iVar) {
        this.f994b = Integer.MIN_VALUE;
        this.c = new Rect();
        this.f993a = iVar;
    }

    public static x a(RecyclerView.i iVar) {
        return new v(iVar);
    }
}
