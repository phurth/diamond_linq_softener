package com.google.android.material.transformation;

import a.g.i.y;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.c.a.a.a.b;
import b.c.a.a.a.c;
import b.c.a.a.a.e;
import b.c.a.a.a.h;
import b.c.a.a.a.i;
import b.c.a.a.a.j;
import b.c.a.a.f.d;
import b.c.a.a.f.f;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private final Rect c = new Rect();
    private final RectF d = new RectF();
    private final RectF e = new RectF();
    private final int[] f = new int[2];
    private float g;
    private float h;

    protected static class a {

        /* renamed from: a  reason: collision with root package name */
        public h f1548a;

        /* renamed from: b  reason: collision with root package name */
        public j f1549b;

        protected a() {
        }
    }

    public FabTransformationBehavior() {
    }

    @TargetApi(21)
    private void c(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float i = y.i(view2) - y.i(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-i);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-i});
        }
        aVar.f1548a.b("elevation").a((Animator) objectAnimator);
        list.add(objectAnimator);
    }

    private void d(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof f) && (view instanceof ImageView)) {
            f fVar = (f) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, e.f1283a, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, e.f1283a, new int[]{255});
                }
                objectAnimator.addUpdateListener(new d(this, view2));
                aVar.f1548a.b("iconFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
                list2.add(new e(this, fVar, drawable));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract a a(Context context, boolean z);

    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public AnimatorSet b(View view, View view2, boolean z, boolean z2) {
        boolean z3 = z;
        a a2 = a(view2.getContext(), z3);
        if (z3) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            c(view, view2, z, z2, a2, arrayList, arrayList2);
        }
        RectF rectF = this.d;
        View view3 = view;
        View view4 = view2;
        boolean z4 = z;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        a(view3, view4, z4, z2, a2, (List<Animator>) arrayList3, (List<Animator.AnimatorListener>) arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        a(view3, view4, z4, a2, arrayList);
        boolean z5 = z2;
        a aVar = a2;
        d(view3, view4, z4, z5, aVar, arrayList3, arrayList4);
        a(view3, view4, z4, z5, aVar, width, height, (List<Animator>) arrayList, (List<Animator.AnimatorListener>) arrayList2);
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = arrayList2;
        b(view3, view4, z4, z5, aVar, arrayList5, arrayList6);
        a(view3, view4, z4, z5, aVar, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        animatorSet.addListener(new c(this, z3, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(CoordinatorLayout.e eVar) {
        if (eVar.h == 0) {
            eVar.h = 80;
        }
    }

    private float c(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a(view, rectF);
        b(view2, rectF2);
        int i = jVar.f1292a & 7;
        if (i == 1) {
            f4 = rectF2.centerX();
            f3 = rectF.centerX();
        } else if (i == 3) {
            f4 = rectF2.left;
            f3 = rectF.left;
        } else if (i != 5) {
            f2 = 0.0f;
            return f2 + jVar.f1293b;
        } else {
            f4 = rectF2.right;
            f3 = rectF.right;
        }
        f2 = f4 - f3;
        return f2 + jVar.f1293b;
    }

    private void a(View view, View view2, boolean z, a aVar, List<Animator> list) {
        float c2 = c(view, view2, aVar.f1549b);
        float d2 = d(view, view2, aVar.f1549b);
        Pair<i, i> a2 = a(c2, d2, z, aVar);
        i iVar = (i) a2.first;
        i iVar2 = (i) a2.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            c2 = this.g;
        }
        fArr[0] = c2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            d2 = this.h;
        }
        fArr2[0] = d2;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        iVar.a((Animator) ofFloat);
        iVar2.a((Animator) ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private float d(View view, View view2, j jVar) {
        float f2;
        float f3;
        float f4;
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a(view, rectF);
        b(view2, rectF2);
        int i = jVar.f1292a & 112;
        if (i == 16) {
            f4 = rectF2.centerY();
            f3 = rectF.centerY();
        } else if (i == 48) {
            f4 = rectF2.top;
            f3 = rectF.top;
        } else if (i != 80) {
            f2 = 0.0f;
            return f2 + jVar.c;
        } else {
            f4 = rectF2.bottom;
            f3 = rectF.bottom;
        }
        f2 = f4 - f3;
        return f2 + jVar.c;
    }

    private ViewGroup c(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        View view3 = view;
        View view4 = view2;
        boolean z3 = z;
        a aVar2 = aVar;
        List<Animator> list3 = list;
        float c2 = c(view3, view4, aVar2.f1549b);
        float d2 = d(view3, view4, aVar2.f1549b);
        Pair<i, i> a2 = a(c2, d2, z3, aVar2);
        i iVar = (i) a2.first;
        i iVar2 = (i) a2.second;
        if (z3) {
            if (!z2) {
                view4.setTranslationX(-c2);
                view4.setTranslationY(-d2);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            a(view2, aVar, iVar, iVar2, -c2, -d2, 0.0f, 0.0f, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-c2});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-d2});
        }
        iVar.a((Animator) objectAnimator2);
        iVar2.a((Animator) objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private void b(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof f) {
            f fVar = (f) view2;
            int b2 = b(view);
            int i = 16777215 & b2;
            if (z) {
                if (!z2) {
                    fVar.setCircularRevealScrimColor(b2);
                }
                objectAnimator = ObjectAnimator.ofInt(fVar, f.c.f1304a, new int[]{i});
            } else {
                objectAnimator = ObjectAnimator.ofInt(fVar, f.c.f1304a, new int[]{b2});
            }
            objectAnimator.setEvaluator(c.a());
            aVar.f1548a.b("color").a((Animator) objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void b(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, float f2, float f3, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        View view3 = view;
        View view4 = view2;
        a aVar2 = aVar;
        if (view4 instanceof f) {
            f fVar = (f) view4;
            float a2 = a(view3, view4, aVar2.f1549b);
            float b2 = b(view3, view4, aVar2.f1549b);
            ((FloatingActionButton) view3).a(this.c);
            float width = ((float) this.c.width()) / 2.0f;
            i b3 = aVar2.f1548a.b("expansion");
            if (z) {
                if (!z2) {
                    fVar.setRevealInfo(new f.d(a2, b2, width));
                }
                if (z2) {
                    width = fVar.getRevealInfo().c;
                }
                animator = b.c.a.a.f.b.a(fVar, a2, b2, b.c.a.a.k.a.a(a2, b2, 0.0f, 0.0f, f2, f3));
                animator.addListener(new f(this, fVar));
                a(view2, b3.a(), (int) a2, (int) b2, width, list);
            } else {
                float f4 = fVar.getRevealInfo().c;
                Animator a3 = b.c.a.a.f.b.a(fVar, a2, b2, width);
                int i = (int) a2;
                int i2 = (int) b2;
                View view5 = view2;
                a(view5, b3.a(), i, i2, f4, list);
                long a4 = b3.a();
                long b4 = b3.b();
                long a5 = aVar2.f1548a.a();
                a(view5, a4, b4, a5, i, i2, width, list);
                animator = a3;
            }
            b3.a(animator);
            list.add(animator);
            list2.add(b.c.a.a.f.b.a(fVar));
        }
    }

    private float b(View view, View view2, j jVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a(view, rectF);
        b(view2, rectF2);
        rectF2.offset(0.0f, -d(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private int b(View view) {
        ColorStateList e2 = y.e(view);
        if (e2 != null) {
            return e2.getColorForState(view.getDrawableState(), e2.getDefaultColor());
        }
        return 0;
    }

    private void a(View view, View view2, boolean z, boolean z2, a aVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup a2;
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if ((!(view2 instanceof f) || d.f1300a != 0) && (a2 = a(view2)) != null) {
                if (z) {
                    if (!z2) {
                        b.c.a.a.a.d.f1282a.set(a2, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(a2, b.c.a.a.a.d.f1282a, new float[]{1.0f});
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(a2, b.c.a.a.a.d.f1282a, new float[]{0.0f});
                }
                aVar.f1548a.b("contentFade").a((Animator) objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    private Pair<i, i> a(float f2, float f3, boolean z, a aVar) {
        i iVar;
        i iVar2;
        if (f2 == 0.0f || f3 == 0.0f) {
            iVar2 = aVar.f1548a.b("translationXLinear");
            iVar = aVar.f1548a.b("translationYLinear");
        } else if ((!z || f3 >= 0.0f) && (z || f3 <= 0.0f)) {
            iVar2 = aVar.f1548a.b("translationXCurveDownwards");
            iVar = aVar.f1548a.b("translationYCurveDownwards");
        } else {
            iVar2 = aVar.f1548a.b("translationXCurveUpwards");
            iVar = aVar.f1548a.b("translationYCurveUpwards");
        }
        return new Pair<>(iVar2, iVar);
    }

    private void a(View view, RectF rectF) {
        b(view, rectF);
        rectF.offset(this.g, this.h);
    }

    private float a(View view, View view2, j jVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        a(view, rectF);
        b(view2, rectF2);
        rectF2.offset(-c(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private void a(View view, a aVar, i iVar, i iVar2, float f2, float f3, float f4, float f5, RectF rectF) {
        float a2 = a(aVar, iVar, f2, f4);
        float a3 = a(aVar, iVar2, f3, f5);
        Rect rect = this.c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.d;
        rectF2.set(rect);
        RectF rectF3 = this.e;
        b(view, rectF3);
        rectF3.offset(a2, a3);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float a(a aVar, i iVar, float f2, float f3) {
        long a2 = iVar.a();
        long b2 = iVar.b();
        i b3 = aVar.f1548a.b("expansion");
        return b.c.a.a.a.a.a(f2, f3, iVar.c().getInterpolation(((float) (((b3.a() + b3.b()) + 17) - a2)) / ((float) b2)));
    }

    private ViewGroup a(View view) {
        View findViewById = view.findViewById(b.c.a.a.e.mtrl_child_content_container);
        if (findViewById != null) {
            return c(findViewById);
        }
        if ((view instanceof i) || (view instanceof h)) {
            return c(((ViewGroup) view).getChildAt(0));
        }
        return c(view);
    }

    private void a(View view, long j, int i, int i2, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f2, f2);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j);
            list.add(createCircularReveal);
        }
    }

    private void a(View view, long j, long j2, long j3, int i, int i2, float f2, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f2, f2);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }
}
