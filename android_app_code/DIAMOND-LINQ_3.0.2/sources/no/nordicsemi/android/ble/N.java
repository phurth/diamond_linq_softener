package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.ConditionVariable;
import no.nordicsemi.android.ble.a.e;
import no.nordicsemi.android.ble.a.f;
import no.nordicsemi.android.ble.a.k;

public abstract class N {

    /* renamed from: a  reason: collision with root package name */
    private C f1576a;

    /* renamed from: b  reason: collision with root package name */
    final ConditionVariable f1577b;
    final a c;
    final BluetoothGattCharacteristic d;
    final BluetoothGattDescriptor e;
    no.nordicsemi.android.ble.a.a f;
    k g;
    e h;
    f i;
    no.nordicsemi.android.ble.a.a j;
    k k;
    e l;
    boolean m;
    boolean n;

    enum a {
        SET,
        CONNECT,
        DISCONNECT,
        CREATE_BOND,
        REMOVE_BOND,
        WRITE,
        READ,
        WRITE_DESCRIPTOR,
        READ_DESCRIPTOR,
        BEGIN_RELIABLE_WRITE,
        EXECUTE_RELIABLE_WRITE,
        ABORT_RELIABLE_WRITE,
        ENABLE_NOTIFICATIONS,
        ENABLE_INDICATIONS,
        DISABLE_NOTIFICATIONS,
        DISABLE_INDICATIONS,
        WAIT_FOR_NOTIFICATION,
        WAIT_FOR_INDICATION,
        READ_BATTERY_LEVEL,
        ENABLE_BATTERY_LEVEL_NOTIFICATIONS,
        DISABLE_BATTERY_LEVEL_NOTIFICATIONS,
        ENABLE_SERVICE_CHANGED_INDICATIONS,
        REQUEST_MTU,
        REQUEST_CONNECTION_PRIORITY,
        SET_PREFERRED_PHY,
        READ_PHY,
        READ_RSSI,
        REFRESH_CACHE,
        SLEEP
    }

    N(a aVar) {
        this.c = aVar;
        this.d = null;
        this.e = null;
        this.f1577b = new ConditionVariable(true);
    }

    @Deprecated
    public static L b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new L(a.READ, bluetoothGattCharacteristic);
    }

    @Deprecated
    public static Y c() {
        return new Y(a.ENABLE_BATTERY_LEVEL_NOTIFICATIONS);
    }

    static Y d() {
        return new Y(a.ENABLE_SERVICE_CHANGED_INDICATIONS);
    }

    @Deprecated
    public static L e() {
        return new L(a.READ_BATTERY_LEVEL);
    }

    /* access modifiers changed from: package-private */
    public N a(C c2) {
        this.f1576a = c2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (!this.n) {
            this.n = true;
            f fVar = this.i;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    static F a(BluetoothDevice bluetoothDevice) {
        return new F(a.CONNECT, bluetoothDevice);
    }

    public void b() {
        this.f1576a.a(this);
    }

    /* access modifiers changed from: package-private */
    public void c(BluetoothDevice bluetoothDevice) {
        if (!this.n) {
            this.n = true;
            k kVar = this.g;
            if (kVar != null) {
                kVar.a(bluetoothDevice);
            }
            k kVar2 = this.k;
            if (kVar2 != null) {
                kVar2.a(bluetoothDevice);
            }
        }
    }

    static H a() {
        return new H(a.DISCONNECT);
    }

    /* access modifiers changed from: package-private */
    public void b(BluetoothDevice bluetoothDevice) {
        no.nordicsemi.android.ble.a.a aVar = this.f;
        if (aVar != null) {
            aVar.a(bluetoothDevice);
        }
        no.nordicsemi.android.ble.a.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.a(bluetoothDevice);
        }
    }

    @Deprecated
    public static Y a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return new Y(a.WRITE, bluetoothGattCharacteristic, bArr, 0, bArr != null ? bArr.length : 0, bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getWriteType() : 2);
    }

    N(a aVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.c = aVar;
        this.d = bluetoothGattCharacteristic;
        this.e = null;
        this.f1577b = new ConditionVariable(true);
    }

    @Deprecated
    public static Y a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new Y(a.ENABLE_NOTIFICATIONS, bluetoothGattCharacteristic);
    }

    @Deprecated
    public static S a(long j2) {
        return new S(a.SLEEP, j2);
    }

    public N a(k kVar) {
        this.g = kVar;
        return this;
    }

    public N a(e eVar) {
        this.h = eVar;
        return this;
    }

    public N a(f fVar) {
        this.i = fVar;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(BluetoothDevice bluetoothDevice, int i2) {
        if (!this.n) {
            this.n = true;
            e eVar = this.h;
            if (eVar != null) {
                eVar.a(bluetoothDevice, i2);
            }
            e eVar2 = this.l;
            if (eVar2 != null) {
                eVar2.a(bluetoothDevice, i2);
            }
        }
    }
}
