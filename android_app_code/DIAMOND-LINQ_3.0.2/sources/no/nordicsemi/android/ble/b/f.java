package no.nordicsemi.android.ble.b;

import java.io.ByteArrayOutputStream;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f1587a = new ByteArrayOutputStream();

    public boolean a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        return a(bArr, 0, bArr.length);
    }

    public b b() {
        return new b(this.f1587a.toByteArray());
    }

    public boolean a(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length < i) {
            return false;
        }
        this.f1587a.write(bArr, i, Math.min(bArr.length - i, i2));
        return true;
    }

    public byte[] a() {
        return this.f1587a.toByteArray();
    }
}
