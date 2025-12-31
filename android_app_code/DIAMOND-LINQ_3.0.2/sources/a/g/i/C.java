package a.g.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class C extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ F f196a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f197b;
    final /* synthetic */ E c;

    C(E e, F f, View view) {
        this.c = e;
        this.f196a = f;
        this.f197b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f196a.a(this.f197b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f196a.b(this.f197b);
    }

    public void onAnimationStart(Animator animator) {
        this.f196a.c(this.f197b);
    }
}
