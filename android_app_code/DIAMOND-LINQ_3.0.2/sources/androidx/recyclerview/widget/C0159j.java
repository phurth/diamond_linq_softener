package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.C0160k;

/* renamed from: androidx.recyclerview.widget.j  reason: case insensitive filesystem */
class C0159j extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0160k.a f969a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f970b;
    final /* synthetic */ View c;
    final /* synthetic */ C0160k d;

    C0159j(C0160k kVar, C0160k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.f969a = aVar;
        this.f970b = viewPropertyAnimator;
        this.c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f970b.setListener((Animator.AnimatorListener) null);
        this.c.setAlpha(1.0f);
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        this.d.a(this.f969a.f972b, false);
        this.d.s.remove(this.f969a.f972b);
        this.d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.d.b(this.f969a.f972b, false);
    }
}
