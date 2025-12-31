package a.i.a;

import android.os.Parcel;
import android.os.Parcelable;

class b implements Parcelable.ClassLoaderCreator<c> {
    b() {
    }

    public c[] newArray(int i) {
        return new c[i];
    }

    public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return c.f246a;
        }
        throw new IllegalStateException("superState must be null");
    }

    public c createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
