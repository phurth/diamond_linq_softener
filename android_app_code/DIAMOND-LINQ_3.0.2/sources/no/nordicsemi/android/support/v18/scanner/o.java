package no.nordicsemi.android.support.v18.scanner;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.support.v18.scanner.d;

@TargetApi(21)
class o extends d {

    /* renamed from: b  reason: collision with root package name */
    private final Map<v, a> f1660b = new HashMap();

    static class a extends d.a {
        /* access modifiers changed from: private */
        public final ScanCallback o;

        private a(boolean z, boolean z2, List<x> list, C c, v vVar, Handler handler) {
            super(z, z2, list, c, vVar, handler);
            this.o = new n(this);
        }
    }

    o() {
    }

    /* access modifiers changed from: package-private */
    public void a(List<x> list, C c, v vVar, Handler handler) {
        a aVar;
        v vVar2 = vVar;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        r.a(defaultAdapter);
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner != null) {
            boolean isOffloadedScanBatchingSupported = defaultAdapter.isOffloadedScanBatchingSupported();
            boolean isOffloadedFilteringSupported = defaultAdapter.isOffloadedFilteringSupported();
            synchronized (this.f1660b) {
                if (!this.f1660b.containsKey(vVar2)) {
                    aVar = new a(isOffloadedScanBatchingSupported, isOffloadedFilteringSupported, list, c, vVar, handler);
                    this.f1660b.put(vVar2, aVar);
                } else {
                    throw new IllegalArgumentException("scanner already started with given callback");
                }
            }
            ScanSettings a2 = a(defaultAdapter, c, false);
            ArrayList<ScanFilter> arrayList = null;
            if (!list.isEmpty() && isOffloadedFilteringSupported && c.o()) {
                arrayList = b(list);
            }
            bluetoothLeScanner.startScan(arrayList, a2, aVar.o);
            return;
        }
        throw new IllegalStateException("BT le scanner not available");
    }

    /* access modifiers changed from: package-private */
    public void b(v vVar) {
        a remove;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        r.a(defaultAdapter);
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner != null) {
            synchronized (this.f1660b) {
                remove = this.f1660b.remove(vVar);
            }
            if (remove != null) {
                remove.a();
                bluetoothLeScanner.stopScan(remove.o);
                return;
            }
            return;
        }
        throw new IllegalStateException("BT le scanner not available");
    }

    /* access modifiers changed from: package-private */
    public ArrayList<ScanFilter> b(List<x> list) {
        ArrayList<ScanFilter> arrayList = new ArrayList<>();
        for (x a2 : list) {
            arrayList.add(a(a2));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ScanSettings a(BluetoothAdapter bluetoothAdapter, C c, boolean z) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (z || (bluetoothAdapter.isOffloadedScanBatchingSupported() && c.m())) {
            builder.setReportDelay(c.k());
        }
        if (c.l() != -1) {
            builder.setScanMode(c.l());
        } else {
            builder.setScanMode(0);
        }
        c.a();
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public ScanFilter a(x xVar) {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        builder.setDeviceAddress(xVar.a()).setDeviceName(xVar.b()).setServiceUuid(xVar.i(), xVar.j()).setManufacturerData(xVar.e(), xVar.c(), xVar.d());
        if (xVar.h() != null) {
            builder.setServiceData(xVar.h(), xVar.f(), xVar.g());
        }
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public A a(ScanResult scanResult) {
        return new A(scanResult.getDevice(), y.a(scanResult.getScanRecord() != null ? scanResult.getScanRecord().getBytes() : null), scanResult.getRssi(), scanResult.getTimestampNanos());
    }

    /* access modifiers changed from: package-private */
    public ArrayList<A> a(List<ScanResult> list) {
        ArrayList<A> arrayList = new ArrayList<>();
        for (ScanResult a2 : list) {
            arrayList.add(a(a2));
        }
        return arrayList;
    }
}
