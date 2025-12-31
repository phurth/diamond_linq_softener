package a.n;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* renamed from: a.n.d  reason: case insensitive filesystem */
class C0049d extends Property<Drawable, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private Rect f304a = new Rect();

    C0049d(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public void set(Drawable drawable, PointF pointF) {
        drawable.copyBounds(this.f304a);
        this.f304a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(this.f304a);
    }

    /* renamed from: a */
    public PointF get(Drawable drawable) {
        drawable.copyBounds(this.f304a);
        Rect rect = this.f304a;
        return new PointF((float) rect.left, (float) rect.top);
    }
}
