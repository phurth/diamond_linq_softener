package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class b implements Parcelable.ClassLoaderCreator<CoordinatorLayout.g> {
    b() {
    }

    public CoordinatorLayout.g[] newArray(int i) {
        return new CoordinatorLayout.g[i];
    }

    public CoordinatorLayout.g createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout.g(parcel, classLoader);
    }

    public CoordinatorLayout.g createFromParcel(Parcel parcel) {
        return new CoordinatorLayout.g(parcel, (ClassLoader) null);
    }
}
