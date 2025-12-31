package me.relex.circleindicator;

import androidx.viewpager.widget.ViewPager;

class b implements ViewPager.f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CircleIndicator f1566a;

    b(CircleIndicator circleIndicator) {
        this.f1566a = circleIndicator;
    }

    public void a(int i) {
    }

    public void a(int i, float f, int i2) {
    }

    public void b(int i) {
        if (this.f1566a.k.getAdapter() != null && this.f1566a.k.getAdapter().a() > 0) {
            this.f1566a.a(i);
            this.f1566a.j = i;
        }
    }
}
