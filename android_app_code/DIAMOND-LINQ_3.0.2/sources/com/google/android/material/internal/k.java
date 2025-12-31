package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;

class k implements Parcelable.ClassLoaderCreator<l> {
    k() {
    }

    public l[] newArray(int i) {
        return new l[i];
    }

    public l createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new l(parcel, classLoader);
    }

    public l createFromParcel(Parcel parcel) {
        return new l(parcel, (ClassLoader) null);
    }
}
