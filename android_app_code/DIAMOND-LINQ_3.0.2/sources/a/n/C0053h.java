package a.n;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* renamed from: a.n.h  reason: case insensitive filesystem */
class C0053h extends Property<View, PointF> {
    C0053h(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public PointF get(View view) {
        return null;
    }

    /* renamed from: a */
    public void set(View view, PointF pointF) {
        ba.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
    }
}
