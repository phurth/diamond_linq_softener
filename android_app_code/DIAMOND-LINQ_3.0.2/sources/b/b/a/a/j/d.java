package b.b.a.a.j;

import android.os.Parcel;
import android.os.Parcelable;

class d implements Parcelable.Creator<e> {
    d() {
    }

    public e createFromParcel(Parcel parcel) {
        e eVar = new e(0.0f, 0.0f);
        eVar.a(parcel);
        return eVar;
    }

    public e[] newArray(int i) {
        return new e[i];
    }
}
