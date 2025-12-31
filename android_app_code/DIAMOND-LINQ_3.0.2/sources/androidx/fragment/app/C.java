package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

@SuppressLint({"BanParcelableUsage"})
final class C implements Parcelable {
    public static final Parcelable.Creator<C> CREATOR = new B();

    /* renamed from: a  reason: collision with root package name */
    final String f765a;

    /* renamed from: b  reason: collision with root package name */
    final String f766b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    C0132h l;

    C(C0132h hVar) {
        this.f765a = hVar.getClass().getName();
        this.f766b = hVar.f;
        this.c = hVar.m;
        this.d = hVar.v;
        this.e = hVar.w;
        this.f = hVar.x;
        this.g = hVar.A;
        this.h = hVar.z;
        this.i = hVar.g;
        this.j = hVar.y;
    }

    public C0132h a(ClassLoader classLoader, C0137m mVar) {
        if (this.l == null) {
            Bundle bundle = this.i;
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
            }
            this.l = mVar.a(classLoader, this.f765a);
            this.l.m(this.i);
            Bundle bundle2 = this.k;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
                this.l.c = this.k;
            } else {
                this.l.c = new Bundle();
            }
            C0132h hVar = this.l;
            hVar.f = this.f766b;
            hVar.m = this.c;
            hVar.o = true;
            hVar.v = this.d;
            hVar.w = this.e;
            hVar.x = this.f;
            hVar.A = this.g;
            hVar.z = this.h;
            hVar.y = this.j;
            if (w.c) {
                Log.v("FragmentManager", "Instantiated fragment " + this.l);
            }
        }
        return this.l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f765a);
        parcel.writeString(this.f766b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
    }

    C(Parcel parcel) {
        this.f765a = parcel.readString();
        this.f766b = parcel.readString();
        boolean z = true;
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        this.j = parcel.readInt() == 0 ? false : z;
        this.k = parcel.readBundle();
    }
}
