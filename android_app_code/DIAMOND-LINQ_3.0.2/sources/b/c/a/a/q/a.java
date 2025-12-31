package b.c.a.a.q;

import android.os.Parcel;
import android.os.Parcelable;

class a implements Parcelable.ClassLoaderCreator<b> {
    a() {
    }

    public b[] newArray(int i) {
        return new b[i];
    }

    public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new b(parcel, classLoader, (a) null);
    }

    public b createFromParcel(Parcel parcel) {
        return new b(parcel, (ClassLoader) null, (a) null);
    }
}
