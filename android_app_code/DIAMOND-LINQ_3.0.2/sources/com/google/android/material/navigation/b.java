package com.google.android.material.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.navigation.NavigationView;

class b implements Parcelable.ClassLoaderCreator<NavigationView.b> {
    b() {
    }

    public NavigationView.b[] newArray(int i) {
        return new NavigationView.b[i];
    }

    public NavigationView.b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new NavigationView.b(parcel, classLoader);
    }

    public NavigationView.b createFromParcel(Parcel parcel) {
        return new NavigationView.b(parcel, (ClassLoader) null);
    }
}
