package androidx.versionedparcelable;

import a.d.b;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import no.nordicsemi.android.log.BuildConfig;

class c extends b {
    private final SparseIntArray d;
    private final Parcel e;
    private final int f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;

    c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), BuildConfig.FLAVOR, new b(), new b(), new b());
    }

    public boolean a(int i2) {
        while (this.j < this.g) {
            int i3 = this.k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            int readInt = this.e.readInt();
            this.k = this.e.readInt();
            this.j += readInt;
        }
        if (this.k == i2) {
            return true;
        }
        return false;
    }

    public void b(int i2) {
        a();
        this.i = i2;
        this.d.put(i2, this.e.dataPosition());
        c(0);
        c(i2);
    }

    public void c(int i2) {
        this.e.writeInt(i2);
    }

    public byte[] d() {
        int readInt = this.e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.e.readByteArray(bArr);
        return bArr;
    }

    public int e() {
        return this.e.readInt();
    }

    public <T extends Parcelable> T f() {
        return this.e.readParcelable(c.class.getClassLoader());
    }

    public String g() {
        return this.e.readString();
    }

    private c(Parcel parcel, int i2, int i3, String str, b<String, Method> bVar, b<String, Method> bVar2, b<String, Class> bVar3) {
        super(bVar, bVar2, bVar3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.e = parcel;
        this.f = i2;
        this.g = i3;
        this.j = this.f;
        this.h = str;
    }

    /* access modifiers changed from: protected */
    public b b() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.j;
        if (i2 == this.f) {
            i2 = this.g;
        }
        int i3 = i2;
        return new c(parcel, dataPosition, i3, this.h + "  ", this.f1027a, this.f1028b, this.c);
    }

    public void a() {
        int i2 = this.i;
        if (i2 >= 0) {
            int i3 = this.d.get(i2);
            int dataPosition = this.e.dataPosition();
            this.e.setDataPosition(i3);
            this.e.writeInt(dataPosition - i3);
            this.e.setDataPosition(dataPosition);
        }
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.e.writeInt(bArr.length);
            this.e.writeByteArray(bArr);
            return;
        }
        this.e.writeInt(-1);
    }

    public void a(String str) {
        this.e.writeString(str);
    }

    public void a(Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }
}
