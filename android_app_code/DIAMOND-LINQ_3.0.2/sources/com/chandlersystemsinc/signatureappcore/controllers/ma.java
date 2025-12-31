package com.chandlersystemsinc.signatureappcore.controllers;

import android.bluetooth.BluetoothDevice;
import b.a.a.Fa;
import no.nordicsemi.android.ble.D;
import no.nordicsemi.android.ble.E;

class ma implements E {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CsMainCoreActivity f1396a;

    ma(CsMainCoreActivity csMainCoreActivity) {
        this.f1396a = csMainCoreActivity;
    }

    public void a(BluetoothDevice bluetoothDevice) {
        this.f1396a.Y();
    }

    @Deprecated
    public /* synthetic */ void a(BluetoothDevice bluetoothDevice, int i) {
        D.a(this, bluetoothDevice, i);
    }

    public void a(BluetoothDevice bluetoothDevice, String str, int i) {
    }

    public void a(BluetoothDevice bluetoothDevice, boolean z) {
    }

    public void b(BluetoothDevice bluetoothDevice) {
        if (this.f1396a.Q && CsMainCoreActivity.t != null && !CsMainCoreActivity.t.h() && this.f1396a.E.getText().equals(this.f1396a.getString(Fa.bt_status_connecting))) {
            this.f1396a.M();
        }
    }

    public void c(BluetoothDevice bluetoothDevice) {
    }

    public void d(BluetoothDevice bluetoothDevice) {
    }

    public void e(BluetoothDevice bluetoothDevice) {
    }

    public void f(BluetoothDevice bluetoothDevice) {
    }

    public void g(BluetoothDevice bluetoothDevice) {
    }

    public void h(BluetoothDevice bluetoothDevice) {
    }

    public void i(BluetoothDevice bluetoothDevice) {
    }

    public void j(BluetoothDevice bluetoothDevice) {
    }

    @Deprecated
    public /* synthetic */ boolean k(BluetoothDevice bluetoothDevice) {
        return D.a(this, bluetoothDevice);
    }
}
