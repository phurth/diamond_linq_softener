package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: androidx.appcompat.widget.d  reason: case insensitive filesystem */
class C0091d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f590a;

    C0091d(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f590a = actionBarOverlayLayout;
    }

    public void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f590a;
        actionBarOverlayLayout.x = null;
        actionBarOverlayLayout.l = false;
    }

    public void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f590a;
        actionBarOverlayLayout.x = null;
        actionBarOverlayLayout.l = false;
    }
}
