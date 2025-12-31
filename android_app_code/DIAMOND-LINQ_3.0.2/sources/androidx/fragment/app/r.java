package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;

class r implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f816a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ C0132h f817b;
    final /* synthetic */ w c;

    r(w wVar, ViewGroup viewGroup, C0132h hVar) {
        this.c = wVar;
        this.f816a = viewGroup;
        this.f817b = hVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f816a.post(new C0141q(this));
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
