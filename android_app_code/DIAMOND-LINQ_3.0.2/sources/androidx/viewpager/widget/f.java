package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager.widget.ViewPager;

class f implements Parcelable.ClassLoaderCreator<ViewPager.i> {
    f() {
    }

    public ViewPager.i[] newArray(int i) {
        return new ViewPager.i[i];
    }

    public ViewPager.i createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.i(parcel, classLoader);
    }

    public ViewPager.i createFromParcel(Parcel parcel) {
        return new ViewPager.i(parcel, (ClassLoader) null);
    }
}
