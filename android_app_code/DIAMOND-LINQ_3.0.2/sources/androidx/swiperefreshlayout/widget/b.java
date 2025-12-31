package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import androidx.swiperefreshlayout.widget.d;

class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.a f1009a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ d f1010b;

    b(d dVar, d.a aVar) {
        this.f1010b = dVar;
        this.f1009a = aVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f1010b.a(floatValue, this.f1009a);
        this.f1010b.a(floatValue, this.f1009a, false);
        this.f1010b.invalidateSelf();
    }
}
