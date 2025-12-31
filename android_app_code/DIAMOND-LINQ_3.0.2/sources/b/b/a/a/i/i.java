package b.b.a.a.i;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import b.b.a.a.d.k;
import b.b.a.a.d.l;
import b.b.a.a.g.a.d;
import b.b.a.a.g.b.e;
import b.b.a.a.i.c;
import b.b.a.a.j.g;
import b.b.a.a.j.j;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class i extends j {
    protected d i;
    protected Paint j;
    protected WeakReference<Bitmap> k;
    protected Canvas l;
    protected Bitmap.Config m = Bitmap.Config.ARGB_8888;
    protected Path n = new Path();
    protected Path o = new Path();
    private float[] p = new float[4];
    protected Path q = new Path();
    private HashMap<b.b.a.a.g.b.d, a> r = new HashMap<>();
    private float[] s = new float[2];

    public i(d dVar, b.b.a.a.a.a aVar, j jVar) {
        super(aVar, jVar);
        this.i = dVar;
        this.j = new Paint(1);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setColor(-1);
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        int l2 = (int) this.f1268a.l();
        int k2 = (int) this.f1268a.k();
        WeakReference<Bitmap> weakReference = this.k;
        if (!(weakReference != null && ((Bitmap) weakReference.get()).getWidth() == l2 && ((Bitmap) this.k.get()).getHeight() == k2)) {
            if (l2 > 0 && k2 > 0) {
                this.k = new WeakReference<>(Bitmap.createBitmap(l2, k2, this.m));
                this.l = new Canvas((Bitmap) this.k.get());
            } else {
                return;
            }
        }
        ((Bitmap) this.k.get()).eraseColor(0);
        for (e eVar : this.i.getLineData().c()) {
            if (eVar.isVisible()) {
                a(canvas, eVar);
            }
        }
        canvas.drawBitmap((Bitmap) this.k.get(), 0.0f, 0.0f, this.c);
    }

    /* access modifiers changed from: protected */
    public void b(e eVar) {
        float b2 = this.f1261b.b();
        g a2 = this.i.a(eVar.q());
        this.g.a(this.i, eVar);
        this.n.reset();
        c.a aVar = this.g;
        if (aVar.c >= 1) {
            b.b.a.a.d.j b3 = eVar.b(aVar.f1259a);
            this.n.moveTo(b3.d(), b3.c() * b2);
            int i2 = this.g.f1259a + 1;
            while (true) {
                c.a aVar2 = this.g;
                if (i2 > aVar2.c + aVar2.f1259a) {
                    break;
                }
                b.b.a.a.d.j b4 = eVar.b(i2);
                float d = b3.d() + ((b4.d() - b3.d()) / 2.0f);
                this.n.cubicTo(d, b3.c() * b2, d, b4.c() * b2, b4.d(), b4.c() * b2);
                i2++;
                b3 = b4;
            }
        }
        if (eVar.L()) {
            this.o.reset();
            this.o.addPath(this.n);
            a(this.l, eVar, this.o, a2, this.g);
        }
        this.c.setColor(eVar.t());
        this.c.setStyle(Paint.Style.STROKE);
        a2.a(this.n);
        this.l.drawPath(this.n, this.c);
        this.c.setPathEffect((PathEffect) null);
    }

    public void c(Canvas canvas) {
        int i2;
        b.b.a.a.j.e eVar;
        float f;
        float f2;
        if (a((b.b.a.a.g.a.c) this.i)) {
            List c = this.i.getLineData().c();
            for (int i3 = 0; i3 < c.size(); i3++) {
                e eVar2 = (e) c.get(i3);
                if (b(eVar2)) {
                    a((b.b.a.a.g.b.d) eVar2);
                    g a2 = this.i.a(eVar2.q());
                    int K = (int) (eVar2.K() * 1.75f);
                    if (!eVar2.N()) {
                        K /= 2;
                    }
                    int i4 = K;
                    this.g.a(this.i, eVar2);
                    float a3 = this.f1261b.a();
                    float b2 = this.f1261b.b();
                    c.a aVar = this.g;
                    float[] a4 = a2.a(eVar2, a3, b2, aVar.f1259a, aVar.f1260b);
                    b.b.a.a.j.e a5 = b.b.a.a.j.e.a(eVar2.s());
                    a5.e = b.b.a.a.j.i.a(a5.e);
                    a5.f = b.b.a.a.j.i.a(a5.f);
                    int i5 = 0;
                    while (i5 < a4.length) {
                        float f3 = a4[i5];
                        float f4 = a4[i5 + 1];
                        if (!this.f1268a.c(f3)) {
                            break;
                        }
                        if (!this.f1268a.b(f3) || !this.f1268a.f(f4)) {
                            i2 = i5;
                            eVar = a5;
                        } else {
                            int i6 = i5 / 2;
                            b.b.a.a.d.j b3 = eVar2.b(this.g.f1259a + i6);
                            if (eVar2.p()) {
                                f2 = f4;
                                f = f3;
                                i2 = i5;
                                eVar = a5;
                                a(canvas, eVar2.i(), b3.c(), b3, i3, f3, f4 - ((float) i4), eVar2.d(i6));
                            } else {
                                f2 = f4;
                                f = f3;
                                i2 = i5;
                                eVar = a5;
                            }
                            if (b3.b() != null && eVar2.d()) {
                                Drawable b4 = b3.b();
                                b.b.a.a.j.i.a(canvas, b4, (int) (f + eVar.e), (int) (f2 + eVar.f), b4.getIntrinsicWidth(), b4.getIntrinsicHeight());
                            }
                        }
                        i5 = i2 + 2;
                        a5 = eVar;
                    }
                    b.b.a.a.j.e.b(a5);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d(Canvas canvas) {
        a aVar;
        Bitmap a2;
        this.c.setStyle(Paint.Style.FILL);
        float b2 = this.f1261b.b();
        float[] fArr = this.s;
        float f = 0.0f;
        char c = 0;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List c2 = this.i.getLineData().c();
        int i2 = 0;
        while (i2 < c2.size()) {
            e eVar = (e) c2.get(i2);
            if (eVar.isVisible() && eVar.N() && eVar.r() != 0) {
                this.j.setColor(eVar.G());
                g a3 = this.i.a(eVar.q());
                this.g.a(this.i, eVar);
                float K = eVar.K();
                float O = eVar.O();
                boolean z = eVar.P() && O < K && O > f;
                boolean z2 = z && eVar.G() == 1122867;
                if (this.r.containsKey(eVar)) {
                    aVar = this.r.get(eVar);
                } else {
                    aVar = new a(this, (h) null);
                    this.r.put(eVar, aVar);
                }
                if (aVar.a(eVar)) {
                    aVar.a(eVar, z, z2);
                }
                c.a aVar2 = this.g;
                int i3 = aVar2.c;
                int i4 = aVar2.f1259a;
                int i5 = i3 + i4;
                while (i4 <= i5) {
                    b.b.a.a.d.j b3 = eVar.b(i4);
                    if (b3 == null) {
                        break;
                    }
                    this.s[c] = b3.d();
                    this.s[1] = b3.c() * b2;
                    a3.b(this.s);
                    if (!this.f1268a.c(this.s[c])) {
                        break;
                    }
                    if (!this.f1268a.b(this.s[c]) || !this.f1268a.f(this.s[1]) || (a2 = aVar.a(i4)) == null) {
                        Canvas canvas2 = canvas;
                    } else {
                        float[] fArr2 = this.s;
                        canvas.drawBitmap(a2, fArr2[c] - K, fArr2[1] - K, (Paint) null);
                    }
                    i4++;
                    c = 0;
                }
            }
            Canvas canvas3 = canvas;
            i2++;
            f = 0.0f;
            c = 0;
        }
    }

    private class a {

        /* renamed from: a  reason: collision with root package name */
        private Path f1266a;

        /* renamed from: b  reason: collision with root package name */
        private Bitmap[] f1267b;

        private a() {
            this.f1266a = new Path();
        }

        /* access modifiers changed from: protected */
        public boolean a(e eVar) {
            int A = eVar.A();
            Bitmap[] bitmapArr = this.f1267b;
            if (bitmapArr == null) {
                this.f1267b = new Bitmap[A];
                return true;
            } else if (bitmapArr.length == A) {
                return false;
            } else {
                this.f1267b = new Bitmap[A];
                return true;
            }
        }

        /* synthetic */ a(i iVar, h hVar) {
            this();
        }

        /* access modifiers changed from: protected */
        public void a(e eVar, boolean z, boolean z2) {
            int A = eVar.A();
            float K = eVar.K();
            float O = eVar.O();
            for (int i = 0; i < A; i++) {
                Bitmap.Config config = Bitmap.Config.ARGB_4444;
                double d = (double) K;
                Double.isNaN(d);
                int i2 = (int) (d * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i2, i2, config);
                Canvas canvas = new Canvas(createBitmap);
                this.f1267b[i] = createBitmap;
                i.this.c.setColor(eVar.e(i));
                if (z2) {
                    this.f1266a.reset();
                    this.f1266a.addCircle(K, K, K, Path.Direction.CW);
                    this.f1266a.addCircle(K, K, O, Path.Direction.CCW);
                    canvas.drawPath(this.f1266a, i.this.c);
                } else {
                    canvas.drawCircle(K, K, K, i.this.c);
                    if (z) {
                        canvas.drawCircle(K, K, O, i.this.j);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public Bitmap a(int i) {
            Bitmap[] bitmapArr = this.f1267b;
            return bitmapArr[i % bitmapArr.length];
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, e eVar) {
        if (eVar.r() >= 1) {
            this.c.setStrokeWidth(eVar.E());
            this.c.setPathEffect(eVar.I());
            int i2 = h.f1265a[eVar.M().ordinal()];
            if (i2 == 3) {
                a(eVar);
            } else if (i2 != 4) {
                b(canvas, eVar);
            } else {
                b(eVar);
            }
            this.c.setPathEffect((PathEffect) null);
        }
    }

    /* access modifiers changed from: protected */
    public void a(e eVar) {
        e eVar2 = eVar;
        Math.max(0.0f, Math.min(1.0f, this.f1261b.a()));
        float b2 = this.f1261b.b();
        g a2 = this.i.a(eVar.q());
        this.g.a(this.i, eVar2);
        float H = eVar.H();
        this.n.reset();
        c.a aVar = this.g;
        if (aVar.c >= 1) {
            int i2 = aVar.f1259a + 1;
            b.b.a.a.d.j b3 = eVar2.b(Math.max(i2 - 2, 0));
            b.b.a.a.d.j b4 = eVar2.b(Math.max(i2 - 1, 0));
            int i3 = -1;
            if (b4 != null) {
                this.n.moveTo(b4.d(), b4.c() * b2);
                int i4 = this.g.f1259a + 1;
                b.b.a.a.d.j jVar = b4;
                while (true) {
                    c.a aVar2 = this.g;
                    if (i4 > aVar2.c + aVar2.f1259a) {
                        break;
                    }
                    if (i3 != i4) {
                        jVar = eVar2.b(i4);
                    }
                    int i5 = i4 + 1;
                    if (i5 < eVar.r()) {
                        i4 = i5;
                    }
                    b.b.a.a.d.j b5 = eVar2.b(i4);
                    this.n.cubicTo(b4.d() + ((jVar.d() - b3.d()) * H), (b4.c() + ((jVar.c() - b3.c()) * H)) * b2, jVar.d() - ((b5.d() - b4.d()) * H), (jVar.c() - ((b5.c() - b4.c()) * H)) * b2, jVar.d(), jVar.c() * b2);
                    b3 = b4;
                    b4 = jVar;
                    jVar = b5;
                    int i6 = i4;
                    i4 = i5;
                    i3 = i6;
                }
            } else {
                return;
            }
        }
        if (eVar.L()) {
            this.o.reset();
            this.o.addPath(this.n);
            a(this.l, eVar, this.o, a2, this.g);
        }
        this.c.setColor(eVar.t());
        this.c.setStyle(Paint.Style.STROKE);
        a2.a(this.n);
        this.l.drawPath(this.n, this.c);
        this.c.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas, e eVar) {
        e eVar2 = eVar;
        int r2 = eVar.r();
        boolean Q = eVar.Q();
        int i2 = Q ? 4 : 2;
        g a2 = this.i.a(eVar.q());
        float b2 = this.f1261b.b();
        this.c.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = eVar.F() ? this.l : canvas;
        this.g.a(this.i, eVar2);
        if (eVar.L() && r2 > 0) {
            a(canvas, eVar2, a2, this.g);
        }
        if (eVar.n().size() > 1) {
            int i3 = i2 * 2;
            if (this.p.length <= i3) {
                this.p = new float[(i2 * 4)];
            }
            int i4 = this.g.f1259a;
            while (true) {
                c.a aVar = this.g;
                if (i4 > aVar.c + aVar.f1259a) {
                    break;
                }
                b.b.a.a.d.j b3 = eVar2.b(i4);
                if (b3 != null) {
                    this.p[0] = b3.d();
                    this.p[1] = b3.c() * b2;
                    if (i4 < this.g.f1260b) {
                        b.b.a.a.d.j b4 = eVar2.b(i4 + 1);
                        if (b4 == null) {
                            break;
                        } else if (Q) {
                            this.p[2] = b4.d();
                            float[] fArr = this.p;
                            fArr[3] = fArr[1];
                            fArr[4] = fArr[2];
                            fArr[5] = fArr[3];
                            fArr[6] = b4.d();
                            this.p[7] = b4.c() * b2;
                        } else {
                            this.p[2] = b4.d();
                            this.p[3] = b4.c() * b2;
                        }
                    } else {
                        float[] fArr2 = this.p;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[1];
                    }
                    a2.b(this.p);
                    if (!this.f1268a.c(this.p[0])) {
                        break;
                    } else if (this.f1268a.b(this.p[2]) && (this.f1268a.d(this.p[1]) || this.f1268a.a(this.p[3]))) {
                        this.c.setColor(eVar2.c(i4));
                        canvas2.drawLines(this.p, 0, i3, this.c);
                    }
                }
                i4++;
            }
        } else {
            int i5 = r2 * i2;
            if (this.p.length < Math.max(i5, i2) * 2) {
                this.p = new float[(Math.max(i5, i2) * 4)];
            }
            if (eVar2.b(this.g.f1259a) != null) {
                int i6 = this.g.f1259a;
                int i7 = 0;
                while (true) {
                    c.a aVar2 = this.g;
                    if (i6 > aVar2.c + aVar2.f1259a) {
                        break;
                    }
                    b.b.a.a.d.j b5 = eVar2.b(i6 == 0 ? 0 : i6 - 1);
                    b.b.a.a.d.j b6 = eVar2.b(i6);
                    if (!(b5 == null || b6 == null)) {
                        int i8 = i7 + 1;
                        this.p[i7] = b5.d();
                        int i9 = i8 + 1;
                        this.p[i8] = b5.c() * b2;
                        if (Q) {
                            int i10 = i9 + 1;
                            this.p[i9] = b6.d();
                            int i11 = i10 + 1;
                            this.p[i10] = b5.c() * b2;
                            int i12 = i11 + 1;
                            this.p[i11] = b6.d();
                            i9 = i12 + 1;
                            this.p[i12] = b5.c() * b2;
                        }
                        int i13 = i9 + 1;
                        this.p[i9] = b6.d();
                        this.p[i13] = b6.c() * b2;
                        i7 = i13 + 1;
                    }
                    i6++;
                }
                if (i7 > 0) {
                    a2.b(this.p);
                    this.c.setColor(eVar.t());
                    canvas2.drawLines(this.p, 0, Math.max((this.g.c + 1) * i2, i2) * 2, this.c);
                }
            }
        }
        this.c.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, e eVar, Path path, g gVar, c.a aVar) {
        float a2 = eVar.D().a(eVar, this.i);
        path.lineTo(eVar.b(aVar.f1259a + aVar.c).d(), a2);
        path.lineTo(eVar.b(aVar.f1259a).d(), a2);
        path.close();
        gVar.a(path);
        Drawable J = eVar.J();
        if (J != null) {
            a(canvas, path, J);
        } else {
            a(canvas, path, eVar.B(), eVar.C());
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, e eVar, g gVar, c.a aVar) {
        int i2;
        int i3;
        Path path = this.q;
        int i4 = aVar.f1259a;
        int i5 = aVar.c + i4;
        int i6 = 0;
        do {
            i2 = (i6 * 128) + i4;
            i3 = i2 + 128;
            if (i3 > i5) {
                i3 = i5;
            }
            if (i2 <= i3) {
                a(eVar, i2, i3, path);
                gVar.a(path);
                Drawable J = eVar.J();
                if (J != null) {
                    a(canvas, path, J);
                } else {
                    a(canvas, path, eVar.B(), eVar.C());
                }
            }
            i6++;
        } while (i2 <= i3);
    }

    private void a(e eVar, int i2, int i3, Path path) {
        float a2 = eVar.D().a(eVar, this.i);
        float b2 = this.f1261b.b();
        boolean z = eVar.M() == l.a.STEPPED;
        path.reset();
        b.b.a.a.d.j b3 = eVar.b(i2);
        path.moveTo(b3.d(), a2);
        path.lineTo(b3.d(), b3.c() * b2);
        int i4 = i2 + 1;
        b.b.a.a.d.j jVar = null;
        while (true) {
            b.b.a.a.d.j jVar2 = jVar;
            if (i4 > i3) {
                break;
            }
            jVar = eVar.b(i4);
            if (z && jVar2 != null) {
                path.lineTo(jVar.d(), jVar2.c() * b2);
            }
            path.lineTo(jVar.d(), jVar.c() * b2);
            i4++;
        }
        if (jVar != null) {
            path.lineTo(jVar.d(), a2);
        }
        path.close();
    }

    public void b(Canvas canvas) {
        d(canvas);
    }

    public void b() {
        Canvas canvas = this.l;
        if (canvas != null) {
            canvas.setBitmap((Bitmap) null);
            this.l = null;
        }
        WeakReference<Bitmap> weakReference = this.k;
        if (weakReference != null) {
            ((Bitmap) weakReference.get()).recycle();
            this.k.clear();
            this.k = null;
        }
    }

    public void a(Canvas canvas, b.b.a.a.f.c[] cVarArr) {
        k lineData = this.i.getLineData();
        for (b.b.a.a.f.c cVar : cVarArr) {
            e eVar = (e) lineData.a(cVar.b());
            if (eVar != null && eVar.u()) {
                b.b.a.a.d.j a2 = eVar.a(cVar.f(), cVar.h());
                if (a(a2, eVar)) {
                    b.b.a.a.j.c a3 = this.i.a(eVar.q()).a(a2.d(), a2.c() * this.f1261b.b());
                    cVar.a((float) a3.d, (float) a3.e);
                    a(canvas, (float) a3.d, (float) a3.e, eVar);
                }
            }
        }
    }
}
