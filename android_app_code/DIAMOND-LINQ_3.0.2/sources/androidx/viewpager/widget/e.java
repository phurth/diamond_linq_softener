package androidx.viewpager.widget;

import a.g.i.I;
import a.g.i.q;
import a.g.i.y;
import android.graphics.Rect;
import android.view.View;

class e implements q {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f1041a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ViewPager f1042b;

    e(ViewPager viewPager) {
        this.f1042b = viewPager;
    }

    public I a(View view, I i) {
        I b2 = y.b(view, i);
        if (b2.g()) {
            return b2;
        }
        Rect rect = this.f1041a;
        rect.left = b2.c();
        rect.top = b2.e();
        rect.right = b2.d();
        rect.bottom = b2.b();
        int childCount = this.f1042b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            I a2 = y.a(this.f1042b.getChildAt(i2), b2);
            rect.left = Math.min(a2.c(), rect.left);
            rect.top = Math.min(a2.e(), rect.top);
            rect.right = Math.min(a2.d(), rect.right);
            rect.bottom = Math.min(a2.b(), rect.bottom);
        }
        return b2.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
