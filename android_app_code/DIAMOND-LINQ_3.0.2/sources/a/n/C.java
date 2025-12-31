package a.n;

import a.d.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class C extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f267a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ E f268b;

    C(E e, b bVar) {
        this.f268b = e;
        this.f267a = bVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f267a.remove(animator);
        this.f268b.A.remove(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.f268b.A.add(animator);
    }
}
