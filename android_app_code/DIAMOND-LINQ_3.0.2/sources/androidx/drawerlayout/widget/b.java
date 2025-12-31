package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.drawerlayout.widget.DrawerLayout;

class b implements Parcelable.ClassLoaderCreator<DrawerLayout.e> {
    b() {
    }

    public DrawerLayout.e[] newArray(int i) {
        return new DrawerLayout.e[i];
    }

    public DrawerLayout.e createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new DrawerLayout.e(parcel, classLoader);
    }

    public DrawerLayout.e createFromParcel(Parcel parcel) {
        return new DrawerLayout.e(parcel, (ClassLoader) null);
    }
}
