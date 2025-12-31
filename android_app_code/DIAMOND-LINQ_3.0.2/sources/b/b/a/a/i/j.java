package b.b.a.a.i;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import b.b.a.a.a.a;
import b.b.a.a.j.i;

public abstract class j extends k {
    public j(a aVar, b.b.a.a.j.j jVar) {
        super(aVar, jVar);
    }

    private boolean b() {
        return i.d() >= 18;
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, Path path, Drawable drawable) {
        if (b()) {
            int save = canvas.save();
            canvas.clipPath(path);
            drawable.setBounds((int) this.f1268a.g(), (int) this.f1268a.i(), (int) this.f1268a.h(), (int) this.f1268a.e());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + i.d() + ".");
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, Path path, int i, int i2) {
        int i3 = (i & 16777215) | (i2 << 24);
        if (b()) {
            int save = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i3);
            canvas.restoreToCount(save);
            return;
        }
        Paint.Style style = this.c.getStyle();
        int color = this.c.getColor();
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(i3);
        canvas.drawPath(path, this.c);
        this.c.setColor(color);
        this.c.setStyle(style);
    }
}
