package androidx.constraintlayout.widget;

import a.e.b.a.f;
import a.e.b.a.h;
import a.e.b.a.i;
import a.e.b.a.l;
import a.e.b.f;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    SparseArray<View> f673a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<d> f674b = new ArrayList<>(4);
    private final ArrayList<h> c = new ArrayList<>(100);
    i d = new i();
    private int e = 0;
    private int f = 0;
    private int g = Integer.MAX_VALUE;
    private int h = Integer.MAX_VALUE;
    private boolean i = true;
    private int j = 7;
    private g k = null;
    protected f l = null;
    /* access modifiers changed from: private */
    public int m = -1;
    private HashMap<String, Integer> n = new HashMap<>();
    private int o = -1;
    private int p = -1;
    int q = -1;
    int r = -1;
    int s = 0;
    int t = 0;
    private i u;
    private f v;
    Handler w = new e(this, Looper.getMainLooper());

    public ConstraintLayout(Context context) {
        super(context);
        a((AttributeSet) null, 0, 0);
    }

    private final h c(int i2) {
        if (i2 == 0) {
            return this.d;
        }
        View view = this.f673a.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).ma;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        this.l = new f(getContext(), this, i2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = (float) i3;
                        float f3 = (float) (i3 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f4 = (float) i4;
                        float f5 = f2;
                        float f6 = f2;
                        float f7 = f4;
                        Paint paint2 = paint;
                        float f8 = f3;
                        Paint paint3 = paint2;
                        canvas2.drawLine(f5, f7, f8, f4, paint3);
                        float parseInt4 = (float) (i4 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f9 = f3;
                        float f10 = parseInt4;
                        canvas2.drawLine(f9, f7, f8, f10, paint3);
                        float f11 = parseInt4;
                        float f12 = f6;
                        canvas2.drawLine(f9, f11, f12, f10, paint3);
                        float f13 = f6;
                        canvas2.drawLine(f13, f11, f12, f4, paint3);
                        Paint paint4 = paint2;
                        paint4.setColor(-16711936);
                        Paint paint5 = paint4;
                        float f14 = f3;
                        Paint paint6 = paint5;
                        canvas2.drawLine(f13, f4, f14, parseInt4, paint6);
                        canvas2.drawLine(f13, parseInt4, f14, f4, paint6);
                    }
                }
            }
        }
    }

    public int getMaxHeight() {
        return this.h;
    }

    public int getMaxWidth() {
        return this.g;
    }

    public int getMinHeight() {
        return this.f;
    }

    public int getMinWidth() {
        return this.e;
    }

    public int getOptimizationLevel() {
        return this.d.P();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            h hVar = aVar.ma;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || aVar.ba || isInEditMode) && !aVar.aa) {
                int h2 = hVar.h();
                int i7 = hVar.i();
                int t2 = hVar.t() + h2;
                int j2 = hVar.j() + i7;
                childAt.layout(h2, i7, t2, j2);
                if ((childAt instanceof k) && (content = ((k) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(h2, i7, t2, j2);
                }
            }
        }
        int size = this.f674b.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.f674b.get(i8).a(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        int i5;
        int i6;
        int i7;
        int i8;
        int baseline;
        int i9 = i2;
        int i10 = i3;
        System.currentTimeMillis();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.d.t(paddingLeft);
        this.d.u(paddingTop);
        this.d.l(this.g);
        this.d.k(this.h);
        if (Build.VERSION.SDK_INT >= 17) {
            this.d.c(getLayoutDirection() == 1);
        }
        c(i2, i3);
        int t2 = this.d.t();
        int j2 = this.d.j();
        if (this.i) {
            this.i = false;
            b();
            z = true;
        } else {
            z = false;
        }
        boolean z5 = (this.j & 8) == 8;
        if (z5) {
            this.d.W();
            this.d.f(t2, j2);
            b(i2, i3);
        } else {
            a(i2, i3);
        }
        c();
        if (getChildCount() > 0 && z) {
            a.e.b.a.a.a(this.d);
        }
        i iVar = this.d;
        if (iVar.Ha) {
            if (iVar.Ia && mode == Integer.MIN_VALUE) {
                int i11 = iVar.Ka;
                if (i11 < size) {
                    iVar.q(i11);
                }
                this.d.a(h.a.FIXED);
            }
            i iVar2 = this.d;
            if (iVar2.Ja && mode2 == Integer.MIN_VALUE) {
                int i12 = iVar2.La;
                if (i12 < size2) {
                    iVar2.i(i12);
                }
                this.d.b(h.a.FIXED);
            }
        }
        if ((this.j & 32) == 32) {
            int t3 = this.d.t();
            int j3 = this.d.j();
            if (this.o != t3 && mode == 1073741824) {
                a.e.b.a.a.a(this.d.Ga, 0, t3);
            }
            if (this.p != j3 && mode2 == 1073741824) {
                a.e.b.a.a.a(this.d.Ga, 1, j3);
            }
            i iVar3 = this.d;
            if (iVar3.Ia && iVar3.Ka > size) {
                a.e.b.a.a.a(iVar3.Ga, 0, size);
            }
            i iVar4 = this.d;
            if (iVar4.Ja && iVar4.La > size2) {
                a.e.b.a.a.a(iVar4.Ga, 1, size2);
            }
            if ((this.j & 4) == 4) {
                a.e.b.a.a.b(this.d);
            }
        }
        if (getChildCount() > 0) {
            a("First pass");
        }
        int size3 = this.c.size();
        int paddingBottom = paddingTop + getPaddingBottom();
        int paddingRight = paddingLeft + getPaddingRight();
        if (size3 > 0) {
            boolean z6 = this.d.k() == h.a.WRAP_CONTENT;
            boolean z7 = this.d.r() == h.a.WRAP_CONTENT;
            int max = Math.max(this.d.t(), this.e);
            int max2 = Math.max(this.d.j(), this.f);
            int i13 = 0;
            boolean z8 = false;
            int i14 = 0;
            while (i13 < size3) {
                h hVar = this.c.get(i13);
                int i15 = size3;
                View view = (View) hVar.f();
                if (view == null) {
                    i6 = t2;
                    z4 = z8;
                    i5 = j2;
                } else {
                    i5 = j2;
                    a aVar = (a) view.getLayoutParams();
                    i6 = t2;
                    if ((!aVar.Z || aVar.ba) && !aVar.Y) {
                        z4 = z8;
                        if (view.getVisibility() != 8 && (!z5 || !hVar.n().c() || !hVar.m().c())) {
                            if (aVar.width != -2 || !aVar.V) {
                                i7 = View.MeasureSpec.makeMeasureSpec(hVar.t(), 1073741824);
                            } else {
                                i7 = ViewGroup.getChildMeasureSpec(i9, paddingRight, aVar.width);
                            }
                            if (aVar.height != -2 || !aVar.W) {
                                i8 = View.MeasureSpec.makeMeasureSpec(hVar.j(), 1073741824);
                            } else {
                                i8 = ViewGroup.getChildMeasureSpec(i10, paddingBottom, aVar.height);
                            }
                            view.measure(i7, i8);
                            f fVar = this.v;
                            if (fVar != null) {
                                fVar.f111b++;
                            }
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            if (measuredWidth != hVar.t()) {
                                hVar.q(measuredWidth);
                                if (z5) {
                                    hVar.n().a(measuredWidth);
                                }
                                if (z6 && hVar.o() > max) {
                                    max = Math.max(max, hVar.o() + hVar.a(f.c.RIGHT).b());
                                }
                                z4 = true;
                            }
                            if (measuredHeight != hVar.j()) {
                                hVar.i(measuredHeight);
                                if (z5) {
                                    hVar.m().a(measuredHeight);
                                }
                                if (z7 && hVar.e() > max2) {
                                    max2 = Math.max(max2, hVar.e() + hVar.a(f.c.BOTTOM).b());
                                }
                                z4 = true;
                            }
                            if (!(!aVar.X || (baseline = view.getBaseline()) == -1 || baseline == hVar.d())) {
                                hVar.h(baseline);
                                z4 = true;
                            }
                            if (Build.VERSION.SDK_INT >= 11) {
                                i14 = ViewGroup.combineMeasuredStates(i14, view.getMeasuredState());
                            } else {
                                int i16 = i14;
                            }
                        }
                    } else {
                        z4 = z8;
                    }
                }
                z8 = z4;
                i13++;
                i9 = i2;
                t2 = i6;
                size3 = i15;
                j2 = i5;
            }
            int i17 = size3;
            int i18 = t2;
            int i19 = j2;
            i4 = i14;
            if (z8) {
                this.d.q(i18);
                this.d.i(i19);
                if (z5) {
                    this.d.X();
                }
                a("2nd pass");
                if (this.d.t() < max) {
                    this.d.q(max);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.d.j() < max2) {
                    this.d.i(max2);
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (z3) {
                    a("3rd pass");
                }
            }
            int i20 = i17;
            for (int i21 = 0; i21 < i20; i21++) {
                h hVar2 = this.c.get(i21);
                View view2 = (View) hVar2.f();
                if (view2 != null && (view2.getMeasuredWidth() != hVar2.t() || view2.getMeasuredHeight() != hVar2.j())) {
                    if (hVar2.s() != 8) {
                        view2.measure(View.MeasureSpec.makeMeasureSpec(hVar2.t(), 1073741824), View.MeasureSpec.makeMeasureSpec(hVar2.j(), 1073741824));
                        a.e.b.f fVar2 = this.v;
                        if (fVar2 != null) {
                            fVar2.f111b++;
                        }
                    }
                }
            }
        } else {
            i4 = 0;
        }
        int t4 = this.d.t() + paddingRight;
        int j4 = this.d.j() + paddingBottom;
        if (Build.VERSION.SDK_INT >= 11) {
            int min = Math.min(this.g, ViewGroup.resolveSizeAndState(t4, i2, i4) & 16777215);
            int min2 = Math.min(this.h, ViewGroup.resolveSizeAndState(j4, i10, i4 << 16) & 16777215);
            if (this.d.T()) {
                min |= 16777216;
            }
            if (this.d.R()) {
                min2 |= 16777216;
            }
            setMeasuredDimension(min, min2);
            this.o = min;
            this.p = min2;
            return;
        }
        setMeasuredDimension(t4, j4);
        this.o = t4;
        this.p = j4;
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        h a2 = a(view);
        if ((view instanceof j) && !(a2 instanceof l)) {
            a aVar = (a) view.getLayoutParams();
            aVar.ma = new l();
            aVar.Y = true;
            ((l) aVar.ma).x(aVar.S);
        }
        if (view instanceof d) {
            d dVar = (d) view;
            dVar.a();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.f674b.contains(dVar)) {
                this.f674b.add(dVar);
            }
        }
        this.f673a.put(view.getId(), view);
        this.i = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f673a.remove(view.getId());
        h a2 = a(view);
        this.d.c(a2);
        this.f674b.remove(view);
        this.c.remove(a2);
        this.i = true;
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void requestLayout() {
        super.requestLayout();
        this.i = true;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.s = 0;
        this.t = 0;
    }

    public void setConstraintSet(g gVar) {
        this.k = gVar;
    }

    public void setId(int i2) {
        this.f673a.remove(getId());
        super.setId(i2);
        this.f673a.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.h) {
            this.h = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.g) {
            this.g = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.f) {
            this.f = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.e) {
            this.e = i2;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(i iVar) {
        this.u = iVar;
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(iVar);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.j = i2;
        this.d.w(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    private void b() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            this.c.clear();
            a();
        }
    }

    public void a(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.n == null) {
                this.n = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.n.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* access modifiers changed from: protected */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r24, int r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            int r3 = r23.getPaddingTop()
            int r4 = r23.getPaddingBottom()
            int r3 = r3 + r4
            int r4 = r23.getPaddingLeft()
            int r5 = r23.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r23.getChildCount()
            r7 = 0
        L_0x001d:
            r8 = 1
            r10 = 8
            r12 = -2
            if (r7 >= r5) goto L_0x00de
            android.view.View r14 = r0.getChildAt(r7)
            int r15 = r14.getVisibility()
            if (r15 != r10) goto L_0x0030
            goto L_0x00d6
        L_0x0030:
            android.view.ViewGroup$LayoutParams r10 = r14.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r10 = (androidx.constraintlayout.widget.ConstraintLayout.a) r10
            a.e.b.a.h r15 = r10.ma
            boolean r6 = r10.Y
            if (r6 != 0) goto L_0x00d6
            boolean r6 = r10.Z
            if (r6 == 0) goto L_0x0042
            goto L_0x00d6
        L_0x0042:
            int r6 = r14.getVisibility()
            r15.p(r6)
            int r6 = r10.width
            int r13 = r10.height
            if (r6 == 0) goto L_0x00c6
            if (r13 != 0) goto L_0x0053
            goto L_0x00c6
        L_0x0053:
            if (r6 != r12) goto L_0x0058
            r16 = 1
            goto L_0x005a
        L_0x0058:
            r16 = 0
        L_0x005a:
            int r11 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r6)
            if (r13 != r12) goto L_0x0063
            r17 = 1
            goto L_0x0065
        L_0x0063:
            r17 = 0
        L_0x0065:
            int r12 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r13)
            r14.measure(r11, r12)
            a.e.b.f r11 = r0.v
            if (r11 == 0) goto L_0x0077
            r12 = r3
            long r2 = r11.f110a
            long r2 = r2 + r8
            r11.f110a = r2
            goto L_0x0078
        L_0x0077:
            r12 = r3
        L_0x0078:
            r2 = -2
            if (r6 != r2) goto L_0x007d
            r3 = 1
            goto L_0x007e
        L_0x007d:
            r3 = 0
        L_0x007e:
            r15.b((boolean) r3)
            if (r13 != r2) goto L_0x0085
            r2 = 1
            goto L_0x0086
        L_0x0085:
            r2 = 0
        L_0x0086:
            r15.a((boolean) r2)
            int r2 = r14.getMeasuredWidth()
            int r3 = r14.getMeasuredHeight()
            r15.q(r2)
            r15.i(r3)
            if (r16 == 0) goto L_0x009c
            r15.s(r2)
        L_0x009c:
            if (r17 == 0) goto L_0x00a1
            r15.r(r3)
        L_0x00a1:
            boolean r6 = r10.X
            if (r6 == 0) goto L_0x00af
            int r6 = r14.getBaseline()
            r8 = -1
            if (r6 == r8) goto L_0x00af
            r15.h(r6)
        L_0x00af:
            boolean r6 = r10.V
            if (r6 == 0) goto L_0x00d7
            boolean r6 = r10.W
            if (r6 == 0) goto L_0x00d7
            a.e.b.a.r r6 = r15.n()
            r6.a(r2)
            a.e.b.a.r r2 = r15.m()
            r2.a(r3)
            goto L_0x00d7
        L_0x00c6:
            r12 = r3
            a.e.b.a.r r2 = r15.n()
            r2.b()
            a.e.b.a.r r2 = r15.m()
            r2.b()
            goto L_0x00d7
        L_0x00d6:
            r12 = r3
        L_0x00d7:
            int r7 = r7 + 1
            r2 = r25
            r3 = r12
            goto L_0x001d
        L_0x00de:
            r12 = r3
            a.e.b.a.i r2 = r0.d
            r2.X()
            r2 = 0
        L_0x00e5:
            if (r2 >= r5) goto L_0x02e2
            android.view.View r3 = r0.getChildAt(r2)
            int r6 = r3.getVisibility()
            if (r6 != r10) goto L_0x00f3
            goto L_0x02ce
        L_0x00f3:
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r6 = (androidx.constraintlayout.widget.ConstraintLayout.a) r6
            a.e.b.a.h r7 = r6.ma
            boolean r11 = r6.Y
            if (r11 != 0) goto L_0x02ce
            boolean r11 = r6.Z
            if (r11 == 0) goto L_0x0105
            goto L_0x02ce
        L_0x0105:
            int r11 = r3.getVisibility()
            r7.p(r11)
            int r11 = r6.width
            int r13 = r6.height
            if (r11 == 0) goto L_0x0116
            if (r13 == 0) goto L_0x0116
            goto L_0x02ce
        L_0x0116:
            a.e.b.a.f$c r14 = a.e.b.a.f.c.LEFT
            a.e.b.a.f r14 = r7.a((a.e.b.a.f.c) r14)
            a.e.b.a.q r14 = r14.d()
            a.e.b.a.f$c r15 = a.e.b.a.f.c.RIGHT
            a.e.b.a.f r15 = r7.a((a.e.b.a.f.c) r15)
            a.e.b.a.q r15 = r15.d()
            a.e.b.a.f$c r10 = a.e.b.a.f.c.LEFT
            a.e.b.a.f r10 = r7.a((a.e.b.a.f.c) r10)
            a.e.b.a.f r10 = r10.g()
            if (r10 == 0) goto L_0x0144
            a.e.b.a.f$c r10 = a.e.b.a.f.c.RIGHT
            a.e.b.a.f r10 = r7.a((a.e.b.a.f.c) r10)
            a.e.b.a.f r10 = r10.g()
            if (r10 == 0) goto L_0x0144
            r10 = 1
            goto L_0x0145
        L_0x0144:
            r10 = 0
        L_0x0145:
            a.e.b.a.f$c r8 = a.e.b.a.f.c.TOP
            a.e.b.a.f r8 = r7.a((a.e.b.a.f.c) r8)
            a.e.b.a.q r8 = r8.d()
            a.e.b.a.f$c r9 = a.e.b.a.f.c.BOTTOM
            a.e.b.a.f r9 = r7.a((a.e.b.a.f.c) r9)
            a.e.b.a.q r9 = r9.d()
            r17 = r5
            a.e.b.a.f$c r5 = a.e.b.a.f.c.TOP
            a.e.b.a.f r5 = r7.a((a.e.b.a.f.c) r5)
            a.e.b.a.f r5 = r5.g()
            if (r5 == 0) goto L_0x0175
            a.e.b.a.f$c r5 = a.e.b.a.f.c.BOTTOM
            a.e.b.a.f r5 = r7.a((a.e.b.a.f.c) r5)
            a.e.b.a.f r5 = r5.g()
            if (r5 == 0) goto L_0x0175
            r5 = 1
            goto L_0x0176
        L_0x0175:
            r5 = 0
        L_0x0176:
            if (r11 != 0) goto L_0x0188
            if (r13 != 0) goto L_0x0188
            if (r10 == 0) goto L_0x0188
            if (r5 == 0) goto L_0x0188
            r5 = r25
            r20 = r2
            r3 = -1
            r10 = -2
            r18 = 1
            goto L_0x02d8
        L_0x0188:
            r20 = r2
            a.e.b.a.i r2 = r0.d
            a.e.b.a.h$a r2 = r2.k()
            r21 = r6
            a.e.b.a.h$a r6 = a.e.b.a.h.a.WRAP_CONTENT
            if (r2 == r6) goto L_0x0198
            r6 = 1
            goto L_0x0199
        L_0x0198:
            r6 = 0
        L_0x0199:
            a.e.b.a.i r2 = r0.d
            a.e.b.a.h$a r2 = r2.r()
            a.e.b.a.h$a r0 = a.e.b.a.h.a.WRAP_CONTENT
            if (r2 == r0) goto L_0x01a5
            r0 = 1
            goto L_0x01a6
        L_0x01a5:
            r0 = 0
        L_0x01a6:
            if (r6 != 0) goto L_0x01af
            a.e.b.a.r r2 = r7.n()
            r2.b()
        L_0x01af:
            if (r0 != 0) goto L_0x01b8
            a.e.b.a.r r2 = r7.m()
            r2.b()
        L_0x01b8:
            if (r11 != 0) goto L_0x01f0
            if (r6 == 0) goto L_0x01e7
            boolean r2 = r7.D()
            if (r2 == 0) goto L_0x01e7
            if (r10 == 0) goto L_0x01e7
            boolean r2 = r14.c()
            if (r2 == 0) goto L_0x01e7
            boolean r2 = r15.c()
            if (r2 == 0) goto L_0x01e7
            float r2 = r15.f()
            float r10 = r14.f()
            float r2 = r2 - r10
            int r11 = (int) r2
            a.e.b.a.r r2 = r7.n()
            r2.a(r11)
            int r2 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r11)
            r14 = r2
            goto L_0x01f8
        L_0x01e7:
            r2 = -2
            int r6 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r2)
            r14 = r6
            r2 = 1
            r6 = 0
            goto L_0x0204
        L_0x01f0:
            r2 = -2
            r10 = -1
            if (r11 != r10) goto L_0x01fa
            int r14 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r10)
        L_0x01f8:
            r2 = 0
            goto L_0x0204
        L_0x01fa:
            if (r11 != r2) goto L_0x01fe
            r2 = 1
            goto L_0x01ff
        L_0x01fe:
            r2 = 0
        L_0x01ff:
            int r10 = android.view.ViewGroup.getChildMeasureSpec(r1, r4, r11)
            r14 = r10
        L_0x0204:
            if (r13 != 0) goto L_0x0240
            if (r0 == 0) goto L_0x0236
            boolean r10 = r7.C()
            if (r10 == 0) goto L_0x0236
            if (r5 == 0) goto L_0x0236
            boolean r5 = r8.c()
            if (r5 == 0) goto L_0x0236
            boolean r5 = r9.c()
            if (r5 == 0) goto L_0x0236
            float r5 = r9.f()
            float r8 = r8.f()
            float r5 = r5 - r8
            int r13 = (int) r5
            a.e.b.a.r r5 = r7.m()
            r5.a(r13)
            r5 = r25
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r5, r12, r13)
            r9 = r0
            r0 = r8
            goto L_0x024c
        L_0x0236:
            r5 = r25
            r8 = -2
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r5, r12, r8)
            r8 = 1
            r9 = 0
            goto L_0x025c
        L_0x0240:
            r5 = r25
            r8 = -2
            r9 = -1
            if (r13 != r9) goto L_0x024e
            int r10 = android.view.ViewGroup.getChildMeasureSpec(r5, r12, r9)
            r9 = r0
            r0 = r10
        L_0x024c:
            r8 = 0
            goto L_0x025c
        L_0x024e:
            if (r13 != r8) goto L_0x0252
            r8 = 1
            goto L_0x0253
        L_0x0252:
            r8 = 0
        L_0x0253:
            int r9 = android.view.ViewGroup.getChildMeasureSpec(r5, r12, r13)
            r22 = r9
            r9 = r0
            r0 = r22
        L_0x025c:
            r3.measure(r14, r0)
            r0 = r23
            a.e.b.f r10 = r0.v
            if (r10 == 0) goto L_0x026e
            long r14 = r10.f110a
            r18 = 1
            long r14 = r14 + r18
            r10.f110a = r14
            goto L_0x0270
        L_0x026e:
            r18 = 1
        L_0x0270:
            r10 = -2
            if (r11 != r10) goto L_0x0275
            r11 = 1
            goto L_0x0276
        L_0x0275:
            r11 = 0
        L_0x0276:
            r7.b((boolean) r11)
            if (r13 != r10) goto L_0x027d
            r11 = 1
            goto L_0x027e
        L_0x027d:
            r11 = 0
        L_0x027e:
            r7.a((boolean) r11)
            int r11 = r3.getMeasuredWidth()
            int r13 = r3.getMeasuredHeight()
            r7.q(r11)
            r7.i(r13)
            if (r2 == 0) goto L_0x0294
            r7.s(r11)
        L_0x0294:
            if (r8 == 0) goto L_0x0299
            r7.r(r13)
        L_0x0299:
            if (r6 == 0) goto L_0x02a3
            a.e.b.a.r r2 = r7.n()
            r2.a(r11)
            goto L_0x02aa
        L_0x02a3:
            a.e.b.a.r r2 = r7.n()
            r2.f()
        L_0x02aa:
            if (r9 == 0) goto L_0x02b4
            a.e.b.a.r r2 = r7.m()
            r2.a(r13)
            goto L_0x02bb
        L_0x02b4:
            a.e.b.a.r r2 = r7.m()
            r2.f()
        L_0x02bb:
            r6 = r21
            boolean r2 = r6.X
            if (r2 == 0) goto L_0x02cc
            int r2 = r3.getBaseline()
            r3 = -1
            if (r2 == r3) goto L_0x02d8
            r7.h(r2)
            goto L_0x02d8
        L_0x02cc:
            r3 = -1
            goto L_0x02d8
        L_0x02ce:
            r20 = r2
            r17 = r5
            r18 = r8
            r3 = -1
            r10 = -2
            r5 = r25
        L_0x02d8:
            int r2 = r20 + 1
            r5 = r17
            r8 = r18
            r10 = 8
            goto L_0x00e5
        L_0x02e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b(int, int):void");
    }

    private void c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof k) {
                ((k) childAt).a(this);
            }
        }
        int size = this.f674b.size();
        if (size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.f674b.get(i3).b(this);
            }
        }
    }

    public Object a(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.n;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.n.get(str);
    }

    private void a(AttributeSet attributeSet, int i2, int i3) {
        this.d.a((Object) this);
        this.f673a.put(getId(), this);
        this.k = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.ConstraintLayout_Layout, i2, i3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == m.ConstraintLayout_Layout_android_minWidth) {
                    this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == m.ConstraintLayout_Layout_android_minHeight) {
                    this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == m.ConstraintLayout_Layout_android_maxWidth) {
                    this.g = obtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == m.ConstraintLayout_Layout_android_maxHeight) {
                    this.h = obtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == m.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.j = obtainStyledAttributes.getInt(index, this.j);
                } else if (index == m.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            b(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.l = null;
                        }
                    }
                } else if (index == m.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.k = new g();
                        this.k.b(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.k = null;
                    }
                    this.m = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.d.w(this.j);
    }

    private void c(int i2, int i3) {
        h.a aVar;
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        h.a aVar2 = h.a.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                aVar = h.a.WRAP_CONTENT;
            } else if (mode != 1073741824) {
                aVar = aVar2;
            } else {
                i4 = Math.min(this.g, size) - paddingLeft;
                aVar = aVar2;
            }
            i4 = 0;
        } else {
            i4 = size;
            aVar = h.a.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                aVar2 = h.a.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.h, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            aVar2 = h.a.WRAP_CONTENT;
        }
        this.d.n(0);
        this.d.m(0);
        this.d.a(aVar);
        this.d.q(i4);
        this.d.b(aVar2);
        this.d.i(size2);
        this.d.n((this.e - getPaddingLeft()) - getPaddingRight());
        this.d.m((this.f - getPaddingTop()) - getPaddingBottom());
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0380  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r25 = this;
            r0 = r25
            boolean r1 = r25.isInEditMode()
            int r2 = r25.getChildCount()
            r3 = 0
            r4 = 0
        L_0x000c:
            if (r4 >= r2) goto L_0x001f
            android.view.View r5 = r0.getChildAt(r4)
            a.e.b.a.h r5 = r0.a((android.view.View) r5)
            if (r5 != 0) goto L_0x0019
            goto L_0x001c
        L_0x0019:
            r5.E()
        L_0x001c:
            int r4 = r4 + 1
            goto L_0x000c
        L_0x001f:
            r4 = -1
            if (r1 == 0) goto L_0x005c
            r5 = 0
        L_0x0023:
            if (r5 >= r2) goto L_0x005c
            android.view.View r6 = r0.getChildAt(r5)
            android.content.res.Resources r7 = r25.getResources()     // Catch:{ NotFoundException -> 0x0059 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0059 }
            java.lang.String r7 = r7.getResourceName(r8)     // Catch:{ NotFoundException -> 0x0059 }
            int r8 = r6.getId()     // Catch:{ NotFoundException -> 0x0059 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NotFoundException -> 0x0059 }
            r0.a((int) r3, (java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ NotFoundException -> 0x0059 }
            r8 = 47
            int r8 = r7.indexOf(r8)     // Catch:{ NotFoundException -> 0x0059 }
            if (r8 == r4) goto L_0x004e
            int r8 = r8 + 1
            java.lang.String r7 = r7.substring(r8)     // Catch:{ NotFoundException -> 0x0059 }
        L_0x004e:
            int r6 = r6.getId()     // Catch:{ NotFoundException -> 0x0059 }
            a.e.b.a.h r6 = r0.c(r6)     // Catch:{ NotFoundException -> 0x0059 }
            r6.a((java.lang.String) r7)     // Catch:{ NotFoundException -> 0x0059 }
        L_0x0059:
            int r5 = r5 + 1
            goto L_0x0023
        L_0x005c:
            int r5 = r0.m
            if (r5 == r4) goto L_0x007e
            r5 = 0
        L_0x0061:
            if (r5 >= r2) goto L_0x007e
            android.view.View r6 = r0.getChildAt(r5)
            int r7 = r6.getId()
            int r8 = r0.m
            if (r7 != r8) goto L_0x007b
            boolean r7 = r6 instanceof androidx.constraintlayout.widget.h
            if (r7 == 0) goto L_0x007b
            androidx.constraintlayout.widget.h r6 = (androidx.constraintlayout.widget.h) r6
            androidx.constraintlayout.widget.g r6 = r6.getConstraintSet()
            r0.k = r6
        L_0x007b:
            int r5 = r5 + 1
            goto L_0x0061
        L_0x007e:
            androidx.constraintlayout.widget.g r5 = r0.k
            r6 = 1
            if (r5 == 0) goto L_0x0086
            r5.a((androidx.constraintlayout.widget.ConstraintLayout) r0, (boolean) r6)
        L_0x0086:
            a.e.b.a.i r5 = r0.d
            r5.O()
            java.util.ArrayList<androidx.constraintlayout.widget.d> r5 = r0.f674b
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00a4
            r7 = 0
        L_0x0094:
            if (r7 >= r5) goto L_0x00a4
            java.util.ArrayList<androidx.constraintlayout.widget.d> r8 = r0.f674b
            java.lang.Object r8 = r8.get(r7)
            androidx.constraintlayout.widget.d r8 = (androidx.constraintlayout.widget.d) r8
            r8.c(r0)
            int r7 = r7 + 1
            goto L_0x0094
        L_0x00a4:
            r5 = 0
        L_0x00a5:
            if (r5 >= r2) goto L_0x00b7
            android.view.View r7 = r0.getChildAt(r5)
            boolean r8 = r7 instanceof androidx.constraintlayout.widget.k
            if (r8 == 0) goto L_0x00b4
            androidx.constraintlayout.widget.k r7 = (androidx.constraintlayout.widget.k) r7
            r7.b(r0)
        L_0x00b4:
            int r5 = r5 + 1
            goto L_0x00a5
        L_0x00b7:
            r5 = 0
        L_0x00b8:
            if (r5 >= r2) goto L_0x03b2
            android.view.View r7 = r0.getChildAt(r5)
            a.e.b.a.h r14 = r0.a((android.view.View) r7)
            if (r14 != 0) goto L_0x00c7
        L_0x00c4:
            r7 = 1
            goto L_0x03ad
        L_0x00c7:
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            r15 = r8
            androidx.constraintlayout.widget.ConstraintLayout$a r15 = (androidx.constraintlayout.widget.ConstraintLayout.a) r15
            r15.a()
            boolean r8 = r15.na
            if (r8 == 0) goto L_0x00d7
            r15.na = r3
        L_0x00d7:
            int r8 = r7.getVisibility()
            r14.p(r8)
            boolean r8 = r15.aa
            if (r8 == 0) goto L_0x00e7
            r8 = 8
            r14.p(r8)
        L_0x00e7:
            r14.a((java.lang.Object) r7)
            a.e.b.a.i r7 = r0.d
            r7.a((a.e.b.a.h) r14)
            boolean r7 = r15.W
            if (r7 == 0) goto L_0x00f7
            boolean r7 = r15.V
            if (r7 != 0) goto L_0x00fc
        L_0x00f7:
            java.util.ArrayList<a.e.b.a.h> r7 = r0.c
            r7.add(r14)
        L_0x00fc:
            boolean r7 = r15.Y
            r8 = 17
            if (r7 == 0) goto L_0x012a
            a.e.b.a.l r14 = (a.e.b.a.l) r14
            int r7 = r15.ja
            int r9 = r15.ka
            float r10 = r15.la
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 >= r8) goto L_0x0114
            int r7 = r15.f675a
            int r9 = r15.f676b
            float r10 = r15.c
        L_0x0114:
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r8 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x011e
            r14.e(r10)
            goto L_0x00c4
        L_0x011e:
            if (r7 == r4) goto L_0x0124
            r14.v(r7)
            goto L_0x00c4
        L_0x0124:
            if (r9 == r4) goto L_0x00c4
            r14.w(r9)
            goto L_0x00c4
        L_0x012a:
            int r7 = r15.d
            if (r7 != r4) goto L_0x0172
            int r7 = r15.e
            if (r7 != r4) goto L_0x0172
            int r7 = r15.f
            if (r7 != r4) goto L_0x0172
            int r7 = r15.g
            if (r7 != r4) goto L_0x0172
            int r7 = r15.q
            if (r7 != r4) goto L_0x0172
            int r7 = r15.p
            if (r7 != r4) goto L_0x0172
            int r7 = r15.r
            if (r7 != r4) goto L_0x0172
            int r7 = r15.s
            if (r7 != r4) goto L_0x0172
            int r7 = r15.h
            if (r7 != r4) goto L_0x0172
            int r7 = r15.i
            if (r7 != r4) goto L_0x0172
            int r7 = r15.j
            if (r7 != r4) goto L_0x0172
            int r7 = r15.k
            if (r7 != r4) goto L_0x0172
            int r7 = r15.l
            if (r7 != r4) goto L_0x0172
            int r7 = r15.Q
            if (r7 != r4) goto L_0x0172
            int r7 = r15.R
            if (r7 != r4) goto L_0x0172
            int r7 = r15.m
            if (r7 != r4) goto L_0x0172
            int r7 = r15.width
            if (r7 == r4) goto L_0x0172
            int r7 = r15.height
            if (r7 != r4) goto L_0x00c4
        L_0x0172:
            int r7 = r15.ca
            int r9 = r15.da
            int r10 = r15.ea
            int r11 = r15.fa
            int r12 = r15.ga
            int r13 = r15.ha
            float r3 = r15.ia
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 >= r8) goto L_0x01be
            int r3 = r15.d
            int r6 = r15.e
            int r10 = r15.f
            int r11 = r15.g
            int r7 = r15.t
            int r8 = r15.v
            float r9 = r15.z
            if (r3 != r4) goto L_0x01a1
            if (r6 != r4) goto L_0x01a1
            int r12 = r15.q
            if (r12 == r4) goto L_0x019c
            r3 = r12
            goto L_0x01a1
        L_0x019c:
            int r12 = r15.p
            if (r12 == r4) goto L_0x01a1
            r6 = r12
        L_0x01a1:
            if (r10 != r4) goto L_0x01b7
            if (r11 != r4) goto L_0x01b7
            int r12 = r15.r
            if (r12 == r4) goto L_0x01ae
            r13 = r7
            r16 = r8
            r7 = r12
            goto L_0x01bb
        L_0x01ae:
            int r12 = r15.s
            if (r12 == r4) goto L_0x01b7
            r13 = r7
            r16 = r8
            r11 = r9
            goto L_0x01c5
        L_0x01b7:
            r13 = r7
            r16 = r8
            r7 = r10
        L_0x01bb:
            r12 = r11
            r11 = r9
            goto L_0x01c6
        L_0x01be:
            r6 = r9
            r16 = r13
            r13 = r12
            r12 = r11
            r11 = r3
            r3 = r7
        L_0x01c5:
            r7 = r10
        L_0x01c6:
            int r8 = r15.m
            if (r8 == r4) goto L_0x01da
            a.e.b.a.h r3 = r0.c(r8)
            if (r3 == 0) goto L_0x01d7
            float r6 = r15.o
            int r7 = r15.n
            r14.a((a.e.b.a.h) r3, (float) r6, (int) r7)
        L_0x01d7:
            r7 = 1
            goto L_0x02fd
        L_0x01da:
            if (r3 == r4) goto L_0x01f5
            a.e.b.a.h r10 = r0.c(r3)
            if (r10 == 0) goto L_0x01f1
            a.e.b.a.f$c r3 = a.e.b.a.f.c.LEFT
            int r6 = r15.leftMargin
            r8 = r14
            r9 = r3
            r17 = r11
            r11 = r3
            r3 = r12
            r12 = r6
            r8.a(r9, r10, r11, r12, r13)
            goto L_0x020a
        L_0x01f1:
            r17 = r11
            r3 = r12
            goto L_0x020a
        L_0x01f5:
            r17 = r11
            r3 = r12
            if (r6 == r4) goto L_0x020a
            a.e.b.a.h r10 = r0.c(r6)
            if (r10 == 0) goto L_0x020a
            a.e.b.a.f$c r9 = a.e.b.a.f.c.LEFT
            a.e.b.a.f$c r11 = a.e.b.a.f.c.RIGHT
            int r12 = r15.leftMargin
            r8 = r14
            r8.a(r9, r10, r11, r12, r13)
        L_0x020a:
            if (r7 == r4) goto L_0x021f
            a.e.b.a.h r10 = r0.c(r7)
            if (r10 == 0) goto L_0x0232
            a.e.b.a.f$c r9 = a.e.b.a.f.c.RIGHT
            a.e.b.a.f$c r11 = a.e.b.a.f.c.LEFT
            int r12 = r15.rightMargin
            r8 = r14
            r13 = r16
            r8.a(r9, r10, r11, r12, r13)
            goto L_0x0232
        L_0x021f:
            if (r3 == r4) goto L_0x0232
            a.e.b.a.h r10 = r0.c(r3)
            if (r10 == 0) goto L_0x0232
            a.e.b.a.f$c r11 = a.e.b.a.f.c.RIGHT
            int r12 = r15.rightMargin
            r8 = r14
            r9 = r11
            r13 = r16
            r8.a(r9, r10, r11, r12, r13)
        L_0x0232:
            int r3 = r15.h
            if (r3 == r4) goto L_0x0248
            a.e.b.a.h r10 = r0.c(r3)
            if (r10 == 0) goto L_0x025e
            a.e.b.a.f$c r11 = a.e.b.a.f.c.TOP
            int r12 = r15.topMargin
            int r13 = r15.u
            r8 = r14
            r9 = r11
            r8.a(r9, r10, r11, r12, r13)
            goto L_0x025e
        L_0x0248:
            int r3 = r15.i
            if (r3 == r4) goto L_0x025e
            a.e.b.a.h r10 = r0.c(r3)
            if (r10 == 0) goto L_0x025e
            a.e.b.a.f$c r9 = a.e.b.a.f.c.TOP
            a.e.b.a.f$c r11 = a.e.b.a.f.c.BOTTOM
            int r12 = r15.topMargin
            int r13 = r15.u
            r8 = r14
            r8.a(r9, r10, r11, r12, r13)
        L_0x025e:
            int r3 = r15.j
            if (r3 == r4) goto L_0x0275
            a.e.b.a.h r10 = r0.c(r3)
            if (r10 == 0) goto L_0x028a
            a.e.b.a.f$c r9 = a.e.b.a.f.c.BOTTOM
            a.e.b.a.f$c r11 = a.e.b.a.f.c.TOP
            int r12 = r15.bottomMargin
            int r13 = r15.w
            r8 = r14
            r8.a(r9, r10, r11, r12, r13)
            goto L_0x028a
        L_0x0275:
            int r3 = r15.k
            if (r3 == r4) goto L_0x028a
            a.e.b.a.h r10 = r0.c(r3)
            if (r10 == 0) goto L_0x028a
            a.e.b.a.f$c r11 = a.e.b.a.f.c.BOTTOM
            int r12 = r15.bottomMargin
            int r13 = r15.w
            r8 = r14
            r9 = r11
            r8.a(r9, r10, r11, r12, r13)
        L_0x028a:
            int r3 = r15.l
            if (r3 == r4) goto L_0x02df
            android.util.SparseArray<android.view.View> r6 = r0.f673a
            java.lang.Object r3 = r6.get(r3)
            android.view.View r3 = (android.view.View) r3
            int r6 = r15.l
            a.e.b.a.h r6 = r0.c(r6)
            if (r6 == 0) goto L_0x02df
            if (r3 == 0) goto L_0x02df
            android.view.ViewGroup$LayoutParams r7 = r3.getLayoutParams()
            boolean r7 = r7 instanceof androidx.constraintlayout.widget.ConstraintLayout.a
            if (r7 == 0) goto L_0x02df
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$a r3 = (androidx.constraintlayout.widget.ConstraintLayout.a) r3
            r7 = 1
            r15.X = r7
            r3.X = r7
            a.e.b.a.f$c r3 = a.e.b.a.f.c.BASELINE
            a.e.b.a.f r18 = r14.a((a.e.b.a.f.c) r3)
            a.e.b.a.f$c r3 = a.e.b.a.f.c.BASELINE
            a.e.b.a.f r19 = r6.a((a.e.b.a.f.c) r3)
            r20 = 0
            r21 = -1
            a.e.b.a.f$b r22 = a.e.b.a.f.b.STRONG
            r23 = 0
            r24 = 1
            r18.a(r19, r20, r21, r22, r23, r24)
            a.e.b.a.f$c r3 = a.e.b.a.f.c.TOP
            a.e.b.a.f r3 = r14.a((a.e.b.a.f.c) r3)
            r3.j()
            a.e.b.a.f$c r3 = a.e.b.a.f.c.BOTTOM
            a.e.b.a.f r3 = r14.a((a.e.b.a.f.c) r3)
            r3.j()
            goto L_0x02e0
        L_0x02df:
            r7 = 1
        L_0x02e0:
            r3 = 1056964608(0x3f000000, float:0.5)
            r6 = 0
            r9 = r17
            int r8 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x02f0
            int r8 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r8 == 0) goto L_0x02f0
            r14.a((float) r9)
        L_0x02f0:
            float r8 = r15.A
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x02fd
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x02fd
            r14.c((float) r8)
        L_0x02fd:
            if (r1 == 0) goto L_0x030e
            int r3 = r15.Q
            if (r3 != r4) goto L_0x0307
            int r3 = r15.R
            if (r3 == r4) goto L_0x030e
        L_0x0307:
            int r3 = r15.Q
            int r6 = r15.R
            r14.c(r3, r6)
        L_0x030e:
            boolean r3 = r15.V
            if (r3 != 0) goto L_0x033a
            int r3 = r15.width
            if (r3 != r4) goto L_0x0330
            a.e.b.a.h$a r3 = a.e.b.a.h.a.MATCH_PARENT
            r14.a((a.e.b.a.h.a) r3)
            a.e.b.a.f$c r3 = a.e.b.a.f.c.LEFT
            a.e.b.a.f r3 = r14.a((a.e.b.a.f.c) r3)
            int r6 = r15.leftMargin
            r3.e = r6
            a.e.b.a.f$c r3 = a.e.b.a.f.c.RIGHT
            a.e.b.a.f r3 = r14.a((a.e.b.a.f.c) r3)
            int r6 = r15.rightMargin
            r3.e = r6
            goto L_0x0344
        L_0x0330:
            a.e.b.a.h$a r3 = a.e.b.a.h.a.MATCH_CONSTRAINT
            r14.a((a.e.b.a.h.a) r3)
            r3 = 0
            r14.q(r3)
            goto L_0x0344
        L_0x033a:
            a.e.b.a.h$a r3 = a.e.b.a.h.a.FIXED
            r14.a((a.e.b.a.h.a) r3)
            int r3 = r15.width
            r14.q(r3)
        L_0x0344:
            boolean r3 = r15.W
            if (r3 != 0) goto L_0x0371
            int r3 = r15.height
            if (r3 != r4) goto L_0x0367
            a.e.b.a.h$a r3 = a.e.b.a.h.a.MATCH_PARENT
            r14.b((a.e.b.a.h.a) r3)
            a.e.b.a.f$c r3 = a.e.b.a.f.c.TOP
            a.e.b.a.f r3 = r14.a((a.e.b.a.f.c) r3)
            int r6 = r15.topMargin
            r3.e = r6
            a.e.b.a.f$c r3 = a.e.b.a.f.c.BOTTOM
            a.e.b.a.f r3 = r14.a((a.e.b.a.f.c) r3)
            int r6 = r15.bottomMargin
            r3.e = r6
            r3 = 0
            goto L_0x037c
        L_0x0367:
            a.e.b.a.h$a r3 = a.e.b.a.h.a.MATCH_CONSTRAINT
            r14.b((a.e.b.a.h.a) r3)
            r3 = 0
            r14.i(r3)
            goto L_0x037c
        L_0x0371:
            r3 = 0
            a.e.b.a.h$a r6 = a.e.b.a.h.a.FIXED
            r14.b((a.e.b.a.h.a) r6)
            int r6 = r15.height
            r14.i(r6)
        L_0x037c:
            java.lang.String r6 = r15.B
            if (r6 == 0) goto L_0x0383
            r14.b((java.lang.String) r6)
        L_0x0383:
            float r6 = r15.E
            r14.b((float) r6)
            float r6 = r15.F
            r14.d((float) r6)
            int r6 = r15.G
            r14.j(r6)
            int r6 = r15.H
            r14.o(r6)
            int r6 = r15.I
            int r8 = r15.K
            int r9 = r15.M
            float r10 = r15.O
            r14.a((int) r6, (int) r8, (int) r9, (float) r10)
            int r6 = r15.J
            int r8 = r15.L
            int r9 = r15.N
            float r10 = r15.P
            r14.b(r6, r8, r9, r10)
        L_0x03ad:
            int r5 = r5 + 1
            r6 = 1
            goto L_0x00b8
        L_0x03b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a():void");
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet, i2, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(attributeSet, i2, i3);
    }

    public final h a(View view) {
        if (view == this) {
            return this.d;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).ma;
    }

    public static class a extends ViewGroup.MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        float C = 0.0f;
        int D = 1;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public float O = 1.0f;
        public float P = 1.0f;
        public int Q = -1;
        public int R = -1;
        public int S = -1;
        public boolean T = false;
        public boolean U = false;
        boolean V = true;
        boolean W = true;
        boolean X = false;
        boolean Y = false;
        boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f675a = -1;
        boolean aa = false;

        /* renamed from: b  reason: collision with root package name */
        public int f676b = -1;
        boolean ba = false;
        public float c = -1.0f;
        int ca = -1;
        public int d = -1;
        int da = -1;
        public int e = -1;
        int ea = -1;
        public int f = -1;
        int fa = -1;
        public int g = -1;
        int ga = -1;
        public int h = -1;
        int ha = -1;
        public int i = -1;
        float ia = 0.5f;
        public int j = -1;
        int ja;
        public int k = -1;
        int ka;
        public int l = -1;
        float la;
        public int m = -1;
        h ma = new h();
        public int n = 0;
        public boolean na = false;
        public float o = 0.0f;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public int y = -1;
        public float z = 0.5f;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a  reason: collision with other inner class name */
        private static class C0022a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f677a = new SparseIntArray();

            static {
                f677a.append(m.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                f677a.append(m.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f677a.append(m.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                f677a.append(m.ConstraintLayout_Layout_android_orientation, 1);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                f677a.append(m.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f677a.append(m.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f677a.append(m.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f677a.append(m.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f677a.append(m.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f677a.append(m.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                f677a.append(m.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f677a.append(m.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                f677a.append(m.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                switch (C0022a.f677a.get(index)) {
                    case 1:
                        this.S = obtainStyledAttributes.getInt(index, this.S);
                        break;
                    case 2:
                        this.m = obtainStyledAttributes.getResourceId(index, this.m);
                        if (this.m != -1) {
                            break;
                        } else {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        this.o = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        float f2 = this.o;
                        if (f2 >= 0.0f) {
                            break;
                        } else {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f675a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f675a);
                        break;
                    case 6:
                        this.f676b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f676b);
                        break;
                    case 7:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 8:
                        this.d = obtainStyledAttributes.getResourceId(index, this.d);
                        if (this.d != -1) {
                            break;
                        } else {
                            this.d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        this.e = obtainStyledAttributes.getResourceId(index, this.e);
                        if (this.e != -1) {
                            break;
                        } else {
                            this.e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        this.f = obtainStyledAttributes.getResourceId(index, this.f);
                        if (this.f != -1) {
                            break;
                        } else {
                            this.f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        this.g = obtainStyledAttributes.getResourceId(index, this.g);
                        if (this.g != -1) {
                            break;
                        } else {
                            this.g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        this.h = obtainStyledAttributes.getResourceId(index, this.h);
                        if (this.h != -1) {
                            break;
                        } else {
                            this.h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        this.i = obtainStyledAttributes.getResourceId(index, this.i);
                        if (this.i != -1) {
                            break;
                        } else {
                            this.i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        this.j = obtainStyledAttributes.getResourceId(index, this.j);
                        if (this.j != -1) {
                            break;
                        } else {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        this.k = obtainStyledAttributes.getResourceId(index, this.k);
                        if (this.k != -1) {
                            break;
                        } else {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        this.l = obtainStyledAttributes.getResourceId(index, this.l);
                        if (this.l != -1) {
                            break;
                        } else {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        this.p = obtainStyledAttributes.getResourceId(index, this.p);
                        if (this.p != -1) {
                            break;
                        } else {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        this.q = obtainStyledAttributes.getResourceId(index, this.q);
                        if (this.q != -1) {
                            break;
                        } else {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        this.r = obtainStyledAttributes.getResourceId(index, this.r);
                        if (this.r != -1) {
                            break;
                        } else {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        this.s = obtainStyledAttributes.getResourceId(index, this.s);
                        if (this.s != -1) {
                            break;
                        } else {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 28:
                        this.U = obtainStyledAttributes.getBoolean(index, this.U);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        this.I = obtainStyledAttributes.getInt(index, 0);
                        if (this.I != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        this.J = obtainStyledAttributes.getInt(index, 0);
                        if (this.J != 1) {
                            break;
                        } else {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.K) != -2) {
                                break;
                            } else {
                                this.K = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.M) != -2) {
                                break;
                            } else {
                                this.M = -2;
                                break;
                            }
                        }
                    case 35:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        break;
                    case 36:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.L) != -2) {
                                break;
                            } else {
                                this.L = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.N) != -2) {
                                break;
                            } else {
                                this.N = -2;
                                break;
                            }
                        }
                    case 38:
                        this.P = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.P));
                        break;
                    case 44:
                        this.B = obtainStyledAttributes.getString(index);
                        this.C = Float.NaN;
                        this.D = -1;
                        String str = this.B;
                        if (str == null) {
                            break;
                        } else {
                            int length = str.length();
                            int indexOf = this.B.indexOf(44);
                            if (indexOf <= 0 || indexOf >= length - 1) {
                                i2 = 0;
                            } else {
                                String substring = this.B.substring(0, indexOf);
                                if (substring.equalsIgnoreCase("W")) {
                                    this.D = 0;
                                } else if (substring.equalsIgnoreCase("H")) {
                                    this.D = 1;
                                }
                                i2 = indexOf + 1;
                            }
                            int indexOf2 = this.B.indexOf(58);
                            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                String substring2 = this.B.substring(i2, indexOf2);
                                String substring3 = this.B.substring(indexOf2 + 1);
                                if (substring2.length() > 0 && substring3.length() > 0) {
                                    try {
                                        float parseFloat = Float.parseFloat(substring2);
                                        float parseFloat2 = Float.parseFloat(substring3);
                                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                            if (this.D != 1) {
                                                this.C = Math.abs(parseFloat / parseFloat2);
                                                break;
                                            } else {
                                                this.C = Math.abs(parseFloat2 / parseFloat);
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException unused5) {
                                        break;
                                    }
                                }
                            } else {
                                String substring4 = this.B.substring(i2);
                                if (substring4.length() <= 0) {
                                    break;
                                } else {
                                    this.C = Float.parseFloat(substring4);
                                    break;
                                }
                            }
                        }
                        break;
                    case 45:
                        this.E = obtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 46:
                        this.F = obtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 47:
                        this.G = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.H = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                        break;
                    case 50:
                        this.R = obtainStyledAttributes.getDimensionPixelOffset(index, this.R);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            if (this.width == -2 && this.T) {
                this.V = false;
                this.I = 1;
            }
            if (this.height == -2 && this.U) {
                this.W = false;
                this.J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.V = false;
                if (this.width == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.W = false;
                if (this.height == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.c != -1.0f || this.f675a != -1 || this.f676b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.ma instanceof l)) {
                    this.ma = new l();
                }
                ((l) this.ma).x(this.S);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r7) {
            /*
                r6 = this;
                int r0 = r6.leftMargin
                int r1 = r6.rightMargin
                super.resolveLayoutDirection(r7)
                r7 = -1
                r6.ea = r7
                r6.fa = r7
                r6.ca = r7
                r6.da = r7
                r6.ga = r7
                r6.ha = r7
                int r2 = r6.t
                r6.ga = r2
                int r2 = r6.v
                r6.ha = r2
                float r2 = r6.z
                r6.ia = r2
                int r2 = r6.f675a
                r6.ja = r2
                int r2 = r6.f676b
                r6.ka = r2
                float r2 = r6.c
                r6.la = r2
                int r2 = r6.getLayoutDirection()
                r3 = 0
                r4 = 1
                if (r4 != r2) goto L_0x0036
                r2 = 1
                goto L_0x0037
            L_0x0036:
                r2 = 0
            L_0x0037:
                if (r2 == 0) goto L_0x009a
                int r2 = r6.p
                if (r2 == r7) goto L_0x0041
                r6.ea = r2
            L_0x003f:
                r3 = 1
                goto L_0x0048
            L_0x0041:
                int r2 = r6.q
                if (r2 == r7) goto L_0x0048
                r6.fa = r2
                goto L_0x003f
            L_0x0048:
                int r2 = r6.r
                if (r2 == r7) goto L_0x004f
                r6.da = r2
                r3 = 1
            L_0x004f:
                int r2 = r6.s
                if (r2 == r7) goto L_0x0056
                r6.ca = r2
                r3 = 1
            L_0x0056:
                int r2 = r6.x
                if (r2 == r7) goto L_0x005c
                r6.ha = r2
            L_0x005c:
                int r2 = r6.y
                if (r2 == r7) goto L_0x0062
                r6.ga = r2
            L_0x0062:
                r2 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x006c
                float r3 = r6.z
                float r3 = r2 - r3
                r6.ia = r3
            L_0x006c:
                boolean r3 = r6.Y
                if (r3 == 0) goto L_0x00be
                int r3 = r6.S
                if (r3 != r4) goto L_0x00be
                float r3 = r6.c
                r4 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r5 == 0) goto L_0x0084
                float r2 = r2 - r3
                r6.la = r2
                r6.ja = r7
                r6.ka = r7
                goto L_0x00be
            L_0x0084:
                int r2 = r6.f675a
                if (r2 == r7) goto L_0x008f
                r6.ka = r2
                r6.ja = r7
                r6.la = r4
                goto L_0x00be
            L_0x008f:
                int r2 = r6.f676b
                if (r2 == r7) goto L_0x00be
                r6.ja = r2
                r6.ka = r7
                r6.la = r4
                goto L_0x00be
            L_0x009a:
                int r2 = r6.p
                if (r2 == r7) goto L_0x00a0
                r6.da = r2
            L_0x00a0:
                int r2 = r6.q
                if (r2 == r7) goto L_0x00a6
                r6.ca = r2
            L_0x00a6:
                int r2 = r6.r
                if (r2 == r7) goto L_0x00ac
                r6.ea = r2
            L_0x00ac:
                int r2 = r6.s
                if (r2 == r7) goto L_0x00b2
                r6.fa = r2
            L_0x00b2:
                int r2 = r6.x
                if (r2 == r7) goto L_0x00b8
                r6.ga = r2
            L_0x00b8:
                int r2 = r6.y
                if (r2 == r7) goto L_0x00be
                r6.ha = r2
            L_0x00be:
                int r2 = r6.r
                if (r2 != r7) goto L_0x0108
                int r2 = r6.s
                if (r2 != r7) goto L_0x0108
                int r2 = r6.q
                if (r2 != r7) goto L_0x0108
                int r2 = r6.p
                if (r2 != r7) goto L_0x0108
                int r2 = r6.f
                if (r2 == r7) goto L_0x00dd
                r6.ea = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00eb
                if (r1 <= 0) goto L_0x00eb
                r6.rightMargin = r1
                goto L_0x00eb
            L_0x00dd:
                int r2 = r6.g
                if (r2 == r7) goto L_0x00eb
                r6.fa = r2
                int r2 = r6.rightMargin
                if (r2 > 0) goto L_0x00eb
                if (r1 <= 0) goto L_0x00eb
                r6.rightMargin = r1
            L_0x00eb:
                int r1 = r6.d
                if (r1 == r7) goto L_0x00fa
                r6.ca = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0108
                if (r0 <= 0) goto L_0x0108
                r6.leftMargin = r0
                goto L_0x0108
            L_0x00fa:
                int r1 = r6.e
                if (r1 == r7) goto L_0x0108
                r6.da = r1
                int r7 = r6.leftMargin
                if (r7 > 0) goto L_0x0108
                if (r0 <= 0) goto L_0x0108
                r6.leftMargin = r0
            L_0x0108:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private void a(int i2, int i3) {
        boolean z;
        boolean z2;
        int baseline;
        int i4;
        int i5;
        int i6 = i2;
        int i7 = i3;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                h hVar = aVar.ma;
                if (!aVar.Y && (!aVar.Z || aVar.ba)) {
                    hVar.p(childAt.getVisibility());
                    if (aVar.ba) {
                        hVar.p(i8);
                    }
                    int i10 = aVar.width;
                    int i11 = aVar.height;
                    boolean z3 = aVar.V;
                    if (z3 || aVar.W || (!z3 && aVar.I == 1) || aVar.width == -1 || (!aVar.W && (aVar.J == 1 || aVar.height == -1))) {
                        if (i10 == 0) {
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingLeft, -2);
                            z2 = true;
                        } else if (i10 == -1) {
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingLeft, -1);
                            z2 = false;
                        } else {
                            z2 = i10 == -2;
                            i4 = ViewGroup.getChildMeasureSpec(i6, paddingLeft, i10);
                        }
                        if (i11 == 0) {
                            i5 = ViewGroup.getChildMeasureSpec(i7, paddingTop, -2);
                            z = true;
                        } else if (i11 == -1) {
                            i5 = ViewGroup.getChildMeasureSpec(i7, paddingTop, -1);
                            z = false;
                        } else {
                            z = i11 == -2;
                            i5 = ViewGroup.getChildMeasureSpec(i7, paddingTop, i11);
                        }
                        childAt.measure(i4, i5);
                        a.e.b.f fVar = this.v;
                        if (fVar != null) {
                            fVar.f110a++;
                        }
                        hVar.b(i10 == -2);
                        hVar.a(i11 == -2);
                        i10 = childAt.getMeasuredWidth();
                        i11 = childAt.getMeasuredHeight();
                    } else {
                        z2 = false;
                        z = false;
                    }
                    hVar.q(i10);
                    hVar.i(i11);
                    if (z2) {
                        hVar.s(i10);
                    }
                    if (z) {
                        hVar.r(i11);
                    }
                    if (aVar.X && (baseline = childAt.getBaseline()) != -1) {
                        hVar.h(baseline);
                    }
                }
            }
            i9++;
            i8 = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        a.e.b.f fVar = this.v;
        if (fVar != null) {
            fVar.c++;
        }
        this.d.N();
    }

    public void a(int i2, int i3, int i4) {
        f fVar = this.l;
        if (fVar != null) {
            fVar.a(i2, (float) i3, (float) i4);
        }
    }

    public View a(int i2) {
        return this.f673a.get(i2);
    }
}
