package no.nordicsemi.android.ble.d;

import no.nordicsemi.android.log.BuildConfig;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final char[] f1592a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return BuildConfig.FLAVOR;
        }
        char[] cArr = new char[((bArr.length * 3) - 1)];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i] & 255;
            int i2 = i * 3;
            char[] cArr2 = f1592a;
            cArr[i2] = cArr2[b2 >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
            if (i != bArr.length - 1) {
                cArr[i2 + 2] = '-';
            }
        }
        return "(0x) " + new String(cArr);
    }
}
