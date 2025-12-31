package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import b.c.a.a.n.a;
import b.c.a.a.o.b;
import java.util.ArrayList;

class n extends m {
    n(FloatingActionButton floatingActionButton, b bVar) {
        super(floatingActionButton, bVar);
    }

    /* access modifiers changed from: package-private */
    public void a(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.F.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(m.f1505b, a(f, f3));
            stateListAnimator.addState(m.c, a(f, f2));
            stateListAnimator.addState(m.d, a(f, f2));
            stateListAnimator.addState(m.e, a(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.F, "elevation", new float[]{f}).setDuration(0));
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.F;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{floatingActionButton.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.F, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(m.f1504a);
            stateListAnimator.addState(m.f, animatorSet);
            stateListAnimator.addState(m.g, a(0.0f, 0.0f));
            this.F.setStateListAnimator(stateListAnimator);
        }
        if (s()) {
            w();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(a.a(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
    }

    /* access modifiers changed from: package-private */
    public void m() {
        w();
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return this.G.a() || !t();
    }

    /* access modifiers changed from: package-private */
    public void u() {
    }

    public float b() {
        return this.F.getElevation();
    }

    private Animator a(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.F, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.F, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
        animatorSet.setInterpolator(m.f1504a);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        if (Build.VERSION.SDK_INT != 21) {
            return;
        }
        if (this.F.isEnabled()) {
            this.F.setElevation(this.o);
            if (this.F.isPressed()) {
                this.F.setTranslationZ(this.q);
            } else if (this.F.isFocused() || this.F.isHovered()) {
                this.F.setTranslationZ(this.p);
            } else {
                this.F.setTranslationZ(0.0f);
            }
        } else {
            this.F.setElevation(0.0f);
            this.F.setTranslationZ(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        if (this.G.a()) {
            super.a(rect);
        } else if (!t()) {
            int sizeDimension = (this.r - this.F.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }
}
