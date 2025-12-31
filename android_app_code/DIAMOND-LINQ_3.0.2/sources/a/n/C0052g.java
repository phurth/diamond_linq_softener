package a.n;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* renamed from: a.n.g  reason: case insensitive filesystem */
class C0052g extends Property<View, PointF> {
    C0052g(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public PointF get(View view) {
        return null;
    }

    /* renamed from: a */
    public void set(View view, PointF pointF) {
        ba.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
    }
}
