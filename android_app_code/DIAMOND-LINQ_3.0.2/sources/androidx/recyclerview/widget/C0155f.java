package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.f  reason: case insensitive filesystem */
class C0155f extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.x f961a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f962b;
    final /* synthetic */ View c;
    final /* synthetic */ C0160k d;

    C0155f(C0160k kVar, RecyclerView.x xVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.f961a = xVar;
        this.f962b = viewPropertyAnimator;
        this.c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f962b.setListener((Animator.AnimatorListener) null);
        this.c.setAlpha(1.0f);
        this.d.l(this.f961a);
        this.d.r.remove(this.f961a);
        this.d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.d.m(this.f961a);
    }
}
