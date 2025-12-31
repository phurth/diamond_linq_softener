package no.nordicsemi.android.support.v18.scanner;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import no.nordicsemi.android.support.v18.scanner.x;

class w implements Parcelable.Creator<x> {
    w() {
    }

    public x createFromParcel(Parcel parcel) {
        x.a aVar = new x.a();
        if (parcel.readInt() == 1) {
            aVar.b(parcel.readString());
        }
        if (parcel.readInt() == 1) {
            aVar.a(parcel.readString());
        }
        if (parcel.readInt() == 1) {
            ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
            aVar.a(parcelUuid);
            if (parcel.readInt() == 1) {
                aVar.a(parcelUuid, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
            }
        }
        if (parcel.readInt() == 1) {
            ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
            if (parcel.readInt() == 1) {
                byte[] bArr = new byte[parcel.readInt()];
                parcel.readByteArray(bArr);
                if (parcel.readInt() == 0) {
                    aVar.a(parcelUuid2, bArr);
                } else {
                    byte[] bArr2 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr2);
                    aVar.a(parcelUuid2, bArr, bArr2);
                }
            }
        }
        int readInt = parcel.readInt();
        if (parcel.readInt() == 1) {
            byte[] bArr3 = new byte[parcel.readInt()];
            parcel.readByteArray(bArr3);
            if (parcel.readInt() == 0) {
                aVar.a(readInt, bArr3);
            } else {
                byte[] bArr4 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr4);
                aVar.a(readInt, bArr3, bArr4);
            }
        }
        return aVar.a();
    }

    public x[] newArray(int i) {
        return new x[i];
    }
}
