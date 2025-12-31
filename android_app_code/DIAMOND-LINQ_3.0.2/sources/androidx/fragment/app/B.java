package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

class B implements Parcelable.Creator<C> {
    B() {
    }

    public C createFromParcel(Parcel parcel) {
        return new C(parcel);
    }

    public C[] newArray(int i) {
        return new C[i];
    }
}
