package com.google.android.material.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

class d implements Parcelable.ClassLoaderCreator<BottomSheetBehavior.b> {
    d() {
    }

    public BottomSheetBehavior.b[] newArray(int i) {
        return new BottomSheetBehavior.b[i];
    }

    public BottomSheetBehavior.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new BottomSheetBehavior.b(parcel, classLoader);
    }

    public BottomSheetBehavior.b createFromParcel(Parcel parcel) {
        return new BottomSheetBehavior.b(parcel, (ClassLoader) null);
    }
}
