package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.widget.NestedScrollView;

class h implements Parcelable.Creator<NestedScrollView.c> {
    h() {
    }

    public NestedScrollView.c createFromParcel(Parcel parcel) {
        return new NestedScrollView.c(parcel);
    }

    public NestedScrollView.c[] newArray(int i) {
        return new NestedScrollView.c[i];
    }
}
