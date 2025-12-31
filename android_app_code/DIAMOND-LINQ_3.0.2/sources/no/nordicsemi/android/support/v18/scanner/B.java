package no.nordicsemi.android.support.v18.scanner;

import android.os.Parcel;
import android.os.Parcelable;

class B implements Parcelable.Creator<C> {
    B() {
    }

    public C createFromParcel(Parcel parcel) {
        return new C(parcel, (B) null);
    }

    public C[] newArray(int i) {
        return new C[i];
    }
}
