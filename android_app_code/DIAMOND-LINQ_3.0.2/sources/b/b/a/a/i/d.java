package b.b.a.a.i;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import b.b.a.a.a.a;
import b.b.a.a.e.f;
import b.b.a.a.f.c;
import b.b.a.a.j.i;
import b.b.a.a.j.j;

public abstract class d extends l {

    /* renamed from: b  reason: collision with root package name */
    protected a f1261b;
    protected Paint c = new Paint(1);
    protected Paint d;
    protected Paint e;
    protected Paint f;

    public d(a aVar, j jVar) {
        super(jVar);
        this.f1261b = aVar;
        this.c.setStyle(Paint.Style.FILL);
        this.e = new Paint(4);
        this.f = new Paint(1);
        this.f.setColor(Color.rgb(63, 63, 63));
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setTextSize(i.a(9.0f));
        this.d = new Paint(1);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(2.0f);
        this.d.setColor(Color.rgb(255, 187, 115));
    }

    public abstract void a();

    public abstract void a(Canvas canvas);

    public abstract void a(Canvas canvas, c[] cVarArr);

    /* access modifiers changed from: protected */
    public boolean a(b.b.a.a.g.a.c cVar) {
        return ((float) cVar.getData().d()) < ((float) cVar.getMaxVisibleCount()) * this.f1268a.p();
    }

    public abstract void b(Canvas canvas);

    public abstract void c(Canvas canvas);

    /* access modifiers changed from: protected */
    public void a(b.b.a.a.g.b.d dVar) {
        this.f.setTypeface(dVar.l());
        this.f.setTextSize(dVar.h());
    }

    public void a(Canvas canvas, f fVar, float f2, b.b.a.a.d.j jVar, int i, float f3, float f4, int i2) {
        this.f.setColor(i2);
        canvas.drawText(fVar.a(f2, jVar, i, this.f1268a), f3, f4, this.f);
    }
}
