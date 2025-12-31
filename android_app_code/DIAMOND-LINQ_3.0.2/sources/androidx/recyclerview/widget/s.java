package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class s {

    /* renamed from: a  reason: collision with root package name */
    boolean f990a = true;

    /* renamed from: b  reason: collision with root package name */
    int f991b;
    int c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;

    s() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.u uVar) {
        int i2 = this.c;
        return i2 >= 0 && i2 < uVar.a();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f991b + ", mCurrentPosition=" + this.c + ", mItemDirection=" + this.d + ", mLayoutDirection=" + this.e + ", mStartLine=" + this.f + ", mEndLine=" + this.g + '}';
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.p pVar) {
        View d2 = pVar.d(this.c);
        this.c += this.d;
        return d2;
    }
}
