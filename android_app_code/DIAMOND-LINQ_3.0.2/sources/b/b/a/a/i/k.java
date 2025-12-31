package b.b.a.a.i;

import android.graphics.Canvas;
import android.graphics.Path;
import b.b.a.a.a.a;
import b.b.a.a.g.b.g;
import b.b.a.a.j.j;

public abstract class k extends c {
    private Path h = new Path();

    public k(a aVar, j jVar) {
        super(aVar, jVar);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f, float f2, g gVar) {
        this.d.setColor(gVar.v());
        this.d.setStrokeWidth(gVar.w());
        this.d.setPathEffect(gVar.x());
        if (gVar.y()) {
            this.h.reset();
            this.h.moveTo(f, this.f1268a.i());
            this.h.lineTo(f, this.f1268a.e());
            canvas.drawPath(this.h, this.d);
        }
        if (gVar.z()) {
            this.h.reset();
            this.h.moveTo(this.f1268a.g(), f2);
            this.h.lineTo(this.f1268a.h(), f2);
            canvas.drawPath(this.h, this.d);
        }
    }
}
