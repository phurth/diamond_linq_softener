package b.a.a.c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import b.a.a.C0168ba;
import b.a.a.d.a;
import b.a.a.ia;
import java.util.UUID;
import no.nordicsemi.android.ble.C;
import no.nordicsemi.android.ble.E;
import no.nordicsemi.android.ble.a.c;

public final class n extends C<E> {
    /* access modifiers changed from: private */
    public static final UUID H = UUID.fromString("6e400001-b5a3-f393-e0a9-e50e24dcca9e");
    /* access modifiers changed from: private */
    public static final UUID I = UUID.fromString("6e400003-b5a3-f393-e0a9-e50e24dcca9e");
    /* access modifiers changed from: private */
    public static final UUID J = UUID.fromString("6e400002-b5a3-f393-e0a9-e50e24dcca9e");
    /* access modifiers changed from: private */
    public static final UUID K = UUID.fromString("00001000-0000-1000-8000-00805f9b34fb");
    /* access modifiers changed from: private */
    public static final UUID L = UUID.fromString("00001002-0000-1000-8000-00805f9b34fb");
    /* access modifiers changed from: private */
    public static final UUID M = UUID.fromString("00001001-0000-1000-8000-00805f9b34fb");
    /* access modifiers changed from: private */
    public BluetoothGattCharacteristic N;
    /* access modifiers changed from: private */
    public BluetoothGattCharacteristic O;
    /* access modifiers changed from: private */
    public final a P;
    /* access modifiers changed from: private */
    public boolean Q = false;
    /* access modifiers changed from: private */
    public final c R = new l(this);
    private final C<E>.a S = new m(this);

    public n(Context context, a aVar) {
        super(context);
        this.P = aVar;
        a(1).b();
    }

    /* access modifiers changed from: protected */
    public C<E>.a g() {
        return this.S;
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return !this.Q;
    }

    public void b(long j) {
        a(j).b();
    }

    public void a(int i, String str) {
        C0168ba.a(str);
    }

    public void a(byte[] bArr) {
        if (this.O != null) {
            C0168ba.b(ia.a("<<<- Write", bArr, bArr.length));
            a(this.O, bArr).b();
        }
    }
}
