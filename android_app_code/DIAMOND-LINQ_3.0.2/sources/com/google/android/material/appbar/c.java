package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.appbar.AppBarLayout;

class c implements Parcelable.ClassLoaderCreator<AppBarLayout.BaseBehavior.b> {
    c() {
    }

    public AppBarLayout.BaseBehavior.b[] newArray(int i) {
        return new AppBarLayout.BaseBehavior.b[i];
    }

    public AppBarLayout.BaseBehavior.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new AppBarLayout.BaseBehavior.b(parcel, classLoader);
    }

    public AppBarLayout.BaseBehavior.b createFromParcel(Parcel parcel) {
        return new AppBarLayout.BaseBehavior.b(parcel, (ClassLoader) null);
    }
}
