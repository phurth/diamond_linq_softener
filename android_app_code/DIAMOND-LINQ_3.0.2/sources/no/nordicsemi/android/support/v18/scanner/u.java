package no.nordicsemi.android.support.v18.scanner;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class u extends v {

    /* renamed from: a  reason: collision with root package name */
    private final PendingIntent f1662a;

    /* renamed from: b  reason: collision with root package name */
    private Context f1663b;
    private Context c;
    private long d;
    private long e;

    u(PendingIntent pendingIntent, C c2) {
        this.f1662a = pendingIntent;
        this.e = c2.k();
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        this.f1663b = context;
    }

    public void a(int i, A a2) {
        Context context = this.f1663b;
        if (context == null) {
            context = this.c;
        }
        if (context != null) {
            try {
                Intent intent = new Intent();
                intent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", i);
                intent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", new ArrayList(Collections.singletonList(a2)));
                this.f1662a.send(context, 0, intent);
            } catch (PendingIntent.CanceledException unused) {
            }
        }
    }

    u(PendingIntent pendingIntent, C c2, Service service) {
        this.f1662a = pendingIntent;
        this.e = c2.k();
        this.c = service;
    }

    public void a(List<A> list) {
        Context context = this.f1663b;
        if (context == null) {
            context = this.c;
        }
        if (context != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.d <= (elapsedRealtime - this.e) + 5) {
                this.d = elapsedRealtime;
                try {
                    Intent intent = new Intent();
                    intent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", 1);
                    intent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", new ArrayList(list));
                    intent.setExtrasClassLoader(A.class.getClassLoader());
                    this.f1662a.send(context, 0, intent);
                } catch (PendingIntent.CanceledException unused) {
                }
            }
        }
    }

    public void a(int i) {
        Context context = this.f1663b;
        if (context == null) {
            context = this.c;
        }
        if (context != null) {
            try {
                Intent intent = new Intent();
                intent.putExtra("android.bluetooth.le.extra.ERROR_CODE", i);
                this.f1662a.send(context, 0, intent);
            } catch (PendingIntent.CanceledException unused) {
            }
        }
    }
}
