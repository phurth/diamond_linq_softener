package b.c.a.a.f;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import b.c.a.a.f.d;

public interface f extends d.a {

    public static class a implements TypeEvaluator<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final TypeEvaluator<d> f1301a = new a();

        /* renamed from: b  reason: collision with root package name */
        private final d f1302b = new d();

        /* renamed from: a */
        public d evaluate(float f, d dVar, d dVar2) {
            this.f1302b.a(b.c.a.a.k.a.a(dVar.f1305a, dVar2.f1305a, f), b.c.a.a.k.a.a(dVar.f1306b, dVar2.f1306b, f), b.c.a.a.k.a.a(dVar.c, dVar2.c, f));
            return this.f1302b;
        }
    }

    public static class b extends Property<f, d> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<f, d> f1303a = new b("circularReveal");

        private b(String str) {
            super(d.class, str);
        }

        /* renamed from: a */
        public d get(f fVar) {
            return fVar.getRevealInfo();
        }

        /* renamed from: a */
        public void set(f fVar, d dVar) {
            fVar.setRevealInfo(dVar);
        }
    }

    public static class c extends Property<f, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<f, Integer> f1304a = new c("circularRevealScrimColor");

        private c(String str) {
            super(Integer.class, str);
        }

        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getCircularRevealScrimColor());
        }

        /* renamed from: a */
        public void set(f fVar, Integer num) {
            fVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public float f1305a;

        /* renamed from: b  reason: collision with root package name */
        public float f1306b;
        public float c;

        public void a(float f, float f2, float f3) {
            this.f1305a = f;
            this.f1306b = f2;
            this.c = f3;
        }

        private d() {
        }

        public d(float f, float f2, float f3) {
            this.f1305a = f;
            this.f1306b = f2;
            this.c = f3;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(d dVar);
}
