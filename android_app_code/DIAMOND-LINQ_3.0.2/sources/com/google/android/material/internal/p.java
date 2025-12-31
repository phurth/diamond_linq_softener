package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f1524a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private a f1525b = null;
    ValueAnimator c = null;
    private final Animator.AnimatorListener d = new o(this);

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f1526a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f1527b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f1526a = iArr;
            this.f1527b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.c = null;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.f1524a.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.f1524a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f1524a.get(i);
            if (StateSet.stateSetMatches(aVar.f1526a, iArr)) {
                break;
            }
            i++;
        }
        a aVar2 = this.f1525b;
        if (aVar != aVar2) {
            if (aVar2 != null) {
                b();
            }
            this.f1525b = aVar;
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    private void a(a aVar) {
        this.c = aVar.f1527b;
        this.c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.c = null;
        }
    }
}
