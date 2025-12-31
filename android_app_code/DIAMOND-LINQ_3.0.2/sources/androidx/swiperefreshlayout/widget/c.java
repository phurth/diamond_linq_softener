package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import androidx.swiperefreshlayout.widget.d;

class c implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.a f1011a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f1012b;

    c(d dVar, d.a aVar) {
        this.f1012b = dVar;
        this.f1011a = aVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.f1012b.a(1.0f, this.f1011a, true);
        this.f1011a.l();
        this.f1011a.j();
        d dVar = this.f1012b;
        if (dVar.i) {
            dVar.i = false;
            animator.cancel();
            animator.setDuration(1332);
            animator.start();
            this.f1011a.a(false);
            return;
        }
        dVar.h += 1.0f;
    }

    public void onAnimationStart(Animator animator) {
        this.f1012b.h = 0.0f;
    }
}
