package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

class e implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwipeRefreshLayout f1017a;

    e(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1017a = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout.b bVar;
        SwipeRefreshLayout swipeRefreshLayout = this.f1017a;
        if (swipeRefreshLayout.e) {
            swipeRefreshLayout.D.setAlpha(255);
            this.f1017a.D.start();
            SwipeRefreshLayout swipeRefreshLayout2 = this.f1017a;
            if (swipeRefreshLayout2.J && (bVar = swipeRefreshLayout2.d) != null) {
                bVar.d();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = this.f1017a;
            swipeRefreshLayout3.o = swipeRefreshLayout3.w.getTop();
            return;
        }
        swipeRefreshLayout.b();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
