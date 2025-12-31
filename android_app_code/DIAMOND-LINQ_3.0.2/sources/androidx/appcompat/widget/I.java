package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.E;

class I implements Parcelable.Creator<E.d> {
    I() {
    }

    public E.d createFromParcel(Parcel parcel) {
        return new E.d(parcel);
    }

    public E.d[] newArray(int i) {
        return new E.d[i];
    }
}
