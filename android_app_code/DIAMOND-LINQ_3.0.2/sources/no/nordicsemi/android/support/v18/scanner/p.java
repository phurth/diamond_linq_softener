package no.nordicsemi.android.support.v18.scanner;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanSettings;

@TargetApi(23)
class p extends o {
    p() {
    }

    /* access modifiers changed from: package-private */
    public ScanSettings a(BluetoothAdapter bluetoothAdapter, C c, boolean z) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (z || (bluetoothAdapter.isOffloadedScanBatchingSupported() && c.m())) {
            builder.setReportDelay(c.k());
        }
        if (z || c.n()) {
            builder.setCallbackType(c.b()).setMatchMode(c.f()).setNumOfMatches(c.g());
        }
        builder.setScanMode(c.l());
        return builder.build();
    }
}
