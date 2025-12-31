package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public final class x implements Parcelable {
    public static final Parcelable.Creator<x> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private static final x f1664a = new a().a();

    /* renamed from: b  reason: collision with root package name */
    private final String f1665b;
    private final String c;
    private final ParcelUuid d;
    private final ParcelUuid e;
    private final ParcelUuid f;
    private final byte[] g;
    private final byte[] h;
    private final int i;
    private final byte[] j;
    private final byte[] k;

    /* synthetic */ x(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, w wVar) {
        this(str, str2, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i2, bArr3, bArr4);
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.f1665b;
    }

    public byte[] c() {
        return this.j;
    }

    public byte[] d() {
        return this.k;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        if (!t.b(this.f1665b, xVar.f1665b) || !t.b(this.c, xVar.c) || this.i != xVar.i || !t.a(this.j, xVar.j) || !t.a(this.k, xVar.k) || !t.b(this.f, xVar.f) || !t.a(this.g, xVar.g) || !t.a(this.h, xVar.h) || !t.b(this.d, xVar.d) || !t.b(this.e, xVar.e)) {
            return false;
        }
        return true;
    }

    public byte[] f() {
        return this.g;
    }

    public byte[] g() {
        return this.h;
    }

    public ParcelUuid h() {
        return this.f;
    }

    public int hashCode() {
        return t.a(this.f1665b, this.c, Integer.valueOf(this.i), Integer.valueOf(Arrays.hashCode(this.j)), Integer.valueOf(Arrays.hashCode(this.k)), this.f, Integer.valueOf(Arrays.hashCode(this.g)), Integer.valueOf(Arrays.hashCode(this.h)), this.d, this.e);
    }

    public ParcelUuid i() {
        return this.d;
    }

    public ParcelUuid j() {
        return this.e;
    }

    public String toString() {
        return "BluetoothLeScanFilter [deviceName=" + this.f1665b + ", deviceAddress=" + this.c + ", mUuid=" + this.d + ", uuidMask=" + this.e + ", serviceDataUuid=" + t.a((Object) this.f) + ", serviceData=" + Arrays.toString(this.g) + ", serviceDataMask=" + Arrays.toString(this.h) + ", manufacturerId=" + this.i + ", manufacturerData=" + Arrays.toString(this.j) + ", manufacturerDataMask=" + Arrays.toString(this.k) + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3 = 0;
        parcel.writeInt(this.f1665b == null ? 0 : 1);
        String str = this.f1665b;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.c == null ? 0 : 1);
        String str2 = this.c;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.d == null ? 0 : 1);
        ParcelUuid parcelUuid = this.d;
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, i2);
            parcel.writeInt(this.e == null ? 0 : 1);
            ParcelUuid parcelUuid2 = this.e;
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, i2);
            }
        }
        parcel.writeInt(this.f == null ? 0 : 1);
        ParcelUuid parcelUuid3 = this.f;
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, i2);
            parcel.writeInt(this.g == null ? 0 : 1);
            byte[] bArr = this.g;
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.g);
                parcel.writeInt(this.h == null ? 0 : 1);
                byte[] bArr2 = this.h;
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(this.h);
                }
            }
        }
        parcel.writeInt(this.i);
        parcel.writeInt(this.j == null ? 0 : 1);
        byte[] bArr3 = this.j;
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(this.j);
            if (this.k != null) {
                i3 = 1;
            }
            parcel.writeInt(i3);
            byte[] bArr4 = this.k;
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(this.k);
            }
        }
    }

    private x(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4) {
        this.f1665b = str;
        this.d = parcelUuid;
        this.e = parcelUuid2;
        this.c = str2;
        this.f = parcelUuid3;
        this.g = bArr;
        this.h = bArr2;
        this.i = i2;
        this.j = bArr3;
        this.k = bArr4;
    }

    public boolean a(A a2) {
        if (a2 == null) {
            return false;
        }
        BluetoothDevice a3 = a2.a();
        String str = this.c;
        if (str != null && !str.equals(a3.getAddress())) {
            return false;
        }
        y c2 = a2.c();
        if (c2 == null && (this.f1665b != null || this.d != null || this.j != null || this.g != null)) {
            return false;
        }
        String str2 = this.f1665b;
        if (str2 != null && !str2.equals(c2.b())) {
            return false;
        }
        ParcelUuid parcelUuid = this.d;
        if (parcelUuid != null && !a(parcelUuid, this.e, c2.c())) {
            return false;
        }
        ParcelUuid parcelUuid2 = this.f;
        if (parcelUuid2 != null && c2 != null && !a(this.g, this.h, c2.a(parcelUuid2))) {
            return false;
        }
        int i2 = this.i;
        if (i2 < 0 || c2 == null || a(this.j, this.k, c2.a(i2))) {
            return true;
        }
        return false;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f1666a;

        /* renamed from: b  reason: collision with root package name */
        private String f1667b;
        private ParcelUuid c;
        private ParcelUuid d;
        private ParcelUuid e;
        private byte[] f;
        private byte[] g;
        private int h = -1;
        private byte[] i;
        private byte[] j;

        public a a(String str) {
            if (str == null || BluetoothAdapter.checkBluetoothAddress(str)) {
                this.f1667b = str;
                return this;
            }
            throw new IllegalArgumentException("invalid device address " + str);
        }

        public a b(String str) {
            this.f1666a = str;
            return this;
        }

        public a a(ParcelUuid parcelUuid) {
            this.c = parcelUuid;
            this.d = null;
            return this;
        }

        public a a(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (parcelUuid2 == null || parcelUuid != null) {
                this.c = parcelUuid;
                this.d = parcelUuid2;
                return this;
            }
            throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
        }

        public a a(ParcelUuid parcelUuid, byte[] bArr) {
            if (parcelUuid == null && bArr != null) {
                throw new IllegalArgumentException("serviceDataUuid is null!");
            } else if (parcelUuid == null || bArr != null) {
                this.e = parcelUuid;
                this.f = bArr;
                this.g = null;
                return this;
            } else {
                throw new IllegalArgumentException("serviceData is null!");
            }
        }

        public a a(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
            if (parcelUuid != null || bArr == null) {
                if (bArr2 != null) {
                    if (bArr == null) {
                        throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                    } else if (bArr.length != bArr2.length) {
                        throw new IllegalArgumentException("size mismatch for service data and service data mask");
                    }
                }
                this.e = parcelUuid;
                this.f = bArr;
                this.g = bArr2;
                return this;
            }
            throw new IllegalArgumentException("serviceDataUuid is null");
        }

        public a a(int i2, byte[] bArr) {
            if (bArr == null || i2 >= 0) {
                this.h = i2;
                this.i = bArr;
                this.j = null;
                return this;
            }
            throw new IllegalArgumentException("invalid manufacture id");
        }

        public a a(int i2, byte[] bArr, byte[] bArr2) {
            if (bArr == null || i2 >= 0) {
                if (bArr2 != null) {
                    if (bArr == null) {
                        throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                    } else if (bArr.length != bArr2.length) {
                        throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                    }
                }
                this.h = i2;
                this.i = bArr;
                this.j = bArr2;
                return this;
            }
            throw new IllegalArgumentException("invalid manufacture id");
        }

        public x a() {
            return new x(this.f1666a, this.f1667b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, (w) null);
        }
    }

    private static boolean a(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List<ParcelUuid> list) {
        UUID uuid;
        if (parcelUuid == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        for (ParcelUuid next : list) {
            if (parcelUuid2 == null) {
                uuid = null;
            } else {
                uuid = parcelUuid2.getUuid();
            }
            if (a(parcelUuid.getUuid(), uuid, next.getUuid())) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(UUID uuid, UUID uuid2, UUID uuid3) {
        if (uuid2 == null) {
            return uuid.equals(uuid3);
        }
        if ((uuid.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) != (uuid3.getLeastSignificantBits() & uuid2.getLeastSignificantBits())) {
            return false;
        }
        if ((uuid.getMostSignificantBits() & uuid2.getMostSignificantBits()) == (uuid2.getMostSignificantBits() & uuid3.getMostSignificantBits())) {
            return true;
        }
        return false;
    }

    private boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return bArr3 != null;
        }
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        if (bArr2 == null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr3[i2] != bArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if ((bArr2[i3] & bArr3[i3]) != (bArr2[i3] & bArr[i3])) {
                return false;
            }
        }
        return true;
    }
}
