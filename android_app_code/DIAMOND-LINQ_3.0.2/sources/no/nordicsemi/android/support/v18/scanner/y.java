package no.nordicsemi.android.support.v18.scanner;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private final int f1668a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ParcelUuid> f1669b;
    private final SparseArray<byte[]> c;
    private final Map<ParcelUuid, byte[]> d;
    private final int e;
    private final String f;
    private final byte[] g;

    private y(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.f1669b = list;
        this.c = sparseArray;
        this.d = map;
        this.f = str;
        this.f1668a = i;
        this.e = i2;
        this.g = bArr;
    }

    public byte[] a(int i) {
        SparseArray<byte[]> sparseArray = this.c;
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    public String b() {
        return this.f;
    }

    public List<ParcelUuid> c() {
        return this.f1669b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.g, ((y) obj).g);
    }

    public String toString() {
        return "ScanRecord [advertiseFlags=" + this.f1668a + ", serviceUuids=" + this.f1669b + ", manufacturerSpecificData=" + r.a(this.c) + ", serviceData=" + r.a(this.d) + ", txPowerLevel=" + this.e + ", deviceName=" + this.f + "]";
    }

    public byte[] a(ParcelUuid parcelUuid) {
        Map<ParcelUuid, byte[]> map;
        if (parcelUuid == null || (map = this.d) == null) {
            return null;
        }
        return map.get(parcelUuid);
    }

    public byte[] a() {
        return this.g;
    }

    static y a(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return null;
        }
        int i = 0;
        ArrayList arrayList = null;
        SparseArray sparseArray = null;
        String str = null;
        HashMap hashMap = null;
        byte b2 = -1;
        byte b3 = -2147483648;
        while (true) {
            try {
                if (i < bArr2.length) {
                    int i2 = i + 1;
                    byte b4 = bArr2[i] & 255;
                    if (b4 != 0) {
                        int i3 = b4 - 1;
                        int i4 = i2 + 1;
                        byte b5 = bArr2[i2] & 255;
                        if (b5 != 22) {
                            if (b5 != 255) {
                                if (!(b5 == 32 || b5 == 33)) {
                                    switch (b5) {
                                        case 1:
                                            b2 = bArr2[i4] & 255;
                                            break;
                                        case 2:
                                        case 3:
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            a(bArr2, i4, i3, 2, arrayList);
                                            break;
                                        case 4:
                                        case 5:
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            a(bArr2, i4, i3, 4, arrayList);
                                            break;
                                        case 6:
                                        case 7:
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            a(bArr2, i4, i3, 16, arrayList);
                                            break;
                                        case 8:
                                        case 9:
                                            str = new String(a(bArr2, i4, i3));
                                            break;
                                        case 10:
                                            b3 = bArr2[i4];
                                            break;
                                    }
                                }
                            } else {
                                int i5 = ((bArr2[i4 + 1] & 255) << 8) + (255 & bArr2[i4]);
                                byte[] a2 = a(bArr2, i4 + 2, i3 - 2);
                                if (sparseArray == null) {
                                    sparseArray = new SparseArray();
                                }
                                sparseArray.put(i5, a2);
                            }
                            i = i3 + i4;
                        }
                        int i6 = 4;
                        if (b5 != 32) {
                            i6 = b5 == 33 ? 16 : 2;
                        }
                        ParcelUuid a3 = s.a(a(bArr2, i4, i6));
                        byte[] a4 = a(bArr2, i4 + i6, i3 - i6);
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        hashMap.put(a3, a4);
                        i = i3 + i4;
                    }
                }
            } catch (Exception unused) {
                Log.e("ScanRecord", "unable to parse scan record: " + Arrays.toString(bArr));
                return new y((List<ParcelUuid>) null, (SparseArray<byte[]>) null, (Map<ParcelUuid, byte[]>) null, -1, Integer.MIN_VALUE, (String) null, bArr);
            }
        }
        return new y(arrayList, sparseArray, hashMap, b2, b3, str, bArr);
    }

    private static int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(s.a(a(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
