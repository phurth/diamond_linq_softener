package a.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ga extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Q f305a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f306b;
    final /* synthetic */ ha c;

    ga(ha haVar, Q q, View view) {
        this.c = haVar;
        this.f305a = q;
        this.f306b = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f305a.b(this.f306b);
    }
}
