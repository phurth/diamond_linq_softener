package a.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class D extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ E f269a;

    D(E e) {
        this.f269a = e;
    }

    public void onAnimationEnd(Animator animator) {
        this.f269a.a();
        animator.removeListener(this);
    }
}
