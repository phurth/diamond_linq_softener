package androidx.cardview.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f664a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ CardView f665b;

    a(CardView cardView) {
        this.f665b = cardView;
    }

    public void a(Drawable drawable) {
        this.f664a = drawable;
        this.f665b.setBackgroundDrawable(drawable);
    }

    public boolean b() {
        return this.f665b.getUseCompatPadding();
    }

    public Drawable c() {
        return this.f664a;
    }

    public View d() {
        return this.f665b;
    }

    public boolean a() {
        return this.f665b.getPreventCornerOverlap();
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f665b.h.set(i, i2, i3, i4);
        CardView cardView = this.f665b;
        Rect rect = cardView.g;
        a.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    public void a(int i, int i2) {
        CardView cardView = this.f665b;
        if (i > cardView.e) {
            a.super.setMinimumWidth(i);
        }
        CardView cardView2 = this.f665b;
        if (i2 > cardView2.f) {
            a.super.setMinimumHeight(i2);
        }
    }
}
