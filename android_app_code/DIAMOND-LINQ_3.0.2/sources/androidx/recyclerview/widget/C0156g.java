package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.g  reason: case insensitive filesystem */
class C0156g extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.x f963a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f964b;
    final /* synthetic */ ViewPropertyAnimator c;
    final /* synthetic */ C0160k d;

    C0156g(C0160k kVar, RecyclerView.x xVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.d = kVar;
        this.f963a = xVar;
        this.f964b = view;
        this.c = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        this.f964b.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.c.setListener((Animator.AnimatorListener) null);
        this.d.h(this.f963a);
        this.d.p.remove(this.f963a);
        this.d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.d.i(this.f963a);
    }
}
