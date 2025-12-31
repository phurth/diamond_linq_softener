package b.c.a.a.p;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final k[] f1328a = new k[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f1329b = new Matrix[4];
    private final Matrix[] c = new Matrix[4];
    private final PointF d = new PointF();
    private final k e = new k();
    private final float[] f = new float[2];
    private final float[] g = new float[2];

    public interface a {
        void a(k kVar, Matrix matrix, int i);

        void b(k kVar, Matrix matrix, int i);
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final h f1330a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f1331b;
        public final RectF c;
        public final a d;
        public final float e;

        b(h hVar, float f, RectF rectF, a aVar, Path path) {
            this.d = aVar;
            this.f1330a = hVar;
            this.e = f;
            this.c = rectF;
            this.f1331b = path;
        }
    }

    public i() {
        for (int i = 0; i < 4; i++) {
            this.f1328a[i] = new k();
            this.f1329b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    private float a(int i) {
        return (float) ((i + 1) * 90);
    }

    private void b(int i) {
        float[] fArr = this.f;
        k[] kVarArr = this.f1328a;
        fArr[0] = kVarArr[i].c;
        fArr[1] = kVarArr[i].d;
        this.f1329b[i].mapPoints(fArr);
        float a2 = a(i);
        this.c[i].reset();
        Matrix matrix = this.c[i];
        float[] fArr2 = this.f;
        matrix.setTranslate(fArr2[0], fArr2[1]);
        this.c[i].preRotate(a2);
    }

    private void c(b bVar, int i) {
        a(i, bVar.f1330a).a(90.0f, bVar.e, this.f1328a[i]);
        float a2 = a(i);
        this.f1329b[i].reset();
        a(i, bVar.c, this.d);
        Matrix matrix = this.f1329b[i];
        PointF pointF = this.d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f1329b[i].preRotate(a2);
    }

    public void a(h hVar, float f2, RectF rectF, Path path) {
        a(hVar, f2, rectF, (a) null, path);
    }

    public void a(h hVar, float f2, RectF rectF, a aVar, Path path) {
        path.rewind();
        b bVar = new b(hVar, f2, rectF, aVar, path);
        for (int i = 0; i < 4; i++) {
            c(bVar, i);
            b(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            a(bVar, i2);
            b(bVar, i2);
        }
        path.close();
    }

    private void b(b bVar, int i) {
        int i2 = (i + 1) % 4;
        float[] fArr = this.f;
        k[] kVarArr = this.f1328a;
        fArr[0] = kVarArr[i].c;
        fArr[1] = kVarArr[i].d;
        this.f1329b[i].mapPoints(fArr);
        float[] fArr2 = this.g;
        k[] kVarArr2 = this.f1328a;
        fArr2[0] = kVarArr2[i2].f1333a;
        fArr2[1] = kVarArr2[i2].f1334b;
        this.f1329b[i2].mapPoints(fArr2);
        float[] fArr3 = this.f;
        float f2 = fArr3[0];
        float[] fArr4 = this.g;
        float max = Math.max(((float) Math.hypot((double) (f2 - fArr4[0]), (double) (fArr3[1] - fArr4[1]))) - 0.001f, 0.0f);
        float a2 = a(bVar.c, i);
        this.e.b(0.0f, 0.0f);
        b(i, bVar.f1330a).a(max, a2, bVar.e, this.e);
        this.e.a(this.c[i], bVar.f1331b);
        a aVar = bVar.d;
        if (aVar != null) {
            aVar.b(this.e, this.c[i], i);
        }
    }

    private void a(b bVar, int i) {
        float[] fArr = this.f;
        k[] kVarArr = this.f1328a;
        fArr[0] = kVarArr[i].f1333a;
        fArr[1] = kVarArr[i].f1334b;
        this.f1329b[i].mapPoints(fArr);
        if (i == 0) {
            Path path = bVar.f1331b;
            float[] fArr2 = this.f;
            path.moveTo(fArr2[0], fArr2[1]);
        } else {
            Path path2 = bVar.f1331b;
            float[] fArr3 = this.f;
            path2.lineTo(fArr3[0], fArr3[1]);
        }
        this.f1328a[i].a(this.f1329b[i], bVar.f1331b);
        a aVar = bVar.d;
        if (aVar != null) {
            aVar.a(this.f1328a[i], this.f1329b[i], i);
        }
    }

    private float a(RectF rectF, int i) {
        float[] fArr = this.f;
        k[] kVarArr = this.f1328a;
        fArr[0] = kVarArr[i].c;
        fArr[1] = kVarArr[i].d;
        this.f1329b[i].mapPoints(fArr);
        if (i == 1 || i == 3) {
            return Math.abs(rectF.centerX() - this.f[0]);
        }
        return Math.abs(rectF.centerY() - this.f[1]);
    }

    private a a(int i, h hVar) {
        if (i == 1) {
            return hVar.c();
        }
        if (i == 2) {
            return hVar.b();
        }
        if (i != 3) {
            return hVar.h();
        }
        return hVar.g();
    }

    private c b(int i, h hVar) {
        if (i == 1) {
            return hVar.a();
        }
        if (i == 2) {
            return hVar.d();
        }
        if (i != 3) {
            return hVar.e();
        }
        return hVar.f();
    }

    private void a(int i, RectF rectF, PointF pointF) {
        if (i == 1) {
            pointF.set(rectF.right, rectF.bottom);
        } else if (i == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }
}
