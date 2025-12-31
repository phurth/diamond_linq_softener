package no.nordicsemi.android.ble.b;

public final class g implements e {
    public byte[] a(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int min = Math.min(i2, bArr.length - i3);
        if (min <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[min];
        System.arraycopy(bArr, i3, bArr2, 0, min);
        return bArr2;
    }
}
