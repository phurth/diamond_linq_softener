package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class h extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    g f704a;

    public g getConstraintSet() {
        if (this.f704a == null) {
            this.f704a = new g();
        }
        this.f704a.a(this);
        return this.f704a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
        return new ConstraintLayout.a(layoutParams);
    }

    public static class a extends ConstraintLayout.a {
        public float Aa;
        public float oa;
        public boolean pa;
        public float qa;
        public float ra;
        public float sa;
        public float ta;
        public float ua;
        public float va;
        public float wa;
        public float xa;
        public float ya;
        public float za;

        public a(int i, int i2) {
            super(i, i2);
            this.oa = 1.0f;
            this.pa = false;
            this.qa = 0.0f;
            this.ra = 0.0f;
            this.sa = 0.0f;
            this.ta = 0.0f;
            this.ua = 1.0f;
            this.va = 1.0f;
            this.wa = 0.0f;
            this.xa = 0.0f;
            this.ya = 0.0f;
            this.za = 0.0f;
            this.Aa = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.oa = 1.0f;
            this.pa = false;
            this.qa = 0.0f;
            this.ra = 0.0f;
            this.sa = 0.0f;
            this.ta = 0.0f;
            this.ua = 1.0f;
            this.va = 1.0f;
            this.wa = 0.0f;
            this.xa = 0.0f;
            this.ya = 0.0f;
            this.za = 0.0f;
            this.Aa = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == m.ConstraintSet_android_alpha) {
                    this.oa = obtainStyledAttributes.getFloat(index, this.oa);
                } else if (index == m.ConstraintSet_android_elevation) {
                    this.qa = obtainStyledAttributes.getFloat(index, this.qa);
                    this.pa = true;
                } else if (index == m.ConstraintSet_android_rotationX) {
                    this.sa = obtainStyledAttributes.getFloat(index, this.sa);
                } else if (index == m.ConstraintSet_android_rotationY) {
                    this.ta = obtainStyledAttributes.getFloat(index, this.ta);
                } else if (index == m.ConstraintSet_android_rotation) {
                    this.ra = obtainStyledAttributes.getFloat(index, this.ra);
                } else if (index == m.ConstraintSet_android_scaleX) {
                    this.ua = obtainStyledAttributes.getFloat(index, this.ua);
                } else if (index == m.ConstraintSet_android_scaleY) {
                    this.va = obtainStyledAttributes.getFloat(index, this.va);
                } else if (index == m.ConstraintSet_android_transformPivotX) {
                    this.wa = obtainStyledAttributes.getFloat(index, this.wa);
                } else if (index == m.ConstraintSet_android_transformPivotY) {
                    this.xa = obtainStyledAttributes.getFloat(index, this.xa);
                } else if (index == m.ConstraintSet_android_translationX) {
                    this.ya = obtainStyledAttributes.getFloat(index, this.ya);
                } else if (index == m.ConstraintSet_android_translationY) {
                    this.za = obtainStyledAttributes.getFloat(index, this.za);
                } else if (index == m.ConstraintSet_android_translationZ) {
                    this.ya = obtainStyledAttributes.getFloat(index, this.Aa);
                }
            }
        }
    }
}
