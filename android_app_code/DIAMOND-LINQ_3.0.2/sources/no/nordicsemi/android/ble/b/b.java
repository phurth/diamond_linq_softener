package no.nordicsemi.android.ble.b;

import android.os.Parcel;
import android.os.Parcelable;
import no.nordicsemi.android.log.BuildConfig;

public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private static char[] f1585a = "0123456789ABCDEF".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f1586b;

    public b(byte[] bArr) {
        this.f1586b = bArr;
    }

    private static int a(byte b2) {
        return b2 & 255;
    }

    public static int a(int i) {
        return i & 15;
    }

    private static int b(int i, int i2) {
        int i3 = 1 << (i2 - 1);
        return (i & i3) != 0 ? (i3 - (i & (i3 - 1))) * -1 : i;
    }

    public byte[] a() {
        return this.f1586b;
    }

    public int b() {
        byte[] bArr = this.f1586b;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        if (b() == 0) {
            return BuildConfig.FLAVOR;
        }
        char[] cArr = new char[((this.f1586b.length * 3) - 1)];
        int i = 0;
        while (true) {
            byte[] bArr = this.f1586b;
            if (i < bArr.length) {
                byte b2 = bArr[i] & 255;
                int i2 = i * 3;
                char[] cArr2 = f1585a;
                cArr[i2] = cArr2[b2 >>> 4];
                cArr[i2 + 1] = cArr2[b2 & 15];
                if (i != bArr.length - 1) {
                    cArr[i2 + 2] = '-';
                }
                i++;
            } else {
                return "(0x) " + new String(cArr);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.f1586b);
    }

    public Integer a(int i, int i2) {
        if (a(i) + i2 > b()) {
            return null;
        }
        switch (i) {
            case 17:
                return Integer.valueOf(a(this.f1586b[i2]));
            case 18:
                byte[] bArr = this.f1586b;
                return Integer.valueOf(a(bArr[i2], bArr[i2 + 1]));
            case 19:
                byte[] bArr2 = this.f1586b;
                return Integer.valueOf(a(bArr2[i2], bArr2[i2 + 1], bArr2[i2 + 2], (byte) 0));
            case 20:
                byte[] bArr3 = this.f1586b;
                return Integer.valueOf(a(bArr3[i2], bArr3[i2 + 1], bArr3[i2 + 2], bArr3[i2 + 3]));
            default:
                switch (i) {
                    case 33:
                        return Integer.valueOf(b(a(this.f1586b[i2]), 8));
                    case 34:
                        byte[] bArr4 = this.f1586b;
                        return Integer.valueOf(b(a(bArr4[i2], bArr4[i2 + 1]), 16));
                    case 35:
                        byte[] bArr5 = this.f1586b;
                        return Integer.valueOf(b(a(bArr5[i2], bArr5[i2 + 1], bArr5[i2 + 2], (byte) 0), 24));
                    case 36:
                        byte[] bArr6 = this.f1586b;
                        return Integer.valueOf(b(a(bArr6[i2], bArr6[i2 + 1], bArr6[i2 + 2], bArr6[i2 + 3]), 32));
                    default:
                        return null;
                }
        }
    }

    protected b(Parcel parcel) {
        this.f1586b = parcel.createByteArray();
    }

    private static int a(byte b2, byte b3) {
        return a(b2) + (a(b3) << 8);
    }

    private static int a(byte b2, byte b3, byte b4, byte b5) {
        return a(b2) + (a(b3) << 8) + (a(b4) << 16) + (a(b5) << 24);
    }
}
