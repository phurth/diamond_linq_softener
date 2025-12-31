package b.a.a;

import android.content.Context;
import android.graphics.drawable.Drawable;

public final class K {

    /* renamed from: a  reason: collision with root package name */
    private final String f1056a;

    /* renamed from: b  reason: collision with root package name */
    private final Drawable f1057b;

    public K(Context context, String str, int i) {
        this.f1056a = str;
        this.f1057b = context.getResources().getDrawable(i);
    }

    public Drawable a() {
        return this.f1057b;
    }

    public String b() {
        return this.f1056a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof K)) {
            return false;
        }
        return this.f1056a.equals(((K) obj).b());
    }
}
