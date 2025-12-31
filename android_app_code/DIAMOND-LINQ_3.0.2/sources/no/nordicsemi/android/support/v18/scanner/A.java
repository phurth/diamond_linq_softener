package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

public final class A implements Parcelable {
    public static final Parcelable.Creator<A> CREATOR = new z();

    /* renamed from: a  reason: collision with root package name */
    private BluetoothDevice f1631a;

    /* renamed from: b  reason: collision with root package name */
    private y f1632b;
    private int c;
    private long d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    /* synthetic */ A(Parcel parcel, z zVar) {
        this(parcel);
    }

    private void a(Parcel parcel) {
        this.f1631a = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        if (parcel.readInt() == 1) {
            this.f1632b = y.a(parcel.createByteArray());
        }
        this.c = parcel.readInt();
        this.d = parcel.readLong();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }

    public int b() {
        return this.c;
    }

    public y c() {
        return this.f1632b;
    }

    public long d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || A.class != obj.getClass()) {
            return false;
        }
        A a2 = (A) obj;
        if (t.b(this.f1631a, a2.f1631a) && this.c == a2.c && t.b(this.f1632b, a2.f1632b) && this.d == a2.d && this.e == a2.e && this.f == a2.f && this.g == a2.g && this.h == a2.h && this.i == a2.i && this.j == a2.j) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return t.a(this.f1631a, Integer.valueOf(this.c), this.f1632b, Long.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j));
    }

    public String toString() {
        return "ScanResult{device=" + this.f1631a + ", scanRecord=" + t.a((Object) this.f1632b) + ", rssi=" + this.c + ", timestampNanos=" + this.d + ", eventType=" + this.e + ", primaryPhy=" + this.f + ", secondaryPhy=" + this.g + ", advertisingSid=" + this.h + ", txPower=" + this.i + ", periodicAdvertisingInterval=" + this.j + '}';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        this.f1631a.writeToParcel(parcel, i2);
        if (this.f1632b != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.f1632b.a());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }

    public A(BluetoothDevice bluetoothDevice, y yVar, int i2, long j2) {
        this.f1631a = bluetoothDevice;
        this.f1632b = yVar;
        this.c = i2;
        this.d = j2;
        this.e = 17;
        this.f = 1;
        this.g = 0;
        this.h = 255;
        this.i = 127;
        this.j = 0;
    }

    public BluetoothDevice a() {
        return this.f1631a;
    }

    public A(BluetoothDevice bluetoothDevice, int i2, int i3, int i4, int i5, int i6, int i7, int i8, y yVar, long j2) {
        this.f1631a = bluetoothDevice;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.c = i7;
        this.j = i8;
        this.f1632b = yVar;
        this.d = j2;
    }

    private A(Parcel parcel) {
        a(parcel);
    }
}
