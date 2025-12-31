package androidx.appcompat.widget;

import a.g.a.a.h;
import android.graphics.Typeface;
import android.os.Build;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class K extends h.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f528a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f529b;
    final /* synthetic */ WeakReference c;
    final /* synthetic */ L d;

    K(L l, int i, int i2, WeakReference weakReference) {
        this.d = l;
        this.f528a = i;
        this.f529b = i2;
        this.c = weakReference;
    }

    public void a(int i) {
    }

    public void a(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.f528a) != -1) {
            typeface = Typeface.create(typeface, i, (this.f529b & 2) != 0);
        }
        this.d.a((WeakReference<TextView>) this.c, typeface);
    }
}
