package androidx.viewpager.widget;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewPager f1040a;

    d(ViewPager viewPager) {
        this.f1040a = viewPager;
    }

    public void run() {
        this.f1040a.setScrollState(0);
        this.f1040a.e();
    }
}
