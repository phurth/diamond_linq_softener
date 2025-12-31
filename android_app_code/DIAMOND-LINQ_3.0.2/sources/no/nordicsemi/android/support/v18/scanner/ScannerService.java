package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import no.nordicsemi.android.support.v18.scanner.C;

public class ScannerService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1637a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<PendingIntent, v> f1638b;
    private Handler c;

    private void a(List<x> list, C c2, PendingIntent pendingIntent) {
        u uVar = new u(pendingIntent, c2, this);
        synchronized (this.f1637a) {
            this.f1638b.put(pendingIntent, uVar);
        }
        try {
            d.a().a(list, c2, uVar, this.c);
        } catch (Exception e) {
            Log.e("ScannerService", "Starting scanning failed", e);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f1638b = new HashMap<>();
        this.c = new Handler();
    }

    public void onDestroy() {
        d a2 = d.a();
        for (v a3 : this.f1638b.values()) {
            try {
                a2.a(a3);
            } catch (Exception unused) {
            }
        }
        this.f1638b.clear();
        this.f1638b = null;
        this.c = null;
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        boolean containsKey;
        boolean isEmpty;
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_PENDING_INTENT");
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.support.v18.EXTRA_START", false);
        boolean z = !booleanExtra;
        if (pendingIntent == null) {
            synchronized (this.f1637a) {
                isEmpty = this.f1638b.isEmpty();
            }
            if (isEmpty) {
                stopSelf();
            }
            return 2;
        }
        synchronized (this.f1637a) {
            containsKey = this.f1638b.containsKey(pendingIntent);
        }
        if (booleanExtra && !containsKey) {
            List parcelableArrayListExtra = intent.getParcelableArrayListExtra("no.nordicsemi.android.support.v18.EXTRA_FILTERS");
            C c2 = (C) intent.getParcelableExtra("no.nordicsemi.android.support.v18.EXTRA_SETTINGS");
            if (parcelableArrayListExtra == null) {
                parcelableArrayListExtra = Collections.emptyList();
            }
            if (c2 == null) {
                c2 = new C.a().a();
            }
            a(parcelableArrayListExtra, c2, pendingIntent);
        } else if (z && containsKey) {
            a(pendingIntent);
        }
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    private void a(PendingIntent pendingIntent) {
        v remove;
        boolean isEmpty;
        synchronized (this.f1637a) {
            remove = this.f1638b.remove(pendingIntent);
            isEmpty = this.f1638b.isEmpty();
        }
        if (remove != null) {
            try {
                d.a().a(remove);
            } catch (Exception e) {
                Log.e("ScannerService", "Stopping scanning failed", e);
            }
            if (isEmpty) {
                stopSelf();
            }
        }
    }
}
