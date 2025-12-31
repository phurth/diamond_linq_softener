package a.n;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: a.n.w  reason: case insensitive filesystem */
class C0067w<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f333a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f334b;
    private final float c;
    private final float[] d = new float[2];
    private final PointF e = new PointF();
    private float f;

    C0067w(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f333a = property;
        this.f334b = new PathMeasure(path, false);
        this.c = this.f334b.getLength();
    }

    /* renamed from: a */
    public void set(T t, Float f2) {
        this.f = f2.floatValue();
        this.f334b.getPosTan(this.c * f2.floatValue(), this.d, (float[]) null);
        PointF pointF = this.e;
        float[] fArr = this.d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f333a.set(t, pointF);
    }

    public Float get(T t) {
        return Float.valueOf(this.f);
    }
}
