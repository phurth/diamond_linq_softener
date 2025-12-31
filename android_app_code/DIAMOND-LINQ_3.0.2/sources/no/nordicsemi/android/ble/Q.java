package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGattCharacteristic;
import no.nordicsemi.android.ble.N;

public abstract class Q<T> extends P {
    T o;

    Q(N.a aVar) {
        super(aVar);
    }

    public Q<T> a(T t) {
        this.o = t;
        return this;
    }

    Q(N.a aVar, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(aVar, bluetoothGattCharacteristic);
    }
}
