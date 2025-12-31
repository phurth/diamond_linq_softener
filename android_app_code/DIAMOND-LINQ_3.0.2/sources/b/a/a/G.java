package b.a.a;

import android.text.format.Time;
import java.util.Arrays;

public final class G {
    public static boolean a(byte[] bArr) {
        return a(bArr, 8);
    }

    public static byte[] b(J j, int i) {
        if (j == J.Reset || i < 0 || i > 399) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 67;
        int i2 = i / 256;
        a2[14] = (byte) i2;
        a2[15] = (byte) (i - (i2 * 256));
        return a2;
    }

    public static byte[] c(J j) {
        if (j == J.Reset) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 82;
        a2[14] = 84;
        return a2;
    }

    public static byte[] d(J j) {
        if (j == J.Reset) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 82;
        a2[14] = 78;
        return a2;
    }

    public static byte[] e(J j, byte b2) {
        if (j == J.Reset || b2 < 0 || b2 > 29) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 65;
        a2[14] = b2;
        return a2;
    }

    public static byte[] f(J j) {
        B b2 = B.AM;
        Time time = new Time();
        time.setToNow();
        byte b3 = (byte) time.hour;
        if (b3 == 0) {
            b3 = 12;
        } else if (b3 == 12) {
            b2 = B.PM;
        } else if (b3 > 12) {
            b2 = B.PM;
            b3 = (byte) (b3 - 12);
        }
        return a(j, b3, (byte) time.minute, (byte) time.second, b2);
    }

    public static byte[] g(J j, byte b2) {
        if (j == J.Reset || b2 < 0 || b2 > 49) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 66;
        a2[14] = b2;
        return a2;
    }

    public static byte[] h(J j, byte b2) {
        if (j == J.Reset || b2 < 0 || b2 > 99) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 72;
        a2[14] = b2;
        return a2;
    }

    public static boolean a(byte[] bArr, int i) {
        return bArr == null || bArr.length < i;
    }

    public static byte[] a(J j) {
        byte[] bArr = new byte[20];
        switch (F.f1047a[j.ordinal()]) {
            case 1:
                Arrays.fill(bArr, (byte) 114);
                break;
            case 2:
                Arrays.fill(bArr, (byte) 116);
                break;
            case 3:
                Arrays.fill(bArr, (byte) 117);
                break;
            case 4:
                Arrays.fill(bArr, (byte) 118);
                break;
            case 5:
                Arrays.fill(bArr, (byte) 119);
                break;
            case 6:
                Arrays.fill(bArr, (byte) 120);
                break;
        }
        return bArr;
    }

    public static byte[] c(J j, byte b2) {
        if (j == J.Reset || b2 < 0 || b2 > 29) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 70;
        a2[14] = b2;
        return a2;
    }

    public static byte[] d(J j, byte b2) {
        if (j == J.Reset || b2 < 0 || b2 > 4) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 70;
        a2[14] = b2;
        return a2;
    }

    public static byte[] e(J j) {
        if (j == J.Reset) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 66;
        return a2;
    }

    public static byte[] g(J j) {
        if (j == J.Reset) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 65;
        return a2;
    }

    public static byte[] b(J j, byte b2) {
        if (j == J.Reset || b2 < 0 || b2 > 9) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 69;
        a2[14] = b2;
        return a2;
    }

    public static byte[] f(J j, byte b2) {
        if (j == J.Reset || b2 < 0 || b2 > 1) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 68;
        a2[14] = b2;
        return a2;
    }

    public static byte[] b(J j) {
        if (j == J.Reset) {
            return null;
        }
        byte[] bArr = new byte[20];
        for (int i = 0; i < 20; i++) {
            bArr[i] = 116;
        }
        bArr[12] = 70;
        bArr[13] = 87;
        bArr[14] = 85;
        bArr[15] = 76;
        bArr[16] = -1;
        return bArr;
    }

