package b.a.a.c;

import b.a.a.na;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class u {
    public static List<t> a(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (bArr.length == 0) {
            return arrayList;
        }
        int i = 0;
        boolean z = false;
        while (true) {
            try {
                if (i >= bArr.length) {
                    break;
                }
                int i2 = i + 1;
                byte b2 = bArr[i] & 255;
                v a2 = v.a(bArr[i2] & 255);
                if (b2 == 0) {
                    break;
                } else if (a2 == v.Unknown) {
                    break;
                } else {
                    int i3 = i2 + 1;
                    int i4 = i2 + b2;
                    byte[] copyOfRange = Arrays.copyOfRange(bArr, i3, i4);
                    if (copyOfRange != null && copyOfRange.length > 0) {
                        if (!na.a(copyOfRange) || a2 != v.DataTypeManufacturerSpecificData) {
                            arrayList.add(new t(a2, b2, copyOfRange));
                        } else {
                            for (int i5 = z ? 2 : 0; i5 < copyOfRange.length; i5++) {
                                arrayList2.add(Byte.valueOf(copyOfRange[i5]));
                            }
                            z = true;
                        }
                    }
                    i = i4;
                }
            } catch (Exception unused) {
            }
        }
        if (z) {
            v vVar = v.DataTypeManufacturerSpecificData;
            int size = arrayList2.size();
            byte[] bArr2 = new byte[size];
            for (int i6 = 0; i6 < size; i6++) {
                bArr2[i6] = ((Byte) arrayList2.get(i6)).byteValue();
            }
            arrayList.add(new t(vVar, size, bArr2));
        }
        return arrayList;
    }
}
