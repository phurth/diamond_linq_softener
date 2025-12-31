package a.n;

import a.g.i.y;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;

/* renamed from: a.n.k  reason: case insensitive filesystem */
class C0056k extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f315a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ View f316b;
    final /* synthetic */ Rect c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ C0058m h;

    C0056k(C0058m mVar, View view, Rect rect, int i, int i2, int i3, int i4) {
        this.h = mVar;
        this.f316b = view;
        this.c = rect;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }

    public void onAnimationCancel(Animator animator) {
        this.f315a = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.f315a) {
            y.a(this.f316b, this.c);
            ba.a(this.f316b, this.d, this.e, this.f, this.g);
        }
    }
}
