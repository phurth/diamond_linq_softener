package b.b.a.a.d;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;

public class j extends f implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private float f1240a = 0.0f;

    public j() {
    }

    public float d() {
        return this.f1240a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Entry, x: " + this.f1240a + " y: " + c();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f1240a);
        parcel.writeFloat(c());
        if (a() == null) {
            parcel.writeInt(0);
        } else if (a() instanceof Parcelable) {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) a(), i);
        } else {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
    }

    public j(float f, float f2) {
        super(f2);
        this.f1240a = f;
    }

    protected j(Parcel parcel) {
        this.f1240a = parcel.readFloat();
        a(parcel.readFloat());
        if (parcel.readInt() == 1) {
            a((Object) parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
