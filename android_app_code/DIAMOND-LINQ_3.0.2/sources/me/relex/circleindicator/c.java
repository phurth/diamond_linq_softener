package me.relex.circleindicator;

import android.database.DataSetObserver;
import androidx.viewpager.widget.a;

class c extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CircleIndicator f1567a;

    c(CircleIndicator circleIndicator) {
        this.f1567a = circleIndicator;
    }

    public void onChanged() {
        super.onChanged();
        if (this.f1567a.k != null) {
            a adapter = this.f1567a.k.getAdapter();
            int a2 = adapter != null ? adapter.a() : 0;
            if (a2 != this.f1567a.getChildCount()) {
                CircleIndicator circleIndicator = this.f1567a;
                if (circleIndicator.j < a2) {
                    circleIndicator.j = circleIndicator.k.getCurrentItem();
                } else {
                    circleIndicator.j = -1;
                }
                this.f1567a.a();
            }
        }
    }
}
