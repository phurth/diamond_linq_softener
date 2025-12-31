package a.n;

import a.g.i.y;
import a.n.E;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: a.n.o  reason: case insensitive filesystem */
public class C0060o extends ha {

    /* renamed from: a.n.o$a */
    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f323a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f324b = false;

        a(View view) {
            this.f323a = view;
        }

        public void onAnimationEnd(Animator animator) {
            ba.a(this.f323a, 1.0f);
            if (this.f324b) {
                this.f323a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (y.w(this.f323a) && this.f323a.getLayerType() == 0) {
                this.f324b = true;
                this.f323a.setLayerType(2, (Paint) null);
            }
        }
    }

    public C0060o(int i) {
        a(i);
    }

    private Animator a(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ba.a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ba.d, new float[]{f2});
        ofFloat.addListener(new a(view));
        a((E.c) new C0059n(this, view));
        return ofFloat;
    }

    public Animator b(ViewGroup viewGroup, View view, M m, M m2) {
        ba.e(view);
        return a(view, a(m, 1.0f), 0.0f);
    }

    public void c(M m) {
        super.c(m);
        m.f285a.put("android:fade:transitionAlpha", Float.valueOf(ba.c(m.f286b)));
    }

    public Animator a(ViewGroup viewGroup, View view, M m, M m2) {
        float f = 0.0f;
        float a2 = a(m, 0.0f);
        if (a2 != 1.0f) {
            f = a2;
        }
        return a(view, f, 1.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f285a.get("android:fade:transitionAlpha");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float a(a.n.M r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f285a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.n.C0060o.a(a.n.M, float):float");
    }
}
