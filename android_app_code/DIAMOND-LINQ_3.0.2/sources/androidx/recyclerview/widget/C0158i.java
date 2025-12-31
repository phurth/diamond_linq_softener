package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.C0160k;

/* renamed from: androidx.recyclerview.widget.i  reason: case insensitive filesystem */
class C0158i extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0160k.a f967a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f968b;
    final /* synthetic */ View c;
    final /* synthetic */ C0160k d;

    C0158i(C0160k kVar, C0160k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.f967a = aVar;
        this.f968b = viewPropertyAnimator;
        this.c = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f968b.setListener((Animator.AnimatorListener) null);
        this.c.setAlpha(1.0f);
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        this.d.a(this.f967a.f971a, true);
        this.d.s.remove(this.f967a.f971a);
        this.d.j();
    }

    public void onAnimationStart(Animator animator) {
        this.d.b(this.f967a.f971a, true);
    }
}
