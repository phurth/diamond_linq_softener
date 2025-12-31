package a.i.a;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    public static final c f246a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Parcelable f247b;

    /* synthetic */ c(a aVar) {
        this();
    }

    public final Parcelable a() {
        return this.f247b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f247b, i);
    }

    private c() {
        this.f247b = null;
    }

    protected c(Parcelable parcelable) {
        if (parcelable != null) {
            this.f247b = parcelable == f246a ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected c(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f247b = readParcelable == null ? f246a : readParcelable;
    }
}
