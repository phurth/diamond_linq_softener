package b.c.a.a.p;

import a.g.h.c;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.b;
import b.c.a.a.p.h;
import b.c.a.a.p.i;
import b.c.a.a.p.k;

public class e extends Drawable implements b, h.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Paint f1322a = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    private a f1323b;
    /* access modifiers changed from: private */
    public final k.f[] c;
    /* access modifiers changed from: private */
    public final k.f[] d;
    private boolean e;
    private final Matrix f;
    private final Path g;
    private final Path h;
    private final RectF i;
    private final RectF j;
    private final Region k;
    private final Region l;
    private h m;
    private final Paint n;
    private final Paint o;
    private final b.c.a.a.o.a p;
    private final i.a q;
    private final i r;
    private PorterDuffColorFilter s;
    private PorterDuffColorFilter t;

    /* synthetic */ e(a aVar, d dVar) {
        this(aVar);
    }

    private static int a(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    private void g() {
        this.m = new h(e());
        this.m.a(d(this.m.g().f1320a), d(this.m.h().f1320a), d(this.m.c().f1320a), d(this.m.b().f1320a));
        this.r.a(this.m, this.f1323b.j, h(), this.h);
    }

    private RectF h() {
        RectF c2 = c();
        float i2 = i();
        this.j.set(c2.left + i2, c2.top + i2, c2.right - i2, c2.bottom - i2);
        return this.j;
    }

    private float i() {
        if (l()) {
            return this.o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean j() {
        a aVar = this.f1323b;
        int i2 = aVar.n;
        if (i2 == 1 || aVar.o <= 0 || (i2 != 2 && !n())) {
            return false;
        }
        return true;
    }

    private boolean k() {
        Paint.Style style = this.f1323b.s;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean l() {
        Paint.Style style = this.f1323b.s;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > 0.0f;
    }

    private void m() {
        super.invalidateSelf();
    }

    private boolean n() {
        return Build.VERSION.SDK_INT < 21 || (!this.f1323b.f1324a.i() && !this.g.isConvex());
    }

    private void o() {
        p();
    }

    private boolean p() {
        PorterDuffColorFilter porterDuffColorFilter = this.s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.t;
        a aVar = this.f1323b;
        this.s = a(aVar.g, aVar.h, this.n, true);
        a aVar2 = this.f1323b;
        this.t = a(aVar2.f, aVar2.h, this.o, false);
        a aVar3 = this.f1323b;
        if (aVar3.r) {
            this.p.a(aVar3.g.getColorForState(getState(), 0));
        }
        if (!c.a(porterDuffColorFilter, this.s) || !c.a(porterDuffColorFilter2, this.t)) {
            return true;
        }
        return false;
    }

    public void c(float f2) {
        this.f1323b.k = f2;
        invalidateSelf();
    }

    public float d() {
        return this.f1323b.m;
    }

    public void draw(Canvas canvas) {
        this.n.setColorFilter(this.s);
        int alpha = this.n.getAlpha();
        this.n.setAlpha(a(alpha, this.f1323b.l));
        this.o.setColorFilter(this.t);
        this.o.setStrokeWidth(this.f1323b.k);
        int alpha2 = this.o.getAlpha();
        this.o.setAlpha(a(alpha2, this.f1323b.l));
        if (this.e) {
            g();
            a(c(), this.g);
            this.e = false;
        }
        if (j()) {
            canvas.save();
            d(canvas);
            Bitmap createBitmap = Bitmap.createBitmap(getBounds().width() + (this.f1323b.o * 2), getBounds().height() + (this.f1323b.o * 2), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f2 = (float) (getBounds().left - this.f1323b.o);
            float f3 = (float) (getBounds().top - this.f1323b.o);
            canvas2.translate(-f2, -f3);
            a(canvas2);
            canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
        if (k()) {
            b(canvas);
        }
        if (l()) {
            c(canvas);
        }
        this.n.setAlpha(alpha);
        this.o.setAlpha(alpha2);
    }

    public h e() {
        return this.f1323b.f1324a;
    }

    public ColorStateList f() {
        return this.f1323b.g;
    }

    public Drawable.ConstantState getConstantState() {
        return this.f1323b;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        a aVar = this.f1323b;
        if (aVar.n != 2) {
            if (aVar.f1324a.i()) {
                outline.setRoundRect(getBounds(), this.f1323b.f1324a.g().a());
                return;
            }
            a(c(), this.g);
            if (this.g.isConvex()) {
                outline.setConvexPath(this.g);
            }
        }
    }

    public Region getTransparentRegion() {
        this.k.set(getBounds());
        a(c(), this.g);
        this.l.setPath(this.g, this.k);
        this.k.op(this.l, Region.Op.DIFFERENCE);
        return this.k;
    }

    public void invalidateSelf() {
        this.e = true;
        super.invalidateSelf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = r1.f1323b.e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = r1.f1323b.d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f1323b.g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r1.f1323b.f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0039
            b.c.a.a.p.e$a r0 = r1.f1323b
            android.content.res.ColorStateList r0 = r0.g
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x0012:
            b.c.a.a.p.e$a r0 = r1.f1323b
            android.content.res.ColorStateList r0 = r0.f
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x001e:
            b.c.a.a.p.e$a r0 = r1.f1323b
            android.content.res.ColorStateList r0 = r0.e
            if (r0 == 0) goto L_0x002a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x002a:
            b.c.a.a.p.e$a r0 = r1.f1323b
            android.content.res.ColorStateList r0 = r0.d
            if (r0 == 0) goto L_0x0037
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = 1
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.a.a.p.e.isStateful():boolean");
    }

    public Drawable mutate() {
        this.f1323b = new a(this.f1323b);
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.e = true;
        super.onBoundsChange(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z = a(iArr) || p();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void setAlpha(int i2) {
        a aVar = this.f1323b;
        if (aVar.l != i2) {
            aVar.l = i2;
            m();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1323b.c = colorFilter;
        m();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1323b.g = colorStateList;
        p();
        m();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a aVar = this.f1323b;
        if (aVar.h != mode) {
            aVar.h = mode;
            p();
            m();
        }
    }

    public e() {
        this(new h());
    }

    private void d(Canvas canvas) {
        a aVar = this.f1323b;
        double d2 = (double) aVar.p;
        double sin = Math.sin(Math.toRadians((double) aVar.q));
        Double.isNaN(d2);
        int i2 = (int) (d2 * sin);
        a aVar2 = this.f1323b;
        double d3 = (double) aVar2.p;
        double cos = Math.cos(Math.toRadians((double) aVar2.q));
        Double.isNaN(d3);
        int i3 = (int) (d3 * cos);
        if (Build.VERSION.SDK_INT < 21) {
            Rect clipBounds = canvas.getClipBounds();
            int i4 = this.f1323b.o;
            clipBounds.inset(-i4, -i4);
            clipBounds.offset(i2, i3);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate((float) i2, (float) i3);
    }

    public void a(h hVar) {
        this.f1323b.f1324a.b((h.a) this);
        this.f1323b.f1324a = hVar;
        hVar.a((h.a) this);
        invalidateSelf();
    }

    public void b(ColorStateList colorStateList) {
        a aVar = this.f1323b;
        if (aVar.e != colorStateList) {
            aVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public e(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(new h(context, attributeSet, i2, i3));
    }

    /* access modifiers changed from: protected */
    public RectF c() {
        Rect bounds = getBounds();
        this.i.set((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom);
        return this.i;
    }

    public e(h hVar) {
        this(new a(hVar, (b.c.a.a.i.a) null));
    }

    private e(a aVar) {
        this.c = new k.f[4];
        this.d = new k.f[4];
        this.f = new Matrix();
        this.g = new Path();
        this.h = new Path();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new Region();
        this.l = new Region();
        this.n = new Paint(1);
        this.o = new Paint(1);
        this.p = new b.c.a.a.o.a();
        this.r = new i();
        this.f1323b = aVar;
        this.o.setStyle(Paint.Style.STROKE);
        this.n.setStyle(Paint.Style.FILL);
        f1322a.setColor(-1);
        f1322a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        p();
        a(getState());
        this.q = new d(this);
        aVar.f1324a.a((h.a) this);
    }

    private int b(int i2) {
        a aVar = this.f1323b;
        b.c.a.a.i.a aVar2 = aVar.f1325b;
        return aVar2 != null ? aVar2.b(i2, aVar.m) : i2;
    }

    private void c(Canvas canvas) {
        a(canvas, this.o, this.h, this.m, h());
    }

    public void a(ColorStateList colorStateList) {
        a aVar = this.f1323b;
        if (aVar.d != colorStateList) {
            aVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    public void b(float f2) {
        a aVar = this.f1323b;
        if (aVar.j != f2) {
            aVar.j = f2;
            this.e = true;
            invalidateSelf();
        }
    }

    public void a(float f2, int i2) {
        c(f2);
        b(ColorStateList.valueOf(i2));
    }

    public void a(float f2, ColorStateList colorStateList) {
        c(f2);
        b(colorStateList);
    }

    public void b() {
        invalidateSelf();
    }

    private void b(Canvas canvas) {
        a(canvas, this.n, this.g, this.f1323b.f1324a, c());
    }

    private float d(float f2) {
        return Math.max(f2 - i(), 0.0f);
    }

    private void b(RectF rectF, Path path) {
        i iVar = this.r;
        a aVar = this.f1323b;
        h hVar = aVar.f1324a;
        float f2 = aVar.j;
        iVar.a(hVar, f2, rectF, this.q, path);
    }

    public void a(Context context) {
        this.f1323b.f1325b = new b.c.a.a.i.a(context);
        o();
        m();
    }

    public void a(float f2) {
        a aVar = this.f1323b;
        if (aVar.m != f2) {
            aVar.o = (int) Math.ceil((double) (0.75f * f2));
            this.f1323b.p = (int) Math.ceil((double) (0.25f * f2));
            this.f1323b.m = f2;
            o();
            m();
        }
    }

    static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public h f1324a;

        /* renamed from: b  reason: collision with root package name */
        public b.c.a.a.i.a f1325b;
        public ColorFilter c;
        public ColorStateList d = null;
        public ColorStateList e = null;
        public ColorStateList f = null;
        public ColorStateList g = null;
        public PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
        public float i = 1.0f;
        public float j = 1.0f;
        public float k;
        public int l = 255;
        public float m = 0.0f;
        public int n = 0;
        public int o = 0;
        public int p = 0;
        public int q = 0;
        public boolean r = false;
        public Paint.Style s = Paint.Style.FILL_AND_STROKE;

        public a(h hVar, b.c.a.a.i.a aVar) {
            this.f1324a = hVar;
            this.f1325b = aVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new e(this, (d) null);
        }

        public a(a aVar) {
            this.f1324a = aVar.f1324a;
            this.f1325b = aVar.f1325b;
            this.k = aVar.k;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.h = aVar.h;
            this.g = aVar.g;
            this.l = aVar.l;
            this.i = aVar.i;
            this.p = aVar.p;
            this.n = aVar.n;
            this.r = aVar.r;
            this.j = aVar.j;
            this.m = aVar.m;
            this.o = aVar.o;
            this.q = aVar.q;
            this.f = aVar.f;
            this.s = aVar.s;
        }
    }

    public void a(int i2) {
        a aVar = this.f1323b;
        if (aVar.q != i2) {
            aVar.q = i2;
            m();
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, Paint paint, Path path, RectF rectF) {
        a(canvas, paint, path, this.f1323b.f1324a, rectF);
    }

    private void a(Canvas canvas, Paint paint, Path path, h hVar, RectF rectF) {
        if (hVar.i()) {
            float a2 = hVar.h().a();
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void a(Canvas canvas) {
        if (this.f1323b.p != 0) {
            canvas.drawPath(this.g, this.p.a());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.c[i2].a(this.p, this.f1323b.o, canvas);
            this.d[i2].a(this.p, this.f1323b.o, canvas);
        }
        a aVar = this.f1323b;
        double d2 = (double) aVar.p;
        double sin = Math.sin(Math.toRadians((double) aVar.q));
        Double.isNaN(d2);
        int i3 = (int) (d2 * sin);
        a aVar2 = this.f1323b;
        double d3 = (double) aVar2.p;
        double cos = Math.cos(Math.toRadians((double) aVar2.q));
        Double.isNaN(d3);
        int i4 = (int) (d3 * cos);
        canvas.translate((float) (-i3), (float) (-i4));
        canvas.drawPath(this.g, f1322a);
        canvas.translate((float) i3, (float) i4);
    }

    @Deprecated
    public void a(Rect rect, Path path) {
        b(new RectF(rect), path);
    }

    private void a(RectF rectF, Path path) {
        b(rectF, path);
        if (this.f1323b.i != 1.0f) {
            this.f.reset();
            Matrix matrix = this.f;
            float f2 = this.f1323b.i;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f);
        }
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        if (colorStateList == null || mode == null) {
            return a(paint, z);
        }
        return a(colorStateList, mode, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.getColor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.PorterDuffColorFilter a(android.graphics.Paint r2, boolean r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0014
            int r2 = r2.getColor()
            int r3 = r1.b((int) r2)
            if (r3 == r2) goto L_0x0014
            android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.<init>(r3, r0)
            return r2
        L_0x0014:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.a.a.p.e.a(android.graphics.Paint, boolean):android.graphics.PorterDuffColorFilter");
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = b(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private boolean a(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f1323b.d == null || (color2 = this.n.getColor()) == (colorForState2 = this.f1323b.d.getColorForState(iArr, color2))) {
            z = false;
        } else {
            this.n.setColor(colorForState2);
            z = true;
        }
        if (this.f1323b.e == null || (color = this.o.getColor()) == (colorForState = this.f1323b.e.getColorForState(iArr, color))) {
            return z;
        }
        this.o.setColor(colorForState);
        return true;
    }
}
