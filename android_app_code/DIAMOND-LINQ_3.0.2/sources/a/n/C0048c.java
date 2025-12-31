package a.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: a.n.c  reason: case insensitive filesystem */
class C0048c extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f300a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BitmapDrawable f301b;
    final /* synthetic */ View c;
    final /* synthetic */ float d;
    final /* synthetic */ C0058m e;

    C0048c(C0058m mVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
        this.e = mVar;
        this.f300a = viewGroup;
        this.f301b = bitmapDrawable;
        this.c = view;
        this.d = f;
    }

    public void onAnimationEnd(Animator animator) {
        ba.b(this.f300a).b(this.f301b);
        ba.a(this.c, this.d);
    }
}
