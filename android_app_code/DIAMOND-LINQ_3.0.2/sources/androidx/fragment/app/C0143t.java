package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.fragment.app.t  reason: case insensitive filesystem */
class C0143t extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f820a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f821b;
    final /* synthetic */ C0132h c;
    final /* synthetic */ w d;

    C0143t(w wVar, ViewGroup viewGroup, View view, C0132h hVar) {
        this.d = wVar;
        this.f820a = viewGroup;
        this.f821b = view;
        this.c = hVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f820a.endViewTransition(this.f821b);
        animator.removeListener(this);
        View view = this.c.G;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
