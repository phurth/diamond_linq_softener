package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import java.util.Arrays;
import no.nordicsemi.android.ble.N;
import no.nordicsemi.android.ble.a.d;
import no.nordicsemi.android.ble.a.k;
import no.nordicsemi.android.ble.a.l;
import no.nordicsemi.android.ble.b.b;
import no.nordicsemi.android.ble.b.e;
import no.nordicsemi.android.ble.b.g;

public final class Y extends Q<d> implements J {
    private static final e p = new g();
    private l q;
    private e r;
    private final byte[] s;
    private final int t;
    private byte[] u;
    private byte[] v;
    private int w;
    private boolean x;

    Y(N.a aVar) {
        this(aVar, (BluetoothGattCharacteristic) null);
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return !this.x;
    }

    Y(N.a aVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(aVar, bluetoothGattCharacteristic);
        this.w = 0;
        this.x = false;
        this.s = null;
        this.t = 0;
        this.x = true;
    }

    /* access modifiers changed from: package-private */
    public Y a(C c) {
        super.a(c);
        return this;
    }

    public Y a(k kVar) {
        super.a(kVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public byte[] a(int i) {
        if (this.r == null || this.s == null) {
            this.x = true;
            byte[] bArr = this.s;
            this.u = bArr;
            return bArr;
        }
        int i2 = this.t != 4 ? i - 3 : i - 12;
        byte[] bArr2 = this.v;
        if (bArr2 == null) {
            bArr2 = this.r.a(this.s, this.w, i2);
        }
        if (bArr2 != null) {
            this.v = this.r.a(this.s, this.w + 1, i2);
        }
        if (this.v == null) {
            this.x = true;
        }
        this.u = bArr2;
        return bArr2;
    }

    Y(N.a aVar, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i, int i2, int i3) {
        super(aVar, bluetoothGattCharacteristic);
        this.w = 0;
        this.x = false;
        this.s = a(bArr, i, i2);
        this.t = i3;
    }

    /* access modifiers changed from: package-private */
    public boolean a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        T t2;
        l lVar = this.q;
        if (lVar != null) {
            lVar.a(bluetoothDevice, bArr, this.w);
        }
        this.w++;
        if (this.x && (t2 = this.o) != null) {
            ((d) t2).a(bluetoothDevice, new b(this.s));
        }
        return Arrays.equals(bArr, this.u);
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        if (bArr == null || i > bArr.length) {
            return null;
        }
        int min = Math.min(bArr.length - i, i2);
        byte[] bArr2 = new byte[min];
        System.arraycopy(bArr, i, bArr2, 0, min);
        return bArr2;
    }
}
