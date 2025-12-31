package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;

class x implements Parcelable.Creator<y> {
    x() {
    }

    public y createFromParcel(Parcel parcel) {
        return new y(parcel);
    }

    public y[] newArray(int i) {
        return new y[i];
    }
}
