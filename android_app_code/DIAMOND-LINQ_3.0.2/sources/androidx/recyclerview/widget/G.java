package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;

class G implements Parcelable.ClassLoaderCreator<RecyclerView.s> {
    G() {
    }

    public RecyclerView.s[] newArray(int i) {
        return new RecyclerView.s[i];
    }

    public RecyclerView.s createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView.s(parcel, classLoader);
    }

    public RecyclerView.s createFromParcel(Parcel parcel) {
        return new RecyclerView.s(parcel, (ClassLoader) null);
    }
}
