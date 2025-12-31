package b.c.a.a.q;

import a.d.i;
import a.i.a.c;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class b extends c {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final i<String, Bundle> f1341a;

    /* synthetic */ b(Parcel parcel, ClassLoader classLoader, a aVar) {
        this(parcel, classLoader);
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f1341a + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.f1341a.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.f1341a.b(i2);
            bundleArr[i2] = this.f1341a.d(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public b(Parcelable parcelable) {
        super(parcelable);
        this.f1341a = new i<>();
    }

    private b(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f1341a = new i<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f1341a.put(strArr[i], bundleArr[i]);
        }
    }
}
