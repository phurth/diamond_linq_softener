package b.c.a.a.f;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import b.c.a.a.f.f;

public class c extends FrameLayout implements f {

    /* renamed from: a  reason: collision with root package name */
    private final d f1299a;

    public void a() {
        this.f1299a.a();
        throw null;
    }

    public void b() {
        this.f1299a.b();
        throw null;
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        d dVar = this.f1299a;
        if (dVar == null) {
            super.draw(canvas);
        } else {
            dVar.a(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.f1299a.c();
        throw null;
    }

    public int getCircularRevealScrimColor() {
        this.f1299a.d();
        throw null;
    }

    public f.d getRevealInfo() {
        this.f1299a.e();
        throw null;
    }

    public boolean isOpaque() {
        d dVar = this.f1299a;
        if (dVar == null) {
            return super.isOpaque();
        }
        dVar.f();
        throw null;
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f1299a.a(drawable);
        throw null;
    }

    public void setCircularRevealScrimColor(int i) {
        this.f1299a.a(i);
        throw null;
    }

    public void setRevealInfo(f.d dVar) {
        this.f1299a.a(dVar);
        throw null;
    }
}
