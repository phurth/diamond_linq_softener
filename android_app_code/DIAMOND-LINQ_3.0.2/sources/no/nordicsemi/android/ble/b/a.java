package no.nordicsemi.android.ble.b;

import android.os.Parcel;
import android.os.Parcelable;

class a implements Parcelable.Creator<b> {
    a() {
    }

    public b createFromParcel(Parcel parcel) {
        return new b(parcel);
    }

    public b[] newArray(int i) {
        return new b[i];
    }
}
