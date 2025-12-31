package b.c.a.a.p;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public float f1333a;

    /* renamed from: b  reason: collision with root package name */
    public float f1334b;
    public float c;
    public float d;
    public float e;
    public float f;
    private final List<e> g = new ArrayList();
    private final List<f> h = new ArrayList();

    static class a extends f {

        /* renamed from: b  reason: collision with root package name */
        private final c f1335b;

        public a(c cVar) {
            this.f1335b = cVar;
        }

        public void a(Matrix matrix, b.c.a.a.o.a aVar, int i, Canvas canvas) {
            c cVar = this.f1335b;
            float f = cVar.g;
            float f2 = cVar.h;
            aVar.a(canvas, matrix, new RectF(cVar.c, cVar.d, cVar.e, cVar.f), i, f, f2);
        }
    }

    public static class c extends e {

        /* renamed from: b  reason: collision with root package name */
        private static final RectF f1337b = new RectF();
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;

        public c(float f2, float f3, float f4, float f5) {
            this.c = f2;
            this.d = f3;
            this.e = f4;
            this.f = f5;
        }

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1339a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f1337b.set(this.c, this.d, this.e, this.f);
            path.arcTo(f1337b, this.g, this.h, false);
            path.transform(matrix);
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f1339a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        static final Matrix f1340a = new Matrix();

        f() {
        }

        public abstract void a(Matrix matrix, b.c.a.a.o.a aVar, int i, Canvas canvas);

        public final void a(b.c.a.a.o.a aVar, int i, Canvas canvas) {
            a(f1340a, aVar, i, canvas);
        }
    }

    public k() {
        b(0.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f1333a = f2;
        this.f1334b = f3;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = (f4 + f5) % 360.0f;
        this.g.clear();
        this.h.clear();
    }

    public void b(float f2, float f3) {
        a(f2, f3, 270.0f, 0.0f);
    }

    public static class d extends e {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f1338b;
        /* access modifiers changed from: private */
        public float c;

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f1339a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f1338b, this.c);
            path.transform(matrix);
        }
    }

    static class b extends f {

        /* renamed from: b  reason: collision with root package name */
        private final d f1336b;
        private final float c;
        private final float d;

        public b(d dVar, float f, float f2) {
            this.f1336b = dVar;
            this.c = f;
            this.d = f2;
        }

        public void a(Matrix matrix, b.c.a.a.o.a aVar, int i, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.f1336b.c - this.d), (double) (this.f1336b.f1338b - this.c)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.d);
            matrix2.preRotate(a());
            aVar.a(canvas, matrix2, rectF, i);
        }

        /* access modifiers changed from: package-private */
        public float a() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f1336b.c - this.d) / (this.f1336b.f1338b - this.c))));
        }
    }

    public void a(float f2, float f3) {
        d dVar = new d();
        float unused = dVar.f1338b = f2;
        float unused2 = dVar.c = f3;
        this.g.add(dVar);
        b bVar = new b(dVar, this.c, this.d);
        a(bVar, bVar.a() + 270.0f, bVar.a() + 270.0f);
        this.c = f2;
        this.d = f3;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.g = f6;
        cVar.h = f7;
        this.g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        a(aVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = (double) f8;
        this.c = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2))));
        this.d = ((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).a(matrix, path);
        }
    }

    /* access modifiers changed from: package-private */
    public f a(Matrix matrix) {
        a(this.f);
        return new j(this, new ArrayList(this.h), matrix);
    }

    private void a(f fVar, float f2, float f3) {
        a(f2);
        this.h.add(fVar);
        this.e = f3;
    }

    private void a(float f2) {
        float f3 = this.e;
        if (f3 != f2) {
            float f4 = ((f2 - f3) + 360.0f) % 360.0f;
            if (f4 <= 180.0f) {
                float f5 = this.c;
                float f6 = this.d;
                c cVar = new c(f5, f6, f5, f6);
                cVar.g = this.e;
                cVar.h = f4;
                this.h.add(new a(cVar));
                this.e = f2;
            }
        }
    }
}
