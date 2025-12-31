package b.c.a.a.f;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import b.c.a.a.f.f;

public final class b {
    public static Animator a(f fVar, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(fVar, f.b.f1303a, f.a.f1301a, new f.d[]{new f.d(f, f2, f3)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        f.d revealInfo = fVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) fVar, (int) f, (int) f2, revealInfo.c, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static Animator.AnimatorListener a(f fVar) {
        return new a(fVar);
    }
}
