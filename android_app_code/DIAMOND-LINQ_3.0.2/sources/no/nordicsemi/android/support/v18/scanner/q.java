package no.nordicsemi.android.support.v18.scanner;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.C;
import no.nordicsemi.android.support.v18.scanner.d;
import no.nordicsemi.android.support.v18.scanner.x;

@TargetApi(26)
class q extends p {
    private final HashMap<PendingIntent, a> c = new HashMap<>();

    static class a extends d.a {
        final u o = ((u) this.h);

        a(boolean z, boolean z2, List<x> list, C c, PendingIntent pendingIntent) {
            super(z, z2, list, c, new u(pendingIntent, c), new Handler());
        }
    }

    q() {
    }

    /* access modifiers changed from: package-private */
    public a a(PendingIntent pendingIntent) {
        synchronized (this.c) {
            if (!this.c.containsKey(pendingIntent)) {
                return null;
            }
            a aVar = this.c.get(pendingIntent);
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalStateException("Scanning has been stopped");
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<x> c(List<ScanFilter> list) {
        ArrayList<x> arrayList = new ArrayList<>();
        for (ScanFilter a2 : list) {
            arrayList.add(a(a2));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void a(PendingIntent pendingIntent, a aVar) {
        synchronized (this.c) {
            this.c.put(pendingIntent, aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public ScanSettings a(BluetoothAdapter bluetoothAdapter, C c2, boolean z) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (z || (bluetoothAdapter.isOffloadedScanBatchingSupported() && c2.m())) {
            builder.setReportDelay(c2.k());
        }
        if (z || c2.n()) {
            builder.setCallbackType(c2.b()).setMatchMode(c2.f()).setNumOfMatches(c2.g());
        }
        builder.setScanMode(c2.l()).setLegacy(c2.c()).setPhy(c2.h());
        return builder.build();
    }

    /* access modifiers changed from: package-private */
    public C a(ScanSettings scanSettings, boolean z, boolean z2, boolean z3, long j, long j2, int i, int i2) {
        C.a aVar = new C.a();
        aVar.a(scanSettings.getLegacy());
        aVar.d(scanSettings.getPhy());
        aVar.a(scanSettings.getCallbackType());
        aVar.e(scanSettings.getScanMode());
        aVar.a(scanSettings.getReportDelayMillis());
        aVar.b(z);
        aVar.d(z2);
        aVar.c(z3);
        aVar.a(j, j2);
        aVar.b(i);
        aVar.c(i2);
        return aVar.a();
    }

    /* access modifiers changed from: package-private */
    public x a(ScanFilter scanFilter) {
        x.a aVar = new x.a();
        aVar.a(scanFilter.getDeviceAddress());
        aVar.b(scanFilter.getDeviceName());
        aVar.a(scanFilter.getServiceUuid(), scanFilter.getServiceUuidMask());
        aVar.a(scanFilter.getManufacturerId(), scanFilter.getManufacturerData(), scanFilter.getManufacturerDataMask());
        if (scanFilter.getServiceDataUuid() != null) {
            aVar.a(scanFilter.getServiceDataUuid(), scanFilter.getServiceData(), scanFilter.getServiceDataMask());
        }
        return aVar.a();
    }

    /* access modifiers changed from: package-private */
    public A a(ScanResult scanResult) {
        return new A(scanResult.getDevice(), ((scanResult.getDataStatus() << 5) | (scanResult.isLegacy() ? 16 : 0)) | scanResult.isConnectable() ? 1 : 0, scanResult.getPrimaryPhy(), scanResult.getSecondaryPhy(), scanResult.getAdvertisingSid(), scanResult.getTxPower(), scanResult.getRssi(), scanResult.getPeriodicAdvertisingInterval(), y.a(scanResult.getScanRecord() != null ? scanResult.getScanRecord().getBytes() : null), scanResult.getTimestampNanos());
    }
}
