package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.h  reason: case insensitive filesystem */
class C0157h extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecyclerView.x f965a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f966b;
    final /* synthetic */ View c;
    final /* synthetic */ int d;
    final /* synthetic */ ViewPropertyAnimator e;
    final /* synthetic */ C0160k f;

    C0157h(C0160k kVar, RecyclerView.x xVar, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f = kVar;
        this.f965a = xVar;
        this.f966b = i;
        this.c = view;
        this.d = i2;
        this.e = viewPropertyAnimator;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.f966b != 0) {
            this.c.setTranslationX(0.0f);
        }
        if (this.d != 0) {
            this.c.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.e.setListener((Animator.AnimatorListener) null);
        this.f.j(this.f965a);
        this.f.q.remove(this.f965a);
        this.f.j();
    }

    public void onAnimationStart(Animator animator) {
        this.f.k(this.f965a);
    }
}
