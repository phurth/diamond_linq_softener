package a.n;

import android.os.IBinder;

class ia implements ka {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f311a;

    ia(IBinder iBinder) {
        this.f311a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ia) && ((ia) obj).f311a.equals(this.f311a);
    }

    public int hashCode() {
        return this.f311a.hashCode();
    }
}