    public static byte[] a() {
        return a(J.Reset);
    }

    public static byte[] a(J j, int i) {
        if (j != J.DeviceList || i < 0 || i > 9999) {
            return null;
        }
        byte[] a2 = a(j);
        int[] iArr = new int[4];
        iArr[3] = i / 1000;
        iArr[2] = (i - (iArr[3] * 1000)) / 100;
        iArr[1] = ((i - (iArr[3] * 1000)) - (iArr[2] * 100)) / 10;
        iArr[0] = ((i - (iArr[3] * 1000)) - (iArr[2] * 100)) - (iArr[1] * 10);
        a2[12] = 80;
        a2[13] = 87;
        a2[14] = (byte) iArr[3];
        a2[15] = (byte) iArr[2];
        a2[16] = (byte) iArr[1];
        a2[17] = (byte) iArr[0];
        return a2;
    }

    private static byte[] a(J j, byte b2, byte b3, byte b4, B b5) {
        if (j == J.Reset || b2 < 0 || b2 > 12 || b3 < 0 || b3 > 59 || b4 < 0 || b4 > 59) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 84;
        a2[14] = b2;
        a2[15] = b3;
        a2[16] = b5.a();
        a2[17] = b4;
        return a2;
    }

    public static byte[] a(J j, byte b2, B b3) {
        if (j == J.Reset || b2 < 0 || b2 > 12) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 116;
        a2[14] = b2;
        a2[15] = b3.a();
        return a2;
    }

    public static byte[] a(H h, String str, boolean z) {
        StringBuilder sb = new StringBuilder("xxxxxxxxxDI");
        switch (F.f1048b[h.ordinal()]) {
            case 1:
                sb.append("N");
                break;
            case 2:
                sb.append("P");
                break;
            case 3:
                sb.append("A");
                break;
            case 4:
                sb.append("B");
                break;
            case 5:
                sb.append("E");
                break;
            case 6:
                sb.append("W");
                break;
        }
        if (ia.a(str)) {
            sb.append(0);
        } else {
            String b2 = C.b(str.trim());
            sb.append((char) b2.length());
            sb.append(b2);
        }
        if (!z) {
            int length = sb.length();
            if (length % 20 != 0) {
                int i = 20 - (length - ((length / 20) * 20));
                for (int i2 = 0; i2 < i; i2++) {
                    sb.append("x");
                }
            }
        }
        return sb.toString().getBytes();
    }

    public static byte[] a(J j, byte b2, byte b3) {
        if (j == J.Reset || b2 < 0 || b2 > 1 || b3 < 1 || b3 > 4) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 82;
        a2[14] = 80;
        a2[15] = b2;
        a2[16] = b3;
        return a2;
    }

    public static byte[] a(J j, I i, byte b2) {
        if (j == J.Reset || b2 < 0 || b2 > 99) {
            return null;
        }
        byte[] a2 = a(j);
        a2[13] = 80;
        a2[14] = i.a();
        a2[15] = b2;
        return a2;
    }

    public static byte[] a(J j, byte b2) {
        if (j == J.Reset || b2 < 0) {
            return null;
        }
        byte[] a2 = a(j);
        a2[12] = 70;
        a2[13] = 87;
        a2[14] = 68;
        a2[15] = 76;
        a2[16] = b2;
        return a2;
    }

    public static byte[] a(J j, byte b2, byte[] bArr, byte b3) {
        if (j == J.Reset || b2 < 0 || bArr.length != 256) {
            return null;
        }
        byte[] bArr2 = new byte[280];
        for (int i = 0; i < 12; i++) {
            bArr2[i] = 116;
        }
        bArr2[12] = 70;
        bArr2[13] = 87;
        bArr2[14] = 85;
        bArr2[15] = 76;
        bArr2[16] = b2;
        System.arraycopy(bArr, 0, bArr2, 17, bArr.length);
        bArr2[273] = b3;
        return bArr2;
    }
}
