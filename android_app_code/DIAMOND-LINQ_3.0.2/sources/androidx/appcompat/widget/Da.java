package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;

class Da implements Parcelable.ClassLoaderCreator<Toolbar.d> {
    Da() {
    }

    public Toolbar.d[] newArray(int i) {
        return new Toolbar.d[i];
    }

    public Toolbar.d createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Toolbar.d(parcel, classLoader);
    }

    public Toolbar.d createFromParcel(Parcel parcel) {
        return new Toolbar.d(parcel, (ClassLoader) null);
    }
}
