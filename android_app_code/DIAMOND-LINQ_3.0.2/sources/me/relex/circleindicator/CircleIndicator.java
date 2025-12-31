package me.relex.circleindicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;

public class CircleIndicator extends a {
    /* access modifiers changed from: private */
    public ViewPager k;
    private final ViewPager.f l = new b(this);
    private final DataSetObserver m = new c(this);

    public CircleIndicator(Context context) {
        super(context);
    }

    public /* bridge */ /* synthetic */ void c(d dVar) {
        super.c(dVar);
    }

    public DataSetObserver getDataSetObserver() {
        return this.m;
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.f fVar) {
        ViewPager viewPager = this.k;
        if (viewPager != null) {
            viewPager.b(fVar);
            this.k.a(fVar);
            return;
        }
        throw new NullPointerException("can not find Viewpager , setViewPager first");
    }

    public void setViewPager(ViewPager viewPager) {
        this.k = viewPager;
        ViewPager viewPager2 = this.k;
        if (viewPager2 != null && viewPager2.getAdapter() != null) {
            this.j = -1;
            a();
            this.k.b(this.l);
            this.k.a(this.l);
            this.l.b(this.k.getCurrentItem());
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        int a2;
        removeAllViews();
        a adapter = this.k.getAdapter();
        if (adapter != null && (a2 = adapter.a()) > 0) {
            a(a2, this.k.getCurrentItem());
        }
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public CircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
