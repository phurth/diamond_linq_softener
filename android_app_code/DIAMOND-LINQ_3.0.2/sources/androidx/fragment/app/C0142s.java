package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.fragment.app.s  reason: case insensitive filesystem */
class C0142s extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f818a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f819b;
    final /* synthetic */ C0132h c;
    final /* synthetic */ w d;

    C0142s(w wVar, ViewGroup viewGroup, View view, C0132h hVar) {
        this.d = wVar;
        this.f818a = viewGroup;
        this.f819b = view;
        this.c = hVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f818a.endViewTransition(this.f819b);
        Animator j = this.c.j();
        this.c.a((Animator) null);
        if (j != null && this.f818a.indexOfChild(this.f819b) < 0) {
            w wVar = this.d;
            C0132h hVar = this.c;
            wVar.a(hVar, hVar.B(), 0, 0, false);
        }
    }
}
