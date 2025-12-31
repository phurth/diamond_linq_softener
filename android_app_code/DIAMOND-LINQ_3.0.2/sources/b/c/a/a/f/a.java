package b.c.a.a.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1298a;

    a(f fVar) {
        this.f1298a = fVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1298a.b();
    }

    public void onAnimationStart(Animator animator) {
        this.f1298a.a();
    }
}
