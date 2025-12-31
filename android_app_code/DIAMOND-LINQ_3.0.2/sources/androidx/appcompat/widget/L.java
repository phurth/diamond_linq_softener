package androidx.appcompat.widget;

import a.a.j;
import a.g.a.a.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.widget.b;
import java.lang.ref.WeakReference;

class L {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f532a;

    /* renamed from: b  reason: collision with root package name */
    private xa f533b;
    private xa c;
    private xa d;
    private xa e;
    private xa f;
    private xa g;
    private xa h;
    private final N i;
    private int j = 0;
    private int k = -1;
    private Typeface l;
    private boolean m;

    L(TextView textView) {
        this.f532a = textView;
        this.i = new N(this.f532a);
    }

    private void l() {
        xa xaVar = this.h;
        this.f533b = xaVar;
        this.c = xaVar;
        this.d = xaVar;
        this.e = xaVar;
        this.f = xaVar;
        this.g = xaVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012b  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.util.AttributeSet r19, int r20) {
        /*
            r18 = this;
            r7 = r18
            r0 = r19
            r1 = r20
            android.widget.TextView r2 = r7.f532a
            android.content.Context r2 = r2.getContext()
            androidx.appcompat.widget.q r3 = androidx.appcompat.widget.C0116q.b()
            int[] r4 = a.a.j.AppCompatTextHelper
            r5 = 0
            androidx.appcompat.widget.za r4 = androidx.appcompat.widget.za.a(r2, r0, r4, r1, r5)
            int r6 = a.a.j.AppCompatTextHelper_android_textAppearance
            r8 = -1
            int r6 = r4.g(r6, r8)
            int r9 = a.a.j.AppCompatTextHelper_android_drawableLeft
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x0032
            int r9 = a.a.j.AppCompatTextHelper_android_drawableLeft
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.xa r9 = a(r2, r3, r9)
            r7.f533b = r9
        L_0x0032:
            int r9 = a.a.j.AppCompatTextHelper_android_drawableTop
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x0046
            int r9 = a.a.j.AppCompatTextHelper_android_drawableTop
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.xa r9 = a(r2, r3, r9)
            r7.c = r9
        L_0x0046:
            int r9 = a.a.j.AppCompatTextHelper_android_drawableRight
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x005a
            int r9 = a.a.j.AppCompatTextHelper_android_drawableRight
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.xa r9 = a(r2, r3, r9)
            r7.d = r9
        L_0x005a:
            int r9 = a.a.j.AppCompatTextHelper_android_drawableBottom
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x006e
            int r9 = a.a.j.AppCompatTextHelper_android_drawableBottom
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.xa r9 = a(r2, r3, r9)
            r7.e = r9
        L_0x006e:
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 17
            if (r9 < r10) goto L_0x009c
            int r9 = a.a.j.AppCompatTextHelper_android_drawableStart
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x0088
            int r9 = a.a.j.AppCompatTextHelper_android_drawableStart
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.xa r9 = a(r2, r3, r9)
            r7.f = r9
        L_0x0088:
            int r9 = a.a.j.AppCompatTextHelper_android_drawableEnd
            boolean r9 = r4.g(r9)
            if (r9 == 0) goto L_0x009c
            int r9 = a.a.j.AppCompatTextHelper_android_drawableEnd
            int r9 = r4.g(r9, r5)
            androidx.appcompat.widget.xa r9 = a(r2, r3, r9)
            r7.g = r9
        L_0x009c:
            r4.a()
            android.widget.TextView r4 = r7.f532a
            android.text.method.TransformationMethod r4 = r4.getTransformationMethod()
            boolean r4 = r4 instanceof android.text.method.PasswordTransformationMethod
            r9 = 26
            r11 = 23
            if (r6 == r8) goto L_0x0130
            int[] r13 = a.a.j.TextAppearance
            androidx.appcompat.widget.za r6 = androidx.appcompat.widget.za.a((android.content.Context) r2, (int) r6, (int[]) r13)
            if (r4 != 0) goto L_0x00c6
            int r13 = a.a.j.TextAppearance_textAllCaps
            boolean r13 = r6.g(r13)
            if (r13 == 0) goto L_0x00c6
            int r13 = a.a.j.TextAppearance_textAllCaps
            boolean r13 = r6.a((int) r13, (boolean) r5)
            r14 = r13
            r13 = 1
            goto L_0x00c8
        L_0x00c6:
            r13 = 0
            r14 = 0
        L_0x00c8:
            r7.a((android.content.Context) r2, (androidx.appcompat.widget.za) r6)
            int r15 = android.os.Build.VERSION.SDK_INT
            if (r15 >= r11) goto L_0x0105
            int r15 = a.a.j.TextAppearance_android_textColor
            boolean r15 = r6.g(r15)
            if (r15 == 0) goto L_0x00de
            int r15 = a.a.j.TextAppearance_android_textColor
            android.content.res.ColorStateList r15 = r6.a(r15)
            goto L_0x00df
        L_0x00de:
            r15 = 0
        L_0x00df:
            int r10 = a.a.j.TextAppearance_android_textColorHint
            boolean r10 = r6.g(r10)
            if (r10 == 0) goto L_0x00ee
            int r10 = a.a.j.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r10 = r6.a(r10)
            goto L_0x00ef
        L_0x00ee:
            r10 = 0
        L_0x00ef:
            int r12 = a.a.j.TextAppearance_android_textColorLink
            boolean r12 = r6.g(r12)
            if (r12 == 0) goto L_0x0103
            int r12 = a.a.j.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r12 = r6.a(r12)
            r17 = r15
            r15 = r12
            r12 = r17
            goto L_0x0108
        L_0x0103:
            r12 = r15
            goto L_0x0107
        L_0x0105:
            r10 = 0
            r12 = 0
        L_0x0107:
            r15 = 0
        L_0x0108:
            int r8 = a.a.j.TextAppearance_textLocale
            boolean r8 = r6.g(r8)
            if (r8 == 0) goto L_0x0117
            int r8 = a.a.j.TextAppearance_textLocale
            java.lang.String r8 = r6.d(r8)
            goto L_0x0118
        L_0x0117:
            r8 = 0
        L_0x0118:
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 < r9) goto L_0x012b
            int r11 = a.a.j.TextAppearance_fontVariationSettings
            boolean r11 = r6.g(r11)
            if (r11 == 0) goto L_0x012b
            int r11 = a.a.j.TextAppearance_fontVariationSettings
            java.lang.String r11 = r6.d(r11)
            goto L_0x012c
        L_0x012b:
            r11 = 0
        L_0x012c:
            r6.a()
            goto L_0x0137
        L_0x0130:
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0137:
            int[] r6 = a.a.j.TextAppearance
            androidx.appcompat.widget.za r6 = androidx.appcompat.widget.za.a(r2, r0, r6, r1, r5)
            if (r4 != 0) goto L_0x014e
            int r9 = a.a.j.TextAppearance_textAllCaps
            boolean r9 = r6.g(r9)
            if (r9 == 0) goto L_0x014e
            int r9 = a.a.j.TextAppearance_textAllCaps
            boolean r14 = r6.a((int) r9, (boolean) r5)
            r13 = 1
        L_0x014e:
            int r9 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r9 >= r5) goto L_0x017e
            int r5 = a.a.j.TextAppearance_android_textColor
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x0162
            int r5 = a.a.j.TextAppearance_android_textColor
            android.content.res.ColorStateList r12 = r6.a(r5)
        L_0x0162:
            int r5 = a.a.j.TextAppearance_android_textColorHint
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x0170
            int r5 = a.a.j.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r10 = r6.a(r5)
        L_0x0170:
            int r5 = a.a.j.TextAppearance_android_textColorLink
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x017e
            int r5 = a.a.j.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r15 = r6.a(r5)
        L_0x017e:
            int r5 = a.a.j.TextAppearance_textLocale
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x018c
            int r5 = a.a.j.TextAppearance_textLocale
            java.lang.String r8 = r6.d(r5)
        L_0x018c:
            int r5 = android.os.Build.VERSION.SDK_INT
            r9 = 26
            if (r5 < r9) goto L_0x01a0
            int r5 = a.a.j.TextAppearance_fontVariationSettings
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x01a0
            int r5 = a.a.j.TextAppearance_fontVariationSettings
            java.lang.String r11 = r6.d(r5)
        L_0x01a0:
            int r5 = android.os.Build.VERSION.SDK_INT
            r9 = 28
            if (r5 < r9) goto L_0x01c1
            int r5 = a.a.j.TextAppearance_android_textSize
            boolean r5 = r6.g(r5)
            if (r5 == 0) goto L_0x01c1
            int r5 = a.a.j.TextAppearance_android_textSize
            r9 = -1
            int r5 = r6.c(r5, r9)
            if (r5 != 0) goto L_0x01c1
            android.widget.TextView r5 = r7.f532a
            r9 = 0
            r16 = r3
            r3 = 0
            r5.setTextSize(r3, r9)
            goto L_0x01c3
        L_0x01c1:
            r16 = r3
        L_0x01c3:
            r7.a((android.content.Context) r2, (androidx.appcompat.widget.za) r6)
            r6.a()
            if (r12 == 0) goto L_0x01d0
            android.widget.TextView r3 = r7.f532a
            r3.setTextColor(r12)
        L_0x01d0:
            if (r10 == 0) goto L_0x01d7
            android.widget.TextView r3 = r7.f532a
            r3.setHintTextColor(r10)
        L_0x01d7:
            if (r15 == 0) goto L_0x01de
            android.widget.TextView r3 = r7.f532a
            r3.setLinkTextColor(r15)
        L_0x01de:
            if (r4 != 0) goto L_0x01e5
            if (r13 == 0) goto L_0x01e5
            r7.a((boolean) r14)
        L_0x01e5:
            android.graphics.Typeface r3 = r7.l
            if (r3 == 0) goto L_0x01fb
            int r4 = r7.k
            r5 = -1
            if (r4 != r5) goto L_0x01f6
            android.widget.TextView r4 = r7.f532a
            int r5 = r7.j
            r4.setTypeface(r3, r5)
            goto L_0x01fb
        L_0x01f6:
            android.widget.TextView r4 = r7.f532a
            r4.setTypeface(r3)
        L_0x01fb:
            if (r11 == 0) goto L_0x0202
            android.widget.TextView r3 = r7.f532a
            r3.setFontVariationSettings(r11)
        L_0x0202:
            if (r8 == 0) goto L_0x022c
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x0214
            android.widget.TextView r3 = r7.f532a
            android.os.LocaleList r4 = android.os.LocaleList.forLanguageTags(r8)
            r3.setTextLocales(r4)
            goto L_0x022c
        L_0x0214:
            r4 = 21
            if (r3 < r4) goto L_0x022c
            r3 = 44
            int r3 = r8.indexOf(r3)
            r4 = 0
            java.lang.String r3 = r8.substring(r4, r3)
            android.widget.TextView r4 = r7.f532a
            java.util.Locale r3 = java.util.Locale.forLanguageTag(r3)
            r4.setTextLocale(r3)
        L_0x022c:
            androidx.appcompat.widget.N r3 = r7.i
            r3.a((android.util.AttributeSet) r0, (int) r1)
            boolean r1 = androidx.core.widget.b.f748a
            if (r1 == 0) goto L_0x0272
            androidx.appcompat.widget.N r1 = r7.i
            int r1 = r1.f()
            if (r1 == 0) goto L_0x0272
            androidx.appcompat.widget.N r1 = r7.i
            int[] r1 = r1.e()
            int r3 = r1.length
            if (r3 <= 0) goto L_0x0272
            android.widget.TextView r3 = r7.f532a
            int r3 = r3.getAutoSizeStepGranularity()
            float r3 = (float) r3
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x026c
            android.widget.TextView r1 = r7.f532a
            androidx.appcompat.widget.N r3 = r7.i
            int r3 = r3.c()
            androidx.appcompat.widget.N r4 = r7.i
            int r4 = r4.b()
            androidx.appcompat.widget.N r5 = r7.i
            int r5 = r5.d()
            r6 = 0
            r1.setAutoSizeTextTypeUniformWithConfiguration(r3, r4, r5, r6)
            goto L_0x0272
        L_0x026c:
            r6 = 0
            android.widget.TextView r3 = r7.f532a
            r3.setAutoSizeTextTypeUniformWithPresetSizes(r1, r6)
        L_0x0272:
            int[] r1 = a.a.j.AppCompatTextView
            androidx.appcompat.widget.za r8 = androidx.appcompat.widget.za.a((android.content.Context) r2, (android.util.AttributeSet) r0, (int[]) r1)
            int r0 = a.a.j.AppCompatTextView_drawableLeftCompat
            r1 = -1
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x0289
            r3 = r16
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r4 = r0
            goto L_0x028c
        L_0x0289:
            r3 = r16
            r4 = 0
        L_0x028c:
            int r0 = a.a.j.AppCompatTextView_drawableTopCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x029a
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r5 = r0
            goto L_0x029b
        L_0x029a:
            r5 = 0
        L_0x029b:
            int r0 = a.a.j.AppCompatTextView_drawableRightCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02a9
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r6 = r0
            goto L_0x02aa
        L_0x02a9:
            r6 = 0
        L_0x02aa:
            int r0 = a.a.j.AppCompatTextView_drawableBottomCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02b8
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r9 = r0
            goto L_0x02b9
        L_0x02b8:
            r9 = 0
        L_0x02b9:
            int r0 = a.a.j.AppCompatTextView_drawableStartCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02c7
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r10 = r0
            goto L_0x02c8
        L_0x02c7:
            r10 = 0
        L_0x02c8:
            int r0 = a.a.j.AppCompatTextView_drawableEndCompat
            int r0 = r8.g(r0, r1)
            if (r0 == r1) goto L_0x02d6
            android.graphics.drawable.Drawable r0 = r3.a((android.content.Context) r2, (int) r0)
            r11 = r0
            goto L_0x02d7
        L_0x02d6:
            r11 = 0
        L_0x02d7:
            r0 = r18
            r1 = r4
            r2 = r5
            r3 = r6
            r4 = r9
            r5 = r10
            r6 = r11
            r0.a(r1, r2, r3, r4, r5, r6)
            int r0 = a.a.j.AppCompatTextView_drawableTint
            boolean r0 = r8.g(r0)
            if (r0 == 0) goto L_0x02f5
            int r0 = a.a.j.AppCompatTextView_drawableTint
            android.content.res.ColorStateList r0 = r8.a(r0)
            android.widget.TextView r1 = r7.f532a
            androidx.core.widget.j.a((android.widget.TextView) r1, (android.content.res.ColorStateList) r0)
        L_0x02f5:
            int r0 = a.a.j.AppCompatTextView_drawableTintMode
            boolean r0 = r8.g(r0)
            if (r0 == 0) goto L_0x030f
            int r0 = a.a.j.AppCompatTextView_drawableTintMode
            r1 = -1
            int r0 = r8.d(r0, r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.S.a(r0, r2)
            android.widget.TextView r2 = r7.f532a
            androidx.core.widget.j.a((android.widget.TextView) r2, (android.graphics.PorterDuff.Mode) r0)
            goto L_0x0310
        L_0x030f:
            r1 = -1
        L_0x0310:
            int r0 = a.a.j.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.c(r0, r1)
            int r2 = a.a.j.AppCompatTextView_lastBaselineToBottomHeight
            int r2 = r8.c(r2, r1)
            int r3 = a.a.j.AppCompatTextView_lineHeight
            int r3 = r8.c(r3, r1)
            r8.a()
            if (r0 == r1) goto L_0x032c
            android.widget.TextView r4 = r7.f532a
            androidx.core.widget.j.a((android.widget.TextView) r4, (int) r0)
        L_0x032c:
            if (r2 == r1) goto L_0x0333
            android.widget.TextView r0 = r7.f532a
            androidx.core.widget.j.b(r0, r2)
        L_0x0333:
            if (r3 == r1) goto L_0x033a
            android.widget.TextView r0 = r7.f532a
            androidx.core.widget.j.c(r0, r3)
        L_0x033a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.L.a(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.i.a();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.i.b();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.i.c();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.i.d();
    }

    /* access modifiers changed from: package-private */
    public int[] f() {
        return this.i.e();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.i.f();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList h() {
        xa xaVar = this.h;
        if (xaVar != null) {
            return xaVar.f654a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode i() {
        xa xaVar = this.h;
        if (xaVar != null) {
            return xaVar.f655b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.i.g();
    }

    /* access modifiers changed from: package-private */
    public void k() {
        a();
    }

    private void b(int i2, float f2) {
        this.i.a(i2, f2);
    }

    private void a(Context context, za zaVar) {
        String d2;
        this.j = zaVar.d(j.TextAppearance_android_textStyle, this.j);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 28) {
            this.k = zaVar.d(j.TextAppearance_android_textFontWeight, -1);
            if (this.k != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (zaVar.g(j.TextAppearance_android_fontFamily) || zaVar.g(j.TextAppearance_fontFamily)) {
            this.l = null;
            int i2 = zaVar.g(j.TextAppearance_fontFamily) ? j.TextAppearance_fontFamily : j.TextAppearance_android_fontFamily;
            int i3 = this.k;
            int i4 = this.j;
            if (!context.isRestricted()) {
                try {
                    Typeface a2 = zaVar.a(i2, this.j, (h.a) new K(this, i3, i4, new WeakReference(this.f532a)));
                    if (a2 != null) {
                        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
                            this.l = a2;
                        } else {
                            this.l = Typeface.create(Typeface.create(a2, 0), this.k, (this.j & 2) != 0);
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l == null && (d2 = zaVar.d(i2)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
                    this.l = Typeface.create(d2, this.j);
                    return;
                }
                Typeface create = Typeface.create(d2, 0);
                int i5 = this.k;
                if ((this.j & 2) != 0) {
                    z = true;
                }
                this.l = Typeface.create(create, i5, z);
            }
        } else if (zaVar.g(j.TextAppearance_android_typeface)) {
            this.m = false;
            int d3 = zaVar.d(j.TextAppearance_android_typeface, 1);
            if (d3 == 1) {
                this.l = Typeface.SANS_SERIF;
            } else if (d3 == 2) {
                this.l = Typeface.SERIF;
            } else if (d3 == 3) {
                this.l = Typeface.MONOSPACE;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, int i2) {
        String d2;
        ColorStateList a2;
        za a3 = za.a(context, i2, j.TextAppearance);
        if (a3.g(j.TextAppearance_textAllCaps)) {
            a(a3.a(j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a3.g(j.TextAppearance_android_textColor) && (a2 = a3.a(j.TextAppearance_android_textColor)) != null) {
            this.f532a.setTextColor(a2);
        }
        if (a3.g(j.TextAppearance_android_textSize) && a3.c(j.TextAppearance_android_textSize, -1) == 0) {
            this.f532a.setTextSize(0, 0.0f);
        }
        a(context, a3);
        if (Build.VERSION.SDK_INT >= 26 && a3.g(j.TextAppearance_fontVariationSettings) && (d2 = a3.d(j.TextAppearance_fontVariationSettings)) != null) {
            this.f532a.setFontVariationSettings(d2);
        }
        a3.a();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f532a.setTypeface(typeface, this.j);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f532a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!(this.f533b == null && this.c == null && this.d == null && this.e == null)) {
            Drawable[] compoundDrawables = this.f532a.getCompoundDrawables();
            a(compoundDrawables[0], this.f533b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f != null || this.g != null) {
            Drawable[] compoundDrawablesRelative = this.f532a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    private void a(Drawable drawable, xa xaVar) {
        if (drawable != null && xaVar != null) {
            C0116q.a(drawable, xaVar, this.f532a.getDrawableState());
        }
    }

    private static xa a(Context context, C0116q qVar, int i2) {
        ColorStateList b2 = qVar.b(context, i2);
        if (b2 == null) {
            return null;
        }
        xa xaVar = new xa();
        xaVar.d = true;
        xaVar.f654a = b2;
        return xaVar;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z, int i2, int i3, int i4, int i5) {
        if (!b.f748a) {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2) {
        if (!b.f748a && !j()) {
            b(i2, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.i.b(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, int i5) {
        this.i.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr, int i2) {
        this.i.a(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new xa();
        }
        xa xaVar = this.h;
        xaVar.f654a = colorStateList;
        xaVar.d = colorStateList != null;
        l();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new xa();
        }
        xa xaVar = this.h;
        xaVar.f655b = mode;
        xaVar.c = mode != null;
        l();
    }

    private void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f532a.getCompoundDrawablesRelative();
            TextView textView = this.f532a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f532a.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f532a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f532a.getCompoundDrawables();
            TextView textView3 = this.f532a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }
}
