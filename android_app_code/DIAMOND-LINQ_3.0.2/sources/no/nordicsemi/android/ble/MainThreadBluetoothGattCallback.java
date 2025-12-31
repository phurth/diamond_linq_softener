package no.nordicsemi.android.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;

abstract class MainThreadBluetoothGattCallback extends BluetoothGattCallback {

    /* renamed from: a  reason: collision with root package name */
    private Handler f1575a;

    MainThreadBluetoothGattCallback() {
    }

    /* access modifiers changed from: package-private */
    public void a(Handler handler) {
        this.f1575a = handler;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void a(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void a(BluetoothGatt bluetoothGatt, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void a(BluetoothGatt bluetoothGatt, int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract void a(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void b(BluetoothGatt bluetoothGatt, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void a(BluetoothGatt bluetoothGatt, int i, int i2);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void b(BluetoothGatt bluetoothGatt, int i, int i2, int i3);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract void b(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, int i);

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract void b(BluetoothGatt bluetoothGatt, int i, int i2);

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract void c(BluetoothGatt bluetoothGatt, int i, int i2);

    public final void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        a((Runnable) new C0239m(this, bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue()));
    }

    public final void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        a((Runnable) new C0241o(this, bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), i));
    }

    public final void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        a((Runnable) new C0243q(this, bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), i));
    }

    public final void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        a((Runnable) new C0246u(this, bluetoothGatt, i, i2));
    }

    @Keep
    public final void onConnectionUpdated(BluetoothGatt bluetoothGatt, int i, int i2, int i3, int i4) {
        a((Runnable) new r(this, bluetoothGatt, i, i2, i3, i4));
    }

    public final void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        a((Runnable) new C0248w(this, bluetoothGatt, bluetoothGattDescriptor, bluetoothGattDescriptor.getValue(), i));
    }

    public final void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        a((Runnable) new C0247v(this, bluetoothGatt, bluetoothGattDescriptor, bluetoothGattDescriptor.getValue(), i));
    }

    public final void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        a((Runnable) new C0237k(this, bluetoothGatt, i, i2));
    }

    public final void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        a((Runnable) new C0238l(this, bluetoothGatt, i, i2, i3));
    }

    public final void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
        a((Runnable) new C0242p(this, bluetoothGatt, i, i2, i3));
    }

    public final void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        a((Runnable) new C0245t(this, bluetoothGatt, i, i2));
    }

    public final void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
        a((Runnable) new C0240n(this, bluetoothGatt, i));
    }

    public final void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        a((Runnable) new C0244s(this, bluetoothGatt, i));
    }

    private void a(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f1575a.post(runnable);
        } else {
            runnable.run();
        }
    }
}
