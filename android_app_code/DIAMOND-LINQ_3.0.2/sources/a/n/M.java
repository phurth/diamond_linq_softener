package a.n;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f285a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f286b;
    final ArrayList<E> c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof M)) {
            return false;
        }
        M m = (M) obj;
        return this.f286b == m.f286b && this.f285a.equals(m.f285a);
    }

    public int hashCode() {
        return (this.f286b.hashCode() * 31) + this.f285a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f286b + "\n") + "    values:";
        for (String next : this.f285a.keySet()) {
            str = str + "    " + next + ": " + this.f285a.get(next) + "\n";
        }
        return str;
    }
}
