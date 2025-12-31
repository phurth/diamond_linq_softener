package no.nordicsemi.android.support.v18.scanner;

import android.os.Parcel;
import android.os.Parcelable;

class z implements Parcelable.Creator<A> {
    z() {
    }

    public A createFromParcel(Parcel parcel) {
        return new A(parcel, (z) null);
    }

    public A[] newArray(int i) {
        return new A[i];
    }
}
