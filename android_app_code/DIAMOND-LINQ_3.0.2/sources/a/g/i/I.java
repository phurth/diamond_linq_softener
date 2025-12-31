package a.g.i;

import android.os.Build;
import android.view.WindowInsets;

public class I {

    /* renamed from: a  reason: collision with root package name */
    private final Object f204a;

    private I(Object obj) {
        this.f204a = obj;
    }

    public I a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new I(((WindowInsets) this.f204a).consumeSystemWindowInsets());
        }
        return null;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f204a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f204a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f204a).getSystemWindowInsetRight();
        }
        return 0;
    }

    public int e() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f204a).getSystemWindowInsetTop();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || I.class != obj.getClass()) {
            return false;
        }
        I i = (I) obj;
        Object obj2 = this.f204a;
        if (obj2 != null) {
            return obj2.equals(i.f204a);
        }
        if (i.f204a == null) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f204a).hasSystemWindowInsets();
        }
        return false;
    }

    public boolean g() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f204a).isConsumed();
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f204a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public I a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new I(((WindowInsets) this.f204a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    static I a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new I(obj);
    }

    static Object a(I i) {
        if (i == null) {
            return null;
        }
        return i.f204a;
    }
}
