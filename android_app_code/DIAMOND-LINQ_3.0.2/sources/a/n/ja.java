package a.n;

import android.view.View;
import android.view.WindowId;

class ja implements ka {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f314a;

    ja(View view) {
        this.f314a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ja) && ((ja) obj).f314a.equals(this.f314a);
    }

    public int hashCode() {
        return this.f314a.hashCode();
    }
}
