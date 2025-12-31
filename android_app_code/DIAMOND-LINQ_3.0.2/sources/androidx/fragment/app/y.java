package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<C> f838a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f839b;
    C0127c[] c;
    String d = null;
    int e;

    public y() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f838a);
        parcel.writeStringList(this.f839b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
    }

    public y(Parcel parcel) {
        this.f838a = parcel.createTypedArrayList(C.CREATOR);
        this.f839b = parcel.createStringArrayList();
        this.c = (C0127c[]) parcel.createTypedArray(C0127c.CREATOR);
        this.d = parcel.readString();
        this.e = parcel.readInt();
    }
}
