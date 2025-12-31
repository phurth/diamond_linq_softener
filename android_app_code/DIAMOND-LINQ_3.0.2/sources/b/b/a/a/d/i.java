package b.b.a.a.d;

import android.os.Parcel;
import android.os.Parcelable;

class i implements Parcelable.Creator<j> {
    i() {
    }

    public j createFromParcel(Parcel parcel) {
        return new j(parcel);
    }

    public j[] newArray(int i) {
        return new j[i];
    }
}
