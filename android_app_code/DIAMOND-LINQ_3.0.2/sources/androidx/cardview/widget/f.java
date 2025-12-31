package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

class f implements h {

    /* renamed from: a  reason: collision with root package name */
    final RectF f668a = new RectF();

    f() {
    }

    private j j(g gVar) {
        return (j) gVar.c();
    }

    public void a() {
        j.f672b = new e(this);
    }

    public float b(g gVar) {
        return j(gVar).b();
    }

    public void c(g gVar) {
    }

    public void c(g gVar, float f) {
        j(gVar).b(f);
        i(gVar);
    }

    public float d(g gVar) {
        return j(gVar).c();
    }

    public ColorStateList e(g gVar) {
        return j(gVar).a();
    }

    public float f(g gVar) {
        return j(gVar).d();
    }

    public float g(g gVar) {
        return j(gVar).e();
    }

    public void h(g gVar) {
        j(gVar).a(gVar.a());
        i(gVar);
    }

    public void i(g gVar) {
        Rect rect = new Rect();
        j(gVar).a(rect);
        gVar.a((int) Math.ceil((double) g(gVar)), (int) Math.ceil((double) f(gVar)));
        gVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(g gVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        j a2 = a(context, colorStateList, f, f2, f3);
        a2.a(gVar.a());
        gVar.a(a2);
        i(gVar);
    }

    public void b(g gVar, float f) {
        j(gVar).c(f);
    }

    private j a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new j(context.getResources(), colorStateList, f, f2, f3);
    }

    public void a(g gVar, ColorStateList colorStateList) {
        j(gVar).a(colorStateList);
    }

    public void a(g gVar, float f) {
        j(gVar).a(f);
        i(gVar);
    }

    public float a(g gVar) {
        return j(gVar).f();
    }
}
